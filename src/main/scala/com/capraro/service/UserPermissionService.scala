package com.capraro.service

import cats.Id
import cats.data.{Kleisli, Reader}
import com.capraro.RepositoryConfiguration
import com.capraro.model.{Permission, User}

object UserPermissionService {
  def createUser(user: User): Reader[RepositoryConfiguration, Long] = {
    Reader(
      (configuration: RepositoryConfiguration) => {
        configuration.userRepository.create(user)
      }
    )
  }

  def getUser(id: Long): Reader[RepositoryConfiguration, User] = {
    Reader(
      (configuration: RepositoryConfiguration) => {
        configuration.userRepository.get(id)
      }
    )
  }

  def createPermission(permission: Permission): Reader[RepositoryConfiguration, Long] = {
    Reader(
      (configuration: RepositoryConfiguration) => {
        configuration.permissionRepository.create(permission)
      }
    )
  }

  def getPermission(id: Long): Reader[RepositoryConfiguration, Permission] = {
    Reader(
      (configuration: RepositoryConfiguration) => {
        configuration.permissionRepository.get(id)
      }
    )
  }

  def searchPermissions(role: String): Reader[RepositoryConfiguration, List[Permission]] = {
    Reader(
      (configuration: RepositoryConfiguration) => {
        configuration.permissionRepository.search(role)
      }
    )
  }

  def getUserPermissions(id: Long): Kleisli[Id, RepositoryConfiguration, List[Permission]] = {
    for {
      u <- this.getUser(id)
      p <- this.searchPermissions(u.role)
    } yield p
  }
}

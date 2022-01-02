package com.capraro.repository

import com.capraro.model.Permission

trait PermissionRepository {
  def create(permission: Permission): Long

  def get(id: Long): Permission

  def search(role: String): List[Permission]

}

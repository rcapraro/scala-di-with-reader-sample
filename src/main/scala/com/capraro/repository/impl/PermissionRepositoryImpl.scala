package com.capraro.repository.impl

import com.capraro.model.Permission
import com.capraro.repository.PermissionRepository

import scala.util.Random

class PermissionRepositoryImpl extends PermissionRepository {
  override def create(permission: Permission): Long = {
    println(s"permission created $permission")
    permission.id
  }

  override def get(id: Long): Permission = {
    println(s"get permission $id")
    val roles = List("admin", "manager", "legal_officer", "user")
    val perms = List("use_archive", "use_doc_storage", "use_schema", "use_auth")
    Permission(id, Random.shuffle(roles).head, Random.shuffle(perms).head)
  }

  override def search(role: String): List[Permission] = {
    List(
      Permission(1001, role, "user_archive"),
      Permission(1002, role, "use_doc_storage"),
      Permission(1005, role, "use_auth")
    )
  }
}

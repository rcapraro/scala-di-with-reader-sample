package com.capraro

import com.capraro.model.{Permission, User}
import com.capraro.repository.impl.{PermissionRepositoryImpl, UserRepositoryImpl}
import com.capraro.service.UserPermissionService

object UserPermissionApp extends App {

  val userRepo = new UserRepositoryImpl
  val permRepo = new PermissionRepositoryImpl
  val config = RepositoryConfiguration(userRepo, permRepo)

  val createUserResp = UserPermissionService.createUser(User(1001, "lambda", "admin")).run(config)
  println(createUserResp)

  val createPermResp = UserPermissionService.createPermission(Permission(2001, "admin", "use_auth")).run(config)
  println(createPermResp)

  val getPermResp = UserPermissionService.getPermission(1001).run(config)
  println(getPermResp)

  val permissions = UserPermissionService.getUserPermissions(1001).run(config)
  println(permissions)
}

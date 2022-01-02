package com.capraro

import com.capraro.repository.{PermissionRepository, UserRepository}

case class RepositoryConfiguration(userRepository: UserRepository, permissionRepository: PermissionRepository)

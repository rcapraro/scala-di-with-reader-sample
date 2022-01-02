package com.capraro.repository.impl

import com.capraro.model.User
import com.capraro.repository.UserRepository

import scala.util.Random

class UserRepositoryImpl extends UserRepository {
  override def create(user: User): Long = {
    println(s"user created $user")
    user.id
  }

  override def get(id: Long): User = {
    println(s"get user $id")
    val roles = List("admin", "manager", "legal_officer", "user")
    User(id, s"lambda$id", Random.shuffle(roles).head)
  }
}
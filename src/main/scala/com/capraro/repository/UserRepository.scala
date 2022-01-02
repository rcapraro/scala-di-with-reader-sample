package com.capraro.repository

import com.capraro.model.User

trait UserRepository {

  def create(user: User): Long

  def get(id: Long): User

}

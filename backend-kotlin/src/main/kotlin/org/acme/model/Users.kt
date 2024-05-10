package org.acme.model

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity


@Entity
class Users : PanacheEntity {

    companion object : PanacheCompanion<Users>

    @Column(unique = true, length = 50)
    lateinit var name: String

    @Column(length = 50)
    lateinit var username: String

    @Column(length = 255)
    lateinit var userpassword: String

    constructor()

    constructor(name: String, username: String, userpassword: String) {
        this.name = name
        this.username = username
        this.userpassword = userpassword
    }
}
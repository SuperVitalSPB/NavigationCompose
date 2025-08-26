package com.supervital.data.mappers

import com.supervital.data.database.entries.UserEntry
import com.supervital.domain.model.UserInfo

fun UserEntry.map() = UserInfo(
    id = this.id,
    name = this.name,
    age = this.age
)

fun UserInfo.map() = UserEntry(
        id = this.id ?: 0,
        name = this.name,
        age = this.age
)

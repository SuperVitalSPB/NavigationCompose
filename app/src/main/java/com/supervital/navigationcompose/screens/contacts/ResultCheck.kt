package com.supervital.navigationcompose.contacts

sealed class ResultCheck () {
    class ResultOk() : ResultCheck()
    class NameExists() : ResultCheck()
    class NameMustEnter() : ResultCheck()
    class BadAge() : ResultCheck()
}
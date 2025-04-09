package com.example.full_stack_ktor.helper

import io.kvision.require

@Suppress("UnsafeCastFromDynamic")
val marked: (String, dynamic) -> String = require("marked")

package com.example.full_stack_ktor.repository

import com.example.full_stack_ktor.repository.auth.authRepositoryModule
import org.koin.dsl.module

val repositoryModule = module {
    includes(authRepositoryModule)
}
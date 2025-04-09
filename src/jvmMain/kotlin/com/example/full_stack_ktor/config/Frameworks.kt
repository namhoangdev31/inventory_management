package com.example.full_stack_ktor.config


import com.example.full_stack_ktor.IArticleService
import com.example.full_stack_ktor.IAuthService
import com.example.full_stack_ktor.controllers.AuthController
import com.example.full_stack_ktor.controllers.UserController
import com.example.full_stack_ktor.dao.*
import com.example.full_stack_ktor.repositories.AuthRepository
import com.example.full_stack_ktor.repositories.AuthRepositoryImpl
import com.example.full_stack_ktor.repositories.UserRepository
import com.example.full_stack_ktor.repositories.UserRepositoryImpl
import com.example.full_stack_ktor.services.ArticleService
import com.example.full_stack_ktor.services.AuthService
import com.example.full_stack_ktor.services.UserService
import io.ktor.server.application.*
import io.kvision.remote.kvisionInit
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.SLF4JLogger
import org.koin.logger.slf4jLogger
import org.slf4j.event.Level

fun Application.configureFrameworks() {
//    install(Koin) {
//        slf4jLogger()
//        modules(
//            configModule(environment),
//            appDaoModule(),
//            authModule(),
//            userModule()
//        )
//    }

    kvisionInit(
        modules = listOf(
            configModule(environment),
            appDaoModule(),
            authModule(),
            userModule(),
            articleModule()
        ).toTypedArray(),
    )
}

fun authModule() = module {
    single<IAuthService> { AuthService() }
    single<AuthController> { AuthController() }
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
}

fun articleModule() = module {
    single<IArticleService> { ArticleService() }
}

fun userModule() = module {
    single<UserService> { UserService() }
    single<UserController> { UserController() }
    single<UserRepository> { UserRepositoryImpl(get(), get()) }
}

fun appDaoModule() = module {
    single<UserDao> { UserDaoImpl() }
    single<RegionDao> { RegionDaoImpl() }
    single<LocationDao> { LocationDaoImpl() }
    single<WarehouseDao> { WarehouseDaoImpl() }
    single<CustomerDao> { CustomerDaoImpl() }
    single<CategoryDao> { CategoryDaoImpl() }
    single<DeliveryOrderDao> { DeliveryOrderDaoImpl() }
    single<DeliveryOrderDetailDao> { DeliveryOrderDetailDaoImpl() }
    single<EmployeeDao> { EmployeeDaoImpl() }
    single<InventoryDao> { InventoryDaoImpl() }
    single<InventoryTransactionDao> { InventoryTransactionDaoImpl() }
    single<PurchasePaymentDao> { PurchasePaymentDaoImpl() }
    single<PurchaseOrderDao> { PurchaseOrderDaoImpl() }
    single<PurchaseOrderDetailDao> { PurchaseOrderDetailDaoImpl() }
    single<ReturnOrderDao> { ReturnOrderDaoImpl() }
    single<ReturnOrderDetailDao> { ReturnOrderDetailDaoImpl() }
    single<ProductDao> { ProductDaoImpl() }
    single<ProductImageDao> { ProductImageDaoImpl() }
    single<ProductLotDao> { ProductLotDaoImpl() }
    single<RoleDao> { RoleDaoImpl() }
    single<SalesOrderDao> { SalesOrderDaoImpl() }
    single<SalesOrderDetailDao> { SalesOrderDetailDaoImpl() }
    single<SalesPaymentDao> { SalesPaymentDaoImpl() }
    single<SupplierDao> { SupplierDaoImpl() }
    single<StockTransferDao> { StockTransferDaoImpl() }
}

fun configModule(applicationEnvironment: ApplicationEnvironment) = module {
    single<ApplicationEnvironment> { applicationEnvironment }
}

package org.example.inventory_management.config


import org.example.inventory_management.controllers.AuthController
import org.example.inventory_management.controllers.UserController
import org.example.inventory_management.dao.*
import org.example.inventory_management.repositories.AuthRepository
import org.example.inventory_management.repositories.AuthRepositoryImpl
import org.example.inventory_management.repositories.UserRepository
import org.example.inventory_management.repositories.UserRepositoryImpl
import org.example.inventory_management.services.AuthService
import org.example.inventory_management.services.UserService
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureFrameworks() {
    install(Koin) {
        slf4jLogger()
        modules(
            listOf(
                configModule(environment),
                appDaoModule(),
                authModule(),
                userModule()
            )
        )
    }
}

fun authModule() = module {
    single<AuthService> { AuthService(get()) }
    single<AuthController> { AuthController() }
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
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

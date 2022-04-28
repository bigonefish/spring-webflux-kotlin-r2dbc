package com.example.learnspringwebfluxr2dbc

//import io.r2dbc.spi.ConnectionFactories
//import io.r2dbc.spi.ConnectionFactory
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

//@Configuration
//@EnableR2dbcRepositories
//class R2DBCConfig : AbstractR2dbcConfiguration() {
//    @Bean
//    override fun connectionFactory() : ConnectionFactory {
//        return ConnectionFactories.get("r2dbc:mariadb://root:1111@localhost:3306/db_works")
//    }
//}
package bigs.bigsbetest.infra.mysql.db.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class MysqlDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "bigs-be-test.datasource")
    fun hikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    fun mainDataSource(@Qualifier("hikariConfig") config:HikariConfig): HikariDataSource {
        return HikariDataSource(config)
    }
}
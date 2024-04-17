package bigs.bigsbetest.infra.mysql.db.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = ["bigs.BigsBeTest.infra.mysql.db"])
@EnableJpaRepositories(basePackages = ["bigs.bigsbetest.infra.mysql.db"])
internal class MysqlJpaConfig {
}
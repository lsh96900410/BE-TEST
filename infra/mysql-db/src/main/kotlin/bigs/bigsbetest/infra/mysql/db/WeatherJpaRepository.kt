package bigs.bigsbetest.infra.mysql.db

import org.springframework.data.jpa.repository.JpaRepository

internal interface WeatherJpaRepository : JpaRepository<WeatherEntity, Long>{
    fun findByNxAndNy(nx : Int, ny : Int) : List<WeatherEntity>
}


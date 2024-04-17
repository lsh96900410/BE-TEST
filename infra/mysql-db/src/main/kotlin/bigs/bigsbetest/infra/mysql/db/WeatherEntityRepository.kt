package bigs.bigsbetest.infra.mysql.db

import bigs.bigsbetest.domains.Weather
import bigs.bigsbetest.domains.WeatherRepository
import bigs.bigsbetest.domains.dto.WeatherDomainDto
import org.springframework.stereotype.Repository

/**
 *  Domain Module Repository Interface 구현체 [mysql, JPA 사용 모듈]
 */

@Repository
internal class WeatherEntityRepository(
    private val weatherJpaRepository: WeatherJpaRepository,
) : WeatherRepository {

    /**
     *  Dto -> Entity for Insert
     */
    override fun saveWeather(dto: WeatherDomainDto) {
        weatherJpaRepository.save(WeatherEntity(
            nx = dto.nx,
            ny = dto.ny,
            baseDate = dto.baseDate,
            baseTime = dto.baseTime,
            pty = dto.pty,
            rn1 = dto.rn1,
            reh = dto.reh,
            t1h = dto.t1h,
            uuu = dto.uuu,
            vvv = dto.vvv,
            wsd = dto.wsd,
            vec = dto.vec
        ))
    }

    /**
     *  Entity List Data -> Domain List Data for
     */
    override fun findWeather(nx: Int, ny: Int): List<Weather> {
        var data = weatherJpaRepository.findByNxAndNy(nx, ny)
        val weatherList = mutableListOf<Weather>()

        for (entity in data) {
            val weather = entity.toWeather()
            weatherList.add(weather)
        }
        return weatherList;
    }

}
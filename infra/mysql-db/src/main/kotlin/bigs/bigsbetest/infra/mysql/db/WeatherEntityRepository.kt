package bigs.bigsbetest.infra.mysql.db

import bigs.bigsbetest.domains.Weather
import bigs.bigsbetest.domains.WeatherRepository
import bigs.bigsbetest.domains.dto.WeatherDomainDto
import org.springframework.stereotype.Repository

/**
 *  Domain Module - WeatherRepository Interface 구현체
 */

@Repository
internal class WeatherEntityRepository(
    private val weatherJpaRepository: WeatherJpaRepository,
) : WeatherRepository {

    /**
     *  Domain Dto -> Entity, for Insert
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
     *  Entity List  -> Domain List
     */
    override fun findWeatherAtRegion(nx: Int, ny: Int): List<Weather> {

        var resultEntity_findWeathers_atRegion = weatherJpaRepository.findByNxAndNy(nx, ny)

        val resultDomain_findWeathers_atRegion = mutableListOf<Weather>()

        for (entity in resultEntity_findWeathers_atRegion) {
            val domain_weather = entity.toDomain()
            resultDomain_findWeathers_atRegion.add(domain_weather)
        }

        return resultDomain_findWeathers_atRegion;
    }

}
package bigs.bigsbetest.domains

import bigs.bigsbetest.domains.dto.WeatherDomainDto

/**
 *  Implementation Class : infra, mysql-db, WeatherEntityRepository
 */
interface WeatherRepository {
    fun findWeatherAtRegion(nx : Int, ny : Int) : List<Weather>
    fun saveWeather(apiData : WeatherDomainDto)
}
package bigs.bigsbetest.domains

import bigs.bigsbetest.domains.dto.WeatherDomainDto

/**
 *  Implementation Class == infra, mysql-db , WeatherEntityRepository
 *  -> 도메인 모듈은 infra 구조를 모른다.
 */
interface WeatherRepository {
    fun findWeather(nx : Int, ny : Int) : List<Weather>
    fun saveWeather(apiData : WeatherDomainDto)
}
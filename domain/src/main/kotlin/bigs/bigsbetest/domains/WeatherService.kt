package bigs.bigsbetest.domains

import bigs.bigsbetest.domains.dto.WeatherDomainDto
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service


@Service
class WeatherService (
    private val weatherFind : WeatherFind,
    private val weatherApiSave: WeatherApiSave
){
    fun save(weatherDomainDto: WeatherDomainDto){
        return weatherApiSave.save(weatherDomainDto)
    }

    fun findWeatherAtRegion(nx : Int, ny : Int) : List<Weather>{
        return weatherFind.findWeathersAtRegion(nx,ny)
    }
}
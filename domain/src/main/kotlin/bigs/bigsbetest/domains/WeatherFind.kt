package bigs.bigsbetest.domains

import bigs.bigsbetest.domains.WeatherRepository
import org.springframework.stereotype.Component

@Component
class WeatherFind (
    private val weatherRepository: WeatherRepository
) {
    fun find(nx : Int, ny : Int) : List<Weather>{
       return  weatherRepository.findWeather(nx,ny)
    }
}
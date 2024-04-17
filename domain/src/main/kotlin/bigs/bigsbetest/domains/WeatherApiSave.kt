package bigs.bigsbetest.domains

import bigs.bigsbetest.domains.dto.WeatherDomainDto
import org.springframework.stereotype.Component
import java.sql.SQLIntegrityConstraintViolationException

@Component
class WeatherApiSave(
    private val weatherRepository: WeatherRepository
) {
    /**
     *  중복 Data Save 방지 -> 예외 처리
     */
    fun save (weatherDomainDto: WeatherDomainDto){
        try {
            return weatherRepository.saveWeather(weatherDomainDto)
        }catch (e : SQLIntegrityConstraintViolationException){
            e.printStackTrace()
        }

    }
}
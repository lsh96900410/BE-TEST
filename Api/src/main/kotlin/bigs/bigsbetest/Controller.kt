package bigs.bigsbetest

import bigs.bigsbetest.domains.Weather
import bigs.bigsbetest.domains.dto.ForecastApiResponseDto
import bigs.bigsbetest.domains.WeatherService
import bigs.bigsbetest.domains.dto.WeatherDomainDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/bigs")
class Controller(
    private val service: Service,
    private val weatherService: WeatherService
) {

    /**
     *  요구사항 X,Y 좌표 : 60,130
     */
    @GetMapping
    fun findForecast() : ResponseEntity<Any>  {

        var result_findWeather = weatherService.findWeatherAtRegion(60,130)

        return if(result_findWeather.isNotEmpty()){
            ResponseEntity.status(HttpStatus.OK).body(result_findWeather)
        }else{
            ResponseEntity.noContent().build()
        }

    }

    /**
     *  데이터 전달 흐름
     *  예보 응답 Api -> 응답 API DTO -> DomainDto -> Entity
     */
    @PostMapping
    fun saveForecast() {
        var result_fetch_forecastApi : List<ForecastApiResponseDto> = service.forecastFind();

        val weatherDomainDto = WeatherDomainDto(result_fetch_forecastApi)

        weatherService.save(weatherDomainDto);
    }

}
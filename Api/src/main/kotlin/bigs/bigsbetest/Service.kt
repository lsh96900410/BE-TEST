package bigs.bigsbetest

import bigs.bigsbetest.domains.dto.ForecastApiResponseDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URL
import java.net.URLEncoder

@Service
class Service () {

    /**
     *  작업 흐름
     *  1. http call
     *  2. response json Serialization -> Domain DTO Deserialization
     */

    fun forecastFind() : List<ForecastApiResponseDto> {
        /**
         *  1. http call
         */

        var restTemplate  = RestTemplate();
        var serviceKey : String ="서비스키"

        val requestUri =
            StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst")
            requestUri.append(("?" + URLEncoder.encode("serviceKey", "UTF-8")).toString()+"="+ serviceKey)
            requestUri.append(("&" + URLEncoder.encode("pageNo", "UTF-8")).toString() + "=" + URLEncoder.encode("1", "UTF-8"))
            requestUri.append(("&" + URLEncoder.encode("numOfRows", "UTF-8")).toString() + "=" + URLEncoder.encode("1000", "UTF-8"))
            requestUri.append(("&" + URLEncoder.encode("dataType", "UTF-8")).toString() + "=" + URLEncoder.encode("JSON", "UTF-8"))
            requestUri.append(("&" + URLEncoder.encode("base_date", "UTF-8")).toString() + "=" + URLEncoder.encode("20240417", "UTF-8"))
            requestUri.append(("&" + URLEncoder.encode("base_time", "UTF-8")).toString() + "=" + URLEncoder.encode("1700", "UTF-8"))
            requestUri.append(("&" + URLEncoder.encode("nx", "UTF-8")).toString() + "=" + URLEncoder.encode("60", "UTF-8"))
            requestUri.append(("&" + URLEncoder.encode("ny", "UTF-8")).toString() + "=" + URLEncoder.encode("130", "UTF-8"))


        val result_fetch_forecastData: ResponseEntity<String> = restTemplate.getForEntity(requestUri.toString(), String::class.java)
        val string_responseBody: String = result_fetch_forecastData.body ?:""

        /**
         *  2. response json Serialization -> Domain DTO Deserialization
         */

        val objectMapper = ObjectMapper()

        val fetchApi_ResponseBodyDatas = objectMapper.readTree(string_responseBody)
            .get("response")
            .get("body")
            .get("items")
            .get("item")

        val forecastApi_responseDtos = mutableListOf<ForecastApiResponseDto>();

        for (i in 0 until fetchApi_ResponseBodyDatas.size()){
            val apiResponseBodyData = fetchApi_ResponseBodyDatas.get(i)
            
            val forecast = objectMapper.convertValue(apiResponseBodyData, ForecastApiResponseDto::class.java)
            forecastApi_responseDtos.add(forecast)
        }

        return forecastApi_responseDtos
    }

}
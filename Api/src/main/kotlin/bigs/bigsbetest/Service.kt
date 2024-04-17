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
        restTemplate.messageConverters.add(MappingJackson2HttpMessageConverter());
        var serviceKey : String ="서비스키"

        val urlBuilder =
            StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst")
        urlBuilder.append(("?" + URLEncoder.encode("serviceKey", "UTF-8")).toString()+"="+ serviceKey)
        urlBuilder.append(("&" + URLEncoder.encode("pageNo", "UTF-8")).toString() + "=" + URLEncoder.encode("1", "UTF-8"))
        urlBuilder.append(("&" + URLEncoder.encode("numOfRows", "UTF-8")).toString() + "=" + URLEncoder.encode("1000", "UTF-8"))
        urlBuilder.append(("&" + URLEncoder.encode("dataType", "UTF-8")).toString() + "=" + URLEncoder.encode("JSON", "UTF-8"))
        urlBuilder.append(("&" + URLEncoder.encode("base_date", "UTF-8")).toString() + "=" + URLEncoder.encode("20240417", "UTF-8"))
        urlBuilder.append(("&" + URLEncoder.encode("base_time", "UTF-8")).toString() + "=" + URLEncoder.encode("0800", "UTF-8"))
        urlBuilder.append(("&" + URLEncoder.encode("nx", "UTF-8")).toString() + "=" + URLEncoder.encode("60", "UTF-8"))
        urlBuilder.append(("&" + URLEncoder.encode("ny", "UTF-8")).toString() + "=" + URLEncoder.encode("130", "UTF-8"))
        val url: URL = URL(urlBuilder.toString())


        /**
         *  2. response json Serialization -> Domain DTO Deserialization
         */

        val objectMapper = ObjectMapper()
        val responseEntity: ResponseEntity<String> = restTemplate.getForEntity(url.toString(), String::class.java)
        val responseBody: String = responseEntity.body ?:""

        val responseJsonDatas = objectMapper.readTree(responseBody)
            .get("response")
            .get("body")
            .get("items")
            .get("item")

        val itemList = mutableListOf<ForecastApiResponseDto>();

        for (i in 0 until responseJsonDatas.size()){
            val jsonItem = responseJsonDatas.get(i)
            val item = objectMapper.convertValue(jsonItem, ForecastApiResponseDto::class.java)
            itemList.add(item)
        }

        return itemList
    }

}
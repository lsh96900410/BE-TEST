package bigs.bigsbetest.domains.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

/**
 *  JSON Response Api Deserialization DTO 
 *  - 예보 응답 데이터 중 필요 부분 추출
 */

data class ForecastApiResponseDto @JsonCreator constructor (
    @JsonProperty("baseDate") val baseDate: String,
    @JsonProperty("baseTime") val baseTime: String,
    @JsonProperty("category") val category: String,
    @JsonProperty("nx") val nx: Int,
    @JsonProperty("ny") val ny: Int,
    @JsonProperty("obsrValue") val obsrValue: String
)

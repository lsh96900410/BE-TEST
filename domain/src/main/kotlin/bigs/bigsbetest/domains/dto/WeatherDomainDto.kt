package bigs.bigsbetest.domains.dto

/**
 *  JSON Response Api Deserialization DTO -> Database Domain Required DTO
 */

data class WeatherDomainDto (
    var nx : Int ?=null,
    var ny : Int ?=null,
    var baseDate : String ?=null,
    var baseTime : String ?=null,
    var pty : String ?=null,
    var rn1 : String ?=null,
    var reh : String ?=null,
    var t1h : String ?=null,
    var uuu : String ?=null,
    var vvv : String ?=null,
    var wsd : String ?=null,
    var vec : String ?=null,
    var list : List<ForecastApiResponseDto> ?=null
){
    constructor(weatherList: List<ForecastApiResponseDto>) : this(list = weatherList)

    init {
        list?.let {
            this.nx= it.firstOrNull()?.nx
            this.ny= it.firstOrNull()?.ny
            this.baseDate=it.firstOrNull()?.baseDate
            this.baseTime=it.firstOrNull()?.baseTime

            for (weatherData in it) {
                when (weatherData.category) {
                    "PTY" -> this.pty = weatherData.obsrValue
                    "RN1" -> this.rn1 = weatherData.obsrValue
                    "REH" -> this.reh = weatherData.obsrValue
                    "T1H" -> this.t1h = weatherData.obsrValue
                    "UUU" -> this.uuu = weatherData.obsrValue
                    "VVV" -> this.vvv = weatherData.obsrValue
                    "WSD" -> this.wsd = weatherData.obsrValue
                    "VEC" -> this.vec = weatherData.obsrValue
                }
            }

        }
    }


}
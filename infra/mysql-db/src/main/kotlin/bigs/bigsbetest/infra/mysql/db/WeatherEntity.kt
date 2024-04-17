package bigs.bigsbetest.infra.mysql.db

import bigs.bigsbetest.domains.Weather
import bigs.bigsbetest.domains.dto.WeatherDomainDto
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

/**
 * nx+ ny = 지역, basedate+basetime = 예보 시간
 * -> 중복 데이터 DB insert 방지 : Unique
 */

@Entity
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["nx","ny","baseDate","baseTime"])])
internal class WeatherEntity (
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
    var vec : String ?=null
) : BaseEntity() {


    /**
     *  Entity -> Domain
     */
    fun toWeather(): Weather {
        val weather = Weather()
        weather.nx = this.nx
        weather.ny = this.ny
        weather.baseDate = this.baseDate
        weather.baseTime = this.baseTime
        weather.pty = this.pty
        weather.rn1 = this.rn1
        weather.reh = this.reh
        weather.t1h = this.t1h
        weather.uuu = this.uuu
        weather.vvv = this.vvv
        weather.wsd = this.wsd
        weather.vec = this.vec
        return weather
    }


}
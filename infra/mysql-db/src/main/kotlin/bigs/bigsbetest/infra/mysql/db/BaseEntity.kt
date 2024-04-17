package bigs.bigsbetest.infra.mysql.db

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalTime

@MappedSuperclass
internal abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?=null

    @CreationTimestamp
    var createAt: LocalTime? = null

}
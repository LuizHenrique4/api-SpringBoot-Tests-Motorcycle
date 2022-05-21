package sptech.motorcycle.entity

import org.jetbrains.annotations.NotNull
import javax.persistence.*
import kotlin.math.min

@Entity
@Table(name = "motos")
class Moto (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    var nome: String,

    var modelo: String,

    var potencia: Double,
)
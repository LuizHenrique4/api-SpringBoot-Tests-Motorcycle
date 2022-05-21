package sptech.motorcycle.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sptech.motorcycle.entity.Moto
import sptech.motorcycle.repository.MotoRepository
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/motos")
class MotoController {

    @Autowired
    lateinit var repository: MotoRepository

    @GetMapping
    fun index(): List<Moto> {
        return repository.findAll()
    }

    @PostMapping
    fun postMotorcycle(@RequestBody moto: Moto): Moto {
        return repository.save(moto)
    }

    @GetMapping("/{id}")
    fun getMotorcycle(@PathVariable("id") id: Long): Moto {
        return repository.findById(id).orElseThrow(){
            EntityNotFoundException()
        }
    }

    @PutMapping("/{id}")
    fun putMotorcycle(@PathVariable("id") id: Long, @RequestBody novaMoto: Moto): Moto {
        val moto = repository.findById(id).orElseThrow(){
            EntityNotFoundException()
        }
        moto.apply {
            this.nome = novaMoto.nome
            this.modelo = novaMoto.modelo
            this.potencia = novaMoto.potencia
        }
        return repository.save(moto)
    }

    @DeleteMapping("/{id}")
    fun deleteMotorcycle(@PathVariable("id") id: Long){
        var moto = repository.findById(id).orElseThrow {
            EntityNotFoundException()
        }
        repository.delete(moto)
    }
}
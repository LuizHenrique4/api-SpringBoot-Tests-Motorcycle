package sptech.motorcycle.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sptech.motorcycle.entity.Moto

@Repository
interface MotoRepository: JpaRepository<Moto, Long> {
}
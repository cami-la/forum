package br.com.alura.forum.service

import br.com.alura.forum.entity.Usuario
import br.com.alura.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
data class UsuarioService(
  private val repository: UsuarioRepository
) {
  
  fun buscaUsuarioPorId(id:Long) : Usuario {
    return repository.getById(id)
  }
  
}

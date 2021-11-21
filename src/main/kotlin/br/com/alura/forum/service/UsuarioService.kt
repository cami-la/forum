package br.com.alura.forum.service

import br.com.alura.forum.entity.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
data class UsuarioService(
  private var usuarios: List<Usuario>
) {
  
  init {
    val usuario1 = Usuario(
      id = 1,
      nome = "Ana da Silva",
      email = "ana@email.com"
    )
  
   /* val usuario2 = Usuario(
      id = 3,
      nome = "Joana da Silva",
      email = "Joana@email.com"
    )
  
    val usuario3 = Usuario(
      id = 4,
      nome = "Maria da Silva",
      email = "maria@email.com"
    )*/
    
    usuarios = Arrays.asList(usuario1)
  }
  
  fun buscaUsuarioPorId(id:Long) : Usuario {
    return usuarios.stream()
      .filter { u ->
        u.id == id
      }
      .findFirst()
      .get()
  }
  
}

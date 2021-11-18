package br.com.alura.forum.service

import br.com.alura.forum.entity.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
data class UsuarioService(
  var usuarios: List<Usuario>
) {
  init {
    val usuario: Usuario = Usuario (
      id = 1,
      nome = "Ana da Silva",
      email = "ana@email.com"
    )
    usuarios = Arrays.asList(usuario)
  }
  
  fun buscaUsuarioPorId(idAutor: Long): Usuario {
    return usuarios.stream()
      .filter { u ->
        u.id == idAutor
      }
      .findFirst()
      .get()
  }

}

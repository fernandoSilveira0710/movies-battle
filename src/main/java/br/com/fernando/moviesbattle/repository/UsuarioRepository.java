package br.com.fernando.moviesbattle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fernando.moviesbattle.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByNickAndSenha(String nick, String senha);

}

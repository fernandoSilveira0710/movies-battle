package br.com.fernando.moviesbattle.repository;

import br.com.fernando.moviesbattle.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUserAndPassword(String user, String password);

}

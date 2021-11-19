package co.edu.uniquindio.software.safepet.logica.security;


import co.edu.uniquindio.software.safepet.persistencia.entidades.Afiliado;
import co.edu.uniquindio.software.safepet.persistencia.entidades.CentroVeterinario;
import co.edu.uniquindio.software.safepet.persistencia.entidades.EmpleadoSafePet;
import co.edu.uniquindio.software.safepet.persistencia.entidades.Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.HashSet;

import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;

@ApplicationScoped
public class JPAIdentityStore implements IdentityStore {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CredentialValidationResult validate(Credential credential) {
        UsernamePasswordCredential userCredential = (UsernamePasswordCredential) credential;

        Usuario user = findUser(userCredential.getCaller());
        if( user != null && user.getContrasenia().equals( userCredential.getPasswordAsString() ) ){
            HashSet<String> roles = new HashSet<>();
            roles.add( user.getClass().getSimpleName() );
            return new CredentialValidationResult(user.getId(),roles);
        }
        return INVALID_RESULT;
    }

    private Usuario findUser(String id) {
        Usuario usuario = entityManager.find(EmpleadoSafePet.class,id);
        if( usuario != null ){
            return usuario;
        }
        usuario = entityManager.find(Afiliado.class,id);
        if( usuario != null ){
            return usuario;
        }
        usuario = entityManager.find(CentroVeterinario.class,id);
        if( usuario != null ){
            return usuario;
        }
        return null;
    }
}

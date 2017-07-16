package dc.ufscar.br
import org.springframework.security.access.annotation.Secured

@Secured (['ROLE_USER', 'ROLE_ADMIN'])
class MainController {

    def springSecurityService

    def index() {

        def usuario = springSecurityService.getCurrentUser()
        def authority = usuario.getAuthorities()[0].getAuthority()
        session.usuario = usuario

        if (authority.equals('ROLE_USER')) {
            redirect(controller: "cd")
        } else {
            redirect(controller: "usuario")
        }
    }
}
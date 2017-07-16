import dc.ufscar.br.Artista
import dc.ufscar.br.Cd
import dc.ufscar.br.Usuario
import dc.ufscar.br.Papel
import dc.ufscar.br.UsuarioPapel

class BootStrap {

    def init = { servletContext ->

        def adminPapel = Papel.findByAuthority("ROLE_ADMIN") ?:
                new Papel(authority: "ROLE_ADMIN").save()

        def admin = new Usuario(
                username: "admin",
                password: "admin",
                nome: "Administrador",
                enabled: true
        )

        admin.save()
        if(admin.hasErrors()){
            println admin.errors
        }

        UsuarioPapel.create(admin, adminPapel)

        println 'Populando Usuario Admin - OK'

        def userPapel = Papel.findByAuthority("ROLE_USER") ?:
                new Papel(authority: "ROLE_USER").save()

        def usuario = new Usuario(
                username: "usuario",
                password: "usuario",
                nome: "Usuario",
                enabled: true
        )

        usuario.save()
        if(usuario.hasErrors()){
            println usuario.erros
        }

        UsuarioPapel.create(usuario, userPapel)

        println 'Populando Usuario Usuario - OK'

        

    }
    def destroy = {
    }
}

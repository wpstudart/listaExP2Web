package dc.ufscar.br

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured

@Transactional(readOnly = true)
@Secured(['ROLE_USER', 'ROLE_ADMIN'])
class ArtistaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Artista.list(params), model:[artistaCount: Artista.count()]
    }

    def show(Artista artista) {
        respond artista
    }

    def create() {
        respond new Artista(params)
    }

    @Transactional
    def save(Artista artista) {
        if (artista == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (artista.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond artista.errors, view:'create'
            return
        }

        artista.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'artista.label', default: 'Artista'), artista.id])
                redirect artista
            }
            '*' { respond artista, [status: CREATED] }
        }
    }

    def edit(Artista artista) {
        respond artista
    }

    @Transactional
    def update(Artista artista) {
        if (artista == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (artista.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond artista.errors, view:'edit'
            return
        }

        artista.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'artista.label', default: 'Artista'), artista.id])
                redirect artista
            }
            '*'{ respond artista, [status: OK] }
        }
    }

    @Transactional
    def delete(Artista artista) {

        if (artista == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        artista.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'artista.label', default: 'Artista'), artista.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'artista.label', default: 'Artista'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

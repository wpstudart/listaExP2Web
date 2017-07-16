package dc.ufscar.br

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured

@Transactional(readOnly = true)
@Secured(['ROLE_USER', 'ROLE_ADMIN'])
class CdController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Cd.list(params), model:[cdCount: Cd.count()]
    }

    def show(Cd cd) {
        respond cd
    }

    def create() {
        respond new Cd(params)
    }

    @Transactional
    def save(Cd cd) {
        if (cd == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cd.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cd.errors, view:'create'
            return
        }

        cd.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cd.label', default: 'Cd'), cd.id])
                redirect cd
            }
            '*' { respond cd, [status: CREATED] }
        }
    }

    def edit(Cd cd) {
        respond cd
    }

    @Transactional
    def update(Cd cd) {
        if (cd == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cd.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cd.errors, view:'edit'
            return
        }

        cd.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'cd.label', default: 'Cd'), cd.id])
                redirect cd
            }
            '*'{ respond cd, [status: OK] }
        }
    }

    @Transactional
    def delete(Cd cd) {

        if (cd == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        cd.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'cd.label', default: 'Cd'), cd.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cd.label', default: 'Cd'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

package dc.ufscar.br

import grails.test.mixin.*
import spock.lang.*

@TestFor(ArtistaController)
@Mock(Artista)
class ArtistaControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.artistaList
            model.artistaCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.artista!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def artista = new Artista()
            artista.validate()
            controller.save(artista)

        then:"The create view is rendered again with the correct model"
            model.artista!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            artista = new Artista(params)

            controller.save(artista)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/artista/show/1'
            controller.flash.message != null
            Artista.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def artista = new Artista(params)
            controller.show(artista)

        then:"A model is populated containing the domain instance"
            model.artista == artista
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def artista = new Artista(params)
            controller.edit(artista)

        then:"A model is populated containing the domain instance"
            model.artista == artista
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/artista/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def artista = new Artista()
            artista.validate()
            controller.update(artista)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.artista == artista

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            artista = new Artista(params).save(flush: true)
            controller.update(artista)

        then:"A redirect is issued to the show action"
            artista != null
            response.redirectedUrl == "/artista/show/$artista.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/artista/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def artista = new Artista(params).save(flush: true)

        then:"It exists"
            Artista.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(artista)

        then:"The instance is deleted"
            Artista.count() == 0
            response.redirectedUrl == '/artista/index'
            flash.message != null
    }
}

package dc.ufscar.br

class Cd {

    static constraints = {
        nome(nullable: false)
    }

    int ano
    String nome

    String toString(){
        return nome + ano
    }
}

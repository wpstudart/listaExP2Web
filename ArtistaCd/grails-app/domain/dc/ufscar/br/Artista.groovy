package dc.ufscar.br

class Artista {

    static hasMany = [cd: Cd]

    static constraints = {
        nome(nullable: false)
    }

    String nome
    boolean banda

    String toString(){
        if (banda){
            return "Banda: " + nome
        } else {
            return nome
        }
    }


}

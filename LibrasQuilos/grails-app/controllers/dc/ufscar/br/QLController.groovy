package dc.ufscar.br

class QLController {

    def index() {

        def minVal, maxVal, inc

        if(!params.minVal) {
            minVal = -100
        } else {
            minVal = Integer.parseInt(params.minVal)
        }

        if(!params.maxVal) {
            maxVal = 100
        } else {
            maxVal = Integer.parseInt(params.maxVal)
        }

        if(!params.inc){
            inc = 5
        } else {
            inc = Integer.parseInt(params.inc)
        }

        List<QuiloLibras> list = new ArrayList<>()

        for(i in (minVal..maxVal).step(inc)){
            def ql = new QuiloLibras();
            ql.setQuilos(i)
            list.add(ql)
        }

        render view: 'index', model: [lista: list]

    }
}

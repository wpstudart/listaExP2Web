package dc.ufscar.br

class FibController {

    def index() {

        def n

        if(!params.n){
            n = 15
        } else {
            n = Integer.parseInt(params.n)
        }

        List<Fibonacci> list = new ArrayList<>()

        for(i in (1..n).step(1)){
            def fib = new Fibonacci();
            fib.Fibonacci(i)
            list.add(fib)
        }

        render view: 'index', model: [lista:list]
    }
}

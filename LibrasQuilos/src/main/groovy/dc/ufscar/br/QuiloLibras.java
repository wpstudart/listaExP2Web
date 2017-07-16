package dc.ufscar.br;

public class QuiloLibras {

    private double quilos;
    private double libras;

    public QuiloLibras(){

    }

    public double getQuilos(){
        return this.quilos;
    }

    public double getLibras(){
        return this.libras;
    }

    public void setQuilos(double quilos){
        this.quilos = quilos;
        this.libras = quilos * 2.2046;
    }

    public void setLibras(double libras){
        this.libras = libras;
        this.quilos = libras / 2.2046;
    }

}

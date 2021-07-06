package clases;

import java.math.*;

public class erlang {

    private double erlang;
    private double bloking;
    private double lineas;
    private double porcent;
    
public erlang(double erlang, double bloking, double lineas, double porcent){
    this.erlang = erlang;
    this.bloking = bloking;
    this.lineas = lineas;
    this.porcent = porcent;
}

    public double getErlang() {
        return erlang;
    }

    public void setErlang(double erlang) {
        this.erlang = erlang;
    }

    public double getBloking() {
        return bloking;
    }

    public void setBloking(double bloking) {
        this.bloking = bloking;
    }

    public double getLines() {
        return lineas;
    }

    public void setLines(double lineas) {
        this.lineas = lineas;
    }
    
    public double getPorcent() {
        return porcent;
    }

    public void setPorcent(double porcent) {
        this.porcent = porcent;
    }

    public static final double erlangB(double linea, double erlang) {
	double pn = 1.0;
	for (int i = 1; i <= linea; i++) {
            pn = computeRecursive(i, erlang, pn);
	}
	return pn;
	}

    protected static final double computeRecursive(double linea, double erlang,
	double pn_1) {
	return (erlang * pn_1) / (linea + erlang * pn_1);
    }
    
public double ErlangBResult(){
    int j = 0;
    BigDecimal bd = new BigDecimal(erlangB(j, getErlang())).setScale(3, RoundingMode.HALF_UP);
    double bloqueo = bd.doubleValue();
    while(!(Double.compare(getBloking(), bloqueo) == 0)){
        j++;
        bd = new BigDecimal(erlangB(j, getErlang())).setScale(3, RoundingMode.HALF_UP);
        bloqueo = bd.doubleValue();
    }
    return j;
}    
    
public double ErlangExtResult(){
    BigDecimal bd = new BigDecimal(erlangB(getLines(), getErlang())).setScale(3, RoundingMode.HALF_UP);
    double bloqueo = bd.doubleValue();
    setBloking(bloqueo);
    //extender 
    double porcent = getPorcent()/100;
    double adicional = getErlang() * porcent * getBloking();
    setErlang(getErlang()+adicional);
    //Recalcular
    bd = new BigDecimal(erlangB(getLines(), getErlang())).setScale(3, RoundingMode.HALF_UP);
    bloqueo = bd.doubleValue();
    setBloking(bloqueo);
    //resultado
    return getBloking();
}

}

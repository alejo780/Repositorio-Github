
package Logica;

public class PonerNavesComputadora {
    static int filaMovimientoComputadora=0, columnaMovimientoComputadora=0;
    static boolean posicionValida=false, naveNoColocada=false, barcoColocado=false, barcoHColocado=false, barcoVColocado=false;
    static InstruccionesDeJuego idj = new InstruccionesDeJuego();
    static MetodosUtiles mu = new MetodosUtiles();
    
    public static void ponerTodasLasNavesComputadora(){
        for(int i=0; i<10; i++){
            ponerBarco();
            resetearFilaColumnaPosicion();
        }
        barcoColocado=true;
        for(int i=0; i<5; i++){
            ponerBarcosH();
            resetearFilaColumnaPosicion();
        }
        barcoHColocado=true;
       for(int i=0; i<5; i++){
            ponerBarcosH();
            resetearFilaColumnaPosicion();
        }
        barcoVColocado=true;
        if (barcoHColocado==true && barcoVColocado==true && barcoColocado==true){
        }
    }
    
    public static void generarFilaColumna(){
        filaMovimientoComputadora=(int)(Math.random()*15);
        columnaMovimientoComputadora=(int)(Math.random()*15);
    }
    
    public static void resetearFilaColumnaPosicion(){
        filaMovimientoComputadora=0;
        columnaMovimientoComputadora=0;
        posicionValida=false;
        naveNoColocada=false;
    }
    
    public static boolean validarFilaColumnaIngresadas(){
        do {
            generarFilaColumna();
            if(idj.TableroComputadoraBackEnd[filaMovimientoComputadora][columnaMovimientoComputadora].equals(" ")){
                posicionValida=true;
            }else{
                posicionValida=false;
            }
        } while (posicionValida==false);
        return posicionValida;
    }
    
    public static void ponerBarco(){
        if (validarFilaColumnaIngresadas()==true) {
            idj.TableroComputadoraBackEnd[filaMovimientoComputadora][columnaMovimientoComputadora]="1";
        }
    }
    
    public static void ponerBarcosH(){
        do {
            if (validarFilaColumnaIngresadas()==true) {
                int i=filaMovimientoComputadora;
                int j=columnaMovimientoComputadora;
                if (((j+1)<=(idj.TableroComputadoraBackEnd[0].length-1)) && (idj.TableroComputadoraBackEnd[i][j+1].equals(" "))){
                    idj.TableroComputadoraBackEnd[i][j]="2";
                    idj.TableroComputadoraBackEnd[i][j+1]="2";
                    naveNoColocada=true;
                }else if(((i+1)<=(idj.TableroComputadoraBackEnd.length-1)) && (idj.TableroComputadoraBackEnd[i+1][j].equals(" "))){
                    idj.TableroComputadoraBackEnd[i][j]="2";
                    idj.TableroComputadoraBackEnd[i+1][j]="2";
                    naveNoColocada=true;
                }else if((j-1)>=0 && ((j-1)<=(idj.TableroComputadoraBackEnd[0].length-1)) && (idj.TableroComputadoraBackEnd[i][j-1].equals(" "))){
                    idj.TableroComputadoraBackEnd[i][j]="2";
                    idj.TableroComputadoraBackEnd[i][j-1]="2";
                    naveNoColocada=true;
                }else if((i-1)>=0 && ((i-1)<=(idj.TableroComputadoraBackEnd.length-1)) && (idj.TableroComputadoraBackEnd[i-1][j].equals(" "))){
                    idj.TableroComputadoraBackEnd[i][j]="2";
                    idj.TableroComputadoraBackEnd[i-1][j]="2";
                    naveNoColocada=true;
                }
            }
        } while (naveNoColocada==false);
    }
    
}


import java.util.*;
/**
 * Acepta el reto. 207- Sombras en el camping.
 * https://www.aceptaelreto.com/problem/statement.php?id=207
 *
 * Consideraciones al final del código.
 */
 
public class SombrasEnElCamping
{
    //Una variable de instancia (compartida)
    //que representa al camping: array bidimensional
 
    int camping[][];
    int sombras; //la cantidad de casillas con sombra en cada momento
 
    //constantes utiles
    static final int NO_SOMBRA=0;
    static final int SOMBRA=1;
    static final int ARBOL=2;
 
    /**
     * Inicializa los datos de un caso. Crea un modelo de un camping vacío con todas las casillas sin sombra.
     * Inicializa el contador de casillas con sombra a 0.
     * @param c columnas
     * @param f filas
     */
    void iniciarCaso(int c, int f)
    {
        //iniciamos el caso. Creamos la matriz. (filas x columnas)
        camping=new int[f][c];
        sombras=0;
        //todo sin sombra:
        for (int i=0;i<f;i++)
        {
            for(int j=0;j<c;j++)
            {
                camping[i][j]=NO_SOMBRA;
            }
        }
    }
 
    /**
     * Marca en el modelo las casillas que van a tener un arbol, y las que quedan en sombra debido a ese arbol
     * Sólo debe ser invocado si previamente se ha iniciado el caso con el  {@link #iniciarCaso(int, int) método iniciarCaso(...)}.
     * @param c columnas
     * @param f filas
     */
    void annadirArbol(int cArbol, int fArbol)
    {
        //rango incial y final de filas a poner en sombra, teniendo en cuenta
        //que el arbol podría estar en el borde del camping.
        int fArbolIni=fArbol-1>=0?fArbol-1:fArbol;
        int fArbolFin=fArbol+1<camping.length?fArbol+1:fArbol;
        //rango incial y final de columnas a poner en sombra
        int cArbolIni=cArbol-1>=0?cArbol-1:cArbol;
        int cArbolFin=cArbol+1<camping[0].length?cArbol+1:cArbol;
 
        //si el arbol cae en una casilla que ya estaba en sombra, entonces hay una
        //casilla menos disponible con sommra
        if (camping[fArbol][cArbol]==SOMBRA)
        {
            sombras--;
        }
 
        camping[fArbol][cArbol]=ARBOL; //marcar la posición del arbol
 
        //marcar las casillas con sombra que produce el arbol e ir contándolas
        for (int i=fArbolIni; i<=fArbolFin; i++)
        {
            for (int j=cArbolIni; j<=cArbolFin; j++)
            {
                if (camping[i][j]==NO_SOMBRA)
                {
                    camping[i][j]=SOMBRA;
                    sombras++;
                }
            }
        }
    }
 
    /**
     * El programa principal
     */
    void run()
    {
        Scanner in=new Scanner(System.in);
        boolean esElCentinela;
        do
        {
            //leer columnas, filas y arbol
            int c=in.nextInt();
            int f=in.nextInt();
            int a=in.nextInt();
 
            esElCentinela=(f==0 && c==0 && a==0);
            if (!esElCentinela)
            {
                iniciarCaso(c,f);
                for (int i=0;i<a;i++) //para cada arbol
                {
                    int cArbol=in.nextInt(); //leer columna arbol
                    int fArbol=in.nextInt(); //leer fila arbol
                    annadirArbol(cArbol-1, fArbol-1);
                }
                //generar la salida
                System.out.println(sombras);
            }
        } while (!esElCentinela);
    }
 
    /**
     * Bootstrapping para iniciar la aplicación.
     */
    public static void main(String[] args)
    {
        new SombrasEnElCamping().run();
    }
 
}
 
/*
 * La estrategia de resolución es muy directa:
 * Para cada caso, se crea un array bidimensional de enteros, del tamaño del
 * camping, formando una especie de "matriz"
 *
 * Se lee la posicion de cada arbol y se marcan las casillas que quedan en sombra
 * a su alrededor, contándolas a la vez que se marcan.
 * Hay que tener en cuenta, que si se lee un arbol y cae en una casilla en sombra,
 * hay una casilla en sombra menos disponible.
 * Hay que prestar atención a los rangos si un arbol cae en una casilla en los
 * límites del camping
 */

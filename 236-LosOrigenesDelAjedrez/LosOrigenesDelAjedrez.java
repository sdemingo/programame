/*


 */


import java.util.*;
 
public class LosOrigenesDelAjedrez
{
    public static void main(String[] ars)
    {
        boolean salir=false;
        Scanner in=new Scanner(System.in);
         
        long i1, i2, i3, r, anterior, casilla;
        do
	    {
		i1 = in.nextInt();
		i2 = in.nextInt();
		i3 = in.nextInt();
		in.nextLine();
             
		salir= (i1==0 && i2==0 && i3==0);
		if (!salir)
		    {
			casilla=i1;
			anterior=i1;
			r=casilla;
			for (int i=2; i<=i3; i++)
			    {
				casilla=anterior*i2;
				r+=casilla;
				anterior=casilla;
			    }
			System.out.println(r);
		    }
 
	    } while (!salir);
    }
}

import java.util.Scanner;
public class Main {

	static double modInv(double a, double m)
    {
        a = a % m;
        for (double x = 1; x < m; x++)
           if ((a * x) % m == 1)
              return x;
        return 1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double x,y,a,xi,xr = 0,yi, yr = 0, l,l1 = 0,g = 0,gi = 0,p,xn = 0,yn = 0,n;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter X Co-ordinate : ");
		x = in.nextDouble();
		System.out.println("Enter Y Co-ordinate : ");
		y = in.nextDouble();
		System.out.println("Enter 'a' value ");
		a = in.nextDouble();
		System.out.println("Enter 'p' value ");
		p = in.nextDouble();
		System.out.println("Enter 'n' value ");
		n = in.nextDouble();
		
		l = (((3*(x*x))+a)*(modInv(2*y, p)))%p;
		
		xi = ((l*l)-2*x);
		if(xi<0) {
			xr = (((xi % p) + p) % p);
		}else {
			xr = ((l*l)-2*x)%p;
		}
		yi = (((l*(x-xr))-y));
		if(yi<0) {
		yr = (((yi % p) + p) % p);
		}else {
			yr=(((l*(x-xr))-y))%p;
		}
		
		//p+q
		for(double j=2; j<=n-1; j++) {
		gi = ((yr-y)*(modInv(xr-x,p)));
		
		if(gi<0) {
			gi = (((gi % p) + p) % p);
			}else {
				gi = ((yr-y)*(modInv(xr-x,p)))%p;
			}
	
		xn = ((gi*gi)-x-xr);
		if(xn<0) {
			xn = (((xn % p) + p) % p);
		}else {
			xn = xn%p;
		}
		
		yn = (gi*(x-xn))-y;
		
		if(yn<0) {
		yn = (((yn % p) + p) % p);
		}else {
			yn=yn%p;
		}
		yr = yn;
		xr = xn;
		}
		
		System.out.println(n+"P = "+"("+xr+", "+yr+")");
	}

}

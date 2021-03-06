import java.math.*;
import java.util.*;

public class SeventyTwo
{
  private ArrayList<Integer> primes = Basic.sievePrimes(500000);
  private BigInteger Sum = new BigInteger("0");

  public SeventyTwo()
  {
    int c = 0;
    int d;
    ArrayList<Integer> phi = new ArrayList<Integer>();
    phi.add(2);

    c = primes.get(0);
    while(c < 1000000)
       c *= 2;

    c /= 2;

     while(c > -1)
     {
      d = (int)Math.pow(2, c);
      getNums(0, d, phi);//primeNum pos, the number it forms, and the numbers making it(for phi of n)
      c--;
    }//Do we need c to be sent? -- no

    System.out.println(Sum.toString());
  }

  private void getNums(int x, int d, ArrayList<Integer> phi)
  {
    int c = 0;
    x++;
    if(x < primes.size())
    {
      if(d*primes.get(x)>1000000)
      {
        for(int f = 0; f < phi.size(); f++)
          d *= (1-(1.0/phi.get(f)));

        Sum.add(new BigInteger("" + d));
      }
      else
      {
        getNums(x, d, phi);//unchanged except x is one higher
        while(d < 1000000)
        {
          c++;
          d *= primes.get(x);
        }

        c--;
        d /= primes.get(x);

        while(c > 0)
        {
          getNums(x, d, phi);
          c--;

        }
      }
    }
    else
    {
      double jenky = 1;
      for(int g = 0; g < phi.size(); g++)
        jenky *= (1 - 1.0/phi.get(g));

      Sum.add(new BigInteger("" + (int)(d * jenky)));
    }
  }
}

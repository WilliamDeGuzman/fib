import java.math.BigInteger;
import java.io.File;
import java.io.FileWriter;

class Main {
    public static void main (String[] args) {
        // System.out.println(fib("6999")); // works only up to 7000 and breaks because recursion
        // System.out.println(arrFib("1000000"));
        try {
            FileWriter fWriter = new FileWriter("c://Users/wdeg4/Desktop/fib1000000.txt");
            fWriter.write(arrFib("1000000").toString());
            fWriter.close();
        } catch (Exception e) {
            //cry
        }
    }
    public static BigInteger fib (String target) {
        return fib(new BigInteger(target));
    }
    public static BigInteger fib (BigInteger target) {
        if(target.equals(BigInteger.ZERO)) return BigInteger.ZERO;
        if(target.equals(BigInteger.ONE)) return BigInteger.ONE;
        return fib(target, BigInteger.valueOf(2L), BigInteger.ONE, BigInteger.ZERO);
    }

    private static BigInteger fib (BigInteger target, BigInteger iterations, BigInteger last, BigInteger prevLast) {
        BigInteger current = last.add(prevLast);
        // System.out.println(current + "@" + iterations + "/" + target);
        iterations = iterations.add(BigInteger.ONE);
        if (target.toString().equals(iterations.toString())) return current;
        return fib(target, iterations, current, last);
    }

    private static BigInteger arrFib (String target) {
        return arrFib(new BigInteger(target));
    }

    private static BigInteger arrFib (BigInteger target) {
        if(target.equals(BigInteger.ZERO)) return BigInteger.ZERO;
        if(target.equals(BigInteger.ONE)) return BigInteger.ONE;
        BigInteger current  = BigInteger.ZERO;
        BigInteger prev     = BigInteger.ONE;
        BigInteger prevLast = BigInteger.ZERO;
        for(BigInteger i = BigInteger.valueOf(2L); i.compareTo(target) <= 0; i = i.add(BigInteger.ONE)){
            current = prev.add(prevLast);
            prevLast = prev;
            prev = current;
        }
        return current;
    }
}
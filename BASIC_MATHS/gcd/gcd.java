package gcd;
public class gcd{
    private static int Gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;

        }
        return a;
    }
    public static void main(String[]args){
        System.out.println(Gcd(20,10));
    }
}
package armstrong;

public class armstrong {

    private static boolean isArmstrong(int num){
        int len=0;
        int dummy=num;
        while(dummy!=0){
            dummy=dummy/10;
            len++;
        }
        int total=0;
        dummy=num;
        while(dummy!=0){
            int dig=dummy%10;
            total+=dig*len;
        }
        return total==num;
    }
    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
    }
}

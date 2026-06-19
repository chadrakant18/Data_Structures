public class long_sub_given_sum_k{
    public static int solve(int nums[],int k){
        int n=nums.length;
        int pref=0;
        int j=0;
        int max=0;
        for(int i=0;i<n;i++){
            
            pref+=nums[i];
            while(pref>k){
                pref-=nums[j];
                j++;
            }
            if(pref==k){
                max=Math.max(max,i-j+1);
            }
        }
        return max;

    }
    public static void main(String[] args){
        int nums[]={10,5,2,7,1,9};
        System.out.println(solve(nums, 15));
    }
}
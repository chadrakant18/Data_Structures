package insertion_sort;

public class insertion_sort {

    private static void insertion(int arr[]){
        int n=arr.length;
        for(int i=1;i<n;i++){
            int curr=arr[i];
            int j=i-1;
            while(j>=0&&arr[j]>curr){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=curr;
        }
    }
    public static void main(String[] args) {
int arr[] = {5, 3, 4, 1, 2};

        System.out.println("Before Sorting:");

        for (int num : arr) {
            System.out.print(num + " ");
        }

        insertion(arr);

        System.out.println("\nAfter Sorting:");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
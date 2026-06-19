package selection_sort;

public class selection_sort {
    private static void selection(int arr[]){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int minIndex=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
    }
    public static void main(String[] args) {
        
        int arr[] = {64, 25, 12, 22, 11};

        System.out.println("Before Sorting:");

        for (int num : arr) {
            System.out.print(num + " ");
        }

        selection(arr);

        System.out.println("\nAfter Sorting:");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
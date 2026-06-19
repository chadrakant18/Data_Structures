package quick_sort;

public class quick_sort {
    public static quickSort(int arr[],int low,int high){
        while(low<high){
            int povitIndex=divide(arr,low,high);
            quickSort(arr,low,povitIndex-1);
            quickSort(arr,povitIndex+1,high);
        }
    }
    private int divide(int arr[],int low,int high){
        int pivot=arr[high];
        int i=low-1;
        while(pivot>arr[low]){
            i++;
            int temp=arr[i];
            arr[i]=arr[low];
            arr[low]=temp;
        }
    }
    public static void main(String[] args){

    }
}

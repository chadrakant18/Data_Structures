public class merge_sort {

    public static void mergeSort(int arr[], int low, int high) {
        if (low >= high) return; // base case

        int mid = (low + high) / 2;

        // divide
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        // merge
        merge(arr, low, mid, high);
    }

    private static void merge(int arr[], int low, int mid, int high) {

        int temp[] = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        // merge two sorted halves
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }

        // remaining left part
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // remaining right part
        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // copy back to original array
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 2, 4, 1, 3};

        mergeSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
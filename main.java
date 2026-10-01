import java.util.Arrays;

public class Main {

    static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int pivot = partition(arr, low, high);

        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);
    }

    static int partition(int[] arr, int low, int high) {
        int mid = (low + high) / 2;

        int temp = arr[mid];
        arr[mid] = arr[high];
        arr[high] = temp;

        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 9, 2, 5, 1, 8, 2, 4};

        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {7, 2, 9, 2, 5, 1, 8, 2, 4};

        quickSort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));

        System.out.println(binarySearch(arr, 5));
        System.out.println(lowerBound(arr, 2));
        System.out.println(upperBound(arr, 2));
    }
}

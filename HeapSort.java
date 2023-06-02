public class HeapSort {
    public static void main(String args[])
    {
        int array[] = {123, 1, 13, 11, 4, 9 , 18};
        int n = array.length;

        HeapSort ob = new HeapSort();
        ob.sort(array);

        System.out.println("Сортированный массив");
        printArray(array);
    }
    //Сортировка,перегруппировка кучи,нахождение корня
    public static void sort (int[] array){
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);
        for (int i=n-1; i>=0; i--)
        {

            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);

            
        }
    }
    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом
    //Нахождение нибольшего элемента- это корень
    //Нахождение левого и правого дочернего и сравнение с корнем
    //Рекурсивное преобразование поодерева
    public static void heapify(int array[], int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;


        if (l < n && array[l] > array[largest])
            largest = l;


        if (r < n && array[r] > array[largest])
            largest = r;

        if (largest != i)
        {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;


            heapify(array, n, largest);
        }
    }
    //Функция печати массива
    static void printArray(int array[])
    {
        int n = array.length;
        for (int i=0; i<n; ++i)
            System.out.print(array[i]+" ");
        System.out.println();
    }


}

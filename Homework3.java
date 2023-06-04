import java.util.Iterator;

public class Homework3 {

    public static void main(String[] args) {
        SingleLinkList<Laptop> laptopList = new SingleLinkList<>();

        laptopList.addToEnd(new Laptop(1, "Asus", "Vivobook 14X M1403QA-LY110"));
        laptopList.addToEnd(new Laptop(2, "Acer", "Aspire ES1-533"));
        laptopList.addToEnd(new Laptop(3, "MSI", "GF63 Thin 11UC-255XRU"));
        laptopList.addToEnd(new Laptop(4, "Azerty", "AZ-1509"));
        laptopList.addToEnd(new Laptop(5, "HP", "15-dy2046ms"));

        for (Object contact : laptopList) {
            System.out.println(contact);
        }
        laptopList.reverse();

        System.out.println("-------------------------------------");

        for (Object contact : laptopList) {
            System.out.println(contact);
        }
    }

    static class Laptop {

        int id;

        String manufacture;
        String model;

        public Laptop(int id, String manufacture, String model) {
            this.id = id;
            this.manufacture = manufacture;
            this.model = model;
        }

        @Override
        public String toString() {
            return "Laptop{" +
                    "id=" + id +
                    ", manufacture='" + manufacture + '\'' +
                    ", model='" + model + '\'' +
                    '}';
        }
    }

    public static class SingleLinkList<T> implements Iterable {

        ListItem<T> head;
        ListItem<T> tail;

        @Override
        public Iterator iterator() {
            return new Iterator<T>() {
                ListItem<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        private static class ListItem<T> {

            T data;
            ListItem<T> next;
        }

        //Проверка head на пустоту
        public boolean isEmpty() {
            return head == null;
        }

        //заполнение списка
        public void addToEnd(T item) {

            //Выделение памяти для списка
            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;

            //Если, голова и хвост пустая
            if (isEmpty()) {
                head = newItem;
                tail = newItem;
            } else { //Если, не пустая то передаём элементу адрес и ставим в хвост
                tail.next = newItem;
                tail = newItem;
            }
        }

        //метод разворота списка
        public void reverse() {
            if (!isEmpty() && head.next != null) {//Если голова не равна нулю
                tail = head;
                ListItem<T> current = head.next;
                head.next = null;
                while (current != null) {
                    ListItem<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}
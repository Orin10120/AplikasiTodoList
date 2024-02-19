public class AppTodoList {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowToDoList();
    }

    public static void showTodoList() {
        System.out.println("TODOLIST");
        for (var i = 0; i < model.length; i++) {
            String todo = model[i];
            var no = i + 1;

            if(todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTod0List() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Java Dasar : Aplikasi Todo List ";
        showTodoList();
    }

    public static void addTodoList(String todo){
        var penuh = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                penuh = false;
                break;
            }
        }

        if(penuh) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
        for (int i = 0; i < 25; i++) {
            addTodoList("contoh todo ke. " + i);
        }
        showTodoList();
    }

    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1) ; i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + ": ");
        String data = scanner.nextLine();
        return data;
    }

    public static void  testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    public static void viewShowToDoList() {
        while (true) {
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if (input.equals("1")) {
                viewAddToDoList();
            } else if (input.equals("2")) {
                viewRemoveToDoList();
            } else  if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan Tidak ditemukan");
            }
        }
    }

    public static void  testViewTodoList() {
        addTodoList("Satu");
        addTodoList("dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowToDoList();
    }

    public static void viewRemoveToDoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yang dihapus(x jika Batal)");

        if (number.equals("x")) {
            //batal
        } else {
          boolean succes =  removeTodoList(Integer.valueOf(number));
          if (!succes) {
              System.out.println("Gagal menghapus todolist : " + number);
          }
        }
    }

    public static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("dua");
        addTodoList("Tiga");

        showTodoList();

        viewRemoveToDoList();

        showTodoList();
    }

    public static void viewAddToDoList() {
        System.out.println("Menambah TODOLIST");

        var todo = input("Todo(x jika Batal)");

        if(todo.equals("x")){
            //Batal
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        addTodoList("Satu");

        viewAddToDoList();

        showTodoList();
    }
}



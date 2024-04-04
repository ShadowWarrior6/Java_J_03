import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Разработайте класс Student с полями String name, int age, 
 * transient double GPA (средний балл).
Обеспечьте поддержку сериализации для этого класса.
Создайте объект класса Student и инициализируйте его данными.
Сериализуйте этот объект в файл.
Десериализуйте объект обратно в программу из файла.
Выведите все поля объекта, включая GPA, и ответьте на вопрос,
почему значение GPA не было сохранено/восстановлено.
 */

public class Main{
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        Student student=new Student("Max", 21, 75);
        System.out.println("Name:" + student.getName());
        System.out.println("Age:" + student.getAge());
        System.out.println("GPA:" + student.getGPA());
        System.out.println();

       try(FileOutputStream fileOutputStream=new FileOutputStream("Student.bin");
        ObjectOutputStream out=new ObjectOutputStream(fileOutputStream)){
            out.writeObject(student);
            System.out.println("Обьект студент сериализован ");
        }
        try(FileInputStream fileInputStream=new FileInputStream("Student.bin");
       ObjectInputStream in =new ObjectInputStream(fileInputStream)){
        student=(Student)in.readObject();
        System.out.println("Обьект студент десериализован" );
        }
        System.out.println("Name:"+ student.getName() );
        System.out.println("Age:"+student.getAge());
        System.out.println("GPA:"+ student.getGPA());
        System.out.println("Поля классов, помеченные как transient: такие поля \r\n" + //
                        "Не могут быть сериализованы");
    }    
}    

package fr.dawan.reflexion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws Exception{
        //reflexion / introspection : mecanisme qui permet d extraire des informations relatives à un objet  (type, champs et de pouvoir appeler ses methode dynamiquement

        Employe emp = new Employe("riri","fifi");

        //obtenir le type a partir d un objet
        Class<?> classEmp = emp.getClass();
        System.out.println("classEmp : "+ classEmp);

        System.out.println("------------------- METHODE DE LA CLASSE EMPLOYE -----------------------");

        Method[] methods = classEmp.getMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
        }


        System.out.println("------------------- ATTRIBUTS DE LA CLASSE EMPLOYE -----------------------");

        Field[] fields = classEmp.getDeclaredFields();

        for(Field field : fields) {
            System.out.println(field.getName());
        }


        System.out.println("-------------------INVOQUER LA METHODE IDENTITE -----------------------");

        Method methodIdentite = classEmp.getMethod("identite");
        methodIdentite.invoke(emp);

        System.out.println("-------------------INSTANCIER DYNAMIQUEMENT LA CLASSE -----------------------");

        Employe instance = (Employe)classEmp.getDeclaredConstructor().newInstance(); // appel constructeur sans parametre
        methodIdentite.invoke(instance);

        Constructor<?> constructor = classEmp.getConstructor(String.class, String.class);

        Employe instance2 = (Employe)constructor.newInstance("fifi","riri");
        methodIdentite.invoke(instance2);
    }
}

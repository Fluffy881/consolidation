package fr.dawan.apistream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=================   STREAM API   ==================");

        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");

        System.out.println("StreamFromValues : " + streamFromValues.toList());

        //stream from array

        String[] array = {"a1", "a2", "a3"};
        Stream<String> streamFromArray = Arrays.stream(array);

        System.out.println("StreamFromArray : " + streamFromArray.toList());

        //stream from file
        File file = new File("myfile.tmp");

        PrintWriter pw = new PrintWriter(file);

        pw.println("a1");
        pw.println("a2");
        pw.println("a3");

        pw.close();

        try (Stream<String> streamFromFile = Files.lines(Paths.get(file.getAbsolutePath()))) {

            System.out.println("StreamFromFile : " + streamFromFile.toList());
        }

        //stream from collection

        List<String> collection = List.of("a1", "a2", "a3");
        Stream<String> streamFromCollection = collection.stream();

        System.out.println("StreamFromCollection : " + streamFromCollection.toList());

        System.out.println("\n==================   FILTER   ====================\n");

        collection = List.of("a1","a2","a3","a1","a1");

        long nbA1 = collection.stream().filter("a1"::equals).count();
        System.out.println("nb a1 : " + nbA1);

        List<String> chainesWithA1 = collection.stream().filter("a"::contains).toList();
        System.out.println("chainesWithA1 : "+ chainesWithA1);

        List<People> peoples = new ArrayList<People>();

        peoples.add(new People("William", 16, Sex.MAN));
        peoples.add(new People("John", 26, Sex.MAN));
        peoples.add(new People("Helene", 42, Sex.WOMAN));
        peoples.add(new People("Peter", 69, Sex.MAN));

        // liste des hommes entre 18 et 27 ans
        peoples.stream().filter(p -> p.getAge() >= 16 && p.getAge() <= 27 && p.getSex() == Sex.MAN ).toList().forEach(System.out::println);

        //nombre des individu entre 18 et 60 pour les hommes et 55 ans pour les femmes
        long nbPeopleAtWork = peoples
                                .stream()
                                .filter(p -> p.getAge() >= 18)
                                .filter(p -> (p.getAge() <= 60 && p.getSex() == Sex.MAN) || (p.getAge() <= 55 && p.getSex() == Sex.WOMAN))
                                .count();

        System.out.println("nbPeopleAtWork : " + nbPeopleAtWork);


        System.out.println("\n==================   .MAP   ====================\n");

        // .map permet d appliquer un traitement a chaque element et retourne un nouveau stream
        List<PeopleDto> dtos = peoples.stream().map(p -> new PeopleDto(p.getName(), p.getAge())).toList();
        dtos.forEach(System.out::println);

        //pagination

        peoples.stream().skip(1).limit(2).forEach(System.out::println);

        //distinct
        collection.stream().distinct().forEach(System.out::println); // un seul a1

        System.out.println("\n==================   .AnyMATCH / .ALLMATCH / .NONMATCH   ====================\n");

        boolean anyMatch = collection.stream().anyMatch(s -> s.equals("a1"));
        System.out.println("anymatch : " + anyMatch );

        System.out.println("allmatch : " + collection.stream().allMatch(s -> s.contains("a")));
        System.out.println("nonematch : " + collection.stream().noneMatch(s -> s.contains("b")));

        System.out.println("\n==================   .sorted   ====================\n");

        collection.stream().sorted().forEach(System.out::println);
        System.out.println("---------------");
        collection.stream().sorted().distinct().forEach(System.out::println);
        System.out.println("---------------");
        collection.stream().sorted((s1, s2) -> -s1.compareTo(s2)).forEach(System.out::println); // trie par ordre decroissant

        System.out.println("\n==================   .max   ====================\n");

        String max = collection.stream().max(String::compareTo).get();
        System.out.println("max : " + max );

        String min = collection.stream().min(String::compareTo).get();
        System.out.println("min : " + min );

        People oldest = peoples.stream().max((p1, p2) -> ((Integer)p1.getAge()).compareTo(((Integer)p2.getAge()))).get();
        System.out.println("oldest : "+ oldest);

        People youngest = peoples.stream().min((p1, p2) -> ((Integer)p1.getAge()).compareTo(((Integer)p2.getAge()))).get();
        System.out.println("youngest : "+ youngest);

    }
}

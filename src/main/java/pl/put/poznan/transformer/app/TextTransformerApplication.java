package pl.put.poznan.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.transformer.models.Building;
import pl.put.poznan.transformer.models.Floor;
import pl.put.poznan.transformer.models.Room;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class TextTransformerApplication {

    public static void main(String[] args) {

        SpringApplication.run(TextTransformerApplication.class, args);
        //najpierw tworzymy pokoje
        Room r1 = new Room(1,"b1",12,10,1.2f,10.8f);
        Room r2 = new Room(2, "b1", 1,2,3,4);
        Room r3 = new Room(3,"b1",21,30,5,8);

        //potem dodajemy je do listy, ktora posluzy nam do utworzenia pietra
        //jedna lista na jedno pietro
        List<Room> roomsListA= new ArrayList<Room>();
        roomsListA.add(r1);
        roomsListA.add(r2);
        List<Room> roomsListB = new ArrayList<Room>();
        roomsListB.add(r3);

        //nastepnie tworzymy pietra
        Floor f1 = new Floor(4,"b1",roomsListA);
        Floor f2 = new Floor(5,"b1",roomsListB);

        //podobnie jak przy pokojach dodajemy je do list, jedna dla kazdego budynku
        List<Floor> floorsList = new ArrayList<Floor>();
        floorsList.add(f1);
        floorsList.add(f2);

        //na koncu tworzymy budynek
        Building b1 = new Building(6, "b1", floorsList);

        System.out.println(Float.toString(b1.getLight()));
        System.out.println(Float.toString(b1.getCube()));
        System.out.println(Float.toString(b1.getLightPerUnit()));

        List<Room> rooms = b1.getHeatingOverLimit(0.2f);
        for (Room tRoom : rooms){
            System.out.println(Integer.toString(tRoom.getId()));
        }
    }

    //wszystkie funkcje nazywaja sie tak samo dla kazdej klasy i w zaleznosci z ktorego obiektu sie je wywola daja inny efekt
    //np getArea() dla pokoju zwroci po prostu powierzchnie pokoju, ale dla budynku poda juz laczna sume wszystkich pokojow w budynku itd
    //funkcja getHeatingOverLimit(float limit) zwraca liste pokojow jako liste obiektow typu Room, mozna uzyc na obiekcie kazdej klasy, ale nawet w przypadku pojedynczego pokoju bedzie to lista, wiec trzeba o tym pamietac
    //potem mozna wyswietlic id lub nazwe tych pokojow tak jak zrobilem to w linijkach 49-51
    //najwazniejsze jest to zeby tworzyc obiekty w kolejnosci: pokoje -> pietra -> budynki

}

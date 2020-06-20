package Common;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CreatePerson implements Serializable {

    public Ticket create(){
        Ticket t = new Ticket();
        Ticket.Person person = t.new Person();
        Ticket.Location location = t.new Location();
        person.setPassportID();
        this.setHairColor(person);
        this.setNationality(person);
        this.setCoordinateXForLocation(location);
        this.setCoordinateYForLocation(location);
        this.setLocationName(location);
        person.setLocation(location);
        t.setPerson(person);
        return t;
    }
    public void setHairColor(Ticket.Person person){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите цвет волос человека(GREEN,BLACK,DARKBROWN,BLUE)");
            System.out.print("$ ");
            String hairColor = scanner.nextLine();
            if (hairColor.equals("")||hairColor.equals(null)){
                System.out.println("Значение не может быть нулевым, попробуйте ещё раз.");
                this.setHairColor(person);
            } else if (hairColor.equals("GREEN")||hairColor.equals("BLACK")||hairColor.equals("DARKBROWN")||hairColor.equals("BLUE"))
                person.setHairColor(Ticket.Color.valueOf(hairColor));
            else this.setHairColor(person);
        }
        catch (InputMismatchException e){
            System.out.println("Значение не подходит, введите значение заново.");
            this.setHairColor(person);
        }
    }
    public void setNationality(Ticket.Person person){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите национальность человека(RUSSIA,UNITED_KINGDOM,FRANCE,NORTH_KOREA,JAPAN)");
            System.out.print("$ ");
            String country = scanner.nextLine();
            if (country.equals("")||country.equals(null)){
                System.out.println("Значение не может быть нулевым, попробуйте ещё раз.");
                this.setNationality(person);
            } else if (country.equals("RUSSIA")||country.equals("UNITED_KINGDOM")||country.equals("FRANCE")||country.equals("NORTH_KOREA")||country.equals("JAPAN"))
                person.setNationality(Ticket.Country.valueOf(country));
            else this.setNationality(person);
        }
        catch (InputMismatchException e){
            System.out.println("Значение не подходит, введите значение заново.");
            this.setNationality(person);
        }
    }
    public void setCoordinateXForLocation(Ticket.Location location) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите координату x");
            System.out.print("$ ");
            String x = scanner.nextLine();
            int xn = Integer.parseInt(x);
            if (x.equals("") || x.equals(null)) {
                System.out.println("Значение не может отсутствовать, попробуйте ещё раз.");
                this.setCoordinateXForLocation(location);
            } else location.setX(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"integer\". Введите значение заново");

            this.setCoordinateXForLocation(location);
        }
    }
    public void setCoordinateYForLocation(Ticket.Location location) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите координату y");
            System.out.print("$ ");
            String y = scanner.nextLine();
            if (y.equals("") || y.equals(null)) {
                System.out.println("Значение не может быть нулевым, попробуйте ещё раз.");
                this.setCoordinateYForLocation(location);
            } else {
                double yn = Double.parseDouble(y);
                location.setY(yn);
            }

        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"double\". Введите значение заново.");
            this.setCoordinateYForLocation(location);
        }
    }


    public void setLocationName(Ticket.Location location){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя локации");
            System.out.print("$ ");
            String name = scanner.nextLine();
            if (name.equals("")||name.equals(null)){
                System.out.println("Значение не может быть нулевым, попробуйте ещё раз.");
                this.setLocationName(location);
            } else location.setName(name);
        }
        catch (InputMismatchException | NumberFormatException e){
            System.out.println("Значение должно быть типа:\"string\". Введите значение заново.");
            this.setLocationName(location);
        }

    }



}

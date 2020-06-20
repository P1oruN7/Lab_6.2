package Common;

import java.util.Set;
import java.util.TreeMap;

/**
 * The type Common.Decoder.
 */
public class Decoder {
    /**
     * Sets key for insert and update.
     *
     * @param keyForInsertAndUpdate the key for insert and update
     */
    public static void setKeyForInsertAndUpdate(Long keyForInsertAndUpdate) {
        Decoder.keyForInsertAndUpdate = keyForInsertAndUpdate;
    }

    private static Long keyForInsertAndUpdate=(long)0;

    /**
     * Gets last key.
     *
     * @return the last key
     */
    public static Long getLastKey() {
        Long lastKey =(long) 0;
        TicketCollection ticketCollection = new TicketCollection();
        if(ticketCollection.getSize()>0){
        Set keyset = ticketCollection.getKeySet();
        for (Object key : keyset) {
            lastKey= (Long) key;
        }
    }
        return lastKey;
    }

    /**
     * Decode into collection tree map.
     *
     * @param s the String of collection
     * @return the tree map
     */
    public static TreeMap decodeIntoCollection(String s) {
        TreeMap<Long, Ticket> collection = new TreeMap<>();
        String errorMessage="В ходе заполнения коллекции возникли следующие ошибки:\n";
        if (s.length()>0){
        String a[] = s.split("\n");
        Long mapKey = Decoder.getLastKey()+1;
        for(int i=0;i<a.length;i++) {
            String b[] = a[i].split(",");
            Ticket ticket = new Ticket();
            if (keyForInsertAndUpdate>0){ticket.setMapKey(keyForInsertAndUpdate);}
            else ticket.setMapKey(mapKey++);
            Ticket.Coordinates coordinates = ticket.new Coordinates();
            Ticket.Person person = ticket.new Person();
            Ticket.Location location = ticket.new Location();
            try {
                if (b[0].equals("") || b[0] == null) {
                    throw new Exception();
                } else ticket.setName(b[0]);
            }
            catch (Exception e){
                System.out.print(errorMessage);
                errorMessage = "";
                System.out.println("Некорректно указано имя у билета №" + ticket.getMapKey() + ",изменено на Name,можете исправить с помощью команды update_by_key.");
                ticket.setName("Name");
            }

            try {
                if (b[1].equals("") || b[1] == null || (Long.parseLong(b[1]) >= 297)) {
                    throw new Exception();
                } else coordinates.setX(Long.parseLong(b[1]));
            }
            catch (Exception e){
                System.out.print(errorMessage);
                errorMessage = "";
                System.out.println("Некорректно указана координата Х у билета №" + ticket.getMapKey() + ",изменено на 0,можете исправить с помощью команды update_by_key.");
                coordinates.setX((long) 0);
            }

            try {
                if (b[2].equals("") || b[2] == null) {
                    throw new Exception();
                } else coordinates.setY(Integer.parseInt(b[2]));
            }
            catch (Exception e){
                System.out.print(errorMessage);
                errorMessage = "";
                System.out.println("Некорректно указана координата Y у билета №" + ticket.getMapKey() + ",изменено на 0,можете исправить с помощью команды update_by_key.");
                coordinates.setY(0);
            }

            ticket.setCoordinates(coordinates);

            try {
                if (b[3].equals("") || b[3] == null || (Float.parseFloat(b[1]) <= 0)) {
                    throw new Exception();
                } else ticket.setPrice(Float.parseFloat(b[3]));
            }
            catch (Exception e){
                System.out.print(errorMessage);
                errorMessage = "";
                System.out.println("Некорректно указана цена у билета №" + ticket.getMapKey() + ",изменено на 1,можете исправить с помощью команды update_by_key.");
                ticket.setPrice((float) 1);
            }

            try {
                if (b[4].equals("") || b[4] == null) {
                    throw new Exception();
                } else ticket.setComment(b[4]);
            }
            catch (Exception e){
                System.out.print(errorMessage);
                errorMessage = "";
                System.out.println("Некорректно указан комментарий у билета №" + ticket.getMapKey() + ",изменено на StandartKomment,можете исправить с помощью команды update_by_key.");
                ticket.setComment("StandartKomment");
            }

            try {
                ticket.setType(Ticket.TicketType.valueOf(b[5]));
            }
            catch (Exception e){
                System.out.print(errorMessage);
                errorMessage = "";
                System.out.println("Некорректно указан Тип Билета у билета №" + ticket.getMapKey() + ",изменено на USUAL,можете исправить с помощью команды update_by_key.");
                ticket.setType(Ticket.TicketType.USUAL);
            }

            try {
                person.setHairColor(Ticket.Color.valueOf(b[6]));
            }
            catch (Exception e){
                System.out.print(errorMessage);
                errorMessage = "";
                System.out.println("Некорректно указан Цвет Волос у человека с билетом №" + ticket.getMapKey() + ",изменено на BLACK,можете исправить с помощью команды update_by_key.");
                person.setHairColor(Ticket.Color.BLACK);
            }
            try {
                person.setNationality(Ticket.Country.valueOf(b[7]));
            }
            catch (Exception e){
                System.out.print(errorMessage);
                errorMessage = "";
                System.out.println("Некорректно указана Национальность у человека билетом №" + ticket.getMapKey() + ",изменено на RUSSIA,можете исправить с помощью команды update_by_key.");
                person.setNationality(Ticket.Country.RUSSIA);
            }
            person.setPassportID();

            try {
                if (b[8].equals("") || b[8] == null) {
                    throw new Exception();
                } else location.setX(Integer.parseInt(b[8]));
            }
            catch (Exception e){
                System.out.print(errorMessage);
                errorMessage = "";
                System.out.println("Некорректно указана координата X у локации у билета №" + ticket.getMapKey() + ",изменено на 0,можете исправить с помощью команды update_by_key.");
                location.setX(0);
            }

            try {
                if (b[9].equals("") || b[9] == null) {
                    throw new Exception();
                } else location.setY(Double.parseDouble(b[9]));
            }
            catch (Exception e){
                System.out.print(errorMessage);
                errorMessage = "";
                System.out.println("Некорректно указана координата Y у локации у билета №" + ticket.getMapKey() + ",изменено на 0,можете исправить с помощью команды update_by_key.");
                location.setY((double) 0);
            }
            try {
                if (b[10].equals("") || b[10] == null) {
                    throw new Exception();
                } else location.setName(b[10]);
            }
            catch (Exception e){
                System.out.print(errorMessage);
                errorMessage = "";
                System.out.println("Некорректно указано Имя у локации у билета №" + ticket.getMapKey() + ",изменено на Name,можете исправить с помощью команды update_by_key.");
                location.setName("Name");
            }
            person.setLocation(location);
            ticket.setPerson(person);
            ticket.setCreationDate();

            collection.put(ticket.getMapKey(), ticket);
        }
        }
        return collection;
        }



    }


package Common;

import Utility.ServerSender;

import java.util.Set;
import java.util.TreeMap;

/**
 * The type Common.Decoder.
 */
public class Decoder{
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
     public static String errorMessage="В ходе заполнения коллекции возникли следующие ошибки:\n";
    /**
     * Decode into collection tree map.
     *
     * @param s the String of collection
     * @return the tree map
     */
    public static TreeMap decodeIntoCollection(String s) {
        TreeMap<Long, Ticket> collection = new TreeMap<>();

        if (s.length()>0){
        String a[] = s.split("\n");
        Long mapKey =Decoder.getLastKey()+1;
        for(int i=0;i<a.length;i++) {
            String b[] = a[i].split(",");
            Ticket ticket = new Ticket();
            if (keyForInsertAndUpdate>0){ticket.setMapKey(keyForInsertAndUpdate);keyForInsertAndUpdate=(long)0;}
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
                errorMessage+=("Некорректно указано имя у билета №" + ticket.getMapKey() + ",изменено на Name,можете исправить с помощью команды update_by_key.\n");
                ticket.setName("Name");
            }

            try {
                if (b[1].equals("") || b[1] == null || (Long.parseLong(b[1]) >= 297)) {
                    throw new Exception();
                } else coordinates.setX(Long.parseLong(b[1]));
            }
            catch (Exception e){
                errorMessage+=("Некорректно указана координата Х у билета №" + ticket.getMapKey() + ",изменено на 0,можете исправить с помощью команды update_by_key.\n");
                coordinates.setX((long) 0);
            }

            try {
                if (b[2].equals("") || b[2] == null) {
                    throw new Exception();
                } else coordinates.setY(Integer.parseInt(b[2]));
            }
            catch (Exception e){
                errorMessage+=("Некорректно указана координата Y у билета №" + ticket.getMapKey() + ",изменено на 0,можете исправить с помощью команды update_by_key.\n");
                coordinates.setY(0);
            }

            ticket.setCoordinates(coordinates);

            try {
                if (b[3].equals("") || b[3] == null || (Float.parseFloat(b[1]) <= 0)) {
                    throw new Exception();
                } else ticket.setPrice(Float.parseFloat(b[3]));
            }
            catch (Exception e){
                errorMessage+=("Некорректно указана цена у билета №" + ticket.getMapKey() + ",изменено на 1,можете исправить с помощью команды update_by_key.\n");
                ticket.setPrice((float) 1);
            }

            try {
                if (b[4].equals("") || b[4] == null) {
                    throw new Exception();
                } else ticket.setComment(b[4]);
            }
            catch (Exception e){
                errorMessage+=("Некорректно указан комментарий у билета №" + ticket.getMapKey() + ",изменено на StandartKomment,можете исправить с помощью команды update_by_key.\n");
                ticket.setComment("StandartKomment");
            }

            try {
                ticket.setType(Ticket.TicketType.valueOf(b[5]));
            }
            catch (Exception e){
                errorMessage+=("Некорректно указан Тип Билета у билета №" + ticket.getMapKey() + ",изменено на USUAL,можете исправить с помощью команды update_by_key.\n");
                ticket.setType(Ticket.TicketType.USUAL);
            }

            try {
                person.setHairColor(Ticket.Color.valueOf(b[6]));
            }
            catch (Exception e){
                errorMessage+=("Некорректно указан Цвет Волос у человека с билетом №" + ticket.getMapKey() + ",изменено на BLACK,можете исправить с помощью команды update_by_key.\n");
                person.setHairColor(Ticket.Color.BLACK);
            }
            try {
                person.setNationality(Ticket.Country.valueOf(b[7]));
            }
            catch (Exception e){
                errorMessage+=("Некорректно указана Национальность у человека билетом №" + ticket.getMapKey() + ",изменено на RUSSIA,можете исправить с помощью команды update_by_key.\n");
                person.setNationality(Ticket.Country.RUSSIA);
            }
            person.setPassportID();

            try {
                if (b[8].equals("") || b[8] == null) {
                    throw new Exception();
                } else location.setX(Integer.parseInt(b[8]));
            }
            catch (Exception e){
                errorMessage+=("Некорректно указана координата X у локации у билета №" + ticket.getMapKey() + ",изменено на 0,можете исправить с помощью команды update_by_key.\n");
                location.setX(0);
            }

            try {
                if (b[9].equals("") || b[9] == null) {
                    throw new Exception();
                } else location.setY(Double.parseDouble(b[9]));
            }
            catch (Exception e){
                errorMessage+=("Некорректно указана координата Y у локации у билета №" + ticket.getMapKey() + ",изменено на 0,можете исправить с помощью команды update_by_key.\n");
                location.setY((double) 0);
            }
            try {
                if (b[10].equals("") || b[10] == null) {
                    throw new Exception();
                } else location.setName(b[10]);
            }
            catch (Exception e){
                errorMessage+=("Некорректно указано Имя у локации у билета №" + ticket.getMapKey() + ",изменено на Name,можете исправить с помощью команды update_by_key.\n");
                location.setName("Name");
            }
            person.setLocation(location);
            ticket.setPerson(person);
            ticket.setCreationDate();
            collection.put(ticket.getMapKey(), ticket);

        }
        }
        if (errorMessage.equals("В ходе заполнения коллекции возникли следующие ошибки:\n")) {
            errorMessage="";
        }
        return collection;
        }



    }


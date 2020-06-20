package Utility;
import Common.Ticket;
import Common.TicketCollection;

import java.io.*;
import java.util.Iterator;
import java.util.Map;

/**
 * The type Utility.Save in file.
 */
public class SaveInFile {
    private Thread backgroundReaderThread = null;
    /**
     * Saving.
     *
     * @param path the path
     * @throws IOException the io exception
     */
    public void Saving(String path) throws IOException {
        try {
            TicketCollection ticketCollection = new TicketCollection();
            Iterator it = ticketCollection.getTickets().entrySet().iterator();
            OutputStream outputStream = new FileOutputStream(new File(path));
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String ticketInfo = ((Ticket) entry.getValue()).getCsvTicket();
                outputStreamWriter.write(ticketInfo + "\n");
            }
            outputStreamWriter.close();
        }
        catch (NullPointerException | FileNotFoundException e){
            System.out.println("");
        }
        }
    public void checkForSaveCommand() throws IOException {
        backgroundReaderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                    while (!Thread.interrupted()) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.equalsIgnoreCase("save")){
                            Save s =new Save();
                            s.execute(null);
                        };
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundReaderThread.setDaemon(true);
        backgroundReaderThread.start();
    }


}

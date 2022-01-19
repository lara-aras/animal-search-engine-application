/*
 * Filename: Client.java
 * Author: Lara Aras
 * Created: 04/10/2021
 * Operating System: Windows 10 Enterprise
 * Version: Project 1
 * Description: This file contains the functionality for sending requests to
 *              the server.
 */
package animalsearchengine;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.stream.*;
import javax.swing.*;
import java.net.*;

/**
 * Class used to communicate with server and send data back to the application.
 *
 * @author Lara Aras
 */
public class Client {

    private Socket clientSocket;
    private ObjectOutputStream objOutputStream;
    private BufferedReader bufferedReader;

    /**
     * Version: Project 1
     * <p>
     * Date: 04/10/2021
     * <p>
     * Sends request to server and returns response to calling method.
     *
     * @author Lara Aras
     * @param request
     * @return response
     */
    public String sendRequest(HashMap request) {
        String response = "";

        try {
            /* Open client socket to make connection with server at port 16000 */
            clientSocket = new Socket("127.0.0.1", 16000);

            /* Create object output stream to send HashMap containing 
               request to server */
            objOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

            /* Create input stream to receive response from server */
            bufferedReader = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));

            /* Send map with request data to server */
            objOutputStream.writeObject(request);

            /* Collect all lines from input stream into response variable */
            response = bufferedReader.lines().collect(Collectors.joining(
                    System.lineSeparator()));

            /* Close streams and socket */
            bufferedReader.close();
            objOutputStream.close();
            clientSocket.close();
        } catch (IOException e) {
            if (e instanceof ConnectException) {
                JOptionPane.showMessageDialog(null, "The server is not "
                        + "currently running. Please start the server and try "
                        + "again.", "Error", JOptionPane.ERROR_MESSAGE
                );
                
                response = "server off";
            } else {
                JOptionPane.showMessageDialog(null, "An error has occured:\n"
                        + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE
                );
            }
        }

        /* Return response to calling method */
        return response;
    }

    /**
     * Version: Project 1
     * <p>
     * Date: 07/10/2021
     * <p>
     * Gets all animals in the database to populate form fields when updating
     * and deleting animals in the database admin GUI.
     *
     * @author Lara Aras
     * @return animals
     * @throws IOException
     */
    public String[][] getAnimalsForForms() throws IOException {
        /* Open client socket to make connection with server at port 16000 */
        clientSocket = new Socket("127.0.0.1", 16000);

        /* Create object output stream to send HashMap containing 
               request to server */
        objOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

        /* Create input stream to receive response from server */
        bufferedReader = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));

        HashMap request = new HashMap();
        request.put("action", "getanimals");

        /* Send map with request data to server */
        objOutputStream.writeObject(request);

        /* Collect all lines from input stream into response variable */
        String response = bufferedReader.lines().collect(Collectors.joining(
                System.lineSeparator()));

        String[][] animals = buildRowsArray(response);

        /* Close streams and socket */
        bufferedReader.close();
        objOutputStream.close();
        clientSocket.close();

        return animals;
    }

    /**
     * Version: Project 1
     * <p>
     * Date: 07/10/2021
     * <p>
     * Gets all species in the database to populate form fields when updating
     * species and creating new animals in the database admin GUI.
     *
     * @author Lara Aras
     * @return
     * @throws IOException
     */
    public String[][] getSpeciesForForms() throws IOException {
        /* Open client socket to make connection with server at port 16000 */
        clientSocket = new Socket("127.0.0.1", 16000);

        /* Create object output stream to send HashMap containing 
               request to server */
        objOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

        /* Create input stream to receive response from server */
        bufferedReader = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));

        HashMap request = new HashMap();
        request.put("action", "getspecies");

        /* Send map with request data to server */
        objOutputStream.writeObject(request);

        /* Collect all lines from input stream into response variable */
        String response = bufferedReader.lines().collect(Collectors.joining(
                System.lineSeparator()));

        String[][] species = buildRowsArray(response);

        /* Close streams and socket */
        bufferedReader.close();
        objOutputStream.close();
        clientSocket.close();

        return species;
    }

    /**
     * Version: Project 1
     * <p>
     * Date: 07/10/2021
     * <p>
     * Builds array from the response string returned by the server.
     *
     * @author Lara Aras
     * @return
     * @throws IOException
     */
    private String[][] buildRowsArray(String rowsString) {
        /* Split response string into rows by ":" delimeter */
        String[] resultRows = rowsString.split(":");

        /* Create array to hold table rows that is the same length as the 
               number of search results */
        String[][] rows = new String[resultRows.length][1];
        int i = 0;
        for (String row : resultRows) {
            /* Split row string into columns by "@" delimeter and add the 
                   resulting array to the rows array */
            String[] columns = row.split("@");
            rows[i] = columns;
            i++;
        }

        return rows;
    }
}

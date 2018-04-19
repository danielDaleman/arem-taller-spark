/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.taller.arem.spark;

import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import static spark.Spark.*;

/**
 *
 * @author danie
 */
public class Main {
    
    public static void main(String[] args) throws MalformedURLException {        
        staticFileLocation("/static");
        port(8080);
        init();        
        get("/respuesta", (request, response) -> {
            System.out.println("BOOOOOM");
            Integer value = Integer.parseInt(request.queryParams("num"));
            URL link = new URL("https://7bffw7yff0.execute-api.us-west-2.amazonaws.com/arem/cuadrado?num=" + value);
            String res = "";
            try (BufferedReader reader
                    = new BufferedReader(new InputStreamReader(link.openStream()))) {
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    res += inputLine;
                }
            } catch (IOException x) {
                System.err.println(x);
            }
            
            return res;
        });
        
    }
    
}

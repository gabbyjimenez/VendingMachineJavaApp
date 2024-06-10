package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {

    private String fileName = "Log.txt";

    public void writeToLog(String logEntry) {

        File logFile = new File(fileName);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = dateTimeFormatter.format(now);


        try {

            if(!logFile.exists()){
                logFile.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(logFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(formattedDate + ": " + logEntry);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();


        }
        catch (Exception e) {

        }

    }



}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Common.Library;
import Model.CSVFile;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author tuanh
 */
public class CSVFileDAO {
private static CSVFileDAO instance = null;
    private final String COMMA_DELIMITER = ",";
    private final String NEW_LINE_SEPARATOR = "\n";
    Library l;

    public CSVFileDAO() {
        l = new Library();
    }

    public static CSVFileDAO Instance() {
        if (instance == null) {
            synchronized (CSVFileDAO.class) {
                if (instance == null) {
                    instance = new CSVFileDAO();
                }
            }
        }
        return instance;
    }

    public void formatName(ArrayList<CSVFile> ls) {
        if (ls.isEmpty()) {
            System.out.println("No data");
        } else {
            for (int i = 0; i < ls.size(); i++) {
                String name = ls.get(i).getName().trim();
                name = name.toLowerCase().replaceAll("\\s+", ",");
                String[] arr = name.split(",");
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < arr.length; j++) {
                    sb.append(Character.toUpperCase(arr[j].charAt(0)))
                            .append(arr[j].substring(1)).append(" ");
                }
                ls.get(i).setName(sb.toString().trim());
            }
            System.err.println("Format: Done");
        }
    }

    public void formatAddress(ArrayList<CSVFile> ls) {
        if (ls.isEmpty()) {
            System.out.println("No data");
        } else {
            for (int i = 0; i < ls.size(); i++) {
                String address = ls.get(i).getAddress().trim();
                address = address.toLowerCase().replaceAll("\\s+", ",");
                String[] arr = address.split(",");
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < arr.length; j++) {
                    sb.append(Character.toUpperCase(arr[j].charAt(0)))
                            .append(arr[j].substring(1)).append(" ");
                }
                ls.get(i).setAddress(sb.toString().trim());
            }
            System.err.println("Format: Done");
        }
    }

    public void importFile(ArrayList<CSVFile> ls) {
        String line = "";
        BufferedReader fileReader = null;
        l.checkInputPathFile("Enter Path: ");
        String fileName = l.getString("Enter File Name: ");
        
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            while ((line = fileReader.readLine()) != null) {
                String[] splitCSV = line.split(COMMA_DELIMITER);
                ls.add(new CSVFile(Integer.parseInt(splitCSV[0]), splitCSV[1],
                        splitCSV[2], splitCSV[3], splitCSV[4]));

            }
            System.err.println("Import: Done");
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        } catch (IOException e) {
            System.out.println("adfs");
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void exportFile(ArrayList<CSVFile> ls) {
        if (ls.isEmpty()) {
            System.out.println("No data");
        } else {
            FileWriter fileWriter = null;
            l.checkInputPathFile("Enter Path: ");
            String fileName = l.getString("Enter File Name");
            try {
                fileWriter = new FileWriter(fileName);
                for (CSVFile listCSV : ls) {
                    fileWriter.append(String.valueOf(listCSV.getId()));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(listCSV.getName()));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(listCSV.getEmail()));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(listCSV.getPhone()));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(listCSV.getAddress()));
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }
                System.err.println("Export Done!!!");
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void print(ArrayList<CSVFile> ls) {
        for (int i = 0; i < ls.size(); i++) {
            System.out.printf("%d,%s,%s,%s,%s\n", ls.get(i).getId(),
                    ls.get(i).getName(), ls.get(i).getEmail(), ls.get(i).getPhone(),
                    ls.get(i).getAddress());
        }
    }
}


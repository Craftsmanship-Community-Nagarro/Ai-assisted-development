package org.nagarro.dataExporter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataExporter {

    public void exportUsersToCsv(List<User> users, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            for (User user : users) {
                writer.write(
                        user.getId() + "," + user.getName() + "," + user.getEmail() + "," + user.getPassword() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String doStuff(String x) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            if (c % 2 == 0) {
                result.append((char) (c + 1));
            } else {
                result.append((char) (c - 1));
            }
        }
        return result.toString();
    }
}
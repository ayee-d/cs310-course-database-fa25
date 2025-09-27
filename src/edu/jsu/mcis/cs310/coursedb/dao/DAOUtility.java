package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;


public class DAOUtility {
    
    public static final int TERMID_FA25 = 1;
    
    public static final int TERMID_FA25_DB = 202580;
    
    public static int resolveTermId(int termSelector) {
        return (termSelector == TERMID_FA25) ? TERMID_FA25_DB : termSelector;
    }
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {
                ResultSetMetaData md = rs.getMetaData();
                int cols = md.getColumnCount();
                
                while (rs.next()) {
                    JsonObject row = new JsonObject();
                    for (int i = 1; i <= cols; i++) {
                        String key = md.getColumnLabel(i);
                        String val = rs.getString(i);
                        row.put(key, (val == null) ? "" : val);
                    }
                    records.add(row);
                }

                

            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        return Jsoner.serialize(records);
        }
        
        return Jsoner.serialize(records);
        
    }
    
}

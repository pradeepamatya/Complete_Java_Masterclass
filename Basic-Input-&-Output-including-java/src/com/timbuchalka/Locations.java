package com.timbuchalka;

import java.io.*;
import java.util.*;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
//        FileWriter locfile = null;
//        try {
//            locfile = new FileWriter("locations.txt");
//            for (Location location : locations.values()) {
//                locfile.write(location.getLocationID() + ", " + location.getDescription() + "\n");
////                throw new IOException("test throw while writing");
//            }
//        } finally {
//            System.out.println("In finally block");
//            if (locfile != null) {
//                System.out.println("Attemting to close");
//                locfile.close();
//                System.out.println("Closed!");
//            }
//        }
//
//        try(FileWriter fileWriter = new FileWriter("locations.txt");
//        FileWriter dirFile = new FileWriter("directions.txt")) {
//            for (Location location : locations.values()) {
//                String temp = String.format("%d,%s\n", location.getLocationID(), location.getDescription());
//                fileWriter.write(temp);
//                for (String direction : location.getExits().keySet()) {
//                    dirFile.write(String.format("%s,%s,%s,\n", location.getLocationID(), direction, location.getExits().get(direction)));
//                }
//            }
//        }
    }

    static {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("locations.txt"));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.printf("Scanned location; id: %d, description: %s\n", loc, description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner!=null) {
                scanner.close();
            }
        }
        // now read exits
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("directions.txt")));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {

                String idd = scanner.next();
                int id = Integer.parseInt(idd);
                scanner.skip(scanner.delimiter());
                String direction = scanner.next();
                scanner.skip(scanner.delimiter());
                String dest = scanner.next();
                int destination = Integer.parseInt(dest);
                Location location = locations.get(id);
                location.addExit(direction, destination);
                scanner.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(scanner!=null) {
                scanner.close();
            }
        }
//        Map<String, Integer> tempExit = new HashMap<String, Integer>();
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",null));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 5);
//        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("S", 1);
//        tempExit.put("W", 2);
//        locations.put(5, new Location(5, "You are in the forest",tempExit));

    }
    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
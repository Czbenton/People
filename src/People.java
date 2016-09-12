import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/**
 * Reads a csv file and maps country name to a list of people who are from that country.
 * Then, for each list sorts by last name.
 */
public class People {

    public static void main(String[] args) throws IOException {
        File f = new File("people.csv");
        Scanner fileScanner = new Scanner(f);

        List<Person> peopleList;
        Map<String, List<Person>> peopleMap = new HashMap<>();
        String line;

        while (fileScanner.hasNext()) {
            line = fileScanner.nextLine();
            while (line.startsWith("id,first_name")) {
                line = fileScanner.nextLine();
            }
            String[] columns = line.split(",");
            Person person = new Person(columns[0], columns[1], columns[2], columns[3], columns[4], columns[5]);
            String keyValue = person.getCountry();
            if (peopleMap.containsKey(keyValue)) {
                peopleList = peopleMap.get(keyValue);
                peopleList.add(person);
                Collections.sort(peopleList);
            } else {
                peopleList = new ArrayList<>();
                peopleList.add(person);
                peopleMap.put(keyValue, peopleList);
                Collections.sort(peopleList);
            }
        }
        writeJson("people.json", peopleMap);

        System.out.println(peopleMap);
}
    public static void writeJson(String fileName, Map fileContent) throws IOException {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.include("*").serialize(fileContent);

        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }
}
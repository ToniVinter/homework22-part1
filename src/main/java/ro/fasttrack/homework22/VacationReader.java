//import Vacation;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class VacationReader {
//    private final String fileLocation;
//    private final Resource file;
//
//    public VacationReader(@Value("${file.location:vacations.txt") String fileLocation) {
//        this.fileLocation = fileLocation;
//        this.file = new ClassPathResource(fileLocation);
//        if(!file.exists()){
//            throw new RuntimeException("Could not find file");
//        }
//    }
//
//    public List<Vacation> read(){
//        List<Vacation> result = new ArrayList<>();
//        try(InputStream inputStream = file.getInputStream()){
//            Scanner scanner = new Scanner(file.getInputStream());
//            while (scanner.hasNextLine()){
//                final String[] tokens = scanner.nextLine().split(" ");
//                var location = tokens[0];
//                var price = Integer.parseInt(tokens[1]);
//                var duration = Integer.parseInt(tokens[2]);
//                result.add(new Vacation(location,price,duration));
//            }
//        }
//    }
//}

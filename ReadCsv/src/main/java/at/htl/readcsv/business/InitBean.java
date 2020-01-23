package at.htl.readcsv.business;

import at.htl.readcsv.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@ApplicationScoped
public class InitBean {

    private static final String FILE_NAME = "got.csv";

    private void init(@Observes
                      @Initialized(ApplicationScoped.class) Object object) {
        readCsv(FILE_NAME);
    }

    public InitBean() { }

    private void readCsv(String fileName) {
        // tag::readcsv[]
        URL url = Thread.currentThread().getContextClassLoader()
                .getResource(fileName);
        try (Stream<String> stream = Files.lines(Paths.get(url.getPath()), StandardCharsets.UTF_8)) {
            stream
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(elem -> new Person(elem[0], elem[1], elem[2]))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // end::readcsv[]
    }

}

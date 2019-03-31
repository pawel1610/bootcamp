package pl.pwn.rest.client;

import com.bootcamp.bootcamp.model.CourseEdition;
import com.bootcamp.bootcamp.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CourseRestClient {

    public static void main(String[] args) {

        getCourses();

        getCoursesById(32);

        User user = new User();
        user.setName("Karolina");
        user.setLastName("Michalski");
        user.setEmail("kar878999ol@karol.pl");
        user.setPhone("555-666-888");
        user.setPassword("karol");

        postUser(user, 32);
    }

    private static void getCoursesById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CourseEdition> objectResponseEntity = restTemplate.getForEntity("http://localhost:8080/client/getCourse/" + id, CourseEdition.class);
        CourseEdition body = objectResponseEntity.getBody();
        if (HttpStatus.OK.equals(objectResponseEntity.getStatusCode())) {
            System.out.println("Kurs: " + body);
        } else {
            System.out.println("Błąd status: " + objectResponseEntity.getStatusCode() + " " + objectResponseEntity.getBody());
        }
    }

    private static void getCourses() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<CourseEdition>> response = restTemplate.exchange("http://localhost:8080/client/courses",
                HttpMethod.GET, new HttpEntity<>(new HttpHeaders()),
                new ParameterizedTypeReference<List<CourseEdition>>() {
                });

        List<CourseEdition> courseEditionList = response.getBody();
        if (courseEditionList != null && !courseEditionList.isEmpty()) {
            System.out.println("All Courses\n" + courseEditionList);
        } else {
            System.out.println("No course...");
        }
    }

    private static void postUser(User user, int id){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> requestEntity = new HttpEntity<>(user,new HttpHeaders()); // okreslamy jaki obiket wyslemy
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/client/saveUser/" + id, HttpMethod.POST,
                requestEntity ,new ParameterizedTypeReference<String>() {});

        String body = response.getBody();
        System.out.println(response.getStatusCode());
        System.out.println(body);


    }


}

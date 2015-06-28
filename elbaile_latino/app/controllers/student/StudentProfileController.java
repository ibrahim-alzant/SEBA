package controllers.student;

import models.common.course.Course;
import models.student.Student;
import play.mvc.Controller;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by Admin on 07.06.2015.
 */
public class StudentProfileController extends Controller {
    public List<Course> getCourses(Student student){
        return Course.findByStudent(student);
    }

    public Boolean testImage(String url) {
        try {
            BufferedImage image = ImageIO.read(new URL(url));
            //BufferedImage image = ImageIO.read(new URL("http://someimage.jpg"));
            if (image != null) {
                return true;
            } else {
                return false;
            }
        } catch (MalformedURLException e) {
            System.err.println("URL error with image");
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            System.err.println("IO error with image");
            e.printStackTrace();
            return false;
        }
    }
}

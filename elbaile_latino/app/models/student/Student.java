package models.student;

import models.common.DanceStyle;
import models.common.Gender;
import models.common.Language;
import play.api.libs.json.Json;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;
import play.mvc.Result;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static play.mvc.Results.ok;

/**
 * Created by Admin on 03.06.2015.
 */
@Entity
public class Student extends Model {
    private static final long serialVersionUID = -6738879617416559361L;

    @Id
    @GeneratedValue
    public Long id;

    @Constraints.Required
    public String firstName;

    @OneToOne
    @Constraints.Required
    public Gender gender;

    @Constraints.Required
    public String lastName;

    @Constraints.Required
    public String address;

    @Constraints.Required
    @Column(unique = true)
    public String userName;

    @Constraints.Required
    public String password;

    @Constraints.Required
    @Column(unique = true)
    public String email;

    public String mobile;

    public String imgURL;

    public String additionalInformation;

    public Integer height;

    @Constraints.Required
    @ManyToMany(cascade = CascadeType.ALL)
    public List<Language> spokenLanguages;

    @Formats.DateTime(pattern = "dd-MM-yyyy HH:mm:ss")
    public Date dateOfBirth;

    @Constraints.Required
    @ManyToMany(cascade = CascadeType.ALL)
    public List<DanceStyle> danceStyles;

    public static Model.Finder<Long, Student> find = new Model.Finder<Long, Student>(
            Long.class, Student.class);

    public static Student findByUsername(String username) {
        return find.where().eq("userName", username).findUnique();
    }

    public static List<Student> find(Json searchQuery) {
        return null;
    }

    public static List<Student> findAll() {
        return find.all();
    }

    public static Result allStudentsJson() {
        List<Student> students = findAll();
        return ok(play.libs.Json.toJson(students));
    }

    public static Student authenticate(String userName, String password) {
        Student student = find.where().eq("userName", userName).findUnique();
        if (student != null) {
            if (student.password.equals(password)) {
                return student;
            }
        }
        return null;
    }

    public String getLanguages(Student student) {
        String languages = "";
        for (Language language : student.spokenLanguages) {
            languages += language.languageName + ",";
        }
        languages = languages.substring(0, languages.length() - 1);
        return languages;
    }

    public String getStyles(Student student) {
        String styles = "";
        for (DanceStyle style : student.danceStyles) {
            styles += style.danceStyleName + ",";
        }
        styles = styles.substring(0, styles.length() - 1);
        return styles;
    }

    public String getFormattedDate(Student student){
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return  format.format(student.dateOfBirth);
    }

}

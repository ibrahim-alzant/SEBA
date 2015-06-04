package models.student;

import models.common.DanceStyle;
import models.common.Gender;
import models.common.Language;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 03.06.2015.
 */
public class Student {
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

    public static Student findByUsername(String username){
        return find.where().eq("userName", username).findUnique();
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

}

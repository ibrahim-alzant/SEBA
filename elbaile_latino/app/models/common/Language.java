package models.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.mvc.Result;

import java.util.List;

import static play.mvc.Results.ok;

/**
 * This class represents the available languages that the user can speak.
 *
 * @author ibrahim alzant
 */
@Entity
public class Language extends Model {
    @Id
    @GeneratedValue
    public Long id;

    @Column(unique = true)
    @Required
    public String languageName;

    public static Finder<Long, Language> find = new Finder<Long, Language>(
            Long.class, Language.class);

    public static Language findByName(String languageName) {
        return find.where().eq("languageName", languageName).findUnique();
    }

    public static List<Language> findAll() {
        return find.all();
    }

    public static Result allLanguagesJson() {
        List<Language> languages = findAll();
        return ok(Json.toJson(languages));
    }
}

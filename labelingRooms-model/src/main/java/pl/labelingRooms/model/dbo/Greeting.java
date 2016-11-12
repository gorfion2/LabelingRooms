package pl.labelingRooms.model.dbo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by Kamil S on 2016-03-03.
 */
@Entity
public class Greeting {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(mappedBy = "greeting")
    private ModelOne modelOne;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ModelOne getModelOne() {
        return modelOne;
    }

    public void setModelOne(ModelOne modelOne) {
        this.modelOne = modelOne;
    }

}
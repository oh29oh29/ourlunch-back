package pe.oh29oh29.ourlunch.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "families")
@Data
public class Family implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column
    private String companyId;

    @Column
    private String name;

    @Column
    private String linkUrl;

    @Column
    private String createDate;

}

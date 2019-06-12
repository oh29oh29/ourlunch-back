package pe.oh29oh29.ourlunch.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "families")
@Data
public class Family implements Serializable {

    @Id
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

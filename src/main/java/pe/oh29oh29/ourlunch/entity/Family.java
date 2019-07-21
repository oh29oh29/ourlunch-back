package pe.oh29oh29.ourlunch.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "families")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Family implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne
    @NonNull
    private Company company;

    @NonNull
    private String name;

    @NonNull
    private String linkUrl;

    @NonNull
    private String createDate;

}

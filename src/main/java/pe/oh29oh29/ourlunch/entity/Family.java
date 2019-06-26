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
    @JoinColumn(name = "companyId")
    @NonNull
    private Company company;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private String linkUrl;

    @Column
    @NonNull
    private String createDate;

}

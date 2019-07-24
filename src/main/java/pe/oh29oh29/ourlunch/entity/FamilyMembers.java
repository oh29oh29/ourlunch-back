package pe.oh29oh29.ourlunch.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "family_members")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class FamilyMembers implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne
    @NonNull
    private Family family;

    @ManyToOne
    @NonNull
    private Member member;

    @NonNull
    private String name;

    @NonNull
    private boolean isMaster;

    private String taste;

    @NonNull
    private String joinDate;
}

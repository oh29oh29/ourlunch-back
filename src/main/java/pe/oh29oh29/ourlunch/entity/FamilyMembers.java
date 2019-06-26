package pe.oh29oh29.ourlunch.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "family_members")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class FamilyMembers {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne
    @JoinColumn(name = "familyId")
    @NonNull
    private Family family;

    @ManyToOne
    @JoinColumn(name = "memberId")
    @NonNull
    private Member member;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private boolean isMaster;

    @Column
    private String taste;

    @Column
    @NonNull
    private String joinDate;
}

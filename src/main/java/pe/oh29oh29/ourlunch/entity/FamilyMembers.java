package pe.oh29oh29.ourlunch.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "family_members")
@Data
@RequiredArgsConstructor
public class FamilyMembers {

    @Id
    @ManyToOne
    @JoinColumn(name = "familyId")
    private Family family;

    @Id
    @ManyToOne
    @JoinColumn(name = "memberId")
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

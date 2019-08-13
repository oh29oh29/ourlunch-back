package pe.oh29oh29.ourlunch.domain.member;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pe.oh29oh29.ourlunch.domain.family.Family;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "members")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @NonNull
    private String id;

    @NonNull
    private String password;

    @NonNull
    private String name;

    @OneToOne
    private Family family;

    private boolean isMaster;

    @NonNull
    private String signUpDate;
}

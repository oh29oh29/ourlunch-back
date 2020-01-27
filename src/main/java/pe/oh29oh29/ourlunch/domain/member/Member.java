package pe.oh29oh29.ourlunch.domain.member;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.oh29oh29.ourlunch.domain.family.Family;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)

@Entity(name = "members")
public class Member {

    public Member(
            @NotNull String id,
            @NotNull String name
    ) {
        this.id = id;
        this.name = name;
        this.signUpDate = LocalDateTime.now();
    }

    @Id
    private String id;

    @NotNull
    private String name;

    @OneToOne
    private Family family;

    private String appetite;

    private boolean isMaster;

    @NotNull
    private LocalDateTime signUpDate;
}

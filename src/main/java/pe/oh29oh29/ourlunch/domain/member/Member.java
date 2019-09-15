package pe.oh29oh29.ourlunch.domain.member;

import lombok.*;
import pe.oh29oh29.ourlunch.domain.family.Family;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)

@Entity
@Table(name = "members")
public class Member {

    public static Member of (final String id, final String name) {

        return new Member(id, name, LocalDateTime.now());
    }

    @Id
    @NonNull
    private String id;

    @NonNull
    private String name;

    @OneToOne
    private Family family;

    private boolean isMaster;

    @NonNull
    private LocalDateTime signUpDate;
}

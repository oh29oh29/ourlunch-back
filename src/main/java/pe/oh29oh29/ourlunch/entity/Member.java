package pe.oh29oh29.ourlunch.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


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
    private String signUpDate;
}

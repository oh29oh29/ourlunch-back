package pe.oh29oh29.ourlunch.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "members")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {

    @Id
    @NonNull
    private String id;

    @Column
    @NonNull
    private String password;

    @Column
    @NonNull
    private String signUpDate;
}
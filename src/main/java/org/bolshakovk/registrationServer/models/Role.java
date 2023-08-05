package org.bolshakovk.registrationServer.models;

import jakarta.persistence.*;
import lombok.Data;
import org.bolshakovk.registrationServer.utils.ERole;

@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
}

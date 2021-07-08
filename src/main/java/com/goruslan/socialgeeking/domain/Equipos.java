package com.goruslan.socialgeeking.domain;
import com.goruslan.socialgeeking.service.BeanUtil;
import lombok.*;
import org.ocpsoft.prettytime.PrettyTime;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//nombre empresa, ubicacion, marca, serie, modelo, detalles, horometro,
//estado: operativo o no
//
public class Equipos extends Auditable {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @NotEmpty(message = "Nombre de la compañia.")
    private String nameCompany;

    @NonNull
    @NotEmpty(message = "Ingresa la marca del equipo.")
    private String marca;

    @NonNull
    @NotEmpty(message = "Ingresa la serie del equipo.")
    private String serie;

    @NonNull
    @NotEmpty(message = "Ingresa los detalle o fallas tecnicas del equipo.")
    private String detalles;

    @NonNull
    @NotEmpty(message = "Ingresa el horometro del equipo.")
    private String horometro;

    @NonNull
    @NotEmpty(message = "Estado operativo.")
    private String estado;

    @ManyToOne
    private User user;

    /*@OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "equipos_user",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "equipos_id",referencedColumnName = "id")
    )

    private Set<User> users = new HashSet<>();

    public void addUser(User user) {
        users.add(user);
    }*/

    public String getPrettyTime() {
        PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
        return pt.format(convertToDateViaInstant(getCreationDate()));
    }

    private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }
}

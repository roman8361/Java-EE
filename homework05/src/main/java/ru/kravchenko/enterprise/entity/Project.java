package ru.kravchenko.enterprise.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import javax.persistence.*;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "app_Project")
public class Project extends AbstractEntity{

    @Nullable
    private String name = null;

    @Nullable
    private String description = null;

    @Nullable
    private Date dateBegin;

    @Nullable
    private Date dateEnd;

}

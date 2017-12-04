package org.somrainc.com.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
@ToString(exclude = "user")
@EqualsAndHashCode(exclude = "user")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

}

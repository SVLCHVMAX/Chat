package ru.simbirsoft.chat.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "message")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonManagedReference
    private Room room;

    public Message(long id, String content, User user, Room room) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.room = room;
    }
}

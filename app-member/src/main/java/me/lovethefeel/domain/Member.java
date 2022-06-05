package me.lovethefeel.domain;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "member")
@NoArgsConstructor(access = PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_name")
    private String name;

    private Member(final Long id, final String name) {
        validate(name);
        this.id = id;
        this.name = name;
    }

    private void validate(final String name) {
        if (Strings.isBlank(name)) {
            throw new IllegalArgumentException("이름은 필수값입니다.");
        }
    }

    public static Member from(final Long id, final String name) {
        return new Member(id, name);
    }
}

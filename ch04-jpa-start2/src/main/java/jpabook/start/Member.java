package jpabook.start;

import javax.persistence.*;
import java.util.Date;

@Entity

@Table(name = "MEMBER", uniqueConstraints = {
        @UniqueConstraint(
                name = "NAME_AGE_UNIQUE",
                columnNames = {"NAME", "AGE"})
})  // means ::: 유니크 제약조건. 이런 기능들은 단지 DDL을 자동 생성할 때만 사용되고 JPA의 실행로직에는 영향을 주지 않는다
/*
    alter table MEMBER
    add constraint NAME_AGE_UNIQUE  unique (NAME, age)
*/
public class Member {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME", nullable = false, length = 10)
    // means ::: not null 제약조건 추가, 문자의 크기가 10자리로 제한
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)       // means ::: 자바의 날짜 타입 설정 어노테이션
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob                // means ::: 길이 제한이 없다. 데이터베이스 VARCHAR 타입 대신에 CLOB 타입으로 저장해야한다
                        // @Lob을 사용하면 CLOB, BLOB 타입을 매핑할 수 있음
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

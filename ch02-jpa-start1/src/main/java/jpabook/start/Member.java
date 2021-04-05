package jpabook.start;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity     // means ::: 이 클래스를 테이블과 매핑한다고 JPA에게 알려준다. 이러한 클래스를 엔티티 클래스라고 한다
@Table(name = "MEMBER")     // means ::: 엔티티 클래스에 매핑할 클래스 정보(이름을 통해 연결)
public class Member {
    /*
        CREATE TABLE MEMBER (
        ID VARCHAR(255) NOT NULL,
        NAME VARCHAR(255),
        AGE INTEGER NOT NULL,
        PRIMARY KEY (ID)
        )
    */

    @Id             // means ::: Primary Key 식별자 필드
    @Column(name = "ID")        // means ::: 필드를 DB 컬럼에 매핑
    private String id;

    @Column(name = "NAME")
    private String username;

    // 매핑 정보가 없다면? 필드명을 사용해서 컬럼명으로 자동 매핑
    private Integer age;

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
}

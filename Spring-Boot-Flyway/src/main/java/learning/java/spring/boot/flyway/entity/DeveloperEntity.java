package learning.java.spring.boot.flyway.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "developer")
@Table
@Data
public class DeveloperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "firstname")
    public String firstName;

    @Column(name = "lastname")
    public String lastName;

    @Column(name = "age")
    public Integer age;

    @Column(name = "position")
    public String position;

    @Column(name = "salary")
    public Integer salary;

    @Column(name = "isinhomeoffice")
    public Boolean isInHomeOffice = Boolean.FALSE;
}

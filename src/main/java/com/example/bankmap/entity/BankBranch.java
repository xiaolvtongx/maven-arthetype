package com.example.bankmap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Administrator
 * 银行网点实体类，它使用@Entity注解将其标记为一个JPA实体。在其中，我们定义了五个属性：id、name、address、latitude和longitude。
 * &#064;Id注解指定该实体的主键属性，并使用@GeneratedValue(strategy  = GenerationType.AUTO)注解使其自动生成。
 *  &#064;Column注解用于指定属性的映射关系，其中name属性用于指定列名，nullable属性用于指定该列是否允许为空。
 * 该实体类中包含getter和setter方法，用于读取和设置实体对象的属性值。
 */
@Entity
public class BankBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "bank_name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}


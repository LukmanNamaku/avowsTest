package com.test.avows.backendjavatest.entity;

import javax.persistence.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.entity
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */
        
@Entity
public class Item {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String text;

    @ManyToMany(mappedBy = "items")
    private Set<Container> containers = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Set<Container> getContainers() { return containers; }
}

package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Mark {

    @Id
    @Column
    private String id;

    @Column
    private long markTime;

    @Column
    private String purpose;
}

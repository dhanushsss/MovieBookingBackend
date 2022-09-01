package com.example.moviebookingbackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Table
@Data
@Entity
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String comments;
    private String rating;

    @ManyToOne
    @JoinColumn(name = "customerid" , referencedColumnName = "customerid")
    private Customer customer ;
}

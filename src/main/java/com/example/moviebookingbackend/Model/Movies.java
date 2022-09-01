package com.example.moviebookingbackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieid;
    private String title;
    private String cast;
    private String date;
    private String language;
    private int price;
    private String showTime;
    private String totalTicket;
    private String image ;

    @ManyToOne
    @JoinColumn(name = "theatreid" , referencedColumnName = "theatreid")
    private Theatre theatre;
}

package org.springframework.boot.team.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "teams")
public class Team {
    @Id
    @Column(name="team_name", unique=true)
    private String teamName;

    @Column(name="owner_name")
    private String ownerName;

    @Column(name="home_ground", unique=true)
    private String homeGround;

    @Column(name="no_of_trophy")
    private Integer noOfTrophy;
    
}
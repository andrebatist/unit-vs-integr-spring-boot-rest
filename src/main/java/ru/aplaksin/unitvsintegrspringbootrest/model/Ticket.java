package ru.aplaksin.unitvsintegrspringbootrest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ticket_id")
    private Integer ticketId;
    private String passengerName;
    private Date bookingDate;
    private String sourceStation;
    private String destStation;
    private String email;
}

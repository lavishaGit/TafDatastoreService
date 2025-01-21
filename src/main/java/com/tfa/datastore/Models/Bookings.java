package com.tfa.datastore.Models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
  //  @JoinColumn(name = "user_id", nullable = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false) // Ensure "id" matches Users.id

    private Users user;;
    @ManyToOne(cascade = CascadeType.ALL)
  //  @JoinColumn(name = "flight_id", nullable = false)
    @JoinColumn(name = "flight_id", referencedColumnName = "id", nullable = false) // Ensure "id" matches Flights.id

    private Flights flight;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status=BookingStatus.BOOKED;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public enum BookingStatus {
        BOOKED,
        CANCELLED
    }
}
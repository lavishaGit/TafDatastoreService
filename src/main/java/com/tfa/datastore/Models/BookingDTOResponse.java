package com.tfa.datastore.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BookingDTOResponse {


        private Long id;
        private Long user_id;
        private Long flight_id;
        private String status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

}

package com.holverReto3.reto3.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.holverReto3.reto3.model.Reservation;

public interface ReservationCrudRepository extends CrudRepository <Reservation, Integer>{
    
    public List<Reservation> findAllByStatus(String status);

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date startDate, Date endDate);

    @Query("SELECT c.client, COUNT(c.client) from Reservation  AS c  group by c.client order by COUNT(c.client)DESC ")
    public List<Object[]> reportClient();


}

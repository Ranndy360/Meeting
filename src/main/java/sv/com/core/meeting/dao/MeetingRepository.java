package sv.com.core.meeting.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import sv.com.core.meeting.model.Meeting;

import java.util.Date;
import java.util.List;

public interface MeetingRepository extends CrudRepository<Meeting, Integer> {

    @Query("SELECT m FROM meeting m WHERE m.date >= :start_date AND m.date <= :end_date ORDER BY m.date ASC")
    List<Meeting> findAllByDate(@Param("start_date") Date start_date, @Param("end_date") Date end_date);

}

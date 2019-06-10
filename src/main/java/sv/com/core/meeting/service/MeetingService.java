package sv.com.core.meeting.service;

import org.springframework.stereotype.Service;
import sv.com.core.meeting.dao.MeetingRepository;
import sv.com.core.meeting.model.Meeting;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MeetingService {

    private final MeetingRepository meetingRepository;

    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public List<Meeting> findAllByDate(Date startDate, Date endDate){
        List<Meeting> meetings=new ArrayList<>();
        for (Meeting meeting:meetingRepository.findAllByDate(startDate, endDate)) {
            meetings.add(meeting);
        }
        return meetings;
    }
}

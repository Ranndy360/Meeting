package sv.com.core.meeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.com.core.meeting.beans.TimeAvailable;
import sv.com.core.meeting.helper.Helper;
import sv.com.core.meeting.model.Meeting;
import sv.com.core.meeting.model.User;
import sv.com.core.meeting.service.MeetingService;
import sv.com.core.meeting.service.UserService;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/meeting")
public class RestMeetingController {

    @Autowired
    private UserService userService;
    @Autowired
    private MeetingService meetingService;
    /**
     * Return all time available in day it receives,
     * with these condicion:
     * from 8am to 5pm
     * excluding 12pm-1pm
     * all meetings are half an hour long and
     * at least three people have to be available
     * @param date Date
     * @return  TimeAvailable Object in json format
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET, path = "/available")
    public @ResponseBody ArrayList<TimeAvailable> availableUser(@RequestParam String date) throws Exception{
        //response object
        ArrayList<TimeAvailable> response = new ArrayList<TimeAvailable>();
        try{
            int hour=800;
            //format params
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date startDate = format.parse(date+" 08:00");
            Date endDate = format.parse(date+" 16:30");
            //just one query
            List<User> userBean = userService.findAll();
            List<Meeting> meetingBean = meetingService.findAllByDate(startDate,endDate);
            Helper helper =  new Helper();
            ArrayList<List> bufferTime = new ArrayList<>();
            int time=800;
            String[] spliDate = new String[]{};
            int j = 0;
            boolean flag = false;//check for the last meeting data
            //based in office shedule just is posible have 16 meeting
            for (int i = 0; i <= 15; i++) {
                j=0;
                List bufferUser = new ArrayList();
                if(flag){//fill dataset
                    bufferUser.add(0);//user default
                    bufferTime.add(bufferUser);
                }
                for (Meeting meeting:meetingBean) {
                    j++;
                    //set format time
                    spliDate = meeting.getDate().toString().split(" ");
                    spliDate = spliDate[1].split(":");
                    spliDate[1] = spliDate[0]+spliDate[1];
                    if(time<=Integer.parseInt(spliDate[1])) {//compare if time apply for add new item
                        if (time != Integer.parseInt(spliDate[1])) {//close for
                            bufferUser.add(0);
                            bufferTime.add(bufferUser);
                            time = helper.increaseTime(time);//increase time
                            break;
                        } else {//add users to that time
                            bufferUser.add(meeting.getUser_id());
                            if(Integer.toString(j).equals(Integer.toString(meetingBean.size()))){//when meeting data end fill with user default
                                bufferTime.add(bufferUser);
                                flag=true;
                                time = helper.increaseTime(time);
                            }
                        }
                    }
                }
            }
            time=800;
            int split = 2;
            //fill response with available users
            for (int i = 0; i <= 15; i++) {
                int userAvailable = userBean.size()-(bufferTime.get(i).size()-1);
                if(userAvailable>=3){//if are at least three user available
//                    format time
                    String bufferTimeFormat = Integer.toString(time);
                    split = (time>=1000)?2:1; //if has more that 3 characters
                    String timeFormat = bufferTimeFormat.substring(0,split)+":"+bufferTimeFormat.substring(bufferTimeFormat.length()-2);

                    TimeAvailable timeAvailable =  new TimeAvailable();
                    timeAvailable.setTime(timeFormat);

                    ArrayList<User> users = new ArrayList<User>();
                    for (User userRecord:userBean) {//check who is available
//                        User user = new User();
                        if(userAvailable==userBean.size()){//if all user are available
                            users.add(userRecord);
                        }else{
                            flag=true;
                            for (int p =0; p<=bufferTime.get(i).size()-1;p++){
                                String bufferUserId = bufferTime.get(i).get(p).toString();
                                if(Long.toString(userRecord.getId()).equals(bufferUserId)){//user available
                                    flag=false;
                                }
                            }
                            if(flag)
                                users.add(userRecord);
                        }
                    }
                    timeAvailable.setUsers(users);
                    response.add(timeAvailable);
                    time = helper.increaseTime(time);//increase time
                }
            }

            return response;
        }catch(Exception ex) {
            System.out.print(ex);
            return response;
        }

    }


//    Iterator<String> nombreIterator = nombreArrayList.iterator();
//while(nombreIterator.hasNext()){
//        String elemento = nombreIterator.next();
//        System.out.print(elemento+" / ");
//    }
    @RequestMapping(method = RequestMethod.GET, path = "/test")
    public @ResponseBody TimeAvailable test() throws Exception{
        TimeAvailable response = new TimeAvailable();
        try{
            User user = new User();
            ArrayList<User> users = new ArrayList<User>();

            for (int i = 0; i <= 3; i++) {
                user.setId(i);
                user.setName("Randy");
                user.setLastname("Randy");
                users.add(user);
            }
            response.setTime("8:30");
            response.setUsers(users);
            return response;
        }catch(Exception ex) {
            return response;
        }

    }
}

package com.example.serve.service.comRecord;

import com.example.serve.bean.company.Event;

import java.util.List;

public interface EventService {
    Event getEventByUserIdAndComId(Integer userid, Integer comid);
    List<Event> getEventByUserIdNoComId(Integer userid, Integer comid);
    List<Event> getEventByUserId(Integer userid);
}

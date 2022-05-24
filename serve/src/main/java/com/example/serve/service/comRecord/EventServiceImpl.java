package com.example.serve.service.comRecord;

import com.example.serve.Dao.CompanyDao;
import com.example.serve.bean.company.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private CompanyDao companyDao;
    @Override
    public Event getEventByUserIdAndComId(Integer userid, Integer comid) {
        return companyDao.getEventByUserIdAndComId(userid, comid);
    }

    @Override
    public List<Event> getEventByUserIdNoComId(Integer userid, Integer comid) {
        List<Event> eventArrayList = new ArrayList<>();
        eventArrayList = companyDao.getEventByUserIdNoComId(userid, comid);
        Collections.sort(eventArrayList, new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.comid - o2.comid;
            }
        });
        return eventArrayList;
    }
    @Override
    public List<Event> getEventByUserId(Integer userid) {
        List<Event> eventArrayList = new ArrayList<>();
        eventArrayList = companyDao.getEventByUserId(userid);
        Collections.sort(eventArrayList, new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.comid - o2.comid;
            }
        });
        return eventArrayList;
    }
}

package com.example.serve.service.comRecord;

import java.util.Arrays;
import java.util.List;

public interface EmployRecordService {
    List<Integer> getEmployRecordAll(Integer userid);
    List<Integer> getEmployRecordNoComId(Integer userid,Integer comid);
}

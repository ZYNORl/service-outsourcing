package com.example.serve.controller;

import com.example.serve.bean.position.*;
import com.example.serve.service.position.PosCateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class PositionController {
    @Autowired
    private PosCateServiceImpl posCateService;
    @RequestMapping("/getPosCate")
    public List<PosCate> getPosCate(){
        List<PosCate> posCatelist=new ArrayList<PosCate>();
        //1、查询所有level=1的pos列表，视为第一类划分
        List<PosCateSimple> PosCateSimpleList01 = posCateService.getPosCateSimpleListByLevel(1);
        //2、遍历上述列表，获取其pos_id.然后查询pos_pid=pos_id的所有子列表.添加到其children中
        //3、重复上述操作，直到pos_level=3.数据树构建成功
        for(PosCateSimple posCateSimple : PosCateSimpleList01) {
            PosCate posCate = new PosCate();
            posCate.setPos_id(posCateSimple.getPos_id());
            posCate.setPos_level(posCateSimple.getPos_level());
            posCate.setPos_name(posCateSimple.getPos_name());
            posCate.setPos_pid(posCateSimple.getPos_pid());
            int pid01 = posCateSimple.getPos_id();
            List<PosCate> posCatelistByPid01=new ArrayList<PosCate>();
            List<PosCateSimple> posCateSimpleListByPid01 = posCateService.getPosCateSimpleListByPid(pid01);
            for(PosCateSimple posCateSimple1 : posCateSimpleListByPid01){
                PosCate posCate1 = new PosCate();
                posCate1.setPos_id(posCateSimple1.getPos_id());
                posCate1.setPos_level(posCateSimple1.getPos_level());
                posCate1.setPos_name(posCateSimple1.getPos_name());
                posCate1.setPos_pid(posCateSimple1.getPos_pid());
                int pid02 = posCateSimple1.getPos_id();
                List<PosCate> posCatelistByPid02=new ArrayList<PosCate>();
                List<PosCateSimple> posCateSimpleListByPid02 = posCateService.getPosCateSimpleListByPid((pid02));
                for(PosCateSimple posCateSimple2 : posCateSimpleListByPid02){
                    PosCate posCate2 = new PosCate();
                    posCate2.setPos_id(posCateSimple2.getPos_id());
                    posCate2.setPos_level(posCateSimple2.getPos_level());
                    posCate2.setPos_name(posCateSimple2.getPos_name());
                    posCate2.setPos_pid(posCateSimple2.getPos_pid());
                    int pid03 = posCateSimple2.getPos_id();
                    List<PosCate> posCatelistByPid03 = new ArrayList<PosCate>();
                    List<PosCateSimple> posCateSimpleListByPid03 = posCateService.getPosCateSimpleListByPid(pid03);
                    for(PosCateSimple posCateSimple3 : posCateSimpleListByPid03){
                        PosCate posCate3 = new PosCate();
                        posCate3.setPos_id(posCateSimple3.getPos_id());
                        posCate3.setPos_name(posCateSimple3.getPos_name());
                        posCate3.setPos_level(posCateSimple3.getPos_level());
                        posCate3.setPos_pid(posCateSimple3.getPos_pid());
                        posCate3.setChildren(null);
                        posCatelistByPid03.add(posCate3);
                    }
                    posCate2.setChildren(posCatelistByPid03);
                    posCatelistByPid02.add(posCate2);
                }
                posCate1.setChildren(posCatelistByPid02);
                posCatelistByPid01.add(posCate1);
            }
            posCate.setChildren(posCatelistByPid01);
            posCatelist.add(posCate);
        }
        return posCatelist;
    }

    @RequestMapping("/getPosCateTree")
    public List<PosCateTree> getPosCateTree(){
        List<PosCateTree> posCateTreelist=new ArrayList<PosCateTree>();
        //1、查询所有level=1的pos列表，视为第一类划分
        List<PosCateSimple> PosCateSimpleList01 = posCateService.getPosCateSimpleListByLevel(1);
        //2、遍历上述列表，获取其pos_id.然后查询pos_pid=pos_id的所有子列表.添加到其children中
        //3、重复上述操作，直到pos_level=3.数据树构建成功
        for(PosCateSimple posCateSimple : PosCateSimpleList01) {
            PosCateTree posCateTree = new PosCateTree();
            posCateTree.setName(posCateSimple.getPos_name());
            int pid01 = posCateSimple.getPos_id();
            List<PosCateTree> posCatelistByPid01=new ArrayList<PosCateTree>();
            List<PosCateSimple> posCateSimpleListByPid01 = posCateService.getPosCateSimpleListByPid(pid01);
            for(PosCateSimple posCateSimple1 : posCateSimpleListByPid01){
                PosCateTree posCateTree1 = new PosCateTree();
                posCateTree1.setName(posCateSimple1.getPos_name());
                int pid02 = posCateSimple1.getPos_id();
                List<PosCateTree> posCatelistByPid02=new ArrayList<>();
                List<PosCateSimple> posCateSimpleListByPid02 = posCateService.getPosCateSimpleListByPid((pid02));
                for(PosCateSimple posCateSimple2 : posCateSimpleListByPid02){
                    PosCateTree posCateTree2 = new PosCateTree();
                    posCateTree2.setName(posCateSimple2.getPos_name());
                    int pid03 = posCateSimple2.getPos_id();
                    List<PosCateTree> posCatelistByPid03 = new ArrayList<>();
                    List<PosCateSimple> posCateSimpleListByPid03 = posCateService.getPosCateSimpleListByPid((pid03));
                    for(PosCateSimple posCateSimple3 : posCateSimpleListByPid03){
                        PosCateTree posCateTree3 = new PosCateTree();
                        posCateTree3.setName(posCateSimple3.getPos_name());
                        posCateTree3.setChildren(null);
                        posCatelistByPid03.add(posCateTree3);
                    }
                    posCateTree2.setChildren(posCatelistByPid03);
                    posCatelistByPid02.add(posCateTree2);
                }
                posCateTree1.setChildren(posCatelistByPid02);
                posCatelistByPid01.add(posCateTree1);
            }
            posCateTree.setChildren(posCatelistByPid01);
            posCateTreelist.add(posCateTree);
        }
        PosCateTree posCateTree = new PosCateTree();
        posCateTree.setName("职位");
        posCateTree.setChildren(posCateTreelist);
        List<PosCateTree> posCateTreelistOne=new ArrayList<PosCateTree>();
        posCateTreelistOne.add(posCateTree);
        return posCateTreelistOne;
    }

    @RequestMapping("/getSkills")
    public PosSkill getSkills(@RequestParam String positionName){
        HashMap<String,Object> maps = posCateService.getAllSkillByPisitionName(positionName);
        ArrayList<Skill> arraySkillsList = new ArrayList<>();
        ArrayList<IndicatorSkill> indicatorSkillArrayList = new ArrayList<>();
        PosSkill posSkill = new PosSkill();
        int i=0;
        int[] scoreList = new int[maps.size()];

        for(HashMap.Entry<String,Object> map: maps.entrySet()){
            Skill skill = new Skill();
            IndicatorSkill indicatorSkill = new IndicatorSkill();
            skill.setSkill(map.getKey());
            String[] splitValue = map.getValue().toString().split(",");
            String[] splitScore = splitValue[0].split("=");
            skill.setScore(Integer.parseInt(splitScore[1]));
            arraySkillsList.add(skill);
            indicatorSkill.setName(map.getKey());
            indicatorSkill.setMax(100);
            indicatorSkillArrayList.add(indicatorSkill);
            scoreList[i]=Integer.parseInt(splitScore[1]);
            i++;
        }
        posSkill.setSkillList(arraySkillsList);
        posSkill.setIndicatorSkillList(indicatorSkillArrayList);
        posSkill.setScoreList(scoreList);
        return posSkill;
    }
}

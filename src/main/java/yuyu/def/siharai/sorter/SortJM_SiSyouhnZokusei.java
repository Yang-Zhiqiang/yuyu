package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.meta.QJM_SiSyouhnZokusei;
import yuyu.def.siharai.comparator.OrderJM_SiSyouhnZokusei;

public class SortJM_SiSyouhnZokusei {

    
    public List<JM_SiSyouhnZokusei> OrderJM_SiSyouhnZokuseiByPkAsc(List<JM_SiSyouhnZokusei> pEntity) {
        List<SortCondition<JM_SiSyouhnZokusei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_SiSyouhnZokusei()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SiSyouhnZokusei()).kyhgndkatakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SiSyouhnZokusei()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SiSyouhnZokusei()).kyuuhucd, SortOrder.ASC));
        List<JM_SiSyouhnZokusei> copyList = new ArrayList<JM_SiSyouhnZokusei>(pEntity);
        Collections.sort(copyList, new OrderJM_SiSyouhnZokusei(orders));
        return copyList;
    }

    
    public List<JM_SiSyouhnZokusei> OrderJM_SiSyouhnZokuseiByPkDesc(List<JM_SiSyouhnZokusei> pEntity) {
        List<SortCondition<JM_SiSyouhnZokusei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_SiSyouhnZokusei()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SiSyouhnZokusei()).kyhgndkatakbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SiSyouhnZokusei()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SiSyouhnZokusei()).kyuuhucd, SortOrder.DESC));
        List<JM_SiSyouhnZokusei> copyList = new ArrayList<JM_SiSyouhnZokusei>(pEntity);
        Collections.sort(copyList, new OrderJM_SiSyouhnZokusei(orders));
        return copyList;
    }

}


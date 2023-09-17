package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SyouhnZokusei;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.meta.QBM_SyouhnZokusei;

public class SortBM_SyouhnZokusei {

    public List<BM_SyouhnZokusei> OrderBM_SyouhnZokuseiByPkAsc(List<BM_SyouhnZokusei> pEntity) {
        List<SortCondition<BM_SyouhnZokusei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SyouhnZokusei()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SyouhnZokusei()).syouhnsdno, SortOrder.ASC));
        List<BM_SyouhnZokusei> copyList = new ArrayList<BM_SyouhnZokusei>(pEntity);
        Collections.sort(copyList, new OrderBM_SyouhnZokusei(orders));
        return copyList;
    }

    public List<BM_SyouhnZokusei> OrderBM_SyouhnZokuseiByPkDesc(List<BM_SyouhnZokusei> pEntity) {
        List<SortCondition<BM_SyouhnZokusei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SyouhnZokusei()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SyouhnZokusei()).syouhnsdno, SortOrder.DESC));
        List<BM_SyouhnZokusei> copyList = new ArrayList<BM_SyouhnZokusei>(pEntity);
        Collections.sort(copyList, new OrderBM_SyouhnZokusei(orders));
        return copyList;
    }

}


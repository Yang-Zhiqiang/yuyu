package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAM_SyoruiZokusei;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.meta.QAM_SyoruiZokusei;

public class SortAM_SyoruiZokusei {

    public List<AM_SyoruiZokusei> OrderAM_SyoruiZokuseiByPkAsc(List<AM_SyoruiZokusei> pEntity) {
        List<SortCondition<AM_SyoruiZokusei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_SyoruiZokusei()).syoruiCd, SortOrder.ASC));
        List<AM_SyoruiZokusei> copyList = new ArrayList<AM_SyoruiZokusei>(pEntity);
        Collections.sort(copyList, new OrderAM_SyoruiZokusei(orders));
        return copyList;
    }

    public List<AM_SyoruiZokusei> OrderAM_SyoruiZokuseiByPkDesc(List<AM_SyoruiZokusei> pEntity) {
        List<SortCondition<AM_SyoruiZokusei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_SyoruiZokusei()).syoruiCd, SortOrder.DESC));
        List<AM_SyoruiZokusei> copyList = new ArrayList<AM_SyoruiZokusei>(pEntity);
        Collections.sort(copyList, new OrderAM_SyoruiZokusei(orders));
        return copyList;
    }
}

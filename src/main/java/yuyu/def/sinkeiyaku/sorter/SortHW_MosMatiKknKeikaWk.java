package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HW_MosMatiKknKeikaWk;
import yuyu.def.db.meta.QHW_MosMatiKknKeikaWk;
import yuyu.def.sinkeiyaku.comparator.OrderHW_MosMatiKknKeikaWk;

public class SortHW_MosMatiKknKeikaWk {

    
    public List<HW_MosMatiKknKeikaWk> OrderHW_MosMatiKknKeikaWkByPkAsc(List<HW_MosMatiKknKeikaWk> pEntity) {
        List<SortCondition<HW_MosMatiKknKeikaWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHW_MosMatiKknKeikaWk()).nyksyoriymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHW_MosMatiKknKeikaWk()).itirenno, SortOrder.ASC));
        List<HW_MosMatiKknKeikaWk> copyList = new ArrayList<HW_MosMatiKknKeikaWk>(pEntity);
        Collections.sort(copyList, new OrderHW_MosMatiKknKeikaWk(orders));
        return copyList;
    }

    
    public List<HW_MosMatiKknKeikaWk> OrderHW_MosMatiKknKeikaWkByPkDesc(List<HW_MosMatiKknKeikaWk> pEntity) {
        List<SortCondition<HW_MosMatiKknKeikaWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHW_MosMatiKknKeikaWk()).nyksyoriymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHW_MosMatiKknKeikaWk()).itirenno, SortOrder.DESC));
        List<HW_MosMatiKknKeikaWk> copyList = new ArrayList<HW_MosMatiKknKeikaWk>(pEntity);
        Collections.sort(copyList, new OrderHW_MosMatiKknKeikaWk(orders));
        return copyList;
    }

}


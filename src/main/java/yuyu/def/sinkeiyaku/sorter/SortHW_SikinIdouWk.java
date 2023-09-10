package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HW_SikinIdouWk;
import yuyu.def.db.meta.QHW_SikinIdouWk;
import yuyu.def.sinkeiyaku.comparator.OrderHW_SikinIdouWk;

public class SortHW_SikinIdouWk {

    
    public List<HW_SikinIdouWk> OrderHW_SikinIdouWkByPkAsc(List<HW_SikinIdouWk> pEntity) {
        List<SortCondition<HW_SikinIdouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHW_SikinIdouWk()).nyksyoriymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHW_SikinIdouWk()).itirenno, SortOrder.ASC));
        List<HW_SikinIdouWk> copyList = new ArrayList<HW_SikinIdouWk>(pEntity);
        Collections.sort(copyList, new OrderHW_SikinIdouWk(orders));
        return copyList;
    }

    
    public List<HW_SikinIdouWk> OrderHW_SikinIdouWkByPkDesc(List<HW_SikinIdouWk> pEntity) {
        List<SortCondition<HW_SikinIdouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHW_SikinIdouWk()).nyksyoriymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHW_SikinIdouWk()).itirenno, SortOrder.DESC));
        List<HW_SikinIdouWk> copyList = new ArrayList<HW_SikinIdouWk>(pEntity);
        Collections.sort(copyList, new OrderHW_SikinIdouWk(orders));
        return copyList;
    }
}

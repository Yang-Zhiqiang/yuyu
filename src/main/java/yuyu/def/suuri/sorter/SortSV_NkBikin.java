package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.SV_NkBikin;
import yuyu.def.db.meta.QSV_NkBikin;
import yuyu.def.suuri.comparator.OrderSV_NkBikin;

public class SortSV_NkBikin {

    
    public List<SV_NkBikin> OrderSV_NkBikinByPkAsc(List<SV_NkBikin> pEntity) {
        List<SortCondition<SV_NkBikin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_NkBikin()).renno8keta, SortOrder.ASC));
        List<SV_NkBikin> copyList = new ArrayList<SV_NkBikin>(pEntity);
        Collections.sort(copyList, new OrderSV_NkBikin(orders));
        return copyList;
    }

    
    public List<SV_NkBikin> OrderSV_NkBikinByPkDesc(List<SV_NkBikin> pEntity) {
        List<SortCondition<SV_NkBikin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_NkBikin()).renno8keta, SortOrder.DESC));
        List<SV_NkBikin> copyList = new ArrayList<SV_NkBikin>(pEntity);
        Collections.sort(copyList, new OrderSV_NkBikin(orders));
        return copyList;
    }
}

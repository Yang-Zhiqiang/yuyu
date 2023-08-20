package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.SV_HoyuuMeisai;
import yuyu.def.db.meta.QSV_HoyuuMeisai;
import yuyu.def.suuri.comparator.OrderSV_HoyuuMeisai;

public class SortSV_HoyuuMeisai {

    
    public List<SV_HoyuuMeisai> OrderSV_HoyuuMeisaiByPkAsc(List<SV_HoyuuMeisai> pEntity) {
        List<SortCondition<SV_HoyuuMeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_HoyuuMeisai()).syono, SortOrder.ASC));
        List<SV_HoyuuMeisai> copyList = new ArrayList<SV_HoyuuMeisai>(pEntity);
        Collections.sort(copyList, new OrderSV_HoyuuMeisai(orders));
        return copyList;
    }

    
    public List<SV_HoyuuMeisai> OrderSV_HoyuuMeisaiByPkDesc(List<SV_HoyuuMeisai> pEntity) {
        List<SortCondition<SV_HoyuuMeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_HoyuuMeisai()).syono, SortOrder.DESC));
        List<SV_HoyuuMeisai> copyList = new ArrayList<SV_HoyuuMeisai>(pEntity);
        Collections.sort(copyList, new OrderSV_HoyuuMeisai(orders));
        return copyList;
    }
}

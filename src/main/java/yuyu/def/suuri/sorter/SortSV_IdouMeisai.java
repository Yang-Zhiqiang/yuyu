package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.SV_IdouMeisai;
import yuyu.def.db.meta.QSV_IdouMeisai;
import yuyu.def.suuri.comparator.OrderSV_IdouMeisai;

public class SortSV_IdouMeisai {

    
    public List<SV_IdouMeisai> OrderSV_IdouMeisaiByPkAsc(List<SV_IdouMeisai> pEntity) {
        List<SortCondition<SV_IdouMeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_IdouMeisai()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_IdouMeisai()).gyoumuKousinKinou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_IdouMeisai()).gyoumuKousinTime, SortOrder.ASC));
        List<SV_IdouMeisai> copyList = new ArrayList<SV_IdouMeisai>(pEntity);
        Collections.sort(copyList, new OrderSV_IdouMeisai(orders));
        return copyList;
    }

    
    public List<SV_IdouMeisai> OrderSV_IdouMeisaiByPkDesc(List<SV_IdouMeisai> pEntity) {
        List<SortCondition<SV_IdouMeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_IdouMeisai()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_IdouMeisai()).gyoumuKousinKinou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_IdouMeisai()).gyoumuKousinTime, SortOrder.DESC));
        List<SV_IdouMeisai> copyList = new ArrayList<SV_IdouMeisai>(pEntity);
        Collections.sort(copyList, new OrderSV_IdouMeisai(orders));
        return copyList;
    }
}

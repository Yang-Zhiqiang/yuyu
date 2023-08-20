package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.SV_BikinIdouMeisai;
import yuyu.def.db.meta.QSV_BikinIdouMeisai;
import yuyu.def.suuri.comparator.OrderSV_BikinIdouMeisai;

public class SortSV_BikinIdouMeisai {

    
    public List<SV_BikinIdouMeisai> OrderSV_BikinIdouMeisaiByPkAsc(List<SV_BikinIdouMeisai> pEntity) {
        List<SortCondition<SV_BikinIdouMeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_BikinIdouMeisai()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_BikinIdouMeisai()).gyoumuKousinKinou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_BikinIdouMeisai()).gyoumuKousinTime, SortOrder.ASC));
        List<SV_BikinIdouMeisai> copyList = new ArrayList<SV_BikinIdouMeisai>(pEntity);
        Collections.sort(copyList, new OrderSV_BikinIdouMeisai(orders));
        return copyList;
    }

    
    public List<SV_BikinIdouMeisai> OrderSV_BikinIdouMeisaiByPkDesc(List<SV_BikinIdouMeisai> pEntity) {
        List<SortCondition<SV_BikinIdouMeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_BikinIdouMeisai()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_BikinIdouMeisai()).gyoumuKousinKinou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_BikinIdouMeisai()).gyoumuKousinTime, SortOrder.DESC));
        List<SV_BikinIdouMeisai> copyList = new ArrayList<SV_BikinIdouMeisai>(pEntity);
        Collections.sort(copyList, new OrderSV_BikinIdouMeisai(orders));
        return copyList;
    }
}

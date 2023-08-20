package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.SV_SibourituToukeiSeibigo;
import yuyu.def.db.meta.QSV_SibourituToukeiSeibigo;
import yuyu.def.suuri.comparator.OrderSV_SibourituToukeiSeibigo;

public class SortSV_SibourituToukeiSeibigo {

    
    public List<SV_SibourituToukeiSeibigo> OrderSV_SibourituToukeiSeibigoByPkAsc(List<SV_SibourituToukeiSeibigo> pEntity) {
        List<SortCondition<SV_SibourituToukeiSeibigo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_SibourituToukeiSeibigo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_SibourituToukeiSeibigo()).gyoumuKousinKinou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_SibourituToukeiSeibigo()).gyoumuKousinTime, SortOrder.ASC));
        List<SV_SibourituToukeiSeibigo> copyList = new ArrayList<SV_SibourituToukeiSeibigo>(pEntity);
        Collections.sort(copyList, new OrderSV_SibourituToukeiSeibigo(orders));
        return copyList;
    }

    
    public List<SV_SibourituToukeiSeibigo> OrderSV_SibourituToukeiSeibigoByPkDesc(List<SV_SibourituToukeiSeibigo> pEntity) {
        List<SortCondition<SV_SibourituToukeiSeibigo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_SibourituToukeiSeibigo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_SibourituToukeiSeibigo()).gyoumuKousinKinou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_SibourituToukeiSeibigo()).gyoumuKousinTime, SortOrder.DESC));
        List<SV_SibourituToukeiSeibigo> copyList = new ArrayList<SV_SibourituToukeiSeibigo>(pEntity);
        Collections.sort(copyList, new OrderSV_SibourituToukeiSeibigo(orders));
        return copyList;
    }
}

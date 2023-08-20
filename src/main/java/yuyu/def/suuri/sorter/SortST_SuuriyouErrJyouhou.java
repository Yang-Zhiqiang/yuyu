package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.meta.QST_SuuriyouErrJyouhou;
import yuyu.def.suuri.comparator.OrderST_SuuriyouErrJyouhou;

public class SortST_SuuriyouErrJyouhou {

    
    public List<ST_SuuriyouErrJyouhou> OrderST_SuuriyouErrJyouhouByPkAsc(List<ST_SuuriyouErrJyouhou> pEntity) {
        List<SortCondition<ST_SuuriyouErrJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_SuuriyouErrJyouhou()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SuuriyouErrJyouhou()).kakutyoujobcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SuuriyouErrJyouhou()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SuuriyouErrJyouhou()).gyoumuKousinTime, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SuuriyouErrJyouhou()).suuritoukeiyouerrnaiyou, SortOrder.ASC));
        List<ST_SuuriyouErrJyouhou> copyList = new ArrayList<ST_SuuriyouErrJyouhou>(pEntity);
        Collections.sort(copyList, new OrderST_SuuriyouErrJyouhou(orders));
        return copyList;
    }

    
    public List<ST_SuuriyouErrJyouhou> OrderST_SuuriyouErrJyouhouByPkDesc(List<ST_SuuriyouErrJyouhou> pEntity) {
        List<SortCondition<ST_SuuriyouErrJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_SuuriyouErrJyouhou()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SuuriyouErrJyouhou()).kakutyoujobcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SuuriyouErrJyouhou()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SuuriyouErrJyouhou()).gyoumuKousinTime, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SuuriyouErrJyouhou()).suuritoukeiyouerrnaiyou, SortOrder.DESC));
        List<ST_SuuriyouErrJyouhou> copyList = new ArrayList<ST_SuuriyouErrJyouhou>(pEntity);
        Collections.sort(copyList, new OrderST_SuuriyouErrJyouhou(orders));
        return copyList;
    }
}

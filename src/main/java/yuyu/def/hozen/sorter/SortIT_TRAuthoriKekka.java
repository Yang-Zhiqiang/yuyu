package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_TRAuthoriKekka;
import yuyu.def.db.meta.QIT_TRAuthoriKekka;
import yuyu.def.hozen.comparator.OrderIT_TRAuthoriKekka;

public class SortIT_TRAuthoriKekka {

    public List<IT_TRAuthoriKekka> OrderIT_TRAuthoriKekkaByPkAsc(List<IT_TRAuthoriKekka> pEntity) {
        List<SortCondition<IT_TRAuthoriKekka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TRAuthoriKekka()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRAuthoriKekka()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRAuthoriKekka()).authorikktrrenno, SortOrder.ASC));
        List<IT_TRAuthoriKekka> copyList = new ArrayList<IT_TRAuthoriKekka>(pEntity);
        Collections.sort(copyList, new OrderIT_TRAuthoriKekka(orders));
        return copyList;
    }

    public List<IT_TRAuthoriKekka> OrderIT_TRAuthoriKekkaByPkDesc(List<IT_TRAuthoriKekka> pEntity) {
        List<SortCondition<IT_TRAuthoriKekka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TRAuthoriKekka()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRAuthoriKekka()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRAuthoriKekka()).authorikktrrenno, SortOrder.DESC));
        List<IT_TRAuthoriKekka> copyList = new ArrayList<IT_TRAuthoriKekka>(pEntity);
        Collections.sort(copyList, new OrderIT_TRAuthoriKekka(orders));
        return copyList;
    }

}


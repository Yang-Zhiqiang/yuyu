package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_TRChkYukokekka;
import yuyu.def.db.meta.QIT_TRChkYukokekka;
import yuyu.def.hozen.comparator.OrderIT_TRChkYukokekka;

public class SortIT_TRChkYukokekka {

    public List<IT_TRChkYukokekka> OrderIT_TRChkYukokekkaByPkAsc(List<IT_TRChkYukokekka> pEntity) {
        List<SortCondition<IT_TRChkYukokekka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TRChkYukokekka()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRChkYukokekka()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRChkYukokekka()).yuukoutrrenno, SortOrder.ASC));
        List<IT_TRChkYukokekka> copyList = new ArrayList<IT_TRChkYukokekka>(pEntity);
        Collections.sort(copyList, new OrderIT_TRChkYukokekka(orders));
        return copyList;
    }

    public List<IT_TRChkYukokekka> OrderIT_TRChkYukokekkaByPkDesc(List<IT_TRChkYukokekka> pEntity) {
        List<SortCondition<IT_TRChkYukokekka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TRChkYukokekka()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRChkYukokekka()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRChkYukokekka()).yuukoutrrenno, SortOrder.DESC));
        List<IT_TRChkYukokekka> copyList = new ArrayList<IT_TRChkYukokekka>(pEntity);
        Collections.sort(copyList, new OrderIT_TRChkYukokekka(orders));
        return copyList;
    }

}


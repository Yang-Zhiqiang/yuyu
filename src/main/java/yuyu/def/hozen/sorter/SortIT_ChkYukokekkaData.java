package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_ChkYukokekkaData;
import yuyu.def.db.meta.QIT_ChkYukokekkaData;
import yuyu.def.hozen.comparator.OrderIT_ChkYukokekkaData;

public class SortIT_ChkYukokekkaData {

    public List<IT_ChkYukokekkaData> OrderIT_ChkYukokekkaDataByPkAsc(List<IT_ChkYukokekkaData> pEntity) {
        List<SortCondition<IT_ChkYukokekkaData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_ChkYukokekkaData()).ansyuusyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_ChkYukokekkaData()).yuukoukekkarenno, SortOrder.ASC));
        List<IT_ChkYukokekkaData> copyList = new ArrayList<IT_ChkYukokekkaData>(pEntity);
        Collections.sort(copyList, new OrderIT_ChkYukokekkaData(orders));
        return copyList;
    }

    public List<IT_ChkYukokekkaData> OrderIT_ChkYukokekkaDataByPkDesc(List<IT_ChkYukokekkaData> pEntity) {
        List<SortCondition<IT_ChkYukokekkaData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_ChkYukokekkaData()).ansyuusyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_ChkYukokekkaData()).yuukoukekkarenno, SortOrder.DESC));
        List<IT_ChkYukokekkaData> copyList = new ArrayList<IT_ChkYukokekkaData>(pEntity);
        Collections.sort(copyList, new OrderIT_ChkYukokekkaData(orders));
        return copyList;
    }

}


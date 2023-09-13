package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_MinusUriageKykDtlList;
import yuyu.def.db.meta.QIT_MinusUriageKykDtlList;
import yuyu.def.hozen.comparator.OrderIT_MinusUriageKykDtlList;

public class SortIT_MinusUriageKykDtlList {

    public List<IT_MinusUriageKykDtlList> OrderIT_MinusUriageKykDtlListByPkAsc(List<IT_MinusUriageKykDtlList> pEntity) {
        List<SortCondition<IT_MinusUriageKykDtlList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_MinusUriageKykDtlList()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_MinusUriageKykDtlList()).creditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_MinusUriageKykDtlList()).uriagenengappi, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_MinusUriageKykDtlList()).renno3keta, SortOrder.ASC));
        List<IT_MinusUriageKykDtlList> copyList = new ArrayList<IT_MinusUriageKykDtlList>(pEntity);
        Collections.sort(copyList, new OrderIT_MinusUriageKykDtlList(orders));
        return copyList;
    }

    public List<IT_MinusUriageKykDtlList> OrderIT_MinusUriageKykDtlListByPkDesc(List<IT_MinusUriageKykDtlList> pEntity) {
        List<SortCondition<IT_MinusUriageKykDtlList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_MinusUriageKykDtlList()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_MinusUriageKykDtlList()).creditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_MinusUriageKykDtlList()).uriagenengappi, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_MinusUriageKykDtlList()).renno3keta, SortOrder.DESC));
        List<IT_MinusUriageKykDtlList> copyList = new ArrayList<IT_MinusUriageKykDtlList>(pEntity);
        Collections.sort(copyList, new OrderIT_MinusUriageKykDtlList(orders));
        return copyList;
    }
}

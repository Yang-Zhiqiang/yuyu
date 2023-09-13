package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_UriageSkDataSyuKnr;
import yuyu.def.db.meta.QIT_UriageSkDataSyuKnr;
import yuyu.def.hozen.comparator.OrderIT_UriageSkDataSyuKnr;

public class SortIT_UriageSkDataSyuKnr {

    public List<IT_UriageSkDataSyuKnr> OrderIT_UriageSkDataSyuKnrByPkAsc(List<IT_UriageSkDataSyuKnr> pEntity) {
        List<SortCondition<IT_UriageSkDataSyuKnr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_UriageSkDataSyuKnr()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_UriageSkDataSyuKnr()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_UriageSkDataSyuKnr()).creditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_UriageSkDataSyuKnr()).uriagenengappi, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_UriageSkDataSyuKnr()).renno3keta, SortOrder.ASC));
        List<IT_UriageSkDataSyuKnr> copyList = new ArrayList<IT_UriageSkDataSyuKnr>(pEntity);
        Collections.sort(copyList, new OrderIT_UriageSkDataSyuKnr(orders));
        return copyList;
    }

    public List<IT_UriageSkDataSyuKnr> OrderIT_UriageSkDataSyuKnrByPkDesc(List<IT_UriageSkDataSyuKnr> pEntity) {
        List<SortCondition<IT_UriageSkDataSyuKnr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_UriageSkDataSyuKnr()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_UriageSkDataSyuKnr()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_UriageSkDataSyuKnr()).creditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_UriageSkDataSyuKnr()).uriagenengappi, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_UriageSkDataSyuKnr()).renno3keta, SortOrder.DESC));
        List<IT_UriageSkDataSyuKnr> copyList = new ArrayList<IT_UriageSkDataSyuKnr>(pEntity);
        Collections.sort(copyList, new OrderIT_UriageSkDataSyuKnr(orders));
        return copyList;
    }
}

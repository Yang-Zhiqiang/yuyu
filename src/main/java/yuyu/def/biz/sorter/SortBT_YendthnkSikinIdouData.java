package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_YendthnkSikinIdouData;
import yuyu.def.db.entity.BT_YendthnkSikinIdouData;
import yuyu.def.db.meta.QBT_YendthnkSikinIdouData;

public class SortBT_YendthnkSikinIdouData {

    public List<BT_YendthnkSikinIdouData> OrderBT_YendthnkSikinIdouDataByPkAsc(List<BT_YendthnkSikinIdouData> pEntity) {
        List<SortCondition<BT_YendthnkSikinIdouData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_YendthnkSikinIdouData()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_YendthnkSikinIdouData()).keiriyendthnkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_YendthnkSikinIdouData()).syoriYmd, SortOrder.ASC));
        List<BT_YendthnkSikinIdouData> copyList = new ArrayList<BT_YendthnkSikinIdouData>(pEntity);
        Collections.sort(copyList, new OrderBT_YendthnkSikinIdouData(orders));
        return copyList;
    }

    public List<BT_YendthnkSikinIdouData> OrderBT_YendthnkSikinIdouDataByPkDesc(List<BT_YendthnkSikinIdouData> pEntity) {
        List<SortCondition<BT_YendthnkSikinIdouData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_YendthnkSikinIdouData()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_YendthnkSikinIdouData()).keiriyendthnkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_YendthnkSikinIdouData()).syoriYmd, SortOrder.DESC));
        List<BT_YendthnkSikinIdouData> copyList = new ArrayList<BT_YendthnkSikinIdouData>(pEntity);
        Collections.sort(copyList, new OrderBT_YendthnkSikinIdouData(orders));
        return copyList;
    }
}

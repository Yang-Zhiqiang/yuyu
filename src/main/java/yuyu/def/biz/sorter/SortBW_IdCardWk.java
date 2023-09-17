package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBW_IdCardWk;
import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.def.db.meta.QBW_IdCardWk;

public class SortBW_IdCardWk {

    public List<BW_IdCardWk> OrderBW_IdCardWkByPkAsc(List<BW_IdCardWk> pEntity) {
        List<SortCondition<BW_IdCardWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBW_IdCardWk()).idkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBW_IdCardWk()).idcd, SortOrder.ASC));
        List<BW_IdCardWk> copyList = new ArrayList<BW_IdCardWk>(pEntity);
        Collections.sort(copyList, new OrderBW_IdCardWk(orders));
        return copyList;
    }

    public List<BW_IdCardWk> OrderBW_IdCardWkByPkDesc(List<BW_IdCardWk> pEntity) {
        List<SortCondition<BW_IdCardWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBW_IdCardWk()).idkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBW_IdCardWk()).idcd, SortOrder.DESC));
        List<BW_IdCardWk> copyList = new ArrayList<BW_IdCardWk>(pEntity);
        Collections.sort(copyList, new OrderBW_IdCardWk(orders));
        return copyList;
    }
}

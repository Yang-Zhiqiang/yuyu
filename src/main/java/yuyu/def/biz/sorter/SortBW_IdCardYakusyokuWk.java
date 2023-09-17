package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBW_IdCardYakusyokuWk;
import yuyu.def.db.entity.BW_IdCardYakusyokuWk;
import yuyu.def.db.meta.QBW_IdCardYakusyokuWk;

public class SortBW_IdCardYakusyokuWk {

    public List<BW_IdCardYakusyokuWk> OrderBW_IdCardYakusyokuWkByPkAsc(List<BW_IdCardYakusyokuWk> pEntity) {
        List<SortCondition<BW_IdCardYakusyokuWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBW_IdCardYakusyokuWk()).idkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBW_IdCardYakusyokuWk()).idcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBW_IdCardYakusyokuWk()).yakusyokuhatureiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBW_IdCardYakusyokuWk()).yakusyokuhatureino, SortOrder.ASC));
        List<BW_IdCardYakusyokuWk> copyList = new ArrayList<BW_IdCardYakusyokuWk>(pEntity);
        Collections.sort(copyList, new OrderBW_IdCardYakusyokuWk(orders));
        return copyList;
    }

    public List<BW_IdCardYakusyokuWk> OrderBW_IdCardYakusyokuWkByPkDesc(List<BW_IdCardYakusyokuWk> pEntity) {
        List<SortCondition<BW_IdCardYakusyokuWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBW_IdCardYakusyokuWk()).idkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBW_IdCardYakusyokuWk()).idcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBW_IdCardYakusyokuWk()).yakusyokuhatureiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBW_IdCardYakusyokuWk()).yakusyokuhatureino, SortOrder.DESC));
        List<BW_IdCardYakusyokuWk> copyList = new ArrayList<BW_IdCardYakusyokuWk>(pEntity);
        Collections.sort(copyList, new OrderBW_IdCardYakusyokuWk(orders));
        return copyList;
    }
}

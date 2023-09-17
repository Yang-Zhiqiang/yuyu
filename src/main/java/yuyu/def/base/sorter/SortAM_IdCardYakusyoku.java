package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAM_IdCardYakusyoku;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AM_IdCardYakusyoku;
import yuyu.def.db.meta.QAM_IdCardYakusyoku;

public class SortAM_IdCardYakusyoku {

    public List<AM_IdCardYakusyoku> OrderAM_IdCardYakusyokuByPkAsc(List<AM_IdCardYakusyoku> pEntity) {
        List<SortCondition<AM_IdCardYakusyoku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_IdCardYakusyoku()).idkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAM_IdCardYakusyoku()).idcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAM_IdCardYakusyoku()).yakusyokuhatureiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAM_IdCardYakusyoku()).yakusyokuhatureino, SortOrder.ASC));
        List<AM_IdCardYakusyoku> copyList = new ArrayList<AM_IdCardYakusyoku>(pEntity);
        Collections.sort(copyList, new OrderAM_IdCardYakusyoku(orders));
        return copyList;
    }

    public List<AM_IdCardYakusyoku> OrderAM_IdCardYakusyokuByPkDesc(List<AM_IdCardYakusyoku> pEntity) {
        List<SortCondition<AM_IdCardYakusyoku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_IdCardYakusyoku()).idkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAM_IdCardYakusyoku()).idcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAM_IdCardYakusyoku()).yakusyokuhatureiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAM_IdCardYakusyoku()).yakusyokuhatureino, SortOrder.DESC));
        List<AM_IdCardYakusyoku> copyList = new ArrayList<AM_IdCardYakusyoku>(pEntity);
        Collections.sort(copyList, new OrderAM_IdCardYakusyoku(orders));
        return copyList;
    }
}

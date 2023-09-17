package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAM_HonyakutsgSosikiCd;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AM_HonyakutsgSosikiCd;
import yuyu.def.db.meta.QAM_HonyakutsgSosikiCd;

public class SortAM_HonyakutsgSosikiCd {

    public List<AM_HonyakutsgSosikiCd> OrderAM_HonyakutsgSosikiCdByPkAsc(List<AM_HonyakutsgSosikiCd> pEntity) {
        List<SortCondition<AM_HonyakutsgSosikiCd>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_HonyakutsgSosikiCd()).sosikicd, SortOrder.ASC));
        List<AM_HonyakutsgSosikiCd> copyList = new ArrayList<AM_HonyakutsgSosikiCd>(pEntity);
        Collections.sort(copyList, new OrderAM_HonyakutsgSosikiCd(orders));
        return copyList;
    }

    public List<AM_HonyakutsgSosikiCd> OrderAM_HonyakutsgSosikiCdByPkDesc(List<AM_HonyakutsgSosikiCd> pEntity) {
        List<SortCondition<AM_HonyakutsgSosikiCd>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_HonyakutsgSosikiCd()).sosikicd, SortOrder.DESC));
        List<AM_HonyakutsgSosikiCd> copyList = new ArrayList<AM_HonyakutsgSosikiCd>(pEntity);
        Collections.sort(copyList, new OrderAM_HonyakutsgSosikiCd(orders));
        return copyList;
    }
}

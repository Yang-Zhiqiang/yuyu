package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_SousaRirekiIvrInfo;
import yuyu.def.db.meta.QMT_SousaRirekiIvrInfo;
import yuyu.def.direct.comparator.OrderMT_SousaRirekiIvrInfo;

public class SortMT_SousaRirekiIvrInfo {

    public List<MT_SousaRirekiIvrInfo> OrderMT_SousaRirekiIvrInfoByPkAsc(List<MT_SousaRirekiIvrInfo> pEntity) {
        List<SortCondition<MT_SousaRirekiIvrInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_SousaRirekiIvrInfo()).ttdksikibetuid, SortOrder.ASC));
        List<MT_SousaRirekiIvrInfo> copyList = new ArrayList<MT_SousaRirekiIvrInfo>(pEntity);
        Collections.sort(copyList, new OrderMT_SousaRirekiIvrInfo(orders));
        return copyList;
    }

    public List<MT_SousaRirekiIvrInfo> OrderMT_SousaRirekiIvrInfoByPkDesc(List<MT_SousaRirekiIvrInfo> pEntity) {
        List<SortCondition<MT_SousaRirekiIvrInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_SousaRirekiIvrInfo()).ttdksikibetuid, SortOrder.DESC));
        List<MT_SousaRirekiIvrInfo> copyList = new ArrayList<MT_SousaRirekiIvrInfo>(pEntity);
        Collections.sort(copyList, new OrderMT_SousaRirekiIvrInfo(orders));
        return copyList;
    }
}

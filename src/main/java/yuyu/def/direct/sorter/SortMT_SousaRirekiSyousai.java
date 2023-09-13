package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_SousaRirekiSyousai;
import yuyu.def.db.meta.QMT_SousaRirekiSyousai;
import yuyu.def.direct.comparator.OrderMT_SousaRirekiSyousai;

public class SortMT_SousaRirekiSyousai {

    public List<MT_SousaRirekiSyousai> OrderMT_SousaRirekiSyousaiByPkAsc(List<MT_SousaRirekiSyousai> pEntity) {
        List<SortCondition<MT_SousaRirekiSyousai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_SousaRirekiSyousai()).ttdksikibetuid, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_SousaRirekiSyousai()).sousarirekirenno, SortOrder.ASC));
        List<MT_SousaRirekiSyousai> copyList = new ArrayList<MT_SousaRirekiSyousai>(pEntity);
        Collections.sort(copyList, new OrderMT_SousaRirekiSyousai(orders));
        return copyList;
    }

    public List<MT_SousaRirekiSyousai> OrderMT_SousaRirekiSyousaiByPkDesc(List<MT_SousaRirekiSyousai> pEntity) {
        List<SortCondition<MT_SousaRirekiSyousai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_SousaRirekiSyousai()).ttdksikibetuid, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_SousaRirekiSyousai()).sousarirekirenno, SortOrder.DESC));
        List<MT_SousaRirekiSyousai> copyList = new ArrayList<MT_SousaRirekiSyousai>(pEntity);
        Collections.sort(copyList, new OrderMT_SousaRirekiSyousai(orders));
        return copyList;
    }
}

package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkKykDairitenTuusanS;
import yuyu.def.db.entity.BM_ChkKykDairitenTuusanS;
import yuyu.def.db.meta.QBM_ChkKykDairitenTuusanS;

public class SortBM_ChkKykDairitenTuusanS {

    public List<BM_ChkKykDairitenTuusanS> OrderBM_ChkKykDairitenTuusanSByPkAsc(List<BM_ChkKykDairitenTuusanS> pEntity) {
        List<SortCondition<BM_ChkKykDairitenTuusanS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkKykDairitenTuusanS()).kihonssyuruikbn, SortOrder.ASC));
        List<BM_ChkKykDairitenTuusanS> copyList = new ArrayList<BM_ChkKykDairitenTuusanS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkKykDairitenTuusanS(orders));
        return copyList;
    }

    public List<BM_ChkKykDairitenTuusanS> OrderBM_ChkKykDairitenTuusanSByPkDesc(List<BM_ChkKykDairitenTuusanS> pEntity) {
        List<SortCondition<BM_ChkKykDairitenTuusanS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkKykDairitenTuusanS()).kihonssyuruikbn, SortOrder.DESC));
        List<BM_ChkKykDairitenTuusanS> copyList = new ArrayList<BM_ChkKykDairitenTuusanS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkKykDairitenTuusanS(orders));
        return copyList;
    }
}

package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_PalSyoumetujiyuu;
import yuyu.def.db.entity.BM_PalSyoumetujiyuu;
import yuyu.def.db.meta.QBM_PalSyoumetujiyuu;

public class SortBM_PalSyoumetujiyuu {

    public List<BM_PalSyoumetujiyuu> OrderBM_PalSyoumetujiyuuByPkAsc(List<BM_PalSyoumetujiyuu> pEntity) {
        List<SortCondition<BM_PalSyoumetujiyuu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_PalSyoumetujiyuu()).palsyoumetucd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_PalSyoumetujiyuu()).betukutikeiyakukbn, SortOrder.ASC));
        List<BM_PalSyoumetujiyuu> copyList = new ArrayList<BM_PalSyoumetujiyuu>(pEntity);
        Collections.sort(copyList, new OrderBM_PalSyoumetujiyuu(orders));
        return copyList;
    }

    public List<BM_PalSyoumetujiyuu> OrderBM_PalSyoumetujiyuuByPkDesc(List<BM_PalSyoumetujiyuu> pEntity) {
        List<SortCondition<BM_PalSyoumetujiyuu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_PalSyoumetujiyuu()).palsyoumetucd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_PalSyoumetujiyuu()).betukutikeiyakukbn, SortOrder.DESC));
        List<BM_PalSyoumetujiyuu> copyList = new ArrayList<BM_PalSyoumetujiyuu>(pEntity);
        Collections.sort(copyList, new OrderBM_PalSyoumetujiyuu(orders));
        return copyList;
    }
}

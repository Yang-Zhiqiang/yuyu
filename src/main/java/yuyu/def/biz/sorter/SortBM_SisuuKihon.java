package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SisuuKihon;
import yuyu.def.db.entity.BM_SisuuKihon;
import yuyu.def.db.meta.QBM_SisuuKihon;

public class SortBM_SisuuKihon {

    public List<BM_SisuuKihon> OrderBM_SisuuKihonByPkAsc(List<BM_SisuuKihon> pEntity) {
        List<SortCondition<BM_SisuuKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SisuuKihon()).sisuukbn, SortOrder.ASC));
        List<BM_SisuuKihon> copyList = new ArrayList<BM_SisuuKihon>(pEntity);
        Collections.sort(copyList, new OrderBM_SisuuKihon(orders));
        return copyList;
    }

    public List<BM_SisuuKihon> OrderBM_SisuuKihonByPkDesc(List<BM_SisuuKihon> pEntity) {
        List<SortCondition<BM_SisuuKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SisuuKihon()).sisuukbn, SortOrder.DESC));
        List<BM_SisuuKihon> copyList = new ArrayList<BM_SisuuKihon>(pEntity);
        Collections.sort(copyList, new OrderBM_SisuuKihon(orders));
        return copyList;
    }
}

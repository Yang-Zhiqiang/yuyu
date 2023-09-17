package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_Syokugyou;
import yuyu.def.db.entity.BM_Syokugyou;
import yuyu.def.db.meta.QBM_Syokugyou;

public class SortBM_Syokugyou {

    public List<BM_Syokugyou> OrderBM_SyokugyouByPkAsc(List<BM_Syokugyou> pEntity) {
        List<SortCondition<BM_Syokugyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Syokugyou()).syokugyoucd, SortOrder.ASC));
        List<BM_Syokugyou> copyList = new ArrayList<BM_Syokugyou>(pEntity);
        Collections.sort(copyList, new OrderBM_Syokugyou(orders));
        return copyList;
    }

    public List<BM_Syokugyou> OrderBM_SyokugyouByPkDesc(List<BM_Syokugyou> pEntity) {
        List<SortCondition<BM_Syokugyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Syokugyou()).syokugyoucd, SortOrder.DESC));
        List<BM_Syokugyou> copyList = new ArrayList<BM_Syokugyou>(pEntity);
        Collections.sort(copyList, new OrderBM_Syokugyou(orders));
        return copyList;
    }

}


package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkSyokugyou;
import yuyu.def.db.entity.BM_ChkSyokugyou;
import yuyu.def.db.meta.QBM_ChkSyokugyou;

public class SortBM_ChkSyokugyou {

    public List<BM_ChkSyokugyou> OrderBM_ChkSyokugyouByPkAsc(List<BM_ChkSyokugyou> pEntity) {
        List<SortCondition<BM_ChkSyokugyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkSyokugyou()).syokugyoucd, SortOrder.ASC));
        List<BM_ChkSyokugyou> copyList = new ArrayList<BM_ChkSyokugyou>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkSyokugyou(orders));
        return copyList;
    }

    public List<BM_ChkSyokugyou> OrderBM_ChkSyokugyouByPkDesc(List<BM_ChkSyokugyou> pEntity) {
        List<SortCondition<BM_ChkSyokugyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkSyokugyou()).syokugyoucd, SortOrder.DESC));
        List<BM_ChkSyokugyou> copyList = new ArrayList<BM_ChkSyokugyou>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkSyokugyou(orders));
        return copyList;
    }
}

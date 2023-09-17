package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_BosyuuKyuusi;
import yuyu.def.db.entity.BM_BosyuuKyuusi;
import yuyu.def.db.meta.QBM_BosyuuKyuusi;

public class SortBM_BosyuuKyuusi {

    public List<BM_BosyuuKyuusi> OrderBM_BosyuuKyuusiByPkAsc(List<BM_BosyuuKyuusi> pEntity) {
        List<SortCondition<BM_BosyuuKyuusi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_BosyuuKyuusi()).sksyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_BosyuuKyuusi()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_BosyuuKyuusi()).yoteiriritutkybr1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_BosyuuKyuusi()).yoteiriritutkybr2, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_BosyuuKyuusi()).skeijimukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_BosyuuKyuusi()).hanteiyuusendo, SortOrder.ASC));
        List<BM_BosyuuKyuusi> copyList = new ArrayList<BM_BosyuuKyuusi>(pEntity);
        Collections.sort(copyList, new OrderBM_BosyuuKyuusi(orders));
        return copyList;
    }

    public List<BM_BosyuuKyuusi> OrderBM_BosyuuKyuusiByPkDesc(List<BM_BosyuuKyuusi> pEntity) {
        List<SortCondition<BM_BosyuuKyuusi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_BosyuuKyuusi()).sksyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_BosyuuKyuusi()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_BosyuuKyuusi()).yoteiriritutkybr1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_BosyuuKyuusi()).yoteiriritutkybr2, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_BosyuuKyuusi()).skeijimukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_BosyuuKyuusi()).hanteiyuusendo, SortOrder.DESC));
        List<BM_BosyuuKyuusi> copyList = new ArrayList<BM_BosyuuKyuusi>(pEntity);
        Collections.sort(copyList, new OrderBM_BosyuuKyuusi(orders));
        return copyList;
    }
}

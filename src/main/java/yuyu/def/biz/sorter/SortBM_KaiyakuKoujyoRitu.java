package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_KaiyakuKoujyoRitu;
import yuyu.def.db.entity.BM_KaiyakuKoujyoRitu;
import yuyu.def.db.meta.QBM_KaiyakuKoujyoRitu;

public class SortBM_KaiyakuKoujyoRitu {

    public List<BM_KaiyakuKoujyoRitu> OrderBM_KaiyakuKoujyoRituByPkAsc(List<BM_KaiyakuKoujyoRitu> pEntity) {
        List<SortCondition<BM_KaiyakuKoujyoRitu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_KaiyakuKoujyoRitu()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_KaiyakuKoujyoRitu()).ryouritusdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_KaiyakuKoujyoRitu()).kaiyakukjtkybr1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_KaiyakuKoujyoRitu()).kaiyakukjtkybr2, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_KaiyakuKoujyoRitu()).keikanensuu, SortOrder.ASC));
        List<BM_KaiyakuKoujyoRitu> copyList = new ArrayList<BM_KaiyakuKoujyoRitu>(pEntity);
        Collections.sort(copyList, new OrderBM_KaiyakuKoujyoRitu(orders));
        return copyList;
    }

    public List<BM_KaiyakuKoujyoRitu> OrderBM_KaiyakuKoujyoRituByPkDesc(List<BM_KaiyakuKoujyoRitu> pEntity) {
        List<SortCondition<BM_KaiyakuKoujyoRitu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_KaiyakuKoujyoRitu()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_KaiyakuKoujyoRitu()).ryouritusdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_KaiyakuKoujyoRitu()).kaiyakukjtkybr1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_KaiyakuKoujyoRitu()).kaiyakukjtkybr2, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_KaiyakuKoujyoRitu()).keikanensuu, SortOrder.DESC));
        List<BM_KaiyakuKoujyoRitu> copyList = new ArrayList<BM_KaiyakuKoujyoRitu>(pEntity);
        Collections.sort(copyList, new OrderBM_KaiyakuKoujyoRitu(orders));
        return copyList;
    }

}


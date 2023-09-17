package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.meta.QBM_SjkkkTyouseiyouRiritu2;

public class SortBM_SjkkkTyouseiyouRiritu2 {

    public List<BM_SjkkkTyouseiyouRiritu2> OrderBM_SjkkkTyouseiyouRiritu2ByPkAsc(List<BM_SjkkkTyouseiyouRiritu2> pEntity) {
        List<SortCondition<BM_SjkkkTyouseiyouRiritu2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu2()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu2()).sjkkktyouseiriritutkybr1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu2()).sjkkktyouseiriritutkybr2, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu2()).kijyunfromymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu2()).kijyuntoymd, SortOrder.ASC));
        List<BM_SjkkkTyouseiyouRiritu2> copyList = new ArrayList<BM_SjkkkTyouseiyouRiritu2>(pEntity);
        Collections.sort(copyList, new OrderBM_SjkkkTyouseiyouRiritu2(orders));
        return copyList;
    }

    public List<BM_SjkkkTyouseiyouRiritu2> OrderBM_SjkkkTyouseiyouRiritu2ByPkDesc(List<BM_SjkkkTyouseiyouRiritu2> pEntity) {
        List<SortCondition<BM_SjkkkTyouseiyouRiritu2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu2()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu2()).sjkkktyouseiriritutkybr1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu2()).sjkkktyouseiriritutkybr2, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu2()).kijyunfromymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SjkkkTyouseiyouRiritu2()).kijyuntoymd, SortOrder.DESC));
        List<BM_SjkkkTyouseiyouRiritu2> copyList = new ArrayList<BM_SjkkkTyouseiyouRiritu2>(pEntity);
        Collections.sort(copyList, new OrderBM_SjkkkTyouseiyouRiritu2(orders));
        return copyList;
    }
}

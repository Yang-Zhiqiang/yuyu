package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_YoteiRiritu2;
import yuyu.def.db.entity.BM_YoteiRiritu2;
import yuyu.def.db.meta.QBM_YoteiRiritu2;

public class SortBM_YoteiRiritu2 {

    public List<BM_YoteiRiritu2> OrderBM_YoteiRiritu2ByPkAsc(List<BM_YoteiRiritu2> pEntity) {
        List<SortCondition<BM_YoteiRiritu2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_YoteiRiritu2()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu2()).yoteiriritutkybr1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu2()).yoteiriritutkybr2, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu2()).kijyunfromymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu2()).kijyuntoymd, SortOrder.ASC));
        List<BM_YoteiRiritu2> copyList = new ArrayList<BM_YoteiRiritu2>(pEntity);
        Collections.sort(copyList, new OrderBM_YoteiRiritu2(orders));
        return copyList;
    }

    public List<BM_YoteiRiritu2> OrderBM_YoteiRiritu2ByPkDesc(List<BM_YoteiRiritu2> pEntity) {
        List<SortCondition<BM_YoteiRiritu2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_YoteiRiritu2()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu2()).yoteiriritutkybr1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu2()).yoteiriritutkybr2, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu2()).kijyunfromymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu2()).kijyuntoymd, SortOrder.DESC));
        List<BM_YoteiRiritu2> copyList = new ArrayList<BM_YoteiRiritu2>(pEntity);
        Collections.sort(copyList, new OrderBM_YoteiRiritu2(orders));
        return copyList;
    }
}

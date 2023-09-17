package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_YoteiRiritu3;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.def.db.meta.QBM_YoteiRiritu3;

public class SortBM_YoteiRiritu3 {

    public List<BM_YoteiRiritu3> OrderBM_YoteiRiritu3ByPkAsc(List<BM_YoteiRiritu3> pEntity) {
        List<SortCondition<BM_YoteiRiritu3>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_YoteiRiritu3()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu3()).tuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu3()).yoteiriritutkybr1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu3()).yoteiriritutkybr2, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu3()).kijyunfromymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu3()).kijyuntoymd, SortOrder.ASC));
        List<BM_YoteiRiritu3> copyList = new ArrayList<BM_YoteiRiritu3>(pEntity);
        Collections.sort(copyList, new OrderBM_YoteiRiritu3(orders));
        return copyList;
    }

    public List<BM_YoteiRiritu3> OrderBM_YoteiRiritu3ByPkDesc(List<BM_YoteiRiritu3> pEntity) {
        List<SortCondition<BM_YoteiRiritu3>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_YoteiRiritu3()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu3()).tuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu3()).yoteiriritutkybr1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu3()).yoteiriritutkybr2, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu3()).kijyunfromymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_YoteiRiritu3()).kijyuntoymd, SortOrder.DESC));
        List<BM_YoteiRiritu3> copyList = new ArrayList<BM_YoteiRiritu3>(pEntity);
        Collections.sort(copyList, new OrderBM_YoteiRiritu3(orders));
        return copyList;
    }
}

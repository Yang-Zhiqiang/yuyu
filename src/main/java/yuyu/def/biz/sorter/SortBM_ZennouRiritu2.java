package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ZennouRiritu2;
import yuyu.def.db.entity.BM_ZennouRiritu2;
import yuyu.def.db.meta.QBM_ZennouRiritu2;

public class SortBM_ZennouRiritu2 {

    public List<BM_ZennouRiritu2> OrderBM_ZennouRiritu2ByPkAsc(List<BM_ZennouRiritu2> pEntity) {
        List<SortCondition<BM_ZennouRiritu2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ZennouRiritu2()).tuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouRiritu2()).zennoutkybr1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouRiritu2()).zennoutkybr2, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouRiritu2()).zennoutkybr3, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouRiritu2()).tekiyoukknfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouRiritu2()).tekiyoukknkto, SortOrder.ASC));
        List<BM_ZennouRiritu2> copyList = new ArrayList<BM_ZennouRiritu2>(pEntity);
        Collections.sort(copyList, new OrderBM_ZennouRiritu2(orders));
        return copyList;
    }

    public List<BM_ZennouRiritu2> OrderBM_ZennouRiritu2ByPkDesc(List<BM_ZennouRiritu2> pEntity) {
        List<SortCondition<BM_ZennouRiritu2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ZennouRiritu2()).tuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouRiritu2()).zennoutkybr1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouRiritu2()).zennoutkybr2, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouRiritu2()).zennoutkybr3, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouRiritu2()).tekiyoukknfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouRiritu2()).tekiyoukknkto, SortOrder.DESC));
        List<BM_ZennouRiritu2> copyList = new ArrayList<BM_ZennouRiritu2>(pEntity);
        Collections.sort(copyList, new OrderBM_ZennouRiritu2(orders));
        return copyList;
    }
}

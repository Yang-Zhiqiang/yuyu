package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ZennouGenkaRitu2;
import yuyu.def.db.entity.BM_ZennouGenkaRitu2;
import yuyu.def.db.meta.QBM_ZennouGenkaRitu2;

public class SortBM_ZennouGenkaRitu2 {

    public List<BM_ZennouGenkaRitu2> OrderBM_ZennouGenkaRitu2ByPkAsc(List<BM_ZennouGenkaRitu2> pEntity) {
        List<SortCondition<BM_ZennouGenkaRitu2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu2()).tuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu2()).zennoutkybr1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu2()).zennoutkybr2, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu2()).zennoutkybr3, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu2()).zennounensuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu2()).tekiyoukknfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu2()).tekiyoukknkto, SortOrder.ASC));
        List<BM_ZennouGenkaRitu2> copyList = new ArrayList<BM_ZennouGenkaRitu2>(pEntity);
        Collections.sort(copyList, new OrderBM_ZennouGenkaRitu2(orders));
        return copyList;
    }

    public List<BM_ZennouGenkaRitu2> OrderBM_ZennouGenkaRitu2ByPkDesc(List<BM_ZennouGenkaRitu2> pEntity) {
        List<SortCondition<BM_ZennouGenkaRitu2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu2()).tuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu2()).zennoutkybr1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu2()).zennoutkybr2, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu2()).zennoutkybr3, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu2()).zennounensuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu2()).tekiyoukknfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu2()).tekiyoukknkto, SortOrder.DESC));
        List<BM_ZennouGenkaRitu2> copyList = new ArrayList<BM_ZennouGenkaRitu2>(pEntity);
        Collections.sort(copyList, new OrderBM_ZennouGenkaRitu2(orders));
        return copyList;
    }
}

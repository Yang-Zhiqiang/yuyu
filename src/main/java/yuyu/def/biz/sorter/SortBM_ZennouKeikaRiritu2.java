package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ZennouKeikaRiritu2;
import yuyu.def.db.entity.BM_ZennouKeikaRiritu2;
import yuyu.def.db.meta.QBM_ZennouKeikaRiritu2;

public class SortBM_ZennouKeikaRiritu2 {

    public List<BM_ZennouKeikaRiritu2> OrderBM_ZennouKeikaRiritu2ByPkAsc(List<BM_ZennouKeikaRiritu2> pEntity) {
        List<SortCondition<BM_ZennouKeikaRiritu2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu2()).tuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu2()).zennoutkybr1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu2()).zennoutkybr2, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu2()).zennoutkybr3, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu2()).keikatukisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu2()).tekiyoukknfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu2()).tekiyoukknkto, SortOrder.ASC));
        List<BM_ZennouKeikaRiritu2> copyList = new ArrayList<BM_ZennouKeikaRiritu2>(pEntity);
        Collections.sort(copyList, new OrderBM_ZennouKeikaRiritu2(orders));
        return copyList;
    }

    public List<BM_ZennouKeikaRiritu2> OrderBM_ZennouKeikaRiritu2ByPkDesc(List<BM_ZennouKeikaRiritu2> pEntity) {
        List<SortCondition<BM_ZennouKeikaRiritu2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu2()).tuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu2()).zennoutkybr1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu2()).zennoutkybr2, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu2()).zennoutkybr3, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu2()).keikatukisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu2()).tekiyoukknfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu2()).tekiyoukknkto, SortOrder.DESC));
        List<BM_ZennouKeikaRiritu2> copyList = new ArrayList<BM_ZennouKeikaRiritu2>(pEntity);
        Collections.sort(copyList, new OrderBM_ZennouKeikaRiritu2(orders));
        return copyList;
    }
}

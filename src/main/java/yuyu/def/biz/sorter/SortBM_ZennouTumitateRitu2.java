package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ZennouTumitateRitu2;
import yuyu.def.db.entity.BM_ZennouTumitateRitu2;
import yuyu.def.db.meta.QBM_ZennouTumitateRitu2;

public class SortBM_ZennouTumitateRitu2 {

    public List<BM_ZennouTumitateRitu2> OrderBM_ZennouTumitateRitu2ByPkAsc(List<BM_ZennouTumitateRitu2> pEntity) {
        List<SortCondition<BM_ZennouTumitateRitu2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ZennouTumitateRitu2()).tuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouTumitateRitu2()).zennoutkybr1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouTumitateRitu2()).zennoutkybr2, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouTumitateRitu2()).zennoutkybr3, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouTumitateRitu2()).tekiyoukknfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouTumitateRitu2()).tekiyoukknkto, SortOrder.ASC));
        List<BM_ZennouTumitateRitu2> copyList = new ArrayList<BM_ZennouTumitateRitu2>(pEntity);
        Collections.sort(copyList, new OrderBM_ZennouTumitateRitu2(orders));
        return copyList;
    }

    public List<BM_ZennouTumitateRitu2> OrderBM_ZennouTumitateRitu2ByPkDesc(List<BM_ZennouTumitateRitu2> pEntity) {
        List<SortCondition<BM_ZennouTumitateRitu2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ZennouTumitateRitu2()).tuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouTumitateRitu2()).zennoutkybr1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouTumitateRitu2()).zennoutkybr2, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouTumitateRitu2()).zennoutkybr3, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouTumitateRitu2()).tekiyoukknfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouTumitateRitu2()).tekiyoukknkto, SortOrder.DESC));
        List<BM_ZennouTumitateRitu2> copyList = new ArrayList<BM_ZennouTumitateRitu2>(pEntity);
        Collections.sort(copyList, new OrderBM_ZennouTumitateRitu2(orders));
        return copyList;
    }
}

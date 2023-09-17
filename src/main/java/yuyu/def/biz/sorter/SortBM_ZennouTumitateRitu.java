package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ZennouTumitateRitu;
import yuyu.def.db.entity.BM_ZennouTumitateRitu;
import yuyu.def.db.meta.QBM_ZennouTumitateRitu;

public class SortBM_ZennouTumitateRitu {

    public List<BM_ZennouTumitateRitu> OrderBM_ZennouTumitateRituByPkAsc(List<BM_ZennouTumitateRitu> pEntity) {
        List<SortCondition<BM_ZennouTumitateRitu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ZennouTumitateRitu()).tekiyoukknfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouTumitateRitu()).tekiyoukknkto, SortOrder.ASC));
        List<BM_ZennouTumitateRitu> copyList = new ArrayList<BM_ZennouTumitateRitu>(pEntity);
        Collections.sort(copyList, new OrderBM_ZennouTumitateRitu(orders));
        return copyList;
    }

    public List<BM_ZennouTumitateRitu> OrderBM_ZennouTumitateRituByPkDesc(List<BM_ZennouTumitateRitu> pEntity) {
        List<SortCondition<BM_ZennouTumitateRitu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ZennouTumitateRitu()).tekiyoukknfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouTumitateRitu()).tekiyoukknkto, SortOrder.DESC));
        List<BM_ZennouTumitateRitu> copyList = new ArrayList<BM_ZennouTumitateRitu>(pEntity);
        Collections.sort(copyList, new OrderBM_ZennouTumitateRitu(orders));
        return copyList;
    }
}

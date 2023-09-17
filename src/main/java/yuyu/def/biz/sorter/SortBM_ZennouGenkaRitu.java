package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ZennouGenkaRitu;
import yuyu.def.db.entity.BM_ZennouGenkaRitu;
import yuyu.def.db.meta.QBM_ZennouGenkaRitu;

public class SortBM_ZennouGenkaRitu {

    public List<BM_ZennouGenkaRitu> OrderBM_ZennouGenkaRituByPkAsc(List<BM_ZennouGenkaRitu> pEntity) {
        List<SortCondition<BM_ZennouGenkaRitu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu()).zennounensuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu()).tekiyoukknfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu()).tekiyoukknkto, SortOrder.ASC));
        List<BM_ZennouGenkaRitu> copyList = new ArrayList<BM_ZennouGenkaRitu>(pEntity);
        Collections.sort(copyList, new OrderBM_ZennouGenkaRitu(orders));
        return copyList;
    }

    public List<BM_ZennouGenkaRitu> OrderBM_ZennouGenkaRituByPkDesc(List<BM_ZennouGenkaRitu> pEntity) {
        List<SortCondition<BM_ZennouGenkaRitu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu()).zennounensuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu()).tekiyoukknfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouGenkaRitu()).tekiyoukknkto, SortOrder.DESC));
        List<BM_ZennouGenkaRitu> copyList = new ArrayList<BM_ZennouGenkaRitu>(pEntity);
        Collections.sort(copyList, new OrderBM_ZennouGenkaRitu(orders));
        return copyList;
    }
}

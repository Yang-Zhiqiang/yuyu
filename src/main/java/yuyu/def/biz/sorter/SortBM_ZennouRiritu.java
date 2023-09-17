package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ZennouRiritu;
import yuyu.def.db.entity.BM_ZennouRiritu;
import yuyu.def.db.meta.QBM_ZennouRiritu;

public class SortBM_ZennouRiritu {

    public List<BM_ZennouRiritu> OrderBM_ZennouRirituByPkAsc(List<BM_ZennouRiritu> pEntity) {
        List<SortCondition<BM_ZennouRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ZennouRiritu()).tekiyoukknfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouRiritu()).tekiyoukknkto, SortOrder.ASC));
        List<BM_ZennouRiritu> copyList = new ArrayList<BM_ZennouRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_ZennouRiritu(orders));
        return copyList;
    }

    public List<BM_ZennouRiritu> OrderBM_ZennouRirituByPkDesc(List<BM_ZennouRiritu> pEntity) {
        List<SortCondition<BM_ZennouRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ZennouRiritu()).tekiyoukknfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouRiritu()).tekiyoukknkto, SortOrder.DESC));
        List<BM_ZennouRiritu> copyList = new ArrayList<BM_ZennouRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_ZennouRiritu(orders));
        return copyList;
    }
}

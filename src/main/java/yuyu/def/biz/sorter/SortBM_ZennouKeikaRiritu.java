package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ZennouKeikaRiritu;
import yuyu.def.db.entity.BM_ZennouKeikaRiritu;
import yuyu.def.db.meta.QBM_ZennouKeikaRiritu;

public class SortBM_ZennouKeikaRiritu {

    public List<BM_ZennouKeikaRiritu> OrderBM_ZennouKeikaRirituByPkAsc(List<BM_ZennouKeikaRiritu> pEntity) {
        List<SortCondition<BM_ZennouKeikaRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu()).keikatukisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu()).tekiyoukknfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu()).tekiyoukknkto, SortOrder.ASC));
        List<BM_ZennouKeikaRiritu> copyList = new ArrayList<BM_ZennouKeikaRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_ZennouKeikaRiritu(orders));
        return copyList;
    }

    public List<BM_ZennouKeikaRiritu> OrderBM_ZennouKeikaRirituByPkDesc(List<BM_ZennouKeikaRiritu> pEntity) {
        List<SortCondition<BM_ZennouKeikaRiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu()).keikatukisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu()).tekiyoukknfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ZennouKeikaRiritu()).tekiyoukknkto, SortOrder.DESC));
        List<BM_ZennouKeikaRiritu> copyList = new ArrayList<BM_ZennouKeikaRiritu>(pEntity);
        Collections.sort(copyList, new OrderBM_ZennouKeikaRiritu(orders));
        return copyList;
    }
}

package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_KijyungkHanteiKawaseRate;
import yuyu.def.db.entity.BM_KijyungkHanteiKawaseRate;
import yuyu.def.db.meta.QBM_KijyungkHanteiKawaseRate;

public class SortBM_KijyungkHanteiKawaseRate {

    public List<BM_KijyungkHanteiKawaseRate> OrderBM_KijyungkHanteiKawaseRateByPkAsc(List<BM_KijyungkHanteiKawaseRate> pEntity) {
        List<SortCondition<BM_KijyungkHanteiKawaseRate>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_KijyungkHanteiKawaseRate()).kijunnendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_KijyungkHanteiKawaseRate()).kyktuukasyu, SortOrder.ASC));
        List<BM_KijyungkHanteiKawaseRate> copyList = new ArrayList<BM_KijyungkHanteiKawaseRate>(pEntity);
        Collections.sort(copyList, new OrderBM_KijyungkHanteiKawaseRate(orders));
        return copyList;
    }

    public List<BM_KijyungkHanteiKawaseRate> OrderBM_KijyungkHanteiKawaseRateByPkDesc(List<BM_KijyungkHanteiKawaseRate> pEntity) {
        List<SortCondition<BM_KijyungkHanteiKawaseRate>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_KijyungkHanteiKawaseRate()).kijunnendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_KijyungkHanteiKawaseRate()).kyktuukasyu, SortOrder.DESC));
        List<BM_KijyungkHanteiKawaseRate> copyList = new ArrayList<BM_KijyungkHanteiKawaseRate>(pEntity);
        Collections.sort(copyList, new OrderBM_KijyungkHanteiKawaseRate(orders));
        return copyList;
    }
}

package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_DairitenMinyuKykMeisai;
import yuyu.def.db.meta.QIT_DairitenMinyuKykMeisai;
import yuyu.def.hozen.comparator.OrderIT_DairitenMinyuKykMeisai;

public class SortIT_DairitenMinyuKykMeisai {

    public List<IT_DairitenMinyuKykMeisai> OrderIT_DairitenMinyuKykMeisaiByPkAsc(List<IT_DairitenMinyuKykMeisai> pEntity) {
        List<SortCondition<IT_DairitenMinyuKykMeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_DairitenMinyuKykMeisai()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_DairitenMinyuKykMeisai()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_DairitenMinyuKykMeisai()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_DairitenMinyuKykMeisai()).drtenrenno, SortOrder.ASC));
        List<IT_DairitenMinyuKykMeisai> copyList = new ArrayList<IT_DairitenMinyuKykMeisai>(pEntity);
        Collections.sort(copyList, new OrderIT_DairitenMinyuKykMeisai(orders));
        return copyList;
    }

    public List<IT_DairitenMinyuKykMeisai> OrderIT_DairitenMinyuKykMeisaiByPkDesc(List<IT_DairitenMinyuKykMeisai> pEntity) {
        List<SortCondition<IT_DairitenMinyuKykMeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_DairitenMinyuKykMeisai()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_DairitenMinyuKykMeisai()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_DairitenMinyuKykMeisai()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_DairitenMinyuKykMeisai()).drtenrenno, SortOrder.DESC));
        List<IT_DairitenMinyuKykMeisai> copyList = new ArrayList<IT_DairitenMinyuKykMeisai>(pEntity);
        Collections.sort(copyList, new OrderIT_DairitenMinyuKykMeisai(orders));
        return copyList;
    }
}

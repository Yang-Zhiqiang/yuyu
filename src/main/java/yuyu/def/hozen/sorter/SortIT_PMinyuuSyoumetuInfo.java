package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_PMinyuuSyoumetuInfo;
import yuyu.def.db.meta.QIT_PMinyuuSyoumetuInfo;
import yuyu.def.hozen.comparator.OrderIT_PMinyuuSyoumetuInfo;

public class SortIT_PMinyuuSyoumetuInfo {

    public List<IT_PMinyuuSyoumetuInfo> OrderIT_PMinyuuSyoumetuInfoByPkAsc(List<IT_PMinyuuSyoumetuInfo> pEntity) {
        List<SortCondition<IT_PMinyuuSyoumetuInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_PMinyuuSyoumetuInfo()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_PMinyuuSyoumetuInfo()).syono, SortOrder.ASC));
        List<IT_PMinyuuSyoumetuInfo> copyList = new ArrayList<IT_PMinyuuSyoumetuInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_PMinyuuSyoumetuInfo(orders));
        return copyList;
    }

    public List<IT_PMinyuuSyoumetuInfo> OrderIT_PMinyuuSyoumetuInfoByPkDesc(List<IT_PMinyuuSyoumetuInfo> pEntity) {
        List<SortCondition<IT_PMinyuuSyoumetuInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_PMinyuuSyoumetuInfo()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_PMinyuuSyoumetuInfo()).syono, SortOrder.DESC));
        List<IT_PMinyuuSyoumetuInfo> copyList = new ArrayList<IT_PMinyuuSyoumetuInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_PMinyuuSyoumetuInfo(orders));
        return copyList;
    }
}

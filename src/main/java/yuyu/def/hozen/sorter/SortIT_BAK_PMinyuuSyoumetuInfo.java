package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_PMinyuuSyoumetuInfo;
import yuyu.def.db.meta.QIT_BAK_PMinyuuSyoumetuInfo;
import yuyu.def.hozen.comparator.OrderIT_BAK_PMinyuuSyoumetuInfo;

public class SortIT_BAK_PMinyuuSyoumetuInfo {

    public List<IT_BAK_PMinyuuSyoumetuInfo> OrderIT_BAK_PMinyuuSyoumetuInfoByPkAsc(List<IT_BAK_PMinyuuSyoumetuInfo> pEntity) {
        List<SortCondition<IT_BAK_PMinyuuSyoumetuInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_PMinyuuSyoumetuInfo()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_PMinyuuSyoumetuInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_PMinyuuSyoumetuInfo()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_PMinyuuSyoumetuInfo> copyList = new ArrayList<IT_BAK_PMinyuuSyoumetuInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_PMinyuuSyoumetuInfo(orders));
        return copyList;
    }

    public List<IT_BAK_PMinyuuSyoumetuInfo> OrderIT_BAK_PMinyuuSyoumetuInfoByPkDesc(List<IT_BAK_PMinyuuSyoumetuInfo> pEntity) {
        List<SortCondition<IT_BAK_PMinyuuSyoumetuInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_PMinyuuSyoumetuInfo()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_PMinyuuSyoumetuInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_PMinyuuSyoumetuInfo()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_PMinyuuSyoumetuInfo> copyList = new ArrayList<IT_BAK_PMinyuuSyoumetuInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_PMinyuuSyoumetuInfo(orders));
        return copyList;
    }
}

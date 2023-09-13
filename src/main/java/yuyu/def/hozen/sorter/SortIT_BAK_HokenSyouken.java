package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_HokenSyouken;
import yuyu.def.db.meta.QIT_BAK_HokenSyouken;
import yuyu.def.hozen.comparator.OrderIT_BAK_HokenSyouken;

public class SortIT_BAK_HokenSyouken {

    public List<IT_BAK_HokenSyouken> OrderIT_BAK_HokenSyoukenByPkAsc(List<IT_BAK_HokenSyouken> pEntity) {
        List<SortCondition<IT_BAK_HokenSyouken>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HokenSyouken()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenSyouken()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenSyouken()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenSyouken()).tyouhyouymd, SortOrder.ASC));
        List<IT_BAK_HokenSyouken> copyList = new ArrayList<IT_BAK_HokenSyouken>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HokenSyouken(orders));
        return copyList;
    }

    public List<IT_BAK_HokenSyouken> OrderIT_BAK_HokenSyoukenByPkDesc(List<IT_BAK_HokenSyouken> pEntity) {
        List<SortCondition<IT_BAK_HokenSyouken>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HokenSyouken()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenSyouken()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenSyouken()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenSyouken()).tyouhyouymd, SortOrder.DESC));
        List<IT_BAK_HokenSyouken> copyList = new ArrayList<IT_BAK_HokenSyouken>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HokenSyouken(orders));
        return copyList;
    }

}


package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.meta.QIT_HokenSyouken;
import yuyu.def.hozen.comparator.OrderIT_HokenSyouken;

public class SortIT_HokenSyouken {

    public List<IT_HokenSyouken> OrderIT_HokenSyoukenByPkAsc(List<IT_HokenSyouken> pEntity) {
        List<SortCondition<IT_HokenSyouken>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HokenSyouken()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HokenSyouken()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HokenSyouken()).tyouhyouymd, SortOrder.ASC));
        List<IT_HokenSyouken> copyList = new ArrayList<IT_HokenSyouken>(pEntity);
        Collections.sort(copyList, new OrderIT_HokenSyouken(orders));
        return copyList;
    }

    public List<IT_HokenSyouken> OrderIT_HokenSyoukenByPkDesc(List<IT_HokenSyouken> pEntity) {
        List<SortCondition<IT_HokenSyouken>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HokenSyouken()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HokenSyouken()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HokenSyouken()).tyouhyouymd, SortOrder.DESC));
        List<IT_HokenSyouken> copyList = new ArrayList<IT_HokenSyouken>(pEntity);
        Collections.sort(copyList, new OrderIT_HokenSyouken(orders));
        return copyList;
    }

}


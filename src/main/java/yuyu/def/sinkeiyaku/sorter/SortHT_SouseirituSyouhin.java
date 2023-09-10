package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SouseirituSyouhin;
import yuyu.def.db.meta.QHT_SouseirituSyouhin;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SouseirituSyouhin;

public class SortHT_SouseirituSyouhin {

    
    public List<HT_SouseirituSyouhin> OrderHT_SouseirituSyouhinByPkAsc(List<HT_SouseirituSyouhin> pEntity) {
        List<SortCondition<HT_SouseirituSyouhin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SouseirituSyouhin()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SouseirituSyouhin()).syouhncd, SortOrder.ASC));
        List<HT_SouseirituSyouhin> copyList = new ArrayList<HT_SouseirituSyouhin>(pEntity);
        Collections.sort(copyList, new OrderHT_SouseirituSyouhin(orders));
        return copyList;
    }

    
    public List<HT_SouseirituSyouhin> OrderHT_SouseirituSyouhinByPkDesc(List<HT_SouseirituSyouhin> pEntity) {
        List<SortCondition<HT_SouseirituSyouhin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SouseirituSyouhin()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SouseirituSyouhin()).syouhncd, SortOrder.DESC));
        List<HT_SouseirituSyouhin> copyList = new ArrayList<HT_SouseirituSyouhin>(pEntity);
        Collections.sort(copyList, new OrderHT_SouseirituSyouhin(orders));
        return copyList;
    }

}


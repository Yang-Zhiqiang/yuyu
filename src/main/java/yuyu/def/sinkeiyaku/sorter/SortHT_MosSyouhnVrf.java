package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_MosSyouhnVrf;
import yuyu.def.db.meta.QHT_MosSyouhnVrf;
import yuyu.def.sinkeiyaku.comparator.OrderHT_MosSyouhnVrf;

public class SortHT_MosSyouhnVrf {

    
    public List<HT_MosSyouhnVrf> OrderHT_MosSyouhnVrfByPkAsc(List<HT_MosSyouhnVrf> pEntity) {
        List<SortCondition<HT_MosSyouhnVrf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosSyouhnVrf()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_MosSyouhnVrf()).syouhncd, SortOrder.ASC));
        List<HT_MosSyouhnVrf> copyList = new ArrayList<HT_MosSyouhnVrf>(pEntity);
        Collections.sort(copyList, new OrderHT_MosSyouhnVrf(orders));
        return copyList;
    }

    
    public List<HT_MosSyouhnVrf> OrderHT_MosSyouhnVrfByPkDesc(List<HT_MosSyouhnVrf> pEntity) {
        List<SortCondition<HT_MosSyouhnVrf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosSyouhnVrf()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_MosSyouhnVrf()).syouhncd, SortOrder.DESC));
        List<HT_MosSyouhnVrf> copyList = new ArrayList<HT_MosSyouhnVrf>(pEntity);
        Collections.sort(copyList, new OrderHT_MosSyouhnVrf(orders));
        return copyList;
    }

}


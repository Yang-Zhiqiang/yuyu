package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_MosDairitenVrf;
import yuyu.def.db.meta.QHT_MosDairitenVrf;
import yuyu.def.sinkeiyaku.comparator.OrderHT_MosDairitenVrf;

public class SortHT_MosDairitenVrf {

    
    public List<HT_MosDairitenVrf> OrderHT_MosDairitenVrfByPkAsc(List<HT_MosDairitenVrf> pEntity) {
        List<SortCondition<HT_MosDairitenVrf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosDairitenVrf()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_MosDairitenVrf()).renno, SortOrder.ASC));
        List<HT_MosDairitenVrf> copyList = new ArrayList<HT_MosDairitenVrf>(pEntity);
        Collections.sort(copyList, new OrderHT_MosDairitenVrf(orders));
        return copyList;
    }

    
    public List<HT_MosDairitenVrf> OrderHT_MosDairitenVrfByPkDesc(List<HT_MosDairitenVrf> pEntity) {
        List<SortCondition<HT_MosDairitenVrf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosDairitenVrf()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_MosDairitenVrf()).renno, SortOrder.DESC));
        List<HT_MosDairitenVrf> copyList = new ArrayList<HT_MosDairitenVrf>(pEntity);
        Collections.sort(copyList, new OrderHT_MosDairitenVrf(orders));
        return copyList;
    }

}


package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_MosTrkKzkVrf;
import yuyu.def.db.meta.QHT_MosTrkKzkVrf;
import yuyu.def.sinkeiyaku.comparator.OrderHT_MosTrkKzkVrf;

public class SortHT_MosTrkKzkVrf {

    
    public List<HT_MosTrkKzkVrf> OrderHT_MosTrkKzkVrfByPkAsc(List<HT_MosTrkKzkVrf> pEntity) {
        List<SortCondition<HT_MosTrkKzkVrf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosTrkKzkVrf()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_MosTrkKzkVrf()).trkkzkkbn, SortOrder.ASC));
        List<HT_MosTrkKzkVrf> copyList = new ArrayList<HT_MosTrkKzkVrf>(pEntity);
        Collections.sort(copyList, new OrderHT_MosTrkKzkVrf(orders));
        return copyList;
    }

    
    public List<HT_MosTrkKzkVrf> OrderHT_MosTrkKzkVrfByPkDesc(List<HT_MosTrkKzkVrf> pEntity) {
        List<SortCondition<HT_MosTrkKzkVrf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosTrkKzkVrf()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_MosTrkKzkVrf()).trkkzkkbn, SortOrder.DESC));
        List<HT_MosTrkKzkVrf> copyList = new ArrayList<HT_MosTrkKzkVrf>(pEntity);
        Collections.sort(copyList, new OrderHT_MosTrkKzkVrf(orders));
        return copyList;
    }
}

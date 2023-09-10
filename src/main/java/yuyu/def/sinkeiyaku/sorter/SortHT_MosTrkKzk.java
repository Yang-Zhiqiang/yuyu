package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.meta.QHT_MosTrkKzk;
import yuyu.def.sinkeiyaku.comparator.OrderHT_MosTrkKzk;

public class SortHT_MosTrkKzk {

    
    public List<HT_MosTrkKzk> OrderHT_MosTrkKzkByPkAsc(List<HT_MosTrkKzk> pEntity) {
        List<SortCondition<HT_MosTrkKzk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosTrkKzk()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_MosTrkKzk()).trkkzkkbn, SortOrder.ASC));
        List<HT_MosTrkKzk> copyList = new ArrayList<HT_MosTrkKzk>(pEntity);
        Collections.sort(copyList, new OrderHT_MosTrkKzk(orders));
        return copyList;
    }

    
    public List<HT_MosTrkKzk> OrderHT_MosTrkKzkByPkDesc(List<HT_MosTrkKzk> pEntity) {
        List<SortCondition<HT_MosTrkKzk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosTrkKzk()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_MosTrkKzk()).trkkzkkbn, SortOrder.DESC));
        List<HT_MosTrkKzk> copyList = new ArrayList<HT_MosTrkKzk>(pEntity);
        Collections.sort(copyList, new OrderHT_MosTrkKzk(orders));
        return copyList;
    }
}

package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_BosTrkKzk;
import yuyu.def.db.meta.QHT_BosTrkKzk;
import yuyu.def.sinkeiyaku.comparator.OrderHT_BosTrkKzk;

public class SortHT_BosTrkKzk {

    
    public List<HT_BosTrkKzk> OrderHT_BosTrkKzkByPkAsc(List<HT_BosTrkKzk> pEntity) {
        List<SortCondition<HT_BosTrkKzk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosTrkKzk()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_BosTrkKzk()).trkkzkkbn, SortOrder.ASC));
        List<HT_BosTrkKzk> copyList = new ArrayList<HT_BosTrkKzk>(pEntity);
        Collections.sort(copyList, new OrderHT_BosTrkKzk(orders));
        return copyList;
    }

    
    public List<HT_BosTrkKzk> OrderHT_BosTrkKzkByPkDesc(List<HT_BosTrkKzk> pEntity) {
        List<SortCondition<HT_BosTrkKzk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosTrkKzk()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_BosTrkKzk()).trkkzkkbn, SortOrder.DESC));
        List<HT_BosTrkKzk> copyList = new ArrayList<HT_BosTrkKzk>(pEntity);
        Collections.sort(copyList, new OrderHT_BosTrkKzk(orders));
        return copyList;
    }
}

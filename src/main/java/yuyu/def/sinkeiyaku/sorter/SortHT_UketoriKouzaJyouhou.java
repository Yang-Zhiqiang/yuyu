package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhou;
import yuyu.def.db.meta.QHT_UketoriKouzaJyouhou;
import yuyu.def.sinkeiyaku.comparator.OrderHT_UketoriKouzaJyouhou;

public class SortHT_UketoriKouzaJyouhou {

    
    public List<HT_UketoriKouzaJyouhou> OrderHT_UketoriKouzaJyouhouByPkAsc(List<HT_UketoriKouzaJyouhou> pEntity) {
        List<SortCondition<HT_UketoriKouzaJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_UketoriKouzaJyouhou()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_UketoriKouzaJyouhou()).uktkzsyubetukbn, SortOrder.ASC));
        List<HT_UketoriKouzaJyouhou> copyList = new ArrayList<HT_UketoriKouzaJyouhou>(pEntity);
        Collections.sort(copyList, new OrderHT_UketoriKouzaJyouhou(orders));
        return copyList;
    }

    
    public List<HT_UketoriKouzaJyouhou> OrderHT_UketoriKouzaJyouhouByPkDesc(List<HT_UketoriKouzaJyouhou> pEntity) {
        List<SortCondition<HT_UketoriKouzaJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_UketoriKouzaJyouhou()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_UketoriKouzaJyouhou()).uktkzsyubetukbn, SortOrder.DESC));
        List<HT_UketoriKouzaJyouhou> copyList = new ArrayList<HT_UketoriKouzaJyouhou>(pEntity);
        Collections.sort(copyList, new OrderHT_UketoriKouzaJyouhou(orders));
        return copyList;
    }

}


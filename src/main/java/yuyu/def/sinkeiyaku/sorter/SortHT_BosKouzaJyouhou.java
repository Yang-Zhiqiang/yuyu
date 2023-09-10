package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_BosKouzaJyouhou;
import yuyu.def.db.meta.QHT_BosKouzaJyouhou;
import yuyu.def.sinkeiyaku.comparator.OrderHT_BosKouzaJyouhou;

public class SortHT_BosKouzaJyouhou {

    
    public List<HT_BosKouzaJyouhou> OrderHT_BosKouzaJyouhouByPkAsc(List<HT_BosKouzaJyouhou> pEntity) {
        List<SortCondition<HT_BosKouzaJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosKouzaJyouhou()).mosno, SortOrder.ASC));
        List<HT_BosKouzaJyouhou> copyList = new ArrayList<HT_BosKouzaJyouhou>(pEntity);
        Collections.sort(copyList, new OrderHT_BosKouzaJyouhou(orders));
        return copyList;
    }

    
    public List<HT_BosKouzaJyouhou> OrderHT_BosKouzaJyouhouByPkDesc(List<HT_BosKouzaJyouhou> pEntity) {
        List<SortCondition<HT_BosKouzaJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosKouzaJyouhou()).mosno, SortOrder.DESC));
        List<HT_BosKouzaJyouhou> copyList = new ArrayList<HT_BosKouzaJyouhou>(pEntity);
        Collections.sort(copyList, new OrderHT_BosKouzaJyouhou(orders));
        return copyList;
    }
}

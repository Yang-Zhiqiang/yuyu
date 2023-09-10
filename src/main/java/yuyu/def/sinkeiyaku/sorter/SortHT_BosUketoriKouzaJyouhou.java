package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_BosUketoriKouzaJyouhou;
import yuyu.def.db.meta.QHT_BosUketoriKouzaJyouhou;
import yuyu.def.sinkeiyaku.comparator.OrderHT_BosUketoriKouzaJyouhou;

public class SortHT_BosUketoriKouzaJyouhou {

    
    public List<HT_BosUketoriKouzaJyouhou> OrderHT_BosUketoriKouzaJyouhouByPkAsc(List<HT_BosUketoriKouzaJyouhou> pEntity) {
        List<SortCondition<HT_BosUketoriKouzaJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosUketoriKouzaJyouhou()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_BosUketoriKouzaJyouhou()).uktkzsyubetukbn, SortOrder.ASC));
        List<HT_BosUketoriKouzaJyouhou> copyList = new ArrayList<HT_BosUketoriKouzaJyouhou>(pEntity);
        Collections.sort(copyList, new OrderHT_BosUketoriKouzaJyouhou(orders));
        return copyList;
    }

    
    public List<HT_BosUketoriKouzaJyouhou> OrderHT_BosUketoriKouzaJyouhouByPkDesc(List<HT_BosUketoriKouzaJyouhou> pEntity) {
        List<SortCondition<HT_BosUketoriKouzaJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosUketoriKouzaJyouhou()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_BosUketoriKouzaJyouhou()).uktkzsyubetukbn, SortOrder.DESC));
        List<HT_BosUketoriKouzaJyouhou> copyList = new ArrayList<HT_BosUketoriKouzaJyouhou>(pEntity);
        Collections.sort(copyList, new OrderHT_BosUketoriKouzaJyouhou(orders));
        return copyList;
    }

}


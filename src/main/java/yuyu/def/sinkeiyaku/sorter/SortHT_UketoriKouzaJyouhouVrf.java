package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhouVrf;
import yuyu.def.db.meta.QHT_UketoriKouzaJyouhouVrf;
import yuyu.def.sinkeiyaku.comparator.OrderHT_UketoriKouzaJyouhouVrf;

public class SortHT_UketoriKouzaJyouhouVrf {

    
    public List<HT_UketoriKouzaJyouhouVrf> OrderHT_UketoriKouzaJyouhouVrfByPkAsc(List<HT_UketoriKouzaJyouhouVrf> pEntity) {
        List<SortCondition<HT_UketoriKouzaJyouhouVrf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_UketoriKouzaJyouhouVrf()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_UketoriKouzaJyouhouVrf()).uktkzsyubetukbn, SortOrder.ASC));
        List<HT_UketoriKouzaJyouhouVrf> copyList = new ArrayList<HT_UketoriKouzaJyouhouVrf>(pEntity);
        Collections.sort(copyList, new OrderHT_UketoriKouzaJyouhouVrf(orders));
        return copyList;
    }

    
    public List<HT_UketoriKouzaJyouhouVrf> OrderHT_UketoriKouzaJyouhouVrfByPkDesc(List<HT_UketoriKouzaJyouhouVrf> pEntity) {
        List<SortCondition<HT_UketoriKouzaJyouhouVrf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_UketoriKouzaJyouhouVrf()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_UketoriKouzaJyouhouVrf()).uktkzsyubetukbn, SortOrder.DESC));
        List<HT_UketoriKouzaJyouhouVrf> copyList = new ArrayList<HT_UketoriKouzaJyouhouVrf>(pEntity);
        Collections.sort(copyList, new OrderHT_UketoriKouzaJyouhouVrf(orders));
        return copyList;
    }

}


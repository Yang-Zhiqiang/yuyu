package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_KouzaJyouhouVrf;
import yuyu.def.db.meta.QHT_KouzaJyouhouVrf;
import yuyu.def.sinkeiyaku.comparator.OrderHT_KouzaJyouhouVrf;

public class SortHT_KouzaJyouhouVrf {

    
    public List<HT_KouzaJyouhouVrf> OrderHT_KouzaJyouhouVrfByPkAsc(List<HT_KouzaJyouhouVrf> pEntity) {
        List<SortCondition<HT_KouzaJyouhouVrf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_KouzaJyouhouVrf()).mosno, SortOrder.ASC));
        List<HT_KouzaJyouhouVrf> copyList = new ArrayList<HT_KouzaJyouhouVrf>(pEntity);
        Collections.sort(copyList, new OrderHT_KouzaJyouhouVrf(orders));
        return copyList;
    }

    
    public List<HT_KouzaJyouhouVrf> OrderHT_KouzaJyouhouVrfByPkDesc(List<HT_KouzaJyouhouVrf> pEntity) {
        List<SortCondition<HT_KouzaJyouhouVrf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_KouzaJyouhouVrf()).mosno, SortOrder.DESC));
        List<HT_KouzaJyouhouVrf> copyList = new ArrayList<HT_KouzaJyouhouVrf>(pEntity);
        Collections.sort(copyList, new OrderHT_KouzaJyouhouVrf(orders));
        return copyList;
    }

}


package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.meta.QHT_KouzaJyouhou;
import yuyu.def.sinkeiyaku.comparator.OrderHT_KouzaJyouhou;

public class SortHT_KouzaJyouhou {

    
    public List<HT_KouzaJyouhou> OrderHT_KouzaJyouhouByPkAsc(List<HT_KouzaJyouhou> pEntity) {
        List<SortCondition<HT_KouzaJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_KouzaJyouhou()).mosno, SortOrder.ASC));
        List<HT_KouzaJyouhou> copyList = new ArrayList<HT_KouzaJyouhou>(pEntity);
        Collections.sort(copyList, new OrderHT_KouzaJyouhou(orders));
        return copyList;
    }

    
    public List<HT_KouzaJyouhou> OrderHT_KouzaJyouhouByPkDesc(List<HT_KouzaJyouhou> pEntity) {
        List<SortCondition<HT_KouzaJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_KouzaJyouhou()).mosno, SortOrder.DESC));
        List<HT_KouzaJyouhou> copyList = new ArrayList<HT_KouzaJyouhou>(pEntity);
        Collections.sort(copyList, new OrderHT_KouzaJyouhou(orders));
        return copyList;
    }

}


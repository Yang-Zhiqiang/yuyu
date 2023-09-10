package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_TokujyouRireki;
import yuyu.def.db.meta.QHT_TokujyouRireki;
import yuyu.def.sinkeiyaku.comparator.OrderHT_TokujyouRireki;

public class SortHT_TokujyouRireki {

    
    public List<HT_TokujyouRireki> OrderHT_TokujyouRirekiByPkAsc(List<HT_TokujyouRireki> pEntity) {
        List<SortCondition<HT_TokujyouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_TokujyouRireki()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_TokujyouRireki()).dakuhiktrenno, SortOrder.ASC));
        List<HT_TokujyouRireki> copyList = new ArrayList<HT_TokujyouRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_TokujyouRireki(orders));
        return copyList;
    }

    
    public List<HT_TokujyouRireki> OrderHT_TokujyouRirekiByPkDesc(List<HT_TokujyouRireki> pEntity) {
        List<SortCondition<HT_TokujyouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_TokujyouRireki()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_TokujyouRireki()).dakuhiktrenno, SortOrder.DESC));
        List<HT_TokujyouRireki> copyList = new ArrayList<HT_TokujyouRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_TokujyouRireki(orders));
        return copyList;
    }

}


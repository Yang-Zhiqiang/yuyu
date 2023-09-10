package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_Tokujyou;
import yuyu.def.db.meta.QHT_Tokujyou;
import yuyu.def.sinkeiyaku.comparator.OrderHT_Tokujyou;

public class SortHT_Tokujyou {

    
    public List<HT_Tokujyou> OrderHT_TokujyouByPkAsc(List<HT_Tokujyou> pEntity) {
        List<SortCondition<HT_Tokujyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Tokujyou()).mosno, SortOrder.ASC));
        List<HT_Tokujyou> copyList = new ArrayList<HT_Tokujyou>(pEntity);
        Collections.sort(copyList, new OrderHT_Tokujyou(orders));
        return copyList;
    }

    
    public List<HT_Tokujyou> OrderHT_TokujyouByPkDesc(List<HT_Tokujyou> pEntity) {
        List<SortCondition<HT_Tokujyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Tokujyou()).mosno, SortOrder.DESC));
        List<HT_Tokujyou> copyList = new ArrayList<HT_Tokujyou>(pEntity);
        Collections.sort(copyList, new OrderHT_Tokujyou(orders));
        return copyList;
    }

}


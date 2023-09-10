package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_MisyuupMkkpDetail;
import yuyu.def.db.meta.QJT_MisyuupMkkpDetail;
import yuyu.def.siharai.comparator.OrderJT_MisyuupMkkpDetail;

public class SortJT_MisyuupMkkpDetail {

    
    public List<JT_MisyuupMkkpDetail> OrderJT_MisyuupMkkpDetailByPkAsc(List<JT_MisyuupMkkpDetail> pEntity) {
        List<SortCondition<JT_MisyuupMkkpDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_MisyuupMkkpDetail()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_MisyuupMkkpDetail()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_MisyuupMkkpDetail()).seikyuurirekino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_MisyuupMkkpDetail()).datarenno, SortOrder.ASC));
        List<JT_MisyuupMkkpDetail> copyList = new ArrayList<JT_MisyuupMkkpDetail>(pEntity);
        Collections.sort(copyList, new OrderJT_MisyuupMkkpDetail(orders));
        return copyList;
    }

    
    public List<JT_MisyuupMkkpDetail> OrderJT_MisyuupMkkpDetailByPkDesc(List<JT_MisyuupMkkpDetail> pEntity) {
        List<SortCondition<JT_MisyuupMkkpDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_MisyuupMkkpDetail()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_MisyuupMkkpDetail()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_MisyuupMkkpDetail()).seikyuurirekino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_MisyuupMkkpDetail()).datarenno, SortOrder.DESC));
        List<JT_MisyuupMkkpDetail> copyList = new ArrayList<JT_MisyuupMkkpDetail>(pEntity);
        Collections.sort(copyList, new OrderJT_MisyuupMkkpDetail(orders));
        return copyList;
    }

}


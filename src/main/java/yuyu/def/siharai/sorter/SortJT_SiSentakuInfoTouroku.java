package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiSentakuInfoTouroku;
import yuyu.def.db.meta.QJT_SiSentakuInfoTouroku;
import yuyu.def.siharai.comparator.OrderJT_SiSentakuInfoTouroku;

public class SortJT_SiSentakuInfoTouroku {

    
    public List<JT_SiSentakuInfoTouroku> OrderJT_SiSentakuInfoTourokuByPkAsc(List<JT_SiSentakuInfoTouroku> pEntity) {
        List<SortCondition<JT_SiSentakuInfoTouroku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiSentakuInfoTouroku()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiSentakuInfoTouroku()).renno, SortOrder.ASC));
        List<JT_SiSentakuInfoTouroku> copyList = new ArrayList<JT_SiSentakuInfoTouroku>(pEntity);
        Collections.sort(copyList, new OrderJT_SiSentakuInfoTouroku(orders));
        return copyList;
    }

    
    public List<JT_SiSentakuInfoTouroku> OrderJT_SiSentakuInfoTourokuByPkDesc(List<JT_SiSentakuInfoTouroku> pEntity) {
        List<SortCondition<JT_SiSentakuInfoTouroku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiSentakuInfoTouroku()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiSentakuInfoTouroku()).renno, SortOrder.DESC));
        List<JT_SiSentakuInfoTouroku> copyList = new ArrayList<JT_SiSentakuInfoTouroku>(pEntity);
        Collections.sort(copyList, new OrderJT_SiSentakuInfoTouroku(orders));
        return copyList;
    }

}


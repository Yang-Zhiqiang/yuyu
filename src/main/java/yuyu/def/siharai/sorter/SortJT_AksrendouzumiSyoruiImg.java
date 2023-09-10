package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_AksrendouzumiSyoruiImg;
import yuyu.def.db.meta.QJT_AksrendouzumiSyoruiImg;
import yuyu.def.siharai.comparator.OrderJT_AksrendouzumiSyoruiImg;

public class SortJT_AksrendouzumiSyoruiImg {

    
    public List<JT_AksrendouzumiSyoruiImg> OrderJT_AksrendouzumiSyoruiImgByPkAsc(List<JT_AksrendouzumiSyoruiImg> pEntity) {
        List<SortCondition<JT_AksrendouzumiSyoruiImg>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_AksrendouzumiSyoruiImg()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_AksrendouzumiSyoruiImg()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_AksrendouzumiSyoruiImg()).imageid, SortOrder.ASC));
        List<JT_AksrendouzumiSyoruiImg> copyList = new ArrayList<JT_AksrendouzumiSyoruiImg>(pEntity);
        Collections.sort(copyList, new OrderJT_AksrendouzumiSyoruiImg(orders));
        return copyList;
    }

    
    public List<JT_AksrendouzumiSyoruiImg> OrderJT_AksrendouzumiSyoruiImgByPkDesc(List<JT_AksrendouzumiSyoruiImg> pEntity) {
        List<SortCondition<JT_AksrendouzumiSyoruiImg>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_AksrendouzumiSyoruiImg()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_AksrendouzumiSyoruiImg()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_AksrendouzumiSyoruiImg()).imageid, SortOrder.DESC));
        List<JT_AksrendouzumiSyoruiImg> copyList = new ArrayList<JT_AksrendouzumiSyoruiImg>(pEntity);
        Collections.sort(copyList, new OrderJT_AksrendouzumiSyoruiImg(orders));
        return copyList;
    }
}

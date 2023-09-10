package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkLincTourokuInfo;
import yuyu.def.db.meta.QHT_SkLincTourokuInfo;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkLincTourokuInfo;

public class SortHT_SkLincTourokuInfo {

    
    public List<HT_SkLincTourokuInfo> OrderHT_SkLincTourokuInfoByPkAsc(List<HT_SkLincTourokuInfo> pEntity) {
        List<SortCondition<HT_SkLincTourokuInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkLincTourokuInfo()).mosno, SortOrder.ASC));
        List<HT_SkLincTourokuInfo> copyList = new ArrayList<HT_SkLincTourokuInfo>(pEntity);
        Collections.sort(copyList, new OrderHT_SkLincTourokuInfo(orders));
        return copyList;
    }

    
    public List<HT_SkLincTourokuInfo> OrderHT_SkLincTourokuInfoByPkDesc(List<HT_SkLincTourokuInfo> pEntity) {
        List<SortCondition<HT_SkLincTourokuInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkLincTourokuInfo()).mosno, SortOrder.DESC));
        List<HT_SkLincTourokuInfo> copyList = new ArrayList<HT_SkLincTourokuInfo>(pEntity);
        Collections.sort(copyList, new OrderHT_SkLincTourokuInfo(orders));
        return copyList;
    }

}


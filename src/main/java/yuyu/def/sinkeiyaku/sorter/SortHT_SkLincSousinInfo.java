package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkLincSousinInfo;
import yuyu.def.db.meta.QHT_SkLincSousinInfo;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkLincSousinInfo;

public class SortHT_SkLincSousinInfo {

    
    public List<HT_SkLincSousinInfo> OrderHT_SkLincSousinInfoByPkAsc(List<HT_SkLincSousinInfo> pEntity) {
        List<SortCondition<HT_SkLincSousinInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkLincSousinInfo()).lincsoujyusinsyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkLincSousinInfo()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkLincSousinInfo()).renno, SortOrder.ASC));
        List<HT_SkLincSousinInfo> copyList = new ArrayList<HT_SkLincSousinInfo>(pEntity);
        Collections.sort(copyList, new OrderHT_SkLincSousinInfo(orders));
        return copyList;
    }

    
    public List<HT_SkLincSousinInfo> OrderHT_SkLincSousinInfoByPkDesc(List<HT_SkLincSousinInfo> pEntity) {
        List<SortCondition<HT_SkLincSousinInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkLincSousinInfo()).lincsoujyusinsyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkLincSousinInfo()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkLincSousinInfo()).renno, SortOrder.DESC));
        List<HT_SkLincSousinInfo> copyList = new ArrayList<HT_SkLincSousinInfo>(pEntity);
        Collections.sort(copyList, new OrderHT_SkLincSousinInfo(orders));
        return copyList;
    }

}


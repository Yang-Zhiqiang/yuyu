package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkLincJyusinInfo;
import yuyu.def.db.meta.QHT_SkLincJyusinInfo;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkLincJyusinInfo;

public class SortHT_SkLincJyusinInfo {

    
    public List<HT_SkLincJyusinInfo> OrderHT_SkLincJyusinInfoByPkAsc(List<HT_SkLincJyusinInfo> pEntity) {
        List<SortCondition<HT_SkLincJyusinInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkLincJyusinInfo()).lincsoujyusinsyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkLincJyusinInfo()).linckyknaiykekdatarenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkLincJyusinInfo()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkLincJyusinInfo()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkLincJyusinInfo()).renno2, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkLincJyusinInfo()).sousinymd, SortOrder.ASC));
        List<HT_SkLincJyusinInfo> copyList = new ArrayList<HT_SkLincJyusinInfo>(pEntity);
        Collections.sort(copyList, new OrderHT_SkLincJyusinInfo(orders));
        return copyList;
    }

    
    public List<HT_SkLincJyusinInfo> OrderHT_SkLincJyusinInfoByPkDesc(List<HT_SkLincJyusinInfo> pEntity) {
        List<SortCondition<HT_SkLincJyusinInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkLincJyusinInfo()).lincsoujyusinsyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkLincJyusinInfo()).linckyknaiykekdatarenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkLincJyusinInfo()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkLincJyusinInfo()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkLincJyusinInfo()).renno2, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkLincJyusinInfo()).sousinymd, SortOrder.DESC));
        List<HT_SkLincJyusinInfo> copyList = new ArrayList<HT_SkLincJyusinInfo>(pEntity);
        Collections.sort(copyList, new OrderHT_SkLincJyusinInfo(orders));
        return copyList;
    }

}


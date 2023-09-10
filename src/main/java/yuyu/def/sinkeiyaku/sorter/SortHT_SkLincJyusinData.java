package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkLincJyusinData;
import yuyu.def.db.meta.QHT_SkLincJyusinData;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkLincJyusinData;

public class SortHT_SkLincJyusinData {

    
    public List<HT_SkLincJyusinData> OrderHT_SkLincJyusinDataByPkAsc(List<HT_SkLincJyusinData> pEntity) {
        List<SortCondition<HT_SkLincJyusinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkLincJyusinData()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkLincJyusinData()).linckyknaiykekdatarenno, SortOrder.ASC));
        List<HT_SkLincJyusinData> copyList = new ArrayList<HT_SkLincJyusinData>(pEntity);
        Collections.sort(copyList, new OrderHT_SkLincJyusinData(orders));
        return copyList;
    }

    
    public List<HT_SkLincJyusinData> OrderHT_SkLincJyusinDataByPkDesc(List<HT_SkLincJyusinData> pEntity) {
        List<SortCondition<HT_SkLincJyusinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkLincJyusinData()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkLincJyusinData()).linckyknaiykekdatarenno, SortOrder.DESC));
        List<HT_SkLincJyusinData> copyList = new ArrayList<HT_SkLincJyusinData>(pEntity);
        Collections.sort(copyList, new OrderHT_SkLincJyusinData(orders));
        return copyList;
    }
}

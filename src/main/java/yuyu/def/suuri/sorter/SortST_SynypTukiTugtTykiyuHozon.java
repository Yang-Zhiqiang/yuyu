package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.meta.QST_SynypTukiTugtTykiyuHozon;
import yuyu.def.suuri.comparator.OrderST_SynypTukiTugtTykiyuHozon;

public class SortST_SynypTukiTugtTykiyuHozon {

    
    public List<ST_SynypTukiTugtTykiyuHozon> OrderST_SynypTukiTugtTykiyuHozonByPkAsc(List<ST_SynypTukiTugtTykiyuHozon> pEntity) {
        List<SortCondition<ST_SynypTukiTugtTykiyuHozon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_SynypTukiTugtTykiyuHozon()).ztysrkijyunym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SynypTukiTugtTykiyuHozon()).ztysrkakutyoujobcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SynypTukiTugtTykiyuHozon()).ztysequenceno, SortOrder.ASC));
        List<ST_SynypTukiTugtTykiyuHozon> copyList = new ArrayList<ST_SynypTukiTugtTykiyuHozon>(pEntity);
        Collections.sort(copyList, new OrderST_SynypTukiTugtTykiyuHozon(orders));
        return copyList;
    }

    
    public List<ST_SynypTukiTugtTykiyuHozon> OrderST_SynypTukiTugtTykiyuHozonByPkDesc(List<ST_SynypTukiTugtTykiyuHozon> pEntity) {
        List<SortCondition<ST_SynypTukiTugtTykiyuHozon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_SynypTukiTugtTykiyuHozon()).ztysrkijyunym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SynypTukiTugtTykiyuHozon()).ztysrkakutyoujobcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SynypTukiTugtTykiyuHozon()).ztysequenceno, SortOrder.DESC));
        List<ST_SynypTukiTugtTykiyuHozon> copyList = new ArrayList<ST_SynypTukiTugtTykiyuHozon>(pEntity);
        Collections.sort(copyList, new OrderST_SynypTukiTugtTykiyuHozon(orders));
        return copyList;
    }
}

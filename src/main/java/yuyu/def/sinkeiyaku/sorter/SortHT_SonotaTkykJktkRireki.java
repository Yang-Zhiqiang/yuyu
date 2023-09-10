package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SonotaTkykJktkRireki;
import yuyu.def.db.meta.QHT_SonotaTkykJktkRireki;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SonotaTkykJktkRireki;

public class SortHT_SonotaTkykJktkRireki {

    
    public List<HT_SonotaTkykJktkRireki> OrderHT_SonotaTkykJktkRirekiByPkAsc(List<HT_SonotaTkykJktkRireki> pEntity) {
        List<SortCondition<HT_SonotaTkykJktkRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SonotaTkykJktkRireki()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SonotaTkykJktkRireki()).dakuhiktrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SonotaTkykJktkRireki()).pmnjtkkbn, SortOrder.ASC));
        List<HT_SonotaTkykJktkRireki> copyList = new ArrayList<HT_SonotaTkykJktkRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_SonotaTkykJktkRireki(orders));
        return copyList;
    }

    
    public List<HT_SonotaTkykJktkRireki> OrderHT_SonotaTkykJktkRirekiByPkDesc(List<HT_SonotaTkykJktkRireki> pEntity) {
        List<SortCondition<HT_SonotaTkykJktkRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SonotaTkykJktkRireki()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SonotaTkykJktkRireki()).dakuhiktrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SonotaTkykJktkRireki()).pmnjtkkbn, SortOrder.DESC));
        List<HT_SonotaTkykJktkRireki> copyList = new ArrayList<HT_SonotaTkykJktkRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_SonotaTkykJktkRireki(orders));
        return copyList;
    }

}


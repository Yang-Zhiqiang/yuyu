package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HW_NyuukinJyouhouHuittiWk;
import yuyu.def.db.meta.QHW_NyuukinJyouhouHuittiWk;
import yuyu.def.sinkeiyaku.comparator.OrderHW_NyuukinJyouhouHuittiWk;

public class SortHW_NyuukinJyouhouHuittiWk {

    
    public List<HW_NyuukinJyouhouHuittiWk> OrderHW_NyuukinJyouhouHuittiWkByPkAsc(List<HW_NyuukinJyouhouHuittiWk> pEntity) {
        List<SortCondition<HW_NyuukinJyouhouHuittiWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHW_NyuukinJyouhouHuittiWk()).nyksyoriymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHW_NyuukinJyouhouHuittiWk()).itirenno, SortOrder.ASC));
        List<HW_NyuukinJyouhouHuittiWk> copyList = new ArrayList<HW_NyuukinJyouhouHuittiWk>(pEntity);
        Collections.sort(copyList, new OrderHW_NyuukinJyouhouHuittiWk(orders));
        return copyList;
    }

    
    public List<HW_NyuukinJyouhouHuittiWk> OrderHW_NyuukinJyouhouHuittiWkByPkDesc(List<HW_NyuukinJyouhouHuittiWk> pEntity) {
        List<SortCondition<HW_NyuukinJyouhouHuittiWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHW_NyuukinJyouhouHuittiWk()).nyksyoriymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHW_NyuukinJyouhouHuittiWk()).itirenno, SortOrder.DESC));
        List<HW_NyuukinJyouhouHuittiWk> copyList = new ArrayList<HW_NyuukinJyouhouHuittiWk>(pEntity);
        Collections.sort(copyList, new OrderHW_NyuukinJyouhouHuittiWk(orders));
        return copyList;
    }

}


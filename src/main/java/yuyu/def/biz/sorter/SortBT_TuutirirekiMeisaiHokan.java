package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.meta.QBT_TuutirirekiMeisaiHokan;

public class SortBT_TuutirirekiMeisaiHokan {

    public List<BT_TuutirirekiMeisaiHokan> OrderBT_TuutirirekiMeisaiHokanByPkAsc(List<BT_TuutirirekiMeisaiHokan> pEntity) {
        List<SortCondition<BT_TuutirirekiMeisaiHokan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TuutirirekiMeisaiHokan()).tuutirirekirenno, SortOrder.ASC));
        List<BT_TuutirirekiMeisaiHokan> copyList = new ArrayList<BT_TuutirirekiMeisaiHokan>(pEntity);
        Collections.sort(copyList, new OrderBT_TuutirirekiMeisaiHokan(orders));
        return copyList;
    }

    public List<BT_TuutirirekiMeisaiHokan> OrderBT_TuutirirekiMeisaiHokanByPkDesc(List<BT_TuutirirekiMeisaiHokan> pEntity) {
        List<SortCondition<BT_TuutirirekiMeisaiHokan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TuutirirekiMeisaiHokan()).tuutirirekirenno, SortOrder.DESC));
        List<BT_TuutirirekiMeisaiHokan> copyList = new ArrayList<BT_TuutirirekiMeisaiHokan>(pEntity);
        Collections.sort(copyList, new OrderBT_TuutirirekiMeisaiHokan(orders));
        return copyList;
    }
}

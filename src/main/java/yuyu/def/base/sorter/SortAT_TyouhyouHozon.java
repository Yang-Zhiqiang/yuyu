package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_TyouhyouHozon;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.def.db.meta.QAT_TyouhyouHozon;

public class SortAT_TyouhyouHozon {

    public List<AT_TyouhyouHozon> OrderAT_TyouhyouHozonByPkAsc(List<AT_TyouhyouHozon> pEntity) {
        List<SortCondition<AT_TyouhyouHozon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_TyouhyouHozon()).reportKey, SortOrder.ASC));
        List<AT_TyouhyouHozon> copyList = new ArrayList<AT_TyouhyouHozon>(pEntity);
        Collections.sort(copyList, new OrderAT_TyouhyouHozon(orders));
        return copyList;
    }

    public List<AT_TyouhyouHozon> OrderAT_TyouhyouHozonByPkDesc(List<AT_TyouhyouHozon> pEntity) {
        List<SortCondition<AT_TyouhyouHozon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_TyouhyouHozon()).reportKey, SortOrder.DESC));
        List<AT_TyouhyouHozon> copyList = new ArrayList<AT_TyouhyouHozon>(pEntity);
        Collections.sort(copyList, new OrderAT_TyouhyouHozon(orders));
        return copyList;
    }
}

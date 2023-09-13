package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_UketoriKouza;
import yuyu.def.db.meta.QIT_UketoriKouza;
import yuyu.def.hozen.comparator.OrderIT_UketoriKouza;

public class SortIT_UketoriKouza {

    public List<IT_UketoriKouza> OrderIT_UketoriKouzaByPkAsc(List<IT_UketoriKouza> pEntity) {
        List<SortCondition<IT_UketoriKouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_UketoriKouza()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_UketoriKouza()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_UketoriKouza()).uktsyukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_UketoriKouza()).uktsyurenno, SortOrder.ASC));
        List<IT_UketoriKouza> copyList = new ArrayList<IT_UketoriKouza>(pEntity);
        Collections.sort(copyList, new OrderIT_UketoriKouza(orders));
        return copyList;
    }

    public List<IT_UketoriKouza> OrderIT_UketoriKouzaByPkDesc(List<IT_UketoriKouza> pEntity) {
        List<SortCondition<IT_UketoriKouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_UketoriKouza()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_UketoriKouza()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_UketoriKouza()).uktsyukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_UketoriKouza()).uktsyurenno, SortOrder.DESC));
        List<IT_UketoriKouza> copyList = new ArrayList<IT_UketoriKouza>(pEntity);
        Collections.sort(copyList, new OrderIT_UketoriKouza(orders));
        return copyList;
    }
}

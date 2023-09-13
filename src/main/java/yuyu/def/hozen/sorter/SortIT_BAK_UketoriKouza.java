package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_UketoriKouza;
import yuyu.def.db.meta.QIT_BAK_UketoriKouza;
import yuyu.def.hozen.comparator.OrderIT_BAK_UketoriKouza;

public class SortIT_BAK_UketoriKouza {

    public List<IT_BAK_UketoriKouza> OrderIT_BAK_UketoriKouzaByPkAsc(List<IT_BAK_UketoriKouza> pEntity) {
        List<SortCondition<IT_BAK_UketoriKouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_UketoriKouza()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_UketoriKouza()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_UketoriKouza()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_UketoriKouza()).uktsyukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_UketoriKouza()).uktsyurenno, SortOrder.ASC));
        List<IT_BAK_UketoriKouza> copyList = new ArrayList<IT_BAK_UketoriKouza>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_UketoriKouza(orders));
        return copyList;
    }

    public List<IT_BAK_UketoriKouza> OrderIT_BAK_UketoriKouzaByPkDesc(List<IT_BAK_UketoriKouza> pEntity) {
        List<SortCondition<IT_BAK_UketoriKouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_UketoriKouza()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_UketoriKouza()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_UketoriKouza()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_UketoriKouza()).uktsyukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_UketoriKouza()).uktsyurenno, SortOrder.DESC));
        List<IT_BAK_UketoriKouza> copyList = new ArrayList<IT_BAK_UketoriKouza>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_UketoriKouza(orders));
        return copyList;
    }
}

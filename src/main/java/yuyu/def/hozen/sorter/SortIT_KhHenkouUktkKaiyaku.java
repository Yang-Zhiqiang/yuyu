package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhHenkouUktkKaiyaku;
import yuyu.def.db.meta.QIT_KhHenkouUktkKaiyaku;
import yuyu.def.hozen.comparator.OrderIT_KhHenkouUktkKaiyaku;

public class SortIT_KhHenkouUktkKaiyaku {

    public List<IT_KhHenkouUktkKaiyaku> OrderIT_KhHenkouUktkKaiyakuByPkAsc(List<IT_KhHenkouUktkKaiyaku> pEntity) {
        List<SortCondition<IT_KhHenkouUktkKaiyaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHenkouUktkKaiyaku()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHenkouUktkKaiyaku()).hozenhenkouuktkrenno, SortOrder.ASC));
        List<IT_KhHenkouUktkKaiyaku> copyList = new ArrayList<IT_KhHenkouUktkKaiyaku>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHenkouUktkKaiyaku(orders));
        return copyList;
    }

    public List<IT_KhHenkouUktkKaiyaku> OrderIT_KhHenkouUktkKaiyakuByPkDesc(List<IT_KhHenkouUktkKaiyaku> pEntity) {
        List<SortCondition<IT_KhHenkouUktkKaiyaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHenkouUktkKaiyaku()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHenkouUktkKaiyaku()).hozenhenkouuktkrenno, SortOrder.DESC));
        List<IT_KhHenkouUktkKaiyaku> copyList = new ArrayList<IT_KhHenkouUktkKaiyaku>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHenkouUktkKaiyaku(orders));
        return copyList;
    }
}

package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktkKaiyaku;
import yuyu.def.db.meta.QIT_BAK_KhHenkouUktkKaiyaku;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhHenkouUktkKaiyaku;

public class SortIT_BAK_KhHenkouUktkKaiyaku {

    public List<IT_BAK_KhHenkouUktkKaiyaku> OrderIT_BAK_KhHenkouUktkKaiyakuByPkAsc(List<IT_BAK_KhHenkouUktkKaiyaku> pEntity) {
        List<SortCondition<IT_BAK_KhHenkouUktkKaiyaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkKaiyaku()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkKaiyaku()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkKaiyaku()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkKaiyaku()).hozenhenkouuktkrenno, SortOrder.ASC));
        List<IT_BAK_KhHenkouUktkKaiyaku> copyList = new ArrayList<IT_BAK_KhHenkouUktkKaiyaku>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhHenkouUktkKaiyaku(orders));
        return copyList;
    }

    public List<IT_BAK_KhHenkouUktkKaiyaku> OrderIT_BAK_KhHenkouUktkKaiyakuByPkDesc(List<IT_BAK_KhHenkouUktkKaiyaku> pEntity) {
        List<SortCondition<IT_BAK_KhHenkouUktkKaiyaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkKaiyaku()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkKaiyaku()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkKaiyaku()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkKaiyaku()).hozenhenkouuktkrenno, SortOrder.DESC));
        List<IT_BAK_KhHenkouUktkKaiyaku> copyList = new ArrayList<IT_BAK_KhHenkouUktkKaiyaku>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhHenkouUktkKaiyaku(orders));
        return copyList;
    }
}

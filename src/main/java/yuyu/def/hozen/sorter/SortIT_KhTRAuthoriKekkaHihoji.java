package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhTRAuthoriKekkaHihoji;
import yuyu.def.db.meta.QIT_KhTRAuthoriKekkaHihoji;
import yuyu.def.hozen.comparator.OrderIT_KhTRAuthoriKekkaHihoji;

public class SortIT_KhTRAuthoriKekkaHihoji {

    public List<IT_KhTRAuthoriKekkaHihoji> OrderIT_KhTRAuthoriKekkaHihojiByPkAsc(List<IT_KhTRAuthoriKekkaHihoji> pEntity) {
        List<SortCondition<IT_KhTRAuthoriKekkaHihoji>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhTRAuthoriKekkaHihoji()).creditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhTRAuthoriKekkaHihoji()).syoriYmd, SortOrder.ASC));
        List<IT_KhTRAuthoriKekkaHihoji> copyList = new ArrayList<IT_KhTRAuthoriKekkaHihoji>(pEntity);
        Collections.sort(copyList, new OrderIT_KhTRAuthoriKekkaHihoji(orders));
        return copyList;
    }

    public List<IT_KhTRAuthoriKekkaHihoji> OrderIT_KhTRAuthoriKekkaHihojiByPkDesc(List<IT_KhTRAuthoriKekkaHihoji> pEntity) {
        List<SortCondition<IT_KhTRAuthoriKekkaHihoji>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhTRAuthoriKekkaHihoji()).creditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhTRAuthoriKekkaHihoji()).syoriYmd, SortOrder.DESC));
        List<IT_KhTRAuthoriKekkaHihoji> copyList = new ArrayList<IT_KhTRAuthoriKekkaHihoji>(pEntity);
        Collections.sort(copyList, new OrderIT_KhTRAuthoriKekkaHihoji(orders));
        return copyList;
    }
}

package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_YuukouKakKekkaKikyk;
import yuyu.def.db.meta.QIT_YuukouKakKekkaKikyk;
import yuyu.def.hozen.comparator.OrderIT_YuukouKakKekkaKikyk;

public class SortIT_YuukouKakKekkaKikyk {

    public List<IT_YuukouKakKekkaKikyk> OrderIT_YuukouKakKekkaKikykByPkAsc(List<IT_YuukouKakKekkaKikyk> pEntity) {
        List<SortCondition<IT_YuukouKakKekkaKikyk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_YuukouKakKekkaKikyk()).creditkessaiyouno, SortOrder.ASC));
        List<IT_YuukouKakKekkaKikyk> copyList = new ArrayList<IT_YuukouKakKekkaKikyk>(pEntity);
        Collections.sort(copyList, new OrderIT_YuukouKakKekkaKikyk(orders));
        return copyList;
    }

    public List<IT_YuukouKakKekkaKikyk> OrderIT_YuukouKakKekkaKikykByPkDesc(List<IT_YuukouKakKekkaKikyk> pEntity) {
        List<SortCondition<IT_YuukouKakKekkaKikyk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_YuukouKakKekkaKikyk()).creditkessaiyouno, SortOrder.DESC));
        List<IT_YuukouKakKekkaKikyk> copyList = new ArrayList<IT_YuukouKakKekkaKikyk>(pEntity);
        Collections.sort(copyList, new OrderIT_YuukouKakKekkaKikyk(orders));
        return copyList;
    }
}

package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhShrRirekiDetail;
import yuyu.def.db.meta.QIT_BAK_KhShrRirekiDetail;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhShrRirekiDetail;

public class SortIT_BAK_KhShrRirekiDetail {

    public List<IT_BAK_KhShrRirekiDetail> OrderIT_BAK_KhShrRirekiDetailByPkAsc(List<IT_BAK_KhShrRirekiDetail> pEntity) {
        List<SortCondition<IT_BAK_KhShrRirekiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRirekiDetail()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRirekiDetail()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRirekiDetail()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRirekiDetail()).henkousikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRirekiDetail()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRirekiDetail()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRirekiDetail()).kyksyouhnrenno, SortOrder.ASC));
        List<IT_BAK_KhShrRirekiDetail> copyList = new ArrayList<IT_BAK_KhShrRirekiDetail>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhShrRirekiDetail(orders));
        return copyList;
    }

    public List<IT_BAK_KhShrRirekiDetail> OrderIT_BAK_KhShrRirekiDetailByPkDesc(List<IT_BAK_KhShrRirekiDetail> pEntity) {
        List<SortCondition<IT_BAK_KhShrRirekiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRirekiDetail()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRirekiDetail()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRirekiDetail()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRirekiDetail()).henkousikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRirekiDetail()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRirekiDetail()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRirekiDetail()).kyksyouhnrenno, SortOrder.DESC));
        List<IT_BAK_KhShrRirekiDetail> copyList = new ArrayList<IT_BAK_KhShrRirekiDetail>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhShrRirekiDetail(orders));
        return copyList;
    }

}


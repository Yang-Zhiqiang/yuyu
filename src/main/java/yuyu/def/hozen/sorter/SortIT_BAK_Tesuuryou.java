package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_Tesuuryou;
import yuyu.def.db.meta.QIT_BAK_Tesuuryou;
import yuyu.def.hozen.comparator.OrderIT_BAK_Tesuuryou;

public class SortIT_BAK_Tesuuryou {

    public List<IT_BAK_Tesuuryou> OrderIT_BAK_TesuuryouByPkAsc(List<IT_BAK_Tesuuryou> pEntity) {
        List<SortCondition<IT_BAK_Tesuuryou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_Tesuuryou()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Tesuuryou()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Tesuuryou()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Tesuuryou()).tsrysyorikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Tesuuryou()).renno, SortOrder.ASC));
        List<IT_BAK_Tesuuryou> copyList = new ArrayList<IT_BAK_Tesuuryou>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_Tesuuryou(orders));
        return copyList;
    }

    public List<IT_BAK_Tesuuryou> OrderIT_BAK_TesuuryouByPkDesc(List<IT_BAK_Tesuuryou> pEntity) {
        List<SortCondition<IT_BAK_Tesuuryou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_Tesuuryou()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Tesuuryou()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Tesuuryou()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Tesuuryou()).tsrysyorikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Tesuuryou()).renno, SortOrder.DESC));
        List<IT_BAK_Tesuuryou> copyList = new ArrayList<IT_BAK_Tesuuryou>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_Tesuuryou(orders));
        return copyList;
    }

}


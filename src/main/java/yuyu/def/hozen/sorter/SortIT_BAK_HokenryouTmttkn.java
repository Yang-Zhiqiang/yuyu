package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_HokenryouTmttkn;
import yuyu.def.db.meta.QIT_BAK_HokenryouTmttkn;
import yuyu.def.hozen.comparator.OrderIT_BAK_HokenryouTmttkn;

public class SortIT_BAK_HokenryouTmttkn {

    public List<IT_BAK_HokenryouTmttkn> OrderIT_BAK_HokenryouTmttknByPkAsc(List<IT_BAK_HokenryouTmttkn> pEntity) {
        List<SortCondition<IT_BAK_HokenryouTmttkn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HokenryouTmttkn()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenryouTmttkn()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenryouTmttkn()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenryouTmttkn()).tmttkntaisyouym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenryouTmttkn()).renno, SortOrder.ASC));
        List<IT_BAK_HokenryouTmttkn> copyList = new ArrayList<IT_BAK_HokenryouTmttkn>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HokenryouTmttkn(orders));
        return copyList;
    }

    public List<IT_BAK_HokenryouTmttkn> OrderIT_BAK_HokenryouTmttknByPkDesc(List<IT_BAK_HokenryouTmttkn> pEntity) {
        List<SortCondition<IT_BAK_HokenryouTmttkn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HokenryouTmttkn()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenryouTmttkn()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenryouTmttkn()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenryouTmttkn()).tmttkntaisyouym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenryouTmttkn()).renno, SortOrder.DESC));
        List<IT_BAK_HokenryouTmttkn> copyList = new ArrayList<IT_BAK_HokenryouTmttkn>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HokenryouTmttkn(orders));
        return copyList;
    }
}

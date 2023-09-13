package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.meta.QIT_HokenryouTmttkn;
import yuyu.def.hozen.comparator.OrderIT_HokenryouTmttkn;

public class SortIT_HokenryouTmttkn {

    public List<IT_HokenryouTmttkn> OrderIT_HokenryouTmttknByPkAsc(List<IT_HokenryouTmttkn> pEntity) {
        List<SortCondition<IT_HokenryouTmttkn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HokenryouTmttkn()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HokenryouTmttkn()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HokenryouTmttkn()).tmttkntaisyouym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HokenryouTmttkn()).renno, SortOrder.ASC));
        List<IT_HokenryouTmttkn> copyList = new ArrayList<IT_HokenryouTmttkn>(pEntity);
        Collections.sort(copyList, new OrderIT_HokenryouTmttkn(orders));
        return copyList;
    }

    public List<IT_HokenryouTmttkn> OrderIT_HokenryouTmttknByPkDesc(List<IT_HokenryouTmttkn> pEntity) {
        List<SortCondition<IT_HokenryouTmttkn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HokenryouTmttkn()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HokenryouTmttkn()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HokenryouTmttkn()).tmttkntaisyouym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HokenryouTmttkn()).renno, SortOrder.DESC));
        List<IT_HokenryouTmttkn> copyList = new ArrayList<IT_HokenryouTmttkn>(pEntity);
        Collections.sort(copyList, new OrderIT_HokenryouTmttkn(orders));
        return copyList;
    }
}

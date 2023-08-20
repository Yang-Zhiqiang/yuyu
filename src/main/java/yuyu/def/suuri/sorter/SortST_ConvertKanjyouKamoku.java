package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ST_ConvertKanjyouKamoku;
import yuyu.def.db.meta.QST_ConvertKanjyouKamoku;
import yuyu.def.suuri.comparator.OrderST_ConvertKanjyouKamoku;

public class SortST_ConvertKanjyouKamoku {

    
    public List<ST_ConvertKanjyouKamoku> OrderST_ConvertKanjyouKamokuByPkAsc(List<ST_ConvertKanjyouKamoku> pEntity) {
        List<SortCondition<ST_ConvertKanjyouKamoku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_ConvertKanjyouKamoku()).kanjyoukmkcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_ConvertKanjyouKamoku()).taisyakukbn, SortOrder.ASC));
        List<ST_ConvertKanjyouKamoku> copyList = new ArrayList<ST_ConvertKanjyouKamoku>(pEntity);
        Collections.sort(copyList, new OrderST_ConvertKanjyouKamoku(orders));
        return copyList;
    }

    
    public List<ST_ConvertKanjyouKamoku> OrderST_ConvertKanjyouKamokuByPkDesc(List<ST_ConvertKanjyouKamoku> pEntity) {
        List<SortCondition<ST_ConvertKanjyouKamoku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_ConvertKanjyouKamoku()).kanjyoukmkcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_ConvertKanjyouKamoku()).taisyakukbn, SortOrder.DESC));
        List<ST_ConvertKanjyouKamoku> copyList = new ArrayList<ST_ConvertKanjyouKamoku>(pEntity);
        Collections.sort(copyList, new OrderST_ConvertKanjyouKamoku(orders));
        return copyList;
    }
}

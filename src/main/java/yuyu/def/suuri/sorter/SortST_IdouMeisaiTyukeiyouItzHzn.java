package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.meta.QST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.suuri.comparator.OrderST_IdouMeisaiTyukeiyouItzHzn;

public class SortST_IdouMeisaiTyukeiyouItzHzn {

    
    public List<ST_IdouMeisaiTyukeiyouItzHzn> OrderST_IdouMeisaiTyukeiyouItzHznByPkAsc(List<ST_IdouMeisaiTyukeiyouItzHzn> pEntity) {
        List<SortCondition<ST_IdouMeisaiTyukeiyouItzHzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_IdouMeisaiTyukeiyouItzHzn()).ztysrkijyunym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_IdouMeisaiTyukeiyouItzHzn()).ztysrkakutyoujobcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_IdouMeisaiTyukeiyouItzHzn()).ztysequenceno, SortOrder.ASC));
        List<ST_IdouMeisaiTyukeiyouItzHzn> copyList = new ArrayList<ST_IdouMeisaiTyukeiyouItzHzn>(pEntity);
        Collections.sort(copyList, new OrderST_IdouMeisaiTyukeiyouItzHzn(orders));
        return copyList;
    }

    
    public List<ST_IdouMeisaiTyukeiyouItzHzn> OrderST_IdouMeisaiTyukeiyouItzHznByPkDesc(List<ST_IdouMeisaiTyukeiyouItzHzn> pEntity) {
        List<SortCondition<ST_IdouMeisaiTyukeiyouItzHzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_IdouMeisaiTyukeiyouItzHzn()).ztysrkijyunym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_IdouMeisaiTyukeiyouItzHzn()).ztysrkakutyoujobcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_IdouMeisaiTyukeiyouItzHzn()).ztysequenceno, SortOrder.DESC));
        List<ST_IdouMeisaiTyukeiyouItzHzn> copyList = new ArrayList<ST_IdouMeisaiTyukeiyouItzHzn>(pEntity);
        Collections.sort(copyList, new OrderST_IdouMeisaiTyukeiyouItzHzn(orders));
        return copyList;
    }
}

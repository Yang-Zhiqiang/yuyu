package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.meta.QST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.suuri.comparator.OrderST_HoyuuMeisaiTyukeiyouItzHzn;

public class SortST_HoyuuMeisaiTyukeiyouItzHzn {

    
    public List<ST_HoyuuMeisaiTyukeiyouItzHzn> OrderST_HoyuuMeisaiTyukeiyouItzHznByPkAsc(List<ST_HoyuuMeisaiTyukeiyouItzHzn> pEntity) {
        List<SortCondition<ST_HoyuuMeisaiTyukeiyouItzHzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_HoyuuMeisaiTyukeiyouItzHzn()).ztysrkijyunym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_HoyuuMeisaiTyukeiyouItzHzn()).ztysrkakutyoujobcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_HoyuuMeisaiTyukeiyouItzHzn()).ztysequenceno, SortOrder.ASC));
        List<ST_HoyuuMeisaiTyukeiyouItzHzn> copyList = new ArrayList<ST_HoyuuMeisaiTyukeiyouItzHzn>(pEntity);
        Collections.sort(copyList, new OrderST_HoyuuMeisaiTyukeiyouItzHzn(orders));
        return copyList;
    }

    
    public List<ST_HoyuuMeisaiTyukeiyouItzHzn> OrderST_HoyuuMeisaiTyukeiyouItzHznByPkDesc(List<ST_HoyuuMeisaiTyukeiyouItzHzn> pEntity) {
        List<SortCondition<ST_HoyuuMeisaiTyukeiyouItzHzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_HoyuuMeisaiTyukeiyouItzHzn()).ztysrkijyunym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_HoyuuMeisaiTyukeiyouItzHzn()).ztysrkakutyoujobcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_HoyuuMeisaiTyukeiyouItzHzn()).ztysequenceno, SortOrder.DESC));
        List<ST_HoyuuMeisaiTyukeiyouItzHzn> copyList = new ArrayList<ST_HoyuuMeisaiTyukeiyouItzHzn>(pEntity);
        Collections.sort(copyList, new OrderST_HoyuuMeisaiTyukeiyouItzHzn(orders));
        return copyList;
    }
}

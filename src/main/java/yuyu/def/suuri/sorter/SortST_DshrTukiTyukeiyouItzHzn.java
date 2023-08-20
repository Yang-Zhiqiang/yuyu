package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ST_DshrTukiTyukeiyouItzHzn;
import yuyu.def.db.meta.QST_DshrTukiTyukeiyouItzHzn;
import yuyu.def.suuri.comparator.OrderST_DshrTukiTyukeiyouItzHzn;

public class SortST_DshrTukiTyukeiyouItzHzn {

    
    public List<ST_DshrTukiTyukeiyouItzHzn> OrderST_DshrTukiTyukeiyouItzHznByPkAsc(List<ST_DshrTukiTyukeiyouItzHzn> pEntity) {
        List<SortCondition<ST_DshrTukiTyukeiyouItzHzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_DshrTukiTyukeiyouItzHzn()).ztysequenceno, SortOrder.ASC));
        List<ST_DshrTukiTyukeiyouItzHzn> copyList = new ArrayList<ST_DshrTukiTyukeiyouItzHzn>(pEntity);
        Collections.sort(copyList, new OrderST_DshrTukiTyukeiyouItzHzn(orders));
        return copyList;
    }

    
    public List<ST_DshrTukiTyukeiyouItzHzn> OrderST_DshrTukiTyukeiyouItzHznByPkDesc(List<ST_DshrTukiTyukeiyouItzHzn> pEntity) {
        List<SortCondition<ST_DshrTukiTyukeiyouItzHzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_DshrTukiTyukeiyouItzHzn()).ztysequenceno, SortOrder.DESC));
        List<ST_DshrTukiTyukeiyouItzHzn> copyList = new ArrayList<ST_DshrTukiTyukeiyouItzHzn>(pEntity);
        Collections.sort(copyList, new OrderST_DshrTukiTyukeiyouItzHzn(orders));
        return copyList;
    }
}

package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DairitenItakuSyouhnRn;
import yuyu.def.db.meta.QZT_DairitenItakuSyouhnRn;
import yuyu.def.zdb.comparator.OrderZT_DairitenItakuSyouhnRn;

public class SortZT_DairitenItakuSyouhnRn {

    
    public List<ZT_DairitenItakuSyouhnRn> OrderZT_DairitenItakuSyouhnRnByPkAsc(List<ZT_DairitenItakuSyouhnRn> pEntity) {
        List<SortCondition<ZT_DairitenItakuSyouhnRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DairitenItakuSyouhnRn()).zrndairitencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DairitenItakuSyouhnRn()).zrndrtsyouhinsikibetukbnstr, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DairitenItakuSyouhnRn()).zrndrthrkhouhoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DairitenItakuSyouhnRn()).zrndrtplannmkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DairitenItakuSyouhnRn()).zrnitakuhknhnbkaisiymd, SortOrder.ASC));
        List<ZT_DairitenItakuSyouhnRn> copyList = new ArrayList<ZT_DairitenItakuSyouhnRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DairitenItakuSyouhnRn(orders));
        return copyList;
    }

    
    public List<ZT_DairitenItakuSyouhnRn> OrderZT_DairitenItakuSyouhnRnByPkDesc(List<ZT_DairitenItakuSyouhnRn> pEntity) {
        List<SortCondition<ZT_DairitenItakuSyouhnRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DairitenItakuSyouhnRn()).zrndairitencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DairitenItakuSyouhnRn()).zrndrtsyouhinsikibetukbnstr, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DairitenItakuSyouhnRn()).zrndrthrkhouhoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DairitenItakuSyouhnRn()).zrndrtplannmkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DairitenItakuSyouhnRn()).zrnitakuhknhnbkaisiymd, SortOrder.DESC));
        List<ZT_DairitenItakuSyouhnRn> copyList = new ArrayList<ZT_DairitenItakuSyouhnRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DairitenItakuSyouhnRn(orders));
        return copyList;
    }
}

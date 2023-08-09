package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_HknkykIdouInfoRn;
import yuyu.def.db.meta.QZT_HknkykIdouInfoRn;
import yuyu.def.zdb.comparator.OrderZT_HknkykIdouInfoRn;

public class SortZT_HknkykIdouInfoRn {

    
    public List<ZT_HknkykIdouInfoRn> OrderZT_HknkykIdouInfoRnByPkAsc(List<ZT_HknkykIdouInfoRn> pEntity) {
        List<SortCondition<ZT_HknkykIdouInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoRn()).zrnkyktuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoRn()).zrnidouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoRn()).zrnidoujiyuukbnzfi, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoRn()).zrndatakanrino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoRn()).zrnrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoRn()).zrntumitatekinkbn, SortOrder.ASC));
        List<ZT_HknkykIdouInfoRn> copyList = new ArrayList<ZT_HknkykIdouInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_HknkykIdouInfoRn(orders));
        return copyList;
    }

    
    public List<ZT_HknkykIdouInfoRn> OrderZT_HknkykIdouInfoRnByPkDesc(List<ZT_HknkykIdouInfoRn> pEntity) {
        List<SortCondition<ZT_HknkykIdouInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoRn()).zrnkyktuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoRn()).zrnidouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoRn()).zrnidoujiyuukbnzfi, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoRn()).zrndatakanrino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoRn()).zrnrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoRn()).zrntumitatekinkbn, SortOrder.DESC));
        List<ZT_HknkykIdouInfoRn> copyList = new ArrayList<ZT_HknkykIdouInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_HknkykIdouInfoRn(orders));
        return copyList;
    }
}

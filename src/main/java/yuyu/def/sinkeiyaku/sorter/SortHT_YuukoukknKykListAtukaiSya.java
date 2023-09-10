package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_YuukoukknKykListAtukaiSya;
import yuyu.def.db.meta.QHT_YuukoukknKykListAtukaiSya;
import yuyu.def.sinkeiyaku.comparator.OrderHT_YuukoukknKykListAtukaiSya;

public class SortHT_YuukoukknKykListAtukaiSya {

    
    public List<HT_YuukoukknKykListAtukaiSya> OrderHT_YuukoukknKykListAtukaiSyaByPkAsc(List<HT_YuukoukknKykListAtukaiSya> pEntity) {
        List<SortCondition<HT_YuukoukknKykListAtukaiSya>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_YuukoukknKykListAtukaiSya()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_YuukoukknKykListAtukaiSya()).tyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_YuukoukknKykListAtukaiSya()).keikakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_YuukoukknKykListAtukaiSya()).renno, SortOrder.ASC));
        List<HT_YuukoukknKykListAtukaiSya> copyList = new ArrayList<HT_YuukoukknKykListAtukaiSya>(pEntity);
        Collections.sort(copyList, new OrderHT_YuukoukknKykListAtukaiSya(orders));
        return copyList;
    }

    
    public List<HT_YuukoukknKykListAtukaiSya> OrderHT_YuukoukknKykListAtukaiSyaByPkDesc(List<HT_YuukoukknKykListAtukaiSya> pEntity) {
        List<SortCondition<HT_YuukoukknKykListAtukaiSya>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_YuukoukknKykListAtukaiSya()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_YuukoukknKykListAtukaiSya()).tyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_YuukoukknKykListAtukaiSya()).keikakbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_YuukoukknKykListAtukaiSya()).renno, SortOrder.DESC));
        List<HT_YuukoukknKykListAtukaiSya> copyList = new ArrayList<HT_YuukoukknKykListAtukaiSya>(pEntity);
        Collections.sort(copyList, new OrderHT_YuukoukknKykListAtukaiSya(orders));
        return copyList;
    }

}


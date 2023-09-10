package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.meta.QHT_SkHubiDetail;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkHubiDetail;

public class SortHT_SkHubiDetail {

    
    public List<HT_SkHubiDetail> OrderHT_SkHubiDetailByPkAsc(List<HT_SkHubiDetail> pEntity) {
        List<SortCondition<HT_SkHubiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkHubiDetail()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkHubiDetail()).hubisikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkHubiDetail()).renno3keta, SortOrder.ASC));
        List<HT_SkHubiDetail> copyList = new ArrayList<HT_SkHubiDetail>(pEntity);
        Collections.sort(copyList, new OrderHT_SkHubiDetail(orders));
        return copyList;
    }

    
    public List<HT_SkHubiDetail> OrderHT_SkHubiDetailByPkDesc(List<HT_SkHubiDetail> pEntity) {
        List<SortCondition<HT_SkHubiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkHubiDetail()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkHubiDetail()).hubisikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkHubiDetail()).renno3keta, SortOrder.DESC));
        List<HT_SkHubiDetail> copyList = new ArrayList<HT_SkHubiDetail>(pEntity);
        Collections.sort(copyList, new OrderHT_SkHubiDetail(orders));
        return copyList;
    }

    
    public List<HT_SkHubiDetail> OrderHT_SkHubiDetailByHasinymdRenno3ketaAsc(List<HT_SkHubiDetail> pEntity) {
        List<SortCondition<HT_SkHubiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkHubiDetail()).hasinymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkHubiDetail()).renno3keta, SortOrder.ASC));
        List<HT_SkHubiDetail> copyList = new ArrayList<HT_SkHubiDetail>(pEntity);
        Collections.sort(copyList, new OrderHT_SkHubiDetail(orders));
        return copyList;
    }
    
    public List<HT_SkHubiDetail> OrderHT_SkHubiDetailByHasinymdAsc(List<HT_SkHubiDetail> pEntity) {
        List<SortCondition<HT_SkHubiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkHubiDetail()).hasinymd, SortOrder.ASC));
        List<HT_SkHubiDetail> copyList = new ArrayList<HT_SkHubiDetail>(pEntity);
        Collections.sort(copyList, new OrderHT_SkHubiDetail(orders));
        return copyList;
    }
    
    public List<HT_SkHubiDetail> OrderHT_SkHubiDetailByKaisyouymdHasinymdRenno3ketaAsc(List<HT_SkHubiDetail> pEntity) {
        List<SortCondition<HT_SkHubiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkHubiDetail()).kaisyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkHubiDetail()).hasinymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkHubiDetail()).renno3keta, SortOrder.ASC));
        List<HT_SkHubiDetail> copyList = new ArrayList<HT_SkHubiDetail>(pEntity);
        Collections.sort(copyList, new OrderHT_SkHubiDetail(orders));
        return copyList;
    }



}


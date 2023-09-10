package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiHubiDetail;
import yuyu.def.db.meta.QJT_SiHubiDetail;
import yuyu.def.siharai.comparator.OrderJT_SiHubiDetail;

public class SortJT_SiHubiDetail {

    
    public List<JT_SiHubiDetail> OrderJT_SiHubiDetailByPkAsc(List<JT_SiHubiDetail> pEntity) {
        List<SortCondition<JT_SiHubiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiHubiDetail()).hubisikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiHubiDetail()).renno3keta, SortOrder.ASC));
        List<JT_SiHubiDetail> copyList = new ArrayList<JT_SiHubiDetail>(pEntity);
        Collections.sort(copyList, new OrderJT_SiHubiDetail(orders));
        return copyList;
    }

    
    public List<JT_SiHubiDetail> OrderJT_SiHubiDetailByPkDesc(List<JT_SiHubiDetail> pEntity) {
        List<SortCondition<JT_SiHubiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiHubiDetail()).hubisikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiHubiDetail()).renno3keta, SortOrder.DESC));
        List<JT_SiHubiDetail> copyList = new ArrayList<JT_SiHubiDetail>(pEntity);
        Collections.sort(copyList, new OrderJT_SiHubiDetail(orders));
        return copyList;
    }
    
    public List<JT_SiHubiDetail> OrderJT_SiHubiDetailByHasinymdRenno3ketaAsc(List<JT_SiHubiDetail> pEntity) {
        List<SortCondition<JT_SiHubiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiHubiDetail()).hasinymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiHubiDetail()).renno3keta, SortOrder.ASC));
        List<JT_SiHubiDetail> copyList = new ArrayList<JT_SiHubiDetail>(pEntity);
        Collections.sort(copyList, new OrderJT_SiHubiDetail(orders));
        return copyList;
    }

    
    public List<JT_SiHubiDetail> OrderJT_SiHubiDetailByKaisyouymdHasinymdRenno3ketaAsc(List<JT_SiHubiDetail> pEntity) {
        List<SortCondition<JT_SiHubiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiHubiDetail()).kaisyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiHubiDetail()).hasinymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiHubiDetail()).renno3keta, SortOrder.ASC));
        List<JT_SiHubiDetail> copyList = new ArrayList<JT_SiHubiDetail>(pEntity);
        Collections.sort(copyList, new OrderJT_SiHubiDetail(orders));
        return copyList;
    }


}


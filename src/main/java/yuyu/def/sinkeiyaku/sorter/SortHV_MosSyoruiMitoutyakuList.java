package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HV_MosSyoruiMitoutyakuList;
import yuyu.def.db.meta.QHV_MosSyoruiMitoutyakuList;
import yuyu.def.sinkeiyaku.comparator.OrderHV_MosSyoruiMitoutyakuList;

public class SortHV_MosSyoruiMitoutyakuList {

    
    public List<HV_MosSyoruiMitoutyakuList> OrderHV_MosSyoruiMitoutyakuListByPkAsc(List<HV_MosSyoruiMitoutyakuList> pEntity) {
        List<SortCondition<HV_MosSyoruiMitoutyakuList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHV_MosSyoruiMitoutyakuList()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHV_MosSyoruiMitoutyakuList()).itirenno, SortOrder.ASC));
        List<HV_MosSyoruiMitoutyakuList> copyList = new ArrayList<HV_MosSyoruiMitoutyakuList>(pEntity);
        Collections.sort(copyList, new OrderHV_MosSyoruiMitoutyakuList(orders));
        return copyList;
    }

    
    public List<HV_MosSyoruiMitoutyakuList> OrderHV_MosSyoruiMitoutyakuListByPkDesc(List<HV_MosSyoruiMitoutyakuList> pEntity) {
        List<SortCondition<HV_MosSyoruiMitoutyakuList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHV_MosSyoruiMitoutyakuList()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHV_MosSyoruiMitoutyakuList()).itirenno, SortOrder.DESC));
        List<HV_MosSyoruiMitoutyakuList> copyList = new ArrayList<HV_MosSyoruiMitoutyakuList>(pEntity);
        Collections.sort(copyList, new OrderHV_MosSyoruiMitoutyakuList(orders));
        return copyList;
    }
}

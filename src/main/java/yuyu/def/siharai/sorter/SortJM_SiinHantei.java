package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JM_SiinHantei;
import yuyu.def.db.meta.QJM_SiinHantei;
import yuyu.def.siharai.comparator.OrderJM_SiinHantei;

public class SortJM_SiinHantei {

    
    public List<JM_SiinHantei> OrderJM_SiinHanteiByPkAsc(List<JM_SiinHantei> pEntity) {
        List<SortCondition<JM_SiinHantei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_SiinHantei()).siboukariuketukejigeninkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SiinHantei()).seikyuuuketukejigeninkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SiinHantei()).kansensyouumukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SiinHantei()).saigaikanouseiumukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SiinHantei()).husyounosiumukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SiinHantei()).sateikaksaigaikanouseikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SiinHantei()).sateikakhusyousikbn, SortOrder.ASC));
        List<JM_SiinHantei> copyList = new ArrayList<JM_SiinHantei>(pEntity);
        Collections.sort(copyList, new OrderJM_SiinHantei(orders));
        return copyList;
    }

    
    public List<JM_SiinHantei> OrderJM_SiinHanteiByPkDesc(List<JM_SiinHantei> pEntity) {
        List<SortCondition<JM_SiinHantei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_SiinHantei()).siboukariuketukejigeninkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SiinHantei()).seikyuuuketukejigeninkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SiinHantei()).kansensyouumukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SiinHantei()).saigaikanouseiumukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SiinHantei()).husyounosiumukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SiinHantei()).sateikaksaigaikanouseikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SiinHantei()).sateikakhusyousikbn, SortOrder.DESC));
        List<JM_SiinHantei> copyList = new ArrayList<JM_SiinHantei>(pEntity);
        Collections.sort(copyList, new OrderJM_SiinHantei(orders));
        return copyList;
    }
}

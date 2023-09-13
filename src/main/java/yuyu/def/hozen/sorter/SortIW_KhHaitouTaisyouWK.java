package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhHaitouTaisyouWK;
import yuyu.def.db.meta.QIW_KhHaitouTaisyouWK;
import yuyu.def.hozen.comparator.OrderIW_KhHaitouTaisyouWK;

public class SortIW_KhHaitouTaisyouWK {

    public List<IW_KhHaitouTaisyouWK> OrderIW_KhHaitouTaisyouWKByPkAsc(List<IW_KhHaitouTaisyouWK> pEntity) {
        List<SortCondition<IW_KhHaitouTaisyouWK>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhHaitouTaisyouWK()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIW_KhHaitouTaisyouWK()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIW_KhHaitouTaisyouWK()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIW_KhHaitouTaisyouWK()).haitoukinuketorihoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIW_KhHaitouTaisyouWK()).haitoumeisaikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIW_KhHaitouTaisyouWK()).renno, SortOrder.ASC));
        List<IW_KhHaitouTaisyouWK> copyList = new ArrayList<IW_KhHaitouTaisyouWK>(pEntity);
        Collections.sort(copyList, new OrderIW_KhHaitouTaisyouWK(orders));
        return copyList;
    }

    public List<IW_KhHaitouTaisyouWK> OrderIW_KhHaitouTaisyouWKByPkDesc(List<IW_KhHaitouTaisyouWK> pEntity) {
        List<SortCondition<IW_KhHaitouTaisyouWK>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhHaitouTaisyouWK()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIW_KhHaitouTaisyouWK()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIW_KhHaitouTaisyouWK()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIW_KhHaitouTaisyouWK()).haitoukinuketorihoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIW_KhHaitouTaisyouWK()).haitoumeisaikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIW_KhHaitouTaisyouWK()).renno, SortOrder.DESC));
        List<IW_KhHaitouTaisyouWK> copyList = new ArrayList<IW_KhHaitouTaisyouWK>(pEntity);
        Collections.sort(copyList, new OrderIW_KhHaitouTaisyouWK(orders));
        return copyList;
    }
}

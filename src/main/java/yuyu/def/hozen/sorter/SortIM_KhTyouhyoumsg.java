package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IM_KhTyouhyoumsg;
import yuyu.def.db.meta.QIM_KhTyouhyoumsg;
import yuyu.def.hozen.comparator.OrderIM_KhTyouhyoumsg;

public class SortIM_KhTyouhyoumsg {

    public List<IM_KhTyouhyoumsg> OrderIM_KhTyouhyoumsgByPkAsc(List<IM_KhTyouhyoumsg> pEntity) {
        List<SortCondition<IM_KhTyouhyoumsg>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg()).syoruiCd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg()).meigihnkjiyuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg()).kyksbumu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg()).shrumu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg()).tuityouumu, SortOrder.ASC));
        List<IM_KhTyouhyoumsg> copyList = new ArrayList<IM_KhTyouhyoumsg>(pEntity);
        Collections.sort(copyList, new OrderIM_KhTyouhyoumsg(orders));
        return copyList;
    }

    public List<IM_KhTyouhyoumsg> OrderIM_KhTyouhyoumsgByPkDesc(List<IM_KhTyouhyoumsg> pEntity) {
        List<SortCondition<IM_KhTyouhyoumsg>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg()).syoruiCd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg()).meigihnkjiyuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg()).kyksbumu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg()).shrumu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg()).tuityouumu, SortOrder.DESC));
        List<IM_KhTyouhyoumsg> copyList = new ArrayList<IM_KhTyouhyoumsg>(pEntity);
        Collections.sort(copyList, new OrderIM_KhTyouhyoumsg(orders));
        return copyList;
    }

}


package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IM_KhTyouhyoumsg2;
import yuyu.def.db.meta.QIM_KhTyouhyoumsg2;
import yuyu.def.hozen.comparator.OrderIM_KhTyouhyoumsg2;

public class SortIM_KhTyouhyoumsg2 {

    public List<IM_KhTyouhyoumsg2> OrderIM_KhTyouhyoumsg2ByPkAsc(List<IM_KhTyouhyoumsg2> pEntity) {
        List<SortCondition<IM_KhTyouhyoumsg2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg2()).syoruiCd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg2()).meigihnkjiyuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg2()).kyksbumu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg2()).shrumu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg2()).tuityouumu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg2()).khtyouhyoumsgbunruikbn1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg2()).khtyouhyoumsgbunruikbn2, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg2()).khtyouhyoumsgbunruikbn3, SortOrder.ASC));
        List<IM_KhTyouhyoumsg2> copyList = new ArrayList<IM_KhTyouhyoumsg2>(pEntity);
        Collections.sort(copyList, new OrderIM_KhTyouhyoumsg2(orders));
        return copyList;
    }

    public List<IM_KhTyouhyoumsg2> OrderIM_KhTyouhyoumsg2ByPkDesc(List<IM_KhTyouhyoumsg2> pEntity) {
        List<SortCondition<IM_KhTyouhyoumsg2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg2()).syoruiCd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg2()).meigihnkjiyuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg2()).kyksbumu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg2()).shrumu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg2()).tuityouumu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg2()).khtyouhyoumsgbunruikbn1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg2()).khtyouhyoumsgbunruikbn2, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_KhTyouhyoumsg2()).khtyouhyoumsgbunruikbn3, SortOrder.DESC));
        List<IM_KhTyouhyoumsg2> copyList = new ArrayList<IM_KhTyouhyoumsg2>(pEntity);
        Collections.sort(copyList, new OrderIM_KhTyouhyoumsg2(orders));
        return copyList;
    }
}

package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KydGWKykInfoRn;
import yuyu.def.db.meta.QZT_KydGWKykInfoRn;
import yuyu.def.zdb.comparator.OrderZT_KydGWKykInfoRn;

public class SortZT_KydGWKykInfoRn {

    
    public List<ZT_KydGWKykInfoRn> OrderZT_KydGWKykInfoRnByPkAsc(List<ZT_KydGWKykInfoRn> pEntity) {
        List<SortCondition<ZT_KydGWKykInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KydGWKykInfoRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KydGWKykInfoRn()).zrnsyoriymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KydGWKykInfoRn()).zrnkykmfksnctrlkh, SortOrder.ASC));
        List<ZT_KydGWKykInfoRn> copyList = new ArrayList<ZT_KydGWKykInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KydGWKykInfoRn(orders));
        return copyList;
    }

    
    public List<ZT_KydGWKykInfoRn> OrderZT_KydGWKykInfoRnByPkDesc(List<ZT_KydGWKykInfoRn> pEntity) {
        List<SortCondition<ZT_KydGWKykInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KydGWKykInfoRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KydGWKykInfoRn()).zrnsyoriymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KydGWKykInfoRn()).zrnkykmfksnctrlkh, SortOrder.DESC));
        List<ZT_KydGWKykInfoRn> copyList = new ArrayList<ZT_KydGWKykInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KydGWKykInfoRn(orders));
        return copyList;
    }
}

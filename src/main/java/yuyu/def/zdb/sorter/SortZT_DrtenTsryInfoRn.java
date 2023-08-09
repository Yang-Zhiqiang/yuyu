package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DrtenTsryInfoRn;
import yuyu.def.db.meta.QZT_DrtenTsryInfoRn;
import yuyu.def.zdb.comparator.OrderZT_DrtenTsryInfoRn;

public class SortZT_DrtenTsryInfoRn {

    
    public List<ZT_DrtenTsryInfoRn> OrderZT_DrtenTsryInfoRnByPkAsc(List<ZT_DrtenTsryInfoRn> pEntity) {
        List<SortCondition<ZT_DrtenTsryInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoRn()).zrndairitencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoRn()).zrnbosyuunincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoRn()).zrnkikaisyoriymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoRn()).zrnkykmfksnctrlkh, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoRn()).zrnsikibetujyunjyo, SortOrder.ASC));
        List<ZT_DrtenTsryInfoRn> copyList = new ArrayList<ZT_DrtenTsryInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenTsryInfoRn(orders));
        return copyList;
    }

    
    public List<ZT_DrtenTsryInfoRn> OrderZT_DrtenTsryInfoRnByPkDesc(List<ZT_DrtenTsryInfoRn> pEntity) {
        List<SortCondition<ZT_DrtenTsryInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoRn()).zrndairitencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoRn()).zrnbosyuunincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoRn()).zrnkikaisyoriymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoRn()).zrnkykmfksnctrlkh, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenTsryInfoRn()).zrnsikibetujyunjyo, SortOrder.DESC));
        List<ZT_DrtenTsryInfoRn> copyList = new ArrayList<ZT_DrtenTsryInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenTsryInfoRn(orders));
        return copyList;
    }
}

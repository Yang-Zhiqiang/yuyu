package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiJinsokuShrTtdkInfo;
import yuyu.def.db.meta.QJT_SiJinsokuShrTtdkInfo;
import yuyu.def.siharai.comparator.OrderJT_SiJinsokuShrTtdkInfo;

public class SortJT_SiJinsokuShrTtdkInfo {

    
    public List<JT_SiJinsokuShrTtdkInfo> OrderJT_SiJinsokuShrTtdkInfoByPkAsc(List<JT_SiJinsokuShrTtdkInfo> pEntity) {
        List<SortCondition<JT_SiJinsokuShrTtdkInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiJinsokuShrTtdkInfo()).syorisosikicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiJinsokuShrTtdkInfo()).syoricd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiJinsokuShrTtdkInfo()).hknknshrsntkno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiJinsokuShrTtdkInfo()).syoruiukeymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiJinsokuShrTtdkInfo()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiJinsokuShrTtdkInfo()).denymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiJinsokuShrTtdkInfo()).syono, SortOrder.ASC));
        List<JT_SiJinsokuShrTtdkInfo> copyList = new ArrayList<JT_SiJinsokuShrTtdkInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_SiJinsokuShrTtdkInfo(orders));
        return copyList;
    }

    
    public List<JT_SiJinsokuShrTtdkInfo> OrderJT_SiJinsokuShrTtdkInfoByPkDesc(List<JT_SiJinsokuShrTtdkInfo> pEntity) {
        List<SortCondition<JT_SiJinsokuShrTtdkInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiJinsokuShrTtdkInfo()).syorisosikicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiJinsokuShrTtdkInfo()).syoricd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiJinsokuShrTtdkInfo()).hknknshrsntkno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiJinsokuShrTtdkInfo()).syoruiukeymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiJinsokuShrTtdkInfo()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiJinsokuShrTtdkInfo()).denymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiJinsokuShrTtdkInfo()).syono, SortOrder.DESC));
        List<JT_SiJinsokuShrTtdkInfo> copyList = new ArrayList<JT_SiJinsokuShrTtdkInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_SiJinsokuShrTtdkInfo(orders));
        return copyList;
    }
}

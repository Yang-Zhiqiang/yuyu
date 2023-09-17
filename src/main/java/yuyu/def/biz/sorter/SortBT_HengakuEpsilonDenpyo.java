package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_HengakuEpsilonDenpyo;
import yuyu.def.db.entity.BT_HengakuEpsilonDenpyo;
import yuyu.def.db.meta.QBT_HengakuEpsilonDenpyo;

public class SortBT_HengakuEpsilonDenpyo {

    public List<BT_HengakuEpsilonDenpyo> OrderBT_HengakuEpsilonDenpyoByPkAsc(List<BT_HengakuEpsilonDenpyo> pEntity) {
        List<SortCondition<BT_HengakuEpsilonDenpyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).hengakusyuruikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).unitfundkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).tkbtkanjyouunitfundkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).kacd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).denymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).denpyoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).taisyakukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).kamokucd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).syoriYmd, SortOrder.ASC));
        List<BT_HengakuEpsilonDenpyo> copyList = new ArrayList<BT_HengakuEpsilonDenpyo>(pEntity);
        Collections.sort(copyList, new OrderBT_HengakuEpsilonDenpyo(orders));
        return copyList;
    }

    public List<BT_HengakuEpsilonDenpyo> OrderBT_HengakuEpsilonDenpyoByPkDesc(List<BT_HengakuEpsilonDenpyo> pEntity) {
        List<SortCondition<BT_HengakuEpsilonDenpyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).hengakusyuruikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).unitfundkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).tkbtkanjyouunitfundkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).kacd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).denymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).denpyoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).taisyakukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).kamokucd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_HengakuEpsilonDenpyo()).syoriYmd, SortOrder.DESC));
        List<BT_HengakuEpsilonDenpyo> copyList = new ArrayList<BT_HengakuEpsilonDenpyo>(pEntity);
        Collections.sort(copyList, new OrderBT_HengakuEpsilonDenpyo(orders));
        return copyList;
    }

}


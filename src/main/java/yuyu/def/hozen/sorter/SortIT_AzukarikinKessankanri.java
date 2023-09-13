package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_AzukarikinKessankanri;
import yuyu.def.db.meta.QIT_AzukarikinKessankanri;
import yuyu.def.hozen.comparator.OrderIT_AzukarikinKessankanri;

public class SortIT_AzukarikinKessankanri {

    public List<IT_AzukarikinKessankanri> OrderIT_AzukarikinKessankanriByPkAsc(List<IT_AzukarikinKessankanri> pEntity) {
        List<SortCondition<IT_AzukarikinKessankanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AzukarikinKessankanri()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AzukarikinKessankanri()).kessankijyunymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AzukarikinKessankanri()).henkousikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AzukarikinKessankanri()).tuukasyu, SortOrder.ASC));
        List<IT_AzukarikinKessankanri> copyList = new ArrayList<IT_AzukarikinKessankanri>(pEntity);
        Collections.sort(copyList, new OrderIT_AzukarikinKessankanri(orders));
        return copyList;
    }

    public List<IT_AzukarikinKessankanri> OrderIT_AzukarikinKessankanriByPkDesc(List<IT_AzukarikinKessankanri> pEntity) {
        List<SortCondition<IT_AzukarikinKessankanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AzukarikinKessankanri()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AzukarikinKessankanri()).kessankijyunymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AzukarikinKessankanri()).henkousikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AzukarikinKessankanri()).tuukasyu, SortOrder.DESC));
        List<IT_AzukarikinKessankanri> copyList = new ArrayList<IT_AzukarikinKessankanri>(pEntity);
        Collections.sort(copyList, new OrderIT_AzukarikinKessankanri(orders));
        return copyList;
    }
}

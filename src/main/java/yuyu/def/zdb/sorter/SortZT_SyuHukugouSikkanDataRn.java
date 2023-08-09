package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SyuHukugouSikkanDataRn;
import yuyu.def.db.meta.QZT_SyuHukugouSikkanDataRn;
import yuyu.def.zdb.comparator.OrderZT_SyuHukugouSikkanDataRn;

public class SortZT_SyuHukugouSikkanDataRn {

    
    public List<ZT_SyuHukugouSikkanDataRn> OrderZT_SyuHukugouSikkanDataRnByPkAsc(List<ZT_SyuHukugouSikkanDataRn> pEntity) {
        List<SortCondition<ZT_SyuHukugouSikkanDataRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnijitoukeidaihyousyurui, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnkeiyakunendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnhknnendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnhhknseikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnkykage, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrntoutatunenrei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnatukaibetu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnsinsahouhou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnketteikekkakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnsibousrank, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnjissituhosyousrank, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnsirajikykkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnhrkhuhukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnhknsyurui2keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrndaisiincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrntyuusiincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnsyousiincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnnenreihousikikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnsykgycd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrntodouhukencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnbotaisisyaeigyouhonbu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnsisyaeigyoubu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnaatukaisosikicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnnensyuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnhanbaikeirokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnoyadairitencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrntratkidrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnbsudirtnatkikeitaikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnkyktuuka, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnhrktuuka, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnhknsyukigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnsyksbyensitihsyutyhkumu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnjyudkaigomehrtkhkumu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnijitoukeizennoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrndai1hknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnijitoukeitikshrtkykkbn, SortOrder.ASC));
        List<ZT_SyuHukugouSikkanDataRn> copyList = new ArrayList<ZT_SyuHukugouSikkanDataRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SyuHukugouSikkanDataRn(orders));
        return copyList;
    }

    
    public List<ZT_SyuHukugouSikkanDataRn> OrderZT_SyuHukugouSikkanDataRnByPkDesc(List<ZT_SyuHukugouSikkanDataRn> pEntity) {
        List<SortCondition<ZT_SyuHukugouSikkanDataRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnijitoukeidaihyousyurui, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnkeiyakunendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnhknnendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnhhknseikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnkykage, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrntoutatunenrei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnatukaibetu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnsinsahouhou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnketteikekkakbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnsibousrank, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnjissituhosyousrank, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnsirajikykkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnhrkhuhukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnhknsyurui2keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrndaisiincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrntyuusiincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnsyousiincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnnenreihousikikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnsykgycd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrntodouhukencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnbotaisisyaeigyouhonbu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnsisyaeigyoubu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnaatukaisosikicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnnensyuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnhanbaikeirokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnoyadairitencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrntratkidrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnbsudirtnatkikeitaikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnkyktuuka, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnhrktuuka, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnhknsyukigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnsyksbyensitihsyutyhkumu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnjyudkaigomehrtkhkumu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnijitoukeizennoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrndai1hknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataRn()).zrnijitoukeitikshrtkykkbn, SortOrder.DESC));
        List<ZT_SyuHukugouSikkanDataRn> copyList = new ArrayList<ZT_SyuHukugouSikkanDataRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SyuHukugouSikkanDataRn(orders));
        return copyList;
    }
}

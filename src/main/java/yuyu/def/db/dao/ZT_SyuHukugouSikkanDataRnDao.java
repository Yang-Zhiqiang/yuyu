package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SyuHukugouSikkanDataRn;
import yuyu.def.db.meta.QZT_SyuHukugouSikkanDataRn;

/**
 * 普保Ⅱ主契約複合疾患データテーブル（連）(ZT_SyuHukugouSikkanDataRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SyuHukugouSikkanDataRnDao extends AbstractDao<ZT_SyuHukugouSikkanDataRn> {

    public ZT_SyuHukugouSikkanDataRnDao() {
        super(ZT_SyuHukugouSikkanDataRn.class);
    }

    public ZT_SyuHukugouSikkanDataRn getSyuHukugouSikkanDataRn(String pZrnijitoukeidaihyousyurui, String pZrnkeiyakunendo, String pZrnhknnendo, String pZrnhhknseikbn, String pZrnkykage, String pZrntoutatunenrei, String pZrnatukaibetu, String pZrnsinsahouhou, String pZrnketteikekkakbn, String pZrnsibousrank, String pZrnjissituhosyousrank, String pZrnsirajikykkbn, String pZrnhrkhuhukbn, String pZrnhknsyurui2keta, String pZrndaisiincd, String pZrntyuusiincd, String pZrnsyousiincd, String pZrnnenreihousikikbn, String pZrnsykgycd, String pZrntodouhukencd, String pZrnbotaisisyaeigyouhonbu, String pZrnsisyaeigyoubu, String pZrnaatukaisosikicd, String pZrnnensyuukbn, String pZrnhanbaikeirokbn, String pZrnoyadairitencd, String pZrntratkidrtencd, String pZrnbsudirtnatkikeitaikbn, String pZrnkyktuuka, String pZrnhrktuuka, String pZrnhknsyukigou, String pZrnsyksbyensitihsyutyhkumu, String pZrnjyudkaigomehrtkhkumu, String pZrnijitoukeizennoukbn, String pZrndai1hknkkn, String pZrnijitoukeitikshrtkykkbn) {
        ZT_SyuHukugouSikkanDataRn zT_SyuHukugouSikkanDataRn =  new ZT_SyuHukugouSikkanDataRn();
        zT_SyuHukugouSikkanDataRn.setZrnijitoukeidaihyousyurui(pZrnijitoukeidaihyousyurui);
        zT_SyuHukugouSikkanDataRn.setZrnkeiyakunendo(pZrnkeiyakunendo);
        zT_SyuHukugouSikkanDataRn.setZrnhknnendo(pZrnhknnendo);
        zT_SyuHukugouSikkanDataRn.setZrnhhknseikbn(pZrnhhknseikbn);
        zT_SyuHukugouSikkanDataRn.setZrnkykage(pZrnkykage);
        zT_SyuHukugouSikkanDataRn.setZrntoutatunenrei(pZrntoutatunenrei);
        zT_SyuHukugouSikkanDataRn.setZrnatukaibetu(pZrnatukaibetu);
        zT_SyuHukugouSikkanDataRn.setZrnsinsahouhou(pZrnsinsahouhou);
        zT_SyuHukugouSikkanDataRn.setZrnketteikekkakbn(pZrnketteikekkakbn);
        zT_SyuHukugouSikkanDataRn.setZrnsibousrank(pZrnsibousrank);
        zT_SyuHukugouSikkanDataRn.setZrnjissituhosyousrank(pZrnjissituhosyousrank);
        zT_SyuHukugouSikkanDataRn.setZrnsirajikykkbn(pZrnsirajikykkbn);
        zT_SyuHukugouSikkanDataRn.setZrnhrkhuhukbn(pZrnhrkhuhukbn);
        zT_SyuHukugouSikkanDataRn.setZrnhknsyurui2keta(pZrnhknsyurui2keta);
        zT_SyuHukugouSikkanDataRn.setZrndaisiincd(pZrndaisiincd);
        zT_SyuHukugouSikkanDataRn.setZrntyuusiincd(pZrntyuusiincd);
        zT_SyuHukugouSikkanDataRn.setZrnsyousiincd(pZrnsyousiincd);
        zT_SyuHukugouSikkanDataRn.setZrnnenreihousikikbn(pZrnnenreihousikikbn);
        zT_SyuHukugouSikkanDataRn.setZrnsykgycd(pZrnsykgycd);
        zT_SyuHukugouSikkanDataRn.setZrntodouhukencd(pZrntodouhukencd);
        zT_SyuHukugouSikkanDataRn.setZrnbotaisisyaeigyouhonbu(pZrnbotaisisyaeigyouhonbu);
        zT_SyuHukugouSikkanDataRn.setZrnsisyaeigyoubu(pZrnsisyaeigyoubu);
        zT_SyuHukugouSikkanDataRn.setZrnaatukaisosikicd(pZrnaatukaisosikicd);
        zT_SyuHukugouSikkanDataRn.setZrnnensyuukbn(pZrnnensyuukbn);
        zT_SyuHukugouSikkanDataRn.setZrnhanbaikeirokbn(pZrnhanbaikeirokbn);
        zT_SyuHukugouSikkanDataRn.setZrnoyadairitencd(pZrnoyadairitencd);
        zT_SyuHukugouSikkanDataRn.setZrntratkidrtencd(pZrntratkidrtencd);
        zT_SyuHukugouSikkanDataRn.setZrnbsudirtnatkikeitaikbn(pZrnbsudirtnatkikeitaikbn);
        zT_SyuHukugouSikkanDataRn.setZrnkyktuuka(pZrnkyktuuka);
        zT_SyuHukugouSikkanDataRn.setZrnhrktuuka(pZrnhrktuuka);
        zT_SyuHukugouSikkanDataRn.setZrnhknsyukigou(pZrnhknsyukigou);
        zT_SyuHukugouSikkanDataRn.setZrnsyksbyensitihsyutyhkumu(pZrnsyksbyensitihsyutyhkumu);
        zT_SyuHukugouSikkanDataRn.setZrnjyudkaigomehrtkhkumu(pZrnjyudkaigomehrtkhkumu);
        zT_SyuHukugouSikkanDataRn.setZrnijitoukeizennoukbn(pZrnijitoukeizennoukbn);
        zT_SyuHukugouSikkanDataRn.setZrndai1hknkkn(pZrndai1hknkkn);
        zT_SyuHukugouSikkanDataRn.setZrnijitoukeitikshrtkykkbn(pZrnijitoukeitikshrtkykkbn);
        return this.selectOne(zT_SyuHukugouSikkanDataRn);
    }

    public ExDBResults<ZT_SyuHukugouSikkanDataRn> selectAllZT_SyuHukugouSikkanDataRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SyuHukugouSikkanDataRn qZT_SyuHukugouSikkanDataRn =  new QZT_SyuHukugouSikkanDataRn();
        jpql.append($SELECT);
        jpql.append(qZT_SyuHukugouSikkanDataRn);
        jpql.append($FROM);
        jpql.append(qZT_SyuHukugouSikkanDataRn.ZT_SyuHukugouSikkanDataRn());
        jpql.append($ORDER_BY(qZT_SyuHukugouSikkanDataRn.zrnijitoukeidaihyousyurui.asc(), qZT_SyuHukugouSikkanDataRn.zrnkeiyakunendo.asc(), qZT_SyuHukugouSikkanDataRn.zrnhknnendo.asc(), qZT_SyuHukugouSikkanDataRn.zrnhhknseikbn.asc(), qZT_SyuHukugouSikkanDataRn.zrnkykage.asc(), qZT_SyuHukugouSikkanDataRn.zrntoutatunenrei.asc(), qZT_SyuHukugouSikkanDataRn.zrnatukaibetu.asc(), qZT_SyuHukugouSikkanDataRn.zrnsinsahouhou.asc(), qZT_SyuHukugouSikkanDataRn.zrnketteikekkakbn.asc(), qZT_SyuHukugouSikkanDataRn.zrnsibousrank.asc(), qZT_SyuHukugouSikkanDataRn.zrnjissituhosyousrank.asc(), qZT_SyuHukugouSikkanDataRn.zrnsirajikykkbn.asc(), qZT_SyuHukugouSikkanDataRn.zrnhrkhuhukbn.asc(), qZT_SyuHukugouSikkanDataRn.zrnhknsyurui2keta.asc(), qZT_SyuHukugouSikkanDataRn.zrndaisiincd.asc(), qZT_SyuHukugouSikkanDataRn.zrntyuusiincd.asc(), qZT_SyuHukugouSikkanDataRn.zrnsyousiincd.asc(), qZT_SyuHukugouSikkanDataRn.zrnnenreihousikikbn.asc(), qZT_SyuHukugouSikkanDataRn.zrnsykgycd.asc(), qZT_SyuHukugouSikkanDataRn.zrntodouhukencd.asc(), qZT_SyuHukugouSikkanDataRn.zrnbotaisisyaeigyouhonbu.asc(), qZT_SyuHukugouSikkanDataRn.zrnsisyaeigyoubu.asc(), qZT_SyuHukugouSikkanDataRn.zrnaatukaisosikicd.asc(), qZT_SyuHukugouSikkanDataRn.zrnnensyuukbn.asc(), qZT_SyuHukugouSikkanDataRn.zrnhanbaikeirokbn.asc(), qZT_SyuHukugouSikkanDataRn.zrnoyadairitencd.asc(), qZT_SyuHukugouSikkanDataRn.zrntratkidrtencd.asc(), qZT_SyuHukugouSikkanDataRn.zrnbsudirtnatkikeitaikbn.asc(), qZT_SyuHukugouSikkanDataRn.zrnkyktuuka.asc(), qZT_SyuHukugouSikkanDataRn.zrnhrktuuka.asc(), qZT_SyuHukugouSikkanDataRn.zrnhknsyukigou.asc(), qZT_SyuHukugouSikkanDataRn.zrnsyksbyensitihsyutyhkumu.asc(), qZT_SyuHukugouSikkanDataRn.zrnjyudkaigomehrtkhkumu.asc(), qZT_SyuHukugouSikkanDataRn.zrnijitoukeizennoukbn.asc(), qZT_SyuHukugouSikkanDataRn.zrndai1hknkkn.asc(), qZT_SyuHukugouSikkanDataRn.zrnijitoukeitikshrtkykkbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SyuHukugouSikkanDataRn).getResults();
    }
}

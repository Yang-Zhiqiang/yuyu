package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SyuHukugouSikkanDataTy;
import yuyu.def.db.meta.QZT_SyuHukugouSikkanDataTy;

/**
 * 普保Ⅱ主契約複合疾患データテーブル（中）(ZT_SyuHukugouSikkanDataTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SyuHukugouSikkanDataTyDao extends AbstractDao<ZT_SyuHukugouSikkanDataTy> {

    public ZT_SyuHukugouSikkanDataTyDao() {
        super(ZT_SyuHukugouSikkanDataTy.class);
    }

    public ZT_SyuHukugouSikkanDataTy getSyuHukugouSikkanDataTy(String pZtyijitoukeidaihyousyurui, String pZtykeiyakunendo, String pZtyhknnendo, String pZtyhhknseikbn, String pZtykykage, String pZtytoutatunenrei, String pZtyatukaibetu, String pZtysinsahouhou, String pZtyketteikekkakbn, String pZtysibousrank, String pZtyjissituhosyousrank, String pZtysirajikykkbn, String pZtyhrkhuhukbn, String pZtyhknsyurui2keta, String pZtydaisiincd, String pZtytyuusiincd, String pZtysyousiincd, String pZtynenreihousikikbn, String pZtysykgycd, String pZtytodouhukencd, String pZtybotaisisyaeigyouhonbu, String pZtysisyaeigyoubu, String pZtyaatukaisosikicd, String pZtynensyuukbn, String pZtyhanbaikeirokbn, String pZtyoyadairitencd, String pZtytratkidrtencd, String pZtybsudirtnatkikeitaikbn, String pZtykyktuuka, String pZtyhrktuuka, String pZtyhknsyukigou, String pZtysyksbyensitihsyutyhkumu, String pZtyjyudkaigomehrtkhkumu, String pZtyijitoukeizennoukbn, String pZtydai1hknkkn, String pZtyijitoukeitikshrtkykkbn) {
        ZT_SyuHukugouSikkanDataTy zT_SyuHukugouSikkanDataTy =  new ZT_SyuHukugouSikkanDataTy();
        zT_SyuHukugouSikkanDataTy.setZtyijitoukeidaihyousyurui(pZtyijitoukeidaihyousyurui);
        zT_SyuHukugouSikkanDataTy.setZtykeiyakunendo(pZtykeiyakunendo);
        zT_SyuHukugouSikkanDataTy.setZtyhknnendo(pZtyhknnendo);
        zT_SyuHukugouSikkanDataTy.setZtyhhknseikbn(pZtyhhknseikbn);
        zT_SyuHukugouSikkanDataTy.setZtykykage(pZtykykage);
        zT_SyuHukugouSikkanDataTy.setZtytoutatunenrei(pZtytoutatunenrei);
        zT_SyuHukugouSikkanDataTy.setZtyatukaibetu(pZtyatukaibetu);
        zT_SyuHukugouSikkanDataTy.setZtysinsahouhou(pZtysinsahouhou);
        zT_SyuHukugouSikkanDataTy.setZtyketteikekkakbn(pZtyketteikekkakbn);
        zT_SyuHukugouSikkanDataTy.setZtysibousrank(pZtysibousrank);
        zT_SyuHukugouSikkanDataTy.setZtyjissituhosyousrank(pZtyjissituhosyousrank);
        zT_SyuHukugouSikkanDataTy.setZtysirajikykkbn(pZtysirajikykkbn);
        zT_SyuHukugouSikkanDataTy.setZtyhrkhuhukbn(pZtyhrkhuhukbn);
        zT_SyuHukugouSikkanDataTy.setZtyhknsyurui2keta(pZtyhknsyurui2keta);
        zT_SyuHukugouSikkanDataTy.setZtydaisiincd(pZtydaisiincd);
        zT_SyuHukugouSikkanDataTy.setZtytyuusiincd(pZtytyuusiincd);
        zT_SyuHukugouSikkanDataTy.setZtysyousiincd(pZtysyousiincd);
        zT_SyuHukugouSikkanDataTy.setZtynenreihousikikbn(pZtynenreihousikikbn);
        zT_SyuHukugouSikkanDataTy.setZtysykgycd(pZtysykgycd);
        zT_SyuHukugouSikkanDataTy.setZtytodouhukencd(pZtytodouhukencd);
        zT_SyuHukugouSikkanDataTy.setZtybotaisisyaeigyouhonbu(pZtybotaisisyaeigyouhonbu);
        zT_SyuHukugouSikkanDataTy.setZtysisyaeigyoubu(pZtysisyaeigyoubu);
        zT_SyuHukugouSikkanDataTy.setZtyaatukaisosikicd(pZtyaatukaisosikicd);
        zT_SyuHukugouSikkanDataTy.setZtynensyuukbn(pZtynensyuukbn);
        zT_SyuHukugouSikkanDataTy.setZtyhanbaikeirokbn(pZtyhanbaikeirokbn);
        zT_SyuHukugouSikkanDataTy.setZtyoyadairitencd(pZtyoyadairitencd);
        zT_SyuHukugouSikkanDataTy.setZtytratkidrtencd(pZtytratkidrtencd);
        zT_SyuHukugouSikkanDataTy.setZtybsudirtnatkikeitaikbn(pZtybsudirtnatkikeitaikbn);
        zT_SyuHukugouSikkanDataTy.setZtykyktuuka(pZtykyktuuka);
        zT_SyuHukugouSikkanDataTy.setZtyhrktuuka(pZtyhrktuuka);
        zT_SyuHukugouSikkanDataTy.setZtyhknsyukigou(pZtyhknsyukigou);
        zT_SyuHukugouSikkanDataTy.setZtysyksbyensitihsyutyhkumu(pZtysyksbyensitihsyutyhkumu);
        zT_SyuHukugouSikkanDataTy.setZtyjyudkaigomehrtkhkumu(pZtyjyudkaigomehrtkhkumu);
        zT_SyuHukugouSikkanDataTy.setZtyijitoukeizennoukbn(pZtyijitoukeizennoukbn);
        zT_SyuHukugouSikkanDataTy.setZtydai1hknkkn(pZtydai1hknkkn);
        zT_SyuHukugouSikkanDataTy.setZtyijitoukeitikshrtkykkbn(pZtyijitoukeitikshrtkykkbn);
        return this.selectOne(zT_SyuHukugouSikkanDataTy);
    }

    public ExDBResults<ZT_SyuHukugouSikkanDataTy> selectAllZT_SyuHukugouSikkanDataTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SyuHukugouSikkanDataTy qZT_SyuHukugouSikkanDataTy =  new QZT_SyuHukugouSikkanDataTy();
        jpql.append($SELECT);
        jpql.append(qZT_SyuHukugouSikkanDataTy);
        jpql.append($FROM);
        jpql.append(qZT_SyuHukugouSikkanDataTy.ZT_SyuHukugouSikkanDataTy());
        jpql.append($ORDER_BY(qZT_SyuHukugouSikkanDataTy.ztyijitoukeidaihyousyurui.asc(), qZT_SyuHukugouSikkanDataTy.ztykeiyakunendo.asc(), qZT_SyuHukugouSikkanDataTy.ztyhknnendo.asc(), qZT_SyuHukugouSikkanDataTy.ztyhhknseikbn.asc(), qZT_SyuHukugouSikkanDataTy.ztykykage.asc(), qZT_SyuHukugouSikkanDataTy.ztytoutatunenrei.asc(), qZT_SyuHukugouSikkanDataTy.ztyatukaibetu.asc(), qZT_SyuHukugouSikkanDataTy.ztysinsahouhou.asc(), qZT_SyuHukugouSikkanDataTy.ztyketteikekkakbn.asc(), qZT_SyuHukugouSikkanDataTy.ztysibousrank.asc(), qZT_SyuHukugouSikkanDataTy.ztyjissituhosyousrank.asc(), qZT_SyuHukugouSikkanDataTy.ztysirajikykkbn.asc(), qZT_SyuHukugouSikkanDataTy.ztyhrkhuhukbn.asc(), qZT_SyuHukugouSikkanDataTy.ztyhknsyurui2keta.asc(), qZT_SyuHukugouSikkanDataTy.ztydaisiincd.asc(), qZT_SyuHukugouSikkanDataTy.ztytyuusiincd.asc(), qZT_SyuHukugouSikkanDataTy.ztysyousiincd.asc(), qZT_SyuHukugouSikkanDataTy.ztynenreihousikikbn.asc(), qZT_SyuHukugouSikkanDataTy.ztysykgycd.asc(), qZT_SyuHukugouSikkanDataTy.ztytodouhukencd.asc(), qZT_SyuHukugouSikkanDataTy.ztybotaisisyaeigyouhonbu.asc(), qZT_SyuHukugouSikkanDataTy.ztysisyaeigyoubu.asc(), qZT_SyuHukugouSikkanDataTy.ztyaatukaisosikicd.asc(), qZT_SyuHukugouSikkanDataTy.ztynensyuukbn.asc(), qZT_SyuHukugouSikkanDataTy.ztyhanbaikeirokbn.asc(), qZT_SyuHukugouSikkanDataTy.ztyoyadairitencd.asc(), qZT_SyuHukugouSikkanDataTy.ztytratkidrtencd.asc(), qZT_SyuHukugouSikkanDataTy.ztybsudirtnatkikeitaikbn.asc(), qZT_SyuHukugouSikkanDataTy.ztykyktuuka.asc(), qZT_SyuHukugouSikkanDataTy.ztyhrktuuka.asc(), qZT_SyuHukugouSikkanDataTy.ztyhknsyukigou.asc(), qZT_SyuHukugouSikkanDataTy.ztysyksbyensitihsyutyhkumu.asc(), qZT_SyuHukugouSikkanDataTy.ztyjyudkaigomehrtkhkumu.asc(), qZT_SyuHukugouSikkanDataTy.ztyijitoukeizennoukbn.asc(), qZT_SyuHukugouSikkanDataTy.ztydai1hknkkn.asc(), qZT_SyuHukugouSikkanDataTy.ztyijitoukeitikshrtkykkbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SyuHukugouSikkanDataTy).getResults();
    }
}

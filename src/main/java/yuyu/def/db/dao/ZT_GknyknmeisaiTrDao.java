package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_GknyknmeisaiTr;
import yuyu.def.db.meta.QZT_GknyknmeisaiTr;

/**
 * 外貨入出金明細テーブル（取）(ZT_GknyknmeisaiTrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_GknyknmeisaiTrDao extends AbstractDao<ZT_GknyknmeisaiTr> {

    public ZT_GknyknmeisaiTrDao() {
        super(ZT_GknyknmeisaiTr.class);
    }

    public ZT_GknyknmeisaiTr getGknyknmeisaiTr(String pZtrsakuseiymd, String pZtrrenrakuymd, String pZtrrenrakukaisuu, String pZtrbankcd, String pZtrshitencd, String pZtryokinkbn, String pZtrkouzano, String pZtrzndktuukasyu, String pZtrsyorino1) {
        ZT_GknyknmeisaiTr zT_GknyknmeisaiTr =  new ZT_GknyknmeisaiTr();
        zT_GknyknmeisaiTr.setZtrsakuseiymd(pZtrsakuseiymd);
        zT_GknyknmeisaiTr.setZtrrenrakuymd(pZtrrenrakuymd);
        zT_GknyknmeisaiTr.setZtrrenrakukaisuu(pZtrrenrakukaisuu);
        zT_GknyknmeisaiTr.setZtrbankcd(pZtrbankcd);
        zT_GknyknmeisaiTr.setZtrshitencd(pZtrshitencd);
        zT_GknyknmeisaiTr.setZtryokinkbn(pZtryokinkbn);
        zT_GknyknmeisaiTr.setZtrkouzano(pZtrkouzano);
        zT_GknyknmeisaiTr.setZtrzndktuukasyu(pZtrzndktuukasyu);
        zT_GknyknmeisaiTr.setZtrsyorino1(pZtrsyorino1);
        return this.selectOne(zT_GknyknmeisaiTr);
    }

    public ExDBResults<ZT_GknyknmeisaiTr> selectAllZT_GknyknmeisaiTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_GknyknmeisaiTr qZT_GknyknmeisaiTr =  new QZT_GknyknmeisaiTr();
        jpql.append($SELECT);
        jpql.append(qZT_GknyknmeisaiTr);
        jpql.append($FROM);
        jpql.append(qZT_GknyknmeisaiTr.ZT_GknyknmeisaiTr());
        jpql.append($ORDER_BY(qZT_GknyknmeisaiTr.ztrsakuseiymd.asc(), qZT_GknyknmeisaiTr.ztrrenrakuymd.asc(), qZT_GknyknmeisaiTr.ztrrenrakukaisuu.asc(), qZT_GknyknmeisaiTr.ztrbankcd.asc(), qZT_GknyknmeisaiTr.ztrshitencd.asc(), qZT_GknyknmeisaiTr.ztryokinkbn.asc(), qZT_GknyknmeisaiTr.ztrkouzano.asc(), qZT_GknyknmeisaiTr.ztrzndktuukasyu.asc(), qZT_GknyknmeisaiTr.ztrsyorino1.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_GknyknmeisaiTr).getResults();
    }

    public ExDBResults<ZT_GknyknmeisaiTr> getGknyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd(String pZtrsakuseiymd) {


        QZT_GknyknmeisaiTr qZT_GknyknmeisaiTr = new QZT_GknyknmeisaiTr();


        String strSql = $SELECT + qZT_GknyknmeisaiTr +
            $FROM + qZT_GknyknmeisaiTr.ZT_GknyknmeisaiTr() +
            $WHERE + qZT_GknyknmeisaiTr.ztrsakuseiymd.eq(pZtrsakuseiymd);


        return em.createJPQL(strSql).bind(qZT_GknyknmeisaiTr).getResults();

    }
}

package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_OnlineGknyknmeisaiTr;
import yuyu.def.db.meta.QZT_OnlineGknyknmeisaiTr;

/**
 * オンライン外貨入出金明細テーブル（取）(ZT_OnlineGknyknmeisaiTr) アクセス用の DAO クラスです。<br />
 */
public class ZT_OnlineGknyknmeisaiTrDao extends AbstractDao<ZT_OnlineGknyknmeisaiTr> {

    public ZT_OnlineGknyknmeisaiTrDao() {
        super(ZT_OnlineGknyknmeisaiTr.class);
    }

    public ZT_OnlineGknyknmeisaiTr getOnlineGknyknmeisaiTr(String pZtrsakuseiymd, String pZtrrenrakuymd, String pZtrrenrakukaisuu, String pZtrbankcd, String pZtrshitencd, String pZtryokinkbn, String pZtrkouzano, String pZtrzndktuukasyu, String pZtrsyorino1) {
        ZT_OnlineGknyknmeisaiTr zT_GknyknmeisaiTr =  new ZT_OnlineGknyknmeisaiTr();
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

    public ExDBResults<ZT_OnlineGknyknmeisaiTr> selectAllZT_OnlineGknyknmeisaiTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_OnlineGknyknmeisaiTr qZT_OnlineGknyknmeisaiTr =  new QZT_OnlineGknyknmeisaiTr();
        jpql.append($SELECT);
        jpql.append(qZT_OnlineGknyknmeisaiTr);
        jpql.append($FROM);
        jpql.append(qZT_OnlineGknyknmeisaiTr.ZT_OnlineGknyknmeisaiTr());
        jpql.append($ORDER_BY(qZT_OnlineGknyknmeisaiTr.ztrsakuseiymd.asc(), qZT_OnlineGknyknmeisaiTr.ztrrenrakuymd.asc(), qZT_OnlineGknyknmeisaiTr.ztrrenrakukaisuu.asc(), qZT_OnlineGknyknmeisaiTr.ztrbankcd.asc(), qZT_OnlineGknyknmeisaiTr.ztrshitencd.asc(), qZT_OnlineGknyknmeisaiTr.ztryokinkbn.asc(), qZT_OnlineGknyknmeisaiTr.ztrkouzano.asc(), qZT_OnlineGknyknmeisaiTr.ztrzndktuukasyu.asc(), qZT_OnlineGknyknmeisaiTr.ztrsyorino1.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_OnlineGknyknmeisaiTr).getResults();
    }
}

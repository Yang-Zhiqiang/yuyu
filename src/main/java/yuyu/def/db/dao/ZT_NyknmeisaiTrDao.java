package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NyknmeisaiTr;
import yuyu.def.db.meta.QZT_NyknmeisaiTr;

/**
 * 入出金明細テーブル（取）(ZT_NyknmeisaiTrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NyknmeisaiTrDao extends AbstractDao<ZT_NyknmeisaiTr> {

    public ZT_NyknmeisaiTrDao() {
        super(ZT_NyknmeisaiTr.class);
    }

    public ZT_NyknmeisaiTr getNyknmeisaiTr(String pZtrsakuseiymd6keta, String pZtrbankcd, String pZtrshitencd, String pZtryokinkbn, String pZtrkouzano, String pZtrsyoukaino, String pZtrrenno8) {
        ZT_NyknmeisaiTr zT_NyknmeisaiTr =  new ZT_NyknmeisaiTr();
        zT_NyknmeisaiTr.setZtrsakuseiymd6keta(pZtrsakuseiymd6keta);
        zT_NyknmeisaiTr.setZtrbankcd(pZtrbankcd);
        zT_NyknmeisaiTr.setZtrshitencd(pZtrshitencd);
        zT_NyknmeisaiTr.setZtryokinkbn(pZtryokinkbn);
        zT_NyknmeisaiTr.setZtrkouzano(pZtrkouzano);
        zT_NyknmeisaiTr.setZtrsyoukaino(pZtrsyoukaino);
        zT_NyknmeisaiTr.setZtrrenno8(pZtrrenno8);
        return this.selectOne(zT_NyknmeisaiTr);
    }

    public ExDBResults<ZT_NyknmeisaiTr> selectAllZT_NyknmeisaiTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_NyknmeisaiTr qZT_NyknmeisaiTr =  new QZT_NyknmeisaiTr();
        jpql.append($SELECT);
        jpql.append(qZT_NyknmeisaiTr);
        jpql.append($FROM);
        jpql.append(qZT_NyknmeisaiTr.ZT_NyknmeisaiTr());
        jpql.append($ORDER_BY(qZT_NyknmeisaiTr.ztrsakuseiymd6keta.asc(), qZT_NyknmeisaiTr.ztrbankcd.asc(), qZT_NyknmeisaiTr.ztrshitencd.asc(), qZT_NyknmeisaiTr.ztryokinkbn.asc(), qZT_NyknmeisaiTr.ztrkouzano.asc(), qZT_NyknmeisaiTr.ztrsyoukaino.asc(), qZT_NyknmeisaiTr.ztrrenno8.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NyknmeisaiTr).getResults();
    }

    public ExDBResults<ZT_NyknmeisaiTr> getNyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd6keta(String pZtrsakuseiymd6keta) {


        QZT_NyknmeisaiTr qZT_NyknmeisaiTr =  new QZT_NyknmeisaiTr();


        String  strSql = $SELECT + qZT_NyknmeisaiTr +
            $FROM + qZT_NyknmeisaiTr.ZT_NyknmeisaiTr() +
            $WHERE + qZT_NyknmeisaiTr.ztrsakuseiymd6keta.eq(pZtrsakuseiymd6keta);

        return em.createJPQL(strSql).bind(qZT_NyknmeisaiTr).getResults();
    }
}

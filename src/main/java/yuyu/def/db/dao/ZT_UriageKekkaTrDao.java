package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_UriageKekkaTr;
import yuyu.def.db.meta.QZT_UriageKekkaTr;

/**
 * 売上結果Ｆテーブル（取）(ZT_UriageKekkaTrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_UriageKekkaTrDao extends AbstractDao<ZT_UriageKekkaTr> {

    public ZT_UriageKekkaTrDao() {
        super(ZT_UriageKekkaTr.class);
    }

    public ZT_UriageKekkaTr getUriageKekkaTr(String pZtrsyono, String pZtrcreditkessaiyouno, String pZtruriageymd6keta, String pZtrrecordno, Long pZtrseikyuukngk) {
        ZT_UriageKekkaTr zT_UriageKekkaTr =  new ZT_UriageKekkaTr();
        zT_UriageKekkaTr.setZtrsyono(pZtrsyono);
        zT_UriageKekkaTr.setZtrcreditkessaiyouno(pZtrcreditkessaiyouno);
        zT_UriageKekkaTr.setZtruriageymd6keta(pZtruriageymd6keta);
        zT_UriageKekkaTr.setZtrrecordno(pZtrrecordno);
        zT_UriageKekkaTr.setZtrseikyuukngk(pZtrseikyuukngk);
        return this.selectOne(zT_UriageKekkaTr);
    }

    public ExDBResults<ZT_UriageKekkaTr> selectAllZT_UriageKekkaTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_UriageKekkaTr qZT_UriageKekkaTr =  new QZT_UriageKekkaTr();
        jpql.append($SELECT);
        jpql.append(qZT_UriageKekkaTr);
        jpql.append($FROM);
        jpql.append(qZT_UriageKekkaTr.ZT_UriageKekkaTr());
        jpql.append($ORDER_BY(qZT_UriageKekkaTr.ztrsyono.asc(), qZT_UriageKekkaTr.ztrcreditkessaiyouno.asc(), qZT_UriageKekkaTr.ztruriageymd6keta.asc(), qZT_UriageKekkaTr.ztrrecordno.asc(), qZT_UriageKekkaTr.ztrseikyuukngk.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_UriageKekkaTr).getResults();
    }
}

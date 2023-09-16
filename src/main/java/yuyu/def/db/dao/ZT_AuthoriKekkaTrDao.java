package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_AuthoriKekkaTr;
import yuyu.def.db.meta.QZT_AuthoriKekkaTr;

/**
 * オーソリ結果Ｆテーブル（取）(ZT_AuthoriKekkaTrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_AuthoriKekkaTrDao extends AbstractDao<ZT_AuthoriKekkaTr> {

    public ZT_AuthoriKekkaTrDao() {
        super(ZT_AuthoriKekkaTr.class);
    }

    public ZT_AuthoriKekkaTr getAuthoriKekkaTr(String pZtrrenno7, String pZtrcreditkessaiyouno, String pZtrdatajyusinymd) {
        ZT_AuthoriKekkaTr zT_AuthoriKekkaTr =  new ZT_AuthoriKekkaTr();
        zT_AuthoriKekkaTr.setZtrrenno7(pZtrrenno7);
        zT_AuthoriKekkaTr.setZtrcreditkessaiyouno(pZtrcreditkessaiyouno);
        zT_AuthoriKekkaTr.setZtrdatajyusinymd(pZtrdatajyusinymd);
        return this.selectOne(zT_AuthoriKekkaTr);
    }

    public ExDBResults<ZT_AuthoriKekkaTr> selectAllZT_AuthoriKekkaTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_AuthoriKekkaTr qZT_AuthoriKekkaTr =  new QZT_AuthoriKekkaTr();
        jpql.append($SELECT);
        jpql.append(qZT_AuthoriKekkaTr);
        jpql.append($FROM);
        jpql.append(qZT_AuthoriKekkaTr.ZT_AuthoriKekkaTr());
        jpql.append($ORDER_BY(qZT_AuthoriKekkaTr.ztrrenno7.asc(), qZT_AuthoriKekkaTr.ztrcreditkessaiyouno.asc(), qZT_AuthoriKekkaTr.ztrdatajyusinymd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_AuthoriKekkaTr).getResults();
    }
}

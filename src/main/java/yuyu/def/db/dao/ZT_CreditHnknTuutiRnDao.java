package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_CreditHnknTuutiRn;
import yuyu.def.db.meta.QZT_CreditHnknTuutiRn;

/**
 * クレカ返金通知テーブル（連）(ZT_CreditHnknTuutiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_CreditHnknTuutiRnDao extends AbstractDao<ZT_CreditHnknTuutiRn> {

    public ZT_CreditHnknTuutiRnDao() {
        super(ZT_CreditHnknTuutiRn.class);
    }

    public ZT_CreditHnknTuutiRn getCreditHnknTuutiRn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsikibetuno) {
        ZT_CreditHnknTuutiRn zT_CreditHnknTuutiRn =  new ZT_CreditHnknTuutiRn();
        zT_CreditHnknTuutiRn.setZrnsyono(pZrnsyono);
        zT_CreditHnknTuutiRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_CreditHnknTuutiRn.setZrnsikibetuno(pZrnsikibetuno);
        return this.selectOne(zT_CreditHnknTuutiRn);
    }

    public ExDBResults<ZT_CreditHnknTuutiRn> selectAllZT_CreditHnknTuutiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_CreditHnknTuutiRn qZT_CreditHnknTuutiRn =  new QZT_CreditHnknTuutiRn();
        jpql.append($SELECT);
        jpql.append(qZT_CreditHnknTuutiRn);
        jpql.append($FROM);
        jpql.append(qZT_CreditHnknTuutiRn.ZT_CreditHnknTuutiRn());
        jpql.append($ORDER_BY(qZT_CreditHnknTuutiRn.zrnsyono.asc(), qZT_CreditHnknTuutiRn.zrntyouhyouymd.asc(), qZT_CreditHnknTuutiRn.zrnsikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_CreditHnknTuutiRn).getResults();
    }
}

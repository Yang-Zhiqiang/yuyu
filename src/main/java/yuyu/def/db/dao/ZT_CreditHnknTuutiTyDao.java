package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_CreditHnknTuutiTy;
import yuyu.def.db.meta.QZT_CreditHnknTuutiTy;

/**
 * クレカ返金通知テーブル（中）(ZT_CreditHnknTuutiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_CreditHnknTuutiTyDao extends AbstractDao<ZT_CreditHnknTuutiTy> {

    public ZT_CreditHnknTuutiTyDao() {
        super(ZT_CreditHnknTuutiTy.class);
    }

    public ZT_CreditHnknTuutiTy getCreditHnknTuutiTy(String pZtysyono, String pZtytyouhyouymd, String pZtysikibetuno) {
        ZT_CreditHnknTuutiTy zT_CreditHnknTuutiTy =  new ZT_CreditHnknTuutiTy();
        zT_CreditHnknTuutiTy.setZtysyono(pZtysyono);
        zT_CreditHnknTuutiTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_CreditHnknTuutiTy.setZtysikibetuno(pZtysikibetuno);
        return this.selectOne(zT_CreditHnknTuutiTy);
    }

    public ExDBResults<ZT_CreditHnknTuutiTy> selectAllZT_CreditHnknTuutiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_CreditHnknTuutiTy qZT_CreditHnknTuutiTy =  new QZT_CreditHnknTuutiTy();
        jpql.append($SELECT);
        jpql.append(qZT_CreditHnknTuutiTy);
        jpql.append($FROM);
        jpql.append(qZT_CreditHnknTuutiTy.ZT_CreditHnknTuutiTy());
        jpql.append($ORDER_BY(qZT_CreditHnknTuutiTy.ztysyono.asc(), qZT_CreditHnknTuutiTy.ztytyouhyouymd.asc(), qZT_CreditHnknTuutiTy.ztysikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_CreditHnknTuutiTy).getResults();
    }
}

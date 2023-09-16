package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkHitKsnTy;
import yuyu.def.db.meta.QZT_NkHitKsnTy;

/**
 * 年金配当所要額Ｆ決算報告用テーブル（中）(ZT_NkHitKsnTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkHitKsnTyDao extends AbstractDao<ZT_NkHitKsnTy> {

    public ZT_NkHitKsnTyDao() {
        super(ZT_NkHitKsnTy.class);
    }

    public ZT_NkHitKsnTy getNkHitKsnTy(String pZtynksyousyono) {
        ZT_NkHitKsnTy zT_NkHitKsnTy =  new ZT_NkHitKsnTy();
        zT_NkHitKsnTy.setZtynksyousyono(pZtynksyousyono);
        return this.selectOne(zT_NkHitKsnTy);
    }

    public ExDBResults<ZT_NkHitKsnTy> selectAllZT_NkHitKsnTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkHitKsnTy qZT_NkHitKsnTy =  new QZT_NkHitKsnTy();
        jpql.append($SELECT);
        jpql.append(qZT_NkHitKsnTy);
        jpql.append($FROM);
        jpql.append(qZT_NkHitKsnTy.ZT_NkHitKsnTy());
        jpql.append($ORDER_BY(qZT_NkHitKsnTy.ztynksyousyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkHitKsnTy).getResults();
    }
}

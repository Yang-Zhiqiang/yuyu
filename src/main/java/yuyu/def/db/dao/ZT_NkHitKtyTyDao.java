package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkHitKtyTy;
import yuyu.def.db.meta.QZT_NkHitKtyTy;

/**
 * 年金配当所要額Ｆ期中報告用テーブル（中）(ZT_NkHitKtyTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkHitKtyTyDao extends AbstractDao<ZT_NkHitKtyTy> {

    public ZT_NkHitKtyTyDao() {
        super(ZT_NkHitKtyTy.class);
    }

    public ZT_NkHitKtyTy getNkHitKtyTy(String pZtynksyousyono) {
        ZT_NkHitKtyTy zT_NkHitKtyTy =  new ZT_NkHitKtyTy();
        zT_NkHitKtyTy.setZtynksyousyono(pZtynksyousyono);
        return this.selectOne(zT_NkHitKtyTy);
    }

    public ExDBResults<ZT_NkHitKtyTy> selectAllZT_NkHitKtyTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkHitKtyTy qZT_NkHitKtyTy =  new QZT_NkHitKtyTy();
        jpql.append($SELECT);
        jpql.append(qZT_NkHitKtyTy);
        jpql.append($FROM);
        jpql.append(qZT_NkHitKtyTy.ZT_NkHitKtyTy());
        jpql.append($ORDER_BY(qZT_NkHitKtyTy.ztynksyousyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkHitKtyTy).getResults();
    }
}

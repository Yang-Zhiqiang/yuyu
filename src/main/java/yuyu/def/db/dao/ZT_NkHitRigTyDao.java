package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkHitRigTy;
import yuyu.def.db.meta.QZT_NkHitRigTy;

/**
 * 年金配当所要額Ｆ例月報告用テーブル（中）(ZT_NkHitRigTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkHitRigTyDao extends AbstractDao<ZT_NkHitRigTy> {

    public ZT_NkHitRigTyDao() {
        super(ZT_NkHitRigTy.class);
    }

    public ZT_NkHitRigTy getNkHitRigTy(String pZtynksyousyono) {
        ZT_NkHitRigTy zT_NkHitRigTy =  new ZT_NkHitRigTy();
        zT_NkHitRigTy.setZtynksyousyono(pZtynksyousyono);
        return this.selectOne(zT_NkHitRigTy);
    }

    public ExDBResults<ZT_NkHitRigTy> selectAllZT_NkHitRigTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkHitRigTy qZT_NkHitRigTy =  new QZT_NkHitRigTy();
        jpql.append($SELECT);
        jpql.append(qZT_NkHitRigTy);
        jpql.append($FROM);
        jpql.append(qZT_NkHitRigTy.ZT_NkHitRigTy());
        jpql.append($ORDER_BY(qZT_NkHitRigTy.ztynksyousyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkHitRigTy).getResults();
    }
}

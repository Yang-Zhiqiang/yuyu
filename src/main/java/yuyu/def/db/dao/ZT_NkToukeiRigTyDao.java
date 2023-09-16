package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkToukeiRigTy;
import yuyu.def.db.meta.QZT_NkToukeiRigTy;

/**
 * 年金統計Ｆ例月用テーブル（中）(ZT_NkToukeiRigTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkToukeiRigTyDao extends AbstractDao<ZT_NkToukeiRigTy> {

    public ZT_NkToukeiRigTyDao() {
        super(ZT_NkToukeiRigTy.class);
    }

    public ZT_NkToukeiRigTy getNkToukeiRigTy(Integer pZtysequenceno) {
        ZT_NkToukeiRigTy zT_NkToukeiRigTy =  new ZT_NkToukeiRigTy();
        zT_NkToukeiRigTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_NkToukeiRigTy);
    }

    public ExDBResults<ZT_NkToukeiRigTy> selectAllZT_NkToukeiRigTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkToukeiRigTy qZT_NkToukeiRigTy =  new QZT_NkToukeiRigTy();
        jpql.append($SELECT);
        jpql.append(qZT_NkToukeiRigTy);
        jpql.append($FROM);
        jpql.append(qZT_NkToukeiRigTy.ZT_NkToukeiRigTy());
        jpql.append($ORDER_BY(qZT_NkToukeiRigTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkToukeiRigTy).getResults();
    }
}

package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkToukeiHySgTy;
import yuyu.def.db.meta.QZT_NkToukeiHySgTy;

/**
 * 年金統計Ｆ保有照合用テーブル（中）(ZT_NkToukeiHySgTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkToukeiHySgTyDao extends AbstractDao<ZT_NkToukeiHySgTy> {

    public ZT_NkToukeiHySgTyDao() {
        super(ZT_NkToukeiHySgTy.class);
    }

    public ZT_NkToukeiHySgTy getNkToukeiHySgTy(Integer pZtysequenceno) {
        ZT_NkToukeiHySgTy zT_NkToukeiHySgTy =  new ZT_NkToukeiHySgTy();
        zT_NkToukeiHySgTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_NkToukeiHySgTy);
    }

    public ExDBResults<ZT_NkToukeiHySgTy> selectAllZT_NkToukeiHySgTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkToukeiHySgTy qZT_NkToukeiHySgTy =  new QZT_NkToukeiHySgTy();
        jpql.append($SELECT);
        jpql.append(qZT_NkToukeiHySgTy);
        jpql.append($FROM);
        jpql.append(qZT_NkToukeiHySgTy.ZT_NkToukeiHySgTy());
        jpql.append($ORDER_BY(qZT_NkToukeiHySgTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkToukeiHySgTy).getResults();
    }
}

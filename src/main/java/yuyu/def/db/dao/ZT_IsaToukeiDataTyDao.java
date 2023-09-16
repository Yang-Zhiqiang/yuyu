package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_IsaToukeiDataTy;
import yuyu.def.db.meta.QZT_IsaToukeiDataTy;

/**
 * 医査統計データテーブル（中）(ZT_IsaToukeiDataTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_IsaToukeiDataTyDao extends AbstractDao<ZT_IsaToukeiDataTy> {

    public ZT_IsaToukeiDataTyDao() {
        super(ZT_IsaToukeiDataTy.class);
    }

    public ZT_IsaToukeiDataTy getIsaToukeiDataTy(String pZtymosno) {
        ZT_IsaToukeiDataTy zT_IsaToukeiDataTy =  new ZT_IsaToukeiDataTy();
        zT_IsaToukeiDataTy.setZtymosno(pZtymosno);
        return this.selectOne(zT_IsaToukeiDataTy);
    }

    public ExDBResults<ZT_IsaToukeiDataTy> selectAllZT_IsaToukeiDataTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_IsaToukeiDataTy qZT_IsaToukeiDataTy =  new QZT_IsaToukeiDataTy();
        jpql.append($SELECT);
        jpql.append(qZT_IsaToukeiDataTy);
        jpql.append($FROM);
        jpql.append(qZT_IsaToukeiDataTy.ZT_IsaToukeiDataTy());
        jpql.append($ORDER_BY(qZT_IsaToukeiDataTy.ztymosno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_IsaToukeiDataTy).getResults();
    }
}

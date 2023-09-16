package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RayIdouVTy;
import yuyu.def.db.meta.QZT_RayIdouVTy;

/**
 * ＲＡＹ異動ＶＦテーブル（中）(ZT_RayIdouVTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RayIdouVTyDao extends AbstractDao<ZT_RayIdouVTy> {

    public ZT_RayIdouVTyDao() {
        super(ZT_RayIdouVTy.class);
    }

    public ZT_RayIdouVTy getRayIdouVTy(Integer pZtysequenceno) {
        ZT_RayIdouVTy zT_RayIdouVTy =  new ZT_RayIdouVTy();
        zT_RayIdouVTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_RayIdouVTy);
    }

    public ExDBResults<ZT_RayIdouVTy> selectAllZT_RayIdouVTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_RayIdouVTy qZT_RayIdouVTy =  new QZT_RayIdouVTy();
        jpql.append($SELECT);
        jpql.append(qZT_RayIdouVTy);
        jpql.append($FROM);
        jpql.append(qZT_RayIdouVTy.ZT_RayIdouVTy());
        jpql.append($ORDER_BY(qZT_RayIdouVTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RayIdouVTy).getResults();
    }
}

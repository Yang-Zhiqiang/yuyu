package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RayKimatuVTy;
import yuyu.def.db.meta.QZT_RayKimatuVTy;

/**
 * ＲＡＹ期末ＶＦテーブル（中）(ZT_RayKimatuVTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RayKimatuVTyDao extends AbstractDao<ZT_RayKimatuVTy> {

    public ZT_RayKimatuVTyDao() {
        super(ZT_RayKimatuVTy.class);
    }

    public ZT_RayKimatuVTy getRayKimatuVTy(Integer pZtysequenceno) {
        ZT_RayKimatuVTy zT_RayKimatuVTy =  new ZT_RayKimatuVTy();
        zT_RayKimatuVTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_RayKimatuVTy);
    }

    public ExDBResults<ZT_RayKimatuVTy> selectAllZT_RayKimatuVTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_RayKimatuVTy qZT_RayKimatuVTy =  new QZT_RayKimatuVTy();
        jpql.append($SELECT);
        jpql.append(qZT_RayKimatuVTy);
        jpql.append($FROM);
        jpql.append(qZT_RayKimatuVTy.ZT_RayKimatuVTy());
        jpql.append($ORDER_BY(qZT_RayKimatuVTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RayKimatuVTy).getResults();
    }
}

package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RayJigyohiTy;
import yuyu.def.db.meta.QZT_RayJigyohiTy;

/**
 * ＲＡＹ事業費Ｆテーブル（中）(ZT_RayJigyohiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RayJigyohiTyDao extends AbstractDao<ZT_RayJigyohiTy> {

    public ZT_RayJigyohiTyDao() {
        super(ZT_RayJigyohiTy.class);
    }

    public ZT_RayJigyohiTy getRayJigyohiTy(Integer pZtysequenceno) {
        ZT_RayJigyohiTy zT_RayJigyohiTy =  new ZT_RayJigyohiTy();
        zT_RayJigyohiTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_RayJigyohiTy);
    }

    public ExDBResults<ZT_RayJigyohiTy> selectAllZT_RayJigyohiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_RayJigyohiTy qZT_RayJigyohiTy =  new QZT_RayJigyohiTy();
        jpql.append($SELECT);
        jpql.append(qZT_RayJigyohiTy);
        jpql.append($FROM);
        jpql.append(qZT_RayJigyohiTy.ZT_RayJigyohiTy());
        jpql.append($ORDER_BY(qZT_RayJigyohiTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RayJigyohiTy).getResults();
    }
}

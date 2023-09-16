package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KsnRayJigyohiTy;
import yuyu.def.db.meta.QZT_KsnRayJigyohiTy;

/**
 * 決算計上用ＲＡＹ事業費Ｆテーブル（中）(ZT_KsnRayJigyohiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KsnRayJigyohiTyDao extends AbstractDao<ZT_KsnRayJigyohiTy> {

    public ZT_KsnRayJigyohiTyDao() {
        super(ZT_KsnRayJigyohiTy.class);
    }

    public ZT_KsnRayJigyohiTy getKsnRayJigyohiTy(Integer pZtysequenceno) {
        ZT_KsnRayJigyohiTy zT_KsnRayJigyohiTy =  new ZT_KsnRayJigyohiTy();
        zT_KsnRayJigyohiTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_KsnRayJigyohiTy);
    }

    public ExDBResults<ZT_KsnRayJigyohiTy> selectAllZT_KsnRayJigyohiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KsnRayJigyohiTy qZT_KsnRayJigyohiTy =  new QZT_KsnRayJigyohiTy();
        jpql.append($SELECT);
        jpql.append(qZT_KsnRayJigyohiTy);
        jpql.append($FROM);
        jpql.append(qZT_KsnRayJigyohiTy.ZT_KsnRayJigyohiTy());
        jpql.append($ORDER_BY(qZT_KsnRayJigyohiTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KsnRayJigyohiTy).getResults();
    }
}

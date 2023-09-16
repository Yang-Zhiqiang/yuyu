package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RayVKnsyuyuTy;
import yuyu.def.db.meta.QZT_RayVKnsyuyuTy;

/**
 * ＲＡＹＶ検証用Ｆテーブル（中）(ZT_RayVKnsyuyuTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RayVKnsyuyuTyDao extends AbstractDao<ZT_RayVKnsyuyuTy> {

    public ZT_RayVKnsyuyuTyDao() {
        super(ZT_RayVKnsyuyuTy.class);
    }

    public ZT_RayVKnsyuyuTy getRayVKnsyuyuTy(Integer pZtysequenceno) {
        ZT_RayVKnsyuyuTy zT_RayVKnsyuyuTy =  new ZT_RayVKnsyuyuTy();
        zT_RayVKnsyuyuTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_RayVKnsyuyuTy);
    }

    public ExDBResults<ZT_RayVKnsyuyuTy> selectAllZT_RayVKnsyuyuTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_RayVKnsyuyuTy qZT_RayVKnsyuyuTy =  new QZT_RayVKnsyuyuTy();
        jpql.append($SELECT);
        jpql.append(qZT_RayVKnsyuyuTy);
        jpql.append($FROM);
        jpql.append(qZT_RayVKnsyuyuTy.ZT_RayVKnsyuyuTy());
        jpql.append($ORDER_BY(qZT_RayVKnsyuyuTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RayVKnsyuyuTy).getResults();
    }
}

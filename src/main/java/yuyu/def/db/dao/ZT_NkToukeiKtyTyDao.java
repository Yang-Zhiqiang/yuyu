package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkToukeiKtyTy;
import yuyu.def.db.meta.QZT_NkToukeiKtyTy;

/**
 * 年金統計Ｆ期中報告用テーブル（中）(ZT_NkToukeiKtyTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkToukeiKtyTyDao extends AbstractDao<ZT_NkToukeiKtyTy> {

    public ZT_NkToukeiKtyTyDao() {
        super(ZT_NkToukeiKtyTy.class);
    }

    public ZT_NkToukeiKtyTy getNkToukeiKtyTy(Integer pZtysequenceno) {
        ZT_NkToukeiKtyTy zT_NkToukeiKtyTy =  new ZT_NkToukeiKtyTy();
        zT_NkToukeiKtyTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_NkToukeiKtyTy);
    }

    public ExDBResults<ZT_NkToukeiKtyTy> selectAllZT_NkToukeiKtyTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkToukeiKtyTy qZT_NkToukeiKtyTy =  new QZT_NkToukeiKtyTy();
        jpql.append($SELECT);
        jpql.append(qZT_NkToukeiKtyTy);
        jpql.append($FROM);
        jpql.append(qZT_NkToukeiKtyTy.ZT_NkToukeiKtyTy());
        jpql.append($ORDER_BY(qZT_NkToukeiKtyTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkToukeiKtyTy).getResults();
    }
}

package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DshrToukeiLoadingTy;
import yuyu.def.db.meta.QZT_DshrToukeiLoadingTy;

/**
 * Ｄ支払統計ローディングＦテーブル（中）(ZT_DshrToukeiLoadingTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DshrToukeiLoadingTyDao extends AbstractDao<ZT_DshrToukeiLoadingTy> {

    public ZT_DshrToukeiLoadingTyDao() {
        super(ZT_DshrToukeiLoadingTy.class);
    }

    public ZT_DshrToukeiLoadingTy getDshrToukeiLoadingTy(Integer pZtysequenceno) {
        ZT_DshrToukeiLoadingTy zT_DshrToukeiLoadingTy =  new ZT_DshrToukeiLoadingTy();
        zT_DshrToukeiLoadingTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_DshrToukeiLoadingTy);
    }

    public ExDBResults<ZT_DshrToukeiLoadingTy> selectAllZT_DshrToukeiLoadingTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_DshrToukeiLoadingTy qZT_DshrToukeiLoadingTy =  new QZT_DshrToukeiLoadingTy();
        jpql.append($SELECT);
        jpql.append(qZT_DshrToukeiLoadingTy);
        jpql.append($FROM);
        jpql.append(qZT_DshrToukeiLoadingTy.ZT_DshrToukeiLoadingTy());
        jpql.append($ORDER_BY(qZT_DshrToukeiLoadingTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DshrToukeiLoadingTy).getResults();
    }
}

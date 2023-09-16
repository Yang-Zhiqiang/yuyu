package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DshrToukeiTy;
import yuyu.def.db.meta.QZT_DshrToukeiTy;

/**
 * Ｄ支払統計Ｆテーブル（中）(ZT_DshrToukeiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DshrToukeiTyDao extends AbstractDao<ZT_DshrToukeiTy> {

    public ZT_DshrToukeiTyDao() {
        super(ZT_DshrToukeiTy.class);
    }

    public ZT_DshrToukeiTy getDshrToukeiTy(Integer pZtysequenceno) {
        ZT_DshrToukeiTy zT_DshrToukeiTy =  new ZT_DshrToukeiTy();
        zT_DshrToukeiTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_DshrToukeiTy);
    }

    public ExDBResults<ZT_DshrToukeiTy> selectAllZT_DshrToukeiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_DshrToukeiTy qZT_DshrToukeiTy =  new QZT_DshrToukeiTy();
        jpql.append($SELECT);
        jpql.append(qZT_DshrToukeiTy);
        jpql.append($FROM);
        jpql.append(qZT_DshrToukeiTy.ZT_DshrToukeiTy());
        jpql.append($ORDER_BY(qZT_DshrToukeiTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DshrToukeiTy).getResults();
    }
}

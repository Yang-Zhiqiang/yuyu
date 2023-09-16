package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkeisynyptoukeirigTy;
import yuyu.def.db.meta.QZT_SkeisynyptoukeirigTy;

/**
 * 新契約収入Ｐ統計例月Ｆテーブル（中）(ZT_SkeisynyptoukeirigTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkeisynyptoukeirigTyDao extends AbstractDao<ZT_SkeisynyptoukeirigTy> {

    public ZT_SkeisynyptoukeirigTyDao() {
        super(ZT_SkeisynyptoukeirigTy.class);
    }

    public ZT_SkeisynyptoukeirigTy getSkeisynyptoukeirigTy(Integer pZtysequenceno) {
        ZT_SkeisynyptoukeirigTy zT_SkeisynyptoukeirigTy =  new ZT_SkeisynyptoukeirigTy();
        zT_SkeisynyptoukeirigTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_SkeisynyptoukeirigTy);
    }

    public ExDBResults<ZT_SkeisynyptoukeirigTy> selectAllZT_SkeisynyptoukeirigTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkeisynyptoukeirigTy qZT_SkeisynyptoukeirigTy =  new QZT_SkeisynyptoukeirigTy();
        jpql.append($SELECT);
        jpql.append(qZT_SkeisynyptoukeirigTy);
        jpql.append($FROM);
        jpql.append(qZT_SkeisynyptoukeirigTy.ZT_SkeisynyptoukeirigTy());
        jpql.append($ORDER_BY(qZT_SkeisynyptoukeirigTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkeisynyptoukeirigTy).getResults();
    }
}

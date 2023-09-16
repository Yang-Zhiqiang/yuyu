package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_OuNnknShrTy;
import yuyu.def.db.meta.QZT_OuNnknShrTy;

/**
 * ＯＵ用年金支払テーブル（中）(ZT_OuNnknShrTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_OuNnknShrTyDao extends AbstractDao<ZT_OuNnknShrTy> {

    public ZT_OuNnknShrTyDao() {
        super(ZT_OuNnknShrTy.class);
    }

    public ZT_OuNnknShrTy getOuNnknShrTy(Integer pZtysequenceno) {
        ZT_OuNnknShrTy zT_OuNnknShrTy =  new ZT_OuNnknShrTy();
        zT_OuNnknShrTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_OuNnknShrTy);
    }

    public ExDBResults<ZT_OuNnknShrTy> selectAllZT_OuNnknShrTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_OuNnknShrTy qZT_OuNnknShrTy =  new QZT_OuNnknShrTy();
        jpql.append($SELECT);
        jpql.append(qZT_OuNnknShrTy);
        jpql.append($FROM);
        jpql.append(qZT_OuNnknShrTy.ZT_OuNnknShrTy());
        jpql.append($ORDER_BY(qZT_OuNnknShrTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_OuNnknShrTy).getResults();
    }
}

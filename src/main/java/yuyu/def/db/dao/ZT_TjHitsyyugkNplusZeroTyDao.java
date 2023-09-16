package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusZeroTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusZeroTy;

/**
 * 通常配当所要額Ｆ（Ｎ＋０）テーブル（中）(ZT_TjHitsyyugkNplusZeroTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TjHitsyyugkNplusZeroTyDao extends AbstractDao<ZT_TjHitsyyugkNplusZeroTy> {

    public ZT_TjHitsyyugkNplusZeroTyDao() {
        super(ZT_TjHitsyyugkNplusZeroTy.class);
    }

    public ZT_TjHitsyyugkNplusZeroTy getTjHitsyyugkNplusZeroTy(Integer pZtysequenceno) {
        ZT_TjHitsyyugkNplusZeroTy zT_TjHitsyyugkNplusZeroTy =  new ZT_TjHitsyyugkNplusZeroTy();
        zT_TjHitsyyugkNplusZeroTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_TjHitsyyugkNplusZeroTy);
    }

    public ExDBResults<ZT_TjHitsyyugkNplusZeroTy> selectAllZT_TjHitsyyugkNplusZeroTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_TjHitsyyugkNplusZeroTy qZT_TjHitsyyugkNplusZeroTy =  new QZT_TjHitsyyugkNplusZeroTy();
        jpql.append($SELECT);
        jpql.append(qZT_TjHitsyyugkNplusZeroTy);
        jpql.append($FROM);
        jpql.append(qZT_TjHitsyyugkNplusZeroTy.ZT_TjHitsyyugkNplusZeroTy());
        jpql.append($ORDER_BY(qZT_TjHitsyyugkNplusZeroTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TjHitsyyugkNplusZeroTy).getResults();
    }
}

package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RisaTjHitNplusZeroTy;
import yuyu.def.db.meta.QZT_RisaTjHitNplusZeroTy;

/**
 * 利差のみ通常配当所要額Ｆ（Ｎ＋０）テーブル（中）(ZT_RisaTjHitNplusZeroTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RisaTjHitNplusZeroTyDao extends AbstractDao<ZT_RisaTjHitNplusZeroTy> {

    public ZT_RisaTjHitNplusZeroTyDao() {
        super(ZT_RisaTjHitNplusZeroTy.class);
    }

    public ZT_RisaTjHitNplusZeroTy getRisaTjHitNplusZeroTy(Integer pZtysequenceno) {
        ZT_RisaTjHitNplusZeroTy zT_RisaTjHitNplusZeroTy =  new ZT_RisaTjHitNplusZeroTy();
        zT_RisaTjHitNplusZeroTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_RisaTjHitNplusZeroTy);
    }

    public ExDBResults<ZT_RisaTjHitNplusZeroTy> selectAllZT_RisaTjHitNplusZeroTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_RisaTjHitNplusZeroTy qZT_RisaTjHitNplusZeroTy =  new QZT_RisaTjHitNplusZeroTy();
        jpql.append($SELECT);
        jpql.append(qZT_RisaTjHitNplusZeroTy);
        jpql.append($FROM);
        jpql.append(qZT_RisaTjHitNplusZeroTy.ZT_RisaTjHitNplusZeroTy());
        jpql.append($ORDER_BY(qZT_RisaTjHitNplusZeroTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RisaTjHitNplusZeroTy).getResults();
    }
}

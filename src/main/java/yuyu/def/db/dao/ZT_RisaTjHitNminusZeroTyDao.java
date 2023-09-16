package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RisaTjHitNminusZeroTy;
import yuyu.def.db.meta.QZT_RisaTjHitNminusZeroTy;

/**
 * 利差のみ通常配当所要額Ｆ（Ｎ－０）テーブル（中）(ZT_RisaTjHitNminusZeroTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RisaTjHitNminusZeroTyDao extends AbstractDao<ZT_RisaTjHitNminusZeroTy> {

    public ZT_RisaTjHitNminusZeroTyDao() {
        super(ZT_RisaTjHitNminusZeroTy.class);
    }

    public ZT_RisaTjHitNminusZeroTy getRisaTjHitNminusZeroTy(Integer pZtysequenceno) {
        ZT_RisaTjHitNminusZeroTy zT_RisaTjHitNminusZeroTy =  new ZT_RisaTjHitNminusZeroTy();
        zT_RisaTjHitNminusZeroTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_RisaTjHitNminusZeroTy);
    }

    public ExDBResults<ZT_RisaTjHitNminusZeroTy> selectAllZT_RisaTjHitNminusZeroTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_RisaTjHitNminusZeroTy qZT_RisaTjHitNminusZeroTy =  new QZT_RisaTjHitNminusZeroTy();
        jpql.append($SELECT);
        jpql.append(qZT_RisaTjHitNminusZeroTy);
        jpql.append($FROM);
        jpql.append(qZT_RisaTjHitNminusZeroTy.ZT_RisaTjHitNminusZeroTy());
        jpql.append($ORDER_BY(qZT_RisaTjHitNminusZeroTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RisaTjHitNminusZeroTy).getResults();
    }
}

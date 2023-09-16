package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RisaTjHitNplusQuartTy;
import yuyu.def.db.meta.QZT_RisaTjHitNplusQuartTy;

/**
 * 利差のみ通常配当所要額Ｆ（Ｎ＋Ｑ）テーブル（中）(ZT_RisaTjHitNplusQuartTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RisaTjHitNplusQuartTyDao extends AbstractDao<ZT_RisaTjHitNplusQuartTy> {

    public ZT_RisaTjHitNplusQuartTyDao() {
        super(ZT_RisaTjHitNplusQuartTy.class);
    }

    public ZT_RisaTjHitNplusQuartTy getRisaTjHitNplusQuartTy(Integer pZtysequenceno) {
        ZT_RisaTjHitNplusQuartTy zT_RisaTjHitNplusQuartTy =  new ZT_RisaTjHitNplusQuartTy();
        zT_RisaTjHitNplusQuartTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_RisaTjHitNplusQuartTy);
    }

    public ExDBResults<ZT_RisaTjHitNplusQuartTy> selectAllZT_RisaTjHitNplusQuartTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_RisaTjHitNplusQuartTy qZT_RisaTjHitNplusQuartTy =  new QZT_RisaTjHitNplusQuartTy();
        jpql.append($SELECT);
        jpql.append(qZT_RisaTjHitNplusQuartTy);
        jpql.append($FROM);
        jpql.append(qZT_RisaTjHitNplusQuartTy.ZT_RisaTjHitNplusQuartTy());
        jpql.append($ORDER_BY(qZT_RisaTjHitNplusQuartTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RisaTjHitNplusQuartTy).getResults();
    }
}

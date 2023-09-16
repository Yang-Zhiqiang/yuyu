package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusQuartTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusQuartTy;

/**
 * 通常配当所要額Ｆ（Ｎ＋Ｑ）テーブル（中）(ZT_TjHitsyyugkNplusQuartTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TjHitsyyugkNplusQuartTyDao extends AbstractDao<ZT_TjHitsyyugkNplusQuartTy> {

    public ZT_TjHitsyyugkNplusQuartTyDao() {
        super(ZT_TjHitsyyugkNplusQuartTy.class);
    }

    public ZT_TjHitsyyugkNplusQuartTy getTjHitsyyugkNplusQuartTy(Integer pZtysequenceno) {
        ZT_TjHitsyyugkNplusQuartTy zT_TjHitsyyugkNplusQuartTy =  new ZT_TjHitsyyugkNplusQuartTy();
        zT_TjHitsyyugkNplusQuartTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_TjHitsyyugkNplusQuartTy);
    }

    public ExDBResults<ZT_TjHitsyyugkNplusQuartTy> selectAllZT_TjHitsyyugkNplusQuartTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_TjHitsyyugkNplusQuartTy qZT_TjHitsyyugkNplusQuartTy =  new QZT_TjHitsyyugkNplusQuartTy();
        jpql.append($SELECT);
        jpql.append(qZT_TjHitsyyugkNplusQuartTy);
        jpql.append($FROM);
        jpql.append(qZT_TjHitsyyugkNplusQuartTy.ZT_TjHitsyyugkNplusQuartTy());
        jpql.append($ORDER_BY(qZT_TjHitsyyugkNplusQuartTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TjHitsyyugkNplusQuartTy).getResults();
    }
}

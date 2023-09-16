package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TjHitsyyugkNminusZeroTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNminusZeroTy;

/**
 * 通常配当所要額Ｆ（Ｎ－０）テーブル（中）(ZT_TjHitsyyugkNminusZeroTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TjHitsyyugkNminusZeroTyDao extends AbstractDao<ZT_TjHitsyyugkNminusZeroTy> {

    public ZT_TjHitsyyugkNminusZeroTyDao() {
        super(ZT_TjHitsyyugkNminusZeroTy.class);
    }

    public ZT_TjHitsyyugkNminusZeroTy getTjHitsyyugkNminusZeroTy(Integer pZtysequenceno) {
        ZT_TjHitsyyugkNminusZeroTy zT_TjHitsyyugkNminusZeroTy =  new ZT_TjHitsyyugkNminusZeroTy();
        zT_TjHitsyyugkNminusZeroTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_TjHitsyyugkNminusZeroTy);
    }

    public ExDBResults<ZT_TjHitsyyugkNminusZeroTy> selectAllZT_TjHitsyyugkNminusZeroTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_TjHitsyyugkNminusZeroTy qZT_TjHitsyyugkNminusZeroTy =  new QZT_TjHitsyyugkNminusZeroTy();
        jpql.append($SELECT);
        jpql.append(qZT_TjHitsyyugkNminusZeroTy);
        jpql.append($FROM);
        jpql.append(qZT_TjHitsyyugkNminusZeroTy.ZT_TjHitsyyugkNminusZeroTy());
        jpql.append($ORDER_BY(qZT_TjHitsyyugkNminusZeroTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TjHitsyyugkNminusZeroTy).getResults();
    }
}

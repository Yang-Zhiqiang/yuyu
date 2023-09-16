package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusOneTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusOneTy;

/**
 * 通常配当所要額Ｆ（Ｎ＋１）テーブル（中）(ZT_TjHitsyyugkNplusOneTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TjHitsyyugkNplusOneTyDao extends AbstractDao<ZT_TjHitsyyugkNplusOneTy> {

    public ZT_TjHitsyyugkNplusOneTyDao() {
        super(ZT_TjHitsyyugkNplusOneTy.class);
    }

    public ZT_TjHitsyyugkNplusOneTy getTjHitsyyugkNplusOneTy(Integer pZtysequenceno) {
        ZT_TjHitsyyugkNplusOneTy zT_TjHitsyyugkNplusOneTy =  new ZT_TjHitsyyugkNplusOneTy();
        zT_TjHitsyyugkNplusOneTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_TjHitsyyugkNplusOneTy);
    }

    public ExDBResults<ZT_TjHitsyyugkNplusOneTy> selectAllZT_TjHitsyyugkNplusOneTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_TjHitsyyugkNplusOneTy qZT_TjHitsyyugkNplusOneTy =  new QZT_TjHitsyyugkNplusOneTy();
        jpql.append($SELECT);
        jpql.append(qZT_TjHitsyyugkNplusOneTy);
        jpql.append($FROM);
        jpql.append(qZT_TjHitsyyugkNplusOneTy.ZT_TjHitsyyugkNplusOneTy());
        jpql.append($ORDER_BY(qZT_TjHitsyyugkNplusOneTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TjHitsyyugkNplusOneTy).getResults();
    }
}

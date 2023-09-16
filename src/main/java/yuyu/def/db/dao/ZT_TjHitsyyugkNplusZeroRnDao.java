package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusZeroRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusZeroRn;

/**
 * 通常配当所要額Ｆ（Ｎ＋０）テーブル（連）(ZT_TjHitsyyugkNplusZeroRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TjHitsyyugkNplusZeroRnDao extends AbstractDao<ZT_TjHitsyyugkNplusZeroRn> {

    public ZT_TjHitsyyugkNplusZeroRnDao() {
        super(ZT_TjHitsyyugkNplusZeroRn.class);
    }

    public ZT_TjHitsyyugkNplusZeroRn getTjHitsyyugkNplusZeroRn(Integer pZrnsequenceno) {
        ZT_TjHitsyyugkNplusZeroRn zT_TjHitsyyugkNplusZeroRn =  new ZT_TjHitsyyugkNplusZeroRn();
        zT_TjHitsyyugkNplusZeroRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_TjHitsyyugkNplusZeroRn);
    }

    public ExDBResults<ZT_TjHitsyyugkNplusZeroRn> selectAllZT_TjHitsyyugkNplusZeroRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_TjHitsyyugkNplusZeroRn qZT_TjHitsyyugkNplusZeroRn =  new QZT_TjHitsyyugkNplusZeroRn();
        jpql.append($SELECT);
        jpql.append(qZT_TjHitsyyugkNplusZeroRn);
        jpql.append($FROM);
        jpql.append(qZT_TjHitsyyugkNplusZeroRn.ZT_TjHitsyyugkNplusZeroRn());
        jpql.append($ORDER_BY(qZT_TjHitsyyugkNplusZeroRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TjHitsyyugkNplusZeroRn).getResults();
    }
}

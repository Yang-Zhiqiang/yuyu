package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TjHitsyyugkNminusZeroRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNminusZeroRn;

/**
 * 通常配当所要額Ｆ（Ｎ－０）テーブル（連）(ZT_TjHitsyyugkNminusZeroRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TjHitsyyugkNminusZeroRnDao extends AbstractDao<ZT_TjHitsyyugkNminusZeroRn> {

    public ZT_TjHitsyyugkNminusZeroRnDao() {
        super(ZT_TjHitsyyugkNminusZeroRn.class);
    }

    public ZT_TjHitsyyugkNminusZeroRn getTjHitsyyugkNminusZeroRn(Integer pZrnsequenceno) {
        ZT_TjHitsyyugkNminusZeroRn zT_TjHitsyyugkNminusZeroRn =  new ZT_TjHitsyyugkNminusZeroRn();
        zT_TjHitsyyugkNminusZeroRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_TjHitsyyugkNminusZeroRn);
    }

    public ExDBResults<ZT_TjHitsyyugkNminusZeroRn> selectAllZT_TjHitsyyugkNminusZeroRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_TjHitsyyugkNminusZeroRn qZT_TjHitsyyugkNminusZeroRn =  new QZT_TjHitsyyugkNminusZeroRn();
        jpql.append($SELECT);
        jpql.append(qZT_TjHitsyyugkNminusZeroRn);
        jpql.append($FROM);
        jpql.append(qZT_TjHitsyyugkNminusZeroRn.ZT_TjHitsyyugkNminusZeroRn());
        jpql.append($ORDER_BY(qZT_TjHitsyyugkNminusZeroRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TjHitsyyugkNminusZeroRn).getResults();
    }
}

package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusQuartRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusQuartRn;

/**
 * 通常配当所要額Ｆ（Ｎ＋Ｑ）テーブル（連）(ZT_TjHitsyyugkNplusQuartRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TjHitsyyugkNplusQuartRnDao extends AbstractDao<ZT_TjHitsyyugkNplusQuartRn> {

    public ZT_TjHitsyyugkNplusQuartRnDao() {
        super(ZT_TjHitsyyugkNplusQuartRn.class);
    }

    public ZT_TjHitsyyugkNplusQuartRn getTjHitsyyugkNplusQuartRn(Integer pZrnsequenceno) {
        ZT_TjHitsyyugkNplusQuartRn zT_TjHitsyyugkNplusQuartRn =  new ZT_TjHitsyyugkNplusQuartRn();
        zT_TjHitsyyugkNplusQuartRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_TjHitsyyugkNplusQuartRn);
    }

    public ExDBResults<ZT_TjHitsyyugkNplusQuartRn> selectAllZT_TjHitsyyugkNplusQuartRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_TjHitsyyugkNplusQuartRn qZT_TjHitsyyugkNplusQuartRn =  new QZT_TjHitsyyugkNplusQuartRn();
        jpql.append($SELECT);
        jpql.append(qZT_TjHitsyyugkNplusQuartRn);
        jpql.append($FROM);
        jpql.append(qZT_TjHitsyyugkNplusQuartRn.ZT_TjHitsyyugkNplusQuartRn());
        jpql.append($ORDER_BY(qZT_TjHitsyyugkNplusQuartRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TjHitsyyugkNplusQuartRn).getResults();
    }
}

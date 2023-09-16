package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusOneRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusOneRn;

/**
 * 通常配当所要額Ｆ（Ｎ＋１）テーブル（連）(ZT_TjHitsyyugkNplusOneRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TjHitsyyugkNplusOneRnDao extends AbstractDao<ZT_TjHitsyyugkNplusOneRn> {

    public ZT_TjHitsyyugkNplusOneRnDao() {
        super(ZT_TjHitsyyugkNplusOneRn.class);
    }

    public ZT_TjHitsyyugkNplusOneRn getTjHitsyyugkNplusOneRn(Integer pZrnsequenceno) {
        ZT_TjHitsyyugkNplusOneRn zT_TjHitsyyugkNplusOneRn =  new ZT_TjHitsyyugkNplusOneRn();
        zT_TjHitsyyugkNplusOneRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_TjHitsyyugkNplusOneRn);
    }

    public ExDBResults<ZT_TjHitsyyugkNplusOneRn> selectAllZT_TjHitsyyugkNplusOneRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_TjHitsyyugkNplusOneRn qZT_TjHitsyyugkNplusOneRn =  new QZT_TjHitsyyugkNplusOneRn();
        jpql.append($SELECT);
        jpql.append(qZT_TjHitsyyugkNplusOneRn);
        jpql.append($FROM);
        jpql.append(qZT_TjHitsyyugkNplusOneRn.ZT_TjHitsyyugkNplusOneRn());
        jpql.append($ORDER_BY(qZT_TjHitsyyugkNplusOneRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TjHitsyyugkNplusOneRn).getResults();
    }
}

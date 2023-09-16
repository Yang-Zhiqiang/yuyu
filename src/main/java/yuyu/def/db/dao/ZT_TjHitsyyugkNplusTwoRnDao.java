package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusTwoRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusTwoRn;

/**
 * 通常配当所要額Ｆ（Ｎ＋２）テーブル（連）(ZT_TjHitsyyugkNplusTwoRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TjHitsyyugkNplusTwoRnDao extends AbstractDao<ZT_TjHitsyyugkNplusTwoRn> {

    public ZT_TjHitsyyugkNplusTwoRnDao() {
        super(ZT_TjHitsyyugkNplusTwoRn.class);
    }

    public ZT_TjHitsyyugkNplusTwoRn getTjHitsyyugkNplusTwoRn(Integer pZrnsequenceno) {
        ZT_TjHitsyyugkNplusTwoRn zT_TjHitsyyugkNplusTwoRn =  new ZT_TjHitsyyugkNplusTwoRn();
        zT_TjHitsyyugkNplusTwoRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_TjHitsyyugkNplusTwoRn);
    }

    public ExDBResults<ZT_TjHitsyyugkNplusTwoRn> selectAllZT_TjHitsyyugkNplusTwoRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_TjHitsyyugkNplusTwoRn qZT_TjHitsyyugkNplusTwoRn =  new QZT_TjHitsyyugkNplusTwoRn();
        jpql.append($SELECT);
        jpql.append(qZT_TjHitsyyugkNplusTwoRn);
        jpql.append($FROM);
        jpql.append(qZT_TjHitsyyugkNplusTwoRn.ZT_TjHitsyyugkNplusTwoRn());
        jpql.append($ORDER_BY(qZT_TjHitsyyugkNplusTwoRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TjHitsyyugkNplusTwoRn).getResults();
    }
}

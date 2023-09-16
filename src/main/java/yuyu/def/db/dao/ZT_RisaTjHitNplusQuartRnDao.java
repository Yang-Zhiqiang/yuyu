package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RisaTjHitNplusQuartRn;
import yuyu.def.db.meta.QZT_RisaTjHitNplusQuartRn;

/**
 * 利差のみ通常配当所要額Ｆ（Ｎ＋Ｑ）テーブル（連）(ZT_RisaTjHitNplusQuartRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RisaTjHitNplusQuartRnDao extends AbstractDao<ZT_RisaTjHitNplusQuartRn> {

    public ZT_RisaTjHitNplusQuartRnDao() {
        super(ZT_RisaTjHitNplusQuartRn.class);
    }

    public ZT_RisaTjHitNplusQuartRn getRisaTjHitNplusQuartRn(Integer pZrnsequenceno) {
        ZT_RisaTjHitNplusQuartRn zT_RisaTjHitNplusQuartRn =  new ZT_RisaTjHitNplusQuartRn();
        zT_RisaTjHitNplusQuartRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_RisaTjHitNplusQuartRn);
    }

    public ExDBResults<ZT_RisaTjHitNplusQuartRn> selectAllZT_RisaTjHitNplusQuartRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_RisaTjHitNplusQuartRn qZT_RisaTjHitNplusQuartRn =  new QZT_RisaTjHitNplusQuartRn();
        jpql.append($SELECT);
        jpql.append(qZT_RisaTjHitNplusQuartRn);
        jpql.append($FROM);
        jpql.append(qZT_RisaTjHitNplusQuartRn.ZT_RisaTjHitNplusQuartRn());
        jpql.append($ORDER_BY(qZT_RisaTjHitNplusQuartRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RisaTjHitNplusQuartRn).getResults();
    }
}

package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RisaTjHitNplusZeroRn;
import yuyu.def.db.meta.QZT_RisaTjHitNplusZeroRn;

/**
 * 利差のみ通常配当所要額Ｆ（Ｎ＋０）テーブル（連）(ZT_RisaTjHitNplusZeroRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RisaTjHitNplusZeroRnDao extends AbstractDao<ZT_RisaTjHitNplusZeroRn> {

    public ZT_RisaTjHitNplusZeroRnDao() {
        super(ZT_RisaTjHitNplusZeroRn.class);
    }

    public ZT_RisaTjHitNplusZeroRn getRisaTjHitNplusZeroRn(Integer pZrnsequenceno) {
        ZT_RisaTjHitNplusZeroRn zT_RisaTjHitNplusZeroRn =  new ZT_RisaTjHitNplusZeroRn();
        zT_RisaTjHitNplusZeroRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_RisaTjHitNplusZeroRn);
    }

    public ExDBResults<ZT_RisaTjHitNplusZeroRn> selectAllZT_RisaTjHitNplusZeroRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_RisaTjHitNplusZeroRn qZT_RisaTjHitNplusZeroRn =  new QZT_RisaTjHitNplusZeroRn();
        jpql.append($SELECT);
        jpql.append(qZT_RisaTjHitNplusZeroRn);
        jpql.append($FROM);
        jpql.append(qZT_RisaTjHitNplusZeroRn.ZT_RisaTjHitNplusZeroRn());
        jpql.append($ORDER_BY(qZT_RisaTjHitNplusZeroRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RisaTjHitNplusZeroRn).getResults();
    }
}

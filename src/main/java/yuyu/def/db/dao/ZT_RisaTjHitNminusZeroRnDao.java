package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RisaTjHitNminusZeroRn;
import yuyu.def.db.meta.QZT_RisaTjHitNminusZeroRn;

/**
 * 利差のみ通常配当所要額Ｆ（Ｎ－０）テーブル（連）(ZT_RisaTjHitNminusZeroRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RisaTjHitNminusZeroRnDao extends AbstractDao<ZT_RisaTjHitNminusZeroRn> {

    public ZT_RisaTjHitNminusZeroRnDao() {
        super(ZT_RisaTjHitNminusZeroRn.class);
    }

    public ZT_RisaTjHitNminusZeroRn getRisaTjHitNminusZeroRn(Integer pZrnsequenceno) {
        ZT_RisaTjHitNminusZeroRn zT_RisaTjHitNminusZeroRn =  new ZT_RisaTjHitNminusZeroRn();
        zT_RisaTjHitNminusZeroRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_RisaTjHitNminusZeroRn);
    }

    public ExDBResults<ZT_RisaTjHitNminusZeroRn> selectAllZT_RisaTjHitNminusZeroRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_RisaTjHitNminusZeroRn qZT_RisaTjHitNminusZeroRn =  new QZT_RisaTjHitNminusZeroRn();
        jpql.append($SELECT);
        jpql.append(qZT_RisaTjHitNminusZeroRn);
        jpql.append($FROM);
        jpql.append(qZT_RisaTjHitNminusZeroRn.ZT_RisaTjHitNminusZeroRn());
        jpql.append($ORDER_BY(qZT_RisaTjHitNminusZeroRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RisaTjHitNminusZeroRn).getResults();
    }
}

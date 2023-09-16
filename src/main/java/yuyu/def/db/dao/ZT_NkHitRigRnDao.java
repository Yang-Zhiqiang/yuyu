package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkHitRigRn;
import yuyu.def.db.meta.QZT_NkHitRigRn;

/**
 * 年金配当所要額Ｆ例月報告用テーブル（連）(ZT_NkHitRigRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkHitRigRnDao extends AbstractDao<ZT_NkHitRigRn> {

    public ZT_NkHitRigRnDao() {
        super(ZT_NkHitRigRn.class);
    }

    public ZT_NkHitRigRn getNkHitRigRn(String pZrnnksyousyono) {
        ZT_NkHitRigRn zT_NkHitRigRn =  new ZT_NkHitRigRn();
        zT_NkHitRigRn.setZrnnksyousyono(pZrnnksyousyono);
        return this.selectOne(zT_NkHitRigRn);
    }

    public ExDBResults<ZT_NkHitRigRn> selectAllZT_NkHitRigRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkHitRigRn qZT_NkHitRigRn =  new QZT_NkHitRigRn();
        jpql.append($SELECT);
        jpql.append(qZT_NkHitRigRn);
        jpql.append($FROM);
        jpql.append(qZT_NkHitRigRn.ZT_NkHitRigRn());
        jpql.append($ORDER_BY(qZT_NkHitRigRn.zrnnksyousyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkHitRigRn).getResults();
    }
}

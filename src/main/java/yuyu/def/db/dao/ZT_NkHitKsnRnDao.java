package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkHitKsnRn;
import yuyu.def.db.meta.QZT_NkHitKsnRn;

/**
 * 年金配当所要額Ｆ決算報告用テーブル（連）(ZT_NkHitKsnRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkHitKsnRnDao extends AbstractDao<ZT_NkHitKsnRn> {

    public ZT_NkHitKsnRnDao() {
        super(ZT_NkHitKsnRn.class);
    }

    public ZT_NkHitKsnRn getNkHitKsnRn(String pZrnnksyousyono) {
        ZT_NkHitKsnRn zT_NkHitKsnRn =  new ZT_NkHitKsnRn();
        zT_NkHitKsnRn.setZrnnksyousyono(pZrnnksyousyono);
        return this.selectOne(zT_NkHitKsnRn);
    }

    public ExDBResults<ZT_NkHitKsnRn> selectAllZT_NkHitKsnRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkHitKsnRn qZT_NkHitKsnRn =  new QZT_NkHitKsnRn();
        jpql.append($SELECT);
        jpql.append(qZT_NkHitKsnRn);
        jpql.append($FROM);
        jpql.append(qZT_NkHitKsnRn.ZT_NkHitKsnRn());
        jpql.append($ORDER_BY(qZT_NkHitKsnRn.zrnnksyousyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkHitKsnRn).getResults();
    }
}

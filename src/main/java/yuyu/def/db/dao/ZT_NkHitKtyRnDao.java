package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkHitKtyRn;
import yuyu.def.db.meta.QZT_NkHitKtyRn;

/**
 * 年金配当所要額Ｆ期中報告用テーブル（連）(ZT_NkHitKtyRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkHitKtyRnDao extends AbstractDao<ZT_NkHitKtyRn> {

    public ZT_NkHitKtyRnDao() {
        super(ZT_NkHitKtyRn.class);
    }

    public ZT_NkHitKtyRn getNkHitKtyRn(String pZrnnksyousyono) {
        ZT_NkHitKtyRn zT_NkHitKtyRn =  new ZT_NkHitKtyRn();
        zT_NkHitKtyRn.setZrnnksyousyono(pZrnnksyousyono);
        return this.selectOne(zT_NkHitKtyRn);
    }

    public ExDBResults<ZT_NkHitKtyRn> selectAllZT_NkHitKtyRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkHitKtyRn qZT_NkHitKtyRn =  new QZT_NkHitKtyRn();
        jpql.append($SELECT);
        jpql.append(qZT_NkHitKtyRn);
        jpql.append($FROM);
        jpql.append(qZT_NkHitKtyRn.ZT_NkHitKtyRn());
        jpql.append($ORDER_BY(qZT_NkHitKtyRn.zrnnksyousyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkHitKtyRn).getResults();
    }
}

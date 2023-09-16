package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkHitAddInfoRn;
import yuyu.def.db.meta.QZT_NkHitAddInfoRn;

/**
 * 年金配当所要額追加情報反映テーブル（連）(ZT_NkHitAddInfoRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkHitAddInfoRnDao extends AbstractDao<ZT_NkHitAddInfoRn> {

    public ZT_NkHitAddInfoRnDao() {
        super(ZT_NkHitAddInfoRn.class);
    }

    public ZT_NkHitAddInfoRn getNkHitAddInfoRn(String pZrnnksyousyono) {
        ZT_NkHitAddInfoRn zT_NkHitAddInfoRn =  new ZT_NkHitAddInfoRn();
        zT_NkHitAddInfoRn.setZrnnksyousyono(pZrnnksyousyono);
        return this.selectOne(zT_NkHitAddInfoRn);
    }

    public ExDBResults<ZT_NkHitAddInfoRn> selectAllZT_NkHitAddInfoRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkHitAddInfoRn qZT_NkHitAddInfoRn =  new QZT_NkHitAddInfoRn();
        jpql.append($SELECT);
        jpql.append(qZT_NkHitAddInfoRn);
        jpql.append($FROM);
        jpql.append(qZT_NkHitAddInfoRn.ZT_NkHitAddInfoRn());
        jpql.append($ORDER_BY(qZT_NkHitAddInfoRn.zrnnksyousyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkHitAddInfoRn).getResults();
    }
}

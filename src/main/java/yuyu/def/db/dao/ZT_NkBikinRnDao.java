package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkBikinRn;
import yuyu.def.db.meta.QZT_NkBikinRn;

/**
 * 年金備金テーブル（連）(ZT_NkBikinRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkBikinRnDao extends AbstractDao<ZT_NkBikinRn> {

    public ZT_NkBikinRnDao() {
        super(ZT_NkBikinRn.class);
    }

    public ZT_NkBikinRn getNkBikinRn(String pZrnnksyousyono, String pZrnshiharaihasseiymd) {
        ZT_NkBikinRn zT_NkBikinRn =  new ZT_NkBikinRn();
        zT_NkBikinRn.setZrnnksyousyono(pZrnnksyousyono);
        zT_NkBikinRn.setZrnshiharaihasseiymd(pZrnshiharaihasseiymd);
        return this.selectOne(zT_NkBikinRn);
    }

    public ExDBResults<ZT_NkBikinRn> selectAllZT_NkBikinRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkBikinRn qZT_NkBikinRn =  new QZT_NkBikinRn();
        jpql.append($SELECT);
        jpql.append(qZT_NkBikinRn);
        jpql.append($FROM);
        jpql.append(qZT_NkBikinRn.ZT_NkBikinRn());
        jpql.append($ORDER_BY(qZT_NkBikinRn.zrnnksyousyono.asc(), qZT_NkBikinRn.zrnshiharaihasseiymd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkBikinRn).getResults();
    }
}

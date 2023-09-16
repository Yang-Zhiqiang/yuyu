package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkIktHriRn;
import yuyu.def.db.meta.QZT_NkIktHriRn;

/**
 * 年金一括払テーブル（連）(ZT_NkIktHriRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkIktHriRnDao extends AbstractDao<ZT_NkIktHriRn> {

    public ZT_NkIktHriRnDao() {
        super(ZT_NkIktHriRn.class);
    }

    public ZT_NkIktHriRn getNkIktHriRn(String pZrndatakanrino) {
        ZT_NkIktHriRn zT_NkIktHriRn =  new ZT_NkIktHriRn();
        zT_NkIktHriRn.setZrndatakanrino(pZrndatakanrino);
        return this.selectOne(zT_NkIktHriRn);
    }

    public ExDBResults<ZT_NkIktHriRn> selectAllZT_NkIktHriRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkIktHriRn qZT_NkIktHriRn =  new QZT_NkIktHriRn();
        jpql.append($SELECT);
        jpql.append(qZT_NkIktHriRn);
        jpql.append($FROM);
        jpql.append(qZT_NkIktHriRn.ZT_NkIktHriRn());
        jpql.append($ORDER_BY(qZT_NkIktHriRn.zrndatakanrino.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkIktHriRn).getResults();
    }
}

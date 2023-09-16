package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SeirituInfoRn;
import yuyu.def.db.meta.QZT_SeirituInfoRn;

/**
 * 成立情報Ｆテーブル（連）(ZT_SeirituInfoRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SeirituInfoRnDao extends AbstractDao<ZT_SeirituInfoRn> {

    public ZT_SeirituInfoRnDao() {
        super(ZT_SeirituInfoRn.class);
    }

    public ZT_SeirituInfoRn getSeirituInfoRn(String pZrnkijyunym, String pZrnsyono) {
        ZT_SeirituInfoRn zT_SeirituInfoRn =  new ZT_SeirituInfoRn();
        zT_SeirituInfoRn.setZrnkijyunym(pZrnkijyunym);
        zT_SeirituInfoRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_SeirituInfoRn);
    }

    public ExDBResults<ZT_SeirituInfoRn> selectAllZT_SeirituInfoRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SeirituInfoRn qZT_SeirituInfoRn =  new QZT_SeirituInfoRn();
        jpql.append($SELECT);
        jpql.append(qZT_SeirituInfoRn);
        jpql.append($FROM);
        jpql.append(qZT_SeirituInfoRn.ZT_SeirituInfoRn());
        jpql.append($ORDER_BY(qZT_SeirituInfoRn.zrnkijyunym.asc(), qZT_SeirituInfoRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SeirituInfoRn).getResults();
    }
}

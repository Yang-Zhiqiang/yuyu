package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkToukeiHySgRn;
import yuyu.def.db.meta.QZT_NkToukeiHySgRn;

/**
 * 年金統計Ｆ保有照合用テーブル（連）(ZT_NkToukeiHySgRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkToukeiHySgRnDao extends AbstractDao<ZT_NkToukeiHySgRn> {

    public ZT_NkToukeiHySgRnDao() {
        super(ZT_NkToukeiHySgRn.class);
    }

    public ZT_NkToukeiHySgRn getNkToukeiHySgRn(Integer pZrnsequenceno) {
        ZT_NkToukeiHySgRn zT_NkToukeiHySgRn =  new ZT_NkToukeiHySgRn();
        zT_NkToukeiHySgRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_NkToukeiHySgRn);
    }

    public ExDBResults<ZT_NkToukeiHySgRn> selectAllZT_NkToukeiHySgRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkToukeiHySgRn qZT_NkToukeiHySgRn =  new QZT_NkToukeiHySgRn();
        jpql.append($SELECT);
        jpql.append(qZT_NkToukeiHySgRn);
        jpql.append($FROM);
        jpql.append(qZT_NkToukeiHySgRn.ZT_NkToukeiHySgRn());
        jpql.append($ORDER_BY(qZT_NkToukeiHySgRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkToukeiHySgRn).getResults();
    }
}

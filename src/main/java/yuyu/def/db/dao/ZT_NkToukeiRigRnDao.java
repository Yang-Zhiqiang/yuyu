package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkToukeiRigRn;
import yuyu.def.db.meta.QZT_NkToukeiRigRn;

/**
 * 年金統計Ｆ例月用テーブル（連）(ZT_NkToukeiRigRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkToukeiRigRnDao extends AbstractDao<ZT_NkToukeiRigRn> {

    public ZT_NkToukeiRigRnDao() {
        super(ZT_NkToukeiRigRn.class);
    }

    public ZT_NkToukeiRigRn getNkToukeiRigRn(Integer pZrnsequenceno) {
        ZT_NkToukeiRigRn zT_NkToukeiRigRn =  new ZT_NkToukeiRigRn();
        zT_NkToukeiRigRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_NkToukeiRigRn);
    }

    public ExDBResults<ZT_NkToukeiRigRn> selectAllZT_NkToukeiRigRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkToukeiRigRn qZT_NkToukeiRigRn =  new QZT_NkToukeiRigRn();
        jpql.append($SELECT);
        jpql.append(qZT_NkToukeiRigRn);
        jpql.append($FROM);
        jpql.append(qZT_NkToukeiRigRn.ZT_NkToukeiRigRn());
        jpql.append($ORDER_BY(qZT_NkToukeiRigRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkToukeiRigRn).getResults();
    }
}

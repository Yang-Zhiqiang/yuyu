package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DshrToukeiRn;
import yuyu.def.db.meta.QZT_DshrToukeiRn;

/**
 * Ｄ支払統計Ｆテーブル（連）(ZT_DshrToukeiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DshrToukeiRnDao extends AbstractDao<ZT_DshrToukeiRn> {

    public ZT_DshrToukeiRnDao() {
        super(ZT_DshrToukeiRn.class);
    }

    public ZT_DshrToukeiRn getDshrToukeiRn(Integer pZrnsequenceno) {
        ZT_DshrToukeiRn zT_DshrToukeiRn =  new ZT_DshrToukeiRn();
        zT_DshrToukeiRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_DshrToukeiRn);
    }

    public ExDBResults<ZT_DshrToukeiRn> selectAllZT_DshrToukeiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DshrToukeiRn qZT_DshrToukeiRn =  new QZT_DshrToukeiRn();
        jpql.append($SELECT);
        jpql.append(qZT_DshrToukeiRn);
        jpql.append($FROM);
        jpql.append(qZT_DshrToukeiRn.ZT_DshrToukeiRn());
        jpql.append($ORDER_BY(qZT_DshrToukeiRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DshrToukeiRn).getResults();
    }
}

package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DshrToukeiLoadingRn;
import yuyu.def.db.meta.QZT_DshrToukeiLoadingRn;

/**
 * Ｄ支払統計ローディングＦテーブル（連）(ZT_DshrToukeiLoadingRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DshrToukeiLoadingRnDao extends AbstractDao<ZT_DshrToukeiLoadingRn> {

    public ZT_DshrToukeiLoadingRnDao() {
        super(ZT_DshrToukeiLoadingRn.class);
    }

    public ZT_DshrToukeiLoadingRn getDshrToukeiLoadingRn(Integer pZrnsequenceno) {
        ZT_DshrToukeiLoadingRn zT_DshrToukeiLoadingRn =  new ZT_DshrToukeiLoadingRn();
        zT_DshrToukeiLoadingRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_DshrToukeiLoadingRn);
    }

    public ExDBResults<ZT_DshrToukeiLoadingRn> selectAllZT_DshrToukeiLoadingRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DshrToukeiLoadingRn qZT_DshrToukeiLoadingRn =  new QZT_DshrToukeiLoadingRn();
        jpql.append($SELECT);
        jpql.append(qZT_DshrToukeiLoadingRn);
        jpql.append($FROM);
        jpql.append(qZT_DshrToukeiLoadingRn.ZT_DshrToukeiLoadingRn());
        jpql.append($ORDER_BY(qZT_DshrToukeiLoadingRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DshrToukeiLoadingRn).getResults();
    }
}

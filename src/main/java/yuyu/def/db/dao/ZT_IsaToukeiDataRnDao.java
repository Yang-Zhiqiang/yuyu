package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_IsaToukeiDataRn;
import yuyu.def.db.meta.QZT_IsaToukeiDataRn;

/**
 * 医査統計データテーブル（連）(ZT_IsaToukeiDataRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_IsaToukeiDataRnDao extends AbstractDao<ZT_IsaToukeiDataRn> {

    public ZT_IsaToukeiDataRnDao() {
        super(ZT_IsaToukeiDataRn.class);
    }

    public ZT_IsaToukeiDataRn getIsaToukeiDataRn(String pZrnmosno) {
        ZT_IsaToukeiDataRn zT_IsaToukeiDataRn =  new ZT_IsaToukeiDataRn();
        zT_IsaToukeiDataRn.setZrnmosno(pZrnmosno);
        return this.selectOne(zT_IsaToukeiDataRn);
    }

    public ExDBResults<ZT_IsaToukeiDataRn> selectAllZT_IsaToukeiDataRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_IsaToukeiDataRn qZT_IsaToukeiDataRn =  new QZT_IsaToukeiDataRn();
        jpql.append($SELECT);
        jpql.append(qZT_IsaToukeiDataRn);
        jpql.append($FROM);
        jpql.append(qZT_IsaToukeiDataRn.ZT_IsaToukeiDataRn());
        jpql.append($ORDER_BY(qZT_IsaToukeiDataRn.zrnmosno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_IsaToukeiDataRn).getResults();
    }
}

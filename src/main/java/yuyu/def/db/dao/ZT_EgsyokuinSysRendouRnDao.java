package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_EgsyokuinSysRendouRn;
import yuyu.def.db.meta.QZT_EgsyokuinSysRendouRn;

/**
 * 営業職員システム連動Ｆテーブル（連）(ZT_EgsyokuinSysRendouRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_EgsyokuinSysRendouRnDao extends AbstractDao<ZT_EgsyokuinSysRendouRn> {

    public ZT_EgsyokuinSysRendouRnDao() {
        super(ZT_EgsyokuinSysRendouRn.class);
    }

    public ZT_EgsyokuinSysRendouRn getEgsyokuinSysRendouRn(Integer pZrnsequenceno) {
        ZT_EgsyokuinSysRendouRn zT_EgsyokuinSysRendouRn =  new ZT_EgsyokuinSysRendouRn();
        zT_EgsyokuinSysRendouRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_EgsyokuinSysRendouRn);
    }

    public ExDBResults<ZT_EgsyokuinSysRendouRn> selectAllZT_EgsyokuinSysRendouRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_EgsyokuinSysRendouRn qZT_EgsyokuinSysRendouRn =  new QZT_EgsyokuinSysRendouRn();
        jpql.append($SELECT);
        jpql.append(qZT_EgsyokuinSysRendouRn);
        jpql.append($FROM);
        jpql.append(qZT_EgsyokuinSysRendouRn.ZT_EgsyokuinSysRendouRn());
        jpql.append($ORDER_BY(qZT_EgsyokuinSysRendouRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_EgsyokuinSysRendouRn).getResults();
    }
}

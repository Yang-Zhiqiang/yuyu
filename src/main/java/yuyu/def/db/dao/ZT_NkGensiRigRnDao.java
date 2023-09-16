package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkGensiRigRn;
import yuyu.def.db.meta.QZT_NkGensiRigRn;

/**
 * 年金原資Ｆ例月用テーブル（連）(ZT_NkGensiRigRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkGensiRigRnDao extends AbstractDao<ZT_NkGensiRigRn> {

    public ZT_NkGensiRigRnDao() {
        super(ZT_NkGensiRigRn.class);
    }

    public ZT_NkGensiRigRn getNkGensiRigRn(Integer pZrnsequenceno) {
        ZT_NkGensiRigRn zT_NkGensiRigRn =  new ZT_NkGensiRigRn();
        zT_NkGensiRigRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_NkGensiRigRn);
    }

    public ExDBResults<ZT_NkGensiRigRn> selectAllZT_NkGensiRigRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkGensiRigRn qZT_NkGensiRigRn =  new QZT_NkGensiRigRn();
        jpql.append($SELECT);
        jpql.append(qZT_NkGensiRigRn);
        jpql.append($FROM);
        jpql.append(qZT_NkGensiRigRn.ZT_NkGensiRigRn());
        jpql.append($ORDER_BY(qZT_NkGensiRigRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkGensiRigRn).getResults();
    }
}

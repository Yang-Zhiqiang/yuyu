package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkGensiKtyRn;
import yuyu.def.db.meta.QZT_NkGensiKtyRn;

/**
 * 年金原資Ｆ期中報告用テーブル（連）(ZT_NkGensiKtyRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkGensiKtyRnDao extends AbstractDao<ZT_NkGensiKtyRn> {

    public ZT_NkGensiKtyRnDao() {
        super(ZT_NkGensiKtyRn.class);
    }

    public ZT_NkGensiKtyRn getNkGensiKtyRn(Integer pZrnsequenceno) {
        ZT_NkGensiKtyRn zT_NkGensiKtyRn =  new ZT_NkGensiKtyRn();
        zT_NkGensiKtyRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_NkGensiKtyRn);
    }

    public ExDBResults<ZT_NkGensiKtyRn> selectAllZT_NkGensiKtyRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkGensiKtyRn qZT_NkGensiKtyRn =  new QZT_NkGensiKtyRn();
        jpql.append($SELECT);
        jpql.append(qZT_NkGensiKtyRn);
        jpql.append($FROM);
        jpql.append(qZT_NkGensiKtyRn.ZT_NkGensiKtyRn());
        jpql.append($ORDER_BY(qZT_NkGensiKtyRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkGensiKtyRn).getResults();
    }
}

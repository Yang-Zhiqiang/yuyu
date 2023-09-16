package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NkGensiHySgRn;
import yuyu.def.db.meta.QZT_NkGensiHySgRn;

/**
 * 年金原資Ｆ保有照合用テーブル（連）(ZT_NkGensiHySgRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NkGensiHySgRnDao extends AbstractDao<ZT_NkGensiHySgRn> {

    public ZT_NkGensiHySgRnDao() {
        super(ZT_NkGensiHySgRn.class);
    }

    public ZT_NkGensiHySgRn getNkGensiHySgRn(Integer pZrnsequenceno) {
        ZT_NkGensiHySgRn zT_NkGensiHySgRn =  new ZT_NkGensiHySgRn();
        zT_NkGensiHySgRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_NkGensiHySgRn);
    }

    public ExDBResults<ZT_NkGensiHySgRn> selectAllZT_NkGensiHySgRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_NkGensiHySgRn qZT_NkGensiHySgRn =  new QZT_NkGensiHySgRn();
        jpql.append($SELECT);
        jpql.append(qZT_NkGensiHySgRn);
        jpql.append($FROM);
        jpql.append(qZT_NkGensiHySgRn.ZT_NkGensiHySgRn());
        jpql.append($ORDER_BY(qZT_NkGensiHySgRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NkGensiHySgRn).getResults();
    }
}

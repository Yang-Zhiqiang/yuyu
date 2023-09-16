package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_IdouMeisaiRn;
import yuyu.def.db.meta.QZT_IdouMeisaiRn;

/**
 * 異動明細Ｆテーブル（連）(ZT_IdouMeisaiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_IdouMeisaiRnDao extends AbstractDao<ZT_IdouMeisaiRn> {

    public ZT_IdouMeisaiRnDao() {
        super(ZT_IdouMeisaiRn.class);
    }

    public ZT_IdouMeisaiRn getIdouMeisaiRn(Integer pZrnsequenceno) {
        ZT_IdouMeisaiRn zT_IdouMeisaiRn =  new ZT_IdouMeisaiRn();
        zT_IdouMeisaiRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_IdouMeisaiRn);
    }

    public ExDBResults<ZT_IdouMeisaiRn> selectAllZT_IdouMeisaiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_IdouMeisaiRn qZT_IdouMeisaiRn =  new QZT_IdouMeisaiRn();
        jpql.append($SELECT);
        jpql.append(qZT_IdouMeisaiRn);
        jpql.append($FROM);
        jpql.append(qZT_IdouMeisaiRn.ZT_IdouMeisaiRn());
        jpql.append($ORDER_BY(qZT_IdouMeisaiRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_IdouMeisaiRn).getResults();
    }
}

package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_HoyuuMeisaiRn;
import yuyu.def.db.meta.QZT_HoyuuMeisaiRn;

/**
 * 保有明細Ｆテーブル（連）(ZT_HoyuuMeisaiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_HoyuuMeisaiRnDao extends AbstractDao<ZT_HoyuuMeisaiRn> {

    public ZT_HoyuuMeisaiRnDao() {
        super(ZT_HoyuuMeisaiRn.class);
    }

    public ZT_HoyuuMeisaiRn getHoyuuMeisaiRn(Integer pZrnsequenceno) {
        ZT_HoyuuMeisaiRn zT_HoyuuMeisaiRn =  new ZT_HoyuuMeisaiRn();
        zT_HoyuuMeisaiRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_HoyuuMeisaiRn);
    }

    public ExDBResults<ZT_HoyuuMeisaiRn> selectAllZT_HoyuuMeisaiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_HoyuuMeisaiRn qZT_HoyuuMeisaiRn =  new QZT_HoyuuMeisaiRn();
        jpql.append($SELECT);
        jpql.append(qZT_HoyuuMeisaiRn);
        jpql.append($FROM);
        jpql.append(qZT_HoyuuMeisaiRn.ZT_HoyuuMeisaiRn());
        jpql.append($ORDER_BY(qZT_HoyuuMeisaiRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_HoyuuMeisaiRn).getResults();
    }
}

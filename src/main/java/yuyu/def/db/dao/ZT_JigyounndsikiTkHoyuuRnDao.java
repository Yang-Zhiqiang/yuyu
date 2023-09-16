package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_JigyounndsikiTkHoyuuRn;
import yuyu.def.db.meta.QZT_JigyounndsikiTkHoyuuRn;

/**
 * 事業年度式特約保有Fテーブル（連）(ZT_JigyounndsikiTkHoyuuRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_JigyounndsikiTkHoyuuRnDao extends AbstractDao<ZT_JigyounndsikiTkHoyuuRn> {

    public ZT_JigyounndsikiTkHoyuuRnDao() {
        super(ZT_JigyounndsikiTkHoyuuRn.class);
    }

    public ZT_JigyounndsikiTkHoyuuRn getJigyounndsikiTkHoyuuRn(Integer pZrnsequenceno) {
        ZT_JigyounndsikiTkHoyuuRn zT_JigyounndsikiTkHoyuuRn =  new ZT_JigyounndsikiTkHoyuuRn();
        zT_JigyounndsikiTkHoyuuRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_JigyounndsikiTkHoyuuRn);
    }

    public ExDBResults<ZT_JigyounndsikiTkHoyuuRn> selectAllZT_JigyounndsikiTkHoyuuRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_JigyounndsikiTkHoyuuRn qZT_JigyounndsikiTkHoyuuRn =  new QZT_JigyounndsikiTkHoyuuRn();
        jpql.append($SELECT);
        jpql.append(qZT_JigyounndsikiTkHoyuuRn);
        jpql.append($FROM);
        jpql.append(qZT_JigyounndsikiTkHoyuuRn.ZT_JigyounndsikiTkHoyuuRn());
        jpql.append($ORDER_BY(qZT_JigyounndsikiTkHoyuuRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_JigyounndsikiTkHoyuuRn).getResults();
    }
}

package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_JigyounndsikiTkHoyuuTy;
import yuyu.def.db.meta.QZT_JigyounndsikiTkHoyuuTy;

/**
 * 事業年度式特約保有Fテーブル（中）(ZT_JigyounndsikiTkHoyuuTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_JigyounndsikiTkHoyuuTyDao extends AbstractDao<ZT_JigyounndsikiTkHoyuuTy> {

    public ZT_JigyounndsikiTkHoyuuTyDao() {
        super(ZT_JigyounndsikiTkHoyuuTy.class);
    }

    public ZT_JigyounndsikiTkHoyuuTy getJigyounndsikiTkHoyuuTy(Integer pZtysequenceno) {
        ZT_JigyounndsikiTkHoyuuTy zT_JigyounndsikiTkHoyuuTy =  new ZT_JigyounndsikiTkHoyuuTy();
        zT_JigyounndsikiTkHoyuuTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_JigyounndsikiTkHoyuuTy);
    }

    public ExDBResults<ZT_JigyounndsikiTkHoyuuTy> selectAllZT_JigyounndsikiTkHoyuuTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_JigyounndsikiTkHoyuuTy qZT_JigyounndsikiTkHoyuuTy =  new QZT_JigyounndsikiTkHoyuuTy();
        jpql.append($SELECT);
        jpql.append(qZT_JigyounndsikiTkHoyuuTy);
        jpql.append($FROM);
        jpql.append(qZT_JigyounndsikiTkHoyuuTy.ZT_JigyounndsikiTkHoyuuTy());
        jpql.append($ORDER_BY(qZT_JigyounndsikiTkHoyuuTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_JigyounndsikiTkHoyuuTy).getResults();
    }
}

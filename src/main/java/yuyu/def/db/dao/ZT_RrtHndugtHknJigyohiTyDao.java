package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RrtHndugtHknJigyohiTy;
import yuyu.def.db.meta.QZT_RrtHndugtHknJigyohiTy;

/**
 * 利率変動型保険事業費Ｆテーブル（中）(ZT_RrtHndugtHknJigyohiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RrtHndugtHknJigyohiTyDao extends AbstractDao<ZT_RrtHndugtHknJigyohiTy> {

    public ZT_RrtHndugtHknJigyohiTyDao() {
        super(ZT_RrtHndugtHknJigyohiTy.class);
    }

    public ZT_RrtHndugtHknJigyohiTy getRrtHndugtHknJigyohiTy(Integer pZtysequenceno) {
        ZT_RrtHndugtHknJigyohiTy zT_RrtHndugtHknJigyohiTy =  new ZT_RrtHndugtHknJigyohiTy();
        zT_RrtHndugtHknJigyohiTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_RrtHndugtHknJigyohiTy);
    }

    public ExDBResults<ZT_RrtHndugtHknJigyohiTy> selectAllZT_RrtHndugtHknJigyohiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_RrtHndugtHknJigyohiTy qZT_RrtHndugtHknJigyohiTy =  new QZT_RrtHndugtHknJigyohiTy();
        jpql.append($SELECT);
        jpql.append(qZT_RrtHndugtHknJigyohiTy);
        jpql.append($FROM);
        jpql.append(qZT_RrtHndugtHknJigyohiTy.ZT_RrtHndugtHknJigyohiTy());
        jpql.append($ORDER_BY(qZT_RrtHndugtHknJigyohiTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RrtHndugtHknJigyohiTy).getResults();
    }
}

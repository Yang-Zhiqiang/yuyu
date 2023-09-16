package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RrtHndugtHknKsnJigyohiTy;
import yuyu.def.db.meta.QZT_RrtHndugtHknKsnJigyohiTy;

/**
 * 利率変動型保険決算用事業費Ｆテーブル（中）(ZT_RrtHndugtHknKsnJigyohiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RrtHndugtHknKsnJigyohiTyDao extends AbstractDao<ZT_RrtHndugtHknKsnJigyohiTy> {

    public ZT_RrtHndugtHknKsnJigyohiTyDao() {
        super(ZT_RrtHndugtHknKsnJigyohiTy.class);
    }

    public ZT_RrtHndugtHknKsnJigyohiTy getRrtHndugtHknKsnJigyohiTy(Integer pZtysequenceno) {
        ZT_RrtHndugtHknKsnJigyohiTy zT_RrtHndugtHknKsnJigyohiTy =  new ZT_RrtHndugtHknKsnJigyohiTy();
        zT_RrtHndugtHknKsnJigyohiTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_RrtHndugtHknKsnJigyohiTy);
    }

    public ExDBResults<ZT_RrtHndugtHknKsnJigyohiTy> selectAllZT_RrtHndugtHknKsnJigyohiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_RrtHndugtHknKsnJigyohiTy qZT_RrtHndugtHknKsnJigyohiTy =  new QZT_RrtHndugtHknKsnJigyohiTy();
        jpql.append($SELECT);
        jpql.append(qZT_RrtHndugtHknKsnJigyohiTy);
        jpql.append($FROM);
        jpql.append(qZT_RrtHndugtHknKsnJigyohiTy.ZT_RrtHndugtHknKsnJigyohiTy());
        jpql.append($ORDER_BY(qZT_RrtHndugtHknKsnJigyohiTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RrtHndugtHknKsnJigyohiTy).getResults();
    }
}

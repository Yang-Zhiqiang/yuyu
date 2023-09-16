package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RrtHndugtHknVKnsyuyuTy;
import yuyu.def.db.meta.QZT_RrtHndugtHknVKnsyuyuTy;

/**
 * 利率変動型保険Ｖ検証用Ｆテーブル（中）(ZT_RrtHndugtHknVKnsyuyuTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RrtHndugtHknVKnsyuyuTyDao extends AbstractDao<ZT_RrtHndugtHknVKnsyuyuTy> {

    public ZT_RrtHndugtHknVKnsyuyuTyDao() {
        super(ZT_RrtHndugtHknVKnsyuyuTy.class);
    }

    public ZT_RrtHndugtHknVKnsyuyuTy getRrtHndugtHknVKnsyuyuTy(Integer pZtysequenceno) {
        ZT_RrtHndugtHknVKnsyuyuTy zT_RrtHndugtHknVKnsyuyuTy =  new ZT_RrtHndugtHknVKnsyuyuTy();
        zT_RrtHndugtHknVKnsyuyuTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_RrtHndugtHknVKnsyuyuTy);
    }

    public ExDBResults<ZT_RrtHndugtHknVKnsyuyuTy> selectAllZT_RrtHndugtHknVKnsyuyuTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_RrtHndugtHknVKnsyuyuTy qZT_RrtHndugtHknVKnsyuyuTy =  new QZT_RrtHndugtHknVKnsyuyuTy();
        jpql.append($SELECT);
        jpql.append(qZT_RrtHndugtHknVKnsyuyuTy);
        jpql.append($FROM);
        jpql.append(qZT_RrtHndugtHknVKnsyuyuTy.ZT_RrtHndugtHknVKnsyuyuTy());
        jpql.append($ORDER_BY(qZT_RrtHndugtHknVKnsyuyuTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RrtHndugtHknVKnsyuyuTy).getResults();
    }
}

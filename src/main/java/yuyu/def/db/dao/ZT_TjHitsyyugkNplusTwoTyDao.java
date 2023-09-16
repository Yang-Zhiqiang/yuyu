package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusTwoTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusTwoTy;

/**
 * 通常配当所要額Ｆ（Ｎ＋２）テーブル（中）(ZT_TjHitsyyugkNplusTwoTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TjHitsyyugkNplusTwoTyDao extends AbstractDao<ZT_TjHitsyyugkNplusTwoTy> {

    public ZT_TjHitsyyugkNplusTwoTyDao() {
        super(ZT_TjHitsyyugkNplusTwoTy.class);
    }

    public ZT_TjHitsyyugkNplusTwoTy getTjHitsyyugkNplusTwoTy(Integer pZtysequenceno) {
        ZT_TjHitsyyugkNplusTwoTy zT_TjHitsyyugkNplusTwoTy =  new ZT_TjHitsyyugkNplusTwoTy();
        zT_TjHitsyyugkNplusTwoTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_TjHitsyyugkNplusTwoTy);
    }

    public ExDBResults<ZT_TjHitsyyugkNplusTwoTy> selectAllZT_TjHitsyyugkNplusTwoTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_TjHitsyyugkNplusTwoTy qZT_TjHitsyyugkNplusTwoTy =  new QZT_TjHitsyyugkNplusTwoTy();
        jpql.append($SELECT);
        jpql.append(qZT_TjHitsyyugkNplusTwoTy);
        jpql.append($FROM);
        jpql.append(qZT_TjHitsyyugkNplusTwoTy.ZT_TjHitsyyugkNplusTwoTy());
        jpql.append($ORDER_BY(qZT_TjHitsyyugkNplusTwoTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TjHitsyyugkNplusTwoTy).getResults();
    }
}

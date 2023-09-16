package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SeirituInfoTy;
import yuyu.def.db.meta.QZT_SeirituInfoTy;

/**
 * 成立情報Ｆテーブル（中）(ZT_SeirituInfoTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SeirituInfoTyDao extends AbstractDao<ZT_SeirituInfoTy> {

    public ZT_SeirituInfoTyDao() {
        super(ZT_SeirituInfoTy.class);
    }

    public ZT_SeirituInfoTy getSeirituInfoTy(String pZtykijyunym, String pZtysyono) {
        ZT_SeirituInfoTy zT_SeirituInfoTy =  new ZT_SeirituInfoTy();
        zT_SeirituInfoTy.setZtykijyunym(pZtykijyunym);
        zT_SeirituInfoTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_SeirituInfoTy);
    }

    public ExDBResults<ZT_SeirituInfoTy> selectAllZT_SeirituInfoTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SeirituInfoTy qZT_SeirituInfoTy =  new QZT_SeirituInfoTy();
        jpql.append($SELECT);
        jpql.append(qZT_SeirituInfoTy);
        jpql.append($FROM);
        jpql.append(qZT_SeirituInfoTy.ZT_SeirituInfoTy());
        jpql.append($ORDER_BY(qZT_SeirituInfoTy.ztykijyunym.asc(), qZT_SeirituInfoTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SeirituInfoTy).getResults();
    }
}

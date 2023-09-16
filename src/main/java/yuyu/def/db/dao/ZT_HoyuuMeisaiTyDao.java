package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_HoyuuMeisaiTy;
import yuyu.def.db.meta.QZT_HoyuuMeisaiTy;

/**
 * 保有明細Ｆテーブル（中）(ZT_HoyuuMeisaiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_HoyuuMeisaiTyDao extends AbstractDao<ZT_HoyuuMeisaiTy> {

    public ZT_HoyuuMeisaiTyDao() {
        super(ZT_HoyuuMeisaiTy.class);
    }

    public ZT_HoyuuMeisaiTy getHoyuuMeisaiTy(Integer pZtysequenceno) {
        ZT_HoyuuMeisaiTy zT_HoyuuMeisaiTy =  new ZT_HoyuuMeisaiTy();
        zT_HoyuuMeisaiTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_HoyuuMeisaiTy);
    }

    public ExDBResults<ZT_HoyuuMeisaiTy> selectAllZT_HoyuuMeisaiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_HoyuuMeisaiTy qZT_HoyuuMeisaiTy =  new QZT_HoyuuMeisaiTy();
        jpql.append($SELECT);
        jpql.append(qZT_HoyuuMeisaiTy);
        jpql.append($FROM);
        jpql.append(qZT_HoyuuMeisaiTy.ZT_HoyuuMeisaiTy());
        jpql.append($ORDER_BY(qZT_HoyuuMeisaiTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_HoyuuMeisaiTy).getResults();
    }
}

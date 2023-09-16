package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_IdouMeisaiTy;
import yuyu.def.db.meta.QZT_IdouMeisaiTy;

/**
 * 異動明細Ｆテーブル（中）(ZT_IdouMeisaiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_IdouMeisaiTyDao extends AbstractDao<ZT_IdouMeisaiTy> {

    public ZT_IdouMeisaiTyDao() {
        super(ZT_IdouMeisaiTy.class);
    }

    public ZT_IdouMeisaiTy getIdouMeisaiTy(Integer pZtysequenceno) {
        ZT_IdouMeisaiTy zT_IdouMeisaiTy =  new ZT_IdouMeisaiTy();
        zT_IdouMeisaiTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_IdouMeisaiTy);
    }

    public ExDBResults<ZT_IdouMeisaiTy> selectAllZT_IdouMeisaiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_IdouMeisaiTy qZT_IdouMeisaiTy =  new QZT_IdouMeisaiTy();
        jpql.append($SELECT);
        jpql.append(qZT_IdouMeisaiTy);
        jpql.append($FROM);
        jpql.append(qZT_IdouMeisaiTy.ZT_IdouMeisaiTy());
        jpql.append($ORDER_BY(qZT_IdouMeisaiTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_IdouMeisaiTy).getResults();
    }
}

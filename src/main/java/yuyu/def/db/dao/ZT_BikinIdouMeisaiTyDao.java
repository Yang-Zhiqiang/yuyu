package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_BikinIdouMeisaiTy;
import yuyu.def.db.meta.QZT_BikinIdouMeisaiTy;

/**
 * 備金異動明細Ｆテーブル（中）(ZT_BikinIdouMeisaiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_BikinIdouMeisaiTyDao extends AbstractDao<ZT_BikinIdouMeisaiTy> {

    public ZT_BikinIdouMeisaiTyDao() {
        super(ZT_BikinIdouMeisaiTy.class);
    }

    public ZT_BikinIdouMeisaiTy getBikinIdouMeisaiTy(Integer pZtysequenceno) {
        ZT_BikinIdouMeisaiTy zT_BikinIdouMeisaiTy =  new ZT_BikinIdouMeisaiTy();
        zT_BikinIdouMeisaiTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_BikinIdouMeisaiTy);
    }

    public ExDBResults<ZT_BikinIdouMeisaiTy> selectAllZT_BikinIdouMeisaiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_BikinIdouMeisaiTy qZT_BikinIdouMeisaiTy =  new QZT_BikinIdouMeisaiTy();
        jpql.append($SELECT);
        jpql.append(qZT_BikinIdouMeisaiTy);
        jpql.append($FROM);
        jpql.append(qZT_BikinIdouMeisaiTy.ZT_BikinIdouMeisaiTy());
        jpql.append($ORDER_BY(qZT_BikinIdouMeisaiTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_BikinIdouMeisaiTy).getResults();
    }
}

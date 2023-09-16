package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_MosJkItiranSyoukaiTy;
import yuyu.def.db.meta.QZT_MosJkItiranSyoukaiTy;

/**
 * 申込状況一覧照会用Ｆテーブル（中）(ZT_MosJkItiranSyoukaiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_MosJkItiranSyoukaiTyDao extends AbstractDao<ZT_MosJkItiranSyoukaiTy> {

    public ZT_MosJkItiranSyoukaiTyDao() {
        super(ZT_MosJkItiranSyoukaiTy.class);
    }

    public ZT_MosJkItiranSyoukaiTy getMosJkItiranSyoukaiTy(String pZtymosym, String pZtymosno, String pZtybsydrtencd, String pZtyatukaikojincd) {
        ZT_MosJkItiranSyoukaiTy zT_MosJkItiranSyoukaiTy =  new ZT_MosJkItiranSyoukaiTy();
        zT_MosJkItiranSyoukaiTy.setZtymosym(pZtymosym);
        zT_MosJkItiranSyoukaiTy.setZtymosno(pZtymosno);
        zT_MosJkItiranSyoukaiTy.setZtybsydrtencd(pZtybsydrtencd);
        zT_MosJkItiranSyoukaiTy.setZtyatukaikojincd(pZtyatukaikojincd);
        return this.selectOne(zT_MosJkItiranSyoukaiTy);
    }

    public ExDBResults<ZT_MosJkItiranSyoukaiTy> selectAllZT_MosJkItiranSyoukaiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_MosJkItiranSyoukaiTy qZT_MosJkItiranSyoukaiTy =  new QZT_MosJkItiranSyoukaiTy();
        jpql.append($SELECT);
        jpql.append(qZT_MosJkItiranSyoukaiTy);
        jpql.append($FROM);
        jpql.append(qZT_MosJkItiranSyoukaiTy.ZT_MosJkItiranSyoukaiTy());
        jpql.append($ORDER_BY(qZT_MosJkItiranSyoukaiTy.ztymosym.asc(), qZT_MosJkItiranSyoukaiTy.ztymosno.asc(), qZT_MosJkItiranSyoukaiTy.ztybsydrtencd.asc(), qZT_MosJkItiranSyoukaiTy.ztyatukaikojincd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_MosJkItiranSyoukaiTy).getResults();
    }
}

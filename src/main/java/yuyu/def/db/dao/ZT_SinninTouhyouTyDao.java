package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SinninTouhyouTy;
import yuyu.def.db.meta.QZT_SinninTouhyouTy;

/**
 * 信任投票データテーブル（中）(ZT_SinninTouhyouTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SinninTouhyouTyDao extends AbstractDao<ZT_SinninTouhyouTy> {

    public ZT_SinninTouhyouTyDao() {
        super(ZT_SinninTouhyouTy.class);
    }

    public ZT_SinninTouhyouTy getSinninTouhyouTy(String pZtysyono) {
        ZT_SinninTouhyouTy zT_SinninTouhyouTy =  new ZT_SinninTouhyouTy();
        zT_SinninTouhyouTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_SinninTouhyouTy);
    }

    public ExDBResults<ZT_SinninTouhyouTy> selectAllZT_SinninTouhyouTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SinninTouhyouTy qZT_SinninTouhyouTy =  new QZT_SinninTouhyouTy();
        jpql.append($SELECT);
        jpql.append(qZT_SinninTouhyouTy);
        jpql.append($FROM);
        jpql.append(qZT_SinninTouhyouTy.ZT_SinninTouhyouTy());
        jpql.append($ORDER_BY(qZT_SinninTouhyouTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SinninTouhyouTy).getResults();
    }
}

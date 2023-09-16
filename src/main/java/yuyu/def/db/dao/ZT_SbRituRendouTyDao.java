package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SbRituRendouTy;
import yuyu.def.db.meta.QZT_SbRituRendouTy;

/**
 * 死亡率用連動Ｆテーブル（中）(ZT_SbRituRendouTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SbRituRendouTyDao extends AbstractDao<ZT_SbRituRendouTy> {

    public ZT_SbRituRendouTyDao() {
        super(ZT_SbRituRendouTy.class);
    }

    public ZT_SbRituRendouTy getSbRituRendouTy(String pZtydatakanrino) {
        ZT_SbRituRendouTy zT_SbRituRendouTy =  new ZT_SbRituRendouTy();
        zT_SbRituRendouTy.setZtydatakanrino(pZtydatakanrino);
        return this.selectOne(zT_SbRituRendouTy);
    }

    public ExDBResults<ZT_SbRituRendouTy> selectAllZT_SbRituRendouTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SbRituRendouTy qZT_SbRituRendouTy =  new QZT_SbRituRendouTy();
        jpql.append($SELECT);
        jpql.append(qZT_SbRituRendouTy);
        jpql.append($FROM);
        jpql.append(qZT_SbRituRendouTy.ZT_SbRituRendouTy());
        jpql.append($ORDER_BY(qZT_SbRituRendouTy.ztydatakanrino.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SbRituRendouTy).getResults();
    }
}

package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_YuukouseiNgTuutiTy;
import yuyu.def.db.meta.QZT_YuukouseiNgTuutiTy;

/**
 * 有効性確認ＮＧ通知テーブル（中）(ZT_YuukouseiNgTuutiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_YuukouseiNgTuutiTyDao extends AbstractDao<ZT_YuukouseiNgTuutiTy> {

    public ZT_YuukouseiNgTuutiTyDao() {
        super(ZT_YuukouseiNgTuutiTy.class);
    }

    public ZT_YuukouseiNgTuutiTy getYuukouseiNgTuutiTy(String pZtytyouhyouymd, String pZtysyono) {
        ZT_YuukouseiNgTuutiTy zT_YuukouseiNgTuutiTy =  new ZT_YuukouseiNgTuutiTy();
        zT_YuukouseiNgTuutiTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_YuukouseiNgTuutiTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_YuukouseiNgTuutiTy);
    }

    public ExDBResults<ZT_YuukouseiNgTuutiTy> selectAllZT_YuukouseiNgTuutiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_YuukouseiNgTuutiTy qZT_YuukouseiNgTuutiTy =  new QZT_YuukouseiNgTuutiTy();
        jpql.append($SELECT);
        jpql.append(qZT_YuukouseiNgTuutiTy);
        jpql.append($FROM);
        jpql.append(qZT_YuukouseiNgTuutiTy.ZT_YuukouseiNgTuutiTy());
        jpql.append($ORDER_BY(qZT_YuukouseiNgTuutiTy.ztytyouhyouymd.asc(), qZT_YuukouseiNgTuutiTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_YuukouseiNgTuutiTy).getResults();
    }
}

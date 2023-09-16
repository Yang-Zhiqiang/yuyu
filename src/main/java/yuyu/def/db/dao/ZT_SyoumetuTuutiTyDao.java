package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SyoumetuTuutiTy;
import yuyu.def.db.meta.QZT_SyoumetuTuutiTy;

/**
 * 消滅通知Ｆテーブル（中）(ZT_SyoumetuTuutiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SyoumetuTuutiTyDao extends AbstractDao<ZT_SyoumetuTuutiTy> {

    public ZT_SyoumetuTuutiTyDao() {
        super(ZT_SyoumetuTuutiTy.class);
    }

    public ZT_SyoumetuTuutiTy getSyoumetuTuutiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {
        ZT_SyoumetuTuutiTy zT_SyoumetuTuutiTy =  new ZT_SyoumetuTuutiTy();
        zT_SyoumetuTuutiTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_SyoumetuTuutiTy.setZtysyono(pZtysyono);
        zT_SyoumetuTuutiTy.setZtysikibetuno(pZtysikibetuno);
        return this.selectOne(zT_SyoumetuTuutiTy);
    }

    public ExDBResults<ZT_SyoumetuTuutiTy> selectAllZT_SyoumetuTuutiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SyoumetuTuutiTy qZT_SyoumetuTuutiTy =  new QZT_SyoumetuTuutiTy();
        jpql.append($SELECT);
        jpql.append(qZT_SyoumetuTuutiTy);
        jpql.append($FROM);
        jpql.append(qZT_SyoumetuTuutiTy.ZT_SyoumetuTuutiTy());
        jpql.append($ORDER_BY(qZT_SyoumetuTuutiTy.ztytyouhyouymd.asc(), qZT_SyoumetuTuutiTy.ztysyono.asc(), qZT_SyoumetuTuutiTy.ztysikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SyoumetuTuutiTy).getResults();
    }
}

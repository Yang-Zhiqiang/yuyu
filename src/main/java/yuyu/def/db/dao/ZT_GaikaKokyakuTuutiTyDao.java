package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.db.meta.QZT_GaikaKokyakuTuutiTy;

/**
 * 外貨建顧客通知Ｆテーブル（中）(ZT_GaikaKokyakuTuutiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_GaikaKokyakuTuutiTyDao extends AbstractDao<ZT_GaikaKokyakuTuutiTy> {

    public ZT_GaikaKokyakuTuutiTyDao() {
        super(ZT_GaikaKokyakuTuutiTy.class);
    }

    public ZT_GaikaKokyakuTuutiTy getGaikaKokyakuTuutiTy(String pZtytyouhyouymd, String pZtysyono) {
        ZT_GaikaKokyakuTuutiTy zT_GaikaKokyakuTuutiTy =  new ZT_GaikaKokyakuTuutiTy();
        zT_GaikaKokyakuTuutiTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_GaikaKokyakuTuutiTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_GaikaKokyakuTuutiTy);
    }

    public ExDBResults<ZT_GaikaKokyakuTuutiTy> selectAllZT_GaikaKokyakuTuutiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_GaikaKokyakuTuutiTy qZT_GaikaKokyakuTuutiTy =  new QZT_GaikaKokyakuTuutiTy();
        jpql.append($SELECT);
        jpql.append(qZT_GaikaKokyakuTuutiTy);
        jpql.append($FROM);
        jpql.append(qZT_GaikaKokyakuTuutiTy.ZT_GaikaKokyakuTuutiTy());
        jpql.append($ORDER_BY(qZT_GaikaKokyakuTuutiTy.ztytyouhyouymd.asc(), qZT_GaikaKokyakuTuutiTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_GaikaKokyakuTuutiTy).getResults();
    }
}

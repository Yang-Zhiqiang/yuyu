package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SaihakkouHokensyoukenTy;
import yuyu.def.db.meta.QZT_SaihakkouHokensyoukenTy;

/**
 * 再発行保険証券Ｆテーブル（中）(ZT_SaihakkouHokensyoukenTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SaihakkouHokensyoukenTyDao extends AbstractDao<ZT_SaihakkouHokensyoukenTy> {

    public ZT_SaihakkouHokensyoukenTyDao() {
        super(ZT_SaihakkouHokensyoukenTy.class);
    }

    public ZT_SaihakkouHokensyoukenTy getSaihakkouHokensyoukenTy(String pZtytyouhyouymd, String pZtysyono) {
        ZT_SaihakkouHokensyoukenTy zT_SaihakkouHokensyoukenTy =  new ZT_SaihakkouHokensyoukenTy();
        zT_SaihakkouHokensyoukenTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_SaihakkouHokensyoukenTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_SaihakkouHokensyoukenTy);
    }

    public ExDBResults<ZT_SaihakkouHokensyoukenTy> selectAllZT_SaihakkouHokensyoukenTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SaihakkouHokensyoukenTy qZT_SaihakkouHokensyoukenTy =  new QZT_SaihakkouHokensyoukenTy();
        jpql.append($SELECT);
        jpql.append(qZT_SaihakkouHokensyoukenTy);
        jpql.append($FROM);
        jpql.append(qZT_SaihakkouHokensyoukenTy.ZT_SaihakkouHokensyoukenTy());
        jpql.append($ORDER_BY(qZT_SaihakkouHokensyoukenTy.ztytyouhyouymd.asc(), qZT_SaihakkouHokensyoukenTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SaihakkouHokensyoukenTy).getResults();
    }
}

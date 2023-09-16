package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SaihakkouSyoukenSuiiTy;
import yuyu.def.db.meta.QZT_SaihakkouSyoukenSuiiTy;

/**
 * 再発行保険証券推移表Ｆテーブル（中）(ZT_SaihakkouSyoukenSuiiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SaihakkouSyoukenSuiiTyDao extends AbstractDao<ZT_SaihakkouSyoukenSuiiTy> {

    public ZT_SaihakkouSyoukenSuiiTyDao() {
        super(ZT_SaihakkouSyoukenSuiiTy.class);
    }

    public ZT_SaihakkouSyoukenSuiiTy getSaihakkouSyoukenSuiiTy(String pZtysyono, String pZtytyouhyouymd, String pZtysuiihyouptn) {
        ZT_SaihakkouSyoukenSuiiTy zT_SaihakkouSyoukenSuiiTy =  new ZT_SaihakkouSyoukenSuiiTy();
        zT_SaihakkouSyoukenSuiiTy.setZtysyono(pZtysyono);
        zT_SaihakkouSyoukenSuiiTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_SaihakkouSyoukenSuiiTy.setZtysuiihyouptn(pZtysuiihyouptn);
        return this.selectOne(zT_SaihakkouSyoukenSuiiTy);
    }

    public ExDBResults<ZT_SaihakkouSyoukenSuiiTy> selectAllZT_SaihakkouSyoukenSuiiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SaihakkouSyoukenSuiiTy qZT_SaihakkouSyoukenSuiiTy =  new QZT_SaihakkouSyoukenSuiiTy();
        jpql.append($SELECT);
        jpql.append(qZT_SaihakkouSyoukenSuiiTy);
        jpql.append($FROM);
        jpql.append(qZT_SaihakkouSyoukenSuiiTy.ZT_SaihakkouSyoukenSuiiTy());
        jpql.append($ORDER_BY(qZT_SaihakkouSyoukenSuiiTy.ztysyono.asc(), qZT_SaihakkouSyoukenSuiiTy.ztytyouhyouymd.asc(), qZT_SaihakkouSyoukenSuiiTy.ztysuiihyouptn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SaihakkouSyoukenSuiiTy).getResults();
    }
}

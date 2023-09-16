package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SaihakkouSyoukenSuii2Ty;
import yuyu.def.db.meta.QZT_SaihakkouSyoukenSuii2Ty;

/**
 * 再発行保険証券推移表Ｆテーブル２（中）(ZT_SaihakkouSyoukenSuii2TyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SaihakkouSyoukenSuii2TyDao extends AbstractDao<ZT_SaihakkouSyoukenSuii2Ty> {

    public ZT_SaihakkouSyoukenSuii2TyDao() {
        super(ZT_SaihakkouSyoukenSuii2Ty.class);
    }

    public ZT_SaihakkouSyoukenSuii2Ty getSaihakkouSyoukenSuii2Ty(String pZtysyono, String pZtytyouhyouymd, String pZtysuiihyouptn) {
        ZT_SaihakkouSyoukenSuii2Ty zT_SaihakkouSyoukenSuii2Ty =  new ZT_SaihakkouSyoukenSuii2Ty();
        zT_SaihakkouSyoukenSuii2Ty.setZtysyono(pZtysyono);
        zT_SaihakkouSyoukenSuii2Ty.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_SaihakkouSyoukenSuii2Ty.setZtysuiihyouptn(pZtysuiihyouptn);
        return this.selectOne(zT_SaihakkouSyoukenSuii2Ty);
    }

    public ExDBResults<ZT_SaihakkouSyoukenSuii2Ty> selectAllZT_SaihakkouSyoukenSuii2Ty() {
        StringBuilder jpql = new StringBuilder();
        QZT_SaihakkouSyoukenSuii2Ty qZT_SaihakkouSyoukenSuii2Ty =  new QZT_SaihakkouSyoukenSuii2Ty();
        jpql.append($SELECT);
        jpql.append(qZT_SaihakkouSyoukenSuii2Ty);
        jpql.append($FROM);
        jpql.append(qZT_SaihakkouSyoukenSuii2Ty.ZT_SaihakkouSyoukenSuii2Ty());
        jpql.append($ORDER_BY(qZT_SaihakkouSyoukenSuii2Ty.ztysyono.asc(), qZT_SaihakkouSyoukenSuii2Ty.ztytyouhyouymd.asc(), qZT_SaihakkouSyoukenSuii2Ty.ztysuiihyouptn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SaihakkouSyoukenSuii2Ty).getResults();
    }
}

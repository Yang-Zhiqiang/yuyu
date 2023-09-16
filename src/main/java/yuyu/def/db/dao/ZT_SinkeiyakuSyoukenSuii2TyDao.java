package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SinkeiyakuSyoukenSuii2Ty;
import yuyu.def.db.meta.QZT_SinkeiyakuSyoukenSuii2Ty;

/**
 * 新契約保険証券推移表Ｆテーブル２（中）(ZT_SinkeiyakuSyoukenSuii2TyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SinkeiyakuSyoukenSuii2TyDao extends AbstractDao<ZT_SinkeiyakuSyoukenSuii2Ty> {

    public ZT_SinkeiyakuSyoukenSuii2TyDao() {
        super(ZT_SinkeiyakuSyoukenSuii2Ty.class);
    }

    public ZT_SinkeiyakuSyoukenSuii2Ty getSinkeiyakuSyoukenSuii2Ty(String pZtysyono, String pZtytyouhyouymd, String pZtysuiihyouptn) {
        ZT_SinkeiyakuSyoukenSuii2Ty zT_SinkeiyakuSyoukenSuii2Ty =  new ZT_SinkeiyakuSyoukenSuii2Ty();
        zT_SinkeiyakuSyoukenSuii2Ty.setZtysyono(pZtysyono);
        zT_SinkeiyakuSyoukenSuii2Ty.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_SinkeiyakuSyoukenSuii2Ty.setZtysuiihyouptn(pZtysuiihyouptn);
        return this.selectOne(zT_SinkeiyakuSyoukenSuii2Ty);
    }

    public ExDBResults<ZT_SinkeiyakuSyoukenSuii2Ty> selectAllZT_SinkeiyakuSyoukenSuii2Ty() {
        StringBuilder jpql = new StringBuilder();
        QZT_SinkeiyakuSyoukenSuii2Ty qZT_SinkeiyakuSyoukenSuii2Ty =  new QZT_SinkeiyakuSyoukenSuii2Ty();
        jpql.append($SELECT);
        jpql.append(qZT_SinkeiyakuSyoukenSuii2Ty);
        jpql.append($FROM);
        jpql.append(qZT_SinkeiyakuSyoukenSuii2Ty.ZT_SinkeiyakuSyoukenSuii2Ty());
        jpql.append($ORDER_BY(qZT_SinkeiyakuSyoukenSuii2Ty.ztysyono.asc(), qZT_SinkeiyakuSyoukenSuii2Ty.ztytyouhyouymd.asc(), qZT_SinkeiyakuSyoukenSuii2Ty.ztysuiihyouptn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SinkeiyakuSyoukenSuii2Ty).getResults();
    }
}

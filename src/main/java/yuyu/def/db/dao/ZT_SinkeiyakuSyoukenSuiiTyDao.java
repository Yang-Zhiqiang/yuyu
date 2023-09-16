package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SinkeiyakuSyoukenSuiiTy;
import yuyu.def.db.meta.QZT_SinkeiyakuSyoukenSuiiTy;

/**
 * 新契約保険証券推移表Ｆテーブル（中）(ZT_SinkeiyakuSyoukenSuiiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SinkeiyakuSyoukenSuiiTyDao extends AbstractDao<ZT_SinkeiyakuSyoukenSuiiTy> {

    public ZT_SinkeiyakuSyoukenSuiiTyDao() {
        super(ZT_SinkeiyakuSyoukenSuiiTy.class);
    }

    public ZT_SinkeiyakuSyoukenSuiiTy getSinkeiyakuSyoukenSuiiTy(String pZtysyono, String pZtytyouhyouymd, String pZtysuiihyouptn) {
        ZT_SinkeiyakuSyoukenSuiiTy zT_SinkeiyakuSyoukenSuiiTy =  new ZT_SinkeiyakuSyoukenSuiiTy();
        zT_SinkeiyakuSyoukenSuiiTy.setZtysyono(pZtysyono);
        zT_SinkeiyakuSyoukenSuiiTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_SinkeiyakuSyoukenSuiiTy.setZtysuiihyouptn(pZtysuiihyouptn);
        return this.selectOne(zT_SinkeiyakuSyoukenSuiiTy);
    }

    public ExDBResults<ZT_SinkeiyakuSyoukenSuiiTy> selectAllZT_SinkeiyakuSyoukenSuiiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SinkeiyakuSyoukenSuiiTy qZT_SinkeiyakuSyoukenSuiiTy =  new QZT_SinkeiyakuSyoukenSuiiTy();
        jpql.append($SELECT);
        jpql.append(qZT_SinkeiyakuSyoukenSuiiTy);
        jpql.append($FROM);
        jpql.append(qZT_SinkeiyakuSyoukenSuiiTy.ZT_SinkeiyakuSyoukenSuiiTy());
        jpql.append($ORDER_BY(qZT_SinkeiyakuSyoukenSuiiTy.ztysyono.asc(), qZT_SinkeiyakuSyoukenSuiiTy.ztytyouhyouymd.asc(), qZT_SinkeiyakuSyoukenSuiiTy.ztysuiihyouptn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SinkeiyakuSyoukenSuiiTy).getResults();
    }
}

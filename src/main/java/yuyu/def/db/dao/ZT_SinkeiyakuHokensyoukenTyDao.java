package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SinkeiyakuHokensyoukenTy;
import yuyu.def.db.meta.QZT_SinkeiyakuHokensyoukenTy;

/**
 * 新契約保険証券Ｆテーブル（中）(ZT_SinkeiyakuHokensyoukenTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SinkeiyakuHokensyoukenTyDao extends AbstractDao<ZT_SinkeiyakuHokensyoukenTy> {

    public ZT_SinkeiyakuHokensyoukenTyDao() {
        super(ZT_SinkeiyakuHokensyoukenTy.class);
    }

    public ZT_SinkeiyakuHokensyoukenTy getSinkeiyakuHokensyoukenTy(String pZtytyouhyouymd, String pZtysyono) {
        ZT_SinkeiyakuHokensyoukenTy zT_SinkeiyakuHokensyoukenTy =  new ZT_SinkeiyakuHokensyoukenTy();
        zT_SinkeiyakuHokensyoukenTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_SinkeiyakuHokensyoukenTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_SinkeiyakuHokensyoukenTy);
    }

    public ExDBResults<ZT_SinkeiyakuHokensyoukenTy> selectAllZT_SinkeiyakuHokensyoukenTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SinkeiyakuHokensyoukenTy qZT_SinkeiyakuHokensyoukenTy =  new QZT_SinkeiyakuHokensyoukenTy();
        jpql.append($SELECT);
        jpql.append(qZT_SinkeiyakuHokensyoukenTy);
        jpql.append($FROM);
        jpql.append(qZT_SinkeiyakuHokensyoukenTy.ZT_SinkeiyakuHokensyoukenTy());
        jpql.append($ORDER_BY(qZT_SinkeiyakuHokensyoukenTy.ztytyouhyouymd.asc(), qZT_SinkeiyakuHokensyoukenTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SinkeiyakuHokensyoukenTy).getResults();
    }
}

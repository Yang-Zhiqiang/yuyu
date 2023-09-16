package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SyoukenTkListShTy;
import yuyu.def.db.meta.QZT_SyoukenTkListShTy;

/**
 * 証券特殊処理明細リスト（再発行）Ｆテーブル（中）(ZT_SyoukenTkListShTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SyoukenTkListShTyDao extends AbstractDao<ZT_SyoukenTkListShTy> {

    public ZT_SyoukenTkListShTyDao() {
        super(ZT_SyoukenTkListShTy.class);
    }

    public ZT_SyoukenTkListShTy getSyoukenTkListShTy(String pZtytyouhyouymd, String pZtysyono) {
        ZT_SyoukenTkListShTy zT_SyoukenTkListShTy =  new ZT_SyoukenTkListShTy();
        zT_SyoukenTkListShTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_SyoukenTkListShTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_SyoukenTkListShTy);
    }

    public ExDBResults<ZT_SyoukenTkListShTy> selectAllZT_SyoukenTkListShTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SyoukenTkListShTy qZT_SyoukenTkListShTy =  new QZT_SyoukenTkListShTy();
        jpql.append($SELECT);
        jpql.append(qZT_SyoukenTkListShTy);
        jpql.append($FROM);
        jpql.append(qZT_SyoukenTkListShTy.ZT_SyoukenTkListShTy());
        jpql.append($ORDER_BY(qZT_SyoukenTkListShTy.ztytyouhyouymd.asc(), qZT_SyoukenTkListShTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SyoukenTkListShTy).getResults();
    }
}

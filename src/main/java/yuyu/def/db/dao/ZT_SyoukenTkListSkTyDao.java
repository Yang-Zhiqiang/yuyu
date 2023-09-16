package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SyoukenTkListSkTy;
import yuyu.def.db.meta.QZT_SyoukenTkListSkTy;

/**
 * 証券特殊処理明細リスト（新契約）Ｆテーブル（中）(ZT_SyoukenTkListSkTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SyoukenTkListSkTyDao extends AbstractDao<ZT_SyoukenTkListSkTy> {

    public ZT_SyoukenTkListSkTyDao() {
        super(ZT_SyoukenTkListSkTy.class);
    }

    public ZT_SyoukenTkListSkTy getSyoukenTkListSkTy(String pZtytyouhyouymd, String pZtysyono) {
        ZT_SyoukenTkListSkTy zT_SyoukenTkListSkTy =  new ZT_SyoukenTkListSkTy();
        zT_SyoukenTkListSkTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_SyoukenTkListSkTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_SyoukenTkListSkTy);
    }

    public ExDBResults<ZT_SyoukenTkListSkTy> selectAllZT_SyoukenTkListSkTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SyoukenTkListSkTy qZT_SyoukenTkListSkTy =  new QZT_SyoukenTkListSkTy();
        jpql.append($SELECT);
        jpql.append(qZT_SyoukenTkListSkTy);
        jpql.append($FROM);
        jpql.append(qZT_SyoukenTkListSkTy.ZT_SyoukenTkListSkTy());
        jpql.append($ORDER_BY(qZT_SyoukenTkListSkTy.ztytyouhyouymd.asc(), qZT_SyoukenTkListSkTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SyoukenTkListSkTy).getResults();
    }
}

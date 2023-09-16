package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SeisanDHaneiTuutiTy;
import yuyu.def.db.meta.QZT_SeisanDHaneiTuutiTy;

/**
 * 精算Ｄ反映通知テーブル（中）(ZT_SeisanDHaneiTuutiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SeisanDHaneiTuutiTyDao extends AbstractDao<ZT_SeisanDHaneiTuutiTy> {

    public ZT_SeisanDHaneiTuutiTyDao() {
        super(ZT_SeisanDHaneiTuutiTy.class);
    }

    public ZT_SeisanDHaneiTuutiTy getSeisanDHaneiTuutiTy(String pZtytyouhyouymd, String pZtykeysyono) {
        ZT_SeisanDHaneiTuutiTy zT_SeisanDHaneiTuutiTy =  new ZT_SeisanDHaneiTuutiTy();
        zT_SeisanDHaneiTuutiTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_SeisanDHaneiTuutiTy.setZtykeysyono(pZtykeysyono);
        return this.selectOne(zT_SeisanDHaneiTuutiTy);
    }

    public ExDBResults<ZT_SeisanDHaneiTuutiTy> selectAllZT_SeisanDHaneiTuutiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SeisanDHaneiTuutiTy qZT_SeisanDHaneiTuutiTy =  new QZT_SeisanDHaneiTuutiTy();
        jpql.append($SELECT);
        jpql.append(qZT_SeisanDHaneiTuutiTy);
        jpql.append($FROM);
        jpql.append(qZT_SeisanDHaneiTuutiTy.ZT_SeisanDHaneiTuutiTy());
        jpql.append($ORDER_BY(qZT_SeisanDHaneiTuutiTy.ztytyouhyouymd.asc(), qZT_SeisanDHaneiTuutiTy.ztykeysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SeisanDHaneiTuutiTy).getResults();
    }
}

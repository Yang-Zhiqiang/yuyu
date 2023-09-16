package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KoujyoSyoumeiTy;
import yuyu.def.db.meta.QZT_KoujyoSyoumeiTy;

/**
 * 控除証明書Ｆテーブル（中）(ZT_KoujyoSyoumeiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KoujyoSyoumeiTyDao extends AbstractDao<ZT_KoujyoSyoumeiTy> {

    public ZT_KoujyoSyoumeiTyDao() {
        super(ZT_KoujyoSyoumeiTy.class);
    }

    public ZT_KoujyoSyoumeiTy getKoujyoSyoumeiTy(String pZtytyouhyouymd, String pZtysyono, String pZtysakunm15keta) {
        ZT_KoujyoSyoumeiTy zT_KoujyoSyoumeiTy =  new ZT_KoujyoSyoumeiTy();
        zT_KoujyoSyoumeiTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_KoujyoSyoumeiTy.setZtysyono(pZtysyono);
        zT_KoujyoSyoumeiTy.setZtysakunm15keta(pZtysakunm15keta);
        return this.selectOne(zT_KoujyoSyoumeiTy);
    }

    public ExDBResults<ZT_KoujyoSyoumeiTy> selectAllZT_KoujyoSyoumeiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KoujyoSyoumeiTy qZT_KoujyoSyoumeiTy =  new QZT_KoujyoSyoumeiTy();
        jpql.append($SELECT);
        jpql.append(qZT_KoujyoSyoumeiTy);
        jpql.append($FROM);
        jpql.append(qZT_KoujyoSyoumeiTy.ZT_KoujyoSyoumeiTy());
        jpql.append($ORDER_BY(qZT_KoujyoSyoumeiTy.ztytyouhyouymd.asc(), qZT_KoujyoSyoumeiTy.ztysyono.asc(), qZT_KoujyoSyoumeiTy.ztysakunm15keta.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KoujyoSyoumeiTy).getResults();
    }
}

package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KhGinkouMdhnFollowCallTy;
import yuyu.def.db.meta.QZT_KhGinkouMdhnFollowCallTy;

/**
 * 銀行窓販フォローコール対象テーブル（中）(ZT_KhGinkouMdhnFollowCallTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KhGinkouMdhnFollowCallTyDao extends AbstractDao<ZT_KhGinkouMdhnFollowCallTy> {

    public ZT_KhGinkouMdhnFollowCallTyDao() {
        super(ZT_KhGinkouMdhnFollowCallTy.class);
    }

    public ZT_KhGinkouMdhnFollowCallTy getKhGinkouMdhnFollowCallTy(String pZtysyono, String pZtyminyuuym) {
        ZT_KhGinkouMdhnFollowCallTy zT_KhGinkouMdhnFollowCallTy =  new ZT_KhGinkouMdhnFollowCallTy();
        zT_KhGinkouMdhnFollowCallTy.setZtysyono(pZtysyono);
        zT_KhGinkouMdhnFollowCallTy.setZtyminyuuym(pZtyminyuuym);
        return this.selectOne(zT_KhGinkouMdhnFollowCallTy);
    }

    public ExDBResults<ZT_KhGinkouMdhnFollowCallTy> selectAllZT_KhGinkouMdhnFollowCallTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KhGinkouMdhnFollowCallTy qZT_KhGinkouMdhnFollowCallTy =  new QZT_KhGinkouMdhnFollowCallTy();
        jpql.append($SELECT);
        jpql.append(qZT_KhGinkouMdhnFollowCallTy);
        jpql.append($FROM);
        jpql.append(qZT_KhGinkouMdhnFollowCallTy.ZT_KhGinkouMdhnFollowCallTy());
        jpql.append($ORDER_BY(qZT_KhGinkouMdhnFollowCallTy.ztysyono.asc(), qZT_KhGinkouMdhnFollowCallTy.ztyminyuuym.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KhGinkouMdhnFollowCallTy).getResults();
    }
}

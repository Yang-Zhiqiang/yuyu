package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KhGinkouMdhnFollowCallRn;
import yuyu.def.db.meta.QZT_KhGinkouMdhnFollowCallRn;

/**
 * 銀行窓販フォローコール対象テーブル（連）(ZT_KhGinkouMdhnFollowCallRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KhGinkouMdhnFollowCallRnDao extends AbstractDao<ZT_KhGinkouMdhnFollowCallRn> {

    public ZT_KhGinkouMdhnFollowCallRnDao() {
        super(ZT_KhGinkouMdhnFollowCallRn.class);
    }

    public ZT_KhGinkouMdhnFollowCallRn getKhGinkouMdhnFollowCallRn(String pZrnsyono, String pZrnminyuuym) {
        ZT_KhGinkouMdhnFollowCallRn zT_KhGinkouMdhnFollowCallRn =  new ZT_KhGinkouMdhnFollowCallRn();
        zT_KhGinkouMdhnFollowCallRn.setZrnsyono(pZrnsyono);
        zT_KhGinkouMdhnFollowCallRn.setZrnminyuuym(pZrnminyuuym);
        return this.selectOne(zT_KhGinkouMdhnFollowCallRn);
    }

    public ExDBResults<ZT_KhGinkouMdhnFollowCallRn> selectAllZT_KhGinkouMdhnFollowCallRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KhGinkouMdhnFollowCallRn qZT_KhGinkouMdhnFollowCallRn =  new QZT_KhGinkouMdhnFollowCallRn();
        jpql.append($SELECT);
        jpql.append(qZT_KhGinkouMdhnFollowCallRn);
        jpql.append($FROM);
        jpql.append(qZT_KhGinkouMdhnFollowCallRn.ZT_KhGinkouMdhnFollowCallRn());
        jpql.append($ORDER_BY(qZT_KhGinkouMdhnFollowCallRn.zrnsyono.asc(), qZT_KhGinkouMdhnFollowCallRn.zrnminyuuym.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KhGinkouMdhnFollowCallRn).getResults();
    }
}

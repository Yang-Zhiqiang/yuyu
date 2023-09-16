package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_EgsyokuinSysRendouTy;
import yuyu.def.db.meta.QZT_EgsyokuinSysRendouTy;

/**
 * 営業職員システム連動Ｆテーブル（中）(ZT_EgsyokuinSysRendouTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_EgsyokuinSysRendouTyDao extends AbstractDao<ZT_EgsyokuinSysRendouTy> {

    public ZT_EgsyokuinSysRendouTyDao() {
        super(ZT_EgsyokuinSysRendouTy.class);
    }

    public ZT_EgsyokuinSysRendouTy getEgsyokuinSysRendouTy(Integer pZtysequenceno) {
        ZT_EgsyokuinSysRendouTy zT_EgsyokuinSysRendouTy =  new ZT_EgsyokuinSysRendouTy();
        zT_EgsyokuinSysRendouTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_EgsyokuinSysRendouTy);
    }

    public ExDBResults<ZT_EgsyokuinSysRendouTy> selectAllZT_EgsyokuinSysRendouTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_EgsyokuinSysRendouTy qZT_EgsyokuinSysRendouTy =  new QZT_EgsyokuinSysRendouTy();
        jpql.append($SELECT);
        jpql.append(qZT_EgsyokuinSysRendouTy);
        jpql.append($FROM);
        jpql.append(qZT_EgsyokuinSysRendouTy.ZT_EgsyokuinSysRendouTy());
        jpql.append($ORDER_BY(qZT_EgsyokuinSysRendouTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_EgsyokuinSysRendouTy).getResults();
    }
}

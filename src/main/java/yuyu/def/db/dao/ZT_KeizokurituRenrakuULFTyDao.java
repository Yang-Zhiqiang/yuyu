package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KeizokurituRenrakuULFTy;
import yuyu.def.db.meta.QZT_KeizokurituRenrakuULFTy;

/**
 * 継続率連絡データＵＬＦテーブル（中）(ZT_KeizokurituRenrakuULFTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KeizokurituRenrakuULFTyDao extends AbstractDao<ZT_KeizokurituRenrakuULFTy> {

    public ZT_KeizokurituRenrakuULFTyDao() {
        super(ZT_KeizokurituRenrakuULFTy.class);
    }

    public ZT_KeizokurituRenrakuULFTy getKeizokurituRenrakuULFTy(Integer pZtysequenceno) {
        ZT_KeizokurituRenrakuULFTy zT_KeizokurituRenrakuULFTy =  new ZT_KeizokurituRenrakuULFTy();
        zT_KeizokurituRenrakuULFTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_KeizokurituRenrakuULFTy);
    }

    public ExDBResults<ZT_KeizokurituRenrakuULFTy> selectAllZT_KeizokurituRenrakuULFTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KeizokurituRenrakuULFTy qZT_KeizokurituRenrakuULFTy =  new QZT_KeizokurituRenrakuULFTy();
        jpql.append($SELECT);
        jpql.append(qZT_KeizokurituRenrakuULFTy);
        jpql.append($FROM);
        jpql.append(qZT_KeizokurituRenrakuULFTy.ZT_KeizokurituRenrakuULFTy());
        jpql.append($ORDER_BY(qZT_KeizokurituRenrakuULFTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KeizokurituRenrakuULFTy).getResults();
    }
}

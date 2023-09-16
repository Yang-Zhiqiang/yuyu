package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DrtenKykIdouDetailTy;
import yuyu.def.db.meta.QZT_DrtenKykIdouDetailTy;

/**
 * 代理店契約異動明細テーブル（中）(ZT_DrtenKykIdouDetailTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DrtenKykIdouDetailTyDao extends AbstractDao<ZT_DrtenKykIdouDetailTy> {

    public ZT_DrtenKykIdouDetailTyDao() {
        super(ZT_DrtenKykIdouDetailTy.class);
    }

    public ZT_DrtenKykIdouDetailTy getDrtenKykIdouDetailTy(String pZtybsydrtencd, String pZtybosyuunincd, String pZtysyono, String pZtyidouhasseiymd, String pZtyidoukbn) {
        ZT_DrtenKykIdouDetailTy zT_DrtenKykIdouDetailTy =  new ZT_DrtenKykIdouDetailTy();
        zT_DrtenKykIdouDetailTy.setZtybsydrtencd(pZtybsydrtencd);
        zT_DrtenKykIdouDetailTy.setZtybosyuunincd(pZtybosyuunincd);
        zT_DrtenKykIdouDetailTy.setZtysyono(pZtysyono);
        zT_DrtenKykIdouDetailTy.setZtyidouhasseiymd(pZtyidouhasseiymd);
        zT_DrtenKykIdouDetailTy.setZtyidoukbn(pZtyidoukbn);
        return this.selectOne(zT_DrtenKykIdouDetailTy);
    }

    public ExDBResults<ZT_DrtenKykIdouDetailTy> selectAllZT_DrtenKykIdouDetailTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_DrtenKykIdouDetailTy qZT_DrtenKykIdouDetailTy =  new QZT_DrtenKykIdouDetailTy();
        jpql.append($SELECT);
        jpql.append(qZT_DrtenKykIdouDetailTy);
        jpql.append($FROM);
        jpql.append(qZT_DrtenKykIdouDetailTy.ZT_DrtenKykIdouDetailTy());
        jpql.append($ORDER_BY(qZT_DrtenKykIdouDetailTy.ztybsydrtencd.asc(), qZT_DrtenKykIdouDetailTy.ztybosyuunincd.asc(), qZT_DrtenKykIdouDetailTy.ztysyono.asc(), qZT_DrtenKykIdouDetailTy.ztyidouhasseiymd.asc(), qZT_DrtenKykIdouDetailTy.ztyidoukbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DrtenKykIdouDetailTy).getResults();
    }
}

package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_GinkouMdhnMisyuuInfoFTy;
import yuyu.def.db.meta.QZT_GinkouMdhnMisyuuInfoFTy;

/**
 * 銀行窓販未収情報Ｆテーブル（中）(ZT_GinkouMdhnMisyuuInfoFTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_GinkouMdhnMisyuuInfoFTyDao extends AbstractDao<ZT_GinkouMdhnMisyuuInfoFTy> {

    public ZT_GinkouMdhnMisyuuInfoFTyDao() {
        super(ZT_GinkouMdhnMisyuuInfoFTy.class);
    }

    public ZT_GinkouMdhnMisyuuInfoFTy getGinkouMdhnMisyuuInfoFTy(String pZtybsydrtencd, String pZtydatasakuseiymd, String pZtysyonosyuban) {
        ZT_GinkouMdhnMisyuuInfoFTy zT_GinkouMdhnMisyuuInfoFTy =  new ZT_GinkouMdhnMisyuuInfoFTy();
        zT_GinkouMdhnMisyuuInfoFTy.setZtybsydrtencd(pZtybsydrtencd);
        zT_GinkouMdhnMisyuuInfoFTy.setZtydatasakuseiymd(pZtydatasakuseiymd);
        zT_GinkouMdhnMisyuuInfoFTy.setZtysyonosyuban(pZtysyonosyuban);
        return this.selectOne(zT_GinkouMdhnMisyuuInfoFTy);
    }

    public ExDBResults<ZT_GinkouMdhnMisyuuInfoFTy> selectAllZT_GinkouMdhnMisyuuInfoFTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_GinkouMdhnMisyuuInfoFTy qZT_GinkouMdhnMisyuuInfoFTy =  new QZT_GinkouMdhnMisyuuInfoFTy();
        jpql.append($SELECT);
        jpql.append(qZT_GinkouMdhnMisyuuInfoFTy);
        jpql.append($FROM);
        jpql.append(qZT_GinkouMdhnMisyuuInfoFTy.ZT_GinkouMdhnMisyuuInfoFTy());
        jpql.append($ORDER_BY(qZT_GinkouMdhnMisyuuInfoFTy.ztybsydrtencd.asc(), qZT_GinkouMdhnMisyuuInfoFTy.ztydatasakuseiymd.asc(), qZT_GinkouMdhnMisyuuInfoFTy.ztysyonosyuban.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_GinkouMdhnMisyuuInfoFTy).getResults();
    }
}

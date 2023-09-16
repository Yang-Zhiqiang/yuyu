package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DrtenMisyuSkInfoDataTy;
import yuyu.def.db.meta.QZT_DrtenMisyuSkInfoDataTy;

/**
 * 代理店未収・失効情報連動データＦテーブル（中）(ZT_DrtenMisyuSkInfoDataTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DrtenMisyuSkInfoDataTyDao extends AbstractDao<ZT_DrtenMisyuSkInfoDataTy> {

    public ZT_DrtenMisyuSkInfoDataTyDao() {
        super(ZT_DrtenMisyuSkInfoDataTy.class);
    }

    public ZT_DrtenMisyuSkInfoDataTy getDrtenMisyuSkInfoDataTy(String pZtysyono, String pZtybsydrtencd, String pZtyhanteiymd) {
        ZT_DrtenMisyuSkInfoDataTy zT_DrtenMisyuSkInfoDataTy =  new ZT_DrtenMisyuSkInfoDataTy();
        zT_DrtenMisyuSkInfoDataTy.setZtysyono(pZtysyono);
        zT_DrtenMisyuSkInfoDataTy.setZtybsydrtencd(pZtybsydrtencd);
        zT_DrtenMisyuSkInfoDataTy.setZtyhanteiymd(pZtyhanteiymd);
        return this.selectOne(zT_DrtenMisyuSkInfoDataTy);
    }

    public ExDBResults<ZT_DrtenMisyuSkInfoDataTy> selectAllZT_DrtenMisyuSkInfoDataTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_DrtenMisyuSkInfoDataTy qZT_DrtenMisyuSkInfoDataTy =  new QZT_DrtenMisyuSkInfoDataTy();
        jpql.append($SELECT);
        jpql.append(qZT_DrtenMisyuSkInfoDataTy);
        jpql.append($FROM);
        jpql.append(qZT_DrtenMisyuSkInfoDataTy.ZT_DrtenMisyuSkInfoDataTy());
        jpql.append($ORDER_BY(qZT_DrtenMisyuSkInfoDataTy.ztysyono.asc(), qZT_DrtenMisyuSkInfoDataTy.ztybsydrtencd.asc(), qZT_DrtenMisyuSkInfoDataTy.ztyhanteiymd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DrtenMisyuSkInfoDataTy).getResults();
    }
}

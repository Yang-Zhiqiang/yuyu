package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DrtenSkKykDtlSyokaiTy;
import yuyu.def.db.meta.QZT_DrtenSkKykDtlSyokaiTy;

/**
 * 代理店失効契約明細照会用Ｆテーブル（中）(ZT_DrtenSkKykDtlSyokaiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DrtenSkKykDtlSyokaiTyDao extends AbstractDao<ZT_DrtenSkKykDtlSyokaiTy> {

    public ZT_DrtenSkKykDtlSyokaiTyDao() {
        super(ZT_DrtenSkKykDtlSyokaiTy.class);
    }

    public ZT_DrtenSkKykDtlSyokaiTy getDrtenSkKykDtlSyokaiTy(String pZtysakuseiym, String pZtybsydrtencd, String pZtytntusycd, String pZtysyono) {
        ZT_DrtenSkKykDtlSyokaiTy zT_DrtenSkKykDtlSyokaiTy =  new ZT_DrtenSkKykDtlSyokaiTy();
        zT_DrtenSkKykDtlSyokaiTy.setZtysakuseiym(pZtysakuseiym);
        zT_DrtenSkKykDtlSyokaiTy.setZtybsydrtencd(pZtybsydrtencd);
        zT_DrtenSkKykDtlSyokaiTy.setZtytntusycd(pZtytntusycd);
        zT_DrtenSkKykDtlSyokaiTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_DrtenSkKykDtlSyokaiTy);
    }

    public ExDBResults<ZT_DrtenSkKykDtlSyokaiTy> selectAllZT_DrtenSkKykDtlSyokaiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_DrtenSkKykDtlSyokaiTy qZT_DrtenSkKykDtlSyokaiTy =  new QZT_DrtenSkKykDtlSyokaiTy();
        jpql.append($SELECT);
        jpql.append(qZT_DrtenSkKykDtlSyokaiTy);
        jpql.append($FROM);
        jpql.append(qZT_DrtenSkKykDtlSyokaiTy.ZT_DrtenSkKykDtlSyokaiTy());
        jpql.append($ORDER_BY(qZT_DrtenSkKykDtlSyokaiTy.ztysakuseiym.asc(), qZT_DrtenSkKykDtlSyokaiTy.ztybsydrtencd.asc(), qZT_DrtenSkKykDtlSyokaiTy.ztytntusycd.asc(), qZT_DrtenSkKykDtlSyokaiTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DrtenSkKykDtlSyokaiTy).getResults();
    }
}

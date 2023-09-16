package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DrtenMinyuKykDtlSyokaiTy;
import yuyu.def.db.meta.QZT_DrtenMinyuKykDtlSyokaiTy;

/**
 * 代理店未入契約明細照会用Ｆテーブル（中）(ZT_DrtenMinyuKykDtlSyokaiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DrtenMinyuKykDtlSyokaiTyDao extends AbstractDao<ZT_DrtenMinyuKykDtlSyokaiTy> {

    public ZT_DrtenMinyuKykDtlSyokaiTyDao() {
        super(ZT_DrtenMinyuKykDtlSyokaiTy.class);
    }

    public ZT_DrtenMinyuKykDtlSyokaiTy getDrtenMinyuKykDtlSyokaiTy(String pZtysakuseiym, String pZtybsydrtencd, String pZtytntusycd, String pZtysyono) {
        ZT_DrtenMinyuKykDtlSyokaiTy zT_DrtenMinyuKykDtlSyokaiTy =  new ZT_DrtenMinyuKykDtlSyokaiTy();
        zT_DrtenMinyuKykDtlSyokaiTy.setZtysakuseiym(pZtysakuseiym);
        zT_DrtenMinyuKykDtlSyokaiTy.setZtybsydrtencd(pZtybsydrtencd);
        zT_DrtenMinyuKykDtlSyokaiTy.setZtytntusycd(pZtytntusycd);
        zT_DrtenMinyuKykDtlSyokaiTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_DrtenMinyuKykDtlSyokaiTy);
    }

    public ExDBResults<ZT_DrtenMinyuKykDtlSyokaiTy> selectAllZT_DrtenMinyuKykDtlSyokaiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_DrtenMinyuKykDtlSyokaiTy qZT_DrtenMinyuKykDtlSyokaiTy =  new QZT_DrtenMinyuKykDtlSyokaiTy();
        jpql.append($SELECT);
        jpql.append(qZT_DrtenMinyuKykDtlSyokaiTy);
        jpql.append($FROM);
        jpql.append(qZT_DrtenMinyuKykDtlSyokaiTy.ZT_DrtenMinyuKykDtlSyokaiTy());
        jpql.append($ORDER_BY(qZT_DrtenMinyuKykDtlSyokaiTy.ztysakuseiym.asc(), qZT_DrtenMinyuKykDtlSyokaiTy.ztybsydrtencd.asc(), qZT_DrtenMinyuKykDtlSyokaiTy.ztytntusycd.asc(), qZT_DrtenMinyuKykDtlSyokaiTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DrtenMinyuKykDtlSyokaiTy).getResults();
    }
}

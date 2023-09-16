package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_YuseiMinyuKykDtlSyokaiTy;
import yuyu.def.db.meta.QZT_YuseiMinyuKykDtlSyokaiTy;

/**
 * 郵政未入契約明細照会用Ｆテーブル（中）(ZT_YuseiMinyuKykDtlSyokaiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_YuseiMinyuKykDtlSyokaiTyDao extends AbstractDao<ZT_YuseiMinyuKykDtlSyokaiTy> {

    public ZT_YuseiMinyuKykDtlSyokaiTyDao() {
        super(ZT_YuseiMinyuKykDtlSyokaiTy.class);
    }

    public ZT_YuseiMinyuKykDtlSyokaiTy getYuseiMinyuKykDtlSyokaiTy(String pZtysakuseiym, String pZtybsydrtencd, String pZtytntusycd, String pZtysyono) {
        ZT_YuseiMinyuKykDtlSyokaiTy zT_YuseiMinyuKykDtlSyokaiTy =  new ZT_YuseiMinyuKykDtlSyokaiTy();
        zT_YuseiMinyuKykDtlSyokaiTy.setZtysakuseiym(pZtysakuseiym);
        zT_YuseiMinyuKykDtlSyokaiTy.setZtybsydrtencd(pZtybsydrtencd);
        zT_YuseiMinyuKykDtlSyokaiTy.setZtytntusycd(pZtytntusycd);
        zT_YuseiMinyuKykDtlSyokaiTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_YuseiMinyuKykDtlSyokaiTy);
    }

    public ExDBResults<ZT_YuseiMinyuKykDtlSyokaiTy> selectAllZT_YuseiMinyuKykDtlSyokaiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_YuseiMinyuKykDtlSyokaiTy qZT_YuseiMinyuKykDtlSyokaiTy =  new QZT_YuseiMinyuKykDtlSyokaiTy();
        jpql.append($SELECT);
        jpql.append(qZT_YuseiMinyuKykDtlSyokaiTy);
        jpql.append($FROM);
        jpql.append(qZT_YuseiMinyuKykDtlSyokaiTy.ZT_YuseiMinyuKykDtlSyokaiTy());
        jpql.append($ORDER_BY(qZT_YuseiMinyuKykDtlSyokaiTy.ztysakuseiym.asc(), qZT_YuseiMinyuKykDtlSyokaiTy.ztybsydrtencd.asc(), qZT_YuseiMinyuKykDtlSyokaiTy.ztytntusycd.asc(), qZT_YuseiMinyuKykDtlSyokaiTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_YuseiMinyuKykDtlSyokaiTy).getResults();
    }
}

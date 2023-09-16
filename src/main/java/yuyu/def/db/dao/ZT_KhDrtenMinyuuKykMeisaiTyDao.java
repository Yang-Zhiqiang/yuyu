package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KhDrtenMinyuuKykMeisaiTy;
import yuyu.def.db.meta.QZT_KhDrtenMinyuuKykMeisaiTy;

/**
 * 代理店未入契約明細テーブル（中）(ZT_KhDrtenMinyuuKykMeisaiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KhDrtenMinyuuKykMeisaiTyDao extends AbstractDao<ZT_KhDrtenMinyuuKykMeisaiTy> {

    public ZT_KhDrtenMinyuuKykMeisaiTyDao() {
        super(ZT_KhDrtenMinyuuKykMeisaiTy.class);
    }

    public ZT_KhDrtenMinyuuKykMeisaiTy getKhDrtenMinyuuKykMeisaiTy(String pZtysyoriymd, String pZtybsydrtencd, String pZtysyono) {
        ZT_KhDrtenMinyuuKykMeisaiTy zT_KhDrtenMinyuuKykMeisaiTy =  new ZT_KhDrtenMinyuuKykMeisaiTy();
        zT_KhDrtenMinyuuKykMeisaiTy.setZtysyoriymd(pZtysyoriymd);
        zT_KhDrtenMinyuuKykMeisaiTy.setZtybsydrtencd(pZtybsydrtencd);
        zT_KhDrtenMinyuuKykMeisaiTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_KhDrtenMinyuuKykMeisaiTy);
    }

    public ExDBResults<ZT_KhDrtenMinyuuKykMeisaiTy> selectAllZT_KhDrtenMinyuuKykMeisaiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KhDrtenMinyuuKykMeisaiTy qZT_KhDrtenMinyuuKykMeisaiTy =  new QZT_KhDrtenMinyuuKykMeisaiTy();
        jpql.append($SELECT);
        jpql.append(qZT_KhDrtenMinyuuKykMeisaiTy);
        jpql.append($FROM);
        jpql.append(qZT_KhDrtenMinyuuKykMeisaiTy.ZT_KhDrtenMinyuuKykMeisaiTy());
        jpql.append($ORDER_BY(qZT_KhDrtenMinyuuKykMeisaiTy.ztysyoriymd.asc(), qZT_KhDrtenMinyuuKykMeisaiTy.ztybsydrtencd.asc(), qZT_KhDrtenMinyuuKykMeisaiTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KhDrtenMinyuuKykMeisaiTy).getResults();
    }
}

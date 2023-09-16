package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SeihoWebIdouListTy;
import yuyu.def.db.meta.QZT_SeihoWebIdouListTy;

/**
 * 生保Ｗｅｂ異動一覧抽出テーブル（中）(ZT_SeihoWebIdouListTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SeihoWebIdouListTyDao extends AbstractDao<ZT_SeihoWebIdouListTy> {

    public ZT_SeihoWebIdouListTyDao() {
        super(ZT_SeihoWebIdouListTy.class);
    }

    public ZT_SeihoWebIdouListTy getSeihoWebIdouListTy(String pZtysakuseiymd7keta, String pZtybsydrtencd, String pZtytntusycd, String pZtysyono, String pZtyhasseiymd, String pZtyidoukbn1, String pZtykydatkikbnkj, String pZtykykyymm, String pZtycifcd) {
        ZT_SeihoWebIdouListTy zT_SeihoWebIdouListTy =  new ZT_SeihoWebIdouListTy();
        zT_SeihoWebIdouListTy.setZtysakuseiymd7keta(pZtysakuseiymd7keta);
        zT_SeihoWebIdouListTy.setZtybsydrtencd(pZtybsydrtencd);
        zT_SeihoWebIdouListTy.setZtytntusycd(pZtytntusycd);
        zT_SeihoWebIdouListTy.setZtysyono(pZtysyono);
        zT_SeihoWebIdouListTy.setZtyhasseiymd(pZtyhasseiymd);
        zT_SeihoWebIdouListTy.setZtyidoukbn1(pZtyidoukbn1);
        zT_SeihoWebIdouListTy.setZtykydatkikbnkj(pZtykydatkikbnkj);
        zT_SeihoWebIdouListTy.setZtykykyymm(pZtykykyymm);
        zT_SeihoWebIdouListTy.setZtycifcd(pZtycifcd);
        return this.selectOne(zT_SeihoWebIdouListTy);
    }

    public ExDBResults<ZT_SeihoWebIdouListTy> selectAllZT_SeihoWebIdouListTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SeihoWebIdouListTy qZT_SeihoWebIdouListTy =  new QZT_SeihoWebIdouListTy();
        jpql.append($SELECT);
        jpql.append(qZT_SeihoWebIdouListTy);
        jpql.append($FROM);
        jpql.append(qZT_SeihoWebIdouListTy.ZT_SeihoWebIdouListTy());
        jpql.append($ORDER_BY(qZT_SeihoWebIdouListTy.ztysakuseiymd7keta.asc(), qZT_SeihoWebIdouListTy.ztybsydrtencd.asc(), qZT_SeihoWebIdouListTy.ztytntusycd.asc(), qZT_SeihoWebIdouListTy.ztysyono.asc(), qZT_SeihoWebIdouListTy.ztyhasseiymd.asc(), qZT_SeihoWebIdouListTy.ztyidoukbn1.asc(), qZT_SeihoWebIdouListTy.ztykydatkikbnkj.asc(), qZT_SeihoWebIdouListTy.ztykykyymm.asc(), qZT_SeihoWebIdouListTy.ztycifcd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SeihoWebIdouListTy).getResults();
    }
}

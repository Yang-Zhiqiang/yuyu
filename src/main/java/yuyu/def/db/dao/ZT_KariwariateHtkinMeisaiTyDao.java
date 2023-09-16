package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KariwariateHtkinMeisaiTy;
import yuyu.def.db.meta.QZT_KariwariateHtkinMeisaiTy;

/**
 * 仮割当配当金明細Ｆテーブル（中）(ZT_KariwariateHtkinMeisaiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KariwariateHtkinMeisaiTyDao extends AbstractDao<ZT_KariwariateHtkinMeisaiTy> {

    public ZT_KariwariateHtkinMeisaiTyDao() {
        super(ZT_KariwariateHtkinMeisaiTy.class);
    }

    public ZT_KariwariateHtkinMeisaiTy getKariwariateHtkinMeisaiTy(Integer pZtysequenceno) {
        ZT_KariwariateHtkinMeisaiTy zT_KariwariateHtkinMeisaiTy =  new ZT_KariwariateHtkinMeisaiTy();
        zT_KariwariateHtkinMeisaiTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_KariwariateHtkinMeisaiTy);
    }

    public ExDBResults<ZT_KariwariateHtkinMeisaiTy> selectAllZT_KariwariateHtkinMeisaiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KariwariateHtkinMeisaiTy qZT_KariwariateHtkinMeisaiTy =  new QZT_KariwariateHtkinMeisaiTy();
        jpql.append($SELECT);
        jpql.append(qZT_KariwariateHtkinMeisaiTy);
        jpql.append($FROM);
        jpql.append(qZT_KariwariateHtkinMeisaiTy.ZT_KariwariateHtkinMeisaiTy());
        jpql.append($ORDER_BY(qZT_KariwariateHtkinMeisaiTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KariwariateHtkinMeisaiTy).getResults();
    }
}

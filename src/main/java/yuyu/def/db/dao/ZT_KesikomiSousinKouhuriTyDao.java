package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KesikomiSousinKouhuriTy;
import yuyu.def.db.meta.QZT_KesikomiSousinKouhuriTy;

/**
 * 消込送信Ｆ（口振）テーブル（中）(ZT_KesikomiSousinKouhuriTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KesikomiSousinKouhuriTyDao extends AbstractDao<ZT_KesikomiSousinKouhuriTy> {

    public ZT_KesikomiSousinKouhuriTyDao() {
        super(ZT_KesikomiSousinKouhuriTy.class);
    }

    public ZT_KesikomiSousinKouhuriTy getKesikomiSousinKouhuriTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd) {
        ZT_KesikomiSousinKouhuriTy zT_KesikomiSousinKouhuriTy =  new ZT_KesikomiSousinKouhuriTy();
        zT_KesikomiSousinKouhuriTy.setZtykskmsousinrenno(pZtykskmsousinrenno);
        zT_KesikomiSousinKouhuriTy.setZtykskmfsyoriymd(pZtykskmfsyoriymd);
        return this.selectOne(zT_KesikomiSousinKouhuriTy);
    }

    public ExDBResults<ZT_KesikomiSousinKouhuriTy> selectAllZT_KesikomiSousinKouhuriTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KesikomiSousinKouhuriTy qZT_KesikomiSousinKouhuriTy =  new QZT_KesikomiSousinKouhuriTy();
        jpql.append($SELECT);
        jpql.append(qZT_KesikomiSousinKouhuriTy);
        jpql.append($FROM);
        jpql.append(qZT_KesikomiSousinKouhuriTy.ZT_KesikomiSousinKouhuriTy());
        jpql.append($ORDER_BY(qZT_KesikomiSousinKouhuriTy.ztykskmsousinrenno.asc(), qZT_KesikomiSousinKouhuriTy.ztykskmfsyoriymd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KesikomiSousinKouhuriTy).getResults();
    }
}

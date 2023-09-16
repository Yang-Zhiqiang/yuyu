package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KesikomiSousinCreditTy;
import yuyu.def.db.meta.QZT_KesikomiSousinCreditTy;

/**
 * 消込送信Ｆ（クレ払）テーブル（中）(ZT_KesikomiSousinCreditTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KesikomiSousinCreditTyDao extends AbstractDao<ZT_KesikomiSousinCreditTy> {

    public ZT_KesikomiSousinCreditTyDao() {
        super(ZT_KesikomiSousinCreditTy.class);
    }

    public ZT_KesikomiSousinCreditTy getKesikomiSousinCreditTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd) {
        ZT_KesikomiSousinCreditTy zT_KesikomiSousinCreditTy =  new ZT_KesikomiSousinCreditTy();
        zT_KesikomiSousinCreditTy.setZtykskmsousinrenno(pZtykskmsousinrenno);
        zT_KesikomiSousinCreditTy.setZtykskmfsyoriymd(pZtykskmfsyoriymd);
        return this.selectOne(zT_KesikomiSousinCreditTy);
    }

    public ExDBResults<ZT_KesikomiSousinCreditTy> selectAllZT_KesikomiSousinCreditTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KesikomiSousinCreditTy qZT_KesikomiSousinCreditTy =  new QZT_KesikomiSousinCreditTy();
        jpql.append($SELECT);
        jpql.append(qZT_KesikomiSousinCreditTy);
        jpql.append($FROM);
        jpql.append(qZT_KesikomiSousinCreditTy.ZT_KesikomiSousinCreditTy());
        jpql.append($ORDER_BY(qZT_KesikomiSousinCreditTy.ztykskmsousinrenno.asc(), qZT_KesikomiSousinCreditTy.ztykskmfsyoriymd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KesikomiSousinCreditTy).getResults();
    }
}

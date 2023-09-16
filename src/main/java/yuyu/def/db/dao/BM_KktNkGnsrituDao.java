package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KktNkGnsritu;
import yuyu.def.db.meta.QBM_KktNkGnsritu;

/**
 * 確定年金原資率マスタ(BM_KktNkGnsrituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_KktNkGnsrituDao extends AbstractDao<BM_KktNkGnsritu> {

    public BM_KktNkGnsrituDao() {
        super(BM_KktNkGnsritu.class);
    }

    public BM_KktNkGnsritu getKktNkGnsritu(String pRyouritusdno, C_Tuukasyu pTuukasyu, Integer pShrkkn) {
        BM_KktNkGnsritu bM_KktNkGnsritu =  new BM_KktNkGnsritu();
        bM_KktNkGnsritu.setRyouritusdno(pRyouritusdno);
        bM_KktNkGnsritu.setTuukasyu(pTuukasyu);
        bM_KktNkGnsritu.setShrkkn(pShrkkn);
        return this.selectOne(bM_KktNkGnsritu);
    }

    public ExDBResults<BM_KktNkGnsritu> selectAllKktNkGnsritu() {
        StringBuilder jpql = new StringBuilder();
        QBM_KktNkGnsritu qBM_KktNkGnsritu =  new QBM_KktNkGnsritu();
        jpql.append($SELECT);
        jpql.append(qBM_KktNkGnsritu);
        jpql.append($FROM);
        jpql.append(qBM_KktNkGnsritu.BM_KktNkGnsritu());
        jpql.append($ORDER_BY(qBM_KktNkGnsritu.ryouritusdno.asc(), qBM_KktNkGnsritu.tuukasyu.asc(), qBM_KktNkGnsritu.shrkkn.asc()));
        return em.createJPQL(jpql.toString()).bind(qBM_KktNkGnsritu).getResults();
    }
}

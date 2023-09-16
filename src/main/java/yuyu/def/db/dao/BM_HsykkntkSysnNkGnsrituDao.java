package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_HsykkntkSysnNkGnsritu;
import yuyu.def.db.meta.QBM_HsykkntkSysnNkGnsritu;

/**
 * 保証期間付終身年金原資率マスタ(BM_HsykkntkSysnNkGnsrituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_HsykkntkSysnNkGnsrituDao extends AbstractDao<BM_HsykkntkSysnNkGnsritu> {

    public BM_HsykkntkSysnNkGnsrituDao() {
        super(BM_HsykkntkSysnNkGnsritu.class);
    }

    public BM_HsykkntkSysnNkGnsritu getHsykkntkSysnNkGnsritu(String pRyouritusdno, C_Tuukasyu pTuukasyu, C_Seibetu pSeibetu, Integer pNkshrstartnen) {
        BM_HsykkntkSysnNkGnsritu bM_HsykkntkSysnNkGnsritu =  new BM_HsykkntkSysnNkGnsritu();
        bM_HsykkntkSysnNkGnsritu.setRyouritusdno(pRyouritusdno);
        bM_HsykkntkSysnNkGnsritu.setTuukasyu(pTuukasyu);
        bM_HsykkntkSysnNkGnsritu.setSeibetu(pSeibetu);
        bM_HsykkntkSysnNkGnsritu.setNkshrstartnen(pNkshrstartnen);
        return this.selectOne(bM_HsykkntkSysnNkGnsritu);
    }

    public ExDBResults<BM_HsykkntkSysnNkGnsritu> selectAllKktNkGnsritu() {
        StringBuilder jpql = new StringBuilder();
        QBM_HsykkntkSysnNkGnsritu qBM_HsykkntkSysnNkGnsritu =  new QBM_HsykkntkSysnNkGnsritu();
        jpql.append($SELECT);
        jpql.append(qBM_HsykkntkSysnNkGnsritu);
        jpql.append($FROM);
        jpql.append(qBM_HsykkntkSysnNkGnsritu.BM_HsykkntkSysnNkGnsritu());
        jpql.append($ORDER_BY(qBM_HsykkntkSysnNkGnsritu.ryouritusdno.asc(), qBM_HsykkntkSysnNkGnsritu.tuukasyu.asc(), qBM_HsykkntkSysnNkGnsritu.seibetu.asc(), qBM_HsykkntkSysnNkGnsritu.nkshrstartnen.asc()));
        return em.createJPQL(jpql.toString()).bind(qBM_HsykkntkSysnNkGnsritu).getResults();
    }
}

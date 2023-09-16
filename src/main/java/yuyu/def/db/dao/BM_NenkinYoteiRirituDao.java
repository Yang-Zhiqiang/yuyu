package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_NenkinYoteiRiritu;
import yuyu.def.db.meta.QBM_NenkinYoteiRiritu;

/**
 * 年金開始後予定利率マスタ(BM_NenkinYoteiRirituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_NenkinYoteiRirituDao extends AbstractDao<BM_NenkinYoteiRiritu> {

    public BM_NenkinYoteiRirituDao() {
        super(BM_NenkinYoteiRiritu.class);
    }

    public BM_NenkinYoteiRiritu getNenkinYoteiRiritu(String pNenkinsyu,
            C_Tuukasyu pTuukasyu,
            BizDate pKykfromymd,
            BizDate pKyktoymd){
        BM_NenkinYoteiRiritu bM_NenkinYoteiRiritu =  new BM_NenkinYoteiRiritu();
        bM_NenkinYoteiRiritu.setNenkinsyu(pNenkinsyu);
        bM_NenkinYoteiRiritu.setTuukasyu(pTuukasyu);
        bM_NenkinYoteiRiritu.setKykfromymd(pKykfromymd);
        bM_NenkinYoteiRiritu.setKyktoymd(pKyktoymd);
        return this.selectOne(bM_NenkinYoteiRiritu);
    }

    public List<BM_NenkinYoteiRiritu> getNenkinYoteiRiritusByNenkinsyuTuukasyuKykfromymdKyktoymd(String pNenkinsyu, C_Tuukasyu pTuukasyu, BizDate pKykymd) {


        QBM_NenkinYoteiRiritu qBM_NenkinYoteiRiritu = new QBM_NenkinYoteiRiritu();


        String strSql = $SELECT + qBM_NenkinYoteiRiritu +
                $FROM + qBM_NenkinYoteiRiritu.BM_NenkinYoteiRiritu() +
                $WHERE + qBM_NenkinYoteiRiritu.nenkinsyu.eq(pNenkinsyu) +
                $AND + qBM_NenkinYoteiRiritu.tuukasyu.eq(pTuukasyu) +
                $AND + qBM_NenkinYoteiRiritu.kykfromymd.le(pKykymd) +
                $AND + qBM_NenkinYoteiRiritu.kyktoymd.ge(pKykymd);


        return em.createJPQL(strSql).bind(qBM_NenkinYoteiRiritu).getResultList();
    }
}

package yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukin.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HW_HrkmNyknTaisyouWk;
import yuyu.def.db.meta.QHT_HrkmNyknData;
import yuyu.def.db.meta.QHT_HrkmNyknSakujyo;
import yuyu.def.db.meta.QHT_JidouSyuunouMeisai2;
import yuyu.def.db.meta.QHW_HrkmNyknTaisyouWk;
import yuyu.def.db.meta.QHW_JidouNyknTaisyougaiWk;
import yuyu.def.db.meta.QHW_MosMatiKknKeikaWk;
import yuyu.def.db.meta.QHW_NyuukinJyouhouHuittiWk;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;

/**
 * 新契約 入金 振込入金処理の機能DAOクラスです
 */
public class SkHurikomiNyuukinDao {

    @Inject
    ExDBEntityManager em;

    public ExDBUpdatableResults<HW_HrkmNyknTaisyouWk>  getHrkmNyknTaisyouWksByKakutyoujobcd(String pKakutyouJobCd) {

        QHW_HrkmNyknTaisyouWk qHW_HrkmNyknTaisyouWk = new QHW_HrkmNyknTaisyouWk();

        String strSql = $SELECT + qHW_HrkmNyknTaisyouWk +
            $FROM + qHW_HrkmNyknTaisyouWk.HW_HrkmNyknTaisyouWk() +
            $WHERE + qHW_HrkmNyknTaisyouWk.syorizumiflg.eq(C_Syorizumiflg.MISYORI) +
            $ORDER_BY(qHW_HrkmNyknTaisyouWk.syoriYmd.asc(),qHW_HrkmNyknTaisyouWk.mosno.asc());

        ExDBUpdatableResults<HW_HrkmNyknTaisyouWk> exDBUpdatableResults =
            em.createJPQL(strSql).bind(qHW_HrkmNyknTaisyouWk).getUpdatableResults();

        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBUpdatableResults;

    }

}

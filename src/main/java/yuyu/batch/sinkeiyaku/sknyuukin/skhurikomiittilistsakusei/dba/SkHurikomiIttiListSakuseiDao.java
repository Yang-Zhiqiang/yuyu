package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomiittilistsakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HW_HrkmNyknTaisyouWk;
import yuyu.def.db.meta.QHW_HrkmNyknTaisyouWk;

/**
 * 新契約 入金 振込入金一致リスト作成DAOクラス
 */
public class SkHurikomiIttiListSakuseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HW_HrkmNyknTaisyouWk> getHrkmNyknTaisyouWksBySyoriYmdRstuukasyuNyktyhyoutlst(BizDate pSyoriYmd,
        C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn... pNyktyhyoutKbnLst) {

        QHW_HrkmNyknTaisyouWk qHW_HrkmNyknTaisyouWk = new QHW_HrkmNyknTaisyouWk("qHW_HrkmNyknTaisyouWk");

        String strSql = $SELECT + qHW_HrkmNyknTaisyouWk +
            $FROM(qHW_HrkmNyknTaisyouWk) +
            $WHERE + qHW_HrkmNyknTaisyouWk.syoriYmd.eq(pSyoriYmd) +
            $AND + qHW_HrkmNyknTaisyouWk.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHW_HrkmNyknTaisyouWk.nyktyhyoutkbn.in(pNyktyhyoutKbnLst) +
            $ORDER_BY(qHW_HrkmNyknTaisyouWk.oyadrtencd.asc(),
                qHW_HrkmNyknTaisyouWk.ryosyuymd.asc(),
                qHW_HrkmNyknTaisyouWk.mosno.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qHW_HrkmNyknTaisyouWk).getResults();
    }

}

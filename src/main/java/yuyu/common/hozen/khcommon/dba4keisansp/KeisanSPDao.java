package yuyu.common.hozen.khcommon.dba4keisansp;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_IkkatuKeisuu;
import yuyu.def.db.meta.QBM_IkkatuKeisuu;
import yuyu.def.db.meta.QBM_IkkatuTekiyouNo2;

/**
 * 契約保全 共通 ＳＰ計算機能DAOクラス
 */
public class KeisanSPDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public BM_IkkatuKeisuu getIkkatuKeisuu(
        String pSyouhnCd,
        String pRyouritusdNo,
        BizNumber pYoteiRiritu,
        String pIkttekiyoubr1,
        String pIkttekiyoubr2,
        String pIkttekiyoubr3,
        Integer pNen1nen2baraihyouji,
        Integer pKeikatukisuu) {

        QBM_IkkatuKeisuu qBM_IkkatuKeisuu = new QBM_IkkatuKeisuu("qBM_IkkatuKeisuu");
        QBM_IkkatuTekiyouNo2 qBM_IkkatuTekiyouNo2 = new QBM_IkkatuTekiyouNo2("qBM_IkkatuTekiyouNo2");

        String strSql = $SELECT + (qBM_IkkatuKeisuu) +
            $FROM(qBM_IkkatuKeisuu,
                qBM_IkkatuTekiyouNo2) +
                $WHERE + qBM_IkkatuKeisuu.ikttekiyouno.eq(qBM_IkkatuTekiyouNo2.ikttekiyouno) +
                $AND + qBM_IkkatuTekiyouNo2.syouhncd.eq(pSyouhnCd) +
                $AND + qBM_IkkatuTekiyouNo2.ryouritusdno.eq(pRyouritusdNo) +
                $AND + qBM_IkkatuTekiyouNo2.yoteiriritu.eq(pYoteiRiritu) +
                $AND + qBM_IkkatuTekiyouNo2.ikttekiyoubr1.eq(pIkttekiyoubr1) +
                $AND + qBM_IkkatuTekiyouNo2.ikttekiyoubr2.eq(pIkttekiyoubr2) +
                $AND + qBM_IkkatuTekiyouNo2.ikttekiyoubr3.eq(pIkttekiyoubr3) +
                $AND + qBM_IkkatuKeisuu.nen1nen2baraihyouji.eq(pNen1nen2baraihyouji) +
                $AND + qBM_IkkatuKeisuu.keikatukisuu.eq(pKeikatukisuu);

        return exDBEntityManager.createJPQL(strSql).bind(qBM_IkkatuKeisuu, qBM_IkkatuTekiyouNo2).getSingleResult();
    }
}

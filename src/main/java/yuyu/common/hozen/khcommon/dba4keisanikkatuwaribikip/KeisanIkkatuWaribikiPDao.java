package yuyu.common.hozen.khcommon.dba4keisanikkatuwaribikip;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_IkkatuKeisuu;
import yuyu.def.db.meta.QBM_IkkatuKeisuu;
import yuyu.def.db.meta.QBM_IkkatuTekiyouNo2;

/**
 * 契約保全 契約保全共通 一括割引Ｐ計算Daoクラス
 */
public class KeisanIkkatuWaribikiPDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public BM_IkkatuKeisuu getIkkatuKeisuu(
        String pSyouhncd,
        String pRyouritusdno,
        BizNumber pYoteiRiritu,
        String pIkttekiyoubr1,
        String pIkttekiyoubr2,
        String pIkttekiyoubr3,
        Integer pNen1nen2baraihyouji,
        Integer pKeikatukisuu) {

        QBM_IkkatuKeisuu qBM_IkkatuKeisuu = new QBM_IkkatuKeisuu("qBM_IkkatuKeisuu");
        QBM_IkkatuTekiyouNo2 qBM_IkkatuTekiyouNo2 = new QBM_IkkatuTekiyouNo2("qBM_IkkatuTekiyouNo2");
        String strSql = $SELECT + qBM_IkkatuKeisuu +
            $FROM(qBM_IkkatuKeisuu,
                qBM_IkkatuTekiyouNo2) +
                $WHERE + qBM_IkkatuTekiyouNo2.ikttekiyouno.eq(qBM_IkkatuKeisuu.ikttekiyouno) +
                $AND + qBM_IkkatuTekiyouNo2.syouhncd.eq(pSyouhncd) +
                $AND + qBM_IkkatuTekiyouNo2.ryouritusdno.eq(pRyouritusdno) +
                $AND + qBM_IkkatuTekiyouNo2.yoteiriritu.eq(pYoteiRiritu) +
                $AND + qBM_IkkatuTekiyouNo2.ikttekiyoubr1.eq(pIkttekiyoubr1) +
                $AND + qBM_IkkatuTekiyouNo2.ikttekiyoubr2.eq(pIkttekiyoubr2) +
                $AND + qBM_IkkatuTekiyouNo2.ikttekiyoubr3.eq(pIkttekiyoubr3) +
                $AND + qBM_IkkatuKeisuu.nen1nen2baraihyouji.eq(pNen1nen2baraihyouji) +
                $AND + qBM_IkkatuKeisuu.keikatukisuu.eq(pKeikatukisuu);

        return exDBEntityManager.createJPQL(strSql)
            .bind(qBM_IkkatuKeisuu, qBM_IkkatuTekiyouNo2).getSingleResult();
    }

}

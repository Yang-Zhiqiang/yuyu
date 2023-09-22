package yuyu.common.sinkeiyaku.skcommon.dba4skzennouikkatuutil;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_IkkatuKeisuu;
import yuyu.def.db.entity.BM_ZennouGenkaRitu2;
import yuyu.def.db.meta.QBM_IkkatuKeisuu;
import yuyu.def.db.meta.QBM_IkkatuTekiyouNo2;
import yuyu.def.db.meta.QBM_ZennouGenkaRitu2;

/**
 *  新契約前納一括払関連ユーティリティ機能DAOクラスです
 */
public class SkZennouIkkatuUtilDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<BM_ZennouGenkaRitu2> getZennouGenkaRitu2(C_Tuukasyu pTuukasyu,
        Integer pZennounensuu, BizDate pKijyunymd) {

        QBM_ZennouGenkaRitu2 qBbM_ZennouGenkaRitu2 = new QBM_ZennouGenkaRitu2("qBbM_ZennouGenkaRitu2");

        String query = $SELECT + qBbM_ZennouGenkaRitu2 +
            $FROM(qBbM_ZennouGenkaRitu2) +
            $WHERE + qBbM_ZennouGenkaRitu2.tuukasyu.eq(pTuukasyu) +
            $AND +   qBbM_ZennouGenkaRitu2.zennoutkybr1.eq("") +
            $AND +   qBbM_ZennouGenkaRitu2.zennoutkybr2.eq("") +
            $AND +   qBbM_ZennouGenkaRitu2.zennoutkybr3.eq("") +
            $AND +   qBbM_ZennouGenkaRitu2.zennounensuu.eq(pZennounensuu) +
            $AND + qBbM_ZennouGenkaRitu2.tekiyoukknfrom.le(pKijyunymd.toString()) +
            $AND + qBbM_ZennouGenkaRitu2.tekiyoukknkto.ge(pKijyunymd.toString());

        return exDBEntityManager.createJPQL(query).bind(qBbM_ZennouGenkaRitu2).getResultList();
    }

    public BM_IkkatuKeisuu getIkkatuKeisuu(
        String pSyouhncd,
        String pRyouritusdno,
        BizNumber pYoteiriritu,
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
                $AND + qBM_IkkatuTekiyouNo2.yoteiriritu.eq(pYoteiriritu) +
                $AND + qBM_IkkatuTekiyouNo2.ikttekiyoubr1.eq("") +
                $AND + qBM_IkkatuTekiyouNo2.ikttekiyoubr2.eq("") +
                $AND + qBM_IkkatuTekiyouNo2.ikttekiyoubr3.eq("") +
                $AND + qBM_IkkatuKeisuu.nen1nen2baraihyouji.eq(pNen1nen2baraihyouji) +
                $AND + qBM_IkkatuKeisuu.keikatukisuu.eq(pKeikatukisuu);

        return exDBEntityManager.createJPQL(strSql)
            .bind(qBM_IkkatuKeisuu, qBM_IkkatuTekiyouNo2).getSingleResult();
    }
}

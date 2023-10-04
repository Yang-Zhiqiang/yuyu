package yuyu.batch.hozen.khinterf.khsinnintouhyousks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_KhTtdkTyuui;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 信任投票作成機能DAOクラス
 */
public class KhSinninTouhyouSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhYuukouTaisyouKykBean> getYuukouTaisyouKykBeans(String pKakutyoujobcd, BizDate pSinninTouhyouSyutujouYmd) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");
        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");
        QIT_KhTtdkTyuui qIT_KhTtdkTyuui = new QIT_KhTtdkTyuui("qIT_KhTtdkTyuui");

        String strSql = $SELECT + $NEW(KhYuukouTaisyouKykBean.class,
            qIT_KykKihon.kbnkey,
            qIT_KykKihon.syono,
            qIT_KykKihon.bosyuuym,
            qIT_KykKihon.hrkkaisuu,
            qIT_KykKihon.hrkkeiro,
            qIT_KykKihon.tikiktbrisyuruikbn,
            qIT_KykSyouhn.kykjyoutai,
            qIT_KykSya.kkkyktdk,
            qIT_KykSya.kyksakuinmeino,
            qIT_KykSya.kyknmkn,
            qIT_KykSya.kyknmkj,
            qIT_KykSya.kykseiymd,
            qIT_KykSya.tsinyno,
            qIT_KykSya.tsinadr1kj,
            qIT_KykSya.tsinadr2kj,
            qIT_KykSya.tsinadr3kj,
            qIT_HhknSya.hhknsakuinmeino,
            qIT_KhTtdkTyuui.kktyuitakbn,
            qIT_KhTtdkTyuui.ttdktyuuikbn1,
            qIT_KhTtdkTyuui.ttdktyuuikbn2,
            qIT_KhTtdkTyuui.ttdktyuuikbn3,
            qIT_KhTtdkTyuui.ttdktyuuikbn4,
            qIT_KhTtdkTyuui.ttdktyuuikbn5) +
            $FROM(qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_KykSya,
                qIT_HhknSya) +
                $LEFT_OUTER_JOIN + qIT_KykKihon.IT_KhTtdkTyuui() +
                $AS + qIT_KhTtdkTyuui +
                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_KykSyouhn.kykymd.le(pSinninTouhyouSyutujouYmd) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_HhknSya.syono);

        ExDBResults<KhYuukouTaisyouKykBean> exDBResults = exDBEntityManager.createJPQL(strSql, KhYuukouTaisyouKykBean.class)
            .bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya, qIT_HhknSya,
                qIT_KhTtdkTyuui).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public long getYuukouTaisyouKykCount(BizDate pSinninTouhyouSyutujouYmd) {

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String strSql = $SELECT + $COUNT(qIT_KykSyouhn.syono) +
            $FROM(qIT_KykSyouhn) +
            $WHERE  + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
            $AND + qIT_KykSyouhn.kykymd.le(pSinninTouhyouSyutujouYmd);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KykSyouhn).getSingleResult();
    }
}

package yuyu.batch.hozen.khinterf.khseisandhaneituutisks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QIM_Syorijtkahi;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_KhTtdkTyuui;
import yuyu.def.db.meta.QIT_KhTumitateDKanri;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_SeisanDHaneiTuuti;
import yuyu.def.db.meta.QMT_KhHenkouUktkYyk;

/**
 * 契約保全 インターフェイス 精算Ｄ反映通知作成機能DAOクラスです。<br />
 */
public class KhSeisanDhaneiTuutiSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhSeisanDhaneiTuutiSksBean> getKhSeisanDhaneiTuutiSksBeans(
        String pKakutyouJobCd,
        BizDateY pHaitouNendo ) {

        QIT_SeisanDHaneiTuuti qIT_SeisanDHaneiTuuti = new QIT_SeisanDHaneiTuuti("qIT_SeisanDHaneiTuuti");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");
        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");
        QIT_KhTtdkTyuui qIT_KhTtdkTyuui = new QIT_KhTtdkTyuui("qIT_KhTtdkTyuui");

        String sql = $SELECT + $NEW(KhSeisanDhaneiTuutiSksBean.class,
            qIT_SeisanDHaneiTuuti.kbnkey,
            qIT_SeisanDHaneiTuuti.syono,
            qIT_SeisanDHaneiTuuti.haitounendo,
            qIT_SeisanDHaneiTuuti.kakuteitounendod.getTypeFieldName(),
            qIT_SeisanDHaneiTuuti.kakuteitounendod.getValueFieldName(),
            qIT_SeisanDHaneiTuuti.naiteitounendod.getTypeFieldName(),
            qIT_SeisanDHaneiTuuti.naiteitounendod.getValueFieldName(),
            qIT_SeisanDHaneiTuuti.seisandkgk.getTypeFieldName(),
            qIT_SeisanDHaneiTuuti.seisandkgk.getValueFieldName(),
            qIT_KykKihon.hrkkeiro,
            qIT_KykKihon.haitoukinuketorihoukbn,
            qIT_KykSyouhn.kykymd,
            qBM_SyouhnZokusei.syouhnnmsyouken,
            qIT_KykSya.tsinyno,
            qIT_KykSya.tsinadr1kj,
            qIT_KykSya.tsinadr2kj,
            qIT_KykSya.tsinadr3kj,
            qIT_KykSya.kyknmkj,
            qIT_HhknSya.hhknnmkj,
            qIT_KhTtdkTyuui.kktyuitakbn,
            qIT_KhTtdkTyuui.ttdktyuuikbn1,
            qIT_KhTtdkTyuui.ttdktyuuikbn2,
            qIT_KhTtdkTyuui.ttdktyuuikbn3,
            qIT_KhTtdkTyuui.ttdktyuuikbn4,
            qIT_KhTtdkTyuui.ttdktyuuikbn5) +
            $FROM(qIT_SeisanDHaneiTuuti,
                qIT_KykKihon,
                qIT_KykSyouhn,
                qBM_SyouhnZokusei,
                qIT_KykSya,
                qIT_HhknSya) +
                $LEFT_OUTER_JOIN + qIT_KykKihon.IT_KhTtdkTyuui() +
                $AS + qIT_KhTtdkTyuui +
                $WHERE + qIT_SeisanDHaneiTuuti.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_SeisanDHaneiTuuti.haitounendo.eq(pHaitouNendo) +
                $AND + qIT_SeisanDHaneiTuuti.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_SeisanDHaneiTuuti.syono.eq(qIT_KykSya.syono) +
                $AND + qIT_SeisanDHaneiTuuti.syono.eq(qIT_HhknSya.syono) +
                $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +
                $AND + qIT_KykSyouhn.syouhnsdno.eq(qBM_SyouhnZokusei.syouhnsdno);

        ExDBResults<KhSeisanDhaneiTuutiSksBean> exDBResults = exDBEntityManager.createJPQL(sql, KhSeisanDhaneiTuutiSksBean.class)
            .bind(qIT_SeisanDHaneiTuuti, qIT_KykKihon, qIT_KykSyouhn, qBM_SyouhnZokusei, qIT_KykSya, qIT_HhknSya,
                qIT_KhTtdkTyuui).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public Long getSyorijtkahiCount(String pKinouId, String pSyorijiMuttdkCd,
        String pSyoritaskid, C_YuukoujyotaikahiKbn pYuukoujyotaiKahiKbn ) {

        QIM_Syorijtkahi qIM_Syorijtkahi = new QIM_Syorijtkahi("qIM_Syorijtkahi");

        String sql = $SELECT + $COUNT + "(*)" +
            $FROM(qIM_Syorijtkahi) +
            $WHERE + qIM_Syorijtkahi.kinouId.eq(pKinouId) +
            $AND + qIM_Syorijtkahi.syorijimuttdkcd.eq(pSyorijiMuttdkCd) +
            $AND + qIM_Syorijtkahi.syoritaskid.eq(pSyoritaskid) +
            $AND + qIM_Syorijtkahi.yuukoujyotaikahikbn.eq(pYuukoujyotaiKahiKbn);

        return exDBEntityManager.createJPQL(sql).bind(qIM_Syorijtkahi).getSingleResult();
    }


    public List<KhHenkouUktkYykBean> getKhHenkouUktkYykBean(C_UktkJyoutaiKbn pUktkJyoutaiKbn, C_UktkSyoriKbn pUktkSyoriKbn) {

        QMT_KhHenkouUktkYyk qMT_KhHenkouUktkYyk = new QMT_KhHenkouUktkYyk("qMT_KhHenkouUktkYyk");

        String sql = $SELECT + $NEW(KhHenkouUktkYykBean.class,
            qMT_KhHenkouUktkYyk.syono,
            qMT_KhHenkouUktkYyk.uktksyorikbn) +
            $FROM(qMT_KhHenkouUktkYyk) +
            $WHERE + qMT_KhHenkouUktkYyk.uktkjyoutaikbn.eq(pUktkJyoutaiKbn) +
            $AND + qMT_KhHenkouUktkYyk.uktksyorikbn.eq(pUktkSyoriKbn);

        return exDBEntityManager.createJPQL(sql, KhHenkouUktkYykBean.class).bind(qMT_KhHenkouUktkYyk).getResultList();
    }

    public Long getKhTumitateDKanriCount(String pSyono, C_TumitateDSakuseiKbn[] pTumitateDSakuseiKbn, BizDate pKijyunymd) {

        QIT_KhTumitateDKanri qIT_KhTumitateDKanri = new QIT_KhTumitateDKanri("qIT_KhTumitateDKanri");

        String sql = $SELECT + $COUNT + "(*)" +
            $FROM(qIT_KhTumitateDKanri) +
            $WHERE + qIT_KhTumitateDKanri.syono.eq(pSyono) +
            $AND + qIT_KhTumitateDKanri.tumitatedskskbn.in(pTumitateDSakuseiKbn) +
            $AND + qIT_KhTumitateDKanri.tumitatedshrkrkymd.ge(pKijyunymd);

        return exDBEntityManager.createJPQL(sql).bind(qIT_KhTumitateDKanri).getSingleResult();
    }

}

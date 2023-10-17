package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrnykgk.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_HijynnykzndkkouzaKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_SegbunruiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.meta.QBM_SegmentSikinidou;
import yuyu.def.db.meta.QBM_SyouhnbetuSegment;
import yuyu.def.db.meta.QIT_KihrkmpSeisanRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;

/**
 * 業務共通 経理･会計 資金移動リストデータ作成(平準払入金外貨)機能DAOクラス<br />
 */
public class BzSikinIdouListDataSksHijynbrNykGkDao {


    @Inject
    private ExDBEntityManager em;

    public ExDBResults<HijynbrNykGkDataBean> getHijynbrNykGkDataBeans(String pKakutyouJobCd, BizDate pSyoriYmd) {

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QBM_SyouhnbetuSegment qBM_SyouhnbetuSegment = new QBM_SyouhnbetuSegment("qBM_SyouhnbetuSegment");

        QBM_SegmentSikinidou qBM_SegmentSikinidou = new QBM_SegmentSikinidou("qBM_SegmentSikinidou");

        String strSql = $SELECT + $NEW(HijynbrNykGkDataBean.class,
            qIT_NyknJissekiRireki.syono,
            qIT_NyknJissekiRireki.nyksyoriymd,
            qIT_NyknJissekiRireki.nyktrksymd,
            qIT_NyknJissekiRireki.nykkeiro,
            qIT_NyknJissekiRireki.nyknaiyoukbn,
            qIT_NyknJissekiRireki.hrkp.getValueFieldName(),
            qIT_NyknJissekiRireki.hrkp.getTypeFieldName(),
            qIT_NyknJissekiRireki.rstuukasyu,
            qIT_NyknJissekiRireki.rsgaku.getValueFieldName(),
            qIT_NyknJissekiRireki.rsgaku.getTypeFieldName(),
            qIT_NyknJissekiRireki.ryosyukwsrate,
            qIT_NyknJissekiRireki.ikkatuyoupkaisuu,
            qBM_SyouhnbetuSegment.segcd) +
            $FROM (qIT_NyknJissekiRireki,
                qIT_KykKihon,
                qIT_KykSyouhn,
                qBM_SyouhnbetuSegment,
                qBM_SegmentSikinidou) +
                $WHERE + qIT_NyknJissekiRireki.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_NyknJissekiRireki.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnbetuSegment.syouhncd) +
                $AND + qIT_KykSyouhn.kyktuukasyu.eq(qBM_SyouhnbetuSegment.kyktuukasyu) +
                $AND + qBM_SyouhnbetuSegment.segcd.eq(qBM_SegmentSikinidou.segcd) +
                $AND + $((qIT_NyknJissekiRireki.nyksyoriymd.eq(pSyoriYmd) +
                    $AND + qIT_NyknJissekiRireki.nyktrksymd.isNull()) +
                    $OR + $(qIT_NyknJissekiRireki.nyksyoriymd.ne(pSyoriYmd) +
                        $AND + qIT_NyknJissekiRireki.nyktrksymd.eq(pSyoriYmd))) +
                        $AND + qBM_SegmentSikinidou.hijynnykzndkkouzakbn.eq(C_HijynnykzndkkouzaKbn.GKHONKZ) +
                        $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.BLNK) +
                        $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.JPY) +
                        $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.BLNK) +
                        $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.ITIJI) +
                        $AND + qIT_NyknJissekiRireki.nykkeiro.ne(C_Nykkeiro.HKNKIN) +
                        $AND + qIT_NyknJissekiRireki.nykkeiro.ne(C_Nykkeiro.KYHKIN) +
                        $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                        $AND + qBM_SyouhnbetuSegment.segbunrui1.eq(C_SegbunruiKbn.BLNK) +
                        $AND + qBM_SyouhnbetuSegment.segbunrui2.eq(C_SegbunruiKbn.BLNK) +
                        $ORDER_BY(qIT_NyknJissekiRireki.syono.asc());

        ExDBResults<HijynbrNykGkDataBean> exDBResults = em.createJPQL(strSql, HijynbrNykGkDataBean.class).bind(
            qIT_NyknJissekiRireki,
            qIT_KykKihon,
            qIT_KykSyouhn,
            qBM_SyouhnbetuSegment,
            qBM_SegmentSikinidou).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public ExDBResults<KihrkmpSeisanRirekiDataBean> getKihrkmpSeisanRirekiDataBeans(String pKakutyouJobCd, BizDate pSyoriYmd) {

        QIT_KihrkmpSeisanRireki qIT_KihrkmpSeisanRireki = new QIT_KihrkmpSeisanRireki("qIT_KihrkmpSeisanRireki");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QBM_SyouhnbetuSegment qBM_SyouhnbetuSegment = new QBM_SyouhnbetuSegment("qBM_SyouhnbetuSegment");

        QBM_SegmentSikinidou qBM_SegmentSikinidou = new QBM_SegmentSikinidou("qBM_SegmentSikinidou");

        String strSql = $SELECT + $NEW(KihrkmpSeisanRirekiDataBean.class,
            qIT_KihrkmpSeisanRireki.syono,
            qIT_KihrkmpSeisanRireki.renno,
            qIT_KihrkmpSeisanRireki.tuityouk.getValueFieldName(),
            qIT_KihrkmpSeisanRireki.tuityouk.getTypeFieldName(),
            qIT_KihrkmpSeisanRireki.yenkansantuityoukin.getValueFieldName(),
            qIT_KihrkmpSeisanRireki.yenkansantuityoukin.getTypeFieldName(),
            qIT_KihrkmpSeisanRireki.zeimukwsrate,
            qBM_SyouhnbetuSegment.segcd) +
            $FROM (qIT_KihrkmpSeisanRireki,
                qIT_KykKihon,
                qIT_KykSyouhn,
                qBM_SyouhnbetuSegment,
                qBM_SegmentSikinidou) +
                $WHERE + qIT_KihrkmpSeisanRireki.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KihrkmpSeisanRireki.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnbetuSegment.syouhncd) +
                $AND + qIT_KykSyouhn.kyktuukasyu.eq(qBM_SyouhnbetuSegment.kyktuukasyu) +
                $AND + qBM_SyouhnbetuSegment.segcd.eq(qBM_SegmentSikinidou.segcd) +
                $AND + qIT_KihrkmpSeisanRireki.kouryokuhasseiymd.eq(pSyoriYmd) +
                $AND + qIT_KihrkmpSeisanRireki.kihrkpssnaiyoukbn.eq(C_KiharaiPseisanNaiyouKbn.TUITYOUKIN) +
                $AND + qBM_SegmentSikinidou.hijynnykzndkkouzakbn.eq(C_HijynnykzndkkouzaKbn.GKHONKZ) +
                $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.BLNK) +
                $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.JPY) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qBM_SyouhnbetuSegment.segbunrui1.eq(C_SegbunruiKbn.BLNK) +
                $AND + qBM_SyouhnbetuSegment.segbunrui2.eq(C_SegbunruiKbn.BLNK) +
                $ORDER_BY(qIT_KihrkmpSeisanRireki.syono.asc(),
                    qIT_KihrkmpSeisanRireki.renno.asc());

        ExDBResults<KihrkmpSeisanRirekiDataBean> exDBResults = em.createJPQL(strSql, KihrkmpSeisanRirekiDataBean.class).bind(
            qIT_KihrkmpSeisanRireki,
            qIT_KykKihon,
            qIT_KykSyouhn,
            qBM_SyouhnbetuSegment,
            qBM_SegmentSikinidou).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }
}

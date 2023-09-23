package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;






import com.google.common.base.Strings;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantousituKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TuutisakuseitaisyouKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_TtdkKan;

/**
 * 契約保全 契約保全共通 新契約直送用手続完了TBL編集
 */
public class EditSkYouTtdkKanryouTbl {

    private static final String TELNO_SETTEI_ARI = "0";

    private static final String TELNO_SETTEI_NASI = "1";

    private static final String KZKOMTTUT_MSGKBN = "06";

    private static final String DRSETTEI_NASI_MSGKNB = "70";

    private static final String KYK_DRSETTI_ARI_MSGKBN = "71";

    private static final String HHK_DRSETTEI_ARI_MSGKBN = "72";

    private static final String KYKHHK_DRSETTEI_ARI_MSGKBN = "73";

    private static final String KZKTAISYOUKYK_MSGKBN = "2";

    private static final String TIRASIHUNYUUH_ARI = "1";

    private static final String TIRASIHUNYUUH_NASI = "0";

    @Inject
    private static Logger logger;

    public List<IT_TtdkKan> exec(
        KhozenCommonParam pKhozenCommonParam,
        IT_KykKihon pKykKihon,
        List<IT_KykSyouhn> pKykSyouhnListSyu,
        IT_KykSya pKykSya,
        IT_KykSonotaTkyk pKykSonotaTkyk,
        IT_KykUkt pKykDairiUkt,
        IT_KykUkt pHhknDairiUkt,
        BizDate pSyoriYmd,
        C_HassouKbn pHassouKbn,
        List<TyokusouTaisyouBean> pTyokusouTaisyouBeanList) {

        logger.debug("▽ 新契約直送用手続完了TBL編集 開始");

        String henkousikibetuKey = pKhozenCommonParam.getSikibetuKey(pKykKihon.getSyono());

        C_UktKbn kykdairiUktKbn = C_UktKbn.BLNK;
        C_UktKbn hhkndairiUktKbn = C_UktKbn.BLNK;

        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getKykdrtkykhukaumu())) {

            kykdairiUktKbn = pKykDairiUkt.getUktkbn();
        }

        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getStdrsktkyhkumu())) {

            hhkndairiUktKbn = pHhknDairiUkt.getUktkbn();
        }

        String callcenterSosikiCd = YuyuBizConfig.getInstance().getCallcentersosikicd();

        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);
        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(callcenterSosikiCd);

        String hokenKaisyaNmKanji = YuyuBizConfig.getInstance().getHokenKaisyaNmKanji();

        List<IT_TtdkKan> ttdkKanList = new ArrayList<IT_TtdkKan>();

        for (TyokusouTaisyouBean tyokusouTaisyouBean : pTyokusouTaisyouBeanList) {

            IT_TtdkKan ttdkKan = pKykKihon.createTtdkKan();

            ttdkKan.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR);
            ttdkKan.setTyouhyouymd(pSyoriYmd);
            ttdkKan.setHassoukbn(pHassouKbn);
            ttdkKan.setTantousitukbn(C_TantousituKbn.KEIYAKUSINSA);
            ttdkKan.setToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
            ttdkKan.setToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
            ttdkKan.setToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
            ttdkKan.setToiawaseadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
            ttdkKan.setToiawasekaisyanmkj(hokenKaisyaNmKanji);
            ttdkKan.setKyknmkj(pKykSya.getKyknmkj());
            ttdkKan.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            ttdkKan.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            ttdkKan.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            ttdkKan.setKhmosno1(pKykKihon.getSkjmosno());

            if (C_TuutisakuseitaisyouKbn.TRKKZK1.eq(tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn()) ||
                C_TuutisakuseitaisyouKbn.TRKKZK2.eq(tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn())) {

                editTtdkkanTblTrkkzk(ttdkKan,
                    kykdairiUktKbn,
                    hhkndairiUktKbn,
                    pKykSyouhnListSyu.get(0).getKykymd(),
                    henkousikibetuKey,
                    tyokusouTaisyouBean);
            }

            henkousikibetuKey = incrementHenkouSikibetukey(henkousikibetuKey);

            BizPropertyInitializer.initialize(ttdkKan);

            ttdkKanList.add(ttdkKan);
        }

        logger.debug("△ 新契約直送用手続完了TBL編集 終了");

        return ttdkKanList;
    }

    private void editTtdkkanTblTrkkzk(
        IT_TtdkKan pTtdkKan,
        C_UktKbn pKykdruktKbn,
        C_UktKbn pHhkndairiUktKbn,
        BizDate pKykYmd,
        String pHenkousikibetuKey,
        TyokusouTaisyouBean pTyokusouTaisyouBean) {

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
        int tourokukzkNenrei = setNenrei.exec(pKykYmd, pTyokusouTaisyouBean.getSeiYmd());

        String shsnmkj2 = "";

        if (tourokukzkNenrei >= 15) {

            shsnmkj2 = "";
        }
        else {
            shsnmkj2 = "（親権者様）";
        }

        String trkkzktelnomtrkhyouji = "";

        if (BizUtil.isBlank(pTyokusouTaisyouBean.getTelno())) {

            trkkzktelnomtrkhyouji = TELNO_SETTEI_NASI;
        }
        else {

            trkkzktelnomtrkhyouji = TELNO_SETTEI_ARI;
        }

        C_TrkKzkKbn trkKzkKbn = C_TrkKzkKbn.TRKKZK1;
        C_UktKbn drhntiyuUktKbn = C_UktKbn.TOUROKUKAZOKU1;

        if (C_TuutisakuseitaisyouKbn.TRKKZK2.eq(pTyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn())) {

            trkKzkKbn = C_TrkKzkKbn.TRKKZK2;
            drhntiyuUktKbn = C_UktKbn.TOUROKUKAZOKU2;
        }

        String drmsgKbn = DRSETTEI_NASI_MSGKNB;
        String keiyakudrHunyuuhyouji = TIRASIHUNYUUH_NASI;
        String hhkdrhuunyuuhyouji = TIRASIHUNYUUH_NASI;

        if (pKykdruktKbn.eq(drhntiyuUktKbn) && pHhkndairiUktKbn.eq(drhntiyuUktKbn)) {

            drmsgKbn = KYKHHK_DRSETTEI_ARI_MSGKBN;
            keiyakudrHunyuuhyouji = TIRASIHUNYUUH_ARI;
            hhkdrhuunyuuhyouji = TIRASIHUNYUUH_ARI;
        }
        else if (pKykdruktKbn.eq(drhntiyuUktKbn)) {

            drmsgKbn = KYK_DRSETTI_ARI_MSGKBN;
            keiyakudrHunyuuhyouji = TIRASIHUNYUUH_ARI;
        }
        else if (pHhkndairiUktKbn.eq(drhntiyuUktKbn)) {

            drmsgKbn = HHK_DRSETTEI_ARI_MSGKBN;
            hhkdrhuunyuuhyouji = TIRASIHUNYUUH_ARI;
        }

        pTtdkKan.setHenkousikibetukey(pHenkousikibetuKey);
        pTtdkKan.setShskyno(pTyokusouTaisyouBean.getYno());
        pTtdkKan.setShsadr1kj(pTyokusouTaisyouBean.getAdr1kj());
        pTtdkKan.setShsadr2kj(pTyokusouTaisyouBean.getAdr2kj());
        pTtdkKan.setShsadr3kj(pTyokusouTaisyouBean.getAdr3kj());
        pTtdkKan.setShsnmkj(pTyokusouTaisyouBean.getNmkj());
        pTtdkKan.setShsnmkj2(shsnmkj2);
        pTtdkKan.setTrkkzkkbn1(trkKzkKbn);
        pTtdkKan.setTrkkzknmkj1(pTyokusouTaisyouBean.getNmkj());
        pTtdkKan.setTrkkzkseiymd1(pTyokusouTaisyouBean.getSeiYmd());
        pTtdkKan.setTrkkzkyno1(pTyokusouTaisyouBean.getYno());
        pTtdkKan.setTrkkzkadr1kj1(pTyokusouTaisyouBean.getAdr1kj());
        pTtdkKan.setTrkkzkadr2kj1(pTyokusouTaisyouBean.getAdr2kj());
        pTtdkKan.setTrkkzkadr3kj1(pTyokusouTaisyouBean.getAdr3kj());
        pTtdkKan.setTrkkzktelno1(pTyokusouTaisyouBean.getTelno());
        pTtdkKan.setTrkkzktelnomtrkhyouji1(trkkzktelnomtrkhyouji);
        pTtdkKan.setKzkomttutkbn1(KZKOMTTUT_MSGKBN);
        pTtdkKan.setKzkaistmsgkbn1(drmsgKbn);
        pTtdkKan.setKzktaisyoukykkbn(KZKTAISYOUKYK_MSGKBN);
        pTtdkKan.setKzkmoshnkniymsg21(drmsgKbn);
        pTtdkKan.setKzktrktrshuunyuuhyouji1(TIRASIHUNYUUH_ARI);
        pTtdkKan.setKykdrhuunyuuhyouji(keiyakudrHunyuuhyouji);
        pTtdkKan.setHhkdrhuunyuuhyouji(hhkdrhuunyuuhyouji);
    }

    private String incrementHenkouSikibetukey(String pHenkousikibetuKey) {

        long henkousikibetuKeyKsy = Long.valueOf(pHenkousikibetuKey);
        henkousikibetuKeyKsy = henkousikibetuKeyKsy + 1;
        String incrementAfHenkouSikibetukey = String.valueOf(henkousikibetuKeyKsy);

        incrementAfHenkouSikibetukey = Strings.padStart(incrementAfHenkouSikibetukey, 18, '0');

        return incrementAfHenkouSikibetukey;
    }
}

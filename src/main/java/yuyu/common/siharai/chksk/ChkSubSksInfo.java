package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.CheckKana;
import yuyu.common.biz.bzcommon.CheckKouzaNo;
import yuyu.common.biz.bzcommon.CheckMeigininNmKana;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.kaikei.BzShiharaiDenpyouDateShutoku;
import yuyu.common.siharai.sicommon.SetteiShrhousiteiKbn;
import yuyu.def.classification.C_BankYuuksHantKbn;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_EnkashrKahiKbn;
import yuyu.def.classification.C_GaikashrKahiKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;

/**
 * 保険金給付金支払 請求内容チェック 送金先情報チェック
 */
public class ChkSubSksInfo {

    @Inject
    private static Logger logger;

    public ChkSubSksInfo() {
        super();
    }

    public void exec(C_InputShrhousiteiKbn pInputShrhousiteiKbn, String pBankCd, String pSitenCd, C_YokinKbn pYokinKbn,
        String pKouzaNo, C_Kzdou pKzdou, String pKzMeiginMkn, C_Tuukasyu pTuukasyu, String pSeikyuusyanmkn,
        C_SeikyuusyaKbn pSeikyuusyaKbn, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 送金先情報チェック 開始");

        if (C_InputShrhousiteiKbn.BLNK.eq(pInputShrhousiteiKbn)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.ISHRHOUSITEIKBN_MINYUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
        else if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(pInputShrhousiteiKbn) ||
            C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(pInputShrhousiteiKbn)) {
            if (!BizUtil.isBlank(pBankCd) || !BizUtil.isBlank(pSitenCd) || !C_YokinKbn.BLNK.eq(pYokinKbn) ||
                !BizUtil.isBlank(pKouzaNo) || !BizUtil.isBlank(pKzMeiginMkn) || !C_Kzdou.BLNK.eq(pKzdou)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KRKKEIJYO_CHK);
                pChkKekkaBeanLst.add(chkKekkaBean);

            }
        }
        else if (C_InputShrhousiteiKbn.FBSOUKIN.eq(pInputShrhousiteiKbn)) {
            if (C_Tuukasyu.JPY.eq(pTuukasyu)) {
                if (BizUtil.isBlank(pBankCd)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.BANKCD_MINYUCHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);

                }
                if (BizUtil.isBlank(pSitenCd)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SITENCD_MINYUCHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);

                }
                if (C_YokinKbn.BLNK.eq(pYokinKbn)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.YOKINSYUMOKU_MINYUCHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);

                }
                if (BizUtil.isBlank(pKouzaNo)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KOUZANO_MINYUCHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);

                }
                if (C_Kzdou.BLNK.eq(pKzdou)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KZDOUKBN_MINYUCHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);

                }
                else if (C_Kzdou.SITEI.eq(pKzdou) && BizUtil.isBlank(pKzMeiginMkn)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KZMEIGINM_MINYUCHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);

                }
                else if (C_Kzdou.DOUITU.eq(pKzdou) && !BizUtil.isBlank(pKzMeiginMkn)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KZMEIGINM_INPUTCHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);

                }
                chkInputNaiyou(pTuukasyu, pInputShrhousiteiKbn, pBankCd, pSitenCd, pKouzaNo, pKzdou, pKzMeiginMkn,
                    pSeikyuusyanmkn, pChkKekkaBeanLst);

                if(IGkCommonKoumoku.BANKCD_YTGINKOU.equals(pBankCd) && !C_YokinKbn.HUTUU.eq(pYokinKbn) ){
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.YOKINSYUMOKU_YUUTYOCHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);

                }
            }
            else if (!C_Tuukasyu.JPY.eq(pTuukasyu)) {
                if (BizUtil.isBlank(pBankCd)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.BANKCD_MINYUCHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);

                }
                if (BizUtil.isBlank(pSitenCd)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SITENCD_MINYUCHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);

                }
                if (BizUtil.isBlank(pKouzaNo)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KOUZANO_MINYUCHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);

                }
                if (BizUtil.isBlank(pKzMeiginMkn)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KZMEIGINM_MINYUCHK_GAIKA);
                    pChkKekkaBeanLst.add(chkKekkaBean);

                }

                chkInputNaiyou(pTuukasyu, pInputShrhousiteiKbn, pBankCd, pSitenCd, pKouzaNo, pKzdou, pKzMeiginMkn,
                    pSeikyuusyanmkn, pChkKekkaBeanLst);

                if (!C_YokinKbn.BLNK.eq(pYokinKbn)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.YOKINSYUMOKU_INPUTCHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);

                }

            }

            if (C_SeikyuusyaKbn.KYKDAIRININ.eq(pSeikyuusyaKbn) && C_Kzdou.DOUITU.eq(pKzdou)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KYKDRKZDOUKBN_CHK);
                pChkKekkaBeanLst.add(chkKekkaBean);

            }

        }

        logger.debug("△ 送金先情報チェック 終了");
    }

    private void chkInputNaiyou(C_Tuukasyu pTuukasyu, C_InputShrhousiteiKbn pInputShrhousiteiKbn, String pBankCd,
        String pSitenCd, String pKouzaNo, C_Kzdou pKzdou, String pKzMeiginMkn, String pSeikyuusyanmkn,
        List<ChkKekkaBean> pChkKekkaBeanLst) {
        if (!BizUtil.isBlank(pBankCd) && !BizUtil.isBlank(pSitenCd)) {

            SetteiShrhousiteiKbn setteiShrhousiteiKbn = SWAKInjector.getInstance(SetteiShrhousiteiKbn.class);
            C_ShrhousiteiKbn shrhousiteiKbn = setteiShrhousiteiKbn.exec(pInputShrhousiteiKbn, pTuukasyu);

            BzShiharaiDenpyouDateShutoku bzShiharaiDenpyouDateShutoku = SWAKInjector
                .getInstance(BzShiharaiDenpyouDateShutoku.class);
            BizDate siharaiDenbyouHiduke = bzShiharaiDenpyouDateShutoku.exec(BizDate.getSysDate(), shrhousiteiKbn,
                pTuukasyu, pBankCd);

            BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
            BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(pBankCd, pSitenCd, siharaiDenbyouHiduke);
            if (C_BankmasterUmuKbn.NONE.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.GINKOUMST_UMUCHK);
                pChkKekkaBeanLst.add(chkKekkaBean);

            }
            if (C_BankYuuksHantKbn.NG.eq(bzGetBankDataBean.getBankYuuksHantKbn())) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KINYUKKN_YKCHK_SEYMD);
                pChkKekkaBeanLst.add(chkKekkaBean);
            }
            if (C_Tuukasyu.JPY.eq(pTuukasyu)) {
                if (C_EnkashrKahiKbn.HUKA.eq(bzGetBankDataBean.getEnkashrKahiKbn())) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KINYUKKN_YKCHK_NAIKOKU);
                    pChkKekkaBeanLst.add(chkKekkaBean);
                }
            }
            else{
                if (C_GaikashrKahiKbn.HUKA.eq(bzGetBankDataBean.getGaikashrKahiKbn())) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KINYUKKN_YKCHK_GSENM);
                    pChkKekkaBeanLst.add(chkKekkaBean);
                }
            }
        }
        if (!BizUtil.isBlank(pKouzaNo)) {

            CheckKouzaNo kouzaNoChk = SWAKInjector.getInstance(CheckKouzaNo.class);
            boolean kyokaMojiKetukaChk = kouzaNoChk.isCheckOK(pKouzaNo, pTuukasyu);
            if (!kyokaMojiKetukaChk) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KOUZANO_KYOKAMOJICHK);
                pChkKekkaBeanLst.add(chkKekkaBean);

            }

            boolean ketasuuKetukaChk = kouzaNoChk.isKyoyouKeta(pKouzaNo, pTuukasyu);
            if (!ketasuuKetukaChk) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KOUZANO_KETACHK);
                pChkKekkaBeanLst.add(chkKekkaBean);

            }

        }

        if (!BizUtil.isBlank(pKzMeiginMkn)) {
            boolean tuuKetukaChk = CheckMeigininNmKana.isCheckOK_Tuuka(pKzMeiginMkn, pTuukasyu);

            if (!tuuKetukaChk) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KZMEIGINM_KYOKAMOJICHK);
                pChkKekkaBeanLst.add(chkKekkaBean);
            }

            boolean kouzaMeiginYouKenkakuChk = CheckKana.isKyoyouKetaHankaku_Kouza(pKzMeiginMkn);
            if (!kouzaMeiginYouKenkakuChk) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KZMEIGINM_KETACHK);
                pChkKekkaBeanLst.add(chkKekkaBean);

            }
        }

        if (!BizUtil.isBlank(pSeikyuusyanmkn)) {
            if (C_Kzdou.DOUITU.eq(pKzdou)) {
                if (C_Tuukasyu.JPY.eq(pTuukasyu)) {
                    boolean meigininNmKanaChk = CheckMeigininNmKana.isCheckOK(pSeikyuusyanmkn, C_Kojinhjn.KOJIN);
                    if (!meigininNmKanaChk) {
                        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKANA_MEIGINMKNCHK);
                        pChkKekkaBeanLst.add(chkKekkaBean);
                    } else {
                        boolean tuuKetukaChk = CheckMeigininNmKana.isCheckOK_Tuuka(pSeikyuusyanmkn, pTuukasyu);

                        if (!tuuKetukaChk) {
                            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKANA_MEIGINMKNCHK);
                            pChkKekkaBeanLst.add(chkKekkaBean);
                        }
                    }
                } else {
                    boolean tuuKetukaChk = CheckMeigininNmKana.isCheckOK_Tuuka(pSeikyuusyanmkn, pTuukasyu);

                    if (!tuuKetukaChk) {
                        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKANA_MEIGINMKNCHK);
                        pChkKekkaBeanLst.add(chkKekkaBean);
                    }
                }

                boolean kouzaMeiginYouKenkakuChk = CheckKana.isKyoyouKetaHankaku_Kouza(pSeikyuusyanmkn);
                if (!kouzaMeiginYouKenkakuChk) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKANA_KETACHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);
                }

            }
        }

    }

}
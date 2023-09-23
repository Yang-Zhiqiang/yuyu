package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckMeigininNmKana;
import yuyu.common.siharai.sicommon.KykCommonHantei;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiUkt;

/**
 * 保険金給付金支払 請求内容チェック 請求者情報チェック
 */
public class ChkSubSksyaInfo {

    @Inject
    private static Logger logger;

    public ChkSubSksyaInfo() {
        super();
    }

    public boolean exec(C_SeikyuusyaKbn pSeikyuusyaKbn, String pSeikyuusyaNmkn, String pSeikyuusyaNmkj,
        BizDate pSeikyuusyaSeiYmd, C_Seibetu pSeikyuusyaSei, C_SeikyuuSyubetu pSeikyuuSyubetu,
        JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 請求者情報チェック 開始");

        boolean isCheckMeigininNmKana = true;

        if (C_SeikyuusyaKbn.BLNK.eq(pSeikyuusyaKbn)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
        else {
            int sbUktsuu = pSiKykKihon.getSbuktnin();
            String sbUktnmKn = "";
            C_UktKbn uktKbn = C_UktKbn.BLNK;
            for (JT_SiUkt siUkt : pSiKykKihon.getSiUkts()) {
                if (C_Hkuktsyu.SBHKKUKT.eq(siUkt.getHkuktsyu())
                    || C_Hkuktsyu.SBKYFKUKT.eq(siUkt.getHkuktsyu())) {
                    sbUktnmKn = siUkt.getUktnmkn();
                    uktKbn = siUkt.getUktkbn();
                }
            }
            if (C_SeikyuusyaKbn.UKTHONNIN.eq(pSeikyuusyaKbn)) {
                chkSksinfoUmu(pSeikyuuSyubetu, pSeikyuusyaKbn, sbUktsuu, pSiKykKihon, pChkKekkaBeanLst);
                chkSksinfoKanaUmu(pSeikyuuSyubetu,sbUktsuu, sbUktnmKn, pChkKekkaBeanLst);
                chkSksinfoSei(pSeikyuusyaSei, pChkKekkaBeanLst);
                chkSksinfoHukusuu(sbUktsuu, pSiKykKihon, pChkKekkaBeanLst);
                chkSksyaSeibetuKyk(uktKbn, pSeikyuusyaSei, pSiKykKihon.getKyksei(), pChkKekkaBeanLst);
            }
            else if (C_SeikyuusyaKbn.STDR.eq(pSeikyuusyaKbn)) {
                chkSksinfoUmu(pSeikyuuSyubetu, pSeikyuusyaKbn, sbUktsuu, pSiKykKihon, pChkKekkaBeanLst);
                chkSksinfoSei(pSeikyuusyaSei, pChkKekkaBeanLst);
                chkSksinfoSiteiKanaUmu(pSiKykKihon, pChkKekkaBeanLst);
            }
            else if (C_SeikyuusyaKbn.UKTDAIHYOU.eq(pSeikyuusyaKbn)
                || C_SeikyuusyaKbn.SONOTA.eq(pSeikyuusyaKbn)) {
                chkSksKana(pSeikyuusyaNmkn, pChkKekkaBeanLst);
                chkSksKanji(pSeikyuusyaNmkj, pChkKekkaBeanLst);
                isCheckMeigininNmKana = chkSksMeigin(pSeikyuusyaNmkn, pChkKekkaBeanLst);
                chkSksSeiymd(pSeikyuusyaSeiYmd, pChkKekkaBeanLst);
                chkSksSeiymdSakihiduke(pSeikyuusyaSeiYmd, pChkKekkaBeanLst);
                chkSksSei(pSeikyuusyaSei, pChkKekkaBeanLst);
            }
            else if (C_SeikyuusyaKbn.KYKDAIRININ.eq(pSeikyuusyaKbn)) {
                chkSksKykdrtkykhuka(pSiKykKihon, pChkKekkaBeanLst);
                chkSksKeiukedou(pSiKykKihon, pChkKekkaBeanLst);
            }
        }

        logger.debug("△ 請求者情報チェック 終了");

        return isCheckMeigininNmKana;
    }

    private void chkSksKana(String pSeikyuusyaNmkn, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (BizUtil.isBlank(pSeikyuusyaNmkn)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkSksKanji(String pSeikyuusyaNmkj, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (BizUtil.isBlank(pSeikyuusyaNmkj)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private boolean chkSksMeigin(String pSeikyuusyaNmkn, List<ChkKekkaBean> pChkKekkaBeanLst) {

        boolean isCheckMeigininNmKana = true;
        if (!BizUtil.isBlank(pSeikyuusyaNmkn)) {

            Boolean result = CheckMeigininNmKana.isCheckOK(
                pSeikyuusyaNmkn, C_Kojinhjn.KOJIN, YuyuBizConfig.getInstance().getKanaNmKyoyou());

            if (result == false) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK);
                pChkKekkaBeanLst.add(chkKekkaBean);
            }
            isCheckMeigininNmKana = result;
        }
        return isCheckMeigininNmKana;
    }

    private void chkSksSeiymd(BizDate pSeikyuusyaSeiYmd, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (pSeikyuusyaSeiYmd == null) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIYMD_MINYUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkSksSeiymdSakihiduke(BizDate pSeikyuusyaSeiYmd, List<ChkKekkaBean> pChkKekkaBeanLst) {

        BizDate sysYmd = BizDate.getSysDate();

        if (BizDateUtil.compareYmd(sysYmd, pSeikyuusyaSeiYmd) == BizDateUtil.COMPARE_LESSER) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIYMD_SAKICHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkSksSei(C_Seibetu pSeikyuusyaSei, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (C_Seibetu.BLNK.eq(pSeikyuusyaSei)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIBETU_MINYUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkSksinfoUmu(C_SeikyuuSyubetu pSeikyuuSyubetu, C_SeikyuusyaKbn pSeikyuusyaKbn,
        int pSbuktsuu, JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (C_SeikyuuSyubetu.SB.eq(pSeikyuuSyubetu)) {
            if (pSbuktsuu == 0) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAINFO_UMUCHK);
                chkKekkaBean.setMsgHikisuu2(C_SeikyuusyaKbn.UKTHONNIN.getContent());
                pChkKekkaBeanLst.add(chkKekkaBean);
            }
        }
        else if (C_SeikyuuSyubetu.KOUSG.eq(pSeikyuuSyubetu)) {
            if (C_SeikyuusyaKbn.STDR.eq(pSeikyuusyaKbn)) {
                if (C_UmuKbn.NONE.eq(pSiKykKihon.getStdrsktkyhkumu())) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAINFO_UMUCHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);
                }
            }
        }
    }

    private void chkSksinfoKanaUmu(C_SeikyuuSyubetu pSeikyuuSyubetu, int pSbuktsuu,
        String pSbUktnmKn, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (C_SeikyuuSyubetu.SB.eq(pSeikyuuSyubetu)) {

            if (pSbuktsuu == 1) {
                if (BizUtil.isBlank(pSbUktnmKn)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKANA_UMUCHK_HONNIN);
                    chkKekkaBean.setMsgHikisuu2(C_SeikyuusyaKbn.UKTHONNIN.getContent());
                    pChkKekkaBeanLst.add(chkKekkaBean);
                }
            }
        }
    }

    private void chkSksinfoSei(C_Seibetu pSeikyuusyaSei, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (C_Seibetu.BLNK.eq(pSeikyuusyaSei)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYASEIBETU_MINYUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkSksinfoHukusuu(int pSbuktsuu, JT_SiKykKihon pSiKykKihon,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (pSbuktsuu > 1) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYA_HUKUSUUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkSksyaSeibetuKyk(C_UktKbn pUktkbn, C_Seibetu pSeikyuusyaSei, C_Kyksei pKyksei,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (C_UktKbn.KYK.eq(pUktkbn)) {
            if (C_Seibetu.MALE.eq(pSeikyuusyaSei)) {
                if (!C_Kyksei.MALE.eq(pKyksei)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYASEIBETU_KYKCHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);
                }
            }

            if (C_Seibetu.FEMALE.eq(pSeikyuusyaSei)) {
                if (!C_Kyksei.FEMALE.eq(pKyksei)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYASEIBETU_KYKCHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);
                }
            }

            if (C_Seibetu.HJN.eq(pSeikyuusyaSei)) {
                if (!C_Kyksei.HJNKYK.eq(pKyksei)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYASEIBETU_KYKCHK);
                    pChkKekkaBeanLst.add(chkKekkaBean);
                }
            }
        }

    }

    private void chkSksinfoSiteiKanaUmu(JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (BizUtil.isBlank(pSiKykKihon.getSiteidruktnmkn())) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKANA_UMUCHK_SITEIDR);
            chkKekkaBean.setMsgHikisuu2(C_SeikyuusyaKbn.STDR.getContent());
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkSksKykdrtkykhuka(JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        KykCommonHantei kykCommonHantei = SWAKInjector.getInstance(KykCommonHantei.class);

        boolean chkFlag = kykCommonHantei.chkKykdrtkykumu(pSiKykKihon);

        if (!chkFlag) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KYKDRTKYKHUKA_CHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkSksKeiukedou(JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        KykCommonHantei kykCommonHantei = SWAKInjector.getInstance(KykCommonHantei.class);

        boolean chkFlag = kykCommonHantei.chkKeiukedou(pSiKykKihon);

        if (!chkFlag) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KEIUKEDOU_CHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

}
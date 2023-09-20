package yuyu.common.suuri.srcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KykKihonTokuteiJitenKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean;

/**
 * 数理 数理共通 特定時点契約基本情報取得
 */
public class SrGetTokutejitenKykKihonInfo {

    @Inject
    private static Logger logger;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    private static final String KOUMOKUID_TIKIKTBRISYURUIKBN = "tikiktbrisyuruikbn";

    private static final String KOUMOKUID_HRKKEIRO = "hrkkeiro";

    private static final String KOUMOKUID_HRKKAISUU = "hrkkaisuu";

    private static final String KUGIRIMOJI_DOTTO = "\\.";

    private static final String EDABAN1 = "_1";

    private static final String EDABAN2 = "_2";

    public SrGetTokutejitenKykKihonInfoBean exec(
        C_KykKihonTokuteiJitenKbn pKykKihonTokuteiJitenKbn,
        String pSyono,
        BizDate pKijyunYmd,
        String pHenkousikibetukey,
        List<SV_KiykSyuhnData> pKiykSyuhnData,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn,
        C_Hrkkeiro pHrkkeiro,
        C_Hrkkaisuu pHrkkaisuu) {

        logger.debug("▽ 特定時点契約基本情報取得 開始");

        List<String> koumokuteigiLst = null;
        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean =
            SWAKInjector.getInstance(SrGetTokutejitenKykKihonInfoBean.class);

        srGetTokutejitenKykKihonInfoBean.setTikiktbrisyuruiKbnMae(pTikiktbrisyuruikbn);
        srGetTokutejitenKykKihonInfoBean.setTikiktbrisyuruiKbnAto(pTikiktbrisyuruikbn);
        srGetTokutejitenKykKihonInfoBean.setHrkkeiroMae(pHrkkeiro);
        srGetTokutejitenKykKihonInfoBean.setHrkkeiroAto(pHrkkeiro);
        srGetTokutejitenKykKihonInfoBean.setHrkkaisuuMae(pHrkkaisuu);
        srGetTokutejitenKykKihonInfoBean.setHrkkaisuuAto(pHrkkaisuu);

        if (C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN.eq(pKykKihonTokuteiJitenKbn)) {

            koumokuteigiLst = SrGetTokutejitenKykKihonInfoModeManage.modeManageMap.get(pKykKihonTokuteiJitenKbn.getValue());

            getTokutejitenKykKihonInfoKijyunymdJiten(pSyono, pKijyunYmd, pHenkousikibetukey,
                pKiykSyuhnData, pTikiktbrisyuruikbn, pHrkkeiro, pHrkkaisuu, koumokuteigiLst, srGetTokutejitenKykKihonInfoBean);
        }
        else if (C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_TEIKIIKKATUHNARI.eq(pKykKihonTokuteiJitenKbn)) {

            koumokuteigiLst = SrGetTokutejitenKykKihonInfoModeManage.modeManageMap.get(pKykKihonTokuteiJitenKbn.getValue());

            getTokutejitenKykKihonInfoHenkouZengo(pSyono, pHenkousikibetukey,
                koumokuteigiLst, srGetTokutejitenKykKihonInfoBean);
        }
        else if (C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_TEIKIIKKATUHNNASI.eq(pKykKihonTokuteiJitenKbn)) {

            koumokuteigiLst = SrGetTokutejitenKykKihonInfoModeManage.modeManageMap.get(pKykKihonTokuteiJitenKbn.getValue()
                + EDABAN1);

            getTokutejitenKykKihonInfoKijyunymdJiten(pSyono, pKijyunYmd, pHenkousikibetukey,
                pKiykSyuhnData, pTikiktbrisyuruikbn, pHrkkeiro, pHrkkaisuu, koumokuteigiLst, srGetTokutejitenKykKihonInfoBean);

            koumokuteigiLst = SrGetTokutejitenKykKihonInfoModeManage.modeManageMap.get(pKykKihonTokuteiJitenKbn.getValue()
                + EDABAN2);

            getTokutejitenKykKihonInfoHenkouZengo(pSyono, pHenkousikibetukey,
                koumokuteigiLst, srGetTokutejitenKykKihonInfoBean);
        }
        else if (C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNNASI_KAISUUHNARI.eq(pKykKihonTokuteiJitenKbn)) {

            koumokuteigiLst = SrGetTokutejitenKykKihonInfoModeManage.modeManageMap.get(pKykKihonTokuteiJitenKbn.getValue()
                + EDABAN1);

            getTokutejitenKykKihonInfoKijyunymdJiten(pSyono, pKijyunYmd, pHenkousikibetukey,
                pKiykSyuhnData, pTikiktbrisyuruikbn, pHrkkeiro, pHrkkaisuu, koumokuteigiLst, srGetTokutejitenKykKihonInfoBean);

            koumokuteigiLst = SrGetTokutejitenKykKihonInfoModeManage.modeManageMap.get(pKykKihonTokuteiJitenKbn.getValue()
                + EDABAN2);

            getTokutejitenKykKihonInfoHenkouZengo(pSyono, pHenkousikibetukey,
                koumokuteigiLst, srGetTokutejitenKykKihonInfoBean);
        }

        else if (C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_KAISUUHNNASI.eq(pKykKihonTokuteiJitenKbn)) {

            koumokuteigiLst = SrGetTokutejitenKykKihonInfoModeManage.modeManageMap.get(pKykKihonTokuteiJitenKbn.getValue()
                + EDABAN1);

            getTokutejitenKykKihonInfoKijyunymdJiten(pSyono, pKijyunYmd, pHenkousikibetukey,
                pKiykSyuhnData, pTikiktbrisyuruikbn, pHrkkeiro, pHrkkaisuu, koumokuteigiLst, srGetTokutejitenKykKihonInfoBean);

            koumokuteigiLst = SrGetTokutejitenKykKihonInfoModeManage.modeManageMap.get(pKykKihonTokuteiJitenKbn.getValue()
                + EDABAN2);

            getTokutejitenKykKihonInfoHenkouZengo(pSyono, pHenkousikibetukey,
                koumokuteigiLst, srGetTokutejitenKykKihonInfoBean);
        }

        logger.debug("△ 特定時点契約基本情報取得 終了");

        return srGetTokutejitenKykKihonInfoBean;
    }
    private void getTokutejitenKykKihonInfoKijyunymdJiten(
        String pSyono,
        BizDate pKijyunYmd,
        String pHenkousikibetukey,
        List<SV_KiykSyuhnData> pKiykSyuhnData,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn,
        C_Hrkkeiro pHrkkeiro,
        C_Hrkkaisuu pHrkkaisuu,
        List<String> pKoumokuteigiLst,
        SrGetTokutejitenKykKihonInfoBean pSrGetTokutejitenKykKihonInfoBean){

        String targetHenkouSikibetuKey = null;
        BizDate targetYmd = null;
        C_TkiktbrisyuruiKbn tikiktbrisyuruiKbn = pTikiktbrisyuruikbn;
        C_Hrkkeiro hrkkeiro = pHrkkeiro;
        C_Hrkkaisuu hrkkaisuu = pHrkkaisuu;
        String[] searchstrtk = null;
        String tableNmstr = "";
        String columnNmstr = "";


        for (String mokuteigi : pKoumokuteigiLst) {

            searchstrtk = mokuteigi.split(KUGIRIMOJI_DOTTO);
            tableNmstr = searchstrtk[0];
            columnNmstr = searchstrtk[1];

            targetYmd = null;

            for (SV_KiykSyuhnData kiyksyuhnentity : pKiykSyuhnData) {

                BizDate kouryokuHasseiYmd = null;

                if (IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU.equals(kiyksyuhnentity.getGyoumuKousinKinou())) {

                    targetHenkouSikibetuKey = kiyksyuhnentity.getHenkousikibetukey();
                    kouryokuHasseiYmd = kiyksyuhnentity.getKouryokuhasseiymd();
                }
                else {
                    continue;
                }

                if (BizDateUtil.compareYmd(pKijyunYmd, kouryokuHasseiYmd) == BizDateUtil.COMPARE_LESSER &&
                    (targetYmd == null || BizDateUtil.compareYmd(kouryokuHasseiYmd, targetYmd) == BizDateUtil.COMPARE_EQUAL
                    || BizDateUtil.compareYmd(kouryokuHasseiYmd, targetYmd) == BizDateUtil.COMPARE_LESSER)) {

                    targetYmd = kouryokuHasseiYmd;

                    List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> khHenkouRirekiLst =
                        srCommonKinouDao.getKhHenkouRirekis(pSyono, targetHenkouSikibetuKey, tableNmstr, columnNmstr);

                    if (khHenkouRirekiLst.size() > 0) {

                        if (KOUMOKUID_TIKIKTBRISYURUIKBN.equals(columnNmstr)) {

                            tikiktbrisyuruiKbn = C_TkiktbrisyuruiKbn.valueOf(khHenkouRirekiLst.get(0).getBfrnaiyouoriginal());
                        }
                        else if (KOUMOKUID_HRKKEIRO.equals(columnNmstr)) {

                            hrkkeiro = C_Hrkkeiro.valueOf(khHenkouRirekiLst.get(0).getBfrnaiyouoriginal());
                        }
                        else if (KOUMOKUID_HRKKAISUU.equals(columnNmstr)) {

                            hrkkaisuu = C_Hrkkaisuu.valueOf(khHenkouRirekiLst.get(0).getBfrnaiyouoriginal());
                        }
                    }
                }

                else if (BizDateUtil.compareYmd(pKijyunYmd, kouryokuHasseiYmd) == BizDateUtil.COMPARE_EQUAL) {

                    if (pHenkousikibetukey == null) {

                        break;
                    }
                    if (pHenkousikibetukey.compareTo(targetHenkouSikibetuKey) < 0) {

                        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> khHenkouRirekiLst =
                            srCommonKinouDao.getKhHenkouRirekis(pSyono, targetHenkouSikibetuKey, tableNmstr, columnNmstr);

                        if (khHenkouRirekiLst.size() > 0) {

                            if (KOUMOKUID_TIKIKTBRISYURUIKBN.equals(columnNmstr)) {

                                tikiktbrisyuruiKbn = C_TkiktbrisyuruiKbn.valueOf(khHenkouRirekiLst.get(0).getBfrnaiyouoriginal());
                            }
                            else if (KOUMOKUID_HRKKEIRO.equals(columnNmstr)) {

                                hrkkeiro = C_Hrkkeiro.valueOf(khHenkouRirekiLst.get(0).getBfrnaiyouoriginal());
                            }
                            else if (KOUMOKUID_HRKKAISUU.equals(columnNmstr)) {

                                hrkkaisuu = C_Hrkkaisuu.valueOf(khHenkouRirekiLst.get(0).getBfrnaiyouoriginal());
                            }
                        }
                    }
                }
                else {
                    break;
                }
            }
        }

        pSrGetTokutejitenKykKihonInfoBean.setTikiktbrisyuruiKbnMae(tikiktbrisyuruiKbn);
        pSrGetTokutejitenKykKihonInfoBean.setTikiktbrisyuruiKbnAto(tikiktbrisyuruiKbn);
        pSrGetTokutejitenKykKihonInfoBean.setHrkkeiroMae(hrkkeiro);
        pSrGetTokutejitenKykKihonInfoBean.setHrkkeiroAto(hrkkeiro);
        pSrGetTokutejitenKykKihonInfoBean.setHrkkaisuuMae(hrkkaisuu);
        pSrGetTokutejitenKykKihonInfoBean.setHrkkaisuuAto(hrkkaisuu);
    }

    private void getTokutejitenKykKihonInfoHenkouZengo( String pSyono,
        String pHenkousikibetukey,
        List<String> pKoumokuteigiLst,
        SrGetTokutejitenKykKihonInfoBean pSrGetTokutejitenKykKihonInfoBean){

        String searchstrtk[] = null;
        String tablenNmstr = "";
        String columnNmstr = "";

        for (String mokuteigi : pKoumokuteigiLst) {

            searchstrtk = mokuteigi.split(KUGIRIMOJI_DOTTO);
            tablenNmstr = searchstrtk[0];
            columnNmstr = searchstrtk[1];

            List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> khHenkouRirekiLst =
                srCommonKinouDao.getKhHenkouRirekis(pSyono, pHenkousikibetukey, tablenNmstr, columnNmstr);

            if (khHenkouRirekiLst.size() > 0) {

                if (KOUMOKUID_TIKIKTBRISYURUIKBN.equals(columnNmstr)) {

                    pSrGetTokutejitenKykKihonInfoBean.setTikiktbrisyuruiKbnMae(C_TkiktbrisyuruiKbn
                        .valueOf(khHenkouRirekiLst.get(0).getBfrnaiyouoriginal()));

                    pSrGetTokutejitenKykKihonInfoBean.setTikiktbrisyuruiKbnAto(C_TkiktbrisyuruiKbn
                        .valueOf(khHenkouRirekiLst.get(0).getNewnaiyouoriginal()));
                }
                else if (KOUMOKUID_HRKKEIRO.equals(columnNmstr)) {

                    pSrGetTokutejitenKykKihonInfoBean.setHrkkeiroMae(C_Hrkkeiro.valueOf(khHenkouRirekiLst.get(0)
                        .getBfrnaiyouoriginal()));

                    pSrGetTokutejitenKykKihonInfoBean.setHrkkeiroAto(C_Hrkkeiro.valueOf(khHenkouRirekiLst.get(0)
                        .getNewnaiyouoriginal()));
                }
                else if (KOUMOKUID_HRKKAISUU.equals(columnNmstr)) {

                    pSrGetTokutejitenKykKihonInfoBean.setHrkkaisuuMae(C_Hrkkaisuu.valueOf(khHenkouRirekiLst.get(0)
                        .getBfrnaiyouoriginal()));

                    pSrGetTokutejitenKykKihonInfoBean.setHrkkaisuuAto(C_Hrkkaisuu.valueOf(khHenkouRirekiLst.get(0)
                        .getNewnaiyouoriginal()));
                }
            }
        }
    }
}

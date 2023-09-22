package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.hozen.khcommon.CheckKzhuriKouza;
import yuyu.common.sinkeiyaku.skcommon.CheckShiharaikinSiteiKouza;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_KzmeigitknKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhou;

/**
 * 新契約 申込内容チェック 口座情報TBLチェック
 */
public class CheckTblKouzaJyouhou {


    private final static String MSG_KZHURITOUROKUHOUKBN = "口座振替登録方法";

    private final static String MSG_UKTRKZ_KZSYURUIKBN = "定期支払金支払通貨";

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckTblKouzaJyouhou() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 口座情報テーブルチェック 開始");
        }
        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        String mosNo = syoriCTL.getMosno();

        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();

        boolean hrkkeiroSeitouseiHanteiKekka = checkTblKouzaJyouhouKeiro(pMP, syoriCTL);

        if (hrkkeiroSeitouseiHanteiKekka && kouzaJyouhou != null) {
            if (C_UmuKbn.ARI.eq(syoriCTL.getKznrkumu())) {
                HT_MosKihon mosKihon = pMP.getDataSyoriControl().getMosKihon();
                C_KykKbn kykKbn = mosKihon.getKykkbn();
                String kyknmkn = "";

                if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {
                    kyknmkn = mosKihon.getKyknmkn();
                }
                else {
                    kyknmkn = mosKihon.getHhknnmkn();
                }

                CheckKzhuriKouza checkKzhuriKouza = SWAKInjector.getInstance(CheckKzhuriKouza.class);
                C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;
                if (C_KzkykdouKbn.DOUITU.eq(kouzaJyouhou.getKzkykdoukbn())) {
                    errorKbn = checkKzhuriKouza.exec(kouzaJyouhou.getBankcd(),
                        kouzaJyouhou.getSitencd(),
                        kouzaJyouhou.getYokinkbn(),
                        kouzaJyouhou.getKzkykdoukbn(),
                        kyknmkn,
                        kouzaJyouhou.getKzmeiginmkn(),
                        kouzaJyouhou.getKouzano(),
                        pMP.getSysDate());
                }
                else {
                    errorKbn = checkKzhuriKouza.exec(kouzaJyouhou.getBankcd(),
                        kouzaJyouhou.getSitencd(),
                        kouzaJyouhou.getYokinkbn(),
                        kouzaJyouhou.getKzkykdoukbn(),
                        "",
                        kouzaJyouhou.getKzmeiginmkn(),
                        kouzaJyouhou.getKouzano(),
                        pMP.getSysDate());
                }
                List<Integer> errorCdlst = checkKzhuriKouza.getErrorCdlst();

                checkTblKouzaJyouhou(pMP, kouzaJyouhou, errorKbn, errorCdlst);
                checkYuukouKouzaJyouhou(pMP, syoriCTL, kouzaJyouhou, errorKbn, errorCdlst, kyknmkn);
            }

        }

        HT_UketoriKouzaJyouhou uketoriKouzaJyouhou =
            syoriCTL.getUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);

        HT_MosKihon moskihon = syoriCTL.getMosKihon();
        String uketorikouzakyknmkn = "";

        if (uketoriKouzaJyouhou != null) {
            if (C_KykKbn.KEIHI_BETU.eq(moskihon.getKykkbn())) {
                uketorikouzakyknmkn = moskihon.getKyknmkn();
            }
            else {
                uketorikouzakyknmkn = moskihon.getHhknnmkn();
            }
        }

        CheckShiharaikinSiteiKouza checkShiharaikinSiteiKouza = SWAKInjector.getInstance(CheckShiharaikinSiteiKouza.class);

        if (uketoriKouzaJyouhou == null) {

            uketoriKouzaJyouhou = new HT_UketoriKouzaJyouhou();
            uketoriKouzaJyouhou.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
            uketoriKouzaJyouhou.setBankcd("");
            uketoriKouzaJyouhou.setSitencd("");
            uketoriKouzaJyouhou.setYokinkbn(C_YokinKbn.BLNK);
            uketoriKouzaJyouhou.setKouzano("");
            uketoriKouzaJyouhou.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
            uketoriKouzaJyouhou.setKzmeiginmkn("");
        }

        C_ErrorKbn errorkbn = checkShiharaikinSiteiKouza.exec(
            moskihon.getTeikisiharaitkykhkkbn(),
            uketoriKouzaJyouhou.getKzsyuruikbn(),
            uketoriKouzaJyouhou.getBankcd(),
            uketoriKouzaJyouhou.getSitencd(),
            uketoriKouzaJyouhou.getYokinkbn(),
            uketoriKouzaJyouhou.getKouzano(),
            uketoriKouzaJyouhou.getKzkykdoukbn(),
            uketorikouzakyknmkn,
            uketoriKouzaJyouhou.getKzmeiginmkn(),
            pMP.getSysDate());

        List<Integer> errorcdlst = checkShiharaikinSiteiKouza.getErrorCdList();

        if (!C_ErrorKbn.OK.eq(errorkbn)) {

            outputHubiCheckUketoriKouza(pMP, syoriCTL, moskihon, uketoriKouzaJyouhou, errorcdlst);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 口座情報テーブルチェック 終了");
        }
    }

    private boolean checkTblKouzaJyouhouKeiro(MosnaiCheckParam pMP, HT_SyoriCTL pSyoriCTL) {
        HT_MosKihon mosKihon = pSyoriCTL.getMosKihon();
        boolean hanteiKekka = true;

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getKznrkumu())) {
            if (!C_Hrkkeiro.KOUHURI.eq(mosKihon.getHrkkeiro())) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1101, MessageId.EHC1101),
                    pMP);
                hanteiKekka = false;
            }
        }
        else {
            if (C_Hrkkeiro.KOUHURI.eq(mosKihon.getHrkkeiro())) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1102, MessageId.EHC1102),
                    pMP);
                hanteiKekka = false;
            }
        }

        return hanteiKekka;
    }

    private void checkTblKouzaJyouhou(MosnaiCheckParam pMP, HT_KouzaJyouhou pKouzaJyouHou, C_ErrorKbn pErrorKbn,
        List<Integer> pErrorCdlst) {

        if (C_ErrorKbn.ERROR.eq(pErrorKbn)) {
            if (pErrorCdlst.contains(CheckKzhuriKouza.BANKCD_NRK_ERROR)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC1092, MessageId.EHC1092, ICommonKoumoku.DISP_S_BANKCD), pMP);
            }
            if (pErrorCdlst.contains(CheckKzhuriKouza.SITENCD_NRK_ERROR)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC1092, MessageId.EHC1092, ICommonKoumoku.DISP_S_SITENCD), pMP);
            }
            if (pErrorCdlst.contains(CheckKzhuriKouza.BFRYOKIN_MINRYK_ERROR)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC1092, MessageId.EHC1092, ICommonKoumoku.DISP_S_YOKINSYUMOKU), pMP);
            }
            if (pErrorCdlst.contains(CheckKzhuriKouza.KOUZANO_MNYRYK_ERROR)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC1092, MessageId.EHC1092, ICommonKoumoku.DISP_S_KOUZANO), pMP);
            }
            if (pErrorCdlst.contains(CheckKzhuriKouza.KZKYK_DOUKBNMINYURYK_ERROR)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC1092, MessageId.EHC1092, ICommonKoumoku.DISP_N_KZDOU), pMP);
            }
            if (pErrorCdlst.contains(CheckKzhuriKouza.KZMEIGINMKN_MNYRYKU_ERROR)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC1092, MessageId.EHC1092, ICommonKoumoku.DISP_S_KZMEIGINMEI), pMP);
            }
            if (pErrorCdlst.contains(CheckKzhuriKouza.KZMEIGINMK_NNYRYKU_ERROR)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC1093, MessageId.EHC1093, ICommonKoumoku.DISP_S_KZMEIGINMEI), pMP);
            }
        }
        if (C_YouhiblnkKbn.BLNK.eq(pKouzaJyouHou.getKouzakakuniniraikbn())) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                MakeHubiMsg.exec(MessageId.EHC1092, MessageId.EHC1092, ICommonKoumoku.DISP_N_CSSKAKUNINIRAIKBN), pMP);
        }
    }

    private void checkYuukouKouzaJyouhou(MosnaiCheckParam pMP, HT_SyoriCTL pSyoriCTL, HT_KouzaJyouhou pKouzaJyouHou,
        C_ErrorKbn pErrorKbn, List<Integer> pErrorCdlst, String pKyknmkn) {

        HT_MosKihon syoriCTL = pSyoriCTL.getMosKihon();
        String bankcd = pKouzaJyouHou.getBankcd();
        String hrkmSitencd = pKouzaJyouHou.getSitencd();
        C_KzkykdouKbn kzkykdoukbn = pKouzaJyouHou.getKzkykdoukbn();
        C_KykKbn kykkbn = syoriCTL.getKykkbn();
        String kzmeiginmkn = pKouzaJyouHou.getKzmeiginmkn();
        C_YouhiblnkKbn kouzaKakuninIraiKbn = pKouzaJyouHou.getKouzakakuniniraikbn();
        C_KzhuritourokuhouKbn kzhuritourokuhouKbn = pKouzaJyouHou.getKzhuritourokuhoukbn();
        C_Syuudaikocd  syuuDaiKocd  = pKouzaJyouHou.getSyuudaikocd();

        if (C_ErrorKbn.ERROR.eq(pErrorKbn)) {
            if (pErrorCdlst.contains(CheckKzhuriKouza.BANKMASTER_SNZCHK_ERROR)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC1094, MessageId.EHC1094, bankcd, hrkmSitencd), pMP);
            }

            if (pErrorCdlst.contains(CheckKzhuriKouza.BANKYUUKOU_HANTEICHK_ERROR)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC1077, MessageId.EHC1077, bankcd, hrkmSitencd), pMP);

            }

            if (pErrorCdlst.contains(CheckKzhuriKouza.YOFURIKYOUTEI_CHK_ERROR)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC1078, MessageId.EHC1078, bankcd, hrkmSitencd), pMP);

            }

            if (pErrorCdlst.contains(CheckKzhuriKouza.KOUZANO_KYOKAMONJICHK_ERROR)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC1096, MessageId.EHC1096, ICommonKoumoku.DISP_S_KOUZANO), pMP);

            }
            if (pErrorCdlst.contains(CheckKzhuriKouza.KOUZANO_KETASUCHK_ERROR)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC1097, MessageId.EHC1097, ICommonKoumoku.DISP_S_KOUZANO), pMP);

            }

            if (!C_KzkykdouKbn.DOUITU.eq(kzkykdoukbn)) {
                if (pErrorCdlst.contains(CheckKzhuriKouza.KZMEIGINMKN_KYOKAMONJICHK_ERROR)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                        MakeHubiMsg.exec(MessageId.EHC1096, MessageId.EHC1096, ICommonKoumoku.DISP_S_KZMEIGINMEI), pMP);

                }
                if (pErrorCdlst.contains(CheckKzhuriKouza.KZMEIGINMKN_KETASUUCHK_ERROR)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                        MakeHubiMsg.exec(MessageId.EHC1097, MessageId.EHC1097, ICommonKoumoku.DISP_S_KZMEIGINMEI), pMP);

                }
            }
            else if (C_KzkykdouKbn.DOUITU.eq(kzkykdoukbn)) {
                if (C_KykKbn.KEIHI_BETU.eq(kykkbn)) {
                    if (pErrorCdlst.contains(CheckKzhuriKouza.KZMEIGINMKN_KYOKAMONJICHK_ERROR)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                            MakeHubiMsg.exec(MessageId.EHC1079, MessageId.EHC1079, ICommonKoumoku.DISP_S_KYKNMKN), pMP);
                    }
                    if (pErrorCdlst.contains(CheckKzhuriKouza.KZMEIGINMKN_KETASUUCHK_ERROR)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                            MakeHubiMsg.exec(MessageId.EHC1080, MessageId.EHC1080, ICommonKoumoku.DISP_S_KYKNMKN), pMP);
                    }
                }
                else if (C_KykKbn.KEIHI_DOUITU.eq(kykkbn)) {
                    if (pErrorCdlst.contains(CheckKzhuriKouza.KZMEIGINMKN_KYOKAMONJICHK_ERROR)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                            MakeHubiMsg.exec(MessageId.EHC1079, MessageId.EHC1079, ICommonKoumoku.DISP_S_HHKNNMKN),
                            pMP);
                    }
                    if (pErrorCdlst.contains(CheckKzhuriKouza.KZMEIGINMKN_KETASUUCHK_ERROR)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                            MakeHubiMsg.exec(MessageId.EHC1080, MessageId.EHC1080, ICommonKoumoku.DISP_S_HHKNNMKN),
                            pMP);
                    }
                }
            }
        }

        if (!C_KzkykdouKbn.DOUITU.eq(kzkykdoukbn)) {
            C_KzmeigitknKbn kzmeigitknKbn;
            HT_Tokunin tokunin = pSyoriCTL.getTokunin();
            if (tokunin != null) {
                kzmeigitknKbn = tokunin.getKzmeigitknkbn();
            }
            else {
                kzmeigitknKbn = C_KzmeigitknKbn.NONE;
            }

            C_TknKbn tknKbn = C_TknKbn.NONE;
            if (C_KzmeigitknKbn.NONE.eq(kzmeigitknKbn)) {
                tknKbn = C_TknKbn.KANOU;
            }
            else {
                tknKbn = C_TknKbn.SUMI;
            }

            if (!pKyknmkn.equals(kzmeiginmkn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, C_HubisyubetusyousaiKbn.KOUHURIKZMEIGIKYKBETUHUBI,
                    MakeHubiMsg.exec(MessageId.EHC1081, MessageId.EHC1081), pMP, tknKbn, C_MsgKbn.ERROR);
            }
        }

        if (C_ErrorKbn.ERROR.eq(pErrorKbn)) {
            if (pErrorCdlst.contains(CheckKzhuriKouza.BFRYOKIN_YUUTYOCHK_ERROR)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    MakeHubiMsg.exec(MessageId.EHC1098, MessageId.EHC1098, bankcd), pMP);
            }
        }

        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(bankcd)) {
            if (C_YouhiblnkKbn.YOU.eq(kouzaKakuninIraiKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1107, MessageId.EHC1107),
                    pMP);
            }
        }

        if (C_KzhuritourokuhouKbn.QR.eq(kzhuritourokuhouKbn) && C_YouhiblnkKbn.YOU.eq(kouzaKakuninIraiKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1134, MessageId.EHC1134,
                C_KzhuritourokuhouKbn.getContentByValue(C_KzhuritourokuhouKbn.PATTERN_DEFAULT,
                    kzhuritourokuhouKbn.getValue())), pMP);
        }

        if (!C_MosUketukeKbn.PAPERLESS.eq(pSyoriCTL.getMosuketukekbn()) && !C_KzhuritourokuhouKbn.BLNK.
            eq(kzhuritourokuhouKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012,
                MSG_KZHURITOUROKUHOUKBN), pMP);
        }

        if (C_KzhuritourokuhouKbn.QR.eq(kzhuritourokuhouKbn)) {

            if (!isKanouQrChannelDrten(pMP)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1135, MessageId.EHC1135,
                    C_KzhuritourokuhouKbn.getContentByValue(C_KzhuritourokuhouKbn.PATTERN_DEFAULT,
                        kzhuritourokuhouKbn.getValue())), pMP);
            }

        }

        if (C_Syuudaikocd.BLNK.equals(syuuDaiKocd)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1136, MessageId.EHC1136), pMP);
        }

        if (C_KzhuritourokuhouKbn.QR.eq(kzhuritourokuhouKbn) && !C_Syuudaikocd.CSS.eq(syuuDaiKocd)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1137, MessageId.EHC1137,
                C_Syuudaikocd.getContentByValue(C_Syuudaikocd.PATTERN_DEFAULT,
                    syuuDaiKocd.getValue())), pMP);
        }

    }

    private boolean isKanouQrChannelDrten(MosnaiCheckParam pMP) {

        C_SkeijimuKbn skeiJimuKbn = pMP.getDataSyoriControl().getSkeijimukbn();

        if (C_SkeijimuKbn.SMBC.eq(skeiJimuKbn) || C_SkeijimuKbn.MIZUHO.eq(skeiJimuKbn)) {
            return  true;
        }

        return false;

    }

    private void outputHubiCheckUketoriKouza(MosnaiCheckParam pMP, HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon,
        HT_UketoriKouzaJyouhou pUketoriKouzaJyouhou, List<Integer> pErrorCdlst) {

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.SHRKINSITEIKOUZAJYOUHOU_NRK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1156, MessageId.EHC1156), pMP);
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.SHRKINSITEIKOUZAJYOUHOU_MNRK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1157, MessageId.EHC1157), pMP);
        }

        Boolean chkInputHubiAriFlg = false;

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.TEIKISIHARAIKINSHRTUUKA_MNRK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1143, MessageId.EHC1143,
                MSG_UKTRKZ_KZSYURUIKBN), pMP);
            chkInputHubiAriFlg = true;
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.BANKCD_MNRK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1143, MessageId.EHC1143,
                ICommonKoumoku.DISP_S_BANKCD), pMP);
            chkInputHubiAriFlg = true;
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.SITENCD_MNRK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1143, MessageId.EHC1143,
                ICommonKoumoku.DISP_S_SITENCD), pMP);
            chkInputHubiAriFlg = true;
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.YOKINSYUMOKU_MNRK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1143, MessageId.EHC1143,
                ICommonKoumoku.DISP_S_YOKINSYUMOKU), pMP);
            chkInputHubiAriFlg = true;
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.YOKINSYUMOKUGAIKA_NRK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1158, MessageId.EHC1158,
                ICommonKoumoku.DISP_S_YOKINSYUMOKU), pMP);
            chkInputHubiAriFlg = true;
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.KOUZANO_MNRK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1143, MessageId.EHC1143,
                ICommonKoumoku.DISP_S_KOUZANO), pMP);
            chkInputHubiAriFlg = true;
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.KZKYKDOUKBN_MNRK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1143, MessageId.EHC1143,
                ICommonKoumoku.DISP_N_KZDOU), pMP);
            chkInputHubiAriFlg = true;
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.KZKYKDOUKBNGAIKA_NRK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1159, MessageId.EHC1159,
                ICommonKoumoku.DISP_N_KZDOU, C_KzkykdouKbn.getContentByValue(C_KzkykdouKbn.PATTERN_DEFAULT,
                    pUketoriKouzaJyouhou.getKzkykdoukbn().getValue())), pMP);
            chkInputHubiAriFlg = true;
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.KZMEIGINMKN_NRK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1158, MessageId.EHC1158,
                ICommonKoumoku.DISP_S_KZMEIGINMEI), pMP);
            chkInputHubiAriFlg = true;
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.KZMEIGINMKN_MNRK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1143, MessageId.EHC1143,
                ICommonKoumoku.DISP_S_KZMEIGINMEI), pMP);
            chkInputHubiAriFlg = true;
        }

        if (chkInputHubiAriFlg) {
            return;
        }

        Boolean chkBankMasterHubiAriFlg = false;

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.BANKMASTER_SNZCHK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1144, MessageId.EHC1144,
                pUketoriKouzaJyouhou.getBankcd(), pUketoriKouzaJyouhou.getSitencd()), pMP);
            chkBankMasterHubiAriFlg = true;
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.BANKYUUKOU_HANTEICHK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1145, MessageId.EHC1145,
                pUketoriKouzaJyouhou.getBankcd(), pUketoriKouzaJyouhou.getSitencd()), pMP);
            chkBankMasterHubiAriFlg = true;
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.BANKYENSOUKIN_CHK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1147, MessageId.EHC1147), pMP);
            chkBankMasterHubiAriFlg = true;
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.BANKGAIKASOUKIN_CHK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1148, MessageId.EHC1148), pMP);
            chkBankMasterHubiAriFlg = true;
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.KOUZANO_KYOKAMOJICHK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1150, MessageId.EHC1150,
                ICommonKoumoku.DISP_S_KOUZANO), pMP);
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.KOUZANO_KETASUUCHK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1160, MessageId.EHC1160,
                ICommonKoumoku.DISP_S_KOUZANO), pMP);
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.KZMEIGINMKN_KYOKAMOJICHK_ERROR) ||
            pErrorCdlst.contains(CheckShiharaikinSiteiKouza.KZMEIGINMKN_KETASUUCHK_ERROR)) {

            String maikomiStr1 = "";
            String messageIDKyokaMoji = "";
            String messageIDMaxKeta = "";

            if (C_KzkykdouKbn.SITEI.eq(pUketoriKouzaJyouhou.getKzkykdoukbn())) {

                messageIDKyokaMoji = "EHC1150";
                messageIDMaxKeta = "EHC1160";
                maikomiStr1 = ICommonKoumoku.DISP_S_KZMEIGINMEI;
            }
            else if (C_KzkykdouKbn.DOUITU.eq(pUketoriKouzaJyouhou.getKzkykdoukbn())) {

                messageIDKyokaMoji = "EHC1161";
                messageIDMaxKeta = "EHC1162";

                if (C_KykKbn.KEIHI_BETU.eq(pMosKihon.getKykkbn())) {

                    maikomiStr1 = ICommonKoumoku.DISP_S_KYKNMKN;
                }
                else if (C_KykKbn.KEIHI_DOUITU.eq(pMosKihon.getKykkbn())) {

                    maikomiStr1 = ICommonKoumoku.DISP_S_HHKNNMKN;
                }
            }

            if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.KZMEIGINMKN_KYOKAMOJICHK_ERROR)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(messageIDKyokaMoji, messageIDKyokaMoji, maikomiStr1), pMP);
            }

            if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.KZMEIGINMKN_KETASUUCHK_ERROR)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(messageIDMaxKeta, messageIDMaxKeta, maikomiStr1), pMP);
            }
        }

        if (pErrorCdlst.contains(CheckShiharaikinSiteiKouza.KZMEIGINMKN_HUITTICHK_ERROR)) {

            C_KzmeigitknKbn kzMeigiTknKbn;

            HT_Tokunin tokunin = pSyoriCTL.getTokunin();

            if (tokunin != null) {

                kzMeigiTknKbn = tokunin.getKzmeigitknkbn();
            }

            else{

                kzMeigiTknKbn = C_KzmeigitknKbn.NONE;
            }

            C_TknKbn tknKbn = C_TknKbn.NONE;

            if (C_KzmeigitknKbn.NONE.eq(kzMeigiTknKbn)) {

                tknKbn = C_TknKbn.KANOU;
            }

            else {

                tknKbn = C_TknKbn.SUMI;
            }

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, C_HubisyubetusyousaiKbn.KOUHURIKZMEIGIKYKBETUHUBI,
                MakeHubiMsg.exec(MessageId.EHC1163, MessageId.EHC1163), pMP, tknKbn, C_MsgKbn.ERROR);
        }

        if ((!chkBankMasterHubiAriFlg) && pErrorCdlst.contains(CheckShiharaikinSiteiKouza.YOKINSYUMOKU_YUUTYOCHK_ERROR)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1149, MessageId.EHC1149,
                pUketoriKouzaJyouhou.getBankcd()), pMP);
        }

    }

}
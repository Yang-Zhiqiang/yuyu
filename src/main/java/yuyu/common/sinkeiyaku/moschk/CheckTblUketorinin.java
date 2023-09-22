package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SonotaTokuninKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;

/**
 * 新契約 申込内容チェック 受取人TBLチェック
 */
public class CheckTblUketorinin {

    private static String KZKTRK_SERVICE = "ご家族登録サービス";

    private static String TRKKZK_1 = "登録家族１人目";

    private static String TRKKZK_1INFO = "登録家族１人目情報";

    private static String TRKKZK_1ADRINFO = "登録家族１人目住所情報";

    private static String TRKKZK_2 = "登録家族２人目";

    private static String TRKKZK_2INFO = "登録家族２人目情報";

    private static String TRKKZK_2ADRINFO = "登録家族２人目住所情報";

    private static String KYKDRTKH = "保険契約者代理特約";

    private static String KYKDAIRIN = "契約者代理人";

    private static String KYKDRKBN = "契約者代理人区分";

    private static String STDRSKT = "被保険者代理特約";

    private static String STDRSKN = "被保険者代理人";

    private static String STDRSKNKBN = "被保険者代理人区分";

    private static String STDRSKNINFO = "被保険者代理人情報";

    private static String KEIHIDOUITU = "契被同一";

    private static String SEIYMD = "生年月日";

    private static String TEIKISHRKNUKT = "定期支払金受取人";

    private static String TEIKISHRKNUKTKBN = "定期支払金受取人区分";

    private static String TEIKISHRKNUKTINFO = "定期支払金受取人情報";

    @Inject
    private static Logger logger;

    @Inject
    private GetUktYouFlg getUktYouFlg;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private CheckSbUktHhkn checkSbUktHhkn;

    @Inject
    private CheckNkUktKbn checkNkUktKbn;

    @Inject
    private CheckUktBnWari checkUktBnWari;

    public CheckTblUketorinin() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        boolean checkFlgSibou = true;
        boolean checkFlgNk = true;
        boolean checkFlgKzktrkService = true;
        boolean checkFlgKykdairin = true;
        boolean checkFlgStd = true;
        boolean checkFlgTeikShrknUkt = true;

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 受取人テーブルチェック 開始");
        }

        HT_MosKihon mosKihon = pMP.getDataSyoriControl().getMosKihon();
        BizDate mosymd = mosKihon.getMosymd();
        getUktYouFlg.exec(pMP);
        boolean youFlgSbUkt = getUktYouFlg.getFlgSbUkt();
        boolean youFlgKzkTrkSrv = getUktYouFlg.getFlgKzkTrkSrv();
        boolean youFlgKykDr = getUktYouFlg.getFlgKykDr();
        boolean youFlgHhknDr = getUktYouFlg.getFlgHhknDr();
        boolean youFlgSbHnkUkt = getUktYouFlg.getFlgSbHnknknUkt();
        boolean youFlgNkUkt = getUktYouFlg.getFlgNkUkt();
        boolean youFlgTeikShrknUkt = getUktYouFlg.getFlgTikShrknUkt();

        C_SysKbn sysKbn = pMP.getSysKbn();

        List<HT_Uketorinin> lstSbHnknUkt = pMP.getDataSyoriControl().getUketorininsByUktsyukbn(C_UktsyuKbn.SBHENKANUKT);

        if(C_SysKbn.SKEI.eq(sysKbn)){

            if (youFlgSbHnkUkt) {
                if (lstSbHnknUkt.size() == 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC0106,
                        MessageId.EHC0106), pMP);
                }
            }
            else {
                if (lstSbHnknUkt.size() > 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC0107,
                        MessageId.EHC0107), pMP);
                }
            }
        }

        List<HT_Uketorinin> lstSbUkt = pMP.getDataSyoriControl().getUketorininsByUktsyukbn(C_UktsyuKbn.SBUKT);

        if(C_SysKbn.SKEI.eq(sysKbn)){

            int sbUketorinInNo = mosKihon.getSbuktnin();
            if (sbUketorinInNo < 5 && youFlgSbUkt) {

                if (lstSbUkt.size() == 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC0041,
                        MessageId.EHC0041), pMP);

                    checkFlgSibou = false;
                }
                else {
                    if (lstSbUkt.size() != sbUketorinInNo) {
                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EBC0045,
                            MessageId.EBC0045, "受取人人数分"), pMP);

                        checkFlgSibou = false;
                    }
                }
            }
            else {
                if (lstSbUkt.size() > 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC0007,
                        MessageId.EHC0007), pMP);

                }
                checkFlgSibou = false;
            }

        }

        if (checkFlgSibou) {
            checkSbUktHhkn.exec(pMP, lstSbUkt);

            checkUktBnWari.exec(pMP, lstSbUkt);

            CheckSeiYmd checkSeiYmd = SWAKInjector.getInstance(CheckSeiYmd.class);

            for (HT_Uketorinin uketorinIn : lstSbUkt) {
                BizDate uktseiYmd = uketorinIn.getUktseiymd();
                C_UktsyuKbn uktsyuKbn = uketorinIn.getUktsyukbn();

                checkSeiYmd.exec(pMP, uktseiYmd, uktsyuKbn.getContent() + "生年月日");
            }
        }

        List<HT_Uketorinin> lstNkUkt = pMP.getDataSyoriControl().getUketorininsByUktsyukbn(C_UktsyuKbn.NKUKT);
        if(C_SysKbn.SKEI.eq(sysKbn)){
            if (youFlgNkUkt) {
                if (lstNkUkt.size() == 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                        MakeHubiMsg.exec(MessageId.EBC0045, MessageId.EBC0045, "年金受取人"),
                        pMP);

                    checkFlgNk = false;
                }
            }
            else {
                if (lstNkUkt.size() > 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                        MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, "年金受取人"),
                        pMP);
                }

                checkFlgNk = false;
            }
        }

        if (checkFlgNk) {
            checkNkUktKbn.exec(pMP, lstNkUkt);
        }

        HT_MosTrkKzk mosTrkKzk1 = null;
        HT_MosTrkKzk mosTrkKzk2 = null;
        if (C_SysKbn.SKEI.eq(sysKbn)) {
            BizDate kzktourokuServiceKaisiYmd = YuyuSinkeiyakuConfig.getInstance().getKzktourokuServiceKaisiYmd();
            boolean kzktourokuServiceErrorariFlg = false;
            List<HT_MosTrkKzk> mosTrkKzkList = pMP.getDataSyoriControl().getMosTrkKzks();
            C_KzktourokuserviceTourokuKbn kzktourokuServiceKbn = mosKihon.getKzktourokuservicetourokukbn();

            if (mosTrkKzkList != null && mosTrkKzkList.size() != 0) {
                for (HT_MosTrkKzk mosTrkKzk : mosTrkKzkList) {
                    if (C_TrkKzkKbn.TRKKZK1.eq(mosTrkKzk.getTrkkzkkbn())) {
                        mosTrkKzk1 = mosTrkKzk;
                    }
                    else if (C_TrkKzkKbn.TRKKZK2.eq(mosTrkKzk.getTrkkzkkbn())) {
                        mosTrkKzk2 = mosTrkKzk;
                    }
                }
            }

            if (mosymd.compareTo(kzktourokuServiceKaisiYmd) >= 0) {
                if (youFlgKzkTrkSrv) {
                    if (C_KzktourokuserviceTourokuKbn.BLNK.eq(kzktourokuServiceKbn)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            MakeHubiMsg.exec(MessageId.EBC0045, MessageId.EBC0045, KZKTRK_SERVICE),
                            pMP,
                            C_TknKbn.NONE,
                            C_MsgKbn.ERROR);

                        checkFlgKzktrkService = false;
                    }
                    else if (C_KzktourokuserviceTourokuKbn.ARI.eq(kzktourokuServiceKbn)) {
                        if (mosTrkKzkList.size() == 0) {
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                C_SpKeisanKahiKbn.SPKEISANKA,
                                C_HubisyubetusyousaiKbn.NONE,
                                MakeHubiMsg.exec(MessageId.EBC0045, MessageId.EBC0045, TRKKZK_1),
                                pMP,
                                C_TknKbn.NONE,
                                C_MsgKbn.ERROR);

                            checkFlgKzktrkService = false;
                        }
                    }
                    else {
                        if (mosTrkKzkList.size() > 0) {
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                C_SpKeisanKahiKbn.SPKEISANKA,
                                C_HubisyubetusyousaiKbn.NONE,
                                MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, KZKTRK_SERVICE),
                                pMP,
                                C_TknKbn.NONE,
                                C_MsgKbn.ERROR);

                            checkFlgKzktrkService = false;
                        }
                    }

                    if (checkFlgKzktrkService && C_KzktourokuserviceTourokuKbn.ARI.eq(kzktourokuServiceKbn)) {
                        if (mosTrkKzk1 == null) {
                            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                MakeHubiMsg.exec(MessageId.EBC0045, MessageId.EBC0045, TRKKZK_1),
                                pMP);

                            kzktourokuServiceErrorariFlg = true;
                        }
                        else {
                            if (BizUtil.isBlank(mosTrkKzk1.getTrkkzknmkn()) ||
                                BizUtil.isBlank(mosTrkKzk1.getTrkkzknmkj()) ||
                                mosTrkKzk1.getTrkkzkseiymd() == null ||
                                C_Seibetu.BLNK.eq(mosTrkKzk1.getTrkkzksei()) ||
                                C_Tdk.BLNK.eq(mosTrkKzk1.getTrkkzktdk()) ||
                                BizUtil.isBlank(mosTrkKzk1.getTrkkzktelno())) {
                                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                    MakeHubiMsg.exec(MessageId.EHC1129, MessageId.EHC1129, TRKKZK_1INFO),
                                    pMP);

                                kzktourokuServiceErrorariFlg = true;
                            }
                            else {
                                if (C_TsindousiteiKbn.BLNK.eq(mosTrkKzk1.getTrkkzktsindousiteikbn())) {
                                    if (BizUtil.isBlank(mosTrkKzk1.getTrkkzkyno()) ||
                                        BizUtil.isBlank(mosTrkKzk1.getTrkkzkadr1kj())) {
                                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                            MakeHubiMsg.exec(MessageId.EHC1129, MessageId.EHC1129, TRKKZK_1ADRINFO),
                                            pMP);

                                        kzktourokuServiceErrorariFlg = true;
                                    }
                                }
                                else {
                                    if (!BizUtil.isBlank(mosTrkKzk1.getTrkkzkyno()) ||
                                        !BizUtil.isBlank(mosTrkKzk1.getTrkkzkadr1kj()) ||
                                        !BizUtil.isBlank(mosTrkKzk1.getTrkkzkadr2kj()) ||
                                        !BizUtil.isBlank(mosTrkKzk1.getTrkkzkadr3kj())) {
                                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                            MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, TRKKZK_1ADRINFO),
                                            pMP);

                                        kzktourokuServiceErrorariFlg = true;
                                    }
                                }
                            }
                        }
                    }

                    if (checkFlgKzktrkService && C_KzktourokuserviceTourokuKbn.ARI.eq(kzktourokuServiceKbn)) {
                        if (mosTrkKzk2 != null) {
                            if (BizUtil.isBlank(mosTrkKzk2.getTrkkzknmkn()) ||
                                BizUtil.isBlank(mosTrkKzk2.getTrkkzknmkj()) ||
                                mosTrkKzk2.getTrkkzkseiymd() == null ||
                                C_Seibetu.BLNK.eq(mosTrkKzk2.getTrkkzksei()) ||
                                C_Tdk.BLNK.eq(mosTrkKzk2.getTrkkzktdk()) ||
                                BizUtil.isBlank(mosTrkKzk2.getTrkkzktelno())) {
                                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                    MakeHubiMsg.exec(MessageId.EHC1129, MessageId.EHC1129, TRKKZK_2INFO),
                                    pMP);

                                kzktourokuServiceErrorariFlg = true;
                            }
                            else {
                                if (C_TsindousiteiKbn.BLNK.eq(mosTrkKzk2.getTrkkzktsindousiteikbn())) {
                                    if (BizUtil.isBlank(mosTrkKzk2.getTrkkzkyno()) ||
                                        BizUtil.isBlank(mosTrkKzk2.getTrkkzkadr1kj())) {
                                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                            MakeHubiMsg.exec(MessageId.EHC1129, MessageId.EHC1129, TRKKZK_2ADRINFO),
                                            pMP);

                                        kzktourokuServiceErrorariFlg = true;
                                    }
                                }
                                else {
                                    if (!BizUtil.isBlank(mosTrkKzk2.getTrkkzkyno()) ||
                                        !BizUtil.isBlank(mosTrkKzk2.getTrkkzkadr1kj()) ||
                                        !BizUtil.isBlank(mosTrkKzk2.getTrkkzkadr2kj()) ||
                                        !BizUtil.isBlank(mosTrkKzk2.getTrkkzkadr3kj())) {
                                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                            MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, TRKKZK_2ADRINFO),
                                            pMP);

                                        kzktourokuServiceErrorariFlg = true;
                                    }
                                }
                            }
                        }
                    }

                    String trkKzk1yno = "";
                    String trkkzk1adr1kj = "";
                    String trkkzk1adr2kj = "";
                    String trkkzk1adr3kj = "";
                    String trkKzk2yno = "";
                    String trkkzk2adr1kj = "";
                    String trkkzk2adr2kj = "";
                    String trkkzk2adr3kj = "";
                    String hikakusakiKyknmkn = "";
                    String hikakusakiKyknmkj = "";
                    BizDate hikakusakiKykseiYmd = null;
                    String hikakusakiKykyno = "";
                    String hikakusakiKykadr1kj = "";
                    String hikakusakiKykadr2kj = "";
                    String hikakusakiKykadr3kj = "";

                    if (checkFlgKzktrkService &&
                        C_KzktourokuserviceTourokuKbn.ARI.eq(kzktourokuServiceKbn) &&
                        mosTrkKzk1 != null) {

                        if (C_TsindousiteiKbn.BLNK.eq(mosTrkKzk1.getTrkkzktsindousiteikbn())) {

                            trkKzk1yno = mosTrkKzk1.getTrkkzkyno();
                            trkkzk1adr1kj = mosTrkKzk1.getTrkkzkadr1kj();
                            trkkzk1adr2kj = mosTrkKzk1.getTrkkzkadr2kj();
                            trkkzk1adr3kj = mosTrkKzk1.getTrkkzkadr3kj();
                        }
                        else {
                            trkKzk1yno = mosKihon.getTsinyno();
                            trkkzk1adr1kj = mosKihon.getTsinadr1kj();
                            trkkzk1adr2kj = mosKihon.getTsinadr2kj();
                            trkkzk1adr3kj = mosKihon.getTsinadr3kj();
                        }

                        if (C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn())) {

                            hikakusakiKyknmkn = mosKihon.getKyknmkn();
                            hikakusakiKyknmkj = mosKihon.getKyknmkj();
                            hikakusakiKykseiYmd = mosKihon.getKykseiymd();
                            hikakusakiKykyno = mosKihon.getTsinyno();
                            hikakusakiKykadr1kj = mosKihon.getTsinadr1kj();
                            hikakusakiKykadr2kj = mosKihon.getTsinadr2kj();
                            hikakusakiKykadr3kj = mosKihon.getTsinadr3kj();
                        }
                        else {

                            hikakusakiKyknmkn = mosKihon.getHhknnmkn();
                            hikakusakiKyknmkj = mosKihon.getHhknnmkj();
                            hikakusakiKykseiYmd = mosKihon.getHhknseiymd();

                            if (C_TsindousiteiKbn.BLNK.eq(mosKihon.getTsindousiteikbn())) {

                                hikakusakiKykyno = mosKihon.getHhknyno();
                                hikakusakiKykadr1kj = mosKihon.getHhknadr1kj();
                                hikakusakiKykadr2kj = mosKihon.getHhknadr2kj();
                                hikakusakiKykadr3kj = mosKihon.getHhknadr3kj();
                            }
                            else {

                                hikakusakiKykyno = mosKihon.getTsinyno();
                                hikakusakiKykadr1kj = mosKihon.getTsinadr1kj();
                                hikakusakiKykadr2kj = mosKihon.getTsinadr2kj();
                                hikakusakiKykadr3kj = mosKihon.getTsinadr3kj();
                            }
                        }

                        if (mosTrkKzk1.getTrkkzknmkn().equals(hikakusakiKyknmkn) &&
                            mosTrkKzk1.getTrkkzknmkj().equals(hikakusakiKyknmkj) &&
                            BizDateUtil.compareYmd(mosTrkKzk1.getTrkkzkseiymd(), hikakusakiKykseiYmd) == BizDateUtil.COMPARE_EQUAL &&
                            trkKzk1yno.equals(hikakusakiKykyno) &&
                            trkkzk1adr1kj.equals(hikakusakiKykadr1kj) &&
                            trkkzk1adr2kj.equals(hikakusakiKykadr2kj) &&
                            trkkzk1adr3kj.equals(hikakusakiKykadr3kj) ) {

                            setHubiMsg.exec(
                                C_KetsrhkosKbn.KETHORYU_HUBI,
                                C_SpKeisanKahiKbn.SPKEISANKA,
                                C_HubisyubetusyousaiKbn.NONE,
                                MakeHubiMsg.exec(MessageId.EHC1164, MessageId.EHC1164, TRKKZK_1),
                                pMP,
                                C_TknKbn.NONE,
                                C_MsgKbn.ERROR);

                            kzktourokuServiceErrorariFlg = true;
                        }
                    }

                    if (checkFlgKzktrkService &&
                        C_KzktourokuserviceTourokuKbn.ARI.eq(kzktourokuServiceKbn) &&
                        mosTrkKzk2 != null) {

                        if (C_TsindousiteiKbn.BLNK.eq(mosTrkKzk2.getTrkkzktsindousiteikbn())) {

                            trkKzk2yno = mosTrkKzk2.getTrkkzkyno();
                            trkkzk2adr1kj = mosTrkKzk2.getTrkkzkadr1kj();
                            trkkzk2adr2kj = mosTrkKzk2.getTrkkzkadr2kj();
                            trkkzk2adr3kj = mosTrkKzk2.getTrkkzkadr3kj();
                        }
                        else {
                            trkKzk2yno = mosKihon.getTsinyno();
                            trkkzk2adr1kj = mosKihon.getTsinadr1kj();
                            trkkzk2adr2kj = mosKihon.getTsinadr2kj();
                            trkkzk2adr3kj = mosKihon.getTsinadr3kj();
                        }

                        if (C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn())) {

                            hikakusakiKyknmkn = mosKihon.getKyknmkn();
                            hikakusakiKyknmkj = mosKihon.getKyknmkj();
                            hikakusakiKykseiYmd = mosKihon.getKykseiymd();
                            hikakusakiKykyno = mosKihon.getTsinyno();
                            hikakusakiKykadr1kj = mosKihon.getTsinadr1kj();
                            hikakusakiKykadr2kj = mosKihon.getTsinadr2kj();
                            hikakusakiKykadr3kj = mosKihon.getTsinadr3kj();
                        }
                        else {

                            hikakusakiKyknmkn = mosKihon.getHhknnmkn();
                            hikakusakiKyknmkj = mosKihon.getHhknnmkj();
                            hikakusakiKykseiYmd = mosKihon.getHhknseiymd();

                            if (C_TsindousiteiKbn.BLNK.eq(mosKihon.getTsindousiteikbn())) {

                                hikakusakiKykyno = mosKihon.getHhknyno();
                                hikakusakiKykadr1kj = mosKihon.getHhknadr1kj();
                                hikakusakiKykadr2kj = mosKihon.getHhknadr2kj();
                                hikakusakiKykadr3kj = mosKihon.getHhknadr3kj();
                            }
                            else {

                                hikakusakiKykyno = mosKihon.getTsinyno();
                                hikakusakiKykadr1kj = mosKihon.getTsinadr1kj();
                                hikakusakiKykadr2kj = mosKihon.getTsinadr2kj();
                                hikakusakiKykadr3kj = mosKihon.getTsinadr3kj();
                            }
                        }

                        if (mosTrkKzk2.getTrkkzknmkn().equals(hikakusakiKyknmkn) &&
                            mosTrkKzk2.getTrkkzknmkj().equals(hikakusakiKyknmkj) &&
                            BizDateUtil.compareYmd(mosTrkKzk2.getTrkkzkseiymd(), hikakusakiKykseiYmd) == BizDateUtil.COMPARE_EQUAL &&
                            trkKzk2yno.equals(hikakusakiKykyno) &&
                            trkkzk2adr1kj.equals(hikakusakiKykadr1kj) &&
                            trkkzk2adr2kj.equals(hikakusakiKykadr2kj) &&
                            trkkzk2adr3kj.equals(hikakusakiKykadr3kj) ) {

                            setHubiMsg.exec(
                                C_KetsrhkosKbn.KETHORYU_HUBI,
                                C_SpKeisanKahiKbn.SPKEISANKA,
                                C_HubisyubetusyousaiKbn.NONE,
                                MakeHubiMsg.exec(MessageId.EHC1164, MessageId.EHC1164, TRKKZK_2),
                                pMP,
                                C_TknKbn.NONE,
                                C_MsgKbn.ERROR);

                            kzktourokuServiceErrorariFlg = true;
                        }
                    }

                    if (checkFlgKzktrkService && kzktourokuServiceErrorariFlg) {

                        checkFlgKzktrkService = false;
                    }
                }
                else {
                    if (C_KzktourokuserviceTourokuKbn.BLNK.eq(kzktourokuServiceKbn)) {
                        if (mosTrkKzkList.size() > 0) {
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                C_SpKeisanKahiKbn.SPKEISANKA,
                                C_HubisyubetusyousaiKbn.NONE,
                                MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, KZKTRK_SERVICE),
                                pMP,
                                C_TknKbn.NONE,
                                C_MsgKbn.ERROR);

                            checkFlgKzktrkService = false;
                        }
                    }
                    else {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, KZKTRK_SERVICE),
                            pMP,
                            C_TknKbn.NONE,
                            C_MsgKbn.ERROR);

                        checkFlgKzktrkService = false;
                    }
                }
            }
            else {
                if (!C_KzktourokuserviceTourokuKbn.BLNK.eq(kzktourokuServiceKbn)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, KZKTRK_SERVICE),
                        pMP,
                        C_TknKbn.NONE,
                        C_MsgKbn.ERROR);

                    checkFlgKzktrkService = false;
                }
                else {
                    if (mosTrkKzkList.size() > 0) {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, KZKTRK_SERVICE),
                            pMP,
                            C_TknKbn.NONE,
                            C_MsgKbn.ERROR);

                        checkFlgKzktrkService = false;
                    }
                }
            }
        }

        if (C_SysKbn.SKEI.eq(sysKbn)) {
            BizDate kykdaririTkykHukaYmd = YuyuSinkeiyakuConfig.getInstance().getKykdaririTkykHukaYmd();
            List<HT_Uketorinin> uketorininList = pMP.getDataSyoriControl().
                getUketorininsByUktsyukbn(C_UktsyuKbn.KYKDRN);

            C_UktKbn kykdrKbn = C_UktKbn.BLNK;

            C_Tkhukaumu kykdrtkykhukaKbn = mosKihon.getKykdrtkykhukakbn();
            if (uketorininList.size() > 0) {
                if (uketorininList.get(0).getUktkbn() != null) {
                    kykdrKbn = uketorininList.get(0).getUktkbn();
                }
            }

            if (mosymd.compareTo(kykdaririTkykHukaYmd) >= 0) {
                if (youFlgKykDr) {
                    if (C_Tkhukaumu.BLNK.eq(kykdrtkykhukaKbn)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            MakeHubiMsg.exec(MessageId.EBC0045, MessageId.EBC0045, KYKDRTKH),
                            pMP,
                            C_TknKbn.NONE,
                            C_MsgKbn.ERROR);

                        checkFlgKykdairin = false;
                    }
                    else if (C_Tkhukaumu.HUKA.eq(kykdrtkykhukaKbn)) {
                        if (uketorininList.size() == 0) {
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                C_SpKeisanKahiKbn.SPKEISANKA,
                                C_HubisyubetusyousaiKbn.NONE,
                                MakeHubiMsg.exec(MessageId.EBC0045, MessageId.EBC0045, KYKDAIRIN),
                                pMP,
                                C_TknKbn.NONE,
                                C_MsgKbn.ERROR);

                            checkFlgKykdairin = false;
                        }
                    }
                    else {
                        if (uketorininList.size() > 0) {
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                C_SpKeisanKahiKbn.SPKEISANKA,
                                C_HubisyubetusyousaiKbn.NONE,
                                MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, KYKDAIRIN),
                                pMP,
                                C_TknKbn.NONE,
                                C_MsgKbn.ERROR);

                            checkFlgKykdairin = false;
                        }
                    }

                    if (checkFlgKykdairin && C_Tkhukaumu.HUKA.eq(kykdrtkykhukaKbn)) {
                        if (C_UktKbn.BLNK.eq(kykdrKbn)) {
                            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                MakeHubiMsg.exec(MessageId.EBC0045, MessageId.EBC0045, KYKDRKBN),
                                pMP);

                            checkFlgKykdairin = false;
                        }
                    }

                    if (checkFlgKykdairin && C_Tkhukaumu.HUKA.eq(kykdrtkykhukaKbn)) {
                        if (checkFlgKzktrkService) {
                            if (C_UktKbn.TOUROKUKAZOKU1.eq(kykdrKbn) && mosTrkKzk1 == null) {
                                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                    MakeHubiMsg.exec(MessageId.EHA1095, MessageId.EHA1095, KYKDRKBN,
                                        C_UktKbn.getContentByValue(C_UktKbn.PATTERN_SKKYKDR, kykdrKbn.getValue())),
                                        pMP);

                                checkFlgKykdairin = false;
                            }
                            else if (C_UktKbn.TOUROKUKAZOKU2.eq(kykdrKbn) && mosTrkKzk2 == null) {
                                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                    MakeHubiMsg.exec(MessageId.EHA1095, MessageId.EHA1095, KYKDRKBN,
                                        C_UktKbn.getContentByValue(C_UktKbn.PATTERN_SKKYKDR, kykdrKbn.getValue())),
                                        pMP);

                                checkFlgKykdairin = false;
                            }
                        }
                    }
                }
                else {
                    if (C_Tkhukaumu.BLNK.eq(kykdrtkykhukaKbn)) {
                        if (uketorininList.size() > 0) {
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                C_SpKeisanKahiKbn.SPKEISANKA,
                                C_HubisyubetusyousaiKbn.NONE,
                                MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, KYKDAIRIN),
                                pMP,
                                C_TknKbn.NONE,
                                C_MsgKbn.ERROR);

                            checkFlgKykdairin = false;
                        }
                    }
                    else {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, KYKDRTKH),
                            pMP,
                            C_TknKbn.NONE,
                            C_MsgKbn.ERROR);

                        checkFlgKykdairin = false;
                    }
                }
            }
            else {
                if (!C_Tkhukaumu.BLNK.eq(kykdrtkykhukaKbn)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, KYKDRTKH),
                        pMP,
                        C_TknKbn.NONE,
                        C_MsgKbn.ERROR);

                    checkFlgKykdairin = false;
                }
                else {
                    if (uketorininList.size() > 0) {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, KYKDRTKH),
                            pMP,
                            C_TknKbn.NONE,
                            C_MsgKbn.ERROR);

                        checkFlgKykdairin = false;
                    }
                }
            }
        }

        if(C_SysKbn.SKEI.eq(sysKbn)){
            List<HT_Uketorinin> lstStDrSk = pMP.getDataSyoriControl().getUketorininsByUktsyukbn(C_UktsyuKbn.STDRSK);
            C_UktKbn uktKbn = C_UktKbn.BLNK;
            String uktnmKn = "";
            String uktnmKj = "";
            BizDate stdrskSeiYmd = null;
            C_Tdk tdk = C_Tdk.BLNK;
            C_KjkhukaKbn kjkhukaKbn = C_KjkhukaKbn.BLNK;
            C_Tkhukaumu tkHukaumu = mosKihon.getStdrsktkyhkkbn();
            BizDate hhkndairiTkykHukaYmd = YuyuSinkeiyakuConfig.getInstance().getHhkndairiTkykHukaYmd();
            if (lstStDrSk.size() > 0) {
                uktKbn = lstStDrSk.get(0).getUktkbn();
                uktnmKn = lstStDrSk.get(0).getUktnmkn();
                uktnmKj = lstStDrSk.get(0).getUktnmkj();
                stdrskSeiYmd = lstStDrSk.get(0).getUktseiymd();
                tdk = lstStDrSk.get(0).getUkttdk();
                kjkhukaKbn = lstStDrSk.get(0).getUktnmkjkhukakbn();
            }

            if (youFlgHhknDr) {
                if (C_Tkhukaumu.BLNK.eq(tkHukaumu)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MakeHubiMsg.exec(MessageId.EBC0045, MessageId.EBC0045, STDRSKT),
                        pMP,
                        C_TknKbn.NONE,
                        C_MsgKbn.ERROR);
                    checkFlgStd = false;
                }
            }
            else {
                if (!C_Tkhukaumu.BLNK.eq(tkHukaumu)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, STDRSKN),
                        pMP,
                        C_TknKbn.NONE,
                        C_MsgKbn.ERROR);
                    checkFlgStd = false;
                }
            }
            if (checkFlgStd && !youFlgHhknDr) {
                if (lstStDrSk.size() > 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, STDRSKN),
                        pMP,
                        C_TknKbn.NONE,
                        C_MsgKbn.ERROR);
                    checkFlgStd = false;
                }
            }
            else if (checkFlgStd && youFlgHhknDr && C_Tkhukaumu.NONE.eq(tkHukaumu)) {
                if (lstStDrSk.size() > 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, STDRSKN),
                        pMP,
                        C_TknKbn.NONE,
                        C_MsgKbn.ERROR);
                    checkFlgStd = false;
                }
            }
            else if (checkFlgStd && youFlgHhknDr && C_Tkhukaumu.HUKA.eq(tkHukaumu)) {
                if (lstStDrSk.size() == 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MakeHubiMsg.exec(MessageId.EBC0045, MessageId.EBC0045, STDRSKN),
                        pMP,
                        C_TknKbn.NONE,
                        C_MsgKbn.ERROR);
                    checkFlgStd = false;
                }
                else if (mosKihon.getSbuktnin() >= 5) {
                    if (C_UktKbn.SBUK.eq(uktKbn)){
                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                            MakeHubiMsg.exec(MessageId.EHA1028, MessageId.EHA1028),
                            pMP);
                        checkFlgStd = false;
                    }
                }
                if (checkFlgStd
                    && (C_UktKbn.SBUK.eq(uktKbn))
                    && (!BizUtil.isBlank(uktnmKn) || !BizUtil.isBlank(uktnmKj) || stdrskSeiYmd != null ||
                    !C_KjkhukaKbn.BLNK.eq(kjkhukaKbn) || !C_Tdk.BLNK.eq(tdk))) {
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                        MakeHubiMsg.exec(MessageId.EHA0401, MessageId.EHA0401,
                            C_UktKbn.getContentByValue(C_UktKbn.PATTERN_DEFAULT, uktKbn.getValue())),
                            pMP);
                    checkFlgStd = false;
                }
                if (checkFlgStd && C_UktKbn.BLNK.eq(uktKbn)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                        MakeHubiMsg.exec(MessageId.EHC0046, MessageId.EHC0046),
                        pMP);
                    checkFlgStd = false;
                }
                if (checkFlgStd && (C_UktKbn.TOKUTEIMEIGI.eq(uktKbn) && mosymd.compareTo(hhkndairiTkykHukaYmd) < 0)
                    && (BizUtil.isBlank(uktnmKn) || BizUtil.isBlank(uktnmKj) || C_Tdk.BLNK.eq(tdk))) {
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                        MakeHubiMsg.exec(MessageId.EHA0402, MessageId.EHA0402,
                            C_UktKbn.getContentByValue(C_UktKbn.PATTERN_DEFAULT, uktKbn.getValue())),
                            pMP);
                    checkFlgStd = false;
                }
                else if (checkFlgStd &&
                    (C_UktKbn.TOKUTEIMEIGI.eq(uktKbn) && mosymd.compareTo(hhkndairiTkykHukaYmd) >= 0 &&
                    (BizUtil.isBlank(uktnmKn) || BizUtil.isBlank(uktnmKj) || C_Tdk.BLNK.eq(tdk) ||
                        stdrskSeiYmd == null))) {
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                        MakeHubiMsg.exec(MessageId.EHA0402, MessageId.EHA0402,
                            C_UktKbn.getContentByValue(C_UktKbn.PATTERN_DEFAULT, uktKbn.getValue())),
                            pMP);
                    checkFlgStd = false;
                }
                else if (checkFlgStd && C_UktKbn.TOUROKUKAZOKU1.eq(uktKbn) || C_UktKbn.TOUROKUKAZOKU2.eq(uktKbn) ||
                    C_UktKbn.KYK.eq(uktKbn)) {
                    if (!BizUtil.isBlank(uktnmKn) || !BizUtil.isBlank(uktnmKj) || stdrskSeiYmd != null ||
                        !C_Tdk.BLNK.eq(tdk) || !C_KjkhukaKbn.BLNK.eq(kjkhukaKbn)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                            MakeHubiMsg.exec(MessageId.EHC1112, MessageId.EHC1112, STDRSKNKBN,
                                C_UktKbn.getContentByValue(C_UktKbn.PATTERN_SKSTDR, uktKbn.getValue()),
                                STDRSKNINFO),
                                pMP);
                        checkFlgStd = false;
                    }
                }

                if (checkFlgStd && checkFlgNk ) {
                    if (C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn())) {
                        if (lstNkUkt.size() > 0) {
                            for (HT_Uketorinin uketorinIn : lstNkUkt) {
                                if (!C_UktKbn.HHKN.eq(uketorinIn.getUktkbn())){
                                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                        MakeHubiMsg.exec(MessageId.EHC1074, MessageId.EHC1074),
                                        pMP);
                                    checkFlgStd = false;
                                    break;
                                }
                            }
                        }
                    }
                }

                if (checkFlgStd && checkFlgSibou && mosymd.compareTo(hhkndairiTkykHukaYmd) >= 0) {
                    if (C_UktKbn.SBUK.eq(uktKbn)) {
                        if (lstSbUkt.size() > 0) {
                            for (HT_Uketorinin uketorinIn : lstSbUkt) {
                                if (C_UktKbn.KYK.eq(uketorinIn.getUktkbn())) {
                                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                        MakeHubiMsg.exec(MessageId.EHC1132, MessageId.EHC1132),
                                        pMP);
                                    checkFlgStd = false;
                                    break;
                                }
                            }
                        }
                    }
                }

                if (checkFlgStd && C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                    if (C_UktKbn.KYK.eq(uktKbn)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                            MakeHubiMsg.exec(MessageId.EHA1096, MessageId.EHA1096, KEIHIDOUITU,
                                C_UktKbn.getContentByValue(C_UktKbn.PATTERN_SKSTDR, uktKbn.getValue())),
                                pMP);
                        checkFlgStd = false;
                    }
                }

                C_SonotaTokuninKbn sonotaTokuninKbn = C_SonotaTokuninKbn.NONE;
                if (checkFlgStd) {

                    HT_Tokunin tokunin = pMP.getDataSyoriControl().getTokunin();
                    if (tokunin != null) {
                        sonotaTokuninKbn = tokunin.getSonotatknkbn();
                    }


                    if ((C_Tdk.SONOTA.eq(tdk)) ||
                        (checkFlgKzktrkService && mosTrkKzk1 != null &&
                        C_UktKbn.TOUROKUKAZOKU1.eq(uktKbn) &&
                        C_Tdk.SONOTA.eq(mosTrkKzk1.getTrkkzktdk())) ||
                        (checkFlgKzktrkService && mosTrkKzk2 != null &&
                        C_UktKbn.TOUROKUKAZOKU2.eq(uktKbn) &&
                        C_Tdk.SONOTA.eq(mosTrkKzk2.getTrkkzktdk()))) {

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            MakeHubiMsg.exec(MessageId.EHC1047, MessageId.EHC1047,
                                C_Tdk.getContentByValue(C_Tdk.PATTERN_DEFAULT, C_Tdk.SONOTA.getValue())),
                                pMP,
                                C_SonotaTokuninKbn.NONE.eq(sonotaTokuninKbn) ? C_TknKbn.KANOU : C_TknKbn.SUMI,
                                    C_MsgKbn.ERROR);

                        if (C_SonotaTokuninKbn.NONE.eq(sonotaTokuninKbn)) {
                            checkFlgStd = false;
                        }
                    }
                }

                if (checkFlgStd) {
                    if (youFlgSbUkt && checkFlgSibou) {
                        if (C_SonotaTokuninKbn.NONE.eq(sonotaTokuninKbn) && C_UktKbn.TOKUTEIMEIGI.eq(uktKbn)
                            && C_Tdk.HGU.eq(tdk)) {
                            for (HT_Uketorinin uketorinIn : lstSbUkt) {
                                if (uketorinIn.getUktsyurenno() == 1) {
                                    C_Tdk uktTdk = uketorinIn.getUkttdk();
                                    if (C_Tdk.HGU.eq(uktTdk)) {
                                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                            C_SpKeisanKahiKbn.SPKEISANKA,
                                            C_HubisyubetusyousaiKbn.NONE,
                                            MakeHubiMsg.exec(MessageId.EHC1008, MessageId.EHC1008),
                                            pMP,
                                            C_TknKbn.KANOU,
                                            C_MsgKbn.ERROR);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

                if (checkFlgStd) {
                    if (checkFlgKzktrkService) {
                        if (C_UktKbn.TOUROKUKAZOKU1.eq(uktKbn) && mosTrkKzk1 == null) {
                            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                MakeHubiMsg.exec(MessageId.EHA1095, MessageId.EHA1095, STDRSKNKBN,
                                    C_UktKbn.getContentByValue(C_UktKbn.PATTERN_SKSTDR, uktKbn.getValue())),
                                    pMP);
                            checkFlgStd = false;
                        }
                        else if (C_UktKbn.TOUROKUKAZOKU2.eq(uktKbn) && mosTrkKzk2 == null) {
                            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                MakeHubiMsg.exec(MessageId.EHA1095, MessageId.EHA1095, STDRSKNKBN,
                                    C_UktKbn.getContentByValue(C_UktKbn.PATTERN_SKSTDR, uktKbn.getValue())),
                                    pMP);
                            checkFlgStd = false;
                        }
                    }
                }

                if (checkFlgStd) {

                    String hhkdrnmkn = "";
                    String hhkdrnmkj = "";
                    BizDate hhkdrseiymd = null;

                    if (checkFlgKzktrkService && C_UktKbn.TOUROKUKAZOKU1.eq(uktKbn)) {

                        hhkdrnmkn = mosTrkKzk1.getTrkkzknmkn();
                        hhkdrnmkj = mosTrkKzk1.getTrkkzknmkj();
                        hhkdrseiymd = mosTrkKzk1.getTrkkzkseiymd();
                    }
                    else if (checkFlgKzktrkService && C_UktKbn.TOUROKUKAZOKU2.eq(uktKbn)) {

                        hhkdrnmkn = mosTrkKzk2.getTrkkzknmkn();
                        hhkdrnmkj = mosTrkKzk2.getTrkkzknmkj();
                        hhkdrseiymd = mosTrkKzk2.getTrkkzkseiymd();
                    }
                    else if (C_UktKbn.KYK.eq(uktKbn)) {

                        hhkdrnmkn = mosKihon.getKyknmkn();
                        hhkdrnmkj = mosKihon.getKyknmkj();
                        hhkdrseiymd = mosKihon.getKykseiymd();
                    }
                    else if (checkFlgSibou && C_UktKbn.SBUK.eq(uktKbn)) {

                        HT_Uketorinin uketorinin1 = null;

                        if (lstSbUkt != null && lstSbUkt.size() != 0) {
                            for (HT_Uketorinin uketorinin : lstSbUkt) {
                                if (uketorinin.getUktsyurenno() == 1) {
                                    uketorinin1 = uketorinin;
                                }
                            }
                        }

                        if (uketorinin1 != null) {

                            hhkdrnmkn = uketorinin1.getUktnmkn();
                            hhkdrnmkj = uketorinin1.getUktnmkj();
                            hhkdrseiymd = uketorinin1.getUktseiymd();
                        }
                    }
                    else if (C_UktKbn.TOKUTEIMEIGI.eq(uktKbn)) {

                        hhkdrnmkn = uktnmKn;
                        hhkdrnmkj = uktnmKj;
                        hhkdrseiymd = stdrskSeiYmd;
                    }

                    if ((!BizUtil.isBlank(hhkdrnmkn) || !BizUtil.isBlank(hhkdrnmkj) || hhkdrseiymd != null) &&
                        hhkdrnmkn.equals(mosKihon.getHhknnmkn()) &&
                        hhkdrnmkj.equals(mosKihon.getHhknnmkj()) &&
                        BizDateUtil.compareYmd(hhkdrseiymd, mosKihon.getHhknseiymd()) == BizDateUtil.COMPARE_EQUAL) {

                        C_TknKbn tknKbn = C_TknKbn.NONE;

                        if (C_SonotaTokuninKbn.NONE.eq(sonotaTokuninKbn)) {
                            tknKbn = C_TknKbn.KANOU;
                        }
                        else {
                            tknKbn = C_TknKbn.SUMI;
                        }

                        setHubiMsg.exec(
                            C_KetsrhkosKbn.KETHORYU_HUBI,
                            C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            MakeHubiMsg.exec(MessageId.EHC1165, MessageId.EHC1165),
                            pMP,
                            tknKbn,
                            C_MsgKbn.ERROR);

                        if (C_SonotaTokuninKbn.NONE.eq(sonotaTokuninKbn)) {

                            checkFlgStd = false;
                        }
                    }
                }

                if (checkFlgStd && mosymd.compareTo(hhkndairiTkykHukaYmd) < 0) {
                    if (stdrskSeiYmd != null) {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            MakeHubiMsg.exec(MessageId.EHA1095, MessageId.EHA1095, STDRSKNINFO, SEIYMD),
                            pMP,
                            C_TknKbn.NONE,
                            C_MsgKbn.ERROR);
                        checkFlgStd = false;
                    }
                    else if (C_UktKbn.TOUROKUKAZOKU1.eq(uktKbn) || C_UktKbn.TOUROKUKAZOKU2.eq(uktKbn) ||
                        C_UktKbn.KYK.eq(uktKbn)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            MakeHubiMsg.exec(MessageId.EHA1095, MessageId.EHA1095, STDRSKNKBN,
                                C_UktKbn.getContentByValue(C_UktKbn.PATTERN_SKSTDR, uktKbn.getValue())),
                                pMP,
                                C_TknKbn.NONE,
                                C_MsgKbn.ERROR);
                        checkFlgStd = false;
                    }
                }
            }
        }

        if(C_SysKbn.SKEI.eq(sysKbn)){
            List<HT_Uketorinin> uketorininList = pMP.getDataSyoriControl().
                getUketorininsByUktsyukbn(C_UktsyuKbn.TKSHKUKT);

            C_UktKbn teikShrknUktKbn = C_UktKbn.BLNK;
            String teikShrknUktnmKn = "";
            String teikShrknUktnmKj = "";
            BizDate teikShrknUktYmd = null;
            C_Tdk teikShrknUktTdk = C_Tdk.BLNK;
            C_KjkhukaKbn teikShrknUktKjkhukaKbn = C_KjkhukaKbn.BLNK;

            C_Tkhukaumu teikisiharaiTkykhkKbn = mosKihon.getTeikisiharaitkykhkkbn();
            if (uketorininList.size() > 0) {
                teikShrknUktKbn = uketorininList.get(0).getUktkbn();
                teikShrknUktnmKn = uketorininList.get(0).getUktnmkn();
                teikShrknUktnmKj = uketorininList.get(0).getUktnmkj();
                teikShrknUktYmd = uketorininList.get(0).getUktseiymd();
                teikShrknUktTdk = uketorininList.get(0).getUkttdk();
                teikShrknUktKjkhukaKbn = uketorininList.get(0).getUktnmkjkhukakbn();
            }

            if (youFlgTeikShrknUkt) {
                if (uketorininList.size() == 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EBC0045,
                        MessageId.EBC0045, TEIKISHRKNUKT), pMP);

                    checkFlgTeikShrknUkt = false;
                }

                if (checkFlgTeikShrknUkt && C_Tkhukaumu.HUKA.eq(teikisiharaiTkykhkKbn)) {
                    if (C_UktKbn.TOKUTEIMEIGI.eq(teikShrknUktKbn)) {
                        if (BizUtil.isBlank(teikShrknUktnmKn) ||
                            BizUtil.isBlank(teikShrknUktnmKj) ||
                            teikShrknUktYmd == null ||
                            C_Tdk.BLNK.eq(teikShrknUktTdk)) {
                            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                MakeHubiMsg.exec(MessageId.EHC1155, MessageId.EHC1155,
                                    C_UktKbn.getContentByValue(C_UktKbn.PATTERN_TEIKISHRUKT,
                                        teikShrknUktKbn.getValue())),
                                        pMP);

                            checkFlgTeikShrknUkt = false;
                        }
                    }
                    else {
                        if (!BizUtil.isBlank(teikShrknUktnmKn) ||
                            !BizUtil.isBlank(teikShrknUktnmKj) ||
                            teikShrknUktYmd != null ||
                            !C_Tdk.BLNK.eq(teikShrknUktTdk) ||
                            !C_KjkhukaKbn.BLNK.eq(teikShrknUktKjkhukaKbn)) {
                            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                MakeHubiMsg.exec(MessageId.EHC1112, MessageId.EHC1112, TEIKISHRKNUKTKBN,
                                    C_UktKbn.getContentByValue(C_UktKbn.PATTERN_TEIKISHRUKT,
                                        teikShrknUktKbn.getValue()), TEIKISHRKNUKTINFO),
                                        pMP);

                            checkFlgTeikShrknUkt = false;
                        }
                    }
                }
            }
            else {
                if (uketorininList.size() > 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MakeHubiMsg.exec(MessageId.EBC0012,
                        MessageId.EBC0012, TEIKISHRKNUKT), pMP);

                    checkFlgTeikShrknUkt = false;
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 受取人テーブルチェック 終了");
        }
    }
}

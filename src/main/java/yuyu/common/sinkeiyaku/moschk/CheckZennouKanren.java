package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_Znnkaisuukekka;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;

/**
 * 新契約 申込内容チェック 前納関連チェック
 */
public class CheckZennouKanren {

    public static final String ZENNOU = "前納";

    public static final String ITIBUZENNOU = "一部前納";

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private HanteiZennouKaisuu hanteiZennouKaisuu;

    @Inject
    private SyouhinUtil syouhinUtil;

    public CheckZennouKanren() {
        super();
    }

    public void exec(MosnaiCheckParam pMP){
        if (logger.isDebugEnabled()) {
            logger.debug("▽ 前納関連チェック 開始");
        }

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        BM_SyouhnZokusei syouhnZokusei = pMP.getSyuSyouhnZokusei();
        C_Hrkkeiro hrkKeiro = mosKihon.getHrkkeiro();
        C_Hrkkaisuu hrkKaisuu = mosKihon.getHrkkaisuu();
        int zennoKaisuu = mosKihon.getZnnkai();
        C_BlnktkumuKbn zenkizennouUmu = mosKihon.getZenkizennouumu();
        C_IkkatubaraiKaisuuKbn ikkatuBaraiKaisuu = mosKihon.getIkkatubaraikaisuu();
        BizCurrency mosZennoupSvokaiari = mosKihon.getMoszennoupsyokaiari();
        C_UmuKbn zennouUmu = syouhnZokusei.getZennouumu();
        C_UmuKbn teikiikkatubaraiUmu = syouhnZokusei.getTeikiikkatubaraiumu();
        int znnKaiMin = YuyuSinkeiyakuConfig.getInstance().getZnnKaiMin();
        boolean zennouHanteiFlg = true;

        if (C_UmuKbn.ARI.eq(zennouUmu)) {

            if (C_Hrkkeiro.HURIKAE.eq(hrkKeiro)) {

                if (C_UmuKbn.NONE.eq(teikiikkatubaraiUmu)) {

                    if (!C_Hrkkaisuu.NEN.eq(hrkKaisuu)) {

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1109,
                            MessageId.EHC1109, ICommonKoumoku.DISP_N_HRKKEIRO, hrkKeiro.getContent(),
                            ICommonKoumoku.DISP_N_HRKKAISUU, C_Hrkkaisuu.NEN.getContent()), pMP);

                        zennouHanteiFlg = false;
                    }
                }
                else {

                    if (zennouHanteiFlg && !C_IkkatubaraiKaisuuKbn.IKKATU12.eq(ikkatuBaraiKaisuu)) {

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1109,
                            MessageId.EHC1109, ICommonKoumoku.DISP_N_HRKKEIRO, hrkKeiro.getContent(),
                            ICommonKoumoku.DISP_N_TEIKIIKKTUBARAIKAISUU,
                            C_IkkatubaraiKaisuuKbn.IKKATU12.getContent(C_IkkatubaraiKaisuuKbn.PATTERN_TEIKI)), pMP);

                        zennouHanteiFlg = false;
                    }
                }

                if (zennouHanteiFlg && C_SysKbn.SKEI.eq(pMP.getSysKbn()) &&
                    mosZennoupSvokaiari.compareTo(BizCurrency.valueOf(0, mosZennoupSvokaiari.getType())) == 0) {

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EBC0045,
                        MessageId.EBC0045, ICommonKoumoku.DISP_S_ZENNOUP), pMP);

                    zennouHanteiFlg = false;
                }
            }

            else {

                if(C_SysKbn.SKEI.eq(pMP.getSysKbn()) &&
                    mosZennoupSvokaiari.compareTo(BizCurrency.valueOf(0, mosZennoupSvokaiari.getType())) != 0) {

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EBC0007,
                        MessageId.EBC0007, ICommonKoumoku.DISP_S_ZENNOUP), pMP);

                    zennouHanteiFlg = false;
                }
            }

            if (zennouHanteiFlg && C_BlnktkumuKbn.BLNK.eq(zenkizennouUmu)) {

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EBC0045,
                    MessageId.EBC0045, ICommonKoumoku.DISP_N_ZENKIZENNOU), pMP);

                zennouHanteiFlg = false;
            }

            if (zennouHanteiFlg) {

                if (!C_Hrkkeiro.HURIKAE.eq(hrkKeiro)) {

                    if (C_BlnktkumuKbn.ARI.eq(zenkizennouUmu) || zennoKaisuu != 0) {

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1085,
                            MessageId.EHC1085, hrkKeiro.getContent(), ZENNOU),
                            pMP);

                        zennouHanteiFlg = false;
                    }
                }
                else  {

                    C_UmuKbn itibuzennoutekiyouUmu = syouhnZokusei.getItibuzennoutekiumu();
                    C_UmuKbn zenkizennoutekiyouUmu = syouhnZokusei.getZenkizennoutekiumu();

                    if (C_UmuKbn.NONE.eq(itibuzennoutekiyouUmu) && C_UmuKbn.ARI.eq(zenkizennoutekiyouUmu) &&
                        C_BlnktkumuKbn.NONE.eq(zenkizennouUmu)) {

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC0019,
                            MessageId.EHC0019, syouhinUtil.getSyouhnNm(syouhnZokusei.getSyouhncd(), pMP.getSysDate()),
                            ITIBUZENNOU), pMP);
                        zennouHanteiFlg = false;
                    }
                    else if (C_UmuKbn.ARI.eq(itibuzennoutekiyouUmu) && C_UmuKbn.NONE.eq(zenkizennoutekiyouUmu) &&
                        C_BlnktkumuKbn.ARI.eq(zenkizennouUmu)) {

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC0019,
                            MessageId.EHC0019, syouhinUtil.getSyouhnNm(syouhnZokusei.getSyouhncd(), pMP.getSysDate()),
                            ICommonKoumoku.DISP_N_ZENKIZENNOU), pMP);
                        zennouHanteiFlg = false;
                    }
                    else if (C_BlnktkumuKbn.NONE.eq(zenkizennouUmu) && zennoKaisuu == 0) {

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EBC0045,
                            MessageId.EBC0045, ICommonKoumoku.DISP_N_ZENNOUKIKAN), pMP);
                        zennouHanteiFlg = false;
                    }
                    else if (C_BlnktkumuKbn.ARI.eq(zenkizennouUmu) && zennoKaisuu == 0) {

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1084,
                            MessageId.EHC1084), pMP);
                        zennouHanteiFlg = false;
                    }
                    else if (zennoKaisuu < znnKaiMin) {

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC0105,
                            MessageId.EHC0105, String.valueOf(znnKaiMin)), pMP);
                        zennouHanteiFlg = false;
                    }
                }
            }
            if (zennouHanteiFlg) {

                C_Znnkaisuukekka znnkaisuukekka =  hanteiZennouKaisuu.exec(pMP);

                if (C_Znnkaisuukekka.OVER.eq(znnkaisuukekka)) {

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC0102,
                        MessageId.EHC0102), pMP);
                    zennouHanteiFlg = false;
                }
                else if (C_Znnkaisuukekka.TKOVER.eq(znnkaisuukekka)) {

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC0103,
                        MessageId.EHC0103), pMP);
                    zennouHanteiFlg = false;
                }
                else if (C_Znnkaisuukekka.ZENKI_ARI_HUITTI.eq(znnkaisuukekka)) {

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1076,
                        MessageId.EHC1076), pMP);
                    zennouHanteiFlg = false;
                }
                else if (C_Znnkaisuukekka.TKZENKI_ARI_HUITTI.eq(znnkaisuukekka)) {

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1088,
                        MessageId.EHC1088), pMP);
                    zennouHanteiFlg = false;
                }
                else if (C_Znnkaisuukekka.ZENKI_NASI_ITTI.eq(znnkaisuukekka)) {

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1086,
                        MessageId.EHC1086), pMP);
                    zennouHanteiFlg = false;
                }
                else if (C_Znnkaisuukekka.TKZENKI_NASI_ITTI.eq(znnkaisuukekka)) {

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1087,
                        MessageId.EHC1087), pMP);
                    zennouHanteiFlg = false;
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 前納関連チェック 終了");
        }
    }
}

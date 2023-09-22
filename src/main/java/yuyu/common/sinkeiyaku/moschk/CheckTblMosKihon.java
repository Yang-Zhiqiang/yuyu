package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.CheckZeiseiTkkkTkykHukaJyouken;
import yuyu.common.hozen.renkei.KhConvUtil;
import yuyu.common.sinkeiyaku.skcommon.DrtenTkykTratkiHantei;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_MassitknKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SknnkaisikitkhukaKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkHukaKanouKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_TkykTratkiKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.db.entity.BM_ChkTargetTkMokuhyouti;
import yuyu.def.db.entity.BM_Syokugyou;
import yuyu.def.db.entity.BM_SyouhnToriatukaiTuuka;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.db.entity.HT_Tuusan;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 申込内容チェック 申込基本TBLチェック
 */
public class CheckTblMosKihon {

    @Inject
    private static Logger logger;

    @Inject
    private CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen;

    @Inject
    private CheckKirikaeTratkikkn checkKirikaeTratkikkn;

    @Inject
    private CheckLivHuka checkLivHuka;

    @Inject
    private CheckSntkHouSyouhin checkSntkHouSyouhin;

    @Inject
    private CheckHrkKaisuu checkHrkKaisuu;

    @Inject
    private CheckZennouKanren checkZennouKanren;

    @Inject
    private CheckMeigininNmKanaCall checkMeigininNmKanaCall;

    @Inject
    private CheckSeiYmd checkSeiYmd;

    @Inject
    private CheckTelNoCall checkTelNoCall;

    @Inject
    private CheckKykSeiYmdKanren checkKykSeiYmdKanren;

    @Inject
    private CheckKykSeibetu checkKykSeibetu;

    @Inject
    private CheckKykKanren checkKykKanren;

    @Inject
    private CheckNnknTokuyaku checkNnknTokuyaku;

    @Inject
    private CheckPmentkKanren checkPmentkKanren;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private HanteiKirikaeYuukou hanteiKirikaeYuukou;

    @Inject
    private CheckShiteiKeiyakubi checkShiteiKeiyakubi;

    @Inject
    private CheckHrkKeiro checkHrkKeiro;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager manager;

    public CheckTblMosKihon() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {
        List<HT_MosSyouhn>      mosSyouhnLst;
        BM_SyouhnZokusei        syouhnZokusei;
        int                     syohinHanteiKbn;
        HT_Tokunin              tokunin;
        HT_MosKihon             mosKihonDaihyou;
        HT_SyoriCTL             syoriCTL;
        String                  mosNo;
        C_UmuKbn                kktNrkUmu;
        C_UmuKbn                hjyNrkUmu;
        String                  daiMosno;
        C_SkeijimuKbn           skeijimukbn;
        HT_MosKihon             mosKihonTbl;
        BizDate                 msKhnMosYmd;
        C_FstphrkkeiroKbn       msKhnFstPHrkKeiro;
        C_Sdpd                  msKhnSdPdKbn;
        C_SntkhouKbn            msKhnSntkHouKbn;
        C_Hrkkeiro              msKhnHrkKeiro;
        BizDate                 msKhnMassiSeiYmd;
        String                  msKhnDntCd;
        BizDate                 msKhn1PRsYmd;
        BizDate                 msKhnHhknSeiYmd;
        BizDate                 msKhnKykSeiYmd;
        C_Kyksei                msKhnKykSei;
        String                  msKhnDntCdDaihyou;
        String                  msKhnDujkiykSyono;
        C_SknnkaisikitkhukaKbn  msKhnSnKskiTkHkKbn;
        BizDate                 msKhnMosUkeYmd;
        int                     msKhnKykNen;
        int                     msKhnHhknNen;
        C_KykKbn                msKhnKyksyaKbn;
        C_SysKbn                sysKbn;
        C_TargetTkMokuhyoutiKbn targetTkMkhtKbn;
        C_KzktourokuserviceTourokuKbn kzktrkserviceTrkKbn;
        C_Tkhukaumu             kykdrTkykhukaKbn;
        C_Tkhukaumu             stdrskTkyhkKbn;
        C_Tkhukaumu             yennyknTkhkKbn;
        C_Tkhukaumu             yenshrTkhkKbn;
        C_Tkhukaumu             gaikanyknTkhkKbn;
        C_Tkhukaumu             targetTkhkKbn;
        C_HonninkakuninSyoruiKbn kykhonninkakninsyoruiKbn;
        C_DirectServiceMosKbn    drctDerviceMosKbn;
        String                   hhknsykgyCd;
        C_HaitoukinuketorihouKbn haitoukinuketorihouKbn;
        C_NensyuuKbn             hhknNensyuuKbn;
        HT_Tuusan                tuusan;
        HT_MosDairiten           mosDairiten;
        String                   oyaDrtenCd;
        C_UmuKbn                 tsryHshrkykumuKbn;
        C_Channelcd              kiteiChkChannelCd;
        C_TumitatekinHaibunWariKbn teirituHaibunWariKbn;
        C_TumitatekinHaibunWariKbn sisuuHaibunWariKbn;
        C_Tdk                      kykTdk;
        C_Tkhukaumu                kjnnkpZeitekitkHukaKbn;
        C_Tkhukaumu                teikiShrtkHukaKbn;
        C_Tkhukaumu                syksbYensitihsyuTkhkKbn;
        C_BlnktkumuKbn             zenkizennouumu;
        C_Tuukasyu                 kyktuukasyu;
        C_Tuukasyu                 hrktuukasyu;
        BizDate                    kykymd;
        Integer                    hknkkn;
        C_HknkknsmnKbn             hknkknSmnKbn;
        Integer                    hrkkkn;
        C_HrkkknsmnKbn             hrkkknSmnkbn;
        C_Sknenkinsyu              skneNkinSyu;
        C_YnkHrkmgkAnniTuutiKbn    ynkhrkmgkannituutikbn;
        List<HT_Uketorinin>        uketoriNinLst;
        BizDate                    mizuhoDirectServiceKaisiYmd;

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 申込基本TBLチェック 開始");
        }

        syoriCTL = pMp.getDataSyoriControl();
        mosNo = syoriCTL.getMosno();
        kktNrkUmu = syoriCTL.getKktnrkumu();
        hjyNrkUmu = syoriCTL.getHjynrkumu();
        daiMosno = syoriCTL.getDaimosno();
        skeijimukbn = syoriCTL.getSkeijimukbn();
        mosKihonTbl = syoriCTL.getMosKihon();
        msKhnMosYmd = mosKihonTbl.getMosymd();
        msKhnSdPdKbn = mosKihonTbl.getSdpdkbn();
        msKhnSntkHouKbn = mosKihonTbl.getSntkhoukbn();
        msKhnHrkKeiro = mosKihonTbl.getHrkkeiro();
        msKhnFstPHrkKeiro = mosKihonTbl.getFstphrkkeirokbn();
        msKhnMassiSeiYmd = mosKihonTbl.getMassiseiymd();
        msKhnDntCd = mosKihonTbl.getDntcd();
        msKhn1PRsYmd = mosKihonTbl.getItiprsymd();
        msKhnHhknSeiYmd = mosKihonTbl.getHhknseiymd();
        msKhnKykSeiYmd = mosKihonTbl.getKykseiymd();
        msKhnKykSei = mosKihonTbl.getKyksei();
        msKhnDujkiykSyono = mosKihonTbl.getDoujikaiyakusyono();
        msKhnSnKskiTkHkKbn = mosKihonTbl.getSknnkaisikitkhukakbn();
        msKhnMosUkeYmd = mosKihonTbl.getMosukeymd();
        msKhnKykNen = mosKihonTbl.getKyknen();
        msKhnHhknNen = mosKihonTbl.getHhknnen();
        msKhnKyksyaKbn = mosKihonTbl.getKykkbn();
        sysKbn = pMp.getSysKbn();
        targetTkMkhtKbn = mosKihonTbl.getTargettkmkhtkbn();
        kzktrkserviceTrkKbn = mosKihonTbl.getKzktourokuservicetourokukbn();
        kykdrTkykhukaKbn = mosKihonTbl.getKykdrtkykhukakbn();
        stdrskTkyhkKbn = mosKihonTbl.getStdrsktkyhkkbn();
        yennyknTkhkKbn = mosKihonTbl.getYennykntkhkkbn();
        yenshrTkhkKbn = mosKihonTbl.getYenshrtkhkkbn();
        gaikanyknTkhkKbn = mosKihonTbl.getGaikanykntkhkkbn();
        targetTkhkKbn = mosKihonTbl.getTargettkhkkbn();
        kykhonninkakninsyoruiKbn = mosKihonTbl.getKykhonninkakninsyoruikbn();
        drctDerviceMosKbn = mosKihonTbl.getDrctservicemoskbn();
        hhknsykgyCd = mosKihonTbl.getHhknsykgycd();
        haitoukinuketorihouKbn = mosKihonTbl.getHaitoukinuketorihoukbn();
        hhknNensyuuKbn = mosKihonTbl.getHhknnensyuukbn();
        tuusan = syoriCTL.getTuusan();
        tsryHshrkykumuKbn = mosKihonTbl.getTsryhshrkykumukbn();
        teirituHaibunWariKbn = mosKihonTbl.getTeirituhaibunwarikbn();
        sisuuHaibunWariKbn = mosKihonTbl.getSisuuhaibunwarikbn();
        kiteiChkChannelCd = pMp.getKiteiCheckChannelCd();
        kykTdk = mosKihonTbl.getKyktdk();
        kjnnkpZeitekitkHukaKbn = mosKihonTbl.getKjnnkpzeitekitkhukakbn();
        teikiShrtkHukaKbn = mosKihonTbl.getTeikisiharaitkykhkkbn();
        syksbYensitihsyuTkhkKbn = mosKihonTbl.getSyksbyensitihsyutkhkkbn();
        zenkizennouumu = mosKihonTbl.getZenkizennouumu();
        kyktuukasyu = mosKihonTbl.getKyktuukasyu();
        hrktuukasyu = mosKihonTbl.getHrktuukasyu();
        kykymd = mosKihonTbl.getKykymd();
        ynkhrkmgkannituutikbn = mosKihonTbl.getYnkhrkmgkannituutikbn();
        mizuhoDirectServiceKaisiYmd = YuyuSinkeiyakuConfig.getInstance().getMizuhoDirectServiceKaisiYmd();


        String   syouhnNm;
        C_UmuKbn sdUmu;
        C_UmuKbn pdUmu;
        C_UmuKbn syouhnKzktrkServiceUmu;
        C_UmuKbn syouhnKykdrtkykUmu;
        C_UmuKbn syouhnStdrsktkUmu;
        C_UmuKbn syouhnYenshrtkhkUmu;
        C_UmuKbn syouhnPyennykntkUmu;
        C_HaitouKbn haitouKbn;
        C_TargetTkHukaKanouKbn targetTkhukaKanouKbn;
        C_UmuKbn tmttknHaibunWarisiteiUmu;
        C_UmuKbn syouhnGaikanYuukinTktekiUmu;
        C_UmuKbn syksbYensitihsyuTktekiUmu;
        C_UmuKbn itijibrumu;
        C_UmuKbn nkhknumu;

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (syuMosSyouhnLst.size() != 1) {
            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + mosNo);
        }
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        hknkkn = syuMosSyouhnLst.get(0).getHknkkn();
        hknkknSmnKbn = syuMosSyouhnLst.get(0).getHknkknsmnkbn();
        hrkkkn = syuMosSyouhnLst.get(0).getHrkkkn();
        hrkkknSmnkbn = syuMosSyouhnLst.get(0).getHrkkknsmnkbn();
        skneNkinSyu = syuMosSyouhnLst.get(0).getSknenkinsyu();

        syouhnZokusei = pMp.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        syouhnNm = syouhnZokusei.getSyouhnnm();
        sdUmu = syouhnZokusei.getSdumu();
        pdUmu = syouhnZokusei.getPdumu();
        syouhnKzktrkServiceUmu = syouhnZokusei.getKzktourokuserviceumu();
        syouhnKykdrtkykUmu = syouhnZokusei.getKykdrtkykumu();
        syouhnStdrsktkUmu = syouhnZokusei.getStdrsktkumu();
        syouhnYenshrtkhkUmu = syouhnZokusei.getYenshrtktekiumu();
        syouhnPyennykntkUmu = syouhnZokusei.getPyennykntktekiumu();
        syouhnGaikanYuukinTktekiUmu = syouhnZokusei.getGaikanyuukintktekiumu();
        haitouKbn = syouhnZokusei.getHaitoukbn();
        targetTkhukaKanouKbn = syouhnZokusei.getTargettkhukakanoukbn();
        tmttknHaibunWarisiteiUmu = syouhnZokusei.getTmttknhaibunwarisiteiumu();
        syksbYensitihsyuTktekiUmu = syouhnZokusei.getSyksbyensitihsyutktekiumu();
        itijibrumu = syouhnZokusei.getItijibrumu();
        nkhknumu = syouhnZokusei.getNkhknumu();
        syohinHanteiKbn = SyouhinUtil.hantei(syuSyouhnCd);

        mosDairiten = syoriCTL.getMosDairitenByRenno(1);

        if (C_SysKbn.SKEI.eq(sysKbn)) {

            if (mosDairiten != null) {
                oyaDrtenCd = mosDairiten.getOyadrtencd();
            }
            else {
                oyaDrtenCd = "";
            }
        }

        else {

            oyaDrtenCd = pMp.getSekmossakuseiOyaAgCd();
        }

        uketoriNinLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.NKUKT);

        tokunin = syoriCTL.getTokunin();
        C_KakoymdkyytknKbn kakohdktknkbn;

        if(tokunin != null){
            kakohdktknkbn = tokunin.getKakoymdkyytknkbn();
        }
        else{
            kakohdktknkbn = C_KakoymdkyytknKbn.NONE;
        }

        if(C_SysKbn.SKEI.eq(sysKbn)){
            checkHokenRyouYuukouKigen.exec(pMp);
        }

        BizDate sysDate = pMp.getSysDate();
        int mosKakoHidukeKyoyou = YuyuSinkeiyakuConfig.getInstance().getMosKakoKyoyou();
        BizDate sysDateKakoHiduke = sysDate.addDays(-mosKakoHidukeKyoyou);

        if(C_SysKbn.SKEI.eq(sysKbn)){

            if( sysDateKakoHiduke.compareTo(msKhnMosYmd) > 0 ||
                sysDate.compareTo(msKhnMosYmd) < 0) {

                C_TknKbn tokuninEnable = C_TknKbn.NONE;
                if(C_KakoymdkyytknKbn.NONE.eq(kakohdktknkbn)){
                    tokuninEnable = C_TknKbn.KANOU;
                }
                else{
                    tokuninEnable = C_TknKbn.SUMI;
                }

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    makeMsg(MessageId.EBC0046, MessageId.EBC0046, ICommonKoumoku.DISP_S_MOSYMD),
                    pMp,
                    tokuninEnable);
            }
        }

        if(C_SysKbn.SKEI.eq(sysKbn)){

            if (C_SknnkaisikitkhukaKbn.HUKA.eq(msKhnSnKskiTkHkKbn) && msKhnMosUkeYmd == null) {

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    makeMsg(MessageId.EBC0045, MessageId.EBC0045, ICommonKoumoku.DISP_S_MOSUKEYMD),
                    pMp,
                    C_TknKbn.NONE,
                    C_MsgKbn.ERROR);
            }

            BizDate sakuseiYmd = mosKihonTbl.getMossakuseiymd();

            if (sakuseiYmd != null) {
                if (sakuseiYmd.compareTo(msKhnMosYmd) > 0) {

                    setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                        makeMsg(MessageId.WHC0094, MessageId.WHC0094),
                        pMp,
                        C_TknKbn.NONE,
                        C_MsgKbn.WARNING);
                }
            }

            if (msKhnMosUkeYmd != null) {

                if (sysDate.compareTo(msKhnMosUkeYmd) < 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        makeMsg(MessageId.EBC0046, MessageId.EBC0046, ICommonKoumoku.DISP_S_MOSUKEYMD),
                        pMp,
                        C_TknKbn.NONE);
                }

                if (msKhnMosUkeYmd.compareTo(msKhnMosYmd) < 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                        makeMsg(MessageId.WHC0095, MessageId.WHC0095),
                        pMp,
                        C_TknKbn.NONE,
                        C_MsgKbn.WARNING);
                }

                int kairi = YuyuSinkeiyakuConfig.getInstance().getMosKairiNissuu();
                BizDate mosYmd = msKhnMosYmd.addDays(kairi);

                if (mosYmd.compareTo(msKhnMosUkeYmd) == 0 || mosYmd.compareTo(msKhnMosUkeYmd) < 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                        makeMsg(MessageId.WHC0096, MessageId.WHC0096, String.valueOf(kairi)),
                        pMp,
                        C_TknKbn.NONE,
                        C_MsgKbn.WARNING);
                }
            }

        }

        if(C_SysKbn.SKEI.eq(sysKbn)){

            if (!BizUtil.isBlank(msKhnDujkiykSyono)) {
                setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                    makeMsg(MessageId.WHC0081, MessageId.WHC0081, msKhnDujkiykSyono),
                    pMp,
                    C_TknKbn.NONE,
                    C_MsgKbn.WARNING);

                hanteiKirikaeYuukou.exec(pMp);
                checkKirikaeTratkikkn.exec(pMp);
            }
        }

        if(C_SysKbn.SKEI.eq(sysKbn)){
            checkShiteiKeiyakubi.exec(pMp);

        }

        checkLivHuka.exec(pMp, syouhnZokusei);

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_KouzokujkKbn.NONE.eq(pMp.getKouzokuSyoriJikkouKbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 申込基本TBLチェック 終了");
            }
            return;
        }

        if (hknkkn != 99 ) {
            if (C_HknkknsmnKbn.SAIMANKI.eq(hknkknSmnKbn) && hknkkn < msKhnHhknNen) {
                if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        makeMsg(MessageId.EHC1115, MessageId.EHC1115, syouhnNm, msKhnSdPdKbn.getContent()),
                        pMp);
                }
            }
        }

        if (hrkkkn != 0) {
            if (C_HrkkknsmnKbn.SAIMANKI.eq(hrkkknSmnkbn) && hrkkkn < msKhnHhknNen) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    makeMsg(MessageId.EHC1116, MessageId.EHC1116, syouhnNm, msKhnSdPdKbn.getContent()),
                    pMp);
            }
        }

        if(C_Sdpd.BLNK.eq(msKhnSdPdKbn)) {

            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI ,
                makeMsg(MessageId.EBA0027, MessageId.EBA0027, "Ｓ建Ｐ建"),  pMp);
        }
        else if(C_Sdpd.SD.eq(msKhnSdPdKbn)) {

            if(C_UmuKbn.NONE.eq(sdUmu)) {
                if (C_SysKbn.SKEI.eq(sysKbn)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        makeMsg(MessageId.EHC0019, MessageId.EHC0019, syouhnNm, msKhnSdPdKbn.getContent()),
                        pMp);
                }

                if(C_SysKbn.ESHIEN.eq(sysKbn)){
                    setHubiMsg.exec("",
                        MessageUtil.getMessage(MessageId.EGA1012, C_Sdpd.PD.getContent()),
                        C_SekmossakuseiErroutKbn.GAMEN,
                        pMp);
                    if (logger.isDebugEnabled()) {
                        logger.debug("△ 申込基本TBLチェック 終了");
                    }
                    return;
                }
            }
        }
        else if(C_Sdpd.PD.eq(msKhnSdPdKbn)) {
            if(C_UmuKbn.NONE.eq(pdUmu)) {
                if (C_SysKbn.SKEI.eq(sysKbn)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        makeMsg(MessageId.EHC0019, MessageId.EHC0019, syouhnNm, msKhnSdPdKbn.getContent()),
                        pMp);
                }

                if(C_SysKbn.ESHIEN.eq(sysKbn)){
                    setHubiMsg.exec("",
                        MessageUtil.getMessage(MessageId.EGA1012, C_Sdpd.SD.getContent()),
                        C_SekmossakuseiErroutKbn.GAMEN,
                        pMp);
                    if (logger.isDebugEnabled()) {
                        logger.debug("△ 申込基本TBLチェック 終了");
                    }
                    return;
                }
            }
        }

        List<BM_SyouhnToriatukaiTuuka> syouhnToriatukaiTuukaList =
            manager.getSyouhnToriatukaiTuukasByPk(syuSyouhnCd, kykymd, zenkizennouumu, kyktuukasyu, hrktuukasyu);

        if(syouhnToriatukaiTuukaList == null || syouhnToriatukaiTuukaList.size() == 0) {

            String replaceMsg = "";

            if (C_BlnktkumuKbn.BLNK.eq(zenkizennouumu)) {

                replaceMsg = C_BlnktkumuKbn.getContentByValue(C_BlnktkumuKbn.PATTERN_DEFAULT, C_BlnktkumuKbn.NONE.getValue());
            }
            else {

                replaceMsg = zenkizennouumu.getContent();
            }

            String wkMsg = "EHC1166" + " " +  MessageUtil.getMessage(MessageId.EHC1166, syouhnNm, kyktuukasyu.getContent(),
                hrktuukasyu.getContent(), replaceMsg);
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, wkMsg, pMp);
        }

        if (C_SysKbn.SKEI.eq(sysKbn)) {
            if(syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN &&
                C_Tuukasyu.USD.eq(kyktuukasyu) &&
                C_Tuukasyu.JPY.eq(hrktuukasyu) &&
                C_BlnktkumuKbn.NONE.eq(zenkizennouumu)) {

                if(C_YnkHrkmgkAnniTuutiKbn.BLNK.eq(ynkhrkmgkannituutikbn)){

                    String wkMsg =  "EHC1169" + " " + MessageUtil.getMessage(MessageId.EHC1169);
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, wkMsg, pMp);
                }
            }
            else {

                if(!C_YnkHrkmgkAnniTuutiKbn.BLNK.eq(ynkhrkmgkannituutikbn)) {

                    String wkMsg =  "EHC1170" + " " + MessageUtil.getMessage(MessageId.EHC1170);
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, wkMsg, pMp);
                }
            }
        }

        checkSntkHouSyouhin.exec(pMp, syouhnZokusei);

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_KouzokujkKbn.NONE.eq(pMp.getKouzokuSyoriJikkouKbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 申込基本TBLチェック 終了");
            }
            return;
        }

        String dispMsKhnSntkHouKbn = msKhnSntkHouKbn.getContent();

        if(C_SysKbn.SKEI.eq(sysKbn)){

            if(C_SntkhouKbn.KKT.eq(msKhnSntkHouKbn)) {
                if(C_UmuKbn.ARI.eq(hjyNrkUmu)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        makeMsg(MessageId.EHC0021, MessageId.EHC0021, dispMsKhnSntkHouKbn),
                        pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                }
            }
            else if(C_SntkhouKbn.NONE.eq(msKhnSntkHouKbn) || C_SntkhouKbn.SYOKUGYOU.eq(msKhnSntkHouKbn)) {
                if(C_UmuKbn.ARI.eq(kktNrkUmu)) {
                    if(C_UmuKbn.ARI.eq(hjyNrkUmu)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            makeMsg(MessageId.EHC0020, MessageId.EHC0020, dispMsKhnSntkHouKbn),
                            pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            makeMsg(MessageId.EHC0021, MessageId.EHC0021, dispMsKhnSntkHouKbn),
                            pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                    }
                    else {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            makeMsg(MessageId.EHC0020, MessageId.EHC0020, dispMsKhnSntkHouKbn),
                            pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                    }
                }
                else {
                    if(C_UmuKbn.ARI.eq(hjyNrkUmu)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            makeMsg(MessageId.EHC0021, MessageId.EHC0021, dispMsKhnSntkHouKbn),
                            pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                    }
                }
            }
        }

        if(C_SysKbn.SKEI.eq(sysKbn)){

            if (C_SntkhouKbn.SYOKUGYOU.eq(mosKihonTbl.getSntkhoukbn())) {
                sysDate = pMp.getSysDate();
                Integer kktKakoKyoyou = YuyuSinkeiyakuConfig.getInstance().getKktKakoKyoyou();
                BizDate kktKakoKyoyouYmd = sysDate.addDays(-kktKakoKyoyou);
                BizDate kktYmd = mosKihonTbl.getKktymd();

                if (kktYmd == null) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        makeMsg(MessageId.EBA0027, MessageId.EBA0027, ICommonKoumoku.DISP_S_KKTYMD), pMp);
                }

                if (kktYmd != null && kktKakoKyoyouYmd != null && sysDate != null) {
                    if (kktKakoKyoyouYmd.compareTo(kktYmd) <= 0 && kktYmd.compareTo(sysDate) <= 0) {
                    }
                    else {
                        C_TknKbn tokuNin = null;
                        if (C_KakoymdkyytknKbn.NONE.eq(kakohdktknkbn)) {
                            tokuNin = C_TknKbn.KANOU;
                        }
                        else {
                            tokuNin = C_TknKbn.SUMI;
                        }
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            makeMsg(MessageId.EBC0046, MessageId.EBC0046, ICommonKoumoku.DISP_S_KKTYMD),
                            pMp, tokuNin);
                    }
                }
            }
        }

        checkHrkKaisuu.exec(pMp, syouhnZokusei);

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_KouzokujkKbn.NONE.eq(pMp.getKouzokuSyoriJikkouKbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 申込基本TBLチェック 終了");
            }
            return;
        }

        checkHrkKeiro.exec(pMp, syouhnZokusei);

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_KouzokujkKbn.NONE.eq(pMp.getKouzokuSyoriJikkouKbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 申込基本TBLチェック 終了");
            }
            return;
        }

        checkZennouKanren.exec(pMp);

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_KouzokujkKbn.NONE.eq(pMp.getKouzokuSyoriJikkouKbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 申込基本TBLチェック 終了");
            }
            return;
        }

        mosSyouhnLst = syoriCTL.getMosSyouhnsByKatakbns(new C_KataKbn[]{C_KataKbn.HONIN_KO, C_KataKbn.HONNIN_SAISI});

        if(mosSyouhnLst != null && mosSyouhnLst.size() > 0) {
            if(msKhnMassiSeiYmd == null) {
                if(tokunin == null) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        makeMsg(MessageId.EBC0045, MessageId.EBC0045, ICommonKoumoku.DISP_S_MASSISEIYMD),
                        pMp,
                        C_TknKbn.KANOU, C_MsgKbn.ERROR);

                    if(C_SysKbn.ESHIEN.eq(sysKbn)){
                        if (logger.isDebugEnabled()) {
                            logger.debug("△ 申込基本TBLチェック 終了");
                        }
                        return;
                    }
                }
                else {
                    C_MassitknKbn massiTknKbn = tokunin.getMassitknkbn();

                    if(C_MassitknKbn.ARI.eq(massiTknKbn)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            makeMsg(MessageId.EBC0045, MessageId.EBC0045, ICommonKoumoku.DISP_S_MASSISEIYMD),
                            pMp,
                            C_TknKbn.SUMI, C_MsgKbn.ERROR);

                        if(C_SysKbn.ESHIEN.eq(sysKbn)){
                            if (logger.isDebugEnabled()) {
                                logger.debug("△ 申込基本TBLチェック 終了");
                            }
                            return;
                        }
                    }
                    else if(C_MassitknKbn.NONE.eq(massiTknKbn)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            makeMsg(MessageId.EBC0045, MessageId.EBC0045, ICommonKoumoku.DISP_S_MASSISEIYMD),
                            pMp,
                            C_TknKbn.KANOU, C_MsgKbn.ERROR);

                        if(C_SysKbn.ESHIEN.eq(sysKbn)){
                            if (logger.isDebugEnabled()) {
                                logger.debug("△ 申込基本TBLチェック 終了");
                            }
                            return;
                        }
                    }
                }
            }
        }
        else {
            if(msKhnMassiSeiYmd != null) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                    C_HubisyubetusyousaiKbn.NONE,
                    makeMsg(MessageId.EBC0007, MessageId.EBC0007, ICommonKoumoku.DISP_S_MASSISEIYMD),
                    pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);

                if(C_SysKbn.ESHIEN.eq(sysKbn)){
                    if (logger.isDebugEnabled()) {
                        logger.debug("△ 申込基本TBLチェック 終了");
                    }
                    return;
                }
            }
        }

        if(msKhnMassiSeiYmd != null) {
            if(msKhnMassiSeiYmd.compareTo(msKhnMosYmd) > 0) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                    C_HubisyubetusyousaiKbn.NONE,
                    makeMsg(MessageId.EBC0046, MessageId.EBC0046, ICommonKoumoku.DISP_S_MASSISEIYMD),
                    pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);

                if(C_SysKbn.ESHIEN.eq(sysKbn)){
                    if (logger.isDebugEnabled()) {
                        logger.debug("△ 申込基本TBLチェック 終了");
                    }
                    return;
                }
            }
        }

        if(C_SysKbn.SKEI.eq(sysKbn)){

            if(C_FstphrkkeiroKbn.KOUHURI.eq(msKhnFstPHrkKeiro)) {
                if(msKhn1PRsYmd == null) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        makeMsg(MessageId.EBC0045, MessageId.EBC0045, ICommonKoumoku.DISP_S_1PRSYMD),
                        pMp);
                }
            }
            else {
                if(msKhn1PRsYmd != null) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        makeMsg(MessageId.EBC0007, MessageId.EBC0007, ICommonKoumoku.DISP_S_1PRSYMD),
                        pMp);
                }
            }
        }

        checkMeigininNmKanaCall.execHhkn(pMp);

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_KouzokujkKbn.NONE.eq(pMp.getKouzokuSyoriJikkouKbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 申込基本TBLチェック 終了");
            }
            return;
        }

        checkSeiYmd.exec(pMp, msKhnHhknSeiYmd, ICommonKoumoku.DISP_S_HHKNSEIYMD);

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_KouzokujkKbn.NONE.eq(pMp.getKouzokuSyoriJikkouKbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 申込基本TBLチェック 終了");
            }
            return;
        }

        if(C_SysKbn.SKEI.eq(sysKbn)){

            if (BizUtil.isBlank(hhknsykgyCd)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    makeMsg(MessageId.EBC0045, MessageId.EBC0045, ICommonKoumoku.DISP_S_HHKNSYKGYCD),
                    pMp);
            }

            if (!BizUtil.isBlank(hhknsykgyCd)) {
                BM_Syokugyou syokugyouMst = manager.getSyokugyou(hhknsykgyCd);

                if (syokugyouMst == null) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        makeMsg(MessageId.EBA0030, MessageId.EBA0030, ICommonKoumoku.DISP_S_HHKNSYKGYCD),
                        pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                }
            }

        }

        if(C_SysKbn.SKEI.eq(sysKbn)){

            if (!C_UmuKbn.ARI.eq(itijibrumu) &&
                !C_UmuKbn.ARI.eq(nkhknumu) &&
                C_NensyuuKbn.BLNK.eq(hhknNensyuuKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    makeMsg(MessageId.EBC0045, MessageId.EBC0045, ICommonKoumoku.DISP_S_HHKNNENSYUU),
                    pMp);
            }
        }

        if(C_SysKbn.SKEI.eq(sysKbn)){
            checkTelNoCall.execHhkn(pMp);

        }

        checkMeigininNmKanaCall.execKyk(pMp);

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_KouzokujkKbn.NONE.eq(pMp.getKouzokuSyoriJikkouKbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 申込基本TBLチェック 終了");
            }
            return;
        }

        checkKykSeiYmdKanren.exec(pMp);

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_KouzokujkKbn.NONE.eq(pMp.getKouzokuSyoriJikkouKbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 申込基本TBLチェック 終了");
            }
            return;
        }

        checkSeiYmd.exec(pMp, msKhnKykSeiYmd, ICommonKoumoku.DISP_S_KYKSEIYMD);

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_KouzokujkKbn.NONE.eq(pMp.getKouzokuSyoriJikkouKbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 申込基本TBLチェック 終了");
            }
            return;
        }

        checkKykSeibetu.exec(pMp);

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_KouzokujkKbn.NONE.eq(pMp.getKouzokuSyoriJikkouKbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 申込基本TBLチェック 終了");
            }
            return;
        }

        checkKykKanren.exec(pMp);

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_KouzokujkKbn.NONE.eq(pMp.getKouzokuSyoriJikkouKbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 申込基本TBLチェック 終了");
            }
            return;
        }

        checkTelNoCall.execTuusin(pMp);

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_KouzokujkKbn.NONE.eq(pMp.getKouzokuSyoriJikkouKbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 申込基本TBLチェック 終了");
            }
            return;
        }

        if(C_SysKbn.SKEI.eq(sysKbn)){
            checkTelNoCall.execDainiTuusin(pMp);

        }

        checkNnknTokuyaku.exec(pMp);

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_KouzokujkKbn.NONE.eq(pMp.getKouzokuSyoriJikkouKbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 申込基本TBLチェック 終了");
            }
            return;
        }

        if(C_SysKbn.SKEI.eq(sysKbn)){

            if(!BizUtil.isBlank(daiMosno)) {
                if(!C_Hrkkeiro.DANTAI.eq(msKhnHrkKeiro)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        makeMsg(MessageId.EHC0087, MessageId.EHC0087),
                        pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                }

                if(!daiMosno.equals(mosNo)) {
                    mosKihonDaihyou = sinkeiyakuDomManager.getSyoriCTL(daiMosno).getMosKihon();

                    if(mosKihonDaihyou != null) {
                        msKhnDntCdDaihyou = mosKihonDaihyou.getDntcd();
                    }
                    else {
                        msKhnDntCdDaihyou = "";
                    }

                    if(!msKhnDntCd.equals(msKhnDntCdDaihyou)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            makeMsg(MessageId.EHC0088, MessageId.EHC0088),
                            pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                    }
                }

                if(!C_Kyksei.HJNKYK.eq(msKhnKykSei)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        makeMsg(MessageId.EHC0092, MessageId.EHC0092),
                        pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                }
            }
        }

        if(C_SysKbn.SKEI.eq(sysKbn)){

            CheckUktNinzuu checkUktNinzuu = SWAKInjector.getInstance(CheckUktNinzuu.class);
            checkUktNinzuu.exec(pMp);

        }

        if (C_UmuKbn.ARI.eq(tmttknHaibunWarisiteiUmu)) {

            if (C_TumitatekinHaibunWariKbn.BLNK.eq(sisuuHaibunWariKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                    C_HubisyubetusyousaiKbn.NONE,
                    makeMsg(MessageId.EBC0045, MessageId.EBC0045, "指数連動部分割合"),
                    pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
            }

            if (C_TumitatekinHaibunWariKbn.BLNK.eq(teirituHaibunWariKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                    C_HubisyubetusyousaiKbn.NONE,
                    makeMsg(MessageId.EBC0045, MessageId.EBC0045, "定率積立部分割合"),
                    pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
            }

            if (!C_TumitatekinHaibunWariKbn.BLNK.eq(teirituHaibunWariKbn) &&
                !C_TumitatekinHaibunWariKbn.BLNK.eq(sisuuHaibunWariKbn) &&
                (Integer.parseInt(teirituHaibunWariKbn.getValue()) + Integer.parseInt(sisuuHaibunWariKbn.getValue()) != 100)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                    C_HubisyubetusyousaiKbn.NONE,
                    makeMsg(MessageId.EHC1065, MessageId.EHC1065),
                    pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
            }
        }

        checkPmentkKanren.exec(pMp, syouhnZokusei);

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_KouzokujkKbn.NONE.eq(pMp.getKouzokuSyoriJikkouKbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 申込基本TBLチェック 終了");
            }
            return;
        }

        DrtenTkykTratkiHantei drtenTkykTratkiHantei = SWAKInjector.getInstance(DrtenTkykTratkiHantei.class);

        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.targettkTratkiHantei(
            targetTkhukaKanouKbn, skeijimukbn, oyaDrtenCd);

        if (C_TkykTratkiKbn.BLNK.eq(tkykTratkiKbn) && !C_Tkhukaumu.BLNK.eq(targetTkhkKbn)) {

            if(C_SysKbn.SKEI.eq(sysKbn)){

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                    C_HubisyubetusyousaiKbn.NONE,
                    makeMsg(MessageId.EHC0197, MessageId.EHC0197, syouhnNm, "ターゲット特約"),
                    pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
            }

            else {

                setHubiMsg.exec("",
                    MessageUtil.getMessage(MessageId.EGA1037),
                    C_SekmossakuseiErroutKbn.GAMEN,
                    pMp);

                if (logger.isDebugEnabled()) {
                    logger.debug("△ 申込基本TBLチェック 終了");
                }

                return;
            }
        }

        if (C_TkykTratkiKbn.HUKAHISSU.eq(tkykTratkiKbn) && !C_Tkhukaumu.HUKA.eq(targetTkhkKbn)) {

            if(C_SysKbn.SKEI.eq(sysKbn)){

                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    makeMsg(MessageId.EHC1061, MessageId.EHC1061, syouhnNm, targetTkhukaKanouKbn.getContent(),
                        ICommonKoumoku.DISP_N_MOKUHYOUTI),
                        pMp);
            }

            else {

                setHubiMsg.exec("",
                    MessageUtil.getMessage(MessageId.EGA1038),
                    C_SekmossakuseiErroutKbn.GAMEN,
                    pMp);

                if (logger.isDebugEnabled()) {
                    logger.debug("△ 申込基本TBLチェック 終了");
                }

                return;
            }
        }

        if (C_TkykTratkiKbn.TRATKINASI.eq(tkykTratkiKbn) && C_Tkhukaumu.HUKA.eq(targetTkhkKbn)) {

            if(C_SysKbn.SKEI.eq(sysKbn)){

                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    makeMsg(MessageId.EHC0197, MessageId.EHC0197, syouhnNm, targetTkhukaKanouKbn.getContent()),
                    pMp);
            }

            else {

                setHubiMsg.exec("",
                    MessageUtil.getMessage(MessageId.EGA1037),
                    C_SekmossakuseiErroutKbn.GAMEN,
                    pMp);

                if (logger.isDebugEnabled()) {
                    logger.debug("△ 申込基本TBLチェック 終了");
                }

                return;
            }
        }

        if (C_Tkhukaumu.HUKA.eq(targetTkhkKbn) && C_TargetTkMokuhyoutiKbn.BLNK.eq(targetTkMkhtKbn)){
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                makeMsg(MessageId.EBC0045, MessageId.EBC0045, ICommonKoumoku.DISP_N_MOKUHYOUTI,
                    ICommonKoumoku.DISP_N_MKHYOUTIYENSYSNIKOUTK,ICommonKoumoku.DISP_N_MOKUHYOUTI), pMp);

            if(C_SysKbn.ESHIEN.eq(sysKbn)){
                if (logger.isDebugEnabled()) {
                    logger.debug("△ 申込基本TBLチェック 終了");
                }
                return;
            }
        }

        if (C_Tkhukaumu.HUKA.eq(targetTkhkKbn) && !C_TargetTkMokuhyoutiKbn.BLNK.eq(targetTkMkhtKbn)){
            List<BM_ChkTargetTkMokuhyouti> chkTargetTkMokuhyoutiLst = manager.getChkTargetTkMokuhyoutisByPk(
                syuSyouhnCd,
                syuSyouhnsdNo,
                kiteiChkChannelCd,
                Integer.valueOf(targetTkMkhtKbn.getValue()));

            if (chkTargetTkMokuhyoutiLst == null || chkTargetTkMokuhyoutiLst.size() == 0) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    makeMsg(MessageId.EHC0038, MessageId.EHC0038, syouhnNm, ICommonKoumoku.DISP_N_MOKUHYOUTI),
                    pMp);

                if(C_SysKbn.ESHIEN.eq(sysKbn)){
                    if (logger.isDebugEnabled()) {
                        logger.debug("△ 申込基本TBLチェック 終了");
                    }
                    return;
                }
            }
        }
        if(!C_Tkhukaumu.HUKA.eq(targetTkhkKbn) && !C_TargetTkMokuhyoutiKbn.BLNK.eq(targetTkMkhtKbn)){
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                makeMsg(MessageId.EBC0012, MessageId.EBC0012, ICommonKoumoku.DISP_N_MOKUHYOUTI, ICommonKoumoku.DISP_N_MOKUHYOUTI),
                pMp);

            if(C_SysKbn.ESHIEN.eq(sysKbn)){
                if (logger.isDebugEnabled()) {
                    logger.debug("△ 申込基本TBLチェック 終了");
                }
                return;
            }
        }

        if (C_UmuKbn.NONE.eq(syouhnKzktrkServiceUmu) && C_KzktourokuserviceTourokuKbn.ARI.eq(kzktrkserviceTrkKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                makeMsg(MessageId.EHC0197, MessageId.EHC0197, syouhnNm, ICommonKoumoku.DISP_N_KZKTRKSRV),
                pMp);

            if(C_SysKbn.ESHIEN.eq(sysKbn)){
                if (logger.isDebugEnabled()) {
                    logger.debug("△ 申込基本TBLチェック 終了");
                }
                return;
            }
        }

        if (C_UmuKbn.NONE.eq(syouhnKykdrtkykUmu) && C_Tkhukaumu.HUKA.eq(kykdrTkykhukaKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                makeMsg(MessageId.EHC0197, MessageId.EHC0197, syouhnNm, ICommonKoumoku.DISP_N_HKNKYKDRTKY),
                pMp);

            if(C_SysKbn.ESHIEN.eq(sysKbn)){
                if (logger.isDebugEnabled()) {
                    logger.debug("△ 申込基本TBLチェック 終了");
                }
                return;
            }
        }

        if (C_UmuKbn.NONE.eq(syouhnStdrsktkUmu) && C_Tkhukaumu.HUKA.eq(stdrskTkyhkKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                makeMsg(MessageId.EHC0197, MessageId.EHC0197, syouhnNm, ICommonKoumoku.DISP_N_HHKNDRTKY),
                pMp);

            if(C_SysKbn.ESHIEN.eq(sysKbn)){
                if (logger.isDebugEnabled()) {
                    logger.debug("△ 申込基本TBLチェック 終了");
                }
                return;
            }
        }

        if (C_UmuKbn.NONE.eq(syouhnYenshrtkhkUmu) && C_Tkhukaumu.HUKA.eq(yenshrTkhkKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA, C_HubisyubetusyousaiKbn.NONE,
                makeMsg(MessageId.EHC0197, MessageId.EHC0197, syouhnNm, ICommonKoumoku.DISP_N_YENKASHRTK),
                pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);

            if(C_SysKbn.ESHIEN.eq(sysKbn)){
                if (logger.isDebugEnabled()) {
                    logger.debug("△ 申込基本TBLチェック 終了");
                }
                return;
            }
        }

        C_TkykTratkiKbn yennYkntkTratkiKbn = drtenTkykTratkiHantei.yennykntkTratkiHantei(syuSyouhnCd,
            syouhnPyennykntkUmu, skeijimukbn, oyaDrtenCd);

        if (C_TkykTratkiKbn.HUKAHISSU.eq(yennYkntkTratkiKbn) && !C_Tkhukaumu.HUKA.eq(yennyknTkhkKbn)) {

            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MakeHubiMsg.exec(MessageId.EHC1083, MessageId.EHC1083,
                syouhnNm, ICommonKoumoku.DISP_N_HOKENRYOUYENKAHARAIKOMITK), pMp);

            if (C_SysKbn.ESHIEN.eq(sysKbn)) {

                if (logger.isDebugEnabled()) {
                    logger.debug("△ 申込基本TBLチェック 終了");
                }
                return;
            }
        }
        else if ((C_TkykTratkiKbn.BLNK.eq(yennYkntkTratkiKbn) || C_TkykTratkiKbn.TRATKINASI.eq(yennYkntkTratkiKbn))
            && C_Tkhukaumu.HUKA.eq(yennyknTkhkKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MakeHubiMsg.exec(MessageId.EHC0197, MessageId.EHC0197, syouhnNm,
                    ICommonKoumoku.DISP_N_HOKENRYOUYENKAHARAIKOMITK), pMp);

            if(C_SysKbn.ESHIEN.eq(sysKbn)){
                if (logger.isDebugEnabled()) {
                    logger.debug("△ 申込基本TBLチェック 終了");
                }
                return;
            }
        }

        C_TkykTratkiKbn gaikanTkykTratkiKbn = drtenTkykTratkiHantei.gaikanykntkTratkiHantei(syuSyouhnCd,
            syouhnGaikanYuukinTktekiUmu, skeijimukbn, oyaDrtenCd);

        if ((C_TkykTratkiKbn.BLNK.eq(gaikanTkykTratkiKbn) || C_TkykTratkiKbn.TRATKINASI.eq(gaikanTkykTratkiKbn))
            && C_Tkhukaumu.HUKA.eq(gaikanyknTkhkKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MakeHubiMsg.exec(MessageId.EHC0197, MessageId.EHC0197, syouhnNm,
                    ICommonKoumoku.DISP_N_HOKENRYOUSITEIGAIKAHARAIKOMITK), pMp);

            if(C_SysKbn.ESHIEN.eq(sysKbn)){
                if (logger.isDebugEnabled()) {
                    logger.debug("△ 申込基本TBLチェック 終了");
                }
                return;
            }
        }

        C_TkykTratkiKbn initsbjiYenknsnshrgkSaiteihsytk = drtenTkykTratkiHantei
            .initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(syuSyouhnCd, syksbYensitihsyuTktekiUmu, skeijimukbn,
                oyaDrtenCd);

        if (C_TkykTratkiKbn.HUKAHISSU.eq(initsbjiYenknsnshrgkSaiteihsytk)
            && !C_Tkhukaumu.HUKA.eq(syksbYensitihsyuTkhkKbn)) {

            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                makeMsg(MessageId.EHC1083, MessageId.EHC1083, syouhnNm, "初期死亡時円換算支払額最低保証特約"),
                pMp);
        }
        else if (C_TkykTratkiKbn.TRATKINASI.eq(initsbjiYenknsnshrgkSaiteihsytk)
            && C_Tkhukaumu.HUKA.eq(syksbYensitihsyuTkhkKbn)) {

            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                makeMsg(MessageId.EHC0197, MessageId.EHC0197, syouhnNm, "初期死亡時円換算支払額最低保証特約"),
                pMp);
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getJyudkaigomehrtktekiumu()) &&
            C_Tkhukaumu.BLNK.eq(mosKihonTbl.getJyudkaigomehrtkhkkbn())) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                makeMsg(MessageId.EBC0045, MessageId.EBC0045, ICommonKoumoku.DISP_N_JYUDKAIGOMEHRTKHKKBN),
                pMp);
        }
        else if (C_UmuKbn.NONE.eq(syouhnZokusei.getJyudkaigomehrtktekiumu()) &&
            !C_Tkhukaumu.BLNK.eq(mosKihonTbl.getJyudkaigomehrtkhkkbn())) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                makeMsg(MessageId.EHC1036, MessageId.EHC1036, syouhnNm),
                pMp);
        }

        if (tuusan != null && C_Tkhukaumu.HUKA.eq(mosKihonTbl.getJyudkaigomehrtkhkkbn()) &&
            C_UmuKbn.ARI.eq(tuusan.getTsnkaigomehrtkumukbn())) {

            if(C_SysKbn.SKEI.eq(sysKbn)){

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA, C_HubisyubetusyousaiKbn.NONE,
                    makeMsg(MessageId.EHC1037, MessageId.EHC1037),
                    pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
            }

            else {
                setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1048), C_SekmossakuseiErroutKbn.GAMEN, pMp);

                if (logger.isDebugEnabled()) {
                    logger.debug("△ 申込基本TBLチェック 終了");
                }
                return;
            }
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getZeiseitekikakuumu())) {

            if (C_Tkhukaumu.BLNK.eq(kjnnkpZeitekitkHukaKbn)) {

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                    C_HubisyubetusyousaiKbn.NONE,
                    MakeHubiMsg.exec(MessageId.EBC0045, MessageId.EBC0045, ICommonKoumoku.DISP_N_KJNNKPZEITEKITKHUKA),
                    pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
            }
            else if (C_Tkhukaumu.HUKA.eq(kjnnkpZeitekitkHukaKbn)) {

                KhConvUtil khConvUtil = SWAKInjector.getInstance(yuyu.common.hozen.renkei.KhConvUtil.class);
                CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(
                    yuyu.common.hozen.khcommon.CheckZeiseiTkkkTkykHukaJyouken.class);

                C_Nenkinsyu nenkinsyuHenkango = khConvUtil.convNksyukbn(skneNkinSyu);
                int nenkinKknHenkango = khConvUtil.convNenkinkkn(skneNkinSyu);
                C_Tdk kykTdkHenkango = khConvUtil.convKyktdk(msKhnKyksyaKbn, kykTdk);
                C_UktKbn nenkinuktKbn = C_UktKbn.BLNK;

                if (uketoriNinLst.size() != 0) {

                    nenkinuktKbn = uketoriNinLst.get(0).getUktkbn();
                }

                checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJk(kykTdkHenkango, nenkinuktKbn, msKhnHhknNen,
                    hrkkknSmnkbn, hrkkkn, hknkknSmnKbn, hknkkn, nenkinsyuHenkango, nenkinKknHenkango);

                boolean zeiseitkkktkykHukaHanteiKekka = checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk();

                if (!zeiseitkkktkykHukaHanteiKekka) {
                    if (C_SysKbn.SKEI.eq(sysKbn)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE, MakeHubiMsg.exec(MessageId.EBC0014, MessageId.EBC0014,
                                ICommonKoumoku.DISP_N_KJNNKPZEITEKITKHUKA), pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                    }else{
                        List<Integer> errorCodeList = checkZeiseiTkkkTkykHukaJyouken.getErrorCodeList();
                        String seihoWebErrorMessage = null;

                        if (errorCodeList != null && errorCodeList.size() > 0) {
                            if (errorCodeList.contains(CheckZeiseiTkkkTkykHukaJyouken.NENKINUKETORININ_DAISANSYA_HUBIERROR)) {
                                seihoWebErrorMessage = MakeHubiMsg.exec(MessageId.EGA1050,MessageId.EGA1050);
                            }
                            else if (errorCodeList.contains(CheckZeiseiTkkkTkykHukaJyouken.NENKINUKETORININ_HONNIN_HUBIERROR)) {
                                seihoWebErrorMessage = MakeHubiMsg.exec(MessageId.EGA1049,MessageId.EGA1049);
                            }
                            else if (errorCodeList.contains(CheckZeiseiTkkkTkykHukaJyouken.HOKENHARAIKOMIKIKAN_HUBIERROR)) {
                                seihoWebErrorMessage = MakeHubiMsg.exec(MessageId.EGA1051,MessageId.EGA1051);
                            }
                            else if (errorCodeList.contains(CheckZeiseiTkkkTkykHukaJyouken.NENKINKAISINENREI_HUBIERROR)) {
                                seihoWebErrorMessage = MakeHubiMsg.exec(MessageId.EGA1053,MessageId.EGA1053);
                            }
                            else if (errorCodeList.contains(CheckZeiseiTkkkTkykHukaJyouken.NENKINSIHARAIKIKAN_HUBIERROR)) {
                                seihoWebErrorMessage = MakeHubiMsg.exec(MessageId.EGA1052,MessageId.EGA1052);
                            }
                        } else {
                            seihoWebErrorMessage = MakeHubiMsg.exec(MessageId.EBC0014, MessageId.EBC0014,
                                ICommonKoumoku.DISP_N_KJNNKPZEITEKITKHUKA);
                        }

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE, seihoWebErrorMessage, pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);

                        if (logger.isDebugEnabled()) {
                            logger.debug("△ 申込基本TBLチェック 終了");
                        }
                        return;
                    }
                }
            }
        }
        else {

            if (!C_Tkhukaumu.BLNK.eq(kjnnkpZeitekitkHukaKbn)) {

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                    C_HubisyubetusyousaiKbn.NONE, MakeHubiMsg.exec(MessageId.EBC0014, MessageId.EBC0014,
                        ICommonKoumoku.DISP_N_KJNNKPZEITEKITKHUKA), pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
            }
        }


        if (C_UmuKbn.ARI.eq(syouhnZokusei.getTeikisiharaikinumu())) {
            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ) {
                if (!C_Tkhukaumu.HUKA.eq(teikiShrtkHukaKbn)) {

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANHUKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MakeHubiMsg.exec(MessageId.EHC1083, MessageId.EHC1083, syouhnNm, ICommonKoumoku.DISP_N_SITEITUUKANENKINHKTEIKISHRTK),
                        pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                }
                else if (!C_TumitatekinHaibunWariKbn.WARIAI000.eq(mosKihonTbl.getSisuuhaibunwarikbn()) &&
                    !C_TumitatekinHaibunWariKbn.BLNK.eq(mosKihonTbl.getSisuuhaibunwarikbn())) {

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANHUKA,
                        C_HubisyubetusyousaiKbn.NONE, MakeHubiMsg.exec(MessageId.EHC1142, MessageId.EHC1142),
                        pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                }
            }
            else if (C_Tkhukaumu.BLNK.eq(teikiShrtkHukaKbn)) {

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANHUKA,
                    C_HubisyubetusyousaiKbn.NONE,
                    MakeHubiMsg.exec(MessageId.EBC0045, MessageId.EBC0045, ICommonKoumoku.DISP_N_SITEITUUKANENKINHKTEIKISHRTK),
                    pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);

            }
        }
        else {
            if ((syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20  &&
                C_Tkhukaumu.HUKA.eq(teikiShrtkHukaKbn)) ||
                (syohinHanteiKbn != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20  &&
                !C_Tkhukaumu.BLNK.eq(teikiShrtkHukaKbn))) {

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANHUKA,
                    C_HubisyubetusyousaiKbn.NONE,
                    MakeHubiMsg.exec(MessageId.EBC0014, MessageId.EBC0014, ICommonKoumoku.DISP_N_SITEITUUKANENKINHKTEIKISHRTK),
                    pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
            }
        }

        if ((!C_HaitouKbn.BLNK.eq(haitouKbn) && !C_HaitouKbn.NONE.eq(haitouKbn)) &&
            C_HaitoukinuketorihouKbn.BLNK.eq(haitoukinuketorihouKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA, C_HubisyubetusyousaiKbn.NONE,
                makeMsg(MessageId.EBA0027, MessageId.EBA0027, ICommonKoumoku.DISP_N_HAITOUKINUKETORIHOU),
                pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);

            if(C_SysKbn.ESHIEN.eq(sysKbn)){
                if (logger.isDebugEnabled()) {
                    logger.debug("△ 申込基本TBLチェック 終了");
                }
                return;
            }
        }

        if(C_SysKbn.SKEI.eq(sysKbn)){

            if (C_HonninkakuninSyoruiKbn.BLNK.eq(kykhonninkakninsyoruiKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    makeMsg(MessageId.EBA0027, MessageId.EBA0027, ICommonKoumoku.DISP_N_KYKHONNINKAKNINSYORUIINFO),
                    pMp);
            }
        }

        if(C_SysKbn.SKEI.eq(sysKbn)){

            if (C_DirectServiceMosKbn.BLNK.eq(drctDerviceMosKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    makeMsg(MessageId.EHC1139, MessageId.EHC1139), pMp);
            }

            else if (C_SkeijimuKbn.MIZUHO.eq(skeijimukbn)
                && BizDateUtil.compareYmd(msKhnMosYmd, mizuhoDirectServiceKaisiYmd) == BizDateUtil.COMPARE_LESSER) {
                if (!C_DirectServiceMosKbn.NOENTRY.eq(drctDerviceMosKbn)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                        makeMsg(MessageId.EHC1075, MessageId.EHC1075, skeijimukbn.getContent()), pMp);
                }

            }

            else if (!C_DirectServiceMosKbn.NOENTRY.eq(drctDerviceMosKbn)) {
                int nen = 0;
                if (C_KykKbn.KEIHI_DOUITU.eq(msKhnKyksyaKbn)) {
                    nen = msKhnHhknNen;
                }
                else {
                    nen = msKhnKykNen;
                }
                if (nen < 18) {
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                        makeMsg(MessageId.EHC1009, MessageId.EHC1009), pMp);
                }
            }
        }

        if (C_SysKbn.SKEI.eq(sysKbn)) {
            if (C_UmuKbn.ARI.eq(tsryHshrkykumuKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                    makeMsg(MessageId.WHC1013, MessageId.WHC1013), pMp);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 申込基本TBLチェック 終了");
        }
    }

    private String makeMsg(String pInMessageID, String pMsgID) {
        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageID);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgID));
        return ret.toString();
    }

    private String makeMsg(String pInMessageID, String pMsgID, String pReplaceMsg1) {
        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageID);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg1));
        return ret.toString();
    }

    private String makeMsg(String pInMessageID,
        String pMsgID,
        String pReplaceMsg1,
        String pReplaceMsg2) {
        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageID);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg1, pReplaceMsg2));
        return ret.toString();
    }

    private String makeMsg(String pInMessageID,
        String pMsgID,
        String pReplaceMsg1,
        String pReplaceMsg2,
        String pReplaceMsg3
        ) {
        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageID);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg1, pReplaceMsg2, pReplaceMsg3));
        return ret.toString();
    }

}
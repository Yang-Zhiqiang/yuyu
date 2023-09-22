package yuyu.common.sinkeiyaku.moschk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.SetDenSimebi;
import yuyu.common.sinkeiyaku.skcommon.ConvNenSaiManki;
import yuyu.common.sinkeiyaku.skcommon.GetRsgakukei;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_BoskyuusiKijyunymdKbn;
import yuyu.def.classification.C_BoskyuusiRiyuuKbn;
import yuyu.def.classification.C_BosyuusysctrlKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_Kykymdtkrumu;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SknnkaisikitkhukaKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SyosaiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteikykymdKbn;
import yuyu.def.classification.C_YoteirirituhendouKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.BM_BosyuuKyuusi;
import yuyu.def.db.entity.BM_Simekiribi;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_Houjyou;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.sinkeiyaku.sorter.SortHT_Nyuukin;

/**
 * 新契約 申込内容チェック 基礎項目設定
 */
public class SetKisoKoumoku {

    private final static int KANOUNISSUU = 7;

    private final static int YMKJYMD = 18;

    private final static String MOSYMKBN = "2";

    private final static String BOSYUUYMKBN = "1";

    private boolean BosyuuKyuusiRateGtFlg  = false;

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private SetSyouhinSedai setSyouhinSedai;

    @Inject
    private SetDenSimebi setDenSimebi;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SetNenrei setNenrei;

    public SetKisoKoumoku() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 基礎項目設定 開始");
        }

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        String mosNo = syoriCTL.getMosno();
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        BosyuuKyuusiRateGtFlg = false;

        if (mosSyouhnLst.size() != 1) {

            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + mosNo);
        }

        BizDate rsYmd = null;
        rsYmd = setRsYmd(syoriCTL, mosKihon, pMP);

        if (logger.isDebugEnabled()) {
            logger.debug("｜    WK１領収日=" + rsYmd);
        }

        C_SntkhouKbn sntkHouKbn = mosKihon.getSntkhoukbn();
        BizDate kktYmd = null;
        BizDate kktiAtkKktYmd = null;
        BizDate hjyAtkKktYmd = null;

        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {
            if (C_SntkhouKbn.NONE.eq(sntkHouKbn)) {

            }
            else if (C_SntkhouKbn.SYOKUGYOU.eq(sntkHouKbn)) {

                kktYmd = mosKihon.getKktymd();
            }
            else {

                kktiAtkKktYmd = setKktymd(syoriCTL, mosNo)[0];
                hjyAtkKktYmd = setKktymd(syoriCTL, mosNo)[1];

                if (C_SntkhouKbn.HJY.eq(sntkHouKbn)) {

                    kktYmd = hjyAtkKktYmd;
                }
                if (C_SntkhouKbn.KKT.eq(sntkHouKbn)) {

                    kktYmd = kktiAtkKktYmd;
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("｜    WK1告知扱告知日=" + kktiAtkKktYmd);
            logger.debug("｜    WK1報状扱告知日=" + hjyAtkKktYmd);
            logger.debug("｜    WK1職業のみ告知告知日=" + mosKihon.getKktymd());
        }

        BizDate mosYmd =  mosKihon.getMosymd();
        BizDate mosukeYmd = mosKihon.getMosukeymd();
        C_SknnkaisikitkhukaKbn sknnKaisikiTkHukaKbn = mosKihon.getSknnkaisikitkhukakbn();

        if (logger.isDebugEnabled()) {
            logger.debug("｜    申込日=" + mosYmd);
        }

        SetSknnkaisiymd setSknnkaisiymd = SWAKInjector.getInstance(SetSknnkaisiymd.class);
        setSknnkaisiymd.exec(sntkHouKbn, kktYmd, mosYmd, rsYmd,
            sknnKaisikiTkHukaKbn, mosukeYmd);
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();
        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();

        BizDate siteiKykYmd = null;
        if (C_Kykymdtkrumu.ARI.eq(mosKihon.getKykymdtkrumu())) {

            siteiKykYmd =  sknnKaisiYmd;
        }

        BizDate kykYmd  = setkykymdHantei(mosKihon, mosSyouhnLst.get(0), rsYmd, mosYmd, kariSknnKaisiYmd,
            pMP.getSysDate(), pMP.getSysKbn(), pMP.getYoteiKykymdKbn());

        if (logger.isDebugEnabled()) {
            logger.debug("｜    WK2契約日=" + kykYmd);
        }

        if (siteiKykYmd != null) {

            kykYmd = siteiKykYmd;
        }

        setSyouhinSedai.exec(pMP, kykYmd);

        mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (mosSyouhnLst.size() != 1) {
            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + mosNo);
        }

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(
            mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());

        pMP.setSyuSyouhnZokusei(syouhnZokusei);

        List<HT_MosSyouhn> tkMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        List<BM_SyouhnZokusei> tkSyouhnZokuseiLst = new ArrayList<>();

        for (int i = 0; i < tkMosSyouhnLst.size(); i++) {

            BM_SyouhnZokusei tkSyouhnZokusei = bizDomManager.getSyouhnZokusei(tkMosSyouhnLst.get(i).getSyouhncd(),
                tkMosSyouhnLst.get(i).getSyouhnsdno());

            tkSyouhnZokuseiLst.add(tkSyouhnZokusei);
        }

        pMP.setListTkSyouhnZokusei(tkSyouhnZokuseiLst);

        C_ErrorKbn bosyuuErrorKbn = checkBosyuuKyuusi(pMP, mosSyouhn.getSyouhncd(), "", "", C_SkeijimuKbn.BLNK
            , C_BoskyuusiRiyuuKbn.BLNK, kykYmd, sknnKaisiYmd, mosYmd);

        if (C_ErrorKbn.ERROR.eq(bosyuuErrorKbn)) {

            if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {

                logger.debug("△ 基礎項目設定 終了");
                return;
            }
        }

        BizNumber yoteiriritu = BizNumber.valueOf(0);
        BizNumber tumitateriritu = BizNumber.valueOf(0);
        BizNumber tmttknzoukaritujygn = BizNumber.valueOf(0);
        BizNumber setteibairitu = BizNumber.valueOf(0);
        BizNumber loadingHnkgtumitateRiritu = BizNumber.valueOf(0);
        BizNumber rendouRitu = BizNumber.valueOf(0);
        GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

        getYoteirirituBean.setSyouhncd(mosSyouhn.getSyouhncd());
        getYoteirirituBean.setKijyunymd(kykYmd);
        getYoteirirituBean.setSknnkaisiymd(kariSknnKaisiYmd);
        getYoteirirituBean.setKykymd(kykYmd);
        getYoteirirituBean.setHknkkn(mosSyouhn.getHknkkn());
        getYoteirirituBean.setHknkknsmnkbn(mosSyouhn.getHknkknsmnkbn());
        getYoteirirituBean.setHhknnen(mosKihon.getHhknnen());
        getYoteirirituBean.setSitihsyuriritu(syouhnZokusei.getYoteirirituminhosyouritu());

        getYoteirirituBean.setTuukasyu(mosKihon.getKyktuukasyu());

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn errorKbn = getYoteiriritu.exec(getYoteirirituBean);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            if (!C_YoteirirituhendouKbn.NONE.eq(syouhnZokusei.getYoteirirituhendoukbn()) &&
                C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                String bosyuuKyuusiSyouhinMsg = getBosyuuKyuusiSyouhinMsg(pMP.getSysKbn(),syouhnZokusei, syoriCTL, mosKihon, mosSyouhn);
                if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {
                    if (BosyuuKyuusiRateGtFlg == false) {
                        String message = MessageId.EHC1120 + " " + MessageUtil.getMessage(MessageId.EHC1120, bosyuuKyuusiSyouhinMsg);
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, message, pMP);
                    }
                }
                else {
                    setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1054, bosyuuKyuusiSyouhinMsg),
                        C_SekmossakuseiErroutKbn.GAMEN, pMP);
                }
            }
            else {
                if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {
                    String message = MessageId.EHC1048 + " " + MessageUtil.getMessage(MessageId.EHC1048,
                        syouhnZokusei.getSyouhnnm(), kykYmd.toString());

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, message, pMP);
                }
                else if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {
                    setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1025), C_SekmossakuseiErroutKbn.GAMEN, pMP);
                }
            }
        }
        else {
            yoteiriritu = getYoteiriritu.getYoteiriritu();
            tumitateriritu = getYoteiriritu.getTumitateriritu();
            tmttknzoukaritujygn = getYoteiriritu.getTmttknzoukaritujygn();
            setteibairitu = getYoteiriritu.getSetteibairitu();
            loadingHnkgtumitateRiritu = getYoteiriritu.getLoadinghnkgtumitateriritu();
            rendouRitu = getYoteiriritu.getRendouritu();
        }

        if (logger.isDebugEnabled()) {
            logger.debug("｜    WK2予定利率=" + yoteiriritu);
            logger.debug("｜    WK2積立利率=" + tumitateriritu);
            logger.debug("｜    WK2積立金増加率上限=" + tmttknzoukaritujygn);
            logger.debug("｜    WK2設定倍率=" + setteibairitu);
            logger.debug("｜    WK2ローディング変更後積立利率=" + loadingHnkgtumitateRiritu );
            logger.debug("｜    WK2連動率=" + rendouRitu );
        }

        C_Sisuukbn sisuuKbn = syouhnZokusei.getSisuukbn();

        if (logger.isDebugEnabled()) {
            logger.debug("｜    WK2指数区分=" + sisuuKbn);
        }

        BizDateYM bosyuYm = null;

        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {
            bosyuYm = setBosyuuYm(mosKihon.getMosymd(), syoriCTL.getMosnrkymd(), rsYmd, BOSYUUYMKBN, pMP);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("｜    WK3募集年月=" + bosyuYm);
        }


        BizDateYM mosYm = null;

        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {
            if (mosKihon.getMosym() == null) {
                mosYm = setBosyuuYm(mosKihon.getMosymd(), syoriCTL.getMosnrkymd(), rsYmd, MOSYMKBN, pMP);
            }

            else {
                if (bosyuYm != null && bosyuYm.compareTo(mosKihon.getMosym()) < 0) {
                    mosYm = bosyuYm;
                }
                else {
                    mosYm = mosKihon.getMosym();
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("｜    WK3申込月度=" + mosYm);
        }

        BizDateYM seisekiYm = null;

        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

            if (!C_SknnkaisikitkhukaKbn.HUKA.eq(sknnKaisikiTkHukaKbn)) {

                seisekiYm = bosyuYm;
            }
            else {

                if (C_UmuKbn.NONE.eq(syoriCTL.getNyknnrkumu())) {
                    //                if (C_FstphrkkeiroKbn.CREDIT.eq(mosKihon.getFstphrkkeirokbn()) &&
                    //                        C_AuthorijkKbn.OK.eq(syoriCTL.getAuthorijkkbn())) {
                    //                    BizCurrency authoriGk = BizCurrency.valueOf(0);
                    //                    Map<CurrencyType, BizCurrency> byAuthoriMap =
                    //                            syoriCTL.getAuthoriRirekiSumAuthorigkByAuthori(
                    //                                    syoriCTL.getFstauthorikanryoymd(),
                    //                                    C_AuthorijkKbn.OK,
                    //                                    C_SaiauthoriKbn.NOSAIAUTHORI,
                    //                                    C_SaiauthoriKbn.AFTSAIAUTHORI);
                    //
                    //                    if (byAuthoriMap != null && byAuthoriMap.size() > 0) {
                    //                        authoriGk = byAuthoriMap.get(BizCurrencyTypes.YEN);
                    //                    }
                    //                    if (mosKihon.getMosfstpkei().compareTo(authoriGk) <= 0) {
                    //                        seisekiYm = bosyuYm;
                    //                    }
                    //                }
                }
                else {

                    GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);

                    getRsgakukei.getPkakinsumiRsgaku(syoriCTL);

                    BizCurrency bdJsaiRyousyuuKingaku = getRsgakukei.getRsgakukei();

                    if (mosKihon.getMosfstpkei().compareTo(bdJsaiRyousyuuKingaku) <= 0) {

                        seisekiYm = bosyuYm;
                    }
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("｜    WK4成績計上年月=" + seisekiYm);
        }

        int hhknNen = setNenrei.exec(kykYmd ,mosKihon.getHhknseiymd());

        if (logger.isDebugEnabled()) {
            logger.debug("｜    WK5被保険者年齢=" + hhknNen);
        }

        int hrkkkn = mosSyouhn.getHrkkkn();

        if (C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.eq(mosKihon.getHknsyuruino()) ||
            C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(mosKihon.getHknsyuruino())) {

            hrkkkn = hhknNen + 5;

            if (hrkkkn > 99) {

                hrkkkn = 99;
            }

        }

        BizDate sysDate = pMP.getSysDate();
        BizDateYM kariKeijyouYm = null;
        BizDate denSimebi = null;

        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {
            denSimebi = setDenSimebi.exec(sysDate);
        }

        if (denSimebi != null && (BizDateUtil.compareYmd(sysDate, denSimebi) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(sysDate, denSimebi) == BizDateUtil.COMPARE_EQUAL)) {

            kariKeijyouYm = sysDate.getBizDateYM().getPreviousMonth();
        }
        else {

            kariKeijyouYm = sysDate.getBizDateYM();
        }

        if (logger.isDebugEnabled()) {
            logger.debug("｜    WK6仮計上年月=" + kariKeijyouYm);
        }

        BizDate kariRsYmd = null;
        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {
            kariRsYmd = setKariRsYmd(mosKihon, syoriCTL);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("｜    WK6仮領収日=" + kariRsYmd);
        }

        BizDateYM kariRsYm = BizDateYM.MIN_VALUE;

        if (kariRsYmd != null) {

            kariRsYm = kariRsYmd.getBizDateYM();
        }

        BizDateYM skeiKeijyouYm = null;
        BizDateYM sknnKaisiYm = kariSknnKaisiYmd.getBizDateYM();

        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

            if (C_SknnkaisikitkhukaKbn.HUKA.eq(sknnKaisikiTkHukaKbn)) {

                if (BizDateUtil.compareYm(sknnKaisiYm, kariKeijyouYm) == BizDateUtil.COMPARE_GREATER) {

                    skeiKeijyouYm = sknnKaisiYm;
                }
                else {

                    skeiKeijyouYm = kariKeijyouYm;
                }
            }
            else {

                if (BizDateUtil.compareYm(sknnKaisiYm, kariRsYm) == BizDateUtil.COMPARE_GREATER) {

                    skeiKeijyouYm = sknnKaisiYm;
                }
                else {

                    skeiKeijyouYm = kariRsYm;
                }

                if (BizDateUtil.compareYm(kariKeijyouYm, skeiKeijyouYm) == BizDateUtil.COMPARE_GREATER) {

                    skeiKeijyouYm = kariKeijyouYm;
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("｜    WK6新契約計上年月=" + skeiKeijyouYm);
        }

        int kykNen = setNenrei.exec(kykYmd , mosKihon.getKykseiymd());

        int znnkai = mosKihon.getZnnkai();
        if (C_BlnktkumuKbn.ARI.eq(mosKihon.getZenkizennouumu())) {
            ConvNenSaiManki convNenSaiManki = SWAKInjector.getInstance(ConvNenSaiManki.class);
            C_ErrorKbn errorKbnNenSai = convNenSaiManki.convHrkkknNen(hrkkkn,
                mosSyouhn.getHrkkknsmnkbn(),
                hhknNen);
            if (C_ErrorKbn.OK.eq(errorKbnNenSai)) {
                if (0 < convNenSaiManki.getHrkkknNen()) {
                    znnkai = convNenSaiManki.getHrkkknNen() - 1;
                }
            }
        }

        syoriCTL.setKktymd(kktYmd);
        syoriCTL.setRyosyuymd(rsYmd);

        mosKihon.setMosym(mosYm);
        mosKihon.setKykymd(kykYmd);
        mosKihon.setSknnkaisiymd(sknnKaisiYmd);
        mosKihon.setSkykymd(siteiKykYmd);
        mosKihon.setBosyuuym(bosyuYm);
        mosKihon.setSeisekiym(seisekiYm);
        mosKihon.setHhknnen(hhknNen);
        mosKihon.setSkeikeijyouym(skeiKeijyouYm);
        mosKihon.setKyknen(kykNen);
        mosKihon.setZnnkai(znnkai);
        mosKihon.setSisuukbn(sisuuKbn);

        mosSyouhn.setYoteiriritu(yoteiriritu);
        mosSyouhn.setTumitateriritu(tumitateriritu);
        mosSyouhn.setTmttknzoukaritujygn(tmttknzoukaritujygn);
        mosSyouhn.setSetteibairitu(setteibairitu);
        mosSyouhn.setLoadinghnkgtumitateriritu(loadingHnkgtumitateRiritu);
        mosSyouhn.setRendouritu(rendouRitu);
        mosSyouhn.setHrkkkn(hrkkkn);

        if (logger.isDebugEnabled()) {
            logger.debug("｜    ▽MP．処理コントロールTBL設定値");
            logger.debug("｜  ｜告知日=" + kktYmd);
            logger.debug("｜  ｜領収日=" + rsYmd);
            logger.debug("｜    △");
            logger.debug("｜    ▽MP．申込基本TBL設定値");
            logger.debug("｜  ｜責任開始日=" + sknnKaisiYmd);
            logger.debug("｜  ｜申込月度=" + mosYm);
            logger.debug("｜  ｜契約日=" + kykYmd);
            logger.debug("｜  ｜指定契約日=" + siteiKykYmd);
            logger.debug("｜  ｜募集年月=" + bosyuYm);
            logger.debug("｜  ｜成績計上年月=" + seisekiYm);
            logger.debug("｜  ｜新契約計上年月=" + skeiKeijyouYm);
            logger.debug("｜  ｜被保険者年齢=" + hhknNen);
            logger.debug("｜  ｜契約者年齢=" + kykNen);
            logger.debug("｜  ｜前納回数=" + znnkai);
            logger.debug("｜  ｜指数区分=" + sisuuKbn);
            logger.debug("｜    △");
            logger.debug("｜    ▽MP．申込商品TBL（主契約）設定値");
            logger.debug("｜  ｜予定利率=" + yoteiriritu);
            logger.debug("｜  ｜積立利率=" + tumitateriritu);
            logger.debug("｜  ｜積立金増加率上限=" + tmttknzoukaritujygn);
            logger.debug("｜  ｜設定倍率=" + setteibairitu);
            logger.debug("｜  ｜ローディング変更後積立利率=" + loadingHnkgtumitateRiritu);
            logger.debug("｜  ｜連動率=" + rendouRitu);
            logger.debug("｜  ｜払込期間=" + hrkkkn);
            logger.debug("｜    △");
            logger.debug("△ 基礎項目設定 終了");
        }
    }

    public BizDate setkykymdHantei(HT_MosKihon pMosKihon, HT_MosSyouhn pMosSyouhn, BizDate pRsYmd,
        BizDate pMosYmd, BizDate pSknnKaisiYmd, BizDate pSyoriYmd, C_SysKbn pSysKbn, C_YoteikykymdKbn pYoteiKykymdKbn) {

        BizDate kykYmd = null;
        String rsMd = "";
        BizDate coolingofKigenYmd = null;

        int syouhnHtKbn = SyouhinUtil.hantei(pMosSyouhn.getSyouhncd());

        if (C_SysKbn.ESHIEN.eq(pSysKbn)) {
            if (C_YoteikykymdKbn.SITEI.eq(pYoteiKykymdKbn) && pMosKihon.getKykymd() != null) {
                kykYmd = pMosKihon.getKykymd();

                return kykYmd;
            }
        }

        boolean hengkNkKekka = SyouhinUtil.chkHengakuNenkin(pMosSyouhn.getSyouhncd());

        if (hengkNkKekka) {
            kykYmd = pSyoriYmd.getNextDay();

            if (pSknnKaisiYmd != null) {
                if (pSknnKaisiYmd.compareTo(kykYmd) > 0) {
                    kykYmd = pSknnKaisiYmd;
                }
            }

            if (pMosYmd != null) {
                coolingofKigenYmd = pMosYmd;
                coolingofKigenYmd = coolingofKigenYmd.addDays(KANOUNISSUU);
                coolingofKigenYmd = coolingofKigenYmd.addBusinessDays(1);

                if (coolingofKigenYmd.compareTo(kykYmd) > 0) {
                    kykYmd = coolingofKigenYmd;
                }
            }
        }
        else if (syouhnHtKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            syouhnHtKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            BizDate sknnKaisiYmd = null;
            if (pSknnKaisiYmd != null) {
                sknnKaisiYmd = pSknnKaisiYmd;
            }
            else {
                sknnKaisiYmd = pMosYmd;
            }

            int hanteiD = sknnKaisiYmd.getDay();

            if (hanteiD <= 15) {
                kykYmd = sknnKaisiYmd.getBizDateYM().getNextMonth().getFirstDay();
            }
            else {
                kykYmd = sknnKaisiYmd.getBizDateYM().getNextMonth().getFirstDay().addDays(15);
            }
        }
        else if (syouhnHtKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            BizDate sknnKaisiYmd = null;
            if (pSknnKaisiYmd != null) {
                sknnKaisiYmd = pSknnKaisiYmd;
            }
            else {
                sknnKaisiYmd = pMosYmd;
            }
            kykYmd = sknnKaisiYmd.getBizDateYM().getNextMonth().getFirstDay();
        }
        else {
            if (C_Hrkkaisuu.TUKI.eq(pMosKihon.getHrkkaisuu())) {

                kykYmd = pSknnKaisiYmd.getBizDateYM().getNextMonth().getFirstDay();
            }
            else {
                kykYmd = pSknnKaisiYmd;
            }
        }

        return kykYmd;
    }

    public BizDate getNextkykymd(HT_MosKihon pMosKihon, HT_MosSyouhn pSyuMosSyouhn, BizDate pKijyunYmd) {

        BizDate nextKykymd = null;

        int syouhnHtKbn = SyouhinUtil.hantei(pSyuMosSyouhn.getSyouhncd());

        if (syouhnHtKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            syouhnHtKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            int hanteiD = pKijyunYmd.getDay();

            if (hanteiD <= 15) {
                nextKykymd = pKijyunYmd.getBizDateYM().getFirstDay().addDays(15);
            }
            else {
                nextKykymd = pKijyunYmd.getBizDateYM().getNextMonth().getFirstDay();
            }
        }
        else if (syouhnHtKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            nextKykymd = pKijyunYmd.getBizDateYM().getNextMonth().getFirstDay();
        }
        else {
            if (C_Hrkkaisuu.TUKI.eq(pMosKihon.getHrkkaisuu())) {
                nextKykymd = pKijyunYmd.getBizDateYM().getNextMonth().getFirstDay();
            }
            else {
                nextKykymd = pKijyunYmd.getNextDay();
            }
        }

        return nextKykymd;
    }

    public BizDate[] setKktymd(HT_SyoriCTL pSyoriCTL, String pMosNo){

        BizDate kktKktYmd = null;
        BizDate hjyKktYmd = null;

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getHjynrkumu())) {

            HT_Houjyou houjyou = pSyoriCTL.getHoujyouBySyosaikbn(C_SyosaiKbn.SOYSIN);

            if (houjyou == null) {
                throw new CommonBizAppException("申込番号=" + pMosNo);
            }

            hjyKktYmd = houjyou.getKktymd();
        }

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getKktnrkumu())) {

            HT_Kokutisyo kokutisyo = pSyoriCTL.getKokutisyo();

            if (kokutisyo == null) {
                throw new CommonBizAppException("申込番号=" + pMosNo);
            }

            kktKktYmd = kokutisyo.getKktymd();
        }

        return new BizDate[] {kktKktYmd, hjyKktYmd};
    }

    public C_ErrorKbn checkBosyuuKyuusi(MosnaiCheckParam pMP, String pSyouhncd, String pYoteiRiriTutkybr1
        , String pYoteiRiriTutkybr2, C_SkeijimuKbn pSkeijimuKbn, C_BoskyuusiRiyuuKbn pBoskyuusiRiyuuKbn){

        HT_MosKihon mosKihon = pMP.getDataSyoriControl().getMosKihon();

        return checkBosyuuKyuusi(pMP, pSyouhncd, pYoteiRiriTutkybr1, pYoteiRiriTutkybr2, pSkeijimuKbn,
            pBoskyuusiRiyuuKbn, mosKihon.getKykymd(), mosKihon.getSknnkaisiymd(), mosKihon.getMosymd());

    }

    private C_ErrorKbn checkBosyuuKyuusi(MosnaiCheckParam pMP, String pSyouhncd, String pYoteiRiriTutkybr1
        , String pYoteiRiriTutkybr2, C_SkeijimuKbn pSkeijimuKbn, C_BoskyuusiRiyuuKbn pBoskyuusiRiyuuKbn
        , BizDate pKykymd, BizDate pSknnkaisiymd, BizDate pMosymd){

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhncd);
        String yoteiRiriTutkybr1 = "";

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            yoteiRiriTutkybr1 = String.valueOf(pMP.getDataSyoriControl().getMosSyouhnBySyouhncd(pSyouhncd).getHknkkn());
        }
        else if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            yoteiRiriTutkybr1 = pMP.getDataSyoriControl().getMosKihon().getKyktuukasyu().getValue();
        }

        List<BM_BosyuuKyuusi> bosyuuKyuusiLst = bizDomManager.getBosyuuKyuusiBySyouhncdSkeijimukbn(
            pMP.getSysKbn(), pSyouhncd, yoteiRiriTutkybr1, pYoteiRiriTutkybr2, pSkeijimuKbn, pBoskyuusiRiyuuKbn);

        if (bosyuuKyuusiLst == null || bosyuuKyuusiLst.size() == 0) {

            return C_ErrorKbn.OK;
        }

        C_KakoymdkyytknKbn kakoYmdKyytknKbn = C_KakoymdkyytknKbn.NONE;

        if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

            HT_Tokunin tokunin = pMP.getDataSyoriControl().getTokunin();

            if (tokunin != null) {

                kakoYmdKyytknKbn = tokunin.getKakoymdkyytknkbn();
            }
        }

        BizDate kyuusiYmdFrom = null;
        BizDate kyuusiYmdTo = null;
        BizDate kijyunYmd = null;
        String msg = "";
        C_TknKbn tknKbn = null;
        String msgId = "";
        C_MsgKbn msgKbn = null;

        for (BM_BosyuuKyuusi bosyuuKyuusi : bosyuuKyuusiLst) {

            kyuusiYmdFrom = bosyuuKyuusi.getKyuusiymdfrom();
            kyuusiYmdTo = bosyuuKyuusi.getKyuusiymdto();

            if (C_BoskyuusiKijyunymdKbn.KYKYMD.eq(bosyuuKyuusi.getBoskyuusikijyunymdkbn())) {

                kijyunYmd = pKykymd;
            }
            else if (C_BoskyuusiKijyunymdKbn.SKNNKAISIYMD.eq(bosyuuKyuusi.getBoskyuusikijyunymdkbn())) {

                if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

                    kijyunYmd = pSknnkaisiymd;
                }
                else {

                    kijyunYmd = pMosymd;
                }
            }
            else if (C_BoskyuusiKijyunymdKbn.MOSYMD.eq(bosyuuKyuusi.getBoskyuusikijyunymdkbn())) {

                kijyunYmd = pMosymd;
            }

            if (kijyunYmd != null &&
                BizDateUtil.compareYmd(kyuusiYmdFrom, kijyunYmd) != BizDateUtil.COMPARE_GREATER &&
                BizDateUtil.compareYmd(kijyunYmd, kyuusiYmdTo) != BizDateUtil.COMPARE_GREATER) {

                if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

                    if (C_BoskyuusiRiyuuKbn.RATE.eq(bosyuuKyuusi.getBoskyuusiriyuukbn())) {

                        BosyuuKyuusiRateGtFlg = true;
                    }

                    if (C_HubisyubetuKbn.WARNING.eq(bosyuuKyuusi.getHubisyubetukbn())) {

                        msgId = "WHC1026";
                        msgKbn = C_MsgKbn.WARNING;
                    }
                    else {

                        msgId = "EHC1171";
                        msgKbn = C_MsgKbn.ERROR;
                    }

                    if (C_BoskyuusiRiyuuKbn.RATE.eq(bosyuuKyuusi.getBoskyuusiriyuukbn()) ||
                        C_BoskyuusiRiyuuKbn.HANBAIRYOU.eq(bosyuuKyuusi.getBoskyuusiriyuukbn())) {

                        msg = msgId + " " + MessageUtil.getMessage(msgId, bosyuuKyuusi.getHubimsg());
                    }
                    else {

                        msg = msgId + " " + bosyuuKyuusi.getHubimsg();
                    }

                    if (!C_HubisyubetuKbn.WARNING.eq(bosyuuKyuusi.getHubisyubetukbn()) &&
                        C_KahiKbn.KA.eq(bosyuuKyuusi.getTokuninkahikbn())) {

                        if (C_KakoymdkyytknKbn.NONE.eq(kakoYmdKyytknKbn)) {

                            tknKbn = C_TknKbn.KANOU;
                        }
                        else {

                            tknKbn = C_TknKbn.SUMI;
                        }
                    }
                    else {

                        tknKbn = C_TknKbn.NONE;
                    }

                    setHubiMsg.exec(C_KetsrhkosKbn.valueOf(bosyuuKyuusi.getHubisyubetukbn().toString())
                        , C_SpKeisanKahiKbn.SPKEISANKA, C_HubisyubetusyousaiKbn.NONE, msg, pMP, tknKbn, msgKbn);
                }
                else if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {

                    if (C_BoskyuusiRiyuuKbn.RATE.eq(bosyuuKyuusi.getBoskyuusiriyuukbn()) ||
                        C_BoskyuusiRiyuuKbn.HANBAIRYOU.eq(bosyuuKyuusi.getBoskyuusiriyuukbn())) {

                        setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1054,
                            bosyuuKyuusi.getHubimsg()), C_SekmossakuseiErroutKbn.GAMEN, pMP);
                    }
                    else {

                        setHubiMsg.exec(bosyuuKyuusi.getSeihowebmessage1(), bosyuuKyuusi.getSeihowebmessage2()
                            , C_SekmossakuseiErroutKbn.GAMEN, pMP);
                    }
                }

                return C_ErrorKbn.ERROR;
            }
        }

        return C_ErrorKbn.OK;
    }

    private BizDate setRsYmd(HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon, MosnaiCheckParam pMP){

        C_FstphrkkeiroKbn fstpHrkkeiroKbn = pMosKihon.getFstphrkkeirokbn();
        C_UmuKbn nyknNrkUmu = pSyoriCTL.getNyknnrkumu();
        BizDate rsYmd = null;
        C_SysKbn sysKbn = pMP.getSysKbn();
        C_Tuukasyu kykTuukaSyu = pMosKihon.getKyktuukasyu();
        C_Tuukasyu hrkTuukaSyu = pMosKihon.getHrktuukasyu();
        BizDate kwsrateKjYmd = null;
        BizNumber nyknKwsrate = BizNumber.ZERO;
        BizDate nyknKwsrateKijyunYmd = null;
        String mosNo = pSyoriCTL.getMosno();
        C_Hrkkaisuu hrkkaisuu = pMosKihon.getHrkkaisuu();
        BizDate mosYmd = pMosKihon.getMosymd();
        C_UmuKbn zennouMousideUmu = pMosKihon.getZennoumousideumu();
        C_IkkatubaraiKbn ikkatubaraiKbn = pMosKihon.getIkkatubaraikbn();

        if (C_SysKbn.SKEI.eq(sysKbn)) {
            if (C_FstphrkkeiroKbn.KOUHURI.eq(fstpHrkkeiroKbn)) {

                rsYmd = pMosKihon.getItiprsymd();
            }
            else if (C_FstphrkkeiroKbn.CREDIT.eq(fstpHrkkeiroKbn)) {

                rsYmd = pSyoriCTL.getAuthorikakymd();
            }
            else {
                if ((C_FstphrkkeiroKbn.HURIKOMI.eq(fstpHrkkeiroKbn)
                    || C_FstphrkkeiroKbn.CONVENIENCE.eq(fstpHrkkeiroKbn))
                    && C_UmuKbn.ARI.eq(nyknNrkUmu)) {

                    rsYmd = pSyoriCTL.getNyuukinMinRyosyuymdByZenhnknkbn(C_ZenhnknKbn.BLNK);
                }
            }
        }
        else {

            if (C_BosyuusysctrlKbn.SMBC.eq(pMP.getBosyuuSysCtrlKbn()) && mosYmd.isHoliday()) {

                rsYmd = mosYmd.getBusinessDay(CHolidayAdjustingMode.NEXT);
            }
            else {

                rsYmd = mosYmd;
            }
        }

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        if (rsYmd != null) {
            kwsrateKjYmd = rsYmd;
        }
        else {
            kwsrateKjYmd = pMosKihon.getMosymd();
        }

        if (!kykTuukaSyu.eq(hrkTuukaSyu)) {
            if (pMP.getNyuuryokuKawaseRate() == null ||
                pMP.getNyuuryokuKawaseRate().isZeroOrOptional()) {
                C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(kwsrateKjYmd, kykTuukaSyu, hrkTuukaSyu,
                    C_YouhiKbn.YOU, hrkkaisuu, sysKbn, zennouMousideUmu, ikkatubaraiKbn);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException("申込番号 = " + mosNo);
                }

                nyknKwsrate = getKawaseRate.getKawaserate();
                nyknKwsrateKijyunYmd = getKawaseRate.getKwsrateKjYmd();
            }
            else {
                nyknKwsrate = pMP.getNyuuryokuKawaseRate();
                nyknKwsrateKijyunYmd = kwsrateKjYmd;
            }
        }

        pSyoriCTL.setNyknkwsratekijyunymd(nyknKwsrateKijyunYmd);
        pSyoriCTL.setNyknkwsrate(nyknKwsrate);

        return rsYmd;

    }

    private BizDateYM setGetudo(BizDate pSsyKiYmd){

        BizDateYM yearMonth = pSsyKiYmd.getBizDateYM();

        int hanteiD = pSsyKiYmd.getDay();

        if (hanteiD < YMKJYMD) {

            yearMonth = yearMonth.getPreviousMonth();
        }

        return yearMonth;
    }


    private BizDateYM setBosyuuYm(BizDate pMosYmd, BizDate pMosNrkYmd,
        BizDate pRsYmd, String pSyoriKbn, MosnaiCheckParam pMP){

        BizDate simekiriStkKjnBi = null;

        if (MOSYMKBN.equals(pSyoriKbn)) {
            simekiriStkKjnBi = pMosNrkYmd;
        }
        else {
            simekiriStkKjnBi = pMP.getSysDate();
        }

        BizDateYM bosyuuYm = setGetudo(simekiriStkKjnBi);

        BM_Simekiribi simekiribi = bizDomManager.getSimekiribi(bosyuuYm);

        if (simekiribi == null) {

            String msg = MessageId.EHF0011 + " " + MessageUtil.getMessage(MessageId.EHF0011,
                DateFormatUtil.viewYM(bosyuuYm.toString()));

            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                C_HubisyubetusyousaiKbn.NONE, msg, pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);

            return bosyuuYm;
        }

        BizDate mosSimeToYmd = simekiribi.getMossimetoymd();
        BizDate mosNrkSimeToYmd = simekiribi.getMosnrksimetoymd();
        BizDate nyknSimeToYmd = simekiribi.getNyknsimetoymd();
        BizDate syoriSimeToYmd = simekiribi.getSyorisimetoymd();

        if (pMosYmd != null) {

            if (mosSimeToYmd.compareTo(pMosYmd) < 0) {

                bosyuuYm = bosyuuYm.addMonths(1);
                return bosyuuYm;
            }
        }

        if (pMosNrkYmd != null) {

            if (mosNrkSimeToYmd.compareTo(pMosNrkYmd) < 0) {

                bosyuuYm = bosyuuYm.addMonths(1);
                return bosyuuYm;
            }
        }

        if (BOSYUUYMKBN.equals(pSyoriKbn) && pRsYmd != null) {

            if (nyknSimeToYmd.compareTo(pRsYmd) < 0) {

                bosyuuYm = bosyuuYm.addMonths(1);
                return bosyuuYm;
            }
        }

        if (BOSYUUYMKBN.equals(pSyoriKbn) && pMP.getSysDate() != null) {

            if (syoriSimeToYmd.compareTo(pMP.getSysDate()) < 0) {

                bosyuuYm = bosyuuYm.addMonths(1);

                return bosyuuYm;
            }
        }

        return bosyuuYm;
    }

    private BizDate setKariRsYmd(HT_MosKihon pMosKihon, HT_SyoriCTL pSyoriCTL){

        BizDate kariRsYmd = null;
        C_FstphrkkeiroKbn fstpHrkkeiroKbn = pMosKihon.getFstphrkkeirokbn();

        if (C_FstphrkkeiroKbn.KOUHURI.eq(fstpHrkkeiroKbn)
            || C_FstphrkkeiroKbn.HURIKOMI.eq(fstpHrkkeiroKbn)
            || C_FstphrkkeiroKbn.CONVENIENCE.eq(fstpHrkkeiroKbn)) {

            List<HT_Nyuukin> nyuukinLst = pSyoriCTL.getNyuukinsByZenhnknkbnNe(C_ZenhnknKbn.SUMI);

            if (nyuukinLst != null && nyuukinLst.size() > 0) {

                SortHT_Nyuukin sortHT_Nyuukin = SWAKInjector.getInstance(SortHT_Nyuukin.class);
                nyuukinLst = sortHT_Nyuukin.OrderHT_NyuukinByRyosyuymdDesc(nyuukinLst);
                kariRsYmd = nyuukinLst.get(0).getRyosyuymd();
            }
        }

        else if (C_FstphrkkeiroKbn.CREDIT.eq(fstpHrkkeiroKbn)) {

            kariRsYmd = pSyoriCTL.getAuthorikakymd();
        }

        return kariRsYmd;
    }

    private String getBosyuuKyuusiSyouhinMsg(C_SysKbn pSysKbn, BM_SyouhnZokusei pSyouhnZokusei, HT_SyoriCTL pSyoriCTL,
        HT_MosKihon pMosKihon, HT_MosSyouhn pMosSyouhn) {
        String bosyuuKyuusiSyouhinMsg = "";
        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokusei.getSyouhncd());
        if (C_SysKbn.SKEI.eq(pSysKbn)) {
            bosyuuKyuusiSyouhinMsg = pSyouhnZokusei.getSyouhnnm();
        }
        else {
            bosyuuKyuusiSyouhinMsg = "指定通貨" + C_Tuukasyu.getContentByValue(pMosKihon.getKyktuukasyu().getValue());
        }
        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            bosyuuKyuusiSyouhinMsg = bosyuuKyuusiSyouhinMsg + "・据置期間" +
                ConvertUtil.toZenAll(pMosSyouhn.getHknkkn().toString(), 1, 1) +
                C_HknkknsmnKbn.getContentByValue(C_HknkknsmnKbn.PATTERN_TSEK, pMosSyouhn.getHknkknsmnkbn().getValue());
        }

        if (C_SysKbn.ESHIEN.eq(pSysKbn) &&
            syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20  &&
            C_Tkhukaumu.HUKA.eq(pMosKihon.getTeikisiharaitkykhkkbn())) {

            bosyuuKyuusiSyouhinMsg = bosyuuKyuusiSyouhinMsg + "（定期支払）";
        }

        return bosyuuKyuusiSyouhinMsg;

    }

}

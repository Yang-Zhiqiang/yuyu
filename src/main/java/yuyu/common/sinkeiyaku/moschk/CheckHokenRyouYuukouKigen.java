package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.EditPdfYoteirirtu;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_NenreiuptknKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteikykymdKbn;
import yuyu.def.classification.C_YoteiriritutknKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_ChkNenreiHani2;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;

/**
 * 新契約 申込内容チェック 保険料有効期限チェック
 */
public class CheckHokenRyouYuukouKigen {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private BizDomManager bizDomManager;

    public CheckHokenRyouYuukouKigen() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 保険料有効期限チェック 開始");
        }
        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        BizDate msKhnMosYmd = mosKihon.getMosymd();
        BizDate sysDate = pMp.getSysDate();
        BizDate sknnKaisiYmd = mosKihon.getSknnkaisiymd();
        C_Sdpd sdpdkbn = mosKihon.getSdpdkbn();
        BizDateMD hhknseiMd = null;
        if (mosKihon.getHhknseiymd() != null) {
            hhknseiMd = mosKihon.getHhknseiymd().getBizDateMD();
        }
        C_TumitatekinHaibunWariKbn teirituHaibunWarikbn = mosKihon.getTeirituhaibunwarikbn();
        C_TumitatekinHaibunWariKbn sisuuHaibunWariKbn = mosKihon.getSisuuhaibunwarikbn();
        boolean yoteirirituetcRnrkhyouFlgTumitateriritu = false;
        boolean yoteirirituetcRnrkhyouFlgTmttknzoukaritujygn = false;
        boolean yoteirirituetcRnrkhyouFlgSetteibairitu = false;
        boolean yoteirirituetcRnrkhyouFlgRendouritu = false;
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (syuMosSyouhnLst.size() != 1) {
            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + syoriCTL.getMosno());
        }
        String syuSyouhnCd = syuMosSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuMosSyouhnLst.get(0).getSyouhnsdno();
        BizNumber yoteirirituMosymdKijyun = null;
        BizNumber tumitaterirituMosymdKijyun = null;
        BizNumber loadinghnkgtumitaterirituMosymdKijyun = null;
        BizNumber tmttknzoukaritujygnMosymdKijyun = null;
        BizNumber setteibairituMosymdKijyun = null;
        BizNumber rendourituMosymdKijyun = null;
        BizNumber yoteirirituKykymdKijyun = BizNumber.valueOf(0);
        if (syuMosSyouhnLst.get(0).getYoteiriritu() != null) {

            yoteirirituKykymdKijyun = syuMosSyouhnLst.get(0).getYoteiriritu();
        }
        BizNumber tumitaterirituKykymdKijyun = BizNumber.valueOf(0);
        if (syuMosSyouhnLst.get(0).getTumitateriritu() != null) {

            tumitaterirituKykymdKijyun = syuMosSyouhnLst.get(0).getTumitateriritu();
        }
        BizNumber loadinghnkgtumitaterirituKykymdKijyun = BizNumber.valueOf(0);
        if (syuMosSyouhnLst.get(0).getLoadinghnkgtumitateriritu() != null) {

            loadinghnkgtumitaterirituKykymdKijyun = syuMosSyouhnLst.get(0).getLoadinghnkgtumitateriritu();
        }
        BizNumber tmttknzoukaritujygnKykymdKijyun = BizNumber.valueOf(0);
        if (syuMosSyouhnLst.get(0).getTmttknzoukaritujygn() != null) {

            tmttknzoukaritujygnKykymdKijyun = syuMosSyouhnLst.get(0).getTmttknzoukaritujygn();
        }
        BizNumber setteibairituKykymdKijyun = BizNumber.valueOf(0);
        if (syuMosSyouhnLst.get(0).getSetteibairitu() != null) {

            setteibairituKykymdKijyun = syuMosSyouhnLst.get(0).getSetteibairitu();
        }
        BizNumber rendourituKykymdKijyun = BizNumber.valueOf(0);
        if (syuMosSyouhnLst.get(0).getRendouritu() != null) {

            rendourituKykymdKijyun = syuMosSyouhnLst.get(0).getRendouritu();
        }
        BM_SyouhnZokusei syuSyouhnZokusei = pMp.getSyuSyouhnZokusei();
        List<BM_SyouhnZokusei> tkSyouhnZokuseiLst = pMp.getListTkSyouhnZokusei();
        String syuSyouhnnm = syuSyouhnZokusei.getSyouhnnm();
        C_UmuKbn hokenkngkyakujyouumu = syuSyouhnZokusei.getHokenkngkyakujyouumu();


        HanteiMoschk hanteiMoschk = SWAKInjector.getInstance(HanteiMoschk.class);
        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);
        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);


        C_BlnktkumuKbn blnktkUmuKbn = hanteiMoschk.hanteiSpCheckKingakuSouiJissiyouhi(syuSyouhnZokusei,
            tkSyouhnZokuseiLst, mosKihon);

        if (C_BlnktkumuKbn.BLNK.eq(blnktkUmuKbn)) {

            if (logger.isDebugEnabled()) {
                logger.debug("△ 保険料有効期限チェック 終了");
            }

            return;
        }


        BizDate kariKykymdMosymdKijyun = setKisoKoumoku.setkykymdHantei(mosKihon, syuMosSyouhnLst.get(0), null,
            msKhnMosYmd, msKhnMosYmd, msKhnMosYmd, C_SysKbn.SKEI, C_YoteikykymdKbn.AUTO);

        BizDate kariKykymdSyoriymdKijyun = setKisoKoumoku.setkykymdHantei(mosKihon, syuMosSyouhnLst.get(0), null,
            sysDate, sysDate, sysDate, C_SysKbn.SKEI, C_YoteikykymdKbn.AUTO);


        int hhknnenMosymdKijyun = setNenrei.exec(kariKykymdMosymdKijyun, mosKihon.getHhknseiymd());


        int hrkkkn = syuMosSyouhnLst.get(0).getHrkkkn();
        int hrkkknNenreiUpGo = syuMosSyouhnLst.get(0).getHrkkkn();

        if (C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.eq(mosKihon.getHknsyuruino()) ||
            C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(mosKihon.getHknsyuruino())) {

            hrkkkn = hhknnenMosymdKijyun + 5;
            hrkkknNenreiUpGo = hrkkkn + 1;

            if (hrkkkn > 99) {

                hrkkkn = 99;
            }

            if (hrkkknNenreiUpGo > 99) {

                hrkkknNenreiUpGo = 99;
            }

        }


        if (sknnKaisiYmd != null) {

            if (hhknnenMosymdKijyun < mosKihon.getHhknnen()) {

                C_TknKbn tknKbn = C_TknKbn.KANOU;

                HT_Tokunin tokunin = syoriCTL.getTokunin();

                if (tokunin != null && C_NenreiuptknKbn.ARI.eq(tokunin.getNenreiuptknkbn())) {

                    tknKbn = C_TknKbn.SUMI;
                }

                if (C_Sdpd.PD.eq(sdpdkbn) && C_UmuKbn.NONE.eq(hokenkngkyakujyouumu)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA, C_HubisyubetusyousaiKbn.NONE,
                        MessageId.EHC1034 + " " + MessageUtil.getMessage(MessageId.EHC1034), pMp, tknKbn, C_MsgKbn.ERROR);
                }
                else {
                    setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                        MessageId.WHC1022 + " " + MessageUtil.getMessage(MessageId.WHC1022), pMp, C_TknKbn.NONE, C_MsgKbn.WARNING);
                }
            }
        }


        C_UmuKbn kykNenreiUpSekininkaisiNasiTyuuiHubiumu = C_UmuKbn.NONE;

        if (C_YouhiKbn.YOU.eq(hanteiMoschk.hanteiKykNenreiUpSekininkaisiNasiTyuui(syuSyouhnZokusei,
            tkSyouhnZokuseiLst,mosKihon))) {

            if (sknnKaisiYmd == null && hhknseiMd != null) {

                BizDate tyuuiHaniFromYmd = kariKykymdSyoriymdKijyun.getNextDay();

                BizDate tyuuiHaniToYmd = setKisoKoumoku.getNextkykymd(mosKihon, syuMosSyouhnLst.get(0), tyuuiHaniFromYmd);

                if (isContainsMD(tyuuiHaniFromYmd, tyuuiHaniToYmd, hhknseiMd)) {

                    kykNenreiUpSekininkaisiNasiTyuuiHubiumu = C_UmuKbn.ARI;

                    BizDate nextKykymd = setKisoKoumoku.getNextkykymd(mosKihon, syuMosSyouhnLst.get(0), sysDate);

                    String dispSknnkaisiKigen =
                        new BizDateFormat("MM月dd日", FillStyle.None).format(nextKykymd.getPreviousDay());

                    List<BM_ChkNenreiHani2> chkNenreiHani2Lst = null;

                    chkNenreiHani2Lst = bizDomManager.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(
                        C_Channelcd.TIGIN,
                        syuSyouhnCd,
                        syuSyouhnsdNo,
                        BizNumber.valueOf(hhknnenMosymdKijyun),
                        Integer.valueOf(mosKihon.getHhknsei().getValue()),
                        syuMosSyouhnLst.get(0).getKatakbn(),
                        syuMosSyouhnLst.get(0).getHknkkn(),
                        syuMosSyouhnLst.get(0).getHknkknsmnkbn(),
                        hrkkkn,
                        syuMosSyouhnLst.get(0).getHrkkknsmnkbn(),
                        syuMosSyouhnLst.get(0).getYoteiriritu(),
                        syuMosSyouhnLst.get(0).getDai1hknkkn(),
                        null, null, null, null, null,
                        C_UmuKbn.NONE,
                        C_UmuKbn.NONE);

                    int tyuuiNenreiUpZenKns = chkNenreiHani2Lst.size();
                    int tyuuiNenreiUpGoKns = 0;

                    if (tyuuiNenreiUpZenKns > 0) {

                        chkNenreiHani2Lst = bizDomManager.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(
                            C_Channelcd.TIGIN,
                            syuSyouhnCd,
                            syuSyouhnsdNo,
                            BizNumber.valueOf(hhknnenMosymdKijyun + 1),
                            Integer.valueOf(mosKihon.getHhknsei().getValue()),
                            syuMosSyouhnLst.get(0).getKatakbn(),
                            syuMosSyouhnLst.get(0).getHknkkn(),
                            syuMosSyouhnLst.get(0).getHknkknsmnkbn(),
                            hrkkknNenreiUpGo,
                            syuMosSyouhnLst.get(0).getHrkkknsmnkbn(),
                            syuMosSyouhnLst.get(0).getYoteiriritu(),
                            syuMosSyouhnLst.get(0).getDai1hknkkn(),
                            null, null, null, null, null,
                            C_UmuKbn.NONE,
                            C_UmuKbn.NONE);

                        tyuuiNenreiUpGoKns = chkNenreiHani2Lst.size();
                    }

                    String msgWord = null;

                    if (tyuuiNenreiUpZenKns > 0 && tyuuiNenreiUpGoKns == 0) {

                        msgWord = MessageId.WHC1015 + " " + MessageUtil.getMessage(MessageId.WHC1015, dispSknnkaisiKigen);
                    }
                    else {

                        msgWord = MessageId.WHC1016 + " " + MessageUtil.getMessage(MessageId.WHC1016, dispSknnkaisiKigen);
                    }

                    setHubiMsg.exec(C_KetsrhkosKbn.WARNING, msgWord, pMp, C_TknKbn.NONE, C_MsgKbn.WARNING);
                }
            }
        }


        if (C_YouhiKbn.YOU.eq(hanteiMoschk.hanteiKykNenreiUpSekininkaisiNasiKeikoku(syuSyouhnZokusei,
            tkSyouhnZokuseiLst,mosKihon))) {

            if (sknnKaisiYmd == null && hhknseiMd != null && C_UmuKbn.NONE.eq(kykNenreiUpSekininkaisiNasiTyuuiHubiumu)) {

                if (BizDateUtil.compareYmd(kariKykymdMosymdKijyun, kariKykymdSyoriymdKijyun) ==
                    BizDateUtil.COMPARE_LESSER) {

                    BizDate warningHaniFromYmd = kariKykymdMosymdKijyun.getNextDay();

                    BizDate warningHaniToYmd = kariKykymdSyoriymdKijyun;

                    if (isContainsMD(warningHaniFromYmd, warningHaniToYmd, hhknseiMd)) {

                        List<BM_ChkNenreiHani2> chkNenreiHani2Lst = null;

                        chkNenreiHani2Lst = bizDomManager.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(
                            C_Channelcd.TIGIN,
                            syuSyouhnCd,
                            syuSyouhnsdNo,
                            BizNumber.valueOf(hhknnenMosymdKijyun),
                            Integer.valueOf(mosKihon.getHhknsei().getValue()),
                            syuMosSyouhnLst.get(0).getKatakbn(),
                            syuMosSyouhnLst.get(0).getHknkkn(),
                            syuMosSyouhnLst.get(0).getHknkknsmnkbn(),
                            hrkkkn,
                            syuMosSyouhnLst.get(0).getHrkkknsmnkbn(),
                            syuMosSyouhnLst.get(0).getYoteiriritu(),
                            syuMosSyouhnLst.get(0).getDai1hknkkn(),
                            null, null, null, null, null,
                            C_UmuKbn.NONE,
                            C_UmuKbn.NONE);

                        int warningNenreiUpZenKns = chkNenreiHani2Lst.size();
                        int warningNenreiUpGoKns = 0;

                        if (warningNenreiUpZenKns > 0) {

                            chkNenreiHani2Lst = bizDomManager.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(
                                C_Channelcd.TIGIN,
                                syuSyouhnCd,
                                syuSyouhnsdNo,
                                BizNumber.valueOf(hhknnenMosymdKijyun + 1),
                                Integer.valueOf(mosKihon.getHhknsei().getValue()),
                                syuMosSyouhnLst.get(0).getKatakbn(),
                                syuMosSyouhnLst.get(0).getHknkkn(),
                                syuMosSyouhnLst.get(0).getHknkknsmnkbn(),
                                hrkkknNenreiUpGo,
                                syuMosSyouhnLst.get(0).getHrkkknsmnkbn(),
                                syuMosSyouhnLst.get(0).getYoteiriritu(),
                                syuMosSyouhnLst.get(0).getDai1hknkkn(),
                                null, null, null, null, null,
                                C_UmuKbn.NONE,
                                C_UmuKbn.NONE);

                            warningNenreiUpGoKns = chkNenreiHani2Lst.size();
                        }

                        String msgWord = null;

                        if (warningNenreiUpZenKns > 0 && warningNenreiUpGoKns == 0) {

                            msgWord = MessageId.WHC1017 + " " + MessageUtil.getMessage(MessageId.WHC1017);
                        }
                        else {

                            msgWord = MessageId.WHC1018 + " " + MessageUtil.getMessage(MessageId.WHC1018);
                        }

                        setHubiMsg.exec(C_KetsrhkosKbn.WARNING, msgWord, pMp, C_TknKbn.NONE, C_MsgKbn.WARNING);
                    }
                }
            }
        }






        if (C_YouhiKbn.YOU.eq(hanteiMoschk.hanteiYoteirirituHendouGetYoteiriritu(syuSyouhnZokusei,
            tkSyouhnZokuseiLst))) {

            if (sknnKaisiYmd != null) {

                GetYoteirirituBean getYoteirirituBean = new GetYoteirirituBean();
                getYoteirirituBean.setSyouhncd(syuSyouhnCd);
                getYoteirirituBean.setKijyunymd(kariKykymdMosymdKijyun);
                getYoteirirituBean.setSknnkaisiymd(msKhnMosYmd);
                getYoteirirituBean.setKykymd(kariKykymdMosymdKijyun);
                getYoteirirituBean.setHknkkn(syuMosSyouhnLst.get(0).getHknkkn());
                getYoteirirituBean.setHknkknsmnkbn(syuMosSyouhnLst.get(0).getHknkknsmnkbn());
                getYoteirirituBean.setHhknnen(mosKihon.getHhknnen());
                getYoteirirituBean.setSitihsyuriritu(syuSyouhnZokusei.getYoteirirituminhosyouritu());
                getYoteirirituBean.setTuukasyu(mosKihon.getKyktuukasyu());

                if (C_ErrorKbn.ERROR.eq(getYoteiriritu.exec(getYoteirirituBean))) {

                    String msgWord = MessageUtil.getMessage(MessageId.EHC1055, syuSyouhnnm, String.valueOf(msKhnMosYmd));

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MessageId.EHC1055 + " " + msgWord,
                        pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                }
                else {
                    yoteirirituMosymdKijyun = getYoteiriritu.getYoteiriritu();
                }
            }
        }


        if (C_YouhiKbn.YOU.eq(hanteiMoschk.hanteiYoteirirituHendouGetTumitateriritu(syuSyouhnZokusei,
            tkSyouhnZokuseiLst))) {

            if (sknnKaisiYmd != null) {

                GetYoteirirituBean getYoteirirituBean = new GetYoteirirituBean();

                getYoteirirituBean.setSyouhncd(syuSyouhnCd);
                getYoteirirituBean.setKijyunymd(kariKykymdMosymdKijyun);
                getYoteirirituBean.setSknnkaisiymd(msKhnMosYmd);
                getYoteirirituBean.setKykymd(kariKykymdMosymdKijyun);
                getYoteirirituBean.setHknkkn(syuMosSyouhnLst.get(0).getHknkkn());
                getYoteirirituBean.setHknkknsmnkbn(syuMosSyouhnLst.get(0).getHknkknsmnkbn());
                getYoteirirituBean.setHhknnen(mosKihon.getHhknnen());
                getYoteirirituBean.setSitihsyuriritu(syuSyouhnZokusei.getYoteirirituminhosyouritu());
                getYoteirirituBean.setTuukasyu(mosKihon.getKyktuukasyu());

                if (C_ErrorKbn.ERROR.eq(getYoteiriritu.exec(getYoteirirituBean))) {

                    String msgWord = MessageUtil.getMessage(MessageId.EHC1067, syuSyouhnnm, String.valueOf(msKhnMosYmd));

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MessageId.EHC1067 + " " + msgWord,
                        pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                }
                else {

                    tumitaterirituMosymdKijyun = getYoteiriritu.getTumitateriritu();
                    loadinghnkgtumitaterirituMosymdKijyun = getYoteiriritu.getLoadinghnkgtumitateriritu();
                    tmttknzoukaritujygnMosymdKijyun = getYoteiriritu.getTmttknzoukaritujygn();
                    setteibairituMosymdKijyun = getYoteiriritu.getSetteibairitu();
                    rendourituMosymdKijyun = getYoteiriritu.getRendouritu();
                }
            }
        }


        if (C_YouhiKbn.YOU.eq(hanteiMoschk.hanteiYoteirirituHendouYoteirirituUpDown(syuSyouhnZokusei,
            tkSyouhnZokuseiLst))) {

            if (sknnKaisiYmd != null && yoteirirituMosymdKijyun != null &&
                yoteirirituKykymdKijyun.compareTo(BizNumber.valueOf(0)) != 0) {

                if (yoteirirituMosymdKijyun.compareTo(yoteirirituKykymdKijyun) != 0) {

                    if (syoriCTL.getYoteirirituhenkourenrakuymd() == null
                        && C_Sdpd.PD.eq(sdpdkbn) && C_UmuKbn.NONE.eq(hokenkngkyakujyouumu)) {

                        EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

                        editPdfYoteirirtu.exec(pMp,
                            yoteirirituMosymdKijyun.multiply(100),
                            yoteirirituKykymdKijyun.multiply(100),
                            C_UmuKbn.ARI,
                            BizNumber.valueOf(0),
                            BizNumber.valueOf(0),
                            BizNumber.valueOf(0),
                            BizNumber.valueOf(0),
                            C_UmuKbn.NONE,
                            BizNumber.valueOf(0),
                            BizNumber.valueOf(0),
                            C_UmuKbn.NONE,
                            BizNumber.valueOf(0),
                            BizNumber.valueOf(0),
                            C_UmuKbn.NONE,
                            BizNumber.valueOf(0),
                            BizNumber.valueOf(0),
                            C_UmuKbn.NONE);

                        syoriCTL.setYoteirirituhenkourenrakuymd(sysDate);

                    }

                    C_TknKbn yoteiriritutkn = C_TknKbn.KANOU;

                    HT_Tokunin tokunin = syoriCTL.getTokunin();

                    if (tokunin != null && C_YoteiriritutknKbn.ARI.eq(tokunin.getYoteiriritutknkbn())) {

                        yoteiriritutkn = C_TknKbn.SUMI;
                    }

                    String yoteirirituMosymdKijyunKekka = BizUtil.comma(
                        String.valueOf(yoteirirituMosymdKijyun.multiply(100)), BizUtil.ZERO_FILL, 2) + "％";

                    String yoteirirituKykymdKijyunKekka = BizUtil.comma(
                        String.valueOf(yoteirirituKykymdKijyun.multiply(100)), BizUtil.ZERO_FILL, 2) + "％";

                    String msgWord = null;
                    if (yoteirirituMosymdKijyun.compareTo(yoteirirituKykymdKijyun) < 0) {
                        if (C_Sdpd.PD.eq(sdpdkbn) && C_UmuKbn.NONE.eq(hokenkngkyakujyouumu)) {
                            msgWord = MessageId.EHC1056 + " " + MessageUtil.getMessage(MessageId.EHC1056,
                                yoteirirituMosymdKijyunKekka, yoteirirituKykymdKijyunKekka);
                        }
                        else {
                            msgWord = MessageId.WHC1023 + " " + MessageUtil.getMessage(MessageId.WHC1023,
                                yoteirirituMosymdKijyunKekka, yoteirirituKykymdKijyunKekka);
                        }
                    }
                    else {
                        if (C_Sdpd.PD.eq(sdpdkbn) && C_UmuKbn.NONE.eq(hokenkngkyakujyouumu)) {
                            msgWord = MessageId.EHC1057 + " " + MessageUtil.getMessage(MessageId.EHC1057,
                                yoteirirituMosymdKijyunKekka, yoteirirituKykymdKijyunKekka);
                        }
                        else {
                            msgWord = MessageId.WHC1024 + " " + MessageUtil.getMessage(MessageId.WHC1024,
                                yoteirirituMosymdKijyunKekka, yoteirirituKykymdKijyunKekka);
                        }
                    }
                    if (C_Sdpd.PD.eq(sdpdkbn) && C_UmuKbn.NONE.eq(hokenkngkyakujyouumu)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE, msgWord, pMp, yoteiriritutkn, C_MsgKbn.ERROR);
                    }
                    else {
                        setHubiMsg.exec(C_KetsrhkosKbn.WARNING, msgWord, pMp, C_TknKbn.NONE, C_MsgKbn.WARNING);
                    }


                }
            }
        }


        if (C_YouhiKbn.YOU.eq(hanteiMoschk.hanteiYoteirirituHendouTumitaterirituUpDown(syuSyouhnZokusei,
            tkSyouhnZokuseiLst))) {

            int syohinHanteiKbn = SyouhinUtil.hantei(syuSyouhnZokusei.getSyouhncd());

            boolean syohinGotoHanteiFlg = true;

            if ((syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
                ((C_TumitatekinHaibunWariKbn.WARIAI000.eq(teirituHaibunWarikbn) ||
                    C_TumitatekinHaibunWariKbn.BLNK.eq(teirituHaibunWarikbn)) &&
                    (C_TumitatekinHaibunWariKbn.WARIAI000.eq(sisuuHaibunWariKbn) ||
                        C_TumitatekinHaibunWariKbn.BLNK.eq(sisuuHaibunWariKbn)))) {

                syohinGotoHanteiFlg = false;
            }

            if (sknnKaisiYmd != null && tumitaterirituMosymdKijyun != null &&
                tumitaterirituKykymdKijyun.compareTo(BizNumber.valueOf(0)) != 0 &&
                syohinGotoHanteiFlg == true) {

                if (tumitaterirituMosymdKijyun.compareTo(tumitaterirituKykymdKijyun) != 0) {

                    if (syoriCTL.getYoteirirituhenkourenrakuymd() == null) {

                        yoteirirituetcRnrkhyouFlgTumitateriritu = true;
                    }

                    C_TknKbn yoteiriritutkn = C_TknKbn.KANOU;

                    HT_Tokunin tokunin = syoriCTL.getTokunin();

                    if (tokunin != null && C_YoteiriritutknKbn.ARI.eq(tokunin.getYoteiriritutknkbn())) {

                        yoteiriritutkn = C_TknKbn.SUMI;
                    }

                    String tumitaterirituMosymdKijyunKekka = BizUtil.comma(
                        String.valueOf(tumitaterirituMosymdKijyun.multiply(100)), BizUtil.ZERO_FILL, 2) + "％";

                    String tumitaterirituKykymdKijyunKekka = BizUtil.comma(
                        String.valueOf(tumitaterirituKykymdKijyun.multiply(100)), BizUtil.ZERO_FILL, 2) + "％";

                    String msgWord = null;
                    if (tumitaterirituMosymdKijyun.compareTo(tumitaterirituKykymdKijyun) < 0) {

                        msgWord = MessageId.EHC1068 + " " + MessageUtil.getMessage(MessageId.EHC1068,
                            tumitaterirituMosymdKijyunKekka, tumitaterirituKykymdKijyunKekka);
                    }
                    else {

                        msgWord = MessageId.EHC1071 + " " + MessageUtil.getMessage(MessageId.EHC1071,
                            tumitaterirituMosymdKijyunKekka, tumitaterirituKykymdKijyunKekka);
                    }

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE, msgWord, pMp, yoteiriritutkn, C_MsgKbn.ERROR);
                }
            }
        }


        if (C_YouhiKbn.YOU.eq(hanteiMoschk.hanteiYoteirirituHendouTumitatekinZoukarituJyougenUpDown(syuSyouhnZokusei,
            tkSyouhnZokuseiLst))) {

            if (sknnKaisiYmd != null && tmttknzoukaritujygnMosymdKijyun != null &&
                tmttknzoukaritujygnKykymdKijyun.compareTo(BizNumber.valueOf(0)) != 0 &&
                !C_TumitatekinHaibunWariKbn.WARIAI000.eq(sisuuHaibunWariKbn) &&
                !C_TumitatekinHaibunWariKbn.BLNK.eq(sisuuHaibunWariKbn)) {

                if (tmttknzoukaritujygnMosymdKijyun.compareTo(tmttknzoukaritujygnKykymdKijyun) != 0) {

                    if (syoriCTL.getYoteirirituhenkourenrakuymd() == null) {

                        yoteirirituetcRnrkhyouFlgTmttknzoukaritujygn = true;
                    }

                    C_TknKbn yoteiriritutkn = C_TknKbn.KANOU;

                    HT_Tokunin tokunin = syoriCTL.getTokunin();

                    if (tokunin != null && C_YoteiriritutknKbn.ARI.eq(tokunin.getYoteiriritutknkbn())) {

                        yoteiriritutkn = C_TknKbn.SUMI;
                    }

                    String tmttknzoukaritujygnMosymdKijyunKekka = BizUtil.comma(
                        String.valueOf(tmttknzoukaritujygnMosymdKijyun.multiply(100)), BizUtil.ZERO_FILL, 2) + "％";

                    String tmttknzoukaritujygnKykymdKijyunKekka = BizUtil.comma(
                        String.valueOf(tmttknzoukaritujygnKykymdKijyun.multiply(100)), BizUtil.ZERO_FILL, 2) + "％";

                    String msgWord = null;
                    if (tmttknzoukaritujygnMosymdKijyun.compareTo(tmttknzoukaritujygnKykymdKijyun) < 0) {

                        msgWord = MessageId.EHC1069 + " " + MessageUtil.getMessage(MessageId.EHC1069,
                            tmttknzoukaritujygnMosymdKijyunKekka, tmttknzoukaritujygnKykymdKijyunKekka);
                    }
                    else {

                        msgWord = MessageId.EHC1072 + " " + MessageUtil.getMessage(MessageId.EHC1072,
                            tmttknzoukaritujygnMosymdKijyunKekka, tmttknzoukaritujygnKykymdKijyunKekka);
                    }

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE, msgWord, pMp, yoteiriritutkn, C_MsgKbn.ERROR);
                }
            }
        }


        if (C_YouhiKbn.YOU.eq(hanteiMoschk.hanteiYoteirirituHendouSetteibairituUpDown(syuSyouhnZokusei,
            tkSyouhnZokuseiLst))) {

            if (sknnKaisiYmd != null && setteibairituMosymdKijyun != null &&
                setteibairituKykymdKijyun.compareTo(BizNumber.valueOf(0)) != 0 &&
                !C_TumitatekinHaibunWariKbn.WARIAI000.eq(sisuuHaibunWariKbn) &&
                !C_TumitatekinHaibunWariKbn.BLNK.eq(sisuuHaibunWariKbn)) {

                if (setteibairituMosymdKijyun.compareTo(setteibairituKykymdKijyun) != 0) {

                    if (syoriCTL.getYoteirirituhenkourenrakuymd() == null) {

                        yoteirirituetcRnrkhyouFlgSetteibairitu = true;
                    }

                    C_TknKbn yoteiriritutkn = C_TknKbn.KANOU;

                    HT_Tokunin tokunin = syoriCTL.getTokunin();

                    if (tokunin != null && C_YoteiriritutknKbn.ARI.eq(tokunin.getYoteiriritutknkbn())) {

                        yoteiriritutkn = C_TknKbn.SUMI;
                    }

                    String setteibairituMosymdKijyunKekka = BizUtil.comma(
                        String.valueOf(setteibairituMosymdKijyun), BizUtil.ZERO_FILL, 2) + "倍";

                    String setteibairituKykymdKijyunKekka = BizUtil.comma(
                        String.valueOf(setteibairituKykymdKijyun), BizUtil.ZERO_FILL, 2) + "倍";

                    String msgWord = null;
                    if (setteibairituMosymdKijyun.compareTo(setteibairituKykymdKijyun) < 0) {

                        msgWord = MessageId.EHC1070 + " " + MessageUtil.getMessage(MessageId.EHC1070,
                            setteibairituMosymdKijyunKekka, setteibairituKykymdKijyunKekka);
                    }
                    else {

                        msgWord = MessageId.EHC1073 + " " + MessageUtil.getMessage(MessageId.EHC1073,
                            setteibairituMosymdKijyunKekka, setteibairituKykymdKijyunKekka);
                    }

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE, msgWord, pMp, yoteiriritutkn, C_MsgKbn.ERROR);
                }
            }
        }


        if (C_YouhiKbn.YOU.eq(hanteiMoschk.hanteiYoteirirituHendouRendourituUpDown(syuSyouhnZokusei,
            tkSyouhnZokuseiLst))) {

            if (sknnKaisiYmd != null && rendourituMosymdKijyun != null &&
                rendourituKykymdKijyun.compareTo(BizNumber.valueOf(0)) != 0 &&
                !C_TumitatekinHaibunWariKbn.WARIAI000.eq(sisuuHaibunWariKbn) &&
                !C_TumitatekinHaibunWariKbn.BLNK.eq(sisuuHaibunWariKbn)) {

                if (rendourituMosymdKijyun.compareTo(rendourituKykymdKijyun) != 0) {

                    if (syoriCTL.getYoteirirituhenkourenrakuymd() == null) {

                        yoteirirituetcRnrkhyouFlgRendouritu = true;
                    }

                    C_TknKbn yoteiriritutkn = C_TknKbn.KANOU;

                    HT_Tokunin tokunin = syoriCTL.getTokunin();

                    if (tokunin != null && C_YoteiriritutknKbn.ARI.eq(tokunin.getYoteiriritutknkbn())) {

                        yoteiriritutkn = C_TknKbn.SUMI;
                    }

                    String rendourituMosymdKekka = BizUtil.comma(
                        String.valueOf(rendourituMosymdKijyun.multiply(100)), BizUtil.ZERO_FILL, 2) + "％";

                    String rendourituKykymdKijyunKekka = BizUtil.comma(
                        String.valueOf(rendourituKykymdKijyun.multiply(100)), BizUtil.ZERO_FILL, 2) + "％";

                    String msgWord = null;
                    if (rendourituMosymdKijyun.compareTo(rendourituKykymdKijyun) < 0) {

                        msgWord = MessageId.EHC1140 + " " + MessageUtil.getMessage(MessageId.EHC1140,
                            rendourituMosymdKekka, rendourituKykymdKijyunKekka);
                    }
                    else {

                        msgWord = MessageId.EHC1141 + " " + MessageUtil.getMessage(MessageId.EHC1141,
                            rendourituMosymdKekka, rendourituKykymdKijyunKekka);
                    }

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE, msgWord, pMp, yoteiriritutkn, C_MsgKbn.ERROR);
                }
            }
        }


        if (yoteirirituetcRnrkhyouFlgTumitateriritu == true || yoteirirituetcRnrkhyouFlgTmttknzoukaritujygn == true ||
            yoteirirituetcRnrkhyouFlgSetteibairitu == true || yoteirirituetcRnrkhyouFlgRendouritu == true) {

            EditPdfYoteirirtu editPdfYoteirirtu = SWAKInjector.getInstance(EditPdfYoteirirtu.class);

            C_UmuKbn tmttrrttouhendouumu = null;
            if (yoteirirituetcRnrkhyouFlgTumitateriritu == true) {

                tmttrrttouhendouumu = C_UmuKbn.ARI;
            }
            else {

                tmttrrttouhendouumu = C_UmuKbn.NONE;
            }

            C_UmuKbn tmttknzoukaritujygnhendouumu  = null;
            if (yoteirirituetcRnrkhyouFlgTmttknzoukaritujygn == true) {

                tmttknzoukaritujygnhendouumu = C_UmuKbn.ARI;
            }
            else {

                tmttknzoukaritujygnhendouumu = C_UmuKbn.NONE;
            }

            C_UmuKbn setteibairituhendouumu  = null;
            if (yoteirirituetcRnrkhyouFlgSetteibairitu == true) {

                setteibairituhendouumu = C_UmuKbn.ARI;
            }
            else {

                setteibairituhendouumu = C_UmuKbn.NONE;
            }

            C_UmuKbn rendourituhendouumu  = null;
            if (yoteirirituetcRnrkhyouFlgRendouritu == true) {

                rendourituhendouumu = C_UmuKbn.ARI;
            }
            else {

                rendourituhendouumu = C_UmuKbn.NONE;
            }

            editPdfYoteirirtu.exec(pMp,
                BizNumber.valueOf(0),
                BizNumber.valueOf(0),
                C_UmuKbn.NONE,
                tumitaterirituMosymdKijyun.multiply(100),
                tumitaterirituKykymdKijyun.multiply(100),
                loadinghnkgtumitaterirituMosymdKijyun.multiply(100),
                loadinghnkgtumitaterirituKykymdKijyun.multiply(100),
                tmttrrttouhendouumu,
                tmttknzoukaritujygnMosymdKijyun.multiply(100),
                tmttknzoukaritujygnKykymdKijyun.multiply(100),
                tmttknzoukaritujygnhendouumu,
                setteibairituMosymdKijyun,
                setteibairituKykymdKijyun,
                setteibairituhendouumu,
                rendourituMosymdKijyun.multiply(100),
                rendourituKykymdKijyun.multiply(100),
                rendourituhendouumu);

            syoriCTL.setYoteirirituhenkourenrakuymd(sysDate);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 保険料有効期限チェック 終了");
        }

    }

    private boolean isContainsMD(BizDate pFromYmd, BizDate pToYmd, BizDateMD pSiteiMd) {

        if (BizDateUtil.calcDifference(pFromYmd, pToYmd.getNextDay()).getYears() >= BizDateSpan.NEXT_YEAR.getYears()) {
            return true;
        }

        BizDateMD fromMd = pFromYmd.getBizDateMD();
        BizDateMD toMd = pToYmd.getBizDateMD();

        if (pFromYmd.getYear() == pToYmd.getYear()) {
            if (fromMd.compareTo(pSiteiMd) <= 0 &&
                pSiteiMd.compareTo(toMd) <= 0) {
                return true;
            }

            return false;
        }

        if (toMd.compareTo(pSiteiMd) < 0 &&
            pSiteiMd.compareTo(fromMd) < 0) {
            return false;
        }

        return true;
    }
}

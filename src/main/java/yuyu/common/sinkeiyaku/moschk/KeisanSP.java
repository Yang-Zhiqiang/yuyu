package yuyu.common.sinkeiyaku.moschk;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.KeisanZennouNyuukinGk2;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkSyouhnBean;
import yuyu.common.hozen.khcommon.KeisanTeikishrkin;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.sinkeiyaku.skcommon.ConvNenSaiManki;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.sorter.SortHT_MosSyouhn;

/**
 * 新契約 申込内容チェック SP計算
 */
public class KeisanSP {

    private BizCurrency fstphrkgk;

    private BizCurrency seitoufstpkei;

    private BizCurrency hyouteiP;

    private BizCurrency heijyunP;

    private BizCurrency heijyunPRyoumasinasi;

    private BizCurrency ikkatuP;

    private BizCurrency zennouP;

    private BizCurrency zennouJyuutouP;

    private BizCurrency tokujyouPGoukei;

    private BizCurrency pharaiKomiSougaku;

    private C_ErrorKbn errorKbn;

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private yuyu.common.hozen.khcommon.KeisanSP hozenKeisanSP;

    public KeisanSP() {
        super();
    }

    public BizCurrency getFstphrkgk() {
        return fstphrkgk;
    }

    public BizCurrency getHyouteiP() {
        return hyouteiP;
    }

    public BizCurrency getSeitoufstpkei() {
        return seitoufstpkei;
    }

    public BizCurrency getHeijyunp() {
        return heijyunP;
    }

    public BizCurrency getHeijyunpryoumasinasi() {
        return heijyunPRyoumasinasi;
    }

    public BizCurrency getIkkatup() {
        return ikkatuP;
    }

    public BizCurrency getZennoup() {
        return zennouP;
    }

    public BizCurrency getZennoujyuutoup() {
        return zennouJyuutouP;
    }

    public BizCurrency getTokujyouPGoukei() {
        return tokujyouPGoukei;
    }

    public BizCurrency getPharaikomisougaku() {
        return pharaiKomiSougaku;
    }

    public C_ErrorKbn getiErrorKbn() {
        return errorKbn;
    }

    public void exec(MosnaiCheckParam pMP) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ SP計算 開始");
        }

        errorKbn = C_ErrorKbn.OK;

        HT_SyoriCTL dataSyoriCTL = pMP.getDataSyoriControl();
        String mosNo = dataSyoriCTL.getMosno();
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector
            .getInstance(yuyu.common.biz.bzcommon.KeisanGaikakanzan.class);
        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector
            .getInstance(yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk.class);
        KeisanZennouNyuukinGk2 keisanZennouNyuukinGk2 = SWAKInjector
            .getInstance(yuyu.common.hozen.ascommon.KeisanZennouNyuukinGk2.class);
        ConvNenSaiManki convNenSaiManki = SWAKInjector
            .getInstance(yuyu.common.sinkeiyaku.skcommon.ConvNenSaiManki.class);
        HT_MosKihon mosKihon = dataSyoriCTL.getMosKihon();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(yuyu.common.biz.bzcommon.HenkanTuuka.class);
        CurrencyType kykTuukaType = henkanTuuka.henkanTuukaKbnToType(mosKihon.getKyktuukasyu());
        CurrencyType hrkTuukaType = henkanTuuka.henkanTuukaKbnToType(mosKihon.getHrktuukasyu());

        C_Sdpd sdpdKbn = mosKihon.getSdpdkbn();
        C_Tuukasyu kykTuukaKbn = mosKihon.getKyktuukasyu();
        C_Tuukasyu hrkTuukaKbn = mosKihon.getHrktuukasyu();
        C_Hrkkaisuu hrkKaisuu = mosKihon.getHrkkaisuu();
        C_IkkatubaraiKbn ikkatubaraiKbn = mosKihon.getIkkatubaraikbn();
        C_IkkatubaraiKaisuuKbn ikkatubaraiKaisuu = mosKihon.getIkkatubaraikaisuu();
        C_Tkhukaumu teikiShrtkykhkkbn = mosKihon.getTeikisiharaitkykhkkbn();
        BizCurrency wkHyouteiP = BizCurrency.valueOf(0, kykTuukaType);
        BizCurrency wkTokujyouPGoukei = BizCurrency.valueOf(0, kykTuukaType);
        seitoufstpkei = BizCurrency.valueOf(0, kykTuukaType);
        hyouteiP = BizCurrency.valueOf(0, kykTuukaType);
        tokujyouPGoukei = BizCurrency.valueOf(0, kykTuukaType);
        C_Tuukasyu pYakujyouTuukasyu = null;
        CurrencyType pYakujyouCurrencyType = null;
        BizCurrency wkHeijyunPGoukei = BizCurrency.valueOf(0);
        BizCurrency wkHeijyunPRyoumasinasiGoukei = BizCurrency.valueOf(0);
        BizCurrency wkPharaiKomiSougaku = BizCurrency.valueOf(0);

        List<HT_MosSyouhn> mosSyouhnLst = dataSyoriCTL.getMosSyouhns();
        mosSyouhnLst = new SortHT_MosSyouhn().OrderHT_MosSyouhnByBM_SyouhnZokuseiSyutkkbnSyohnsortnoAsc(mosSyouhnLst);
        if (mosSyouhnLst.size() != 0) {

            if (!C_SyutkKbn.SYU.eq(mosSyouhnLst.get(0).getSyutkkbn())) {
                throw new CommonBizAppException("申込番号 = " + mosNo + " 主契約・特約区分 = 主契約");
            }

            BM_SyouhnZokusei syouhnZokuseiSyu = bizDomManager.getSyouhnZokusei(mosSyouhnLst.get(0).getSyouhncd(),
                mosSyouhnLst.get(0).getSyouhnsdno());

            if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokuseiSyu.getPtratkituukasiteikbn())) {

                pYakujyouTuukasyu = hrkTuukaKbn;
                pYakujyouCurrencyType = hrkTuukaType;
            }
            else {

                pYakujyouTuukasyu = kykTuukaKbn;
                pYakujyouCurrencyType = kykTuukaType;
            }

            wkHeijyunPGoukei = BizCurrency.valueOf(0, pYakujyouCurrencyType);
            wkHeijyunPRyoumasinasiGoukei = BizCurrency.valueOf(0, pYakujyouCurrencyType);
            wkPharaiKomiSougaku = BizCurrency.valueOf(0, pYakujyouCurrencyType);
            fstphrkgk = BizCurrency.valueOf(0, pYakujyouCurrencyType);
            heijyunP = BizCurrency.valueOf(0, pYakujyouCurrencyType);
            heijyunPRyoumasinasi = BizCurrency.valueOf(0, pYakujyouCurrencyType);
            ikkatuP = BizCurrency.valueOf(0, pYakujyouCurrencyType);
            zennouP = BizCurrency.valueOf(0, pYakujyouCurrencyType);
            zennouJyuutouP = BizCurrency.valueOf(0, pYakujyouCurrencyType);
            pharaiKomiSougaku = BizCurrency.valueOf(0, pYakujyouCurrencyType);

        }
        else {
            throw new CommonBizAppException("申込番号 = " + mosNo);
        }

        int index = 0;
        int size = mosSyouhnLst.size();
        BizCurrency kyTuuKihonS = BizCurrency.valueOf(0, kykTuukaType);
        BizCurrency kykTuukasyutkP = BizCurrency.valueOf(0, kykTuukaType);
        BizCurrency hrkTuukasyutkP = BizCurrency.valueOf(0, pYakujyouCurrencyType);
        BizCurrency hrkTuukasyutkPKei = BizCurrency.valueOf(0, pYakujyouCurrencyType);

        int hrkKknY = 0;
        List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNyuukinGkSyouhnBeanLst = new ArrayList<>();

        do {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(index);

            BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(),
                mosSyouhn.getSyouhnsdno());

            C_UmuKbn gijiPdUmu = syouhnZokusei.getGijipdumu();

            C_UmuKbn teikiShrkinUmu = syouhnZokusei.getTeikisiharaikinumu();

            if (C_Sdpd.PD.eq(sdpdKbn)) {
                if (kykTuukaKbn.eq(pYakujyouTuukasyu)) {
                    kykTuukasyutkP = mosSyouhn.getHrktuukasyutkp();
                }

                else {
                    kykTuukasyutkP = keisanGaikakanzan.execDivide(mosKihon.getKyktuukasyu(),
                        mosSyouhn.getHrktuukasyutkp(), dataSyoriCTL.getNyknkwsrate(), C_HasuusyoriKbn.AGE);
                }
            }

            if (C_Sdpd.SD.eq(sdpdKbn)) {

                if (C_UmuKbn.ARI.eq(gijiPdUmu)) {

                    if (kykTuukaKbn.eq(pYakujyouTuukasyu)) {
                        kyTuuKihonS = mosSyouhn.getHrktuukasyutkp();
                    }

                    else {
                        kyTuuKihonS = keisanGaikakanzan.execDivide(kykTuukaKbn,
                            mosSyouhn.getHrktuukasyutkp(), dataSyoriCTL.getNyknkwsrate(), C_HasuusyoriKbn.AGE);
                    }
                }
                else {
                    kyTuuKihonS = mosSyouhn.getKihons();
                }
            }

            C_Kykjyoutai kykJyoutai = C_Kykjyoutai.HRKMTYUU;
            if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {

                kykJyoutai = C_Kykjyoutai.ITIJIBARAI;
            }
            else if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())) {

                kykJyoutai = C_Kykjyoutai.ZENNOU;
            }
            else if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(mosKihon.getIkkatubaraikbn())) {

                kykJyoutai = C_Kykjyoutai.IKKATUNK;
            }

            C_ErrorKbn errorKbnResult = hozenKeisanSP.exec(mosSyouhn.getSyouhncd(), mosSyouhn.getRyouritusdno(),
                mosSyouhn.getYoteiriritu(), hrkKaisuu, mosKihon.getHhknnen(), mosKihon.getHhknsei(),
                mosSyouhn.getHknkknsmnkbn(), mosSyouhn.getHknkkn(), mosSyouhn.getHrkkkn(), mosKihon.getSdpdkbn(),
                kyTuuKihonS, kykTuukasyutkP, kykTuukaKbn, kykJyoutai, mosSyouhn.getDai1hknkkn(), mosKihon.getHrkkeiro());

            pMP.setPRate(hozenKeisanSP.getPRate());
            pMP.setPdateSRate(hozenKeisanSP.getPSRate());
            pMP.setHrbtJyousu(hozenKeisanSP.getHrbtJyousu());

            if (C_ErrorKbn.ERROR.eq(errorKbnResult)) {
                errorKbn = errorKbnResult;
                return;
            }


            if (C_Sdpd.PD.eq(sdpdKbn)) {
                mosSyouhn.setSeitoukihons(hozenKeisanSP.getS());
                mosSyouhn.setSyutkp(kykTuukasyutkP);
                mosSyouhn.setGyoumuKousinsyaId(pMP.getKosID());
                mosSyouhn.setGyoumuKousinTime(pMP.getKosTime());
            }
            else {
                if (C_UmuKbn.ARI.eq(gijiPdUmu)) {

                    mosSyouhn.setSeitoukihons(kyTuuKihonS);
                    mosSyouhn.setSyutkp(hozenKeisanSP.getP());
                    mosSyouhn.setGyoumuKousinsyaId(pMP.getKosID());
                    mosSyouhn.setGyoumuKousinTime(pMP.getKosTime());
                }
                else {
                    mosSyouhn.setSeitoukihons(kyTuuKihonS);
                    mosSyouhn.setSyutkp(hozenKeisanSP.getP());
                    mosSyouhn.setGyoumuKousinsyaId(pMP.getKosID());
                    mosSyouhn.setGyoumuKousinTime(pMP.getKosTime());
                }
            }


            if (C_Tkhukaumu.HUKA.eq(teikiShrtkykhkkbn) && C_UmuKbn.ARI.eq(teikiShrkinUmu)) {

                KeisanTeikishrkin keisanTeikishrkin = SWAKInjector.getInstance(KeisanTeikishrkin.class);

                C_ErrorKbn kekkaKbn = keisanTeikishrkin.exec(mosSyouhn.getSeitoukihons(), mosSyouhn.getTumitateriritu());

                if (C_ErrorKbn.OK.eq(kekkaKbn)) {

                    mosSyouhn.setTeikisiharaikin(keisanTeikishrkin.getTeikishrkin());
                }
            }
            else {

                mosSyouhn.setTeikisiharaikin(BizCurrency.valueOf(0, kykTuukaType));
            }

            wkHyouteiP = wkHyouteiP.add(mosSyouhn.getSyutkp());

            mosSyouhn.setTkjyp(BizCurrency.valueOf(0, kykTuukaType));

            if (C_Sdpd.PD.eq(sdpdKbn)) {

                hrkTuukasyutkP = mosSyouhn.getHrktuukasyutkp();
            }
            else {

                if (kykTuukaKbn.eq(pYakujyouTuukasyu)) {

                    hrkTuukasyutkP = mosSyouhn.getSyutkp().add(mosSyouhn.getTkjyp());
                }
                else {

                    hrkTuukasyutkP = keisanGaikakanzan.exec(pYakujyouTuukasyu, mosSyouhn.getSyutkp()
                        .add(mosSyouhn.getTkjyp()), dataSyoriCTL.getNyknkwsrate(), C_HasuusyoriKbn.SUTE);
                }
            }

            hrkTuukasyutkPKei = hrkTuukasyutkPKei.add(hrkTuukasyutkP);

            if (!C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {

                C_ErrorKbn hrkKknYKekka = convNenSaiManki.convHrkkknNen(mosSyouhn.getHrkkkn(),
                    mosSyouhn.getHrkkknsmnkbn(), mosKihon.getHhknnen());

                if (C_ErrorKbn.OK.eq(hrkKknYKekka)) {

                    hrkKknY = convNenSaiManki.getHrkkknNen();
                }
                else {

                    hrkKknY = 0;
                }

                wkPharaiKomiSougaku = wkPharaiKomiSougaku.add(hrkTuukasyutkP.multiply(12).divide(
                    Integer.valueOf(hrkKaisuu.getValue()),
                    wkPharaiKomiSougaku.getType().getShiftDigits(),
                    RoundingMode.UP).multiply(hrkKknY));
            }

            if (!C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {

                wkHeijyunPGoukei = wkHeijyunPGoukei.add(hrkTuukasyutkP);
                wkHeijyunPRyoumasinasiGoukei = wkHeijyunPRyoumasinasiGoukei.add(hrkTuukasyutkP);

            }

            if (!C_IkkatubaraiKbn.BLNK.eq(ikkatubaraiKbn)) {

                KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

                keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd(mosSyouhn.getSyouhncd());
                keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(mosSyouhn.getSyouhnsdno());
                keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo(mosSyouhn.getRyouritusdno());
                keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(0));
                keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(hrkTuukasyutkP);

                keisanIkkatuNyuukinGkSyouhnBeanLst.add(keisanIkkatuNyuukinGkSyouhnBean);
            }

            index++;

        } while (index < size);

        hyouteiP = wkHyouteiP;

        tokujyouPGoukei = wkTokujyouPGoukei;

        heijyunP = wkHeijyunPGoukei;

        heijyunPRyoumasinasi = wkHeijyunPRyoumasinasiGoukei;

        pharaiKomiSougaku = wkPharaiKomiSougaku;

        seitoufstpkei = wkHyouteiP;

        fstphrkgk = hrkTuukasyutkPKei;

        if (!C_IkkatubaraiKbn.BLNK.eq(ikkatubaraiKbn)) {

            KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
            keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(keisanIkkatuNyuukinGkSyouhnBeanLst);
            keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(Integer.valueOf(ikkatubaraiKaisuu.getValue()));
            if (C_IkkatubaraiKaisuuKbn.IKKATU6.eq(ikkatubaraiKaisuu)) {

                keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
            }
            else if (C_IkkatubaraiKaisuuKbn.IKKATU12.eq(ikkatubaraiKaisuu)) {

                keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);
            }
            else {

                keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.BLNK);
            }
            keisanIkkatuNyuukinGkBean.setRstuukasyu(hrkTuukaKbn);
            keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.BLNK);
            keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.BLNK);
            keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(null);
            keisanIkkatuNyuukinGkBean.setJyutoustartYm(null);

            C_ErrorKbn resultKbn = keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean, false);

            if (C_ErrorKbn.OK.eq(resultKbn)) {

                ikkatuP = keisanTukiIkkatuNyuukinGk.getIktnyknkgk();

                fstphrkgk = keisanTukiIkkatuNyuukinGk.getIktnyknkgk();
            }
            else {

                errorKbn = C_ErrorKbn.ERROR;
                return;
            }

        }

        if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu()) && mosKihon.getZnnkai() > 0) {

            zennouJyuutouP = fstphrkgk;

            C_ErrorKbn result = keisanZennouNyuukinGk2.execKeisanSinkeiyakuDoujiZennouNyuukinGk(mosKihon.getKykymd(),
                zennouJyuutouP, mosKihon.getZnnkai(), null, null, null);

            if (C_ErrorKbn.OK.eq(result)) {

                fstphrkgk = keisanZennouNyuukinGk2.getZennouNyuukinGk();

                zennouP = keisanZennouNyuukinGk2.getZennouGenka();
            }
            else {

                errorKbn = C_ErrorKbn.ERROR;
                return;
            }

        }
        if (logger.isDebugEnabled()) {

            logger.debug("｜ 表定保険料       = " + hyouteiP);
            logger.debug("｜ 特条P合計        = " + tokujyouPGoukei);
            logger.debug("｜ 正当初回P合計額  = " + seitoufstpkei);
            logger.debug("｜ 初回P払込必要額  = " + fstphrkgk);
            logger.debug("｜ 平準払P          = " + heijyunP);
            logger.debug("｜ 平準払P（料増除）= " + heijyunPRyoumasinasi);
            logger.debug("｜ 一括払P          = " + ikkatuP);
            logger.debug("｜ 前納P            = " + zennouP);
            logger.debug("｜ 前納年払充当P    = " + zennouJyuutouP);
            logger.debug("｜ 保険料払込総額   = " + pharaiKomiSougaku);
            logger.debug("｜ 為替レート = " + dataSyoriCTL.getNyknkwsrate());
            logger.debug("△ SP計算 終了");
        }
    }
}

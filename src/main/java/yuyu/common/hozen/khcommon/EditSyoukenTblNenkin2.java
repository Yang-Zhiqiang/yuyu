package yuyu.common.hozen.khcommon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_HokenSyoukenHukaInfo;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;

import com.google.common.collect.Lists;

/**
 * 契約保全 契約保全共通 保険証券TBL編集（年金２）
 */
public class EditSyoukenTblNenkin2 {

    private static final int SINKEIYAKUHOKENSYOUKEN = 1;

    private static final int KYKJI = 1;

    private static final int SAISAKUSEIJI = 2;

    private static final int SONOTANAIYOULSTMAXCNT = 20;

    private static final int WTYUUIJIKOUMSGCDMAXCNT = 7;

    private static final int HUTANHIYUSTMMSGCDUEMAXCNT = 4;

    private static final double HUTANHIYUSTMYTIJIHIRITU = 1.0;

    private static final double HUTANHIYUSTMKYAKKJRTMIN = 0.03;

    private static final double HUTANHIYUSTMKYAKKJRTMAX = 0.31;

    private static final int TEIGAKUNK_5NEN = 5;

    private static final int TEIGAKUNK_10NEN = 10;

    private static final int TEIGAKUNK_15NEN = 15;

    private static final BizDate KIRIKAE_YMD = BizDate.valueOf("20200401");

    private static final BizDate KIRIKAEMAE_YMD = BizDate.valueOf("20200331");

    private static final String ERROR_MSG = "予定利率取得が実行できませんでした。";

    @Inject
    private static Logger logger;

    public EditSyoukenTblNenkin2() {
        super();
    }

    public void editTBL(
        IT_HokenSyouken pHokenSyouken,
        IT_KykKihon pKykKihon,
        EditHokenSyoukenParam pEditHokenSyoukenParam,
        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst,
        IT_KykSya pKykSya,
        List<IT_KykSyouhn> pSyuKykSyouhnLst,
        IT_KykSonotaTkyk pKykSonotaTkyk,
        List<IT_KykUkt> pSibouhokenLst,
        IT_KykUkt pSiteiDairi,
        int pSksyoukenskskbn,
        int pSinkykjyoutai,
        C_UmuKbn pGengakuExistsCheck,
        C_KjkhukaKbn pSbUktNmKjHukaKbn,
        IT_Zennou pZennou) {

        logger.debug("▽ 保険証券TBL編集（年金２） 開始");

        C_Nenkinsyu nksyukbn = pSyuKykSyouhnLst.get(0).getNksyukbn();
        BizNumber kykjisisuurendourate = pSyuKykSyouhnLst.get(0).getKykjisisuurendourate();
        int nenkinkkn = pSyuKykSyouhnLst.get(0).getNenkinkkn().intValue();
        C_TkiktbrisyuruiKbn tkiktbrisyuruiKbn = pKykKihon.getTikiktbrisyuruikbn();
        BizDate kykymd = pSyuKykSyouhnLst.get(0).getKykymd();
        C_UmuKbn kykDrtkykhukaumu = pKykSonotaTkyk.getKykdrtkykhukaumu();
        BM_SyouhnZokusei syouhnZokusei = pSyuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_UmuKbn kzkTirasidouhuukbn1 = pHokenSyouken.getHokenSyoukenHukaInfo().getKzktirasidouhuukbn1();

        C_UmuKbn kzkTirasidouhuukbn2 = pHokenSyouken.getHokenSyoukenHukaInfo().getKzktirasidouhuukbn2();

        String nksyuruinmsyouken = "";

        if (C_Nenkinsyu.KAKUTEINENKIN.eq(nksyukbn)) {

            if (nenkinkkn == TEIGAKUNK_5NEN) {

                nksyuruinmsyouken = "（定額年金型５年確定年金）";
            }
            else if (nenkinkkn == TEIGAKUNK_10NEN) {

                nksyuruinmsyouken = "（定額年金型１０年確定年金）";
            }
            else if (nenkinkkn == TEIGAKUNK_15NEN) {

                nksyuruinmsyouken = "（定額年金型１５年確定年金）";
            }
        }
        else if (C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK.eq(nksyukbn)) {

            nksyuruinmsyouken = "（第１回年金倍額型５年確定年金）";
        }

        boolean sueokikknariflag = true;

        if (pSyuKykSyouhnLst.get(0).getHknkkn() == pSyuKykSyouhnLst.get(0).getHrkkkn()) {

            sueokikknariflag = false;
        }

        IT_KykUkt nenkinUketorinin = null;

        if (pKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT).size() > 0) {

            nenkinUketorinin = pKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT).get(0);
        }

        int keikanensuu = 0;
        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
        BizDate calcKijyunYmd = setOutoubi.exec(
            C_TykzentykgoKbn.TYKGO
            , pSyuKykSyouhnLst.get(0).getKykymd()
            , C_Hrkkaisuu.NEN
            , pEditHokenSyoukenParam.getCalckijyunYMD()
            );

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
            keikanensuu = 1;

        }
        else {
            keikanensuu = BizDateUtil.calcDifference(calcKijyunYmd, pSyuKykSyouhnLst.get(0).getKykymd()).getYears();
        }

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);
        BizNumber sitihsyuriritu = pSyuKykSyouhnLst.get(0).getYoteirrthendohosyurrt();

        getYoteirirituBean.setSyouhncd(pSyuKykSyouhnLst.get(0).getSyouhncd());
        getYoteirirituBean.setKijyunymd(kykymd);
        getYoteirirituBean.setSknnkaisiymd(kykymd);
        getYoteirirituBean.setKykymd(kykymd);
        getYoteirirituBean.setHknkkn(pSyuKykSyouhnLst.get(0).getHknkkn());
        getYoteirirituBean.setHknkknsmnkbn(pSyuKykSyouhnLst.get(0).getHknkknsmnkbn());
        getYoteirirituBean.setHhknnen(pSyuKykSyouhnLst.get(0).getHhknnen());
        getYoteirirituBean.setSitihsyuriritu(sitihsyuriritu);

        C_ErrorKbn errorKbn = getYoteiriritu.exec(getYoteirirituBean);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new CommonBizAppException(ERROR_MSG);
        }

        List<String> hyoujiranleftmsgcdLst = new ArrayList<>();

        List<String> hyoujiranrightmsgcdLst = new ArrayList<>();

        BizNumber yoteiriritu = BizNumber.ZERO;

        hyoujiranleftmsgcdLst.add("02010");

        hyoujiranleftmsgcdLst.add("02029");

        BizDate sknnkaisiymd = pSyuKykSyouhnLst.get(0).getSknnkaisiymd();

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            hyoujiranleftmsgcdLst.add("02490");
            hyoujiranrightmsgcdLst.add("02512");
        }
        else {

            hyoujiranleftmsgcdLst.add("02031");
            hyoujiranleftmsgcdLst.add("02052");
            yoteiriritu = getYoteiriritu.getYoteiriritu();
        }

        BizCurrency hokenryou = pKykKihon.getHrkp();

        String ptuukasyuNm = C_Tuukasyu.JPY.getContent();

        String pmsgcd1 = null;

        String pmsgcd2 = null;

        String pmsgcd3 = null;

        String ptokuyakumsgcd = "";

        BizCurrency pznntikiktbriyenhrkgk = BizCurrency.valueOf(BigDecimal.ZERO);

        BizCurrency Tikiktbriyenhrkgk = BizCurrency.valueOf(BigDecimal.ZERO);

        int zennnou = 0;

        int tkiktbritukisuu = 0;

        pmsgcd1 = "05014";

        if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(tkiktbrisyuruiKbn)) {

            pmsgcd2 = "05015";
            tkiktbritukisuu = 6;
        }
        else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(tkiktbrisyuruiKbn)) {

            pmsgcd2 = "05015";
            tkiktbritukisuu = 12;
        }

        if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

            pmsgcd3 = "05016";
            zennnou = Integer.parseInt(pZennou.getZennoukikan()) + 1;
        }

        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

            ptokuyakumsgcd = "05042";
        }

        if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(tkiktbrisyuruiKbn) ||
            C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(tkiktbrisyuruiKbn)) {

            KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk =  SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);
            KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = SWAKInjector.getInstance(KeisanIkkatuNyuukinGkBean.class);
            KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = SWAKInjector.getInstance(KeisanIkkatuNyuukinGkSyouhnBean.class);
            List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNyuukinGkSyouhnBeanLst = Lists.newArrayList();

            keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd(pSyuKykSyouhnLst.get(0).getSyouhncd());
            keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(pSyuKykSyouhnLst.get(0).getSyouhnsdno());
            keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo(pSyuKykSyouhnLst.get(0).getRyouritusdno());
            keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(hokenryou);
            keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.ZERO);

            keisanIkkatuNyuukinGkSyouhnBeanLst.add(keisanIkkatuNyuukinGkSyouhnBean);

            keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(keisanIkkatuNyuukinGkSyouhnBeanLst);
            keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(tkiktbritukisuu);
            keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(tkiktbrisyuruiKbn);
            keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.JPY);
            keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.BLNK);
            keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.BANK);
            keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(null);
            keisanIkkatuNyuukinGkBean.setJyutoustartYm(null);

            C_ErrorKbn kekkaKbn = keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean, false);

            if (C_ErrorKbn.OK.eq(kekkaKbn)) {

                Tikiktbriyenhrkgk = keisanTukiIkkatuNyuukinGk.getIktnyknkgk();
            }
        }

        if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

            pznntikiktbriyenhrkgk = pZennou.getZennounyuukinkgk().add(Tikiktbriyenhrkgk);
        }

        String hrkktuki = "";
        String phrkhouhou = "";
        String kykymdafter6 = "";
        String hrkkaisuu = "12";

        String kykymdm = ConvertUtil.toZenAll(String.valueOf(kykymd.getMonth()), 0, 0);

        if (kykymd.getMonth() == 6) {

            kykymdafter6 = "１２";
        }
        else {

            kykymdafter6 = ConvertUtil.toZenAll(String.valueOf((kykymd.getMonth() + 6) % 12), 0, 0) ;
        }

        if (C_TkiktbrisyuruiKbn.NONE.eq(tkiktbrisyuruiKbn)) {

            hrkktuki = "毎月１日から末日まで";
        }
        else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(tkiktbrisyuruiKbn)) {

            hrkktuki = "毎年" + kykymdm + "月";

            hrkkaisuu = "1";
        }
        else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(tkiktbrisyuruiKbn)) {

            hrkktuki = "毎年" + kykymdm + "月・" + kykymdafter6 + "月";
            hrkkaisuu = "2";
        }

        if (C_Hrkkeiro.KOUHURI.eq(pKykKihon.getHrkkeiro())) {

            phrkhouhou = "01";
        }
        else if (C_Hrkkeiro.CREDIT.eq(pKykKihon.getHrkkeiro())) {

            phrkhouhou = "04";
        }
        else {

            if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                phrkhouhou = "00";
            }
        }

        String syukyktkykhknkknmsgkbn1 = null;

        String syukyktkykmsgkbn1 = "";

        String syukyktkyksmsgkbn1 = null;

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            syukyktkykmsgkbn1 = "04";

            syukyktkyksmsgkbn1 = "07";

            syukyktkykhknkknmsgkbn1 = "04";
        }
        else {

            syukyktkykmsgkbn1 = "05";

            syukyktkyksmsgkbn1 = "09";

            syukyktkykhknkknmsgkbn1 = "05";
        }


        String kykniyustmsgcd1 = "08070";
        String kykniyustmsgcd2 = "";

        if (C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK.eq(nksyukbn)) {

            kykniyustmsgcd2 = "08072";
        }


        BizNumber sonotanyrannenkinkkn = BizNumber.valueOf(nenkinkkn);

        BizNumber sonotanyranytirrt = BizNumber.ZERO;

        List<String> stNaiyouranMsgCdList = new ArrayList<>();

        BizCurrency pharaikomisougaku = pSyuKykSyouhnLst.get(0).getPharaikomisougaku();

        stNaiyouranMsgCdList.add("09001");

        BizDate nkshrstartymd = pSyuKykSyouhnLst.get(0).getHknkknmanryouymd();

        if (C_Nenkinsyu.KAKUTEINENKIN.eq(nksyukbn)) {

            stNaiyouranMsgCdList.add("09004");
            stNaiyouranMsgCdList.add("09006");
        }

        else if (C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK.eq(nksyukbn)) {
            stNaiyouranMsgCdList.add("09005");
            stNaiyouranMsgCdList.add("09006");
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            if ((pSinkykjyoutai == KYKJI &&
                (BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAE_YMD) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAE_YMD) == BizDateUtil.COMPARE_GREATER)) ||
                (pSinkykjyoutai == SAISAKUSEIJI &&
                ((BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAE_YMD) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAE_YMD) == BizDateUtil.COMPARE_GREATER) ||
                (BizDateUtil.compareYmd(pHokenSyouken.getTyouhyouymd(), KIRIKAE_YMD) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(pHokenSyouken.getTyouhyouymd(), KIRIKAE_YMD) == BizDateUtil.COMPARE_GREATER)))) {

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getKzktourokuserviceumu())) {

                    if (C_UmuKbn.ARI.eq(kzkTirasidouhuukbn1) ||
                        C_UmuKbn.ARI.eq(kzkTirasidouhuukbn2)) {

                        stNaiyouranMsgCdList.add("09041");
                    }
                }

                if (C_UmuKbn.ARI.eq(kykDrtkykhukaumu)) {

                    stNaiyouranMsgCdList.add("09047");
                }

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getStdrsktkyhkumu())) {

                    stNaiyouranMsgCdList.add("09051");
                }
            }
        }
        else {

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getKzktourokuserviceumu())) {

                if (C_UmuKbn.ARI.eq(kzkTirasidouhuukbn1) ||
                    C_UmuKbn.ARI.eq(kzkTirasidouhuukbn2)) {

                    stNaiyouranMsgCdList.add("09041");
                }
            }

            if (C_UmuKbn.ARI.eq(kykDrtkykhukaumu)) {

                stNaiyouranMsgCdList.add("09048");
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getStdrsktkyhkumu())) {

                stNaiyouranMsgCdList.add("09051");
            }
        }

        stNaiyouranMsgCdList.add("09010");

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                stNaiyouranMsgCdList.add("09023");
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getStdrsktkyhkumu())) {

                if ((pSinkykjyoutai == KYKJI &&
                    (BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_EQUAL)) ||
                    (pSinkykjyoutai == SAISAKUSEIJI &&
                    (BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(pKykKihon.getMosymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_EQUAL) &&
                    (BizDateUtil.compareYmd(pHokenSyouken.getTyouhyouymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(pHokenSyouken.getTyouhyouymd(), KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_EQUAL))) {

                    stNaiyouranMsgCdList.add("09050");
                }
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getZeiseitkkktkykhukaumu())) {

                stNaiyouranMsgCdList.add("09055");
            }

            stNaiyouranMsgCdList.add("09060");

            if (C_Hrkkeiro.CREDIT.eq(pKykKihon.getHrkkeiro())) {

                stNaiyouranMsgCdList.add("09086");
            }

            stNaiyouranMsgCdList.add("09104");
            sonotanyranytirrt = getYoteiriritu.getYoteiriritu();
        }
        else {

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                if (C_UmuKbn.ARI.eq(pGengakuExistsCheck)) {

                    stNaiyouranMsgCdList.add("09025");
                }
                else {

                    stNaiyouranMsgCdList.add("09023");
                }
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getZeiseitkkktkykhukaumu())) {

                stNaiyouranMsgCdList.add("09055");
            }

            stNaiyouranMsgCdList.add("09060");

            if (C_Hrkkeiro.CREDIT.eq(pKykKihon.getHrkkeiro())) {

                stNaiyouranMsgCdList.add("09087");
            }
        }

        int stNaiyouranMsgCdListCnt = stNaiyouranMsgCdList.size();

        for (int i = 0; i < SONOTANAIYOULSTMAXCNT - stNaiyouranMsgCdListCnt; i++) {

            stNaiyouranMsgCdList.add("");
        }

        List<String> nenkinmsgcdLst = new ArrayList<>();
        nenkinmsgcdLst.add("12201");

        if (C_Nenkinsyu.KAKUTEINENKIN.eq(nksyukbn) ||
            C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK.eq(nksyukbn)) {
            nenkinmsgcdLst.add("12203");
        }

        if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk()) ||
            (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn()))) {
            nenkinmsgcdLst.add("12207");
        }

        if (C_Nenkinsyu.KAKUTEINENKIN.eq(nksyukbn)) {

            nenkinmsgcdLst.add("12224");
        }

        if (C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK.eq(nksyukbn)) {

            nenkinmsgcdLst.add("12226");
        }

        List<String> siboukyhkmsgcdLst = new ArrayList<>();

        siboukyhkmsgcdLst.add("12331");

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            if (sueokikknariflag == false) {

                siboukyhkmsgcdLst.add("12337");
            }
            else {

                siboukyhkmsgcdLst.add("12339");
            }
        }
        else {

            if (sueokikknariflag == false) {

                if (C_UmuKbn.ARI.eq(pGengakuExistsCheck)) {

                    siboukyhkmsgcdLst.add("12338");
                }
                else {

                    siboukyhkmsgcdLst.add("12337");
                }
            }
            else {

                if (C_UmuKbn.ARI.eq(pGengakuExistsCheck)) {

                    siboukyhkmsgcdLst.add("12340");
                }
                else {

                    siboukyhkmsgcdLst.add("12339");
                }
            }
        }

        if (C_Nenkinsyu.KAKUTEINENKIN.eq(nksyukbn) ||
            C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK.eq(nksyukbn)) {

            if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk()) ||
                (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn()))) {

                siboukyhkmsgcdLst.add("12349");
            }
            else {
                siboukyhkmsgcdLst.add("12351");
            }
        }

        List<String> hutanhiyustmmsgcdueLst = new ArrayList<>();

        String hutanhiyustmmsgcdst02 = "";

        String hutanhiyustmmsgcdst01 = "13100";

        String hutanhiyustmknsnhyuptn = "";

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            if (sueokikknariflag == false) {

                hutanhiyustmmsgcdueLst.add("13078");
            }
            else {
                hutanhiyustmmsgcdueLst.add("13079");
            }
        }
        else {

            if (sueokikknariflag == false) {

                if (BizDateUtil.calcDifference(pHokenSyouken.getTyouhyouymd(), nkshrstartymd).getYears() == 0) {

                    if (keikanensuu == 9) {

                        hutanhiyustmmsgcdueLst.add("13083");
                    }
                    else if (keikanensuu > 9){

                        hutanhiyustmmsgcdueLst.add("13085");
                    }
                }
                else {

                    hutanhiyustmmsgcdueLst.add("13078");
                }
            }
            else {

                if (BizDateUtil.calcDifference(pHokenSyouken.getTyouhyouymd(), nkshrstartymd).getYears() == 0) {

                    if (keikanensuu == 9) {

                        hutanhiyustmmsgcdueLst.add("13084");
                    }
                    else if (keikanensuu > 9) {

                        hutanhiyustmmsgcdueLst.add("13086");
                    }

                }
                else {

                    hutanhiyustmmsgcdueLst.add("13079");
                }
            }
        }

        hutanhiyustmmsgcdueLst.add("13092");

        int hutanhiyustmmsgcdueLsttCnt = hutanhiyustmmsgcdueLst.size();

        for (int i = 0; i < HUTANHIYUSTMMSGCDUEMAXCNT - hutanhiyustmmsgcdueLsttCnt; i++) {

            hutanhiyustmmsgcdueLst.add("");
        }

        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
            hutanhiyustmmsgcdst02 = "13128";

            hutanhiyustmknsnhyuptn = "10";
        }

        String fstpmsgcd = pHokenSyouken.getFstpmsgcd();
        BizCurrency fstphrkpkngkkei = hokenryou;

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(tkiktbrisyuruiKbn) ||
                C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(tkiktbrisyuruiKbn)) {

                fstphrkpkngkkei = Tikiktbriyenhrkgk;
            }

            if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                fstpmsgcd = "13151";
                fstphrkpkngkkei = pznntikiktbriyenhrkgk;
            }
        }

        List<String> wtyuuijikoumsgcdLst = new ArrayList<>();

        String wmsgcd1 = "";

        String wmsgcd2 = "";

        String wmsgcd3 = "";

        String wmsgcd2_1 = "";

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            wmsgcd1 = "14017";

            wmsgcd2_1 = "14018";

            if (sueokikknariflag == false) {

                wtyuuijikoumsgcdLst.add("14056");
            }
            else {

                wtyuuijikoumsgcdLst.add("14057");
            }
        }
        else {

            wmsgcd1 = "14013";

            wmsgcd2_1 = "14031";

            if (sueokikknariflag == false) {

                if (C_UmuKbn.ARI.eq(pGengakuExistsCheck)) {

                    wtyuuijikoumsgcdLst.add("14063");
                }
                else {

                    wtyuuijikoumsgcdLst.add("14055");
                }
            }
            else {

                if (C_UmuKbn.ARI.eq(pGengakuExistsCheck)) {

                    wtyuuijikoumsgcdLst.add("14064");
                }
                else {

                    wtyuuijikoumsgcdLst.add("14057");
                }
            }
        }

        if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

            wtyuuijikoumsgcdLst.add("14058");
        }
        else {

            wtyuuijikoumsgcdLst.add("14059");
        }

        int wtyuuijikoumsgcdLstCnt = wtyuuijikoumsgcdLst.size();

        for (int i = 0; i < WTYUUIJIKOUMSGCDMAXCNT - wtyuuijikoumsgcdLstCnt; i++) {

            wtyuuijikoumsgcdLst.add("");
        }


        if (pSksyoukenskskbn != SINKEIYAKUHOKENSYOUKEN) {

            pHokenSyouken.setHosyounymsgcd("99001");
        }

        if (hyoujiranleftmsgcdLst.size() > 0) {
            pHokenSyouken.setHyoujiranhidarimsgcd1(hyoujiranleftmsgcdLst.get(0));
        }

        if (hyoujiranleftmsgcdLst.size() > 1) {
            pHokenSyouken.setHyoujiranhidarimsgcd2(hyoujiranleftmsgcdLst.get(1));
        }

        if (hyoujiranleftmsgcdLst.size() > 2) {
            pHokenSyouken.setHyoujiranhidarimsgcd3(hyoujiranleftmsgcdLst.get(2));
        }

        if (hyoujiranleftmsgcdLst.size() > 3) {
            pHokenSyouken.setHyoujiranhidarimsgcd4(hyoujiranleftmsgcdLst.get(3));
        }

        if (hyoujiranleftmsgcdLst.size() > 4) {
            pHokenSyouken.setHyoujiranhidarimsgcd5(hyoujiranleftmsgcdLst.get(4));
        }

        if (hyoujiranleftmsgcdLst.size() > 5) {
            pHokenSyouken.setHyoujiranhidarimsgcd6(hyoujiranleftmsgcdLst.get(5));
        }

        if (hyoujiranleftmsgcdLst.size() > 6) {
            pHokenSyouken.setHyoujiranhidarimsgcd7(hyoujiranleftmsgcdLst.get(6));
        }

        if (hyoujiranrightmsgcdLst.size() > 0) {
            pHokenSyouken.setHyoujiranmigiimsgcd1(hyoujiranrightmsgcdLst.get(0));
        }

        if (hyoujiranrightmsgcdLst.size() > 1) {
            pHokenSyouken.setHyoujiranmigiimsgcd2(hyoujiranrightmsgcdLst.get(1));
        }

        pHokenSyouken.setHyoujiransknnkaisiymd(sknnkaisiymd);

        pHokenSyouken.setHyoujiranyoteiriritu(yoteiriritu);

        pHokenSyouken.setPmsgcd1(pmsgcd1);

        pHokenSyouken.setPmsgcd2(pmsgcd2);

        pHokenSyouken.setPmsgcd3(pmsgcd3);

        pHokenSyouken.setPtuukatype(C_Tuukasyu.JPY);

        pHokenSyouken.setHokenryou(hokenryou);

        pHokenSyouken.setPtuuka(ptuukasyuNm);

        pHokenSyouken.setPtokuyakumsgcd(ptokuyakumsgcd);

        pHokenSyouken.setSyukyktkykmsgkbn1(syukyktkykmsgkbn1);

        pHokenSyouken.setSyukyktkyksmsgkbn1(syukyktkyksmsgkbn1);

        pHokenSyouken.setSyukyktkykhknkknmsgkbn1(syukyktkykhknkknmsgkbn1);

        pHokenSyouken.setKykniyustmsgcd1(kykniyustmsgcd1);

        pHokenSyouken.setKykniyustmsgcd2(kykniyustmsgcd2);

        pHokenSyouken.setStnaiyouranmsgcd1(stNaiyouranMsgCdList.get(0));

        pHokenSyouken.setStnaiyouranmsgcd2(stNaiyouranMsgCdList.get(1));

        pHokenSyouken.setStnaiyouranmsgcd3(stNaiyouranMsgCdList.get(2));

        pHokenSyouken.setStnaiyouranmsgcd4(stNaiyouranMsgCdList.get(3));

        pHokenSyouken.setStnaiyouranmsgcd5(stNaiyouranMsgCdList.get(4));

        pHokenSyouken.setStnaiyouranmsgcd6(stNaiyouranMsgCdList.get(5));

        pHokenSyouken.setStnaiyouranmsgcd7(stNaiyouranMsgCdList.get(6));

        pHokenSyouken.setStnaiyouranmsgcd8(stNaiyouranMsgCdList.get(7));

        pHokenSyouken.setStnaiyouranmsgcd9(stNaiyouranMsgCdList.get(8));

        pHokenSyouken.setStnaiyouranmsgcd10(stNaiyouranMsgCdList.get(9));

        pHokenSyouken.setStnaiyouranmsgcd11(stNaiyouranMsgCdList.get(10));

        pHokenSyouken.setStnaiyouranmsgcd12(stNaiyouranMsgCdList.get(11));

        pHokenSyouken.setStnaiyouranmsgcd13(stNaiyouranMsgCdList.get(12));

        pHokenSyouken.setStnaiyouranmsgcd14(stNaiyouranMsgCdList.get(13));

        pHokenSyouken.setStnaiyouranmsgcd15(stNaiyouranMsgCdList.get(14));

        pHokenSyouken.setStnaiyouranmsgcd16(stNaiyouranMsgCdList.get(15));

        pHokenSyouken.setStnaiyouranmsgcd17(stNaiyouranMsgCdList.get(16));

        pHokenSyouken.setStnaiyouranmsgcd18(stNaiyouranMsgCdList.get(17));

        pHokenSyouken.setStnaiyouranmsgcd19(stNaiyouranMsgCdList.get(18));

        pHokenSyouken.setStnaiyouranmsgcd20(stNaiyouranMsgCdList.get(19));

        pHokenSyouken.setSonotanyranytirrt(sonotanyranytirrt);

        pHokenSyouken.setHutanhiyustmmsgcdue01(hutanhiyustmmsgcdueLst.get(0));

        pHokenSyouken.setHutanhiyustmmsgcdue02(hutanhiyustmmsgcdueLst.get(1));

        pHokenSyouken.setHutanhiyustmmsgcdue03(hutanhiyustmmsgcdueLst.get(2));

        pHokenSyouken.setHutanhiyustmmsgcdue04(hutanhiyustmmsgcdueLst.get(3));

        pHokenSyouken.setHutanhiyustmknsnhyuptn(hutanhiyustmknsnhyuptn);

        pHokenSyouken.setHutanhiyustmmsgcdst01(hutanhiyustmmsgcdst01);

        pHokenSyouken.setHutanhiyustmmsgcdst02(hutanhiyustmmsgcdst02);

        pHokenSyouken.setFstpmsgcd(fstpmsgcd);

        pHokenSyouken.setFstphrkpkngkkeituuktype(C_Tuukasyu.JPY);

        pHokenSyouken.setFstphrkpkngkkei(fstphrkpkngkkei);

        pHokenSyouken.setWmsgcd1(wmsgcd1);

        pHokenSyouken.setWmsgcd2(wmsgcd2);

        pHokenSyouken.setWmsgcd3(wmsgcd3);

        if (wtyuuijikoumsgcdLst.size() > 0) {
            pHokenSyouken.setWtyuuijikoumsgcd1(wtyuuijikoumsgcdLst.get(0));
        }

        if (wtyuuijikoumsgcdLst.size() > 1) {
            pHokenSyouken.setWtyuuijikoumsgcd2(wtyuuijikoumsgcdLst.get(1));
        }

        if (wtyuuijikoumsgcdLst.size() > 2) {
            pHokenSyouken.setWtyuuijikoumsgcd3(wtyuuijikoumsgcdLst.get(2));
        }

        if (wtyuuijikoumsgcdLst.size() > 3) {
            pHokenSyouken.setWtyuuijikoumsgcd4(wtyuuijikoumsgcdLst.get(3));
        }

        if (wtyuuijikoumsgcdLst.size() > 4) {
            pHokenSyouken.setWtyuuijikoumsgcd5(wtyuuijikoumsgcdLst.get(4));
        }

        if (wtyuuijikoumsgcdLst.size() > 5) {
            pHokenSyouken.setWtyuuijikoumsgcd6(wtyuuijikoumsgcdLst.get(5));
        }

        if (wtyuuijikoumsgcdLst.size() > 6) {
            pHokenSyouken.setWtyuuijikoumsgcd7(wtyuuijikoumsgcdLst.get(6));
        }

        pHokenSyouken.setKoujyosyoumeimsgcd1("15040");

        pHokenSyouken.setSonotanyrannkshrstartymd(nkshrstartymd);

        pHokenSyouken.setSonotanyrannenkinkkn(sonotanyrannenkinkkn);

        pHokenSyouken.setSonotanyrankjnkngktuktype(C_Tuukasyu.JPY);

        pHokenSyouken.setSonotanyrankjnkngk(pSyuKykSyouhnLst.get(0).getPharaikomisougaku());

        if (nenkinmsgcdLst.size() > 0) {
            pHokenSyouken.setNkmsgcd1(nenkinmsgcdLst.get(0));
        }

        if (nenkinmsgcdLst.size() > 1) {
            pHokenSyouken.setNkmsgcd2(nenkinmsgcdLst.get(1));
        }

        if (nenkinmsgcdLst.size() > 2) {
            pHokenSyouken.setNkmsgcd3(nenkinmsgcdLst.get(2));
        }

        if (nenkinmsgcdLst.size() > 3) {
            pHokenSyouken.setNkmsgcd4(nenkinmsgcdLst.get(3));
        }

        if (nenkinmsgcdLst.size() > 4) {
            pHokenSyouken.setNkmsgcd5(nenkinmsgcdLst.get(4));
        }

        if (nenkinmsgcdLst.size() > 5) {
            pHokenSyouken.setNkmsgcd6(nenkinmsgcdLst.get(5));
        }

        if (nenkinmsgcdLst.size() > 6) {
            pHokenSyouken.setNkmsgcd7(nenkinmsgcdLst.get(6));
        }

        if (nenkinmsgcdLst.size() > 7) {
            pHokenSyouken.setNkmsgcd8(nenkinmsgcdLst.get(7));
        }

        if (nenkinmsgcdLst.size() > 8) {
            pHokenSyouken.setNkmsgcd9(nenkinmsgcdLst.get(8));
        }

        if (nenkinmsgcdLst.size() > 9) {
            pHokenSyouken.setNkmsgcd10(nenkinmsgcdLst.get(9));
        }

        if (siboukyhkmsgcdLst.size() > 0) {
            pHokenSyouken.setSiboukyuuhukinmsgcd1(siboukyhkmsgcdLst.get(0));
        }

        if (siboukyhkmsgcdLst.size() > 1) {
            pHokenSyouken.setSiboukyuuhukinmsgcd2(siboukyhkmsgcdLst.get(1));
        }

        if (siboukyhkmsgcdLst.size() > 2) {
            pHokenSyouken.setSiboukyuuhukinmsgcd3(siboukyhkmsgcdLst.get(2));
        }

        if (siboukyhkmsgcdLst.size() > 3) {
            pHokenSyouken.setSiboukyuuhukinmsgcd4(siboukyhkmsgcdLst.get(3));
        }

        if (siboukyhkmsgcdLst.size() > 4) {
            pHokenSyouken.setSiboukyuuhukinmsgcd5(siboukyhkmsgcdLst.get(4));
        }

        if (siboukyhkmsgcdLst.size() > 5) {
            pHokenSyouken.setSiboukyuuhukinmsgcd6(siboukyhkmsgcdLst.get(5));
        }

        if (siboukyhkmsgcdLst.size() > 6) {
            pHokenSyouken.setSiboukyuuhukinmsgcd7(siboukyhkmsgcdLst.get(6));
        }

        if (siboukyhkmsgcdLst.size() > 7) {
            pHokenSyouken.setSiboukyuuhukinmsgcd8(siboukyhkmsgcdLst.get(7));
        }

        if (siboukyhkmsgcdLst.size() > 8) {
            pHokenSyouken.setSiboukyuuhukinmsgcd9(siboukyhkmsgcdLst.get(8));
        }

        if (siboukyhkmsgcdLst.size() > 9) {
            pHokenSyouken.setSiboukyuuhukinmsgcd10(siboukyhkmsgcdLst.get(9));
        }

        if (nkshrstartymd != null) {
            pHokenSyouken.setNkshrstartzenymd(String.valueOf(nkshrstartymd.getPreviousDay()));
        }

        pHokenSyouken.setTeiritutmtthbnwr(BizNumber.valueOf(100).subtract(kykjisisuurendourate));

        pHokenSyouken.setSisuutmtthbnwr(kykjisisuurendourate);

        pHokenSyouken.setHutanhiyustmytijihiritu(BizNumber.valueOf(HUTANHIYUSTMYTIJIHIRITU));

        pHokenSyouken.setWmsgcd21(wmsgcd2_1);

        pHokenSyouken.setHrkkknmsgkbn(String.valueOf(pSyuKykSyouhnLst.get(0).getHrkkkn() - pSyuKykSyouhnLst.get(0).getHhknnen()));

        pHokenSyouken.setHrkkaisuumsgkbn(hrkkaisuu);

        pHokenSyouken.setPhrkktuki(hrkktuki);

        pHokenSyouken.setHrkhouhoumsgkbn(phrkhouhou);


        IT_HokenSyoukenHukaInfo pHokenSyoukenHukaInfo = pHokenSyouken.getHokenSyoukenHukaInfo();
        pHokenSyoukenHukaInfo.setHenkousikibetukey(pHokenSyouken.getHenkousikibetukey());
        pHokenSyoukenHukaInfo.setNksyuruinmsyouken(nksyuruinmsyouken);
        pHokenSyoukenHukaInfo.setTeikiikkatubaraitukisuu(tkiktbritukisuu);
        pHokenSyoukenHukaInfo.setZnntikiktbriyhrkgktuktype(C_Tuukasyu.JPY);
        pHokenSyoukenHukaInfo.setZnntikiktbriyenhrkgk(pznntikiktbriyenhrkgk);
        pHokenSyoukenHukaInfo.setZnnkai2(zennnou);
        pHokenSyoukenHukaInfo.setHutanhiyustmkyakkjrtmin(BizNumber.valueOf(HUTANHIYUSTMKYAKKJRTMIN));
        pHokenSyoukenHukaInfo.setHutanhiyustmkyakkjrtmax(BizNumber.valueOf(HUTANHIYUSTMKYAKKJRTMAX));
        pHokenSyoukenHukaInfo.setFstpznnkngktuktype(C_Tuukasyu.JPY);
        pHokenSyoukenHukaInfo.setFstpznnkngk(pznntikiktbriyenhrkgk);
        pHokenSyoukenHukaInfo.setDskjnkngkktuktype(C_Tuukasyu.JPY);
        pHokenSyoukenHukaInfo.setDskjnkngk(pharaikomisougaku);
        pHokenSyoukenHukaInfo.setTikiktbriyhrkgktuktype(C_Tuukasyu.JPY);
        pHokenSyoukenHukaInfo.setTikiktbriyenhrkgk(Tikiktbriyenhrkgk);

        logger.debug("△ 保険証券TBL編集（年金２） 終了");
    }
}

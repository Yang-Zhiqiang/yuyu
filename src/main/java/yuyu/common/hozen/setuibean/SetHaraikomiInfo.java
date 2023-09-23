package yuyu.common.hozen.setuibean;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.hozen.khcommon.CreditKessaiyouNoHensyuu;
import yuyu.common.hozen.khcommon.KeisanKihrkP;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SyouhntaniKousingoPkeisan;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_CreditCardInfo;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;

/**
 * 契約保全 UiBean設定 払込情報設定
 */
public class SetHaraikomiInfo {

    private static final String BLANK = "";

    @Inject
    private KeisanKihrkP keisanKihrkP;

    @Inject
    private SyouhntaniKousingoPkeisan syouhntaniKousingoPkeisan;

    public SetHaraikomiInfo() {
        super();
    }

    public  boolean exec(KhozenCommonParam pKhComParm, SetHaraikomiInfoExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();

        IT_KykKihon kykKihon = pKhComParm.getKeiyakuKihon(syoNo);

        IT_HhknSya hhknSya = pKhComParm.getHihokensya(syoNo);

        List<IT_KykSyouhn> kykSyouhnLst = pKhComParm.getKeiyakuSyouhin(syoNo, C_SyutkKbn.SYU);
        if (kykSyouhnLst == null || kykSyouhnLst.size() == 0) {
            return false;
        }

        IT_Kouza kouza = pKhComParm.getKouza(syoNo);

        BizDateYM annaisaikaiym = null;

        IT_AnsyuKihon ansyuKihon = pKhComParm.getAnsyuuKihon(syoNo);

        if (ansyuKihon.getZennous().size() == 0) {
            pUiBean.setVhrkizennoustartym(null);
            pUiBean.setVhrkizennounyuukingk(BizCurrency.optional());
            pUiBean.setVhrkizennoukkn(BLANK);
            pUiBean.setVhrkizenkizennouumu(C_UmuKbn.NONE);
            pUiBean.setVhrkizennounyuukinymd(null);
        }
        else {
            IT_Zennou zennou = ansyuKihon.getZennous().get(ansyuKihon.getZennous().size() - 1);

            pUiBean.setVhrkizennoustartym(zennou.getZennoukaisiymd().getBizDateYM());
            pUiBean.setVhrkizennounyuukingk(zennou.getZennounyuukinkgk());
            pUiBean.setVhrkizennoukkn(zennou.getZennoukikan());
            pUiBean.setVhrkizennounyuukinymd(zennou.getZennounyuukinsyoriymd());
            annaisaikaiym = zennou.getAnnaisaikaiym();
        }

        keisanKihrkP.exec(syoNo,kykSyouhnLst.get(0).getKyktuukasyu());
        BizCurrency zeimuHrkp = keisanKihrkP.getYenKihrkP();

        BizCurrency jkikousingoHrkp = BizCurrency.valueOf(0);
        C_UmuKbn jkikousinUmu = C_UmuKbn.NONE;

        if (C_UmuKbn.ARI.eq(kykSyouhnLst.get(0).getSyouhnZokusei().getKostratkiumu())
            && C_HknkknsmnKbn.NENMANKI.eq(kykSyouhnLst.get(0).getHknkknsmnkbn())) {

            syouhntaniKousingoPkeisan.setSyouhncd(kykSyouhnLst.get(0).getSyouhncd());
            syouhntaniKousingoPkeisan.setSyouhnSdno(kykSyouhnLst.get(0).getSyouhnsdno());
            syouhntaniKousingoPkeisan.setKeiyakubi(kykSyouhnLst.get(0).getKykymd());
            syouhntaniKousingoPkeisan.setKatakbn(kykSyouhnLst.get(0).getKatakbn());
            syouhntaniKousingoPkeisan.setKyhgndKatakbn(kykSyouhnLst.get(0).getKyhgndkatakbn());
            syouhntaniKousingoPkeisan.setSyukyhkinKatakbn(kykSyouhnLst.get(0).getSyukyhkinkatakbn());
            syouhntaniKousingoPkeisan.setKhnkyhkgbairituKbn(kykSyouhnLst.get(0).getKhnkyhkgbairitukbn());
            syouhntaniKousingoPkeisan.set6DaisktsyknTuikakyhKatakbn(kykSyouhnLst.get(0).getRokudaildkbn());
            syouhntaniKousingoPkeisan.setPmnjtkhukaKbn(kykSyouhnLst.get(0).getPmnjtkkbn());
            syouhntaniKousingoPkeisan.setHknkknSmnkbn(kykSyouhnLst.get(0).getHknkknsmnkbn());
            syouhntaniKousingoPkeisan.setHknkkn(kykSyouhnLst.get(0).getHknkkn());
            syouhntaniKousingoPkeisan.setHrkkknSmnkbn(kykSyouhnLst.get(0).getHrkkknsmnkbn());
            syouhntaniKousingoPkeisan.setHrkkkn(kykSyouhnLst.get(0).getHrkkkn());
            syouhntaniKousingoPkeisan.setHhknNen(kykSyouhnLst.get(0).getHhknnen());
            syouhntaniKousingoPkeisan.setHhknSei(hhknSya.getHhknsei());
            syouhntaniKousingoPkeisan.setHrkKaisuu(kykKihon.getHrkkaisuu());
            syouhntaniKousingoPkeisan.setHrkKeiro(kykKihon.getHrkkeiro());
            syouhntaniKousingoPkeisan.setSdPdKbn(C_Sdpd.SD);
            syouhntaniKousingoPkeisan.setS(kykSyouhnLst.get(0).getKihons());

            syouhntaniKousingoPkeisan.exec();

            if (syouhntaniKousingoPkeisan.getKoskaisu() > 0) {
                jkikousingoHrkp = syouhntaniKousingoPkeisan.getKosnaiymeiskmk()[0].getHknry();
                jkikousinUmu = C_UmuKbn.ARI;
            }
        }

        List<IT_KykSyouhn> rtSyouhntk = pKhComParm.getKeiyakuSyouhin(syoNo, C_SyutkKbn.TK);
        if (rtSyouhntk != null) {
            for (IT_KykSyouhn kykSyouhn : rtSyouhntk) {
                if (C_UmuKbn.ARI.eq(kykSyouhn.getSyouhnZokusei().getKostratkiumu())
                    &&  C_HknkknsmnKbn.NENMANKI.eq(kykSyouhn.getHknkknsmnkbn())) {

                    syouhntaniKousingoPkeisan = SWAKInjector.getInstance(SyouhntaniKousingoPkeisan.class);

                    syouhntaniKousingoPkeisan.setSyouhncd(kykSyouhn.getSyouhncd());
                    syouhntaniKousingoPkeisan.setSyouhnSdno(kykSyouhn.getSyouhnsdno());
                    syouhntaniKousingoPkeisan.setKeiyakubi(kykSyouhn.getKykymd());
                    syouhntaniKousingoPkeisan.setKatakbn(kykSyouhn.getKatakbn());
                    syouhntaniKousingoPkeisan.setKyhgndKatakbn(kykSyouhn.getKyhgndkatakbn());
                    syouhntaniKousingoPkeisan.setSyukyhkinKatakbn(kykSyouhn.getSyukyhkinkatakbn());
                    syouhntaniKousingoPkeisan.setKhnkyhkgbairituKbn(kykSyouhn.getKhnkyhkgbairitukbn());
                    syouhntaniKousingoPkeisan.set6DaisktsyknTuikakyhKatakbn(kykSyouhn.getRokudaildkbn());
                    syouhntaniKousingoPkeisan.setPmnjtkhukaKbn(kykSyouhn.getPmnjtkkbn());
                    syouhntaniKousingoPkeisan.setHknkknSmnkbn(kykSyouhn.getHknkknsmnkbn());
                    syouhntaniKousingoPkeisan.setHknkkn(kykSyouhn.getHknkkn());
                    syouhntaniKousingoPkeisan.setHrkkknSmnkbn(kykSyouhn.getHrkkknsmnkbn());
                    syouhntaniKousingoPkeisan.setHrkkkn(kykSyouhn.getHrkkkn());
                    syouhntaniKousingoPkeisan.setHhknNen(kykSyouhn.getHhknnen());
                    syouhntaniKousingoPkeisan.setHhknSei(hhknSya.getHhknsei());
                    syouhntaniKousingoPkeisan.setHrkKaisuu(kykKihon.getHrkkaisuu());
                    syouhntaniKousingoPkeisan.setHrkKeiro(kykKihon.getHrkkeiro());
                    syouhntaniKousingoPkeisan.setSdPdKbn(C_Sdpd.SD);
                    syouhntaniKousingoPkeisan.setS(kykSyouhn.getKihons());

                    syouhntaniKousingoPkeisan.exec();

                    if (syouhntaniKousingoPkeisan.getKoskaisu() > 0) {
                        jkikousingoHrkp = jkikousingoHrkp.add(syouhntaniKousingoPkeisan.getKosnaiymeiskmk()[0].getHknry());
                        jkikousinUmu = C_UmuKbn.ARI;
                    }
                }
            }
        }

        if (C_Hrkkaisuu.ITIJI.eq(kykKihon.getHrkkaisuu())) {
            pUiBean.setVhrkijkipjytym(null);
        }
        else {
            pUiBean.setVhrkijkipjytym(ansyuKihon.getJkipjytym());
        }


        pUiBean.setVhrkifstphrkkeirokbn(kykKihon.getFstphrkkeirokbn());
        pUiBean.setVhrkihrkkaisuu(kykKihon.getHrkkaisuu());
        pUiBean.setVhrkihrkkeiro(kykKihon.getHrkkeiro());
		
    	pUiBean.setVhrkihrkp(kykKihon.getHrkp());
    	
        pUiBean.setNextkosumu(jkikousinUmu);
        pUiBean.setVhrkinextkosgohrkp(jkikousingoHrkp);
        pUiBean.setVhrkiyenkansannyknkingk(zeimuHrkp);
        pUiBean.setKyktuukasyu(kykSyouhnLst.get(0).getKyktuukasyu());
        pUiBean.setVhrkitikiktbrijk(kykKihon.getTikiktbrisyuruikbn());
        pUiBean.setVhrkikykjyoutai(kykSyouhnLst.get(0).getKykjyoutai());
        if (ansyuKihon.getSyuharaimanymd() != null &&
            BizDateUtil.compareYm(annaisaikaiym,
                ansyuKihon.getSyuharaimanymd().getBizDateYM()) == BizDateUtil.COMPARE_EQUAL) {
            pUiBean.setVhrkizenkizennouumu(C_UmuKbn.ARI);
        }
        else {
            pUiBean.setVhrkizenkizennouumu(C_UmuKbn.NONE);
        }

        IT_KykSonotaTkyk kykSonotaTkyk = pKhComParm.getSonotaTokuyaku(syoNo);
        pUiBean.setYennykntkhkumu(kykSonotaTkyk.getYennykntkhkumu());

        if (kouza == null) {
            pUiBean.setVhrkihrkinfobankcd(BLANK);
            pUiBean.setVhrkihrkinfobanknmkj(BLANK);
            pUiBean.setVhrkihrkinfositencd(BLANK);
            pUiBean.setVhrkihrkinfositennmkj(BLANK);
            pUiBean.setVhrkihrkinfoyokinkbn(C_YokinKbn.BLNK);
            pUiBean.setVhrkihrkinfokouzano(BLANK);
            pUiBean.setVhrkihrkinfokzmeiginmkn(BLANK);
            pUiBean.setVhrkihrkinfosinkeizkkbn(C_SinkeizkKbn.BLNK);
            pUiBean.setVhrkihrkinfotuutyoukigou(BLANK );
            pUiBean.setVhrkikzdoukbn(C_KzkykdouKbn.BLNK);
        }
        else {

            pUiBean.setVhrkihrkinfobankcd(kouza.getBankcd());
            pUiBean.setVhrkihrkinfositencd(kouza.getSitencd());

            BzGetBankData bankData = SWAKInjector.getInstance(BzGetBankData.class);

            BzGetBankDataBean getBankDataBean = bankData.exec(kouza.getBankcd(),kouza.getSitencd(),null);

            if (getBankDataBean.getBankNmKj() == null) {
                pUiBean.setVhrkihrkinfobanknmkj(BLANK);
            }
            else {
                pUiBean.setVhrkihrkinfobanknmkj(getBankDataBean.getBankNmKj());
            }

            if (getBankDataBean.getSitenNmKj() == null) {
                pUiBean.setVhrkihrkinfositennmkj(BLANK);
            }
            else {
                pUiBean.setVhrkihrkinfositennmkj(getBankDataBean.getSitenNmKj());
            }

            if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(kouza.getBankcd())) {
                pUiBean.setVhrkihrkinfoyokinkbn(C_YokinKbn.BLNK);
                pUiBean.setVhrkihrkinfokouzano(kouza.getKouzano() + "1");
            }
            else {
                pUiBean.setVhrkihrkinfoyokinkbn(kouza.getYokinkbn());
                pUiBean.setVhrkihrkinfokouzano(kouza.getKouzano());
            }

            pUiBean.setVhrkihrkinfokzmeiginmkn(kouza.getKzmeiginmkn());
            pUiBean.setVhrkihrkinfosinkeizkkbn(kouza.getSinkeizkkbn());
            pUiBean.setVhrkihrkinfotuutyoukigou("1" + kouza.getSitencd() + "0");
            pUiBean.setVhrkikzdoukbn(kouza.getKzkykdoukbn());
        }

    	
    	IT_NyknJissekiRireki nyknJissekiRireki = pKhComParm.getNyknJissekiRirekiSk(syoNo).get(0);
    	
        pUiBean.setVhrkiyentkykwsrateymd(nyknJissekiRireki.getYenkansantkykwsrateymd());
        pUiBean.setVhrkiyentkykwsrate(nyknJissekiRireki.getYenkansantkykwsrate());
        pUiBean.setVhrkiyentkykwsratetuukasyu(nyknJissekiRireki.getRstuukasyu());
        pUiBean.setVhrkiitijibrp(nyknJissekiRireki.getHrkp());
        if (C_Hrkkaisuu.ITIJI.eq(kykKihon.getHrkkaisuu())) {
            pUiBean.setVhrkikihrkp(nyknJissekiRireki.getRsgaku());
        }
        else {

            pUiBean.setVhrkikihrkp(keisanKihrkP.getSkjHrktuukaKihrkP());
        }

        IT_CreditCardInfo creditCardInfo = kykKihon.getCreditCardInfo();

        if (creditCardInfo == null){

            pUiBean.setVhrkicreditkessaiyouno(BLANK);
            pUiBean.setVhrkidispcreditkessaiyouno(BLANK);
            pUiBean.setVhrkicredityuukoukakkekka(C_Yuukoukakkekka.BLNK);
            pUiBean.setVhrkicredityuukoukakym(null);
        }
        else {

            CreditKessaiyouNoHensyuu creditKessaiyouNoHensyuu = SWAKInjector.getInstance(CreditKessaiyouNoHensyuu.class);

            String dispcreditkessaiyouno = creditKessaiyouNoHensyuu.exec(creditCardInfo.getCreditkessaiyouno());

            pUiBean.setVhrkicreditkessaiyouno(creditCardInfo.getCreditkessaiyouno());
            pUiBean.setVhrkidispcreditkessaiyouno(dispcreditkessaiyouno);
            pUiBean.setVhrkicredityuukoukakkekka(creditCardInfo.getCredityuukoukakkekka());
            pUiBean.setVhrkicredityuukoukakym(creditCardInfo.getCredityuukoukakym());
        }

        return true;
    }

    public void init(SetHaraikomiInfoExecUiBeanParam pUiBean) {
        pUiBean.setVhrkifstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
        pUiBean.setVhrkihrkkaisuu(C_Hrkkaisuu.BLNK);
        pUiBean.setVhrkihrkkeiro(C_Hrkkeiro.BLNK);
        pUiBean.setVhrkijkipjytym(null);
        pUiBean.setVhrkihrkp(BizCurrency.optional());
        pUiBean.setVhrkikihrkp(BizCurrency.optional());
        pUiBean.setNextkosumu(C_UmuKbn.NONE);
        pUiBean.setVhrkinextkosgohrkp(BizCurrency.optional());
        pUiBean.setVhrkihrkinfobankcd(BLANK);
        pUiBean.setVhrkihrkinfobanknmkj(BLANK);
        pUiBean.setVhrkihrkinfositencd(BLANK);
        pUiBean.setVhrkihrkinfositennmkj(BLANK);
        pUiBean.setVhrkihrkinfoyokinkbn(C_YokinKbn.BLNK);
        pUiBean.setVhrkihrkinfokouzano(BLANK);
        pUiBean.setVhrkihrkinfokzmeiginmkn(BLANK);
        pUiBean.setVhrkihrkinfosinkeizkkbn(C_SinkeizkKbn.BLNK);
        pUiBean.setVhrkiyenkansannyknkingk(BizCurrency.optional());
        pUiBean.setVhrkiyentkykwsrateymd(null);
        pUiBean.setVhrkiyentkykwsrate(null);
        pUiBean.setVhrkiyentkykwsratetuukasyu(C_Tuukasyu.BLNK);
        pUiBean.setVhrkiitijibrp(BizCurrency.optional());
        pUiBean.setKyktuukasyu(C_Tuukasyu.BLNK);
        pUiBean.setYennykntkhkumu(C_UmuKbn.NONE);
        pUiBean.setVhrkitikiktbrijk(C_TkiktbrisyuruiKbn.BLNK);
        pUiBean.setVhrkikykjyoutai(C_Kykjyoutai.BLNK);
        pUiBean.setVhrkizenkizennouumu(C_UmuKbn.NONE);
        pUiBean.setVhrkihrkinfotuutyoukigou(BLANK );
        pUiBean.setVhrkikzdoukbn(C_KzkykdouKbn.BLNK);
        pUiBean.setVhrkizennoustartym(null);
        pUiBean.setVhrkizennounyuukingk(BizCurrency.optional());
        pUiBean.setVhrkizennoukkn(BLANK);
        pUiBean.setVhrkizennounyuukinymd(null);
        pUiBean.setVhrkicreditkessaiyouno(BLANK);
        pUiBean.setVhrkidispcreditkessaiyouno(BLANK);
        pUiBean.setVhrkicredityuukoukakkekka(C_Yuukoukakkekka.BLNK);
        pUiBean.setVhrkicredityuukoukakym(null);
    }
}

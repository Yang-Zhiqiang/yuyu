package yuyu.common.hozen.renkei;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.string.ConvertUtil;
import lombok.Getter;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.hozen.khcommon.CheckKaiyaku;
import yuyu.common.hozen.khcommon.CheckKaiyakuBean;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuOutBean;
import yuyu.common.hozen.khcommon.KeisanGaisanPsougk;
import yuyu.common.hozen.khcommon.KeisanKaiyakuBean;
import yuyu.common.hozen.khcommon.KeisanKijyungk;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetSyokenhakkouymd;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobi;
import yuyu.common.hozen.renkei.dba4khansyuugetsyanaiwebkeiyakuinfo.KhGetSyanaiWebKeiyakuInfoDao;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.bean.webservice.IwssnSyanaiHozenInfoOutputBean;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;
import yuyu.def.classification.C_KaiyakuchkkekkaKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KykdrDouiYouhiKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_PyenTutHouKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YennykntksyuruiKbn;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KhTtdkRirekiInfosBySyonoBean;

/**
 * 契約保全 サブシステム連携 社内Web用保全共通情報取得<br />
 */
public abstract class KhGetSyanaiWebKyoutuuInfo {

    protected static final String NIHONGOSYOKITI= "　";

    protected static final String HANKAKUEIKANOSYOKITI= " ";

    protected static final String YMDSYOKITI_8 = "00000000";

    protected static final String YMDSYOKITI_6 = "000000";

    protected static final String NUMSYOKITI = "0";

    protected static final String YUUBINNOSYOKITI= "0000000";

    @Getter
    protected IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean;

    protected KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean;

    private C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private static Logger logger;

    @Inject
    private KhGetSyanaiWebKeiyakuInfoDao khGetSyanaiWebKeiyakuInfoDao;

    private static final DecimalFormat GAIKAFORMAT = new DecimalFormat("0.00");

    public C_IwssnKykSyoukaiKekkaKbn exec(IwssnSyanaiHozenInfoOutputBean pIwssnSyanaiHozenInfoOutputBean) throws Exception {

        logger.debug("▽ 社内Web用保全共通情報取得を開始します。");

        iwssnSyanaiHozenInfoOutputBean = pIwssnSyanaiHozenInfoOutputBean;

        init();
        initSub();

        iwssnKykSyoukaiKekkaKbn = C_IwssnKykSyoukaiKekkaKbn.NORMAL;
        String syoNo = iwssnSyanaiHozenInfoOutputBean.getIwssnSyono();
        BizDate sysDate = BizDate.getSysDate();

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        SetSyokenhakkouymd setSyokenhakkouymd = SWAKInjector.getInstance(SetSyokenhakkouymd.class);
        BizDate syokensakuseiYmd = setSyokenhakkouymd.exec(kykKihon.getSeirituymd());

        iwssnSyanaiHozenInfoOutputBean.setIwssnAisyoumeikbn(kykKihon.getAisyoumeikbn().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnAisyoumeikj(initZenkaku(kykKihon.getAisyoumeikbn().getContent()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnBosyuuym(initDate(kykKihon.getBosyuuym()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyhenkouymd(initDate(kykKihon.getSyhenkouymd()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyhenkousyorinm(initZenkaku(kykKihon.getKinou().getKinouNm()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyokensakuseiymd(initDate(syokensakuseiYmd));
        iwssnSyanaiHozenInfoOutputBean.setIwssnYakkanjyuryouhoukbn(kykKihon.getYakkanjyuryouhoukbn().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnYakkanjyuryouhoukbnnm(initZenkaku(kykKihon.getYakkanjyuryouhoukbn().getContent(C_YakkanJyuryouKbn.PATTERN_HOZEN)));
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyosaihkymd(initDate(kykKihon.getLastsyosaihkymd()));

        C_UmuKbn pYenTutYuusouUmu = C_UmuKbn.NONE;
        C_UmuKbn pYenTutMailUmu = C_UmuKbn.NONE;
        C_PyenTutHouKbn pYenTutHouKbn = C_PyenTutHouKbn.BLNK;

        if (!C_YnkHrkmgkAnniTuutiKbn.BLNK.eq(kykKihon.getYnkhrkmgkannituutikbn())) {

            if (C_YnkHrkmgkAnniTuutiKbn.YUUSOUKIBOU.eq(kykKihon.getYnkhrkmgkannituutikbn())) {

                pYenTutYuusouUmu = C_UmuKbn.ARI;
            }

            List<MT_DsMailAddress> dsMailAddressList = khGetSyanaiWebKeiyakuInfoDao.getDsMailAddressTrkjkInfoList(syoNo);

            if (dsMailAddressList.size() > 0){

                MT_DsMailAddress dsMailAddress = dsMailAddressList.get(0);

                if (C_DsMailSousinJyoutaiKbn.YUUKOU.eq(dsMailAddress.getDsmailsousinjyoutaikbn()) ||
                    C_DsMailSousinTeisiRiyuuKbn.MAILHAISINERROR.eq(dsMailAddress.getDsmailsousintisrykbn())) {

                    pYenTutMailUmu = C_UmuKbn.ARI;
                }
            }

            if (C_UmuKbn.ARI.eq(pYenTutYuusouUmu)) {

                if (C_UmuKbn.ARI.eq(pYenTutMailUmu)) {

                    pYenTutHouKbn = C_PyenTutHouKbn.MAILYUUSOUKIBOU;
                }
                else {
                    pYenTutHouKbn = C_PyenTutHouKbn.YUUSOUKIBOU;
                }
            }
            else {
                if (C_UmuKbn.ARI.eq(pYenTutMailUmu)) {

                    pYenTutHouKbn = C_PyenTutHouKbn.MAILKIBOU;
                }
                else {
                    pYenTutHouKbn = C_PyenTutHouKbn.KIBOUSINAI;
                }
            }
        }
        iwssnSyanaiHozenInfoOutputBean.setIwssnYnkhrkmgkannittkbn(pYenTutHouKbn.getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnYnkhrkmgkannittkbnnm(initZenkaku(pYenTutHouKbn.getContent()));

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyouhnnm(initZenkaku(kykSyouhn.getSyouhnZokusei().getSyouhnnm()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykjyoutaikbn(kykSyouhn.getKykjyoutai().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykjyoutaikbnnm(initZenkaku(kykSyouhn.getKykjyoutai().getContent()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykymd(initDate(kykSyouhn.getKykymd()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnSknnkaisiymd(initDate(kykSyouhn.getSknnkaisiymd()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn(String.valueOf(kykSyouhn.getHknkkn()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyoumetujiyuu(kykSyouhn.getSyoumetujiyuu().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyoumetujiyuukj(initZenkaku(kykSyouhn.getSyoumetujiyuu().getContent()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyoumetuymd(initDate(kykSyouhn.getSyoumetuymd()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnKihonhokenkngk(initCurrency(kykSyouhn.getKihons()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnKihonhokenkngktuukasyu(initCurrencyType(kykSyouhn.getKihons()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyuhknkknsmnkbn(kykSyouhn.getHknkknsmnkbn().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyuhknkknsmnkbnnm(initZenkaku(kykSyouhn.getHknkknsmnkbn().getContent()));

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        boolean checkYuuyokkngaiKekka = checkYuuyokkngai.exec(syoNo, sysDate);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

        int hhknnen = setNenrei.exec(sysDate, hhknSya.getHhknseiymd());
        iwssnSyanaiHozenInfoOutputBean.setIwssnHhknsyanmkn(initKana(hhknSya.getHhknnmkn()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnHhknnmkj(initZenkaku(hhknSya.getHhknnmkj()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnHhknseiymd(initDate(hhknSya.getHhknseiymd()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnHhknkyknen(String.valueOf(kykSyouhn.getHhknnen()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnHhknnen(String.valueOf(hhknnen));
        iwssnSyanaiHozenInfoOutputBean.setIwssnHhknsei(hhknSya.getHhknsei().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnHhknseikj(initZenkaku(hhknSya.getHhknsei().getContent()));

        IT_KykSya kykSya = kykKihon.getKykSya();

        int kyksyanen = setNenrei.exec(sysDate, kykSya.getKykseiymd());

        iwssnSyanaiHozenInfoOutputBean.setIwssnKyknmkn(initKana(kykSya.getKyknmkn()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnKyknmkj(initZenkaku(kykSya.getKyknmkj()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnKyksyaseiymd(initDate(kykSya.getKykseiymd()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnKyksyanen(String.valueOf(kyksyanen));
        iwssnSyanaiHozenInfoOutputBean.setIwssnKyksyasei(kykSya.getKyksei().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykseikj(initZenkaku(kykSya.getKyksei().getContent()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnKyktdk(kykSya.getKkkyktdk().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnKyktdkkj(initZenkaku(kykSya.getKkkyktdk().getContent(C_Tdk.PATTERN_KYKSYA)));
        iwssnSyanaiHozenInfoOutputBean.setIwssnTsinyno(initYuubinNo(kykSya.getTsinyno()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnTsinadr1kj(initZenkaku(kykSya.getTsinadr1kj()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnTsinadr2kj(initZenkaku(kykSya.getTsinadr2kj()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnTsinadr3kj(initZenkaku(kykSya.getTsinadr3kj()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnTsintelno(initHankaku(kykSya.getTsintelno()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnDai2tsintelno(initHankaku(kykSya.getDai2tsintelno()));

        if (kykKihon.getSbuktnin() < 5) {

            List<IT_KykUkt> sibouKykUktList = khozenCommonParam.getSibouUketorinin(syoNo);

            if (sibouKykUktList != null) {
                iwssnSyanaiHozenInfoOutputBean.setIwssnSibouuktkbn(sibouKykUktList.get(0).getUktkbn().getValue());
                iwssnSyanaiHozenInfoOutputBean.setIwssnSibouuktkj(initZenkaku(sibouKykUktList.get(0).getUktkbn().getContent(C_UktKbn.PATTERN_KHSBUK)));

                for (int n = 0; n < sibouKykUktList.size(); n++) {

                    if (n == 0) {

                        BizNumber sibouHknknBunwari1 = sibouKykUktList.get(n).getUktbnwari();
                        String sibouHknknuktsmikana1 = HANKAKUEIKANOSYOKITI;
                        String sibouHknknuktsmikanji1 = NIHONGOSYOKITI;

                        if (C_UktKbn.KYK.eq(sibouKykUktList.get(n).getUktkbn())) {

                            sibouHknknuktsmikana1 = iwssnSyanaiHozenInfoOutputBean.getIwssnKyknmkn();
                            sibouHknknuktsmikanji1 = iwssnSyanaiHozenInfoOutputBean.getIwssnKyknmkj();
                        }
                        else if (C_UktKbn.HHKN.eq(sibouKykUktList.get(n).getUktkbn())) {

                            sibouHknknuktsmikana1 = iwssnSyanaiHozenInfoOutputBean.getIwssnHhknsyanmkn();
                            sibouHknknuktsmikanji1 = iwssnSyanaiHozenInfoOutputBean.getIwssnHhknnmkj();
                        }
                        else if (C_UktKbn.TOKUTEIMEIGI.eq(sibouKykUktList.get(n).getUktkbn())) {

                            sibouHknknuktsmikana1 = sibouKykUktList.get(0).getUktnmkn();
                            sibouHknknuktsmikanji1 = sibouKykUktList.get(0).getUktnmkj();

                        }
                        else if (C_UktKbn.SOUZOKUNIN.eq(sibouKykUktList.get(n).getUktkbn())) {

                            sibouHknknuktsmikana1 = "ｿｳｿﾞｸﾆﾝ";
                            sibouHknknuktsmikanji1 = "相続人";
                        }

                        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknbunwari1(initNum(sibouHknknBunwari1));
                        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikana1(initKana(sibouHknknuktsmikana1));
                        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikanji1(initZenkaku(sibouHknknuktsmikanji1));

                        continue;

                    }

                    reflect(iwssnSyanaiHozenInfoOutputBean, "setIwssnSibouhknknbunwari" + (n + 1), initNum(sibouKykUktList.get(n).getUktbnwari()));
                    reflect(iwssnSyanaiHozenInfoOutputBean, "setIwssnSibouhknknuktsmikana" + (n + 1), initKana(sibouKykUktList.get(n).getUktnmkn()));
                    reflect(iwssnSyanaiHozenInfoOutputBean, "setIwssnSibouhknknuktsmikanji" + (n + 1), initZenkaku(sibouKykUktList.get(n).getUktnmkj()));

                    if (n + 1 >= 4) {
                        break;
                    }
                }
            }
            else {

                setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR);
            }
        }

        C_UmuKbn kzktrkserviceryUmu = C_UmuKbn.NONE;
        List<IT_TrkKzk> trkKzkList = khozenCommonParam.getTrkKzk(syoNo);

        if (trkKzkList != null) {
            kzktrkserviceryUmu = C_UmuKbn.ARI;
            for (IT_TrkKzk trkKzk : trkKzkList) {
                if (C_TrkKzkKbn.TRKKZK1.eq(trkKzk.getTrkkzkkbn())) {

                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzknm1kn(initKana(trkKzk.getTrkkzknmkn()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzknm1kj(initZenkaku(trkKzk.getTrkkzknmkj()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1seiymd(initDate(trkKzk.getTrkkzkseiymd()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1sei(trkKzk.getTrkkzksei().getValue());
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1seinm(initZenkaku(trkKzk.getTrkkzksei().getContent()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1tdk(trkKzk.getTrkkzktdk().getValue());
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1tdknm(initZenkaku(trkKzk.getTrkkzktdk().getContent()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1yno(initYuubinNo(trkKzk.getTrkkzkyno()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1adr1kj(initZenkaku(trkKzk.getTrkkzkadr1kj()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1adr2kj(initZenkaku(trkKzk.getTrkkzkadr2kj()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1adr3kj(initZenkaku(trkKzk.getTrkkzkadr3kj()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1telno(initHankaku(trkKzk.getTrkkzktelno()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1tsindousiteikbn(trkKzk.getTrkkzktsindousiteikbn().getValue());
                }

                else if (C_TrkKzkKbn.TRKKZK2.eq(trkKzk.getTrkkzkkbn())) {

                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzknm2kn(initKana(trkKzk.getTrkkzknmkn()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzknm2kj(initZenkaku(trkKzk.getTrkkzknmkj()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2seiymd(initDate(trkKzk.getTrkkzkseiymd()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2sei(trkKzk.getTrkkzksei().getValue());
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2seinm(initZenkaku(trkKzk.getTrkkzksei().getContent()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2tdk(trkKzk.getTrkkzktdk().getValue());
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2tdknm(initZenkaku(trkKzk.getTrkkzktdk().getContent()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2yno(initYuubinNo(trkKzk.getTrkkzkyno()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2adr1kj(initZenkaku(trkKzk.getTrkkzkadr1kj()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2adr2kj(initZenkaku(trkKzk.getTrkkzkadr2kj()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2adr3kj(initZenkaku(trkKzk.getTrkkzkadr3kj()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2telno(initHankaku(trkKzk.getTrkkzktelno()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2tsindousiteikbn(trkKzk.getTrkkzktsindousiteikbn().getValue());
                }
            }
        }

        iwssnSyanaiHozenInfoOutputBean.setIwssnKzktrkserviceryumu(kzktrkserviceryUmu.getValue());


        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        String penhrktkkbn = C_YennykntksyuruiKbn.BLNK.getValue();

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {

            penhrktkkbn = kykSonotaTkyk.getYennyknsyuruikbn().getValue();
        }

        iwssnSyanaiHozenInfoOutputBean.setIwssnPyenhrktkkbn(penhrktkkbn);
        iwssnSyanaiHozenInfoOutputBean.setIwssnStdrskntkyhkkbn(kykSonotaTkyk.getStdrsktkyhkumu().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykdrtkykhukakbn(kykSonotaTkyk.getKykdrtkykhukaumu().getValue());

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getStdrsktkyhkumu())) {

            IT_KykUkt uktHhkdrnin = khozenCommonParam.getSiteiDairiSeikyuunin(syoNo);

            if (uktHhkdrnin != null) {

                iwssnSyanaiHozenInfoOutputBean.setIwssnStdrsknkbn(uktHhkdrnin.getUktkbn().getValue());
                iwssnSyanaiHozenInfoOutputBean.setIwssnStdrsknkbnnm(initZenkaku(uktHhkdrnin.getUktkbn().getContent(C_UktKbn.PATTERN_KHSTDR)));
                iwssnSyanaiHozenInfoOutputBean.setIwssnStdrsknsmikanji(initZenkaku(uktHhkdrnin.getUktnmkj()));
                iwssnSyanaiHozenInfoOutputBean.setIwssnStdrsknsmikana(initKana(uktHhkdrnin.getUktnmkn()));
                iwssnSyanaiHozenInfoOutputBean.setIwssnHhkdrseiymd(initDate(uktHhkdrnin.getUktseiymd()));

            }
            else {

                setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR);
            }
        }

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getKykdrtkykhukaumu())) {

            IT_KykUkt kyksyaDairinin = khozenCommonParam.getKyksyaDairinin(syoNo);
            if (kyksyaDairinin != null) {

                iwssnSyanaiHozenInfoOutputBean.setIwssnKykdrkbn(kyksyaDairinin.getUktkbn().getValue());
                iwssnSyanaiHozenInfoOutputBean.setIwssnKykdrkbnnm(initZenkaku(kyksyaDairinin.getUktkbn().getContent(C_UktKbn.PATTERN_KHKYKDR)));
                iwssnSyanaiHozenInfoOutputBean.setIwssnKykdairinmkj(initZenkaku(kyksyaDairinin.getUktnmkj()));
                iwssnSyanaiHozenInfoOutputBean.setIwssnKykdairinmkn(initKana(kyksyaDairinin.getUktnmkn()));
                iwssnSyanaiHozenInfoOutputBean.setIwssnKykdryno(initYuubinNo(kyksyaDairinin.getUktyno()));
                iwssnSyanaiHozenInfoOutputBean.setIwssnKykdradr1kj(initZenkaku(kyksyaDairinin.getUktadr1kj()));
                iwssnSyanaiHozenInfoOutputBean.setIwssnKykdradr2kj(initZenkaku(kyksyaDairinin.getUktadr2kj()));
                iwssnSyanaiHozenInfoOutputBean.setIwssnKykdradr3kj(initZenkaku(kyksyaDairinin.getUktadr3kj()));
                iwssnSyanaiHozenInfoOutputBean.setIwssnKykdrseiymd(initDate(kyksyaDairinin.getUktseiymd()));

            }
            else {

                setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR);
            }
        }

        List<IT_KykDairiten> kykDairitenList = kykKihon.getKykDairitens();
        if (kykDairitenList != null && kykDairitenList.size() > 0) {

            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
            List<BzGetAgInfoBean> aBzGetAgInfoBeanList = bzGetAgInfo.exec(kykDairitenList.get(0).getDrtencd());

            if (aBzGetAgInfoBeanList.size() > 0) {
                iwssnSyanaiHozenInfoOutputBean.setIwssnDairitencd1(initHankaku(aBzGetAgInfoBeanList.get(2).getDrtenCd()));
                iwssnSyanaiHozenInfoOutputBean.setIwssnDairitenm1(initZenkaku(aBzGetAgInfoBeanList.get(2).getKanjiDairitenNm()));
            }
            else {
                setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.TANTOUSYAINFO_ERROR);
            }

            BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);
            BzGetBsInfoBean aBzGetBsInfoBean = bzGetBsInfo.exec(kykDairitenList.get(0).getBosyuucd());

            iwssnSyanaiHozenInfoOutputBean.setIwssnDaibosyuucd1(initHankaku(kykDairitenList.get(0).getBosyuucd()));

            if (aBzGetBsInfoBean != null) {
                iwssnSyanaiHozenInfoOutputBean.setIwssnBosyuunin1(initZenkaku(aBzGetBsInfoBean.getKanjiBosyuuninNm()));
            }
            else {
                setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.TANTOUSYAINFO_ERROR);
            }

            if (kykDairitenList.size() > 1) {
                List<BzGetAgInfoBean> bBzGetAgInfoBeanList = bzGetAgInfo.exec(kykDairitenList.get(1).getDrtencd());

                if (bBzGetAgInfoBeanList.size() > 0) {
                    iwssnSyanaiHozenInfoOutputBean.setIwssnDairitencd2(initHankaku(bBzGetAgInfoBeanList.get(2).getDrtenCd()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnDairitenm2(initZenkaku(bBzGetAgInfoBeanList.get(2).getKanjiDairitenNm()));
                }
                else {
                    setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.TANTOUSYAINFO_ERROR);
                }

                BzGetBsInfoBean bBzGetBsInfoBean = bzGetBsInfo.exec(kykDairitenList.get(1).getBosyuucd());

                iwssnSyanaiHozenInfoOutputBean.setIwssnDaibosyuucd2(initHankaku(kykDairitenList.get(1).getBosyuucd()));

                if (bBzGetBsInfoBean != null) {
                    iwssnSyanaiHozenInfoOutputBean.setIwssnBosyuunin2(initZenkaku(bBzGetBsInfoBean.getKanjiBosyuuninNm()));
                }
                else {

                    setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.TANTOUSYAINFO_ERROR);
                }
            }
        }
        else {
            setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.TANTOUSYAINFO_ERROR);
        }

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        if (khTtdkTyuui != null) {

            for (int n = 1; n <= 5; n++) {

                C_TtdktyuuiKbn ttdktyuuiKbn = ((C_TtdktyuuiKbn) reflect(khTtdkTyuui, "getTtdktyuuikbn" + n, null));

                reflect(iwssnSyanaiHozenInfoOutputBean, "setIwssnTtdktyuuikbn"   + n, ttdktyuuiKbn.getValue());
                reflect(iwssnSyanaiHozenInfoOutputBean, "setIwssnTtdktyuuikbnkj" + n, initZenkaku(ttdktyuuiKbn.getContent()));

                BizDate ttdktyuuikbnsetymd = ((BizDate) reflect(khTtdkTyuui, "getTtdktyuuikbnsetymd" + n, null));
                String ttdktyuuikbnhsknaiyou = ((String) reflect(khTtdkTyuui, "getTtdktyuuikbnhsknaiyou" + n, null));

                reflect(iwssnSyanaiHozenInfoOutputBean, "setIwssnTtdktyuuisetymd" + n, initDate(ttdktyuuikbnsetymd));
                reflect(iwssnSyanaiHozenInfoOutputBean, "setIwssnTtdktyuuinaiyo"  + n, initZenkaku(ttdktyuuikbnhsknaiyou));

            }

            String kykdrknhatudouJyoutai = "0";
            if (C_KykdrknHtdjytKbn.SETTEI.eq(khTtdkTyuui.getKykdrknhatudoujyoutai())) {

                kykdrknhatudouJyoutai = "2";
            }
            else {
                if (C_KykdrDouiYouhiKbn.YOU.eq(khTtdkTyuui.getKykdrdouiyouhi())) {

                    kykdrknhatudouJyoutai = "1";
                }
            }

            iwssnSyanaiHozenInfoOutputBean.setIwssnKykdrknhatudoujyoutai(kykdrknhatudouJyoutai);

            iwssnSyanaiHozenInfoOutputBean.setIwssnStknsetkbn(kykKihon.getStknsetkbn().getValue());
            iwssnSyanaiHozenInfoOutputBean.setIwssnStknsetkbnnm(initZenkaku(kykKihon.getStknsetkbn().getContent()));

        }
        else {

            setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.TDKTYUUIINFO_ERROR);
        }

        List<KhTtdkRirekiInfosBySyonoBean> khTtdkRirekiInfosBySyonoBeanList = hozenDomManager.getKhTtdkRirekiInfosBySyono(syoNo);

        if (khTtdkRirekiInfosBySyonoBeanList.size() != 0) {

            int count = 1;
            for (KhTtdkRirekiInfosBySyonoBean khTtdkRirekiInfosBySyonoBean : khTtdkRirekiInfosBySyonoBeanList) {

                if(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(khTtdkRirekiInfosBySyonoBean.getGyoumuKousinKinou())) {
                    continue;
                }

                reflect(iwssnSyanaiHozenInfoOutputBean, "setIwssnTtdkrrksyoriymd" + count, initDate(khTtdkRirekiInfosBySyonoBean.getSyoriYmd()));

                if (C_SyoriKbn.BLNK.eq(khTtdkRirekiInfosBySyonoBean.getSyorikbn())) {

                    reflect(iwssnSyanaiHozenInfoOutputBean, "setIwssnTtdkrrksyorinaiyou" + count, initZenkaku(khTtdkRirekiInfosBySyonoBean.getKinouNm()));
                }
                else {

                    String ttdkrrksyorinaiyou = khTtdkRirekiInfosBySyonoBean.getKinouNm() +
                        "（" + C_SyoriKbn.getContentByValue(C_SyoriKbn.PATTERN_SYOUKAI, khTtdkRirekiInfosBySyonoBean.getSyorikbn().getValue()) + "）";

                    reflect(iwssnSyanaiHozenInfoOutputBean, "setIwssnTtdkrrksyorinaiyou" + count, initZenkaku(ttdkrrksyorinaiyou));
                }
                if (count++ >= 3) {
                    break;
                }
            }
        }
        else {

            setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR);
        }

        String yakkanbunsyoNo = kykKihon.getYakkanbunsyono();

        if (!BizUtil.isBlank(yakkanbunsyoNo)) {

            Matcher mc = Pattern.compile("(\\w{2})(\\w{4})(\\w{4})").matcher(yakkanbunsyoNo);
            yakkanbunsyoNo = mc.replaceAll("$1-$2-$3");

            iwssnSyanaiHozenInfoOutputBean.setIwssnSioriyakkansearchcd(initHankaku(yakkanbunsyoNo));
        }

        String siteiTuuka = "";

        if (kykSyouhn.getYendthnkymd() == null) {

            siteiTuuka = kykSyouhn.getKyktuukasyu().getValue();
        }
        else {
            IT_KykSyouhnHnkmae kykSyouhnHnkmae = hozenDomManager.getKykSyouhnHnkmaeBySyono(syoNo);
            if (kykSyouhnHnkmae != null) {
                siteiTuuka = kykSyouhnHnkmae.getKyktuukasyu().getValue();
            }
            else {

                setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR);
            }
        }
        iwssnSyanaiHozenInfoOutputBean.setIwssnSiteituuka(initHankaku(siteiTuuka));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = khozenCommonParam.getNyknJissekiRirekiSk(syoNo);

        int syouhinhanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

        if (nyknJissekiRirekiList != null) {

            if (C_UmuKbn.ARI.eq(kykSyouhn.getSyouhnZokusei().getHeijyunbaraiumu())) {

                if (syouhinhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                    KeisanGaisanPsougk keisanGaisanPsougk = SWAKInjector.getInstance(KeisanGaisanPsougk.class);

                    BizCurrency gaisanPsougk = keisanGaisanPsougk.exec(kykKihon.getHrkp(),
                        kykKihon.getHrkkaisuu(),
                        kykSyouhn.getKykymd(),
                        kykSyouhn.getHaraimanymd());

                    if (BizCurrencyTypes.YEN != gaisanPsougk.getType()) {
                        iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakugaika(initCurrency(gaisanPsougk));
                        iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakugktuksyu(initCurrencyType(gaisanPsougk));
                    }
                    else {
                        iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakuyen(initCurrency(gaisanPsougk));
                        iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakuyentuksyu(initCurrencyType(gaisanPsougk));
                    }
                }
                else if (syouhinhanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN){

                    iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakuyen(initCurrency(kykSyouhn.getPharaikomisougaku()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakuyentuksyu(initCurrencyType(kykSyouhn.getPharaikomisougaku()));
                }
            }
            else if(!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                if (BizUtil.isZero(kykSyouhn.getGengakugoyenitijibrpstgk())) {

                    C_Tkhukaumu tkhukaumu = C_Tkhukaumu.NONE;
                    if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {

                        tkhukaumu = C_Tkhukaumu.HUKA;
                    }

                    KeisanKijyungk keisankijyungk = SWAKInjector.getInstance(KeisanKijyungk.class);

                    C_ErrorKbn errorKbn = keisankijyungk.exec(nyknJissekiRirekiList.get(0).getRyosyuymd(),
                        nyknJissekiRirekiList.get(0).getRsgaku(),
                        nyknJissekiRirekiList.get(0).getHrkp(),
                        kykSyouhn.getKyktuukasyu(),
                        tkhukaumu);

                    if (C_ErrorKbn.OK.eq(errorKbn)) {
                        iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakuyen(initCurrency(keisankijyungk.getKijyungk()));
                        iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakuyentuksyu(initCurrencyType(keisankijyungk.getKijyungk()));

                    }
                    else {

                        setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR);
                    }
                }
                else {

                    iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakuyen(initCurrency(kykSyouhn.getGengakugoyenitijibrpstgk()));
                    iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakuyentuksyu(initCurrencyType(kykSyouhn.getGengakugoyenitijibrpstgk()));
                }
            }

            iwssnSyanaiHozenInfoOutputBean.setIwssnHrktuuka(nyknJissekiRirekiList.get(0).getRstuukasyu().getValue());

        }
        else {

            setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR);
        }

        if (C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhn.getYuukousyoumetukbn())) {

            IT_AnsyuKihon ansyukihon = hozenDomManager.getAnsyuKihon(syoNo);

            BizDate kaiyakuYmd = BizDate.getSysDate();

            if (!checkYuuyokkngaiKekka) {

                SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);
                setYuuyokknmanryobi.exec(
                    syoNo,
                    ansyukihon.getJkipjytym()
                    );

                kaiyakuYmd = setYuuyokknmanryobi.getSyoumetubi();
            }

            CheckKaiyakuBean checkKaiyakuBean = SWAKInjector.getInstance(CheckKaiyakuBean.class);
            checkKaiyakuBean.setSyoruiukeYmd(kaiyakuYmd);
            checkKaiyakuBean.setSyukykYmd(kykSyouhn.getKykymd());
            checkKaiyakuBean.setYendthnkYmd(kykSyouhn.getYendthnkymd());
            checkKaiyakuBean.setSyoriYmd(sysDate);
            checkKaiyakuBean.setKykKihon(kykKihon);
            checkKaiyakuBean.setAnsyuKihon(ansyukihon);

            CheckKaiyaku checkKaiyaku = SWAKInjector.getInstance(CheckKaiyaku.class);
            C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec(
                CheckKaiyaku.KINOUBUNRUI_DRCTSERVICE,
                "",
                checkKaiyakuBean
                );

            if (C_KaiyakuchkkekkaKbn.ERROR.eq(kaiyakuchkkekkaKbn)) {
                setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.CASHVALUEINFO_ERROR);
            }

            if (!C_KaiyakuchkkekkaKbn.ERROR.eq(kaiyakuchkkekkaKbn)) {

                GetKawaseRate getKawaseRateYn = SWAKInjector.getInstance(GetKawaseRate.class);
                GetKawaseRate getKawaseRateGk = SWAKInjector.getInstance(GetKawaseRate.class);
                BizNumber yenshrKwsrate = null;
                BizNumber gikshrKwsrate = null;
                C_ErrorKbn kawaseRateErrorKbnYn = null;
                C_ErrorKbn kawaseRateErrorKbnGk = null;

                if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                    kawaseRateErrorKbnYn = getKawaseRateYn.exec(
                        kaiyakuYmd,
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                        kykSyouhn.getKyktuukasyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.SYUKKINRATE,
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                        C_YouhiKbn.YOU);

                    if (C_ErrorKbn.OK.eq(kawaseRateErrorKbnYn)) {

                        yenshrKwsrate = getKawaseRateYn.getKawaserate();

                        iwssnSyanaiHozenInfoOutputBean.setIwssnShrkwsrate(initNum(yenshrKwsrate));
                        iwssnSyanaiHozenInfoOutputBean.setIwssnKwsratesyutokuymd(initDate(getKawaseRateYn.getKwsrateKjYmd()));

                    }
                    else {

                        setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.CASHVALUEINFO_ERROR);
                    }

                    kawaseRateErrorKbnGk = getKawaseRateGk.exec(
                        kaiyakuYmd,
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                        kykSyouhn.getKyktuukasyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.NYUKINRATE,
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                        C_YouhiKbn.YOU);

                    if (C_ErrorKbn.OK.eq(kawaseRateErrorKbnGk)) {

                        gikshrKwsrate = getKawaseRateGk.getKawaserate();

                    }
                    else {

                        setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.CASHVALUEINFO_ERROR);
                    }
                }

                KeisanCommonKaiyaku keisanCommonKaiyaku = SWAKInjector.getInstance(KeisanCommonKaiyaku.class);
                KeisanKaiyakuBean keisanKaiyakuBean = SWAKInjector.getInstance(KeisanKaiyakuBean.class);

                if ((!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu()) && C_ErrorKbn.OK.eq(kawaseRateErrorKbnYn) && C_ErrorKbn.OK.eq(kawaseRateErrorKbnGk)) ||
                    C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                    keisanKaiyakuBean.setSyoruiukeymd(sysDate);
                    keisanKaiyakuBean.setKaiykymd(kaiyakuYmd);
                    keisanKaiyakuBean.setYenshrkwsrate(yenshrKwsrate);
                    keisanKaiyakuBean.setGkshrkwsrate(gikshrKwsrate);

                    C_ErrorKbn keisanKaiyakuErrorKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(
                        KeisanCommonKaiyaku.KINOUBUNRUI_ONLINE,
                        kykKihon,
                        sysDate,
                        keisanKaiyakuBean
                        );

                    if (C_ErrorKbn.OK.eq(keisanKaiyakuErrorKbn)) {

                        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

                        iwssnSyanaiHozenInfoOutputBean.setIwssnShrgkkeiyen(initCurrency(keisanCommonKaiyakuOutBean.getShrgkkeiYen()));
                        iwssnSyanaiHozenInfoOutputBean.setIwssnShrgkkeiyentuukasyu(initCurrencyType(keisanCommonKaiyakuOutBean.getShrgkkeiYen()));

                        if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                            iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakuhrgaika(initCurrency(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeigk()));
                            iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakuhrgaikatuukasyu(initCurrencyType(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeigk()));
                            iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakuhryen(initCurrency(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen()));
                            iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakuhryentuukasyu(initCurrencyType(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen()));

                            if (checkYuuyokkngaiKekka) {
                                iwssnSyanaiHozenInfoOutputBean.setIwssnShrgkkeigaika(initCurrency(keisanCommonKaiyakuOutBean.getShrgkkeigk()));
                                iwssnSyanaiHozenInfoOutputBean.setIwssnShrgkkeigaikatuukasyu(initCurrencyType(keisanCommonKaiyakuOutBean.getShrgkkeigk()));
                            }
                        }
                        else {

                            if (syouhinhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                                iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakuhryen(initCurrency(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen()));
                                iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakuhryentuukasyu(initCurrencyType(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen()));
                            }
                            else {

                                iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakuhryen(initCurrency(keisanCommonKaiyakuOutBean.getKaiyakuHrYen()));
                                iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakuhryentuukasyu(initCurrencyType(keisanCommonKaiyakuOutBean.getKaiyakuHrYen()));
                            }
                        }
                    }

                    else {

                        setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.CASHVALUEINFO_ERROR);
                    }
                }
            }
        }

        BizDate calcHkShrKngkYmd = BizDate.getSysDate();

        if (!C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhn.getYuukousyoumetukbn())) {

            BizDate syoumetuymd = kykSyouhn.getSyoumetuymd();

            if (BizDateUtil.compareYmd(sysDate, syoumetuymd) == BizDateUtil.COMPARE_GREATER ) {
                calcHkShrKngkYmd = syoumetuymd;
            }
        }

        C_HokenkinsyuruiKbn hokenkinsyuruiKbn = null;

        if (C_UmuKbn.ARI.eq(kykSyouhn.getSyouhnZokusei().getSbhkuktumu())) {
            hokenkinsyuruiKbn = C_HokenkinsyuruiKbn.SBHOKENKIN;
        }

        if (C_UmuKbn.ARI.eq(kykSyouhn.getSyouhnZokusei().getSbkyuuhukinuktumu())) {
            hokenkinsyuruiKbn = C_HokenkinsyuruiKbn.SBKYUUHUKIN;
        }

        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);

        C_ErrorKbn keisanWExtErrorKbn = calcHkShrKngk.execByKeisanWExt(
            syoNo,
            calcHkShrKngkYmd,
            C_SiinKbn.SP,
            hokenkinsyuruiKbn,
            kykKihon.getSdpdkbn(),
            kykKihon.getHrkkeiro());

        if (C_ErrorKbn.OK.eq(keisanWExtErrorKbn)) {
            iwssnSyanaiHozenInfoOutputBean.setIwssnGenzaisbhknkngaku(
                initCurrency(calcHkShrKngk.getCalcHkShrKngkBean().getHokenknGk()));
            iwssnSyanaiHozenInfoOutputBean.setIwssnGenzaisbhknkngakutuksy(
                initCurrencyType(calcHkShrKngk.getCalcHkShrKngkBean().getHokenknGk()));
        }
        else {

            setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR);
        }

        if (C_UmuKbn.ARI.eq(kykSyouhn.getSyouhnZokusei().getMvatekiumu())) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnKykjisjkkktusirrt(initNum100(kykSyouhn.getKyksjkkktyouseiriritu()));

            GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
            GetSjkkktyouseiyourirituBean sjkkktyouseiyourirituBean = SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);
            sjkkktyouseiyourirituBean.setSyouhncd(kykSyouhn.getSyouhncd());
            sjkkktyouseiyourirituBean.setKijyunymd(BizDate.getSysDate());
            sjkkktyouseiyourirituBean.setHknkkn(kykSyouhn.getHknkkn());
            sjkkktyouseiyourirituBean.setHknkknsmnkbn(C_HknkknsmnKbn.BLNK);
            sjkkktyouseiyourirituBean.setHhknnen(0);
            C_ErrorKbn getSjkkktyouseiyourirituKekka = getSjkkktyouseiyouriritu.exec(sjkkktyouseiyourirituBean);

            if (C_ErrorKbn.OK.eq(getSjkkktyouseiyourirituKekka)) {
                iwssnSyanaiHozenInfoOutputBean.setIwssnSyokaijikkktusirrt(initNum100(getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu()));
            }
            else {
                setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.CASHVALUEINFO_ERROR);
            }
        }

        getSyouhnInfo();

        logger.debug("△ 社内Web用保全共通情報取得を終了します｡");

        return iwssnKykSyoukaiKekkaKbn;

    }

    protected abstract void initSub();

    protected abstract void getSyouhnInfo() throws Exception;

    protected void setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn pKykSyoukaiKekkaKbn) {

        if (C_IwssnKykSyoukaiKekkaKbn.NORMAL.eq(iwssnKykSyoukaiKekkaKbn)) {

            iwssnKykSyoukaiKekkaKbn = pKykSyoukaiKekkaKbn;
            return;
        }

        if (iwssnKykSyoukaiKekkaKbn.getValue().compareTo(pKykSyoukaiKekkaKbn.getValue()) > 0) {

            iwssnKykSyoukaiKekkaKbn = pKykSyoukaiKekkaKbn;
        }
    }

    protected Object reflect(Object pObj, String pMethod, Object pParam) throws Exception {
        return  (pParam == null) ?
            pObj.getClass().getMethod(pMethod).invoke(pObj) :
                pObj.getClass().getMethod(pMethod, pParam.getClass()).invoke(pObj, pParam);
    }

    protected String initCurrency(BizCurrency pCurrency) {

        if (pCurrency == null || pCurrency.isZeroOrOptional()) {
            return NUMSYOKITI;
        }

        if (BizCurrencyTypes.YEN == pCurrency.getType()) {
            return pCurrency.toString();
        }

        return GAIKAFORMAT.format(new BigDecimal(pCurrency.toString()));
    }

    protected String initNum(BizNumber pNum) {
        return (pNum == null || pNum.isZeroOrOptional()) ? NUMSYOKITI : String.valueOf(pNum);
    }

    protected String initNum100(BizNumber pNum) {
        return (pNum == null || pNum.isZeroOrOptional()) ? NUMSYOKITI : String.valueOf(pNum.multiply(100));
    }

    protected String initZenkaku(String pStr) {
        return BizUtil.isBlank(pStr) ? NIHONGOSYOKITI : pStr;
    }

    protected String initHankaku(String pStr) {
        return BizUtil.isBlank(pStr) ? HANKAKUEIKANOSYOKITI : pStr;
    }

    protected String initKana(String pStr) {
        return BizUtil.isBlank(pStr) ? HANKAKUEIKANOSYOKITI : ConvertUtil.toHanAll(pStr, 0, 0);
    }

    protected String initDate(BizDate pDate) {
        return pDate == null ? YMDSYOKITI_8 : String.valueOf(pDate);
    }

    protected String initDate(BizDateYM pDate) {
        return pDate == null ? YMDSYOKITI_6 : String.valueOf(pDate);
    }

    protected String initYuubinNo(String pStr) {
        return BizUtil.isBlank(pStr) ? YUUBINNOSYOKITI : pStr;
    }

    protected String initCurrencyType(BizCurrency pCurrency) {
        return pCurrency == null || pCurrency.isZeroOrOptional() ? HANKAKUEIKANOSYOKITI : pCurrency.getCurrencyType();
    }

    private void init() {
        iwssnSyanaiHozenInfoOutputBean.setIwssnKyknmkn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKyknmkj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKyksyaseiymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKyksyanen(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKyksyasei(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykseikj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKyktdk(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKyktdkkj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHhknsyanmkn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHhknnmkj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHhknseiymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHhknkyknen(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHhknnen(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHhknsei(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHhknseikj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTsinyno(YUUBINNOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTsinadr1kj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTsinadr2kj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTsinadr3kj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTsintelno(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouuktkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouuktkj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknbunwari1(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknbunwari2(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknbunwari3(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknbunwari4(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikana1(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikana2(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikana3(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikana4(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikanji1(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikanji2(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikanji3(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSibouhknknuktsmikanji4(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnStdrsknkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnStdrsknkbnnm(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnStdrsknsmikanji(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnStdrskntkyhkkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHhkdrseiymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnStdrsknsmikana(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyouhnnm(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnAisyoumeikj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnAisyoumeikbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyoumetujiyuu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyoumetujiyuukj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykjyoutaikbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykjyoutaikbnnm(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSknnkaisiymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnBosyuuym(YMDSYOKITI_6);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyoumetuymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnPyenhrktkkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHrktuuka(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSiteituuka(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnGenzaisbhknkngaku(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnGenzaisbhknkngakutuksy(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakuhrgaika(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakuhrgaikatuukasyu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakuhryen(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakuhryentuukasyu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnShrgkkeigaika(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnShrgkkeigaikatuukasyu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnShrgkkeiyen(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnShrgkkeiyentuukasyu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnShrkwsrate(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKwsratesyutokuymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnDairitencd1(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnDairitencd2(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnDairitenm1(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnDairitenm2(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnDaibosyuucd1(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnDaibosyuucd2(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnBosyuunin1(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnBosyuunin2(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbn1(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbn2(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbn3(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbn4(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbn5(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbnkj1(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbnkj2(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbnkj3(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbnkj4(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuikbnkj5(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuisetymd1(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuisetymd2(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuisetymd3(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuisetymd4(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuisetymd5(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuinaiyo1(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuinaiyo2(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuinaiyo3(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuinaiyo4(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdktyuuinaiyo5(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdkrrksyoriymd1(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdkrrksyoriymd2(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdkrrksyoriymd3(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdkrrksyorinaiyou1(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdkrrksyorinaiyou2(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTtdkrrksyorinaiyou3(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyhenkouymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyhenkousyorinm(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyokensakuseiymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyosaihkymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnWarnmongon(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnYakkanjyuryouhoukbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnYakkanjyuryouhoukbnnm(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSioriyakkansearchcd(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTeirituwari(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKihonhokenkngk(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKihonhokenkngktuukasyu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyuhknkknsmnkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyuhknkknsmnkbnnm(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzknm1kn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzknm1kj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1seiymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1sei(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1seinm(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1tdk(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1tdknm(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1yno(YUUBINNOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1adr1kj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1adr2kj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1adr3kj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1telno(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzknm2kn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzknm2kj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2seiymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2sei(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2seinm(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2tdk(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2tdknm(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2yno(YUUBINNOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2adr1kj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2adr2kj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2adr3kj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2telno(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykdrkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykdrkbnnm(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykdairinmkj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykdairinmkn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykdryno(YUUBINNOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykdradr1kj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykdradr2kj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykdradr3kj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykdrseiymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykdrknhatudoujyoutai(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakuyen(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakuyentuksyu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykdrtkykhukakbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakugaika(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKijyunkingakugktuksyu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKzktrkserviceryumu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk1tsindousiteikbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTrkkzk2tsindousiteikbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnStknsetkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnStknsetkbnnm(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnYnkhrkmgkannittkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnYnkhrkmgkannittkbnnm(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnDai2tsintelno(HANKAKUEIKANOSYOKITI);
    }
}
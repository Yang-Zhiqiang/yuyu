package yuyu.common.hozen.renkei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.GetBankSitenNm;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgkOutBean;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobi;
import yuyu.common.hozen.renkei.dba4khansyuugetsyanaiwebkeiyakuinfo.KhansyuuGetSyanaiWebKeiyakuInfoDao;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.bean.webservice.IwssnSyanaiAnsyuInfoOutputBean;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_CreditCardInfo;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 サブシステム連携 社内Web用案内収納契約内容情報取得
 */
public class KhansyuuGetSyanaiWebKeiyakuInfo {

    private static final String KAIGYOU_CR = "\r";

    private static final String KAIGYOU_LF = "\n";

    private static final String SPACE_HANKAKU = " ";

    private static final String SPACE_ZENKAKU = "　";

    private static final String ALL_ZERO_1 = "0";

    private static final String ALL_ZERO_6 = "000000";

    private static final String ALL_ZERO_8 = "00000000";

    private IwssnSyanaiAnsyuInfoOutputBean iwssnSyanaiAnsyuInfoOutputBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhansyuuGetSyanaiWebKeiyakuInfoDao khansyuuGetSyanaiWebKeiyakuInfoDao;

    @Inject
    private static Logger logger;

    public C_IwssnKykSyoukaiKekkaKbn exec(String pSyono) {

        logger.debug("▽ 社内Web用案内収納契約内容情報取得 開始");

        C_IwssnKykSyoukaiKekkaKbn syoriKekkaKbn = null;

        try {

            iwssnSyanaiAnsyuInfoOutputBean = SWAKInjector.getInstance(IwssnSyanaiAnsyuInfoOutputBean.class);

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

            List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

            IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();

            if (kykSyouhnList.size() > 0) {
                kykSyouhn = kykSyouhnList.get(0);
            }

            int syouhnhanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHrkkeirokbn(kykKihon.getHrkkeiro().getValue());

            if(C_Hrkkeiro.BLNK.eq(kykKihon.getHrkkeiro())){
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHrkkeirokbnnm(SPACE_ZENKAKU);
            }
            else{
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHrkkeirokbnnm(kykKihon.getHrkkeiro().getContent());
            }

            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHrkkaisuukbn(kykKihon.getHrkkaisuu().getValue());

            if(C_Hrkkaisuu.BLNK.eq(kykKihon.getHrkkaisuu())){
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHrkkaisuukbnnm(SPACE_ZENKAKU);
            }
            else{
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHrkkaisuukbnnm(kykKihon.getHrkkaisuu().getContent());
            }

            if (syouhnhanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
                syouhnhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunjkipjytym(ALL_ZERO_6);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunanjoannaiym1(ALL_ZERO_6);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunanjoannaiym2(ALL_ZERO_6);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunanjoannaiym3(ALL_ZERO_6);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijytym1(ALL_ZERO_6);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijytym2(ALL_ZERO_6);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijytym3(ALL_ZERO_6);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbn1(SPACE_HANKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbn2(SPACE_HANKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbn3(SPACE_HANKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbnnm1(SPACE_ZENKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbnnm2(SPACE_ZENKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbnnm3(SPACE_ZENKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynannaijytkaisuuy(ALL_ZERO_1);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynannaijytkaisuum(ALL_ZERO_1);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunannaigk(ALL_ZERO_1);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHrkp(ALL_ZERO_1);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHrkptuukasyu(SPACE_HANKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnDattairiyuukbn(SPACE_HANKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnDattairiyuukbnnm(SPACE_ZENKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjkouzano(SPACE_HANKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjkzmeigikn(SPACE_HANKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjbanknm(SPACE_ZENKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjsitennm(SPACE_ZENKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjyokinkbnnm(SPACE_ZENKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjbankcd(SPACE_HANKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjsitencd(SPACE_HANKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjyokinkbn(SPACE_HANKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnDattaisyoriymd(ALL_ZERO_8);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnDtjcomment(SPACE_ZENKAKU);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunannaiym(ALL_ZERO_6);
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunannaijyutouym(ALL_ZERO_6);

                if (syouhnhanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ) {
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnTeikiikkatubaraijkkbn(SPACE_HANKAKU);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnTikiktbrjkkbnnm(SPACE_ZENKAKU);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnCreyuukoukakkekka(SPACE_HANKAKU);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnCreyuukoukakkekkakbnnm(SPACE_ZENKAKU);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnCredityuukoukakym(ALL_ZERO_6);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbn1(SPACE_HANKAKU);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbn2(SPACE_HANKAKU);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbn3(SPACE_HANKAKU);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbnnm1(SPACE_ZENKAKU);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbnnm2(SPACE_ZENKAKU);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbnnm3(SPACE_ZENKAKU);
                }

                if (syouhnhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN ) {

                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnYenkansanp(ALL_ZERO_1);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnYenkansanptuukasyu(SPACE_HANKAKU);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnKktikwsrate(ALL_ZERO_1);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnKnsnkijyunymd(ALL_ZERO_8);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnYykknmnryymd(ALL_ZERO_8);
                }

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyono);
                if (ansyuKihon == null) {

                    syoriKekkaKbn = C_IwssnKykSyoukaiKekkaKbn.SONOTAHENSYUU_ERROR;

                    logger.debug("△ 社内Web用案内収納契約内容情報取得 終了");

                    return syoriKekkaKbn;
                }
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunjkipjytym(ansyuKihon.getJkipjytym().toString());

                List<IT_AnsyuRireki> ansyuRirekiList = khansyuuGetSyanaiWebKeiyakuInfoDao.getAnsyuRirekis(pSyono);

                if (ansyuRirekiList.size() >= 1) {

                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunanjoannaiym1(ansyuRirekiList.get(0).getAnnaisakuseiymd()
                        .getBizDateYM().toString());
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijytym1(ansyuRirekiList.get(0).getJyuutouym()
                        .toString());
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbn1(ansyuRirekiList.get(0).getAnnaijkkbn()
                        .getValue());

                    if (!C_AnnaijkKbn.BLNK.eq(ansyuRirekiList.get(0).getAnnaijkkbn())) {

                        iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbnnm1(ansyuRirekiList.get(0).getAnnaijkkbn()
                            .getContent());
                    }

                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunannaiym(ansyuRirekiList.get(0).getAnnaisakuseiymd()
                        .getBizDateYM().toString());
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunannaijyutouym(ansyuRirekiList.get(0).getJyuutouym()
                        .toString());
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynannaijytkaisuuy(ansyuRirekiList.get(0).getJyutoukaisuuy()
                        .toString());
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynannaijytkaisuum(ansyuRirekiList.get(0).getJyutoukaisuum()
                        .toString());
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunannaigk(ansyuRirekiList.get(0).getRsgaku().toString());

                    if (syouhnhanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                        iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbn1(ansyuRirekiList.get(0).
                            getCredituriagengjiyuu().getValue());

                        if (!C_CreditUriageNgJiyuuKbn.BLNK.eq(ansyuRirekiList.get(0).getCredituriagengjiyuu())) {

                            iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbnnm1(
                                ansyuRirekiList.get(0).getCredituriagengjiyuu().getContent());
                        }
                    }
                }

                if (ansyuRirekiList.size() >= 2) {

                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunanjoannaiym2(ansyuRirekiList.get(1).getAnnaisakuseiymd()
                        .getBizDateYM().toString());
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijytym2(ansyuRirekiList.get(1).getJyuutouym()
                        .toString());
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbn2(ansyuRirekiList.get(1).getAnnaijkkbn()
                        .getValue());

                    if (!C_AnnaijkKbn.BLNK.eq(ansyuRirekiList.get(1).getAnnaijkkbn())) {

                        iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbnnm2(ansyuRirekiList.get(1).getAnnaijkkbn()
                            .getContent());
                    }

                    if (syouhnhanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                        iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbn2(ansyuRirekiList.get(1).
                            getCredituriagengjiyuu().getValue());

                        if (!C_CreditUriageNgJiyuuKbn.BLNK.eq(ansyuRirekiList.get(1).getCredituriagengjiyuu())) {

                            iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbnnm2(
                                ansyuRirekiList.get(1).getCredituriagengjiyuu().getContent());
                        }
                    }
                }

                if (ansyuRirekiList.size() >= 3) {

                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunanjoannaiym3(ansyuRirekiList.get(2).getAnnaisakuseiymd()
                        .getBizDateYM().toString());
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijytym3(ansyuRirekiList.get(2).getJyuutouym()
                        .toString());
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbn3(ansyuRirekiList.get(2).getAnnaijkkbn()
                        .getValue());

                    if (!C_AnnaijkKbn.BLNK.eq(ansyuRirekiList.get(2).getAnnaijkkbn())) {

                        iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbnnm3(ansyuRirekiList.get(2).getAnnaijkkbn()
                            .getContent());
                    }

                    if (syouhnhanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                        iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbn3(ansyuRirekiList.get(2).
                            getCredituriagengjiyuu().getValue());

                        if (!C_CreditUriageNgJiyuuKbn.BLNK.eq(ansyuRirekiList.get(2).getCredituriagengjiyuu())) {

                            iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbnnm3(
                                ansyuRirekiList.get(2).getCredituriagengjiyuu().getContent());
                        }
                    }
                }

                IT_Kouza kouza = kykKihon.getKouza();
                GetBankSitenNm getBankSitenNm = SWAKInjector.getInstance(GetBankSitenNm.class);
                if (kouza != null) {

                    getBankSitenNm.exec(kouza.getBankcd(), kouza.getSitencd());

                    if (C_ErrorKbn.ERROR.eq(getBankSitenNm.getErrorKbn())) {

                        syoriKekkaKbn = C_IwssnKykSyoukaiKekkaKbn.SONOTAHENSYUU_ERROR;

                        logger.debug("△ 社内Web用案内収納契約内容情報取得 終了");

                        return syoriKekkaKbn;
                    }

                    String kjBanKnm = "";
                    String kjSitennm = "";
                    String yokinKbn = "";
                    String yokinKbnnm = "";
                    String kouzaNo = "";

                    kjBanKnm = getBankSitenNm.getBankNmKj();
                    kjSitennm = getBankSitenNm.getSitenNmKj();

                    if (!IGkCommonKoumoku.BANKCD_YTGINKOU.equals(kouza.getBankcd())) {

                        yokinKbn = kouza.getYokinkbn().getValue();

                        if (C_YokinKbn.BLNK.eq(kouza.getYokinkbn())) {
                            yokinKbnnm = SPACE_ZENKAKU;
                        }else{
                            yokinKbnnm = kouza.getYokinkbn().getContent();
                        }

                        kouzaNo = kouza.getKouzano();
                    }
                    else {

                        yokinKbn = " ";
                        yokinKbnnm = "　";
                        kouzaNo = kouza.getKouzano().substring(0, 7);
                    }

                    String kzmeiginmei = ConvertUtil.toHanAll(kouza.getKzmeiginmkn(), 0, 0);

                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjbankcd(kouza.getBankcd().toString());
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjbanknm(kjBanKnm);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjsitencd(kouza.getSitencd().toString());
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjsitennm(kjSitennm);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjyokinkbn(yokinKbn);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjyokinkbnnm(yokinKbnnm);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjkouzano(kouzaNo);
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjkzmeigikn(kzmeiginmei);

                }

                if (syouhnhanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnTeikiikkatubaraijkkbn(kykKihon.getTikiktbrisyuruikbn().getValue());

                    if (!C_TkiktbrisyuruiKbn.BLNK.eq(kykKihon.getTikiktbrisyuruikbn())) {

                        iwssnSyanaiAnsyuInfoOutputBean.setIwssnTikiktbrjkkbnnm(kykKihon.getTikiktbrisyuruikbn().getContent());
                    }
                }

                IT_DattaiUktk dattaiUktk = ansyuKihon.getDattaiUktk();
                if (dattaiUktk != null) {

                    String dattaiComment = dattaiUktk.getComment124keta();

                    if (dattaiComment != null) {

                        dattaiComment = dattaiComment.replaceAll(KAIGYOU_CR, "").replaceAll(KAIGYOU_LF, "");
                    }

                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnDattaisyoriymd(dattaiUktk.getSyoriYmd().toString());
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnDattairiyuukbn(dattaiUktk.getDattairiyuukbn().toString());

                    if (!C_DattairiyuuKbn.BLNK.eq(dattaiUktk.getDattairiyuukbn())) {

                        iwssnSyanaiAnsyuInfoOutputBean.setIwssnDattairiyuukbnnm(dattaiUktk.getDattairiyuukbn().getContent());
                    }
                    iwssnSyanaiAnsyuInfoOutputBean.setIwssnDtjcomment(dattaiComment);
                }

                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHrkp(kykKihon.getHrkp().toString());
                iwssnSyanaiAnsyuInfoOutputBean.setIwssnHrkptuukasyu(kykKihon.getHrkp().getCurrencyType());

                if (syouhnhanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                    IT_CreditCardInfo creditCardInfo = kykKihon.getCreditCardInfo();

                    if (creditCardInfo != null) {
                        iwssnSyanaiAnsyuInfoOutputBean.setIwssnCreyuukoukakkekka(creditCardInfo.getCredityuukoukakkekka().
                            getValue());

                        if (!C_Yuukoukakkekka.BLNK.eq(creditCardInfo.getCredityuukoukakkekka())) {

                            iwssnSyanaiAnsyuInfoOutputBean.setIwssnCreyuukoukakkekkakbnnm(creditCardInfo.
                                getCredityuukoukakkekka().getContent());
                        }
                        iwssnSyanaiAnsyuInfoOutputBean.setIwssnCredityuukoukakym(creditCardInfo.getCredityuukoukakym().toString());
                    }
                }

                if (syouhnhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                    C_UmuKbn yennyknTkhkUmu = kykKihon.getKykSonotaTkyk().getYennykntkhkumu();

                    if (C_UmuKbn.ARI.eq(yennyknTkhkUmu)) {

                        int jyuutouNensuu = 0;
                        int jyuutouTukisuu = 0;

                        if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {

                            jyuutouNensuu = 1;
                        }

                        if (C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {

                            jyuutouTukisuu = 6;
                        }
                        else if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {

                            jyuutouTukisuu = 1;
                        }

                        KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);
                        C_ErrorKbn errorKbn = keisanRsgaku.exec(
                            kykKihon,
                            C_Nykkeiro.OTHER,
                            C_NyknaiyouKbn.KEIZOKUP,
                            BizDate.getSysDate(),
                            BizDate.getSysDate().getBizDateYM(),
                            jyuutouNensuu,
                            jyuutouTukisuu);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            syoriKekkaKbn = C_IwssnKykSyoukaiKekkaKbn.SONOTAHENSYUU_ERROR;

                            logger.debug("△ 社内Web用案内収納契約内容情報取得 終了");

                            return syoriKekkaKbn;
                        }

                        KeisanRsgkOutBean keisanRsgkOutBean = keisanRsgaku.getKeisanRsgkOutBean();

                        iwssnSyanaiAnsyuInfoOutputBean.setIwssnYenkansanp(keisanRsgkOutBean.getRsgakuGoukei().toString());
                        iwssnSyanaiAnsyuInfoOutputBean.setIwssnYenkansanptuukasyu(keisanRsgkOutBean.getRsgakuGoukei().getCurrencyType());
                        iwssnSyanaiAnsyuInfoOutputBean.setIwssnKktikwsrate(
                            keisanRsgkOutBean.getKeisanRsgkUtiwakeBeanLst().get(0).getRyosyukwsrate().toString());
                        iwssnSyanaiAnsyuInfoOutputBean.setIwssnKnsnkijyunymd(
                            keisanRsgkOutBean.getKeisanRsgkUtiwakeBeanLst().get(0).getRyosyukwsratekjymd().toString());

                        SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);
                        setYuuyokknmanryobi.exec(ansyuKihon.getSyono(), ansyuKihon.getJkipjytym());

                        iwssnSyanaiAnsyuInfoOutputBean.setIwssnYykknmnryymd(setYuuyokknmanryobi.getTksnYuuyokknMnrybi().toString());
                    }
                }
            }

            syoriKekkaKbn = C_IwssnKykSyoukaiKekkaKbn.NORMAL;

        } catch (Exception e) {
            logger.debug("△ 社内Web用案内収納契約内容情報取得 終了");
            syoriKekkaKbn = C_IwssnKykSyoukaiKekkaKbn.EXCEPTION;
            return syoriKekkaKbn;
        }

        logger.debug("△ 社内Web用案内収納契約内容情報取得 終了");

        return syoriKekkaKbn;

    }

    public IwssnSyanaiAnsyuInfoOutputBean getIwssnSyanaiAnsyuInfoOutputBean() {
        return iwssnSyanaiAnsyuInfoOutputBean;
    }

}

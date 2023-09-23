package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.hozen.khcommon.dba4edithrhnkanryotuuti.EditHrhnKanryoTuutiDao;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_HrhnTtdkKan;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.hozen.bean.report.KhHrhnKanryoTuutiBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;
/**
 * 契約保全 契約保全共通 払変完了通知編集クラス
 */
public class EditHrhnKanryoTuuti {

    private static final String KOUZAMST_MSG_MAE = "※お客さま情報保護のため、";

    private static final String KOUZAMST_MSG_ATO = "の一部を＊にて表示しています。";

    private static final String TUUTYOU_NO = "通帳番号";

    private static final String KOUZA_NO = "口座番号";

    private static final String KZMEIGIN = "口座名義人　";

    private static final String NENHAN_HURISTAR = "上記口座からの振替開始年月　";

    private static final String NEW_KOUZA = "＜変更後のご指定口座＞";

    private static final String PHURIYOTEI = "【今後の保険料振替予定】";

    private static final String SHIROMARU = "○";

    private static final String HURIKAEYMD = "（振替日）";

    private static final String TEN3 = "・・・";

    private static final String KARA = "から";

    private static final String MONTHS = "か月分";

    private static final String MONTHS1 = "から１か月分";

    private static final String IKOU_HURIKAEYMD1 = "○以降、毎月２７日（金融機関休日のときは翌営業日）に１か月分ずつ";

    private static final String IKOU_HURIKAEYMD2 = "　ご指定口座から振り替えさせていただきます。";

    private static final String COMMENT1 = "＊なお、ご契約内容の変更等により、";

    private static final String COMMENT2 = "　には１か月分の保険料を、翌月には２か月分の保険料を振り替えさせ";

    private static final String COMMENT3 = "　ていただくことがございます。予めご了承ください。";

    private static final String NEW_KOUZAANNAI1 = "より、変更後のご指定口座からの";

    private static final String NEW_KOUZAANNAI2 = "　振り替えが開始します。";

    private static final String HANYOU_HRKYKKMSG1 = "【　お願い　】";

    private static final String HANYOU_HRKYKKMSG2 = "ご住所の変更がございましたら、表面に記載の連絡先へ次の事項をお知ら";

    private static final String HANYOU_HRKYKKMSG3 = "せください。";

    private static final String HANYOU_HRKYKKMSG4 = "";

    private static final String HANYOU_HRKYKKMSG5 = "●新しいご住所・電話番号";

    private static final String HANYOU_HRKYKKMSG6 = "●ご加入いただいているすべての証券番号";

    private static final String HANYOU_HRKYKKMSG7 = "●契約者さまのお名前";

    private static final String FURIKAEM_SOUI1 = "＊次は";

    private static final String FURIKAEM_SOUI2 = "の振替となります。ご注意ください。";

    private static final String KAISUUHNK_MIHANEI1 = "＊当通知は口座変更完了のお知らせになります。";

    private static final String KAISUUHNK_MIHANEI2 = "　払込回数のご変更は";

    private static final String KAISUUHNK_MIHANEI3 = "の保険料より適用となります。";

    private static final String TIKIKTBRIHRKP_COMMENT1 = "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込";

    private static final String TIKIKTBRIHRKP_COMMENT2 = "　額（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」";

    private static final String TIKIKTBRIHRKP_COMMENT3 = "　と表示しております。";

    private static final String NEW_CREDITCARD = "＜変更後のクレジットカード＞";

    private static final String CRED_NO = "カード番号　";

    private static final String CRED_MSG1 = "※お客さま情報保護のため、クレジットカード番号の一部を＊にて表示して";

    private static final String CRED_MSG2 = "います。";

    private static final String PHHRIYOTEI = "【今後の保険料お払込予定】";

    private static final String GRIYOUYMD = "（ご利用日）";

    private static final String IKOU_HRRIKAEYMD1 = "○以降、毎月１５日をご利用日として、１か月分の保険料をクレジット";

    private static final String IKOU_HRRIKAEYMD2 = "　カードにて決済させていただきます。";

    private static final String CRED_HURIKAEYMDCOMMENT1 = "＊クレジットカードのご利用日は毎月１５日です。ご指定口座からの保";

    private static final String CRED_HURIKAEYMDCOMMENT2 = "　険料の振替日はクレジットカード会社によって異なり、ご利用日の翌";

    private static final String CRED_HURIKAEYMDCOMMENT3 = "　月や翌々月となることがあります。";

    private static final String NI = "に、";

    private static final String CRED_PHMSG = "　１か月分の保険料をクレジットカードにて決済させていただきます。";

    private static final String CRED_PHSTARMSG1 = "より、変更後のクレジットカード";

    private static final String CRED_PHSTARMSG2 = "　での決済が開始します。";

    private static final String COLON= "：";

    private static final String OLD_CREDNEWKOUHMSG1= "＊クレジットカードによる保険料お払込み等により、保険料振替予定が";

    private static final String OLD_CREDNEWKOUHMSG2= "　変更となることがございます。予めご了承願います。";

    @Inject
    private static Logger logger;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private EditHrhnKanryoTuutiDao editHrhnKanryoTuutiDao;

    @Inject
    private HozenDomManager hozenDomManager;

    public IT_HrhnTtdkKan editTBL(KhozenCommonParam pKhozenCommonParam, IT_KykKihon pKykKihon,
        EditHrhnKanryoTuutiParam pEditHrhnKanryoTuutiParam, BizDate pSyoriymd) {

        logger.debug("▽ 手続完了（払方変更）TBL編集 開始");

        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = null;
        IT_Kouza kouza = null;
        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        kykSya = pKykKihon.getKykSya();
        hhknSya = pKykKihon.getHhknSya();
        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean =
            bzGetSosikiMadogutiInfo.exec(YuyuBizConfig.getInstance().getCallcentersosikicd());

        String kouzaMaskingMsg = "";
        String msgareaMongon1 = "";
        String msgareaMongon2 = "";
        String msgareaMongon3 = "";
        String msgareaMongon4 = "";
        String msgareaMongon5 = "";
        String msgareaMongon6 = "";
        String msgareaMongon7 = "";
        String hurikaekaisiymMongon = "";

        if (C_Hrkkeiro.KOUHURI.eq(pKykKihon.getHrkkeiro())) {

            kouza = pKykKihon.getKouza();

            if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(kouza.getBankcd())) {
                kouzaMaskingMsg = kouzaMaskingMsg + TUUTYOU_NO;
            }
            else {
                kouzaMaskingMsg = kouzaMaskingMsg + KOUZA_NO;
            }

            kouzaMaskingMsg = kouzaMaskingMsg + KOUZAMST_MSG_ATO;

            if ((C_TkiktbrisyuruiKbn.BLNK.eq(pKykKihon.getTikiktbrisyuruikbn())
                && (C_Hrkkaisuu.HALFY.eq(pKykKihon.getHrkkaisuu())
                    || C_Hrkkaisuu.NEN.eq(pKykKihon.getHrkkaisuu())))
                    || (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn())
                        || C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn()))) {

                BizDate annaiKaisiBi = null;
                BizDate hurikaeKaisiBi = null;
                SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

                setHurikaebi.exec(pSyoriymd);

                BizDate chokugoAnnaiBi = setHurikaebi.getTyokugoAnnaibi();

                SetAnnaibi setAnnaibi = SWAKInjector.getInstance(SetAnnaibi.class);

                setAnnaibi.exec(pEditHrhnKanryoTuutiParam.getHennyuym());

                BizDate hennyuymAnnaibi = setAnnaibi.getSeijyouAnnaibi();

                if (BizDateUtil.compareYmd(hennyuymAnnaibi, chokugoAnnaiBi) == BizDateUtil.COMPARE_LESSER) {
                    annaiKaisiBi = chokugoAnnaiBi;
                } else {
                    annaiKaisiBi = hennyuymAnnaibi;
                }

                hurikaeKaisiBi = getTyokugoHurikaebi(annaiKaisiBi);

                String hurikaeKaisiYm = FixedDateFormatter.formatYMZenkakuSeirekiKanji(hurikaeKaisiBi);

                hurikaekaisiymMongon = NENHAN_HURISTAR + hurikaeKaisiYm;
            }

            List<String> lstKzInfoResule = editKouzaInfo(kouza.getBankcd(), kouza.getSitencd(), kouza.getYokinkbn(),
                kouza.getKouzano(), kouza.getKzmeiginmkn(), hurikaekaisiymMongon);

            kouzaMaskingMsg = KOUZAMST_MSG_MAE + kouzaMaskingMsg;
            msgareaMongon1 = NEW_KOUZA;
            msgareaMongon2 = lstKzInfoResule.get(0);
            msgareaMongon3 = lstKzInfoResule.get(1);
            msgareaMongon4 = lstKzInfoResule.get(2);
            msgareaMongon5 = lstKzInfoResule.get(3);
            msgareaMongon6 = lstKzInfoResule.get(4);
            msgareaMongon7 = lstKzInfoResule.get(5);
        }

        else if (C_Hrkkeiro.CREDIT.eq(pKykKihon.getHrkkeiro())){

            CreditCardNoHensyuu creditCardNoHensyuu = SWAKInjector.getInstance(CreditCardNoHensyuu.class);

            String editCreditCardNo = creditCardNoHensyuu.exec(pEditHrhnKanryoTuutiParam.getCardBrandKbn(),
                pEditHrhnKanryoTuutiParam.getCreditKaiinnoSimo4());

            msgareaMongon1 = NEW_CREDITCARD;
            msgareaMongon2 = pEditHrhnKanryoTuutiParam.getCardBrandKbn().getContent();
            msgareaMongon3 = CRED_NO + editCreditCardNo;
            msgareaMongon4 = CRED_MSG1;
            msgareaMongon5 = CRED_MSG2;
        }

        String[] hrkykkMsg = editHrkykkmsg(pKykKihon, pEditHrhnKanryoTuutiParam, pSyoriymd);

        C_HassouKbn hassouKbn = pEditHrhnKanryoTuutiParam.getHassouKbn();
        String honsyakaisouRiyuu = "000";

        AnsyuuSetTetudukityuuiInfo ansyuuSetTetudukityuuiInfo = SWAKInjector.getInstance(
            AnsyuuSetTetudukityuuiInfo.class);

        AnsyuuSetTetudukityuuiInfoBean ansyuuSetTetudukityuuiInfoBean = ansyuuSetTetudukityuuiInfo.
            getAnsyuuSetTetudukityuuiInfo(pKykKihon.getSyono());

        if (C_KktyuitaKbn.DNGNMEMOARI.eq(ansyuuSetTetudukityuuiInfoBean.getKktyuitaKbn())) {

            hassouKbn = C_HassouKbn.HONSYAKAISOU;
            honsyakaisouRiyuu = "Z01";

        }
        else if (C_KykdrknHtdjytKbn.SETTEI.eq(ansyuuSetTetudukityuuiInfoBean.getKykdrknhatudoujyoutaiKbn())) {

            hassouKbn = C_HassouKbn.HONSYAKAISOU;
            honsyakaisouRiyuu = "Z02";

        }

        IT_HrhnTtdkKan hrhnTtdkKan = pKykKihon.createHrhnTtdkKan();

        hrhnTtdkKan.setHenkousikibetukey(pKhozenCommonParam.getSikibetuKey(pKykKihon.getSyono()));

        hrhnTtdkKan.setSyoruiCd(C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI_DNP);
        hrhnTtdkKan.setTyouhyouymd(pSyoriymd);
        hrhnTtdkKan.setShskyno(kykSya.getTsinyno());
        hrhnTtdkKan.setShsadr1kj(kykSya.getTsinadr1kj());
        hrhnTtdkKan.setShsadr2kj(kykSya.getTsinadr2kj());
        hrhnTtdkKan.setShsadr3kj(kykSya.getTsinadr3kj());
        hrhnTtdkKan.setShsnmkj(kykSya.getKyknmkj());
        hrhnTtdkKan.setToiawasesosikinmkj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
        hrhnTtdkKan.setToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
        hrhnTtdkKan.setToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
        hrhnTtdkKan.setToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
        hrhnTtdkKan.setToiawaseadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
        hrhnTtdkKan.setToiawasekaisyanmkj(YuyuBizConfig.getInstance().getHokenKaisyaNmKanji());
        hrhnTtdkKan.setToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());
        hrhnTtdkKan.setToiawaseteluktkkanou1(YuyuBizConfig.getInstance().getUketimecallcenter1());
        hrhnTtdkKan.setToiawaseteluktkkanou2(YuyuBizConfig.getInstance().getUketimecallcenter2());
        hrhnTtdkKan.setKyknmkj(kykSya.getKyknmkj());
        hrhnTtdkKan.setHhknnmkj(hhknSya.getHhknnmkj());
        hrhnTtdkKan.setKouzamaskingmsg(kouzaMaskingMsg);

        if (C_TkiktbrisyuruiKbn.BLNK.eq(pKykKihon.getTikiktbrisyuruikbn())
            || C_TkiktbrisyuruiKbn.NONE.eq(pKykKihon.getTikiktbrisyuruikbn())) {

            hrhnTtdkKan.setHrkkaisuutkiktbrisyu(pKykKihon.getHrkkaisuu().getContent());
        }
        else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn())){

            hrhnTtdkKan.setHrkkaisuutkiktbrisyu("６か月定期一括払");
        }
        else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn())){

            hrhnTtdkKan.setHrkkaisuutkiktbrisyu("１２か月定期一括払");
        }

        hrhnTtdkKan.setHrkkeiro(pKykKihon.getHrkkeiro());
        hrhnTtdkKan.setHrkp(pEditHrhnKanryoTuutiParam.getHrkp());

        if (((C_TkiktbrisyuruiKbn.BLNK.eq(pKykKihon.getTikiktbrisyuruikbn())
            && C_UmuKbn.ARI.eq(pEditHrhnKanryoTuutiParam.getHrkkaisuuHnkumu()))
            || (!C_TkiktbrisyuruiKbn.BLNK.eq(pKykKihon.getTikiktbrisyuruikbn())
                && C_UmuKbn.ARI.eq(pEditHrhnKanryoTuutiParam.getTikiktbrisyuruihnkumu())))
                && C_UmuKbn.NONE.eq(pEditHrhnKanryoTuutiParam.getKaisuuhnkYoyakuUmu())) {

            hrhnTtdkKan.setKouryokuhasseiym(pEditHrhnKanryoTuutiParam.getHennyuym());
        }

        hrhnTtdkKan.setMsgarea34keta1(msgareaMongon1);
        hrhnTtdkKan.setMsgarea34keta2(msgareaMongon2);
        hrhnTtdkKan.setMsgarea34keta3(msgareaMongon3);
        hrhnTtdkKan.setMsgarea34keta4(msgareaMongon4);
        hrhnTtdkKan.setMsgarea34keta5(msgareaMongon5);
        hrhnTtdkKan.setMsgarea34keta6(msgareaMongon6);
        hrhnTtdkKan.setMsgarea34keta7(msgareaMongon7);
        hrhnTtdkKan.setHrkykkmsg34keta1(hrkykkMsg[0]);
        hrhnTtdkKan.setHrkykkmsg34keta2(hrkykkMsg[1]);
        hrhnTtdkKan.setHrkykkmsg34keta3(hrkykkMsg[2]);
        hrhnTtdkKan.setHrkykkmsg34keta4(hrkykkMsg[3]);
        hrhnTtdkKan.setHrkykkmsg34keta5(hrkykkMsg[4]);
        hrhnTtdkKan.setHrkykkmsg34keta6(hrkykkMsg[5]);
        hrhnTtdkKan.setHrkykkmsg34keta7(hrkykkMsg[6]);
        hrhnTtdkKan.setHrkykkmsg34keta8(hrkykkMsg[7]);
        hrhnTtdkKan.setHrkykkmsg34keta9(hrkykkMsg[8]);
        hrhnTtdkKan.setHrkykkmsg34keta10(hrkykkMsg[9]);
        hrhnTtdkKan.setHrkykkmsg34keta11(hrkykkMsg[10]);
        hrhnTtdkKan.setHrkykkmsg34keta12(hrkykkMsg[11]);
        hrhnTtdkKan.setHrkykkmsg34keta13(hrkykkMsg[12]);
        hrhnTtdkKan.setHrkykkmsg34keta14(hrkykkMsg[13]);
        hrhnTtdkKan.setHrkykkmsg34keta15(hrkykkMsg[14]);
        hrhnTtdkKan.setHrkykkmsg34keta16(hrkykkMsg[15]);
        hrhnTtdkKan.setHrkykkmsg34keta17(hrkykkMsg[16]);
        hrhnTtdkKan.setHrkykkmsg34keta18(hrkykkMsg[17]);
        hrhnTtdkKan.setHrkykkmsg34keta19(hrkykkMsg[18]);
        hrhnTtdkKan.setHrkykkmsg34keta20(hrkykkMsg[19]);
        hrhnTtdkKan.setHrkykkmsg34keta21(hrkykkMsg[20]);
        hrhnTtdkKan.setHrkykkmsg34keta22(hrkykkMsg[21]);
        hrhnTtdkKan.setHrkykkmsg34keta23(hrkykkMsg[22]);
        hrhnTtdkKan.setHrkykkmsg34keta24(hrkykkMsg[23]);
        hrhnTtdkKan.setHrkykkmsg34keta25(hrkykkMsg[24]);
        hrhnTtdkKan.setHrkykkmsg34keta26(hrkykkMsg[25]);
        hrhnTtdkKan.setHrkykkmsg34keta27(hrkykkMsg[26]);
        hrhnTtdkKan.setHrkykkmsg34keta28(hrkykkMsg[27]);
        hrhnTtdkKan.setHassoukbn(hassouKbn);
        hrhnTtdkKan.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        hrhnTtdkKan.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        hrhnTtdkKan.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        hrhnTtdkKan.setHonsyakaisouriyuu(honsyakaisouRiyuu);

        BizPropertyInitializer.initialize(hrhnTtdkKan);

        logger.debug("△ 手続完了（払方変更）TBL編集 終了");

        return hrhnTtdkKan;
    }

    public ReportServicesBean editBean(IT_HrhnTtdkKan pHrhnTtdkKan, BizDate pSyoriymd) {

        logger.debug("▽ 払変完了通知Bean編集 開始");

        KhHrhnKanryoTuutiBean khHrhnKanryoTuutiBean = SWAKInjector.getInstance(KhHrhnKanryoTuutiBean.class);
        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = SWAKInjector.getInstance(BzKokyakuAtesakiBean.class);

        String[] shadrKj = ViewReport.editAdrDisp(24, pHrhnTtdkKan.getShsadr1kj(), pHrhnTtdkKan.getShsadr2kj(),pHrhnTtdkKan.getShsadr3kj());

        khHrhnKanryoTuutiBean.setIrTyouhyousakuseiymd(DefaultDateFormatter.formatYMDKanji(pHrhnTtdkKan.getTyouhyouymd()));
        khHrhnKanryoTuutiBean.setIrSyono(pHrhnTtdkKan.getSyono());
        khHrhnKanryoTuutiBean.setIrKyknmkj(pHrhnTtdkKan.getKyknmkj());
        khHrhnKanryoTuutiBean.setIrHhknnmkj(pHrhnTtdkKan.getHhknnmkj());
        khHrhnKanryoTuutiBean.setIrHrkkaisuutkiktbrisyu(pHrhnTtdkKan.getHrkkaisuutkiktbrisyu());
        khHrhnKanryoTuutiBean.setIrHrkkeiro(pHrhnTtdkKan.getHrkkeiro());
        khHrhnKanryoTuutiBean.setIrHrkp(pHrhnTtdkKan.getHrkp());
        khHrhnKanryoTuutiBean.setIrKouryokuhasseiym(pHrhnTtdkKan.getKouryokuhasseiym());
        khHrhnKanryoTuutiBean.setIrKouzamaskingmsg(pHrhnTtdkKan.getKouzamaskingmsg());
        khHrhnKanryoTuutiBean.setIrMsgarea34keta1(pHrhnTtdkKan.getMsgarea34keta1());
        khHrhnKanryoTuutiBean.setIrMsgarea34keta2(pHrhnTtdkKan.getMsgarea34keta2());
        khHrhnKanryoTuutiBean.setIrMsgarea34keta3(pHrhnTtdkKan.getMsgarea34keta3());
        khHrhnKanryoTuutiBean.setIrMsgarea34keta4(pHrhnTtdkKan.getMsgarea34keta4());
        khHrhnKanryoTuutiBean.setIrMsgarea34keta5(pHrhnTtdkKan.getMsgarea34keta5());
        khHrhnKanryoTuutiBean.setIrMsgarea34keta6(pHrhnTtdkKan.getMsgarea34keta6());
        khHrhnKanryoTuutiBean.setIrMsgarea34keta7(pHrhnTtdkKan.getMsgarea34keta7());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta1(pHrhnTtdkKan.getHrkykkmsg34keta1());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta2(pHrhnTtdkKan.getHrkykkmsg34keta2());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta3(pHrhnTtdkKan.getHrkykkmsg34keta3());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta4(pHrhnTtdkKan.getHrkykkmsg34keta4());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta5(pHrhnTtdkKan.getHrkykkmsg34keta5());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta6(pHrhnTtdkKan.getHrkykkmsg34keta6());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta7(pHrhnTtdkKan.getHrkykkmsg34keta7());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta8(pHrhnTtdkKan.getHrkykkmsg34keta8());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta9(pHrhnTtdkKan.getHrkykkmsg34keta9());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta10(pHrhnTtdkKan.getHrkykkmsg34keta10());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta11(pHrhnTtdkKan.getHrkykkmsg34keta11());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta12(pHrhnTtdkKan.getHrkykkmsg34keta12());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta13(pHrhnTtdkKan.getHrkykkmsg34keta13());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta14(pHrhnTtdkKan.getHrkykkmsg34keta14());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta15(pHrhnTtdkKan.getHrkykkmsg34keta15());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta16(pHrhnTtdkKan.getHrkykkmsg34keta16());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta17(pHrhnTtdkKan.getHrkykkmsg34keta17());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta18(pHrhnTtdkKan.getHrkykkmsg34keta18());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta19(pHrhnTtdkKan.getHrkykkmsg34keta19());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta20(pHrhnTtdkKan.getHrkykkmsg34keta20());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta21(pHrhnTtdkKan.getHrkykkmsg34keta21());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta22(pHrhnTtdkKan.getHrkykkmsg34keta22());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta23(pHrhnTtdkKan.getHrkykkmsg34keta23());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta24(pHrhnTtdkKan.getHrkykkmsg34keta24());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta25(pHrhnTtdkKan.getHrkykkmsg34keta25());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta26(pHrhnTtdkKan.getHrkykkmsg34keta26());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta27(pHrhnTtdkKan.getHrkykkmsg34keta27());
        khHrhnKanryoTuutiBean.setIrHrkykkmsg34keta28(pHrhnTtdkKan.getHrkykkmsg34keta28());

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(DefaultDateFormatter.formatYMDKanji(pHrhnTtdkKan.getTyouhyouymd()));
        bzKokyakuAtesakiBean.setIrShsyno(pHrhnTtdkKan.getShskyno());
        bzKokyakuAtesakiBean.setIrShadr1kj(shadrKj[0]);
        bzKokyakuAtesakiBean.setIrShadr2kj(shadrKj[1]);
        bzKokyakuAtesakiBean.setIrShadr3kj(shadrKj[2]);
        bzKokyakuAtesakiBean.setIrShsnmkj(pHrhnTtdkKan.getShsnmkj());
        bzKokyakuAtesakiBean.setIrHknkisynm(pHrhnTtdkKan.getToiawasekaisyanmkj());
        bzKokyakuAtesakiBean.setIrToiawasesosiki(pHrhnTtdkKan.getToiawasesosikinmkj());
        bzKokyakuAtesakiBean.setIrToiawaseyno(pHrhnTtdkKan.getToiawaseyno());
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj(pHrhnTtdkKan.getToiawaseadr1kj());
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj(pHrhnTtdkKan.getToiawaseadr2kj());
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj(pHrhnTtdkKan.getToiawaseadr3kj());
        bzKokyakuAtesakiBean.setIrToiawasetelno(pHrhnTtdkKan.getToiawasetelno());

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
        ReportServicesBean reportServiceBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            C_SyoruiCdKbn.AS_HRHNKANRYOTUUTI);

        reportServiceBean.setKensakuKeys(pHrhnTtdkKan.getSyono());
        reportServiceBean.setSyoriYmd(pSyoriymd);
        reportServiceBean.addParamObjects(khHrhnKanryoTuutiBean, bzKokyakuAtesakiBean);

        logger.debug("△ 払変完了通知Bean編集 終了");

        return reportServiceBean;
    }

    private List<String> editKouzaInfo(String pBankCd, String pSitenCd, C_YokinKbn pYokinKbn, String pKouzaNo,
        String pKzmeiginmKn, String pHurikaekaisiymMongon) {

        List<String> lstHensyuuResule = Lists.newArrayList();

        BzGetBankData bankData = SWAKInjector.getInstance(BzGetBankData.class);
        BzGetBankDataBean getBankDataBean = bankData.exec(pBankCd, pSitenCd);

        lstHensyuuResule.add(getBankDataBean.getBankNmKj());
        lstHensyuuResule.add(getBankDataBean.getReportSitenNm());

        String kouzaNo = KhozenEdit.editKouzaNo(pBankCd, pKouzaNo);
        kouzaNo = ConvertUtil.toZenAll(kouzaNo, 0, 1);

        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(pBankCd)) {

            lstHensyuuResule.add(TUUTYOU_NO + "　" +  kouzaNo);
        }
        else {

            lstHensyuuResule.add(pYokinKbn.getContent(C_YokinKbn.PATTERN_TYOUHYOU) + "　" + KOUZA_NO + "　" + kouzaNo);
        }

        if (pKzmeiginmKn.length() < 19) {

            lstHensyuuResule.add(KZMEIGIN  + pKzmeiginmKn + "　" + "様");
        }
        else {

            lstHensyuuResule.add(KZMEIGIN  + pKzmeiginmKn.substring(0, 18));
            lstHensyuuResule.add("　　　　　　" + pKzmeiginmKn.substring(18) + "　" + "様");
        }

        lstHensyuuResule.add(pHurikaekaisiymMongon);

        int kousuu = lstHensyuuResule.size() - 1;

        while (kousuu < 6) {

            lstHensyuuResule.add("");

            kousuu++;
        }

        return lstHensyuuResule;
    }

    private String[] editHrkykkmsg(IT_KykKihon pKykKihon, EditHrhnKanryoTuutiParam pEditHrhnKanryoTuutiParam,
        BizDate pSyoriymd) {

        String[] hrkykkMsg = new String[28];
        List<String> hrkykkMsgList = new ArrayList<String>();
        boolean hanyouMongon = true;
        String tyuuimsg1 = "";
        String tyuuimsg2 = "";
        String yokuHurikaeymdKanji = "";
        boolean hisaigaiFlg = false;


        if (((C_UmuKbn.ARI.eq(pEditHrhnKanryoTuutiParam.getHrkkaisuuHnkumu())
            && (C_Hrkkaisuu.HALFY.eq(pKykKihon.getHrkkaisuu())
                || C_Hrkkaisuu.NEN.eq(pKykKihon.getHrkkaisuu())))
                || (C_UmuKbn.ARI.eq(pEditHrhnKanryoTuutiParam.getTikiktbrisyuruihnkumu())
                    && (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn())
                        || C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn()))))
                        && C_UmuKbn.NONE.eq(pEditHrhnKanryoTuutiParam.getKaisuuhnkYoyakuUmu())) {

            SetAnnaibi setAnnaibi = SWAKInjector.getInstance(SetAnnaibi.class);

            setAnnaibi.exec(pEditHrhnKanryoTuutiParam.getHennyuym());

            BizDate annaibi = setAnnaibi.getSeijyouAnnaibi();

            if (BizDateUtil.compareYmd(annaibi, pSyoriymd) == BizDateUtil.COMPARE_LESSER) {

                List<IT_KykSyouhn> kykSyouhnList = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

                BizDate kykymd = kykSyouhnList.get(0).getKykymd();

                C_Hrkkaisuu outoubiSettiyouHrkkaisuu = null;

                if (C_UmuKbn.ARI.eq(pEditHrhnKanryoTuutiParam.getHrkkaisuuHnkumu())) {

                    outoubiSettiyouHrkkaisuu = pKykKihon.getHrkkaisuu();
                }
                else if (C_UmuKbn.ARI.eq(pEditHrhnKanryoTuutiParam.getTikiktbrisyuruihnkumu())) {

                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn())) {

                        outoubiSettiyouHrkkaisuu = C_Hrkkaisuu.HALFY;
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn())) {

                        outoubiSettiyouHrkkaisuu = C_Hrkkaisuu.NEN;
                    }
                }

                SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

                BizDate outoubi = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, kykymd, outoubiSettiyouHrkkaisuu, pSyoriymd);

                hrkykkMsgList.add("");

                hrkykkMsgList.add(FURIKAEM_SOUI1 + FixedDateFormatter.formatYMZenkakuSeirekiKanji(outoubi)
                    + FURIKAEM_SOUI2);
            }
        }

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pKykKihon.getSyono());

        IT_Tokusin tokusin = ansyuKihon.getTokusin();

        if (tokusin != null && C_TokusinKbn.HISAIGAI.eq(tokusin.getTokusinkbn())) {

            hisaigaiFlg = true;
        }

        if (hisaigaiFlg == false && C_Hrkkeiro.KOUHURI.eq(pKykKihon.getHrkkeiro())) {

            if ((C_TkiktbrisyuruiKbn.BLNK.eq(pKykKihon.getTikiktbrisyuruikbn())
                && C_Hrkkaisuu.TUKI.eq(pKykKihon.getHrkkaisuu()))
                || C_TkiktbrisyuruiKbn.NONE.eq(pKykKihon.getTikiktbrisyuruikbn())) {

                SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

                setHurikaebi.exec(pSyoriymd);

                BizDate tyokugoAnnaibi = setHurikaebi.getTyokugoAnnaibi();

                BizDate tyokugoHurikaebi = getTyokugoHurikaebi(tyokugoAnnaibi);

                BizDateYM hanteiyouTyokugoHurikaeym = tyokugoAnnaibi.getBizDateYM();

                String tyokugoHurikaebikanji = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(tyokugoHurikaebi)
                    + HURIKAEYMD;

                String jkipJytymKanji = FixedDateFormatter.formatYMZenkakuSeirekiKanji(pEditHrhnKanryoTuutiParam
                    .getJkipJytym().getFirstDay());

                Long annaiKensuu = editHrhnKanryoTuutiDao.getAnsyuRirekiCount(pKykKihon.getSyono());
                boolean onlyKouzaHenkou = false;

                if (C_Hrkkeiro.KOUHURI.eq(pEditHrhnKanryoTuutiParam.getHrkkeiro()) &&
                    ((C_UmuKbn.NONE.eq(pEditHrhnKanryoTuutiParam.getHrkkaisuuHnkumu()) &&
                        C_UmuKbn.NONE.eq(pEditHrhnKanryoTuutiParam.getTikiktbrisyuruihnkumu())) ||
                        C_UmuKbn.ARI.eq(pEditHrhnKanryoTuutiParam.getKaisuuhnkYoyakuUmu()))) {
                    onlyKouzaHenkou = true;
                }

                if (!onlyKouzaHenkou && annaiKensuu == 0) {

                    int tyokugoHurikaekikan = hanteiyouTyokugoHurikaeym.subtractMonths(
                        pEditHrhnKanryoTuutiParam.getJkipJytym().addMonths(-1));

                    if (1 <= tyokugoHurikaekikan && tyokugoHurikaekikan <= 4) {

                        hanyouMongon = false;
                    }

                    if (!hanyouMongon) {

                        hrkykkMsgList.add("");

                        hrkykkMsgList.add(PHURIYOTEI);

                        hrkykkMsgList.add(SHIROMARU + tyokugoHurikaebikanji + TEN3 + jkipJytymKanji + KARA
                            + ConvertUtil.toZenAll(String.valueOf(tyokugoHurikaekikan), 0, 1) + MONTHS);

                        if (2 <= tyokugoHurikaekikan && tyokugoHurikaekikan <= 4) {

                            setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

                            setHurikaebi.exec(tyokugoAnnaibi.addMonths(1));

                            BizDate yokuHurikaeymd = setHurikaebi.getTyokugoHurikaebi();

                            yokuHurikaeymdKanji = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(yokuHurikaeymd)
                                + HURIKAEYMD;

                            String jyuutouymKanji = FixedDateFormatter.formatYMZenkakuSeirekiKanji(
                                pEditHrhnKanryoTuutiParam.getJkipJytym().addMonths(tyokugoHurikaekikan).getFirstDay());

                            hrkykkMsgList.add("");

                            hrkykkMsgList.add(SHIROMARU + yokuHurikaeymdKanji + TEN3 + jyuutouymKanji + MONTHS1);
                        }

                        hrkykkMsgList.add("");

                        hrkykkMsgList.add(IKOU_HURIKAEYMD1);

                        hrkykkMsgList.add(IKOU_HURIKAEYMD2);

                        if (2 <= tyokugoHurikaekikan && tyokugoHurikaekikan <= 3) {

                            if (C_Hrkkeiro.CREDIT.eq(pEditHrhnKanryoTuutiParam.getHrkkeiro())) {

                                hrkykkMsgList.add("");

                                hrkykkMsgList.add(OLD_CREDNEWKOUHMSG1);

                                hrkykkMsgList.add(OLD_CREDNEWKOUHMSG2);
                            }
                            else{

                                hrkykkMsgList.add("");

                                hrkykkMsgList.add(COMMENT1 + tyokugoHurikaebikanji);

                                hrkykkMsgList.add(COMMENT2);

                                hrkykkMsgList.add(COMMENT3);
                            }
                        }
                        else {
                            if (C_Hrkkeiro.CREDIT.eq(pEditHrhnKanryoTuutiParam.getHrkkeiro())) {

                                hrkykkMsgList.add("");

                                hrkykkMsgList.add(OLD_CREDNEWKOUHMSG1);

                                hrkykkMsgList.add(OLD_CREDNEWKOUHMSG2);
                            }
                        }
                    }
                }
                else{

                    hrkykkMsgList.add("");

                    hrkykkMsgList.add(PHURIYOTEI);

                    hrkykkMsgList.add(SHIROMARU + tyokugoHurikaebikanji + NEW_KOUZAANNAI1);

                    hrkykkMsgList.add(NEW_KOUZAANNAI2);

                    hanyouMongon = false;
                }
            }

            if (C_UmuKbn.ARI.eq(pEditHrhnKanryoTuutiParam.getKaisuuhnkYoyakuUmu())
                && C_UmuKbn.ARI.eq(pEditHrhnKanryoTuutiParam.getHrkkeiroHnkumu())) {

                tyuuimsg1 = KAISUUHNK_MIHANEI1;

                tyuuimsg2 = KAISUUHNK_MIHANEI2 + FixedDateFormatter.formatYMZenkakuSeirekiKanji(
                    pEditHrhnKanryoTuutiParam.getHennyuym().getFirstDay()) + KAISUUHNK_MIHANEI3;
            }
        }

        else if (hisaigaiFlg == false && C_Hrkkeiro.CREDIT.eq(pKykKihon.getHrkkeiro())) {

            SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);

            setCreditUriageSeikyuubi.exec(pSyoriymd);

            BizDate jikaiUrsktysytbi = setCreditUriageSeikyuubi.getJikaiUrsktysytbi();

            setCreditUriageSeikyuubi.exec(jikaiUrsktysytbi);

            BizDate yokugoUrskbi = setCreditUriageSeikyuubi.getJikaiUrskbi();

            BizDateYM hanteiyouTyokugoUrskbi = jikaiUrsktysytbi.getBizDateYM();
            String tyokugoriyouKanji = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(yokugoUrskbi) + GRIYOUYMD;
            String jkipJytymKanji = FixedDateFormatter.formatYMZenkakuSeirekiKanji(pEditHrhnKanryoTuutiParam
                .getJkipJytym().getFirstDay());

            Long annaiKensuu = editHrhnKanryoTuutiDao.getAnsyuRirekiCount(pKykKihon.getSyono());

            if (annaiKensuu == 0) {

                int tyokugoHurikaekikan = hanteiyouTyokugoUrskbi.subtractMonths(
                    pEditHrhnKanryoTuutiParam.getJkipJytym().addMonths(-1));

                if (1 <= tyokugoHurikaekikan && tyokugoHurikaekikan <= 4) {

                    hanyouMongon = false;
                }

                if (tyokugoHurikaekikan == 1) {

                    hrkykkMsgList.add("");

                    hrkykkMsgList.add(PHHRIYOTEI);

                    hrkykkMsgList.add(SHIROMARU + tyokugoriyouKanji + NI + jkipJytymKanji + KARA);

                    hrkykkMsgList.add(CRED_PHMSG);
                }
                else if (2 <= tyokugoHurikaekikan && tyokugoHurikaekikan <= 4) {

                    String henkangostr = ConvertUtil.toZenAll(String.valueOf(tyokugoHurikaekikan), 0, 1);

                    hrkykkMsgList.add("");

                    hrkykkMsgList.add(PHHRIYOTEI);

                    hrkykkMsgList.add(SHIROMARU + tyokugoriyouKanji + COLON + jkipJytymKanji + KARA + henkangostr + MONTHS);

                    setCreditUriageSeikyuubi.exec(jikaiUrsktysytbi.addMonths(1));

                    BizDate yokugetubi = setCreditUriageSeikyuubi.getJikaiUrskbi();

                    String yokugetubiKanji = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(yokugetubi) + GRIYOUYMD;

                    String jyuutouym = FixedDateFormatter.formatYMZenkakuSeirekiKanji(pEditHrhnKanryoTuutiParam
                        .getJkipJytym().addMonths(tyokugoHurikaekikan).getFirstDay());

                    hrkykkMsgList.add("");
                    hrkykkMsgList.add(SHIROMARU + yokugetubiKanji + COLON + jyuutouym + MONTHS1);
                }
                hrkykkMsgList.add("");

                hrkykkMsgList.add(IKOU_HRRIKAEYMD1);

                hrkykkMsgList.add(IKOU_HRRIKAEYMD2);
            }

            else {
                hrkykkMsgList.add("");

                hrkykkMsgList.add(PHHRIYOTEI);

                hrkykkMsgList.add(SHIROMARU + tyokugoriyouKanji + CRED_PHSTARMSG1);

                hrkykkMsgList.add(CRED_PHSTARMSG2);

                hanyouMongon = false;
            }

            hrkykkMsgList.add("");

            hrkykkMsgList.add(CRED_HURIKAEYMDCOMMENT1);

            hrkykkMsgList.add(CRED_HURIKAEYMDCOMMENT2);

            hrkykkMsgList.add(CRED_HURIKAEYMDCOMMENT3);
        }

        if (hanyouMongon) {

            hrkykkMsgList.add("");

            hrkykkMsgList.add(HANYOU_HRKYKKMSG1);

            hrkykkMsgList.add(HANYOU_HRKYKKMSG2);

            hrkykkMsgList.add(HANYOU_HRKYKKMSG3);

            hrkykkMsgList.add(HANYOU_HRKYKKMSG4);

            hrkykkMsgList.add(HANYOU_HRKYKKMSG5);

            hrkykkMsgList.add(HANYOU_HRKYKKMSG6);

            hrkykkMsgList.add(HANYOU_HRKYKKMSG7);
        }

        hrkykkMsgList.add("");

        hrkykkMsgList.add(TIKIKTBRIHRKP_COMMENT1);

        hrkykkMsgList.add(TIKIKTBRIHRKP_COMMENT2);

        hrkykkMsgList.add(TIKIKTBRIHRKP_COMMENT3);

        hrkykkMsgList.add("");

        hrkykkMsgList.add(tyuuimsg1);

        hrkykkMsgList.add(tyuuimsg2);

        int kousuu = hrkykkMsgList.size() - 1;

        do {
            hrkykkMsgList.add("");

            kousuu++;
        } while (kousuu < 28);

        hrkykkMsg = hrkykkMsgList.toArray(new String[28]);

        return hrkykkMsg;
    }

    private BizDate getTyokugoHurikaebi(BizDate pSyoriymd) {

        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

        setHurikaebi.exec(pSyoriymd);

        BizDate tyokugoHurikaebi = setHurikaebi.getTyokugoHurikaebi();

        return tyokugoHurikaebi;
    }
}

package yuyu.app.hozen.khozen.khsyouraikaiyakuhenreikin;

import static yuyu.app.hozen.khozen.khsyouraikaiyakuhenreikin.GenKhSyouraiKaiyakuhenreikinConstants.*;
import static yuyu.app.hozen.khozen.khsyouraikaiyakuhenreikin.KhSyouraiKaiyakuhenreikinConstants.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import net.arnx.jsonic.JSON;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.KeisanSP;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkKykTmttkn;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttkn;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SelHokensyuruiKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.bean.report.KhSyouraiwSisanhyouBean;
import yuyu.def.hozen.bean.report.KhSyouraiwSisanhyouDataSourceBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;

/**
 * 将来解約返戻金照会 のビジネスロジックです。
 */
public class KhSyouraiKaiyakuhenreikinBizLogic {

    @Inject
    private KhSyouraiKaiyakuhenreikinUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private CreateReport createReport;

    @Inject
    private OutputReport outputReport;

    @Inject
    private AS_Kinou asKinou;

    void init() {
        BizPropertyInitializer.initialize(uiBean);
    }

    void clear() {

        uiBean.setSrchsyono(null);

        uiBean.setSrchkykymd(null);

        uiBean.setSrchsknnkaisiymd(null);

        uiBean.setSrchkanyuujinen(null);

        uiBean.setSrchsei(null);

        uiBean.setSrchhknsyrui(null);

        uiBean.setSrchsiteituuka(null);

        uiBean.setSrchhknkkn(null);

        uiBean.setSrchhrkkkn(null);

        uiBean.setSrchkihons(null);

        uiBean.setSrchp(null);

        uiBean.setSyusyouhncd(null);

        uiBean.setSrchyendthnkymd(null);

        uiBean.setSrchsisuurendourate(null);

        uiBean.setSrchtmttknitenymd(null);

        uiBean.setSyono(null);

        uiBean.setKykymd(null);

        uiBean.setSknnkaisiymd(null);

        uiBean.setHhknnen(null);

        uiBean.setHhknsei(null);

        uiBean.setSiteituuka(null);

        uiBean.setSyouhnnm(null);

        uiBean.setHknkkn(null);

        uiBean.setHrkkkn(null);

        uiBean.setKihons(null);

        uiBean.setKwsratekjymd(null);

        uiBean.setYendthnkymd(null);

        uiBean.setHokenryou(null);

        uiBean.setTumitateRiritu(null);

        uiBean.setSisuurendourate(null);

        uiBean.setItijibrumu(null);

        uiBean.setSyuusinhknumu(null);

        uiBean.setHeijyunbaraiumu(null);

        uiBean.setTmttknitenymd(null);
    }

    @Transactional
    void pushSearchBySyonoBL() {

        String syono = uiBean.getSrchsyono();

        if (BizUtil.isBlank(syono)) {
            throw new BizLogicException(MessageId.EBC0043, MessageUtil.getMessage(DDID_SYOUKAICONDITIONS1_SRCHSYONO
                .getErrorResourceKey()));
        }

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSrchsyono());

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        int henkouKubetuSyohinHanteiKbn = SyouhinUtil.henkouKubetuHantei(syouhnZokusei.getSyouhncd());

        getKeiyakuInfo(kykKihon, kykSyouhn, syouhnZokusei);

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getItijibrumu()) &&
            C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {

            if (C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhn.getYuukousyoumetukbn())) {
                throw new BizLogicException(MessageId.EIF1116);
            }
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        C_YuukoujyotaichkKbn yuukouJyotaiChkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

        if (yuukouJyotaiChkKbn.eq(C_YuukoujyotaichkKbn.HUKA)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }
        else if (yuukouJyotaiChkKbn.eq(C_YuukoujyotaichkKbn.TYUUITRATKIKA)) {
            for (int i = 0; i < checkYuukouJyoutai.getWarningMessageIDList().size(); i++) {
                messageManager.addMessageId(checkYuukouJyoutai.getWarningMessageIDList().get(i),
                    checkYuukouJyoutai.getWarningMessageList().get(i));
            }

        }

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syoriKahiKbn = hanteiTetuduki.exec(khozenCommonParam, syono);

        if (syoriKahiKbn.eq(C_SyorikahiKbn.SYORIHUKA)) {
            throw new BizLogicException(MessageId.EIA1006, hanteiTetuduki.getMessageParam());
        }
        else if (syoriKahiKbn.eq(C_SyorikahiKbn.TYUUITRATKIKA)) {
            messageManager.addMessageId(hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }

        BizDateYM maxTmttkntaisyouym = BizDateYM.valueOf(MAX_INT_VALUE_TMTTKNTAISYOUYM);
        IT_HokenryouTmttkn hokenryouTmttkn = hozenDomManager.getHokenryouTmttknBySyonoTmttkntaisyouym(uiBean.getSrchsyono(),maxTmttkntaisyouym);

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        if (hokenryouTmttkn != null) {
            uiBean.setTmttkntaisyouymkingk(hokenryouTmttkn.getTmttkntaisyouym());
            uiBean.setPtmttkngk(hokenryouTmttkn.getPtmttkngk());
            uiBean.setKihrkmpstgk(hokenryouTmttkn.getKihrkmpstgk());
        }
        else {
            uiBean.setTmttkntaisyouymkingk(null);
            uiBean.setPtmttkngk(BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(uiBean.getSiteituuka())));
            uiBean.setKihrkmpstgk(BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(uiBean.getSiteituuka())));
        }

        if (SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUMAE == henkouKubetuSyohinHanteiKbn ||
            SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_YENHENKOUMAE == henkouKubetuSyohinHanteiKbn) {

            BizDate hanteiKhSsrndTmttknJytKjynYmd = BizDate.getSysDate();

            if (BizDateUtil.compareYmd(uiBean.getKykymd(), hanteiKhSsrndTmttknJytKjynYmd) == BizDateUtil.COMPARE_GREATER) {

                hanteiKhSsrndTmttknJytKjynYmd = uiBean.getKykymd();
            }

            HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai = SWAKInjector
                .getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

            HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);
            hanteiTmttknJyoutaiBean.setSyono(uiBean.getSyono());
            hanteiTmttknJyoutaiBean.setHanteiKijyunymd(hanteiKhSsrndTmttknJytKjynYmd);
            hanteiTmttknJyoutaiBean.setKykymd(uiBean.getKykymd());

            Boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

            if (!result) {
                throw new BizLogicException(MessageId.EIF1117);
            }
        }

        getListInfo(syouhnZokusei);

        setWarning();
    }

    @Transactional
    void pushSearchByInputBL() {

        BizDate srchKykymd = uiBean.getSrchkykymd();

        BizDate srchSknnKaisiymd = uiBean.getSrchsknnkaisiymd();

        Integer srchKanyuujinen = uiBean.getSrchkanyuujinen();

        C_Seibetu srchSei = uiBean.getSrchsei();

        C_SelHokensyuruiKbn srchHknsyrui = uiBean.getSrchhknsyrui();

        C_Tuukasyu srchsiteituuka = uiBean.getSrchsiteituuka();

        BizCurrency srchKihons = uiBean.getSrchkihons();

        Integer srchHknkkn = uiBean.getSrchhknkkn();

        BizNumber srchSisuuRendouRate = uiBean.getSrchsisuurendourate();

        BizDate srchYendthnkymd = uiBean.getSrchyendthnkymd();

        BizCurrency srchp = uiBean.getSrchp();

        Integer srchhrkkkn = uiBean.getSrchhrkkkn();

        BizDate srchtmttknitenymd = uiBean.getSrchtmttknitenymd();

        int phrkkkn = 0;

        if (srchKykymd == null) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHKYKYMD.getErrorResourceKey()));
        }
        else if (srchKanyuujinen == null) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHKANYUUJINEN.getErrorResourceKey()));
        }
        else if (C_Seibetu.BLNK.eq(srchSei)) {
            throw new BizLogicException(MessageId.EBC0043, MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHSEI
                .getErrorResourceKey()));
        }
        else if (C_SelHokensyuruiKbn.BLNK.eq(srchHknsyrui)) {
            throw new BizLogicException(MessageId.EBC0043, MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHHKNSYRUI
                .getErrorResourceKey()));
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(srchHknsyrui.getValue());

        uiBean.setSyohinHanteiKbn(syohinHanteiKbn);

        boolean yendthnkUmuFlag = false;

        if (C_SelHokensyuruiKbn.NENKIN_KAKUTEI_YENDTHNK5Y.eq(srchHknsyrui) ||
            C_SelHokensyuruiKbn.NENKIN_KAKUTEI_YENDTHNK10Y.eq(srchHknsyrui) ||
            C_SelHokensyuruiKbn.NENKIN_KAKUTEI_YENDTHNK15Y.eq(srchHknsyrui) ||
            C_SelHokensyuruiKbn.NENKIN_SGKHOSYOUTUKISYSN_YENDTHNK.eq(srchHknsyrui) ||
            C_SelHokensyuruiKbn.SYSN_YENDTHNK.eq(srchHknsyrui) ||
            C_SelHokensyuruiKbn.SYSN2_YENDTHNK2Y .eq(srchHknsyrui)) {
            yendthnkUmuFlag = true;
        }

        if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN != uiBean.getSyohinHanteiKbn()) {
            if (!C_Tuukasyu.BLNK.eq(srchsiteituuka)) {
                throw new BizLogicException(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHSITEITUUKA.getErrorResourceKey()));
            }
        }

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN != uiBean.getSyohinHanteiKbn()
            && SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN != uiBean.getSyohinHanteiKbn()) {
            if (srchhrkkkn != null) {
                throw new BizLogicException(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHHRKKKN.getErrorResourceKey()));
            }
        }

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN != uiBean.getSyohinHanteiKbn()) {
            if (srchKihons.isOptional()) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHKIHONS.getErrorResourceKey()));
            }

            if (!srchp.isOptional()) {
                throw new BizLogicException(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHP.getErrorResourceKey()));
            }
        }

        if ((SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR != uiBean.getSyohinHanteiKbn() &&
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 != uiBean.getSyohinHanteiKbn()) ||
            yendthnkUmuFlag) {
            if (!srchSisuuRendouRate.isOptional()) {
                throw new BizLogicException(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHSISUURENDOURATE.getErrorResourceKey()));
            }
        }

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn() ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyohinHanteiKbn()) {
            if (srchSknnKaisiymd == null) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHSKNNKAISIYMD.getErrorResourceKey()));
            }

            if (srchHknkkn == null) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHHKNKKN.getErrorResourceKey()));
            }

            if (!yendthnkUmuFlag) {

                if (srchSisuuRendouRate.isOptional()) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHSISUURENDOURATE.getErrorResourceKey()));
                }
            }

            BizDate yokugetuymd = srchSknnKaisiymd.addMonths(1).getBizDateYM().getFirstDay();

            if (srchSknnKaisiymd.getDay() <= 15 && BizDateUtil.compareYmd(srchKykymd,yokugetuymd) != BizDateUtil.COMPARE_EQUAL) {
                throw new BizLogicException(MessageId.EIA1024,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHKYKYMD.getErrorResourceKey()),
                    "責任開始日の翌月１日");
            }

            yokugetuymd = BizDate.valueOf(srchSknnKaisiymd.addMonths(1).getBizDateYM().toString() + "16");

            if (srchSknnKaisiymd.getDay() > 15 && BizDateUtil.compareYmd(srchKykymd,yokugetuymd) != BizDateUtil.COMPARE_EQUAL) {
                throw new BizLogicException(MessageId.EIA1024,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHKYKYMD.getErrorResourceKey()),
                    "責任開始日の翌月１６日");
            }

            if (srchHknkkn != 5 && srchHknkkn != 10) {
                throw new BizLogicException(MessageId.EBA0023,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHHKNKKN.getErrorResourceKey()));
            }
        }

        if (yendthnkUmuFlag) {
            if (srchYendthnkymd == null) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHYENDTHNKYMD.getErrorResourceKey()));
            }

            BizDate kykymditinengooutouymd = BizDateUtil.getDateAfterPeriod(srchKykymd, 1, 0);

            if (BizDateUtil.compareYmd(srchYendthnkymd, kykymditinengooutouymd) == BizDateUtil.COMPARE_LESSER) {
                throw new BizLogicException(MessageId.EIA1024,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHYENDTHNKYMD.getErrorResourceKey()),
                    "契約日１年後より先日付");
            }
        }

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn() &&
            !yendthnkUmuFlag) {

            if (srchtmttknitenymd != null) {

                if (!BizNumber.ZERO.equals(srchSisuuRendouRate)) {

                    throw new BizLogicException(MessageId.EIA1054,
                        MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHTMTTKNITENYMD.getErrorResourceKey()),
                        MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHSISUURENDOURATE.getErrorResourceKey()));
                }

                if (srchtmttknitenymd.getMonth() != srchKykymd.getMonth() ||
                    srchtmttknitenymd.getDay() != srchKykymd.getDay()) {

                    throw new BizLogicException(MessageId.EIA1024,
                        MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHTMTTKNITENYMD.getErrorResourceKey()),
                        "年単位の契約応当日");
                }
            }
        }

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinHanteiKbn()) {
            if (srchSknnKaisiymd == null) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHSKNNKAISIYMD.getErrorResourceKey()));
            }

            if (srchHknkkn == null) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHHKNKKN.getErrorResourceKey()));
            }

            if (srchhrkkkn == null) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHHRKKKN.getErrorResourceKey()));
            }

            if (srchp.isOptional()) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHP.getErrorResourceKey()));
            }

            BizDate yokugetuymd = srchSknnKaisiymd.addMonths(1).getBizDateYM().getFirstDay();

            if (BizDateUtil.compareYmd(srchKykymd, yokugetuymd) != BizDateUtil.COMPARE_EQUAL) {
                throw new BizLogicException(MessageId.EIA1024,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHKYKYMD.getErrorResourceKey()),
                    "責任開始日の翌月１日");
            }

            if (srchKanyuujinen > 75) {
                throw new BizLogicException(MessageId.EBA0023,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHKANYUUJINEN.getErrorResourceKey()));
            }

            if (srchhrkkkn < 10 || srchhrkkkn > 85) {
                throw new BizLogicException(MessageId.EBA0023,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHHRKKKN.getErrorResourceKey()));
            }

            if (srchKanyuujinen > srchhrkkkn) {
                throw new BizLogicException(MessageId.EIA1038,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHKANYUUJINEN.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHHRKKKN.getErrorResourceKey()));
            }

            phrkkkn = srchhrkkkn - srchKanyuujinen;

            if (phrkkkn < 10 || phrkkkn > 50) {
                throw new BizLogicException(MessageId.EIA1039,"保険料払込期間",
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHKANYUUJINEN.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHHRKKKN.getErrorResourceKey()));
            }

            if (srchHknkkn < 10 || srchHknkkn > 85) {
                throw new BizLogicException(MessageId.EBA0023,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHHKNKKN.getErrorResourceKey()));
            }

            if (srchhrkkkn > srchHknkkn) {
                throw new BizLogicException(MessageId.EIA1038,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHHRKKKN.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHHKNKKN.getErrorResourceKey()));
            }

            if ((srchHknkkn - srchhrkkkn) > 15) {
                throw new BizLogicException(MessageId.EIA1039,"据置期間",
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHHKNKKN.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHHRKKKN.getErrorResourceKey()));
            }

            if (!srchKihons.isOptional()) {
                throw new BizLogicException(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHKIHONS.getErrorResourceKey()));
            }
        }

        if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyohinHanteiKbn()) {
            if (C_Tuukasyu.BLNK.eq(srchsiteituuka)) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHSITEITUUKA.getErrorResourceKey()));
            }
            if (srchhrkkkn == null) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHHRKKKN.getErrorResourceKey()));
            }
            if (!C_Tuukasyu.JPY.eq(srchsiteituuka) && !C_Tuukasyu.USD.eq(srchsiteituuka)) {
                throw new BizLogicException(MessageId.EBA0023,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHSITEITUUKA.getErrorResourceKey()));
            }
        }

        if (!yendthnkUmuFlag) {
            if (srchYendthnkymd != null) {
                throw new BizLogicException(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHYENDTHNKYMD.getErrorResourceKey()));
            }
        }

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR != uiBean.getSyohinHanteiKbn() ||
            yendthnkUmuFlag) {
            if (srchtmttknitenymd != null) {
                throw new BizLogicException(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHTMTTKNITENYMD.getErrorResourceKey()));
            }
        }

        uiBean.setKykymd(srchKykymd);
        uiBean.setSknnkaisiymd(srchSknnKaisiymd);
        uiBean.setHhknnen(srchKanyuujinen);
        uiBean.setHhknsei(C_Hhknsei.valueOf(srchSei.getValue()));
        uiBean.setSyusyouhncd(srchHknsyrui.getValue());
        uiBean.setKihons(srchKihons);
        uiBean.setSrchsyono(null);
        uiBean.setYendthnkymd(srchYendthnkymd);
        uiBean.setTmttknitenymd(srchtmttknitenymd);

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinHanteiKbn()
            || SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyohinHanteiKbn()) {
            uiBean.setHrkkkn(srchhrkkkn);
        } else {
            uiBean.setHrkkkn(0);
        }

        if (srchYendthnkymd != null) {
            uiBean.setKouryokuhasseiymd(srchYendthnkymd);
        }
        else {
            uiBean.setKouryokuhasseiymd(srchtmttknitenymd);
        }

        if (!srchSisuuRendouRate.isOptional()) {
            uiBean.setSisuurendourate(srchSisuuRendouRate);
        }
        else {
            uiBean.setSisuurendourate(BizNumber.ZERO);
        }

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinHanteiKbn()) {
            uiBean.setPharaikomisougaku(uiBean.getSrchp().multiply(12).multiply(phrkkkn));
        }
        else {
            uiBean.setPharaikomisougaku(BizCurrency.valueOf(0));
        }

        BizDate kykYmd = null;

        if (uiBean.getSrchyendthnkymd() != null) {
            kykYmd = uiBean.getYendthnkymd();
        }
        else {
            kykYmd = uiBean.getSrchkykymd();
        }

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyouhncdKykfromymdKyktoymd(
            uiBean.getSyusyouhncd(), kykYmd);

        if (syouhnZokuseiLst.size() == 0) {

            throw new BizLogicException(MessageId.EIA0167);
        }

        BM_SyouhnZokusei syouhnZokusei = syouhnZokuseiLst.get(0);

        getSearchByInputInfo(syouhnZokusei, kykYmd, yendthnkUmuFlag);

        getListInfo(syouhnZokusei);
        setWarning();
    }

    void pushBackBL() {

        init_gotoInputKey();
    }

    @SuppressWarnings("resource")
    void  callAjaxCommonBL() throws IOException {

        HttpServletRequest request = SWAKInjector.getInstance(HttpServletRequest.class);
        HttpServletResponse response = SWAKInjector.getInstance(HttpServletResponse.class);

        List<String> outStrLst = Lists.newArrayList();

        String syouhnCd = request.getParameter(AJAX_POST_PARAM_SYOUHNCD);

        String siteiTuuka = request.getParameter(AJAX_POST_PARAM_SITEITUUKA);

        outStrLst = ajaxSyouhnChange(syouhnCd, C_Tuukasyu.valueOf(siteiTuuka));

        String responseJson = JSON.encode(outStrLst);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println(responseJson);
        out.close();
    }

    void printOut() {
        outputReport.outputPDFByJoinKey(uiBean.getTyouhyoukey());
    }


    private void getKeiyakuInfo(IT_KykKihon pKykKihon, IT_KykSyouhn pKykSyouhn, BM_SyouhnZokusei pSyouhnZokusei) {

        uiBean.setSyono(uiBean.getSrchsyono());
        uiBean.setKykymd(pKykSyouhn.getKykymd());
        uiBean.setSknnkaisiymd(pKykSyouhn.getSknnkaisiymd());
        uiBean.setSyusyouhncd(pKykSyouhn.getSyouhncd());
        uiBean.setHhknnen(pKykSyouhn.getHhknnen());
        uiBean.setHhknsei(pKykSyouhn.getHhknsei());
        uiBean.setSiteituuka(pKykSyouhn.getKyktuukasyu());
        uiBean.setKihons(pKykSyouhn.getKihons());
        uiBean.setHokenryou(pKykSyouhn.getHokenryou());
        uiBean.setSyouhnnm(pSyouhnZokusei.getSyouhnnm());
        uiBean.setSyouhnsdno(pKykSyouhn.getSyouhnsdno());
        uiBean.setRyouritusdno(pKykSyouhn.getRyouritusdno());
        uiBean.setYoteiriritu(pKykSyouhn.getYoteiriritu());
        uiBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
        uiBean.setHknkknsmnkbn(pKykSyouhn.getHknkknsmnkbn());
        uiBean.setHknkkn(pKykSyouhn.getHknkkn());
        uiBean.setHrkkknsmnKbn(pKykSyouhn.getHrkkknsmnkbn());
        uiBean.setHrkkkn(pKykSyouhn.getHrkkkn());
        uiBean.setKouryokuhasseiymd(pKykSyouhn.getKouryokuhasseiymd());
        uiBean.setKyksjkkktyouseiriritu(pKykSyouhn.getKyksjkkktyouseiriritu());
        uiBean.setYendthnkymd(pKykSyouhn.getYendthnkymd());
        uiBean.setTumitateRiritu(pKykSyouhn.getTumitateriritu());
        uiBean.setKykjyoutai(pKykSyouhn.getKykjyoutai());
        uiBean.setYoteirrthendohosyurrt(pKykSyouhn.getYoteirrthendohosyurrt());
        uiBean.setItijibrumu(pSyouhnZokusei.getItijibrumu());
        uiBean.setSyuusinhknumu(pSyouhnZokusei.getSyuusinhknumu());
        uiBean.setHeijyunbaraiumu(pSyouhnZokusei.getHeijyunbaraiumu());
        uiBean.setFstprsymd(pKykKihon.getFstpnyknymd());
        uiBean.setTmttknitenymd(pKykSyouhn.getTmttknitenymd());
        uiBean.setPharaikomisougaku(pKykSyouhn.getPharaikomisougaku());
        uiBean.setDai1hknkkn(pKykSyouhn.getDai1hknkkn());

        if (pKykSyouhn.getTmttknitenymd() == null) {
            uiBean.setSisuurendourate(pKykSyouhn.getKykjisisuurendourate());
        }
        else {
            uiBean.setSisuurendourate(BizNumber.ZERO);
        }
    }

    private void getListInfo(BM_SyouhnZokusei pSyouhnZokusei) {

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokusei.getSyouhncd());

        uiBean.setKwsratekjymd(null);
        uiBean.setWarnFlag(true);
        uiBean.setSyohinHanteiKbn(syohinHanteiKbn);

        BizDate sisanyouSyoriYmd = BizDate.getSysDate();
        BizNumber sisanyouKawaseRate = BizNumber.valueOf(0);

        if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) {
            if (BizDateUtil.compareYmd(uiBean.getKykymd(), sisanyouSyoriYmd) == BizDateUtil.COMPARE_GREATER) {
                sisanyouSyoriYmd = uiBean.getKykymd();
            }

            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinHanteiKbn()) {
                GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                C_ErrorKbn kekkaKbn = C_ErrorKbn.ERROR;

                kekkaKbn = getKawaseRate.exec(
                    BizDate.getSysDate(),
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    uiBean.getSiteituuka(),
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                    C_YouhiKbn.YOU);

                if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                    throw new BizLogicException(MessageId.EIA0167);
                }

                sisanyouKawaseRate = getKawaseRate.getKawaserate();
            }
        }

        int henreikin = 0;

        if (C_UmuKbn.ARI.eq(uiBean.getSyuusinhknumu())) {
            henreikin = 100 - uiBean.getHhknnen();
        }
        else {
            if (C_HknkknsmnKbn.SAIMANKI.eq(uiBean.getHknkknsmnkbn())) {
                henreikin = uiBean.getHknkkn() - uiBean.getHhknnen();
            }
            else {
                henreikin = uiBean.getHknkkn();
            }
        }

        Boolean sjkkkTyouseiyouRirituUmuFlag = false;

        if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getMvatekiumu())) {
            sjkkkTyouseiyouRirituUmuFlag = true;
        }
        else {
            sjkkkTyouseiyouRirituUmuFlag = false;
        }

        boolean sisuurendoutmttRrkUmuFlg = true;

        if (BizUtil.isBlank(uiBean.getSyono())) {
            sisuurendoutmttRrkUmuFlg = false;
        }
        else {
            sisuurendoutmttRrkUmuFlg = true;
        }

        List<List<BizCurrency>> kaiyakuhrGaikaLst = new ArrayList<List<BizCurrency>>();
        List<List<BizCurrency>> kaiyakuhrYenLst = new ArrayList<List<BizCurrency>>();
        List<List<BizNumber>> kawaseRateLst = new ArrayList<List<BizNumber>>();
        List<List<BizCurrency>> ptmttkngkLst = new ArrayList<List<BizCurrency>>();
        List<List<BizCurrency>>kihrkmpstgkLst = new ArrayList<List<BizCurrency>>();

        BizDate calckijyunYmd = null;
        BizDate keiyakuoutoubi = null;
        BizDate calckijyunYmdgetu = null;
        BizDateYM calckijyuYm = null;
        BizDate kaiyakuhryenhkYmd = null;
        BizDate keiyakuYmd = uiBean.getKykymd();
        BizNumber kaiykSjkkkTyouseiyouRiritu = BizNumber.valueOf(0);
        BizDateYM tmttknTaisyouYM = null;
        BizCurrency teirituTmttkngk = BizCurrency.optional();
        BizCurrency sisuurendouTmttkngk = BizCurrency.optional();
        BizNumber tmttknhaneisisuu = BizNumber.valueOf(0);
        BizCurrency teirituTmttknGKOutou = BizCurrency.optional();
        BizCurrency sisuuRendouTmttknGKOutou = BizCurrency.optional();
        BizNumber tmttknhaneisisuuOutou = BizNumber.valueOf(0);
        BizDateYM tmttknTaisyouYMOutou = null;
        BizDateYM tmttknTaisyouYMZennen = null;
        BizCurrency sisuurendouTmttkngkKyk = BizCurrency.optional();
        BizCurrency teirituTmttkngkKyk = BizCurrency.optional();
        BizDate tysytkijyunYmd = null;
        BizDateYM tmttkntaisyouymkingk = uiBean.getTmttkntaisyouymkingk();
        BizCurrency ptmttkngk = uiBean.getPtmttkngk();
        BizCurrency kihrkmpstgk = uiBean.getKihrkmpstgk();
        boolean calcTaisyouflg = false;
        BizCurrency kijyungk = null;
        BizCurrency nennkinnGenshi = BizCurrency.optional();

        for (int cnt = 0; cnt < henreikin; cnt++) {

            if (cnt == 0) {
                keiyakuoutoubi = keiyakuYmd;
            }
            else {
                SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

                keiyakuoutoubi = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, keiyakuYmd, C_Hrkkaisuu.NEN,
                    keiyakuoutoubi);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) {
                calckijyunYmd = keiyakuoutoubi.addMonths(1).getRekijyou();
            }
            else {
                calckijyunYmd = keiyakuoutoubi;
            }

            List<BizCurrency> kaiyakuhrGaika = new ArrayList<>();
            List<BizCurrency> kaiyakuhrYen = new ArrayList<>();
            List<BizNumber> kawaseRate = new ArrayList<>();
            List<BizCurrency> ptmttkngkArrayLst = new ArrayList<>();
            List<BizCurrency> kihrkmpstgkArrayLst = new ArrayList<>();

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            if ((SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn() ||
                SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyohinHanteiKbn()) &&
                !C_Tuukasyu.JPY.eq(uiBean.getSiteituuka())) {
                if (sisuurendoutmttRrkUmuFlg) {
                    SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
                    tysytkijyunYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, keiyakuYmd, C_Hrkkaisuu.NEN, calckijyunYmd);
                    tysytkijyunYmd = tysytkijyunYmd.addDays(-1);

                    SisurendoTmttknInfoBean sisurendoTmttknInfoBean = hozenDomManager.getSisurendoTmttknInfoBean(uiBean.getSrchsyono(), tysytkijyunYmd);

                    if (sisurendoTmttknInfoBean == null || sisurendoTmttknInfoBean.getTmttknTaisyouYM().equals(tmttknTaisyouYMZennen)) {
                        sisuurendoutmttRrkUmuFlg = false;

                    }
                    else {
                        teirituTmttknGKOutou = sisurendoTmttknInfoBean.getTeirituTmttknGK();
                        sisuuRendouTmttknGKOutou = sisurendoTmttknInfoBean.getSisuuRendouTmttknGK();
                        tmttknhaneisisuuOutou = sisurendoTmttknInfoBean.getTmttknhaneisisuu();
                        tmttknTaisyouYMOutou = sisurendoTmttknInfoBean.getTmttknTaisyouYM();
                        tmttknTaisyouYMZennen = tmttknTaisyouYMOutou;
                    }
                }
                else if (cnt == 0) {
                    KeisanSisuuRendouNkKykTmttkn keisanSisuuRendouNkKykTmttkn = SWAKInjector.getInstance(KeisanSisuuRendouNkKykTmttkn.class);

                    keisanSisuuRendouNkKykTmttkn.exec(uiBean.getSiteituuka(), uiBean.getHokenryou(), uiBean.getSisuurendourate());

                    sisuurendouTmttkngkKyk = keisanSisuuRendouNkKykTmttkn.getSisuurendoutmttkngk();
                    teirituTmttkngkKyk = keisanSisuuRendouNkKykTmttkn.getTeiritutmttkngk();
                }
            }

            for (int month = 0; month <= 11; month++) {

                if (month == 0) {
                    calckijyuYm = calckijyunYmd.getBizDateYM();
                    calckijyunYmdgetu = calckijyunYmd;

                    if ((SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn() ||
                        SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyohinHanteiKbn()) &&
                        !C_Tuukasyu.JPY.eq(uiBean.getSiteituuka())) {
                        if (sisuurendoutmttRrkUmuFlg) {
                            tmttknTaisyouYM = tmttknTaisyouYMOutou;
                            teirituTmttkngk = teirituTmttknGKOutou;
                            sisuurendouTmttkngk = sisuuRendouTmttknGKOutou;
                            tmttknhaneisisuu = tmttknhaneisisuuOutou;
                        }
                        else if (cnt == 0 || BizDateUtil.compareYmd(uiBean.getKouryokuhasseiymd(), calckijyunYmd) == BizDateUtil.COMPARE_EQUAL) {
                            tmttknTaisyouYM = calckijyunYmd.getBizDateYM();
                            teirituTmttkngk = teirituTmttkngkKyk;
                            sisuurendouTmttkngk = sisuurendouTmttkngkKyk;
                        }
                        else if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getTeikisiharaikinumu())) {
                            tmttknTaisyouYM = calckijyunYmd.getBizDateYM();
                            teirituTmttkngk = uiBean.getKihons();
                            sisuurendouTmttkngk = BizCurrency.valueOf(0);
                        }
                        else {
                            KeisanSisuuRendouNkTmttkn keisanSisuuRendouNkTmttkn = SWAKInjector.getInstance(KeisanSisuuRendouNkTmttkn.class);
                            C_ErrorKbn kekkaKbn = keisanSisuuRendouNkTmttkn.exec(
                                keiyakuYmd,
                                henreikin,
                                C_UmuKbn.NONE,
                                uiBean.getSiteituuka(),
                                calckijyunYmd,
                                calckijyunYmd.getBizDateYM(),
                                tmttknTaisyouYM,
                                uiBean.getTumitateRiritu(),
                                teirituTmttkngk,
                                sisuurendouTmttkngk);

                            if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                                throw new BizLogicException(MessageId.EIA0167);
                            }

                            teirituTmttkngk = keisanSisuuRendouNkTmttkn.getTeiritutmttkngk();
                            sisuurendouTmttkngk = keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk();
                            tmttknTaisyouYM = calckijyunYmd.getBizDateYM();
                        }
                    }
                }
                else {
                    calckijyuYm = calckijyuYm.addMonths(1);
                    calckijyunYmdgetu = BizDate.valueOf(calckijyuYm, keiyakuYmd.getDay()).getRekijyou();
                }

                if (BizDateUtil.compareYmd(BizDate.getSysDate(), calckijyunYmdgetu) == BizDateUtil.COMPARE_GREATER) {

                    kaiyakuhryenhkYmd = calckijyunYmdgetu;

                    uiBean.setWarnFlag(false);
                }
                else {

                    kaiyakuhryenhkYmd = BizDate.getSysDate();

                    uiBean.setWarnFlag(true);
                }

                if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) {
                    tmttknTaisyouYM = calckijyuYm.addMonths(-1);
                }

                if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getMvatekiumu())) {
                    if (sjkkkTyouseiyouRirituUmuFlag) {

                        GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
                        GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);

                        getSjkkktyouseiyourirituBean.setSyouhncd(uiBean.getSyusyouhncd());
                        getSjkkktyouseiyourirituBean.setKijyunymd(calckijyunYmdgetu);
                        getSjkkktyouseiyourirituBean.setHknkkn(uiBean.getHknkkn());
                        getSjkkktyouseiyourirituBean.setHknkknsmnkbn(C_HknkknsmnKbn.BLNK);
                        getSjkkktyouseiyourirituBean.setHhknnen(0);

                        C_ErrorKbn kekkaKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

                        if (C_ErrorKbn.OK.eq(kekkaKbn)) {
                            kaiykSjkkkTyouseiyouRiritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
                        }
                        else {
                            sjkkkTyouseiyouRirituUmuFlag = false;

                            getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);

                            getSjkkktyouseiyourirituBean = SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);

                            getSjkkktyouseiyourirituBean.setSyouhncd(uiBean.getSyusyouhncd());
                            getSjkkktyouseiyourirituBean.setKijyunymd(calckijyunYmdgetu);
                            getSjkkktyouseiyourirituBean.setHknkkn(uiBean.getHknkkn());
                            getSjkkktyouseiyourirituBean.setHknkknsmnkbn(C_HknkknsmnKbn.BLNK);
                            getSjkkktyouseiyourirituBean.setHhknnen(0);

                            getSjkkktyouseiyouriritu.execMaxkjnymd(getSjkkktyouseiyourirituBean);

                            kaiykSjkkkTyouseiyouRiritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
                        }

                    }
                    else {
                        GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
                        GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);

                        getSjkkktyouseiyourirituBean.setSyouhncd(uiBean.getSyusyouhncd());
                        getSjkkktyouseiyourirituBean.setKijyunymd(calckijyunYmdgetu);
                        getSjkkktyouseiyourirituBean.setHknkkn(uiBean.getHknkkn());
                        getSjkkktyouseiyourirituBean.setHknkknsmnkbn(C_HknkknsmnKbn.BLNK);
                        getSjkkktyouseiyourirituBean.setHhknnen(0);

                        getSjkkktyouseiyouriritu.execMaxkjnymd(getSjkkktyouseiyourirituBean);

                        kaiykSjkkkTyouseiyouRiritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
                    }
                }

                if (calcTaisyouflg == false) {
                    if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinHanteiKbn()) {
                        if (BizDateUtil.compareYm(tmttkntaisyouymkingk, calckijyuYm) == BizDateUtil.COMPARE_LESSER) {
                            calcTaisyouflg = true;
                            tmttknTaisyouYM = tmttkntaisyouymkingk;
                        }
                    }
                    else {
                        if (BizDateUtil.compareYmd(uiBean.getKouryokuhasseiymd(), calckijyunYmdgetu) == BizDateUtil.COMPARE_LESSER ||
                            BizDateUtil.compareYmd(uiBean.getKouryokuhasseiymd(), calckijyunYmdgetu) == BizDateUtil.COMPARE_EQUAL) {
                            calcTaisyouflg = true;
                        }
                    }
                }

                if (calcTaisyouflg == false) {
                    kaiyakuhrGaika.add(BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(uiBean.getSiteituuka())));
                    kaiyakuhrYen.add(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    ptmttkngkArrayLst.add(BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(uiBean.getSiteituuka())));
                    kihrkmpstgkArrayLst.add(BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(uiBean.getSiteituuka())));
                    kawaseRate.add(BizNumber.valueOf(0));
                }
                else {
                    KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
                    KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

                    keisanWExtBean.setSyouhncd(uiBean.getSyusyouhncd());
                    keisanWExtBean.setSyouhnsdno(uiBean.getSyouhnsdno());
                    keisanWExtBean.setRyouritusdno(uiBean.getRyouritusdno());
                    keisanWExtBean.setYoteiriritu(uiBean.getYoteiriritu());
                    keisanWExtBean.setHrkkaisuu(uiBean.getHrkkaisuu());
                    keisanWExtBean.setHknkknsmnkbn(uiBean.getHknkknsmnkbn());
                    keisanWExtBean.setHrkkknsmnkbn(uiBean.getHrkkknsmnKbn());
                    keisanWExtBean.setHrkkkn(uiBean.getHrkkkn());
                    keisanWExtBean.setHknkkn(uiBean.getHknkkn());
                    keisanWExtBean.setHhknnen(uiBean.getHhknnen());
                    keisanWExtBean.setHhknsei(uiBean.getHhknsei());
                    keisanWExtBean.setKihons(uiBean.getKihons());
                    keisanWExtBean.setHokenryou(uiBean.getHokenryou());
                    keisanWExtBean.setKykymd(keiyakuYmd);
                    keisanWExtBean.setTuukasyu(uiBean.getSiteituuka());
                    keisanWExtBean.setKyksjkkktyouseiriritu(uiBean.getKyksjkkktyouseiriritu());
                    keisanWExtBean.setKaiyakusjkkktyouseiriritu(kaiykSjkkkTyouseiyouRiritu);
                    keisanWExtBean.setTmttkntaisyouym(tmttknTaisyouYM);
                    keisanWExtBean.setTeiritutmttkngk(teirituTmttkngk);
                    keisanWExtBean.setSisuurendoutmttkngk(sisuurendouTmttkngk);
                    keisanWExtBean.setTmttknhaneisisuu(tmttknhaneisisuu);
                    keisanWExtBean.setTumitateriritu(uiBean.getTumitateRiritu());
                    keisanWExtBean.setJkipjytym(calckijyuYm);
                    keisanWExtBean.setPtmttkngk(ptmttkngk);
                    keisanWExtBean.setKihrkmpstgk(kihrkmpstgk);
                    keisanWExtBean.setFstpryosyuymd(uiBean.getFstprsymd());
                    keisanWExtBean.setYoteirrthendohosyurrt(uiBean.getYoteirrthendohosyurrt());
                    keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI_SISAN);
                    keisanWExtBean.setSisansyoriymd(sisanyouSyoriYmd);
                    keisanWExtBean.setSisanyoteiriritu(uiBean.getYoteirrthendohosyurrt());
                    keisanWExtBean.setSisankawaserate(sisanyouKawaseRate);
                    keisanWExtBean.setYendthnkymd(uiBean.getYendthnkymd());
                    keisanWExtBean.setDai1hknkkn(uiBean.getDai1hknkkn());
                    keisanWExtBean.setKykJyoutai(uiBean.getKykjyoutai());

                    C_ErrorKbn kekkaKbn = keisanW.exec(calckijyunYmdgetu, calckijyuYm, keisanWExtBean);

                    if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                        throw new BizLogicException(MessageId.EIA0167);
                    }

                    if (C_Tuukasyu.JPY.eq(uiBean.getSiteituuka())) {
                        kaiyakuhrYen.add(keisanW.getW());
                    }
                    else {
                        kaiyakuhrGaika.add(keisanW.getW());
                        ptmttkngkArrayLst.add(keisanW.getV());
                        kihrkmpstgkArrayLst.add(keisanW.getPruikei());

                        ptmttkngk = keisanW.getV();
                        kihrkmpstgk = keisanW.getPruikei();

                        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                        kekkaKbn = getKawaseRate.exec(
                            kaiyakuhryenhkYmd,
                            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                            uiBean.getSiteituuka(),
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.SYUKKINRATE,
                            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                            C_YouhiKbn.YOU);

                        if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                            throw new BizLogicException(MessageId.EIA0167);
                        }

                        uiBean.setKwsratekjymd(getKawaseRate.getKwsrateKjYmd());

                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                        kaiyakuhrYen.add(keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            keisanW.getW(),
                            getKawaseRate.getKawaserate(),
                            C_HasuusyoriKbn.AGE));

                        kawaseRate.add(getKawaseRate.getKawaserate());
                    }
                }
            }

            kaiyakuhrGaikaLst.add(kaiyakuhrGaika);
            kaiyakuhrYenLst.add(kaiyakuhrYen);
            kawaseRateLst.add(kawaseRate);
            ptmttkngkLst.add(ptmttkngkArrayLst);
            kihrkmpstgkLst.add(kihrkmpstgkArrayLst);
        }

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn() ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyohinHanteiKbn()) {
            kijyungk = uiBean.getKihons();
        }
        else if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinHanteiKbn()) {
            kijyungk = uiBean.getPharaikomisougaku();
        }

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn() ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyohinHanteiKbn()) {
            BizDate nkshrstartymd = BizDateUtil.getDateAfterPeriod(uiBean.getKykymd(), uiBean.getHknkkn(), 0);

            KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
            KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

            keisanWExtBean.setSyouhncd(uiBean.getSyusyouhncd());
            keisanWExtBean.setSyouhnsdno(uiBean.getSyouhnsdno());
            keisanWExtBean.setRyouritusdno(uiBean.getRyouritusdno());
            keisanWExtBean.setYoteiriritu(uiBean.getYoteiriritu());
            keisanWExtBean.setHrkkaisuu(uiBean.getHrkkaisuu());
            keisanWExtBean.setHrkkknsmnkbn(uiBean.getHrkkknsmnKbn());
            keisanWExtBean.setHknkknsmnkbn(uiBean.getHknkknsmnkbn());
            keisanWExtBean.setHrkkkn(uiBean.getHrkkkn());
            keisanWExtBean.setHknkkn(uiBean.getHknkkn());
            keisanWExtBean.setHhknnen(uiBean.getHhknnen());
            keisanWExtBean.setHhknsei(uiBean.getHhknsei());
            keisanWExtBean.setKihons(uiBean.getKihons());
            keisanWExtBean.setHokenryou(uiBean.getHokenryou());
            keisanWExtBean.setKykymd(keiyakuYmd);
            keisanWExtBean.setTuukasyu(uiBean.getSiteituuka());
            keisanWExtBean.setKyksjkkktyouseiriritu(uiBean.getKyksjkkktyouseiriritu());
            keisanWExtBean.setKaiyakusjkkktyouseiriritu(kaiykSjkkkTyouseiyouRiritu);
            keisanWExtBean.setTmttkntaisyouym(tmttknTaisyouYM);
            keisanWExtBean.setTeiritutmttkngk(teirituTmttkngk);
            keisanWExtBean.setSisuurendoutmttkngk(sisuurendouTmttkngk);
            keisanWExtBean.setTmttknhaneisisuu(tmttknhaneisisuu);
            keisanWExtBean.setTumitateriritu(uiBean.getTumitateRiritu());
            keisanWExtBean.setJkipjytym(calckijyuYm);
            keisanWExtBean.setPtmttkngk(uiBean.getPtmttkngk());
            keisanWExtBean.setKihrkmpstgk(uiBean.getKihrkmpstgk());
            keisanWExtBean.setFstpryosyuymd(uiBean.getFstprsymd());
            keisanWExtBean.setYoteirrthendohosyurrt(uiBean.getYoteirrthendohosyurrt());
            keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI_SISAN);
            keisanWExtBean.setSisansyoriymd(sisanyouSyoriYmd);
            keisanWExtBean.setSisanyoteiriritu(uiBean.getYoteirrthendohosyurrt());
            keisanWExtBean.setSisankawaserate(sisanyouKawaseRate);
            keisanWExtBean.setYendthnkymd(uiBean.getYendthnkymd());
            keisanWExtBean.setDai1hknkkn(uiBean.getDai1hknkkn());
            keisanWExtBean.setKykJyoutai(uiBean.getKykjyoutai());

            C_ErrorKbn kekkaKbn = keisanW.exec(nkshrstartymd.getPreviousDay(),
                nkshrstartymd.getBizDateYM(), keisanWExtBean);

            if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                throw new BizLogicException(MessageId.EIA0167);
            }

            nennkinnGenshi = keisanW.getV();
        }
        else if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinHanteiKbn()) {
            nennkinnGenshi = ptmttkngk;
        }

        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(keiyakuYmd, BizDate.getSysDate()
            , calckijyuYm, uiBean.getHrkkaisuu(), uiBean.getKykjyoutai(), uiBean.getSyusyouhncd(), null);

        if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) {
            kaiyakuhrKisnKijyunYM = kaiyakuhrKisnKijyunYM.addMonths(-1);
        }

        if (BizDateUtil.compareYm(kaiyakuhrKisnKijyunYM, keiyakuYmd.getBizDateYM()) != BizDateUtil.COMPARE_LESSER) {
            BizDateSpan dateSpan = BizDateUtil.calcDifference(
                kaiyakuhrKisnKijyunYM.getFirstDay(),
                keiyakuYmd.getBizDateYM().getFirstDay());
            uiBean.setSisanbiIndexY(dateSpan.getYears());
            uiBean.setSisanbiIndexM(dateSpan.getMonths());
        }

        List<IReportDataSouceBean> iReportDataSouceBeanList = new ArrayList<>();

        int keikaNensuu = -1;
        int addHhknnen = uiBean.getHhknnen() - 1;

        if (C_Tuukasyu.JPY.eq(uiBean.getSiteituuka())) {
            for (int i = 0; i < kaiyakuhrYenLst.size(); i++) {
                KhSyouraiwSisanhyouDataSourceBean khSyouraiwSisanhyouDataSourceBean = SWAKInjector.getInstance(KhSyouraiwSisanhyouDataSourceBean.class);

                keikaNensuu = keikaNensuu + 1;
                addHhknnen = addHhknnen + 1;

                khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(keikaNensuu);
                khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(addHhknnen);
                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(kaiyakuhrYenLst.get(i).get(0));
                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(kaiyakuhrYenLst.get(i).get(1));
                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(kaiyakuhrYenLst.get(i).get(2));
                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(kaiyakuhrYenLst.get(i).get(3));
                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(kaiyakuhrYenLst.get(i).get(4));
                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(kaiyakuhrYenLst.get(i).get(5));
                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(kaiyakuhrYenLst.get(i).get(6));
                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(kaiyakuhrYenLst.get(i).get(7));
                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(kaiyakuhrYenLst.get(i).get(8));
                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(kaiyakuhrYenLst.get(i).get(9));
                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(kaiyakuhrYenLst.get(i).get(10));
                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(kaiyakuhrYenLst.get(i).get(11));

                if (uiBean.getSisanbiIndexY() == i) {
                    khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(uiBean.getSisanbiIndexM());
                }

                iReportDataSouceBeanList.add(khSyouraiwSisanhyouDataSourceBean);
            }
        }
        else {
            for (int i = 0; i < kaiyakuhrGaikaLst.size(); i++) {

                KhSyouraiwSisanhyouDataSourceBean khSyouraiwSisanhyouDataSourceBean =
                    SWAKInjector.getInstance(KhSyouraiwSisanhyouDataSourceBean.class);

                khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(Integer.valueOf(++keikaNensuu));
                khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(++addHhknnen);

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(kaiyakuhrGaikaLst.get(i).get(0));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(kaiyakuhrGaikaLst.get(i).get(1));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(kaiyakuhrGaikaLst.get(i).get(2));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(kaiyakuhrGaikaLst.get(i).get(3));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(kaiyakuhrGaikaLst.get(i).get(4));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(kaiyakuhrGaikaLst.get(i).get(5));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(kaiyakuhrGaikaLst.get(i).get(6));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(kaiyakuhrGaikaLst.get(i).get(7));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(kaiyakuhrGaikaLst.get(i).get(8));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(kaiyakuhrGaikaLst.get(i).get(9));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(kaiyakuhrGaikaLst.get(i).get(10));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(kaiyakuhrGaikaLst.get(i).get(11));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(kaiyakuhrYenLst.get(i).get(0));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(kaiyakuhrYenLst.get(i).get(1));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(kaiyakuhrYenLst.get(i).get(2));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(kaiyakuhrYenLst.get(i).get(3));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(kaiyakuhrYenLst.get(i).get(4));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(kaiyakuhrYenLst.get(i).get(5));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(kaiyakuhrYenLst.get(i).get(6));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(kaiyakuhrYenLst.get(i).get(7));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(kaiyakuhrYenLst.get(i).get(8));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(kaiyakuhrYenLst.get(i).get(9));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(kaiyakuhrYenLst.get(i).get(10));

                khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(kaiyakuhrYenLst.get(i).get(11));

                khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(kawaseRateLst.get(i).get(0));

                khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(kawaseRateLst.get(i).get(1));

                khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(kawaseRateLst.get(i).get(2));

                khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(kawaseRateLst.get(i).get(3));

                khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(kawaseRateLst.get(i).get(4));

                khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(kawaseRateLst.get(i).get(5));

                khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(kawaseRateLst.get(i).get(6));

                khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(kawaseRateLst.get(i).get(7));

                khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(kawaseRateLst.get(i).get(8));

                khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(kawaseRateLst.get(i).get(9));

                khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(kawaseRateLst.get(i).get(10));

                khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(kawaseRateLst.get(i).get(11));

                khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin0(ptmttkngkLst.get(i).get(0));

                khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin1(ptmttkngkLst.get(i).get(1));

                khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin2(ptmttkngkLst.get(i).get(2));

                khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin3(ptmttkngkLst.get(i).get(3));

                khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin4(ptmttkngkLst.get(i).get(4));

                khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin5(ptmttkngkLst.get(i).get(5));

                khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin6(ptmttkngkLst.get(i).get(6));

                khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin7(ptmttkngkLst.get(i).get(7));

                khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin8(ptmttkngkLst.get(i).get(8));

                khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin9(ptmttkngkLst.get(i).get(9));

                khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin10(ptmttkngkLst.get(i).get(10));

                khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin11(ptmttkngkLst.get(i).get(11));

                if (uiBean.getSisanbiIndexY() == i) {

                    khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(uiBean.getSisanbiIndexM());
                }

                if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinHanteiKbn()) {

                    khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk0(kihrkmpstgkLst.get(i).get(0));

                    khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk1(kihrkmpstgkLst.get(i).get(1));

                    khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk2(kihrkmpstgkLst.get(i).get(2));

                    khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk3(kihrkmpstgkLst.get(i).get(3));

                    khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk4(kihrkmpstgkLst.get(i).get(4));

                    khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk5(kihrkmpstgkLst.get(i).get(5));

                    khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk6(kihrkmpstgkLst.get(i).get(6));

                    khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk7(kihrkmpstgkLst.get(i).get(7));

                    khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk8(kihrkmpstgkLst.get(i).get(8));

                    khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk9(kihrkmpstgkLst.get(i).get(9));

                    khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk10(kihrkmpstgkLst.get(i).get(10));

                    khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk11(kihrkmpstgkLst.get(i).get(11));
                }

                iReportDataSouceBeanList.add(khSyouraiwSisanhyouDataSourceBean);
            }
        }

        if (C_Tuukasyu.JPY.eq(uiBean.getSiteituuka())) {
            uiBean.setWarnFlag(false);
        }

        KhSyouraiwSisanhyouBean khSyouraiwSisanhyouBean = SWAKInjector.getInstance(KhSyouraiwSisanhyouBean.class);

        khSyouraiwSisanhyouBean.setIrUsernm(baseUserInfo.getUserNm());

        khSyouraiwSisanhyouBean.setIrSakuseiymdtime(
            new SimpleDateFormat("yyyy/MM/dd HH:mm").format(BizDate.getSystemDate().getTime()));

        khSyouraiwSisanhyouBean.setIrSyono(uiBean.getSyono());

        khSyouraiwSisanhyouBean.setIrSisanymd(DefaultDateFormatter.formatYMDKanji(BizDate.getSysDate()));

        khSyouraiwSisanhyouBean.setIrKykymd(DefaultDateFormatter.formatYMDKanji(keiyakuYmd));

        khSyouraiwSisanhyouBean.setIrKanyuujinen(uiBean.getHhknnen());

        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.valueOf(uiBean.getHhknsei().getValue()));

        khSyouraiwSisanhyouBean.setIrHknsyurui(uiBean.getSyouhnnm());

        khSyouraiwSisanhyouBean.setIrHkgkgaika(uiBean.getKihons());

        khSyouraiwSisanhyouBean.setIrKyktuukasyu(uiBean.getSiteituuka());

        khSyouraiwSisanhyouBean.setIrHknkkn(String.valueOf(uiBean.getHknkkn()));

        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(uiBean.getHknkknsmnkbn());

        khSyouraiwSisanhyouBean.setIrYendthnkymd(DefaultDateFormatter.formatYMDKanji(uiBean.getYendthnkymd()));

        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(uiBean.getSyohinHanteiKbn());

        khSyouraiwSisanhyouBean.setIrHokenryou(uiBean.getHokenryou());

        khSyouraiwSisanhyouBean.setIrHrkkkn(uiBean.getHrkkkn());

        khSyouraiwSisanhyouBean.setIrHrkkknsmnkbn(uiBean.getHrkkknsmnKbn());

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn() &&
            C_Tuukasyu.JPY.eq(uiBean.getSiteituuka())) {

            khSyouraiwSisanhyouBean.setIrItijibrp(null);
            khSyouraiwSisanhyouBean.setIrTeiritutmttrate(null);
            khSyouraiwSisanhyouBean.setIrSisuurendourate(null);
            khSyouraiwSisanhyouBean.setIrTmttknitenymd(null);
        }
        else {

            khSyouraiwSisanhyouBean.setIrItijibrp(uiBean.getHokenryou());
            khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.valueOf(100).subtract(uiBean.getSisuurendourate()));
            khSyouraiwSisanhyouBean.setIrSisuurendourate(uiBean.getSisuurendourate());
            khSyouraiwSisanhyouBean.setIrTmttknitenymd(DefaultDateFormatter.formatYMDKanji(uiBean.getTmttknitenymd()));
        }

        if (kijyungk != null && !kijyungk.isOptional()) {
            khSyouraiwSisanhyouBean.setIrKijyunkingaku(ViewReport.editCommaTuuka(kijyungk, BizUtil.ZERO_FILL));
        }
        else {

            khSyouraiwSisanhyouBean.setIrKijyunkingaku(null);
        }

        if (nennkinnGenshi != null && !nennkinnGenshi.isOptional()) {
            khSyouraiwSisanhyouBean.setIrNkgnsgk(ViewReport.editCommaTuuka(nennkinnGenshi, BizUtil.ZERO_FILL));
        }
        else {

            khSyouraiwSisanhyouBean.setIrNkgnsgk(null);
        }

        if (uiBean.getWarnFlag()) {

            khSyouraiwSisanhyouBean.setIrWarningmsg(MessageUtil.getMessage(MessageId.IIF1003,
                DefaultDateFormatter.formatYMDKanji(uiBean.getKwsratekjymd())));
        }

        ReportServicesBean serviceBean =
            createReport.createNewReportServiceBean(asKinou.getSubSystemId()
                , asKinou.getCategoryId()
                , asKinou.getKinouId()
                , C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);

        serviceBean.addParamObjects(iReportDataSouceBeanList, khSyouraiwSisanhyouBean);

        String tyouhyouKey = createReport.execNoCommit(serviceBean);

        uiBean.setTyouhyoukey(tyouhyouKey);

    }

    private void init_gotoInputKey() {

        if (!BizUtil.isBlank(uiBean.getSrchsyono())) {

            String srchSyono = uiBean.getSrchsyono();

            clear();

            uiBean.setSrchsyono(srchSyono);

            init();
        }
        else {
            BizDate srchKykymd = uiBean.getSrchkykymd();

            Integer srchKanyujinen = uiBean.getSrchkanyuujinen();

            C_Seibetu srchSei = uiBean.getSrchsei();

            C_SelHokensyuruiKbn srchSyuhknsyurui = uiBean.getSrchhknsyrui();

            C_Tuukasyu srchsiteituuka = uiBean.getSrchsiteituuka();

            Integer srchhrkkkn = uiBean.getSrchhrkkkn();

            BizCurrency srchkihons = uiBean.getSrchkihons();

            BizCurrency srchsrchp = uiBean.getSrchp();

            BizDate srchsknnkaisiymd = uiBean.getSrchsknnkaisiymd();

            Integer srchhknkkn = uiBean.getSrchhknkkn();

            BizDate srchyendthnkymd = uiBean.getSrchyendthnkymd();

            BizNumber srchsisuurendourate = uiBean.getSrchsisuurendourate();

            BizDate srchtmttknitenymd = uiBean.getSrchtmttknitenymd();

            clear();

            init();

            uiBean.setSrchkykymd(srchKykymd);

            uiBean.setSrchkanyuujinen(srchKanyujinen);

            uiBean.setSrchsei(srchSei);

            uiBean.setSrchhknsyrui(srchSyuhknsyurui);

            uiBean.setSrchsiteituuka(srchsiteituuka);

            uiBean.setSrchhrkkkn(srchhrkkkn);

            uiBean.setSrchkihons(srchkihons);

            uiBean.setSrchp(srchsrchp);

            uiBean.setSrchsknnkaisiymd(srchsknnkaisiymd);

            uiBean.setSrchhknkkn(srchhknkkn);

            uiBean.setSrchyendthnkymd(srchyendthnkymd);

            uiBean.setSrchsisuurendourate(srchsisuurendourate);

            uiBean.setSrchtmttknitenymd(srchtmttknitenymd);
        }
    }

    private void setWarning() {

        messageManager.addMessageId(MessageId.IIF1004);
        messageManager.addMessageId(MessageId.IIF1002);

        if (uiBean.getWarnFlag()) {

            messageManager.addMessageId(MessageId.IIF1003, DefaultDateFormatter.formatYMDKanji(uiBean.getKwsratekjymd()));
        }
    }

    private void getSearchByInputInfo(BM_SyouhnZokusei pSyouhnZokusei, BizDate pKykYmd, boolean pYendthnkUmuFlag) {

        if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getSyuusinhknumu())) {
            uiBean.setHknkkn(99);
        }
        else {
            uiBean.setHknkkn(uiBean.getSrchhknkkn());
        }

        if (pYendthnkUmuFlag) {

            BizDate hknkknManryou = BizDateUtil.getDateAfterPeriod(uiBean.getSrchkykymd(), uiBean.getHknkkn(), 0);

            if (BizDateUtil.compareYmd(hknkknManryou, uiBean.getSrchyendthnkymd()) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(hknkknManryou, uiBean.getSrchyendthnkymd()) == BizDateUtil.COMPARE_EQUAL) {

                throw new BizLogicException(MessageId.EIA1024,
                    MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHYENDTHNKYMD.getErrorResourceKey()),
                    "保険期間内の日付");
            }
        }

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn() &&
            !pYendthnkUmuFlag) {

            if (uiBean.getSrchtmttknitenymd() != null) {

                BizDate hknkknManryou = BizDateUtil.getDateAfterPeriod(uiBean.getSrchkykymd(), uiBean.getHknkkn(), 0);

                if (BizDateUtil.compareYmd(hknkknManryou, uiBean.getSrchtmttknitenymd()) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(hknkknManryou, uiBean.getSrchtmttknitenymd()) == BizDateUtil.COMPARE_EQUAL) {

                    throw new BizLogicException(MessageId.EIA1024,
                        MessageUtil.getMessage(DDID_SYOUKAICONDITIONS2_SRCHTMTTKNITENYMD.getErrorResourceKey()),
                        "保険期間内の日付");
                }
            }
        }

        BizNumber yoteiriritu = null;
        BizNumber tumitateriritu = null;

        if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyohinHanteiKbn()) {
            uiBean.setSiteituuka(uiBean.getSrchsiteituuka());
        }
        else {
            uiBean.setSiteituuka(pSyouhnZokusei.getTuukasyu());
        }

        if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR != uiBean.getSyohinHanteiKbn() ||
            !pYendthnkUmuFlag) {
            GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
            GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

            getYoteirirituBean.setSyouhncd(uiBean.getSyusyouhncd());
            getYoteirirituBean.setHknkkn(uiBean.getHknkkn());
            getYoteirirituBean.setHknkknsmnkbn(C_HknkknsmnKbn.BLNK);
            getYoteirirituBean.setHhknnen(0);
            getYoteirirituBean.setSitihsyuriritu(pSyouhnZokusei.getYoteirirituminhosyouritu());
            getYoteirirituBean.setTuukasyu(uiBean.getSiteituuka());

            if (pYendthnkUmuFlag) {
                getYoteirirituBean.setKijyunymd(uiBean.getYendthnkymd());
                getYoteirirituBean.setSknnkaisiymd(uiBean.getYendthnkymd());
                getYoteirirituBean.setKykymd(uiBean.getYendthnkymd());
            }
            else {
                getYoteirirituBean.setKijyunymd(uiBean.getKykymd());
                getYoteirirituBean.setSknnkaisiymd(uiBean.getSknnkaisiymd());
                getYoteirirituBean.setKykymd(uiBean.getKykymd());
            }

            C_ErrorKbn kekkaKbn = getYoteiriritu.exec(getYoteirirituBean);

            if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                throw new BizLogicException(MessageId.EIA0167);
            }
            yoteiriritu = getYoteiriritu.getYoteiriritu();
            tumitateriritu = getYoteiriritu.getTumitateriritu();
        }
        else {
            yoteiriritu = BizNumber.ZERO;
            tumitateriritu = BizNumber.ZERO;
        }

        BizNumber kyksjkkktyouseiriritu = null;
        if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getMvatekiumu())) {
            GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
            GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);

            getSjkkktyouseiyourirituBean.setSyouhncd(uiBean.getSyusyouhncd());
            getSjkkktyouseiyourirituBean.setHknkkn(uiBean.getHknkkn());
            getSjkkktyouseiyourirituBean.setHknkknsmnkbn(C_HknkknsmnKbn.BLNK);
            getSjkkktyouseiyourirituBean.setHhknnen(0);

            if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn() ||
                SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyohinHanteiKbn()) {
                getSjkkktyouseiyourirituBean.setKijyunymd(uiBean.getSknnkaisiymd());
            }
            else {
                getSjkkktyouseiyourirituBean.setKijyunymd(uiBean.getKykymd());
            }

            C_ErrorKbn kekkaKbnSjkkk = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

            if (C_ErrorKbn.ERROR.eq(kekkaKbnSjkkk)) {
                throw new BizLogicException(MessageId.EIA0167);
            }
            kyksjkkktyouseiriritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
        }
        else {
            kyksjkkktyouseiriritu = BizNumber.ZERO;
        }

        uiBean.setSyouhnsdno(pSyouhnZokusei.getSyouhnsdno());

        uiBean.setRyouritusdno(pSyouhnZokusei.getRyouritusdno());

        uiBean.setYoteiriritu(yoteiriritu);

        uiBean.setSyono(null);

        uiBean.setSyouhnnm(pSyouhnZokusei.getSyouhnnm());

        uiBean.setKyksjkkktyouseiriritu(kyksjkkktyouseiriritu);

        uiBean.setTumitateRiritu(tumitateriritu);

        uiBean.setYoteirrthendohosyurrt(pSyouhnZokusei.getYoteirirituminhosyouritu());

        uiBean.setItijibrumu(pSyouhnZokusei.getItijibrumu());

        uiBean.setSyuusinhknumu(pSyouhnZokusei.getSyuusinhknumu());

        uiBean.setHeijyunbaraiumu(pSyouhnZokusei.getHeijyunbaraiumu());

        uiBean.setFstprsymd(uiBean.getSrchsknnkaisiymd());

        uiBean.setTmttknitenymd(uiBean.getTmttknitenymd());

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        uiBean.setPtmttkngk(BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(uiBean.getSiteituuka())));

        uiBean.setKihrkmpstgk(BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(uiBean.getSiteituuka())));

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinHanteiKbn()||
            SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyohinHanteiKbn()) {
            uiBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            uiBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        } else {
            uiBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
            uiBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        }

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn() ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyohinHanteiKbn()) {
            uiBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
            uiBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.NENMANKI);
        }
        else {
            uiBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
            uiBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.SAIMANKI);
        }

        if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyohinHanteiKbn()) {
            uiBean.setDai1hknkkn(5);
        }
        else {
            uiBean.setDai1hknkkn(0);
        }

        if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == uiBean.getSyohinHanteiKbn() && !pYendthnkUmuFlag) {
            KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

            C_ErrorKbn kekkaKbn = keisanSP.exec(uiBean.getSyusyouhncd(),
                uiBean.getRyouritusdno(),
                uiBean.getYoteiriritu(),
                uiBean.getHrkkaisuu(),
                uiBean.getHhknnen(),
                uiBean.getHhknsei(),
                uiBean.getHknkknsmnkbn(),
                uiBean.getHknkkn(),
                uiBean.getHrkkkn(),
                C_Sdpd.SD,
                uiBean.getKihons(),
                BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(uiBean.getSiteituuka())),
                uiBean.getSiteituuka(),
                uiBean.getKykjyoutai(),
                uiBean.getDai1hknkkn(),
                C_Hrkkeiro.BLNK);

            if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                throw new BizLogicException(MessageId.EIA0167);
            }
            uiBean.setHokenryou(keisanSP.getP());
        }
        else if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinHanteiKbn()) {
            uiBean.setHokenryou(uiBean.getSrchp());
        }
        else {
            uiBean.setHokenryou(uiBean.getSrchkihons());
        }
    }

    private List<String> ajaxSyouhnChange(String pSyouhnCd,C_Tuukasyu pTuukasyu) {

        List<String> outStrLst = Lists.newArrayList();

        CurrencyType currencyType = BizCurrencyTypes.YEN;

        C_SelHokensyuruiKbn selHokensyuruiKbn = C_SelHokensyuruiKbn.valueOf(pSyouhnCd);
        if (!C_SelHokensyuruiKbn.BLNK.eq(selHokensyuruiKbn)) {

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnCd);

            if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {
                if (!C_Tuukasyu.BLNK.eq(pTuukasyu)) {
                    currencyType = henkanTuuka.henkanTuukaKbnToType(pTuukasyu);
                }
            }
            else {
                List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyouhncd(pSyouhnCd);

                C_Tuukasyu tuukasyu = syouhnZokuseiLst.get(0).getTuukasyu();

                currencyType = henkanTuuka.henkanTuukaKbnToType(tuukasyu);
            }
        }

        BizCurrency initKingaku = BizCurrency.optional(currencyType);

        outStrLst.add(initKingaku.toString());
        outStrLst.add(initKingaku.toPattern());
        outStrLst.add(currencyType.getUnitValue());
        outStrLst.add(currencyType.toString());
        uiBean.setSrchkihons(initKingaku);

        return outStrLst;
    }
}

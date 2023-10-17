package yuyu.app.hozen.khozen.khkeiyakusyoukai;

import static yuyu.app.hozen.khozen.khkeiyakusyoukai.GenKhKeiyakuSyoukaiConstants.*;
import static yuyu.app.hozen.khozen.khkeiyakusyoukai.KhKeiyakuSyoukaiConstants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khozen.khkeiyakusyoukai.dba.DsMailAddressInfosBySyonoBean;
import yuyu.app.hozen.khozen.khkeiyakusyoukai.dba.KhKeiyakuSyoukaiDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.CTIParamBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.hozen.ascommon.GetasPRsTuuka;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgkOutBean;
import yuyu.common.hozen.ascommon.KeisanRsgkUtiwakeBean;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.HanteiTyotikuseihokenBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenEdit;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.hozen.khcommon.SetHurikaebi;
import yuyu.common.hozen.khcommon.SetTyotikuseihokenhyouji;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobi;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetDattai;
import yuyu.common.hozen.setuibean.SetHaitoukin;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetHihokensya;
import yuyu.common.hozen.setuibean.SetHosyou;
import yuyu.common.hozen.setuibean.SetKariukekin;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKeizokuNkukt;
import yuyu.common.hozen.setuibean.SetKhTkshrSiharaiKouza;
import yuyu.common.hozen.setuibean.SetKyksyadairi;
import yuyu.common.hozen.setuibean.SetNkukt;
import yuyu.common.hozen.setuibean.SetSbHenkanukt;
import yuyu.common.hozen.setuibean.SetSbHkukt;
import yuyu.common.hozen.setuibean.SetSiteiseikyuu;
import yuyu.common.hozen.setuibean.SetSonotaTk;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetTokusin;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.hozen.setuibean.SetTrkKazoku;
import yuyu.common.hozen.setuibean.SetTuusinsaki;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_Boskykjyoutai;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_DispKbn;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_HyoujiptnKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KyktrksKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_PyenTutHouKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_Syorikeiyu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YennykntksyuruiKbn;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KhHenkouUktkYendtHnk;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhShrRirekiDetail;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyaHenkouRireki;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KhShrRirekiInfosBySyonoHenkousikibetukeyBean;
import yuyu.def.hozen.result.bean.KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean;
import yuyu.def.hozen.result.bean.KhTtdkRirekiInfosBySyonoBean;
import yuyu.def.hozen.result.bean.KykInfosByKykymDrtencdItemsBean;
import yuyu.def.hozen.sorter.SortIT_NyknJissekiRireki;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * 契約内容照会 のビジネスロジックです。
 */
public class KhKeiyakuSyoukaiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhKeiyakuSyoukaiUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private KhKeiyakuSyoukaiDao khKeiyakuSyoukaiDao;

    @Inject
    private CTIParamBean ctiParamBean;

    void init() {
        clear();
        BizPropertyInitializer.initialize(uiBean);
    }

    void clear() {
    }

    public void pushKykNaiyouBtnbyInputkeyBL() {
        chkKeiyaku(uiBean.getSyono());

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        chkYuukou(khozenCommonParam);

        hanteiTtdkTyuui(khozenCommonParam, uiBean.getSyono());

        checkYuuyokkngai(khozenCommonParam);

        checkKykymdsakihiduke(khozenCommonParam);

        checkKouryokusakihiduke();

        checkYendtMbrs();

        chkTtdkrrkumu();

        chkSisuurendoTmttknumu(khozenCommonParam);

        setKyknaiyouosiraseKngn();

        setSyouraiKaiyakuhenreikinKngn();

        setKaiyakuKngn();

        setKeiyakunaiyouUiBean(khozenCommonParam);

        uiBean.setSyoriKeiyuKbn(C_Syorikeiyu.KEYINPUT);
    }

    void ctiOpenBL() {
        uiBean.setSyono(ctiParamBean.getSyono());
    }

    public void pushTtdkRirekiBtnByinputkeyBL() {
        chkKeiyaku(uiBean.getSyono());

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        chkTtdkrrkumu();

        if (C_UmuKbn.NONE.eq(uiBean.getTtdkrrkumu())) {
            throw new BizLogicException(MessageId.EIA0061);
        }

        chkYuukou(khozenCommonParam);

        hanteiTtdkTyuui(khozenCommonParam, uiBean.getSyono());

        checkYuuyokkngai(khozenCommonParam);

        checkKykymdsakihiduke(khozenCommonParam);

        checkKouryokusakihiduke();

        checkYendtMbrs();

        chkSisuurendoTmttknumu(khozenCommonParam);

        setKyknaiyouosiraseKngn();

        setSyouraiKaiyakuhenreikinKngn();

        setKaiyakuKngn();

        setTtdkRirekiUiBean(khozenCommonParam);

        getTtdkRireki();

        setTtdkRirekiListUiBean();

        uiBean.setSyoriKeiyuKbn(C_Syorikeiyu.KEYINPUT);
    }

    public void pushNyuukinRirekiBtnbyInputkeyBL() {
        chkKeiyaku(uiBean.getSyono());

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        chkYuukou(khozenCommonParam);

        hanteiTtdkTyuui(khozenCommonParam, uiBean.getSyono());

        checkYuuyokkngai(khozenCommonParam);

        checkKykymdsakihiduke(khozenCommonParam);

        checkKouryokusakihiduke();

        checkYendtMbrs();

        chkSisuurendoTmttknumu(khozenCommonParam);

        setKyknaiyouosiraseKngn();

        setSyouraiKaiyakuhenreikinKngn();

        setKaiyakuKngn();

        setNyuukinRirekiUiBean(khozenCommonParam);

        getNyuukinRireki(khozenCommonParam);

        setNyuukinRirekiListUiBean(khozenCommonParam);

        chkTtdkrrkumu();

        uiBean.setSyoriKeiyuKbn(C_Syorikeiyu.KEYINPUT);
    }

    public void pushTumitatekinRirekiBtnbyInputkeyBL() {

        chkKeiyaku(uiBean.getSyono());

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        chkYuukou(khozenCommonParam);

        hanteiTtdkTyuui(khozenCommonParam, uiBean.getSyono());

        checkYuuyokkngai(khozenCommonParam);

        checkKykymdsakihiduke(khozenCommonParam);

        checkKouryokusakihiduke();

        checkYendtMbrs();

        chkTtdkrrkumu();

        setKyknaiyouosiraseKngn();

        setSyouraiKaiyakuhenreikinKngn();

        setKaiyakuKngn();

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);

        setToriatukaiTyuui.exec(khozenCommonParam, uiBean);

        setTmttkRirekiListUiBean(khozenCommonParam);

        chkSisuurendoTmttknumu(khozenCommonParam);

        uiBean.setSyoriKeiyuKbn(C_Syorikeiyu.KEYINPUT);
    }

    public void pushDispSyonoBL() {

        if (uiBean.getKensakuResultInfoDataSource().getSelectedBean() != null) {
            uiBean.setSyono(uiBean.getKensakuResultInfoDataSource().getSelectedBean().getDispsyono());
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        chkYuukou(khozenCommonParam);

        hanteiTtdkTyuui(khozenCommonParam, uiBean.getSyono());

        checkYuuyokkngai(khozenCommonParam);

        checkKykymdsakihiduke(khozenCommonParam);

        checkKouryokusakihiduke();

        checkYendtMbrs();

        chkTtdkrrkumu();

        chkSisuurendoTmttknumu(khozenCommonParam);

        setKyknaiyouosiraseKngn();

        setSyouraiKaiyakuhenreikinKngn();

        setKaiyakuKngn();

        setKeiyakunaiyouUiBean(khozenCommonParam);
    }

    public void pushNkrrkBtnBL() {

        clearWarningMessage();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        getNyuukinRireki(khozenCommonParam);

        setNyuukinRirekiListUiBean(khozenCommonParam);
    }

    public void pushTmttkrrkBtnBL() {

        clearWarningMessage();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        setTmttkRirekiListUiBean(khozenCommonParam);
    }

    public void pushKykNaiyouBtnBL() {
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        setKeiyakunaiyouUiBean(khozenCommonParam);
    }

    public void pushHyoujilink1BL() {
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        getTtdkSyousai(khozenCommonParam);
    }

    void printHyoujiOut() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    public void pushTtdkRrkBtnBL() {

        clearWarningMessage();

        getTtdkRireki();

        setTtdkRirekiListUiBean();
    }

    public void pushSearchBL() {
        BizDateYM srchKykYm = uiBean.getSrchkykym();
        String srchDrtenCd = uiBean.getSrchdrtencd();
        C_YuukousyoumetuKbn srchyuukousyoumetukbn = uiBean.getSrchyuukousyoumetukbn();
        String srchKykNmKn = uiBean.getSrchkyknmkn();
        String srchkyknmkj = uiBean.getSrchkyknmkj();
        BizDate srchKykSeiYmd = uiBean.getSrchkykseiymd();
        String srchtelno = uiBean.getSrchtelno();
        String srchtsinyno = uiBean.getSrchtsinyno();
        String srchHhknnmkn = uiBean.getSrchhhknnmkn();
        String srchhhknnmkj = uiBean.getSrchhhknnmkj();
        BizDate srchHhknseiymd = uiBean.getSrchhhknseiymd();

        if (srchKykYm == null
            && BizUtil.isBlank(srchDrtenCd)
            && C_YuukousyoumetuKbn.BLNK.eq(srchyuukousyoumetukbn)
            && BizUtil.isBlank(srchtelno)
            && BizUtil.isBlank(srchtsinyno)
            && BizUtil.isBlank(srchKykNmKn)
            && BizUtil.isBlank(srchkyknmkj)
            && srchKykSeiYmd == null
            && BizUtil.isBlank(srchHhknnmkn)
            && BizUtil.isBlank(srchhhknnmkj)
            && srchHhknseiymd == null) {
            throw new BizLogicException(MessageId.EIA0034);
        }

        searchKeiyaku();

        setSearchResultListUiBean();

        uiBean.setSyoriKeiyuKbn(C_Syorikeiyu.SRCH);
    }

    public void searchKeiyaku() {
        YuyuBizConfig config = YuyuBizConfig.getInstance();
        uiBean.setKensakuResultMaxKensuu(config.getSearchResultMaxCnt());

        long srchMaxCnt = uiBean.getKensakuResultMaxKensuu();

        long resultCnt = hozenDomManager.getKeiyakuInfoCountByItems(
            uiBean.getSrchkykym(),
            uiBean.getSrchyuukousyoumetukbn(),
            uiBean.getSrchkyknmkn(),
            uiBean.getSrchkyknmkj(),
            uiBean.getSrchkykseiymd(),
            uiBean.getSrchtelno(),
            uiBean.getSrchtsinyno(),
            uiBean.getSrchhhknnmkn(),
            uiBean.getSrchhhknnmkj(),
            uiBean.getSrchhhknseiymd(),
            uiBean.getSrchdrtencd());

        if (resultCnt == 0) {
            throw new BizLogicException(MessageId.EBA0090);
        }
        if (resultCnt > srchMaxCnt) {
            throw new BizLogicException(MessageId.EBA0053, String.valueOf(srchMaxCnt));
        }

        List<KykInfosByKykymDrtencdItemsBean> srchResultLst = hozenDomManager.getKykInfosByKykymDrtencdItems(
            uiBean.getSrchkykym(),
            uiBean.getSrchdrtencd(),
            uiBean.getSrchyuukousyoumetukbn(),
            uiBean.getSrchkyknmkn(),
            uiBean.getSrchkyknmkj(),
            uiBean.getSrchkykseiymd(),
            uiBean.getSrchtelno(),
            uiBean.getSrchtsinyno(),
            uiBean.getSrchhhknnmkn(),
            uiBean.getSrchhhknnmkj(),
            uiBean.getSrchhhknseiymd());

        uiBean.setSrchResultLst(srchResultLst);
    }

    public void setSearchResultListUiBean() {
        List<KykInfosByKykymDrtencdItemsBean> rtKnskResult = null;

        rtKnskResult = uiBean.getSrchResultLst();
        if (rtKnskResult == null) {
            throw new BizLogicException(MessageId.EBA0054);
        }

        List<KensakuResultInfoDataSourceBean> kensakuResultInfoDataSourceBeanLst = new ArrayList<>();
        for (int cnt = 0; cnt < rtKnskResult.size(); cnt++) {
            KensakuResultInfoDataSourceBean kensakuResultInfoDataSourceBean = new KensakuResultInfoDataSourceBean();
            KykInfosByKykymDrtencdItemsBean kykInfosByKykymDrtencdItemsBean = rtKnskResult.get(cnt);

            kensakuResultInfoDataSourceBean.setDispsyono(kykInfosByKykymDrtencdItemsBean.getSyono());
            kensakuResultInfoDataSourceBean.setDispkyknmkn(kykInfosByKykymDrtencdItemsBean.getKyknmkn());
            kensakuResultInfoDataSourceBean.setDispkyknmkj(kykInfosByKykymDrtencdItemsBean.getKyknmkj());
            kensakuResultInfoDataSourceBean.setDispkykseiymd(kykInfosByKykymDrtencdItemsBean.getKykseiymd());
            kensakuResultInfoDataSourceBean.setDisptsintelno(kykInfosByKykymDrtencdItemsBean.getTsintelno());
            kensakuResultInfoDataSourceBean.setDispdai2tsintelno(kykInfosByKykymDrtencdItemsBean.getDai2tsintelno());
            kensakuResultInfoDataSourceBean.setDisphhknnmkn(kykInfosByKykymDrtencdItemsBean.getHhknnmkn());
            kensakuResultInfoDataSourceBean.setDisphhknnmkj(kykInfosByKykymDrtencdItemsBean.getHhknnmkj());
            kensakuResultInfoDataSourceBean.setDisphhknseiymd(kykInfosByKykymDrtencdItemsBean.getHhknseiymd());
            kensakuResultInfoDataSourceBean.setDispsyouhnnm(kykInfosByKykymDrtencdItemsBean.getSyouhnnm());
            kensakuResultInfoDataSourceBean.setDispyuukousyoumetukbn(kykInfosByKykymDrtencdItemsBean
                .getYuukousyoumetukbn());
            kensakuResultInfoDataSourceBeanLst.add(kensakuResultInfoDataSourceBean);
        }

        uiBean.setKensakuResultInfo(kensakuResultInfoDataSourceBeanLst);
    }

    public void setTtdkRirekiUiBean(KhozenCommonParam pKhozenCommonParam) {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);

        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);
    }

    public void setNyuukinRirekiUiBean(KhozenCommonParam pKhozenCommonParam) {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);

        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);
    }

    public void getTtdkRireki() {
        String syono = uiBean.getSyono();

        List<KhTtdkRirekiInfosBySyonoBean> kTKkTtdkRrkLst = hozenDomManager.getKhTtdkRirekiInfosBySyono(syono);

        uiBean.setKTKkTtdkRrkLst(kTKkTtdkRrkLst);
    }

    public void getNyuukinRireki(KhozenCommonParam pKhozenCommonParam) {
        String syono = uiBean.getSyono();
        BizDateYM jkiPJytYm = null;
        BizDate hrkKJt = null;
        BizDate yuuyoKknManryobi = null;
        BizDate nextAnnaiYoteiYmd = null;
        BizDate nextAnnaiYoteiKjYmd = null;

        IT_KykKihon kTKykKihon = pKhozenCommonParam.getKeiyakuKihon(syono);

        List<IT_KykSyouhn> kykSyouhnLst = pKhozenCommonParam.getKeiyakuSyouhin(syono, C_SyutkKbn.SYU);

        C_UmuKbn itijibaraiUmu = C_UmuKbn.NONE;
        if (C_Hrkkaisuu.ITIJI.eq(kTKykKihon.getHrkkaisuu())) {
            itijibaraiUmu = C_UmuKbn.ARI;
        }
        uiBean.setItijiDispUmu(itijibaraiUmu);

        IT_AnsyuKihon ansyuKihon = pKhozenCommonParam.getAnsyuuKihon(syono);
        jkiPJytYm = ansyuKihon.getJkipjytym();

        List<IT_AnsyuRireki> ansyuRirekiLst = khKeiyakuSyoukaiDao.getAnsyuRirekiBean3monthBySyono(uiBean.getSyono());

        String year = MessageUtil.getMessage(MessageId.IIW1010);
        String month = MessageUtil.getMessage(MessageId.IIW1011);

        for (int i = 0; i < ansyuRirekiLst.size(); i++) {
            String dispannaijyutoukaisuu = "";
            if (ansyuRirekiLst.get(i).getJyutoukaisuuy() != 0) {
                dispannaijyutoukaisuu = ansyuRirekiLst.get(i).getJyutoukaisuuy().toString() + year + "　";
            }
            if (ansyuRirekiLst.get(i).getJyutoukaisuum() != 0) {
                dispannaijyutoukaisuu = ansyuRirekiLst.get(i).getJyutoukaisuum().toString() + month;
            }

            if (i == 0) {
                uiBean.setAnnaiNo1(ansyuRirekiLst.get(i).getAnnaino());
                uiBean.setDispannaiym1(ansyuRirekiLst.get(i).getAnnaisakuseiymd().getBizDateYM());
                uiBean.setDispannaijyutoukaisuu1(dispannaijyutoukaisuu);
                uiBean.setDispannaigk1(ansyuRirekiLst.get(i).getRsgaku());
                uiBean.setDispannaijyutouym1(ansyuRirekiLst.get(i).getJyuutouym());
                uiBean.setDispannaikeiro1(ansyuRirekiLst.get(i).getNykkeiro());
                uiBean.setDispannaijkkbn1(ansyuRirekiLst.get(i).getAnnaijkkbn());
                uiBean.setHrkkeiro1(ansyuRirekiLst.get(i).getHrkkeiro());
                uiBean.setDispcredituragngjiyuukbn1(ansyuRirekiLst.get(i).getCredituriagengjiyuu());
                uiBean.setDisphurihunokbn1(ansyuRirekiLst.get(i).getHurihunokbn());
            } else if (i == 1) {
                uiBean.setAnnaiNo2(ansyuRirekiLst.get(i).getAnnaino());
                uiBean.setDispannaiym2(ansyuRirekiLst.get(i).getAnnaisakuseiymd().getBizDateYM());
                uiBean.setDispannaijyutoukaisuu2(dispannaijyutoukaisuu);
                uiBean.setDispannaigk2(ansyuRirekiLst.get(i).getRsgaku());
                uiBean.setDispannaijyutouym2(ansyuRirekiLst.get(i).getJyuutouym());
                uiBean.setDispannaikeiro2(ansyuRirekiLst.get(i).getNykkeiro());
                uiBean.setDispannaijkkbn2(ansyuRirekiLst.get(i).getAnnaijkkbn());
                uiBean.setHrkkeiro2(ansyuRirekiLst.get(i).getHrkkeiro());
                uiBean.setDispcredituragngjiyuukbn2(ansyuRirekiLst.get(i).getCredituriagengjiyuu());
                uiBean.setDisphurihunokbn2(ansyuRirekiLst.get(i).getHurihunokbn());
            } else if (i == 2) {
                uiBean.setAnnaiNo3(ansyuRirekiLst.get(i).getAnnaino());
                uiBean.setDispannaiym3(ansyuRirekiLst.get(i).getAnnaisakuseiymd().getBizDateYM());
                uiBean.setDispannaijyutoukaisuu3(dispannaijyutoukaisuu);
                uiBean.setDispannaigk3(ansyuRirekiLst.get(i).getRsgaku());
                uiBean.setDispannaijyutouym3(ansyuRirekiLst.get(i).getJyuutouym());
                uiBean.setDispannaikeiro3(ansyuRirekiLst.get(i).getNykkeiro());
                uiBean.setDispannaijkkbn3(ansyuRirekiLst.get(i).getAnnaijkkbn());
                uiBean.setHrkkeiro3(ansyuRirekiLst.get(i).getHrkkeiro());
                uiBean.setDispcredituragngjiyuukbn3(ansyuRirekiLst.get(i).getCredituriagengjiyuu());
                uiBean.setDisphurihunokbn3(ansyuRirekiLst.get(i).getHurihunokbn());
            } else if (i == 3) {
                uiBean.setAnnaiNo4(ansyuRirekiLst.get(i).getAnnaino());
                uiBean.setDispannaiym4(ansyuRirekiLst.get(i).getAnnaisakuseiymd().getBizDateYM());
                uiBean.setDispannaijyutoukaisuu4(dispannaijyutoukaisuu);
                uiBean.setDispannaigk4(ansyuRirekiLst.get(i).getRsgaku());
                uiBean.setDispannaijyutouym4(ansyuRirekiLst.get(i).getJyuutouym());
                uiBean.setDispannaikeiro4(ansyuRirekiLst.get(i).getNykkeiro());
                uiBean.setDispannaijkkbn4(ansyuRirekiLst.get(i).getAnnaijkkbn());
                uiBean.setHrkkeiro4(ansyuRirekiLst.get(i).getHrkkeiro());
                uiBean.setDispcredituragngjiyuukbn4(ansyuRirekiLst.get(i).getCredituriagengjiyuu());
                uiBean.setDisphurihunokbn4(ansyuRirekiLst.get(i).getHurihunokbn());
            } else if (i == 4) {
                uiBean.setAnnaiNo5(ansyuRirekiLst.get(i).getAnnaino());
                uiBean.setDispannaiym5(ansyuRirekiLst.get(i).getAnnaisakuseiymd().getBizDateYM());
                uiBean.setDispannaijyutoukaisuu5(dispannaijyutoukaisuu);
                uiBean.setDispannaigk5(ansyuRirekiLst.get(i).getRsgaku());
                uiBean.setDispannaijyutouym5(ansyuRirekiLst.get(i).getJyuutouym());
                uiBean.setDispannaikeiro5(ansyuRirekiLst.get(i).getNykkeiro());
                uiBean.setDispannaijkkbn5(ansyuRirekiLst.get(i).getAnnaijkkbn());
                uiBean.setHrkkeiro5(ansyuRirekiLst.get(i).getHrkkeiro());
                uiBean.setDispcredituragngjiyuukbn5(ansyuRirekiLst.get(i).getCredituriagengjiyuu());
                uiBean.setDisphurihunokbn5(ansyuRirekiLst.get(i).getHurihunokbn());
            } else if (i == 5) {
                uiBean.setAnnaiNo6(ansyuRirekiLst.get(i).getAnnaino());
                uiBean.setDispannaiym6(ansyuRirekiLst.get(i).getAnnaisakuseiymd().getBizDateYM());
                uiBean.setDispannaijyutoukaisuu6(dispannaijyutoukaisuu);
                uiBean.setDispannaigk6(ansyuRirekiLst.get(i).getRsgaku());
                uiBean.setDispannaijyutouym6(ansyuRirekiLst.get(i).getJyuutouym());
                uiBean.setDispannaikeiro6(ansyuRirekiLst.get(i).getNykkeiro());
                uiBean.setDispannaijkkbn6(ansyuRirekiLst.get(i).getAnnaijkkbn());
                uiBean.setHrkkeiro6(ansyuRirekiLst.get(i).getHrkkeiro());
                uiBean.setDispcredituragngjiyuukbn6(ansyuRirekiLst.get(i).getCredituriagengjiyuu());
                uiBean.setDisphurihunokbn6(ansyuRirekiLst.get(i).getHurihunokbn());
            } else if (i == 6) {
                uiBean.setAnnaiNo7(ansyuRirekiLst.get(i).getAnnaino());
                uiBean.setDispannaiym7(ansyuRirekiLst.get(i).getAnnaisakuseiymd().getBizDateYM());
                uiBean.setDispannaijyutoukaisuu7(dispannaijyutoukaisuu);
                uiBean.setDispannaigk7(ansyuRirekiLst.get(i).getRsgaku());
                uiBean.setDispannaijyutouym7(ansyuRirekiLst.get(i).getJyuutouym());
                uiBean.setDispannaikeiro7(ansyuRirekiLst.get(i).getNykkeiro());
                uiBean.setDispannaijkkbn7(ansyuRirekiLst.get(i).getAnnaijkkbn());
                uiBean.setHrkkeiro7(ansyuRirekiLst.get(i).getHrkkeiro());
                uiBean.setDispcredituragngjiyuukbn7(ansyuRirekiLst.get(i).getCredituriagengjiyuu());
                uiBean.setDisphurihunokbn7(ansyuRirekiLst.get(i).getHurihunokbn());
            } else if (i == 7) {
                uiBean.setAnnaiNo8(ansyuRirekiLst.get(i).getAnnaino());
                uiBean.setDispannaiym8(ansyuRirekiLst.get(i).getAnnaisakuseiymd().getBizDateYM());
                uiBean.setDispannaijyutoukaisuu8(dispannaijyutoukaisuu);
                uiBean.setDispannaigk8(ansyuRirekiLst.get(i).getRsgaku());
                uiBean.setDispannaijyutouym8(ansyuRirekiLst.get(i).getJyuutouym());
                uiBean.setDispannaikeiro8(ansyuRirekiLst.get(i).getNykkeiro());
                uiBean.setDispannaijkkbn8(ansyuRirekiLst.get(i).getAnnaijkkbn());
                uiBean.setHrkkeiro8(ansyuRirekiLst.get(i).getHrkkeiro());
                uiBean.setDispcredituragngjiyuukbn8(ansyuRirekiLst.get(i).getCredituriagengjiyuu());
                uiBean.setDisphurihunokbn8(ansyuRirekiLst.get(i).getHurihunokbn());
            } else if (i == 8) {
                uiBean.setAnnaiNo9(ansyuRirekiLst.get(i).getAnnaino());
                uiBean.setDispannaiym9(ansyuRirekiLst.get(i).getAnnaisakuseiymd().getBizDateYM());
                uiBean.setDispannaijyutoukaisuu9(dispannaijyutoukaisuu);
                uiBean.setDispannaigk9(ansyuRirekiLst.get(i).getRsgaku());
                uiBean.setDispannaijyutouym9(ansyuRirekiLst.get(i).getJyuutouym());
                uiBean.setDispannaikeiro9(ansyuRirekiLst.get(i).getNykkeiro());
                uiBean.setDispannaijkkbn9(ansyuRirekiLst.get(i).getAnnaijkkbn());
                uiBean.setHrkkeiro9(ansyuRirekiLst.get(i).getHrkkeiro());
                uiBean.setDispcredituragngjiyuukbn9(ansyuRirekiLst.get(i).getCredituriagengjiyuu());
                uiBean.setDisphurihunokbn9(ansyuRirekiLst.get(i).getHurihunokbn());
            }
        }

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        kykKihon = IT_KykKihonDetacher.detachNyknJissekiRirekitouched(kykKihon);
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        nyknJissekiRirekiLst = new SortIT_NyknJissekiRireki().OrderIT_NyknJissekiRirekiByPkDesc(nyknJissekiRirekiLst);

        if (C_UmuKbn.ARI.eq(itijibaraiUmu)) {
            jkiPJytYm = null;
        }
        else {
            SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);

            setYuuyokknmanryobi.exec(syono, jkiPJytYm);
            yuuyoKknManryobi = setYuuyokknmanryobi.getTksnYuuyokknMnrybi();

            hrkKJt = jkiPJytYm.getLastDay();

            if (BizDateUtil.compareYm(jkiPJytYm, BizDate.getSysDate().getBizDateYM()) == BizDateUtil.COMPARE_GREATER) {
                nextAnnaiYoteiKjYmd = BizDate.valueOf(jkiPJytYm, 1);
            }
            else {
                nextAnnaiYoteiKjYmd = BizDate.getSysDate();
            }

            if(C_Hrkkeiro.KOUHURI.eq(kTKykKihon.getHrkkeiro())){
                SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

                setHurikaebi.exec(nextAnnaiYoteiKjYmd);
                nextAnnaiYoteiYmd = setHurikaebi.getTyokugoAnnaibi();

            }
            else if(C_Hrkkeiro.CREDIT.eq(kTKykKihon.getHrkkeiro())){
                SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector
                    .getInstance(SetCreditUriageSeikyuubi.class);

                setCreditUriageSeikyuubi.exec(nextAnnaiYoteiKjYmd);
                nextAnnaiYoteiYmd = setCreditUriageSeikyuubi.getJikaiUrsktysytbi();
            }
        }
        uiBean.setDispjkipjytym(jkiPJytYm);

        if (C_Kykjyoutai.ZENNOU.eq(kykSyouhnLst.get(0).getKykjyoutai())) {
            uiBean.setHrkkjt(null);
            uiBean.setYykknmnryymd(null);
            uiBean.setNextannaiyoteiymd(null);
        } else {
            uiBean.setHrkkjt(hrkKJt);
            uiBean.setYykknmnryymd(yuuyoKknManryobi);
            if (BizDateUtil.compareYmd(yuuyoKknManryobi, nextAnnaiYoteiYmd) == BizDateUtil.COMPARE_LESSER) {
                uiBean.setNextannaiyoteiymd(null);
            } else {
                uiBean.setNextannaiyoteiymd(nextAnnaiYoteiYmd);
            }
        }

        setKawaserateTuutiNaiyouInfo(pKhozenCommonParam);
    }

    private void setKawaserateTuutiNaiyouInfo(KhozenCommonParam pKhozenCommonParam) {

        C_DispKbn kawaserateDispKbn = C_DispKbn.HIHYOUJI;
        C_KahiKbn kawaserateKahiKbn = C_KahiKbn.HUKA;
        String yenkansanhokenryou = "";
        String kktikawaserate ="";
        String rstuukasyu = "";
        String kyktuukasyu = "";
        String knsnkijyunymd = "";
        String kwsrtinfomessage1 = "";
        String kwsrtinfomessage2 = "";

        List<IT_KykSyouhn> kykSyouhnLst = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);
        IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);

        IT_KykSonotaTkyk kykSonotaTkyk = pKhozenCommonParam.getSonotaTokuyaku(uiBean.getSyono());

        if (C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhn.getYuukousyoumetukbn()) &&
            C_Kykjyoutai.HRKMTYUU.eq(kykSyouhn.getKykjyoutai()) &&
            C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu()) &&
            C_YennykntksyuruiKbn.PYENHRKM_GKHENDOU.eq(kykSonotaTkyk.getYennyknsyuruikbn())) {

            kawaserateDispKbn = C_DispKbn.HYOUJI;

            IT_AnsyuKihon ansyuKihon = pKhozenCommonParam.getAnsyuuKihon(uiBean.getSyono());

            BizDateYM jkipjytym = ansyuKihon.getJkipjytym();

            KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);

            IT_KykKihon kykKihon = pKhozenCommonParam.getKeiyakuKihonInfo(uiBean.getSyono());

            Integer jyuutounensuu = 0;
            Integer jyuutoutukisuu = 0;
            if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {
                jyuutounensuu = 1;
            }

            if (C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {
                jyuutoutukisuu = 6;
            }
            else if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {
                jyuutoutukisuu = 1;
            }

            C_ErrorKbn errorKbn = keisanRsgaku.exec(
                kykKihon,
                C_Nykkeiro.OTHER,
                C_NyknaiyouKbn.KEIZOKUP,
                BizDate.getSysDate(),
                BizDate.getSysDate().getBizDateYM(),
                jyuutounensuu,
                jyuutoutukisuu);

            if (C_ErrorKbn.OK.eq(errorKbn)) {
                KeisanRsgkOutBean keisanRsgkOutBean = keisanRsgaku.getKeisanRsgkOutBean();
                BizCurrency rsgakuGoukei =  keisanRsgkOutBean.getRsgakuGoukei();
                List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanLst = keisanRsgkOutBean.getKeisanRsgkUtiwakeBeanLst();
                yenkansanhokenryou =  BizUtil.comma(rsgakuGoukei.toString()) + " 円";

                if (keisanRsgkUtiwakeBeanLst != null && keisanRsgkUtiwakeBeanLst.size() > 0) {
                    kktikawaserate = keisanRsgkUtiwakeBeanLst.get(0).getRyosyukwsrate().toString();
                    BizDate ryosyukwsratekjymd = keisanRsgkUtiwakeBeanLst.get(0).getRyosyukwsratekjymd();

                    knsnkijyunymd = String.valueOf(ryosyukwsratekjymd.getYear()) + "/" +
                        Strings.padStart(String.valueOf(ryosyukwsratekjymd.getMonth()), 2, '0') + "/" +
                        Strings.padStart(String.valueOf(ryosyukwsratekjymd.getDay()), 2, '0');
                }

                GetasPRsTuuka getasPRsTuuka = SWAKInjector.getInstance(GetasPRsTuuka.class);
                getasPRsTuuka.exec(uiBean.getSyono());

                rstuukasyu = getasPRsTuuka.getRstuukasyu().getContent();

                kyktuukasyu = kykSyouhn.getKyktuukasyu().getContent();

                if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu()) || C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {
                    if (BizDateUtil.compareYm(
                        jkipjytym, BizDate.getSysDate().getBizDateYM()) != BizDateUtil.COMPARE_GREATER &&
                        BizDateUtil.compareYmd(BizDate.getSysDate(),
                            uiBean.getYykknmnryymd()) != BizDateUtil.COMPARE_GREATER) {
                        kawaserateKahiKbn = C_KahiKbn.KA;
                        kwsrtinfomessage1 = DISP_MESSAGE1;
                    }
                    else {
                        kawaserateKahiKbn = C_KahiKbn.HUKA;
                        kwsrtinfomessage2 = DISP_MESSAGE2;
                    }
                }
                else if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {
                    kawaserateKahiKbn = C_KahiKbn.KA;
                    kwsrtinfomessage1 = DISP_MESSAGE1;
                }
            }
            else {
                kawaserateKahiKbn = C_KahiKbn.HUKA;
                kwsrtinfomessage2 = MessageUtil.getMessage(MessageId.EIA3055, keisanRsgaku.getErrorRiyuu());
            }

            if ( C_KahiKbn.HUKA.eq(kawaserateKahiKbn)) {
                yenkansanhokenryou = "＊＊＊＊＊＊＊＊＊　円" ;
                kktikawaserate = "＊＊＊＊＊";
                rstuukasyu = "";
                kyktuukasyu = "";
                knsnkijyunymd = "＊＊＊＊＊＊＊＊";
            }
        }

        uiBean.setKawaserateDispKbn(kawaserateDispKbn);
        uiBean.setKawaserateKahiKbn(kawaserateKahiKbn);
        uiBean.setDispyenhokenryou(yenkansanhokenryou);
        uiBean.setKwsrtinfokakuteikwsrate(kktikawaserate);
        uiBean.setKwsrtinforstuukasyu(rstuukasyu);
        uiBean.setKwsrtinfokyktuukasyu(kyktuukasyu);
        uiBean.setKwsrtinfoknsnkijyunymd(knsnkijyunymd);
        uiBean.setKwsrtinfomessage1(kwsrtinfomessage1);
        uiBean.setKwsrtinfomessage2(kwsrtinfomessage2);
    }

    public void setNyuukinRirekiListUiBean(KhozenCommonParam pKhozenCommonParam) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());
        kykKihon = IT_KykKihonDetacher.detachNyknJissekiRirekitouched(kykKihon);
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        nyknJissekiRirekiLst = new SortIT_NyknJissekiRireki().OrderIT_NyknJissekiRirekiByPkDesc(nyknJissekiRirekiLst);

        if (nyknJissekiRirekiLst == null) {
            throw new BizLogicException(MessageId.EBA0054);
        }

        List<NyuukinRirekiInfoDataSourceBean> nyuukinRirekiInfo = new ArrayList<>();

        List<IT_KykSyouhn> kykSyouhnLst = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);

        C_Tuukasyu hnkmaeKeiyakuTuukasyu = null;

        if (kykSyouhnLst.get(0).getYendthnkymd() == null) {
            hnkmaeKeiyakuTuukasyu = kykSyouhnLst.get(0).getKyktuukasyu();
        }
        else {
            IT_KykSyouhnHnkmae kykSyouhnHnkmae = hozenDomManager.getKykSyouhnHnkmaeBySyono(uiBean.getSyono());
            if (kykSyouhnHnkmae != null) {
                hnkmaeKeiyakuTuukasyu = kykSyouhnHnkmae.getKyktuukasyu();
            }
        }

        String year = MessageUtil.getMessage(MessageId.IIW1010);
        String month = MessageUtil.getMessage(MessageId.IIW1011);

        String itijiHarai = MessageUtil.getMessage(MessageId.IIW0002);

        for (IT_NyknJissekiRireki nyknJissekiRireki : nyknJissekiRirekiLst) {
            NyuukinRirekiInfoDataSourceBean nyuukinRirekiInfoDataSourceBean = new NyuukinRirekiInfoDataSourceBean();
            String jyutoukaisuu = "";
            if (C_UmuKbn.ARI.eq(uiBean.getItijiDispUmu())) {
                jyutoukaisuu = itijiHarai;
            }
            else {
                if (nyknJissekiRireki.getJyutoukaisuuy() != 0) {
                    jyutoukaisuu = nyknJissekiRireki.getJyutoukaisuuy().toString() + year + "　";
                }
                if (nyknJissekiRireki.getJyutoukaisuum() != 0) {
                    jyutoukaisuu = nyknJissekiRireki.getJyutoukaisuum().toString() + month;
                }
            }

            nyuukinRirekiInfoDataSourceBean.setDispryosyuymd(nyknJissekiRireki.getRyosyuymd());
            nyuukinRirekiInfoDataSourceBean.setDispnykkeiro(nyknJissekiRireki.getNykkeiro());
            nyuukinRirekiInfoDataSourceBean.setDispjyuutouym(nyknJissekiRireki.getJyutoustartym());
            nyuukinRirekiInfoDataSourceBean.setDispjyutoukaisuu(jyutoukaisuu);
            nyuukinRirekiInfoDataSourceBean.setDisphrkp(nyknJissekiRireki.getHrkp());
            nyuukinRirekiInfoDataSourceBean.setDisprskingaku(nyknJissekiRireki.getRsgaku());
            nyuukinRirekiInfoDataSourceBean.setDispkawaserate(nyknJissekiRireki.getRyosyukwsrate());
            nyuukinRirekiInfoDataSourceBean.setDisprstuukasyu(nyknJissekiRireki.getRstuukasyu());
            nyuukinRirekiInfoDataSourceBean.setDispkyktuukasyu(hnkmaeKeiyakuTuukasyu);
            nyuukinRirekiInfoDataSourceBean.setDispnyktrks(nyknJissekiRireki.getNyktrksflg());

            nyuukinRirekiInfo.add(nyuukinRirekiInfoDataSourceBean);
        }
        uiBean.setNyuukinRirekiInfo(nyuukinRirekiInfo);
    }

    public void getTtdkSyousai(KhozenCommonParam pKhozenCommonParam) {

        String syoNo = uiBean.getSyono();
        TetudukiRirekiListDataSourceBean tetudukiRirekiListDataSourceBeanSelect = uiBean
            .getTetudukiRirekiListDataSource().getSelectedBean();
        String henkousikibetukey = tetudukiRirekiListDataSourceBeanSelect.getHenkouSikibetuKey();

        List<KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean> kTKkTtdkRrk = hozenDomManager
            .getKhTtdkRirekiInfoBySyonoHenkousikibetukey(syoNo, henkousikibetukey);

        if (kTKkTtdkRrk.size() > 0) {
            IT_KhTtdkRireki khTtdkRireki = kTKkTtdkRrk.get(0).getIT_KhTtdkRireki();
            AS_Kinou kinouFromDB = kTKkTtdkRrk.get(0).getAS_Kinou();
            AM_User user = kTKkTtdkRrk.get(0).getAM_User();
            uiBean.setSyoriYmd(khTtdkRireki.getSyoriYmd());

            C_SyoriKbn syoriKbn = khTtdkRireki.getSyorikbn();
            String syoriKbnNm = "";
            if (C_SyoriKbn.BLNK.eq(syoriKbn)) {
                uiBean.setSyorinaiyou(kinouFromDB.getKinouNm());
            }
            else {
                syoriKbnNm = C_SyoriKbn.getContentByValue(C_SyoriKbn.PATTERN_SYOUKAI, syoriKbn.getValue());
                uiBean.setSyorinaiyou(kinouFromDB.getKinouNm() + "（" + syoriKbnNm + "）");
            }

            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(khTtdkRireki.getSyorisosikicd(), null);

            uiBean.setSyorisosikinm(bzGetSosikiDataBean.getKanjisosikinm20());
            uiBean.setShrSyousaiUmu(khTtdkRireki.getShrsyousaiumu());
            uiBean.setSyoriKbn(khTtdkRireki.getSyorikbn());
            uiBean.setHenkouRrkUmu(khTtdkRireki.getHenkourrkumu());
            uiBean.setGyoumuyouKousinKinouId(khTtdkRireki.getGyoumuKousinKinou());

            if (user == null || BizUtil.isBlank(user.getUserNm())) {
                uiBean.setSyoritntnmkj("");
            }
            else {
                uiBean.setSyoritntnmkj(user.getUserNm());
            }
        }
        else {
            throw new CommonBizAppException("契約管理手続履歴TBLからレコードが取得できません。  証券番号 =" + syoNo + " 変更識別キー="
                + henkousikibetukey);
        }

        List<HenkounaiyouListDataSourceBean> henkounaiyouList = new ArrayList<>();
        if (C_UmuKbn.ARI.eq(tetudukiRirekiListDataSourceBeanSelect.getHenkouRrkUmu())) {
            List<IT_KhHenkouRireki> KhHenkouRirekiLst = hozenDomManager.getKykKihon(syoNo)
                .getKhTtdkRirekiByHenkousikibetukey(henkousikibetukey).getKhHenkouRirekis();

            if (KhHenkouRirekiLst.size() > 0) {
                for (IT_KhHenkouRireki khHenkouRireki : KhHenkouRirekiLst) {
                    HenkounaiyouListDataSourceBean henkounaiyouListDataSourceBean = new HenkounaiyouListDataSourceBean();
                    henkounaiyouListDataSourceBean.setDisphnkkbn(khHenkouRireki.getHnksyuruikbn());
                    henkounaiyouListDataSourceBean.setDisphanbetukoumokunm(khHenkouRireki.getHanbetukoumokunm());
                    henkounaiyouListDataSourceBean.setDisphenkoukoumokunm(khHenkouRireki.getHenkoukoumokunm());
                    henkounaiyouListDataSourceBean.setDispbfrnaiyou(khHenkouRireki.getBfrnaiyou());
                    henkounaiyouListDataSourceBean.setDispnewnaiyou(khHenkouRireki.getNewnaiyou());
                    henkounaiyouList.add(henkounaiyouListDataSourceBean);
                }
            }

            if (KhHenkouRirekiLst.size() == 0) {
                throw new CommonBizAppException("契約管理変更履歴TBLからレコードが取得できません。  証券番号 =" + syoNo + " 変更識別キー="
                    + henkousikibetukey);
            }

            uiBean.setHenkounaiyouList(henkounaiyouList);
        }

        List<IT_KihrkmpSeisanRireki> kihrkmpSeisanRirekiLst =
            khKeiyakuSyoukaiDao.getKihrkmpSeisanRirekiBySyonoHenkousikibetukeyKiharaiPseisanNaiyouKbn(
                uiBean.getSyono(), henkousikibetukey, C_KiharaiPseisanNaiyouKbn.TUITYOUKIN);

        List<IT_KykSyouhn> kykSyouhnLst = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);
        IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);

        if (kihrkmpSeisanRirekiLst.size() > 0) {
            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki = kihrkmpSeisanRirekiLst.get(0);
            uiBean.setDispyentuikahrkkin(kihrkmpSeisanRireki.getYenkansantuityoukin());
            uiBean.setDisptuikahrkkin(kihrkmpSeisanRireki.getTuityouk());
            uiBean.setDispnyknjikwsratetkyymd(kihrkmpSeisanRireki.getZeimukwsratekjnymd());
            uiBean.setDispnyknjikwsrate(kihrkmpSeisanRireki.getZeimukwsrate());
            uiBean.setKyktuukasyu(kykSyouhn.getKyktuukasyu());
        }

        if (IKhozenCommonConstants.KINOUID_MEIGIHENKOU.equals(uiBean.getGyoumuyouKousinKinouId())) {
            IT_KykSyaHenkouRireki kykSyaHenkouRireki = hozenDomManager.getKysSyaHenkouRireki(syoNo, henkousikibetukey);
            if (kykSyaHenkouRireki != null) {
                if (C_Meigihnkjiyuu.KYKSB.eq(kykSyaHenkouRireki.getMeigihnkjiyuu())
                    || C_Meigihnkjiyuu.KYK.eq(kykSyaHenkouRireki.getMeigihnkjiyuu())) {
                    uiBean.setTsinyno(kykSyaHenkouRireki.getTsinyno());
                    uiBean.setTsinadr1kj(kykSyaHenkouRireki.getTsinadr1kj());
                    uiBean.setTsinadr2kj(kykSyaHenkouRireki.getTsinadr2kj());
                    uiBean.setTsinadr3kj(kykSyaHenkouRireki.getTsinadr3kj());
                    uiBean.setTsintelno(kykSyaHenkouRireki.getTsintelno());
                    uiBean.setDai2tsintelno(kykSyaHenkouRireki.getDai2tsintelno());
                    uiBean.setMeigiHnkJiyuu(kykSyaHenkouRireki.getMeigihnkjiyuu());
                    if (C_Meigihnkjiyuu.KYKSB.eq(kykSyaHenkouRireki.getMeigihnkjiyuu())) {
                        uiBean.setYenkaiyakuhrstgk(kykSyaHenkouRireki.getYenkaiyakuhrstgk());
                        uiBean.setZeimukwsratekjnymd(kykSyaHenkouRireki.getYenkansantkykwsrateymd());
                        uiBean.setZeimukwsrate(kykSyaHenkouRireki.getYenkansantkykwsrate());
                        uiBean.setZeimukyktuukasyu(kykSyaHenkouRireki.getKyktuukasyu());
                        uiBean.setKihrkmpsgk(kykSyaHenkouRireki.getKihrkmpsgk());
                        uiBean.setOldkykkihrkmp(kykSyaHenkouRireki.getOldkykkihrkmp());
                    }
                }
            }
            uiBean.setKinouHyoujiptnKbn(C_HyoujiptnKbn.MEIGIHENKOU);
        }

        if (C_UmuKbn.ARI.eq(tetudukiRirekiListDataSourceBeanSelect.getShrRrkUmu())) {
            List<KhShrRirekiInfosBySyonoHenkousikibetukeyBean> kTKkShrRrkLst = hozenDomManager
                .getKhShrRirekiInfosBySyonoHenkousikibetukey(syoNo, henkousikibetukey);

            List<IT_KhShrRirekiDetail> shrRirekiDetailList = kTKkShrRrkLst.get(0).getIT_KhShrRireki()
                .getKhShrRirekiDetails();

            if (kTKkShrRrkLst.size() > 0) {
                C_SyoriKbn syorikbn = kTKkTtdkRrk.get(0).getIT_KhTtdkRireki().getSyorikbn();

                if (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(uiBean.getGyoumuyouKousinKinouId())) {
                    if (C_SyoriKbn.KYKTORIKESI.eq(syorikbn)) {
                        uiBean.setKyktrkskbn(C_KyktrksKbn.KYKTORIKESI);
                    }
                    else if (C_SyoriKbn.CLGOFF.eq(syorikbn)) {
                        uiBean.setKyktrkskbn(C_KyktrksKbn.CLGOFF);
                    }
                    else if (C_SyoriKbn.KAIJO.eq(syorikbn)) {
                        uiBean.setKyktrkskbn(C_KyktrksKbn.KAIJO);
                    }
                    else if (C_SyoriKbn.MUKOU.eq(syorikbn)) {
                        uiBean.setKyktrkskbn(C_KyktrksKbn.MUKOU);
                    }
                    else if (C_SyoriKbn.SBKAIJO.eq(syorikbn)) {
                        uiBean.setKyktrkskbn(C_KyktrksKbn.SBKAIJO);
                    }
                    else if (C_SyoriKbn.SBMENSEKI.eq(syorikbn)) {
                        uiBean.setKyktrkskbn(C_KyktrksKbn.SBMENSEKI);
                    }
                    else if (C_SyoriKbn.SBMUKOU_KIHRKPSHR.eq(syorikbn)) {
                        uiBean.setKyktrkskbn(C_KyktrksKbn.SBMUKOU_KIHARAIP);
                    }
                    else {
                        uiBean.setKyktrkskbn(null);
                    }
                }
                else {
                    uiBean.setKyktrkskbn(null);
                }

                IT_KhShrRireki khShrRireki = kTKkShrRrkLst.get(0).getIT_KhShrRireki();

                BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

                BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(khShrRireki.getBankcd(),
                    khShrRireki.getSitencd(), BizDate.getSysDate());

                uiBean.setYenshrtkumu(khShrRireki.getYenshrtkumu());
                uiBean.setSoukinsakinmkn(khShrRireki.getSoukinsakinmkn());
                uiBean.setSoukinsakinmkj(khShrRireki.getSoukinsakinmkj());
                uiBean.setSoukinsakiyno(khShrRireki.getSoukinsakiyno());
                uiBean.setSoukinsakiadr1kj(khShrRireki.getSoukinsakiadr1kj());
                uiBean.setSoukinsakiadr2kj(khShrRireki.getSoukinsakiadr2kj());
                uiBean.setSoukinsakiadr3kj(khShrRireki.getSoukinsakiadr3kj());
                uiBean.setKyksyaszknmkn(khShrRireki.getKyksyaszknmkn());
                uiBean.setKyksyaszknmkj(khShrRireki.getKyksyaszknmkj());
                uiBean.setKyksyaszkyno(khShrRireki.getKyksyaszkyno());
                uiBean.setKyksyaszkadr1kj(khShrRireki.getKyksyaszkadr1kj());
                uiBean.setKyksyaszkadr2kj(khShrRireki.getKyksyaszkadr2kj());
                uiBean.setKyksyaszkadr3kj(khShrRireki.getKyksyaszkadr3kj());
                uiBean.setSaikennmkj(khShrRireki.getSaikennmkj());
                uiBean.setSaikennyno(khShrRireki.getSaikennyno());
                uiBean.setSaikenadr1kj(khShrRireki.getSaikenadr1kj());
                uiBean.setSaikenadr2kj(khShrRireki.getSaikenadr2kj());
                uiBean.setSaikenadr3kj(khShrRireki.getSaikenadr3kj());
                uiBean.setKzsyuruikbn(khShrRireki.getKzsyuruikbn());
                uiBean.setInputshrhousiteikbn(khShrRireki.getInputshrhousiteikbn());
                uiBean.setBankcd(khShrRireki.getBankcd());
                uiBean.setBanknmkj(bzGetBankDataBean.getBankNmKj());
                uiBean.setSitencd(khShrRireki.getSitencd());
                uiBean.setSitennmkj(bzGetBankDataBean.getSitenNmKj());
                uiBean.setYokinkbn(khShrRireki.getYokinkbn());
                uiBean.setKouzano(khShrRireki.getKouzano());
                uiBean.setKzdoukbn(khShrRireki.getKzdoukbn());
                uiBean.setKzmeiginmkn(khShrRireki.getKzmeiginmkn());
                uiBean.setKykmnmeigibangou(khShrRireki.getKykmnmeigibangou());
                uiBean.setUktmnmeigibangou(khShrRireki.getUktmnmeigibangou());
                uiBean.setSyoriKbn(syorikbn);

                String tienrskkisanymdnissuu = KhozenEdit.editTienRkksanhi(
                    khShrRireki.getShrhousiteikbn(),
                    khShrRireki.getShrtuukashrtienrsk(),
                    khShrRireki.getShrtienrskkisanymd(),
                    khShrRireki.getTienrsknissuu());

                int syohinHanteiKbn = SyouhinUtil.hantei(pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(),
                    C_SyutkKbn.SYU).get(0).getSyouhncd());

                uiBean.setSyohinHanteiKbn(syohinHanteiKbn);

                C_UmuKbn kaiyakuKoujyorituTekiUmu = kTKkShrRrkLst.get(0).getBM_SyouhnZokusei()
                    .getKaiyakukoujyoritutekiumu();
                C_UmuKbn mvaTekiUmu = kTKkShrRrkLst.get(0).getBM_SyouhnZokusei().getMvatekiumu();

                uiBean.setKaiyakukoujyoritutekiumu(kaiyakuKoujyorituTekiUmu);
                uiBean.setMvatekiumu(mvaTekiUmu);
                uiBean.setHeijyunbaraiumu(kTKkShrRrkLst.get(0).getBM_SyouhnZokusei().getHeijyunbaraiumu());
                uiBean.setItijibrumu(kTKkShrRrkLst.get(0).getBM_SyouhnZokusei().getItijibrumu());

                if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(uiBean.getGyoumuyouKousinKinouId())
                    || IKhozenCommonConstants.KINOUID_GENGAKU.equals(uiBean.getGyoumuyouKousinKinouId())
                    || IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(uiBean.getGyoumuyouKousinKinouId())
                    || (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(uiBean.getGyoumuyouKousinKinouId()) &&
                        C_SyoriKbn.JIDOUSOUKINSEISANZUMI.eq(uiBean.getSyoriKbn()))
                        || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())
                        || C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {

                    if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(uiBean.getGyoumuyouKousinKinouId())
                        || IKhozenCommonConstants.KINOUID_GENGAKU.equals(uiBean.getGyoumuyouKousinKinouId())
                        || IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(uiBean.getGyoumuyouKousinKinouId())) {
                        uiBean.setSyoruiukeymd(khShrRireki.getSyoruiukeymd());
                    }
                    uiBean.setShrymd(khShrRireki.getShrymd());
                    uiBean.setShrgkgoukeikakunin(khShrRireki.getShrtuukashrgkgoukei());
                    uiBean.setKaiyakuhr(khShrRireki.getShrtuukasyushrgkkei());
                    uiBean.setMikeikap(khShrRireki.getMikeikap());
                    uiBean.setZennouseisankin(khShrRireki.getZennomikeikap());
                    uiBean.setAzukarikinkykhnkkaiyakuhr(khShrRireki.getZitkazukarikingksiteituuka());
                    uiBean.setSonotashrgk(khShrRireki.getShrtuukasonotashrkngk());
                    uiBean.setGstszeigk(khShrRireki.getShrtuukagstszeigk().multiply(-1));
                    uiBean.setGsbunritaisyou(khShrRireki.getGsbunritaisyou());
                    uiBean.setSntshrgksssonotashrgk(khShrRireki.getSonotashrkngksiteituuka());
                    uiBean.setSntshrgkssgikshrratetekiymd(khShrRireki.getGaikashrkwsratekjnymd());
                    uiBean.setSntshrgkssgikshrrate(khShrRireki.getGaikashrkwsrate());
                    uiBean.setSntshrgkssgikshrkyktuukasyu(khShrRireki.getKyktuukasyu());
                    uiBean.setSntshrgkssyensonotashrgk(khShrRireki.getSonotashrkngkyen());
                    uiBean.setSntshrgkssyenkamikeikap(khShrRireki.getYenmikeikap());
                    uiBean.setSntshrgkssyenzennousisnkgk(khShrRireki.getYenzennomikeikap());
                    uiBean.setSntshrgkssyenazukarikin(khShrRireki.getZitkazukarikingkyen());
                    uiBean.setSntshrgkssyenhaitoukin(khShrRireki.getYenkansanhaitoukin());
                    uiBean.setSntshrgkssyentkbthaitoukin(khShrRireki.getYensonotahaitoukin());
                    uiBean.setSntshrgkssyenkakrkgk(khShrRireki.getYenkrkgk());
                    uiBean.setJpyshrgkgoukeikakunin(khShrRireki.getShrtuukashrgkgoukei());
                    uiBean.setJpykaiyakuhr(khShrRireki.getShrtuukakaiyakuhrkngkkei());
                    uiBean.setYenkamikeikap(khShrRireki.getYenmikeikap());
                    uiBean.setYenkazennouseisankgk(khShrRireki.getYenzennomikeikap());
                    uiBean.setYenkaazukarikingk(khShrRireki.getZitkazukarikingkyen());
                    uiBean.setYenkahaitoukin(khShrRireki.getYenkansanhaitoukin());
                    uiBean.setYentkbthaitoukin(khShrRireki.getYensonotahaitoukin());
                    uiBean.setYenkakrkgk(khShrRireki.getYenkrkgk());
                    uiBean.setJpygstszeigk(khShrRireki.getShrtuukagstszeigk().multiply(-1));
                    uiBean.setShrsyousaikaiyakuhr(khShrRireki.getSyushrgkkei());
                    uiBean.setShrsyousaijpykaiyakuhr(khShrRireki.getShrtuukasyushrgkkei());
                    uiBean.setYenshrratetekiymd(khShrRireki.getShrkwsratekjnymd());
                    uiBean.setYenshrrate(khShrRireki.getShrkwsrate());
                    uiBean.setShrkyktuukasyu(khShrRireki.getKyktuukasyu());
                    uiBean.setYenkiykhrssyenkiykhrgoukei(khShrRireki.getKaiyakuhrkngkkeiyen());
                    uiBean.setYenkiykhrssyenshrratetkymd(khShrRireki.getShrkwsratekjnymd());
                    uiBean.setYenkiykhrssyenshrratete(khShrRireki.getShrkwsrate());
                    uiBean.setYenkiykhrssshrkyktuukasyu(khShrRireki.getKyktuukasyu());
                    uiBean.setYenkiykhrsskaiyakuhrgoukei(khShrRireki.getKaiyakuhrkngkkeisiteituuka());
                    uiBean.setYenkiykhrsskaiyakuhryen(khShrRireki.getSyushrgkkei());
                    uiBean.setYenkiykhrssmikeikap(khShrRireki.getMikeikap());
                    uiBean.setYenkiykhrsszennouseisankin(khShrRireki.getZennomikeikap());
                    uiBean.setYenkiykhrsskykhnkkaiyakuhr(khShrRireki.getZitkazukarikingksiteituuka());

                    uiBean.setYendthnkshrgkgoukei(khShrRireki.getShrtuukashrgkgoukei());
                    uiBean.setYendthnkkaiyakuhr(khShrRireki.getShrtuukasyushrgkkei());
                    uiBean.setYendthnkmikeikap(khShrRireki.getYenmikeikap());
                    uiBean.setYendthnkzennouseisankin(khShrRireki.getYenzennomikeikap());
                    uiBean.setYendthnkhaitoukin(khShrRireki.getYenkansanhaitoukin());
                    uiBean.setYendthnktkbthaitoukin(khShrRireki.getYensonotahaitoukin());
                    uiBean.setYendthnkkrkgk(khShrRireki.getYenkrkgk());
                    uiBean.setSonotaseisan(khShrRireki.getShrtuukasonotaseisangk());
                    uiBean.setYendthnkgstszeigk(khShrRireki.getShrtuukagstszeigk().multiply(-1));
                    uiBean.setDispyendttienrskksnbinissuu(tienrskkisanymdnissuu);

                    if (C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(khShrRireki.getShrhousiteikbn())) {
                        uiBean.setYendthnkshrtienrsk(BizCurrency.optional());
                    }
                    else {
                        uiBean.setYendthnkshrtienrsk(khShrRireki.getShrtuukashrtienrsk());
                    }

                    if (!IKhozenCommonConstants.KINOUID_GENGAKU.equals(uiBean.getGyoumuyouKousinKinouId())) {
                        uiBean.setPtumitatekinssptumitatekin(shrRirekiDetailList.get(0).getTeiritutmttkngk().
                            add(shrRirekiDetailList.get(0).getSisuurendoutmttkngk()));
                        uiBean.setTeiritutmttkngk(shrRirekiDetailList.get(0).getTeiritutmttkngk());
                        uiBean.setSisuurendoutmttkngk(shrRirekiDetailList.get(0).getSisuurendoutmttkngk());

                    }

                    uiBean.setKiykhrsyousaikaiyakuhr(khShrRireki.getSyushrgkkei());
                    uiBean.setSynykngk(khShrRireki.getYensynykngk());
                    uiBean.setZeimukwsratekjnymd(khShrRireki.getZeimukwsratekjnymd());
                    uiBean.setZeimukwsrate(khShrRireki.getZeimukwsrate());
                    uiBean.setZeimukyktuukasyu(khShrRireki.getKyktuukasyu());
                    uiBean.setHtykeihi(khShrRireki.getYenhtykeihi());
                    uiBean.setGststaisyousaeki(khShrRireki.getYenkztgk());
                    uiBean.setZeimugstszeigk(khShrRireki.getYengstszeigk());
                    uiBean.setDisptienrskkisanymdnissuu(tienrskkisanymdnissuu);
                    uiBean.setDispjptienrskkisanymdnissuu(tienrskkisanymdnissuu);

                    if (C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(khShrRireki.getShrhousiteikbn())) {
                        uiBean.setShrtienrsk(BizCurrency.optional());
                        uiBean.setJpyshrtienrsk(BizCurrency.optional());
                    }
                    else {
                        uiBean.setShrtienrsk(khShrRireki.getShrtuukashrtienrsk());
                        uiBean.setJpyshrtienrsk(khShrRireki.getShrtuukashrtienrsk());
                    }
                    if (khShrRireki.getKykhnkkaisuu() > 0) {
                        uiBean.setYenshrkykhtykeihi(khShrRireki.getYenshrkykhtykeihi());
                        uiBean.setKykhnkkaisuu(khShrRireki.getKykhnkkaisuu());
                    }
                    else {
                        uiBean.setKykhnkkaisuu(0);
                    }

                    if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(uiBean.getGyoumuyouKousinKinouId())) {
                        uiBean.setAzukarigoukeigk(khShrRireki.getZitkazukarikingksiteituuka());
                        uiBean.setAzukariaiyakuhr(khShrRireki.getShrtuukasyushrgkkei());
                        uiBean.setAzukarijpygoukeigk(khShrRireki.getZitkazukarikingkyen());
                        uiBean.setAzukarip(khShrRireki.getYenmikeikap());
                        uiBean.setAzukarizennouseisankgk(khShrRireki.getYenzennomikeikap());
                        uiBean.setAzukarihaitoukin(khShrRireki.getYenkansanhaitoukin());
                        uiBean.setAzukartkbtihaitoukin(khShrRireki.getYensonotahaitoukin());
                        uiBean.setZeitekiazukarikinkjumu(khShrRireki.getZeitekiazukarikinkjumu());
                    }

                    if (khShrRireki.getShrtuukashrgkgoukei().compareTo(
                        BizCurrency.valueOf(0, khShrRireki.getShrtuukashrgkgoukei().getType())) > 0) {
                        uiBean.setShrnaiyouumu(C_UmuKbn.ARI);
                    }
                }
                else if (C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn())
                    || C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn())
                    || C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) {

                    uiBean.setShrymd(khShrRireki.getShrymd());
                    uiBean.setNykntuukashrgkgoukeikakunin(khShrRireki.getShrtuukashrgkgoukei());
                    uiBean.setKihrkmp(khShrRireki.getSyushrgkkei());
                    uiBean.setKeitorikrkgk(khShrRireki.getShrkrkgk());

                }
                else if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {

                    uiBean.setShrymd(khShrRireki.getShrymd());
                    uiBean.setShrgkgoukeikakunin(khShrRireki.getShrtuukashrgkgoukei());
                    uiBean.setPtumitatekin(khShrRireki.getShrtuukasyushrgkkei());
                    uiBean.setMikeikap(khShrRireki.getMikeikap());
                    uiBean.setZennouseisankin(khShrRireki.getZennomikeikap());
                    uiBean.setAzukarikinkykhnkkaiyakuhr(khShrRireki.getZitkazukarikingksiteituuka());
                    uiBean.setSonotashrgk(khShrRireki.getShrtuukasonotashrkngk());
                    uiBean.setSntshrgksssonotashrgk(khShrRireki.getSonotashrkngksiteituuka());
                    uiBean.setSntshrgkssgikshrratetekiymd(khShrRireki.getGaikashrkwsratekjnymd());
                    uiBean.setSntshrgkssgikshrrate(khShrRireki.getGaikashrkwsrate());
                    uiBean.setSntshrgkssgikshrkyktuukasyu(khShrRireki.getKyktuukasyu());
                    uiBean.setSntshrgkssyensonotashrgk(khShrRireki.getSonotashrkngkyen());
                    uiBean.setSntshrgkssyenkamikeikap(khShrRireki.getYenmikeikap());
                    uiBean.setSntshrgkssyenzennousisnkgk(khShrRireki.getYenzennomikeikap());
                    uiBean.setSntshrgkssyenazukarikin(khShrRireki.getZitkazukarikingkyen());
                    uiBean.setSntshrgkssyenhaitoukin(khShrRireki.getYenkansanhaitoukin());
                    uiBean.setSntshrgkssyentkbthaitoukin(khShrRireki.getYensonotahaitoukin());
                    uiBean.setSntshrgkssyenkakrkgk(khShrRireki.getYenkrkgk());
                    uiBean.setJpyshrgkgoukeikakunin(khShrRireki.getShrtuukashrgkgoukei());
                    uiBean.setJpyptumitatekin(khShrRireki.getShrtuukakaiyakuhrkngkkei());
                    uiBean.setYenkamikeikap(khShrRireki.getYenmikeikap());
                    uiBean.setYenkazennouseisankgk(khShrRireki.getYenzennomikeikap());
                    uiBean.setYenkaazukarikingk(khShrRireki.getZitkazukarikingkyen());
                    uiBean.setYenkahaitoukin(khShrRireki.getYenkansanhaitoukin());
                    uiBean.setYentkbthaitoukin(khShrRireki.getYensonotahaitoukin());
                    uiBean.setYenkakrkgk(khShrRireki.getYenkrkgk());
                    uiBean.setShrsyousaiptumitatekin(khShrRireki.getSyushrgkkei());
                    uiBean.setShrsyousaijpyptumitatekin(khShrRireki.getShrtuukasyushrgkkei());
                    uiBean.setYenshrratetekiymd(khShrRireki.getShrkwsratekjnymd());
                    uiBean.setYenshrrate(khShrRireki.getShrkwsrate());
                    uiBean.setShrkyktuukasyu(khShrRireki.getKyktuukasyu());
                    uiBean.setYenptmttssyenptmttgoukei(khShrRireki.getKaiyakuhrkngkkeiyen());
                    uiBean.setYenptmttssyenshrratetkymd(khShrRireki.getShrkwsratekjnymd());
                    uiBean.setYenptmttssyenshrratete(khShrRireki.getShrkwsrate());
                    uiBean.setYenptmttssshrkyktuukasyu(khShrRireki.getKyktuukasyu());
                    uiBean.setYenptmttssptumitategoukei(khShrRireki.getKaiyakuhrkngkkeisiteituuka());
                    uiBean.setYenptmttssptumitate(khShrRireki.getSyushrgkkei());
                    uiBean.setYenptmttssmikeikap(khShrRireki.getMikeikap());
                    uiBean.setYenptmttsszennouseisankin(khShrRireki.getZennomikeikap());
                    uiBean.setYenptmttsskykhnkkaiyakuhr(khShrRireki.getZitkazukarikingksiteituuka());
                    uiBean.setYendthnkshrgkgoukei(khShrRireki.getShrtuukashrgkgoukei());
                    uiBean.setYendthnkptumitatekin(khShrRireki.getShrtuukasyushrgkkei());
                    uiBean.setYendthnkmikeikap(khShrRireki.getYenmikeikap());
                    uiBean.setYendthnkzennouseisankin(khShrRireki.getYenzennomikeikap());
                    uiBean.setYendthnkhaitoukin(khShrRireki.getYenkansanhaitoukin());
                    uiBean.setYendthnktkbthaitoukin(khShrRireki.getYensonotahaitoukin());
                    uiBean.setYendthnkkrkgk(khShrRireki.getYenkrkgk());
                    uiBean.setDispyendttienrskksnbinissuu(tienrskkisanymdnissuu);

                    if (C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(khShrRireki.getShrhousiteikbn())) {
                        uiBean.setYendthnkshrtienrsk(BizCurrency.optional());
                    }
                    else {
                        uiBean.setYendthnkshrtienrsk(khShrRireki.getShrtuukashrtienrsk());
                    }

                    uiBean.setSynykngk(khShrRireki.getYensynykngk());
                    uiBean.setZeimukwsratekjnymd(khShrRireki.getZeimukwsratekjnymd());
                    uiBean.setZeimukwsrate(khShrRireki.getZeimukwsrate());
                    uiBean.setZeimukyktuukasyu(khShrRireki.getKyktuukasyu());
                    uiBean.setHtykeihi(khShrRireki.getYenhtykeihi());
                    uiBean.setDisptienrskkisanymdnissuu(tienrskkisanymdnissuu);
                    uiBean.setDispjptienrskkisanymdnissuu(tienrskkisanymdnissuu);

                    if (C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(khShrRireki.getShrhousiteikbn())) {
                        uiBean.setShrtienrsk(BizCurrency.optional());
                        uiBean.setJpyshrtienrsk(BizCurrency.optional());
                    }
                    else {
                        uiBean.setShrtienrsk(khShrRireki.getShrtuukashrtienrsk());
                        uiBean.setJpyshrtienrsk(khShrRireki.getShrtuukashrtienrsk());
                    }
                    if (khShrRireki.getKykhnkkaisuu() > 0) {
                        uiBean.setYenshrkykhtykeihi(khShrRireki.getYenshrkykhtykeihi());
                        uiBean.setKykhnkkaisuu(khShrRireki.getKykhnkkaisuu());
                    }
                    else {
                        uiBean.setKykhnkkaisuu(0);
                    }
                }
                else if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(uiBean.getGyoumuyouKousinKinouId())) {

                    uiBean.setShrymd(khShrRireki.getShrymd());
                    uiBean.setHenkank(khShrRireki.getSyushrgkkei());
                    uiBean.setYenhenkank(khShrRireki.getYensyushrgkkei());
                    uiBean.setYenshrratetekiymd(khShrRireki.getShrkwsratekjnymd());
                    uiBean.setYenshrrate(khShrRireki.getShrkwsrate());
                    uiBean.setShrkyktuukasyu(khShrRireki.getKyktuukasyu());
                }
                else if (IKhozenCommonConstants.KINOUID_KHYENDTHNKHRSHR.equals(uiBean.getGyoumuyouKousinKinouId())) {
                    uiBean.setSyoruiukeymd(khShrRireki.getSyoruiukeymd());
                    uiBean.setShrymd(khShrRireki.getShrymd());
                    uiBean.setYendthnkshrgkgoukei(khShrRireki.getShrtuukashrgkgoukei());
                    uiBean.setYendthnkhr(khShrRireki.getShrtuukasyushrgkkei());
                    uiBean.setDispyendttienrskksnbinissuu(tienrskkisanymdnissuu);

                    if (C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(khShrRireki.getShrhousiteikbn())) {
                        uiBean.setYendthnkshrtienrsk(BizCurrency.optional());
                    }
                    else {
                        uiBean.setYendthnkshrtienrsk(khShrRireki.getShrtuukashrtienrsk());
                    }
                    uiBean.setSynykngk(khShrRireki.getYensyushrgkkei());
                    uiBean.setHtykeihi(khShrRireki.getYenhtykeihi());
                    if (khShrRireki.getKykhnkkaisuu() > 0) {
                        uiBean.setYenshrkykhtykeihi(khShrRireki.getYenshrkykhtykeihi());
                        uiBean.setKykhnkkaisuu(khShrRireki.getKykhnkkaisuu());
                    }
                    else {
                        uiBean.setKykhnkkaisuu(0);
                    }
                }
                else if (IKhozenCommonConstants.KINOUID_DSHR.equals(uiBean.getGyoumuyouKousinKinouId())) {
                    uiBean.setSyoruiukeymd(khShrRireki.getSyoruiukeymd());
                    uiBean.setCalckijyunymd(khShrRireki.getKouryokuhasseiymd());
                    uiBean.setShrymd(khShrRireki.getShrymd());
                    uiBean.setShrgkkei(khShrRireki.getShrtuukashrgkgoukei());
                    uiBean.setTumitatehaitouganrikin(khShrRireki.getShrtuukasyushrgkkei());
                    uiBean.setDisphaitttienrskksnbinissuu(tienrskkisanymdnissuu);
                    if (C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(khShrRireki.getShrhousiteikbn())) {
                        uiBean.setHaitshrtienrsk(BizCurrency.optional());
                    }
                    else {
                        uiBean.setHaitshrtienrsk(khShrRireki.getShrtuukashrtienrsk());
                    }

                }
                else if (IKhozenCommonConstants.KINOUID_KHDSEISANTUIBARAI.equals(uiBean.getGyoumuyouKousinKinouId())) {
                    uiBean.setShrymd(khShrRireki.getShrymd());
                    uiBean.setShrkyktuukasyu(khShrRireki.getKyktuukasyu());
                    uiBean.setShrgkgoukeikakunin(khShrRireki.getShrtuukashrgkgoukei());
                    uiBean.setSonotashrgk(khShrRireki.getShrtuukasonotashrkngk());
                    uiBean.setGstszeigk(khShrRireki.getShrtuukagstszeigk().multiply(-1));
                    uiBean.setDisptienrskkisanymdnissuu(tienrskkisanymdnissuu);
                    uiBean.setShrtienrsk(khShrRireki.getShrtuukashrtienrsk());
                    uiBean.setSntshrgksssonotashrgk(khShrRireki.getSonotashrkngksiteituuka());
                    uiBean.setSntshrgkssgikshrratetekiymd(khShrRireki.getGaikashrkwsratekjnymd());
                    uiBean.setSntshrgkssgikshrrate(khShrRireki.getGaikashrkwsrate());
                    uiBean.setSntshrgkssgikshrkyktuukasyu(khShrRireki.getKyktuukasyu());
                    uiBean.setSntshrgkssyensonotashrgk(khShrRireki.getSonotashrkngkyen());
                    uiBean.setSntshrgkssyenhaitoukin(khShrRireki.getYenkansanhaitoukin());
                    uiBean.setSntshrgkssyentkbthaitoukin(khShrRireki.getYensonotahaitoukin());
                    uiBean.setJpyshrgkgoukeikakunin(khShrRireki.getShrtuukashrgkgoukei());
                    uiBean.setYenkahaitoukin(khShrRireki.getYenkansanhaitoukin());
                    uiBean.setYentkbthaitoukin(khShrRireki.getYensonotahaitoukin());
                    uiBean.setJpygstszeigk(khShrRireki.getShrtuukagstszeigk().multiply(-1));
                    uiBean.setDispjptienrskkisanymdnissuu(tienrskkisanymdnissuu);
                    uiBean.setJpyshrtienrsk(khShrRireki.getShrtuukashrtienrsk());
                    uiBean.setYendthnkshrgkgoukei(khShrRireki.getShrtuukashrgkgoukei());
                    uiBean.setYendthnkhaitoukin(khShrRireki.getYenkansanhaitoukin());
                    uiBean.setYendthnktkbthaitoukin(khShrRireki.getYensonotahaitoukin());
                    uiBean.setYendthnkgstszeigk(khShrRireki.getShrtuukagstszeigk().multiply(-1));
                    uiBean.setDispyendttienrskksnbinissuu(tienrskkisanymdnissuu);
                    uiBean.setYendthnkshrtienrsk(khShrRireki.getShrtuukashrtienrsk());
                    uiBean.setSynykngk(khShrRireki.getYensynykngk());
                    uiBean.setZeimukwsratekjnymd(khShrRireki.getZeimukwsratekjnymd());
                    uiBean.setZeimukwsrate(khShrRireki.getZeimukwsrate());
                    uiBean.setZeimukyktuukasyu(khShrRireki.getKyktuukasyu());
                    uiBean.setHtykeihi(khShrRireki.getYenhtykeihi());
                    uiBean.setGststaisyousaeki(khShrRireki.getYenkztgk());
                    uiBean.setZeimugstszeigk(khShrRireki.getYengstszeigk());

                    if (khShrRireki.getKykhnkkaisuu() > 0) {
                        uiBean.setYenshrkykhtykeihi(khShrRireki.getYenshrkykhtykeihi());
                        uiBean.setKykhnkkaisuu(khShrRireki.getKykhnkkaisuu());
                    }
                    else {
                        uiBean.setKykhnkkaisuu(0);
                    }
                    if (khShrRireki.getShrtuukashrgkgoukei().compareTo(
                        BizCurrency.valueOf(0, khShrRireki.getShrtuukashrgkgoukei().getType())) > 0) {
                        uiBean.setShrnaiyouumu(C_UmuKbn.ARI);
                    }
                    else {
                        uiBean.setShrnaiyouumu(C_UmuKbn.NONE);
                    }
                    uiBean.setGsbunritaisyou(khShrRireki.getGsbunritaisyou());

                }
            }
            else {
                throw new CommonBizAppException("契約管理支払履歴TBLからレコードが取得できません。  "
                    + "証券番号 =" + syoNo + " 支払識別キー=" + henkousikibetukey);
            }

            if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(uiBean.getGyoumuyouKousinKinouId())
                || IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(uiBean.getGyoumuyouKousinKinouId())
                || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())
                || C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {

                if (shrRirekiDetailList != null && shrRirekiDetailList.size() > 0) {
                    uiBean.setKiykhrsyousaiptumitatekin(shrRirekiDetailList.get(0).getShrtstmttkin());
                    uiBean.setKiykhrsyousaisjkkktyouseirt(shrRirekiDetailList.get(0).getKaiyakusjkkktyouseiritu()
                        .multiply(100));
                    uiBean.setKiykhrsyousaikaiyakukjgk(shrRirekiDetailList.get(0).getKaiyakukjgk().multiply(-1));
                    uiBean.setKiykhrsyousaikaiyakukjritu(shrRirekiDetailList.get(0).getKaiyakukoujyoritu()
                        .multiply(100));
                }
                else {
                    uiBean.setKiykhrsyousaiptumitatekin(BizCurrency.valueOf(0));
                    uiBean.setKiykhrsyousaisjkkktyouseirt(BizNumber.valueOf(0));
                }
            }
        }

        if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(uiBean.getGyoumuyouKousinKinouId()) ||
            (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(uiBean.getGyoumuyouKousinKinouId()) &&
                C_SyoriKbn.MISEISAN.eq(uiBean.getSyoriKbn()))) {

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);

            IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey(henkousikibetukey);

            List<IT_KhHasseijiKazeiRireki> khHasseijiKazeiRirekiList = khTtdkRireki.getKhHasseijiKazeiRirekis();

            if (khHasseijiKazeiRirekiList.size() > 0) {
                uiBean.setHasseiKazeiUmuKbn(C_UmuKbn.ARI);
                uiBean.setSynykngk(khHasseijiKazeiRirekiList.get(0).getHasseijikngk());
                uiBean.setHtykeihi(khHasseijiKazeiRirekiList.get(0).getYenhtykeihi());

                if (khHasseijiKazeiRirekiList.get(0).getKykhnkkaisuu() > 0) {
                    uiBean.setYenshrkykhtykeihi(khHasseijiKazeiRirekiList.get(0).getYenshrkykhtykeihi());
                    uiBean.setKykhnkkaisuu(khHasseijiKazeiRirekiList.get(0).getKykhnkkaisuu());
                }
                else {
                    uiBean.setKykhnkkaisuu(0);
                }
            }
            else {
                uiBean.setHasseiKazeiUmuKbn(C_UmuKbn.NONE);
            }
        }
        else {
            uiBean.setHasseiKazeiUmuKbn(C_UmuKbn.NONE);
        }

        if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(uiBean.getGyoumuyouKousinKinouId())) {
            C_UmuKbn yendtinfomDispUmu = C_UmuKbn.NONE;

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);

            IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey(henkousikibetukey);

            int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

            uiBean.setSyohinHanteiKbn(syohinHanteiKbn);

            if (BizDateUtil.compareYmd(khTtdkRireki.getSyoriYmd(),
                IKhozenCommonConstants.GAMENCTR_DISPTEKIYOUYMD1) != BizDateUtil.COMPARE_LESSER) {
                List<IT_KhTtdkRireki> khTtdkRirekiLst = khKeiyakuSyoukaiDao.getKhTtdkRirekiLst(uiBean.getSyono(),
                    khTtdkRireki.getSyorikbn(), khTtdkRireki.getSyoriYmd());

                if (khTtdkRirekiLst.size() == 1) {

                    yendtinfomDispUmu = C_UmuKbn.ARI;

                    C_UktkSyoriKbn uktkSyoriKbn = C_UktkSyoriKbn.BLNK;

                    if (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(khTtdkRireki.getSyorikbn())) {
                        uktkSyoriKbn = C_UktkSyoriKbn.MKHGKTTTYENDTHNK;
                    }
                    else if (C_SyoriKbn.YENDTHNK_NINISEIKYUU.eq(khTtdkRireki.getSyorikbn())) {
                        uktkSyoriKbn = C_UktkSyoriKbn.NINISEIKYUU;
                    }

                    List<IT_KhHenkouUktkYendtHnk> khHenkouUktkYendtHnkLst =
                        khKeiyakuSyoukaiDao.getKhHenkouUktkYendtHnkLst(uiBean.getSyono(), uktkSyoriKbn,
                            C_UktkJyoutaiKbn.SYORIZUMI);

                    IT_KykSyouhnHnkmae kykSyouhnHnkmae = hozenDomManager.getKykSyouhnHnkmaeBySyono(uiBean.getSyono());

                    C_Tuukasyu kyktuukasyu = C_Tuukasyu.BLNK;
                    if (kykSyouhnHnkmae != null) {
                        kyktuukasyu = kykSyouhnHnkmae.getKyktuukasyu();
                    }

                    if (khHenkouUktkYendtHnkLst.size() > 0) {
                        IT_KhHenkouUktkYendtHnk khHenkouUktkYendtHnk = khHenkouUktkYendtHnkLst.get(0);

                        uiBean.setYendtinfomkhgktttymd(khHenkouUktkYendtHnk.getMkhgktttymd());
                        uiBean.setYendtinfosyoruiuktkymd(khHenkouUktkYendtHnk.getSyoruiukeymd());
                        uiBean.setYendtinfoyendthnkymd(khHenkouUktkYendtHnk.getYendthnkymd());
                        uiBean.setYendtinfomkhgk(khHenkouUktkYendtHnk.getMkhgk());
                        uiBean.setYendtinfokjnkngk(khHenkouUktkYendtHnk.getYendthnkkjnkg());
                        uiBean.setYendtinfomokuhyouti(khHenkouUktkYendtHnk.getTargettkmokuhyouti());
                        uiBean.setYendtinfotoutatukngk(khHenkouUktkYendtHnk.getYendthnkkaiyakuhryen());
                        uiBean.setYendtinfoyendthnkkjnkngk(khHenkouUktkYendtHnk.getYendthnkkaiyakuhryen());
                        uiBean.setYendtinfoyendthnkkiykhr(khHenkouUktkYendtHnk.getYendthnkkaiyakuhrgaika());
                        uiBean.setYendtinfoyendthnkjikwsrate(khHenkouUktkYendtHnk.getYendthnkjikwsrate());
                        if (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(khTtdkRireki.getSyorikbn())) {
                            uiBean.setYendtinfoyendtkwratetkyymd(khHenkouUktkYendtHnk.getMkhgktttymd());
                        } else if (C_SyoriKbn.YENDTHNK_NINISEIKYUU.eq(khTtdkRireki.getSyorikbn())) {
                            uiBean.setYendtinfoyendtkwratetkyymd(khHenkouUktkYendtHnk.getSyoruiukeymd());
                        }
                        uiBean.setYendtinfokyktuukasyu(kyktuukasyu);
                        uiBean.setYendtinfoyendthnkhrgk(khHenkouUktkYendtHnk.getYendthnkhr());
                        uiBean.setYendtinfobfrsibousyen(khHenkouUktkYendtHnk.getYendthnkbfrsibousyen());
                        uiBean.setYendtinfonewkaiyakuhr(khHenkouUktkYendtHnk.getNewkaiyakuhr());
                        uiBean.setKiykhrsyousaiyendthnkiykhr(khHenkouUktkYendtHnk.getYendthnkkaiyakuhrgaika());
                        uiBean.setYendtinfoptumitatekin(khHenkouUktkYendtHnk.getYendthnkjiptumitatekin());
                        uiBean.setYendtinfosjkkktyouseiritu(khHenkouUktkYendtHnk.getYendthnkjisjkkktyouseiritu());
                        uiBean.setYendtinfokaiyakukjgk(khHenkouUktkYendtHnk.getYendthnkjikaiyakukjgk().multiply(-1));
                        uiBean.setYendtinfokaiyakukoujyoritu(khHenkouUktkYendtHnk.getYendthnkjikaiyakukoujyoritu().multiply(100));
                        uiBean.setYendtinfosyorikbn(khTtdkRireki.getSyorikbn());
                        uiBean.setKaiyakukoujyoritutekiumu(khHenkouUktkYendtHnk.getKaiyakukoujyoritutekiumu());
                    }
                }
            }

            uiBean.setYendtinfomDispUmu(yendtinfomDispUmu);
        }

        String koskinouid = uiBean.getGyoumuyouKousinKinouId();

        if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(koskinouid) ||
            IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(koskinouid)) {

            uiBean.setKinouHyoujiptnKbn(C_HyoujiptnKbn.KAIYAKU);
        }
        else if (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(koskinouid) &&
            C_SyoriKbn.JIDOUSOUKINSEISANZUMI.eq(uiBean.getSyoriKbn())) {

            uiBean.setKinouHyoujiptnKbn(C_HyoujiptnKbn.PMNYSYMET_JDSKN_SSNZM);
        }
        else if (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(koskinouid) &&
            C_SyoriKbn.MISEISAN.eq(uiBean.getSyoriKbn())) {

            uiBean.setKinouHyoujiptnKbn(C_HyoujiptnKbn.PMNYSYMET_MSSN);
        }
        else if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(koskinouid)) {

            uiBean.setKinouHyoujiptnKbn(C_HyoujiptnKbn.GENGAKU);
        }
        else if (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(koskinouid)) {

            uiBean.setKinouHyoujiptnKbn(C_HyoujiptnKbn.KYKTRKS);
        }
        else if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(koskinouid)) {

            uiBean.setKinouHyoujiptnKbn(C_HyoujiptnKbn.SEINENGAPPISEI);
        }
        else if (IKhozenCommonConstants.KINOUID_KHYENDTHNKHRSHR.equals(koskinouid)) {

            uiBean.setKinouHyoujiptnKbn(C_HyoujiptnKbn.YENDTHNKHRSHR);
        }
        else if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(koskinouid)) {

            uiBean.setKinouHyoujiptnKbn(C_HyoujiptnKbn.MKHGKTTTYENDTHNK);
        }
        else if (IKhozenCommonConstants.KINOUID_DSHR.equals(koskinouid)) {

            uiBean.setKinouHyoujiptnKbn(C_HyoujiptnKbn.DSHR);
        }
        else if (IKhozenCommonConstants.KINOUID_KHDSEISANTUIBARAI.equals(koskinouid)) {

            uiBean.setKinouHyoujiptnKbn(C_HyoujiptnKbn.DSEISANTUIBARAI);
        }
        uiBean.getBzWorkflowInfo().setKouteiKanriId(kTKkTtdkRrk.get(0).getIT_KhTtdkRireki().getKouteikanriid());

        if (!BizUtil.isBlank(uiBean.getBzWorkflowInfo().getKouteiKanriId())) {

            SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);

            setSyoruiInfoItiran.exec(uiBean);

            SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);

            setProgressHistory.exec(uiBean);
        }
    }

    public void chkYuukou(KhozenCommonParam pKhozenCommonParam) {

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }

        if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {

            if (checkYuukouJyoutai.getWarningMessageIDList().size() != 0) {

                for (int i = 0; i < checkYuukouJyoutai.getWarningMessageIDList().size(); i++) {

                    messageManager.addConversationMessageId(
                        KhMessageGroupConstants.GROUP_WARNING1,
                        checkYuukouJyoutai.getWarningMessageIDList().get(i),
                        checkYuukouJyoutai.getWarningMessageList().get(i));
                }
            }
        }
    }

    private void hanteiTtdkTyuui(KhozenCommonParam pKhozenCommonParam, String pSyono) {

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(pKhozenCommonParam, pSyono);

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {

            throw new BizLogicException(hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
        else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
    }

    public void checkYuuyokkngai(KhozenCommonParam pKhozenCommonParam) {

        messageManager.removeConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA0011);

        boolean ret = false;

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        ret = checkYuuyokkngai.exec(uiBean.getSyono(), BizDate.getSysDate());
        if (ret == false) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA0011);
        }
    }

    public void checkKouryokusakihiduke() {

        messageManager.removeConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIA0023);

        String syono = uiBean.getSyono();

        List<IT_KykSyouhn> kykSyouhnlst = hozenDomManager.getKykSyouhnsBySyonoKouryokuhasseiymd(syono,
            BizDate.getSysDate());

        List<IT_KykSyouhnRireki> kykSyouhnRirekilst = hozenDomManager.getKykSyouhnRirekisBySyonoKouryokuhasseiymd(
            syono,
            BizDate.getSysDate());

        if (kykSyouhnlst.size() > 0 || kykSyouhnRirekilst.size() > 0) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIA0023);
        }
    }

    public void checkYendtMbrs() {

        messageManager.removeConversationMessageId(KhMessageGroupConstants.GROUP_WARNING5, MessageId.WIA1017);

        String syono = uiBean.getSyono();

        List<IT_KhHenreikin> khHenreikinList = hozenDomManager.getKhHenreikinYendtMbrsBySyono(syono);

        if (khHenreikinList.size() > 0) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING5, MessageId.WIA1017);
        }
    }

    public void chkTtdkrrkumu() {
        String syono = uiBean.getSyono();

        long cnt = hozenDomManager.getKhTtdkRirekiCountBySyono(syono);

        if (cnt > 0) {
            uiBean.setTtdkrrkumu(C_UmuKbn.ARI);
        } else {
            uiBean.setTtdkrrkumu(C_UmuKbn.NONE);
        }
    }

    public void chkSisuurendoTmttknumu(KhozenCommonParam pKhozenCommonParam) {

        String syono = uiBean.getSyono();

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknlist = kykKihon.getKhSisuurendoTmttkns();

        if (khSisuurendoTmttknlist != null && khSisuurendoTmttknlist.size() > 0) {
            uiBean.setTumitateRirekiUmuKbn(C_UmuKbn.ARI);

            List<IT_KykSyouhn> kykSyouhnList = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);

            if ((BizDateUtil.compareYmd(kykSyouhnList.get(0).getKykymd(), BizDate.getSysDate())
                == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(kykSyouhnList.get(0).getKykymd(), BizDate.getSysDate())
                == BizDateUtil.COMPARE_EQUAL) &&
                kykSyouhnList.get(0).getYendthnkymd() == null) {

                messageManager.removeConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIF1033);

                BizDate hanteiKijyunymd = BizDate.getSysDate();
                if (!C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhnList.get(0).getYuukousyoumetukbn()) &&
                    BizDateUtil.compareYmd(BizDate.getSysDate(), kykSyouhnList.get(0).getSyoumetuymd())
                    == BizDateUtil.COMPARE_GREATER) {
                    hanteiKijyunymd = kykSyouhnList.get(0).getSyoumetuymd();
                }

                HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai = SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);
                HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);

                hanteiTmttknJyoutaiBean.setSyono(uiBean.getSyono());
                hanteiTmttknJyoutaiBean.setHanteiKijyunymd(hanteiKijyunymd);
                hanteiTmttknJyoutaiBean.setKykymd(kykSyouhnList.get(0).getKykymd());
                boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);
                if (!result) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIF1033);
                }
            }
        }
        else {
            uiBean.setTumitateRirekiUmuKbn(C_UmuKbn.NONE);
        }
    }

    public void checkKykymdsakihiduke(KhozenCommonParam pKhozenCommonParam) {

        messageManager.removeConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIF1049);

        List<IT_KykSyouhn> kykSyouhnList = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);

        if (BizDateUtil.compareYmd(BizDate.getSysDate(), kykSyouhnList.get(0).getKykymd())
            == BizDateUtil.COMPARE_LESSER) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIF1049);
        }
    }

    private void setSyouraiKaiyakuhenreikinKngn() {
        boolean hanteiKbn = baseUserInfo.hasAuthenticatedFunctionModeByFunctionId(
            IKhozenCommonConstants.KINOUID_SYOURAIKAIYAKUHENREIKIN, "default");

        if (hanteiKbn) {
            uiBean.setSyouraiKaiyakuhenreikinKngnUmu(C_UmuKbn.ARI);
        }
        else {
            uiBean.setSyouraiKaiyakuhenreikinKngnUmu(C_UmuKbn.NONE);
        }
    }

    private void setKaiyakuKngn() {
        boolean hanteiKbn = baseUserInfo.hasAuthenticatedFunctionModeByFunctionId(
            IKhozenCommonConstants.KINOUID_KAIYAKU, "default");

        if (hanteiKbn) {
            uiBean.setKaiyakuKngnUmu(C_UmuKbn.ARI);
        }
        else {
            uiBean.setKaiyakuKngnUmu(C_UmuKbn.NONE);
        }
    }

    public void setKeiyakunaiyouUiBean(KhozenCommonParam pKhozenCommonParam) {
        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);

        String syono = uiBean.getSyono();

        BizNumber tmttknzoukaritujygn = BizNumber.ZERO;

        IT_KykKihon kykKihon = pKhozenCommonParam.getKeiyakuKihon(syono);

        List<IT_KykSyouhn> kykSyouhnList = pKhozenCommonParam.getKeiyakuSyouhin(syono, C_SyutkKbn.SYU);

        List<IT_TtdkKan> ttdkKanLst = khKeiyakuSyoukaiDao.getTtdkKanBySyonoSyoruiCdTyouhyouymd(
            syono, C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR, kykKihon.getSinkyksyokensakuseiymd());

        uiBean.setSyono(kykKihon.getSyono());

        uiBean.setYuukousyoumetukbn(kykSyouhnList.get(0).getYuukousyoumetukbn());

        uiBean.setKykjyoutai(kykSyouhnList.get(0).getKykjyoutai());

        uiBean.setSyoumetujiyuu(kykSyouhnList.get(0).getSyoumetujiyuu());

        uiBean.setSyoumetuymd(kykSyouhnList.get(0).getSyoumetuymd());

        uiBean.setMosymd(kykKihon.getMosymd());

        uiBean.setKktymd(kykKihon.getKktymd());

        uiBean.setMosukeymd(kykKihon.getMosukeymd());

        uiBean.setSeirituymd(kykKihon.getSeirituymd());

        uiBean.setSeisekiym(kykKihon.getSeisekiym());

        uiBean.setSyouhinCd(kykSyouhnList.get(0).getSyouhncd());

        tmttknzoukaritujygn = kykSyouhnList.get(0).getTmttknzoukaritujygn();
        if (tmttknzoukaritujygn != null) {
            uiBean.setTmttknzoukaritujygn(tmttknzoukaritujygn.multiply(100));
        }
        else {
            uiBean.setTmttknzoukaritujygn(BizNumber.ZERO);
        }

        uiBean.setSisuukbn(kykSyouhnList.get(0).getSisuukbn());

        if (kykKihon.getMosukeymd() == null || kykKihon.getMosjimosuktymd() == null) {
            uiBean.setMosuktymdhkumu(C_UmuKbn.NONE);
        }
        else if (kykKihon.getMosukeymd().compareTo(kykKihon.getMosjimosuktymd()) != 0) {
            uiBean.setMosuktymdhkumu(C_UmuKbn.ARI);
        }
        else {
            uiBean.setMosuktymdhkumu(C_UmuKbn.NONE);
        }

        uiBean.setMosjimosuktymd(kykKihon.getMosjimosuktymd());

        String yakkanbunsyono = kykKihon.getYakkanbunsyono();

        if (!BizUtil.isBlank(yakkanbunsyono)) {
            Matcher mc = Pattern.compile("(\\w{2})(\\w{4})(\\w{4})").matcher(yakkanbunsyono);
            yakkanbunsyono = mc.replaceAll("$1-$2-$3");
        }
        uiBean.setYakkanjyuryouhoukbn(kykKihon.getYakkanjyuryouhoukbn());
        uiBean.setYakkanbunsyono(yakkanbunsyono);

        int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhnList.get(0).getSyouhncd());

        uiBean.setSyohinHanteiKbn(syohinHanteiKbn);

        C_PyenTutHouKbn pyentuthoukbn = C_PyenTutHouKbn.BLNK;
        C_UmuKbn pyentuthouYusouUmu = C_UmuKbn.NONE;
        C_UmuKbn pyentuthouMailUmu = C_UmuKbn.NONE;
        C_DispKbn pyentuthouDispKbn = C_DispKbn.HIHYOUJI;

        if (!C_YnkHrkmgkAnniTuutiKbn.BLNK.eq(kykKihon.getYnkhrkmgkannituutikbn())) {

            pyentuthouDispKbn = C_DispKbn.HYOUJI;

            if (C_YnkHrkmgkAnniTuutiKbn.YUUSOUKIBOU.eq(kykKihon.getYnkhrkmgkannituutikbn())) {
                pyentuthouYusouUmu = C_UmuKbn.ARI;
            }

            List<DsMailAddressInfosBySyonoBean> dsMailAddressInfosBySyonoBeanLst =
                khKeiyakuSyoukaiDao.getDsMailAddressInfosBySyono(uiBean.getSyono());
            DsMailAddressInfosBySyonoBean dsMailAddressInfosBySyonoBean = null;
            if (dsMailAddressInfosBySyonoBeanLst.size() > 0) {
                dsMailAddressInfosBySyonoBean = dsMailAddressInfosBySyonoBeanLst.get(0);
            }

            if (dsMailAddressInfosBySyonoBean != null) {
                if (C_DsMailSousinJyoutaiKbn.YUUKOU.eq(dsMailAddressInfosBySyonoBean.getDsmailsousinjyoutaikbn()) ||
                    C_DsMailSousinTeisiRiyuuKbn.MAILHAISINERROR.eq(dsMailAddressInfosBySyonoBean.getDsmailsousintisrykbn())) {
                    pyentuthouMailUmu = C_UmuKbn.ARI;
                }
            }

            if (C_UmuKbn.ARI.eq(pyentuthouYusouUmu)) {
                if (C_UmuKbn.ARI.eq(pyentuthouMailUmu)) {
                    pyentuthoukbn = C_PyenTutHouKbn.MAILYUUSOUKIBOU;
                }
                else {
                    pyentuthoukbn = C_PyenTutHouKbn.YUUSOUKIBOU;
                }
            }
            else {
                if (C_UmuKbn.ARI.eq(pyentuthouMailUmu)) {
                    pyentuthoukbn = C_PyenTutHouKbn.MAILKIBOU;
                }
                else {
                    pyentuthoukbn = C_PyenTutHouKbn.KIBOUSINAI;
                }
            }
        }
        else {
            pyentuthouDispKbn = C_DispKbn.HIHYOUJI;
        }

        uiBean.setPyentuthouDispKbn(pyentuthouDispKbn);
        uiBean.setPyentuthoukbn(pyentuthoukbn);
        uiBean.setKyktuukasyu(kykSyouhnList.get(0).getKyktuukasyu());

        C_UmuKbn houteiTyotkseiUmu = C_UmuKbn.NONE;
        SetTyotikuseihokenhyouji setTyotikuseihokenhyouji = SWAKInjector.getInstance(SetTyotikuseihokenhyouji.class);
        HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);

        hanteiTyotikuseihokenBean.setSyouhnCd(kykSyouhnList.get(0).getSyouhncd());
        hanteiTyotikuseihokenBean.setSyouhnsdNo(kykSyouhnList.get(0).getSyouhnsdno());
        hanteiTyotikuseihokenBean.setHrkkaisuu(kykKihon.getHrkkaisuu());
        hanteiTyotikuseihokenBean.setHrkkeiro(kykKihon.getHrkkeiro());

        C_ErrorKbn errorKbn = setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);

        if (!C_ErrorKbn.ERROR.eq(errorKbn)) {
            houteiTyotkseiUmu = setTyotikuseihokenhyouji.getHouteityotkhknhyj();
        }

        uiBean.setHouteityotkseiumu(houteiTyotkseiUmu);

        if (ttdkKanLst.size() > 0) {
            uiBean.setKzkatesouhusaki1(ttdkKanLst.get(0).getShsnmkj());
        }
        else {
            uiBean.setKzkatesouhusaki1("");
        }

        if (ttdkKanLst.size() > 1) {
            uiBean.setKzkatesouhusaki2(ttdkKanLst.get(1).getShsnmkj());
        }
        else {
            uiBean.setKzkatesouhusaki2("");
        }

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(pKhozenCommonParam, uiBean);

        if (uiBean.getWarningMessageIdList().size() > 0) {

            for (int n = 0; n < uiBean.getWarningMessageIdList().size(); n++) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_BETUKYKINFOWARNING,
                    uiBean.getWarningMessageIdList().get(n), uiBean.getWarningMessageList().get(n));
            }
        }

        SetTetudukityuui.exec(pKhozenCommonParam, uiBean);

        SetKeiyakusya.exec(pKhozenCommonParam, uiBean);

        SetTuusinsaki.exec(pKhozenCommonParam, uiBean);

        SetHihokensya.exec(pKhozenCommonParam, uiBean);

        SetNkukt.exec(pKhozenCommonParam, uiBean);

        SetKeizokuNkukt.exec(pKhozenCommonParam, uiBean);

        SetSbHenkanukt.exec(pKhozenCommonParam, uiBean);

        SetSbHkukt.exec(pKhozenCommonParam, uiBean);

        SetTrkKazoku.exec(pKhozenCommonParam, uiBean);

        SetKyksyadairi.exec(pKhozenCommonParam, uiBean);

        SetSiteiseikyuu.exec(pKhozenCommonParam, uiBean);

        SetHosyou setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        setHosyou.exec(pKhozenCommonParam, uiBean);

        SetSonotaTk.exec(pKhozenCommonParam, uiBean);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);
        setHaraikomiInfo.exec(pKhozenCommonParam, uiBean);

        SetTokusin.exec(pKhozenCommonParam, uiBean);

        SetKariukekin setKariukekin = SWAKInjector.getInstance(SetKariukekin.class);
        setKariukekin.exec(pKhozenCommonParam, uiBean);

        SetDattai.exec(pKhozenCommonParam, uiBean);

        SetHaitoukin setHaitoukin = SWAKInjector.getInstance(SetHaitoukin.class);
        setHaitoukin.exec(pKhozenCommonParam, uiBean);

        SetKhTkshrSiharaiKouza setKhTkshrSiharaiKouza = SWAKInjector.getInstance(SetKhTkshrSiharaiKouza.class);
        setKhTkshrSiharaiKouza.exec(pKhozenCommonParam, uiBean);

        kykKihon = hozenDomManager.getKykKihon(syono);

        if (kykKihon == null) {
            throw new CommonBizAppException("契約基本TBL  証券番号 = " + syono);
        }

        List<IT_KykDairiten> kykDairitenlst = kykKihon.getKykDairitens();
        if (kykDairitenlst.size() == 0) {
            throw new CommonBizAppException("契約代理店TBL  証券番号 = " + syono);
        }

        String drtencd;
        String bosyuucd;

        IT_KykDairiten KykDairitenShu = kykDairitenlst.get(0);

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);

        if (KykDairitenShu != null) {
            drtencd = KykDairitenShu.getDrtencd();
            bosyuucd = KykDairitenShu.getBosyuucd();
            uiBean.setDispbosyuucd1(bosyuucd);
            uiBean.setDispbunwari1(KykDairitenShu.getBunwari());

            String dispdrtencd1 = "";
            String dispdrtennm1 = "";

            List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtencd);

            if (bzGetAgInfoBeanList.size() > 0) {
                dispdrtencd1 = bzGetAgInfoBeanList.get(2).getDrtenCd();
                dispdrtennm1 = bzGetAgInfoBeanList.get(2).getKanjiDairitenNm();
            }

            uiBean.setDispdrtencd1(dispdrtencd1);
            uiBean.setDispdrtennm1(dispdrtennm1);

            BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(bosyuucd);

            if (bzGetBsInfoBean != null) {
                uiBean.setDispbosyuunm1(bzGetBsInfoBean.getKanjiBosyuuninNm());
            }
            else {
                uiBean.setDispbosyuunm1("");
            }
        }

        if (kykDairitenlst.size() == 2) {
            IT_KykDairiten kykDairitenJuu = kykDairitenlst.get(1);
            if (kykDairitenJuu != null) {
                drtencd = kykDairitenJuu.getDrtencd();
                bosyuucd = kykDairitenJuu.getBosyuucd();
                uiBean.setDispbosyuucd2(bosyuucd);
                uiBean.setDispbunwari2(kykDairitenJuu.getBunwari());

                String dispdrtencd2 = "";
                String dispdrtennm2 = "";

                List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtencd);

                if (bzGetAgInfoBeanList.size() > 0) {
                    dispdrtencd2 = bzGetAgInfoBeanList.get(2).getDrtenCd();
                    dispdrtennm2 = bzGetAgInfoBeanList.get(2).getKanjiDairitenNm();
                }

                uiBean.setDispdrtencd2(dispdrtencd2);
                uiBean.setDispdrtennm2(dispdrtennm2);

                BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(bosyuucd);

                if (bzGetBsInfoBean != null) {
                    uiBean.setDispbosyuunm2(bzGetBsInfoBean.getKanjiBosyuuninNm());
                }
                else {
                    uiBean.setDispbosyuunm2("");
                }
            }
        }

        uiBean.setBosyuuym(kykKihon.getBosyuuym());
        uiBean.setDairitenseisekiym(kykKihon.getSeisekiym());
        uiBean.setCifcd(kykKihon.getCifcd());
        uiBean.setBoskykjyoutai(kykKihon.getBoskykjyoutai());
        uiBean.setSmbckanriid(kykKihon.getSmbckanriid());

        uiBean.setDisplastsyosaihkymd(kykKihon.getLastsyosaihkymd());
        uiBean.setLastmeihenymd(kykKihon.getLastmeihenymd());
        uiBean.setLastjyuuhenymd(kykKihon.getLastjyuuhenymd());
        uiBean.setSyhenkouymd(kykKihon.getSyhenkouymd());
        uiBean.setKinouNm(kykKihon.getKinou().getKinouNm());
        uiBean.setKosid(kykKihon.getGyoumuKousinsyaId());
        uiBean.setKostime(kykKihon.getGyoumuKousinTime());
        uiBean.setDrtenListKensu(kykDairitenlst.size());
    }

    public void setTtdkRirekiListUiBean() {

        List<KhTtdkRirekiInfosBySyonoBean> kTKkTtdkRrk = null;

        kTKkTtdkRrk = uiBean.getKTKkTtdkRrkLst();
        if (kTKkTtdkRrk.size() == 0) {
            throw new BizLogicException(MessageId.EBA0054);
        }

        C_SyoriKbn syoriKbn = null;
        String syoriNaiyou = null;
        String henkouSikibetuKey;
        C_UmuKbn henkouRrkUmu;
        C_UmuKbn shrRrkUmu;

        List<TetudukiRirekiListDataSourceBean> tetudukiRirekiList = new ArrayList<>();

        for (int cnt = 0; cnt < kTKkTtdkRrk.size(); cnt++) {
            TetudukiRirekiListDataSourceBean tetudukiRirekiListDataSourceBean = new TetudukiRirekiListDataSourceBean();

            KhTtdkRirekiInfosBySyonoBean khTtdkRirekiInfosBySyonoBean = kTKkTtdkRrk.get(cnt);

            tetudukiRirekiListDataSourceBean.setDispsyoriymd(khTtdkRirekiInfosBySyonoBean.getSyoriYmd());
            syoriKbn = khTtdkRirekiInfosBySyonoBean.getSyorikbn();
            if (C_SyoriKbn.BLNK.eq(syoriKbn)) {
                syoriNaiyou = khTtdkRirekiInfosBySyonoBean.getKinouNm();
            }
            else {
                syoriNaiyou = khTtdkRirekiInfosBySyonoBean.getKinouNm()
                    + "（" + C_SyoriKbn.getContentByValue(C_SyoriKbn.PATTERN_SYOUKAI, syoriKbn.getValue()) + "）";
            }

            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(khTtdkRirekiInfosBySyonoBean
                .getSyorisosikicd());

            tetudukiRirekiListDataSourceBean.setDispsyorinaiyou(syoriNaiyou);
            tetudukiRirekiListDataSourceBean.setDispsyorisosikinm(bzGetSosikiDataBean.getKanjisosikinm20());
            if (BizUtil.isBlank(khTtdkRirekiInfosBySyonoBean.getUserNm())) {

                tetudukiRirekiListDataSourceBean.setDispsyoritntnmkj("");
            }
            else {

                tetudukiRirekiListDataSourceBean.setDispsyoritntnmkj(khTtdkRirekiInfosBySyonoBean.getUserNm());
            }

            henkouSikibetuKey = khTtdkRirekiInfosBySyonoBean.getHenkousikibetukey();
            tetudukiRirekiListDataSourceBean.setHenkouSikibetuKey(henkouSikibetuKey);
            henkouRrkUmu = khTtdkRirekiInfosBySyonoBean.getHenkourrkumu();
            if (C_UmuKbn.ARI.eq(henkouRrkUmu)) {
                if (khTtdkRirekiInfosBySyonoBean.getKhHenkouRirekisCount() == 0) {
                    henkouRrkUmu = C_UmuKbn.NONE;
                }
            }
            tetudukiRirekiListDataSourceBean.setHenkouRrkUmu(henkouRrkUmu);

            shrRrkUmu = khTtdkRirekiInfosBySyonoBean.getShrsyousaiumu();
            if (C_UmuKbn.ARI.eq(shrRrkUmu)) {
                if (khTtdkRirekiInfosBySyonoBean.getKhShrRirekiCount() == 0) {
                    shrRrkUmu = C_UmuKbn.NONE;
                }
            }
            tetudukiRirekiListDataSourceBean.setShrRrkUmu(shrRrkUmu);

            if (C_UmuKbn.ARI.eq(henkouRrkUmu) ||
                C_UmuKbn.ARI.eq(shrRrkUmu) ||
                !BizUtil.isBlank(khTtdkRirekiInfosBySyonoBean.getKouteikanriId()) ||
                IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(
                    khTtdkRirekiInfosBySyonoBean.getGyoumuKousinKinou())) {
                tetudukiRirekiListDataSourceBean.setHyoujilink1(MessageUtil
                    .getMessage(DDID_TETUDUKIRIREKILIST_HYOUJILINK1.getErrorResourceKey()));
            }

            tetudukiRirekiList.add(tetudukiRirekiListDataSourceBean);
        }
        uiBean.setTetudukiRirekiList(tetudukiRirekiList);
    }

    public void setTmttkRirekiListUiBean(KhozenCommonParam pKhozenCommonParam) {

        IT_KykKihon kykKihon = pKhozenCommonParam.getKeiyakuKihon(uiBean.getSyono());

        List<IT_KykSyouhn> kykSyouhnList = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);

        int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhnList.get(0).getSyouhncd());

        uiBean.setSyohinHanteiKbn(syohinHanteiKbn);

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknList = Lists.newArrayList();

        if (BizDateUtil.compareYmd(kykSyouhnList.get(0).getKykymd(), BizDate.getSysDate())
            == BizDateUtil.COMPARE_GREATER ) {
            khSisuurendoTmttknList = kykKihon.getKhSisuurendoTmttkns();

            if (khSisuurendoTmttknList.size() == 0) {
                throw new BizLogicException(MessageId.EIA0061);
            }

            uiBean.setTumitateRirekiUmuKbn(C_UmuKbn.ARI);

        }
        else {
            khSisuurendoTmttknList =
                khKeiyakuSyoukaiDao.getKhSisuurendoTmttknsBySyonoTmttknkouryokukaisiymd(uiBean.getSyono(),
                    BizDate.getSysDate());

            if (khSisuurendoTmttknList.size() == 0) {
                throw new BizLogicException(MessageId.EIA0061);
            }

            uiBean.setTumitateRirekiUmuKbn(C_UmuKbn.ARI);
        }

        ArrayList<HokenryouTmttInfoDataSourceBean> hokenryouTmttInfoDataSourceBeanList =
            new ArrayList<HokenryouTmttInfoDataSourceBean>();

        for (IT_KhSisuurendoTmttkn khSisuurendoTmttkn : khSisuurendoTmttknList) {
            HokenryouTmttInfoDataSourceBean hokenryouTmttInfoDataSourceBean =
                SWAKInjector.getInstance(HokenryouTmttInfoDataSourceBean.class);
            hokenryouTmttInfoDataSourceBean.setDisptaisyound(khSisuurendoTmttkn.getTmttkntaisyouym().getBizDateY());
            hokenryouTmttInfoDataSourceBean.setDispkouryokukaisiymd(khSisuurendoTmttkn.getTmttknkouryokukaisiymd());
            hokenryouTmttInfoDataSourceBean.setDispteiritutmttkngk(khSisuurendoTmttkn.getTeiritutmttkngk());
            hokenryouTmttInfoDataSourceBean.setDisptmttknhaneisisuu(khSisuurendoTmttkn.getTmttknhaneisisuu());
            if (khSisuurendoTmttkn.getSisuuupritu() != null) {
                hokenryouTmttInfoDataSourceBean.setDispsisuuupritu(khSisuurendoTmttkn.getSisuuupritu().multiply(100));
            }
            else {
                hokenryouTmttInfoDataSourceBean.setDispsisuuupritu(BizNumber.ZERO);
            }
            hokenryouTmttInfoDataSourceBean.setDispsisuurendoutmttkngk(khSisuurendoTmttkn.getSisuurendoutmttkngk());

            hokenryouTmttInfoDataSourceBeanList.add(hokenryouTmttInfoDataSourceBean);
        }

        uiBean.setHokenryouTmttInfo(hokenryouTmttInfoDataSourceBeanList);

        uiBean.setDisptmttknzoukaritujygn(BizNumber.ZERO);
        uiBean.setDispkykjisisuurendourate(BizNumber.ZERO);
        uiBean.setDisprendouritu(BizNumber.ZERO);
        uiBean.setDispkykjisisuurendourate2(BizNumber.ZERO);

        if (kykSyouhnList.get(0).getYendthnkymd() == null) {
            uiBean.setDisptmttknzoukaritujygn(kykSyouhnList.get(0).getTmttknzoukaritujygn().multiply(100));
            uiBean.setDispkykjisisuurendourate(kykSyouhnList.get(0).getKykjisisuurendourate());
            uiBean.setDisprendouritu(kykSyouhnList.get(0).getRendouritu().multiply(100));
            uiBean.setDispkykjisisuurendourate2(kykSyouhnList.get(0).getKykjisisuurendourate());
        }
        else {
            IT_KykSyouhnHnkmae kykSyouhnHnkmae = hozenDomManager.getKykSyouhnHnkmaeBySyono(uiBean.getSyono());

            if (kykSyouhnHnkmae != null) {
                uiBean.setDisptmttknzoukaritujygn(kykSyouhnHnkmae.getTmttknzoukaritujygn().multiply(100));
                uiBean.setDispkykjisisuurendourate(kykSyouhnHnkmae.getKykjisisuurendourate());
                uiBean.setDisprendouritu(kykSyouhnHnkmae.getRendouritu().multiply(100));
                uiBean.setDispkykjisisuurendourate2(kykSyouhnHnkmae.getKykjisisuurendourate());
            }
        }
    }

    public void initParam_gotoInputKey() {

        uiBean.setSrchResultLst(null);
        uiBean.setKTKkTtdkRrkLst(null);

        clearParam();
    }

    public void setUiBeanSearchResultBack() {

        initParam_gotoSearchResult();
    }

    public void initParam_gotoSearchResult() {

        uiBean.setKTKkTtdkRrkLst(null);

        String kensakuResultMaxKensuu = String.valueOf(uiBean.getKensakuResultMaxKensuu());
        String syono = uiBean.getSyono();
        BizDateYM srchKykym = uiBean.getSrchkykym();
        String srchDrtencd = uiBean.getSrchdrtencd();
        C_YuukousyoumetuKbn srchyuukousyoumetukbn = uiBean.getSrchyuukousyoumetukbn();
        String srchKyknmkn = uiBean.getSrchkyknmkn();
        String srchkyknmkj = uiBean.getSrchkyknmkj();
        BizDate srchKykseiymd = uiBean.getSrchkykseiymd();
        String srchtelno = uiBean.getSrchtelno();
        String srchtsinyno = uiBean.getSrchtsinyno();
        String srchHhknnmkn = uiBean.getSrchhhknnmkn();
        String srchhhknnmkj = uiBean.getSrchhhknnmkj();
        BizDate srchHhknseiymd = uiBean.getSrchhhknseiymd();
        C_Syorikeiyu syoriKeiyuKbn = uiBean.getSyoriKeiyuKbn();

        clearParam();

        uiBean.setKensakuResultMaxKensuu(Integer.valueOf(kensakuResultMaxKensuu));

        uiBean.setSyono(syono);
        uiBean.setSrchkykym(srchKykym);
        uiBean.setSrchdrtencd(srchDrtencd);
        uiBean.setSrchyuukousyoumetukbn(srchyuukousyoumetukbn);
        uiBean.setSrchkyknmkn(srchKyknmkn);
        uiBean.setSrchkyknmkj(srchkyknmkj);
        uiBean.setSrchkykseiymd(srchKykseiymd);
        uiBean.setSrchtelno(srchtelno);
        uiBean.setSrchtsinyno(srchtsinyno);
        uiBean.setSrchhhknnmkn(srchHhknnmkn);
        uiBean.setSrchhhknnmkj(srchhhknnmkj);
        uiBean.setSrchhhknseiymd(srchHhknseiymd);

        uiBean.setSyoriKeiyuKbn(syoriKeiyuKbn);
    }

    public void clearTtdkSyousai() {
        uiBean.setHenkounaiyouList(null);
        uiBean.setShrSyousaiUmu(C_UmuKbn.NONE);
        uiBean.setKinouHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
        uiBean.setDispyentuikahrkkin(BizCurrency.optional());
        uiBean.setDisptuikahrkkin(BizCurrency.optional());
        uiBean.setDispnyknjikwsratetkyymd(null);
        uiBean.setDispnyknjikwsrate(BizNumber.optional());
        uiBean.setKyktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setSyoruiukeymd(null);
        uiBean.setShrymd(null);
        uiBean.setCalckijyunymd(null);
        uiBean.setNykntuukashrgkgoukeikakunin(BizCurrency.optional());
        uiBean.setKihrkmp(BizCurrency.optional());
        uiBean.setKeitorikrkgk(BizCurrency.optional());
        uiBean.setShrgkkei(BizCurrency.optional());
        uiBean.setHenkank(BizCurrency.optional());
        uiBean.setShrgkgoukeikakunin(BizCurrency.optional());
        uiBean.setPtumitatekin(BizCurrency.optional());
        uiBean.setMikeikap(BizCurrency.optional());
        uiBean.setZennouseisankin(BizCurrency.optional());
        uiBean.setKaiyakuhr(BizCurrency.optional());
        uiBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.optional());
        uiBean.setSonotashrgk(BizCurrency.optional());
        uiBean.setGstszeigk(BizCurrency.optional());
        uiBean.setGsbunritaisyou(C_UmuKbn.NONE);
        uiBean.setDisptienrskkisanymdnissuu("");
        uiBean.setSntshrgksssonotashrgk(BizCurrency.optional());
        uiBean.setSntshrgkssgikshrratetekiymd(null);
        uiBean.setSntshrgkssgikshrrate(BizNumber.optional());
        uiBean.setSntshrgkssgikshrkyktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setSntshrgkssyensonotashrgk(BizCurrency.optional());
        uiBean.setSntshrgkssyenkamikeikap(BizCurrency.optional());
        uiBean.setSntshrgkssyenzennousisnkgk(BizCurrency.optional());
        uiBean.setSntshrgkssyenazukarikin(BizCurrency.optional());
        uiBean.setSntshrgkssyenhaitoukin(BizCurrency.optional());
        uiBean.setSntshrgkssyentkbthaitoukin(BizCurrency.optional());
        uiBean.setSntshrgkssyenkakrkgk(BizCurrency.optional());
        uiBean.setShrtienrsk(BizCurrency.optional());
        uiBean.setJpyshrgkgoukeikakunin(BizCurrency.optional());
        uiBean.setJpyptumitatekin(BizCurrency.optional());
        uiBean.setJpykaiyakuhr(BizCurrency.optional());
        uiBean.setYenkamikeikap(BizCurrency.optional());
        uiBean.setYenkazennouseisankgk(BizCurrency.optional());
        uiBean.setYenkaazukarikingk(BizCurrency.optional());
        uiBean.setYenkahaitoukin(BizCurrency.optional());
        uiBean.setYentkbthaitoukin(BizCurrency.optional());
        uiBean.setYenkakrkgk(BizCurrency.optional());
        uiBean.setDispjptienrskkisanymdnissuu("");
        uiBean.setJpyshrtienrsk(BizCurrency.optional());
        uiBean.setJpygstszeigk(BizCurrency.optional());
        uiBean.setShrsyousaikaiyakuhr(BizCurrency.optional());
        uiBean.setShrsyousaijpykaiyakuhr(BizCurrency.optional());
        uiBean.setShrsyousaiptumitatekin(BizCurrency.optional());
        uiBean.setShrsyousaijpyptumitatekin(BizCurrency.optional());
        uiBean.setYenshrratetekiymd(null);
        uiBean.setYenshrrate(BizNumber.optional());
        uiBean.setShrkyktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setYenkiykhrssyenkiykhrgoukei(BizCurrency.optional());
        uiBean.setYenkiykhrssyenshrratetkymd(null);
        uiBean.setYenkiykhrssyenshrratete(BizNumber.optional());
        uiBean.setYenkiykhrssshrkyktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setYenkiykhrsskaiyakuhrgoukei(BizCurrency.optional());
        uiBean.setYenkiykhrsskaiyakuhryen(BizCurrency.optional());
        uiBean.setYenkiykhrssmikeikap(BizCurrency.optional());
        uiBean.setYenkiykhrsszennouseisankin(BizCurrency.optional());
        uiBean.setYenkiykhrsskykhnkkaiyakuhr(BizCurrency.optional());
        uiBean.setYenptmttssyenptmttgoukei(BizCurrency.optional());
        uiBean.setYenptmttssyenshrratetkymd(null);
        uiBean.setYenptmttssyenshrratete(BizNumber.optional());
        uiBean.setYenptmttssshrkyktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setYenptmttssptumitategoukei(BizCurrency.optional());
        uiBean.setYenptmttssptumitate(BizCurrency.optional());
        uiBean.setYenptmttssmikeikap(BizCurrency.optional());
        uiBean.setYenptmttsszennouseisankin(BizCurrency.optional());
        uiBean.setYenptmttsskykhnkkaiyakuhr(BizCurrency.optional());
        uiBean.setYendthnkshrgkgoukei(BizCurrency.optional());
        uiBean.setYendthnkkaiyakuhr(BizCurrency.optional());
        uiBean.setYendthnkmikeikap(BizCurrency.optional());
        uiBean.setYendthnkzennouseisankin(BizCurrency.optional());
        uiBean.setYendthnkptumitatekin(BizCurrency.optional());
        uiBean.setYendthnkhaitoukin(BizCurrency.optional());
        uiBean.setYendthnktkbthaitoukin(BizCurrency.optional());
        uiBean.setYendthnkkrkgk(BizCurrency.optional());
        uiBean.setYendthnkhr(BizCurrency.optional());
        uiBean.setSonotaseisan(BizCurrency.optional());
        uiBean.setYendthnkgstszeigk(BizCurrency.optional());
        uiBean.setDispyendttienrskksnbinissuu("");
        uiBean.setYendthnkshrtienrsk(BizCurrency.optional());
        uiBean.setPtumitatekinssptumitatekin(BizCurrency.optional());
        uiBean.setTeiritutmttkngk(BizCurrency.optional());
        uiBean.setSisuurendoutmttkngk(BizCurrency.optional());
        uiBean.setKiykhrsyousaikaiyakuhr(BizCurrency.optional());
        uiBean.setKiykhrsyousaiptumitatekin(BizCurrency.optional());
        uiBean.setKiykhrsyousaisjkkktyouseirt(BizNumber.optional());
        uiBean.setKiykhrsyousaikaiyakukjgk(BizCurrency.optional());
        uiBean.setKiykhrsyousaikaiyakukjritu(BizNumber.optional());
        uiBean.setSynykngk(BizCurrency.optional());
        uiBean.setZeimukwsratekjnymd(null);
        uiBean.setZeimukwsrate(BizNumber.optional());
        uiBean.setZeimukyktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setHtykeihi(BizCurrency.optional());
        uiBean.setGststaisyousaeki(BizCurrency.optional());
        uiBean.setZeimugstszeigk(BizCurrency.optional());
        uiBean.setYenshrkykhtykeihi(BizCurrency.optional());
        uiBean.setKykhnkkaisuu(0);
        uiBean.setSoukinsakinmkn("");
        uiBean.setSoukinsakinmkj("");
        uiBean.setSoukinsakiyno("");
        uiBean.setSoukinsakiadr1kj("");
        uiBean.setSoukinsakiadr2kj("");
        uiBean.setSoukinsakiadr3kj("");
        uiBean.setKyksyaszknmkn("");
        uiBean.setKyksyaszknmkj("");
        uiBean.setKyksyaszkyno("");
        uiBean.setKyksyaszkadr1kj("");
        uiBean.setKyksyaszkadr2kj("");
        uiBean.setKyksyaszkadr3kj("");
        uiBean.setSaikennmkj("");
        uiBean.setSaikennyno("");
        uiBean.setSaikenadr1kj("");
        uiBean.setSaikenadr2kj("");
        uiBean.setSaikenadr3kj("");
        uiBean.setYenshrtkumu(C_UmuKbn.NONE);
        uiBean.setInputshrhousiteikbn(C_InputShrhousiteiKbn.BLNK);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("");
        uiBean.setBanknmkj("");
        uiBean.setSitencd("");
        uiBean.setSitennmkj("");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("");
        uiBean.setKzdoukbn(C_Kzdou.BLNK);
        uiBean.setKzmeiginmkn("");
        uiBean.setKykmnmeigibangou("");
        uiBean.setUktmnmeigibangou("");
        uiBean.setSyoriKbn(C_SyoriKbn.BLNK);
        uiBean.setAllhyoujibtn("");
        uiBean.setImageid("");
        uiBean.setSyoruiInfoList(null);
        uiBean.setProgresshistoryinfo(null);
        uiBean.setTsinyno("");
        uiBean.setTsinadr1kj("");
        uiBean.setTsinadr2kj("");
        uiBean.setTsinadr3kj("");
        uiBean.setTsintelno("");
        uiBean.setDai2tsintelno("");
        uiBean.setYenkaiyakuhrstgk(BizCurrency.optional());
        uiBean.setKihrkmpsgk(BizCurrency.optional());
        uiBean.setOldkykkihrkmp(BizCurrency.optional());
        uiBean.setMeigiHnkJiyuu(C_Meigihnkjiyuu.BLNK);
        uiBean.setHasseiKazeiUmuKbn(C_UmuKbn.NONE);
        uiBean.setTumitatehaitouganrikin(BizCurrency.optional());
        uiBean.setDisphaitttienrskksnbinissuu("");
        uiBean.setHaitshrtienrsk(BizCurrency.optional());
        uiBean.setAzukarigoukeigk(BizCurrency.optional());
        uiBean.setAzukariaiyakuhr(BizCurrency.optional());
        uiBean.setAzukarijpygoukeigk(BizCurrency.optional());
        uiBean.setAzukarip(BizCurrency.optional());
        uiBean.setAzukarizennouseisankgk(BizCurrency.optional());
        uiBean.setAzukarihaitoukin(BizCurrency.optional());
        uiBean.setZeitekiazukarikinkjumu(C_UmuKbn.NONE);
        uiBean.setShrnaiyouumu(C_UmuKbn.NONE);
        uiBean.setYendtinfosyoruiuktkymd(null);
        uiBean.setYendtinfomkhgktttymd(null);
        uiBean.setYendtinfoyendthnkymd(null);
        uiBean.setYendtinfomkhgk(BizCurrency.optional());
        uiBean.setYendtinfokjnkngk(BizCurrency.optional());
        uiBean.setYendtinfomokuhyouti(null);
        uiBean.setYendtinfotoutatukngk(BizCurrency.optional());
        uiBean.setYendtinfoyendthnkkjnkngk(BizCurrency.optional());
        uiBean.setYendtinfoyendthnkkiykhr(BizCurrency.optional());
        uiBean.setYendtinfoyendthnkjikwsrate(BizNumber.optional());
        uiBean.setYendtinfoyendtkwratetkyymd(null);
        uiBean.setYendtinfokyktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setYendtinfoyendthnkhrgk(BizCurrency.optional());
        uiBean.setYendtinfobfrsibousyen(BizCurrency.optional());
        uiBean.setYendtinfonewkaiyakuhr(BizCurrency.optional());
        uiBean.setYendtinfoptumitatekin(BizCurrency.optional());
        uiBean.setYendtinfosjkkktyouseiritu(BizNumber.optional());
        uiBean.setYendtinfokaiyakukjgk(BizCurrency.optional());
        uiBean.setYendtinfokaiyakukoujyoritu(BizNumber.optional());
        uiBean.setKiykhrsyousaiyendthnkiykhr(BizCurrency.optional());
        uiBean.setYendtinfosyorikbn(C_SyoriKbn.BLNK);
        uiBean.setKaiyakukoujyoritutekiumu(C_UmuKbn.NONE);
        uiBean.setYendtinfomDispUmu(C_UmuKbn.NONE);
    }


    private void chkKeiyaku(String pSyono) {
        if (BizUtil.isBlank(pSyono)) {
            throw new BizLogicException(MessageId.EBC0043, MessageUtil.getMessage(DDID_KIHONINFO_SYONO
                .getErrorResourceKey()));
        }

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }
    }

    private void clearParam() {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.init(uiBean);

        SetBetukyk SetBetukyk = SWAKInjector.getInstance(SetBetukyk.class);

        SetBetukyk.init(uiBean);

        SetTetudukityuui.init(uiBean);

        SetKeiyakusya.init(uiBean);

        SetTuusinsaki.init(uiBean);

        SetHihokensya.init(uiBean);

        SetNkukt.init(uiBean);

        SetKeizokuNkukt.init(uiBean);

        SetSbHenkanukt.init(uiBean);

        SetSbHkukt.init(uiBean);

        SetTrkKazoku.init(uiBean);

        SetKyksyadairi.init(uiBean);

        SetSiteiseikyuu.init(uiBean);

        SetHosyou setHosyou = SWAKInjector.getInstance(SetHosyou.class);

        setHosyou.init(uiBean);

        SetSonotaTk.init(uiBean);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        setHaraikomiInfo.init(uiBean);

        SetTokusin.init(uiBean);

        SetKariukekin setKariukekin = SWAKInjector.getInstance(SetKariukekin.class);
        setKariukekin.init(uiBean);

        SetDattai.init(uiBean);

        SetHaitoukin setHaitoukin = SWAKInjector.getInstance(SetHaitoukin.class);
        setHaitoukin.init(uiBean);

        SetKhTkshrSiharaiKouza.init(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);

        setSyoruiInfoItiran.init(uiBean);

        uiBean.setKzkatesouhusaki1("");
        uiBean.setKzkatesouhusaki2("");

        uiBean.setKensakuResultMaxKensuu(null);
        uiBean.setSrchkykym(null);
        uiBean.setSrchdrtencd("");
        uiBean.setSrchyuukousyoumetukbn(C_YuukousyoumetuKbn.BLNK);
        uiBean.setSrchkyknmkn("");
        uiBean.setSrchkyknmkj("");
        uiBean.setSrchkykseiymd(null);
        uiBean.setSrchtelno("");
        uiBean.setSrchtsinyno("");
        uiBean.setSrchhhknnmkn("");
        uiBean.setSrchhhknnmkj("");
        uiBean.setSrchhhknseiymd(null);
        uiBean.setSyono("");
        uiBean.setYuukousyoumetukbn(C_YuukousyoumetuKbn.BLNK);
        uiBean.setKykjyoutai(C_Kykjyoutai.BLNK);
        uiBean.setSyoumetujiyuu(C_Syoumetujiyuu.BLNK);
        uiBean.setSyoumetuymd(null);
        uiBean.setMosymd(null);
        uiBean.setKktymd(null);
        uiBean.setMosukeymd(null);
        uiBean.setSeirituymd(null);
        uiBean.setSeisekiym(null);
        uiBean.setMosuktymdhkumu(C_UmuKbn.NONE);
        uiBean.setPyentuthouDispKbn(C_DispKbn.HIHYOUJI);
        uiBean.setPyentuthoukbn(C_PyenTutHouKbn.BLNK);

        uiBean.setDispdrtencd1("");
        uiBean.setDispdrtennm1("");
        uiBean.setDispbosyuucd1("");
        uiBean.setDispbosyuunm1("");
        uiBean.setDispbunwari1(BizNumber.optional());

        uiBean.setDispdrtencd2("");
        uiBean.setDispdrtennm2("");
        uiBean.setDispbosyuucd2("");
        uiBean.setDispbosyuunm2("");
        uiBean.setDispbunwari2(BizNumber.optional());

        uiBean.setBosyuuym(null);
        uiBean.setDairitenseisekiym(null);
        uiBean.setCifcd("");
        uiBean.setBoskykjyoutai(C_Boskykjyoutai.BLNK);
        uiBean.setSmbckanriid("");
        uiBean.setDisplastsyosaihkymd(null);
        uiBean.setLastmeihenymd(null);
        uiBean.setLastjyuuhenymd(null);
        uiBean.setSyhenkouymd(null);
        uiBean.setKinouNm("");
        uiBean.setKosid("");
        uiBean.setKostime("");
        uiBean.setTetudukiRirekiList(null);
        uiBean.setSyoriYmd(null);
        uiBean.setSyorinaiyou("");
        uiBean.setSyorisosikinm("");
        uiBean.setSyoritntnmkj("");
        uiBean.setShrSyousaiUmu(C_UmuKbn.NONE);
        uiBean.setHenkouRrkUmu(C_UmuKbn.NONE);
        uiBean.setHenkounaiyouList(null);
        uiBean.setSyoruiInfoList(null);
        uiBean.setProgresshistoryinfo(null);
        uiBean.setYenshrtkumu(C_UmuKbn.NONE);

        uiBean.setImageids(null);
        uiBean.setDispyentuikahrkkin(BizCurrency.optional());
        uiBean.setDisptuikahrkkin(BizCurrency.optional());
        uiBean.setDispnyknjikwsratetkyymd(null);
        uiBean.setDispnyknjikwsrate(BizNumber.optional());
        uiBean.setKyktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setSoukinsakinmkn("");
        uiBean.setSoukinsakinmkj("");
        uiBean.setSoukinsakiyno("");
        uiBean.setSoukinsakiadr1kj("");
        uiBean.setSoukinsakiadr2kj("");
        uiBean.setSoukinsakiadr3kj("");
        uiBean.setKyksyaszknmkn("");
        uiBean.setKyksyaszknmkj("");
        uiBean.setKyksyaszkyno("");
        uiBean.setKyksyaszkadr1kj("");
        uiBean.setKyksyaszkadr2kj("");
        uiBean.setKyksyaszkadr3kj("");
        uiBean.setSaikennmkj("");
        uiBean.setSaikennyno("");
        uiBean.setSaikenadr1kj("");
        uiBean.setSaikenadr2kj("");
        uiBean.setSaikenadr3kj("");
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setInputshrhousiteikbn(C_InputShrhousiteiKbn.BLNK);
        uiBean.setBankcd("");
        uiBean.setBanknmkj("");
        uiBean.setSitencd("");
        uiBean.setSitennmkj("");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("");
        uiBean.setKzdoukbn(C_Kzdou.BLNK);
        uiBean.setKzmeiginmkn("");
        uiBean.setItijiDispUmu(C_UmuKbn.NONE);
        uiBean.setKawaserateDispKbn(C_DispKbn.HIHYOUJI);
        uiBean.setKawaserateKahiKbn(C_KahiKbn.HUKA);
        uiBean.setDispyenhokenryou("");
        uiBean.setKwsrtinfokakuteikwsrate("");
        uiBean.setKwsrtinforstuukasyu("");
        uiBean.setKwsrtinfokyktuukasyu("");
        uiBean.setKwsrtinfoknsnkijyunymd("");
        uiBean.setKwsrtinfomessage1("");
        uiBean.setKwsrtinfomessage2("");

        uiBean.setAnnaiNo1(null);
        uiBean.setDispannaiym1(null);
        uiBean.setDispannaijyutoukaisuu1(null);
        uiBean.setDispannaigk1(BizCurrency.optional());
        uiBean.setDispannaijyutouym1(null);
        uiBean.setDispannaikeiro1(C_Nykkeiro.BLNK);
        uiBean.setDispannaijkkbn1(C_AnnaijkKbn.BLNK);
        uiBean.setHrkkeiro1(C_Hrkkeiro.BLNK);
        uiBean.setDispcredituragngjiyuukbn1(C_CreditUriageNgJiyuuKbn.BLNK);
        uiBean.setDisphurihunokbn1(C_HurihunoKbn.BLNK);

        uiBean.setAnnaiNo2(null);
        uiBean.setDispannaiym2(null);
        uiBean.setDispannaijyutoukaisuu2(null);
        uiBean.setDispannaigk2(BizCurrency.optional());
        uiBean.setDispannaijyutouym2(null);
        uiBean.setDispannaikeiro2(C_Nykkeiro.BLNK);
        uiBean.setDispannaijkkbn2(C_AnnaijkKbn.BLNK);
        uiBean.setHrkkeiro2(C_Hrkkeiro.BLNK);
        uiBean.setDispcredituragngjiyuukbn2(C_CreditUriageNgJiyuuKbn.BLNK);
        uiBean.setDisphurihunokbn2(C_HurihunoKbn.BLNK);

        uiBean.setAnnaiNo3(null);
        uiBean.setDispannaiym3(null);
        uiBean.setDispannaijyutoukaisuu3(null);
        uiBean.setDispannaigk3(BizCurrency.optional());
        uiBean.setDispannaijyutouym3(null);
        uiBean.setDispannaikeiro3(C_Nykkeiro.BLNK);
        uiBean.setDispannaijkkbn3(C_AnnaijkKbn.BLNK);
        uiBean.setHrkkeiro3(C_Hrkkeiro.BLNK);
        uiBean.setDispcredituragngjiyuukbn3(C_CreditUriageNgJiyuuKbn.BLNK);
        uiBean.setDisphurihunokbn3(C_HurihunoKbn.BLNK);

        uiBean.setAnnaiNo4(null);
        uiBean.setDispannaiym4(null);
        uiBean.setDispannaijyutoukaisuu4(null);
        uiBean.setDispannaigk4(BizCurrency.optional());
        uiBean.setDispannaijyutouym4(null);
        uiBean.setDispannaikeiro4(C_Nykkeiro.BLNK);
        uiBean.setDispannaijkkbn4(C_AnnaijkKbn.BLNK);
        uiBean.setHrkkeiro4(C_Hrkkeiro.BLNK);
        uiBean.setDispcredituragngjiyuukbn4(C_CreditUriageNgJiyuuKbn.BLNK);
        uiBean.setDisphurihunokbn4(C_HurihunoKbn.BLNK);

        uiBean.setAnnaiNo5(null);
        uiBean.setDispannaiym5(null);
        uiBean.setDispannaijyutoukaisuu5(null);
        uiBean.setDispannaigk5(BizCurrency.optional());
        uiBean.setDispannaijyutouym5(null);
        uiBean.setDispannaikeiro5(C_Nykkeiro.BLNK);
        uiBean.setDispannaijkkbn5(C_AnnaijkKbn.BLNK);
        uiBean.setHrkkeiro5(C_Hrkkeiro.BLNK);
        uiBean.setDispcredituragngjiyuukbn5(C_CreditUriageNgJiyuuKbn.BLNK);
        uiBean.setDisphurihunokbn5(C_HurihunoKbn.BLNK);

        uiBean.setAnnaiNo6(null);
        uiBean.setDispannaiym6(null);
        uiBean.setDispannaijyutoukaisuu6(null);
        uiBean.setDispannaigk6(BizCurrency.optional());
        uiBean.setDispannaijyutouym6(null);
        uiBean.setDispannaikeiro6(C_Nykkeiro.BLNK);
        uiBean.setDispannaijkkbn6(C_AnnaijkKbn.BLNK);
        uiBean.setHrkkeiro6(C_Hrkkeiro.BLNK);
        uiBean.setDispcredituragngjiyuukbn6(C_CreditUriageNgJiyuuKbn.BLNK);
        uiBean.setDisphurihunokbn6(C_HurihunoKbn.BLNK);

        uiBean.setAnnaiNo7(null);
        uiBean.setDispannaiym7(null);
        uiBean.setDispannaijyutoukaisuu7(null);
        uiBean.setDispannaigk7(BizCurrency.optional());
        uiBean.setDispannaijyutouym7(null);
        uiBean.setDispannaikeiro7(C_Nykkeiro.BLNK);
        uiBean.setDispannaijkkbn7(C_AnnaijkKbn.BLNK);
        uiBean.setHrkkeiro7(C_Hrkkeiro.BLNK);
        uiBean.setDispcredituragngjiyuukbn7(C_CreditUriageNgJiyuuKbn.BLNK);
        uiBean.setDisphurihunokbn7(C_HurihunoKbn.BLNK);

        uiBean.setAnnaiNo8(null);
        uiBean.setDispannaiym8(null);
        uiBean.setDispannaijyutoukaisuu8(null);
        uiBean.setDispannaigk8(BizCurrency.optional());
        uiBean.setDispannaijyutouym8(null);
        uiBean.setDispannaikeiro8(C_Nykkeiro.BLNK);
        uiBean.setDispannaijkkbn8(C_AnnaijkKbn.BLNK);
        uiBean.setHrkkeiro8(C_Hrkkeiro.BLNK);
        uiBean.setDispcredituragngjiyuukbn8(C_CreditUriageNgJiyuuKbn.BLNK);
        uiBean.setDisphurihunokbn8(C_HurihunoKbn.BLNK);

        uiBean.setAnnaiNo9(null);
        uiBean.setDispannaiym9(null);
        uiBean.setDispannaijyutoukaisuu9(null);
        uiBean.setDispannaigk9(BizCurrency.optional());
        uiBean.setDispannaijyutouym9(null);
        uiBean.setDispannaikeiro9(C_Nykkeiro.BLNK);
        uiBean.setDispannaijkkbn9(C_AnnaijkKbn.BLNK);
        uiBean.setHrkkeiro9(C_Hrkkeiro.BLNK);
        uiBean.setDispcredituragngjiyuukbn9(C_CreditUriageNgJiyuuKbn.BLNK);
        uiBean.setDisphurihunokbn9(C_HurihunoKbn.BLNK);

        uiBean.setNyuukinRirekiInfo(null);

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING1);
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING4);
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING5);
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_YUUKOUCHECKWARNING);
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_TORIATUKAITYUUI);
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_BETUKYKINFOWARNING);

        uiBean.setTtdkrrkumu(C_UmuKbn.NONE);
        uiBean.setSyoriKeiyuKbn(C_Syorikeiyu.BLNK);
        uiBean.setDispjkipjytym(null);
        uiBean.setNextannaiyoteiymd(null);
        uiBean.setHrkkjt(null);
        uiBean.setYykknmnryymd(null);
        uiBean.setDisptmttknzoukaritujygn(null);
        uiBean.setDispkykjisisuurendourate(null);
        uiBean.setDisprendouritu(null);
        uiBean.setDispkykjisisuurendourate2(null);

        if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(uiBean.getGyoumuyouKousinKinouId())
            || IKhozenCommonConstants.KINOUID_GENGAKU.equals(uiBean.getGyoumuyouKousinKinouId())
            || IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(uiBean.getGyoumuyouKousinKinouId())
            || (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(uiBean.getGyoumuyouKousinKinouId()) &&
                C_SyoriKbn.JIDOUSOUKINSEISANZUMI.eq(uiBean.getSyoriKbn()))
                || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())
                || C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {

            if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(uiBean.getGyoumuyouKousinKinouId())
                || IKhozenCommonConstants.KINOUID_GENGAKU.equals(uiBean.getGyoumuyouKousinKinouId())
                || IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(uiBean.getGyoumuyouKousinKinouId())) {
                uiBean.setSyoruiukeymd(null);
            }
            uiBean.setShrymd(null);
            uiBean.setShrgkgoukeikakunin(BizCurrency.optional());
            uiBean.setKaiyakuhr(BizCurrency.optional());
            uiBean.setMikeikap(BizCurrency.optional());
            uiBean.setZennouseisankin(BizCurrency.optional());
            uiBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.optional());
            uiBean.setSonotashrgk(BizCurrency.optional());
            uiBean.setGstszeigk(BizCurrency.optional());
            uiBean.setGsbunritaisyou(C_UmuKbn.NONE);
            uiBean.setShrtienrsk(BizCurrency.optional());
            uiBean.setDisptienrskkisanymdnissuu("");
            uiBean.setSntshrgksssonotashrgk(BizCurrency.optional());
            uiBean.setSntshrgkssgikshrratetekiymd(null);
            uiBean.setSntshrgkssgikshrrate(BizNumber.optional());
            uiBean.setSntshrgkssgikshrkyktuukasyu(C_Tuukasyu.BLNK);
            uiBean.setSntshrgkssyensonotashrgk(BizCurrency.optional());
            uiBean.setSntshrgkssyenkamikeikap(BizCurrency.optional());
            uiBean.setSntshrgkssyenzennousisnkgk(BizCurrency.optional());
            uiBean.setSntshrgkssyenazukarikin(BizCurrency.optional());
            uiBean.setSntshrgkssyenhaitoukin(BizCurrency.optional());
            uiBean.setSntshrgkssyentkbthaitoukin(BizCurrency.optional());
            uiBean.setSntshrgkssyenkakrkgk(BizCurrency.optional());
            uiBean.setJpyshrgkgoukeikakunin(BizCurrency.optional());
            uiBean.setJpykaiyakuhr(BizCurrency.optional());
            uiBean.setYenkamikeikap(BizCurrency.optional());
            uiBean.setYenkazennouseisankgk(BizCurrency.optional());
            uiBean.setYenkaazukarikingk(BizCurrency.optional());
            uiBean.setYenkahaitoukin(BizCurrency.optional());
            uiBean.setYentkbthaitoukin(BizCurrency.optional());
            uiBean.setYenkakrkgk(BizCurrency.optional());
            uiBean.setJpygstszeigk(BizCurrency.optional());
            uiBean.setJpyshrtienrsk(BizCurrency.optional());
            uiBean.setDispjptienrskkisanymdnissuu("");
            uiBean.setShrsyousaikaiyakuhr(BizCurrency.optional());
            uiBean.setShrsyousaijpykaiyakuhr(BizCurrency.optional());
            uiBean.setYenshrratetekiymd(null);
            uiBean.setYenshrrate(null);
            uiBean.setShrkyktuukasyu(C_Tuukasyu.BLNK);
            uiBean.setYenkiykhrssyenkiykhrgoukei(BizCurrency.optional());
            uiBean.setYenkiykhrssyenshrratetkymd(null);
            uiBean.setYenkiykhrssyenshrratete(BizNumber.optional());
            uiBean.setYenkiykhrssshrkyktuukasyu(C_Tuukasyu.BLNK);
            uiBean.setYenkiykhrsskaiyakuhrgoukei(BizCurrency.optional());
            uiBean.setYenkiykhrsskaiyakuhryen(BizCurrency.optional());
            uiBean.setYenkiykhrssmikeikap(BizCurrency.optional());
            uiBean.setYenkiykhrsszennouseisankin(BizCurrency.optional());
            uiBean.setYenkiykhrsskykhnkkaiyakuhr(BizCurrency.optional());
            uiBean.setYendthnkshrgkgoukei(BizCurrency.optional());
            uiBean.setYendthnkkaiyakuhr(BizCurrency.optional());
            uiBean.setYendthnkmikeikap(BizCurrency.optional());
            uiBean.setYendthnkzennouseisankin(BizCurrency.optional());
            uiBean.setYendthnkhaitoukin(BizCurrency.optional());
            uiBean.setYendthnktkbthaitoukin(BizCurrency.optional());
            uiBean.setYendthnkkrkgk(BizCurrency.optional());
            uiBean.setSonotaseisan(BizCurrency.optional());
            uiBean.setYendthnkgstszeigk(BizCurrency.optional());
            uiBean.setDispyendttienrskksnbinissuu("");
            uiBean.setYendthnkshrtienrsk(BizCurrency.optional());
            uiBean.setPtumitatekinssptumitatekin(BizCurrency.optional());
            uiBean.setTeiritutmttkngk(BizCurrency.optional());
            uiBean.setSisuurendoutmttkngk(BizCurrency.optional());
            uiBean.setKiykhrsyousaikaiyakuhr(BizCurrency.optional());
            uiBean.setKiykhrsyousaiptumitatekin(BizCurrency.optional());
            uiBean.setKiykhrsyousaisjkkktyouseirt(BizNumber.optional());
            uiBean.setKiykhrsyousaikaiyakukjgk(BizCurrency.optional());
            uiBean.setKiykhrsyousaikaiyakukjritu(BizNumber.optional());
            uiBean.setSynykngk(BizCurrency.optional());
            uiBean.setZeimukwsratekjnymd(null);
            uiBean.setZeimukwsrate(null);
            uiBean.setZeimukyktuukasyu(C_Tuukasyu.BLNK);
            uiBean.setHtykeihi(BizCurrency.optional());
            uiBean.setGststaisyousaeki(BizCurrency.optional());
            uiBean.setZeimugstszeigk(BizCurrency.optional());
            uiBean.setYenshrkykhtykeihi(BizCurrency.optional());
            uiBean.setKykhnkkaisuu(null);
            uiBean.setKyktrkskbn(C_KyktrksKbn.BLNK);
            uiBean.setAzukarigoukeigk(BizCurrency.optional());
            uiBean.setAzukariaiyakuhr(BizCurrency.optional());
            uiBean.setAzukarijpygoukeigk(BizCurrency.optional());
            uiBean.setAzukarip(BizCurrency.optional());
            uiBean.setAzukarizennouseisankgk(BizCurrency.optional());
            uiBean.setAzukarihaitoukin(BizCurrency.optional());
            uiBean.setZeitekiazukarikinkjumu(C_UmuKbn.NONE);
            uiBean.setShrnaiyouumu(C_UmuKbn.NONE);
        }
        else if (C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn())
            || C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn())
            || C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) {

            uiBean.setShrymd(null);
            uiBean.setNykntuukashrgkgoukeikakunin(BizCurrency.optional());
            uiBean.setKihrkmp(BizCurrency.optional());
            uiBean.setKeitorikrkgk(BizCurrency.optional());
            uiBean.setKyktrkskbn(C_KyktrksKbn.BLNK);

        }
        else if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {

            uiBean.setShrymd(null);
            uiBean.setShrgkgoukeikakunin(BizCurrency.optional());
            uiBean.setPtumitatekin(BizCurrency.optional());
            uiBean.setMikeikap(BizCurrency.optional());
            uiBean.setZennouseisankin(BizCurrency.optional());
            uiBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.optional());
            uiBean.setSonotashrgk(BizCurrency.optional());
            uiBean.setDisptienrskkisanymdnissuu("");
            uiBean.setShrtienrsk(BizCurrency.optional());
            uiBean.setSntshrgksssonotashrgk(BizCurrency.optional());
            uiBean.setSntshrgkssgikshrratetekiymd(null);
            uiBean.setSntshrgkssgikshrrate(BizNumber.optional());
            uiBean.setSntshrgkssgikshrkyktuukasyu(C_Tuukasyu.BLNK);
            uiBean.setSntshrgkssyensonotashrgk(BizCurrency.optional());
            uiBean.setSntshrgkssyenkamikeikap(BizCurrency.optional());
            uiBean.setSntshrgkssyenzennousisnkgk(BizCurrency.optional());
            uiBean.setSntshrgkssyenazukarikin(BizCurrency.optional());
            uiBean.setSntshrgkssyenhaitoukin(BizCurrency.optional());
            uiBean.setSntshrgkssyentkbthaitoukin(BizCurrency.optional());
            uiBean.setSntshrgkssyenkakrkgk(BizCurrency.optional());
            uiBean.setJpyshrgkgoukeikakunin(BizCurrency.optional());
            uiBean.setJpyptumitatekin(BizCurrency.optional());
            uiBean.setYenkamikeikap(BizCurrency.optional());
            uiBean.setYenkazennouseisankgk(BizCurrency.optional());
            uiBean.setYenkaazukarikingk(BizCurrency.optional());
            uiBean.setYenkahaitoukin(BizCurrency.optional());
            uiBean.setYentkbthaitoukin(BizCurrency.optional());
            uiBean.setYenkakrkgk(BizCurrency.optional());
            uiBean.setDispjptienrskkisanymdnissuu("");
            uiBean.setJpyshrtienrsk(BizCurrency.optional());
            uiBean.setShrsyousaiptumitatekin(BizCurrency.optional());
            uiBean.setShrsyousaijpyptumitatekin(BizCurrency.optional());
            uiBean.setYenshrratetekiymd(null);
            uiBean.setYenshrrate(null);
            uiBean.setShrkyktuukasyu(C_Tuukasyu.BLNK);
            uiBean.setYenptmttssyenptmttgoukei(BizCurrency.optional());
            uiBean.setYenptmttssyenshrratetkymd(null);
            uiBean.setYenptmttssyenshrratete(null);
            uiBean.setYenptmttssshrkyktuukasyu(C_Tuukasyu.BLNK);
            uiBean.setYenptmttssptumitategoukei(BizCurrency.optional());
            uiBean.setYenptmttssptumitate(BizCurrency.optional());
            uiBean.setYenptmttssmikeikap(BizCurrency.optional());
            uiBean.setYenptmttsszennouseisankin(BizCurrency.optional());
            uiBean.setYenptmttsskykhnkkaiyakuhr(BizCurrency.optional());
            uiBean.setYendthnkshrgkgoukei(BizCurrency.optional());
            uiBean.setYendthnkptumitatekin(BizCurrency.optional());
            uiBean.setYendthnkmikeikap(BizCurrency.optional());
            uiBean.setYendthnkzennouseisankin(BizCurrency.optional());
            uiBean.setYendthnkhaitoukin(BizCurrency.optional());
            uiBean.setYendthnktkbthaitoukin(BizCurrency.optional());
            uiBean.setYendthnkkrkgk(BizCurrency.optional());
            uiBean.setDispyendttienrskksnbinissuu("");
            uiBean.setYendthnkshrtienrsk(BizCurrency.optional());
            uiBean.setSynykngk(BizCurrency.optional());
            uiBean.setZeimukwsratekjnymd(null);
            uiBean.setZeimukwsrate(null);
            uiBean.setZeimukyktuukasyu(C_Tuukasyu.BLNK);
            uiBean.setHtykeihi(BizCurrency.optional());
            uiBean.setYenshrkykhtykeihi(BizCurrency.optional());
            uiBean.setKykhnkkaisuu(null);
            uiBean.setKyktrkskbn(C_KyktrksKbn.BLNK);
        }
        else if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(uiBean.getGyoumuyouKousinKinouId())) {

            uiBean.setShrymd(null);
            uiBean.setHenkank(BizCurrency.optional());
            uiBean.setYenhenkank(BizCurrency.optional());
            uiBean.setYenshrratetekiymd(null);
            uiBean.setYenshrrate(BizNumber.optional());
            uiBean.setShrkyktuukasyu(C_Tuukasyu.BLNK);
        }
        else if (IKhozenCommonConstants.KINOUID_KHYENDTHNKHRSHR.equals(uiBean.getGyoumuyouKousinKinouId())) {
            uiBean.setSyoruiukeymd(null);
            uiBean.setShrymd(null);
            uiBean.setYendthnkshrgkgoukei(BizCurrency.optional());
            uiBean.setYendthnkhr(BizCurrency.optional());
            uiBean.setDispyendttienrskksnbinissuu("");
            uiBean.setYendthnkshrtienrsk(BizCurrency.optional());
            uiBean.setSynykngk(BizCurrency.optional());
            uiBean.setHtykeihi(BizCurrency.optional());
            uiBean.setYenshrkykhtykeihi(BizCurrency.optional());
            uiBean.setKykhnkkaisuu(0);
        }
        else if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(uiBean.getGyoumuyouKousinKinouId()) ||
            (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(uiBean.getGyoumuyouKousinKinouId()) &&
                C_SyoriKbn.MISEISAN.eq(uiBean.getSyoriKbn()))) {
            uiBean.setHasseiKazeiUmuKbn(C_UmuKbn.NONE);
            uiBean.setSynykngk(BizCurrency.optional());
            uiBean.setHtykeihi(BizCurrency.optional());
            uiBean.setYenshrkykhtykeihi(BizCurrency.optional());
            uiBean.setKykhnkkaisuu(0);
        }
        else if (IKhozenCommonConstants.KINOUID_DSHR.equals(uiBean.getGyoumuyouKousinKinouId())) {
            uiBean.setSyoruiukeymd(null);
            uiBean.setCalckijyunymd(null);
            uiBean.setShrymd(null);
            uiBean.setShrgkkei(BizCurrency.optional());
            uiBean.setTumitatehaitouganrikin(BizCurrency.optional());
            uiBean.setDisphaitttienrskksnbinissuu("");
            uiBean.setHaitshrtienrsk(BizCurrency.optional());
        }
        else if (IKhozenCommonConstants.KINOUID_KHDSEISANTUIBARAI.equals(uiBean.getGyoumuyouKousinKinouId())) {
            uiBean.setShrymd(null);
            uiBean.setShrkyktuukasyu(C_Tuukasyu.BLNK);
            uiBean.setShrgkgoukeikakunin(BizCurrency.optional());
            uiBean.setSonotashrgk(BizCurrency.optional());
            uiBean.setGstszeigk(BizCurrency.optional());
            uiBean.setDisptienrskkisanymdnissuu("");
            uiBean.setShrtienrsk(BizCurrency.optional());
            uiBean.setSntshrgksssonotashrgk(BizCurrency.optional());
            uiBean.setSntshrgkssgikshrratetekiymd(null);
            uiBean.setSntshrgkssgikshrrate(BizNumber.optional());
            uiBean.setSntshrgkssgikshrkyktuukasyu(C_Tuukasyu.BLNK);
            uiBean.setSntshrgkssyensonotashrgk(BizCurrency.optional());
            uiBean.setSntshrgkssyenhaitoukin(BizCurrency.optional());
            uiBean.setSntshrgkssyentkbthaitoukin(BizCurrency.optional());
            uiBean.setJpyshrgkgoukeikakunin(BizCurrency.optional());
            uiBean.setYenkahaitoukin(BizCurrency.optional());
            uiBean.setYentkbthaitoukin(BizCurrency.optional());
            uiBean.setJpygstszeigk(BizCurrency.optional());
            uiBean.setDispjptienrskkisanymdnissuu("");
            uiBean.setJpyshrtienrsk(BizCurrency.optional());
            uiBean.setYendthnkshrgkgoukei(BizCurrency.optional());
            uiBean.setYendthnkhaitoukin(BizCurrency.optional());
            uiBean.setYendthnktkbthaitoukin(BizCurrency.optional());
            uiBean.setYendthnkgstszeigk(BizCurrency.optional());
            uiBean.setDispyendttienrskksnbinissuu("");
            uiBean.setYendthnkshrtienrsk(BizCurrency.optional());
            uiBean.setSynykngk(BizCurrency.optional());
            uiBean.setZeimukwsratekjnymd(null);
            uiBean.setZeimukwsrate(BizNumber.optional());
            uiBean.setZeimukyktuukasyu(C_Tuukasyu.BLNK);
            uiBean.setHtykeihi(BizCurrency.optional());
            uiBean.setGststaisyousaeki(BizCurrency.optional());
            uiBean.setZeimugstszeigk(BizCurrency.optional());
            uiBean.setYenshrkykhtykeihi(BizCurrency.optional());
            uiBean.setKykhnkkaisuu(null);
            uiBean.setZeitekiazukarikinkjumu(C_UmuKbn.NONE);
            uiBean.setShrnaiyouumu(C_UmuKbn.NONE);
            uiBean.setGsbunritaisyou(C_UmuKbn.NONE);
        }

        if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(uiBean.getGyoumuyouKousinKinouId())) {
            uiBean.setYendtinfosyoruiuktkymd(null);
            uiBean.setYendtinfomkhgktttymd(null);
            uiBean.setYendtinfoyendthnkymd(null);
            uiBean.setYendtinfomkhgk(BizCurrency.optional());
            uiBean.setYendtinfokjnkngk(BizCurrency.optional());
            uiBean.setYendtinfomokuhyouti(null);
            uiBean.setYendtinfotoutatukngk(BizCurrency.optional());
            uiBean.setYendtinfoyendthnkkjnkngk(BizCurrency.optional());
            uiBean.setYendtinfoyendthnkkiykhr(BizCurrency.optional());
            uiBean.setYendtinfoyendthnkjikwsrate(BizNumber.optional());
            uiBean.setYendtinfoyendtkwratetkyymd(null);
            uiBean.setYendtinfokyktuukasyu(C_Tuukasyu.BLNK);
            uiBean.setYendtinfoyendthnkhrgk(BizCurrency.optional());
            uiBean.setYendtinfobfrsibousyen(BizCurrency.optional());
            uiBean.setYendtinfonewkaiyakuhr(BizCurrency.optional());
            uiBean.setKiykhrsyousaiyendthnkiykhr(BizCurrency.optional());
            uiBean.setYendtinfoptumitatekin(BizCurrency.optional());
            uiBean.setYendtinfosjkkktyouseiritu(BizNumber.optional());
            uiBean.setYendtinfokaiyakukjgk(BizCurrency.optional());
            uiBean.setYendtinfokaiyakukoujyoritu(BizNumber.optional());
            uiBean.setYendtinfosyorikbn(C_SyoriKbn.BLNK);
            uiBean.setKaiyakukoujyoritutekiumu(C_UmuKbn.NONE);
            uiBean.setYendtinfomDispUmu(C_UmuKbn.NONE);
        }
    }

    private void clearWarningMessage() {

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_BETUKYKINFOWARNING);
    }

    private void setKyknaiyouosiraseKngn() {
        boolean hanteiKbn = baseUserInfo.hasAuthenticatedFunctionModeByFunctionId(
            IKhozenCommonConstants.KINOUID_KHKYKNAIYOUOSIRASE, "default");

        if (hanteiKbn) {
            uiBean.setKyknaiyouosiraseKngnUmu(C_UmuKbn.ARI);
        }
        else {
            uiBean.setKyknaiyouosiraseKngnUmu(C_UmuKbn.NONE);
        }
    }
}

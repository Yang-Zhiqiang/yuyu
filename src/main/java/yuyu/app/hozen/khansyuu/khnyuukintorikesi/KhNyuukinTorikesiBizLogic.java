package yuyu.app.hozen.khansyuu.khnyuukintorikesi;

import static yuyu.app.hozen.khansyuu.khnyuukintorikesi.KhNyuukinTorikesiConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khansyuu.khnyuukintorikesi.dba.KhNyuukinTorikesiDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.BzSikinIdouRirekiTblSakusei;
import yuyu.common.biz.kaikei.SikinIdouRirekiDataBean;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.haitou.CheckDShrNyukinTorikesi;
import yuyu.common.hozen.khcommon.AnsyuuCommonSiwake;
import yuyu.common.hozen.khcommon.AnsyuuCommonSiwakeInBean;
import yuyu.common.hozen.khcommon.AnsyuuTaisyouGkBean;
import yuyu.common.hozen.khcommon.CheckIkktNyuknKykjyuti;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CommonSiwakeOutBean;
import yuyu.common.hozen.khcommon.CreditKessaiyouNoHensyuu;
import yuyu.common.hozen.khcommon.EditDairitenTesuuryouTbl;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunou;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunouParam;
import yuyu.common.hozen.khcommon.EditKoujyonaiyouTbl;
import yuyu.common.hozen.khcommon.EditKykSyhnRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KykSyouhnCommonParam;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobi;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetDattai;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetKariukekin;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetTokusin;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_KjsymnytblhensyuusyoriKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NykshrKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;

/**
 * 入金取消 のビジネスロジックです。
 */
public class KhNyuukinTorikesiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhNyuukinTorikesiUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private OutputReport outputReport;

    @Inject
    private CreateReport createReport;

    @Inject
    private KhNyuukinTorikesiDao khNyuukinTorikesiDao;

    void init() {
    }

    void clear() {
    }

    void pushKakuninBL() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        IT_KykSyouhn kykSyouhn = checkKeiyaku();

        IT_AnsyuKihon ansyuKihon = khNyuukinTorikesiDao.getAnsyuKihon(uiBean.getSyono());

        uiBean.setAnsyuKihon(ansyuKihon);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        checkYuukouJyoutai(khozenCommonParam);

        hanteiTetuduki(khozenCommonParam);

        checkJyutouYM();

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = checkNyukinRireki();

        checkKeiyakuHenkou();


        if (BizDateUtil.compareYm(
            kykSyouhn.getKykymd().getBizDateYM(),
            uiBean.getJyuutouym()) == BizDateUtil.COMPARE_EQUAL) {

            throw new BizLogicException(MessageId.EIA0090);
        }

        setNyukin(kykSyouhn.getKykymd(), nyknJissekiRirekiLst);

        setUiBean(khozenCommonParam);
    }

    @Transactional
    void pushKakuteiBL () {

        BizDate denYmd = BizDate.getSysDate();
        BizDate sysDate = BizDate.getSysDate();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        int krukNum = getKrukNum();

        IT_NyknJissekiRireki nyknJissekiRireki = getNyknJskRrk();

        String sikibetuKey = khozenCommonParam.getSikibetuKey(uiBean.getSyono());

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
        tableMaintenanceUtil.backUp(uiBean.getSyono(), sikibetuKey);

        updateKykKihon(sysDate,sysDateTimeMilli);

        IT_KhTtdkRireki khTtdkRireki = khNyuukinTorikesiDao.createKhTtdkRireki(uiBean.getKykKihon());
        khTtdkRireki.setHenkousikibetukey(sikibetuKey);

        List<IT_KykSyouhn> kykSyouhnLst = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);

        IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);

        AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean = SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);

        List<AnsyuuTaisyouGkBean> ansyuuTaisyouGkBeanLst = Lists.newArrayList();

        AnsyuuTaisyouGkBean seisankKariukegkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        seisankKariukegkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);
        seisankKariukegkBean.setTaisyouGk(uiBean.getRsgaku());
        seisankKariukegkBean.setKeiyakutuukaGk(uiBean.getRsgaku());
        seisankKariukegkBean.setNykdenYmd(uiBean.getNykdenYmd());
        seisankKariukegkBean.setHrkkaisuu(uiBean.getHrkkaisuu());
        seisankKariukegkBean.setJyutouStartYm(uiBean.getDispjyuutouym());
        seisankKariukegkBean.setJyutouKaisuuY(uiBean.getJyutoukaisuuy());
        seisankKariukegkBean.setJyutouKaisuuM(uiBean.getJyutoukaisuum());
        ansyuuTaisyouGkBeanLst.add(seisankKariukegkBean);

        AnsyuuTaisyouGkBean seisankKariukegkBean1 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        seisankKariukegkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
        seisankKariukegkBean1.setTaisyouGk(uiBean.getRsgaku());
        seisankKariukegkBean1.setKeiyakutuukaGk(uiBean.getRsgaku());
        ansyuuTaisyouGkBeanLst.add(seisankKariukegkBean1);

        ansyuuCommonSiwakeInBean.setKinouId(khozenCommonParam.getFunctionId());
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.HOZEN);
        ansyuuCommonSiwakeInBean.setSyouhinCd(kykSyouhn.getSyouhncd());
        ansyuuCommonSiwakeInBean.setSyouhnsdno(kykSyouhn.getSyouhnsdno());
        ansyuuCommonSiwakeInBean.setDenYmd(denYmd);
        ansyuuCommonSiwakeInBean.setSyoriYmd(sysDate);
        ansyuuCommonSiwakeInBean.setKykYmd(uiBean.getKykYmd());
        ansyuuCommonSiwakeInBean.setSyono(uiBean.getSyono());
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(ansyuuTaisyouGkBeanLst);

        AnsyuuCommonSiwake ansyuuCommonSiwake = SWAKInjector.getInstance(AnsyuuCommonSiwake.class);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = SWAKInjector.getInstance(BzDenpyouDataTourokuBean.class);

        bzDenpyouDataTourokuBean.setIbSyono(uiBean.getSyono());
        bzDenpyouDataTourokuBean.setIbHuridenatesakicd(commonSiwakeOutBean.getHuridenatesakiCd());
        bzDenpyouDataTourokuBean.setIbTantocd(commonSiwakeOutBean.getTantoCd());
        bzDenpyouDataTourokuBean.setIbDenymd(commonSiwakeOutBean.getDenyMd());
        bzDenpyouDataTourokuBean.setIbTuukasyu(commonSiwakeOutBean.getTuukasyu());
        bzDenpyouDataTourokuBean.setIbHuridenskskbn(commonSiwakeOutBean.getHuridensksKbn());
        bzDenpyouDataTourokuBean.setIbDenhnknhoukbn(commonSiwakeOutBean.getDenhnknhouKbn());
        bzDenpyouDataTourokuBean.setIbDenshrhoukbn(commonSiwakeOutBean.getDenshrhouKbn());
        bzDenpyouDataTourokuBean.setIbSyoriymd(commonSiwakeOutBean.getSyoriYmd());
        bzDenpyouDataTourokuBean.setIbSyoricd(commonSiwakeOutBean.getSyoriCd());
        bzDenpyouDataTourokuBean.setIbSyorisosikicd(khozenCommonParam.getTmSosikiCd());
        bzDenpyouDataTourokuBean.setIbKyktuukasyu(commonSiwakeOutBean.getKyktuukaSyu());
        bzDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(khozenCommonParam.getUserID());
        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(false);
        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(null);
        bzDenpyouDataTourokuBean.setIbSyouhncd(kykSyouhn.getSyouhncd());
        bzDenpyouDataTourokuBean.setIbSyouhnsdno(kykSyouhn.getSyouhnsdno());
        bzDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst());

        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);

        List<IT_KhDenpyoData> khDenpyoDataLst = bzDenpyouDataSks.execKh(bzDenpyouDataTourokuBean);

        for (IT_KhDenpyoData khDenpyoData : khDenpyoDataLst) {
            khNyuukinTorikesiDao.insert(khDenpyoData);
        }

        String denrenno = khDenpyoDataLst.get(0).getDenrenno();

        updateAnsyuKihon(sysDateTimeMilli);

        updateNyknJskRrk(denrenno,denYmd,sysDate,sysDateTimeMilli,nyknJissekiRireki);

        editKoujyonaiyou(nyknJissekiRireki, sysDate, khozenCommonParam, kykSyouhn);

        updateKariukekin(krukNum,denYmd,sysDate,sysDateTimeMilli, nyknJissekiRireki.getCreditkessaiyouno());

        C_Kykjyoutai kykjyoutai = kykSyouhn.getKykjyoutai();

        if (C_Hrkkaisuu.TUKI.eq(uiBean.getKykKihon().getHrkkaisuu())) {
            updateKykSyouhn(khozenCommonParam, sysDate, sysDateTimeMilli, kykSyouhn);
        }

        String youkyuuNo = palKykNaiyouKousin(kykjyoutai, kykSyouhn);

        editTtdkRireki(sysDate,sysDateTimeMilli, youkyuuNo, khozenCommonParam);

        editDairitenTesuuryouTbl(tableMaintenanceUtil.getBakKykKihon(),khozenCommonParam);

        updateSikinIdouRireki(khozenCommonParam, sysDate, kykSyouhn, khDenpyoDataLst, nyknJissekiRireki);

        setJimuRenrakusyuunouMsg(krukNum, sysDate, khozenCommonParam, nyknJissekiRireki.getCreditkessaiyouno());

        khNyuukinTorikesiDao.update(uiBean.getKykKihon());

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void  printOut () {

        String tyouhyouKey = uiBean.getTyouhyouKey();

        outputReport.outputPDFByJoinKey(tyouhyouKey);
    }


    private IT_KykSyouhn checkKeiyaku () {

        IT_KykKihon kykKihon = khNyuukinTorikesiDao.getKykKihon(uiBean.getSyono());

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setKykKihon(kykKihon);

        List<IT_KykSyouhn> kykKihonlist = khNyuukinTorikesiDao.getKykSyouhns2(kykKihon);

        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();

        if(kykKihonlist.size() > 0){

            kykSyouhn = kykKihonlist.get(0);
        }

        return kykSyouhn;
    }

    private void checkJyutouYM () {
        SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);

        setYuuyokknmanryobi.exec(uiBean.getSyono(), uiBean.getJyuutouym());

        BizDate yuuyokknMnrybi = setYuuyokknmanryobi.getYuuyokknMnrybi();

        if (BizDateUtil.compareYmd(yuuyokknMnrybi, BizDate.getSysDate()) == BizDateUtil.COMPARE_LESSER) {
            throw new BizLogicException(MessageId.EIA0085);
        }
    }

    private List<IT_NyknJissekiRireki> checkNyukinRireki () {

        IT_KykKihon kykKihon = uiBean.getKykKihon();

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst =  khNyuukinTorikesiDao.getNyknJissekiRirekis(kykKihon, uiBean.getJyuutouym());

        if (uiBean.getAnsyuKihon() == null || nyknJissekiRirekiLst.size() == 0) {
            throw new BizLogicException(MessageId.EIA0086);
        }

        if (C_UmuKbn.ARI.eq(nyknJissekiRirekiLst.get(0).getIktnyuukinnumu()) &&
            !C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(nyknJissekiRirekiLst.get(0).getTikiktbrisyuruikbn()) &&
            !C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(nyknJissekiRirekiLst.get(0).getTikiktbrisyuruikbn())) {

            throw new BizLogicException(MessageId.EIA0162);
        }

        BizDateYM jkipjytym = uiBean.getAnsyuKihon().getJkipjytym();
        BizDate jkipjytymd = BizDate.valueOf(jkipjytym, 1);

        BizDateSpan bizDateSpan = new BizDateSpan(-Integer.valueOf(nyknJissekiRirekiLst.get(0).getJyutoukaisuuy()),-Integer.valueOf(nyknJissekiRirekiLst.get(0).getJyutoukaisuum()),0);
        jkipjytymd = jkipjytymd.add(bizDateSpan);

        if (BizDateUtil.compareYm(jkipjytymd.getBizDateYM(), uiBean.getJyuutouym()) != BizDateUtil.COMPARE_EQUAL) {
            throw new BizLogicException(MessageId.EIA0086);
        }

        CheckDShrNyukinTorikesi checkDShrNyukinTorikesi = SWAKInjector.getInstance(CheckDShrNyukinTorikesi.class);

        C_ErrorKbn errorKbn = checkDShrNyukinTorikesi.checkDShr(
            uiBean.getSyono(),
            uiBean.getJyuutouym(),
            BizDate.getSysDate());

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            throw new BizLogicException(MessageId.EHS0003, "配当支払チェックが実行できませんでした。");
        }

        if (C_UmuKbn.ARI.eq(checkDShrNyukinTorikesi.getDHuseigouUmu())) {

            throw new BizLogicException(MessageId.EHS0003, "配当整合チェックエラーです。");
        }

        if (C_UmuKbn.ARI.eq(checkDShrNyukinTorikesi.getDHaneiYmdUmu())) {

            throw new BizLogicException(MessageId.EIF3036);
        }

        if (nyknJissekiRirekiLst.get(0).getHrkp().compareTo(kykKihon.getHrkp()) != 0) {
            throw new BizLogicException(MessageId.EIA0107);
        }

        return nyknJissekiRirekiLst;
    }

    private void checkKeiyakuHenkou () {

        List<IT_KykSyouhn> kykSyouhnLst =  khNyuukinTorikesiDao.getKykSyouhns(uiBean.getKykKihon());

        BizDate kouryokuhasseiYmd = null;

        if (kykSyouhnLst.size() > 0) {

            BM_SyouhnZokusei syouhnZokusei = khNyuukinTorikesiDao.getSyouhnZokusei(kykSyouhnLst.get(0));

            if (syouhnZokusei != null) {
                kouryokuhasseiYmd = kykSyouhnLst.get(0).getKouryokuhasseiymd();
            }
        }

        BizDateYM kouryokuhasseiYm = null;

        if (kouryokuhasseiYmd != null) {
            kouryokuhasseiYm = kouryokuhasseiYmd.getBizDateYM();
        }

        if (BizDateUtil.compareYm(kouryokuhasseiYm, uiBean.getJyuutouym()) == BizDateUtil.COMPARE_GREATER ||
            BizDateUtil.compareYm(kouryokuhasseiYm, uiBean.getJyuutouym()) == BizDateUtil.COMPARE_EQUAL ) {
            throw new BizLogicException(MessageId.EIA0106);
        }
    }

    private void checkYuukouJyoutai (KhozenCommonParam pKhozenCommonParam) {

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }

        if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
            if (checkYuukouJyoutai.getWarningMessageIDList().size() != 0) {
                for (int i = 0; i < checkYuukouJyoutai.getWarningMessageIDList().size(); i++) {
                    String messageID = BizUtil.getGeneralMessageId(checkYuukouJyoutai.getWarningMessageIDList().get(i));
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                        messageID, checkYuukouJyoutai.getWarningMessageList().get(i));
                }
            }
        }
    }

    private void hanteiTetuduki (KhozenCommonParam pKhozenCommonParam) {

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(pKhozenCommonParam, uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(MessageId.EIA1006, hanteiTetuduki.getMessageParam());
        }

        if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
    }

    private void setNyukin (BizDate pKykYMD, List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst) {


        uiBean.setNykkeiro(pNyknJissekiRirekiLst.get(0).getNykkeiro());
        uiBean.setNyknaiyoukbn(pNyknJissekiRirekiLst.get(0).getNyknaiyoukbn());
        uiBean.setDispjyuutouym(pNyknJissekiRirekiLst.get(0).getJyutoustartym());
        uiBean.setJyutoukaisuuy(pNyknJissekiRirekiLst.get(0).getJyutoukaisuuy());
        uiBean.setJyutoukaisuum(pNyknJissekiRirekiLst.get(0).getJyutoukaisuum());
        uiBean.setRyosyuymd(pNyknJissekiRirekiLst.get(0).getRyosyuymd());
        uiBean.setRsgaku(pNyknJissekiRirekiLst.get(0).getRsgaku());
        uiBean.setRenNo(pNyknJissekiRirekiLst.get(0).getRenno());
        uiBean.setNykdenYmd(pNyknJissekiRirekiLst.get(0).getNykdenymd());
        uiBean.setHrkkaisuu(pNyknJissekiRirekiLst.get(0).getHrkkaisuu());
        uiBean.setKykYmd(pKykYMD);
        uiBean.setTikiktbrisyuruikbn(pNyknJissekiRirekiLst.get(0).getTikiktbrisyuruikbn());

        messageManager.addMessageId(MessageId.QBA0001);

    }

    private void setUiBean (KhozenCommonParam pKhozenCommonParam) {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);

        SetKihon.exec(pKhozenCommonParam, uiBean);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(pKhozenCommonParam, uiBean);

        if (uiBean.getWarningMessageIdList() != null && uiBean.getWarningMessageIdList().size() > 0) {
            for (int i = 0; i < uiBean.getWarningMessageIdList().size(); i++) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                    uiBean.getWarningMessageIdList().get(i), uiBean.getWarningMessageList().get(i));
            }
        }

        SetTetudukityuui.exec(pKhozenCommonParam, uiBean);

        SetKeiyakusya.exec(pKhozenCommonParam, uiBean);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);
        setHaraikomiInfo.exec(pKhozenCommonParam, uiBean);

        SetTokusin.exec(pKhozenCommonParam, uiBean);

        SetKariukekin setKariukekin = SWAKInjector.getInstance(SetKariukekin.class);
        setKariukekin.exec(pKhozenCommonParam, uiBean);

        SetDattai.exec(pKhozenCommonParam, uiBean);
    }

    private Integer getKrukNum () {

        Integer krukNum = 0;

        krukNum = khNyuukinTorikesiDao.getKariukekinMaxKrkno(uiBean.getSyono());

        if (krukNum != null) {
            krukNum = krukNum + 1;

        }
        else {
            krukNum = 1;
        }

        return krukNum;
    }

    private IT_NyknJissekiRireki getNyknJskRrk () {

        BizDateYM jyuutouYm =  uiBean.getJyuutouym();

        int renNo = uiBean.getRenNo();

        IT_NyknJissekiRireki nyknJissekiRireki = khNyuukinTorikesiDao.getNyknJissekiRireki(uiBean.getKykKihon(), jyuutouYm, renNo);

        if (nyknJissekiRireki == null) {
            throw new CommonBizAppException("入金実績履歴TBLが取得できませんでした。　証券番号＝" +  uiBean.getSyono() +
                "充当開始年月＝" + jyuutouYm +  "連番＝" +  renNo);
        }

        return nyknJissekiRireki;
    }

    private void updateKykKihon (BizDate pSysDate , String pSysTime) {

        IT_KykKihon kykKion = uiBean.getKykKihon();

        kykKion.setSyhenkouymd(pSysDate);
        kykKion.setGyoumuKousinKinou(kinou.getKinouId());
        kykKion.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        kykKion.setGyoumuKousinTime(pSysTime);
    }

    private void updateAnsyuKihon (String pSysTime) {

        IT_AnsyuKihon ansyuKihon = uiBean.getAnsyuKihon();

        ansyuKihon.setJkipjytym(uiBean.getJyuutouym());
        ansyuKihon.setGyoumuKousinKinou(kinou.getKinouId());
        ansyuKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        ansyuKihon.setGyoumuKousinTime(pSysTime);

        khNyuukinTorikesiDao.update(ansyuKihon);
    }

    private void updateNyknJskRrk(String pDenRenno, BizDate pDenYmd, BizDate pSysDate,String pSysTime,
        IT_NyknJissekiRireki pNyknJissekiRireki) {

        pNyknJissekiRireki.setNyktrksflg(C_Nyktrksflg.TORIKESI);
        pNyknJissekiRireki.setNyktrksymd(pSysDate);
        pNyknJissekiRireki.setNyktrksdenno(pDenRenno);
        pNyknJissekiRireki.setNyktrksdenymd(pDenYmd);
        pNyknJissekiRireki.setGyoumuKousinKinou(kinou.getKinouId());
        pNyknJissekiRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        pNyknJissekiRireki.setGyoumuKousinTime(pSysTime);
    }

    private void editKoujyonaiyou(IT_NyknJissekiRireki pNyknJissekiRireki, BizDate pSysDate,
        KhozenCommonParam pKhozenCommonParam, IT_KykSyouhn pKykSyouhn) {

        EditKoujyonaiyouTbl editKoujyonaiyouTbl = SWAKInjector.getInstance(EditKoujyonaiyouTbl.class);

        if (BizDateUtil.compareYm(
            uiBean.getJyuutouym(), pSysDate.getBizDateYM().addMonths(2)) == BizDateUtil.COMPARE_LESSER
            && C_Kykjyoutai.IKKATUNK.eq(pKykSyouhn.getKykjyoutai())) {

            editKoujyonaiyouTbl.setHenmaeHenkousikibetukey(pKykSyouhn.getHenkousikibetukey());
        }

        editKoujyonaiyouTbl.setNyknJskStartYm(pNyknJissekiRireki.getJyutoustartym());
        editKoujyonaiyouTbl.setNyknJskEndYm(pNyknJissekiRireki.getJyutouendym());
        editKoujyonaiyouTbl.setNyknJskRenno(pNyknJissekiRireki.getRenno());
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(pNyknJissekiRireki.getRyosyuymd());
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(pNyknJissekiRireki.getJyutoukaisuuy());
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(pNyknJissekiRireki.getJyutoukaisuum());
        editKoujyonaiyouTbl.setIkkatuNyknUmu(pNyknJissekiRireki.getIktnyuukinnumu());
        editKoujyonaiyouTbl.setNyknJskRysKwsrate(pNyknJissekiRireki.getRyosyukwsrate());
        List<KykSyouhnCommonParam> kykSyouhnCommonParamLst = Lists.newArrayList();

        List<IT_KykSyouhn> kykSyouhnLst = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);

        kykSyouhnCommonParamLst.addAll(kykSyouhnLst);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamLst);

        editKoujyonaiyouTbl.exec(pKhozenCommonParam, uiBean.getSyono(),
            C_KjsymnytblhensyuusyoriKbn.NYUUKINTORIKESI, pSysDate);
    }

    private void updateKariukekin(int pkrukNum, BizDate pDenpyouDate,
        BizDate pSysDate, String pSysTime, String pCreditKessaiyouNo) {

        IT_Kariukekin kariukekin = khNyuukinTorikesiDao.createKariukekin(uiBean.getKykKihon());

        kariukekin.setKrkno(pkrukNum);
        kariukekin.setKrkkeijyoymd(pSysDate);
        kariukekin.setKrkgk(uiBean.getRsgaku());
        kariukekin.setHasseidenymd(pDenpyouDate);
        kariukekin.setKrkriyuukbn(C_KrkriyuuKbn.PTORIKESI);
        kariukekin.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        kariukekin.setNykkeiro(C_Nykkeiro.OTHER);
        kariukekin.setJyuutouym(uiBean.getDispjyuutouym());
        kariukekin.setJyutoukaisuuy(uiBean.getJyutoukaisuuy());
        kariukekin.setJyutoukaisuum(uiBean.getJyutoukaisuum());
        kariukekin.setRyosyuymd(uiBean.getRyosyuymd());
        kariukekin.setHrkkaisuu(uiBean.getHrkkaisuu());
        kariukekin.setTikiktbrisyuruikbn(uiBean.getTikiktbrisyuruikbn());
        kariukekin.setGyoumuKousinKinou(kinou.getKinouId());
        kariukekin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        kariukekin.setGyoumuKousinTime(pSysTime);
        kariukekin.setCreditkessaiyouno(pCreditKessaiyouNo);

        BizPropertyInitializer.initialize(kariukekin);
    }

    private String palKykNaiyouKousin (C_Kykjyoutai pHenkouMaeKykjyoutai, IT_KykSyouhn pKykSyouhn) {
        String youkyuuNo = "";

        if (!pHenkouMaeKykjyoutai.eq(pKykSyouhn.getKykjyoutai())) {
            PALKykNaiyouKousin pALKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);

            pALKykNaiyouKousin.exec(uiBean.getKykKihon());

            youkyuuNo = pALKykNaiyouKousin.getYoukyuuno();
        }

        return youkyuuNo;
    }

    private void editTtdkRireki (BizDate pSysDate, String pSysTime, String pYoukyuuNo, KhozenCommonParam pKhozenCommonParam) {

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        editTtdkRirekiTblParam.setCommonParam(pKhozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
        editTtdkRirekiTblParam.setSyoriYmd(pSysDate);
        editTtdkRirekiTblParam.setSysTime(pSysTime);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        editTtdkRirekiTblParam.setYoukyuuNo(pYoukyuuNo);
        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
    }

    private void editDairitenTesuuryouTbl (IT_BAK_KykKihon pBAK_KykKihon,KhozenCommonParam pKhozenCommonParam) {

        EditDairitenTesuuryouTbl editDairitenTesuuryouTbl = SWAKInjector.getInstance(EditDairitenTesuuryouTbl.class);

        editDairitenTesuuryouTbl.exec(pKhozenCommonParam, uiBean.getSyono(), C_TsrysyoriKbn.NYUUKINTORIKESI,
            uiBean.getJyuutouym(), uiBean.getJyutoukaisuuy(), uiBean.getJyutoukaisuum(),
            BizCurrency.valueOf(0), BizCurrency.valueOf(0), pBAK_KykKihon);
    }

    private void setJimuRenrakusyuunouMsg(int pKrukNum, BizDate pSysDate, KhozenCommonParam pKhozenCommonParam, String pCreditKessaiyouNo) {

        String krkRiyuuKbnNm = C_KrkriyuuKbn.PTORIKESI.getContent();
        String nykKeiro = C_Nykkeiro.OTHER.getContent(C_Nykkeiro.PATTERN_DISP);

        String jyuutouYmWareki = "";

        if (uiBean.getDispjyuutouym() != null) {

            jyuutouYmWareki = DefaultDateFormatter.formatYMKanji(uiBean.getDispjyuutouym().getFirstDay());
        }

        String rsGaku = BizUtil.comma(uiBean.getRsgaku().toAdsoluteString());
        String ryosyuYmd = DefaultDateFormatter.formatYMDKanji(uiBean.getRyosyuymd());

        String kessaiyouNo = "";

        if (!BizUtil.isBlank(pCreditKessaiyouNo)) {

            CreditKessaiyouNoHensyuu creditKessaiyouNoHensyuu = SWAKInjector.getInstance(CreditKessaiyouNoHensyuu.class);

            kessaiyouNo = creditKessaiyouNoHensyuu.exec(pCreditKessaiyouNo);
        }

        List<String> jimuRenrakuhyouLst = Lists.newArrayList();

        jimuRenrakuhyouLst.add(STRING_KRK_KEIJYO);
        jimuRenrakuhyouLst.add("");
        jimuRenrakuhyouLst.add(STRING_KRKNO + pKrukNum);
        jimuRenrakuhyouLst.add(STRING_KRKRIYUU_KBN + krkRiyuuKbnNm);
        jimuRenrakuhyouLst.add(HRKKAISUU + uiBean.getHrkkaisuu().getContent());
        jimuRenrakuhyouLst.add(TKIKTBRISYURUIKBN + uiBean.getTikiktbrisyuruikbn().getContent());
        jimuRenrakuhyouLst.add(STRING_NYKKEIRO + nykKeiro);
        jimuRenrakuhyouLst.add(STRING_NYKNAIYOU_KBN + uiBean.getNyknaiyoukbn().getContent());
        jimuRenrakuhyouLst.add(STRING_JYUUTOU_YM + jyuutouYmWareki);

        if (uiBean.getJyutoukaisuuy() != null && uiBean.getJyutoukaisuuy() != 0) {

            jimuRenrakuhyouLst.add(STRING_JYUTOUKAISUU + uiBean.getJyutoukaisuuy() +
                MessageUtil.getMessage(MessageId.IKW0038));
        }
        else {

            jimuRenrakuhyouLst.add(STRING_JYUTOUKAISUU + uiBean.getJyutoukaisuum() +
                MessageUtil.getMessage(MessageId.IKW0039));
        }

        jimuRenrakuhyouLst.add(STRING_KRKGK + rsGaku + STRING_JPY);
        jimuRenrakuhyouLst.add(STRING_RYOSYU_YMD + ryosyuYmd);
        jimuRenrakuhyouLst.add(KESSAIYOUNO + kessaiyouNo);

        EditJimuRenrakusyuunouParam editJimuRenrakusyuunouParam =
            SWAKInjector.getInstance(EditJimuRenrakusyuunouParam.class);

        editJimuRenrakusyuunouParam.setJimurenrakuMsgList(jimuRenrakuhyouLst);

        EditJimuRenrakusyuunou editJimuRenrakusyuunou = SWAKInjector.getInstance(EditJimuRenrakusyuunou.class);

        ReportServicesBean reportServicesBean = editJimuRenrakusyuunou.exec(pKhozenCommonParam, uiBean.getSyono(),
            C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU , editJimuRenrakusyuunouParam, pSysDate);

        String tyouhyouKey = createReport.execNoCommit(reportServicesBean);

        uiBean.setTyouhyouKey(tyouhyouKey);
    }

    private void updateKykSyouhn(KhozenCommonParam pKhozenCommonParam, BizDate pSysDate, String pSysDateTimeMilli,
        IT_KykSyouhn pKykSyouhn) {

        CheckIkktNyuknKykjyuti checkIkktNyuknKykjyuti = SWAKInjector.getInstance(CheckIkktNyuknKykjyuti.class);

        C_Kykjyoutai kykjyoutai = checkIkktNyuknKykjyuti.exec(pSysDate, uiBean.getJyuutouym());

        if (C_Kykjyoutai.HRKMTYUU.eq(kykjyoutai) && C_Kykjyoutai.IKKATUNK.eq(pKykSyouhn.getKykjyoutai())) {

            EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

            editKykSyhnRirekiTbl.exec(pKhozenCommonParam, uiBean.getSyono());

            pKykSyouhn.setHenkousikibetukey(pKhozenCommonParam.getSikibetuKey(uiBean.getSyono()));
            pKykSyouhn.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
            pKykSyouhn.setGyoumuKousinKinou(kinou.getKinouId());
            pKykSyouhn.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            pKykSyouhn.setGyoumuKousinTime(pSysDateTimeMilli);
        }
    }

    private void updateSikinIdouRireki(KhozenCommonParam pKhozenCommonParam, BizDate pSysDate,
        IT_KykSyouhn pKykSyouhn, List<IT_KhDenpyoData> pKhDenpyoDataLst, IT_NyknJissekiRireki pNyknJissekiRireki) {

        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
            pKykSyouhn.getSyouhncd(), pKykSyouhn.getKyktuukasyu());

        SikinIdouRirekiDataBean sikinIdouRirekiDataBean = SWAKInjector.getInstance(SikinIdouRirekiDataBean.class);

        sikinIdouRirekiDataBean.setSyoriYmd(pSysDate);
        sikinIdouRirekiDataBean.setSyono(uiBean.getSyono());
        sikinIdouRirekiDataBean.setHenkouSikibetuKey(pKhozenCommonParam.getSikibetuKey(uiBean.getSyono()));
        sikinIdouRirekiDataBean.setTargetKinouId(pKhozenCommonParam.getFunctionId());
        sikinIdouRirekiDataBean.setNykshrKbn(C_NykshrKbn.NYUUKIN);
        sikinIdouRirekiDataBean.setSyoricd(kinou.getSyoricd());
        sikinIdouRirekiDataBean.setDensysKbn(pKhDenpyoDataLst.get(0).getDensyskbn());
        sikinIdouRirekiDataBean.setDenrenno(pKhDenpyoDataLst.get(0).getDenrenno());
        sikinIdouRirekiDataBean.setSeg1cd(syouhinbetuSegmentBean.getSegcd1());
        sikinIdouRirekiDataBean.setKykTuukasyu(pKykSyouhn.getKyktuukasyu());
        sikinIdouRirekiDataBean.setSyutkKbn(pKykSyouhn.getSyutkkbn());
        sikinIdouRirekiDataBean.setHrkkaisuu(pNyknJissekiRireki.getHrkkaisuu());
        sikinIdouRirekiDataBean.setSyouhnCd(pKykSyouhn.getSyouhncd());
        sikinIdouRirekiDataBean.setSyouhnSdno(pKykSyouhn.getSyouhnsdno());
        sikinIdouRirekiDataBean.setKykSyouhnRenno(pKykSyouhn.getKyksyouhnrenno());
        sikinIdouRirekiDataBean.setKykYmd(pKykSyouhn.getKykymd());
        sikinIdouRirekiDataBean.setSeirituYmd(uiBean.getKykKihon().getSeirituymd());
        sikinIdouRirekiDataBean.setJkipjytYm(uiBean.getJyuutouym());
        sikinIdouRirekiDataBean.setJyutouStartYm(pNyknJissekiRireki.getJyutoustartym());
        sikinIdouRirekiDataBean.setJyutouEndYm(pNyknJissekiRireki.getJyutouendym());
        sikinIdouRirekiDataBean.setNykkeiro(uiBean.getNykkeiro());
        sikinIdouRirekiDataBean.setNyknaiyouKbn(uiBean.getNyknaiyoukbn());
        sikinIdouRirekiDataBean.setNyktrksFlg(C_Nyktrksflg.TORIKESI);
        sikinIdouRirekiDataBean.setHrkp(uiBean.getKykKihon().getHrkp());
        sikinIdouRirekiDataBean.setHokenryou(pKykSyouhn.getHokenryou());

        BzSikinIdouRirekiTblSakusei bzSikinIdouRirekiTblSakusei = SWAKInjector
            .getInstance(BzSikinIdouRirekiTblSakusei.class);

        BT_SikinIdouRireki sikinIdouRireki = bzSikinIdouRirekiTblSakusei
            .editSikinIdouRirekiTblEntity(sikinIdouRirekiDataBean);

        bzSikinIdouRirekiTblSakusei.insertSikinIdouRirekiTblOne(sikinIdouRireki);

    }
}

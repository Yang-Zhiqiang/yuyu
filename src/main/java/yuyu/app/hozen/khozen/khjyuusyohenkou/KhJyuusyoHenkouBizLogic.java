package yuyu.app.hozen.khozen.khjyuusyohenkou;

import static yuyu.app.hozen.khozen.khjyuusyohenkou.GenKhJyuusyoHenkouConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.string.StringUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.CTIParamBean;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuu;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuuOutBean;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckProcessKekka;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.EditSeikyuusyoParam;
import yuyu.common.hozen.khcommon.EditSouhuannaiParam;
import yuyu.common.hozen.khcommon.EditTtdkKanryouParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiLinc;
import yuyu.common.hozen.khcommon.HanteiLincBean;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.common.hozen.koutei.KhProcessForward;
import yuyu.common.hozen.koutei.KhRuleBean;
import yuyu.common.hozen.prereport.HozenPreReportRenkeiBean;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetHituyouSyorui;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtil;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetKyksyadairi;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.hozen.setuibean.SetTrkKazoku;
import yuyu.common.hozen.setuibean.SetTuusinsaki;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_JyougenketasuutyoukaKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_TyhysakuseiyhKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_KhLincKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.IW_KhJyuusyoHenkouWk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.OutputReport;

/**
 * 住所変更 のビジネスロジックです。
 */
public class KhJyuusyoHenkouBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhJyuusyoHenkouUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private CheckYuukouJyoutai checkYuukouJyoutai;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private HanteiTetuduki hanteiTetuduki;

    @Inject
    private EditTtdkRirekiTblParam editTtdkRirekiTblParam;

    @Inject
    private EditTtdkRirekiTbl editTtdkRirekiTbl;

    @Inject
    private TableMaintenanceUtil tableMaintenanceUtil;

    @Inject
    private KhozenTyouhyouCtl khozenTyouhyouCtl;

    @Inject
    private OutputReport outputReport;

    @Inject
    private BzTaskStart bzTaskStart;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private EditSouhuannaiParam editSouhuannaiParam;

    @Inject
    private EditTtdkKanryouParam editTtdkKanryouParam;

    @Inject
    private HozenPreReportRenkeiBean hozenPreReportRenkeiBean;

    @Inject
    private EditSeikyuusyoParam editSeikyuusyoParam;

    @Inject
    private CheckYuuyokkngai checkYuuyokkngai;

    @Inject
    private SetToriatukaiTyuui setToriatukaiTyuui;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private SetSyoruiInfoItiran setSyoruiInfoItiran;

    @Inject
    private SetKouteiInfo setKouteiInfo;

    @Inject
    private SetProgressHistory setProgressHistory;

    @Inject
    private CheckKinouModeKengen checkKinouModeKengen;

    @Inject
    private CommonDispImage commonDispImage;

    @Inject
    private CheckProcessKekka checkProcessKekka;

    @Inject
    private CheckProcessKaishi checkProcessKaishi;

    @Inject
    private BzChkAdrKetasuu bzChkAdrKetasuu;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private CTIParamBean ctiParamBean;

    void init() {
    }

    void clear() {
    }

    @Transactional
    void iwfOpenBL() {

        checkKinouModeKengen.checkWorklistKinouModeKengen();

        BizPropertyInitializer.initialize(uiBean);

        String kouteikanriid = uiBean.getBzWorkflowInfo().getKouteiKanriId();

        String jimutetuzukicd = uiBean.getBzWorkflowInfo().getJimuTetuzukiCd();

        bzCommonLockProcess.lockProcess(kouteikanriid, jimutetuzukicd);

        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(kouteikanriid, jimutetuzukicd,
            uiBean.getBzWorkflowInfo().getTaskId(), bzCommonLockProcess.getKouteiLockKey());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteikanriid);

        String syono = gyoumuKouteiInfo.getSyono();
        uiBean.setSyono(syono);

        uiBean.setKouteikanriid(kouteikanriid);

        IW_KhJyuusyoHenkouWk khJyuusyoHenkouWk = hozenDomManager.getKhJyuusyoHenkouWk(kouteikanriid);

        if (khJyuusyoHenkouWk != null) {

            if (BizUtil.isBlank(khJyuusyoHenkouWk.getTsinyno()) &&
                BizUtil.isBlank(khJyuusyoHenkouWk.getTsinadr1kj()) &&
                BizUtil.isBlank(khJyuusyoHenkouWk.getTsintelno())) {
                uiBean.setTsinyno(khozenCommonParam.getKeiyakusya(syono).getTsinyno());
                uiBean.setTsinadr1kj(khozenCommonParam.getKeiyakusya(syono).getTsinadr1kj());
                uiBean.setTsinadr2kj(khozenCommonParam.getKeiyakusya(syono).getTsinadr2kj());
                uiBean.setTsinadr3kj(khozenCommonParam.getKeiyakusya(syono).getTsinadr3kj());
                uiBean.setTsintelno(khozenCommonParam.getKeiyakusya(syono).getTsintelno());
                uiBean.setDai2tsintelno(khozenCommonParam.getKeiyakusya(syono).getDai2tsintelno());
            } else {
                uiBean.setTsinyno(khJyuusyoHenkouWk.getTsinyno());
                uiBean.setTsinadr1kj(khJyuusyoHenkouWk.getTsinadr1kj());
                uiBean.setTsinadr2kj(khJyuusyoHenkouWk.getTsinadr2kj());
                uiBean.setTsinadr3kj(khJyuusyoHenkouWk.getTsinadr3kj());
                uiBean.setTsintelno(khJyuusyoHenkouWk.getTsintelno());
                uiBean.setDai2tsintelno(khJyuusyoHenkouWk.getDai2tsintelno());
            }

            uiBean.setHonninkakninkekkakbn(khJyuusyoHenkouWk.getHonninkakninkekkakbn());
            uiBean.setTyhysakuseiyhkbn(khJyuusyoHenkouWk.getTyhysakuseiyhkbn());
            uiBean.setZenkaisyorikekkakbn(khJyuusyoHenkouWk.getZenkaisyorikekkakbn());
        }

        checkKykSonzai(syono);

        checkYuukouJyoutai(syono);

        checkHanteiTetuduki(syono);

        checkYuuyokkngai();

        setUiBean();

        checkNayose();

        if (C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                MessageId.WIC0001, uiBean.getZenkaisyorikekkakbn().getContent());
        }

        if (IKhozenCommonConstants.KINOUID_MEIGIHENKOU.equals(khJyuusyoHenkouWk.getDoujiskkinouid())) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                MessageId.WIF1018);
        }

        checkHrmbr();

        hanteiTrkkzktsindousiteikbnForDispMsg();

        setKouteiInfo.exec(uiBean);

        setSyoruiInfoItiran.exec(uiBean);

        setProgressHistory.exec(uiBean);
    }

    void pushUnlockProcessBL() {

        bzCommonLockProcess.unlockProcess();
    }

    void pushSyoukaiBL() {

        BizPropertyInitializer.initialize(uiBean);

        String syoNo = uiBean.getVkihnsyono();

        uiBean.setSyono(syoNo);

        checkKykSonzai(syoNo);

        checkYuukouJyoutai(syoNo);

        checkHanteiTetuduki(syoNo);

        checkYuuyokkngai();

        setUiBeanFromHanteiSyoriKngn();

        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU);

        setUiBean();

        checkNayose();

        checkHrmbr();

        hanteiTrkkzktsindousiteikbnForDispMsg();

        uiBean.setShsnmkj(khozenCommonParam.getKeiyakusya(syoNo).getKyknmkj());
        uiBean.setShskyno(khozenCommonParam.getKeiyakusya(syoNo).getTsinyno());
        uiBean.setShsadr1kj(khozenCommonParam.getKeiyakusya(syoNo).getTsinadr1kj());
        uiBean.setShsadr2kj(khozenCommonParam.getKeiyakusya(syoNo).getTsinadr2kj());
        uiBean.setShsadr3kj(khozenCommonParam.getKeiyakusya(syoNo).getTsinadr3kj());

        uiBean.setTsinyno(khozenCommonParam.getKeiyakusya(syoNo).getTsinyno());
        uiBean.setTsinadr1kj(khozenCommonParam.getKeiyakusya(syoNo).getTsinadr1kj());
        uiBean.setTsinadr2kj(khozenCommonParam.getKeiyakusya(syoNo).getTsinadr2kj());
        uiBean.setTsinadr3kj(khozenCommonParam.getKeiyakusya(syoNo).getTsinadr3kj());
        uiBean.setTsintelno(khozenCommonParam.getKeiyakusya(syoNo).getTsintelno());
        uiBean.setDai2tsintelno(khozenCommonParam.getKeiyakusya(syoNo).getDai2tsintelno());
    }

    void pushKakuninBL() {

        if (!C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode())) {
            bzCommonLockProcess.continueLockProcess();
        }

        C_UmuKbn adrhenkouKbn = null;

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

                if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {

                    if (BizUtil.isBlank(uiBean.getTsinyno())) {
                        throw new BizLogicException(MessageId.EBC0043, "郵便番号");
                    }

                    if (BizUtil.isBlank(uiBean.getTsinadr1kj())) {
                        throw new BizLogicException(MessageId.EBC0043, "住所（漢字）");
                    }

                    if (BizUtil.isBlank(uiBean.getTsintelno())) {
                        throw new BizLogicException(MessageId.EBC0043, "電話番号");
                    }

                    if (isEqualStr(uiBean.getVtssktsinyno(), uiBean.getTsinyno()) &&
                        isEqualStr(uiBean.getVtssktsinadr1kj(), uiBean.getTsinadr1kj()) &&
                        isEqualStr(uiBean.getVtssktsinadr2kj(), uiBean.getTsinadr2kj()) &&
                        isEqualStr(uiBean.getVtssktsinadr3kj(), uiBean.getTsinadr3kj()) &&
                        isEqualStr(uiBean.getVtssktsintelno(), uiBean.getTsintelno()) &&
                        isEqualStr(uiBean.getVtsskdai2tsintelno(), uiBean.getDai2tsintelno())) {
                        throw new BizLogicException(MessageId.EIA0044, "内容");
                    }

                    BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(uiBean.getTsinadr1kj(),
                        uiBean.getTsinadr2kj(), uiBean.getTsinadr3kj());

                    if (C_JyougenketasuutyoukaKbn.CYOUKA.eq(bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn())) {
                        throw new BizLogicException(MessageId.EBA1003, "住所（漢字）",
                            String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu()),
                            String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu()));
                    }

                    if (isEqualStr(uiBean.getTsintelno(), uiBean.getDai2tsintelno())) {
                        throw new BizLogicException(MessageId.EBA1001, "電話番号", "第２電話番号");
                    }

                    if (C_HonninKakninKekkaKbn.BLNK.eq(uiBean.getHonninkakninkekkakbn())) {
                        throw new BizLogicException(MessageId.EBC0043, "本人確認結果区分");
                    }

                    if (isEqualStr(uiBean.getVtssktsinyno(), uiBean.getTsinyno()) &&
                        isEqualStr(uiBean.getVtssktsinadr1kj(), uiBean.getTsinadr1kj()) &&
                        isEqualStr(uiBean.getVtssktsinadr2kj(), uiBean.getTsinadr2kj()) &&
                        isEqualStr(uiBean.getVtssktsinadr3kj(), uiBean.getTsinadr3kj())) {
                        adrhenkouKbn = C_UmuKbn.NONE;
                    } else {
                        adrhenkouKbn = C_UmuKbn.ARI;
                    }

                    if (C_UmuKbn.NONE.eq(adrhenkouKbn) &&
                        C_TyhysakuseiyhKbn.YOU.eq(uiBean.getTyhysakuseiyhkbn())) {

                        throw new BizLogicException(MessageId.EIF1048);
                    }

                    hanteiTrkkzktsindousiteikbnForUpdate(adrhenkouKbn);
                }
            }
        }
        else if (C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode())
            || ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
                || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()))
                && C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()))) {

            if (BizUtil.isBlank(uiBean.getTsinyno())) {
                throw new BizLogicException(MessageId.EBC0043, "郵便番号");
            }

            if (BizUtil.isBlank(uiBean.getTsinadr1kj())) {
                throw new BizLogicException(MessageId.EBC0043, "住所（漢字）");
            }

            if (BizUtil.isBlank(uiBean.getTsintelno())) {
                throw new BizLogicException(MessageId.EBC0043, "電話番号");
            }

            if (isEqualStr(uiBean.getVtssktsinyno(), uiBean.getTsinyno()) &&
                isEqualStr(uiBean.getVtssktsinadr1kj(), uiBean.getTsinadr1kj()) &&
                isEqualStr(uiBean.getVtssktsinadr2kj(), uiBean.getTsinadr2kj()) &&
                isEqualStr(uiBean.getVtssktsinadr3kj(), uiBean.getTsinadr3kj()) &&
                isEqualStr(uiBean.getVtssktsintelno(), uiBean.getTsintelno()) &&
                isEqualStr(uiBean.getVtsskdai2tsintelno(), uiBean.getDai2tsintelno())) {
                throw new BizLogicException(MessageId.EIA0044, "内容");
            }

            BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(uiBean.getTsinadr1kj(),
                uiBean.getTsinadr2kj(), uiBean.getTsinadr3kj());

            if (C_JyougenketasuutyoukaKbn.CYOUKA.eq(bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn())) {
                throw new BizLogicException(MessageId.EBA1003, "住所（漢字）",
                    String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu()),
                    String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu()));
            }

            if (isEqualStr(uiBean.getTsintelno(), uiBean.getDai2tsintelno())) {
                throw new BizLogicException(MessageId.EBA1001, "電話番号", "第２電話番号");
            }

            if (C_HonninKakninKekkaKbn.BLNK.eq(uiBean.getHonninkakninkekkakbn())) {
                throw new BizLogicException(MessageId.EBC0043, "本人確認結果区分");
            }

            if (isEqualStr(uiBean.getVtssktsinyno(), uiBean.getTsinyno()) &&
                isEqualStr(uiBean.getVtssktsinadr1kj(), uiBean.getTsinadr1kj()) &&
                isEqualStr(uiBean.getVtssktsinadr2kj(), uiBean.getTsinadr2kj()) &&
                isEqualStr(uiBean.getVtssktsinadr3kj(), uiBean.getTsinadr3kj())) {
                adrhenkouKbn = C_UmuKbn.NONE;
            } else {
                adrhenkouKbn = C_UmuKbn.ARI;
            }

            if (C_UmuKbn.NONE.eq(adrhenkouKbn) &&
                C_TyhysakuseiyhKbn.YOU.eq(uiBean.getTyhysakuseiyhkbn())) {

                throw new BizLogicException(MessageId.EIF1048);
            }

            hanteiTrkkzktsindousiteikbnForUpdate(adrhenkouKbn);
        }

        if (!C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode())) {

            checkProcessKekka.exec(uiBean.getSyorikekkakbn(),
                uiBean.getSyanaicommentkh(),
                uiBean.getSasimodosisakikbn());
        }

        messageManager.addMessageId(MessageId.QBA0001);
    }

    void pushsSeikyuusyoSakusei() {
        C_UmuKbn result = checkProcessKaishi.exec(uiBean.getSyono(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(result)) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA0120,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }

        if (BizUtil.isBlank(uiBean.getShsnmkj())) {
            throw new BizLogicException(MessageId.EBC0043, "請求書送付先氏名（漢字）");
        }

        if (BizUtil.isBlank(uiBean.getShskyno())) {
            throw new BizLogicException(MessageId.EBC0043, "請求書送付先郵便番号");
        }

        if (BizUtil.isBlank(uiBean.getShsadr1kj())) {
            throw new BizLogicException(MessageId.EBC0043, "請求書送付先住所１（漢字）");
        }

        BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(uiBean.getShsadr1kj(),
            uiBean.getShsadr2kj(), uiBean.getShsadr3kj());

        if (C_JyougenketasuutyoukaKbn.CYOUKA.eq(bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn())) {
            throw new BizLogicException(MessageId.EBA1003, "送付先住所（漢字）",
                String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu()),
                String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu()));
        }

        messageManager.addMessageId(MessageId.QIA0004);
    }

    @Transactional
    void pushKakuteiBL() {

        if (!C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode())) {
            bzCommonLockProcess.continueLockProcess();
        }

        if (C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode())
            || (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())
                && C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()))) {

            if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {

                uiBean.getBzWorkflowInfo().setTaskId(kinouMode.getKinouMode());

                boolean isModYno = (!uiBean.getVtssktsinyno().equals(uiBean.getTsinyno()));

                String sikibetuKey = khozenCommonParam.getSikibetuKey(uiBean.getSyono());

                tableMaintenanceUtil.backUp(uiBean.getSyono(), sikibetuKey);

                BizDate sysDate = BizDate.getSysDate();
                String sysTime = BizDate.getSysDateTimeMilli();

                doUpdateKTKykKihon(sysDate, sysTime, isModYno);

                IT_KhTtdkRireki khTtdkRireki = uiBean.getKykKihon().createKhTtdkRireki();
                khTtdkRireki.setHenkousikibetukey(sikibetuKey);

                doUpdateKTKykSya(sysTime);

                khLincSousinDataSyori(khozenCommonParam, sysDate, tableMaintenanceUtil.getBakKykKihon());


                PALKykNaiyouKousin pALKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);

                pALKykNaiyouKousin.exec(uiBean.getKykKihon());

                IT_KykSya kykSya = uiBean.getKykKihon().getKykSya();

                if (!C_NayoseJissiKekkaKbn.BLNK.eq(pALKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn())) {
                    kykSya.setKyksakuinmeino(pALKykNaiyouKousin.getKykSakuinmeino());
                }

                if (C_YouhiKbn.YOU.eq(uiBean.getTrkkzktsindousiteihkyouhikbn1())) {

                    doUpdateTrkKzk(C_TrkKzkKbn.TRKKZK1, sysTime);
                }

                if (C_YouhiKbn.YOU.eq(uiBean.getTrkkzktsindousiteihkyouhikbn2())) {

                    doUpdateTrkKzk(C_TrkKzkKbn.TRKKZK2, sysTime);
                }

                hozenDomManager.update(uiBean.getKykKihon());

                editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
                editTtdkRirekiTblParam.setSyoriYmd(sysDate);
                editTtdkRirekiTblParam.setSysTime(sysTime);
                editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
                editTtdkRirekiTblParam.setHonninkakkekka(uiBean.getHonninkakninkekkakbn());
                editTtdkRirekiTblParam.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
                editTtdkRirekiTblParam.setYoukyuuNo(pALKykNaiyouKousin.getYoukyuuno());

                editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

                C_YouhiKbn youhiKbn = C_YouhiKbn.HUYOU;

                if (C_TyhysakuseiyhKbn.YOU.eq(uiBean.getTyhysakuseiyhkbn())) {

                    youhiKbn = C_YouhiKbn.YOU;

                    editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.ADRHNK);
                    editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_ADRHNK_TTDKKR);
                    editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);

                    khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

                    C_SyoruiCdKbn[] syoruiCds = { C_SyoruiCdKbn.KK_ADRHNK_TTDKKR };

                    khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, uiBean.getSyono(), syoruiCds, youhiKbn);
                }

                uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());

                uiBean.setTyouhyoukey(khozenTyouhyouCtl.getTyouhyouKey());
            }
            if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {
                IW_KhJyuusyoHenkouWk khJyuusyoHenkouWk = hozenDomManager
                    .getKhJyuusyoHenkouWk(uiBean.getKouteikanriid());
                hozenDomManager.delete(khJyuusyoHenkouWk);
            }
        }

        else if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
            || (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())
                && !C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()))) {

            doUpdateKTJyuusyoHenkouWk(BizDate.getSysDate(), BizDate.getSysDateTimeMilli());
        }

        if (!C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode())) {
            doJikouteikanri(uiBean.getSyono());
        }

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING4);

        messageManager.addMessageId(MessageId.IAC0009);

        if ((!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())
            || !C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())
            || C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()))
            && !C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode())) {

            uiBean.getKykKihon().detach();
        }
    }

    void pushModoruBtnByConfirm() {

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING4);
        bzCommonLockProcess.continueLockProcess();
    }

    public void ctiOpenBL() {
        BizPropertyInitializer.initialize(uiBean);
        uiBean.setVkihnsyono(ctiParamBean.getSyono());
    }

    void printOut() {
        String tyhykey = uiBean.getTyouhyoukey();
        outputReport.outputPDFByJoinKey(tyhykey);
    }

    void printHyoujiOut() {
        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {
        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    @Transactional
    void pushKakuteiBySksconfirmBL() {

        C_UmuKbn result = checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(result)) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA0120,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setHrkkaisuuhnkUmuKbn(C_UmuKbn.NONE);

        hozenPreReportRenkeiBean.setSyoNo(uiBean.getSyono());
        hozenPreReportRenkeiBean.setBzWorkflowInfo(uiBean.getBzWorkflowInfo());
        hozenPreReportRenkeiBean.setSyoriComment("");
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        editSouhuannaiParam.setShsnmkj(uiBean.getShsnmkj());
        editSouhuannaiParam.setShsyno(uiBean.getShskyno());
        editSouhuannaiParam.setShsadr1kj(uiBean.getShsadr1kj());
        editSouhuannaiParam.setShsadr2kj(uiBean.getShsadr2kj());
        editSouhuannaiParam.setShsadr3kj(uiBean.getShsadr3kj());

        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);

        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);

        C_SyoruiCdKbn[] syoruicds = { C_SyoruiCdKbn.KK_ADRHNK_SOUHU, C_SyoruiCdKbn.KK_ADRHNK_SKS };
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, uiBean.getSyono(), syoruicds, C_YouhiKbn.YOU);

        uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        uiBean.setTyouhyoukey(khozenTyouhyouCtl.getTyouhyouKey());

        insKTJyuusyoHenkouWk(BizDate.getSysDate(),
            BizDate.getSysDateTimeMilli(),
            hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId());

        bzCommonLockProcess.unlockProcess();

        uiBean.getKykKihon().detach();

        messageManager.addMessageId(MessageId.IIA0017);

    }

    String functionNameOnClickBL() {
        BizPropertyInitializer.initialize(uiBean);

        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            bzCommonLockProcess.unlockProcess();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    String syoukainomibtnbysyoukaiOnClickBL() {

        BizPropertyInitializer.initialize(uiBean);

        if (!C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            bzCommonLockProcess.unlockProcess();
            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }


    private void checkKykSonzai(String pSyoNo) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);
        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }
        uiBean.setKykKihon(kykKihon);
    }

    private void checkYuukouJyoutai(String pSyoNo) {

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn;

        yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);
        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }

        if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
            String message = "";
            String messageId = "";

            for (int i = 0; i < checkYuukouJyoutai.getWarningMessageIDList().size(); i++) {
                message = BizUtil.getGeneralMessageId(checkYuukouJyoutai.getWarningMessageList().get(i));
                messageId = checkYuukouJyoutai.getWarningMessageIDList().get(i);

                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING1, messageId, message);
            }
        }
    }

    private void checkHanteiTetuduki(String syoNo) {
        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, syoNo);

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }

        if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
    }

    private void checkYuuyokkngai() {
        boolean checkYuuyokkngaiFlg = checkYuuyokkngai.exec(uiBean.getSyono(), BizDate.getSysDate());
        if (checkYuuyokkngaiFlg == false) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA0011);
        }
    }

    private void checkNayose() {
        if (uiBean.getPalkikeiyakuInfo().size() > 0 ||
            uiBean.getPalnenkinsiharaiInfo().size() > 0 ||
            uiBean.getPalsueokiInfo().size() > 0) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA0054);
        }
        if ((uiBean.getPalkikeiyakuInfo().size() == 0 &&
            uiBean.getPalnenkinsiharaiInfo().size() == 0 &&
            uiBean.getPalsueokiInfo().size() == 0) &&
            uiBean.getKikeiyakuInfo().size() > 0 ||
            uiBean.getNenkinsiharaiInfo().size() > 0) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA0055);
        }
        String messageId = "";
        String message = "";

        for (int i = 0; i < uiBean.getWarningMessageIdList().size(); i++) {
            messageId = BizUtil.getGeneralMessageId(uiBean.getWarningMessageIdList().get(i));
            message = uiBean.getWarningMessageList().get(i);

            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, messageId, message);
        }
    }

    private void setUiBeanFromHanteiSyoriKngn() {
        String kinMode = kinouMode.getKinouMode();

        if (StringUtil.isNullOrBlank(kinMode)
            || C_KhkinouModeIdKbn.DEFAULT.getValue().equals(kinMode)) {

            boolean syoriKengenFlg = baseUserInfo.hasAuthenticatedFunctionMode(C_KhkinouModeIdKbn.SYORI.getValue());

            if (syoriKengenFlg) {
                kinouMode.setKinouMode(C_KhkinouModeIdKbn.SYORI.getValue());
            }
            else {
                boolean syoukaiKengenFlg = baseUserInfo.hasAuthenticatedFunctionMode(
                    C_KhkinouModeIdKbn.SYOUKAI.getValue());

                if (syoukaiKengenFlg) {
                    kinouMode.setKinouMode(C_KhkinouModeIdKbn.SYOUKAI.getValue());
                }
                else {
                    throw new BizLogicException(MessageId.EBS0003);
                }
            }
        }
    }

    private void setUiBean() {

        setToriatukaiTyuui.exec(khozenCommonParam, uiBean);
        SetKihon.exec(khozenCommonParam, uiBean);
        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(khozenCommonParam, uiBean);
        SetTuusinsaki.exec(khozenCommonParam, uiBean);
        SetTetudukityuui.exec(khozenCommonParam, uiBean);
        SetKeiyakusya.exec(khozenCommonParam, uiBean);
        SetTrkKazoku.exec(khozenCommonParam, uiBean);
        SetKyksyadairi.exec(khozenCommonParam, uiBean);
        SetHituyouSyorui.exec(khozenCommonParam, uiBean);

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);

        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        setKhKbnPatternUtil.exec(uiBean);

        if (uiBean.getWarningMessageIdList() != null && uiBean.getWarningMessageIdList().size() > 0) {
            String message = "";
            String messageId = "";

            for (int n = 0; n < uiBean.getWarningMessageIdList().size(); n++) {
                messageId = BizUtil.getGeneralMessageId(uiBean.getWarningMessageIdList().get(n));
                message = uiBean.getWarningMessageList().get(n);

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, messageId, message);

            }
        }
    }

    private void doUpdateKTKykKihon(BizDate pSysDate, String pSysTime, boolean isModYno) {

        IT_KykKihon kykKihon = uiBean.getKykKihon();
        kykKihon.setSyhenkouymd(pSysDate);
        kykKihon.setLastjyuuhenymd(pSysDate);
        kykKihon.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        kykKihon.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        kykKihon.setGyoumuKousinTime(pSysTime);
        if (isModYno) {
            kykKihon.setLasttsinynohenkouymd(pSysDate);
        }
    }

    private void doUpdateKTKykSya(String pSysTime) {

        IT_KykKihon kykKihon = uiBean.getKykKihon();
        IT_KykSya kykSya = kykKihon.getKykSya();

        kykSya.setTsinyno(uiBean.getTsinyno());
        kykSya.setTsinadr1kj(uiBean.getTsinadr1kj());
        kykSya.setTsinadr2kj(uiBean.getTsinadr2kj());
        kykSya.setTsinadr3kj(uiBean.getTsinadr3kj());
        kykSya.setTsintelno(uiBean.getTsintelno());
        kykSya.setDai2tsintelno(uiBean.getDai2tsintelno());
        kykSya.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        kykSya.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        kykSya.setGyoumuKousinTime(pSysTime);
    }

    private void doUpdateTrkKzk(C_TrkKzkKbn pTrkKzkKbn, String pSysTime) {

        IT_TrkKzk trkKzk = uiBean.getKykKihon().getTrkKzkByTrkKzkKbn(pTrkKzkKbn);

        if (C_TrkKzkKbn.TRKKZK1.eq(pTrkKzkKbn)) {

            trkKzk.setTrkkzktsindousiteikbn(uiBean.getTrkkzktsindousiteikbn1());
        }

        if (C_TrkKzkKbn.TRKKZK2.eq(pTrkKzkKbn)) {

            trkKzk.setTrkkzktsindousiteikbn(uiBean.getTrkkzktsindousiteikbn2());
        }

        trkKzk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());

        trkKzk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());

        trkKzk.setGyoumuKousinTime(pSysTime);
    }

    private void insKTJyuusyoHenkouWk(BizDate pSysDate, String pSysDateTimeMilli, String pKouteikanriid) {

        IW_KhJyuusyoHenkouWk khJyuusyoHenkouWk = new IW_KhJyuusyoHenkouWk();
        khJyuusyoHenkouWk.setKouteikanriid(pKouteikanriid);
        khJyuusyoHenkouWk.setSyono(uiBean.getSyono());
        khJyuusyoHenkouWk.setSkssakuseiymd(pSysDate);
        khJyuusyoHenkouWk.setShsnmkj(uiBean.getShsnmkj());
        khJyuusyoHenkouWk.setShskyno(uiBean.getShskyno());
        khJyuusyoHenkouWk.setShsadr1kj(uiBean.getShsadr1kj());
        khJyuusyoHenkouWk.setShsadr2kj(uiBean.getShsadr2kj());
        khJyuusyoHenkouWk.setShsadr3kj(uiBean.getShsadr3kj());
        khJyuusyoHenkouWk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        khJyuusyoHenkouWk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        khJyuusyoHenkouWk.setGyoumuKousinTime(pSysDateTimeMilli);
        BizPropertyInitializer.initialize(khJyuusyoHenkouWk);

        hozenDomManager.insert(khJyuusyoHenkouWk);
    }

    private void doUpdateKTJyuusyoHenkouWk(BizDate pSysDate, String pSysDateTimeMilli) {

        IW_KhJyuusyoHenkouWk khJyuusyoHenkouWk =
            hozenDomManager.getKhJyuusyoHenkouWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {
            khJyuusyoHenkouWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
        }

        if ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()))
            && (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getSyorikekkakbn())
                && !C_SyorikekkaKbn.SASIMODOSI.eq(uiBean.getSyorikekkakbn()))) {

            khJyuusyoHenkouWk.setTsinyno(uiBean.getTsinyno());
            khJyuusyoHenkouWk.setTsinadr1kj(uiBean.getTsinadr1kj());
            khJyuusyoHenkouWk.setTsinadr2kj(uiBean.getTsinadr2kj());
            khJyuusyoHenkouWk.setTsinadr3kj(uiBean.getTsinadr3kj());
            khJyuusyoHenkouWk.setTsintelno(uiBean.getTsintelno());
            khJyuusyoHenkouWk.setDai2tsintelno(uiBean.getDai2tsintelno());
            khJyuusyoHenkouWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
            khJyuusyoHenkouWk.setTyhysakuseiyhkbn(uiBean.getTyhysakuseiyhkbn());

        }
        khJyuusyoHenkouWk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        khJyuusyoHenkouWk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        khJyuusyoHenkouWk.setGyoumuKousinTime(pSysDateTimeMilli);

        hozenDomManager.update(khJyuusyoHenkouWk);
    }

    private void doJikouteikanri(String pSyono) {

        KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);

        khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
        khRuleBean.setSasimodosisakiKbn(uiBean.getSasimodosisakikbn());
        khRuleBean.setSaiwariateUserId("");

        String syanaiComment = uiBean.getSyanaicommentkh();

        KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);

        khProcessForward.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            bzCommonLockProcess.getKouteiLockKey(), syanaiComment, khRuleBean);

        bzCommonLockProcess.unlockProcess();

    }

    private boolean isEqualStr(String pId1, String pId2) {
        String varId = "";
        if (!BizUtil.isBlank(pId1)) {
            varId = pId1;
        }
        return varId.equals(pId2);
    }

    private void checkHrmbr() {
        Long khHenreikinYendtMbrCount = hozenDomManager.getKhHenreikinYendtMbrCountBySyono(uiBean.getSyono());
        if (khHenreikinYendtMbrCount > 0) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA1017);
        }
    }

    private void hanteiTrkkzktsindousiteikbnForDispMsg() {

        List<IT_TrkKzk> trkKzkList = khozenCommonParam.getTrkKzk(uiBean.getSyono());

        if (trkKzkList != null) {

            for (IT_TrkKzk trkKzk : trkKzkList) {

                if (C_TrkKzkKbn.TRKKZK1.eq(trkKzk.getTrkkzkkbn())) {

                    uiBean.setTrkkzkumukbn1(C_UmuKbn.ARI);

                    uiBean.setTrkkzkyno1(trkKzk.getTrkkzkyno());

                    uiBean.setTrkkzkadr1kj1(trkKzk.getTrkkzkadr1kj());

                    uiBean.setTrkkzkadr2kj1(trkKzk.getTrkkzkadr2kj());

                    uiBean.setTrkkzkadr3kj1(trkKzk.getTrkkzkadr3kj());

                    uiBean.setTrkkzktsindousiteikbn1(trkKzk.getTrkkzktsindousiteikbn());
                }

                if (C_TrkKzkKbn.TRKKZK2.eq(trkKzk.getTrkkzkkbn())) {

                    uiBean.setTrkkzkumukbn2(C_UmuKbn.ARI);

                    uiBean.setTrkkzkyno2(trkKzk.getTrkkzkyno());

                    uiBean.setTrkkzkadr1kj2(trkKzk.getTrkkzkadr1kj());

                    uiBean.setTrkkzkadr2kj2(trkKzk.getTrkkzkadr2kj());

                    uiBean.setTrkkzkadr3kj2(trkKzk.getTrkkzkadr3kj());

                    uiBean.setTrkkzktsindousiteikbn2(trkKzk.getTrkkzktsindousiteikbn());
                }
            }

            if (C_TsindousiteiKbn.ARI.eq(uiBean.getTrkkzktsindousiteikbn1()) ||
                    C_TsindousiteiKbn.ARI.eq(uiBean.getTrkkzktsindousiteikbn2())) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA1028);
            }
        }
    }

    private void hanteiTrkkzktsindousiteikbnForUpdate(C_UmuKbn pAdrhenkouUmu) {

        uiBean.setTrkkzktsindousiteihkyouhikbn1(C_YouhiKbn.HUYOU);

        uiBean.setTrkkzktsindousiteihkyouhikbn2(C_YouhiKbn.HUYOU);

        if (C_UmuKbn.ARI.eq(pAdrhenkouUmu)) {

            if (C_UmuKbn.ARI.eq(uiBean.getTrkkzkumukbn1())) {

                if (C_TsindousiteiKbn.ARI.eq(uiBean.getTrkkzktsindousiteikbn1())) {

                    uiBean.setTrkkzktsindousiteihkyouhikbn1(C_YouhiKbn.YOU);

                    uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
                }

                if (uiBean.getTrkkzkyno1().equals(uiBean.getTsinyno()) &&
                        uiBean.getTrkkzkadr1kj1().equals(uiBean.getTsinadr1kj()) &&
                        uiBean.getTrkkzkadr2kj1().equals(uiBean.getTsinadr2kj()) &&
                        uiBean.getTrkkzkadr3kj1().equals(uiBean.getTsinadr3kj())) {

                    uiBean.setTrkkzktsindousiteihkyouhikbn1(C_YouhiKbn.YOU);

                    uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.ARI);
                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getTrkkzkumukbn2())) {

                if (C_TsindousiteiKbn.ARI.eq(uiBean.getTrkkzktsindousiteikbn2())) {

                    uiBean.setTrkkzktsindousiteihkyouhikbn2(C_YouhiKbn.YOU);

                    uiBean.setTrkkzktsindousiteikbn2(C_TsindousiteiKbn.BLNK);
                }

                if (uiBean.getTrkkzkyno2().equals(uiBean.getTsinyno()) &&
                        uiBean.getTrkkzkadr1kj2().equals(uiBean.getTsinadr1kj()) &&
                        uiBean.getTrkkzkadr2kj2().equals(uiBean.getTsinadr2kj()) &&
                        uiBean.getTrkkzkadr3kj2().equals(uiBean.getTsinadr3kj())) {

                    uiBean.setTrkkzktsindousiteihkyouhikbn2(C_YouhiKbn.YOU);

                    uiBean.setTrkkzktsindousiteikbn2(C_TsindousiteiKbn.ARI);
                }
            }
        }
    }
    private void khLincSousinDataSyori(KhozenCommonParam pKhozenCommonParam, BizDate pSyoriYmd,
        IT_BAK_KykKihon pBAK_KykKihon) {

        IT_KhLincKihon khLincKihon = uiBean.getKykKihon().getKhLincKihon();

        Long linckanyuusyano = null;

        if (khLincKihon != null) {
            linckanyuusyano = khLincKihon.getLinckanyuusyano();
        }
        HanteiLinc hanteiLinc = SWAKInjector.getInstance(HanteiLinc.class);
        HanteiLincBean hanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);

        hanteiLincBean.setSyoriYmd(pSyoriYmd);
        hanteiLincBean.setBakKykKihon(pBAK_KykKihon);
        hanteiLincBean.setKykKihon(uiBean.getKykKihon());
        hanteiLincBean.setKanyuusyaNo(linckanyuusyano);

        hanteiLinc.exec(hanteiLincBean, pKhozenCommonParam);
    }
}

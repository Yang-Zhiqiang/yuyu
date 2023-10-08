package yuyu.app.hozen.khozen.khkzktrkkykdrhnk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.ProgressHistoryDataSourceBeanCommonParam;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.koutei.SetProgressHistoryExecUiBeanParam;
import yuyu.common.biz.koutei.viewkouteiinfo.ViewKouteiInfoUiBeanParam;
import yuyu.common.biz.koutei.viewprogresshistory.ViewProgressHistoryUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiExecUiBeanParam;
import yuyu.common.hozen.khcommon.GetKhKykdrInfoBean;
import yuyu.common.hozen.khcommon.KhozenCommonParamGetHituyouSyoruiUiBeanParam;
import yuyu.common.hozen.khview.viewbetukyk.ViewBetukykUiBeanParam;
import yuyu.common.hozen.khview.viewhihokensya.ViewHihokensyaUiBeanParam;
import yuyu.common.hozen.khview.viewhituyousyorui.ViewHituyouSyoruiUiBeanParam;
import yuyu.common.hozen.khview.viewkeiyakusya.ViewKeiyakusyaUiBeanParam;
import yuyu.common.hozen.khview.viewkihon.ViewKihonUiBeanParam;
import yuyu.common.hozen.khview.viewsiteiseikyuu.ViewSiteiseikyuuUiBeanParam;
import yuyu.common.hozen.khview.viewtetudukityuui.ViewTetudukityuuiUiBeanParam;
import yuyu.common.hozen.khview.viewtuusinsaki.ViewTuusinsakiUiBeanParam;
import yuyu.common.hozen.setuibean.KikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.NenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalNenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalkikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalsueokiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.SetBetukykExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHihokensyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHituyouSyoruiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKeiyakusyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtilUiBeanParam;
import yuyu.common.hozen.setuibean.SetKihonExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetSiteiseikyuuExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTetudukityuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTuusinsakiExecUiBeanParam;
import yuyu.common.hozen.setuibean.TtdktyuuikbnInfoDataSourceBeanCommonParam;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;

import com.google.common.collect.Lists;

/**
 * 家族登録／契約者代理特約変更 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhKzktrkKykdrHnkUiBean extends GenKhKzktrkKykdrHnkUiBean implements CheckYuukouJyoutaiExecUiBeanParam,
SetKihonExecUiBeanParam, SetBetukykExecUiBeanParam, SetTetudukityuuiExecUiBeanParam, SetKeiyakusyaExecUiBeanParam,
SetTuusinsakiExecUiBeanParam, SetSiteiseikyuuExecUiBeanParam, SetHituyouSyoruiExecUiBeanParam,
KhozenCommonParamGetHituyouSyoruiUiBeanParam, SetKouteiInfoExecUiBeanParam, SetSyoruiInfoItiranExecUiBeanParam,
SetProgressHistoryExecUiBeanParam, SetKhKbnPatternUtilUiBeanParam, SetToriatukaiTyuuiExecUiBeanParam,
ViewKihonUiBeanParam, ViewBetukykUiBeanParam, ViewTetudukityuuiUiBeanParam, ViewKeiyakusyaUiBeanParam,
ViewTuusinsakiUiBeanParam, ViewSiteiseikyuuUiBeanParam, ViewHituyouSyoruiUiBeanParam, ViewKouteiInfoUiBeanParam,
ViewProgressHistoryUiBeanParam, ViewSyoruiInfoItiranUiBeanParam, ViewHihokensyaUiBeanParam,
SetHihokensyaExecUiBeanParam {

    private static final long serialVersionUID = 1L;

    @Inject
    private IT_KykKihon kykKihon;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    private String kouteiLockKey;

    private String syono;

    private C_SyorikekkaKbn zenkaisyorikekkakbn;

    private String reportKey;

    List<String> warningMessageIdList = new ArrayList<>();

    List<String> warningMessageList = new ArrayList<>();

    private String[] imageids;

    private C_KykdrknHtdjytKbn kykdrknhatudoujyoutai;

    private String patternSyorikekkakbn;

    private C_KhkinouModeIdKbn khkinouModeIdKbn;

    private C_UmuKbn tyouhyoumukbn;

    private C_UmuKbn trkkzkInfo1umukbn;

    private C_UmuKbn trkkzkInfo2umukbn;

    private C_UmuKbn newTrkkzkInfo1umukbn;

    private C_UmuKbn newTrkkzkInfo2umukbn;

    private C_UmuKbn newKyksyadairininumukbn;

    private C_UmuKbn trkkzk1AndHihokensyamukbn;

    private C_UmuKbn trkkzk2AndHihokensyamukbn;

    private C_UmuKbn trkkzk1AndKykmukbn;

    private C_UmuKbn trkkzk2AndKykmukbn;

    private KhKzktrkKykdrHnkInfoUiBean khKzktrkKykdrHnkInfoUiBean;

    private C_KahiKbn trkkzk1Sakujyo;

    private C_KahiKbn trkkzk2Sakujyo;

    private C_UmuKbn kykdrtkykhukaumu;

    private GetKhKykdrInfoBean khKykdrInfoBean;

    public KhKzktrkKykdrHnkUiBean() {
    }

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        kykKihon = pKykKihon;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        bzWorkflowInfo = pBzWorkflowInfo;
    }

    public String getKouteiLockKey() {
        return kouteiLockKey;
    }

    public void setKouteiLockKey(String pKouteiLockKey) {
        kouteiLockKey = pKouteiLockKey;
    }

    @Override
    public String getSyono() {
        return syono;
    }

    @Override
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public C_SyorikekkaKbn getZenkaisyorikekkakbn() {
        return zenkaisyorikekkakbn;
    }

    public void setZenkaisyorikekkakbn(C_SyorikekkaKbn pZenkaisyorikekkakbn) {
        zenkaisyorikekkakbn = pZenkaisyorikekkakbn;
    }

    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String pReportKey) {
        reportKey = pReportKey;
    }

    public List<String> getWarningMessageIdList() {
        return warningMessageIdList;
    }

    @Override
    public void setWarningMessageIdList(List<String> pWarningMessageIdList) {
        warningMessageIdList = pWarningMessageIdList;
    }

    public List<String> getWarningMessageList() {
        return warningMessageList;
    }

    @Override
    public void setWarningMessageList(List<String> pWarningMessageList) {
        warningMessageList = pWarningMessageList;
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }

    public C_KykdrknHtdjytKbn getKykdrknhatudoujyoutai() {
        return kykdrknhatudoujyoutai;
    }

    public void setKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn pKykdrknhatudoujyoutai) {
        kykdrknhatudoujyoutai = pKykdrknhatudoujyoutai;
    }

    public String getPatternSyorikekkakbn() {
        return patternSyorikekkakbn;
    }

    @Override
    public void setPatternSyorikekkakbn(String pPatternSyorikekkakbn) {
        patternSyorikekkakbn = pPatternSyorikekkakbn;
    }

    @Override
    public C_KhkinouModeIdKbn getKhkinouModeIdKbn() {
        return khkinouModeIdKbn;
    }

    public void setKhkinouModeIdKbn(C_KhkinouModeIdKbn pKhkinouModeIdKbn) {
        khkinouModeIdKbn = pKhkinouModeIdKbn;
    }

    public C_UmuKbn getTyouhyoumukbn() {
        return tyouhyoumukbn;
    }

    public void setTyouhyoumukbn(C_UmuKbn pTyouhyoumukbn) {
        tyouhyoumukbn = pTyouhyoumukbn;
    }

    public C_UmuKbn getTrkkzkInfo1umukbn() {
        return trkkzkInfo1umukbn;
    }

    public void setTrkkzkInfo1umukbn(C_UmuKbn pTrkkzkInfo1umukbn) {
        this.trkkzkInfo1umukbn = pTrkkzkInfo1umukbn;
    }

    public C_UmuKbn getTrkkzkInfo2umukbn() {
        return trkkzkInfo2umukbn;
    }

    public void setTrkkzkInfo2umukbn(C_UmuKbn pTrkkzkInfo2umukbn) {
        this.trkkzkInfo2umukbn = pTrkkzkInfo2umukbn;
    }

    public C_UmuKbn getNewTrkkzkInfo1umukbn() {
        return newTrkkzkInfo1umukbn;
    }

    public void setNewTrkkzkInfo1umukbn(C_UmuKbn pNewTrkkzkInfo1umukbn) {
        this.newTrkkzkInfo1umukbn = pNewTrkkzkInfo1umukbn;
    }

    public C_UmuKbn getNewTrkkzkInfo2umukbn() {
        return newTrkkzkInfo2umukbn;
    }

    public void setNewTrkkzkInfo2umukbn(C_UmuKbn pNewTrkkzkInfo2umukbn) {
        this.newTrkkzkInfo2umukbn = pNewTrkkzkInfo2umukbn;
    }

    public C_UmuKbn getNewKyksyadairininumukbn() {
        return newKyksyadairininumukbn;
    }

    public void setNewKyksyadairininumukbn(C_UmuKbn pNewKyksyadairininumukbn) {
        this.newKyksyadairininumukbn = pNewKyksyadairininumukbn;
    }

    public C_UmuKbn getTrkkzk1AndHihokensyamukbn() {
        return trkkzk1AndHihokensyamukbn;
    }

    public void setTrkkzk1AndHihokensyamukbn(C_UmuKbn pTrkkzk1AndHihokensyamukbn) {
        this.trkkzk1AndHihokensyamukbn = pTrkkzk1AndHihokensyamukbn;
    }

    public C_UmuKbn getTrkkzk2AndHihokensyamukbn() {
        return trkkzk2AndHihokensyamukbn;
    }

    public void setTrkkzk2AndHihokensyamukbn(C_UmuKbn pTrkkzk2AndHihokensyamukbn) {
        this.trkkzk2AndHihokensyamukbn = pTrkkzk2AndHihokensyamukbn;
    }

    public C_UmuKbn getTrkkzk1AndKykmukbn() {
        return trkkzk1AndKykmukbn;
    }

    public void setTrkkzk1AndKykmukbn(C_UmuKbn pTrkkzk1AndKykmukbn) {
        this.trkkzk1AndKykmukbn = pTrkkzk1AndKykmukbn;
    }

    public C_UmuKbn getTrkkzk2AndKykmukbn() {
        return trkkzk2AndKykmukbn;
    }

    public void setTrkkzk2AndKykmukbn(C_UmuKbn pTrkkzk2AndKykmukbn) {
        this.trkkzk2AndKykmukbn = pTrkkzk2AndKykmukbn;
    }

    public KhKzktrkKykdrHnkInfoUiBean getKhKzktrkKykdrHnkInfoUiBean() {
        return khKzktrkKykdrHnkInfoUiBean;
    }

    public void setKhKzktrkKykdrHnkInfoUiBean(KhKzktrkKykdrHnkInfoUiBean pKhKzktrkKykdrHnkInfoUiBean) {
        this.khKzktrkKykdrHnkInfoUiBean = pKhKzktrkKykdrHnkInfoUiBean;
    }

    public C_KahiKbn getTrkkzk1Sakujyo() {
        return trkkzk1Sakujyo;
    }

    public void setTrkkzk1Sakujyo(C_KahiKbn pTrkkzk1Sakujyo) {
        this.trkkzk1Sakujyo = pTrkkzk1Sakujyo;
    }

    public C_KahiKbn getTrkkzk2Sakujyo() {
        return trkkzk2Sakujyo;
    }

    public void setTrkkzk2Sakujyo(C_KahiKbn pTrkkzk2Sakujyo) {
        this.trkkzk2Sakujyo = pTrkkzk2Sakujyo;
    }

    public C_UmuKbn getKykdrtkykhukaumu() {
        return kykdrtkykhukaumu;
    }

    public void setKykdrtkykhukaumu(C_UmuKbn pKykdrtkykhukaumu) {
        kykdrtkykhukaumu = pKykdrtkykhukaumu;
    }

    public GetKhKykdrInfoBean getKhKykdrInfoBean() {
        return khKykdrInfoBean;
    }

    public void setKhKykdrInfoBean(GetKhKykdrInfoBean pKhKykdrInfoBean) {
        this.khKykdrInfoBean = pKhKykdrInfoBean;
    }

    @Override
    public void setNewtrkkzknmkjkhuka1(Boolean pNewtrkkzknmkjkhuka1) {
        super.setNewtrkkzknmkjkhuka1(pNewtrkkzknmkjkhuka1);
        C_KjkhukaKbn newtrkkzknmkjkhukakbn = pNewtrkkzknmkjkhuka1 ? C_KjkhukaKbn.KJKHUKA : C_KjkhukaKbn.BLNK;
        super.setNewtrkkzknmkjkhukakbn1(newtrkkzknmkjkhukakbn);
    }

    @Override
    public void setNewtrkkzknmkjkhuka2(Boolean pNewtrkkzknmkjkhuka2) {
        super.setNewtrkkzknmkjkhuka2(pNewtrkkzknmkjkhuka2);
        C_KjkhukaKbn newtrkkzknmkjkhukakbn = pNewtrkkzknmkjkhuka2 ? C_KjkhukaKbn.KJKHUKA : C_KjkhukaKbn.BLNK;
        super.setNewtrkkzknmkjkhukakbn2(newtrkkzknmkjkhukakbn);
    }

    @Override
    public void setNewkykdrnmkjkhuka(Boolean pNewkykdrnmkjkhuka) {
        super.setNewkykdrnmkjkhuka(pNewkykdrnmkjkhuka);
        C_KjkhukaKbn newtrkkzknmkjkhukakbn = pNewkykdrnmkjkhuka ? C_KjkhukaKbn.KJKHUKA : C_KjkhukaKbn.BLNK;
        super.setNewkykdrnmkjkhukakbn(newtrkkzknmkjkhukakbn);
    }

    @Override
    public void setNewtrkkzknmkjkhukakbn1(C_KjkhukaKbn pNewtrkkzknmkjkhukakbn1) {
        super.setNewtrkkzknmkjkhukakbn1(pNewtrkkzknmkjkhukakbn1);

        if (!C_KjkhukaKbn.BLNK.eq(pNewtrkkzknmkjkhukakbn1)) {
            super.setNewtrkkzknmkjkhuka1(true);
        }
    }

    @Override
    public void setNewtrkkzknmkjkhukakbn2(C_KjkhukaKbn pNewtrkkzknmkjkhukakbn2) {
        super.setNewtrkkzknmkjkhukakbn2(pNewtrkkzknmkjkhukakbn2);

        if (!C_KjkhukaKbn.BLNK.eq(pNewtrkkzknmkjkhukakbn2)) {
            super.setNewtrkkzknmkjkhuka2(true);
        }
    }

    @Override
    public void setNewkykdrnmkjkhukakbn(C_KjkhukaKbn pNewkykdrnmkjkhukakbn) {
        super.setNewkykdrnmkjkhukakbn(pNewkykdrnmkjkhukakbn);

        if (!C_KjkhukaKbn.BLNK.eq(pNewkykdrnmkjkhukakbn)) {
            super.setNewkykdrnmkjkhuka(true);
        }
    }

    @Override
    public KikeiyakuInfoDataSourceBeanCommonParam createKikeiyakuInfoDataSourceBean() {
        return new KikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertKikeiyakuInfoForCommonParam(List<KikeiyakuInfoDataSourceBeanCommonParam> pKikeiyakuInfo) {
        List<KikeiyakuInfoDataSourceBean> kikeiyakuInfo = Lists.newArrayList();
        for (KikeiyakuInfoDataSourceBeanCommonParam beanParam : pKikeiyakuInfo) {
            kikeiyakuInfo.add((KikeiyakuInfoDataSourceBean) beanParam);
        }
        super.setKikeiyakuInfo(kikeiyakuInfo);
    }

    @Override
    public NenkinsiharaiInfoDataSourceBeanCommonParam createNenkinsiharaiInfoDataSourceBean() {
        return new NenkinsiharaiInfoDataSourceBean();
    }

    @Override
    public void convertNenkinsiharaiInfoForCommonParam(
        List<NenkinsiharaiInfoDataSourceBeanCommonParam> pNenkinsiharaiInfo) {
        List<NenkinsiharaiInfoDataSourceBean> nenkinsiharaiInfo = Lists.newArrayList();
        for (NenkinsiharaiInfoDataSourceBeanCommonParam beanParam : pNenkinsiharaiInfo) {
            nenkinsiharaiInfo.add((NenkinsiharaiInfoDataSourceBean) beanParam);
        }
        super.setNenkinsiharaiInfo(nenkinsiharaiInfo);
    }

    @Override
    public PalkikeiyakuInfoDataSourceBeanCommonParam createPalkikeiyakuInfoDataSourceBean() {
        return new PalkikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertPalkikeiyakuInfoForCommonParam(List<PalkikeiyakuInfoDataSourceBeanCommonParam> pPalkikeiyakuInfo) {
        List<PalkikeiyakuInfoDataSourceBean> palkikeiyakuInfo = Lists.newArrayList();
        for (PalkikeiyakuInfoDataSourceBeanCommonParam beanParam : pPalkikeiyakuInfo) {
            palkikeiyakuInfo.add((PalkikeiyakuInfoDataSourceBean) beanParam);
        }
        super.setPalkikeiyakuInfo(palkikeiyakuInfo);
    }

    @Override
    public PalNenkinsiharaiInfoDataSourceBeanCommonParam createPalNenkinsiharaiInfoDataSourceBean() {
        return new PalnenkinsiharaiInfoDataSourceBean();
    }

    @Override
    public void convertPalNenkinsiharaiInfoForCommonParam(
        List<PalNenkinsiharaiInfoDataSourceBeanCommonParam> pPalNenkinsiharaiInfo) {
        List<PalnenkinsiharaiInfoDataSourceBean> palnenkinsiharaiInfo = Lists.newArrayList();
        for (PalNenkinsiharaiInfoDataSourceBeanCommonParam beanParam : pPalNenkinsiharaiInfo) {
            palnenkinsiharaiInfo.add((PalnenkinsiharaiInfoDataSourceBean) beanParam);
        }
        super.setPalnenkinsiharaiInfo(palnenkinsiharaiInfo);
    }

    @Override
    public PalsueokiInfoDataSourceBeanCommonParam createPalsueokiInfoDataSourceBean() {
        return new PalsueokiInfoDataSourceBean();
    }

    @Override
    public void convertPalsueokiInfoForCommonParam(List<PalsueokiInfoDataSourceBeanCommonParam> pPalsueokiInfo) {
        List<PalsueokiInfoDataSourceBean> palnenkinsiharaiInfo = Lists.newArrayList();
        for (PalsueokiInfoDataSourceBeanCommonParam beanParam : pPalsueokiInfo) {
            palnenkinsiharaiInfo.add((PalsueokiInfoDataSourceBean) beanParam);
        }
        super.setPalsueokiInfo(palnenkinsiharaiInfo);
    }

    @Override
    public TtdktyuuikbnInfoDataSourceBeanCommonParam createTtdktyuuikbnInfoDataSourceBean() {
        return new TtdktyuuikbnInfoDataSourceBean();
    }

    @Override
    public void convertTtdktyuuikbnInfoForCommonParam(List<TtdktyuuikbnInfoDataSourceBeanCommonParam> pTtdktyuuikbnInfo) {
        List<TtdktyuuikbnInfoDataSourceBean> ttdktyuuikbnInfo = Lists.newArrayList();
        for (TtdktyuuikbnInfoDataSourceBeanCommonParam beanPram : pTtdktyuuikbnInfo) {
            ttdktyuuikbnInfo.add((TtdktyuuikbnInfoDataSourceBean) beanPram);
        }
        super.setTtdktyuuikbnInfo(ttdktyuuikbnInfo);
    }

    @Override
    public SyoruiInfoItiranDataSourceBeanCommonParam createSyoruiInfoItiranDataSourceBean() {
        return new SyoruiInfoListDataSourceBean();
    }

    @Override
    public void convertSyoruiInfoItiranForCommonParam(List<SyoruiInfoItiranDataSourceBeanCommonParam> pSyoruiInfoItiran) {
        List<SyoruiInfoListDataSourceBean> syoruiInfoList = Lists.newArrayList();
        for (SyoruiInfoItiranDataSourceBeanCommonParam beanPram : pSyoruiInfoItiran) {
            syoruiInfoList.add((SyoruiInfoListDataSourceBean) beanPram);
        }
        super.setSyoruiInfoList(syoruiInfoList);
    }

    @Override
    public ProgressHistoryDataSourceBeanCommonParam createProgressHistoryDataSourceBean() {
        return new ProgresshistoryinfoDataSourceBean();
    }

    @Override
    public void convertProgressHistoryForCommonParam(List<ProgressHistoryDataSourceBeanCommonParam> pDataSourceBeanLst) {
        List<ProgresshistoryinfoDataSourceBean> progresshistoryinfo = Lists.newArrayList();
        for (ProgressHistoryDataSourceBeanCommonParam beanPram : pDataSourceBeanLst) {
            progresshistoryinfo.add((ProgresshistoryinfoDataSourceBean) beanPram);
        }
        super.setProgresshistoryinfo(progresshistoryinfo);
    }
}
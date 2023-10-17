package yuyu.app.hozen.khozen.khjyuusyohenkou;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
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
import yuyu.common.hozen.khcommon.KhozenCommonParamGetHituyouSyoruiUiBeanParam;
import yuyu.common.hozen.khview.viewbetukyk.ViewBetukykUiBeanParam;
import yuyu.common.hozen.khview.viewhituyousyorui.ViewHituyouSyoruiUiBeanParam;
import yuyu.common.hozen.khview.viewkeiyakusya.ViewKeiyakusyaUiBeanParam;
import yuyu.common.hozen.khview.viewkihon.ViewKihonUiBeanParam;
import yuyu.common.hozen.khview.viewkyksyadairi.ViewKyksyadairiUiBeanParam;
import yuyu.common.hozen.khview.viewtetudukityuui.ViewTetudukityuuiUiBeanParam;
import yuyu.common.hozen.khview.viewtrkkazoku.ViewTrkKazokuUiBeanParam;
import yuyu.common.hozen.khview.viewtuusinsaki.ViewTuusinsakiUiBeanParam;
import yuyu.common.hozen.setuibean.KikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.NenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalNenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalkikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalsueokiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.SetBetukykExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHituyouSyoruiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKeiyakusyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtilUiBeanParam;
import yuyu.common.hozen.setuibean.SetKihonExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKyksyadairiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTetudukityuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTrkKazokuExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTuusinsakiExecUiBeanParam;
import yuyu.common.hozen.setuibean.TtdktyuuikbnInfoDataSourceBeanCommonParam;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.collect.Lists;

/**
 * 住所変更 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhJyuusyoHenkouUiBean extends GenKhJyuusyoHenkouUiBean implements ViewKihonUiBeanParam,
ViewKeiyakusyaUiBeanParam, ViewTuusinsakiUiBeanParam, ViewHituyouSyoruiUiBeanParam, SetBetukykExecUiBeanParam,
ViewTetudukityuuiUiBeanParam, ViewKouteiInfoUiBeanParam, ViewProgressHistoryUiBeanParam, ViewBetukykUiBeanParam,
ViewSyoruiInfoItiranUiBeanParam, CheckYuukouJyoutaiExecUiBeanParam, SetToriatukaiTyuuiExecUiBeanParam,
SetTetudukityuuiExecUiBeanParam, SetKeiyakusyaExecUiBeanParam, SetTuusinsakiExecUiBeanParam,
SetSyoruiInfoItiranExecUiBeanParam, SetHituyouSyoruiExecUiBeanParam,
SetKihonExecUiBeanParam, KhozenCommonParamGetHituyouSyoruiUiBeanParam, SetKouteiInfoExecUiBeanParam,
SetProgressHistoryExecUiBeanParam, SetKhKbnPatternUtilUiBeanParam, ViewTrkKazokuUiBeanParam,
SetTrkKazokuExecUiBeanParam, ViewKyksyadairiUiBeanParam, SetKyksyadairiExecUiBeanParam {

    private static final long serialVersionUID = 1L;

    @Inject
    private IT_KykKihon kykKihon;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private KinouMode kinouMode;

    private String kouteikanriid;

    private String jimutetuzukicd;

    private C_UmuKbn tyouhyoumukbn;

    private String tyouhyoukey;

    private C_UmuKbn mosuktymdhkumu;

    private BizDate ttdktyuuisetymd;

    private String[] imageids;

    private C_UmuKbn adrhenkouKbn;

    List<String> warningMessageIdList = new ArrayList<>();

    List<String> warningMessageList = new ArrayList<>();

    private C_UmuKbn trkkzkumukbn1;

    private String trkkzkyno1;

    private String trkkzkadr1kj1;

    private String trkkzkadr2kj1;

    private String trkkzkadr3kj1;

    private C_TsindousiteiKbn trkkzktsindousiteikbn1;

    private C_YouhiKbn trkkzktsindousiteihkyouhikbn1;

    private C_UmuKbn trkkzkumukbn2;

    private String trkkzkyno2;

    private String trkkzkadr1kj2;

    private String trkkzkadr2kj2;

    private String trkkzkadr3kj2;

    private C_TsindousiteiKbn trkkzktsindousiteikbn2;

    private C_YouhiKbn trkkzktsindousiteihkyouhikbn2;

    public C_UmuKbn getAdrhenkouKbn() {
        return adrhenkouKbn;
    }

    public void setAdrhenkouKbn(C_UmuKbn pAdrhenkouKbn) {
        this.adrhenkouKbn = pAdrhenkouKbn;
    }

    private C_SyorikekkaKbn zenkaisyorikekkakbn;

    public C_SyorikekkaKbn getZenkaisyorikekkakbn() {
        return zenkaisyorikekkakbn;
    }

    public void setZenkaisyorikekkakbn(C_SyorikekkaKbn pZenkaisyorikekkakbn) {
        this.zenkaisyorikekkakbn = pZenkaisyorikekkakbn;
    }

    private String kouteiLockKey;

    private String patternSyorikekkakbn;

    public String getPatternSyorikekkakbn() {
        return patternSyorikekkakbn;
    }

    @Override
    public void setPatternSyorikekkakbn(String patternSyorikekkakbn) {
        this.patternSyorikekkakbn = patternSyorikekkakbn;
    }

    public boolean isInputMode() {
        return kinouMode.getKinouMode().equals(C_KhkinouModeIdKbn.INPUT.getValue());
    }

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        this.kykKihon = pKykKihon;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        this.bzWorkflowInfo = pBzWorkflowInfo;
    }


    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }

    public C_UmuKbn getTyouhyoumukbn() {
        return tyouhyoumukbn;
    }

    public void setTyouhyoumukbn(C_UmuKbn pTyouhyoumukbn) {
        tyouhyoumukbn = pTyouhyoumukbn;
    }

    public String getTyouhyoukey() {
        return tyouhyoukey;
    }

    public void setTyouhyoukey(String pTyouhyoukey) {
        tyouhyoukey = pTyouhyoukey;
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }

    private String syono;

    @Override
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    @Override
    public String getSyono() {
        return syono;
    }

    @Override
    public SyoruiInfoItiranDataSourceBeanCommonParam createSyoruiInfoItiranDataSourceBean() {
        return new SyoruiInfoListDataSourceBean();
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
    public TtdktyuuikbnInfoDataSourceBeanCommonParam createTtdktyuuikbnInfoDataSourceBean() {
        return new TtdktyuuikbnInfoDataSourceBean();
    }

    @Override
    public void convertSyoruiInfoItiranForCommonParam(List<SyoruiInfoItiranDataSourceBeanCommonParam> pSyoruiInfoItiran) {
        List<SyoruiInfoListDataSourceBean> syoruiInfoList = Lists.newArrayList();

        for (SyoruiInfoItiranDataSourceBeanCommonParam beanPram : pSyoruiInfoItiran) {
            syoruiInfoList.add((SyoruiInfoListDataSourceBean) beanPram);
        }

        super.setSyoruiInfoList(syoruiInfoList);
    }

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    @Override
    public KikeiyakuInfoDataSourceBeanCommonParam createKikeiyakuInfoDataSourceBean() {
        return new KikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertKikeiyakuInfoForCommonParam(List<KikeiyakuInfoDataSourceBeanCommonParam> pKikeiyakuInfo) {
        List<KikeiyakuInfoDataSourceBean> kikeiyakuInfoList = Lists.newArrayList();
        for (KikeiyakuInfoDataSourceBeanCommonParam beanPram : pKikeiyakuInfo) {
            kikeiyakuInfoList.add((KikeiyakuInfoDataSourceBean) beanPram);
        }

        super.setKikeiyakuInfo(kikeiyakuInfoList);

    }

    @Override
    public NenkinsiharaiInfoDataSourceBeanCommonParam createNenkinsiharaiInfoDataSourceBean() {
        return new NenkinsiharaiInfoDataSourceBean();
    }

    @Override
    public void convertNenkinsiharaiInfoForCommonParam(
        List<NenkinsiharaiInfoDataSourceBeanCommonParam> pNenkinsiharaiInfo) {
        List<NenkinsiharaiInfoDataSourceBean> nenkinsiharaifoList = Lists.newArrayList();

        for (NenkinsiharaiInfoDataSourceBeanCommonParam beanPram : pNenkinsiharaiInfo) {
            nenkinsiharaifoList.add((NenkinsiharaiInfoDataSourceBean) beanPram);
        }

        super.setNenkinsiharaiInfo(nenkinsiharaifoList);

    }

    @Override
    public PalkikeiyakuInfoDataSourceBeanCommonParam createPalkikeiyakuInfoDataSourceBean() {
        return new PalkikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertPalkikeiyakuInfoForCommonParam(List<PalkikeiyakuInfoDataSourceBeanCommonParam> pPalkikeiyakuInfo) {
        List<PalkikeiyakuInfoDataSourceBean> palkikeiyakuInfoList = Lists.newArrayList();

        for (PalkikeiyakuInfoDataSourceBeanCommonParam beanPram : pPalkikeiyakuInfo) {
            palkikeiyakuInfoList.add((PalkikeiyakuInfoDataSourceBean) beanPram);
        }

        super.setPalkikeiyakuInfo(palkikeiyakuInfoList);

    }

    @Override
    public PalNenkinsiharaiInfoDataSourceBeanCommonParam createPalNenkinsiharaiInfoDataSourceBean() {
        return new PalnenkinsiharaiInfoDataSourceBean();
    }

    @Override
    public void convertPalNenkinsiharaiInfoForCommonParam(
        List<PalNenkinsiharaiInfoDataSourceBeanCommonParam> pPalNenkinsiharaiInfo) {
        List<PalnenkinsiharaiInfoDataSourceBean> palnenkinsiharaiInfoList = Lists.newArrayList();

        for (PalNenkinsiharaiInfoDataSourceBeanCommonParam beanPram : pPalNenkinsiharaiInfo) {
            palnenkinsiharaiInfoList.add((PalnenkinsiharaiInfoDataSourceBean) beanPram);
        }

        super.setPalnenkinsiharaiInfo(palnenkinsiharaiInfoList);

    }

    @Override
    public PalsueokiInfoDataSourceBeanCommonParam createPalsueokiInfoDataSourceBean() {
        return new PalsueokiInfoDataSourceBean();
    }

    @Override
    public void convertPalsueokiInfoForCommonParam(List<PalsueokiInfoDataSourceBeanCommonParam> pPalsueokiInfo) {
        List<PalsueokiInfoDataSourceBean> palsueokiInfoList = Lists.newArrayList();

        for (PalsueokiInfoDataSourceBeanCommonParam beanPram : pPalsueokiInfo) {
            palsueokiInfoList.add((PalsueokiInfoDataSourceBean) beanPram);
        }

        super.setPalsueokiInfo(palsueokiInfoList);

    }

    @Override
    public ProgressHistoryDataSourceBeanCommonParam createProgressHistoryDataSourceBean() {

        return new ProgresshistoryinfoDataSourceBean();
    }

    @Override
    public void convertProgressHistoryForCommonParam(
        List<ProgressHistoryDataSourceBeanCommonParam> progressHistoryDataSourceBeanCommonParam) {
        List<ProgresshistoryinfoDataSourceBean> progresshistoryinfoList = Lists.newArrayList();

        for (ProgressHistoryDataSourceBeanCommonParam beanPram : progressHistoryDataSourceBeanCommonParam) {
            progresshistoryinfoList.add((ProgresshistoryinfoDataSourceBean) beanPram);
        }

        super.setProgresshistoryinfo(progresshistoryinfoList);
    }

    public List<String> getWarningMessageIdList() {
        return warningMessageIdList;
    }

    @Override
    public void setWarningMessageIdList(List<String> pWarningMessageIdList) {
        this.warningMessageIdList = pWarningMessageIdList;
    }

    public List<String> getWarningMessageList() {
        return warningMessageList;
    }

    @Override
    public void setWarningMessageList(List<String> pWarningMessageList) {
        this.warningMessageList = pWarningMessageList;
    }

    private C_KhkinouModeIdKbn khkinouModeIdKbn;

    @Override
    public C_KhkinouModeIdKbn getKhkinouModeIdKbn() {
        return khkinouModeIdKbn;
    }

    public void setKhkinouModeIdKbn(C_KhkinouModeIdKbn pKhkinouModeIdKbn) {
        khkinouModeIdKbn = pKhkinouModeIdKbn;
    }

    private String syoriKekkaKbnPtnId;

    public String getSyoriKekkaKbnPtnId() {
        return syoriKekkaKbnPtnId;
    }

    public void setSyoriKekkaKbnPtnId(String pSyoriKekkaKbnPtnId) {
        syoriKekkaKbnPtnId = pSyoriKekkaKbnPtnId;
    }

    public C_UmuKbn getMosuktymdhkumu() {
        return mosuktymdhkumu;
    }

    public void setMosuktymdhkumu(C_UmuKbn pMosuktymdhkumu) {
        this.mosuktymdhkumu = pMosuktymdhkumu;
    }

    public BizDate getTtdktyuuisetymd() {
        return ttdktyuuisetymd;
    }

    public void setTtdktyuuisetymd(BizDate pTtdktyuuisetymd) {
        this.ttdktyuuisetymd = pTtdktyuuisetymd;
    }

    public String getKouteiLockKey() {
        return kouteiLockKey;
    }

    public void setKouteiLockKey(String pKouteiLockKey) {
        this.kouteiLockKey = pKouteiLockKey;
    }

    public C_UmuKbn getTrkkzkumukbn1() {
        return trkkzkumukbn1;
    }

    public void setTrkkzkumukbn1(C_UmuKbn pTrkkzkumukbn1) {
        this.trkkzkumukbn1 = pTrkkzkumukbn1;
    }

    public String getTrkkzkyno1() {
        return trkkzkyno1;
    }

    public void setTrkkzkyno1(String pTrkkzkyno1) {
        this.trkkzkyno1 = pTrkkzkyno1;
    }

    public String getTrkkzkadr1kj1() {
        return trkkzkadr1kj1;
    }

    public void setTrkkzkadr1kj1(String pTrkkzkadr1kj1) {
        this.trkkzkadr1kj1 = pTrkkzkadr1kj1;
    }

    public String getTrkkzkadr2kj1() {
        return trkkzkadr2kj1;
    }

    public void setTrkkzkadr2kj1(String pTrkkzkadr2kj1) {
        this.trkkzkadr2kj1 = pTrkkzkadr2kj1;
    }

    public String getTrkkzkadr3kj1() {
        return trkkzkadr3kj1;
    }

    public void setTrkkzkadr3kj1(String pTrkkzkadr3kj1) {
        this.trkkzkadr3kj1 = pTrkkzkadr3kj1;
    }

    public C_TsindousiteiKbn getTrkkzktsindousiteikbn1() {
        return trkkzktsindousiteikbn1;
    }

    public void setTrkkzktsindousiteikbn1(C_TsindousiteiKbn pTrkkzktsindousiteikbn1) {
        this.trkkzktsindousiteikbn1 = pTrkkzktsindousiteikbn1;
    }

    public C_YouhiKbn getTrkkzktsindousiteihkyouhikbn1() {
        return trkkzktsindousiteihkyouhikbn1;
    }

    public void setTrkkzktsindousiteihkyouhikbn1(C_YouhiKbn ptrkkzktsindousiteihkyouhikbn1) {
        this.trkkzktsindousiteihkyouhikbn1 = ptrkkzktsindousiteihkyouhikbn1;
    }

    public C_UmuKbn getTrkkzkumukbn2() {
        return trkkzkumukbn2;
    }

    public void setTrkkzkumukbn2(C_UmuKbn pTrkkzkumukbn2) {
        this.trkkzkumukbn2 = pTrkkzkumukbn2;
    }

    public String getTrkkzkyno2() {
        return trkkzkyno2;
    }

    public void setTrkkzkyno2(String pTrkkzkyno2) {
        this.trkkzkyno2 = pTrkkzkyno2;
    }

    public String getTrkkzkadr1kj2() {
        return trkkzkadr1kj2;
    }

    public void setTrkkzkadr1kj2(String pTrkkzkadr1kj2) {
        this.trkkzkadr1kj2 = pTrkkzkadr1kj2;
    }

    public String getTrkkzkadr2kj2() {
        return trkkzkadr2kj2;
    }

    public void setTrkkzkadr2kj2(String pTrkkzkadr2kj2) {
        this.trkkzkadr2kj2 = pTrkkzkadr2kj2;
    }

    public String getTrkkzkadr3kj2() {
        return trkkzkadr3kj2;
    }

    public void setTrkkzkadr3kj2(String pTrkkzkadr3kj2) {
        this.trkkzkadr3kj2 = pTrkkzkadr3kj2;
    }

    public C_TsindousiteiKbn getTrkkzktsindousiteikbn2() {
        return trkkzktsindousiteikbn2;
    }

    public void setTrkkzktsindousiteikbn2(C_TsindousiteiKbn pTrkkzktsindousiteikbn2) {
        this.trkkzktsindousiteikbn2 = pTrkkzktsindousiteikbn2;
    }

    public C_YouhiKbn getTrkkzktsindousiteihkyouhikbn2() {
        return trkkzktsindousiteihkyouhikbn2;
    }

    public void setTrkkzktsindousiteihkyouhikbn2(C_YouhiKbn ptrkkzktsindousiteihkyouhikbn2) {
        this.trkkzktsindousiteihkyouhikbn2 = ptrkkzktsindousiteihkyouhikbn2;
    }
}

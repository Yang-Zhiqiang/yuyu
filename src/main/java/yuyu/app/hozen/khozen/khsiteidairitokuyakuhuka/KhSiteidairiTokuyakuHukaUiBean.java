package yuyu.app.hozen.khozen.khsiteidairitokuyakuhuka;

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
import yuyu.common.hozen.khcommon.KhozenCommonParamGetHituyouSyoruiUiBeanParam;
import yuyu.common.hozen.khcommon.KhozenCommonParamKhMeigiHenkouUiBeanParam;
import yuyu.common.hozen.khview.viewbetukyk.ViewBetukykUiBeanParam;
import yuyu.common.hozen.khview.viewhihokensya.ViewHihokensyaUiBeanParam;
import yuyu.common.hozen.khview.viewhituyousyorui.ViewHituyouSyoruiUiBeanParam;
import yuyu.common.hozen.khview.viewkeiyakusya.ViewKeiyakusyaUiBeanParam;
import yuyu.common.hozen.khview.viewkihon.ViewKihonUiBeanParam;
import yuyu.common.hozen.khview.viewkyksyadairi.ViewKyksyadairiUiBeanParam;
import yuyu.common.hozen.khview.viewnkukt.ViewNkuktUiBeanParam;
import yuyu.common.hozen.khview.viewsbhkukt.ViewSbHkuktUiBeanParam;
import yuyu.common.hozen.khview.viewtetudukityuui.ViewTetudukityuuiUiBeanParam;
import yuyu.common.hozen.khview.viewtrkkazoku.ViewTrkKazokuUiBeanParam;
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
import yuyu.common.hozen.setuibean.SetKyksyadairiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetNkuktExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetSbHkuktExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTetudukityuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTrkKazokuExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTuusinsakiExecUiBeanParam;
import yuyu.common.hozen.setuibean.TtdktyuuikbnInfoDataSourceBeanCommonParam;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;

import com.google.common.collect.Lists;

/**
 * 被保険者代理特約中途付加 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhSiteidairiTokuyakuHukaUiBean extends GenKhSiteidairiTokuyakuHukaUiBean implements
SetToriatukaiTyuuiExecUiBeanParam, SetKouteiInfoExecUiBeanParam, SetKihonExecUiBeanParam,
SetBetukykExecUiBeanParam,
SetSyoruiInfoItiranExecUiBeanParam, SetTetudukityuuiExecUiBeanParam, SetKeiyakusyaExecUiBeanParam,
SetTuusinsakiExecUiBeanParam, SetHihokensyaExecUiBeanParam, SetNkuktExecUiBeanParam, SetSbHkuktExecUiBeanParam,
SetProgressHistoryExecUiBeanParam, SetHituyouSyoruiExecUiBeanParam, KhozenCommonParamGetHituyouSyoruiUiBeanParam,
KhozenCommonParamKhMeigiHenkouUiBeanParam, CheckYuukouJyoutaiExecUiBeanParam,
ViewKouteiInfoUiBeanParam, ViewKihonUiBeanParam, ViewBetukykUiBeanParam, ViewSyoruiInfoItiranUiBeanParam,
ViewTetudukityuuiUiBeanParam, ViewKeiyakusyaUiBeanParam, ViewTuusinsakiUiBeanParam, ViewHihokensyaUiBeanParam,
ViewNkuktUiBeanParam, ViewSbHkuktUiBeanParam, ViewProgressHistoryUiBeanParam, ViewHituyouSyoruiUiBeanParam,
SetKhKbnPatternUtilUiBeanParam,SetTrkKazokuExecUiBeanParam, ViewTrkKazokuUiBeanParam,
SetKyksyadairiExecUiBeanParam, ViewKyksyadairiUiBeanParam {

    private static final long serialVersionUID = 1L;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private IT_KykKihon kykKihon;

    private String syono;

    private C_SyorikekkaKbn zenkaiSyoriKekka;

    private String kouteiLockKey;

    private String tyouhyouKey;

    List<String> warningMessageIdList = new ArrayList<>();

    List<String> warningMessageList = new ArrayList<>();

    private C_KhkinouModeIdKbn khkinouModeIdKbn;

    private String patternSyorikekkakbn;

    private C_UmuKbn vshktsbhkuktumu;

    private C_UmuKbn vshktsbkyuuhukinuktumu;

    private C_UktKbn vshktdispsbuktkbn2;

    private C_UktKbn vshktdispsbuktkbn3;

    private C_UktKbn vshktdispsbuktkbn4;

    private String[] imageids;

    private C_Meigihnkjiyuu meigihnkjiyuu;

    private C_Hrkkaisuu hrkkaisuu;

    private C_UmuKbn daisennintdkumukbn;

    private Integer vshktsbuktsyurenno1;

    private Integer vshktsbuktsyurenno2;

    private Integer vshktsbuktsyurenno3;

    private Integer vshktsbuktsyurenno4;

    private boolean rstCheckYuuyokkngai;

    public KhSiteidairiTokuyakuHukaUiBean() {
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        bzWorkflowInfo = pBzWorkflowInfo;
    }

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        this.kykKihon = pKykKihon;
    }

    @Override
    public String getSyono() {
        return syono;
    }

    @Override
    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    public C_SyorikekkaKbn getZenkaiSyoriKekka() {
        return zenkaiSyoriKekka;
    }

    public void setZenkaiSyoriKekka(C_SyorikekkaKbn pZenkaiSyoriKekka) {
        this.zenkaiSyoriKekka = pZenkaiSyoriKekka;
    }

    public String getKouteiLockKey() {
        return kouteiLockKey;
    }

    public void setKouteiLockKey(String pKouteiLockKey) {
        this.kouteiLockKey = pKouteiLockKey;
    }

    public String getTyouhyouKey() {
        return tyouhyouKey;
    }

    public void setTyouhyouKey(String pTyouhyouKey) {
        this.tyouhyouKey = pTyouhyouKey;
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

    @Override
    public C_KhkinouModeIdKbn getKhkinouModeIdKbn() {
        return khkinouModeIdKbn;
    }

    public void setKhkinouModeIdKbn(C_KhkinouModeIdKbn pKhkinouModeIdKbn) {
        khkinouModeIdKbn = pKhkinouModeIdKbn;
    }

    public String getPatternSyorikekkakbn() {
        return patternSyorikekkakbn;
    }

    @Override
    public void setPatternSyorikekkakbn(String pPatternSyorikekkakbn) {
        patternSyorikekkakbn = pPatternSyorikekkakbn;
    }

    public C_UmuKbn getVshktsbhkuktumu() {
        return vshktsbhkuktumu;
    }

    @Override
    public void setVshktsbhkuktumu(C_UmuKbn pVshktsbhkuktumu) {
        vshktsbhkuktumu = pVshktsbhkuktumu;
    }

    @Override
    public C_UmuKbn getVshktsbkyuuhukinuktumu() {
        return vshktsbkyuuhukinuktumu;
    }

    @Override
    public void setVshktsbkyuuhukinuktumu(C_UmuKbn pVshktsbkyuuhukinuktumu) {
        vshktsbkyuuhukinuktumu = pVshktsbkyuuhukinuktumu;
    }

    @Override
    public C_UktKbn getVshktdispsbuktkbn2() {
        return vshktdispsbuktkbn2;
    }

    @Override
    public void setVshktdispsbuktkbn2(C_UktKbn pVshktdispsbuktkbn2) {
        vshktdispsbuktkbn2 = pVshktdispsbuktkbn2;
    }

    @Override
    public C_UktKbn getVshktdispsbuktkbn3() {
        return vshktdispsbuktkbn3;
    }

    @Override
    public void setVshktdispsbuktkbn3(C_UktKbn pVshktdispsbuktkbn3) {
        vshktdispsbuktkbn3 = pVshktdispsbuktkbn3;
    }

    @Override
    public C_UktKbn getVshktdispsbuktkbn4() {
        return vshktdispsbuktkbn4;
    }

    @Override
    public void setVshktdispsbuktkbn4(C_UktKbn pVshktdispsbuktkbn4) {
        vshktdispsbuktkbn4 = pVshktdispsbuktkbn4;
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }

    @Override
    public C_Meigihnkjiyuu getMeigihnkjiyuu() {
        return meigihnkjiyuu;
    }

    public void setMeigihnkjiyuu(C_Meigihnkjiyuu meigihnkjiyuu) {
        this.meigihnkjiyuu = meigihnkjiyuu;
    }

    @Override
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu hrkkaisuu) {
        this.hrkkaisuu = hrkkaisuu;
    }

    @Override
    public C_UmuKbn getDaisennintdkumukbn() {
        return daisennintdkumukbn;
    }

    public void setDaisennintdkumukbn(C_UmuKbn daisennintdkumukbn) {
        this.daisennintdkumukbn = daisennintdkumukbn;
    }

    public Integer getVshktsbuktsyurenno1() {
        return vshktsbuktsyurenno1;
    }

    @Override
    public void setVshktsbuktsyurenno1(Integer pVshktsbuktsyurenno1) {
        this.vshktsbuktsyurenno1 = pVshktsbuktsyurenno1;
    }

    public Integer getVshktsbuktsyurenno2() {
        return vshktsbuktsyurenno2;
    }

    @Override
    public void setVshktsbuktsyurenno2(Integer pVshktsbuktsyurenno2) {
        this.vshktsbuktsyurenno2 = pVshktsbuktsyurenno2;
    }

    public Integer getVshktsbuktsyurenno3() {
        return vshktsbuktsyurenno3;
    }

    @Override
    public void setVshktsbuktsyurenno3(Integer pVshktsbuktsyurenno3) {
        this.vshktsbuktsyurenno3 = pVshktsbuktsyurenno3;
    }

    public Integer getVshktsbuktsyurenno4() {
        return vshktsbuktsyurenno4;
    }

    @Override
    public void setVshktsbuktsyurenno4(Integer pVshktsbuktsyurenno4) {
        this.vshktsbuktsyurenno4 = pVshktsbuktsyurenno4;
    }

    public boolean getRstCheckYuuyokkngai() {
        return rstCheckYuuyokkngai;
    }

    public void setRstCheckYuuyokkngai(boolean pRstCheckYuuyokkngai) {
        this.rstCheckYuuyokkngai = pRstCheckYuuyokkngai;
    }

    @Override
    public void setStdrsknmkjhukakbn(C_KjkhukaKbn pStdrsknmkjhukakbn) {
        super.setStdrsknmkjhukakbn(pStdrsknmkjhukakbn);
        Boolean blnRet;
        if (pStdrsknmkjhukakbn == null || C_KjkhukaKbn.BLNK.eq(pStdrsknmkjhukakbn)) {
            blnRet = false;
        }
        else {
            blnRet = true;
        }
        super.setStdrsknmkjkhuka(blnRet);
    }

    @Override
    public void setStdrsknmkjkhuka(Boolean pStdrsknmkjkhuka) {
        super.setStdrsknmkjkhuka(pStdrsknmkjkhuka);
        C_KjkhukaKbn kjkhukaKbn;
        if (pStdrsknmkjkhuka == null || pStdrsknmkjkhuka == false) {
            kjkhukaKbn = C_KjkhukaKbn.BLNK;
        }
        else {
            kjkhukaKbn = C_KjkhukaKbn.KJKHUKA;
        }
        super.setStdrsknmkjhukakbn(kjkhukaKbn);
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
    public TtdktyuuikbnInfoDataSourceBeanCommonParam createTtdktyuuikbnInfoDataSourceBean() {
        return new TtdktyuuikbnInfoDataSourceBean();
    }

    @Override
    public void convertTtdktyuuikbnInfoForCommonParam(List<TtdktyuuikbnInfoDataSourceBeanCommonParam> pTtdktyuuikbnInfo) {
        List<TtdktyuuikbnInfoDataSourceBean> ttdktyuuikbnInfo = Lists.newArrayList();
        for (TtdktyuuikbnInfoDataSourceBeanCommonParam beanParam : pTtdktyuuikbnInfo) {
            ttdktyuuikbnInfo.add((TtdktyuuikbnInfoDataSourceBean) beanParam);
        }
        super.setTtdktyuuikbnInfo(ttdktyuuikbnInfo);
    }

    @Override
    public ProgressHistoryDataSourceBeanCommonParam createProgressHistoryDataSourceBean() {
        return new ProgresshistoryinfoDataSourceBean();
    }

    @Override
    public void convertProgressHistoryForCommonParam(
        List<ProgressHistoryDataSourceBeanCommonParam> pProgresshistoryinfo) {
        List<ProgresshistoryinfoDataSourceBean> progresshistoryinfo = Lists.newArrayList();

        for (ProgressHistoryDataSourceBeanCommonParam beanPram : pProgresshistoryinfo) {
            progresshistoryinfo.add((ProgresshistoryinfoDataSourceBean) beanPram);
        }

        super.setProgresshistoryinfo(progresshistoryinfo);
    }

}

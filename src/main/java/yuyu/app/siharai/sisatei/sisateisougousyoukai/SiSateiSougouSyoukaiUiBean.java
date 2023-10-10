package yuyu.app.siharai.sisatei.sisateisougousyoukai;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.ProgressHistoryDataSourceBeanCommonParam;
import yuyu.common.biz.koutei.SetProgressHistoryExecUiBeanParam;
import yuyu.common.biz.koutei.viewprogresshistory.ViewProgressHistoryUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam;
import yuyu.common.siharai.siview.SiSetUiBeanSetSkKihonKanriUiBeanParam;
import yuyu.common.siharai.siview.SkKihonKanriInfoDataSourceBeanCommonParam;
import yuyu.common.siharai.siview.ViewSkjyouhouSateiSougouSyoukaiUiBeanParam;
import yuyu.common.siharai.siview.ViewSouhusakiSateiSougouSyoukaiUiBeanParam;
import yuyu.common.siharai.siview.ViewSoukinsakiSateiSougouSyoukaiUiBeanParam;
import yuyu.common.siharai.siview.viewsaikeninfo.ViewSaikenInfoUiBeanParam;

import com.google.common.collect.Lists;

/**
 * 査定総合照会 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiSateiSougouSyoukaiUiBean extends GenSiSateiSougouSyoukaiUiBean implements
SetSyoruiInfoItiranExecUiBeanParam, ViewSyoruiInfoItiranUiBeanParam, SetProgressHistoryExecUiBeanParam,
ViewProgressHistoryUiBeanParam,ViewSaikenInfoUiBeanParam,
SiSetUiBeanSetSkKihonKanriUiBeanParam, ViewSkjyouhouSateiSougouSyoukaiUiBeanParam,
ViewSouhusakiSateiSougouSyoukaiUiBeanParam, ViewSoukinsakiSateiSougouSyoukaiUiBeanParam {

    private static final long serialVersionUID = 1L;

    public SiSateiSougouSyoukaiUiBean() {
    }

    private boolean seikyuuJyouhouFlag;

    private boolean mousidejinJyouhouFlag;

    private boolean saikensyaJyouhouFlag;

    private boolean hubiitiranFlag;

    private boolean keiyakuJyouhouFlag;

    private boolean sibouketoriNinzuFlag;

    private boolean uketoriJyouhou1Flag;

    private boolean uketoriJyouhou2Flag;

    private boolean uketoriJyouhou3Flag;

    private boolean uketoriJyouhou4Flag;

    private boolean siteiDairiSeikyuFlag;

    private boolean juuDairiFlag;

    private boolean uketsukeKanriIdFlag;

    private boolean betsuKeiyakuJyouhouFlag;

    private boolean ttdktyuuikbnInfoFlag;

    private boolean sikenSetFlag;

    private boolean sinsaTyuiFlag;

    private boolean fatcaTaisyouFlag;

    private boolean fatcaTaisyou1Flag;

    private boolean fatcaTaisyou2Flag;

    private boolean fatcaTaisyou3Flag;

    private boolean fatcaTaisyou4Flag;

    private boolean fatcaTaisyou5Flag;

    private boolean tokuyaku1Flag;

    private boolean tokuyaku2Flag;

    private boolean tokuyaku3Flag;

    private boolean tokuyaku4Flag;

    private boolean tokuyaku5Flag;

    private boolean tokuyaku6Flag;

    private boolean tokuyaku7Flag;

    private boolean tokuyaku8Flag;

    private boolean tokuyaku9Flag;

    private boolean tokuyaku10Flag;

    private boolean allPrintFlg;

    public boolean isSeikyuuJyouhouFlag() {
        return seikyuuJyouhouFlag;
    }

    public void setSeikyuuJyouhouFlag(boolean pSeikyuuJyouhouFlag) {
        this.seikyuuJyouhouFlag = pSeikyuuJyouhouFlag;
    }

    public boolean isMousidejinJyouhouFlag() {
        return mousidejinJyouhouFlag;
    }

    public void setMousidejinJyouhouFlag(boolean pMousidejinJyouhouFlag) {
        this.mousidejinJyouhouFlag = pMousidejinJyouhouFlag;
    }

    public boolean isSaikensyaJyouhouFlag() {
        return saikensyaJyouhouFlag;
    }

    public void setSaikensyaJyouhouFlag(boolean pSaikensyaJyouhouFlag) {
        this.saikensyaJyouhouFlag = pSaikensyaJyouhouFlag;
    }

    public boolean isHubiitiranFlag() {
        return hubiitiranFlag;
    }

    public void setHubiitiranFlag(boolean pHubiitiranFlag) {
        this.hubiitiranFlag = pHubiitiranFlag;
    }

    public boolean isKeiyakuJyouhouFlag() {
        return keiyakuJyouhouFlag;
    }

    public void setKeiyakuJyouhouFlag(boolean pKeiyakuJyouhouFlag) {
        this.keiyakuJyouhouFlag = pKeiyakuJyouhouFlag;
    }

    public boolean isSibouketoriNinzuFlag() {
        return sibouketoriNinzuFlag;
    }

    public void setSibouketoriNinzuFlag(boolean pSibouketoriNinzuFlag) {
        this.sibouketoriNinzuFlag = pSibouketoriNinzuFlag;
    }

    public boolean isUketoriJyouhou1Flag() {
        return uketoriJyouhou1Flag;
    }

    public void setUketoriJyouhou1Flag(boolean pUketoriJyouhou1Flag) {
        this.uketoriJyouhou1Flag = pUketoriJyouhou1Flag;
    }

    public boolean isUketoriJyouhou2Flag() {
        return uketoriJyouhou2Flag;
    }

    public void setUketoriJyouhou2Flag(boolean pUketoriJyouhou2Flag) {
        this.uketoriJyouhou2Flag = pUketoriJyouhou2Flag;
    }

    public boolean isUketoriJyouhou3Flag() {
        return uketoriJyouhou3Flag;
    }

    public void setUketoriJyouhou3Flag(boolean pUketoriJyouhou3Flag) {
        this.uketoriJyouhou3Flag = pUketoriJyouhou3Flag;
    }

    public boolean isUketoriJyouhou4Flag() {
        return uketoriJyouhou4Flag;
    }

    public void setUketoriJyouhou4Flag(boolean pUketoriJyouhou4Flag) {
        this.uketoriJyouhou4Flag = pUketoriJyouhou4Flag;
    }

    public boolean isSiteiDairiSeikyuFlag() {
        return siteiDairiSeikyuFlag;
    }

    public void setSiteiDairiSeikyuFlag(boolean pSiteiDairiSeikyuFlag) {
        this.siteiDairiSeikyuFlag = pSiteiDairiSeikyuFlag;
    }

    public boolean isJuuDairiFlag() {
        return juuDairiFlag;
    }

    public void setJuuDairiFlag(boolean pjuuDairiFlag) {
        this.juuDairiFlag = pjuuDairiFlag;
    }

    public boolean isUketsukeKanriIdFlag() {
        return uketsukeKanriIdFlag;
    }

    public void setUketsukeKanriIdFlag(boolean pUketsukeKanriIdFlag) {
        this.uketsukeKanriIdFlag = pUketsukeKanriIdFlag;
    }

    public boolean isBetsuKeiyakuJyouhouFlag() {
        return betsuKeiyakuJyouhouFlag;
    }

    public void setBetsuKeiyakuJyouhouFlag(boolean pBetsuKeiyakuJyouhouFlag) {
        this.betsuKeiyakuJyouhouFlag = pBetsuKeiyakuJyouhouFlag;
    }

    public boolean isTtdktyuuikbnInfoFlag() {
        return ttdktyuuikbnInfoFlag;
    }

    public void setTtdktyuuikbnInfoFlag(boolean pttdktyuuikbnInfoFlag) {
        this.ttdktyuuikbnInfoFlag = pttdktyuuikbnInfoFlag;
    }

    public boolean isSikenSetFlag() {
        return sikenSetFlag;
    }

    public void setSikenSetFlag(boolean pSikenSetFlag) {
        this.sikenSetFlag = pSikenSetFlag;
    }

    public boolean isSinsaTyuiFlag() {
        return sinsaTyuiFlag;
    }

    public void setSinsaTyuiFlag(boolean pSinsaTyuiFlag) {
        this.sinsaTyuiFlag = pSinsaTyuiFlag;
    }

    public boolean isFatcaTaisyouFlag() {
        return fatcaTaisyouFlag;
    }

    public void setFatcaTaisyouFlag(boolean pFatcaTaisyouFlag) {
        this.fatcaTaisyouFlag = pFatcaTaisyouFlag;
    }

    public boolean isFatcaTaisyou1Flag() {
        return fatcaTaisyou1Flag;
    }

    public void setFatcaTaisyou1Flag(boolean pFatcaTaisyou1Flag) {
        this.fatcaTaisyou1Flag = pFatcaTaisyou1Flag;
    }

    public boolean isFatcaTaisyou2Flag() {
        return fatcaTaisyou2Flag;
    }

    public void setFatcaTaisyou2Flag(boolean pFatcaTaisyou2Flag) {
        this.fatcaTaisyou2Flag = pFatcaTaisyou2Flag;
    }

    public boolean isFatcaTaisyou3Flag() {
        return fatcaTaisyou3Flag;
    }

    public void setFatcaTaisyou3Flag(boolean pFatcaTaisyou3Flag) {
        this.fatcaTaisyou3Flag = pFatcaTaisyou3Flag;
    }

    public boolean isFatcaTaisyou4Flag() {
        return fatcaTaisyou4Flag;
    }

    public void setFatcaTaisyou4Flag(boolean pFatcaTaisyou4Flag) {
        this.fatcaTaisyou4Flag = pFatcaTaisyou4Flag;
    }

    public boolean isFatcaTaisyou5Flag() {
        return fatcaTaisyou5Flag;
    }

    public void setFatcaTaisyou5Flag(boolean pFatcaTaisyou5Flag) {
        this.fatcaTaisyou5Flag = pFatcaTaisyou5Flag;
    }

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    @Override
    public SyoruiInfoItiranDataSourceBeanCommonParam createSyoruiInfoItiranDataSourceBean() {
        return new SyoruiInfoListDataSourceBean();
    }

    @Override
    public void convertSyoruiInfoItiranForCommonParam(List<SyoruiInfoItiranDataSourceBeanCommonParam> pDataSourceBeanLst) {
        List<SyoruiInfoListDataSourceBean> syoruiInfoList = Lists.newArrayList();

        for (SyoruiInfoItiranDataSourceBeanCommonParam beanParam : pDataSourceBeanLst) {
            syoruiInfoList.add((SyoruiInfoListDataSourceBean) beanParam);
        }

        super.setSyoruiInfoList(syoruiInfoList);
    }

    private String[] imageids;

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }

    @Override
    public ProgressHistoryDataSourceBeanCommonParam createProgressHistoryDataSourceBean() {
        return new ProgresshistoryinfoDataSourceBean();
    }

    @Override
    public void convertProgressHistoryForCommonParam(List<ProgressHistoryDataSourceBeanCommonParam> pDataSourceBeanLst) {
        List<ProgresshistoryinfoDataSourceBean> progresshistoryinfoList = Lists.newArrayList();

        for (ProgressHistoryDataSourceBeanCommonParam beanParam : pDataSourceBeanLst) {
            progresshistoryinfoList.add((ProgresshistoryinfoDataSourceBean) beanParam);
        }

        super.setProgresshistoryinfo(progresshistoryinfoList);

    }

    @Override
    public SkKihonKanriInfoDataSourceBeanCommonParam createSkKihonKanriInfoDataSourceBean() {
        return new SkKihonKanriInfoDataSourceBean();
    }

    @Override
    public void convertSkKihonKanriInfoForCommonParam(List<SkKihonKanriInfoDataSourceBeanCommonParam> pDataSourceBeanLst) {
        List<SkKihonKanriInfoDataSourceBean> skKihonKanriInfoList = Lists.newArrayList();

        for (SkKihonKanriInfoDataSourceBeanCommonParam beanParam : pDataSourceBeanLst) {
            skKihonKanriInfoList.add((SkKihonKanriInfoDataSourceBean) beanParam);
        }

        super.setSkKihonKanriInfo(skKihonKanriInfoList);
    }

    @Override
    public boolean isViewSaikenInfoInputDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSaikenInfoFlg() {
        return saikensyaJyouhouFlag;
    }

    @Override
    public boolean isViewSaikenInfoSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSaikenInfoDispFlg() {
        return true;
    }

    public boolean isTokuyaku1Flag() {
        return tokuyaku1Flag;
    }

    public void setTokuyaku1Flag(boolean ptokuyaku1Flag) {
        this.tokuyaku1Flag = ptokuyaku1Flag;
    }

    public boolean isTokuyaku2Flag() {
        return tokuyaku2Flag;
    }

    public void setTokuyaku2Flag(boolean ptokuyaku2Flag) {
        this.tokuyaku2Flag = ptokuyaku2Flag;
    }

    public boolean isTokuyaku3Flag() {
        return tokuyaku3Flag;
    }

    public void setTokuyaku3Flag(boolean ptokuyaku3Flag) {
        this.tokuyaku3Flag = ptokuyaku3Flag;
    }

    public boolean isTokuyaku4Flag() {
        return tokuyaku4Flag;
    }

    public void setTokuyaku4Flag(boolean ptokuyaku4Flag) {
        this.tokuyaku4Flag = ptokuyaku4Flag;
    }

    public boolean isTokuyaku5Flag() {
        return tokuyaku5Flag;
    }

    public void setTokuyaku5Flag(boolean ptokuyaku5Flag) {
        this.tokuyaku5Flag = ptokuyaku5Flag;
    }

    public boolean isTokuyaku6Flag() {
        return tokuyaku6Flag;
    }

    public void setTokuyaku6Flag(boolean ptokuyaku6Flag) {
        this.tokuyaku6Flag = ptokuyaku6Flag;
    }

    public boolean isTokuyaku7Flag() {
        return tokuyaku7Flag;
    }

    public void setTokuyaku7Flag(boolean ptokuyaku7Flag) {
        this.tokuyaku7Flag = ptokuyaku7Flag;
    }

    public boolean isTokuyaku8Flag() {
        return tokuyaku8Flag;
    }

    public void setTokuyaku8Flag(boolean ptokuyaku8Flag) {
        this.tokuyaku8Flag = ptokuyaku8Flag;
    }

    public boolean isTokuyaku9Flag() {
        return tokuyaku9Flag;
    }

    public void setTokuyaku9Flag(boolean ptokuyaku9Flag) {
        this.tokuyaku9Flag = ptokuyaku9Flag;
    }

    public boolean isTokuyaku10Flag() {
        return tokuyaku10Flag;
    }

    public void setTokuyaku10Flag(boolean ptokuyaku10Flag) {
        this.tokuyaku10Flag = ptokuyaku10Flag;
    }

    public boolean isAllPrintFlg() {
        return allPrintFlg;
    }

    public void setAllPrintFlg(boolean allPrintFlg) {
        this.allPrintFlg = allPrintFlg;
    }
}

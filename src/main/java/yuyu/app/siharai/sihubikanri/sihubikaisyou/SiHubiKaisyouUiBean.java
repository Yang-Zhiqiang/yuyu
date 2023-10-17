package yuyu.app.siharai.sihubikanri.sihubikaisyou;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.ProgressHistoryDataSourceBeanCommonParam;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.koutei.SetProgressHistoryExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiHubi;
import yuyu.def.db.entity.JT_SkKihon;

import com.google.common.collect.Lists;

/**
 * 保険金給付金不備解消 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiHubiKaisyouUiBean extends GenSiHubiKaisyouUiBean implements SetKouteiInfoExecUiBeanParam,
SetSyoruiInfoItiranExecUiBeanParam, SetProgressHistoryExecUiBeanParam {

    private static final long serialVersionUID = 1L;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private JT_SkKihon skKihon;

    @Inject
    private JT_SiHubi siHubi;

    private String hubiSikibetuKey;

    private C_UmuKbn itiranKeiyuUmuKbn;

    private String[] imageids;

    private boolean allPrintFlg;


    public SiHubiKaisyouUiBean() {
    }

    @Override
    public ProgressHistoryDataSourceBeanCommonParam createProgressHistoryDataSourceBean() {
        return new ProgresshistoryinfoDataSourceBean();
    }

    @Override
    public void convertProgressHistoryForCommonParam(List<ProgressHistoryDataSourceBeanCommonParam> pDataSourceBeanLst) {
        List<ProgresshistoryinfoDataSourceBean> progresshistoryinfoList = Lists.newArrayList();

        for (ProgressHistoryDataSourceBeanCommonParam beanPram : pDataSourceBeanLst) {
            progresshistoryinfoList.add((ProgresshistoryinfoDataSourceBean)beanPram);
        }

        super.setProgresshistoryinfo(progresshistoryinfoList);
    }

    @Override
    public SyoruiInfoItiranDataSourceBeanCommonParam createSyoruiInfoItiranDataSourceBean() {
        return new SyoruiInfoListDataSourceBean();
    }

    @Override
    public void convertSyoruiInfoItiranForCommonParam(List<SyoruiInfoItiranDataSourceBeanCommonParam> pSyoruiInfoItiran) {
        List<SyoruiInfoListDataSourceBean> syoruiInfoList = Lists.newArrayList();

        for (SyoruiInfoItiranDataSourceBeanCommonParam beanPram : pSyoruiInfoItiran) {
            syoruiInfoList.add((SyoruiInfoListDataSourceBean)beanPram);
        }

        super.setSyoruiInfoList(syoruiInfoList);
    }

    public String getHubiSikibetuKey() {
        return hubiSikibetuKey;
    }

    public void setHubiSikibetuKey(String pHubiSikibetuKey) {
        hubiSikibetuKey = pHubiSikibetuKey;
    }

    public C_UmuKbn getItiranKeiyuUmuKbn() {
        return itiranKeiyuUmuKbn;
    }

    public void setItiranKeiyuUmuKbn(C_UmuKbn pItiranKeiyuUmuKbn) {
        itiranKeiyuUmuKbn = pItiranKeiyuUmuKbn;
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }


    public boolean isAllPrintFlg() {
        return allPrintFlg;
    }

    public void setAllPrintFlg(boolean allPrintFlg) {
        this.allPrintFlg = allPrintFlg;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        bzWorkflowInfo = pBzWorkflowInfo;
    }

    public JT_SkKihon getSkKihon() {
        return skKihon;
    }

    public void setSkKihon(JT_SkKihon pSkKihon) {
        this.skKihon = pSkKihon;
    }

    public JT_SiHubi getSiHubi() {
        return siHubi;
    }

    public void setSiHubi(JT_SiHubi pSiHubi) {
        this.siHubi = pSiHubi;
    }

    public boolean isKidougmKbnWorkListSeigyo() {

        boolean kidougmKbnWorkListSeigyo = false;
        if (C_KidougmKbn.WORKLIST.eq(bzWorkflowInfo.getKidougmKbn())) {
            kidougmKbnWorkListSeigyo = true;
        }
        return kidougmKbnWorkListSeigyo;
    }

    public boolean isItiranGamenKeiyuSeigyo() {

        boolean itiranGamenKeiyuSeigyo = false;
        if (C_UmuKbn.ARI.eq(itiranKeiyuUmuKbn)) {
            itiranGamenKeiyuSeigyo = true;
        }
        return itiranGamenKeiyuSeigyo;
    }
}

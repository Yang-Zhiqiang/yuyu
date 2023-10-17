package yuyu.app.hozen.khhubikanri.khhubikaisyou;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.app.hozen.khhubikanri.khhubikaisyou.KhHubiKaisyouConstants.E_SyoriKeiyu;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.ProgressHistoryDataSourceBeanCommonParam;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.koutei.SetProgressHistoryExecUiBeanParam;
import yuyu.common.biz.koutei.viewkouteiinfo.ViewKouteiInfoUiBeanParam;
import yuyu.common.biz.koutei.viewprogresshistory.ViewProgressHistoryUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtilUiBeanParam;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.db.entity.IT_KhHubi;
import yuyu.def.db.entity.IT_KykKihon;

import com.google.common.collect.Lists;

/**
 * 契約保全不備解消 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhHubiKaisyouUiBean extends GenKhHubiKaisyouUiBean implements
ViewSyoruiInfoItiranUiBeanParam, SetSyoruiInfoItiranExecUiBeanParam, SetKouteiInfoExecUiBeanParam,
SetProgressHistoryExecUiBeanParam, ViewKouteiInfoUiBeanParam, ViewProgressHistoryUiBeanParam,
SetKhKbnPatternUtilUiBeanParam{

    private static final long serialVersionUID = 1L;

    public KhHubiKaisyouUiBean() {
    }

    @Inject
    private IT_KykKihon kykKihon;

    @Inject
    private IT_KhHubi khHubi;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    private E_SyoriKeiyu syoriKeiyuKbn;

    private String[] imageids;

    private C_KhkinouModeIdKbn khkinouModeIdKbn;

    private String patternSyorikekkakbn;

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        kykKihon = pKykKihon;
    }

    public IT_KhHubi getKhHubi() {
        return khHubi;
    }

    public void setKhHubi(IT_KhHubi pKhHubi) {
        khHubi = pKhHubi;
    }

    public E_SyoriKeiyu getSyoriKeiyuKbn() {
        return syoriKeiyuKbn;
    }

    public void setSyoriKeiyuKbn(E_SyoriKeiyu pSyoriKeiyuKbn) {
        syoriKeiyuKbn = pSyoriKeiyuKbn;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo bzWorkflowInfo) {
        this.bzWorkflowInfo = bzWorkflowInfo;
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
    public void convertProgressHistoryForCommonParam(
        List<ProgressHistoryDataSourceBeanCommonParam> progressHistoryDataSourceBeanCommonParam) {
        List<ProgresshistoryinfoDataSourceBean> progresshistoryinfoList = Lists.newArrayList();

        for (ProgressHistoryDataSourceBeanCommonParam beanPram : progressHistoryDataSourceBeanCommonParam) {
            progresshistoryinfoList.add((ProgresshistoryinfoDataSourceBean) beanPram);
        }

        super.setProgresshistoryinfo(progresshistoryinfoList);
    }

}

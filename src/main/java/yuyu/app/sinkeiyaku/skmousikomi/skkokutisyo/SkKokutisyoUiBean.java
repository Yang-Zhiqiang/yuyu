package yuyu.app.sinkeiyaku.skmousikomi.skkokutisyo;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.app.sinkeiyaku.skmousikomi.skkokutisyo.SkKokutisyoConstants.E_SyoriKbn;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.koutei.viewkouteiinfo.ViewKouteiInfoUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam;
import yuyu.common.sinkeiyaku.skcommon.SaiDataTourokuRegisterSaiDataKokutisyoUiBeanParam;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.TsRrkInfoTourokuRgstrKokutisyoUiBeanParam;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;

import com.google.common.collect.Lists;

/**
 * 告知書入力 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkKokutisyoUiBean extends GenSkKokutisyoUiBean implements TsRrkInfoTourokuRgstrKokutisyoUiBeanParam,
ViewSyoruiInfoItiranUiBeanParam, SetSyoruiInfoItiranExecUiBeanParam,
ViewKouteiInfoUiBeanParam, SetKouteiInfoExecUiBeanParam, SaiDataTourokuRegisterSaiDataKokutisyoUiBeanParam {

    private static final long serialVersionUID = 1L;

    private E_SyoriKbn syoriKbn;

    private String[] hubimsgData;

    private C_UmuKbn nyuryokuSaiUmu;

    private String[] imageids;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private SkIdounaiyouBeforeBean skIdounaiyouBeforeBean;


    @Inject
    private HT_SyoriCTL syoriCTL;

    public SkKokutisyoUiBean() {
    }

    public E_SyoriKbn getSyoriKbn() {
        return syoriKbn;
    }

    public void setSyoriKbn(E_SyoriKbn pSyoriKbn) {
        syoriKbn = pSyoriKbn;
    }

    public String[] getHubimsgData() {
        return hubimsgData;
    }

    public void setHubimsgData(String[] pHubimsgData) {
        hubimsgData = pHubimsgData;
    }

    public C_UmuKbn getNyuryokuSaiUmu() {
        return nyuryokuSaiUmu;
    }

    public void setNyuryokuSaiUmu(C_UmuKbn pNyuryokuSaiUmu) {
        nyuryokuSaiUmu = pNyuryokuSaiUmu;
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        this.imageids = pImageids;
    }

    public HT_SyoriCTL getSyoriCTL() {
        return syoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pSyoriCTL) {
        syoriCTL = pSyoriCTL;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        this.bzWorkflowInfo = pBzWorkflowInfo;
    }

    public SkIdounaiyouBeforeBean getSkIdounaiyouBeforeBean() {
        return skIdounaiyouBeforeBean;
    }

    public void setSkIdounaiyouBeforeBean(SkIdounaiyouBeforeBean pSkIdounaiyouBeforeBean) {
        this.skIdounaiyouBeforeBean = pSkIdounaiyouBeforeBean;
    }

    @Override
    public String getHbcmnt() {
        return getHbcmntgamen();
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
}

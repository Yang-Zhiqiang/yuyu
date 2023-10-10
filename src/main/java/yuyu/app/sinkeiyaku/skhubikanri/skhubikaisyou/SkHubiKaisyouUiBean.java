package yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou.SkHubiKaisyouConstants.E_SyoriKeiyu;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.koutei.viewkouteiinfo.ViewKouteiInfoUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.db.entity.HT_SyoriCTL;

import com.google.common.collect.Lists;

/**
 * 新契約不備解消 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkHubiKaisyouUiBean extends GenSkHubiKaisyouUiBean implements ViewSyoruiInfoItiranUiBeanParam,
SetSyoruiInfoItiranExecUiBeanParam, SetKouteiInfoExecUiBeanParam, ViewKouteiInfoUiBeanParam {

    private static final long serialVersionUID = 1L;

    @Inject
    private HT_SyoriCTL syoriCTL;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private SkIdounaiyouBeforeBean skIdounaiyouBeforeBean;

    private String hubisikibetukey;

    private E_SyoriKeiyu syorikeiyukbn;

    private C_MostenkenjyouKbn mostenkenjoukbn;

    private C_KetteiKbn ketteikbn;

    private C_KnkysateijyouKbn knkysateijyoukbn;

    private C_ImusateijyouKbn imusateijyoukbn;

    private String[] imageids;

    private String imusateiiraihyjctrlflg;

    public SkHubiKaisyouUiBean() {
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
        bzWorkflowInfo = pBzWorkflowInfo;
    }

    public SkIdounaiyouBeforeBean getSkIdounaiyouBeforeBean() {
        return skIdounaiyouBeforeBean;
    }

    public void setSkIdounaiyouBeforeBean(SkIdounaiyouBeforeBean pSkIdounaiyouBeforeBean) {
        skIdounaiyouBeforeBean = pSkIdounaiyouBeforeBean;
    }

    public String getHubisikibetukey() {
        return hubisikibetukey;
    }

    public void setHubisikibetukey(String pHubisikibetukey) {
        hubisikibetukey = pHubisikibetukey;
    }

    public E_SyoriKeiyu getSyorikeiyukbn() {
        return syorikeiyukbn;
    }

    public void setSyorikeiyukbn(E_SyoriKeiyu pSyorikeiyukbn) {
        syorikeiyukbn = pSyorikeiyukbn;
    }

    public C_MostenkenjyouKbn getMostenkenjoukbn() {
        return mostenkenjoukbn;
    }

    public void setMostenkenjoukbn(C_MostenkenjyouKbn pMostenkenjoukbn) {
        mostenkenjoukbn = pMostenkenjoukbn;
    }

    public C_KetteiKbn getKetteikbn() {
        return ketteikbn;
    }

    public void setKetteikbn(C_KetteiKbn pKetteikbn) {
        ketteikbn = pKetteikbn;
    }

    public C_KnkysateijyouKbn getKnkysateijyoukbn() {
        return knkysateijyoukbn;
    }

    public void setKnkysateijyoukbn(C_KnkysateijyouKbn pKnkysateijyoukbn) {
        knkysateijyoukbn = pKnkysateijyoukbn;
    }

    public C_ImusateijyouKbn getImusateijyoukbn() {
        return imusateijyoukbn;
    }

    public void setImusateijyoukbn(C_ImusateijyouKbn pImusateijyoukbn) {
        imusateijyoukbn = pImusateijyoukbn;
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }

    public String getImusateiiraihyjctrlflg() {
        return imusateiiraihyjctrlflg;
    }

    public void setImusateiiraihyjctrlflg(String pImusateiiraihyjctrlflg) {
        imusateiiraihyjctrlflg = pImusateiiraihyjctrlflg;
    }

    @Override
    public SyoruiInfoItiranDataSourceBeanCommonParam createSyoruiInfoItiranDataSourceBean() {

        SyoruiInfoListDataSourceBean syoruiInfoListDataSourceBean = SWAKInjector.getInstance(SyoruiInfoListDataSourceBean.class);
        return syoruiInfoListDataSourceBean;
    }

    @Override
    public void convertSyoruiInfoItiranForCommonParam(List<SyoruiInfoItiranDataSourceBeanCommonParam> pSyoruiInfoItiran) {
        List<SyoruiInfoListDataSourceBean>  syoruiInfoList = Lists.newArrayList();

        for (SyoruiInfoItiranDataSourceBeanCommonParam beanPram : pSyoruiInfoItiran) {
            syoruiInfoList.add((SyoruiInfoListDataSourceBean) beanPram);
        }
        super.setSyoruiInfoList(syoruiInfoList);
    }

}

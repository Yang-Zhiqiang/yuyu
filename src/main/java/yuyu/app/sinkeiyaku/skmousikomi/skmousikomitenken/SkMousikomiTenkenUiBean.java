package yuyu.app.sinkeiyaku.skmousikomi.skmousikomitenken;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.def.classification.C_UktkakKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;

import com.google.common.collect.Lists;

/**
 * 申込点検 の画面UiBeanクラスです。<br />
 */
@ConversationScoped
public class SkMousikomiTenkenUiBean extends GenSkMousikomiTenkenUiBean implements
ViewSyoruiInfoItiranUiBeanParam, SetSyoruiInfoItiranExecUiBeanParam, SetKouteiInfoExecUiBeanParam {

    private static final long serialVersionUID = 1L;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private HT_SyoriCTL syoriCTL;

    @Inject
    private SkIdounaiyouBeforeBean skIdounaiyouBeforeBean;

    private String[] imageids;

    private String[] hubimsgData;

    private C_UmuKbn kykdrtentsnsTumu;

    private C_UmuKbn aeoiTaisyouUmu;

    private String imusateiiraiFlg;

    private String koureisyaTaiouFlg;

    private String tyouhyouKey;

    public C_UmuKbn getKykdrtentsnsTumu() {
        return kykdrtentsnsTumu;
    }

    public void setKykdrtentsnsTumu(C_UmuKbn pKykdrtentsnsTumu) {
        this.kykdrtentsnsTumu = pKykdrtentsnsTumu;
    }

    public SkMousikomiTenkenUiBean() {
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        bzWorkflowInfo = pBzWorkflowInfo;
    }

    public HT_SyoriCTL getSyoriCTL() {
        return syoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pSyoriCTL) {
        this.syoriCTL = pSyoriCTL;
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }

    public String[] getHubimsgData() {
        return hubimsgData;
    }

    public void setHubimsgData(String[] pHubimsgData) {
        hubimsgData = pHubimsgData;
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
    public void setTkhsyouryaku(Boolean b) {
        super.setTkhsyouryaku(b);
        C_UmuKbn kbn;
        if (b) {
            kbn = C_UmuKbn.ARI;
        }
        else {
            kbn = null;
        }
        super.setTkhsyouryakuumukbn(kbn);
    }

    @Override
    public void setTkhsyouryakuumukbn(C_UmuKbn pTkhsyouryakuumukbn) {
        super.setTkhsyouryakuumukbn(pTkhsyouryakuumukbn);
        if (C_UmuKbn.ARI.eq(pTkhsyouryakuumukbn)) {
            super.setTkhsyouryaku(true);
        } else {
            super.setTkhsyouryaku(false);
        }
    }

    public SkIdounaiyouBeforeBean getSkIdounaiyouBeforeBean() {
        return skIdounaiyouBeforeBean;
    }

    public void setSkIdounaiyouBeforeBean(SkIdounaiyouBeforeBean pSkIdounaiyouBeforeBean) {
        this.skIdounaiyouBeforeBean = pSkIdounaiyouBeforeBean;
    }

    List<String> warningMessageIdList = new ArrayList<>();

    List<String> warningMessageList = new ArrayList<>();

    public List<String> getWarningMessageIdList() {
        return warningMessageIdList;
    }

    public void setWarningMessageIdList(List<String> pWarningMessageIdList) {
        this.warningMessageIdList = pWarningMessageIdList;
    }

    public List<String> getWarningMessageList() {
        return warningMessageList;
    }

    public void setWarningMessageList(List<String> pWarningMessageList) {
        this.warningMessageList = pWarningMessageList;
    }

    public C_UmuKbn getAeoiTaisyouUmu() {
        return aeoiTaisyouUmu;
    }

    public void setAeoiTaisyouUmu(C_UmuKbn pAeoiTaisyouUmu) {
        this.aeoiTaisyouUmu = pAeoiTaisyouUmu;
    }

    public String getImusateiiraiFlg() {
        return imusateiiraiFlg;
    }

    public void setImusateiiraiFlg(String pImusateiiraiFlg) {
        this.imusateiiraiFlg = pImusateiiraiFlg;
    }

    public String getKoureisyaTaiouFlg() {
        return koureisyaTaiouFlg;
    }

    public void setKoureisyaTaiouFlg(String pKoureisyaTaiouFlg) {
        this.koureisyaTaiouFlg = pKoureisyaTaiouFlg;
    }

    public String getTyouhyouKey() {
        return tyouhyouKey;
    }

    public void setTyouhyouKey(String pTyouhyouKey) {
        tyouhyouKey = pTyouhyouKey;
    }

    @Override
    public void setUktkak(Boolean pUktkak){

        super.setUktkak(pUktkak);

        C_UktkakKbn uktkakKbn;

        if (pUktkak) {
            uktkakKbn = C_UktkakKbn.SUMI;
        }
        else {
            uktkakKbn = C_UktkakKbn.BLNK;
        }

        super.setUktkakkbn(uktkakKbn);
    }

    @Override
    public void setUktkakkbn(C_UktkakKbn pUktkakkbn) {

        super.setUktkakkbn(pUktkakkbn);

        if (C_UktkakKbn.SUMI.eq(pUktkakkbn)){

            super.setUktkak(true);
        }
        else {

            super.setUktkak(false);
        }
    }
}

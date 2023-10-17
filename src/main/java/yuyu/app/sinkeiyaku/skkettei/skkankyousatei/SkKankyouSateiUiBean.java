package yuyu.app.sinkeiyaku.skkettei.skkankyousatei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_LinckakKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.collect.Lists;

/**
 * 環境査定 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkKankyouSateiUiBean extends GenSkKankyouSateiUiBean implements ViewSyoruiInfoItiranUiBeanParam,
SetSyoruiInfoItiranExecUiBeanParam, SetKouteiInfoExecUiBeanParam {

    private static final long serialVersionUID = 1L;

    private int imusateiIraiyhFlg;

    private int mosTenkenIraiyhFlg;

    private String[] hubimsgData;

    private List<String> gmwarningIdLst;

    private List<String> gmwarningLst;

    private String patternKnksateisateikekka;

    private String patternKetkekkacd;

    private String[] imageids;

    @Inject
    private HT_SyoriCTL syoriCTL;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private SkIdounaiyouBeforeBean skIdounaiyouBeforeBean;

    private int tasyaKanyuuJoukyouPath;

    private String lincjyusintrrenno;

    private List<String> tyouhyoukeyLst;

    private boolean haneibtnOnClickFlg;

    public SkKankyouSateiUiBean() {
    }

    public HT_SyoriCTL getSyoriCTL() {
        return syoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pSyoriCTL) {
        this.syoriCTL = pSyoriCTL;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo () {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        this.bzWorkflowInfo = pBzWorkflowInfo;
    }

    public KinouMode getKinouMode () {
        return kinouMode;
    }

    public void setKinouMode(KinouMode pKinouMode) {
        this.kinouMode = pKinouMode;
    }

    public SkIdounaiyouBeforeBean getSkIdounaiyouBeforeBean() {
        return skIdounaiyouBeforeBean;
    }

    public void setSkIdounaiyouBeforeBean(SkIdounaiyouBeforeBean pSkIdounaiyouBeforeBean) {
        this.skIdounaiyouBeforeBean = pSkIdounaiyouBeforeBean ;
    }

    public int getImusateiIraiyhFlg() {
        return imusateiIraiyhFlg;
    }

    public void setImusateiIraiyhFlg(int pImusateiIraiyhFlg) {
        imusateiIraiyhFlg = pImusateiIraiyhFlg;
    }

    public int getMosTenkenIraiyhFlg() {
        return mosTenkenIraiyhFlg;
    }

    public void setMosTenkenIraiyhFlg(int pMosTenkenIraiyhFlg) {
        mosTenkenIraiyhFlg = pMosTenkenIraiyhFlg;
    }

    public String[] getHubimsgData() {
        return hubimsgData;
    }

    public void setHubimsgData(String[] pHubimsgData) {
        hubimsgData = pHubimsgData;
    }

    public List<String> getGmwarningIdLst() {
        return gmwarningIdLst;
    }

    public void setGmwarningIdLst(List<String> pGmwarningIdLst) {
        gmwarningIdLst = pGmwarningIdLst;
    }

    public List<String> getGmwarningLst() {
        return gmwarningLst;
    }

    public void setGmwarningLst(List<String> pGmwarningLst) {
        gmwarningLst = pGmwarningLst;
    }

    public String getPatternKnksateisateikekka() {
        return patternKnksateisateikekka;
    }

    public void setPatternKnksateisateikekka(String pPatternKnksateisateikekka) {
        this.patternKnksateisateikekka = pPatternKnksateisateikekka;
    }

    public String getPatternKetkekkacd() {
        return patternKetkekkacd;
    }

    public void setPatternKetkekkacd(String pPatternKetkekkacd) {
        this.patternKetkekkacd = pPatternKetkekkacd;
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }

    public int getTasyaKanyuuJoukyouPath() {
        return tasyaKanyuuJoukyouPath;
    }

    public void setTasyaKanyuuJoukyouPath(int pTasyaKanyuuJoukyouPath) {
        this.tasyaKanyuuJoukyouPath = pTasyaKanyuuJoukyouPath;
    }

    public String getLincjyusintrrenno() {
        return lincjyusintrrenno;
    }

    public void setLincjyusintrrenno(String pLincjyusintrrenno) {
        this.lincjyusintrrenno = pLincjyusintrrenno;
    }

    public List<String> getTyouhyoukeyLst() {
        return tyouhyoukeyLst;
    }

    public void setTyouhyoukeyLst(List<String> pTyouhyoukeyLst) {
        this.tyouhyoukeyLst = pTyouhyoukeyLst;
    }

    public boolean isHaneibtnOnClickFlg() {
        return haneibtnOnClickFlg;
    }

    public void setHaneibtnOnClickFlg(boolean pHaneibtnOnClickFlg) {
        this.haneibtnOnClickFlg = pHaneibtnOnClickFlg;
    }

    @Override
    public void setHubihassintns(Boolean b){
        super.setHubihassintns(b);
        C_HubihassintnsKbn kbn;
        if(b){
            kbn = C_HubihassintnsKbn.ARI;
        }
        else{
            kbn = C_HubihassintnsKbn.BLNK;
        }
        super.setHubihassintnskbn(kbn);
    }

    @Override
    public void setLinckak(Boolean b){
        super.setLinckak(b);
        C_LinckakKbn kbn;
        if(b){
            kbn = C_LinckakKbn.SUMI;
        }
        else{
            kbn = C_LinckakKbn.BLNK;
        }
        super.setLinckakkbn(kbn);
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
}

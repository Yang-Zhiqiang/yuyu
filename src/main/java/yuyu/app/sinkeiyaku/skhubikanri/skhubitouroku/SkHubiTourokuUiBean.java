package yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.def.classification.C_DrtenRnrkhouKbn;
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.collect.Lists;

/**
 * 新契約不備登録 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkHubiTourokuUiBean extends GenSkHubiTourokuUiBean implements ViewSyoruiInfoItiranUiBeanParam,
SetSyoruiInfoItiranExecUiBeanParam, SetKouteiInfoExecUiBeanParam {

    private static final long serialVersionUID = 1L;

    public SkHubiTourokuUiBean() {
    }

    @Inject
    private HT_SyoriCTL syoriCTL;

    @Inject
    private SkIdounaiyouBeforeBean skIdounaiyouBeforeBean;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private KinouMode kinouMode;

    private String hubisikibetukey;

    private String[] imageids;

    private C_UmuKbn fsttourokuflg;

    private UserDefsList hubiKbnInfoSelList;

    private UserDefsList iraiNaiyouSelList;

    private C_UmuKbn itiranKeiyuUmuKbn;

    private String tyouhyouKey;

    private C_UmuKbn mihassinhubiumu;

    private C_HubikaisyoujoutaiKbn hubikaisyoujoutaikbn;

    private boolean tourokuBtnFlg;

    private String karisakuseiTyouhyouKey;

    private C_MosUketukeKbn mosuketukekbn;

    private C_DrtenRnrkhouKbn drtenRnrkhouKbn;

    private boolean kyokaFlg;

    private List<HubiList2DataSourceBean> hubiInputSeibiLst;

    private boolean keizokuEditKahi;

    public HT_SyoriCTL getSyoriCTL() {
        return syoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pSyoriCTL) {
        syoriCTL = pSyoriCTL;
    }

    public SkIdounaiyouBeforeBean getSkIdounaiyouBeforeBean() {
        return skIdounaiyouBeforeBean;
    }

    public void setSkIdounaiyouBeforeBean(SkIdounaiyouBeforeBean pSkIdounaiyouBeforeBean) {
        skIdounaiyouBeforeBean = pSkIdounaiyouBeforeBean;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
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

    public String getHubisikibetukey() {
        return hubisikibetukey;
    }

    public void setHubisikibetukey(String pHubisikibetukey) {
        hubisikibetukey = pHubisikibetukey;
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }

    public C_UmuKbn getFsttourokuflg() {
        return fsttourokuflg;
    }

    public void setFsttourokuflg(C_UmuKbn pFsttourokuflg) {
        fsttourokuflg = pFsttourokuflg;
    }

    public UserDefsList getHubiKbnInfoSelList() {
        return hubiKbnInfoSelList;
    }

    public void setHubiKbnInfoSelList(UserDefsList pHubiKbnInfoSelList) {
        hubiKbnInfoSelList = pHubiKbnInfoSelList;
    }

    public UserDefsList getIraiNaiyouSelList() {
        return iraiNaiyouSelList;
    }

    public void setIraiNaiyouSelList(UserDefsList pIraiNaiyouSelList) {
        iraiNaiyouSelList = pIraiNaiyouSelList;
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

    public C_UmuKbn getItiranKeiyuUmuKbn() {
        return itiranKeiyuUmuKbn;
    }

    public void setItiranKeiyuUmuKbn(C_UmuKbn pItiranKeiyuUmuKbn) {
        itiranKeiyuUmuKbn = pItiranKeiyuUmuKbn;
    }

    public String getTyouhyouKey() {
        return tyouhyouKey;
    }

    public void setTyouhyouKey(String pTyouhyouKey) {
        tyouhyouKey = pTyouhyouKey;
    }

    public C_UmuKbn getMihassinhubiumu() {
        return mihassinhubiumu;
    }

    public void setMihassinhubiumu(C_UmuKbn pMihassinhubiumu) {
        mihassinhubiumu = pMihassinhubiumu;
    }

    public C_HubikaisyoujoutaiKbn getHubikaisyoujoutaikbn() {
        return hubikaisyoujoutaikbn;
    }

    public void setHubikaisyoujoutaikbn(C_HubikaisyoujoutaiKbn pHubikaisyoujoutaikbn) {
        hubikaisyoujoutaikbn = pHubikaisyoujoutaikbn;
    }

    public boolean isTourokuBtnFlg() {
        return tourokuBtnFlg;
    }

    public void setTourokuBtnFlg(boolean pTourokuBtnFlg) {
        this.tourokuBtnFlg = pTourokuBtnFlg;
    }

    public String getKarisakuseiTyouhyouKey() {
        return karisakuseiTyouhyouKey;
    }

    public void setKarisakuseiTyouhyouKey(String pKarisakuseiTyouhyouKey) {
        this.karisakuseiTyouhyouKey = pKarisakuseiTyouhyouKey;
    }

    public C_MosUketukeKbn getMosuketukekbn() {
        return mosuketukekbn;
    }

    public void setMosuketukekbn(C_MosUketukeKbn pMosuketukekbn) {
        mosuketukekbn = pMosuketukekbn;
    }

    public C_DrtenRnrkhouKbn getDrtenRnrkhouKbn() {
        return drtenRnrkhouKbn;
    }

    public void setDrtenRnrkhouKbn(C_DrtenRnrkhouKbn pDrtenRnrkhouKbn) {
        drtenRnrkhouKbn = pDrtenRnrkhouKbn;
    }

    public boolean isKyokaFlg() {
        return kyokaFlg;
    }

    public void setKyokaFlg(boolean pKyokaFlg) {
        this.kyokaFlg = pKyokaFlg;
    }

    public List<HubiList2DataSourceBean> getHubiInputSeibiLst() {
        return hubiInputSeibiLst;
    }

    public void setHubiInputSeibiLst(List<HubiList2DataSourceBean> pHubiInputSeibiLst) {
        this.hubiInputSeibiLst = pHubiInputSeibiLst;
    }

    public boolean isKeizokuEditKahi() {
        return keizokuEditKahi;
    }

    public void setKeizokuEditKahi(boolean pKeizokuEditKahi) {
        this.keizokuEditKahi = pKeizokuEditKahi;
    }
}

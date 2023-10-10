package yuyu.app.siharai.sihubikanri.sihubitouroku;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.ProgressHistoryDataSourceBeanCommonParam;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.koutei.SetProgressHistoryExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SkKihon;

import com.google.common.collect.Lists;

/**
 * 保険金給付金不備登録 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiHubiTourokuUiBean extends GenSiHubiTourokuUiBean implements SetKouteiInfoExecUiBeanParam,
SetSyoruiInfoItiranExecUiBeanParam, SetProgressHistoryExecUiBeanParam {

    private static final long serialVersionUID = 1L;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private JT_SkKihon skKihon;

    private String patternSyorikekkaKbn;

    private boolean fstTourokuFlg;

    private String hubiSikibetuKey;

    private String tyouhyouJoinKey;

    private String jimuTetuzukiCd;

    private C_UmuKbn itiranKeiyuUmuKbn;

    private C_UmuKbn hasinsakiKokakuUmuKbn;

    private C_UmuKbn hasinsakiSisyaUmuKbn;

    private C_UmuKbn hasinsakiHonsyajimubumonUmuKbn;

    private String hhknnmkj;

    private String[] imageids;

    private boolean tagamenKidouHanteiFlg;

    private BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean;

    private String karisakuseiTyouhyouJoinKey;

    private String jimuyoucd;

    private C_UmuKbn jmycdMisetteiKbn;

    public SiHubiTourokuUiBean() {
    }

    public String getPatternSyorikekkaKbn() {
        return patternSyorikekkaKbn;
    }

    public void setPatternSyorikekkaKbn(String pPatternSyorikekkaKbn) {
        patternSyorikekkaKbn = pPatternSyorikekkaKbn;
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

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }

    public boolean isFstTourokuFlg() {
        return fstTourokuFlg;
    }

    public void setFstTourokuFlg(boolean pFstTourokuFlg) {
        fstTourokuFlg = pFstTourokuFlg;
    }

    public boolean isTagamenKidouHanteiFlg() {
        return tagamenKidouHanteiFlg;
    }

    public void setTagamenKidouHanteiFlg(boolean pTagamenKidouHanteiFlg) {
        tagamenKidouHanteiFlg = pTagamenKidouHanteiFlg;
    }

    public String getHubiSikibetuKey() {
        return hubiSikibetuKey;
    }

    public void setHubiSikibetuKey(String pHubiSikibetuKey) {
        hubiSikibetuKey = pHubiSikibetuKey;
    }

    public String getTyouhyouJoinKey() {
        return tyouhyouJoinKey;
    }

    public void setTyouhyouJoinKey(String pTyouhyouJoinKey) {
        tyouhyouJoinKey = pTyouhyouJoinKey;
    }

    public String getJimuTetuzukiCd() {
        return jimuTetuzukiCd;
    }

    public void setJimuTetuzukiCd(String pJimuTetuzukiCd) {
        jimuTetuzukiCd = pJimuTetuzukiCd;
    }

    public C_UmuKbn getItiranKeiyuUmuKbn() {
        return itiranKeiyuUmuKbn;
    }

    public void setItiranKeiyuUmuKbn(C_UmuKbn pItiranKeiyuUmuKbn) {
        itiranKeiyuUmuKbn = pItiranKeiyuUmuKbn;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        bzWorkflowInfo = pBzWorkflowInfo;
    }

    public C_UmuKbn getHasinsakiKokakuUmuKbn() {
        return hasinsakiKokakuUmuKbn;
    }

    public void setHasinsakiKokakuUmuKbn(C_UmuKbn pHasinsakiKokakuUmuKbn) {
        this.hasinsakiKokakuUmuKbn = pHasinsakiKokakuUmuKbn;
    }

    public C_UmuKbn getHasinsakiSisyaUmuKbn() {
        return hasinsakiSisyaUmuKbn;
    }

    public void setHasinsakiSisyaUmuKbn(C_UmuKbn pHasinsakiSisyaUmuKbn) {
        this.hasinsakiSisyaUmuKbn = pHasinsakiSisyaUmuKbn;
    }

    public C_UmuKbn getHasinsakiHonsyajimubumonUmuKbn() {
        return hasinsakiHonsyajimubumonUmuKbn;
    }

    public void setHasinsakiHonsyajimubumonUmuKbn(C_UmuKbn pHasinsakiHonsyajimubumonUmuKbn) {
        this.hasinsakiHonsyajimubumonUmuKbn = pHasinsakiHonsyajimubumonUmuKbn;
    }

    public String getHhknnmkj() {
        return hhknnmkj;
    }

    public void setHhknnmkj(String pHhknnmkj) {
        this.hhknnmkj = pHhknnmkj;
    }

    public JT_SkKihon getSkKihon() {
        return skKihon;
    }

    public void setSkKihon(JT_SkKihon pSkKihon) {
        this.skKihon = pSkKihon;
    }

    public boolean isKidougmKbnWorkListSeigyo() {

        boolean kidougmKbnWorkListSeigyo = false;
        if (C_KidougmKbn.WORKLIST.eq(bzWorkflowInfo.getKidougmKbn())) {
            kidougmKbnWorkListSeigyo = true;
        }
        return kidougmKbnWorkListSeigyo;
    }

    public boolean isNngHasinzumiHubiItiranUmuSeigyo() {

        boolean nngHasinzumiHubiItiranUmuSeigyo = false;
        if (super.getHasinzumihubiListDataSource().getAllData().size() > 0) {
            nngHasinzumiHubiItiranUmuSeigyo = true;
        }
        return nngHasinzumiHubiItiranUmuSeigyo;
    }

    public BzGetSosikiMadogutiInfoKekkaBean getBzGetSosikiMadogutiInfoKekkaBean() {
        return bzGetSosikiMadogutiInfoKekkaBean;
    }

    public void setBzGetSosikiMadogutiInfoKekkaBean(BzGetSosikiMadogutiInfoKekkaBean pBzGetSosikiMadogutiInfoKekkaBean) {
        bzGetSosikiMadogutiInfoKekkaBean = pBzGetSosikiMadogutiInfoKekkaBean;
    }
    public String getKarisakuseiTyouhyouJoinKey() {
        return karisakuseiTyouhyouJoinKey;
    }

    public void setKarisakuseiTyouhyouJoinKey(String pKarisakuseiTyouhyouJoinKey) {
        karisakuseiTyouhyouJoinKey = pKarisakuseiTyouhyouJoinKey;
    }

    public String getJimuyoucd() {
        return jimuyoucd;
    }

    public void setJimuyoucd(String pJimuyoucd) {
        jimuyoucd = pJimuyoucd;
    }

    public C_UmuKbn getJmycdMisetteiKbn() {
        return jmycdMisetteiKbn;
    }

    public void setJmycdMisetteiKbn(C_UmuKbn pJmycdMisetteiKbn) {
        jmycdMisetteiKbn = pJmycdMisetteiKbn;
    }
}

package yuyu.app.siharai.siskuke.siseikyuuuketukesb;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai.SiTtzkRirekiSyoukaiUiBean;
import static yuyu.app.siharai.siskuke.siseikyuuuketukesb.GenSiSeikyuuUketukeSbConstants.*;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.siharai.chksk.CheckSbSkNaiyouKekkaBean;
import yuyu.common.siharai.chksk.CheckSbSkNaiyouParam;
import yuyu.common.siharai.edittbl.EditRrkTblParam;
import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiByoumeiParam;
import yuyu.common.siharai.edittbl.SiKekkaInputParam;
import yuyu.common.siharai.edittbl.SiMnmeigibangouParam;
import yuyu.common.siharai.edittbl.SiNenkinInfoBean;
import yuyu.common.siharai.edittbl.SiSaikenParam;
import yuyu.common.siharai.edittbl.SiSateiKakSbParam;
import yuyu.common.siharai.edittbl.SiSeikyuuNaiyouParam;
import yuyu.common.siharai.edittbl.SiSeikyuusyaParam;
import yuyu.common.siharai.edittbl.SiShrdtlsyoHassouParam;
import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.common.siharai.edittbl.SiSiinParam;
import yuyu.common.siharai.edittbl.SiSindansyoJyouhouSbParam;
import yuyu.common.siharai.edittbl.SiSinkensyaKoukenninParam;
import yuyu.common.siharai.edittbl.SiSouhusakiInfoParam;
import yuyu.common.siharai.edittbl.SiSoukinsakiParam;
import yuyu.common.siharai.edittbl.SiSyoruiUketukeYmdSkukeParam;
import yuyu.common.siharai.sicommon.SiHkkingakuSisanParamBean;
import yuyu.common.siharai.siview.ViewSiharaiInfoSkukeUiBeanParam;
import yuyu.common.siharai.siview.ViewSindansyoInfo2DataSourceBeanCommonParam;
import yuyu.common.siharai.siview.ViewSindansyoInfo2DataSourceUiBeanParam;
import yuyu.common.siharai.siview.viewmnmeigibangou.ViewMnMeigiBangouUiBeanParam;
import yuyu.common.siharai.siview.viewsaikeninfo.ViewSaikenInfoUiBeanParam;
import yuyu.common.siharai.siview.viewsateikaisouyouhisibou.ViewSateikaisouyouhiSibouUiBeanParam;
import yuyu.common.siharai.siview.viewshrdtlsakuseikbn.ViewShrdtlSakuseiKbnUiBeanParam;
import yuyu.common.siharai.siview.viewsindansyoinfosibou.ViewSindansyoinfoSibouUiBeanParam;
import yuyu.common.siharai.siview.viewsinkensya.ViewSinkensyaUiBeanParam;
import yuyu.common.siharai.siview.viewskjyouhou.ViewSkjyouhouUiBeanParam;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParam;
import yuyu.common.siharai.siview.viewsknaiyou.ViewSknaiyouUiBeanParam;
import yuyu.common.siharai.siview.viewsouhusaki.ViewSouhusakiUiBeanParam;
import yuyu.common.siharai.siview.viewsoukinsaki.ViewSoukinsakiUiBeanParam;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SkskknsyubetuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.collect.Lists;

/**
 * （死亡）請求受付 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiSeikyuuUketukeSbUiBean extends GenSiSeikyuuUketukeSbUiBean implements EditSkTblParam,
SiSyoruiUketukeYmdSkukeParam, SiSeikyuusyaParam, SiSinkensyaKoukenninParam, SiSoukinsakiParam,
SiSeikyuuNaiyouParam, SiShrdtlsyoHassouParam, SiSindansyoJyouhouSbParam, SiSouhusakiInfoParam, SiSateiKakSbParam,
SiByoumeiParam, EditRrkTblParam, SiKekkaInputParam, ViewSkKihonUiBeanParam, ViewSkjyouhouUiBeanParam,
ViewSinkensyaUiBeanParam, ViewSouhusakiUiBeanParam, ViewSknaiyouUiBeanParam, ViewSoukinsakiUiBeanParam,
ViewSindansyoinfoSibouUiBeanParam, ViewSateikaisouyouhiSibouUiBeanParam, ViewShrdtlSakuseiKbnUiBeanParam,
SetKouteiInfoExecUiBeanParam, CheckSbSkNaiyouParam, ViewSindansyoInfo2DataSourceUiBeanParam,
ViewSiharaiInfoSkukeUiBeanParam, SiSaikenParam, SiMnmeigibangouParam, SiSiinParam, ViewSaikenInfoUiBeanParam,
ViewMnMeigiBangouUiBeanParam
{

    private static final long serialVersionUID = 1L;

    @Inject
    private JT_SkKihon skkihon;

    @Inject
    private SiTtzkRirekiSyoukaiUiBean siTtzkRirekiSyoukaiUiBean;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private KinouMode kinouMode;

    private JT_SiKykKihon siKykKihon;

    private  C_KidougmKbn kidougmKbn;

    private C_YouhiKbn siTtzkRirekiSyoukaiYouhiKbn ;

    private CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean;

    private C_ErrorKbn errorKbn;

    private SiHkkingakuSisanParamBean siHkkingakuSisanParamBean;

    private String kinouNm;

    private boolean viewShrdtlSakuseiKbnInputDispFlg;

    private boolean viewShrdtlSakuseiKbnFlg;

    private boolean viewSindansyoinfoSibouInputDispFlg;

    private boolean viewSoukinsakiInputDispFlg;

    private boolean viewSouhusakiInputDispFlg;

    private boolean viewSkjyouhouInputDispFlg;

    private boolean viewSaikenInfoFlg;

    private BizDate hubikanryouymd;

    private BizDate siboukaritrkymd ;

    private List<SiSiDetailParamBean> siSiDetailParamBean;

    private SiNenkinInfoBean siNenkinInfoBean;

    private List<String> byoumeitourokunolist;

    private boolean siSateiSougouSyoukaiFlg;

    private C_SiinKbn siinkbn;

    private String patterninputshrhousiteikbn;

    private String patternsiharaituukakbn;

    private C_GeninKbn siboukariuketukejiGeninKbn;

    public SiSeikyuuUketukeSbUiBean() {
    }

    @Override
    public JT_SkKihon getSkkihon() {
        return skkihon;
    }

    @Override
    public void setSkkihon(JT_SkKihon pSkkihon) {
        skkihon = pSkkihon;
    }

    public SiTtzkRirekiSyoukaiUiBean getSiTtzkRirekiSyoukaiUiBean() {
        return siTtzkRirekiSyoukaiUiBean;
    }

    public void setSiTtzkRirekiSyoukaiUiBean(SiTtzkRirekiSyoukaiUiBean pSiTtzkRirekiSyoukaiUiBean) {
        this.siTtzkRirekiSyoukaiUiBean = pSiTtzkRirekiSyoukaiUiBean;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        this.bzWorkflowInfo = pBzWorkflowInfo;
    }

    public JT_SiKykKihon getSiKykKihon() {
        return siKykKihon;
    }

    public void setSiKykKihon(JT_SiKykKihon pSiKykKihon) {
        this.siKykKihon = pSiKykKihon;
    }

    public C_KidougmKbn getKidougmKbn() {
        return kidougmKbn;
    }

    public void setKidougmKbn(C_KidougmKbn pKidougmKbn) {
        this.kidougmKbn = pKidougmKbn;
    }

    public C_YouhiKbn getSiTtzkRirekiSyoukaiYouhiKbn() {
        return siTtzkRirekiSyoukaiYouhiKbn;
    }

    public void setSiTtzkRirekiSyoukaiYouhiKbn(C_YouhiKbn pSiTtzkRirekiSyoukaiYouhiKbn) {
        this.siTtzkRirekiSyoukaiYouhiKbn = pSiTtzkRirekiSyoukaiYouhiKbn;
    }

    public CheckSbSkNaiyouKekkaBean getCheckSbSkNaiyouKekkaBean() {
        return checkSbSkNaiyouKekkaBean;
    }

    public void setCheckSbSkNaiyouKekkaBean(CheckSbSkNaiyouKekkaBean pCheckSbSkNaiyouKekkaBean) {
        this.checkSbSkNaiyouKekkaBean = pCheckSbSkNaiyouKekkaBean;
    }

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        this.errorKbn = pErrorKbn;
    }

    public SiHkkingakuSisanParamBean getSiHkkingakuSisanParamBean() {
        return siHkkingakuSisanParamBean;
    }

    public void setSiHkkingakuSisanParamBean(SiHkkingakuSisanParamBean pSiHkkingakuSisanParamBean) {
        this.siHkkingakuSisanParamBean = pSiHkkingakuSisanParamBean;
    }

    public String getKinouNm() {
        return kinouNm;
    }

    public void setKinouNm(String pKinouNm) {
        this.kinouNm = pKinouNm;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnInputDispFlg() {
        return viewShrdtlSakuseiKbnInputDispFlg;
    }

    public void setViewShrdtlSakuseiKbnInputDispFlg(boolean pViewShrdtlSakuseiKbnInputDispFlg) {
        this.viewShrdtlSakuseiKbnInputDispFlg = pViewShrdtlSakuseiKbnInputDispFlg;
    }

    @Override
    public boolean isViewSindansyoinfoSibouInputDispFlg() {
        return viewSindansyoinfoSibouInputDispFlg;
    }

    public void setViewSindansyoinfoSibouInputDispFlg(boolean pViewSindansyoinfoSibouInputDispFlg) {
        this.viewSindansyoinfoSibouInputDispFlg = pViewSindansyoinfoSibouInputDispFlg;
    }

    @Override
    public boolean isViewSoukinsakiInputDispFlg() {
        return viewSoukinsakiInputDispFlg;
    }

    public void setViewSoukinsakiInputDispFlg(boolean pViewSoukinsakiInputDispFlg) {
        this.viewSoukinsakiInputDispFlg = pViewSoukinsakiInputDispFlg;
    }

    @Override
    public boolean isViewSouhusakiInputDispFlg() {
        return viewSouhusakiInputDispFlg;
    }

    public void setViewSouhusakiInputDispFlg(boolean pViewSouhusakiInputDispFlg) {
        this.viewSouhusakiInputDispFlg = pViewSouhusakiInputDispFlg;
    }

    @Override
    public boolean isViewSkjyouhouInputDispFlg() {
        return viewSkjyouhouInputDispFlg;
    }

    public void setViewSkjyouhouInputDispFlg(boolean pViewSkjyouhouInputDispFlg) {
        this.viewSkjyouhouInputDispFlg = pViewSkjyouhouInputDispFlg;
    }

    public BizDate getSiboukaritrkymd() {
        return siboukaritrkymd;
    }

    public void setSiboukaritrkymd(BizDate pSiboukaritrkymd) {
        this.siboukaritrkymd = pSiboukaritrkymd;
    }

    public List<SiSiDetailParamBean> getSiSiDetailParamBean() {
        return siSiDetailParamBean;
    }

    public void setSiSiDetailParamBean(List<SiSiDetailParamBean> pSiSiDetailParamBean) {
        this.siSiDetailParamBean = pSiSiDetailParamBean;
    }

    public SiNenkinInfoBean getSiNenkinInfoBean() {
        return siNenkinInfoBean;
    }

    public void setSiNenkinInfoBean(SiNenkinInfoBean pSiNenkinInfoBean) {
        this.siNenkinInfoBean = pSiNenkinInfoBean;
    }


    @Override
    public BizDate getHubikanryouymd() {
        return hubikanryouymd;
    }

    @Override
    public void setHubikanryouymd(BizDate pHubikanryouymd) {
        hubikanryouymd = pHubikanryouymd;
    }

    @Override
    public List<String> getByoumeitourokunolist() {
        return byoumeitourokunolist;
    }

    @Override
    public void setByoumeitourokunolist(List<String> pByoumeitourokunolist) {
        byoumeitourokunolist = pByoumeitourokunolist;

    }

    public boolean isSiSateiSougouSyoukaiFlg() {
        return siSateiSougouSyoukaiFlg;
    }

    public void setSiSateiSougouSyoukaiFlg(boolean pSiSateiSougouSyoukaiFlg) {
        this.siSateiSougouSyoukaiFlg = pSiSateiSougouSyoukaiFlg;
    }

    @Override
    public void setSateikaksaigaikanousei(Boolean pSateikaksaigaikanousei) {
        super.setSateikaksaigaikanousei(pSateikaksaigaikanousei);

        C_UmuKbn sateikaksaigaikanousei = pSateikaksaigaikanousei ? C_UmuKbn.ARI : C_UmuKbn.NONE;

        super.setSateikaksaigaikanouseikbn(sateikaksaigaikanousei);
    }

    @Override
    public void setSateikakmeigihnk(Boolean pSateikakmeigihnk) {
        super.setSateikakmeigihnk(pSateikakmeigihnk);

        C_YouhiKbn sateikakmeigihnk = pSateikakmeigihnk ? C_YouhiKbn.YOU:C_YouhiKbn.HUYOU;

        super.setSateikakmeigihnkkbn(sateikakmeigihnk);
    }

    @Override
    public void setSateikakkaigaisb(Boolean pSateikakkaigaisb) {

        super.setSateikakkaigaisb(pSateikakkaigaisb);

        C_UmuKbn sateikakkaigaisbkbn = pSateikakkaigaisb ? C_UmuKbn.ARI:C_UmuKbn.NONE;

        super.setSateikakkaigaisbkbn(sateikakkaigaisbkbn);
    }

    @Override
    public void setSateikakhusyousi(Boolean pSateikakhusyousi) {

        super.setSateikakhusyousi(pSateikakhusyousi);

        C_UmuKbn sateikakhusyousikbn = pSateikakhusyousi ? C_UmuKbn.ARI:C_UmuKbn.NONE;

        super.setSateikakhusyousikbn(sateikakhusyousikbn);
    }

    public boolean isKidougmKbnWorkListSeigyo() {

        boolean kidougmKbnWorkListSeigyoFlg = false;
        if (C_KidougmKbn.WORKLIST.eq(this.getKidougmKbn())) {
            kidougmKbnWorkListSeigyoFlg = true;
        }
        return kidougmKbnWorkListSeigyoFlg;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnSeigyo() {
        return false;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnDispFlg() {
        return false;
    }

    public void setViewShrdtlSakuseiKbnFlg(boolean viewShrdtlSakuseiKbnFlg) {
        this.viewShrdtlSakuseiKbnFlg = viewShrdtlSakuseiKbnFlg;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnFlg() {
        return viewShrdtlSakuseiKbnFlg;
    }

    @Override
    public boolean isViewSateikaisouyouhiSibouSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSateikaisouyouhiSibouDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSindansyoinfoSibouSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSindansyoinfoSibouDispFlg() {
        return false;
    }

    @Override
    public boolean isInputshrhousiteiSeigyo() {
        return false;
    }

    @Override
    public boolean isInputshrhousiteiDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSoukinsakiSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSoukinsakiDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSknaiyouSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSknaiyouDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSouhusakiSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSouhusakiDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSinkensyaSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSinkensyaDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSinkensyaHyouji() {
        if (!BizUtil.isBlank(super.getSkskknnmkn()) || !BizUtil.isBlank(super.getSkskknnmkj()) ||
            !C_SkskknsyubetuKbn.BLNK.eq(super.getSkskknsyubetu())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isViewSkjyouhouSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSkjyouhouDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSkKihonSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSkKihonDispFlg() {
        return false;
    }

    public boolean isSiTtzkRirekiSyoukaiHyojiSeigyo () {
        boolean siTtzkRirekiSyoukaiHyojiSeigyoFlg = false;

        if (C_YouhiKbn.YOU.eq(getSiTtzkRirekiSyoukaiYouhiKbn())) {
            siTtzkRirekiSyoukaiHyojiSeigyoFlg = true;
        }

        return siTtzkRirekiSyoukaiHyojiSeigyoFlg;
    }

    @Override
    public ViewSindansyoInfo2DataSourceBeanCommonParam createSindansyoInfo2DataSourceBean() {
        return new ViewSindansyoinfoSibouInfo1DataSourceBean();
    }

    @Override
    public List<ViewSindansyoInfo2DataSourceBeanCommonParam> convertCommonParamForSindansyoInfo2() {

        List<ViewSindansyoInfo2DataSourceBeanCommonParam> beanCommonParamInfo = Lists.newArrayList();

        for (ViewSindansyoinfoSibouInfo1DataSourceBean dataSourceBean : super.getViewSindansyoinfoSibouInfo1DataSource().getAllData()) {
            if (C_Delflag.BLNK.eq(dataSourceBean.getSakujyoflg()) && !BizUtil.isBlank(dataSourceBean.getByoumeitourokuno())) {

                beanCommonParamInfo.add(dataSourceBean);
            }
        }
        return beanCommonParamInfo;
    }

    @Override
    public void convertSindansyoInfo2ForCommonParam(List<ViewSindansyoInfo2DataSourceBeanCommonParam> pSindansyoInfo) {

        List<ViewSindansyoinfoSibouInfo1DataSourceBean> dataSourceBeanInfo = Lists.newArrayList();

        for (ViewSindansyoInfo2DataSourceBeanCommonParam beanCommonParam : pSindansyoInfo) {

            ViewSindansyoinfoSibouInfo1DataSourceBean bataSourceBean = (ViewSindansyoinfoSibouInfo1DataSourceBean) beanCommonParam;

            dataSourceBeanInfo.add(bataSourceBean);
        }
        super.setViewSindansyoinfoSibouInfo1(dataSourceBeanInfo);
    }

    @Override
    public boolean isViewMnMeigiBangouSeigyo() {
        return false;
    }

    @Override
    public boolean isViewMnMeigiBangouDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSaikenInfoInputDispFlg() {
        return true;
    }

    public void setViewSaikenInfoFlg(boolean viewSaikenInfoFlg) {
        this.viewSaikenInfoFlg = viewSaikenInfoFlg;
    }

    @Override
    public boolean isViewSaikenInfoFlg() {
        return viewSaikenInfoFlg;
    }

    @Override
    public boolean isViewSaikenInfoSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSaikenInfoDispFlg() {
        return false;
    }

    @Override
    public C_SiinKbn getSiinkbn() {
        return siinkbn;
    }

    @Override
    public void setSiinkbn(C_SiinKbn pSiinkbn) {
        this.siinkbn = pSiinkbn;
    }

    public String getPatterninputshrhousiteikbn() {
        return patterninputshrhousiteikbn;
    }

    public void setPatterninputshrhousiteikbn(String patterninputshrhousiteikbn) {
        this.patterninputshrhousiteikbn = patterninputshrhousiteikbn;
    }

    public String getPatternsiharaituukakbn() {
        return patternsiharaituukakbn;
    }

    public void setPatternsiharaituukakbn(String patternsiharaiTuukaKbn) {
        this.patternsiharaituukakbn = patternsiharaiTuukaKbn;
    }

    public C_GeninKbn getSiboukariuketukejiGeninKbn() {
        return siboukariuketukejiGeninKbn;
    }

    public void setSiboukariuketukejiGeninKbn(C_GeninKbn siboukariuketukejiGeninKbn) {
        this.siboukariuketukejiGeninKbn = siboukariuketukejiGeninKbn;
    }

    public boolean isViewBanknmSitennmDispFlg() {
        boolean banknmSitennmDispFlg = false;

        if (getPageNo() == PAGENO_INPUTCONTENTS
            && C_SikinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) {
            banknmSitennmDispFlg = true;
        }

        return banknmSitennmDispFlg;
    }
}

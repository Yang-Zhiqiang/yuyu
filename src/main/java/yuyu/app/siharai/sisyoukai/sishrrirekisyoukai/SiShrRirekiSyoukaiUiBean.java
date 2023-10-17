package yuyu.app.siharai.sisyoukai.sishrrirekisyoukai;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.ProgressHistoryDataSourceBeanCommonParam;
import yuyu.common.biz.koutei.SetProgressHistoryExecUiBeanParam;
import yuyu.common.biz.koutei.viewprogresshistory.ViewProgressHistoryUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam;
import yuyu.common.siharai.siview.HktshrMeisaisInfoDataSourceBeanCommonParam;
import yuyu.common.siharai.siview.SiSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParam;
import yuyu.common.siharai.siview.ViewSiharaiSateiShrRirekiUiBeanParam;
import yuyu.common.siharai.siview.ViewSindansyoInfo2DataSourceBeanCommonParam;
import yuyu.common.siharai.siview.ViewSindansyoInfo2DataSourceUiBeanParam;
import yuyu.common.siharai.siview.viewbetukutichecksibou.ViewBetukutiCheckSibouUiBeanParam;
import yuyu.common.siharai.siview.viewippanhantei.ViewIppanhanteiUiBeanParam;
import yuyu.common.siharai.siview.viewjyuukasituinfo.ViewJyuukasituInfoUiBeanParam;
import yuyu.common.siharai.siview.viewkaijokigenymdinput.ViewKaijokigenymdInputUiBeanParam;
import yuyu.common.siharai.siview.viewkokuhancheck.ViewKokuhanCheckUiBeanParam;
import yuyu.common.siharai.siview.viewmeigihenkousatei.ViewMeigihenkouSateiUiBeanParam;
import yuyu.common.siharai.siview.viewmnmeigibangou.ViewMnMeigiBangouUiBeanParam;
import yuyu.common.siharai.siview.viewsaikeninfo.ViewSaikenInfoUiBeanParam;
import yuyu.common.siharai.siview.viewsateikaisouyouhisibou.ViewSateikaisouyouhiSibouUiBeanParam;
import yuyu.common.siharai.siview.viewshrdtlsakuseikbn.ViewShrdtlSakuseiKbnUiBeanParam;
import yuyu.common.siharai.siview.viewshrgoukei.ViewShrGoukeiUiBeanParam;
import yuyu.common.siharai.siview.viewshrsyousais.ViewShrSyousaiSUiBeanParam;
import yuyu.common.siharai.siview.viewsiharaiinfo.ViewSiharaiInfoUiBeanParam;
import yuyu.common.siharai.siview.viewsiininfo.ViewSiinInfoUiBeanParam;
import yuyu.common.siharai.siview.viewsindansyoinfosibou.ViewSindansyoinfoSibouUiBeanParam;
import yuyu.common.siharai.siview.viewsinkensya.ViewSinkensyaUiBeanParam;
import yuyu.common.siharai.siview.viewskjyouhou.ViewSkjyouhouUiBeanParam;
import yuyu.common.siharai.siview.viewsknaiyou.ViewSknaiyouUiBeanParam;
import yuyu.common.siharai.siview.viewsonotachecksibou.ViewSonotaCheckSibouUiBeanParam;
import yuyu.common.siharai.siview.viewsouhusaki.ViewSouhusakiUiBeanParam;
import yuyu.common.siharai.siview.viewsoukinsaki.ViewSoukinsakiUiBeanParam;
import yuyu.common.siharai.siview.viewtratkihuryouhusyoujiken.ViewTratkihuryouHusyoujikenUiBeanParam;
import yuyu.common.siharai.siview.viewzeimuinfo.ViewZeimuInfoUiBeanParam;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SateiYouhiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_Syorikeiyu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_BetukutiSateiInfo;
import yuyu.def.db.entity.JT_SateiIppanHanteiInfo;
import yuyu.def.db.entity.JT_SateiJyuukasituChkInfo;
import yuyu.def.db.entity.JT_SateiKaijyoInfo;
import yuyu.def.db.entity.JT_SateiKokuhanInfo;
import yuyu.def.db.entity.JT_SateiMeigihenkouInfo;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SibouSateiChkInfo;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_Toriatukaifuryouinfo;

import com.google.common.collect.Lists;

/**
 * 支払履歴照会 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiShrRirekiSyoukaiUiBean extends GenSiShrRirekiSyoukaiUiBean implements ViewSkjyouhouUiBeanParam,
ViewSaikenInfoUiBeanParam, ViewSinkensyaUiBeanParam, ViewSouhusakiUiBeanParam,
ViewSoukinsakiUiBeanParam, ViewSateikaisouyouhiSibouUiBeanParam, ViewSknaiyouUiBeanParam,
ViewSindansyoinfoSibouUiBeanParam, ViewSindansyoInfo2DataSourceUiBeanParam, ViewShrdtlSakuseiKbnUiBeanParam,
ViewMnMeigiBangouUiBeanParam, ViewSiinInfoUiBeanParam, ViewShrSyousaiSUiBeanParam,
ViewSiharaiInfoUiBeanParam, ViewShrGoukeiUiBeanParam, ViewZeimuInfoUiBeanParam,
ViewIppanhanteiUiBeanParam, ViewKokuhanCheckUiBeanParam, ViewJyuukasituInfoUiBeanParam,
ViewKaijokigenymdInputUiBeanParam, ViewMeigihenkouSateiUiBeanParam, ViewTratkihuryouHusyoujikenUiBeanParam,
ViewSonotaCheckSibouUiBeanParam, ViewBetukutiCheckSibouUiBeanParam, ViewSiharaiSateiShrRirekiUiBeanParam,
SetProgressHistoryExecUiBeanParam, ViewProgressHistoryUiBeanParam,
SetSyoruiInfoItiranExecUiBeanParam, ViewSyoruiInfoItiranUiBeanParam,
SiSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParam {

    private static final long serialVersionUID = 1L;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    private C_Syorikeiyu syoriKeiyuKbn;

    private C_SeikyuuSyubetu seikyuuSyubetu;

    private String[] imageids;

    private JT_Sk sk;

    private JT_SateiIppanHanteiInfo sateiIppanHanteiInfo;

    private JT_SateiJyuukasituChkInfo sateiJyuukasituChkInfo;

    private JT_SateiKokuhanInfo sateiKokuhanInfo;

    private JT_SateiKaijyoInfo sateiKaijyoInfo;

    private JT_SateiMeigihenkouInfo sateiMeigihenkouInfo;

    private JT_Toriatukaifuryouinfo toriatukaifuryouinfo;

    private JT_SibouSateiChkInfo sibouSateiChkInfo;

    private JT_BetukutiSateiInfo betukutiSateiInfo;

    private JT_SiKykKihon siKykKihon;

    private C_SinsaGendoKknKbn sinsagendokknkbn;

    private Integer rikoukityuutuudannissuu;

    private C_SateiYouhiKbn sateiyhkbn;

    private C_SaisateiKbn saisateikbn;

    private boolean shrGoukeiHaitoukinDispFlg;

    private boolean shrGoukeiSonotahaitoukinDispFlg;

    private boolean shrGoukeiMikeikapDispFlg;

    private boolean shrGoukeiMisyuupDispFlg;

    private boolean shrGoukeiZennouseisankgkDispFlg;

    private boolean shrGoukeiAzukarikingkDispFlg;

    private boolean shrGoukeiKrkgkDispFlg;

    private boolean viewSiharaiInfoGaikaknsnKijyunYmdFlg;

    public SiShrRirekiSyoukaiUiBean() {
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        this.bzWorkflowInfo = pBzWorkflowInfo;
    }

    public C_Syorikeiyu getSyoriKeiyuKbn() {
        return syoriKeiyuKbn;
    }

    public void setSyoriKeiyuKbn(C_Syorikeiyu pSyoriKeiyuKbn) {
        this.syoriKeiyuKbn = pSyoriKeiyuKbn;
    }

    public C_SeikyuuSyubetu getSeikyuuSyubetu() {
        return seikyuuSyubetu;
    }

    public void setSeikyuuSyubetu(C_SeikyuuSyubetu pSeikyuuSyubetu) {
        this.seikyuuSyubetu = pSeikyuuSyubetu;
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }

    public JT_Sk getSk() {
        return sk;
    }

    public void setSk(JT_Sk pSk) {
        this.sk = pSk;
    }

    public JT_SateiIppanHanteiInfo getSateiIppanHanteiInfo() {
        return sateiIppanHanteiInfo;
    }

    public void setSateiIppanHanteiInfo(JT_SateiIppanHanteiInfo pSateiIppanHanteiInfo) {
        this.sateiIppanHanteiInfo = pSateiIppanHanteiInfo;
    }

    public JT_SateiJyuukasituChkInfo getSateiJyuukasituChkInfo() {
        return sateiJyuukasituChkInfo;
    }

    public void setSateiJyuukasituChkInfo(JT_SateiJyuukasituChkInfo pSateiJyuukasituChkInfo) {
        this.sateiJyuukasituChkInfo = pSateiJyuukasituChkInfo;
    }

    public JT_SateiKokuhanInfo getSateiKokuhanInfo() {
        return sateiKokuhanInfo;
    }

    public void setSateiKokuhanInfo(JT_SateiKokuhanInfo pSateiKokuhanInfo) {
        this.sateiKokuhanInfo = pSateiKokuhanInfo;
    }

    public JT_SateiKaijyoInfo getSateiKaijyoInfo() {
        return sateiKaijyoInfo;
    }

    public void setSateiKaijyoInfo(JT_SateiKaijyoInfo pSateiKaijyoInfo) {
        this.sateiKaijyoInfo = pSateiKaijyoInfo;
    }

    public JT_SateiMeigihenkouInfo getSateiMeigihenkouInfo() {
        return sateiMeigihenkouInfo;
    }

    public void setSateiMeigihenkouInfo(JT_SateiMeigihenkouInfo pSateiMeigihenkouInfo) {
        this.sateiMeigihenkouInfo = pSateiMeigihenkouInfo;
    }

    public JT_Toriatukaifuryouinfo getToriatukaifuryouinfo() {
        return toriatukaifuryouinfo;
    }

    public void setToriatukaifuryouinfo(JT_Toriatukaifuryouinfo pToriatukaifuryouinfo) {
        this.toriatukaifuryouinfo = pToriatukaifuryouinfo;
    }

    public JT_SibouSateiChkInfo getSibouSateiChkInfo() {
        return sibouSateiChkInfo;
    }

    public void setSibouSateiChkInfo(JT_SibouSateiChkInfo pSibouSateiChkInfo) {
        this.sibouSateiChkInfo = pSibouSateiChkInfo;
    }

    public JT_BetukutiSateiInfo getBetukutiSateiInfo() {
        return betukutiSateiInfo;
    }

    public void setBetukutiSateiInfo(JT_BetukutiSateiInfo pBetukutiSateiInfo) {
        this.betukutiSateiInfo = pBetukutiSateiInfo;
    }

    public JT_SiKykKihon getSiKykKihon() {
        return siKykKihon;
    }

    public void setSiKykKihon(JT_SiKykKihon pSiKykKihon) {
        this.siKykKihon = pSiKykKihon;
    }

    @Override
    public C_SinsaGendoKknKbn getSinsagendokknkbn() {
        return sinsagendokknkbn;
    }

    @Override
    public void setSinsagendokknkbn(C_SinsaGendoKknKbn pSinsagendokknkbn) {
        this.sinsagendokknkbn = pSinsagendokknkbn;
    }

    @Override
    public Integer getRikoukityuutuudannissuu() {
        return rikoukityuutuudannissuu;
    }

    @Override
    public void setRikoukityuutuudannissuu(Integer pRikoukityuutuudannissuu) {
        this.rikoukityuutuudannissuu = pRikoukityuutuudannissuu;
    }

    public C_SateiYouhiKbn getSateiyhkbn() {
        return sateiyhkbn;
    }

    public void setSateiyhkbn(C_SateiYouhiKbn pSateiyhkbn) {
        sateiyhkbn = pSateiyhkbn;
    }

    public C_SaisateiKbn getSaisateiKbn() {
        return saisateikbn;
    }

    public void setSaisateiKbn(C_SaisateiKbn pSaisateiKbn) {
        saisateikbn = pSaisateiKbn;
    }

    @Override
    public HktshrMeisaisInfoDataSourceBeanCommonParam createHktshrMeisaisInfoDataSourceBean() {
        return SWAKInjector.getInstance(HktshrMeisaisInfoDataSourceBean.class);
    }

    @Override
    public void convertHktshrMeisaisInfoForCommonParam(List<HktshrMeisaisInfoDataSourceBeanCommonParam> pHktshrMeisaisInfo) {

        List<HktshrMeisaisInfoDataSourceBean> hktshrMeisaisInfoDataSourceBeanList = Lists.newArrayList();

        for (HktshrMeisaisInfoDataSourceBeanCommonParam commonParam : pHktshrMeisaisInfo) {

            hktshrMeisaisInfoDataSourceBeanList.add((HktshrMeisaisInfoDataSourceBean)commonParam);
        }

        super.setHktshrMeisaisInfo(hktshrMeisaisInfoDataSourceBeanList);
    }

    @Override
    public SyoruiInfoItiranDataSourceBeanCommonParam createSyoruiInfoItiranDataSourceBean() {
        return SWAKInjector.getInstance(SyoruiInfoListDataSourceBean.class);
    }

    @Override
    public void convertSyoruiInfoItiranForCommonParam(List<SyoruiInfoItiranDataSourceBeanCommonParam> pSyoruiInfoItiran) {

        List<SyoruiInfoListDataSourceBean> syoruiInfoListDataSourceBeanList = Lists.newArrayList();

        for (SyoruiInfoItiranDataSourceBeanCommonParam commonParam : pSyoruiInfoItiran) {

            syoruiInfoListDataSourceBeanList.add((SyoruiInfoListDataSourceBean)commonParam);
        }

        super.setSyoruiInfoList(syoruiInfoListDataSourceBeanList);
    }

    @Override
    public ProgressHistoryDataSourceBeanCommonParam createProgressHistoryDataSourceBean() {
        return SWAKInjector.getInstance(ProgresshistoryinfoDataSourceBean.class);
    }

    @Override
    public void convertProgressHistoryForCommonParam(List<ProgressHistoryDataSourceBeanCommonParam> pDataSourceBeanLst) {

        List<ProgresshistoryinfoDataSourceBean> progressHistoryDataSourceBeanList = Lists.newArrayList();

        for (ProgressHistoryDataSourceBeanCommonParam commonParam : pDataSourceBeanLst) {

            progressHistoryDataSourceBeanList.add((ProgresshistoryinfoDataSourceBean)commonParam);
        }

        super.setProgresshistoryinfo(progressHistoryDataSourceBeanList);
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
    public boolean isViewSouhusakiInputDispFlg() {
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
    public boolean isViewSoukinsakiInputDispFlg() {
        return false;
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
    public boolean isViewSknaiyouSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSknaiyouDispFlg() {
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
    public boolean isViewSindansyoinfoSibouInputDispFlg() {
        return false;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnSeigyo() {
        return false;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnDispFlg() {
        return false;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnFlg() {

        if (C_SaisateiKbn.SAISATEI.eq(saisateikbn)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnInputDispFlg() {
        return false;
    }

    @Override
    public boolean isViewShrSyousaiSSeigyo() {
        return false;
    }

    @Override
    public boolean isViewShrSyousaiSDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSiharaiInfoSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSiharaiInfoDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSiharaiInfoDispHantei() {

        if (sk != null &&
            (C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(sk.getSuketorihouhoukbn()) ||
                C_SUketoriHouhouKbn.ITIBU_NENKIN.eq(sk.getSuketorihouhoukbn()))) {

            return true;
        }
        return false;
    }

    @Override
    public boolean isViewShrGoukeiSeigyo() {
        return false;
    }

    @Override
    public boolean isViewShrGoukeiDispFlg() {
        return false;
    }

    @Override
    public boolean isViewShrGoukeiInfoUmuSeigyo() {

        if (sk != null && siKykKihon != null &&
            C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(sk.getSuketorihouhoukbn()) &&
            C_UmuKbn.ARI.eq(siKykKihon.getNstkhkumu())) {

            return false;
        }
        return true;
    }

    @Override
    public boolean isYenGoukeiSeigyo() {
        return false;
    }

    @Override
    public boolean isYenShrGoukeiDispFlg() {
        return false;
    }

    @Override
    public boolean isYenGoukeiInfoUmuSeigyo() {

        if (siKykKihon != null && C_Tuukasyu.JPY.eq(siKykKihon.getSiKykSyouhns().get(0).getKyktuukasyu())) {

            return false;
        }
        return true;
    }

    @Override
    public boolean isViewZeimuInfoSeigyo() {
        return false;
    }

    @Override
    public boolean isViewZeimuInfoDispFlg() {
        return false;
    }

    @Override
    public boolean isViewIppanhanteiSeigyo() {
        return false;
    }

    @Override
    public boolean isViewIppanhanteiDispFlg() {
        return false;
    }

    @Override
    public boolean isViewIppanhanteiFlg() {

        if (sateiIppanHanteiInfo != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isViewIppanhanteiInputDispFlg() {
        return false;
    }

    @Override
    public boolean isViewJyuukasituInfoSeigyo() {
        return false;
    }

    @Override
    public boolean isViewJyuukasituInfoDispFlg() {
        return false;
    }

    @Override
    public boolean isViewJyuukasituInfoFlg() {

        if (sateiJyuukasituChkInfo != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isViewJyuukasituInfoInputDispFlg() {
        return false;
    }

    @Override
    public boolean isViewKokuhanCheckSeigyo() {
        return false;
    }

    @Override
    public boolean isViewKokuhanCheckDispFlg() {
        return false;
    }

    @Override
    public boolean isViewKokuhanCheckFlg() {

        if (sateiKokuhanInfo != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isViewKokuhanCheckInputDispFlg() {
        return false;
    }

    @Override
    public boolean isViewKaijokigenymdSeigyo() {
        return false;
    }

    @Override
    public boolean isViewKaijokigenymdDispFlg() {
        return false;
    }

    @Override
    public boolean isViewKaijokigenymdInputFlg() {

        if (sateiKaijyoInfo != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isViewMeigihenkouSateiSeigyo() {
        return false;
    }

    @Override
    public boolean isViewMeigihenkouSateiDispFlg() {
        return false;
    }

    @Override
    public boolean isViewMeigihenkouSateiFlg() {

        if (sateiMeigihenkouInfo != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isViewTratkihuryouHusyoujikenSeigyo() {
        return false;
    }

    @Override
    public boolean isViewTratkihuryouHusyoujikenDispFlg() {
        return false;
    }

    @Override
    public boolean isViewTratkihuryouHusyoujikenFlg() {

        if (toriatukaifuryouinfo != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isViewTratkihuryouHusyoujikenInputDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSonotaCheckSibouSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSonotaCheckSibouDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSonotaCheckSibouFlg() {

        if (sibouSateiChkInfo != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isViewBetukutiCheckSibouSeigyo() {
        return false;
    }

    @Override
    public boolean isViewBetukutiCheckSibouDispFlg() {
        return false;
    }

    @Override
    public boolean isViewBetukutiCheckSibouFlg() {

        if (betukutiSateiInfo != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isViewBetukutiCheckSibouInputDispFlg() {
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
    public ViewSindansyoInfo2DataSourceBeanCommonParam createSindansyoInfo2DataSourceBean() {
        return new ViewSindansyoinfoSibouInfo1DataSourceBean();
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
    public boolean isViewSkjyouhouInputDispFlg() {
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
    public boolean isViewSaikenInfoFlg() {

        if (sk != null && sk.getSaikennmkj() != null && !sk.getSaikennmkj().equals("")) {
            return true ;
        }
        return false;
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
    public boolean isViewSaikenInfoInputDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSinkensyaHyouji() {

        if (sk != null && sk.getSkskknnmkn() != null && !sk.getSkskknnmkn().equals("")) {
            return true ;
        }
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
    public boolean isViewMnMeigiBangouSeigyo() {
        return false;
    }

    @Override
    public boolean isViewMnMeigiBangouDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSiinInfoSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSiinInfoDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSiinInfoFlg() {
        return true;
    }

    @Override
    public boolean isViewSiharaiInfoYenknsnKijyunYmdFlg() {

        boolean viewSiharaiInfoYenknsnKijyunYmdFlg = true;

        if (sk != null && sk.getKyktuukasyu() != null && C_Tuukasyu.JPY.eq(sk.getKyktuukasyu())) {
            viewSiharaiInfoYenknsnKijyunYmdFlg = false;
        }

        return viewSiharaiInfoYenknsnKijyunYmdFlg;
    }

    @Override
    public boolean isShrGoukeiHaitoukinDispFlg() {
        return shrGoukeiHaitoukinDispFlg;
    }

    public void setShrGoukeiHaitoukinDispFlg(boolean shrGoukeiHaitoukinDispFlg) {
        this.shrGoukeiHaitoukinDispFlg = shrGoukeiHaitoukinDispFlg;
    }

    @Override
    public boolean isShrGoukeiSonotahaitoukinDispFlg() {
        return shrGoukeiSonotahaitoukinDispFlg;
    }

    public void setShrGoukeiSonotahaitoukinDispFlg(boolean shrGoukeiSonotahaitoukinDispFlg) {
        this.shrGoukeiSonotahaitoukinDispFlg = shrGoukeiSonotahaitoukinDispFlg;
    }

    @Override
    public boolean isShrGoukeiMikeikapDispFlg() {
        return shrGoukeiMikeikapDispFlg;
    }

    public void setShrGoukeiMikeikapDispFlg(boolean shrGoukeiMikeikapDispFlg) {
        this.shrGoukeiMikeikapDispFlg = shrGoukeiMikeikapDispFlg;
    }

    @Override
    public boolean isShrGoukeiMisyuupDispFlg() {
        return shrGoukeiMisyuupDispFlg;
    }

    public void setShrGoukeiMisyuupDispFlg(boolean shrGoukeiMisyuupDispFlg) {
        this.shrGoukeiMisyuupDispFlg = shrGoukeiMisyuupDispFlg;
    }

    @Override
    public boolean isShrGoukeiZennouseisankgkDispFlg() {
        return shrGoukeiZennouseisankgkDispFlg;
    }

    public void setShrGoukeiZennouseisankgkDispFlg(boolean shrGoukeiZennouseisankgkDispFlg) {
        this.shrGoukeiZennouseisankgkDispFlg = shrGoukeiZennouseisankgkDispFlg;
    }

    @Override
    public boolean isShrGoukeiAzukarikingkDispFlg() {
        return shrGoukeiAzukarikingkDispFlg;
    }

    public void setShrGoukeiAzukarikingkDispFlg(boolean shrGoukeiAzukarikingkDispFlg) {
        this.shrGoukeiAzukarikingkDispFlg = shrGoukeiAzukarikingkDispFlg;
    }

    @Override
    public boolean isShrGoukeiKrkgkDispFlg() {
        return shrGoukeiKrkgkDispFlg;
    }

    public void setShrGoukeiKrkgkDispFlg(boolean shrGoukeiKrkgkDispFlg) {
        this.shrGoukeiKrkgkDispFlg = shrGoukeiKrkgkDispFlg;
    }

    @Override
    public boolean isViewSiharaiInfoGaikaknsnKijyunYmdFlg() {
        return viewSiharaiInfoGaikaknsnKijyunYmdFlg;
    }

    public void setViewSiharaiInfoGaikaknsnKijyunYmdFlg(boolean viewSiharaiInfoGaikaknsnKijyunYmdFlg) {
        this.viewSiharaiInfoGaikaknsnKijyunYmdFlg = viewSiharaiInfoGaikaknsnKijyunYmdFlg;
    }

}

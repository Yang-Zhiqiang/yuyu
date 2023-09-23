package yuyu.common.siharai.sicommon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.siharai.siview.HktshrMeisaisInfoDataSourceBeanCommonParam;
import yuyu.common.siharai.siview.SiSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParam;
import yuyu.common.siharai.siview.SiSetUiBeanSetSkKihonKanriUiBeanParam;
import yuyu.common.siharai.siview.SkKihonKanriInfoDataSourceBeanCommonParam;
import yuyu.common.siharai.siview.ViewHihokensyaSyouninTorikesiUiBeanParam;
import yuyu.common.siharai.siview.ViewHihokensyaSyouninTorikesiUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewKeiyakusyaSouhusakiUiBeanParam;
import yuyu.common.siharai.siview.ViewKekkaInputUiBeanParam;
import yuyu.common.siharai.siview.ViewKekkaInputUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSiharaiInfoSateiUiBeanParam;
import yuyu.common.siharai.siview.ViewSiharaiInfoSateiUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSiharaiInfoSkukeUiBeanParam;
import yuyu.common.siharai.siview.ViewSiharaiInfoSkukeUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSiharaiSateiShrRirekiUiBeanParam;
import yuyu.common.siharai.siview.ViewSiharaiSateiShrRirekiUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSindansyoInfo2DataSourceBeanCommonParam;
import yuyu.common.siharai.siview.ViewSindansyoInfo2DataSourceUiBeanParam;
import yuyu.common.siharai.siview.ViewSindansyoryouShrUiBeanParam;
import yuyu.common.siharai.siview.ViewSindansyoryouShrUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSiteidrUiBeanParam;
import yuyu.common.siharai.siview.ViewSiteidrUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSkjyouhouSateiSougouSyoukaiUiBeanParam;
import yuyu.common.siharai.siview.ViewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSkjyouhouSindansyoUiBeanParam;
import yuyu.common.siharai.siview.ViewSkjyouhouSindansyoUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSouhusakiSateiSougouSyoukaiUiBeanParam;
import yuyu.common.siharai.siview.ViewSouhusakiSateiSougouSyoukaiUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSouhusakiSindansyoUiBeanParam;
import yuyu.common.siharai.siview.ViewSouhusakiSindansyoUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSoukinsakiSateiSougouSyoukaiUiBeanParam;
import yuyu.common.siharai.siview.ViewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewTetudukiInputUiBeanParam;
import yuyu.common.siharai.siview.ViewTetudukiInputUiBeanParamImpl;
import yuyu.common.siharai.siview.viewbetukutichecksibou.ViewBetukutiCheckSibouUiBeanParam;
import yuyu.common.siharai.siview.viewbetukutichecksibou.ViewBetukutiCheckSibouUiBeanParamImpl;
import yuyu.common.siharai.siview.viewhihokensya.ViewHihokensyaUiBeanParam;
import yuyu.common.siharai.siview.viewhihokensya.ViewHihokensyaUiBeanParamImpl;
import yuyu.common.siharai.siview.viewippanhantei.ViewIppanhanteiUiBeanParam;
import yuyu.common.siharai.siview.viewippanhantei.ViewIppanhanteiUiBeanParamImpl;
import yuyu.common.siharai.siview.viewjyuukasituinfo.ViewJyuukasituInfoUiBeanParam;
import yuyu.common.siharai.siview.viewjyuukasituinfo.ViewJyuukasituInfoUiBeanParamImpl;
import yuyu.common.siharai.siview.viewkaijokigenymdinput.ViewKaijokigenymdInputUiBeanParam;
import yuyu.common.siharai.siview.viewkaijokigenymdinput.ViewKaijokigenymdInputUiBeanParamImpl;
import yuyu.common.siharai.siview.viewkingakuinfo.ViewKingakuInfoUiBeanParam;
import yuyu.common.siharai.siview.viewkokuhancheck.ViewKokuhanCheckUiBeanParam;
import yuyu.common.siharai.siview.viewkokuhancheck.ViewKokuhanCheckUiBeanParamImpl;
import yuyu.common.siharai.siview.viewmeigihenkousatei.ViewMeigihenkouSateiUiBeanParam;
import yuyu.common.siharai.siview.viewmeigihenkousatei.ViewMeigihenkouSateiUiBeanParamImpl;
import yuyu.common.siharai.siview.viewmnmeigibangou.ViewMnMeigiBangouUiBeanParam;
import yuyu.common.siharai.siview.viewmnmeigibangou.ViewMnMeigiBangouUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsaikeninfo.ViewSaikenInfoUiBeanParam;
import yuyu.common.siharai.siview.viewsaikeninfo.ViewSaikenInfoUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsateikaisouyouhisibou.ViewSateikaisouyouhiSibouUiBeanParam;
import yuyu.common.siharai.siview.viewsateikaisouyouhisibou.ViewSateikaisouyouhiSibouUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsateikekka.ViewSateiKekkaUiBeanParam;
import yuyu.common.siharai.siview.viewshrdtlsakuseikbn.ViewShrdtlSakuseiKbnUiBeanParam;
import yuyu.common.siharai.siview.viewshrdtlsakuseikbn.ViewShrdtlSakuseiKbnUiBeanParamImpl;
import yuyu.common.siharai.siview.viewshrgoukei.ViewShrGoukeiUiBeanParam;
import yuyu.common.siharai.siview.viewshrgoukei.ViewShrGoukeiUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsiharaiinfo.ViewSiharaiInfoUiBeanParam;
import yuyu.common.siharai.siview.viewsiharaiinfo.ViewSiharaiInfoUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsiharaisatei.ViewSiharaiSateiUiBeanParam;
import yuyu.common.siharai.siview.viewsiharaisatei.ViewSiharaiSateiUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsiininfo.ViewSiinInfoUiBeanParam;
import yuyu.common.siharai.siview.viewsiininfo.ViewSiinInfoUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsindansyoinfosibou.ViewSindansyoinfoSibouUiBeanParam;
import yuyu.common.siharai.siview.viewsindansyoinfosibou.ViewSindansyoinfoSibouUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsinkensya.ViewSinkensyaUiBeanParam;
import yuyu.common.siharai.siview.viewsinkensya.ViewSinkensyaUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskjyouhou.ViewSkjyouhouUiBeanParam;
import yuyu.common.siharai.siview.viewskjyouhou.ViewSkjyouhouUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParam;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsknaiyou.ViewSknaiyouUiBeanParam;
import yuyu.common.siharai.siview.viewsknaiyou.ViewSknaiyouUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsonotachecksibou.ViewSonotaCheckSibouUiBeanParam;
import yuyu.common.siharai.siview.viewsonotachecksibou.ViewSonotaCheckSibouUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsouhusaki.ViewSouhusakiUiBeanParam;
import yuyu.common.siharai.siview.viewsouhusaki.ViewSouhusakiUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsoukinsaki.ViewSoukinsakiUiBeanParam;
import yuyu.common.siharai.siview.viewsoukinsaki.ViewSoukinsakiUiBeanParamImpl;
import yuyu.common.siharai.siview.viewtratkihuryouhusyoujiken.ViewTratkihuryouHusyoujikenUiBeanParam;
import yuyu.common.siharai.siview.viewtratkihuryouhusyoujiken.ViewTratkihuryouHusyoujikenUiBeanParamImpl;
import yuyu.common.siharai.siview.viewuketorininsb.ViewUketorininSBUiBeanParam;
import yuyu.common.siharai.siview.viewzeimuinfo.ViewZeimuInfoUiBeanParam;
import yuyu.common.siharai.siview.viewzeimuinfo.ViewZeimuInfoUiBeanParamImpl;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_MeihenUktKbn;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyousaJyoukyouKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_BetukutiSateiInfo;
import yuyu.def.db.entity.JT_SateiIppanHanteiInfo;
import yuyu.def.db.entity.JT_SateiJyuukasituChkInfo;
import yuyu.def.db.entity.JT_SateiKaijyoInfo;
import yuyu.def.db.entity.JT_SateiKokuhanInfo;
import yuyu.def.db.entity.JT_SateiMeigihenkouInfo;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.db.entity.JT_SibouSateiChkInfo;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkByoumei;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_Toriatukaifuryouinfo;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.result.bean.DoujiSeikyuuInfosBySknoSyonoNeBean;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金支払共通UiBean設定
 */
public class SiSetUiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BzGetProcessSummary bzGetProcessSummary;

    @Inject
    private BzGetProcessSummaryInBean bzGetProcessSummaryInBean;

    public SiSetUiBean() {
        super();
    }

    public static void setHKTSkKihon(CommonViewUiBeanParam pUiBean, JT_SkKihon pSkKihon) {

        if (pUiBean == null) {
            return;
        }
        if (pSkKihon == null) {
            return;
        }

        if (pUiBean instanceof ViewSkKihonUiBeanParam) {

            ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
                .getInstance(ViewSkKihonUiBeanParamImpl.class);

            BeanUtil.copyProperties(viewSkKihonUiBeanParamImpl, pSkKihon);

            BeanUtil.copyProperties(pUiBean, viewSkKihonUiBeanParamImpl);
        }
    }

    public void setSk(CommonViewUiBeanParam pUiBean, JT_Sk pSk) {

        if (pUiBean == null) {
            return;
        }
        if (pSk == null) {
            return;
        }

        if (pUiBean instanceof ViewSiharaiInfoSkukeUiBeanParam) {
            setSyoruiUketukeYmdSkuke((ViewSiharaiInfoSkukeUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewSiharaiInfoSateiUiBeanParam) {
            setSyoruiUketukeYmdSkuke((ViewSiharaiInfoSateiUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewSkjyouhouUiBeanParam) {
            setSeikyuusya((ViewSkjyouhouUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewSkjyouhouSindansyoUiBeanParam) {
            setSeikyuusyaSindansyo((ViewSkjyouhouSindansyoUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewSkjyouhouSateiSougouSyoukaiUiBeanParam) {
            setSeikyuusyaSateiSougouSyoukai((ViewSkjyouhouSateiSougouSyoukaiUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewSoukinsakiUiBeanParam) {
            setSoukinsaki((ViewSoukinsakiUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewSoukinsakiSateiSougouSyoukaiUiBeanParam) {
            setSoukinsakiSateiSougouSyoukai((ViewSoukinsakiSateiSougouSyoukaiUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewSindansyoryouShrUiBeanParam) {
            setSindansyoryouShr((ViewSindansyoryouShrUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewShrdtlSakuseiKbnUiBeanParam) {
            setShrdtlsyoHassou((ViewShrdtlSakuseiKbnUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewSouhusakiUiBeanParam) {
            setSouhusakiInfo((ViewSouhusakiUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewSouhusakiSindansyoUiBeanParam) {
            setSouhusakiSindansyo((ViewSouhusakiSindansyoUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewSouhusakiSateiSougouSyoukaiUiBeanParam) {
            setSouhusakiSateiSougouSyoukai((ViewSouhusakiSateiSougouSyoukaiUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewSinkensyaUiBeanParam) {
            setSinkensya((ViewSinkensyaUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewSateikaisouyouhiSibouUiBeanParam) {
            setSateiKakSb((ViewSateikaisouyouhiSibouUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewSiharaiInfoUiBeanParam) {
            setSiharaiInfo((ViewSiharaiInfoUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewShrGoukeiUiBeanParam) {
            setShrGoukei((ViewShrGoukeiUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewSknaiyouUiBeanParam) {
            setSeikyuuNaiyou((ViewSknaiyouUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewSiinInfoUiBeanParam) {
            setSiinInfo((ViewSiinInfoUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewSaikenInfoUiBeanParam) {
            setSaikenInfo((ViewSaikenInfoUiBeanParam) pUiBean, pSk);
        }

        if (pUiBean instanceof ViewMnMeigiBangouUiBeanParam) {
            setMnMeigiBangou((ViewMnMeigiBangouUiBeanParam) pUiBean, pSk);
        }
    }

    public static void setSiharaiKingakuKeisanResult(CommonViewUiBeanParam pUiBean,
        SiHkkingakuSisanParamBean pSiHkkingakuSisanParamBean) {

        if (pUiBean == null) {
            return;
        }

        if (pUiBean instanceof ViewSiharaiInfoUiBeanParam) {
            setSiharaiInfo((ViewSiharaiInfoUiBeanParam) pUiBean, pSiHkkingakuSisanParamBean);
        }

        if (pUiBean instanceof ViewShrGoukeiUiBeanParam) {
            setShrGoukei((ViewShrGoukeiUiBeanParam) pUiBean, pSiHkkingakuSisanParamBean);
        }

        if (pUiBean instanceof ViewKingakuInfoUiBeanParam) {
            setKingakuInfo((ViewKingakuInfoUiBeanParam) pUiBean, pSiHkkingakuSisanParamBean);
        }

        if (pUiBean instanceof ViewZeimuInfoUiBeanParam) {
            setZeimuInfo((ViewZeimuInfoUiBeanParam) pUiBean, pSiHkkingakuSisanParamBean);
        }
    }

    public void setSkJiyuu(CommonViewUiBeanParam pUiBean, List<JT_SkJiyuu> pSkJiyuuLst,
        List<JT_SkByoumei> pSkByoumeiLst) {

        if (pUiBean == null) {
            return;
        }

        if (pUiBean instanceof ViewSindansyoinfoSibouUiBeanParam) {
            setSindansyoJyouhouSb((ViewSindansyoInfo2DataSourceUiBeanParam) pUiBean, pSkJiyuuLst, pSkByoumeiLst);
        }

    }

    public static void setIppanhantei(CommonViewUiBeanParam pUiBean, JT_SateiIppanHanteiInfo pSateiIppanHanteiInfo) {

        if (pUiBean == null) {
            return;
        }

        if (pUiBean instanceof ViewIppanhanteiUiBeanParam) {
            ViewIppanhanteiUiBeanParamImpl viewIppanhanteiUiBeanParamImpl = SWAKInjector
                .getInstance(ViewIppanhanteiUiBeanParamImpl.class);

            if (pSateiIppanHanteiInfo != null) {
                BeanUtil.copyProperties(viewIppanhanteiUiBeanParamImpl, pSateiIppanHanteiInfo);

            }else{
                viewIppanhanteiUiBeanParamImpl.setIppanhanteicomment1("");
                viewIppanhanteiUiBeanParamImpl.setIppanhanteicomment2("");
                viewIppanhanteiUiBeanParamImpl.setIppanhanteicomment3("");
                viewIppanhanteiUiBeanParamImpl.setIppanhanteicomment4("");
                viewIppanhanteiUiBeanParamImpl.setIppanhanteicomment5("");
                viewIppanhanteiUiBeanParamImpl.setIppanhanteicomment6("");
                viewIppanhanteiUiBeanParamImpl.setIppanhanteitensuu1("");
                viewIppanhanteiUiBeanParamImpl.setIppanhanteitensuu2("");
                viewIppanhanteiUiBeanParamImpl.setIppanhanteitensuu3("");
                viewIppanhanteiUiBeanParamImpl.setIppanhanteitensuu4("");
                viewIppanhanteiUiBeanParamImpl.setIppanhanteitensuu5("");
                viewIppanhanteiUiBeanParamImpl.setIppanhanteitensuu6("");
                viewIppanhanteiUiBeanParamImpl.setIppanhanteitensuu1("");
                viewIppanhanteiUiBeanParamImpl.setIppanhanteigoukeicomment("");
                viewIppanhanteiUiBeanParamImpl.setIppanhanteitensuugoukei("");
            }
            BeanUtil.copyProperties(pUiBean, viewIppanhanteiUiBeanParamImpl);

        }

    }

    public static void setKokuhanCheck(CommonViewUiBeanParam pUiBean, JT_SateiKokuhanInfo pSateiKokuhanInfo) {

        if (pUiBean == null) {
            return;
        }

        if (pUiBean instanceof ViewKokuhanCheckUiBeanParam) {

            ViewKokuhanCheckUiBeanParamImpl viewKokuhanCheckUiBeanParamImpl = SWAKInjector
                .getInstance(ViewKokuhanCheckUiBeanParamImpl.class);


            if (pSateiKokuhanInfo != null) {
                BeanUtil.copyProperties(viewKokuhanCheckUiBeanParamImpl, pSateiKokuhanInfo);
            }

            BeanUtil.copyProperties(pUiBean, viewKokuhanCheckUiBeanParamImpl);
        }

    }

    public static void setKaijokigenymdInput(CommonViewUiBeanParam pUiBean, JT_SateiKaijyoInfo pSateiKaijyoInfo) {

        if (pUiBean == null) {
            return;
        }

        if (pUiBean instanceof ViewKaijokigenymdInputUiBeanParam) {

            ViewKaijokigenymdInputUiBeanParamImpl viewKaijokigenymdInputUiBeanParamImpl = SWAKInjector
                .getInstance(ViewKaijokigenymdInputUiBeanParamImpl.class);


            if (pSateiKaijyoInfo != null) {
                BeanUtil.copyProperties(viewKaijokigenymdInputUiBeanParamImpl, pSateiKaijyoInfo);
            }

            BeanUtil.copyProperties(pUiBean, viewKaijokigenymdInputUiBeanParamImpl);
        }

    }

    public static void setMeigihenkouSatei(CommonViewUiBeanParam pUiBean, JT_SateiMeigihenkouInfo pSateiMeigihenkouInfo) {

        if (pUiBean == null) {
            return;
        }

        if (pUiBean instanceof ViewMeigihenkouSateiUiBeanParam) {

            ViewMeigihenkouSateiUiBeanParamImpl viewMeigihenkouSateiUiBeanParamImpl = SWAKInjector
                .getInstance(ViewMeigihenkouSateiUiBeanParamImpl.class);

            if (pSateiMeigihenkouInfo != null) {
                BeanUtil.copyProperties(viewMeigihenkouSateiUiBeanParamImpl, pSateiMeigihenkouInfo);
            }else{
                viewMeigihenkouSateiUiBeanParamImpl.setMeihenuktkbn(C_MeihenUktKbn.BLNK);
                viewMeigihenkouSateiUiBeanParamImpl.setMeihenuktnm("");
                viewMeigihenkouSateiUiBeanParamImpl.setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.BLNK);

            }

            BeanUtil.copyProperties(pUiBean, viewMeigihenkouSateiUiBeanParamImpl);
        }

    }

    public static void setTratkihuryouHusyoujiken(CommonViewUiBeanParam pUiBean,
        JT_Toriatukaifuryouinfo pToriatukaifuryouinfo) {

        if (pUiBean == null) {
            return;
        }

        if (pUiBean instanceof ViewTratkihuryouHusyoujikenUiBeanParam) {

            ViewTratkihuryouHusyoujikenUiBeanParamImpl viewTratkihuryouHusyoujikenUiBeanParamImpl = SWAKInjector
                .getInstance(ViewTratkihuryouHusyoujikenUiBeanParamImpl.class);
            if (pToriatukaifuryouinfo != null) {
                BeanUtil.copyProperties(viewTratkihuryouHusyoujikenUiBeanParamImpl, pToriatukaifuryouinfo);
            }
            BeanUtil.copyProperties(pUiBean, viewTratkihuryouHusyoujikenUiBeanParamImpl);
        }

    }

    public static void setSonotaCheckSibou(CommonViewUiBeanParam pUiBean, JT_SibouSateiChkInfo pSibouSateiChkInfo) {

        if (pUiBean == null) {
            return;
        }

        if (pUiBean instanceof ViewSonotaCheckSibouUiBeanParam) {

            ViewSonotaCheckSibouUiBeanParamImpl viewSonotaCheckSibouUiBeanParamImpl = SWAKInjector
                .getInstance(ViewSonotaCheckSibouUiBeanParamImpl.class);

            if (pSibouSateiChkInfo != null) {
                BeanUtil.copyProperties(viewSonotaCheckSibouUiBeanParamImpl, pSibouSateiChkInfo);
            }

            BeanUtil.copyProperties(pUiBean, viewSonotaCheckSibouUiBeanParamImpl);
        }

    }

    public static void setBetukutiCheck(CommonViewUiBeanParam pUiBean, JT_BetukutiSateiInfo pBetukutiSateiInfo) {

        if (pUiBean == null) {
            return;
        }

        if (pUiBean instanceof ViewBetukutiCheckSibouUiBeanParam) {

            ViewBetukutiCheckSibouUiBeanParamImpl viewBetukutiCheckSibouUiBeanParamImpl = SWAKInjector
                .getInstance(ViewBetukutiCheckSibouUiBeanParamImpl.class);

            if (pBetukutiSateiInfo != null) {
                BeanUtil.copyProperties(viewBetukutiCheckSibouUiBeanParamImpl, pBetukutiSateiInfo);

            }

            BeanUtil.copyProperties(pUiBean, viewBetukutiCheckSibouUiBeanParamImpl);
        }

    }

    public static void setTtdkRireki(CommonViewUiBeanParam pUiBean, JT_TtdkRireki pTtdkRireki) {

        if (pUiBean == null) {
            return;
        }

        if (pTtdkRireki == null) {
            return;
        }

        if (pUiBean instanceof ViewTetudukiInputUiBeanParam) {

            ViewTetudukiInputUiBeanParamImpl viewTetudukiInputUiBeanParamImpl = SWAKInjector
                .getInstance(ViewTetudukiInputUiBeanParamImpl.class);

            BeanUtil.copyProperties(viewTetudukiInputUiBeanParamImpl, pTtdkRireki);

            BeanUtil.copyProperties(pUiBean, viewTetudukiInputUiBeanParamImpl);

        }

    }

    public static void setSateiSyouninRireki(CommonViewUiBeanParam pUiBean, JT_SateiSyouninRireki pSateiSyouninRireki,
        JT_TtdkRireki pTtdkRireki) {

        if (pUiBean == null) {
            return;
        }

        if (pTtdkRireki == null) {
            return;
        }
        if (pUiBean instanceof ViewKekkaInputUiBeanParam) {

            ViewKekkaInputUiBeanParamImpl viewKekkaInputUiBeanParamImpl = SWAKInjector
                .getInstance(ViewKekkaInputUiBeanParamImpl.class);

            if (pSateiSyouninRireki != null) {
                BeanUtil.copyProperties(viewKekkaInputUiBeanParamImpl, pSateiSyouninRireki);
            }

            BeanUtil.copyProperties(viewKekkaInputUiBeanParamImpl, pTtdkRireki);

            BeanUtil.copyProperties(pUiBean, viewKekkaInputUiBeanParamImpl);

        }

        if (pUiBean instanceof ViewSateiKekkaUiBeanParam && pSateiSyouninRireki != null) {

            ViewSateiKekkaUiBeanParam viewSateiKekkaUiBeanParam = (ViewSateiKekkaUiBeanParam) pUiBean;
            viewSateiKekkaUiBeanParam.setSateisyorikekkakbn(pSateiSyouninRireki.getSyorikekkakbn());
            viewSateiKekkaUiBeanParam.setSateitennousakisousasyacd(pSateiSyouninRireki.getTennousakisousasyacd());
            viewSateiKekkaUiBeanParam.setKaiketuymd(pSateiSyouninRireki.getKaiketuymd());
            viewSateiKekkaUiBeanParam.setSateisyanaicomment(pTtdkRireki.getSyanaicomment());
        }

    }

    public void setSateiSiharaiSatei(CommonViewUiBeanParam pUiBean, JT_SateiSyouninRireki pSateiSyouninRireki,
        JT_TtdkRireki pTtdkRireki, JT_Sk pSk) {

        if (pUiBean == null) {
            return;
        }

        if (pUiBean instanceof ViewSiharaiSateiUiBeanParam) {

            ViewSiharaiSateiUiBeanParamImpl viewSiharaiSateiUiBeanParamImpl = SWAKInjector
                .getInstance(ViewSiharaiSateiUiBeanParamImpl.class);

            ViewSiharaiSateiUiBeanParam viewSiharaiSateiUiBeanParam = (ViewSiharaiSateiUiBeanParam) pUiBean;

            if (pSateiSyouninRireki != null) {
                BeanUtil.copyProperties(viewSiharaiSateiUiBeanParamImpl, pSateiSyouninRireki);
            }

            if (pTtdkRireki != null) {
                BeanUtil.copyProperties(viewSiharaiSateiUiBeanParamImpl, pTtdkRireki);
            }

            if (pSk != null) {
                BeanUtil.copyProperties(viewSiharaiSateiUiBeanParamImpl, pSk);
            }

            C_SyorikekkaKbn satei1syorikekkakbn;

            satei1syorikekkakbn = viewSiharaiSateiUiBeanParam.getSatei1Syorikekkakbn();

            BeanUtil.copyProperties(viewSiharaiSateiUiBeanParam, viewSiharaiSateiUiBeanParamImpl);

            viewSiharaiSateiUiBeanParam.setSatei1Syorikekkakbn(satei1syorikekkakbn);

            viewSiharaiSateiUiBeanParam.setSisyanm("");

            if (!BizUtil.isBlank(viewSiharaiSateiUiBeanParam.getSessyousisyacd())) {
                BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
                BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(
                    viewSiharaiSateiUiBeanParam.getSessyousisyacd() + "0000", null);
                if (bzGetSosikiDataBean != null) {
                    viewSiharaiSateiUiBeanParam.setSisyanm(bzGetSosikiDataBean.getKanjisosikinm20());
                }
            }
        }

    }

    public boolean setSkKihonKanri(SiSetUiBeanSetSkKihonKanriUiBeanParam pUiBean,
        List<DoujiSeikyuuInfosBySknoSyonoNeBean> pDoujiSeikyuuInfosBySknoSyonoNeBeanLst) {
        DoujiSeikyuuInfosBySknoSyonoNeBean skKykInfo = null;

        if (pUiBean == null) {
            return false;
        }
        if (pDoujiSeikyuuInfosBySknoSyonoNeBeanLst == null) {
            return false;
        }

        int dbCount = pDoujiSeikyuuInfosBySknoSyonoNeBeanLst.size();
        String[] syoNos = new String[dbCount];
        String[] skNos = new String[dbCount];
        BizDate[] syoriYmds = new BizDate[dbCount];
        C_HubiJyoukyouKbn[] hubijkKbns = new C_HubiJyoukyouKbn[dbCount];
        C_TyousaJyoukyouKbn[] tyousajkKbns = new C_TyousaJyoukyouKbn[dbCount];
        C_SyoriJyoutaiKbn[] syoriJyoutaiKbns = new C_SyoriJyoutaiKbn[dbCount];

        for (int count = 0; count < dbCount; count++) {
            skKykInfo = pDoujiSeikyuuInfosBySknoSyonoNeBeanLst.get(count);

            syoNos[count] = skKykInfo.getSyono();
            skNos[count] = skKykInfo.getSkno();
            syoriYmds[count] = skKykInfo.getSaisinSyoriYmd();
            hubijkKbns[count] = skKykInfo.getHubijyoukyoukbn();
            tyousajkKbns[count] = skKykInfo.getTyousajyoukyoukbn();
            syoriJyoutaiKbns[count] = skKykInfo.getSyorijyoutaikbn();
        }

        List<SkKihonKanriInfoDataSourceBeanCommonParam> beanLst = new ArrayList<>();

        for (int index = 0; index < syoriYmds.length; index++) {

            SkKihonKanriInfoDataSourceBeanCommonParam skKihonKanriInfoDataSourceBeanCommonParam =
                pUiBean.createSkKihonKanriInfoDataSourceBean();

            skKihonKanriInfoDataSourceBeanCommonParam.setDispsyono(syoNos[index]);
            skKihonKanriInfoDataSourceBeanCommonParam.setDispskno(skNos[index]);
            skKihonKanriInfoDataSourceBeanCommonParam.setDispsyoriymd(syoriYmds[index]);
            skKihonKanriInfoDataSourceBeanCommonParam.setDisphubikbn(hubijkKbns[index]);
            skKihonKanriInfoDataSourceBeanCommonParam.setDisptyousajkkbn(tyousajkKbns[index]);

            if (C_SyoriJyoutaiKbn.KANRYOU.eq(syoriJyoutaiKbns[index])) {
                skKihonKanriInfoDataSourceBeanCommonParam.setDispnextsyorinm(C_SyoriJyoutaiKbn.KANRYOU.getContent());
            }
            else {
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setSyoNo(syoNos[index]);
                bzGetProcessSummaryInBean.setSkNos(new String[] { skNos[index] });
                bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.ARI);

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
                    .exec(bzGetProcessSummaryInBean);

                if (bzGetProcessSummaryOutBeanLst.size() == 0) {
                    skKihonKanriInfoDataSourceBeanCommonParam.setDispnextsyorinm("");
                }
                else {
                    skKihonKanriInfoDataSourceBeanCommonParam.setDispnextsyorinm(bzGetProcessSummaryOutBeanLst.get(0)
                        .getNowNodoNm());
                }
            }

            beanLst.add(skKihonKanriInfoDataSourceBeanCommonParam);
        }

        pUiBean.convertSkKihonKanriInfoForCommonParam(beanLst);

        return true;
    }

    public static void setHihokensya(CommonViewUiBeanParam pUiBean, JT_SiKykKihon pSiKykKihon) {

        if (pUiBean == null) {
            return;
        }
        if (pSiKykKihon == null) {
            return;
        }

        if (pUiBean instanceof ViewHihokensyaUiBeanParam) {

            ViewHihokensyaUiBeanParamImpl viewHihokensyaUiBeanParamImpl = SWAKInjector
                .getInstance(ViewHihokensyaUiBeanParamImpl.class);

            BeanUtil.copyProperties(viewHihokensyaUiBeanParamImpl, pSiKykKihon);

            BeanUtil.copyProperties(pUiBean, viewHihokensyaUiBeanParamImpl);
        }

        if (pUiBean instanceof ViewHihokensyaSyouninTorikesiUiBeanParam) {

            ViewHihokensyaSyouninTorikesiUiBeanParamImpl viewHihokensyaSyouninTorikesiUiBeanParamImpl = SWAKInjector
                .getInstance(ViewHihokensyaSyouninTorikesiUiBeanParamImpl.class);

            BeanUtil.copyProperties(viewHihokensyaSyouninTorikesiUiBeanParamImpl, pSiKykKihon);

            BeanUtil.copyProperties(pUiBean, viewHihokensyaSyouninTorikesiUiBeanParamImpl);
        }

    }

    public static boolean setUketorinin(ViewUketorininSBUiBeanParam pUiBean, JT_SiKykKihon pSiKykKihon,
        List<JT_SiUkt> pSiUktLst) {

        if (pUiBean == null) {
            return false;
        }
        if (pSiKykKihon == null) {
            return false;
        }
        if (pSiUktLst == null) {
            return false;
        }

        pUiBean.setSbuktnin(pSiKykKihon.getSbuktnin());

        List<C_UktKbn> uktKbns = new ArrayList<>();
        List<String> uktNmkns = new ArrayList<>();
        List<String> uktNmkjs = new ArrayList<>();
        List<BizDate> uktseiYmds = new ArrayList<>();
        List<BizNumber> ukTbnWaris = new ArrayList<>();

        for (int count = 0; count < pSiUktLst.size(); count++) {
            if (C_Hkuktsyu.SBHKKUKT.eq(pSiUktLst.get(count).getHkuktsyu())) {
                uktKbns.add(pSiUktLst.get(count).getUktkbn());
                uktNmkns.add(pSiUktLst.get(count).getUktnmkn());
                uktNmkjs.add(pSiUktLst.get(count).getUktnmkj());
                uktseiYmds.add(pSiUktLst.get(count).getUktseiymd());
                ukTbnWaris.add(pSiUktLst.get(count).getUktbnwari());
            }
        }

        for (int index = 0; index < uktNmkns.size(); index++) {

            if (index == 0) {
                pUiBean.setDispsbuktkbn1(uktKbns.get(index));
                pUiBean.setDispsbuktnmkn1(uktNmkns.get(index));
                pUiBean.setDispsbuktnmkj1(uktNmkjs.get(index));
                pUiBean.setDispsbuktseiymd1(uktseiYmds.get(index));
                pUiBean.setDispmskmjskjuktnen1("");
                pUiBean.setDispsbuktbnwari1(ukTbnWaris.get(index));

            }

            else if (index == 1) {
                pUiBean.setDispsbuktkbn2(uktKbns.get(index));
                pUiBean.setDispsbuktnmkn2(uktNmkns.get(index));
                pUiBean.setDispsbuktnmkj2(uktNmkjs.get(index));
                pUiBean.setDispsbuktseiymd2(uktseiYmds.get(index));
                pUiBean.setDispmskmjskjuktnen2("");
                pUiBean.setDispsbuktbnwari2(ukTbnWaris.get(index));
            }

            else if (index == 2) {
                pUiBean.setDispsbuktkbn3(uktKbns.get(index));
                pUiBean.setDispsbuktnmkn3(uktNmkns.get(index));
                pUiBean.setDispsbuktnmkj3(uktNmkjs.get(index));
                pUiBean.setDispsbuktseiymd3(uktseiYmds.get(index));
                pUiBean.setDispmskmjskjuktnen3("");
                pUiBean.setDispsbuktbnwari3(ukTbnWaris.get(index));
            }

            else if (index == 3) {
                pUiBean.setDispsbuktkbn4(uktKbns.get(index));
                pUiBean.setDispsbuktnmkn4(uktNmkns.get(index));
                pUiBean.setDispsbuktnmkj4(uktNmkjs.get(index));
                pUiBean.setDispsbuktseiymd4(uktseiYmds.get(index));
                pUiBean.setDispmskmjskjuktnen4("");
                pUiBean.setDispsbuktbnwari4(ukTbnWaris.get(index));
            }

        }
        return true;
    }

    public static void setSiteidairinin(CommonViewUiBeanParam pUiBean, JT_SiKykKihon pSiKykKihon) {

        if (pUiBean == null) {
            return;
        }
        if (pSiKykKihon == null) {
            return;
        }

        if (pUiBean instanceof ViewSiteidrUiBeanParam) {

            ViewSiteidrUiBeanParamImpl viewSiteidrUiBeanParamImpl = SWAKInjector
                .getInstance(ViewSiteidrUiBeanParamImpl.class);

            BeanUtil.copyProperties(viewSiteidrUiBeanParamImpl, pSiKykKihon);

            BeanUtil.copyProperties(pUiBean, viewSiteidrUiBeanParamImpl);
        }

    }

    public static void setSouhusaki(CommonViewUiBeanParam pUiBean, JT_SiKykKihon pSiKykKihon) {

        if (pUiBean == null) {
            return;
        }
        if (pSiKykKihon == null) {
            return;
        }

        if (pUiBean instanceof ViewKeiyakusyaSouhusakiUiBeanParam) {

            ViewKeiyakusyaSouhusakiUiBeanParam viewKeiyakusyaSouhusakiUiBeanParam = (ViewKeiyakusyaSouhusakiUiBeanParam) pUiBean;

            viewKeiyakusyaSouhusakiUiBeanParam.setTdkdtsinyno(pSiKykKihon.getTsinyno());
            viewKeiyakusyaSouhusakiUiBeanParam.setTdkdtsinadr1kj(pSiKykKihon.getTsinadr1kj());
            viewKeiyakusyaSouhusakiUiBeanParam.setTdkdtsinadr2kj(pSiKykKihon.getTsinadr2kj());
            viewKeiyakusyaSouhusakiUiBeanParam.setTdkdtsinadr3kj(pSiKykKihon.getTsinadr3kj());
            viewKeiyakusyaSouhusakiUiBeanParam.setTdkdtsintelno1(pSiKykKihon.getTsintelno());

        }

    }

    public static void setSouhusakiKykAdr(CommonViewUiBeanParam pUiBean, JT_SiKykKihon pSiKykKihon) {

        if (pUiBean == null) {
            return;
        }
        if (pSiKykKihon == null) {
            return;
        }

        if (pUiBean instanceof ViewSouhusakiSindansyoUiBeanParam) {
            ViewSouhusakiSindansyoUiBeanParam ViewSouhusakiSindansyoUiBeanParam = (ViewSouhusakiSindansyoUiBeanParam) pUiBean;
            ViewSouhusakiSindansyoUiBeanParam.setTsinyno(pSiKykKihon.getTsinyno());
            ViewSouhusakiSindansyoUiBeanParam.setTsinadr1kj(pSiKykKihon.getTsinadr1kj());
            ViewSouhusakiSindansyoUiBeanParam.setTsinadr2kj(pSiKykKihon.getTsinadr2kj());
            ViewSouhusakiSindansyoUiBeanParam.setTsinadr3kj(pSiKykKihon.getTsinadr3kj());
        }

        if (pUiBean instanceof ViewSouhusakiUiBeanParam) {

            ViewSouhusakiUiBeanParam viewSouhusakiUiBeanParam = (ViewSouhusakiUiBeanParam) pUiBean;

            viewSouhusakiUiBeanParam.setTsinyno(pSiKykKihon.getTsinyno());
            viewSouhusakiUiBeanParam.setTsinadr1kj(pSiKykKihon.getTsinadr1kj());
            viewSouhusakiUiBeanParam.setTsinadr2kj(pSiKykKihon.getTsinadr2kj());
            viewSouhusakiUiBeanParam.setTsinadr3kj(pSiKykKihon.getTsinadr3kj());
            viewSouhusakiUiBeanParam.setTsintelno(pSiKykKihon.getTsintelno());

        }
    }

    public boolean setHKTShrMeisai(SiSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParam pUiBean, List<JT_SiDetail> pSiDetailLst) {

        JT_SiDetail siDetail = null;

        if (pUiBean == null) {
            return false;
        }

        List<HktshrMeisaisInfoDataSourceBeanCommonParam> beanLst = new ArrayList<>();
        if(pSiDetailLst != null){
            int dbCount = pSiDetailLst.size();
            String kyhNm = "";
            for (int count = 0; count < dbCount; count++) {
                HktshrMeisaisInfoDataSourceBeanCommonParam hktshrMeisaisInfoDataSourceBeanCommonParam =
                    pUiBean.createHktshrMeisaisInfoDataSourceBean();

                siDetail = pSiDetailLst.get(count);

                hktshrMeisaisInfoDataSourceBeanCommonParam.setKyhkg(siDetail.getKyhkg());
                hktshrMeisaisInfoDataSourceBeanCommonParam.setBikoumsg1(siDetail.getBikoumsg1());
                hktshrMeisaisInfoDataSourceBeanCommonParam.setBikoumsg2(siDetail.getBikoumsg2());
                hktshrMeisaisInfoDataSourceBeanCommonParam.setBikoumsg3(siDetail.getBikoumsg3());
                hktshrMeisaisInfoDataSourceBeanCommonParam.setBikoumsg4(siDetail.getBikoumsg4());

                kyhNm = siharaiDomManager.getKyuuhu(siDetail.getKyuuhucd()).getKyuuhunamegamen();

                hktshrMeisaisInfoDataSourceBeanCommonParam.setSyouhnnmgm(kyhNm);

                beanLst.add(hktshrMeisaisInfoDataSourceBeanCommonParam);
            }
        }

        pUiBean.convertHktshrMeisaisInfoForCommonParam(beanLst);

        return true;
    }

    public void addListWarningMessage(String pMsgid, String pMsg) {
        addListMessage(
            SiMessageGroupConstants.GROUP_HUBIMESSAGE,
            pMsgid,
            pMsg);
    }

    public void addListMessage(int pGroup, String pMsgid, String pMsg) {

        if (BizUtil.isBlank(pMsgid)) {
            return;
        }
        if (BizUtil.isBlank(pMsg)) {
            return;
        }

        messageManager.addConversationMessageId(pGroup, BizUtil.getGeneralMessageId(pMsgid), pMsg);
    }

    public void setSateiSiharaiSateiShrRireki(CommonViewUiBeanParam pUiBean,
        JT_SateiSyouninRireki pSateiSyouninRireki, JT_Sk pSk) {

        if (pUiBean == null) {
            return;
        }

        if (pUiBean instanceof ViewSiharaiSateiShrRirekiUiBeanParam) {

            ViewSiharaiSateiShrRirekiUiBeanParamImpl viewSiharaiSateiShrRirekiUiBeanParamImpl = SWAKInjector
                .getInstance(ViewSiharaiSateiShrRirekiUiBeanParamImpl.class);

            ViewSiharaiSateiShrRirekiUiBeanParam viewSiharaiSateiShrRirekiUiBeanParam = (ViewSiharaiSateiShrRirekiUiBeanParam) pUiBean;

            if (pSateiSyouninRireki != null) {
                BeanUtil.copyProperties(viewSiharaiSateiShrRirekiUiBeanParamImpl, pSateiSyouninRireki);
            }

            if (pSk != null) {
                BeanUtil.copyProperties(viewSiharaiSateiShrRirekiUiBeanParamImpl, pSk);
            }

            BeanUtil.copyProperties(viewSiharaiSateiShrRirekiUiBeanParam, viewSiharaiSateiShrRirekiUiBeanParamImpl);

            viewSiharaiSateiShrRirekiUiBeanParam.setSisyanm("");

            if (!BizUtil.isBlank(viewSiharaiSateiShrRirekiUiBeanParam.getSessyousisyacd())) {
                BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
                BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(
                    viewSiharaiSateiShrRirekiUiBeanParam.getSessyousisyacd() + "0000", null);
                if (bzGetSosikiDataBean != null) {
                    viewSiharaiSateiShrRirekiUiBeanParam.setSisyanm(bzGetSosikiDataBean.getKanjisosikinm20());
                }
            }
        }

    }

    public static void setZeimu(CommonViewUiBeanParam pUiBean, JT_SiRireki pSiRireki, JT_Sk pSk) {

        if (pUiBean == null) {
            return;
        }

        if (pUiBean instanceof ViewZeimuInfoUiBeanParam) {

            ViewZeimuInfoUiBeanParamImpl viewZeimuInfoUiBeanParamImpl = SWAKInjector
                .getInstance(ViewZeimuInfoUiBeanParamImpl.class);

            if (pSiRireki != null) {
                BeanUtil.copyProperties(viewZeimuInfoUiBeanParamImpl, pSiRireki);
            }

            if (pSk != null) {
                BeanUtil.copyProperties(viewZeimuInfoUiBeanParamImpl, pSk);
            }
            BeanUtil.copyProperties(pUiBean, viewZeimuInfoUiBeanParamImpl);
        }

    }

    public static void setSiharai(CommonViewUiBeanParam pUiBean, JT_SiRireki pSiRireki, JT_Sk pSk) {

        if (pUiBean == null) {
            return;
        }

        if (pUiBean instanceof ViewSiharaiInfoUiBeanParam) {

            ViewSiharaiInfoUiBeanParam viewSiharaiInfoUiBeanParam = (ViewSiharaiInfoUiBeanParam) pUiBean;

            setSiharaiInfo(viewSiharaiInfoUiBeanParam, pSk);

            viewSiharaiInfoUiBeanParam.setShrymd(pSiRireki.getTyakkinymd());
        }

    }

    public static void setJyuukasituInfo(CommonViewUiBeanParam pUiBean,
        JT_SateiJyuukasituChkInfo pSateiJyuukasituChkInfo) {

        if (pUiBean == null) {
            return;
        }

        if (pUiBean instanceof ViewJyuukasituInfoUiBeanParam) {
            ViewJyuukasituInfoUiBeanParamImpl viewJyuukasituInfoUiBeanParamImpl = SWAKInjector
                .getInstance(ViewJyuukasituInfoUiBeanParamImpl.class);

            if (pSateiJyuukasituChkInfo != null) {
                BeanUtil.copyProperties(viewJyuukasituInfoUiBeanParamImpl, pSateiJyuukasituChkInfo);
            }

            BeanUtil.copyProperties(pUiBean, viewJyuukasituInfoUiBeanParamImpl);
        }
    }

    private static void setSyoruiUketukeYmdSkuke(ViewSiharaiInfoSkukeUiBeanParam pUiBean, JT_Sk pSk) {

        ViewSiharaiInfoSkukeUiBeanParamImpl viewSiharaiInfoSkukeUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiharaiInfoSkukeUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSiharaiInfoSkukeUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSiharaiInfoSkukeUiBeanParamImpl);
    }

    private static void setSyoruiUketukeYmdSkuke(ViewSiharaiInfoSateiUiBeanParam pUiBean, JT_Sk pSk) {

        ViewSiharaiInfoSateiUiBeanParamImpl viewSiharaiInfoSateiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiharaiInfoSateiUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSiharaiInfoSateiUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSiharaiInfoSateiUiBeanParamImpl);
    }

    private static void setSeikyuusya(ViewSkjyouhouUiBeanParam pUiBean, JT_Sk pSk) {

        ViewSkjyouhouUiBeanParamImpl viewSkjyouhouUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkjyouhouUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSkjyouhouUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSkjyouhouUiBeanParamImpl);
    }

    private static void setSeikyuusyaSindansyo(ViewSkjyouhouSindansyoUiBeanParam pUiBean, JT_Sk pSk) {

        ViewSkjyouhouSindansyoUiBeanParamImpl viewSkjyouhouSindansyoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkjyouhouSindansyoUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSkjyouhouSindansyoUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSkjyouhouSindansyoUiBeanParamImpl);
    }

    private static void setSeikyuusyaSateiSougouSyoukai(ViewSkjyouhouSateiSougouSyoukaiUiBeanParam pUiBean, JT_Sk pSk) {

        ViewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl viewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl);
    }

    private void setSoukinsaki(ViewSoukinsakiUiBeanParam pUiBean, JT_Sk pSk) {

        ViewSoukinsakiUiBeanParamImpl viewSoukinsakiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSoukinsakiUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSoukinsakiUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSoukinsakiUiBeanParamImpl);

        if (C_Kzdou.DOUITU.eq(pUiBean.getKzdoukbn())) {
            pUiBean.setKzmeiginmkn("");
        }

        pUiBean.setBanknmkj("");
        pUiBean.setSitennmkj("");

        if (pUiBean.getBankcd() != null && pUiBean.getSitencd() != null) {
            BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
            BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(pUiBean.getBankcd(), pUiBean.getSitencd(), null);
            if (C_BankmasterUmuKbn.ARI.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {
                pUiBean.setBanknmkj(bzGetBankDataBean.getBankNmKj());
                pUiBean.setSitennmkj(bzGetBankDataBean.getSitenNmKj());
            }

        }

    }

    private static void setSoukinsakiSateiSougouSyoukai(ViewSoukinsakiSateiSougouSyoukaiUiBeanParam pUiBean, JT_Sk pSk) {

        ViewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl);

        pUiBean.setBanknmkj("");
        pUiBean.setSitennmkj("");

        if (pUiBean.getBankcd() != null && pUiBean.getSitencd() != null) {
            BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
            BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(pUiBean.getBankcd(), pUiBean.getSitencd(), null);
            if (C_BankmasterUmuKbn.ARI.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {
                pUiBean.setBanknmkj(bzGetBankDataBean.getBankNmKj());
                pUiBean.setSitennmkj(bzGetBankDataBean.getSitenNmKj());
            }

        }
    }

    private static void setSeikyuuNaiyou(ViewSknaiyouUiBeanParam pUiBean, JT_Sk pSk) {

        ViewSknaiyouUiBeanParamImpl viewSknaiyouUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSknaiyouUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSknaiyouUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSknaiyouUiBeanParamImpl);
    }

    private static void setSindansyoryouShr(ViewSindansyoryouShrUiBeanParam pUiBean, JT_Sk pSk) {

        ViewSindansyoryouShrUiBeanParamImpl viewSindansyoryouShrUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSindansyoryouShrUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSindansyoryouShrUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSindansyoryouShrUiBeanParamImpl);

    }

    private static void setShrdtlsyoHassou(ViewShrdtlSakuseiKbnUiBeanParam pUiBean, JT_Sk pSk) {

        ViewShrdtlSakuseiKbnUiBeanParamImpl viewShrdtlSakuseiKbnUiBeanParamImpl = SWAKInjector
            .getInstance(ViewShrdtlSakuseiKbnUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewShrdtlSakuseiKbnUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewShrdtlSakuseiKbnUiBeanParamImpl);

    }

    private static void setSouhusakiInfo(ViewSouhusakiUiBeanParam pUiBean, JT_Sk pSk) {

        ViewSouhusakiUiBeanParamImpl viewSouhusakiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSouhusakiUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSouhusakiUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSouhusakiUiBeanParamImpl);

    }

    private static void setSouhusakiSindansyo(ViewSouhusakiSindansyoUiBeanParam pUiBean, JT_Sk pSk) {

        ViewSouhusakiSindansyoUiBeanParamImpl viewSouhusakiSindansyoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSouhusakiSindansyoUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSouhusakiSindansyoUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSouhusakiSindansyoUiBeanParamImpl);

    }

    private static void setSouhusakiSateiSougouSyoukai(ViewSouhusakiSateiSougouSyoukaiUiBeanParam pUiBean, JT_Sk pSk) {

        ViewSouhusakiSateiSougouSyoukaiUiBeanParamImpl viewSouhusakiSateiSougouSyoukaiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSouhusakiSateiSougouSyoukaiUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSouhusakiSateiSougouSyoukaiUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSouhusakiSateiSougouSyoukaiUiBeanParamImpl);

    }

    private static void setSinkensya(ViewSinkensyaUiBeanParam pUiBean, JT_Sk pSk) {

        ViewSinkensyaUiBeanParamImpl viewSinkensyaUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSinkensyaUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSinkensyaUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSinkensyaUiBeanParamImpl);

    }

    private static void setSateiKakSb(ViewSateikaisouyouhiSibouUiBeanParam pUiBean, JT_Sk pSk) {

        ViewSateikaisouyouhiSibouUiBeanParamImpl viewSateikaisouyouhiSibouUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSateikaisouyouhiSibouUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSateikaisouyouhiSibouUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSateikaisouyouhiSibouUiBeanParamImpl);

    }

    private static void setSiharaiInfo(ViewSiharaiInfoUiBeanParam pUiBean, JT_Sk pSk) {

        ViewSiharaiInfoUiBeanParamImpl viewSiharaiInfoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiharaiInfoUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSiharaiInfoUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSiharaiInfoUiBeanParamImpl);

        pUiBean.setDispsyoruiukeymd(pSk.getSyoruiukeymd());
        pUiBean.setDisphubikanryouymd(pSk.getHubikanryouymd());
        pUiBean.setDispsinsagendokknkbn(pSk.getSinsagendokknkbn());
        pUiBean.setDisprkktydnnissuu(pSk.getRikoukityuutuudannissuu());

    }

    public static void setShrGoukei(ViewShrGoukeiUiBeanParam pUiBean, JT_Sk pSk) {

        ViewShrGoukeiUiBeanParamImpl viewShrGoukeiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewShrGoukeiUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewShrGoukeiUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewShrGoukeiUiBeanParamImpl);

        if (pSk.getShrtienrsk().compareTo(BizCurrency.valueOf(0, pSk.getShrtienrsk().getType())) == 0 &&
            pSk.getYenshrtienrsk().compareTo(BizCurrency.valueOf(0, pSk.getYenshrtienrsk().getType())) == 0) {
            pUiBean.setTienrisokukisanymd(null);
            pUiBean.setTienrsknissuu(null);
            pUiBean.setYentienrisokukisanymd(null);
            pUiBean.setYentienrsknissuu(null);
        }
        else {
            if (C_Tuukasyu.JPY.eq(pSk.getKyktuukasyu())) {
                pUiBean.setYentienrisokukisanymd(null);
                pUiBean.setYentienrsknissuu(null);
            } else {
                if (C_Tuukasyu.JPY.eq(pSk.getShrtuukasyu())) {
                    pUiBean.setTienrisokukisanymd(null);
                    pUiBean.setTienrsknissuu(null);
                    pUiBean.setYentienrisokukisanymd(pSk.getTienrisokukisanymd());
                    pUiBean.setYentienrsknissuu(pSk.getTienrsknissuu());
                } else {
                    pUiBean.setYentienrisokukisanymd(null);
                    pUiBean.setYentienrsknissuu(null);
                }
            }
        }

        if (pSk.getMikeikap().compareTo(BizCurrency.valueOf(0, pSk.getMikeikap().getType())) == 0) {
            pUiBean.setMikeikapgaitoukkn("");
            pUiBean.setYenkamikeikapgaitoukkn("");
        } else {
            SiCommonMojiretuHensyu siCommonMojiretuHensyu = SWAKInjector.getInstance(SiCommonMojiretuHensyu.class);

            String pGaitoukknHensyu = siCommonMojiretuHensyu.editPGaitoukkn(pSk.getMikeikapjyuutouym(),
                pSk.getMikeikapjyuutoukaisuuy(), pSk.getMikeikapjyuutoukaisuum());

            pUiBean.setMikeikapgaitoukkn(pGaitoukknHensyu);
            pUiBean.setYenkamikeikapgaitoukkn(pGaitoukknHensyu);
        }

        if (pSk.getMisyuup().compareTo(BizCurrency.valueOf(0, pSk.getMisyuup().getType())) == 0) {
            pUiBean.setMisyuupgaitoukkn("");
            pUiBean.setYenkamisyuupgaitoukkn("");
        } else {
            SiCommonMojiretuHensyu siCommonMojiretuHensyu = SWAKInjector.getInstance(SiCommonMojiretuHensyu.class);

            String pGaitoukknHensyu = siCommonMojiretuHensyu.editPGaitoukkn(pSk.getMisyuupjyuutouym(),
                pSk.getMisyuupjyuutoukaisuuy(), pSk.getMisyuupjyuutoukaisuum());

            pUiBean.setMisyuupgaitoukkn(pGaitoukknHensyu);
            pUiBean.setYenkamisyuupgaitoukkn(pGaitoukknHensyu);
        }
    }

    private void setSindansyoJyouhouSb(ViewSindansyoInfo2DataSourceUiBeanParam pUiBean, List<JT_SkJiyuu> pSkJiyuuLst,
        List<JT_SkByoumei> pSkByoumeiLst) {

        ViewSindansyoinfoSibouUiBeanParamImpl viewSindansyoinfoSibouUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSindansyoinfoSibouUiBeanParamImpl.class);

        if (pSkJiyuuLst != null && pSkJiyuuLst.size() != 0) {
            BeanUtil.copyProperties(viewSindansyoinfoSibouUiBeanParamImpl, pSkJiyuuLst.get(0));

            BeanUtil.copyProperties(pUiBean, viewSindansyoinfoSibouUiBeanParamImpl);
        }

        List<ViewSindansyoInfo2DataSourceBeanCommonParam> sindansyoInfoLst = new ArrayList<>();

        if (pSkByoumeiLst != null && pSkByoumeiLst.size() != 0) {

            for (JT_SkByoumei skByoumeiTemp : pSkByoumeiLst) {

                ViewSindansyoInfo2DataSourceBeanCommonParam viewSindansyoInfo2DataSourceBeanCommonParam = pUiBean
                    .createSindansyoInfo2DataSourceBean();

                BeanUtil.copyProperties(viewSindansyoInfo2DataSourceBeanCommonParam, skByoumeiTemp);
                viewSindansyoInfo2DataSourceBeanCommonParam.setSakujyoflg(C_Delflag.BLNK);
                sindansyoInfoLst.add(viewSindansyoInfo2DataSourceBeanCommonParam);

            }
        }
        pUiBean.convertSindansyoInfo2ForCommonParam(sindansyoInfoLst);
    }

    private static void setSiharaiInfo(ViewSiharaiInfoUiBeanParam pUiBean,
        SiHkkingakuSisanParamBean pSiHkkingakuSisanParamBean) {
        pUiBean.setShrtuukasyu(pSiHkkingakuSisanParamBean.getShrTuukasyu());
        pUiBean.setShrkwsrate(pSiHkkingakuSisanParamBean.getKawaseRate());
        pUiBean.setShrkwsratekjnymd(pSiHkkingakuSisanParamBean.getKnsnKijyunYmd());
        pUiBean.setGaikaknsnkwsrate(pSiHkkingakuSisanParamBean.getGaikaknsnkwsrate());
        pUiBean.setGaikaknsnkwsratekjymd(pSiHkkingakuSisanParamBean.getKnsnKijyunYmd());
        pUiBean.setShrymd(pSiHkkingakuSisanParamBean.getShrYmd());
    }

    private static void setShrGoukei(ViewShrGoukeiUiBeanParam pUiBean,
        SiHkkingakuSisanParamBean pSiHkkingakuSisanParamBean) {
        pUiBean.setTienrisokukisanymd(pSiHkkingakuSisanParamBean.getTienRisokuKisanYmd());
        pUiBean.setTienrsknissuu(pSiHkkingakuSisanParamBean.getTienRskNissuu());
        pUiBean.setShrgk(pSiHkkingakuSisanParamBean.getShrgkkei());
        pUiBean.setHokenkngkgoukei(pSiHkkingakuSisanParamBean.getHokenknGk());
        pUiBean.setHaitoukin(pSiHkkingakuSisanParamBean.getHaitoukin());
        pUiBean.setSonotahaitoukin(pSiHkkingakuSisanParamBean.getSonotahaitoukin());
        pUiBean.setMikeikap(pSiHkkingakuSisanParamBean.getMikeikap());
        pUiBean.setMisyuup(pSiHkkingakuSisanParamBean.getMisyuup());
        pUiBean.setZennouseisankgk(pSiHkkingakuSisanParamBean.getZennouseisank());
        pUiBean.setAzukarikingk(pSiHkkingakuSisanParamBean.getAzukarikingk());
        pUiBean.setKrkgk(pSiHkkingakuSisanParamBean.getKrkgk());
        pUiBean.setShrtienrsk(pSiHkkingakuSisanParamBean.getTienRsk());
        pUiBean.setYenshrgk(pSiHkkingakuSisanParamBean.getYenkashrgkgoukei());
        pUiBean.setYenhkgkgoukei(pSiHkkingakuSisanParamBean.getYenHokenknGk());
        pUiBean.setYenkahaitoukin(pSiHkkingakuSisanParamBean.getYenkahaitoukin());
        pUiBean.setYenkasonotahaitoukin(pSiHkkingakuSisanParamBean.getYenkasonotahaitoukin());
        pUiBean.setYenkamikeikap(pSiHkkingakuSisanParamBean.getYenkamikeikap());
        pUiBean.setYenkamisyuup(pSiHkkingakuSisanParamBean.getYenkamisyuup());
        pUiBean.setYenkazennouseisankgk(pSiHkkingakuSisanParamBean.getYenkazennouseisank());
        pUiBean.setYenkaazukarikingk(pSiHkkingakuSisanParamBean.getYenkaazukarikingk());
        pUiBean.setYenkakrkgk(pSiHkkingakuSisanParamBean.getYenkakrkgk());
        pUiBean.setYenshrtienrsk(pSiHkkingakuSisanParamBean.getYenTienRsk());

        if (pSiHkkingakuSisanParamBean.getTienRsk().compareTo(BizCurrency.valueOf(0, pSiHkkingakuSisanParamBean.getTienRsk().getType())) == 0 &&
            pSiHkkingakuSisanParamBean.getYenTienRsk().compareTo(BizCurrency.valueOf(0, pSiHkkingakuSisanParamBean.getYenTienRsk().getType())) == 0) {
            pUiBean.setTienrisokukisanymd(null);
            pUiBean.setTienrsknissuu(null);
            pUiBean.setYentienrisokukisanymd(null);
            pUiBean.setYentienrsknissuu(null);
        }
        else {
            if (C_Tuukasyu.JPY.eq(pSiHkkingakuSisanParamBean.getKykTuukasyu())) {
                pUiBean.setYentienrisokukisanymd(null);
                pUiBean.setYentienrsknissuu(null);
            } else {
                if (C_Tuukasyu.JPY.eq(pSiHkkingakuSisanParamBean.getShrTuukasyu())) {
                    pUiBean.setTienrisokukisanymd(null);
                    pUiBean.setTienrsknissuu(null);
                    pUiBean.setYentienrisokukisanymd(pSiHkkingakuSisanParamBean.getTienRisokuKisanYmd());
                    pUiBean.setYentienrsknissuu(pSiHkkingakuSisanParamBean.getTienRskNissuu());
                } else {
                    pUiBean.setYentienrisokukisanymd(null);
                    pUiBean.setYentienrsknissuu(null);
                }
            }
        }

        if (pSiHkkingakuSisanParamBean.getMikeikap().compareTo(
            BizCurrency.valueOf(0, pSiHkkingakuSisanParamBean.getMikeikap().getType())) == 0) {
            pUiBean.setMikeikapgaitoukkn("");
            pUiBean.setYenkamikeikapgaitoukkn("");
        } else {
            SiCommonMojiretuHensyu siCommonMojiretuHensyu = SWAKInjector.getInstance(SiCommonMojiretuHensyu.class);

            String pGaitoukknHensyu = siCommonMojiretuHensyu.editPGaitoukkn(
                pSiHkkingakuSisanParamBean.getMikeikapjyuutouym(),
                pSiHkkingakuSisanParamBean.getMikeikapjyuutoukaisuuy(),
                pSiHkkingakuSisanParamBean.getMikeikapjyuutoukaisuum());

            pUiBean.setMikeikapgaitoukkn(pGaitoukknHensyu);
            pUiBean.setYenkamikeikapgaitoukkn(pGaitoukknHensyu);
        }

        if (pSiHkkingakuSisanParamBean.getMisyuup().compareTo(
            BizCurrency.valueOf(0, pSiHkkingakuSisanParamBean.getMisyuup().getType())) == 0) {
            pUiBean.setMisyuupgaitoukkn("");
            pUiBean.setYenkamisyuupgaitoukkn("");
        } else {
            SiCommonMojiretuHensyu siCommonMojiretuHensyu = SWAKInjector.getInstance(SiCommonMojiretuHensyu.class);

            String pGaitoukknHensyu = siCommonMojiretuHensyu.editPGaitoukkn(
                pSiHkkingakuSisanParamBean.getMisyuupjyuutouym(),
                pSiHkkingakuSisanParamBean.getMisyuupjyuutoukaisuuy(),
                pSiHkkingakuSisanParamBean.getMisyuupjyuutoukaisuum());

            pUiBean.setMisyuupgaitoukkn(pGaitoukknHensyu);
            pUiBean.setYenkamisyuupgaitoukkn(pGaitoukknHensyu);
        }
    }

    private static void setKingakuInfo(ViewKingakuInfoUiBeanParam pUiBean,
        SiHkkingakuSisanParamBean pSiHkkingakuSisanParamBean) {

        pUiBean.setHokenryoustgk(pSiHkkingakuSisanParamBean.getHokenryoustGk());
        pUiBean.setYenhokenryoustgk(pSiHkkingakuSisanParamBean.getYenHokenryoustGk());
        pUiBean.setTutakngk(pSiHkkingakuSisanParamBean.getTutaknGk());
        pUiBean.setYentutakngk(pSiHkkingakuSisanParamBean.getYenTutaknGk());
        pUiBean.setKaiyakuhr(pSiHkkingakuSisanParamBean.getKaiyakuHr());
        pUiBean.setYenkaiyakuhr(pSiHkkingakuSisanParamBean.getYenKaiyakuHr());
        pUiBean.setKihonhokenkngk(pSiHkkingakuSisanParamBean.getKihonHokenKngk());
        pUiBean.setYenkihonhokenkngk(pSiHkkingakuSisanParamBean.getYenKihonHokenKngk());
        if (C_HknKknKbn.DAI1HKNKKN.eq(pSiHkkingakuSisanParamBean.getHknKknKbn())) {
            pUiBean.setSaigais(pSiHkkingakuSisanParamBean.getSaigaiS());
            pUiBean.setYensaigais(pSiHkkingakuSisanParamBean.getYenSaigaiS());
        } else {
            pUiBean.setSaigais(BizCurrency.optional());
            pUiBean.setYensaigais(BizCurrency.optional());
        }
        if (C_Tuukasyu.JPY.eq(pSiHkkingakuSisanParamBean.getKykTuukasyu())) {

            pUiBean.setYenhokenryoustgk(BizCurrency.optional());
            pUiBean.setYentutakngk(BizCurrency.optional());
            pUiBean.setYenkaiyakuhr(BizCurrency.optional());
            pUiBean.setYenkihonhokenkngk(BizCurrency.optional());
            pUiBean.setYensaigais(BizCurrency.optional());
        }
    }

    private static void setZeimuInfo(ViewZeimuInfoUiBeanParam pUiBean,
        SiHkkingakuSisanParamBean pSiHkkingakuSisanParamBean) {

        pUiBean.setGoukeihituyoukeihi(pSiHkkingakuSisanParamBean.getYenHtyKeihi());
        pUiBean.setShrkykhtykeihi(pSiHkkingakuSisanParamBean.getShrkykhtykeihi());

    }

    public String setMskmjSkjNen(BizDate pMosymd, BizDate pSyoruiukeymd, BizDate pSeiymd) {

        String mskmjSkjNen = "";
        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
        int mskmjNen = setNenrei.exec(pMosymd, pSeiymd);

        if (pSyoruiukeymd != null) {
            int skjNen = setNenrei.exec(pSyoruiukeymd, pSeiymd);
            if (mskmjNen != 0 && skjNen != 0) {
                mskmjSkjNen = TeisuuSiharai.MSKMJSKJNENMONGONLIST[0] + mskmjNen
                    + TeisuuSiharai.MSKMJSKJNENMONGONLIST[1] + skjNen
                    + TeisuuSiharai.MSKMJSKJNENMONGONLIST[2];
            }
        } else {
            if (mskmjNen != 0) {
                mskmjSkjNen = TeisuuSiharai.MSKMJSKJNENMONGONLIST[0] + mskmjNen
                    + TeisuuSiharai.MSKMJSKJNENMONGONLIST[2];
            }
        }
        return mskmjSkjNen;
    }

    private static void setSiinInfo(ViewSiinInfoUiBeanParam pUiBean, JT_Sk pSk) {
        ViewSiinInfoUiBeanParamImpl viewSiinInfoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiinInfoUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSiinInfoUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSiinInfoUiBeanParamImpl);
    }

    private static void setSaikenInfo(ViewSaikenInfoUiBeanParam pUiBean, JT_Sk pSk) {
        ViewSaikenInfoUiBeanParamImpl viewSaikenInfoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSaikenInfoUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewSaikenInfoUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewSaikenInfoUiBeanParamImpl);
    }

    private static void setMnMeigiBangou(ViewMnMeigiBangouUiBeanParam pUiBean, JT_Sk pSk) {
        ViewMnMeigiBangouUiBeanParamImpl viewMnMeigiBangouUiBeanParamImpl = SWAKInjector
            .getInstance(ViewMnMeigiBangouUiBeanParamImpl.class);

        BeanUtil.copyProperties(viewMnMeigiBangouUiBeanParamImpl, pSk);

        BeanUtil.copyProperties(pUiBean, viewMnMeigiBangouUiBeanParamImpl);
    }
}

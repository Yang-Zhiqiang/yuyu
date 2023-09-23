package yuyu.common.siharai.siedittyouhyou;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UketorininSibouUmuKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.def.siharai.bean.report.SiEditTeisyutusyoruiBean;
import yuyu.def.siharai.bean.report.SiEditTeisyutusyoruiDataSourceBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 ご提出書類について編集
 */
public class EditTeisyutusyorui {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private static Logger logger;

    @Inject
    private CreateReport createReport;

    public EditTeisyutusyorui(){
        super();
    }

    public ReportServicesBean exec(EditTeisyutusyoruiBean pEditTeisyutusyoruiBean) {

        logger.debug("▽ ご提出書類について編集 開始");

        BizDate syoriYmd = pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd();
        if ( syoriYmd == null) {
            throw new BizAppException(MessageId.EJS1005,"syoriYmd");
        }

        C_SyoruiCdKbn syoruiCd = pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd();
        if ( syoruiCd == null || C_SyoruiCdKbn.BLNK.eq(syoruiCd)) {
            throw new BizAppException(MessageId.EJS1005,"syoruiCd");
        }

        C_SeikyuuSyubetu seikyuuSyubetu = pEditTeisyutusyoruiBean.getSeikyuuSyubetu();
        if ( seikyuuSyubetu == null || C_SeikyuuSyubetu.BLNK.eq(seikyuuSyubetu)) {
            throw new BizAppException(MessageId.EJS1005,"seikyuuSyubetu");
        }

        List<TeisyutusyoruiItiranBean> teisyutusyoruiItiranBeanLst = new ArrayList<>();
        TeisyutusyoruiItiranBean teisyutusyoruiItiranBean = null;

        teisyutusyoruiItiranBean = getSksInfo(pEditTeisyutusyoruiBean);
        if(teisyutusyoruiItiranBean != null){
            teisyutusyoruiItiranBeanLst.add(teisyutusyoruiItiranBean);
        }

        teisyutusyoruiItiranBean = getSskHrkmiraisyoInfo(pEditTeisyutusyoruiBean);
        if(teisyutusyoruiItiranBean != null){
            teisyutusyoruiItiranBeanLst.add(teisyutusyoruiItiranBean);
        }

        teisyutusyoruiItiranBean = getSindansyoInfo(pEditTeisyutusyoruiBean);
        teisyutusyoruiItiranBeanLst.add(teisyutusyoruiItiranBean);

        teisyutusyoruiItiranBean = getKykSindansyoInfo(pEditTeisyutusyoruiBean);
        if(teisyutusyoruiItiranBean != null){
            teisyutusyoruiItiranBeanLst.add(teisyutusyoruiItiranBean);
        }

        teisyutusyoruiItiranBean = getDaihyousennintodokeInfo(pEditTeisyutusyoruiBean);
        if(teisyutusyoruiItiranBean != null){
            teisyutusyoruiItiranBeanLst.add(teisyutusyoruiItiranBean);
        }

        teisyutusyoruiItiranBean = getJijouTodokekenSeiyakusyoInfo(pEditTeisyutusyoruiBean);
        if(teisyutusyoruiItiranBean != null){
            teisyutusyoruiItiranBeanLst.add(teisyutusyoruiItiranBean);
        }

        teisyutusyoruiItiranBean = getKosekitouhonInfo(pEditTeisyutusyoruiBean);
        if(teisyutusyoruiItiranBean != null){
            teisyutusyoruiItiranBeanLst.add(teisyutusyoruiItiranBean);
        }

        teisyutusyoruiItiranBean = getKykDrSkYoukenKakuninSyoruiInfo(pEditTeisyutusyoruiBean);
        if(teisyutusyoruiItiranBean != null){
            teisyutusyoruiItiranBeanLst.add(teisyutusyoruiItiranBean);
        }

        teisyutusyoruiItiranBean = getJikojyokyouhksInfo(pEditTeisyutusyoruiBean);
        if(teisyutusyoruiItiranBean != null){
            teisyutusyoruiItiranBeanLst.add(teisyutusyoruiItiranBean);
        }

        teisyutusyoruiItiranBean = getKtjksmsInfo(pEditTeisyutusyoruiBean);
        if(teisyutusyoruiItiranBean != null){
            teisyutusyoruiItiranBeanLst.add(teisyutusyoruiItiranBean);
        }
        teisyutusyoruiItiranBean = getHonninkakuninSyoruiInfo(pEditTeisyutusyoruiBean);
        if(teisyutusyoruiItiranBean != null){
            teisyutusyoruiItiranBeanLst.add(teisyutusyoruiItiranBean);
        }
        teisyutusyoruiItiranBean = getMynumbertkSyoruiInfo(pEditTeisyutusyoruiBean);
        if(teisyutusyoruiItiranBean != null){
            teisyutusyoruiItiranBeanLst.add(teisyutusyoruiItiranBean);
        }

        List<IReportDataSouceBean> ireportDataSouceBeanLst = new ArrayList<>();
        for(int i = 0; i < teisyutusyoruiItiranBeanLst.size(); i++){
            SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = SWAKInjector.getInstance(SiEditTeisyutusyoruiDataSourceBean.class);

            TeisyutusyoruiItiranBean itiranBean = teisyutusyoruiItiranBeanLst.get(i);
            for(int j = 0; j < itiranBean.getTeisyutuShorui().size(); j++){
                if(j == 0){
                    siEditTeisyutusyoruiDataSourceBean.setIrMsg1(itiranBean.getTeisyutuShorui().get(j).getTyouhyoumsg());

                } else if(j == 1){
                    siEditTeisyutusyoruiDataSourceBean.setIrMsg2(itiranBean.getTeisyutuShorui().get(j).getTyouhyoumsg());
                } else if(j == 2){
                    siEditTeisyutusyoruiDataSourceBean.setIrMsg9(itiranBean.getTeisyutuShorui().get(j).getTyouhyoumsg());
                }
            }

            for(int k = 0; k < itiranBean.getChuuiJiko().size(); k++){
                if(k == 0){
                    siEditTeisyutusyoruiDataSourceBean.setIrMsg3(itiranBean.getChuuiJiko().get(k).getTyouhyoumsg());
                } else if(k == 1){
                    siEditTeisyutusyoruiDataSourceBean.setIrMsg4(itiranBean.getChuuiJiko().get(k).getTyouhyoumsg());
                } else if(k == 2){
                    siEditTeisyutusyoruiDataSourceBean.setIrMsg5(itiranBean.getChuuiJiko().get(k).getTyouhyoumsg());
                } else if(k == 3){
                    siEditTeisyutusyoruiDataSourceBean.setIrMsg6(itiranBean.getChuuiJiko().get(k).getTyouhyoumsg());
                } else if(k == 4){
                    siEditTeisyutusyoruiDataSourceBean.setIrMsg7(itiranBean.getChuuiJiko().get(k).getTyouhyoumsg());
                } else if(k == 5){
                    siEditTeisyutusyoruiDataSourceBean.setIrMsg8(itiranBean.getChuuiJiko().get(k).getTyouhyoumsg());
                }
            }

            ireportDataSouceBeanLst.add(siEditTeisyutusyoruiDataSourceBean);
        }

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = SWAKInjector.getInstance(SiEditTeisyutusyoruiBean.class);

        siEditTeisyutusyoruiBean.setIrTyouhyousakuseiymd(ConvertUtil.toZenNumeric(DateFormatUtil.dateKANJINoEx(syoriYmd)));

        siEditTeisyutusyoruiBean.setIrSyono(pEditTeisyutusyoruiBean.getSyoNo());

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
            kinou.getCategoryId(), kinou.getKinouId(), syoruiCd);
        reportServicesBean.setKensakuKeys(pEditTeisyutusyoruiBean.getSyoNo());
        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(ireportDataSouceBeanLst, siEditTeisyutusyoruiBean);

        logger.debug("△ ご提出書類について編集 終了");
        return reportServicesBean;

    }

    private TeisyutusyoruiItiranBean getMeisaiSyuturyokuInfo(C_SyoruiCdKbn pSyoruiCdKbn, String pTeishutuShoruiKensakuKi,
        String pChuuiJikoukensakuKi) {
        TeisyutusyoruiItiranBean pTeisyutusyoruiItiranBean = SWAKInjector.getInstance(TeisyutusyoruiItiranBean.class);

        List<JM_SiTyouhyoumsg> teisyutuShorui =  siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            pSyoruiCdKbn.getValue(), pTeishutuShoruiKensakuKi);

        List<JM_SiTyouhyoumsg> tyuuiJiko = siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(
            pSyoruiCdKbn.getValue(), pChuuiJikoukensakuKi);

        pTeisyutusyoruiItiranBean.setTeisyutuShorui(teisyutuShorui);
        pTeisyutusyoruiItiranBean.setChuuiJiko(tyuuiJiko);
        return pTeisyutusyoruiItiranBean;

    }

    private TeisyutusyoruiItiranBean getSksInfo(EditTeisyutusyoruiBean pEditTeisyutusyoruiBean) {
        TeisyutusyoruiItiranBean teisyutusyoruiItiranBean = null;

        if (C_SeikyuuSyubetu.SB.eq(pEditTeisyutusyoruiBean.getSeikyuuSyubetu()) &&
            pEditTeisyutusyoruiBean.getJisatuMenseki() == false &&
            C_UmuKbn.NONE.eq(pEditTeisyutusyoruiBean.getNstkhkUmu()) &&
            !C_MousideninKbn.KYKDAIRININ.eq(pEditTeisyutusyoruiBean.getMousideninKbn())) {
            teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(), "SEIKYUUSYO",
                "SEIKYUUSYO_TYUUI");
        }
        else if (C_SeikyuuSyubetu.SB.eq(pEditTeisyutusyoruiBean.getSeikyuuSyubetu()) &&
            pEditTeisyutusyoruiBean.getJisatuMenseki() == false &&
            C_UmuKbn.NONE.eq(pEditTeisyutusyoruiBean.getNstkhkUmu()) &&
            C_MousideninKbn.KYKDAIRININ.eq(pEditTeisyutusyoruiBean.getMousideninKbn())) {
            teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(), "SEIKYUUSYO_KYKDR",
                "SEIKYUUSYO_KYKDR_TYUUI");
        }
        return teisyutusyoruiItiranBean;
    }

    private TeisyutusyoruiItiranBean getSskHrkmiraisyoInfo(EditTeisyutusyoruiBean pEditTeisyutusyoruiBean) {
        TeisyutusyoruiItiranBean teisyutusyoruiItiranBean = null;

        if (C_SeikyuuSyubetu.SB.eq(pEditTeisyutusyoruiBean.getSeikyuuSyubetu()) &&
            pEditTeisyutusyoruiBean.getJisatuMenseki() == true && (pEditTeisyutusyoruiBean.getKykHhknDou() == true ||
            C_KyksyaSibouUmuKbn.KYKSBARI.eq(pEditTeisyutusyoruiBean.getKyksyasibouUmukbn()))){
            teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(),
                "SEISANKINHURIKOMIIRAISYO_KYKSB", "SEISANKINHURIKOMIIRAISYO_KYKSB_TYUUI");
        }
        else if (C_SeikyuuSyubetu.SB.eq(pEditTeisyutusyoruiBean.getSeikyuuSyubetu()) &&
            pEditTeisyutusyoruiBean.getJisatuMenseki() == true && pEditTeisyutusyoruiBean.getKykHhknDou() == false
            && C_KyksyaSibouUmuKbn.BLNK.eq(pEditTeisyutusyoruiBean.getKyksyasibouUmukbn())
            && !C_MousideninKbn.KYKDAIRININ.eq(pEditTeisyutusyoruiBean.getMousideninKbn())) {
            teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(), "SEISANKINHURIKOMIIRAISYO",
                "SEISANKINHURIKOMIIRAISYO_TYUUI");
        }
        else if (C_SeikyuuSyubetu.SB.eq(pEditTeisyutusyoruiBean.getSeikyuuSyubetu()) &&
            pEditTeisyutusyoruiBean.getJisatuMenseki() == true &&
            C_MousideninKbn.KYKDAIRININ.eq(pEditTeisyutusyoruiBean.getMousideninKbn())) {
            teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(),
                "SEISANKINHURIKOMIIRAISYO_KYKDR",
                "SEISANKINHURIKOMIIRAISYO_KYKDR_TYUUI");
        }
        return teisyutusyoruiItiranBean;
    }

    private TeisyutusyoruiItiranBean getSindansyoInfo(EditTeisyutusyoruiBean pEditTeisyutusyoruiBean) {
        TeisyutusyoruiItiranBean teisyutusyoruiItiranBean = SWAKInjector.getInstance(TeisyutusyoruiItiranBean.class);

        if (C_SeikyuuSyubetu.SB.eq(pEditTeisyutusyoruiBean.getSeikyuuSyubetu())) {
            if (pEditTeisyutusyoruiBean.getJisatuMenseki() == true) {
                teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                    pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(), "SB_SINDANSYO_MENSEKI",
                    "SB_SINDANSYO_MENSEKI_TYUUI");
            } else {
                teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                    pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(), "SB_SINDANSYO",
                    "SB_SINDANSYO_TYUUI");
            }
        }
        return teisyutusyoruiItiranBean;
    }

    private TeisyutusyoruiItiranBean getKykSindansyoInfo(EditTeisyutusyoruiBean pEditTeisyutusyoruiBean ){
        TeisyutusyoruiItiranBean teisyutusyoruiItiranBean = null;

        if (C_SeikyuuSyubetu.SB.eq(pEditTeisyutusyoruiBean.getSeikyuuSyubetu()) &&
            C_MousideninKbn.KYKDAIRININ.eq(pEditTeisyutusyoruiBean.getMousideninKbn()) &&
            C_KykdrknHtdjytKbn.BLNK.eq(pEditTeisyutusyoruiBean.getKykdrknHtdjyt())) {
            teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(),
                "KYK_ISINOURYOKU_SINDANSYO",
                "KYK_ISINOURYOKU_SINDANSYO_TYUUI");
        }
        return teisyutusyoruiItiranBean;
    }

    private TeisyutusyoruiItiranBean getDaihyousennintodokeInfo(EditTeisyutusyoruiBean pEditTeisyutusyoruiBean) {
        TeisyutusyoruiItiranBean teisyutusyoruiItiranBean = null;

        if (C_SeikyuuSyubetu.SB.eq(pEditTeisyutusyoruiBean.getSeikyuuSyubetu())) {
            if (pEditTeisyutusyoruiBean.getJisatuMenseki() == true) {
                if (pEditTeisyutusyoruiBean.getKykHhknDou() == true
                    || C_KyksyaSibouUmuKbn.KYKSBARI.eq(pEditTeisyutusyoruiBean.getKyksyasibouUmukbn())) {
                    teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                        pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(),
                        "DAIHYOUSENNINTODOKE_SOUZOKU1MEI", "DAIHYOUSENNINTODOKE_SOUZOKU1MEI_TYUUI");
                }
            } else {
                if (C_MousideninKbn.SOUZOKUNIN.eq(pEditTeisyutusyoruiBean.getMousideninKbn()) ||
                    pEditTeisyutusyoruiBean.getSbuktNin() > 1 ||
                    C_UketorininSibouUmuKbn.UKTSBARI.eq(pEditTeisyutusyoruiBean.getUketorininsibouUmukbn())) {
                    teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                        pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(),
                        "DAIHYOUSENNINTODOKE", "DAIHYOUSENNINTODOKE_TYUUI");
                }
            }
        }
        return teisyutusyoruiItiranBean;
    }

    private TeisyutusyoruiItiranBean getJijouTodokekenSeiyakusyoInfo(EditTeisyutusyoruiBean pEditTeisyutusyoruiBean ){
        TeisyutusyoruiItiranBean teisyutusyoruiItiranBean = null;

        if (C_SeikyuuSyubetu.SB.eq(pEditTeisyutusyoruiBean.getSeikyuuSyubetu()) &&
            C_MousideninKbn.KYKDAIRININ.eq(pEditTeisyutusyoruiBean.getMousideninKbn())) {
            teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(),
                "JIJOTODOKE_SEIYAKUSYO",
                "JIJOTODOKE_SEIYAKUSYO_TYUUI");
        }
        return teisyutusyoruiItiranBean;
    }

    private TeisyutusyoruiItiranBean getKosekitouhonInfo(EditTeisyutusyoruiBean pEditTeisyutusyoruiBean) {
        TeisyutusyoruiItiranBean teisyutusyoruiItiranBean = null;
        String teishutuShoruiKensakuKi = "";
        String chuuiJikoukensakuKi = "";
        Boolean outputFlg = false;

        if (C_SeikyuuSyubetu.SB.eq(pEditTeisyutusyoruiBean.getSeikyuuSyubetu())) {
            if (C_MousideninKbn.KYKDAIRININ.eq(pEditTeisyutusyoruiBean.getMousideninKbn())) {
                teishutuShoruiKensakuKi = "SB_KOSEKITOUHON_KYKDR";
                chuuiJikoukensakuKi = "SB_KOSEKITOUHON_KYKDR_TYUUI";
                outputFlg = true;
            } else {
                if (pEditTeisyutusyoruiBean.getJisatuMenseki() == false) {
                    if (C_UketorininSibouUmuKbn.UKTSBARI.eq(pEditTeisyutusyoruiBean.getUketorininsibouUmukbn())) {
                        teishutuShoruiKensakuKi = "SB_KOSEKITOUHON_UKTSIBOU";
                        chuuiJikoukensakuKi = "SB_KOSEKITOUHON_UKTSIBOU_TYUUI";
                        outputFlg = true;
                    } else {
                        if (C_MousideninKbn.SOUZOKUNIN.eq(pEditTeisyutusyoruiBean.getMousideninKbn())) {
                            teishutuShoruiKensakuKi = "SB_KOSEKITOUHON";
                            chuuiJikoukensakuKi = "SB_KOSEKITOUHON_TYUUI";
                            outputFlg = true;
                        }
                    }
                } else {
                    if (pEditTeisyutusyoruiBean.getKykHhknDou() == true
                        || C_KyksyaSibouUmuKbn.KYKSBARI.eq(pEditTeisyutusyoruiBean.getKyksyasibouUmukbn())) {
                        teishutuShoruiKensakuKi = "SB_KOSEKITOUHON_MENSEKI";
                        chuuiJikoukensakuKi = "SB_KOSEKITOUHON_MENSEKI_TYUUI";
                        outputFlg = true;
                    }
                }
            }
        }
        if (outputFlg == true) {
            teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(), teishutuShoruiKensakuKi,
                chuuiJikoukensakuKi);
        }
        return teisyutusyoruiItiranBean;
    }

    private TeisyutusyoruiItiranBean getKykDrSkYoukenKakuninSyoruiInfo(EditTeisyutusyoruiBean pEditTeisyutusyoruiBean ){
        TeisyutusyoruiItiranBean teisyutusyoruiItiranBean = null;

        if (C_SeikyuuSyubetu.SB.eq(pEditTeisyutusyoruiBean.getSeikyuuSyubetu()) &&
            C_MousideninKbn.KYKDAIRININ.eq(pEditTeisyutusyoruiBean.getMousideninKbn())) {
            teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(),
                "KYKDRSEIKYUU_KAKUNINSYORUI",
                "KYKDRSEIKYUU_KAKUNINSYORUI_TYUUI");
        }
        return teisyutusyoruiItiranBean;
    }

    private TeisyutusyoruiItiranBean getJikojyokyouhksInfo(EditTeisyutusyoruiBean pEditTeisyutusyoruiBean ){
        TeisyutusyoruiItiranBean teisyutusyoruiItiranBean = null;

        if (C_UmuKbn.ARI.eq(pEditTeisyutusyoruiBean.getJikojyoukyouhksUmu())) {
            teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(), "JIKOJYOUKYOU_HOUKOKUSYO",
                "JIKOJYOUKYOU_HOUKOKUSYO_TYUUI");
        }
        return teisyutusyoruiItiranBean;
    }


    private TeisyutusyoruiItiranBean getKtjksmsInfo(EditTeisyutusyoruiBean pEditTeisyutusyoruiBean ){
        TeisyutusyoruiItiranBean teisyutusyoruiItiranBean = null;

        if (C_UmuKbn.ARI.eq(pEditTeisyutusyoruiBean.getJikojyoukyouhksUmu())) {
            teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(), "KOUTUUJIKO_SYOUMEISHO",
                "KOUTUUJIKO_SYOUMEISHO_TYUUI");
        }
        return teisyutusyoruiItiranBean;
    }

    private TeisyutusyoruiItiranBean getHonninkakuninSyoruiInfo(EditTeisyutusyoruiBean pEditTeisyutusyoruiBean ){
        TeisyutusyoruiItiranBean teisyutusyoruiItiranBean = null;
        String teishutuShoruiKensakuKi = "";
        String chuuiJikoukensakuKi = "";
        Boolean outputFlg = false;

        if (C_SeikyuuSyubetu.SB.eq(pEditTeisyutusyoruiBean.getSeikyuuSyubetu())) {
            if (!C_MousideninKbn.KYKDAIRININ.eq(pEditTeisyutusyoruiBean.getMousideninKbn())) {
                if (pEditTeisyutusyoruiBean.getJisatuMenseki() == false) {
                    if(pEditTeisyutusyoruiBean.getSbuktNin() >1){
                        teishutuShoruiKensakuKi = "SB_HONNINKAKUNIN_UKTHUKUSUU";
                        chuuiJikoukensakuKi = "SB_HONNINKAKUNIN_UKTHUKUSUU_TYUUI";
                        outputFlg = true;

                    }
                    else if(pEditTeisyutusyoruiBean.getSbuktNin() == 1){
                        if(C_UktKbn.KYK.eq(pEditTeisyutusyoruiBean.getUktKbn())){
                            teishutuShoruiKensakuKi = "SB_HONNINKAKUNIN";
                            chuuiJikoukensakuKi = "SB_HONNINKAKUNIN_TYUUI";
                            outputFlg = true;
                        } else {
                            teishutuShoruiKensakuKi = "SB_HONNINKAKUNIN_UKTBETSU";
                            chuuiJikoukensakuKi = "SB_HONNINKAKUNIN_UKTBETSU_TYUUI";
                            outputFlg = true;
                        }
                    }
                } else {
                    if (pEditTeisyutusyoruiBean.getKykHhknDou() == false && C_KyksyaSibouUmuKbn.BLNK.eq(pEditTeisyutusyoruiBean.getKyksyasibouUmukbn())) {
                        teishutuShoruiKensakuKi = "SB_HONNINKAKUNIN_KEISB_NASI";
                        chuuiJikoukensakuKi = "SB_HONNINKAKUNIN_KEISB_NASI_TYUUI";
                        outputFlg = true;
                    } else {
                        teishutuShoruiKensakuKi = "SB_HONNINKAKUNIN_KEISB";
                        chuuiJikoukensakuKi = "SB_HONNINKAKUNIN_KEISB_TYUUI";
                        outputFlg = true;
                    }
                }
            }
            else {
                teishutuShoruiKensakuKi = "SB_HONNINKAKUNIN_KYKDR";
                chuuiJikoukensakuKi = "SB_HONNINKAKUNIN_KYKDR_TYUUI";
                outputFlg = true;
            }
        }
        if (outputFlg == true) {
            teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(), teishutuShoruiKensakuKi,
                chuuiJikoukensakuKi);
        }
        return teisyutusyoruiItiranBean;
    }

    private TeisyutusyoruiItiranBean getMynumbertkSyoruiInfo(EditTeisyutusyoruiBean pEditTeisyutusyoruiBean ){
        TeisyutusyoruiItiranBean teisyutusyoruiItiranBean = null;

        if (C_SeikyuuSyubetu.SB.eq(pEditTeisyutusyoruiBean.getSeikyuuSyubetu()) &&
            C_UmuKbn.ARI.eq(pEditTeisyutusyoruiBean.getMynumbertksUmuKbn())) {
            teisyutusyoruiItiranBean = getMeisaiSyuturyokuInfo(
                pEditTeisyutusyoruiBean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd(),
                "MYNUMBER_TEIKYOUSYO",
                "MYNUMBER_TEIKYOUSYO_TYUUI");
        }
        return teisyutusyoruiItiranBean;
    }

}

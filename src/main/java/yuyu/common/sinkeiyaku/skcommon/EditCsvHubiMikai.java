package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.sinkeiyaku.file.csv.SkHubiMikaiListLayoutFile;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.result.bean.HubimikaishoInfosBean;

/**
 * 新契約 新契約共通 不備未解消リストＣＳＶ作成
 */
public class EditCsvHubiMikai {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public EditCsvHubiMikai() {
        super();
    }

    public int exec(BizDate pSyoriYmd) {

        int totalCount = 0;

        try (ExDBResults<HubimikaishoInfosBean> hubimikaishoInfosBeanLst = sinkeiyakuDomManager.getHubimikaishoInfos()) {

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            Iterator<HubimikaishoInfosBean> iterator = hubimikaishoInfosBeanLst.iterator();
            if (!iterator.hasNext()) {
                bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SK_HUBIMIKAISYOLST, new ArrayList<>(), true);
                return totalCount;
            }

            List<SkHubiMikaiListLayoutFile> skHubiMikaiListLayoutFileLst = new ArrayList<>();
            int index = 0;
            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = null;
            SkHubiMikaiListLayoutFile skHubiMikaiListLayoutFile = null;

            while (iterator.hasNext()) {
                HubimikaishoInfosBean hubimikaishoInfosBean = iterator.next();
                String mosNo = hubimikaishoInfosBean.getMosnoSyoriCTL();
                String oyaDrtenCd = hubimikaishoInfosBean.getOyadrtencd();
                String drtenNmkj = "";
                String utdskknNm1kj = hubimikaishoInfosBean.getUtdskknnm1kj();
                String jimusyoCd = "";
                String hknSyuruiNm = hubimikaishoInfosBean.getHknsyuruino().getContent();
                String kykNmkj;
                if (C_KykKbn.KEIHI_DOUITU.eq(hubimikaishoInfosBean.getKykkbn())) {
                    kykNmkj = hubimikaishoInfosBean.getHhknnmkj();
                }
                else {
                    kykNmkj = hubimikaishoInfosBean.getKyknmkj();
                }

                BizCurrency fstphrkGk = hubimikaishoInfosBean.getMosfstpkei();
                String hrkTuukasyu = hubimikaishoInfosBean.getHrktuukasyu().getContent();
                String kettei = hubimikaishoInfosBean.getKetteikbn().getContent();

                bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(mosNo);

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                    bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                BizDate mosNrkYmd = bzGetProcessSummaryOutBeanLst.get(0).getJimuStartYmd();

                List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(hubimikaishoInfosBean.getTratkiagcd());

                for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {

                    if (C_DiritenjyouhouKbn.SHITEIOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                        drtenNmkj = bzGetAgInfoBean.getKanjiDairitenNm();

                        for (BzGetAgInfoBean bzGetAgInfoBean1 : bzGetAgInfoBeanLst) {

                            if (C_DiritenjyouhouKbn.SHITEIKO.eq(bzGetAgInfoBean1.getDiritenJyouhouKbn())) {
                                jimusyoCd = bzGetAgInfoBean1.getDrtenJimCd();
                                break;
                            }
                        }

                        break;
                    }
                }

                skHubiMikaiListLayoutFile = SWAKInjector.getInstance(SkHubiMikaiListLayoutFile.class);

                skHubiMikaiListLayoutFile.setIfcOyadrtencd(oyaDrtenCd);
                skHubiMikaiListLayoutFile.setIfcDrtennmkj(drtenNmkj);
                skHubiMikaiListLayoutFile.setIfcUtidasikikannm1(utdskknNm1kj);
                skHubiMikaiListLayoutFile.setIfcJimusyocd(jimusyoCd);
                skHubiMikaiListLayoutFile.setIfcMosnyuuryokuymd(String.valueOf(mosNrkYmd));
                skHubiMikaiListLayoutFile.setIfcMosno(mosNo);
                skHubiMikaiListLayoutFile.setIfcHknsyuruimei(hknSyuruiNm);
                skHubiMikaiListLayoutFile.setIfcKyknmkj(kykNmkj);
                skHubiMikaiListLayoutFile.setIfcSyokaiphrkgk(fstphrkGk.toFormatString());
                skHubiMikaiListLayoutFile.setIfcHrktuukasyu(hrkTuukasyu);
                skHubiMikaiListLayoutFile.setIfcKetteikbn(kettei);

                skHubiMikaiListLayoutFileLst.add(skHubiMikaiListLayoutFile);

                index = index + 1;
            }

            bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SK_HUBIMIKAISYOLST, skHubiMikaiListLayoutFileLst, true);

            totalCount = index;

            return totalCount;
        }
    }
}

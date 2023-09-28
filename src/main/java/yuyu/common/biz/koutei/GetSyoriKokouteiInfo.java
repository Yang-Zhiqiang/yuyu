package yuyu.common.biz.koutei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;

/**
 * 業務共通 工程 処理中子工程情報取得
 */
public class GetSyoriKokouteiInfo {

    @Inject
    private BzGetProcessSummary bzGetProcessSummary;

    @Inject
    private BizDomManager bizDomManager;

    public GetSyoriKokouteiInfo() {
        super();
    }

    public List<GetSyoriKokouteiInfoOutBean> exec(String pKouteiKanriId, String pJimutetuzukiCd) {

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst =
            bizDomManager.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd(pKouteiKanriId, pJimutetuzukiCd);

        GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean = null;
        List<GetSyoriKokouteiInfoOutBean> getSyoriKokouteiInfoOutBeanLst = new ArrayList<>();
        List<String> syoriKokouteiJimutetuzukiCdLst = new ArrayList<>();

        for (BT_GyoumuKouteiInfo gyoumuKouteiInfo : gyoumuKouteiInfoLst) {

            if (gyoumuKouteiInfo.getKouteikanriid().equals(pKouteiKanriId) &&
                gyoumuKouteiInfo.getJimutetuzukicd().equals(pJimutetuzukiCd)) {
                continue;
            }

            String koKouteiKanriId = gyoumuKouteiInfo.getKouteikanriid();
            String koJimutetuzukiCd = gyoumuKouteiInfo.getJimutetuzukicd();

            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

            bzGetProcessSummaryInBean.setKouteiKanriId(koKouteiKanriId);
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(koJimutetuzukiCd);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.size() == 0) {
                continue;
            }

            getSyoriKokouteiInfoOutBean = new GetSyoriKokouteiInfoOutBean();

            getSyoriKokouteiInfoOutBean.setSyoriKokouteikanriId(koKouteiKanriId);
            getSyoriKokouteiInfoOutBean.setSyoriKokouteiJimutetuzukiCd(koJimutetuzukiCd);

            getSyoriKokouteiInfoOutBeanLst.add(getSyoriKokouteiInfoOutBean);

            syoriKokouteiJimutetuzukiCdLst.add(koJimutetuzukiCd);
        }

        for (GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBeanTemp : getSyoriKokouteiInfoOutBeanLst) {
            String douJimutetuzukiHanteiCd = getSyoriKokouteiInfoOutBeanTemp.getSyoriKokouteiJimutetuzukiCd();

            if (Collections.frequency(syoriKokouteiJimutetuzukiCdLst, douJimutetuzukiHanteiCd) > 1) {
                getSyoriKokouteiInfoOutBeanTemp.setDouJimutetuzukicdUmuKbn(C_UmuKbn.ARI);
            }
            else {
                getSyoriKokouteiInfoOutBeanTemp.setDouJimutetuzukicdUmuKbn(C_UmuKbn.NONE);
            }
        }

        return getSyoriKokouteiInfoOutBeanLst;
    }
}

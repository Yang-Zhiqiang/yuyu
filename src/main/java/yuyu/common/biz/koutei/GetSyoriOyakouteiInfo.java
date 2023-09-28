package yuyu.common.biz.koutei;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;

/**
 * 業務共通 工程 処理中親工程情報取得
 */
public class GetSyoriOyakouteiInfo {

    @Inject
    private BzGetProcessSummary bzGetProcessSummary;

    @Inject
    private BizDomManager bizDomManager;

    public GetSyoriOyakouteiInfo() {
        super();
    }

    public GetSyoriOyakouteiInfoOutBean exec(String pKouteiKanriId) {

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(pKouteiKanriId);

        String syuKouteiKanriId = gyoumuKouteiInfo.getSyukouteikanriid();
        String syuJimutetuzukiCd = gyoumuKouteiInfo.getSyukouteijimutetuzukicd();

        GetSyoriOyakouteiInfoOutBean getSyoriOyakouteiInfoOutBean = new GetSyoriOyakouteiInfoOutBean();

        if (syuKouteiKanriId.equals(pKouteiKanriId)) {
        }
        else {
            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

            bzGetProcessSummaryInBean.setKouteiKanriId(syuKouteiKanriId);
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(syuJimutetuzukiCd);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.size() == 0) {
            }
            else {
                getSyoriOyakouteiInfoOutBean.setSyoriOyaKouteikanriId(syuKouteiKanriId);
                getSyoriOyakouteiInfoOutBean.setSyoriOyaKouteiJimutetuzukiCd(syuJimutetuzukiCd);
            }
        }

        return getSyoriOyakouteiInfoOutBean;
    }
}

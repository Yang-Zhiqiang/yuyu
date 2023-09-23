package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * 保険金給付金支払 請求内容チェック 同時請求処理中チェック
 */
public class ChkSubDoujiSeikyuuSyori {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    ChkSubDoujiSeikyuuSyori() {
        super();
    }

    public void exec(JT_SkKihon pSkKihon, JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanList) {

        logger.debug("▽ 同時請求処理中チェック 開始");

        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoList =  bizDomManager.getGyoumuKouteiInfosBySkno(pSkKihon.getSkno());

        if(gyoumuKouteiInfoList.size() > 0){
            String[] kouteikanriIds = new String[gyoumuKouteiInfoList.size()];

            for (int i=0; i<gyoumuKouteiInfoList.size(); i++ ){
                kouteikanriIds[i] = gyoumuKouteiInfoList.get(i).getKouteikanriid();
            }

            BzGetProcessSummaryInBean summaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

            summaryInBean.setKouteiKanriIds(kouteikanriIds);

            summaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

            List<BzGetProcessSummaryOutBean> outBeanList = bzGetProcessSummary.exec(summaryInBean);

            for (BzGetProcessSummaryOutBean summaryOutBean : outBeanList) {

                if (!pSiKykKihon.getSyono().equals(summaryOutBean.getSyoNo())) {

                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.DOUJISKSYORITYUU_CHK);

                    chkKekkaBean.setMsgHikisuu1(summaryOutBean.getSyoNo());

                    pChkKekkaBeanList.add(chkKekkaBean);
                }
            }
        }

        logger.debug("△ 同時請求処理中チェック 終了");
    }
}

package yuyu.app.siharai.sihubikanri.sihubinaiyoukensaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.JM_SiHubiNaiyou;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.sorter.SortJM_SiHubiNaiyou;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.def.workflow.sorter.SortDM_Jimutetuzuki;

/**
 * 保険金給付金不備内容検索 のビジネスロジックです。
 */
public class SiHubiNaiyouKensakuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiHubiNaiyouKensakuUiBean uiBean;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private WorkflowDomManager workflowDomManager;

    void init() {
        BizPropertyInitializer.initialize(uiBean);

        List<DM_Jimutetuzuki> jimutetuzukiLst =
            workflowDomManager.getJimutetuzukisByJimutetuzukicd(TeisuuSiharai.JIMUTETUZUKICD_SISIBOU);
        SortDM_Jimutetuzuki jimutetuzukiSort = SWAKInjector.getInstance(SortDM_Jimutetuzuki.class);
        jimutetuzukiLst = jimutetuzukiSort.OrderDM_JimutetuzukiByHyoujijyunAsc(jimutetuzukiLst);
        UserDefsList userDefsList = new UserDefsList();
        for (int idx = 0;idx < jimutetuzukiLst.size();idx++) {
            LabelValuePair labelValuePair = new LabelValuePair();
            labelValuePair.setLabel(jimutetuzukiLst.get(idx).getJimutetuzukinm());
            labelValuePair.setValue(jimutetuzukiLst.get(idx).getJimutetuzukicd());
            userDefsList.add(labelValuePair);
        }
        uiBean.setDispjimutetuzukinmOptionBeanList(userDefsList);

        List<JM_SiHubiNaiyou> jM_SiHubiNaiyouList = siharaiDomManager.getAllSiHubiNaiyou();
        for (JM_SiHubiNaiyou jM_SiHubiNaiyou : jM_SiHubiNaiyouList){
            jM_SiHubiNaiyou.detach();
        }
        uiBean.setSiHubiNaiYouLst(jM_SiHubiNaiyouList);

        uiBean.setDispsyoruinmsntkOptionBeanList(new UserDefsList());
    }

    void clear() {
    }

    void pushSearchBL() {
        List<JM_SiHubiNaiyou> siHubiNaiyouLst = siharaiDomManager.getSiHubiNaiyousByJimutetuzukicdSyoruiCd(uiBean
            .getDispjimutetuzukinm(),C_SyoruiCdKbn.valueOf(uiBean.getDispsyoruinmsntk()));
        if (siHubiNaiyouLst.size() == 0) {
            throw new BizLogicException(MessageId.EAC0014);
        }
        SortJM_SiHubiNaiyou sortJM_SiHubiNaiyou = SWAKInjector.getInstance(SortJM_SiHubiNaiyou.class);
        siHubiNaiyouLst = sortJM_SiHubiNaiyou.OrderJM_SiHubiNaiyouByHubinaiyoucdAsc(siHubiNaiyouLst);
        List<HubinaiyouListDataSourceBean> hubinaiyouListDataSourceBeanLst = new ArrayList<>();
        String selLink = MessageUtil.getMessage(SiHubiNaiyouKensakuConstants.DDID_HUBINAIYOULIST_SENTAKULINK
            .getErrorResourceKey());
        for (int idx = 0;idx < siHubiNaiyouLst.size();idx++) {
            HubinaiyouListDataSourceBean hubinaiyouListDataSourceBean = SWAKInjector
                .getInstance(HubinaiyouListDataSourceBean.class);
            hubinaiyouListDataSourceBean.setSyoruiCd(C_SyoruiCdKbn.valueOf(uiBean.getDispsyoruinmsntk()));
            hubinaiyouListDataSourceBean.setSyoruinm(C_SyoruiCdKbn.getContentByValue(uiBean.getDispsyoruinmsntk()));
            hubinaiyouListDataSourceBean.setHubinaiyoucd(siHubiNaiyouLst.get(idx).getHubinaiyoucd());
            hubinaiyouListDataSourceBean.setDisphubinaiyou(siHubiNaiyouLst.get(idx).getHubinaiyou());
            hubinaiyouListDataSourceBean.setDisphubinaiyoumsg(siHubiNaiyouLst.get(idx).getHubisyoruimsg());
            hubinaiyouListDataSourceBean.setSentakulink(selLink);
            hubinaiyouListDataSourceBeanLst.add(hubinaiyouListDataSourceBean);
        }

        uiBean.setHubinaiyouList(hubinaiyouListDataSourceBeanLst);
    }
}

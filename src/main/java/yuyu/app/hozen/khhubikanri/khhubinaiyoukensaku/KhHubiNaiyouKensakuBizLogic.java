package yuyu.app.hozen.khhubikanri.khhubinaiyoukensaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KensakuyouGenponHnkykumu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.IM_KhHubiNaiyou;
import yuyu.def.hozen.detacher.IM_KhHubiNaiyouDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIM_KhHubiNaiyou;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.def.workflow.sorter.SortDM_Jimutetuzuki;

/**
 * 契約保全不備内容検索 のビジネスロジックです。
 */
public class KhHubiNaiyouKensakuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhHubiNaiyouKensakuUiBean uiBean;

    @Inject
    private WorkflowDomManager workflowDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private MessageManager messageManager;

    void init() {

        BizPropertyInitializer.initialize(uiBean);

        SortDM_Jimutetuzuki sortJimutetuzuki = SWAKInjector.getInstance(SortDM_Jimutetuzuki.class);
        SortIM_KhHubiNaiyou sortKhHubiNaiyou = SWAKInjector.getInstance(SortIM_KhHubiNaiyou.class);

        List<DM_Jimutetuzuki> JimutetuzukiList = sortJimutetuzuki.OrderDM_JimutetuzukiByHyoujijyunAsc(
            workflowDomManager.getJimutetuzukisBySubSystemId(KhHubiNaiyouKensakuConstants.SUBSYSTEMID));

        UserDefsList udList = new UserDefsList();

        LabelValuePair pair = new LabelValuePair();

        udList.add(pair);

        for (DM_Jimutetuzuki jimutetuzuki : JimutetuzukiList) {

            pair = new LabelValuePair();

            pair.setLabel(jimutetuzuki.getJimutetuzukinm());

            pair.setValue(jimutetuzuki.getJimutetuzukicd());

            udList.add(pair);
        }

        uiBean.clearJimuttdknmOptionBeanList();
        uiBean.setJimuttdknmOptionBeanList(udList);

        List<IM_KhHubiNaiyou> khHubiNaiyouList = hozenDomManager.getAllKhHubiNaiyou();
        khHubiNaiyouList = IM_KhHubiNaiyouDetacher.detachKhHubiNaiyoutouched(khHubiNaiyouList);
        khHubiNaiyouList = sortKhHubiNaiyou.OrderIM_KhHubiNaiyouBySyoruiCdAsc(khHubiNaiyouList);

        uiBean.setKhHubiNaiyouList(khHubiNaiyouList);

        uiBean.setDispsyoruinmsntkOptionBeanList(new UserDefsList());
    }

    void clear() {

    }

    void searchBtnOnClick() {

        C_UmuKbn genponhnkykumu = C_UmuKbn.NONE;

        if (uiBean.getKensakuyougenponhnkykumu() == null) {

            genponhnkykumu = null;
        }
        else if (C_KensakuyouGenponHnkykumu.ARI.eq(uiBean.getKensakuyougenponhnkykumu())) {

            genponhnkykumu = C_UmuKbn.ARI;
        }
        else if (C_KensakuyouGenponHnkykumu.ARI.eq(uiBean.getKensakuyougenponhnkykumu())) {

            genponhnkykumu = C_UmuKbn.NONE;
        }

        List<FubinaiyouListDataSourceBean> fubinaiyouListDataSourceBeanList = new ArrayList<>();

        uiBean.setFubinaiyouList(fubinaiyouListDataSourceBeanList);

        List<IM_KhHubiNaiyou> khHubiNaiyouList = hozenDomManager.getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems(
            uiBean.getJimuttdknm()
            , C_SyoruiCdKbn.valueOf(uiBean.getDispsyoruinmsntk())
            , uiBean.getHassinsakikbn()
            , uiBean.getKensakuyougenponhnkykumu()
            , genponhnkykumu
            , uiBean.getKhhubinaiyou());

        if (khHubiNaiyouList.size() == 0) {

            messageManager.addMessageId(MessageId.EAC0014);
            return;
        }

        String messageId = KhHubiNaiyouKensakuConstants.DDID_FUBINAIYOULIST_SENTAKULINK.getErrorResourceKey();

        String sentakuLink = MessageUtil.getMessage(messageId);

        for (IM_KhHubiNaiyou khHubiNaiyou : khHubiNaiyouList) {

            FubinaiyouListDataSourceBean fubinaiyouListDataSourceBean = SWAKInjector
                .getInstance(FubinaiyouListDataSourceBean.class);

            fubinaiyouListDataSourceBean.setDispkhhubinaiyou(khHubiNaiyou.getHubinaiyou());

            fubinaiyouListDataSourceBean.setDisphassinsakikbn(khHubiNaiyou.getHassinsakikbn());

            fubinaiyouListDataSourceBean.setDispgenponhnkykumu(khHubiNaiyou.getGenponhnkykumu());

            fubinaiyouListDataSourceBean.setDisphubinaiyoumsg(khHubiNaiyou.getHubisyoruimsg());

            fubinaiyouListDataSourceBean.setSentakulink(sentakuLink);

            fubinaiyouListDataSourceBean.setSyoruiCd(khHubiNaiyou.getSyoruiCd());

            fubinaiyouListDataSourceBean.setSyoruinm(khHubiNaiyou.getSyoruiCd().getContent());

            fubinaiyouListDataSourceBean.setHubinaiyoucd(khHubiNaiyou.getHubinaiyoucd());

            if (C_UmuKbn.ARI.eq(khHubiNaiyou.getGenponhnkykumu())) {
                fubinaiyouListDataSourceBean.setDispgenponhnkykumuchkbox(true);
            }
            else {
                fubinaiyouListDataSourceBean.setDispgenponhnkykumuchkbox(false);
            }

            fubinaiyouListDataSourceBeanList.add(fubinaiyouListDataSourceBean);
        }

        uiBean.setFubinaiyouList(fubinaiyouListDataSourceBeanList);

    }
}

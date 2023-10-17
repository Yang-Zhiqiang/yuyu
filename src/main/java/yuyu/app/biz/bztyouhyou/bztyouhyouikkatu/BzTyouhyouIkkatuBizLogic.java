package yuyu.app.biz.bztyouhyou.bztyouhyouikkatu;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.bean.SyoruiZokuseiTyouhyouInfoBean;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.def.db.entity.BT_TyouhyouOutputKengen;
import yuyu.infr.report.OutputReport;

import com.google.common.collect.Lists;

/**
 * 帳票一括出力 のビジネスロジックです。
 */
public class BzTyouhyouIkkatuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzTyouhyouIkkatuUiBean uiBean;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private OutputReport outputReport;

    @Inject
    private BaseUserInfo baseInfo;

    boolean init() {
        uiBean.setTyouhyousakuseiymd(BizDate.getSysDate().addBusinessDays(-1));

        List<AT_UserRole> userRoleList  = baseInfo.getUser().getUserRoles() ;
        String[] roleCds = new String[userRoleList.size()];
        for (int i = 0; i < userRoleList.size(); i++) {
            roleCds[i] = userRoleList.get(i).getRoleCd();
        }

        List<BT_TyouhyouOutputKengen> tyouhyouOutputKengenList = bizDomManager
            .getTyouhyouOutputKengensByRoleCdsIkkatuoutputkahikbn(roleCds, C_KahiKbn.KA);

        if (tyouhyouOutputKengenList.size() == 0) {
            messageManager.addMessageId(MessageId.IBA0009);
            return true;
        }
        uiBean.setRoleCds(roleCds);

        List<String> hisiyouSubSystemList = YuyuBizConfig.getInstance().getHisiyouSubsystemList();
        List<AS_SubSystem> subSystemList = baseDomManager.getAllSubSystemsSortNoOrder();

        UserDefsList userList = new UserDefsList();

        for (AS_SubSystem subSystem : subSystemList) {
            boolean hisiyouSubSystemFlg = false;

            if (hisiyouSubSystemList.contains(subSystem.getSubSystemId())) {
                hisiyouSubSystemFlg = true;
            }

            if (subSystem.getSubSystemId().equals(BzTyouhyouIkkatuConstants.IWF)) {
                hisiyouSubSystemFlg = true;
            }

            if (!hisiyouSubSystemFlg) {
                LabelValuePair labelValuePair = new LabelValuePair();
                labelValuePair.setLabel(subSystem.getSubSystemNm());
                labelValuePair.setValue(subSystem.getSubSystemId());
                userList.add(labelValuePair);
            }
        }

        uiBean.setSubSystemIdOptionBeanList(userList);

        BizPropertyInitializer.initialize(uiBean);

        return false;
    }

    void clear() {
    }

    void pushKensaku() {

        if (BizDateUtil.compareYmd(BizDate.getSysDate(), uiBean.getTyouhyousakuseiymd()) == BizDateUtil.COMPARE_LESSER) {
            throw new BizLogicException(MessageId.EBA0015);
        }

        List<SyoruiZokuseiTyouhyouInfoBean> tyouhyouInfoList = bizDomManager.getSyoruiZokuseiTyouhyouInfo(
            uiBean.getSubSystemId(), uiBean.getTyouhyousakuseiymd(), uiBean.getRoleCds(), null);

        if (tyouhyouInfoList.size() == 0) {
            throw new BizLogicException(MessageId.EBA0014);
        }

        List<SearchResultListDataSourceBean> searchResultListDsList = Lists.newArrayList();
        for (SyoruiZokuseiTyouhyouInfoBean bean : tyouhyouInfoList) {

            SearchResultListDataSourceBean searchResultListDsBean = new SearchResultListDataSourceBean();
            searchResultListDsBean.setSyoruiCd(bean.getSyoruiCd());
            searchResultListDsBean.setDispsyoruinm(bean.getSyoruinm());
            searchResultListDsBean.setKnskkmkId1(bean.getKensakuKey1());
            searchResultListDsBean.setKnskkmkId2(bean.getKensakuKey2());
            searchResultListDsBean.setKnskkmkId3(bean.getKensakuKey3());
            searchResultListDsBean.setKnskkmkId4(bean.getKensakuKey4());
            searchResultListDsBean.setKnskkmkId5(bean.getKensakuKey5());
            searchResultListDsBean.setDispmisyuturyokukensuu((int)(bean.getNotOutputCount()));
            searchResultListDsBean.setDispsakuseisoukensuu((int)(bean.getAmount()));
            searchResultListDsList.add(searchResultListDsBean);
        }
        uiBean.setSearchResultList(searchResultListDsList);
    }

    void syoruinmLink() {

        SearchResultListDataSourceBean sourceBean = uiBean.getSearchResultListDataSource().getSelectedBean();
        List<String> kensakuIdList = YuyuBizConfig.getInstance().getKensakuIdList();
        List<String> kensakuNmList = YuyuBizConfig.getInstance().getKensakunmList();
        uiBean.setKensakuNm1("");
        uiBean.setKensakuNm2("");
        uiBean.setKensakuNm3("");
        uiBean.setKensakuNm4("");
        uiBean.setKensakuNm5("");
        for (int idx = 0; idx < kensakuIdList.size(); idx++) {
            if (kensakuIdList.get(idx).equals(sourceBean.getKnskkmkId1())) {
                uiBean.setKensakuNm1(kensakuNmList.get(idx));
            }
            else if (kensakuIdList.get(idx).equals(sourceBean.getKnskkmkId2())) {
                uiBean.setKensakuNm2(kensakuNmList.get(idx));
            }
            else if (kensakuIdList.get(idx).equals(sourceBean.getKnskkmkId3())) {
                uiBean.setKensakuNm3(kensakuNmList.get(idx));
            }
            else if (kensakuIdList.get(idx).equals(sourceBean.getKnskkmkId4())) {
                uiBean.setKensakuNm4(kensakuNmList.get(idx));
            }
            else if (kensakuIdList.get(idx).equals(sourceBean.getKnskkmkId5())) {
                uiBean.setKensakuNm5(kensakuNmList.get(idx));
            }
        }
        uiBean.setSyoruiCd(sourceBean.getSyoruiCd());
        uiBean.setSyoruinm(sourceBean.getDispsyoruinm());
        uiBean.setMisyuturyokukensuu(sourceBean.getDispmisyuturyokukensuu());
        uiBean.setSakuseisoukensuu(sourceBean.getDispsakuseisoukensuu());

        List<AT_TyouhyouKensaku> tyouhyouKensakuList = bizDomManager.getTyouhyouKensakusBySyoruiCdSubSystemIdSyoriYmdOutCount(
            sourceBean.getSyoruiCd(),uiBean.getSubSystemId(), uiBean.getTyouhyousakuseiymd(), 0);

        if (tyouhyouKensakuList.size() == 0 || tyouhyouKensakuList.size() != sourceBean.getDispmisyuturyokukensuu()) {
            throw new BizLogicException(MessageId.EBA0016);
        }
        int maxCount = 0;
        if (tyouhyouKensakuList.size() > 50) {
            maxCount = 50;
        }
        else {
            maxCount = tyouhyouKensakuList.size();
        }

        List<SearchKeyListDataSourceBean> searchKeyList = Lists.newArrayList();

        for (int idx = 0; idx < tyouhyouKensakuList.size(); idx++) {

            SearchKeyListDataSourceBean SearchKeyListDataSourceBean = new SearchKeyListDataSourceBean();
            SearchKeyListDataSourceBean.setKnskkmknm1(tyouhyouKensakuList.get(idx).getKensakuKey1());
            SearchKeyListDataSourceBean.setKnskkmknm2(tyouhyouKensakuList.get(idx).getKensakuKey2());
            SearchKeyListDataSourceBean.setKnskkmknm3(tyouhyouKensakuList.get(idx).getKensakuKey3());
            SearchKeyListDataSourceBean.setKnskkmknm4(tyouhyouKensakuList.get(idx).getKensakuKey4());
            SearchKeyListDataSourceBean.setKnskkmknm5(tyouhyouKensakuList.get(idx).getKensakuKey5());
            SearchKeyListDataSourceBean.setReportKey(tyouhyouKensakuList.get(idx).getReportKey());
            searchKeyList.add(SearchKeyListDataSourceBean);
            if (idx + 1 >= maxCount) {
                break;
            }
        }

        uiBean.setSearchKeyList(searchKeyList);
        messageManager.addMessageId(MessageId.QHA0008);
    }

    void pushKakutei() {

        List<SyoruiZokuseiTyouhyouInfoBean> tyouhyouInfoList = bizDomManager.getSyoruiZokuseiTyouhyouInfo(
            uiBean.getSubSystemId(), uiBean.getTyouhyousakuseiymd(), uiBean.getRoleCds(), uiBean.getSyoruiCd());

        if (tyouhyouInfoList.size() == 0) {
            throw new BizLogicException(MessageId.EBA0016);
        }


        if (uiBean.getMisyuturyokukensuu() != tyouhyouInfoList.get(0).getNotOutputCount()
            || uiBean.getSakuseisoukensuu() != tyouhyouInfoList.get(0).getAmount()) {
            throw new BizLogicException(MessageId.EBA0016);
        }

        messageManager.addMessageId(MessageId.IHA0015);
    }

    void printOut(){

        List<SearchKeyListDataSourceBean> searchKeyList = uiBean.getSearchKeyListDataSource().getAllData();

        String[] reportKeys = new String[searchKeyList.size()];
        for (int idx = 0; idx < searchKeyList.size(); idx++) {
            reportKeys[idx] = searchKeyList.get(idx).getReportKey();
        }

        outputReport.outputPDFByKeys(reportKeys);

    }
}
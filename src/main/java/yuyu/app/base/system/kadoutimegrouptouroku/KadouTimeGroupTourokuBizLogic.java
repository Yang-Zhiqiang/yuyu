package yuyu.app.base.system.kadoutimegrouptouroku;

import static yuyu.app.base.system.kadoutimegrouptouroku.GenKadouTimeGroupTourokuConstants.*;
import static yuyu.app.base.system.kadoutimegrouptouroku.KadouTimeGroupTourokuConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.base.ConversationStatus;
import yuyu.common.base.UnknownForwardException;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_EigyoubiKbn;
import yuyu.def.classification.C_KadouTimeSiteiKbn;
import yuyu.def.classification.C_KadouTimeYoubiKbn;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.entity.AT_KadouTime;
import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.def.enumeration.E_HenkanKbn;
import yuyu.def.enumeration.E_SyoriKbn;

import com.google.common.base.Strings;

/**
 * 稼働時間グループ登録 のビジネスロジックです。
 */
public class KadouTimeGroupTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KadouTimeGroupTourokuUiBean uiBean;

    @Inject
    private BaseDomManager manager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private ConversationStatus status;

    void init() {
        clear();
        getKadouTimeGroupInfoList();
    }

    void clear() {
        uiBean.setKadouTimeGroupCd(null);
    }

    void setKadouTimeGroup() {

        getHolidayGroupInfo();

        switch (status.getSyoriKbn()) {

            case NEW:

                if (Strings.isNullOrEmpty(uiBean.getKadouTimeGroupCd())) {
                    throw new BizLogicException(MessageId.EAC0006, DDID_KEYINFO_KADOUTIMEGROUPCD);
                }

                if (manager.getKadouTimeGroup(uiBean.getKadouTimeGroupCd()) != null) {
                    throw new BizLogicException(MessageId.EAC0002, DDID_KEYINFO_KADOUTIMEGROUPCD);
                }

                uiBean.setKadouTimeGroup(new AT_KadouTimeGroup());
                uiBean.getKadouTimeGroup().setKadouTimeGroupCd(uiBean.getKadouTimeGroupCd());

                AT_KadouTimeGroup kadouTimeGroupEntity = uiBean.getKadouTimeGroup();
                setKadouTime(kadouTimeGroupEntity, C_KadouTimeYoubiKbn.HYOUJYUN, C_EigyoubiKbn.EIGYOUBI, C_KadouTimeSiteiKbn.ZENJITURIYOU_HUKA);
                setKadouTime(kadouTimeGroupEntity, C_KadouTimeYoubiKbn.GETUYOU, C_EigyoubiKbn.EIGYOUBI, C_KadouTimeSiteiKbn.HYOUJUN);
                setKadouTime(kadouTimeGroupEntity, C_KadouTimeYoubiKbn.KAYOU, C_EigyoubiKbn.EIGYOUBI, C_KadouTimeSiteiKbn.HYOUJUN);
                setKadouTime(kadouTimeGroupEntity, C_KadouTimeYoubiKbn.SUIYOU, C_EigyoubiKbn.EIGYOUBI, C_KadouTimeSiteiKbn.HYOUJUN);
                setKadouTime(kadouTimeGroupEntity, C_KadouTimeYoubiKbn.MOKUYOU, C_EigyoubiKbn.EIGYOUBI, C_KadouTimeSiteiKbn.HYOUJUN);
                setKadouTime(kadouTimeGroupEntity, C_KadouTimeYoubiKbn.KINYOU, C_EigyoubiKbn.EIGYOUBI, C_KadouTimeSiteiKbn.HYOUJUN);
                setKadouTime(kadouTimeGroupEntity, C_KadouTimeYoubiKbn.DOYOU, C_EigyoubiKbn.EIGYOUBI, C_KadouTimeSiteiKbn.HYOUJUN);
                setKadouTime(kadouTimeGroupEntity, C_KadouTimeYoubiKbn.NITIYOU, C_EigyoubiKbn.EIGYOUBI, C_KadouTimeSiteiKbn.HYOUJUN);
                setKadouTime(kadouTimeGroupEntity, C_KadouTimeYoubiKbn.HYOUJYUN, C_EigyoubiKbn.HIEIGYOUBI, C_KadouTimeSiteiKbn.ZENJITURIYOU_HUKA);
                setKadouTime(kadouTimeGroupEntity, C_KadouTimeYoubiKbn.GETUYOU, C_EigyoubiKbn.HIEIGYOUBI, C_KadouTimeSiteiKbn.HYOUJUN);
                setKadouTime(kadouTimeGroupEntity, C_KadouTimeYoubiKbn.KAYOU, C_EigyoubiKbn.HIEIGYOUBI, C_KadouTimeSiteiKbn.HYOUJUN);
                setKadouTime(kadouTimeGroupEntity, C_KadouTimeYoubiKbn.SUIYOU, C_EigyoubiKbn.HIEIGYOUBI, C_KadouTimeSiteiKbn.HYOUJUN);
                setKadouTime(kadouTimeGroupEntity, C_KadouTimeYoubiKbn.MOKUYOU, C_EigyoubiKbn.HIEIGYOUBI, C_KadouTimeSiteiKbn.HYOUJUN);
                setKadouTime(kadouTimeGroupEntity, C_KadouTimeYoubiKbn.KINYOU, C_EigyoubiKbn.HIEIGYOUBI, C_KadouTimeSiteiKbn.HYOUJUN);
                setKadouTime(kadouTimeGroupEntity, C_KadouTimeYoubiKbn.DOYOU, C_EigyoubiKbn.HIEIGYOUBI, C_KadouTimeSiteiKbn.HYOUJUN);
                setKadouTime(kadouTimeGroupEntity, C_KadouTimeYoubiKbn.NITIYOU, C_EigyoubiKbn.HIEIGYOUBI, C_KadouTimeSiteiKbn.HYOUJUN);

                break;

            case EDIT:

                getKadouTimeGroupInfo();
                break;

            case DELETE:
                getKadouTimeGroupInfo();
                convertHolidayGroupInfo(E_HenkanKbn.HYOUJI);

                messageManager.addMessageId(MessageId.QAC0010);
                break;

            default:
                throw new UnknownForwardException();
        }

    }

    void setMessageConvertHolidayGroupInfo() {
        if (E_SyoriKbn.NEW.equals(status.getSyoriKbn())) {
            messageManager.addMessageId(MessageId.QAC0008);
        }
        else  if (E_SyoriKbn.EDIT.equals(status.getSyoriKbn())){
            messageManager.addMessageId(MessageId.QAC0009);
        }

        convertHolidayGroupInfo(E_HenkanKbn.HYOUJI);
    }

    @Transactional
    void commitKadouTimeGroup() {

        switch (status.getSyoriKbn()) {

            case NEW:
                manager.insert(uiBean.getKadouTimeGroup());
                break;

            case EDIT:
                manager.update(uiBean.getKadouTimeGroup());
                break;
            case DELETE:
                manager.delete(uiBean.getKadouTimeGroup());
                break;

            default:
                throw new UnknownForwardException();
        }

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void getHolidayGroupInfo() {

        uiBean.clearHolidayGroupCdOptionBeanList();

        List<AT_HolidayGroup> holidayGroupList = manager.getAllHolidayGroups();

        UserDefsList holidayGroupSelectList = new UserDefsList();

        LabelValuePair selectOptionBean = new LabelValuePair();
        selectOptionBean.setLabel("");
        selectOptionBean.setValue("");
        holidayGroupSelectList.add(selectOptionBean);

        for(AT_HolidayGroup holidayGroup : holidayGroupList){
            selectOptionBean = new LabelValuePair();
            selectOptionBean.setLabel(holidayGroup.getHolidayGroupCd() + SPLITTER + holidayGroup.getHolidayGroupNm());
            selectOptionBean.setValue(holidayGroup.getHolidayGroupCd());
            holidayGroupSelectList.add(selectOptionBean);
        }

        uiBean.setHolidayGroupCdOptionBeanList(holidayGroupSelectList);
    }

    void convertHolidayGroupInfo(E_HenkanKbn pHenkanKbn) {

        getHolidayGroupInfo();

        if (E_HenkanKbn.HYOUJI.equals(pHenkanKbn)) {

            List<LabelValuePair>  holidayGroupCdOptionBeanList = uiBean.getHolidayGroupCdOptionBeanList();

            for (LabelValuePair labelVale : holidayGroupCdOptionBeanList) {

                String label = labelVale.getLabel();

                if (Strings.isNullOrEmpty(label)) {
                    continue;
                }

                String[] labels = label.split(SPLITTER);

                if (labels.length > 1) {
                    labelVale.setLabel(labels[1]);
                }
            }
        }
    }

    void chkReferenceMaster() {

        AT_HolidayGroup holidayGroup = manager.getHolidayGroup(uiBean.getKadouTimeGroup().getHolidayGroupCd());

        if(holidayGroup == null){
            throw new BizLogicException(MessageId.EAC0046, MessageUtil.getMessage(MessageId.IAW0036));
        }
    }


    void chkKadouTimeGroupCdExistence() {

        String kadouTimeGroupCd = uiBean.getKadouTimeGroup().getKadouTimeGroupCd();

        if (kadouTimeGroupCd == null) {
            kadouTimeGroupCd = uiBean.getKadouTimeGroupInfoListDataSource().getSelectedBean().getKadouTimeGroupCd();
        }

        long kinouModeCnt = manager.getKinouModeByCountKadouTimeGroupCd(kadouTimeGroupCd);
        if (kinouModeCnt != 0) {
            throw new BizLogicException(MessageId.EAF0024, KINOUMODE_KIKAN, MessageUtil.getMessage(MessageId.IAW0041));
        }

        long tokuteiKadouTimeCnt = manager.getTokuteibiKadouTimeByCountKadouTimeGroupCd(kadouTimeGroupCd);
        if (tokuteiKadouTimeCnt != 0) {
            throw new BizLogicException(MessageId.EAF0024, MessageUtil.getMessage(MessageId.IAW0038), MessageUtil.getMessage(MessageId.IAW0041));
        }
    }

    void chkKadouTimeGroupExistence() {

        KadouTimeGroupInfoListDataSourceBean  kadouTimeGroupInfoListDataSourceBean =
            uiBean.getKadouTimeGroupInfoListDataSource().getSelectedBean();

        String kadouTimeGroupCd = kadouTimeGroupInfoListDataSourceBean.getKadouTimeGroupCd();

        if (manager.getKadouTimeGroup(kadouTimeGroupCd) == null) {
            throw new BizLogicException(MessageId.EAC0046, MessageUtil.getMessage(DDID_KEYINFO_KADOUTIMEGROUPCD.getErrorResourceKey()));
        }
    }

    private void getKadouTimeGroupInfoList() {

        List<AT_KadouTimeGroup> kadouTimeGroupList = manager.getAllKadouTimeGroups();

        List<KadouTimeGroupInfoListDataSourceBean> kadouTimeGroupInfoBeanList =
            BeanUtil.createList(KadouTimeGroupInfoListDataSourceBean.class, kadouTimeGroupList);

        List<AS_KinouMode> kinouModeList = null;

        String henkou = MessageUtil.getMessage(DDID_KADOUTIMEGROUPINFOLIST_HENKOULINK.getErrorResourceKey());
        String sakujyo = MessageUtil.getMessage(DDID_KADOUTIMEGROUPINFOLIST_SAKUJYOLINK.getErrorResourceKey());

        for(KadouTimeGroupInfoListDataSourceBean bean : kadouTimeGroupInfoBeanList) {

            kinouModeList = manager.getKinouModesByKadouTimeGroup(bean.getKadouTimeGroupCd());

            if (kinouModeList != null  && kinouModeList.size() > 0) {

                bean.setSakujyoLink(null);
            }
            else {

                bean.setSakujyoLink(sakujyo);
            }

            bean.setHenkouLink(henkou);
        }

        uiBean.setKadouTimeGroupInfoList(kadouTimeGroupInfoBeanList);
    }

    private void setKadouTime(AT_KadouTimeGroup pKadouTimeGroup,
        C_KadouTimeYoubiKbn pKadouTimeYoubiKbn,
        C_EigyoubiKbn pEigyoubiKbn,
        C_KadouTimeSiteiKbn pKadouTimeSiteiKbn) {

        AT_KadouTime kadouTimeEntity = pKadouTimeGroup.createKadouTime();
        kadouTimeEntity.setKadouTimeYoubiKbn(pKadouTimeYoubiKbn);
        kadouTimeEntity.setEigyoubiKbn(pEigyoubiKbn);
        kadouTimeEntity.setKadouTimeSiteiKbn(pKadouTimeSiteiKbn);
    }

    private void getKadouTimeGroupInfo() {

        KadouTimeGroupInfoListDataSourceBean  kadouTimeGroupInfoListDataSourceBean =
            uiBean.getKadouTimeGroupInfoListDataSource().getSelectedBean();

        AT_KadouTimeGroup aT_KadouTimeGroup = manager.getKadouTimeGroup(kadouTimeGroupInfoListDataSourceBean.getKadouTimeGroupCd());

        kadouTimeGroupInfoListDataSourceBean.setKadouTimeGroupCd(aT_KadouTimeGroup.getKadouTimeGroupCd());
        kadouTimeGroupInfoListDataSourceBean.setKadouTimeGroupNm(aT_KadouTimeGroup.getKadouTimeGroupNm());
        kadouTimeGroupInfoListDataSourceBean.setHolidayGroupCd(aT_KadouTimeGroup.getHolidayGroupCd());
        kadouTimeGroupInfoListDataSourceBean.setKadouTimeGroupDescription(aT_KadouTimeGroup.getKadouTimeGroupDescription());

        uiBean.setKadouTimeGroup(aT_KadouTimeGroup);
    }
}

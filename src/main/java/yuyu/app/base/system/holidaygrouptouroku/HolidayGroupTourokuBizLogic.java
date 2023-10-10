package yuyu.app.base.system.holidaygrouptouroku;

import static yuyu.app.base.system.holidaygrouptouroku.GenHolidayGroupTourokuConstants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.ConversationStatus;
import yuyu.common.base.UnknownForwardException;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SysSiyouKbn;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.enumeration.E_SyoriKbn;

import com.google.common.base.Strings;

/**
 * 休日グループ登録 のビジネスロジックです。
 */
public class HolidayGroupTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private HolidayGroupTourokuUiBean uiBean;

    @Inject
    private BaseDomManager manager;

    @Inject
    private MessageManager   messageManager;

    @Inject
    private ConversationStatus status;

    void init() {
        clear();
        getHolidayGroupInfoDataSource();
    }

    void clear() {
        uiBean.setHolidayGroup(new AT_HolidayGroup());
    }

    void setupUiBeanHolidayGroup(){

        AT_HolidayGroup holidayGroup;
        HolidayGroupInfoListDataSourceBean holidayGroupInfoListDataSourceBean = uiBean.getHolidayGroupInfoListDataSource().getSelectedBean();

        switch (status.getSyoriKbn()) {

            case EDIT:
                holidayGroup = manager.getHolidayGroup(holidayGroupInfoListDataSourceBean.getHolidayGroupCd());
                uiBean.setHolidayGroup(holidayGroup);
                break;

            case DELETE:
                holidayGroup = manager.getHolidayGroup(holidayGroupInfoListDataSourceBean.getHolidayGroupCd());

                uiBean.setHolidayGroup(holidayGroup);
                messageManager.addMessageId(MessageId.QAC0010) ;
                break;

            default:
                throw new UnknownForwardException();
        }
    }

    void setKakuninMessage() {
        switch (status.getSyoriKbn()) {
            case NEW:
                messageManager.addMessageId(MessageId.QAC0008);
                break;
            case EDIT:
                messageManager.addMessageId(MessageId.QAC0009);
                break;
            default:
                throw new UnknownForwardException();
        }
    }

    @Transactional
    void commitHolidayGroup(){

        AT_HolidayGroup holidayGroup = uiBean.getHolidayGroup();

        switch (status.getSyoriKbn()) {

            case NEW:

                holidayGroup.setSysSiyouKbn(C_SysSiyouKbn.TUUJYOU);
                manager.insert(holidayGroup);
                break;
            case EDIT:

                manager.update(holidayGroup);
                break;
            case DELETE:

                manager.delete(holidayGroup);
                break;

            default:
                throw new UnknownForwardException();
        }

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void chkHoildayGroupExistence() {

        HolidayGroupInfoListDataSourceBean holidayGroupInfoListDataSourceBean = uiBean.getHolidayGroupInfoListDataSource().getSelectedBean();
        String holidayGroupCd = holidayGroupInfoListDataSourceBean.getHolidayGroupCd();

        if (manager.getHolidayGroup(holidayGroupCd) == null) {
            throw new BizLogicException(MessageId.EAC0046, MessageUtil.getMessage(DDID_KEYINFO_HOLIDAYGROUPCD.getErrorResourceKey()));
        }
    }

    void chkReferenceMaster() {

        if (E_SyoriKbn.DELETE.equals(status.getSyoriKbn())) {
            String holidayGroupCd  = uiBean.getHolidayGroup().getHolidayGroupCd();

            if (uiBean.getPageNo() == PAGENO_INPUTKEY) {
                HolidayGroupInfoListDataSourceBean holidayGroupInfoListDataSourceBean = uiBean.getHolidayGroupInfoListDataSource().getSelectedBean();
                holidayGroupCd = holidayGroupInfoListDataSourceBean.getHolidayGroupCd();

            }

            AT_HolidayGroup holidayGroup = manager.getHolidayGroup(holidayGroupCd);

            if (holidayGroup != null) {

                if (holidayGroup.getHolidays().size() > 0) {
                    throw new BizLogicException(MessageId.EAF0024,
                        MessageUtil.getMessage(MessageId.IAW0035),
                        MessageUtil.getMessage(MessageId.IAW0036));
                }
                if (holidayGroup.getHolidayYoyakus().size() > 0) {
                    throw new BizLogicException(MessageId.EAF0024,
                        MessageUtil.getMessage(MessageId.IAW0065),
                        MessageUtil.getMessage(MessageId.IAW0036));
                }
                long kadoutimeGroupCnt = manager.getKadouTimeGroupByCountHolidayGroupCd(holidayGroup.getHolidayGroupCd());
                if (kadoutimeGroupCnt > 0) {
                    throw new BizLogicException(MessageId.EAF0024,
                        MessageUtil.getMessage(MessageId.IAW0041),
                        MessageUtil.getMessage(MessageId.IAW0036));
                }
            }

            long holidayYoyakuCnt = manager.getCountHolidayYoyakuByHolidayPattern(holidayGroupCd);
            if (holidayYoyakuCnt > 0) {
                throw new BizLogicException(MessageId.EAF0024,
                    MessageUtil.getMessage(MessageId.IAW0065),
                    MessageUtil.getMessage(MessageId.IAW0036));
            }

            long holidayCnt = manager.getCountHolidayByHolidayPattern(holidayGroupCd);
            if (holidayCnt > 0) {
                throw new BizLogicException(MessageId.EAF0024,
                    MessageUtil.getMessage(MessageId.IAW0035),
                    MessageUtil.getMessage(MessageId.IAW0036));
            }
        }
    }

    void chkHolidayGroupCdExistence() {
        String holidayGroupCd = uiBean.getHolidayGroup().getHolidayGroupCd();
        if (Strings.isNullOrEmpty(holidayGroupCd)) {
            getHolidayGroupInfoDataSource();
            throw new BizLogicException(MessageId.EAC0006, DDID_KEYINFO_HOLIDAYGROUPCD);
        }
        AT_HolidayGroup holidayGroupEntty = manager.getHolidayGroup(holidayGroupCd);
        if(holidayGroupEntty != null){
            getHolidayGroupInfoDataSource();
            throw new BizLogicException(MessageId.EAC0002, DDID_KEYINFO_HOLIDAYGROUPCD);
        }
    }


    private void getHolidayGroupInfoDataSource() {

        List<AT_HolidayGroup> aT_HolidayGroupList = manager.getAllHolidayGroups();

        Collections.sort(aT_HolidayGroupList,
            new Comparator<AT_HolidayGroup>() {
                @Override
                public int compare(AT_HolidayGroup group1, AT_HolidayGroup group2) {
                    return group1.getHolidayGroupCd().compareTo(
                        group2.getHolidayGroupCd());
                }
            });

        List<HolidayGroupInfoListDataSourceBean> holidayGroupInfoList = new ArrayList<HolidayGroupInfoListDataSourceBean>();

        for (AT_HolidayGroup at_HolidayGroup : aT_HolidayGroupList) {
            HolidayGroupInfoListDataSourceBean holidayGroupInfoListDataSourceBean = new HolidayGroupInfoListDataSourceBean();

            holidayGroupInfoListDataSourceBean.setHolidayGroupCd(at_HolidayGroup.getHolidayGroupCd());
            holidayGroupInfoListDataSourceBean.setHolidayGroupDescription(at_HolidayGroup.getHolidayGroupDescription());
            holidayGroupInfoListDataSourceBean.setHolidayGroupNm(at_HolidayGroup.getHolidayGroupNm());
            C_SysSiyouKbn sysSiyouKbn = at_HolidayGroup.getSysSiyouKbn();

            if (sysSiyouKbn == C_SysSiyouKbn.TUUJYOU) {
                holidayGroupInfoListDataSourceBean.setHenkouLink(MessageUtil.getMessage(MessageId.IAW0011));
                holidayGroupInfoListDataSourceBean.setSakujyoLink(MessageUtil.getMessage(MessageId.IAW0012));
            }
            holidayGroupInfoList.add(holidayGroupInfoListDataSourceBean);
        }
        uiBean.setHolidayGroupInfoList(holidayGroupInfoList);
    }

}

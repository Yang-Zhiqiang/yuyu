package yuyu.app.base.system.usergroupkensaku;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_UserGroup;

/**
 * ユーザーグループ検索 のビジネスロジックです。
 */
public class UserGroupKensakuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private UserGroupKensakuUiBean uiBean;

    @Inject
    private BaseDomManager baseManager;

    @Inject
    private MessageManager messageManager;

    void init() {
        clear();
    }

    void clear() {
        uiBean.setUserGroupInfo(null);
    }

    void searchUserGroup() {
        uiBean.setUserGroupInfo(null);

        List<AM_UserGroup> userGroups = baseManager.getUserGroupsSerchResult(uiBean.getUserGroupCd(),uiBean.getUserGroupNm());

        if(userGroups.size() == 0){
            messageManager.addMessageId(MessageId.IAC0021, MessageUtil.getMessage(UserGroupKensakuConstants.DDID_USERGROUPINFO_USERGROUPCD.getErrorResourceKey()));
            return;
        }

        if(userGroups.size() >= UserGroupKensakuConstants.SEARCH_MAX){
            messageManager.addMessageId(MessageId.IAC0022);
            return;
        }

        setSearchResult(userGroups);

    }


    private void setSearchResult(List<AM_UserGroup> pUserGroups) {

        uiBean.setUserGroupInfo(BeanUtil.createList(UserGroupInfoDataSourceBean.class, pUserGroups));


    }
}

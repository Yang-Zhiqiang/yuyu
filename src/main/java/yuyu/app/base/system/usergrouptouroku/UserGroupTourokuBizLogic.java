package yuyu.app.base.system.usergrouptouroku;

import static yuyu.app.base.system.usergrouptouroku.GenUserGroupTourokuConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.ConversationStatus;
import yuyu.common.base.UnknownForwardException;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_UserGroup;

/**
 * ユーザーグループ登録 のビジネスロジックです。
 */
public class UserGroupTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private UserGroupTourokuUiBean uiBean;

    @Inject
    private ConversationStatus status;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private MessageManager messageManager;

    void init() {
        clear();
    }

    void clear() {
        uiBean.setUserGroup(new AM_UserGroup());
    }

    void setupUiBeanUserGroup(){
        AM_UserGroup userGroup = baseDomManager.getUserGroup(uiBean.getUserGroup().getUserGroupCd());

        chkUserGroupInfo(userGroup);

        switch(status.getSyoriKbn()){
            case NEW:
                break;

            case EDIT:
            case DELETE:
                uiBean.setUserGroup(userGroup);
                break;

            default:
                throw new UnknownForwardException();
        }
    }


    @Transactional
    void commitUserGroup(){
        AM_UserGroup userGroup = uiBean.getUserGroup();

        switch(status.getSyoriKbn()){
            case NEW:
                baseDomManager.insert(userGroup);
                break;

            case EDIT:
                baseDomManager.update(userGroup);
                break;

            case DELETE:
                baseDomManager.delete(userGroup);
                break;

            default:
                throw new UnknownForwardException();
        }

        messageManager.addMessageId(MessageId.IAC0009);
    }


    void userGroupMessageInfo(){
        switch(status.getSyoriKbn()){
            case NEW:
                messageManager.addMessageId(MessageId.QAC0008);
                break;

            case EDIT:
                messageManager.addMessageId(MessageId.QAC0009);
                break;

            case DELETE:
                messageManager.addMessageId(MessageId.QAC0010);
                break;

            default:
                throw new UnknownForwardException();
        }
    }

    private void chkUserGroupInfo(AM_UserGroup pUserGroup){
        switch(status.getSyoriKbn()){
            case NEW:
                if(pUserGroup != null){
                    throw new BizLogicException(MessageId.EAC0002, DDID_USERGROUPINFO_USERGROUPCD);
                }
                break;

            case EDIT:
                chkExistUserGroup(pUserGroup);
                break;

            case DELETE:
                chkExistUserGroup(pUserGroup);

                if(baseDomManager.getUserByCountUserGroupCd(uiBean.getUserGroup().getUserGroupCd()) >= 1){
                    throw new BizLogicException(MessageId.EAC0003, DDID_USERGROUPINFO_USERGROUPCD);
                }
                break;

            default:
                throw new UnknownForwardException();
        }
    }


    private void chkExistUserGroup(AM_UserGroup pUserGroup){
        if(pUserGroup == null){
            throw new BizLogicException(MessageId.EAC0001, DDID_USERGROUPINFO_USERGROUPCD);
        }
    }
}

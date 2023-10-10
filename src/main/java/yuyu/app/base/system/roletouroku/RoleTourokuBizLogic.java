package yuyu.app.base.system.roletouroku;

import static yuyu.app.base.system.roletouroku.GenRoleTourokuConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.ConversationStatus;
import yuyu.common.base.UnknownForwardException;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SysSiyouKbn;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.AT_KinouKengen;

/**
 * ロール登録 のビジネスロジックです。
 */
public class RoleTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private RoleTourokuUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseDomManager manager;

    @Inject
    private ConversationStatus status;

    void init() {
        clear();
    }

    void clear() {
        uiBean.setRole(new AM_Role());
    }

    void setupUiBeanRole(){

        AM_Role role = manager.getRole(uiBean.getRole().getRoleCd());

        chkRoleInfo(role);

        switch (status.getSyoriKbn()) {

            case NEW:
                break;

            case EDIT:

                uiBean.setRole(role);
                break;

            case DELETE:

                uiBean.setRole(role);

                messageManager.addMessageId(MessageId.QAC0010);
                break;

            default:
                throw new UnknownForwardException();
        }
    }

    void roleTourokuMessageInfo(){

        switch (status.getSyoriKbn()) {
            case NEW:     messageManager.addMessageId(MessageId.QAC0008); break;
            case EDIT:    messageManager.addMessageId(MessageId.QAC0009); break;
            default:      throw new UnknownForwardException();
        }
    }

    @Transactional
    void commitRole(){

        AM_Role role = uiBean.getRole();

        switch (status.getSyoriKbn()) {

            case NEW:

                role.setSysSiyouKbn(C_SysSiyouKbn.TUUJYOU);
                manager.insert(role);
                break;

            case EDIT:

                manager.update(role);
                break;

            case DELETE:

                manager.delete(role);
                break;

            default:
                throw new UnknownForwardException();
        }

        messageManager.addMessageId(MessageId.IAC0009);

    }

    private void chkRoleInfo(AM_Role pRole){

        switch (status.getSyoriKbn()) {

            case NEW:

                if(pRole != null){
                    throw new BizLogicException(MessageId.EAC0002, DDID_KEYINFO_ROLECD);
                }

                break;

            case EDIT:

                chkExistRole(pRole);
                chkSystemRole(pRole);
                break;

            case DELETE:

                chkExistRole(pRole);
                chkSystemRole(pRole);

                if (manager.getCountUsersByRoleCd(pRole.getRoleCd()) > 0){
                    throw new BizLogicException(MessageId.EAC0003, DDID_KEYINFO_ROLECD);
                }

                List<AT_KinouKengen> kinoukengen = pRole.getKinouKengens();

                if (kinoukengen.size() > 0){
                    throw new BizLogicException(MessageId.EAC0003, DDID_KEYINFO_ROLECD);
                }

                break;

            default:
                throw new UnknownForwardException();
        }
    }

    private void chkExistRole(AM_Role pRole){

        if(pRole == null){
            throw new BizLogicException(MessageId.EAC0001, DDID_KEYINFO_ROLECD);
        }
    }

    private void chkSystemRole(AM_Role pRole){

        if (pRole.getSysSiyouKbn().eq(C_SysSiyouKbn.SYSSIYOU)){
            throw new BizLogicException(MessageId.EAF0025, DDID_KEYINFO_ROLECD);
        }
    }
}

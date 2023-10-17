package yuyu.app.base.menu.passwordhenkou;

import static yuyu.app.base.menu.passwordhenkou.GenPasswordHenkouConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.accesslog.AccessLog;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.security.InvalidPasswordException;
import jp.co.slcs.swak.util.security.SecurityPolicy;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_KyokaKbn;
import yuyu.def.db.entity.AM_User;

/**
 * パスワード変更 のビジネスロジックです。
 */
public class PasswordHenkouBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private PasswordHenkouUiBean uiBean;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private SecurityPolicy securityPolicy;

    @Inject
    private MessageManager messageManager;

    @Inject
    BaseDomManager baseDomManager;

    void init() {

        baseUserInfo.refresh();

        uiBean.setPasswordHenkouKyokaFlg(chkPasswordHenkou());

        if(!uiBean.getPasswordHenkouKyokaFlg()) {

            messageManager.addMessageId(MessageId.EAF0007) ;

        }
        else{
            uiBean.getUser().setUserNm(baseUserInfo.getUserNm());
        }
    }

    void clear() {
    }


    @Transactional
    void passwordHenkou() {
        errorCheck();
        updateUserPassword();

        messageManager.addMessageId(MessageId.IAC0009);
        uiBean.setPasswordKekka(MessageUtil.getMessage(MessageId.IAW0031));
    }


    private void errorCheck() {

        baseUserInfo.refresh();

        if(!chkPasswordHenkou()) {
            throw new BizLogicException(MessageId.EAF0007);
        }
        if(!baseUserInfo.getUser().getPassword().equals(uiBean.getOldPassword())) {
            throw new BizLogicException(MessageId.EAF0021, DDID_PASSWORDINPUT_OLDPASSWORD);
        }
        if(!uiBean.getPassword().equals(uiBean.getPasswordKakunin())){
            throw new BizLogicException(MessageId.EAF0022, DDID_PASSWORDINPUT_PASSWORDKAKUNIN,DDID_PASSWORDINPUT_PASSWORD);
        }
        try {
            securityPolicy.checkPassword(uiBean.getPassword(), baseUserInfo.getUserId());
        } catch (InvalidPasswordException e) {
            throw new BizLogicException(MessageId.EAC0049, new Item[]{DDID_PASSWORDINPUT_PASSWORD},e.getMessage());
        }

    }

    private void updateUserPassword() {
        AM_User user = baseDomManager.getUser(baseUserInfo.getUserId());
        user.setPassword(uiBean.getPassword());
        user.setPasswordSetteiYmd(BizDate.getSysDate());
        baseDomManager.update(user);
        AccessLog.PasswordAlter.log();
    }


    private boolean chkPasswordHenkou() {

        if(baseUserInfo.getUser().getPasswordHenkouKyokaKbn().eq(C_KyokaKbn.NONE)) {
            return false;
        }

        return true;
    }
}

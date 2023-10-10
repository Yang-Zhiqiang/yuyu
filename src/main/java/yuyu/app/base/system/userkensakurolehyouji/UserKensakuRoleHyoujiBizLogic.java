package yuyu.app.base.system.userkensakurolehyouji;

import static yuyu.app.base.system.userkensakurolehyouji.GenUserKensakuRoleHyoujiConstants.*;
import static yuyu.app.base.system.userkensakurolehyouji.UserKensakuRoleHyoujiConstants.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.base.result.bean.TaisyouUserAndUserRoleInfosByItemsBean;
import yuyu.def.biz.configuration.YuyuBizConfig;

import com.google.common.base.Strings;

/**
 * ユーザー検索（ロール表示用） のビジネスロジックです。
 */
public class UserKensakuRoleHyoujiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private UserKensakuRoleHyoujiUiBean uiBean;

    @Inject
    private BaseDomManager manager;

    @Inject
    private MessageManager messageManager;

    void init() {
        clear();
    }

    void clear() {
        uiBean.setUserAndUserRoleInfo(null);
    }

    void searchUser() {
        uiBean.setUserAndUserRoleInfo(null);

        if (Strings.isNullOrEmpty(uiBean.getUserId()) && Strings.isNullOrEmpty(uiBean.getUserNm()) &&
            Strings.isNullOrEmpty(uiBean.getSrchsosikicd())) {
            messageManager.addMessageId(MessageId.IAC0022);
            return;
        }

        if (!Strings.isNullOrEmpty(uiBean.getUserId()) && uiBean.getUserId().length() != 8) {
            throw new BizLogicException(MessageId.EAV1001, new Item[] { DDID_SEARCHINFO_USERID }
            , new String[] { DDID_SEARCHINFO_USERID.toString(), "8" });
        }
        if (!Strings.isNullOrEmpty(uiBean.getSrchsosikicd()) && uiBean.getSrchsosikicd().length() != 7) {
            throw new BizLogicException(MessageId.EAV1001, new Item[] { DDID_SEARCHINFO_SRCHSOSIKICD }
            , new String[] { DDID_SEARCHINFO_SRCHSOSIKICD.toString(), "7" });
        }
        if (!Strings.isNullOrEmpty(uiBean.getUserNm()) && Strings.isNullOrEmpty(uiBean.getSrchsosikicd())) {
            throw new BizLogicException(MessageId.EAC0027, DDID_SEARCHINFO_USERNM, DDID_SEARCHINFO_SRCHSOSIKICD);
        }

        List<String> sisyaAtukaiSosikiCdList = YuyuBizConfig.getInstance().getSisyaAtukaiSosikiCdList();

        String[] sisyaAtukaiSosikiCds = sisyaAtukaiSosikiCdList.toArray(new String[sisyaAtukaiSosikiCdList.size()]);

        List<String> sisyaReigaiSosikiCdList = YuyuBizConfig.getInstance().getSisyaReigaiSosikiCdList();

        String[] sisyaReigaiSosikiCds = sisyaReigaiSosikiCdList.toArray(new String[sisyaReigaiSosikiCdList.size()]);

        List<TaisyouUserAndUserRoleInfosByItemsBean> resultUserList = manager.getTaisyouUserAndUserRoleInfosByItems(
            uiBean.getUserId(), uiBean.getUserNm(), uiBean.getSrchsosikicd(),
            sisyaAtukaiSosikiCds, sisyaReigaiSosikiCds);

        if (resultUserList.isEmpty()) {
            messageManager.addMessageId(MessageId.IAC0021,
                MessageUtil.getMessage(DDID_USERANDUSERROLEINFO_USERID.getErrorResourceKey()));
            return;
        }

        if (resultUserList.size() > SEARCH_MAX) {
            messageManager.addMessageId(MessageId.IAC0022);
            return;
        }

        uiBean.setUserAndUserRoleInfo(BeanUtil.createList(UserAndUserRoleInfoDataSourceBean.class, resultUserList));
    }
}

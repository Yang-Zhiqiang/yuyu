package yuyu.app.base.system.userkensaku;

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
import yuyu.def.base.result.bean.TaisyouUserInfosByItemsBean;
import yuyu.def.biz.configuration.YuyuBizConfig;

import com.google.common.base.Strings;

/**
 * ユーザー検索 のビジネスロジックです。
 */
public class UserKensakuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private UserKensakuUiBean uiBean;

    @Inject
    private BaseDomManager manager;

    @Inject
    private MessageManager messageManager;

    void init() {
        clear();
    }

    void clear() {
        uiBean.setUserInfo(null);
    }

    void searchUser() {
        uiBean.setUserInfo(null);

        if(Strings.isNullOrEmpty(uiBean.getUserId()) && Strings.isNullOrEmpty(uiBean.getUserNm()) && Strings.isNullOrEmpty(uiBean.getSrchsosikicd())){
            messageManager.addMessageId(MessageId.IAC0022);
            return;
        }

        if (!Strings.isNullOrEmpty(uiBean.getUserId()) && uiBean.getUserId().length() != 8) {
            throw new BizLogicException(MessageId.EAV1001, new Item[]{GenUserKensakuConstants.DDID_SEARCHINFO_USERID}
            , new String[]{GenUserKensakuConstants.DDID_SEARCHINFO_USERID.toString(), "8"});
        }
        if (!Strings.isNullOrEmpty(uiBean.getSrchsosikicd()) && uiBean.getSrchsosikicd().length() != 7) {
            throw new BizLogicException(MessageId.EAV1001, new Item[]{GenUserKensakuConstants.DDID_SEARCHINFO_SRCHSOSIKICD}
            , new String[]{GenUserKensakuConstants.DDID_SEARCHINFO_SRCHSOSIKICD.toString(), "7"});
        }
        if(!Strings.isNullOrEmpty(uiBean.getUserNm()) && Strings.isNullOrEmpty(uiBean.getSrchsosikicd())){
            throw new BizLogicException(MessageId.EAC0027, GenUserKensakuConstants.DDID_SEARCHINFO_USERNM,
                GenUserKensakuConstants.DDID_SEARCHINFO_SRCHSOSIKICD);
        }

        List<String> sisyaAtukaiSosikiCdList = YuyuBizConfig.getInstance().getSisyaAtukaiSosikiCdList();

        String[] sisyaAtukaiSosikiCd = sisyaAtukaiSosikiCdList.toArray(new String[sisyaAtukaiSosikiCdList.size()]);

        List<String> sisyaReigaiSosikiCdList = YuyuBizConfig.getInstance().getSisyaReigaiSosikiCdList();

        String[] sisyaReigaiSosikiCd = sisyaReigaiSosikiCdList.toArray(new String[sisyaReigaiSosikiCdList.size()]);

        List<TaisyouUserInfosByItemsBean> resultUserList = manager.getTaisyouUserInfosByItems(
            uiBean.getUserId(), uiBean.getUserNm(), uiBean.getSrchsosikicd(),sisyaAtukaiSosikiCd,sisyaReigaiSosikiCd);

        if (resultUserList.isEmpty()) {
            messageManager.addMessageId(MessageId.IAC0021, MessageUtil.getMessage(
                UserKensakuConstants.DDID_USERINFO_USERID.getErrorResourceKey()));
            return;
        }

        if (resultUserList.size() > UserKensakuConstants.SEARCH_MAX) {
            messageManager.addMessageId(MessageId.IAC0022);
            return;
        }

        uiBean.setUserInfo(BeanUtil.createList(UserInfoDataSourceBean.class, resultUserList));

    }
}

package yuyu.app.base.system.rolekensaku;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_Role;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * ロール検索 のビジネスロジックです。
 */
public class RoleKensakuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private RoleKensakuUiBean uiBean;

    @Inject
    private BaseDomManager manager;

    @Inject
    private MessageManager messageManager;

    void init() {
        clear();
    }

    void clear() {
        uiBean.setRoleCd(null);
        uiBean.setRoleNm(null);
    }

    void searchRole() {
        uiBean.setRoleInfo(null);

        String RoleCd = uiBean.getRoleCd();
        String RoleNm = uiBean.getRoleNm();

        List<AM_Role> allRole = manager.getAllRoles();
        List<AM_Role> resultRoleList = ImmutableList.copyOf(Iterables.filter(allRole, new RoleEntityPredicate(RoleCd, RoleNm)));

        if (resultRoleList.isEmpty()) {
            messageManager.addMessageId(MessageId.IAC0021, MessageUtil.getMessage(RoleKensakuConstants.DDID_ROLEINFO_ROLECD.getErrorResourceKey()));
            return;
        }

        if (resultRoleList.size() >= RoleKensakuConstants.SEARCH_MAX) {
            messageManager.addMessageId(MessageId.IAC0022);
            return;
        }

        uiBean.setRoleInfo(BeanUtil.createList(RoleInfoDataSourceBean.class, resultRoleList));

    }

}

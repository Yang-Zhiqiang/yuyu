package yuyu.app.base.menu.menu;


import javax.inject.Inject;

import jp.co.slcs.swak.core.aop.TraceInterceptor;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import lombok.val;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.inject.UserProvider;
import yuyu.def.db.entity.AS_Kinou;

import com.google.common.base.Predicate;

/**
 * 現在のログインユーザーの権限でメニューに表示できる機能だけを抽出するためのフィルター(の述部)です。
 */
class MenuAuthFilter implements Predicate<AS_Kinou> {

    private static Logger logger = LoggerFactory.getLogger(MenuAuthFilter.class);

    private final BaseUserInfo user;

    @Inject
    MenuAuthFilter(BaseUserInfo pUser) {
        user = pUser;
        logger.debug("◇ user = {}({})", user.getUserId(), user.getUserNm());

        if (! logger.isTraceEnabled()) {
            return;
        }

        TraceInterceptor.incrementNestingLevel();
        try {
            for (val userRole : user.getUser().getUserRoles()) {
                logger.trace(
                    "{}({})",
                    userRole.getRoleCd(),
                    userRole.getRole().getRoleNm()
                    );
            }
        } finally {
            TraceInterceptor.decrementNestingLevel();
        }
        logger.trace("△");
    }

    @Override
    public boolean apply(AS_Kinou pKinou) {

        if (logger.isTraceEnabled()) {
            logger.trace("◇ kinou = {}", pKinou);
            TraceInterceptor.incrementNestingLevel();
            logger.trace("△");

            logger.trace("◇ user = {}", user);
            TraceInterceptor.incrementNestingLevel();
            try {
                for (val userRole : user.getUser().getUserRoles()) {
                    logger.trace(" role = {}", userRole.getRole());
                }
            } finally {
                TraceInterceptor.decrementNestingLevel();
            }
            logger.trace("△");
        }

        return user.hasAuthenticatedFunction(pKinou);

    }

}

package yuyu.app.base.menu.menu;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.aop.TraceInterceptor;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.auth.LoginManager;
import jp.co.slcs.swak.web.conversation.ConversationContext;
import lombok.val;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AT_MyMenu;
import yuyu.infr.auth.LoginUser;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Ordering;

/**
 * メニュー のビジネスロジックです。
 */
public class MenuBizLogic {

    @Inject
    private static Logger logger;

    private final MenuUiBean uiBean;

    private final LoginManager   loginManager;

    private final MenuAuthFilter menuAuthFilter;

    private final BaseDomManager domManager;

    private final LoginUser loginUser;

    private final BaseUserInfo loginUserInfo;

    @Inject
    MenuBizLogic(
        MenuUiBean     pUiBean,
        LoginManager   pLoginManager,
        MenuAuthFilter pMenuAuthFilter,
        BaseDomManager pDomManager,
        LoginUser      pLoginUser,
        BaseUserInfo   pLoginUserInfo
        ) {
        uiBean         = pUiBean;
        loginManager   = pLoginManager;
        menuAuthFilter = pMenuAuthFilter;
        domManager     = pDomManager;
        loginUser      = pLoginUser;
        loginUserInfo  = pLoginUserInfo;
    }

    public void createMenu() {

        if (loginUserInfo.getUser().getUserRoles().size() == 0) {
            ConversationContext.endConversation();

            throw new BizLogicException(MessageId.EAF0056,
                MessageUtil.getMessage(MessageId.IAW0034),
                MessageUtil.getMessage(MessageId.IAW0037));
        }

        val menuHyoujiKinous = Iterables.filter(
            domManager.getAllKinous(),
            menuHyoujiFilter
            );

        if (! Iterables.any(menuHyoujiKinous, menuAuthFilter)) {
            ConversationContext.endConversation();

            throw new BizLogicException(MessageId.EAF0057,
                MessageUtil.getMessage(MessageId.IAW1001));
        }

        uiBean.setMenuContents(
            ImmutableList.copyOf(
                Iterables.transform(
                    menuOrder.sortedCopy(
                        Iterables.filter(
                            menuHyoujiKinous,
                            menuAuthFilter
                            )
                        ),
                        kinouToMenuDsConverter
                    )
                )
            );

        createMyMenu();

        logger.debug("◇ kinous.size = {}", Integer.valueOf(uiBean.getMenuContentsDataSource().size()));
        if (logger.isTraceEnabled()) {
            TraceInterceptor.incrementNestingLevel();
            try {
                for (val menuContent : uiBean.getMenuContentsDataSource().getAllData()) {
                    logger.trace("{}", BeanUtil.toString(menuContent));
                }
            } finally {
                TraceInterceptor.decrementNestingLevel();
            }
        }
        logger.debug("◇ myMenus.size = {}", Integer.valueOf(uiBean.getMyMenuContentsDataSource().size()));
        if (logger.isTraceEnabled()) {
            TraceInterceptor.incrementNestingLevel();
            try {
                for (val myMenuContent : uiBean.getMyMenuContentsDataSource().getAllData()) {
                    logger.trace("{}", BeanUtil.toString(myMenuContent));
                }
            } finally {
                TraceInterceptor.decrementNestingLevel();
            }
        }
        logger.trace("△");
    }

    public void close() {
        if (loginManager != null) {
            loginManager.logout();
        }
    }

    @Transactional
    public void registerMyMenu() {
        val menuContents = uiBean.getMenuContentsDataSource().getAllData();

        logger.debug("◇ MenuBizLogic # registerMyMenu()");
        if (logger.isTraceEnabled()) {
            for (val menuContent : menuContents) {
                logger.trace(
                    "│kinouId={}, checked={}",
                    Strings.padEnd(menuContent.getKinouId(), 40, ' '),
                    menuContent.getCommonCheckBox()
                    );
            }
            logger.trace("△");
        }

        AM_User user = domManager.getUser(loginUser.getUserId());

        val currentMyMenus = ImmutableList.copyOf(user.getMyMenus());
        logger.debug("◇ Current MyMenus (size={})", Integer.valueOf(currentMyMenus.size()));
        if (logger.isTraceEnabled()) {
            for (val myMenu : currentMyMenus) {
                logger.trace("│{}", myMenu);
            }
            logger.trace("△");
        }

        val removedMyMenuPartition = Multimaps.index(
            currentMyMenus,
            new Function<AT_MyMenu, Integer>() {
                @Override
                public Integer apply(AT_MyMenu pMyMenu) {
                    for (val menuContent : menuContents) {
                        if (menuContent.getKinouId().equals(pMyMenu.getKinouId())) {
                            return menuContent.getCommonCheckBox().booleanValue() ? Integer.valueOf(1) : Integer.valueOf(0);
                        }
                    }
                    return Integer.valueOf(0);
                }
            }
            );
        val removedMyMenus  = removedMyMenuPartition.get(Integer.valueOf(0));
        val remainedMyMenus = removedMyMenuPartition.get(Integer.valueOf(1));

        val addedMyMenus = Collections2.transform(
            Collections2.filter(
                menuContents,
                new AddedMyMenuPredicate(remainedMyMenus)
                ),
                new MenuDsBeanToMyMenuConverter(loginUser)
            );

        user.getMyMenus().removeAll(removedMyMenus);
        user.getMyMenus().addAll(addedMyMenus);

        logger.debug("◇ Removed MyMenus (size={})", Integer.valueOf(removedMyMenus.size()));
        if (logger.isTraceEnabled()) {
            for (val myMenu : removedMyMenus) {
                logger.trace("│{}", myMenu);
            }
            logger.trace("△");
        }

        logger.debug("◇ Remained MyMenus (size={})", Integer.valueOf(remainedMyMenus.size()));
        if (logger.isTraceEnabled()) {
            for (val myMenu : remainedMyMenus) {
                logger.trace("│{}", myMenu);
            }
            logger.trace("△");
        }

        logger.debug("◇ Added MyMenus (size={})", Integer.valueOf(addedMyMenus.size()));
        if (logger.isTraceEnabled()) {
            for (val myMenu : addedMyMenus) {
                logger.trace("│{}", myMenu);
            }
            logger.trace("△");
        }

        logger.debug("◇ New MyMenus (size={})", Integer.valueOf(user.getMyMenus().size()));
        if (logger.isTraceEnabled()) {
            for (val myMenu : user.getMyMenus()) {
                logger.trace("│{}", myMenu);
            }
            logger.trace("△");
        }

        domManager.update(user);

        createMyMenu(user.getMyMenus());
    }

    private void createMyMenu() {
        createMyMenu(domManager.getUser(loginUser.getUserId()).getMyMenus());
    }

    private void createMyMenu(Iterable<AT_MyMenu> pMyMenus) {
        val menuContents = uiBean.getMenuContentsDataSource().getAllData();
        uiBean.setMyMenuContents(
            ImmutableList.copyOf(
                Iterables.transform(
                    new MyMenuOrder(menuContents).sortedCopy(
                        Iterables.filter(
                            pMyMenus,
                            new ValidMyMenuFilter(menuContents)
                            )
                        ),
                        myMenuToDsBeanConverter
                    )
                )
            );
    }

    private static final Ordering<AS_Kinou> menuOrder = new Ordering<AS_Kinou>() {
        @Override
        public int compare(AS_Kinou pKinou1, AS_Kinou pKinou2) {
            int result;

            result = pKinou1.getSubSystem().getSortNo().intValue() -
                pKinou2.getSubSystem().getSortNo().intValue();
            if (result != 0) {
                return result;
            }

            result = pKinou1.getCategory().getSortNo().intValue() -
                pKinou2.getCategory().getSortNo().intValue();
            if (result != 0) {
                return result;
            }

            return pKinou1.getSortNo().intValue() -
                pKinou2.getSortNo().intValue();
        }
    };

    private static class MyMenuOrder extends Ordering<AT_MyMenu> {
        private final Iterable<MenuContentsDataSourceBean> menuContents;

        MyMenuOrder(Iterable<MenuContentsDataSourceBean> pMenuContents) {
            menuContents = pMenuContents;
        }

        @Override
        public int compare(AT_MyMenu pLeft, AT_MyMenu pRight) {
            int leftIndex  = -1;
            int rightIndex = -1;
            int i          =  0;
            for (Iterator<MenuContentsDataSourceBean> iterator = menuContents.iterator(); iterator.hasNext(); i++) {
                MenuContentsDataSourceBean menuContent = iterator.next();
                if (menuContent.getKinouId().equals(pLeft.getKinouId())) {
                    leftIndex = i;
                    if (rightIndex >= 0) {
                        break;
                    }
                }
                if (menuContent.getKinouId().equals(pRight.getKinouId())) {
                    rightIndex = i;
                    if (leftIndex >= 0) {
                        break;
                    }
                }
            }
            return leftIndex - rightIndex;
        }
    }

    private static final Predicate<AS_Kinou> menuHyoujiFilter = new Predicate<AS_Kinou>() {
        @Override
        public boolean apply(AS_Kinou pKinou) {
            return pKinou.getMenuHyoujiKahi().eq(C_KahiKbn.KA);
        }
    };

    private static final Function<AS_Kinou, MenuContentsDataSourceBean> kinouToMenuDsConverter =
        new Function<AS_Kinou, MenuContentsDataSourceBean>() {
        @Override
        public MenuContentsDataSourceBean apply(AS_Kinou pKinou) {
            MenuContentsDataSourceBean dsBean = new MenuContentsDataSourceBean();
            BeanUtil.copyProperties(dsBean, pKinou);
            dsBean.setSubSystemNm(pKinou.getSubSystem().getSubSystemNm());
            dsBean.setCategoryNm (pKinou.getCategory().getCategoryNm());
            dsBean.setCommonCheckBox(Boolean.FALSE);
            return dsBean;
        }
    }
    ;

    private static final Function<AT_MyMenu, MyMenuContentsDataSourceBean> myMenuToDsBeanConverter =
        new Function<AT_MyMenu, MyMenuContentsDataSourceBean>() {
        @Override
        public MyMenuContentsDataSourceBean apply(AT_MyMenu pMyMenu) {
            MyMenuContentsDataSourceBean dsBean = new MyMenuContentsDataSourceBean();
            dsBean.setKinouId(
                String.format(
                    "%s.%s.%s",
                    pMyMenu.getSubSystemId(),
                    pMyMenu.getCategoryId(),
                    pMyMenu.getKinouId()
                    )
                );
            return dsBean;
        }
    }
    ;

    private static class AddedMyMenuPredicate implements Predicate<MenuContentsDataSourceBean> {
        private final Iterable<AT_MyMenu> myMenuList;

        AddedMyMenuPredicate(Iterable<AT_MyMenu> pMyMenuList) {
            myMenuList = pMyMenuList;
        }

        @Override
        public boolean apply(final MenuContentsDataSourceBean pMenuDsBean) {
            if (pMenuDsBean.getCommonCheckBox().equals(Boolean.FALSE)) {
                return false;
            }
            return Iterables.all(
                myMenuList,
                new Predicate<AT_MyMenu>() {

                    @Override
                    public boolean apply(AT_MyMenu pMyMenu) {
                        return ! pMyMenu.getKinouId().equals(pMenuDsBean.getKinouId());
                    }
                }
                );
        }
    }

    private static class MenuDsBeanToMyMenuConverter implements Function<MenuContentsDataSourceBean, AT_MyMenu> {
        private final LoginUser loginUser;

        MenuDsBeanToMyMenuConverter(LoginUser pLoginUser) {
            loginUser = pLoginUser;
        }

        @Override
        public AT_MyMenu apply(MenuContentsDataSourceBean pMenuDsBean) {
            val myMenu = new AT_MyMenu(loginUser.getUserId(), pMenuDsBean.getKinouId());
            myMenu.setSubSystemId(pMenuDsBean.getSubSystemId());
            myMenu.setCategoryId(pMenuDsBean.getCategoryId());
            return myMenu;
        }
    }

    private static class ValidMyMenuFilter implements Predicate<AT_MyMenu> {
        private final Iterable<MenuContentsDataSourceBean> menuContents;

        ValidMyMenuFilter(Iterable<MenuContentsDataSourceBean> pMenuContents) {
            menuContents = pMenuContents;
        }

        @Override
        public boolean apply(AT_MyMenu pInput) {
            for (val bean : menuContents) {
                if (bean.getKinouId().equals(pInput.getKinouId())) {
                    bean.setCommonCheckBox(Boolean.TRUE);
                    return true;
                }
            }
            return false;
        }
    }
}

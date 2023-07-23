package yuyu.infr.inject;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;

import jp.co.slcs.swak.bizinfr.configuration.BizInfrConfig;
import jp.co.slcs.swak.core.aop.TraceInterceptor;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.web.action.ActionProvider;
import jp.co.slcs.swak.web.test.MockHttpServletRequest;
import lombok.val;

import org.slf4j.Logger;

import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AS_Kinou;

import com.google.common.base.Strings;

/**
 * yuyuseiho プロジェクト用の {@link AS_Kinou 機能Entity(AS_Kinou)} Provider です。<br />
 * この Provider を利用すると、業務プログラム内で「現在実行中である業務機能の機能Entity」が Inject 可能となります。<br />
 */
public class KinouProvider implements Provider<AS_Kinou> {

    private static final Logger logger = LoggerFactory.getLogger(KinouProvider.class);

    private static final int KINOU_ID_MAX_LENGTH = 50;

    private final ActionProvider     actionProvider;
    private final HttpServletRequest request;
    private final YuyuBaseConfig     yuyuBaseConfig;
    private final BaseDomManager     domManager;

    @Deprecated
    @Inject
    public KinouProvider(
        ActionProvider     pActionProvider,
        HttpServletRequest pRequest,
        YuyuBaseConfig     pYuyuBaseConfig,
        BaseDomManager     pDomManager
    ) {
        if (logger.isTraceEnabled()) {
            logger.trace(
                "◇ KinouProvider construct({}, {}{}, ...)",
                new Object[] {
                    pActionProvider.getActionClass(),
                    pRequest.getRequestURI(),
                    Strings.isNullOrEmpty(pRequest.getQueryString()) ? "" : "?" + pRequest.getQueryString()
                }
            );
        }
        actionProvider   = pActionProvider;
        request          = pRequest;
        yuyuBaseConfig   = pYuyuBaseConfig;
        domManager       = pDomManager;
    }

    @Override
    public AS_Kinou get() {
        if (logger.isTraceEnabled()) {
            logger.trace("▽ KinouProvider # get()");
            TraceInterceptor.incrementNestingLevel();
        }
        try {
            String   kinouPackage = null;
            String   kinouId      = null;
            Class<?> actionClass  = null;

            if (request instanceof MockHttpServletRequest) {
                actionClass = SWAKInjector.getInstance(Class.class, "TestClass");
                kinouPackage = actionClass.getPackage().getName();
                kinouId = actionClass.getSimpleName();
                if (kinouId.length() > KINOU_ID_MAX_LENGTH) {
                    kinouId = kinouId.substring(0, KINOU_ID_MAX_LENGTH);
                }

                AS_Kinou kinou = new AS_Kinou(kinouId);
                String[] packages = kinouPackage.split("\\.");
                if (packages.length >= 1) { kinou.setCategoryId (packages[packages.length - 1]); }
                if (packages.length >= 2) { kinou.setSubSystemId(packages[packages.length - 2]); }
                kinou.setKinouNm("JUnitテスト - " + kinouId);
                kinou.setKinouSetumei("JUnit用の単体テストです。");
                return kinou;
            } else {
                val method = actionProvider.getEventHandlerMethod();
                for (val tk : yuyuBaseConfig.getTokusyuKinouList()){
                    if ((tk.getActionClass() != null) &&
                        method.getDeclaringClass().equals(tk.getActionClass()) &&
                        method.getName().equals(tk.getInitMethod())
                    ) {
                        kinouPackage = tk.getActionClass().getPackage().getName();
                        kinouId      = tk.getKinouId();
                        actionClass  = method.getDeclaringClass();
                        break;
                    }
                }
            }

            if (kinouId == null) {
                val appRootPackage = BizInfrConfig.instance.getAppRootPackage();
                actionClass  = actionProvider.getActionClass();
                kinouPackage = actionClass.getPackage().getName();
                if (! kinouPackage.startsWith(appRootPackage)) {
                    throw new RuntimeException("Package '" + kinouPackage + "' is not supported.");
                }
                logger.trace(" kinouPackage = {}", kinouPackage);

                val packages = kinouPackage.substring(appRootPackage.length()).split("\\.");
                kinouId = packages[packages.length - 1];
            }

            AS_Kinou kinou = domManager.getKinou(kinouId);

            if (kinou == null) {

                kinou = new AS_Kinou(kinouId);
                if (actionClass != null) {
                    String[] packages = actionClass.getPackage().getName().split("\\.");
                    if (packages.length >= 2) { kinou.setCategoryId (packages[packages.length - 2]); }
                    if (packages.length >= 3) { kinou.setSubSystemId(packages[packages.length - 3]); }
                }
                kinou.setKinouNm("未定義機能(" + kinouPackage + ")");
            } else {
                kinou.detach();
            }
            logger.debug("◇ 機能名 = {}", kinou.getKinouNm());

            return kinou;
        } finally {
            if (logger.isTraceEnabled()) {
                TraceInterceptor.decrementNestingLevel();
                logger.trace("△");
            }
        }

    }

}

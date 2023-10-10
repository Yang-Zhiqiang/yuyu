package yuyu.app.base.menu.login;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.accesslog.AccessLog;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.security.SecurityPolicy;
import jp.co.slcs.swak.web.auth.LoginFailedException;
import jp.co.slcs.swak.web.auth.LoginManager;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_KyokaKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.infr.auth.RayBCPBean;
import yuyu.infr.auth.RayCreator;
import yuyu.infr.auth.RayHttpHeaderBean;
import yuyu.infr.auth.RayHttpHeaderHolder;
import yuyu.infr.auth.YuyuAuthMode;
import yuyu.infr.auth.YuyuAuthMode.E_AuthMode;

import com.google.common.base.Optional;
import com.google.inject.Injector;

/**
 * ログイン のビジネスロジックです。
 */
public class LoginBizLogic {

    @Inject
    private LoginUiBean uiBean;

    @Inject
    @Nullable
    private LoginManager loginManager;

    @Inject
    private YuyuAuthMode authMode;

    @Inject
    private BaseDomManager baseDom;

    @Inject
    private SecurityPolicy securityPolicy;

    @Inject
    private Injector injector;

    boolean init() {
        if (loginManager.isSessionTimeout()) {
            return false;
        }

        RayCreator.create();

        RayHttpHeaderBean headerBean = SWAKInjector.getInstance(RayHttpHeaderBean.class);
        uiBean.setTanmatusettisosikicd(headerBean.getTmSosikiCd());

        return true;
    }

    boolean loginForBCP(){
        if(RayCreator.chkAuthInfoIsEmpty()){
            return false;
        }

        RayBCPBean bcpBean = SWAKInjector.getInstance(RayBCPBean.class);

        bcpBean.setDaikouSosikiCd(uiBean.getTanmatusettisosikicd());
        bcpBean.setBcp(true);

        return login();
    }

    //              ┌ dontRollbackOn について。
    //              │   ログイン失敗時は BizLogicException が throw されるが、
    //              │   その場合でも ログイエラー回数 を増やして AM_User を更新しなければならない。
    //              │   よって BizLogicException では rollback せず、 commit する。
    //              ↓   その他の例外発生時は自動 rollback される。
    @Transactional(dontRollbackOn = BizLogicException.class)
    boolean login() {
        authMode.setAuthMode(E_AuthMode.USER);

        RayHttpHeaderBean headerBean = SWAKInjector.getInstance(RayHttpHeaderBean.class);

        RayCreator.create();

        String userId = headerBean.getIdKind() + headerBean.getPersonCd();

        SWAKInjector.getInstance(RayHttpHeaderHolder.class).setRayHeaderBean(headerBean);

        try {

            boolean loginSuccessful = loginManager.login(userId, null);

            BaseUserInfo userInfo = injector.getInstance(BaseUserInfo.class); // ← ※ BaseUserInfo は、このタイミング (loginManager.login() を通過した後) でないと取得できない。
            // ※ BaseUserInfo をメンバインジェクションにしてしまうと、
            //    インジェクト段階ではまだ「ログインしていない(このビジネスロジックの中でログインする)」ため、
            //    正しい Credentials が取れず、落ちる。ただし、BaseUserInfo をメンバインジェクションできないのは
            //    この「ログイン」機能のみで、通常の業務機能ならばメンバインジェクションで良い。

            AM_User user = baseDom.getUser(userId);

            // ユーザー存在チェック
            if(user == null){
                throw new LoginFailedException();
            }

            if (Optional.of(user.getLoginErrorCount()).or(Integer.valueOf(0)).intValue() != 0) {
                user.setLoginErrorCount(Integer.valueOf(0));
            }
            //            if (user.getLoginErrorCount() != 0) {  // LoginFailedException の catch ブロックの中ではnullチェックしてたけど、ここではしてない。
            //                user.setLoginErrorCount(0);        // AutoBoxing 使っちゃってるから気づいてないかもしれないけど、user.getLoginErrorCount() の
            //            }                                      // Integer が null だったら、NullPointerException で落ちるよ。

            userInfo.setZenkaiLoginTime(user.getLastLoginTime());

            user.setLastLoginTime(BizDate.getSysDateTimeMilli());
            baseDom.update(user);

            return loginSuccessful;
        } catch (LoginFailedException lfe) {
            if (securityPolicy.getLockoutCount() > 0) {
                AM_User user = baseDom.getUser(userId);
                if (user != null && user.getLoginKyokaKbn().eq(C_KyokaKbn.KYOKA)) {
                    int errorCount = Optional.fromNullable(user.getLoginErrorCount()).or(Integer.valueOf(0)).intValue() + 1;
                    user.setLoginErrorCount(Integer.valueOf(errorCount));
                    //                    Integer errorCount = user.getLoginErrorCount();
                    //                    if (errorCount == null) {
                    //                        errorCount = 1;
                    //                    } else {
                    //                        errorCount = errorCount + 1;
                    //                    }
                    //                    user.setLoginErrorCount(errorCount);

                    if (errorCount >= securityPolicy.getLockoutCount()) {
                        user.setLoginKyokaKbn(C_KyokaKbn.NONE);
                        AccessLog.Lockout.log(userId);
                    }
                    baseDom.update(user);
                }
            }

            return false;
        }
    }
}

package yuyu.infr.web;

import javax.servlet.http.HttpSessionEvent;

import jp.co.slcs.swak.web.servlet.SessionListener;

/**
 * Yuyuセッションリスナー<br />
 */
public class YuyuSessionListener extends SessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        super.sessionCreated(se);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        super.sessionDestroyed(se);
    }

}

package yuyu.infr.inject;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;

import com.google.common.base.Strings;

/**
 * HttpServletRequest.requestURI の Provider です。<br />
 * 取得できるのは String の requestURI なので、&#64;{@link Named} アノテーションとともに利用してください。<br />
 * (Inject可能な)クラスに以下のようなメンバを宣言すれば
 * 「Conversation が開始される時のリクエストURI」を取得することができます。
 */
public class RequestUriProvider implements Provider<String> {

    public static final String BIND_NAME = "requestURI";

    private final HttpServletRequest request;

    @Deprecated
    @Inject
    public RequestUriProvider(HttpServletRequest pRequest) {
        request = pRequest;
    }

    @Override
    public String get() {
        String uri = request.getRequestURI();
        if (! Strings.isNullOrEmpty(request.getQueryString())) {
            uri += "?" + request.getQueryString();
        }
        return uri;
    }

}

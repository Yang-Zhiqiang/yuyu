package yuyu.infr.auth;

import com.google.inject.servlet.SessionScoped;

/**
 * {@link RayHttpHeaderBean}のモッククラスです。<br />
 */
@SessionScoped
public class RayHttpHeaderBeanMock_EditTtdkRirekiTbl extends RayHttpHeaderBean {

    private static final long serialVersionUID = 1L;

    @Override
    public String getTmSosikiCd() {

        return "0010001";

    }
}

package yuyu.infr.auth;

import yuyu.common.workflowcore.WorkflowAuthInfoTest;

import com.google.inject.servlet.SessionScoped;

/**
 * {@link RayHttpHeaderBean}のモッククラスです。<br />
 */
@SessionScoped
public class RayHttpHeaderBeanMock extends RayHttpHeaderBean {

    private static final long serialVersionUID = 1L;

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    @Override
    public String getTmSosikiCd() {

        if (caller == WorkflowAuthInfoTest.class
            && TESTPATTERN1.equals(SYORIPTN)) {
            return "000";

        }
        return super.getTmSosikiCd();

    }
}

package yuyu.testinfr.inject;

import jp.co.slcs.swak.auth.Credentials;

/**
 * JUnitテスト用の モックCredentials です。<br />
 * この Credentials の username は常に "JUnit" となります。
 */
public class MockCredentials extends Credentials {

    private static final long serialVersionUID = 2569757887081974073L;

    @Override
    public String getUsername() {
        return "JUnit";
    }
}

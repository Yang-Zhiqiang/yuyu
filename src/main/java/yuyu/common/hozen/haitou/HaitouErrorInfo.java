package yuyu.common.hozen.haitou;

/**
 * 契約保全 契約保全共通 配当エラー情報
 */
public class HaitouErrorInfo {

    private final String kinouId;

    private final String errorInfo1;

    private final String errorInfo2;

    public HaitouErrorInfo(String pKinouId, String pErrorInfo1, String pErrorInfo2) {
        kinouId = pKinouId;
        errorInfo1 = pErrorInfo1;
        errorInfo2 = pErrorInfo2;
    }

    public String getKinouId() {
        return kinouId;
    }

    public String getErrorInfo1() {
        return errorInfo1;
    }

    public String getErrorInfo2() {
        return errorInfo2;
    }
}

package yuyu.common.biz.bzunyo;

import java.io.Serializable;

/**
 * 業務共通 運用 テストデータ抽出用ファイルユーティリティBeanクラス
 */
public class BzTestDataExportFileUtilBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean result;

    private String count;

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean pResult) {
        result = pResult;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String pCount) {
        count = pCount;
    }
}

package yuyu.common.hozen.haitou;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 契約保全 契約保全共通 配当エラー処理インターフェース
 */
public interface HaitouErrorProcess {

    public void regErrorInfo(String pErrorCode, String pErrorInfo1, String pErrorInfo2);

    public Set<Map.Entry<String, HaitouErrorInfo>> getAllErrorCode();

    public void clear();

    public void setErrorInfo(String pErrorCode);

    public void setErrorLink(HaitouErrorProcess pErrorProcess);

    public List<HaitouErrorInfo> getErrorInfo();
}

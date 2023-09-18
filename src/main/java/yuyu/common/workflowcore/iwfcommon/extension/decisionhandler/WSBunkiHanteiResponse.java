package yuyu.common.workflowcore.iwfcommon.extension.decisionhandler;

import javax.annotation.Generated;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * ファイルレイアウトのBeanです。<br/>
 * このソースは全てツールから吐き出されています。<br />
 * 編集する必要がある場合は、別クラスとして新規作成してください。
 */
@Generated("このソースは全てツールから吐き出されています。")
@SuppressWarnings("serial")
public class WSBunkiHanteiResponse extends WSCommonResponse {

    private String sHanteikekka_;

    @JSONHint(name=IWSBunkiHanteiIOKey.OUT.sS_HANTEIKEKKA)
    public String getHanteikekka() {
        return sHanteikekka_;
    }

    public void setHanteikekka(String psHanteikekka) {
        sHanteikekka_ = psHanteikekka;
    }

}

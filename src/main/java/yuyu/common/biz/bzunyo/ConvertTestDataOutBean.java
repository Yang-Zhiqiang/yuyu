package yuyu.common.biz.bzunyo;

import java.io.Serializable;

/**
 * 業務共通 共通 テストデータ変換出力Beanクラス
 */
public class ConvertTestDataOutBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private String syoNo;

    private String kbnKey;

    public String getTestSyono() {
        return syoNo;
    }

    public void setTestSyono(String pSyoNo){
        syoNo = pSyoNo ;
    }

    public String getKbnKey() {
        return kbnKey;
    }

    public void setKbnKey(String pKbnKey) {
        kbnKey = pKbnKey;
    }
}
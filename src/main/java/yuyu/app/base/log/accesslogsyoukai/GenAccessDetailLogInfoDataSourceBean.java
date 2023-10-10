package yuyu.app.base.log.accesslogsyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;

/**
 * アクセスログ照会 - ●アクセス詳細ログ情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenAccessDetailLogInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long syousaiEdaNo;

    public Long getSyousaiEdaNo() {
        return syousaiEdaNo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyousaiEdaNo(Long pSyousaiEdaNo) {
        syousaiEdaNo = pSyousaiEdaNo;
    }


    private String logSyousaiData;

    public String getLogSyousaiData() {
        return logSyousaiData;
    }

    @Trim("both")
    public void setLogSyousaiData(String pLogSyousaiData) {
        logSyousaiData = pLogSyousaiData;
    }

}

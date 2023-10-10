package yuyu.app.base.log.accesslogsyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * アクセスログ照会 - ●アクセスログ情報リスト の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenAccessLogInfoListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoriTime;

    public String getSyoriTime() {
        return syoriTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriTime(String pSyoriTime) {
        syoriTime = pSyoriTime;
    }


    private String syoriUserId;

    public String getSyoriUserId() {
        return syoriUserId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriUserId(String pSyoriUserId) {
        syoriUserId = pSyoriUserId;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String userNm;

    public String getUserNm() {
        return userNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUserNm(String pUserNm) {
        userNm = pUserNm;
    }


    private C_AccessLogSyubetuKbn logKindCd;

    public C_AccessLogSyubetuKbn getLogKindCd() {
        return logKindCd;
    }

    public void setLogKindCd(C_AccessLogSyubetuKbn pLogKindCd) {
        logKindCd = pLogKindCd;
    }


    private String ipAddress;

    public String getIpAddress() {
        return ipAddress;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIpAddress(String pIpAddress) {
        ipAddress = pIpAddress;
    }


    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSessionId(String pSessionId) {
        sessionId = pSessionId;
    }


    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTransactionId(String pTransactionId) {
        transactionId = pTransactionId;
    }


    private String subSystemNm;

    public String getSubSystemNm() {
        return subSystemNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSubSystemNm(String pSubSystemNm) {
        subSystemNm = pSubSystemNm;
    }


    private String kinouNm;

    public String getKinouNm() {
        return kinouNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKinouNm(String pKinouNm) {
        kinouNm = pKinouNm;
    }


    private String syousaiLink;

    public String getSyousaiLink() {
        return syousaiLink;
    }

    public void setSyousaiLink(String pSyousaiLink) {
        syousaiLink = pSyousaiLink;
    }


    private String logData;

    public String getLogData() {
        return logData;
    }

    @Trim("both")
    public void setLogData(String pLogData) {
        logData = pLogData;
    }

}

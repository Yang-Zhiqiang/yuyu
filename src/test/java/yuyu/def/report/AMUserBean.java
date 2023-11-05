package yuyu.def.report;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KyokaKbn;
import yuyu.def.classification.C_PasswordYuukouKikanKbn;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.classification.C_YoukyuuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * ユーザーマスタ のテーブルマッピングBeanです。<br />
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public class AMUserBean implements IReportDataSouceBean {


    public AMUserBean() {
    }

    public AMUserBean(String pUserId) {
        userId = pUserId;
    }

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }

    private String userNm;

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String pUserNm) {
        userNm = pUserNm;
    }

    private C_SpecialUserKbn specialUserKbn;

    public C_SpecialUserKbn getSpecialUserKbn() {
        return specialUserKbn;
    }

    public void setSpecialUserKbn(C_SpecialUserKbn pSpecialUserKbn) {
        specialUserKbn = pSpecialUserKbn;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String pPassword) {
        password = pPassword;
    }

    private BizDate passwordSetteiYmd;

    public BizDate getPasswordSetteiYmd() {
        return passwordSetteiYmd;
    }

    public void setPasswordSetteiYmd(BizDate pPasswordSetteiYmd) {
        passwordSetteiYmd = pPasswordSetteiYmd;
    }

    private BizDate passwordYuukouKigenYmd;

    public BizDate getPasswordYuukouKigenYmd() {
        return passwordYuukouKigenYmd;
    }

    public void setPasswordYuukouKigenYmd(BizDate pPasswordYuukouKigenYmd) {
        passwordYuukouKigenYmd = pPasswordYuukouKigenYmd;
    }

    private Integer passwordYuukouCountY;

    public Integer getPasswordYuukouCountY() {
        return passwordYuukouCountY;
    }

    public void setPasswordYuukouCountY(Integer pPasswordYuukouCountY) {
        passwordYuukouCountY = pPasswordYuukouCountY;
    }

    private Integer passwordYuukouCountM;

    public Integer getPasswordYuukouCountM() {
        return passwordYuukouCountM;
    }

    public void setPasswordYuukouCountM(Integer pPasswordYuukouCountM) {
        passwordYuukouCountM = pPasswordYuukouCountM;
    }

    private Integer passwordYuukouCountD;

    public Integer getPasswordYuukouCountD() {
        return passwordYuukouCountD;
    }

    public void setPasswordYuukouCountD(Integer pPasswordYuukouCountD) {
        passwordYuukouCountD = pPasswordYuukouCountD;
    }

    private C_PasswordYuukouKikanKbn passwordYuukouKikanKbn;

    public C_PasswordYuukouKikanKbn getPasswordYuukouKikanKbn() {
        return passwordYuukouKikanKbn;
    }

    public void setPasswordYuukouKikanKbn(C_PasswordYuukouKikanKbn pPasswordYuukouKikanKbn) {
        passwordYuukouKikanKbn = pPasswordYuukouKikanKbn;
    }

    private C_KyokaKbn passwordHenkouKyokaKbn;

    public C_KyokaKbn getPasswordHenkouKyokaKbn() {
        return passwordHenkouKyokaKbn;
    }

    public void setPasswordHenkouKyokaKbn(C_KyokaKbn pPasswordHenkouKyokaKbn) {
        passwordHenkouKyokaKbn = pPasswordHenkouKyokaKbn;
    }

    private C_YoukyuuKbn passwordHenkouYoukyuuKbn;

    public C_YoukyuuKbn getPasswordHenkouYoukyuuKbn() {
        return passwordHenkouYoukyuuKbn;
    }

    public void setPasswordHenkouYoukyuuKbn(C_YoukyuuKbn pPasswordHenkouYoukyuuKbn) {
        passwordHenkouYoukyuuKbn = pPasswordHenkouYoukyuuKbn;
    }

    private C_KyokaKbn loginKyokaKbn;

    public C_KyokaKbn getLoginKyokaKbn() {
        return loginKyokaKbn;
    }

    public void setLoginKyokaKbn(C_KyokaKbn pLoginKyokaKbn) {
        loginKyokaKbn = pLoginKyokaKbn;
    }

    private Integer loginErrorCount;

    public Integer getLoginErrorCount() {
        return loginErrorCount;
    }

    public void setLoginErrorCount(Integer pLoginErrorCount) {
        loginErrorCount = pLoginErrorCount;
    }

}

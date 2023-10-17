package yuyu.app.base.system.userkensakurolehyouji;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * ユーザー検索（ロール表示用） : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenUserKensakuRoleHyoujiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<UserAndUserRoleInfoDataSourceBean> userAndUserRoleInfoDataSource = new DataSource<>();
    public DataSource<UserAndUserRoleInfoDataSourceBean> getUserAndUserRoleInfoDataSource() {
        return userAndUserRoleInfoDataSource;
    }

    @Deprecated
    public List<UserAndUserRoleInfoDataSourceBean> getUserAndUserRoleInfo() {
        return userAndUserRoleInfoDataSource.getDatas();
    }

    public void setUserAndUserRoleInfo(List<UserAndUserRoleInfoDataSourceBean> pUserAndUserRoleInfo) {
        userAndUserRoleInfoDataSource.setDatas(pUserAndUserRoleInfo, 10);
    }

    @MaxLength(max=30)
    @AlphaDigit
    private String userId;

    public String getUserId() {
        return userId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserId(String pUserId) {
        userId = pUserId;
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

    @MaxLength(max=7)
    @Digit
    @SingleByteStrings
    private String srchsosikicd;

    public String getSrchsosikicd() {
        return srchsosikicd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchsosikicd(String pSrchsosikicd) {
        srchsosikicd = pSrchsosikicd;
    }
}

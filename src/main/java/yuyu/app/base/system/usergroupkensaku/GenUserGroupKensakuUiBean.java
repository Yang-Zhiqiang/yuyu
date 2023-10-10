package yuyu.app.base.system.usergroupkensaku;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * ユーザーグループ検索 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenUserGroupKensakuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<UserGroupInfoDataSourceBean> userGroupInfoDataSource = new DataSource<>();
    public DataSource<UserGroupInfoDataSourceBean> getUserGroupInfoDataSource() {
        return userGroupInfoDataSource;
    }

    @Deprecated
    public List<UserGroupInfoDataSourceBean> getUserGroupInfo() {
        return userGroupInfoDataSource.getDatas();
    }

    public void setUserGroupInfo(List<UserGroupInfoDataSourceBean> pUserGroupInfo) {
        userGroupInfoDataSource.setDatas(pUserGroupInfo, 10);
    }

    @MaxLength(max=30)
    @AlphaDigit
    private String userGroupCd;

    public String getUserGroupCd() {
        return userGroupCd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserGroupCd(String pUserGroupCd) {
        userGroupCd = pUserGroupCd;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String userGroupNm;

    public String getUserGroupNm() {
        return userGroupNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUserGroupNm(String pUserGroupNm) {
        userGroupNm = pUserGroupNm;
    }
}

package yuyu.app.base.system.usertouroku;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.db.entity.AM_User;

/**
 * ユーザー登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenUserTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private AM_User user;

    public AM_User getUser() {
        return user;
    }

    public void setUser(AM_User pUser) {
        user = pUser;
    }

    private DataSource<RoleInfoDataSourceBean> roleInfoDataSource = new DataSource<>();
    public DataSource<RoleInfoDataSourceBean> getRoleInfoDataSource() {
        return roleInfoDataSource;
    }

    @Deprecated
    public List<RoleInfoDataSourceBean> getRoleInfo() {
        return roleInfoDataSource.getDatas();
    }

    public void setRoleInfo(List<RoleInfoDataSourceBean> pRoleInfo) {
        roleInfoDataSource.setDatas(pRoleInfo);
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

package yuyu.app.base.system.rolekensaku;

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
 * ロール検索 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenRoleKensakuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<RoleInfoDataSourceBean> roleInfoDataSource = new DataSource<>();
    public DataSource<RoleInfoDataSourceBean> getRoleInfoDataSource() {
        return roleInfoDataSource;
    }

    @Deprecated
    public List<RoleInfoDataSourceBean> getRoleInfo() {
        return roleInfoDataSource.getDatas();
    }

    public void setRoleInfo(List<RoleInfoDataSourceBean> pRoleInfo) {
        roleInfoDataSource.setDatas(pRoleInfo, 10);
    }

    @MaxLength(max=30)
    @AlphaDigit
    private String roleCd;

    public String getRoleCd() {
        return roleCd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRoleCd(String pRoleCd) {
        roleCd = pRoleCd;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String roleNm;

    public String getRoleNm() {
        return roleNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setRoleNm(String pRoleNm) {
        roleNm = pRoleNm;
    }
}

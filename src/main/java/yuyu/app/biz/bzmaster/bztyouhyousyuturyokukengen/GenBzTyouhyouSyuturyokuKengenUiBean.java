package yuyu.app.biz.bzmaster.bztyouhyousyuturyokukengen;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 帳票出力権限登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenBzTyouhyouSyuturyokuKengenUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<TyouhyouListDataSourceBean> tyouhyouListDataSource = new DataSource<>();
    public DataSource<TyouhyouListDataSourceBean> getTyouhyouListDataSource() {
        return tyouhyouListDataSource;
    }

    @Deprecated
    public List<TyouhyouListDataSourceBean> getTyouhyouList() {
        return tyouhyouListDataSource.getDatas();
    }

    public void setTyouhyouList(List<TyouhyouListDataSourceBean> pTyouhyouList) {
        tyouhyouListDataSource.setDatas(pTyouhyouList);
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

    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    private LoopChain<UserDefsList> subSystemIdOptionBeanList = new LoopChain<>();
    public UserDefsList getSubSystemIdOptionBeanList() {
        return subSystemIdOptionBeanList.get();
    }

    public void setSubSystemIdOptionBeanList(UserDefsList pSubSystemIdOptionBeanList) {
        clearSubSystemIdOptionBeanList();
        subSystemIdOptionBeanList.add(pSubSystemIdOptionBeanList);
    }

    public void clearSubSystemIdOptionBeanList() {
        subSystemIdOptionBeanList.clear();
    }
}

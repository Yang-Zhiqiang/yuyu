package yuyu.app.base.system.kinouteigitouroku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean.LoopChain;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 機能定義登録 - ● 権限設定 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKengenSetteiListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean commonCheckBox;

    public Boolean getCommonCheckBox() {
        return commonCheckBox == null ? Boolean.FALSE : commonCheckBox;
    }

    public void setCommonCheckBox(Boolean pCommonCheckBox) {
        commonCheckBox = pCommonCheckBox == null ? Boolean.FALSE : pCommonCheckBox;
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


    @MaxLength(max=100)
    @MultiByteStrings
    @InvalidCharacter
    private String roleSetumei;

    public String getRoleSetumei() {
        return roleSetumei;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setRoleSetumei(String pRoleSetumei) {
        roleSetumei = pRoleSetumei;
    }


    private String siborikomiId;

    public String getSiborikomiId() {
        return siborikomiId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSiborikomiId(String pSiborikomiId) {
        siborikomiId = pSiborikomiId;
    }


    private LoopChain<UserDefsList> siborikomiIdOptionBeanList = new LoopChain<>();
    public UserDefsList getSiborikomiIdOptionBeanList() {
        return siborikomiIdOptionBeanList.get();
    }

    public void setSiborikomiIdOptionBeanList(UserDefsList pSiborikomiIdOptionBeanList) {
        siborikomiIdOptionBeanList.add(pSiborikomiIdOptionBeanList);
    }

    public void clearSiborikomiIdOptionBeanList() {
        siborikomiIdOptionBeanList.clear();
    }
}

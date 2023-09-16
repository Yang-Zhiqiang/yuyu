package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZennouKessanHoyuuHanteiKekkaKbn;

/**
 * {@link C_ZennouKessanHoyuuHanteiKekkaKbn 前納決算保有判定結果区分} の Hibernate ユーザー定義型です。<br />
 * 前納決算保有判定結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZennouKessanHoyuuHanteiKekkaKbn extends AbstractUserType<C_ZennouKessanHoyuuHanteiKekkaKbn> {

    @Override
    protected Class<C_ZennouKessanHoyuuHanteiKekkaKbn> returnType() {
        return C_ZennouKessanHoyuuHanteiKekkaKbn.class;
    }

    @Override
    protected C_ZennouKessanHoyuuHanteiKekkaKbn valueOf(String pValue) {
        return C_ZennouKessanHoyuuHanteiKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZennouKessanHoyuuHanteiKekkaKbn pValue) {
        return pValue.getValue();
    }
}

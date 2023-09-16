package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KetteikekkaKbn;

/**
 * {@link C_KetteikekkaKbn 決定結果区分} の Hibernate ユーザー定義型です。<br />
 * 決定結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KetteikekkaKbn extends AbstractUserType<C_KetteikekkaKbn> {

    @Override
    protected Class<C_KetteikekkaKbn> returnType() {
        return C_KetteikekkaKbn.class;
    }

    @Override
    protected C_KetteikekkaKbn valueOf(String pValue) {
        return C_KetteikekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KetteikekkaKbn pValue) {
        return pValue.getValue();
    }
}

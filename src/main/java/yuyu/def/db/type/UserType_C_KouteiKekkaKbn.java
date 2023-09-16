package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KouteiKekkaKbn;

/**
 * {@link C_KouteiKekkaKbn 工程結果区分} の Hibernate ユーザー定義型です。<br />
 * 工程結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KouteiKekkaKbn extends AbstractUserType<C_KouteiKekkaKbn> {

    @Override
    protected Class<C_KouteiKekkaKbn> returnType() {
        return C_KouteiKekkaKbn.class;
    }

    @Override
    protected C_KouteiKekkaKbn valueOf(String pValue) {
        return C_KouteiKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KouteiKekkaKbn pValue) {
        return pValue.getValue();
    }
}

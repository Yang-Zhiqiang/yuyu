package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsKzkJmKknHsJyKbn;

/**
 * {@link C_DsKzkJmKknHsJyKbn ＤＳ後続事務確認発生事由区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ後続事務確認発生事由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsKzkJmKknHsJyKbn extends AbstractUserType<C_DsKzkJmKknHsJyKbn> {

    @Override
    protected Class<C_DsKzkJmKknHsJyKbn> returnType() {
        return C_DsKzkJmKknHsJyKbn.class;
    }

    @Override
    protected C_DsKzkJmKknHsJyKbn valueOf(String pValue) {
        return C_DsKzkJmKknHsJyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsKzkJmKknHsJyKbn pValue) {
        return pValue.getValue();
    }
}

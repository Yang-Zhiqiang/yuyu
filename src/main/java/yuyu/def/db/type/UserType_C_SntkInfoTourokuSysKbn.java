package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SntkInfoTourokuSysKbn;

/**
 * {@link C_SntkInfoTourokuSysKbn 選択情報登録システム区分} の Hibernate ユーザー定義型です。<br />
 * 選択情報登録システム区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SntkInfoTourokuSysKbn extends AbstractUserType<C_SntkInfoTourokuSysKbn> {

    @Override
    protected Class<C_SntkInfoTourokuSysKbn> returnType() {
        return C_SntkInfoTourokuSysKbn.class;
    }

    @Override
    protected C_SntkInfoTourokuSysKbn valueOf(String pValue) {
        return C_SntkInfoTourokuSysKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SntkInfoTourokuSysKbn pValue) {
        return pValue.getValue();
    }
}

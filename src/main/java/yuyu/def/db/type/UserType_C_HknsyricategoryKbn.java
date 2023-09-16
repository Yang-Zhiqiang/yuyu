package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HknsyricategoryKbn;

/**
 * {@link C_HknsyricategoryKbn 保険種類カテゴリ区分} の Hibernate ユーザー定義型です。<br />
 * 保険種類カテゴリ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HknsyricategoryKbn extends AbstractUserType<C_HknsyricategoryKbn> {

    @Override
    protected Class<C_HknsyricategoryKbn> returnType() {
        return C_HknsyricategoryKbn.class;
    }

    @Override
    protected C_HknsyricategoryKbn valueOf(String pValue) {
        return C_HknsyricategoryKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HknsyricategoryKbn pValue) {
        return pValue.getValue();
    }
}

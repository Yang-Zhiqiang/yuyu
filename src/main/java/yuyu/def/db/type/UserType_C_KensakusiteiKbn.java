package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KensakusiteiKbn;

/**
 * {@link C_KensakusiteiKbn 検索指定区分} の Hibernate ユーザー定義型です。<br />
 * 検索指定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KensakusiteiKbn extends AbstractUserType<C_KensakusiteiKbn> {

    @Override
    protected Class<C_KensakusiteiKbn> returnType() {
        return C_KensakusiteiKbn.class;
    }

    @Override
    protected C_KensakusiteiKbn valueOf(String pValue) {
        return C_KensakusiteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KensakusiteiKbn pValue) {
        return pValue.getValue();
    }
}

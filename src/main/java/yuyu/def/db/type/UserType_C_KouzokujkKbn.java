package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KouzokujkKbn;

/**
 * {@link C_KouzokujkKbn 後続処理実行区分} の Hibernate ユーザー定義型です。<br />
 * 後続処理実行区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KouzokujkKbn extends AbstractUserType<C_KouzokujkKbn> {

    @Override
    protected Class<C_KouzokujkKbn> returnType() {
        return C_KouzokujkKbn.class;
    }

    @Override
    protected C_KouzokujkKbn valueOf(String pValue) {
        return C_KouzokujkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KouzokujkKbn pValue) {
        return pValue.getValue();
    }
}

package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BlnktkumuKbn;

/**
 * {@link C_BlnktkumuKbn ブランク付有無区分} の Hibernate ユーザー定義型です。<br />
 * ブランク付有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BlnktkumuKbn extends AbstractUserType<C_BlnktkumuKbn> {

    @Override
    protected Class<C_BlnktkumuKbn> returnType() {
        return C_BlnktkumuKbn.class;
    }

    @Override
    protected C_BlnktkumuKbn valueOf(String pValue) {
        return C_BlnktkumuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BlnktkumuKbn pValue) {
        return pValue.getValue();
    }
}

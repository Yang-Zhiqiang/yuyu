package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SakujyoKeyKbn;

/**
 * {@link C_SakujyoKeyKbn 削除キー区分} の Hibernate ユーザー定義型です。<br />
 * 削除キー区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SakujyoKeyKbn extends AbstractUserType<C_SakujyoKeyKbn> {

    @Override
    protected Class<C_SakujyoKeyKbn> returnType() {
        return C_SakujyoKeyKbn.class;
    }

    @Override
    protected C_SakujyoKeyKbn valueOf(String pValue) {
        return C_SakujyoKeyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SakujyoKeyKbn pValue) {
        return pValue.getValue();
    }
}

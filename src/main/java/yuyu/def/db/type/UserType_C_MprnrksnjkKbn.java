package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MprnrksnjkKbn;

/**
 * {@link C_MprnrksnjkKbn マイページ連絡承認状況区分} の Hibernate ユーザー定義型です。<br />
 * マイページ連絡承認状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MprnrksnjkKbn extends AbstractUserType<C_MprnrksnjkKbn> {

    @Override
    protected Class<C_MprnrksnjkKbn> returnType() {
        return C_MprnrksnjkKbn.class;
    }

    @Override
    protected C_MprnrksnjkKbn valueOf(String pValue) {
        return C_MprnrksnjkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MprnrksnjkKbn pValue) {
        return pValue.getValue();
    }
}

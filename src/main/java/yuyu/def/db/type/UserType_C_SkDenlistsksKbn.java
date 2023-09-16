package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SkDenlistsksKbn;

/**
 * {@link C_SkDenlistsksKbn 新契約伝票リスト作成区分} の Hibernate ユーザー定義型です。<br />
 * 新契約伝票リスト作成区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SkDenlistsksKbn extends AbstractUserType<C_SkDenlistsksKbn> {

    @Override
    protected Class<C_SkDenlistsksKbn> returnType() {
        return C_SkDenlistsksKbn.class;
    }

    @Override
    protected C_SkDenlistsksKbn valueOf(String pValue) {
        return C_SkDenlistsksKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SkDenlistsksKbn pValue) {
        return pValue.getValue();
    }
}

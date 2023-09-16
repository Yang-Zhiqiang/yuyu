package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SksmongonKbn;

/**
 * {@link C_SksmongonKbn 請求書文言区分} の Hibernate ユーザー定義型です。<br />
 * 請求書文言区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SksmongonKbn extends AbstractUserType<C_SksmongonKbn> {

    @Override
    protected Class<C_SksmongonKbn> returnType() {
        return C_SksmongonKbn.class;
    }

    @Override
    protected C_SksmongonKbn valueOf(String pValue) {
        return C_SksmongonKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SksmongonKbn pValue) {
        return pValue.getValue();
    }
}

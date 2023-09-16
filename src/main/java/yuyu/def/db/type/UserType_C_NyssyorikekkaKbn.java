package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NyssyorikekkaKbn;

/**
 * {@link C_NyssyorikekkaKbn 名寄せ処理結果区分} の Hibernate ユーザー定義型です。<br />
 * 名寄せ処理結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NyssyorikekkaKbn extends AbstractUserType<C_NyssyorikekkaKbn> {

    @Override
    protected Class<C_NyssyorikekkaKbn> returnType() {
        return C_NyssyorikekkaKbn.class;
    }

    @Override
    protected C_NyssyorikekkaKbn valueOf(String pValue) {
        return C_NyssyorikekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NyssyorikekkaKbn pValue) {
        return pValue.getValue();
    }
}

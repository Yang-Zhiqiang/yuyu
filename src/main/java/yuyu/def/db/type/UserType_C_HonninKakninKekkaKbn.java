package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HonninKakninKekkaKbn;

/**
 * {@link C_HonninKakninKekkaKbn 本人確認結果区分} の Hibernate ユーザー定義型です。<br />
 * 本人確認結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HonninKakninKekkaKbn extends AbstractUserType<C_HonninKakninKekkaKbn> {

    @Override
    protected Class<C_HonninKakninKekkaKbn> returnType() {
        return C_HonninKakninKekkaKbn.class;
    }

    @Override
    protected C_HonninKakninKekkaKbn valueOf(String pValue) {
        return C_HonninKakninKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HonninKakninKekkaKbn pValue) {
        return pValue.getValue();
    }
}

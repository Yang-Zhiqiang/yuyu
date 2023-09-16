package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SinsetuhenkouKbn;

/**
 * {@link C_SinsetuhenkouKbn 新設変更区分} の Hibernate ユーザー定義型です。<br />
 * 新設変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SinsetuhenkouKbn extends AbstractUserType<C_SinsetuhenkouKbn> {

    @Override
    protected Class<C_SinsetuhenkouKbn> returnType() {
        return C_SinsetuhenkouKbn.class;
    }

    @Override
    protected C_SinsetuhenkouKbn valueOf(String pValue) {
        return C_SinsetuhenkouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SinsetuhenkouKbn pValue) {
        return pValue.getValue();
    }
}

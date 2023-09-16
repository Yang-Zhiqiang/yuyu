package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyoruiTorikomiHouKbn;

/**
 * {@link C_SyoruiTorikomiHouKbn 書類取込方法区分} の Hibernate ユーザー定義型です。<br />
 * 書類取込方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyoruiTorikomiHouKbn extends AbstractUserType<C_SyoruiTorikomiHouKbn> {

    @Override
    protected Class<C_SyoruiTorikomiHouKbn> returnType() {
        return C_SyoruiTorikomiHouKbn.class;
    }

    @Override
    protected C_SyoruiTorikomiHouKbn valueOf(String pValue) {
        return C_SyoruiTorikomiHouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyoruiTorikomiHouKbn pValue) {
        return pValue.getValue();
    }
}

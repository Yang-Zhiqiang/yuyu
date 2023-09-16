package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsrybonusKbn;

/**
 * {@link C_TsrybonusKbn 手数料・ボーナス区分} の Hibernate ユーザー定義型です。<br />
 * 手数料・ボーナス区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsrybonusKbn extends AbstractUserType<C_TsrybonusKbn> {

    @Override
    protected Class<C_TsrybonusKbn> returnType() {
        return C_TsrybonusKbn.class;
    }

    @Override
    protected C_TsrybonusKbn valueOf(String pValue) {
        return C_TsrybonusKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsrybonusKbn pValue) {
        return pValue.getValue();
    }
}

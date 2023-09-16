package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;

/**
 * {@link C_TumitatekinHaibunWariKbn 積立金配分割合区分} の Hibernate ユーザー定義型です。<br />
 * 積立金配分割合区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TumitatekinHaibunWariKbn extends AbstractUserType<C_TumitatekinHaibunWariKbn> {

    @Override
    protected Class<C_TumitatekinHaibunWariKbn> returnType() {
        return C_TumitatekinHaibunWariKbn.class;
    }

    @Override
    protected C_TumitatekinHaibunWariKbn valueOf(String pValue) {
        return C_TumitatekinHaibunWariKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TumitatekinHaibunWariKbn pValue) {
        return pValue.getValue();
    }
}

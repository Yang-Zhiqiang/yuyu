package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_3rdsecinsriskksnKbn;

/**
 * {@link C_3rdsecinsriskksnKbn 第三分野保険リスク計算区分} の Hibernate ユーザー定義型です。<br />
 * 第三分野保険リスク計算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_3rdsecinsriskksnKbn extends AbstractUserType<C_3rdsecinsriskksnKbn> {

    @Override
    protected Class<C_3rdsecinsriskksnKbn> returnType() {
        return C_3rdsecinsriskksnKbn.class;
    }

    @Override
    protected C_3rdsecinsriskksnKbn valueOf(String pValue) {
        return C_3rdsecinsriskksnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_3rdsecinsriskksnKbn pValue) {
        return pValue.getValue();
    }
}

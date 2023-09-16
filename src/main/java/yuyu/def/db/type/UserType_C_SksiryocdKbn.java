package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SksiryocdKbn;

/**
 * {@link C_SksiryocdKbn 請求資料コード区分} の Hibernate ユーザー定義型です。<br />
 * 請求資料コード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SksiryocdKbn extends AbstractUserType<C_SksiryocdKbn> {

    @Override
    protected Class<C_SksiryocdKbn> returnType() {
        return C_SksiryocdKbn.class;
    }

    @Override
    protected C_SksiryocdKbn valueOf(String pValue) {
        return C_SksiryocdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SksiryocdKbn pValue) {
        return pValue.getValue();
    }
}

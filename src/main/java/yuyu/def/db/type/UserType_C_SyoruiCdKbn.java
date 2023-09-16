package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * {@link C_SyoruiCdKbn 書類コード区分} の Hibernate ユーザー定義型です。<br />
 * 書類コード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyoruiCdKbn extends AbstractUserType<C_SyoruiCdKbn> {

    @Override
    protected Class<C_SyoruiCdKbn> returnType() {
        return C_SyoruiCdKbn.class;
    }

    @Override
    protected C_SyoruiCdKbn valueOf(String pValue) {
        return C_SyoruiCdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyoruiCdKbn pValue) {
        return pValue.getValue();
    }
}

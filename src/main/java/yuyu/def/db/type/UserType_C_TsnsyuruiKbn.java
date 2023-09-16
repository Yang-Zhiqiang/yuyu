package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsnsyuruiKbn;

/**
 * {@link C_TsnsyuruiKbn 通算種類区分} の Hibernate ユーザー定義型です。<br />
 * 通算種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsnsyuruiKbn extends AbstractUserType<C_TsnsyuruiKbn> {

    @Override
    protected Class<C_TsnsyuruiKbn> returnType() {
        return C_TsnsyuruiKbn.class;
    }

    @Override
    protected C_TsnsyuruiKbn valueOf(String pValue) {
        return C_TsnsyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsnsyuruiKbn pValue) {
        return pValue.getValue();
    }
}

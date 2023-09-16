package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_WftyouhyousyuruiKbn;

/**
 * {@link C_WftyouhyousyuruiKbn IWF帳票種類区分} の Hibernate ユーザー定義型です。<br />
 * IWF帳票種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_WftyouhyousyuruiKbn extends AbstractUserType<C_WftyouhyousyuruiKbn> {

    @Override
    protected Class<C_WftyouhyousyuruiKbn> returnType() {
        return C_WftyouhyousyuruiKbn.class;
    }

    @Override
    protected C_WftyouhyousyuruiKbn valueOf(String pValue) {
        return C_WftyouhyousyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_WftyouhyousyuruiKbn pValue) {
        return pValue.getValue();
    }
}

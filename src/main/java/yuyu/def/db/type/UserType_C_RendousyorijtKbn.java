package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RendousyorijtKbn;

/**
 * {@link C_RendousyorijtKbn 連動処理状態区分} の Hibernate ユーザー定義型です。<br />
 * 連動処理状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RendousyorijtKbn extends AbstractUserType<C_RendousyorijtKbn> {

    @Override
    protected Class<C_RendousyorijtKbn> returnType() {
        return C_RendousyorijtKbn.class;
    }

    @Override
    protected C_RendousyorijtKbn valueOf(String pValue) {
        return C_RendousyorijtKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RendousyorijtKbn pValue) {
        return pValue.getValue();
    }
}

package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RendousyorikekkaKbn;

/**
 * {@link C_RendousyorikekkaKbn 連動処理結果区分} の Hibernate ユーザー定義型です。<br />
 * 連動処理結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RendousyorikekkaKbn extends AbstractUserType<C_RendousyorikekkaKbn> {

    @Override
    protected Class<C_RendousyorikekkaKbn> returnType() {
        return C_RendousyorikekkaKbn.class;
    }

    @Override
    protected C_RendousyorikekkaKbn valueOf(String pValue) {
        return C_RendousyorikekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RendousyorikekkaKbn pValue) {
        return pValue.getValue();
    }
}

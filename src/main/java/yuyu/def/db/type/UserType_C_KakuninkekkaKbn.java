package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KakuninkekkaKbn;

/**
 * {@link C_KakuninkekkaKbn 内容確認結果区分} の Hibernate ユーザー定義型です。<br />
 * 内容確認結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KakuninkekkaKbn extends AbstractUserType<C_KakuninkekkaKbn> {

    @Override
    protected Class<C_KakuninkekkaKbn> returnType() {
        return C_KakuninkekkaKbn.class;
    }

    @Override
    protected C_KakuninkekkaKbn valueOf(String pValue) {
        return C_KakuninkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KakuninkekkaKbn pValue) {
        return pValue.getValue();
    }
}

package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KykKihonTokuteiJitenKbn;

/**
 * {@link C_KykKihonTokuteiJitenKbn 契約基本用特定時点判定処理区分} の Hibernate ユーザー定義型です。<br />
 * 契約基本用特定時点判定処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KykKihonTokuteiJitenKbn extends AbstractUserType<C_KykKihonTokuteiJitenKbn> {

    @Override
    protected Class<C_KykKihonTokuteiJitenKbn> returnType() {
        return C_KykKihonTokuteiJitenKbn.class;
    }

    @Override
    protected C_KykKihonTokuteiJitenKbn valueOf(String pValue) {
        return C_KykKihonTokuteiJitenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KykKihonTokuteiJitenKbn pValue) {
        return pValue.getValue();
    }
}

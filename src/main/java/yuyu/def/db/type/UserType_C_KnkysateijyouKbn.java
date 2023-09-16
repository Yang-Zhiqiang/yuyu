package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KnkysateijyouKbn;

/**
 * {@link C_KnkysateijyouKbn 環境査定状態区分} の Hibernate ユーザー定義型です。<br />
 * 環境査定状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KnkysateijyouKbn extends AbstractUserType<C_KnkysateijyouKbn> {

    @Override
    protected Class<C_KnkysateijyouKbn> returnType() {
        return C_KnkysateijyouKbn.class;
    }

    @Override
    protected C_KnkysateijyouKbn valueOf(String pValue) {
        return C_KnkysateijyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KnkysateijyouKbn pValue) {
        return pValue.getValue();
    }
}

package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MsgHikisuuNaiyouKbn;

/**
 * {@link C_MsgHikisuuNaiyouKbn メッセージ引数内容区分} の Hibernate ユーザー定義型です。<br />
 * メッセージ引数内容区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MsgHikisuuNaiyouKbn extends AbstractUserType<C_MsgHikisuuNaiyouKbn> {

    @Override
    protected Class<C_MsgHikisuuNaiyouKbn> returnType() {
        return C_MsgHikisuuNaiyouKbn.class;
    }

    @Override
    protected C_MsgHikisuuNaiyouKbn valueOf(String pValue) {
        return C_MsgHikisuuNaiyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MsgHikisuuNaiyouKbn pValue) {
        return pValue.getValue();
    }
}

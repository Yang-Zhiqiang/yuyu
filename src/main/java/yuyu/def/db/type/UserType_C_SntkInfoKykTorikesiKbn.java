package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SntkInfoKykTorikesiKbn;

/**
 * {@link C_SntkInfoKykTorikesiKbn 選択情報用契約取消処理区分} の Hibernate ユーザー定義型です。<br />
 * 選択情報用契約取消処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SntkInfoKykTorikesiKbn extends AbstractUserType<C_SntkInfoKykTorikesiKbn> {

    @Override
    protected Class<C_SntkInfoKykTorikesiKbn> returnType() {
        return C_SntkInfoKykTorikesiKbn.class;
    }

    @Override
    protected C_SntkInfoKykTorikesiKbn valueOf(String pValue) {
        return C_SntkInfoKykTorikesiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SntkInfoKykTorikesiKbn pValue) {
        return pValue.getValue();
    }
}

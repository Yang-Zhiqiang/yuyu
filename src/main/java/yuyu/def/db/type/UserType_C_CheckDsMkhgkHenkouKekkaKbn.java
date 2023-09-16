package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CheckDsMkhgkHenkouKekkaKbn;

/**
 * {@link C_CheckDsMkhgkHenkouKekkaKbn ＤＳ目標額変更共通チェック結果区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ目標額変更共通チェック結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CheckDsMkhgkHenkouKekkaKbn extends AbstractUserType<C_CheckDsMkhgkHenkouKekkaKbn> {

    @Override
    protected Class<C_CheckDsMkhgkHenkouKekkaKbn> returnType() {
        return C_CheckDsMkhgkHenkouKekkaKbn.class;
    }

    @Override
    protected C_CheckDsMkhgkHenkouKekkaKbn valueOf(String pValue) {
        return C_CheckDsMkhgkHenkouKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CheckDsMkhgkHenkouKekkaKbn pValue) {
        return pValue.getValue();
    }
}

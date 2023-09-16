package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Gmkansyori;

/**
 * {@link C_Gmkansyori 画面間処理区分} の Hibernate ユーザー定義型です。<br />
 * 画面間処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Gmkansyori extends AbstractUserType<C_Gmkansyori> {

    @Override
    protected Class<C_Gmkansyori> returnType() {
        return C_Gmkansyori.class;
    }

    @Override
    protected C_Gmkansyori valueOf(String pValue) {
        return C_Gmkansyori.valueOf(pValue);
    }

    @Override
    protected String toString(C_Gmkansyori pValue) {
        return pValue.getValue();
    }
}

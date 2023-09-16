package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kykjyoutai;

/**
 * {@link C_Kykjyoutai 契約状態} の Hibernate ユーザー定義型です。<br />
 * 契約状態 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kykjyoutai extends AbstractUserType<C_Kykjyoutai> {

    @Override
    protected Class<C_Kykjyoutai> returnType() {
        return C_Kykjyoutai.class;
    }

    @Override
    protected C_Kykjyoutai valueOf(String pValue) {
        return C_Kykjyoutai.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kykjyoutai pValue) {
        return pValue.getValue();
    }
}

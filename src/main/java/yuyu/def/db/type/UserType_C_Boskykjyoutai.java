package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Boskykjyoutai;

/**
 * {@link C_Boskykjyoutai 募集契約状態} の Hibernate ユーザー定義型です。<br />
 * 募集契約状態 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Boskykjyoutai extends AbstractUserType<C_Boskykjyoutai> {

    @Override
    protected Class<C_Boskykjyoutai> returnType() {
        return C_Boskykjyoutai.class;
    }

    @Override
    protected C_Boskykjyoutai valueOf(String pValue) {
        return C_Boskykjyoutai.valueOf(pValue);
    }

    @Override
    protected String toString(C_Boskykjyoutai pValue) {
        return pValue.getValue();
    }
}

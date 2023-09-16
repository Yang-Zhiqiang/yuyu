package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Znnkaisuukekka;

/**
 * {@link C_Znnkaisuukekka 前納回数判定結果区分} の Hibernate ユーザー定義型です。<br />
 * 前納回数判定結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Znnkaisuukekka extends AbstractUserType<C_Znnkaisuukekka> {

    @Override
    protected Class<C_Znnkaisuukekka> returnType() {
        return C_Znnkaisuukekka.class;
    }

    @Override
    protected C_Znnkaisuukekka valueOf(String pValue) {
        return C_Znnkaisuukekka.valueOf(pValue);
    }

    @Override
    protected String toString(C_Znnkaisuukekka pValue) {
        return pValue.getValue();
    }
}

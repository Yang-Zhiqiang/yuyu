package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Znnhrkkai;

/**
 * {@link C_Znnhrkkai 前納後払込回数} の Hibernate ユーザー定義型です。<br />
 * 前納後払込回数 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Znnhrkkai extends AbstractUserType<C_Znnhrkkai> {

    @Override
    protected Class<C_Znnhrkkai> returnType() {
        return C_Znnhrkkai.class;
    }

    @Override
    protected C_Znnhrkkai valueOf(String pValue) {
        return C_Znnhrkkai.valueOf(pValue);
    }

    @Override
    protected String toString(C_Znnhrkkai pValue) {
        return pValue.getValue();
    }
}

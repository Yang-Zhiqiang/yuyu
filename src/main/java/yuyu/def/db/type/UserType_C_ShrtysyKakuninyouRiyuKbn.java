package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrtysyKakuninyouRiyuKbn;

/**
 * {@link C_ShrtysyKakuninyouRiyuKbn 支払調書確認要理由区分} の Hibernate ユーザー定義型です。<br />
 * 支払調書確認要理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrtysyKakuninyouRiyuKbn extends AbstractUserType<C_ShrtysyKakuninyouRiyuKbn> {

    @Override
    protected Class<C_ShrtysyKakuninyouRiyuKbn> returnType() {
        return C_ShrtysyKakuninyouRiyuKbn.class;
    }

    @Override
    protected C_ShrtysyKakuninyouRiyuKbn valueOf(String pValue) {
        return C_ShrtysyKakuninyouRiyuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrtysyKakuninyouRiyuKbn pValue) {
        return pValue.getValue();
    }
}

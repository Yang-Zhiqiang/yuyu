package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SiMakeSbKariUktkKidouKbn;

/**
 * {@link C_SiMakeSbKariUktkKidouKbn 死亡仮受付情報作成起動区分} の Hibernate ユーザー定義型です。<br />
 * 死亡仮受付情報作成起動区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SiMakeSbKariUktkKidouKbn extends AbstractUserType<C_SiMakeSbKariUktkKidouKbn> {

    @Override
    protected Class<C_SiMakeSbKariUktkKidouKbn> returnType() {
        return C_SiMakeSbKariUktkKidouKbn.class;
    }

    @Override
    protected C_SiMakeSbKariUktkKidouKbn valueOf(String pValue) {
        return C_SiMakeSbKariUktkKidouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SiMakeSbKariUktkKidouKbn pValue) {
        return pValue.getValue();
    }
}

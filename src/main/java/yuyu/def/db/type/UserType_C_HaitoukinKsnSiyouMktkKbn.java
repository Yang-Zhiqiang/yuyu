package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HaitoukinKsnSiyouMktkKbn;

/**
 * {@link C_HaitoukinKsnSiyouMktkKbn 配当金計算使用目的区分} の Hibernate ユーザー定義型です。<br />
 * 配当金計算使用目的区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HaitoukinKsnSiyouMktkKbn extends AbstractUserType<C_HaitoukinKsnSiyouMktkKbn> {

    @Override
    protected Class<C_HaitoukinKsnSiyouMktkKbn> returnType() {
        return C_HaitoukinKsnSiyouMktkKbn.class;
    }

    @Override
    protected C_HaitoukinKsnSiyouMktkKbn valueOf(String pValue) {
        return C_HaitoukinKsnSiyouMktkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HaitoukinKsnSiyouMktkKbn pValue) {
        return pValue.getValue();
    }
}

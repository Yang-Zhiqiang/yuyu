package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Yuukoukakkekka;

/**
 * {@link C_Yuukoukakkekka 有効確認結果} の Hibernate ユーザー定義型です。<br />
 * 有効確認結果 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Yuukoukakkekka extends AbstractUserType<C_Yuukoukakkekka> {

    @Override
    protected Class<C_Yuukoukakkekka> returnType() {
        return C_Yuukoukakkekka.class;
    }

    @Override
    protected C_Yuukoukakkekka valueOf(String pValue) {
        return C_Yuukoukakkekka.valueOf(pValue);
    }

    @Override
    protected String toString(C_Yuukoukakkekka pValue) {
        return pValue.getValue();
    }
}

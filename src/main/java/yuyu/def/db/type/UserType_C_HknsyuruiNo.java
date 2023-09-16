package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HknsyuruiNo;

/**
 * {@link C_HknsyuruiNo 保険種類番号} の Hibernate ユーザー定義型です。<br />
 * 保険種類番号 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HknsyuruiNo extends AbstractUserType<C_HknsyuruiNo> {

    @Override
    protected Class<C_HknsyuruiNo> returnType() {
        return C_HknsyuruiNo.class;
    }

    @Override
    protected C_HknsyuruiNo valueOf(String pValue) {
        return C_HknsyuruiNo.valueOf(pValue);
    }

    @Override
    protected String toString(C_HknsyuruiNo pValue) {
        return pValue.getValue();
    }
}

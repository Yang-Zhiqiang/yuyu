package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Hknsyuruicd;

/**
 * {@link C_Hknsyuruicd 保険種類コード} の Hibernate ユーザー定義型です。<br />
 * 保険種類コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Hknsyuruicd extends AbstractUserType<C_Hknsyuruicd> {

    @Override
    protected Class<C_Hknsyuruicd> returnType() {
        return C_Hknsyuruicd.class;
    }

    @Override
    protected C_Hknsyuruicd valueOf(String pValue) {
        return C_Hknsyuruicd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Hknsyuruicd pValue) {
        return pValue.getValue();
    }
}

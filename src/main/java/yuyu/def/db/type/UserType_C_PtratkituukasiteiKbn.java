package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PtratkituukasiteiKbn;

/**
 * {@link C_PtratkituukasiteiKbn 保険料取扱通貨指定区分} の Hibernate ユーザー定義型です。<br />
 * 保険料取扱通貨指定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PtratkituukasiteiKbn extends AbstractUserType<C_PtratkituukasiteiKbn> {

    @Override
    protected Class<C_PtratkituukasiteiKbn> returnType() {
        return C_PtratkituukasiteiKbn.class;
    }

    @Override
    protected C_PtratkituukasiteiKbn valueOf(String pValue) {
        return C_PtratkituukasiteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PtratkituukasiteiKbn pValue) {
        return pValue.getValue();
    }
}

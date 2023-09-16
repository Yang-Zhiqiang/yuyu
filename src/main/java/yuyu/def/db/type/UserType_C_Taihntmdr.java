package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Taihntmdr;

/**
 * {@link C_Taihntmdr 体格判定戻り値} の Hibernate ユーザー定義型です。<br />
 * 体格判定戻り値 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Taihntmdr extends AbstractUserType<C_Taihntmdr> {

    @Override
    protected Class<C_Taihntmdr> returnType() {
        return C_Taihntmdr.class;
    }

    @Override
    protected C_Taihntmdr valueOf(String pValue) {
        return C_Taihntmdr.valueOf(pValue);
    }

    @Override
    protected String toString(C_Taihntmdr pValue) {
        return pValue.getValue();
    }
}

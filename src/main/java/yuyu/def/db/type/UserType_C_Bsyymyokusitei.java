package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Bsyymyokusitei;

/**
 * {@link C_Bsyymyokusitei 募集年月翌月指定} の Hibernate ユーザー定義型です。<br />
 * 募集年月翌月指定 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Bsyymyokusitei extends AbstractUserType<C_Bsyymyokusitei> {

    @Override
    protected Class<C_Bsyymyokusitei> returnType() {
        return C_Bsyymyokusitei.class;
    }

    @Override
    protected C_Bsyymyokusitei valueOf(String pValue) {
        return C_Bsyymyokusitei.valueOf(pValue);
    }

    @Override
    protected String toString(C_Bsyymyokusitei pValue) {
        return pValue.getValue();
    }
}

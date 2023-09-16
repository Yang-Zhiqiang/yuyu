package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AnnaityuuhanteiKbn;

/**
 * {@link C_AnnaityuuhanteiKbn 案内中判定区分} の Hibernate ユーザー定義型です。<br />
 * 案内中判定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AnnaityuuhanteiKbn extends AbstractUserType<C_AnnaityuuhanteiKbn> {

    @Override
    protected Class<C_AnnaityuuhanteiKbn> returnType() {
        return C_AnnaityuuhanteiKbn.class;
    }

    @Override
    protected C_AnnaityuuhanteiKbn valueOf(String pValue) {
        return C_AnnaityuuhanteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AnnaityuuhanteiKbn pValue) {
        return pValue.getValue();
    }
}

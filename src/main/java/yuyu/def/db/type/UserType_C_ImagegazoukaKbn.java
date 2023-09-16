package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ImagegazoukaKbn;

/**
 * {@link C_ImagegazoukaKbn イメージ画像化区分} の Hibernate ユーザー定義型です。<br />
 * イメージ画像化区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ImagegazoukaKbn extends AbstractUserType<C_ImagegazoukaKbn> {

    @Override
    protected Class<C_ImagegazoukaKbn> returnType() {
        return C_ImagegazoukaKbn.class;
    }

    @Override
    protected C_ImagegazoukaKbn valueOf(String pValue) {
        return C_ImagegazoukaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ImagegazoukaKbn pValue) {
        return pValue.getValue();
    }
}

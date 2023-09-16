package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tyuuisyorikahi;

/**
 * {@link C_Tyuuisyorikahi 注意判定処理可否区分} の Hibernate ユーザー定義型です。<br />
 * 注意判定処理可否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tyuuisyorikahi extends AbstractUserType<C_Tyuuisyorikahi> {

    @Override
    protected Class<C_Tyuuisyorikahi> returnType() {
        return C_Tyuuisyorikahi.class;
    }

    @Override
    protected C_Tyuuisyorikahi valueOf(String pValue) {
        return C_Tyuuisyorikahi.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tyuuisyorikahi pValue) {
        return pValue.getValue();
    }
}

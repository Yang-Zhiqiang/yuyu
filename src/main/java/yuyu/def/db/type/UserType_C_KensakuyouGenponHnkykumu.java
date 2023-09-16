package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KensakuyouGenponHnkykumu;

/**
 * {@link C_KensakuyouGenponHnkykumu 検索用原本返却有無} の Hibernate ユーザー定義型です。<br />
 * 検索用原本返却有無 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KensakuyouGenponHnkykumu extends AbstractUserType<C_KensakuyouGenponHnkykumu> {

    @Override
    protected Class<C_KensakuyouGenponHnkykumu> returnType() {
        return C_KensakuyouGenponHnkykumu.class;
    }

    @Override
    protected C_KensakuyouGenponHnkykumu valueOf(String pValue) {
        return C_KensakuyouGenponHnkykumu.valueOf(pValue);
    }

    @Override
    protected String toString(C_KensakuyouGenponHnkykumu pValue) {
        return pValue.getValue();
    }
}

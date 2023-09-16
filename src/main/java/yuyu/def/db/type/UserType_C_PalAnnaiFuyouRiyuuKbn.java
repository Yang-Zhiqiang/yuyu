package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PalAnnaiFuyouRiyuuKbn;

/**
 * {@link C_PalAnnaiFuyouRiyuuKbn ＰＡＬ案内不要理由区分} の Hibernate ユーザー定義型です。<br />
 * ＰＡＬ案内不要理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PalAnnaiFuyouRiyuuKbn extends AbstractUserType<C_PalAnnaiFuyouRiyuuKbn> {

    @Override
    protected Class<C_PalAnnaiFuyouRiyuuKbn> returnType() {
        return C_PalAnnaiFuyouRiyuuKbn.class;
    }

    @Override
    protected C_PalAnnaiFuyouRiyuuKbn valueOf(String pValue) {
        return C_PalAnnaiFuyouRiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PalAnnaiFuyouRiyuuKbn pValue) {
        return pValue.getValue();
    }
}

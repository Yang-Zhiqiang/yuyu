package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KydsskkinyuukntkyKbn;

/**
 * {@link C_KydsskkinyuukntkyKbn 協同組織金融機関適用区分} の Hibernate ユーザー定義型です。<br />
 * 協同組織金融機関適用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KydsskkinyuukntkyKbn extends AbstractUserType<C_KydsskkinyuukntkyKbn> {

    @Override
    protected Class<C_KydsskkinyuukntkyKbn> returnType() {
        return C_KydsskkinyuukntkyKbn.class;
    }

    @Override
    protected C_KydsskkinyuukntkyKbn valueOf(String pValue) {
        return C_KydsskkinyuukntkyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KydsskkinyuukntkyKbn pValue) {
        return pValue.getValue();
    }
}

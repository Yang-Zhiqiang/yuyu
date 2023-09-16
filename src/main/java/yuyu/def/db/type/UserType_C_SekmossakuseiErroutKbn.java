package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;

/**
 * {@link C_SekmossakuseiErroutKbn 設計書申込書作成エラー出力区分} の Hibernate ユーザー定義型です。<br />
 * 設計書申込書作成エラー出力区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SekmossakuseiErroutKbn extends AbstractUserType<C_SekmossakuseiErroutKbn> {

    @Override
    protected Class<C_SekmossakuseiErroutKbn> returnType() {
        return C_SekmossakuseiErroutKbn.class;
    }

    @Override
    protected C_SekmossakuseiErroutKbn valueOf(String pValue) {
        return C_SekmossakuseiErroutKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SekmossakuseiErroutKbn pValue) {
        return pValue.getValue();
    }
}

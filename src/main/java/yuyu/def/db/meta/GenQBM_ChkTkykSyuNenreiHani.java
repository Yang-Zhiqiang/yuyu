package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.db.entity.BM_ChkTkykSyuNenreiHani;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;

/**
 * 特約種類年齢範囲チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkTkykSyuNenreiHani extends AbstractExDBTable<BM_ChkTkykSyuNenreiHani> {

    public GenQBM_ChkTkykSyuNenreiHani() {
        this("BM_ChkTkykSyuNenreiHani");
    }

    public GenQBM_ChkTkykSyuNenreiHani(String pAlias) {
        super("BM_ChkTkykSyuNenreiHani", BM_ChkTkykSyuNenreiHani.class, pAlias);
    }

    public String BM_ChkTkykSyuNenreiHani() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkTkykSyuNenreiHani, C_PmnjtkKbn> pmnjtkkbn = new ExDBFieldString<>("pmnjtkkbn", this, UserType_C_PmnjtkKbn.class);

    public final ExDBFieldString<BM_ChkTkykSyuNenreiHani, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkTkykSyuNenreiHani, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);
}

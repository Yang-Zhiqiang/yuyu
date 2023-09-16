package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkTkykHukaKahi;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 特約付加可否倍率チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkTkykHukaKahi extends AbstractExDBTable<BM_ChkTkykHukaKahi> {

    public GenQBM_ChkTkykHukaKahi() {
        this("BM_ChkTkykHukaKahi");
    }

    public GenQBM_ChkTkykHukaKahi(String pAlias) {
        super("BM_ChkTkykHukaKahi", BM_ChkTkykHukaKahi.class, pAlias);
    }

    public String BM_ChkTkykHukaKahi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkTkykHukaKahi, String> tksyouhncd = new ExDBFieldString<>("tksyouhncd", this);

    public final ExDBFieldString<BM_ChkTkykHukaKahi, String> syusyouhncd = new ExDBFieldString<>("syusyouhncd", this);

    public final ExDBFieldNumber<BM_ChkTkykHukaKahi, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkTkykHukaKahi, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldString<BM_ChkTkykHukaKahi, C_Channelcd> channelcd = new ExDBFieldString<>("channelcd", this, UserType_C_Channelcd.class);

    public final ExDBFieldNumber<BM_ChkTkykHukaKahi, Integer> hukakahikbn = new ExDBFieldNumber<>("hukakahikbn", this);

    public final ExDBFieldString<BM_ChkTkykHukaKahi, String> tkbairituhugou = new ExDBFieldString<>("tkbairituhugou", this);

    public final ExDBFieldString<BM_ChkTkykHukaKahi, BizNumber> tkbairitu = new ExDBFieldString<>("tkbairitu", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkTkykHukaKahi, C_UmuKbn> tkhukahissuumu = new ExDBFieldString<>("tkhukahissuumu", this, UserType_C_UmuKbn.class);
}

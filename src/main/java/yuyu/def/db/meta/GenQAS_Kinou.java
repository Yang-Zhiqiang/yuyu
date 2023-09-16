package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_BatchKyouseiSyuuryouFlag;
import yuyu.def.classification.C_BatchLogHyoujiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.type.UserType_C_BatchKyouseiSyuuryouFlag;
import yuyu.def.db.type.UserType_C_BatchLogHyoujiKbn;
import yuyu.def.db.type.UserType_C_KahiKbn;
import yuyu.def.db.type.UserType_C_KinouKbn;
import yuyu.def.db.type.UserType_C_TaisyouKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;

/**
 * 機能基幹テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAS_Kinou extends AbstractExDBTable<AS_Kinou> {

    public GenQAS_Kinou() {
        this("AS_Kinou");
    }

    public GenQAS_Kinou(String pAlias) {
        super("AS_Kinou", AS_Kinou.class, pAlias);
    }

    public String AS_Kinou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AS_Kinou, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<AS_Kinou, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<AS_Kinou, String> categoryId = new ExDBFieldString<>("categoryId", this);

    public final ExDBFieldString<AS_Kinou, String> kinouNm = new ExDBFieldString<>("kinouNm", this);

    public final ExDBFieldNumber<AS_Kinou, Integer> sortNo = new ExDBFieldNumber<>("sortNo", this);

    public final ExDBFieldString<AS_Kinou, C_KinouKbn> kinouKbn = new ExDBFieldString<>("kinouKbn", this, UserType_C_KinouKbn.class);

    public final ExDBFieldString<AS_Kinou, String> jikkouPath = new ExDBFieldString<>("jikkouPath", this);

    public final ExDBFieldString<AS_Kinou, String> kinouSetumei = new ExDBFieldString<>("kinouSetumei", this);

    public final ExDBFieldString<AS_Kinou, C_BatchKyouseiSyuuryouFlag> batchKyouseiSyuuryouFlag = new ExDBFieldString<>("batchKyouseiSyuuryouFlag", this, UserType_C_BatchKyouseiSyuuryouFlag.class);

    public final ExDBFieldString<AS_Kinou, C_KahiKbn> menuHyoujiKahi = new ExDBFieldString<>("menuHyoujiKahi", this, UserType_C_KahiKbn.class);

    public final ExDBFieldString<AS_Kinou, C_BatchLogHyoujiKbn> batchLogHyoujiKbn = new ExDBFieldString<>("batchLogHyoujiKbn", this, UserType_C_BatchLogHyoujiKbn.class);

    public final ExDBFieldString<AS_Kinou, C_YouhiKbn> kidouKengenHanteiYouhiKbn = new ExDBFieldString<>("kidouKengenHanteiYouhiKbn", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<AS_Kinou, C_TaisyouKbn> kinouTeigiTaisyouKbn = new ExDBFieldString<>("kinouTeigiTaisyouKbn", this, UserType_C_TaisyouKbn.class);

    public final ExDBFieldString<AS_Kinou, String> syoricd = new ExDBFieldString<>("syoricd", this);
}

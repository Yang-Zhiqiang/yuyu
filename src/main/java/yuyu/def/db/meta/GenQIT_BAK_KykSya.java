package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Tdk;
import yuyu.def.db.entity.IT_BAK_KykSya;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HjndaiykKbn;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_Tdk;

/**
 * 契約者バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KykSya extends AbstractExDBTable<IT_BAK_KykSya> {

    public GenQIT_BAK_KykSya() {
        this("IT_BAK_KykSya");
    }

    public GenQIT_BAK_KykSya(String pAlias) {
        super("IT_BAK_KykSya", IT_BAK_KykSya.class, pAlias);
    }

    public String IT_BAK_KykSya() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KykSya, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> kokno = new ExDBFieldString<>("kokno", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> kyksakuinmeino = new ExDBFieldString<>("kyksakuinmeino", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_BAK_KykSya, C_KjkhukaKbn> kyknmkjkhukakbn = new ExDBFieldString<>("kyknmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IT_BAK_KykSya, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KykSya, C_Kyksei> kyksei = new ExDBFieldString<>("kyksei", this, UserType_C_Kyksei.class);

    public final ExDBFieldString<IT_BAK_KykSya, C_Tdk> kkkyktdk = new ExDBFieldString<>("kkkyktdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<IT_BAK_KykSya, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> tsinadr1kn = new ExDBFieldString<>("tsinadr1kn", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> tsinadr2kn = new ExDBFieldString<>("tsinadr2kn", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> tsinadr3kn = new ExDBFieldString<>("tsinadr3kn", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> dai2tsintelno = new ExDBFieldString<>("dai2tsintelno", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> tsinmailaddress = new ExDBFieldString<>("tsinmailaddress", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> kinmusakinm = new ExDBFieldString<>("kinmusakinm", this);

    public final ExDBFieldString<IT_BAK_KykSya, C_HjndaiykKbn> hjndaiykkbn = new ExDBFieldString<>("hjndaiykkbn", this, UserType_C_HjndaiykKbn.class);

    public final ExDBFieldString<IT_BAK_KykSya, String> hjndaiyknm = new ExDBFieldString<>("hjndaiyknm", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> hjndainmkn = new ExDBFieldString<>("hjndainmkn", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> hjndainmkj = new ExDBFieldString<>("hjndainmkj", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KykSya, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}

package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.db.entity.IT_BAK_KhTumitateDKanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_NaiteiKakuteiKbn;
import yuyu.def.db.type.UserType_C_TumitateDSakuseiKbn;

/**
 * 積立Ｄ管理バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KhTumitateDKanri extends AbstractExDBTable<IT_BAK_KhTumitateDKanri> {

    public GenQIT_BAK_KhTumitateDKanri() {
        this("IT_BAK_KhTumitateDKanri");
    }

    public GenQIT_BAK_KhTumitateDKanri(String pAlias) {
        super("IT_BAK_KhTumitateDKanri", IT_BAK_KhTumitateDKanri.class, pAlias);
    }

    public String IT_BAK_KhTumitateDKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KhTumitateDKanri, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KhTumitateDKanri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KhTumitateDKanri, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_KhTumitateDKanri, BizDate> tumitatedtumitateymd = new ExDBFieldString<>("tumitatedtumitateymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_KhTumitateDKanri, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_BAK_KhTumitateDKanri, C_TumitateDSakuseiKbn> tumitatedskskbn = new ExDBFieldString<>("tumitatedskskbn", this, UserType_C_TumitateDSakuseiKbn.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhTumitateDKanri> tumitated = new ExDBFieldBizCurrency<>("tumitated", this);

    public final ExDBFieldString<IT_BAK_KhTumitateDKanri, BizDate> tumitatedshrkrkymd = new ExDBFieldString<>("tumitatedshrkrkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhTumitateDKanri, C_NaiteiKakuteiKbn> naiteikakuteikbn = new ExDBFieldString<>("naiteikakuteikbn", this, UserType_C_NaiteiKakuteiKbn.class);

    public final ExDBFieldString<IT_BAK_KhTumitateDKanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KhTumitateDKanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KhTumitateDKanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}

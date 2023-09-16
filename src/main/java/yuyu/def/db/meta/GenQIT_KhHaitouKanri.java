package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import yuyu.def.db.type.UserType_C_HaitoukinsksKbn;
import yuyu.def.db.type.UserType_C_HaitoumeisaiKbn;
import yuyu.def.db.type.UserType_C_NaiteiKakuteiKbn;

/**
 * 配当管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhHaitouKanri extends AbstractExDBTable<IT_KhHaitouKanri> {

    public GenQIT_KhHaitouKanri() {
        this("IT_KhHaitouKanri");
    }

    public GenQIT_KhHaitouKanri(String pAlias) {
        super("IT_KhHaitouKanri", IT_KhHaitouKanri.class, pAlias);
    }

    public String IT_KhHaitouKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhHaitouKanri, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KhHaitouKanri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhHaitouKanri, BizDateY> haitounendo = new ExDBFieldString<>("haitounendo", this, BizDateYType.class);

    public final ExDBFieldNumber<IT_KhHaitouKanri, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_KhHaitouKanri, C_HaitoukinsksKbn> haitoukinskskbn = new ExDBFieldString<>("haitoukinskskbn", this, UserType_C_HaitoukinsksKbn.class);

    public final ExDBFieldString<IT_KhHaitouKanri, C_HaitoumeisaiKbn> haitoumeisaikbn = new ExDBFieldString<>("haitoumeisaikbn", this, UserType_C_HaitoumeisaiKbn.class);

    public final ExDBFieldString<IT_KhHaitouKanri, BizDateY> fstkariwariatednendo = new ExDBFieldString<>("fstkariwariatednendo", this, BizDateYType.class);

    public final ExDBFieldBizCurrency<IT_KhHaitouKanri> tounendod = new ExDBFieldBizCurrency<>("tounendod", this);

    public final ExDBFieldString<IT_KhHaitouKanri, C_NaiteiKakuteiKbn> naiteikakuteikbn = new ExDBFieldString<>("naiteikakuteikbn", this, UserType_C_NaiteiKakuteiKbn.class);

    public final ExDBFieldString<IT_KhHaitouKanri, BizDate> kariwariatedshrymd = new ExDBFieldString<>("kariwariatedshrymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KhHaitouKanri> kariwariatedruigk = new ExDBFieldBizCurrency<>("kariwariatedruigk", this);

    public final ExDBFieldBizCurrency<IT_KhHaitouKanri> kariwariatedgngkkngk = new ExDBFieldBizCurrency<>("kariwariatedgngkkngk", this);

    public final ExDBFieldBizCurrency<IT_KhHaitouKanri> kariwariatedshrgk = new ExDBFieldBizCurrency<>("kariwariatedshrgk", this);

    public final ExDBFieldString<IT_KhHaitouKanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhHaitouKanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhHaitouKanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}

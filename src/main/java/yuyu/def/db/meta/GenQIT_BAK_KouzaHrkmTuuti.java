package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_BAK_KouzaHrkmTuuti;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 口座振込通知バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KouzaHrkmTuuti extends AbstractExDBTable<IT_BAK_KouzaHrkmTuuti> {

    public GenQIT_BAK_KouzaHrkmTuuti() {
        this("IT_BAK_KouzaHrkmTuuti");
    }

    public GenQIT_BAK_KouzaHrkmTuuti(String pAlias) {
        super("IT_BAK_KouzaHrkmTuuti", IT_BAK_KouzaHrkmTuuti.class, pAlias);
    }

    public String IT_BAK_KouzaHrkmTuuti() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<IT_BAK_KouzaHrkmTuuti, Integer> krkno = new ExDBFieldNumber<>("krkno", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> toiawaseyno = new ExDBFieldString<>("toiawaseyno", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> toiawaseadr1kj = new ExDBFieldString<>("toiawaseadr1kj", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> toiawaseadr2kj = new ExDBFieldString<>("toiawaseadr2kj", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> toiawaseadr3kj = new ExDBFieldString<>("toiawaseadr3kj", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> toiawaseteluktkkanou1 = new ExDBFieldString<>("toiawaseteluktkkanou1", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> toiawaseteluktkkanou2 = new ExDBFieldString<>("toiawaseteluktkkanou2", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> toiawasesosikinmkj2 = new ExDBFieldString<>("toiawasesosikinmkj2", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> toiawasetelno2 = new ExDBFieldString<>("toiawasetelno2", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, BizDate> hurikomiymd = new ExDBFieldString<>("hurikomiymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_BAK_KouzaHrkmTuuti> shrgk = new ExDBFieldBizCurrency<>("shrgk", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> shririyuu1 = new ExDBFieldString<>("shririyuu1", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> shririyuu2 = new ExDBFieldString<>("shririyuu2", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> shririyuu3 = new ExDBFieldString<>("shririyuu3", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> siteikouza1 = new ExDBFieldString<>("siteikouza1", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> siteikouza2 = new ExDBFieldString<>("siteikouza2", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> siteikouza3 = new ExDBFieldString<>("siteikouza3", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> siteikouza4 = new ExDBFieldString<>("siteikouza4", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> siteikouza5 = new ExDBFieldString<>("siteikouza5", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KouzaHrkmTuuti, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}

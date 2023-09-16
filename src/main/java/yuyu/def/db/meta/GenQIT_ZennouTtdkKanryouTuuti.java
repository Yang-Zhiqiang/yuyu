package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_ZennouSyoriKbn;
import yuyu.def.db.entity.IT_ZennouTtdkKanryouTuuti;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_ZennouSyoriKbn;

/**
 * 前納手続完了通知書テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_ZennouTtdkKanryouTuuti extends AbstractExDBTable<IT_ZennouTtdkKanryouTuuti> {

    public GenQIT_ZennouTtdkKanryouTuuti() {
        this("IT_ZennouTtdkKanryouTuuti");
    }

    public GenQIT_ZennouTtdkKanryouTuuti(String pAlias) {
        super("IT_ZennouTtdkKanryouTuuti", IT_ZennouTtdkKanryouTuuti.class, pAlias);
    }

    public String IT_ZennouTtdkKanryouTuuti() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, BizDateYM> zennoustartym = new ExDBFieldString<>("zennoustartym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, C_ZennouSyoriKbn> zennousyorikbn = new ExDBFieldString<>("zennousyorikbn", this, UserType_C_ZennouSyoriKbn.class);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, BizDate> zennounyuukinsyoriymd = new ExDBFieldString<>("zennounyuukinsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, BizDate> zennounyuukindenymd = new ExDBFieldString<>("zennounyuukindenymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, String> zennoukikan = new ExDBFieldString<>("zennoukikan", this);

    public final ExDBFieldBizCurrency<IT_ZennouTtdkKanryouTuuti> zennounyuukinkgk = new ExDBFieldBizCurrency<>("zennounyuukinkgk", this);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, BizDateYM> annaisaikaiym = new ExDBFieldString<>("annaisaikaiym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_ZennouTtdkKanryouTuuti, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}

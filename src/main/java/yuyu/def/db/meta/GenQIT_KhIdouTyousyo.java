package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_ShrtysyhknsyuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.IT_KhIdouTyousyo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_ShrtysyhknsyuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;

/**
 * 契約保全異動調書テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhIdouTyousyo extends AbstractExDBTable<IT_KhIdouTyousyo> {

    public GenQIT_KhIdouTyousyo() {
        this("IT_KhIdouTyousyo");
    }

    public GenQIT_KhIdouTyousyo(String pAlias) {
        super("IT_KhIdouTyousyo", IT_KhIdouTyousyo.class, pAlias);
    }

    public String IT_KhIdouTyousyo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhIdouTyousyo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_KhIdouTyousyo, Long> shrtysyrenno = new ExDBFieldNumber<>("shrtysyrenno", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> kacd = new ExDBFieldString<>("kacd", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> hknsyukigou = new ExDBFieldString<>("hknsyukigou", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> shrtysysyuruicd = new ExDBFieldString<>("shrtysysyuruicd", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> syoritaisyoukbn = new ExDBFieldString<>("syoritaisyoukbn", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> tblsakuseihunodisp = new ExDBFieldString<>("tblsakuseihunodisp", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> oldtsinyno = new ExDBFieldString<>("oldtsinyno", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> oldtsinadr1kj = new ExDBFieldString<>("oldtsinadr1kj", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> oldtsinadr2kj = new ExDBFieldString<>("oldtsinadr2kj", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> oldtsinadr3kj = new ExDBFieldString<>("oldtsinadr3kj", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> oldkyknmkj = new ExDBFieldString<>("oldkyknmkj", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, BizDate> oldkyksibouymd = new ExDBFieldString<>("oldkyksibouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhIdouTyousyo, BizDate> kouryokuhasseiymd = new ExDBFieldString<>("kouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhIdouTyousyo, BizDate> kyksiboumeighnksyoriymd = new ExDBFieldString<>("kyksiboumeighnksyoriymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KhIdouTyousyo> kaiyakuhrstgk = new ExDBFieldBizCurrency<>("kaiyakuhrstgk", this);

    public final ExDBFieldBizCurrency<IT_KhIdouTyousyo> kihrkmp = new ExDBFieldBizCurrency<>("kihrkmp", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> oldkykkihrkmpyouhyj = new ExDBFieldString<>("oldkykkihrkmpyouhyj", this);

    public final ExDBFieldBizCurrency<IT_KhIdouTyousyo> oldkykkihrkmp = new ExDBFieldBizCurrency<>("oldkykkihrkmp", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, BizDate> sakuseiymd = new ExDBFieldString<>("sakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> huho2kykdisp = new ExDBFieldString<>("huho2kykdisp", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, C_ShrtysyhknsyuKbn> shrtysyhknsyukbn = new ExDBFieldString<>("shrtysyhknsyukbn", this, UserType_C_ShrtysyhknsyuKbn.class);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhIdouTyousyo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}

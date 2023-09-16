package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_NayoseJyoutaiKbn;
import yuyu.def.classification.C_SirajiKykKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.HT_NayoseKekka;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_BlnktkumuKbn;
import yuyu.def.db.type.UserType_C_MQSyoukaiErrorKbn;
import yuyu.def.db.type.UserType_C_NayoseJissiKekkaKbn;
import yuyu.def.db.type.UserType_C_NayoseJyoutaiKbn;
import yuyu.def.db.type.UserType_C_SirajiKykKbn;
import yuyu.def.db.type.UserType_C_SntkInfoTaisyousyaKbn;
import yuyu.def.db.type.UserType_C_YouhiblnkKbn;

/**
 * 名寄せ結果テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_NayoseKekka extends AbstractExDBTable<HT_NayoseKekka> {

    public GenQHT_NayoseKekka() {
        this("HT_NayoseKekka");
    }

    public GenQHT_NayoseKekka(String pAlias) {
        super("HT_NayoseKekka", HT_NayoseKekka.class, pAlias);
    }

    public String HT_NayoseKekka() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_NayoseKekka, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_NayoseKekka, C_SntkInfoTaisyousyaKbn> sntkinfotaisyousyakbn = new ExDBFieldString<>("sntkinfotaisyousyakbn", this, UserType_C_SntkInfoTaisyousyaKbn.class);

    public final ExDBFieldNumber<HT_NayoseKekka, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<HT_NayoseKekka, String> sakuinnmno = new ExDBFieldString<>("sakuinnmno", this);

    public final ExDBFieldString<HT_NayoseKekka, C_NayoseJissiKekkaKbn> nysjissikekkakbn = new ExDBFieldString<>("nysjissikekkakbn", this, UserType_C_NayoseJissiKekkaKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_NayoseJyoutaiKbn> nysjyoutaikbn = new ExDBFieldString<>("nysjyoutaikbn", this, UserType_C_NayoseJyoutaiKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_MQSyoukaiErrorKbn> sakuininfosyoukaierrkbn = new ExDBFieldString<>("sakuininfosyoukaierrkbn", this, UserType_C_MQSyoukaiErrorKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_MQSyoukaiErrorKbn> mrsyoukaierrkbn = new ExDBFieldString<>("mrsyoukaierrkbn", this, UserType_C_MQSyoukaiErrorKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_MQSyoukaiErrorKbn> signalsyoukaierrkbn = new ExDBFieldString<>("signalsyoukaierrkbn", this, UserType_C_MQSyoukaiErrorKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_MQSyoukaiErrorKbn> sinsntkhnsysyoukaierrkbn = new ExDBFieldString<>("sinsntkhnsysyoukaierrkbn", this, UserType_C_MQSyoukaiErrorKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_MQSyoukaiErrorKbn> tsngksyoukaierrkbn = new ExDBFieldString<>("tsngksyoukaierrkbn", this, UserType_C_MQSyoukaiErrorKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_MQSyoukaiErrorKbn> kykdrtentsnssyoukaierrkbn = new ExDBFieldString<>("kykdrtentsnssyoukaierrkbn", this, UserType_C_MQSyoukaiErrorKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_MQSyoukaiErrorKbn> mossakuseikahisyoukaierrkbn = new ExDBFieldString<>("mossakuseikahisyoukaierrkbn", this, UserType_C_MQSyoukaiErrorKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_MQSyoukaiErrorKbn> hndketyhsyoukaierrkbn = new ExDBFieldString<>("hndketyhsyoukaierrkbn", this, UserType_C_MQSyoukaiErrorKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_BlnktkumuKbn> sntkinfomrumukbn = new ExDBFieldString<>("sntkinfomrumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_BlnktkumuKbn> sntkinfohnsyumukbn = new ExDBFieldString<>("sntkinfohnsyumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_BlnktkumuKbn> signalsetteiumukbn = new ExDBFieldString<>("signalsetteiumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_BlnktkumuKbn> signalinfohnsyumukbn = new ExDBFieldString<>("signalinfohnsyumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_BlnktkumuKbn> gaikokupepsumukbn = new ExDBFieldString<>("gaikokupepsumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_BlnktkumuKbn> sinsntkhnsyumukbn = new ExDBFieldString<>("sinsntkhnsyumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_YouhiblnkKbn> itekisntkhndktyhkbn = new ExDBFieldString<>("itekisntkhndktyhkbn", this, UserType_C_YouhiblnkKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_YouhiblnkKbn> ttdktyuuiknkhndktyhkbn = new ExDBFieldString<>("ttdktyuuiknkhndktyhkbn", this, UserType_C_YouhiblnkKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_YouhiblnkKbn> kyhkinuktkariitkhndktyhkbn = new ExDBFieldString<>("kyhkinuktkariitkhndktyhkbn", this, UserType_C_YouhiblnkKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_YouhiblnkKbn> doujimositekihndktyhkbn = new ExDBFieldString<>("doujimositekihndktyhkbn", this, UserType_C_YouhiblnkKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_YouhiblnkKbn> doujimosknkhndktyhkbn = new ExDBFieldString<>("doujimosknkhndktyhkbn", this, UserType_C_YouhiblnkKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, C_SirajiKykKbn> sirajikykkbn = new ExDBFieldString<>("sirajikykkbn", this, UserType_C_SirajiKykKbn.class);

    public final ExDBFieldString<HT_NayoseKekka, BizDate> kikykinfoseiymd = new ExDBFieldString<>("kikykinfoseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_NayoseKekka, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_NayoseKekka, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}

package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyuShrgkSyoukeiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.IT_BAK_KhShrRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HtsiryosyuKbn;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_ShrsyoriKbn;
import yuyu.def.db.type.UserType_C_SinsaGendoKknKbn;
import yuyu.def.db.type.UserType_C_SoukinsakisiteiKbn;
import yuyu.def.db.type.UserType_C_SyuShrgkSyoukeiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_ZeitratkiKbn;

/**
 * 契約保全支払履歴バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KhShrRireki extends AbstractExDBTable<IT_BAK_KhShrRireki> {

    public GenQIT_BAK_KhShrRireki() {
        this("IT_BAK_KhShrRireki");
    }

    public GenQIT_BAK_KhShrRireki(String pAlias) {
        super("IT_BAK_KhShrRireki", IT_BAK_KhShrRireki.class, pAlias);
    }

    public String IT_BAK_KhShrRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, BizDate> shrymd = new ExDBFieldString<>("shrymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, BizDate> shrsyoriymd = new ExDBFieldString<>("shrsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_ShrsyoriKbn> shrsyorikbn = new ExDBFieldString<>("shrsyorikbn", this, UserType_C_ShrsyoriKbn.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_UmuKbn> torikesiflg = new ExDBFieldString<>("torikesiflg", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, BizDate> torikesiymd = new ExDBFieldString<>("torikesiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, BizDate> kouryokuhasseiymd = new ExDBFieldString<>("kouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, BizDate> shrtienrskkisanymd = new ExDBFieldString<>("shrtienrskkisanymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_KhShrRireki, Integer> tienrsknissuu = new ExDBFieldNumber<>("tienrsknissuu", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_SinsaGendoKknKbn> sinsagendokknkbn = new ExDBFieldString<>("sinsagendokknkbn", this, UserType_C_SinsaGendoKknKbn.class);

    public final ExDBFieldNumber<IT_BAK_KhShrRireki, Integer> rikoukityuutuudannissuu = new ExDBFieldNumber<>("rikoukityuutuudannissuu", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_ZeitratkiKbn> zeitratkikbn = new ExDBFieldString<>("zeitratkikbn", this, UserType_C_ZeitratkiKbn.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_UmuKbn> gsbunritaisyou = new ExDBFieldString<>("gsbunritaisyou", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_UmuKbn> yenshrtkumu = new ExDBFieldString<>("yenshrtkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> shrgkkei = new ExDBFieldBizCurrency<>("shrgkkei", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_SyuShrgkSyoukeiKbn> syushrgkkeisyukbn = new ExDBFieldString<>("syushrgkkeisyukbn", this, UserType_C_SyuShrgkSyoukeiKbn.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> syushrgkkei = new ExDBFieldBizCurrency<>("syushrgkkei", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> mikeikap = new ExDBFieldBizCurrency<>("mikeikap", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> haitoukin = new ExDBFieldBizCurrency<>("haitoukin", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> sonotaseisangk = new ExDBFieldBizCurrency<>("sonotaseisangk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> gstszeigk = new ExDBFieldBizCurrency<>("gstszeigk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> shrtienrsk = new ExDBFieldBizCurrency<>("shrtienrsk", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> shrtuukashrgkgoukei = new ExDBFieldBizCurrency<>("shrtuukashrgkgoukei", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> shrtuukasyushrgkkei = new ExDBFieldBizCurrency<>("shrtuukasyushrgkkei", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> shrtuukahaitoukin = new ExDBFieldBizCurrency<>("shrtuukahaitoukin", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> shrtuukasonotaseisangk = new ExDBFieldBizCurrency<>("shrtuukasonotaseisangk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> shrtuukagstszeigk = new ExDBFieldBizCurrency<>("shrtuukagstszeigk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> shrtuukashrtienrsk = new ExDBFieldBizCurrency<>("shrtuukashrtienrsk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yenshrgkgoukei = new ExDBFieldBizCurrency<>("yenshrgkgoukei", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yensyushrgkkei = new ExDBFieldBizCurrency<>("yensyushrgkkei", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yenkansanhaitoukin = new ExDBFieldBizCurrency<>("yenkansanhaitoukin", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yenkansansonotaseisangk = new ExDBFieldBizCurrency<>("yenkansansonotaseisangk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yenmikeikap = new ExDBFieldBizCurrency<>("yenmikeikap", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yengstszeigk = new ExDBFieldBizCurrency<>("yengstszeigk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yengstszeigknationaltax = new ExDBFieldBizCurrency<>("yengstszeigknationaltax", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yengstszeigklocaltax = new ExDBFieldBizCurrency<>("yengstszeigklocaltax", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> nztodouhukencd = new ExDBFieldString<>("nztodouhukencd", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yenshrtienrsk = new ExDBFieldBizCurrency<>("yenshrtienrsk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> htykeihi = new ExDBFieldBizCurrency<>("htykeihi", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> kztgk = new ExDBFieldBizCurrency<>("kztgk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yenhtykeihi = new ExDBFieldBizCurrency<>("yenhtykeihi", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yenkztgk = new ExDBFieldBizCurrency<>("yenkztgk", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, BizDate> shrkwsratekjnymd = new ExDBFieldString<>("shrkwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, BizNumber> shrkwsrate = new ExDBFieldString<>("shrkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, BizDate> zeimukwsratekjnymd = new ExDBFieldString<>("zeimukwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, BizNumber> zeimukwsrate = new ExDBFieldString<>("zeimukwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_SoukinsakisiteiKbn> soukinsakisiteikbn = new ExDBFieldString<>("soukinsakisiteikbn", this, UserType_C_SoukinsakisiteiKbn.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> soukinsakinmkn = new ExDBFieldString<>("soukinsakinmkn", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> soukinsakinmkj = new ExDBFieldString<>("soukinsakinmkj", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> soukinsakiyno = new ExDBFieldString<>("soukinsakiyno", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> soukinsakiadr1kj = new ExDBFieldString<>("soukinsakiadr1kj", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> soukinsakiadr2kj = new ExDBFieldString<>("soukinsakiadr2kj", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> soukinsakiadr3kj = new ExDBFieldString<>("soukinsakiadr3kj", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> kyksyaszknmkn = new ExDBFieldString<>("kyksyaszknmkn", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> kyksyaszknmkj = new ExDBFieldString<>("kyksyaszknmkj", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> kyksyaszkyno = new ExDBFieldString<>("kyksyaszkyno", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> kyksyaszkadr1kj = new ExDBFieldString<>("kyksyaszkadr1kj", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> kyksyaszkadr2kj = new ExDBFieldString<>("kyksyaszkadr2kj", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> kyksyaszkadr3kj = new ExDBFieldString<>("kyksyaszkadr3kj", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> saikennmkj = new ExDBFieldString<>("saikennmkj", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> saikennyno = new ExDBFieldString<>("saikennyno", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> saikenadr1kj = new ExDBFieldString<>("saikenadr1kj", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> saikenadr2kj = new ExDBFieldString<>("saikenadr2kj", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> saikenadr3kj = new ExDBFieldString<>("saikenadr3kj", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_InputShrhousiteiKbn> inputshrhousiteikbn = new ExDBFieldString<>("inputshrhousiteikbn", this, UserType_C_InputShrhousiteiKbn.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_ShrhousiteiKbn> shrhousiteikbn = new ExDBFieldString<>("shrhousiteikbn", this, UserType_C_ShrhousiteiKbn.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_KouzasyuruiKbn> kzsyuruikbn = new ExDBFieldString<>("kzsyuruikbn", this, UserType_C_KouzasyuruiKbn.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_Kzdou> kzdoukbn = new ExDBFieldString<>("kzdoukbn", this, UserType_C_Kzdou.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> kykmnmeigibangou = new ExDBFieldString<>("kykmnmeigibangou", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> uktmnmeigibangou = new ExDBFieldString<>("uktmnmeigibangou", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_HtsiryosyuKbn> shrtysysyuruikbn = new ExDBFieldString<>("shrtysysyuruikbn", this, UserType_C_HtsiryosyuKbn.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yenshrkykhtykeihi = new ExDBFieldBizCurrency<>("yenshrkykhtykeihi", this);

    public final ExDBFieldNumber<IT_BAK_KhShrRireki, Integer> kykhnkkaisuu = new ExDBFieldNumber<>("kykhnkkaisuu", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> shrmikeikap = new ExDBFieldBizCurrency<>("shrmikeikap", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> zennomikeikap = new ExDBFieldBizCurrency<>("zennomikeikap", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> shrzennomikeikap = new ExDBFieldBizCurrency<>("shrzennomikeikap", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yenzennomikeikap = new ExDBFieldBizCurrency<>("yenzennomikeikap", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> zitkazukarikingksiteituuka = new ExDBFieldBizCurrency<>("zitkazukarikingksiteituuka", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> zitkazukarikingkyen = new ExDBFieldBizCurrency<>("zitkazukarikingkyen", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> shrazukarikingk = new ExDBFieldBizCurrency<>("shrazukarikingk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yenazukarikingk = new ExDBFieldBizCurrency<>("yenazukarikingk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> sonotahaitoukin = new ExDBFieldBizCurrency<>("sonotahaitoukin", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> shrtuukasonotahaitoukin = new ExDBFieldBizCurrency<>("shrtuukasonotahaitoukin", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yensonotahaitoukin = new ExDBFieldBizCurrency<>("yensonotahaitoukin", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> krkgk = new ExDBFieldBizCurrency<>("krkgk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> shrkrkgk = new ExDBFieldBizCurrency<>("shrkrkgk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yenkrkgk = new ExDBFieldBizCurrency<>("yenkrkgk", this);

    public final ExDBFieldString<IT_BAK_KhShrRireki, C_UmuKbn> zeitekiazukarikinkjumu = new ExDBFieldString<>("zeitekiazukarikinkjumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, BizDate> gaikashrkwsratekjnymd = new ExDBFieldString<>("gaikashrkwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhShrRireki, BizNumber> gaikashrkwsrate = new ExDBFieldString<>("gaikashrkwsrate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> kaiyakuhrkngkkeisiteituuka = new ExDBFieldBizCurrency<>("kaiyakuhrkngkkeisiteituuka", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> shrtuukakaiyakuhrkngkkei = new ExDBFieldBizCurrency<>("shrtuukakaiyakuhrkngkkei", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> kaiyakuhrkngkkeiyen = new ExDBFieldBizCurrency<>("kaiyakuhrkngkkeiyen", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> sonotashrkngksiteituuka = new ExDBFieldBizCurrency<>("sonotashrkngksiteituuka", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> shrtuukasonotashrkngk = new ExDBFieldBizCurrency<>("shrtuukasonotashrkngk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> sonotashrkngkyen = new ExDBFieldBizCurrency<>("sonotashrkngkyen", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhShrRireki> yensynykngk = new ExDBFieldBizCurrency<>("yensynykngk", this);
}

package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykMsnKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.def.db.entity.IT_SyoumetuTuuti;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HtsiryosyuKbn;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_KykMsnKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_ZeimuNaiyouHnsyuCtrlKbn;

/**
 * 消滅通知テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_SyoumetuTuuti extends AbstractExDBTable<IT_SyoumetuTuuti> {

    public GenQIT_SyoumetuTuuti() {
        this("IT_SyoumetuTuuti");
    }

    public GenQIT_SyoumetuTuuti(String pAlias) {
        super("IT_SyoumetuTuuti", IT_SyoumetuTuuti.class, pAlias);
    }

    public String IT_SyoumetuTuuti() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_SyoumetuTuuti, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<IT_SyoumetuTuuti, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_SyoumetuTuuti, C_UmuKbn> sksdoufuukbn = new ExDBFieldString<>("sksdoufuukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_SyoumetuTuuti, C_UmuKbn> mynosinkokuiraidoufuukbn = new ExDBFieldString<>("mynosinkokuiraidoufuukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> toiawaseyno = new ExDBFieldString<>("toiawaseyno", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> toiawaseadr1kj = new ExDBFieldString<>("toiawaseadr1kj", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> toiawaseadr2kj = new ExDBFieldString<>("toiawaseadr2kj", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> toiawaseadr3kj = new ExDBFieldString<>("toiawaseadr3kj", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> toiawasekaisyanmkj = new ExDBFieldString<>("toiawasekaisyanmkj", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> toiawaseteluktkkanou1 = new ExDBFieldString<>("toiawaseteluktkkanou1", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> toiawaseteluktkkanou2 = new ExDBFieldString<>("toiawaseteluktkkanou2", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> toiawasesosikinmkj2 = new ExDBFieldString<>("toiawasesosikinmkj2", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> toiawasetelno2 = new ExDBFieldString<>("toiawasetelno2", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, BizDate> syoumetuymd = new ExDBFieldString<>("syoumetuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SyoumetuTuuti, BizDate> shrymd = new ExDBFieldString<>("shrymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, BizDate> keiyakuymd = new ExDBFieldString<>("keiyakuymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_SyoumetuTuuti> shrtuukakaiyakuhrkngkkei = new ExDBFieldBizCurrency<>("shrtuukakaiyakuhrkngkkei", this);

    public final ExDBFieldBizCurrency<IT_SyoumetuTuuti> kaiyakuhrkngkkeisiteituuka = new ExDBFieldBizCurrency<>("kaiyakuhrkngkkeisiteituuka", this);

    public final ExDBFieldBizCurrency<IT_SyoumetuTuuti> sonotaseisan = new ExDBFieldBizCurrency<>("sonotaseisan", this);

    public final ExDBFieldBizCurrency<IT_SyoumetuTuuti> yenkansanhaitoukin = new ExDBFieldBizCurrency<>("yenkansanhaitoukin", this);

    public final ExDBFieldBizCurrency<IT_SyoumetuTuuti> yensonotahaitoukin = new ExDBFieldBizCurrency<>("yensonotahaitoukin", this);

    public final ExDBFieldBizCurrency<IT_SyoumetuTuuti> shrtuukagstszeigk = new ExDBFieldBizCurrency<>("shrtuukagstszeigk", this);

    public final ExDBFieldBizCurrency<IT_SyoumetuTuuti> zitkazukarikingksiteituuka = new ExDBFieldBizCurrency<>("zitkazukarikingksiteituuka", this);

    public final ExDBFieldBizCurrency<IT_SyoumetuTuuti> shrgkkei = new ExDBFieldBizCurrency<>("shrgkkei", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_SyoumetuTuuti, BizNumber> shrkwsrate = new ExDBFieldString<>("shrkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> banknmkj = new ExDBFieldString<>("banknmkj", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> sitennmkj = new ExDBFieldString<>("sitennmkj", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, C_KouzasyuruiKbn> kzsyuruikbn = new ExDBFieldString<>("kzsyuruikbn", this, UserType_C_KouzasyuruiKbn.class);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, C_HtsiryosyuKbn> htsiryosyukbn = new ExDBFieldString<>("htsiryosyukbn", this, UserType_C_HtsiryosyuKbn.class);

    public final ExDBFieldBizCurrency<IT_SyoumetuTuuti> synykngk = new ExDBFieldBizCurrency<>("synykngk", this);

    public final ExDBFieldBizCurrency<IT_SyoumetuTuuti> htykeihi = new ExDBFieldBizCurrency<>("htykeihi", this);

    public final ExDBFieldBizCurrency<IT_SyoumetuTuuti> shrkykhtykeihi = new ExDBFieldBizCurrency<>("shrkykhtykeihi", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, C_ZeimuNaiyouHnsyuCtrlKbn> zeimunaiyouhensyuctrlkbn = new ExDBFieldString<>("zeimunaiyouhensyuctrlkbn", this, UserType_C_ZeimuNaiyouHnsyuCtrlKbn.class);

    public final ExDBFieldNumber<IT_SyoumetuTuuti, Integer> kykhnkkaisuu = new ExDBFieldNumber<>("kykhnkkaisuu", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, C_KykMsnKbn> kykmsnkbn = new ExDBFieldString<>("kykmsnkbn", this, UserType_C_KykMsnKbn.class);

    public final ExDBFieldString<IT_SyoumetuTuuti, BizDate> lastsyosaihkymd = new ExDBFieldString<>("lastsyosaihkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> toritugisyasyozokunm = new ExDBFieldString<>("toritugisyasyozokunm", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> toritugisyakjncd = new ExDBFieldString<>("toritugisyakjncd", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> toritugisyanm = new ExDBFieldString<>("toritugisyanm", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_SyoumetuTuuti, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}

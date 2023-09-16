package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DseisansouhusakihnsyuKbn;
import yuyu.def.classification.C_DseisantetudukimeiKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.IT_DSeisanTuibaraiKanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_DseisansouhusakihnsyuKbn;
import yuyu.def.db.type.UserType_C_DseisantetudukimeiKbn;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Kaiyakujiyuu;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;
import yuyu.def.db.type.UserType_C_ZeitratkiKbn;

/**
 * Ｄ精算追払管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_DSeisanTuibaraiKanri extends AbstractExDBTable<IT_DSeisanTuibaraiKanri> {

    public GenQIT_DSeisanTuibaraiKanri() {
        this("IT_DSeisanTuibaraiKanri");
    }

    public GenQIT_DSeisanTuibaraiKanri(String pAlias) {
        super("IT_DSeisanTuibaraiKanri", IT_DSeisanTuibaraiKanri.class, pAlias);
    }

    public String IT_DSeisanTuibaraiKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, BizDateY> haitounendo = new ExDBFieldString<>("haitounendo", this, BizDateYType.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<IT_DSeisanTuibaraiKanri, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, C_ShrhousiteiKbn> shrhousiteikbn = new ExDBFieldString<>("shrhousiteikbn", this, UserType_C_ShrhousiteiKbn.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, C_InputShrhousiteiKbn> inputshrhousiteikbn = new ExDBFieldString<>("inputshrhousiteikbn", this, UserType_C_InputShrhousiteiKbn.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, C_YouhiKbn> tuibaraiyouhikbn = new ExDBFieldString<>("tuibaraiyouhikbn", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, C_YouhiKbn> tuutisakuseiyouhikbn = new ExDBFieldString<>("tuutisakuseiyouhikbn", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, C_DseisansouhusakihnsyuKbn> dseisansouhusakihnsyukbn = new ExDBFieldString<>("dseisansouhusakihnsyukbn", this, UserType_C_DseisansouhusakihnsyuKbn.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, C_DseisantetudukimeiKbn> dseisantetudukimeikbn = new ExDBFieldString<>("dseisantetudukimeikbn", this, UserType_C_DseisantetudukimeiKbn.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, BizDate> shrymd = new ExDBFieldString<>("shrymd", this, BizDateType.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, BizDate> shrtienrskkisanymd = new ExDBFieldString<>("shrtienrskkisanymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_DSeisanTuibaraiKanri, Integer> tienrsknissuu = new ExDBFieldNumber<>("tienrsknissuu", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, BizDate> kouryokuhasseiymd = new ExDBFieldString<>("kouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, C_UmuKbn> gsbunritaisyou = new ExDBFieldString<>("gsbunritaisyou", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, C_UmuKbn> yenshrtkumu = new ExDBFieldString<>("yenshrtkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, C_KouzasyuruiKbn> kzsyuruikbn = new ExDBFieldString<>("kzsyuruikbn", this, UserType_C_KouzasyuruiKbn.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, C_Kzdou> kzdoukbn = new ExDBFieldString<>("kzdoukbn", this, UserType_C_Kzdou.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, BizDate> gaikashrkwsratekjnymd = new ExDBFieldString<>("gaikashrkwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, BizNumber> gaikashrkwsrate = new ExDBFieldString<>("gaikashrkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, BizDate> zeimukwsratekjnymd = new ExDBFieldString<>("zeimukwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, BizNumber> zeimukwsrate = new ExDBFieldString<>("zeimukwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, String> nztodouhukencd = new ExDBFieldString<>("nztodouhukencd", this);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> yensynykngk = new ExDBFieldBizCurrency<>("yensynykngk", this);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> yenhtykeihi = new ExDBFieldBizCurrency<>("yenhtykeihi", this);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> yenkztgk = new ExDBFieldBizCurrency<>("yenkztgk", this);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> yenshrkykhtykeihi = new ExDBFieldBizCurrency<>("yenshrkykhtykeihi", this);

    public final ExDBFieldNumber<IT_DSeisanTuibaraiKanri, Integer> kykhnkkaisuu = new ExDBFieldNumber<>("kykhnkkaisuu", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, C_YouhiKbn> shrtysykurikosiyouhi = new ExDBFieldString<>("shrtysykurikosiyouhi", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, String> soukinsakinmkj = new ExDBFieldString<>("soukinsakinmkj", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, String> soukinsakiyno = new ExDBFieldString<>("soukinsakiyno", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, String> soukinsakiadr1kj = new ExDBFieldString<>("soukinsakiadr1kj", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, String> soukinsakiadr2kj = new ExDBFieldString<>("soukinsakiadr2kj", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, String> soukinsakiadr3kj = new ExDBFieldString<>("soukinsakiadr3kj", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, C_Kaiyakujiyuu> kaiyakujiyuu = new ExDBFieldString<>("kaiyakujiyuu", this, UserType_C_Kaiyakujiyuu.class);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> shrtuukashrgkgoukei = new ExDBFieldBizCurrency<>("shrtuukashrgkgoukei", this);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> shrtuukagstszeigk = new ExDBFieldBizCurrency<>("shrtuukagstszeigk", this);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> shrtuukashrtienrsk = new ExDBFieldBizCurrency<>("shrtuukashrtienrsk", this);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> shrtuukasonotashrkngk = new ExDBFieldBizCurrency<>("shrtuukasonotashrkngk", this);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> yenkansanhaitoukin = new ExDBFieldBizCurrency<>("yenkansanhaitoukin", this);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> yensonotahaitoukin = new ExDBFieldBizCurrency<>("yensonotahaitoukin", this);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> yenshrgkgoukei = new ExDBFieldBizCurrency<>("yenshrgkgoukei", this);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> yengstszeigk = new ExDBFieldBizCurrency<>("yengstszeigk", this);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> yengstszeigknationaltax = new ExDBFieldBizCurrency<>("yengstszeigknationaltax", this);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> yengstszeigklocaltax = new ExDBFieldBizCurrency<>("yengstszeigklocaltax", this);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> yenshrtienrsk = new ExDBFieldBizCurrency<>("yenshrtienrsk", this);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> sonotashrkngkyen = new ExDBFieldBizCurrency<>("sonotashrkngkyen", this);

    public final ExDBFieldBizCurrency<IT_DSeisanTuibaraiKanri> sonotashrkngksiteituuka = new ExDBFieldBizCurrency<>("sonotashrkngksiteituuka", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_DSeisanTuibaraiKanri, C_ZeitratkiKbn> zeitratkikbn = new ExDBFieldString<>("zeitratkikbn", this, UserType_C_ZeitratkiKbn.class);
}

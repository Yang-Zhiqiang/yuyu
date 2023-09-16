package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_HugouKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykniyuhenkouKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SksmongonKbn;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantousituKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YendthnkzeimuinfohskKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.def.db.entity.IT_BAK_TtdkKan;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HtsiryosyuKbn;
import yuyu.def.db.type.UserType_C_HugouKbn;
import yuyu.def.db.type.UserType_C_Kaiyakujiyuu;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_KykniyuhenkouKbn;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_SksmongonKbn;
import yuyu.def.db.type.UserType_C_SoukinsakisiteiKbn;
import yuyu.def.db.type.UserType_C_SyoriKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_TantousituKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TetudukisyuKbn;
import yuyu.def.db.type.UserType_C_TrkKzkKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YendthnkzeimuinfohskKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_ZeimuNaiyouHnsyuCtrlKbn;

/**
 * 手続完了バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_TtdkKan extends AbstractExDBTable<IT_BAK_TtdkKan> {

    public GenQIT_BAK_TtdkKan() {
        this("IT_BAK_TtdkKan");
    }

    public GenQIT_BAK_TtdkKan(String pAlias) {
        super("IT_BAK_TtdkKan", IT_BAK_TtdkKan.class, pAlias);
    }

    public String IT_BAK_TtdkKan() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_TantousituKbn> tantousitukbn = new ExDBFieldString<>("tantousitukbn", this, UserType_C_TantousituKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_UmuKbn> syoukendhumukbn = new ExDBFieldString<>("syoukendhumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> shsnmkj2 = new ExDBFieldString<>("shsnmkj2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> toiawaseyno = new ExDBFieldString<>("toiawaseyno", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> toiawaseadr1kj = new ExDBFieldString<>("toiawaseadr1kj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> toiawaseadr2kj = new ExDBFieldString<>("toiawaseadr2kj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> toiawaseadr3kj = new ExDBFieldString<>("toiawaseadr3kj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> toiawasekaisyanmkj = new ExDBFieldString<>("toiawasekaisyanmkj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> toiawaseteluktkkanou1 = new ExDBFieldString<>("toiawaseteluktkkanou1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> toiawaseteluktkkanou2 = new ExDBFieldString<>("toiawaseteluktkkanou2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_TetudukisyuKbn> tetudukisyukbn = new ExDBFieldString<>("tetudukisyukbn", this, UserType_C_TetudukisyuKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_UmuKbn> shrumu = new ExDBFieldString<>("shrumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_SyoriKbn> syorikbn = new ExDBFieldString<>("syorikbn", this, UserType_C_SyoriKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> syouhnnm = new ExDBFieldString<>("syouhnnm", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_UmuKbn> yenshrtktekiumu = new ExDBFieldString<>("yenshrtktekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_UmuKbn> ttdknaiyouumukbn = new ExDBFieldString<>("ttdknaiyouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> ttdknaiyou1 = new ExDBFieldString<>("ttdknaiyou1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> ttdknaiyou2 = new ExDBFieldString<>("ttdknaiyou2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> ttdknaiyou3 = new ExDBFieldString<>("ttdknaiyou3", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> ttdknaiyou4 = new ExDBFieldString<>("ttdknaiyou4", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> ttdknaiyou5 = new ExDBFieldString<>("ttdknaiyou5", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> ttdknaiyou6 = new ExDBFieldString<>("ttdknaiyou6", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> ttdknaiyou7 = new ExDBFieldString<>("ttdknaiyou7", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> ttdknaiyou8 = new ExDBFieldString<>("ttdknaiyou8", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> ttdknaiyou9 = new ExDBFieldString<>("ttdknaiyou9", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> ttdknaiyou10 = new ExDBFieldString<>("ttdknaiyou10", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, BizDate> shrymd = new ExDBFieldString<>("shrymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, BizDate> calckijyunymd = new ExDBFieldString<>("calckijyunymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, BizDate> kaiykymd = new ExDBFieldString<>("kaiykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> shrtuukasyuryk = new ExDBFieldString<>("shrtuukasyuryk", this);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> shrgkkei = new ExDBFieldBizCurrency<>("shrgkkei", this);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> hnkngk = new ExDBFieldBizCurrency<>("hnkngk", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Tuukasyu> hnkntuukasyu = new ExDBFieldString<>("hnkntuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, BizDate> hnknymd = new ExDBFieldString<>("hnknymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> shrtienrsk = new ExDBFieldBizCurrency<>("shrtienrsk", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> tekiyou1 = new ExDBFieldString<>("tekiyou1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> tekiyou2 = new ExDBFieldString<>("tekiyou2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> tekiyou3 = new ExDBFieldString<>("tekiyou3", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> tekiyou4 = new ExDBFieldString<>("tekiyou4", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> tekiyou5 = new ExDBFieldString<>("tekiyou5", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> tekiyou6 = new ExDBFieldString<>("tekiyou6", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> tekiyou7 = new ExDBFieldString<>("tekiyou7", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> tekiyou8 = new ExDBFieldString<>("tekiyou8", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> tekiyou9 = new ExDBFieldString<>("tekiyou9", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> tekiyou10 = new ExDBFieldString<>("tekiyou10", this);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> kngkmeisai1 = new ExDBFieldBizCurrency<>("kngkmeisai1", this);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> kngkmeisai2 = new ExDBFieldBizCurrency<>("kngkmeisai2", this);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> kngkmeisai3 = new ExDBFieldBizCurrency<>("kngkmeisai3", this);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> kngkmeisai4 = new ExDBFieldBizCurrency<>("kngkmeisai4", this);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> kngkmeisai5 = new ExDBFieldBizCurrency<>("kngkmeisai5", this);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> kngkmeisai6 = new ExDBFieldBizCurrency<>("kngkmeisai6", this);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> kngkmeisai7 = new ExDBFieldBizCurrency<>("kngkmeisai7", this);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> kngkmeisai8 = new ExDBFieldBizCurrency<>("kngkmeisai8", this);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> kngkmeisai9 = new ExDBFieldBizCurrency<>("kngkmeisai9", this);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> kngkmeisai10 = new ExDBFieldBizCurrency<>("kngkmeisai10", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Tuukasyu> kngkmisituukasyu1 = new ExDBFieldString<>("kngkmisituukasyu1", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Tuukasyu> kngkmisituukasyu2 = new ExDBFieldString<>("kngkmisituukasyu2", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Tuukasyu> kngkmisituukasyu3 = new ExDBFieldString<>("kngkmisituukasyu3", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Tuukasyu> kngkmisituukasyu4 = new ExDBFieldString<>("kngkmisituukasyu4", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Tuukasyu> kngkmisituukasyu5 = new ExDBFieldString<>("kngkmisituukasyu5", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Tuukasyu> kngkmisituukasyu6 = new ExDBFieldString<>("kngkmisituukasyu6", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Tuukasyu> kngkmisituukasyu7 = new ExDBFieldString<>("kngkmisituukasyu7", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Tuukasyu> kngkmisituukasyu8 = new ExDBFieldString<>("kngkmisituukasyu8", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Tuukasyu> kngkmisituukasyu9 = new ExDBFieldString<>("kngkmisituukasyu9", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Tuukasyu> kngkmisituukasyu10 = new ExDBFieldString<>("kngkmisituukasyu10", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> bikou1 = new ExDBFieldString<>("bikou1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> bikou2 = new ExDBFieldString<>("bikou2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> bikou3 = new ExDBFieldString<>("bikou3", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> bikou4 = new ExDBFieldString<>("bikou4", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> bikou5 = new ExDBFieldString<>("bikou5", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> bikou6 = new ExDBFieldString<>("bikou6", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> bikou7 = new ExDBFieldString<>("bikou7", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> bikou8 = new ExDBFieldString<>("bikou8", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> bikou9 = new ExDBFieldString<>("bikou9", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> bikou10 = new ExDBFieldString<>("bikou10", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> banknmkj = new ExDBFieldString<>("banknmkj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> sitennmkj = new ExDBFieldString<>("sitennmkj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_KouzasyuruiKbn> kzsyuruikbn = new ExDBFieldString<>("kzsyuruikbn", this, UserType_C_KouzasyuruiKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_SoukinsakisiteiKbn> soukinsakisiteikbn = new ExDBFieldString<>("soukinsakisiteikbn", this, UserType_C_SoukinsakisiteiKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_HtsiryosyuKbn> htsiryosyukbn = new ExDBFieldString<>("htsiryosyukbn", this, UserType_C_HtsiryosyuKbn.class);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> synykngk = new ExDBFieldBizCurrency<>("synykngk", this);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> htykeihi = new ExDBFieldBizCurrency<>("htykeihi", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Kaiyakujiyuu> kaiyakujiyuu = new ExDBFieldString<>("kaiyakujiyuu", this, UserType_C_Kaiyakujiyuu.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_UmuKbn> zeimumongonoutkbn = new ExDBFieldString<>("zeimumongonoutkbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> zeimumongon1 = new ExDBFieldString<>("zeimumongon1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> zeimumongon2 = new ExDBFieldString<>("zeimumongon2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> zeimumongon3 = new ExDBFieldString<>("zeimumongon3", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> zeimumongon4 = new ExDBFieldString<>("zeimumongon4", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> zeimumongon5 = new ExDBFieldString<>("zeimumongon5", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongonhyoudai = new ExDBFieldString<>("osirasemongonhyoudai", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon1 = new ExDBFieldString<>("osirasemongon1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon2 = new ExDBFieldString<>("osirasemongon2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon3 = new ExDBFieldString<>("osirasemongon3", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon4 = new ExDBFieldString<>("osirasemongon4", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon5 = new ExDBFieldString<>("osirasemongon5", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon6 = new ExDBFieldString<>("osirasemongon6", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon7 = new ExDBFieldString<>("osirasemongon7", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon8 = new ExDBFieldString<>("osirasemongon8", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon9 = new ExDBFieldString<>("osirasemongon9", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon10 = new ExDBFieldString<>("osirasemongon10", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon11 = new ExDBFieldString<>("osirasemongon11", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon12 = new ExDBFieldString<>("osirasemongon12", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon13 = new ExDBFieldString<>("osirasemongon13", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon14 = new ExDBFieldString<>("osirasemongon14", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon15 = new ExDBFieldString<>("osirasemongon15", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon16 = new ExDBFieldString<>("osirasemongon16", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon17 = new ExDBFieldString<>("osirasemongon17", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon18 = new ExDBFieldString<>("osirasemongon18", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon19 = new ExDBFieldString<>("osirasemongon19", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon20 = new ExDBFieldString<>("osirasemongon20", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon21 = new ExDBFieldString<>("osirasemongon21", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon22 = new ExDBFieldString<>("osirasemongon22", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon23 = new ExDBFieldString<>("osirasemongon23", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon24 = new ExDBFieldString<>("osirasemongon24", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon25 = new ExDBFieldString<>("osirasemongon25", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon26 = new ExDBFieldString<>("osirasemongon26", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon27 = new ExDBFieldString<>("osirasemongon27", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon28 = new ExDBFieldString<>("osirasemongon28", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon29 = new ExDBFieldString<>("osirasemongon29", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon30 = new ExDBFieldString<>("osirasemongon30", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon31 = new ExDBFieldString<>("osirasemongon31", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon32 = new ExDBFieldString<>("osirasemongon32", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon33 = new ExDBFieldString<>("osirasemongon33", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon34 = new ExDBFieldString<>("osirasemongon34", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon35 = new ExDBFieldString<>("osirasemongon35", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon36 = new ExDBFieldString<>("osirasemongon36", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon37 = new ExDBFieldString<>("osirasemongon37", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon38 = new ExDBFieldString<>("osirasemongon38", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon39 = new ExDBFieldString<>("osirasemongon39", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon40 = new ExDBFieldString<>("osirasemongon40", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon41 = new ExDBFieldString<>("osirasemongon41", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon42 = new ExDBFieldString<>("osirasemongon42", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon43 = new ExDBFieldString<>("osirasemongon43", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon44 = new ExDBFieldString<>("osirasemongon44", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon45 = new ExDBFieldString<>("osirasemongon45", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon46 = new ExDBFieldString<>("osirasemongon46", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon47 = new ExDBFieldString<>("osirasemongon47", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon48 = new ExDBFieldString<>("osirasemongon48", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon49 = new ExDBFieldString<>("osirasemongon49", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osirasemongon50 = new ExDBFieldString<>("osirasemongon50", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> osiraseinjihuyouhyouji = new ExDBFieldString<>("osiraseinjihuyouhyouji", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> shrkykhtykeihi = new ExDBFieldBizCurrency<>("shrkykhtykeihi", this);

    public final ExDBFieldNumber<IT_BAK_TtdkKan, Integer> kykhnkkaisuu = new ExDBFieldNumber<>("kykhnkkaisuu", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_ZeimuNaiyouHnsyuCtrlKbn> zeimunaiyouhensyuctrlkbn = new ExDBFieldString<>("zeimunaiyouhensyuctrlkbn", this, UserType_C_ZeimuNaiyouHnsyuCtrlKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_KykniyuhenkouKbn> kykniyuhnkkbn = new ExDBFieldString<>("kykniyuhnkkbn", this, UserType_C_KykniyuhenkouKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, BizDate> kykniyuhnkymd = new ExDBFieldString<>("kykniyuhnkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykniyuhnkinfo = new ExDBFieldString<>("kykniyuhnkinfo", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_HugouKbn> kykniyuhnkgkhugou1 = new ExDBFieldString<>("kykniyuhnkgkhugou1", this, UserType_C_HugouKbn.class);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> kykniyuhnkkngk1 = new ExDBFieldBizCurrency<>("kykniyuhnkkngk1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Tuukasyu> kykniyuhnkkngktuksyu1 = new ExDBFieldString<>("kykniyuhnkkngktuksyu1", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_HugouKbn> kykniyuhnkkngkhugou2 = new ExDBFieldString<>("kykniyuhnkkngkhugou2", this, UserType_C_HugouKbn.class);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> kykniyuhnkkngk2 = new ExDBFieldBizCurrency<>("kykniyuhnkkngk2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Tuukasyu> kykniyuhnkkngktuksyu2 = new ExDBFieldString<>("kykniyuhnkkngktuksyu2", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_TtdkKan> gsbnrkztsaeki = new ExDBFieldBizCurrency<>("gsbnrkztsaeki", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_HugouKbn> shrkngkmeisaihugou1 = new ExDBFieldString<>("shrkngkmeisaihugou1", this, UserType_C_HugouKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_HugouKbn> shrkngkmeisaihugou2 = new ExDBFieldString<>("shrkngkmeisaihugou2", this, UserType_C_HugouKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_HugouKbn> shrkngkmeisaihugou3 = new ExDBFieldString<>("shrkngkmeisaihugou3", this, UserType_C_HugouKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_HugouKbn> shrkngkmeisaihugou4 = new ExDBFieldString<>("shrkngkmeisaihugou4", this, UserType_C_HugouKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_HugouKbn> shrkngkmeisaihugou5 = new ExDBFieldString<>("shrkngkmeisaihugou5", this, UserType_C_HugouKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_HugouKbn> shrkngkmeisaihugou6 = new ExDBFieldString<>("shrkngkmeisaihugou6", this, UserType_C_HugouKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_HugouKbn> shrkngkmeisaihugou7 = new ExDBFieldString<>("shrkngkmeisaihugou7", this, UserType_C_HugouKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_HugouKbn> shrkngkmeisaihugou8 = new ExDBFieldString<>("shrkngkmeisaihugou8", this, UserType_C_HugouKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_HugouKbn> shrkngkmeisaihugou9 = new ExDBFieldString<>("shrkngkmeisaihugou9", this, UserType_C_HugouKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_HugouKbn> shrkngkmeisaihugou10 = new ExDBFieldString<>("shrkngkmeisaihugou10", this, UserType_C_HugouKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> documentid = new ExDBFieldString<>("documentid", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_SksmongonKbn> sksmongonkbn1 = new ExDBFieldString<>("sksmongonkbn1", this, UserType_C_SksmongonKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_SksmongonKbn> sksmongonkbn2 = new ExDBFieldString<>("sksmongonkbn2", this, UserType_C_SksmongonKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> toritugisyasyozokunm = new ExDBFieldString<>("toritugisyasyozokunm", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> toritugisyakjncd = new ExDBFieldString<>("toritugisyakjncd", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> toritugisyanm = new ExDBFieldString<>("toritugisyanm", this);

    public final ExDBFieldNumber<IT_BAK_TtdkKan, Integer> hozonKikan = new ExDBFieldNumber<>("hozonKikan", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> shrnaiyouhskmongon1 = new ExDBFieldString<>("shrnaiyouhskmongon1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> shrnaiyouhskmongon2 = new ExDBFieldString<>("shrnaiyouhskmongon2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_YendthnkzeimuinfohskKbn> yendthnkzeimuinfohskkbn = new ExDBFieldString<>("yendthnkzeimuinfohskkbn", this, UserType_C_YendthnkzeimuinfohskKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_UmuKbn> yuuyokkntyoukaumu = new ExDBFieldString<>("yuuyokkntyoukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> dseisanshrttdknm = new ExDBFieldString<>("dseisanshrttdknm", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_TrkKzkKbn> trkkzkkbn1 = new ExDBFieldString<>("trkkzkkbn1", this, UserType_C_TrkKzkKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> trkkzknmkj1 = new ExDBFieldString<>("trkkzknmkj1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Seibetu> trkkzksei1 = new ExDBFieldString<>("trkkzksei1", this, UserType_C_Seibetu.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, BizDate> trkkzkseiymd1 = new ExDBFieldString<>("trkkzkseiymd1", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> trkkzkyno1 = new ExDBFieldString<>("trkkzkyno1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> trkkzkadr1kj1 = new ExDBFieldString<>("trkkzkadr1kj1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> trkkzkadr2kj1 = new ExDBFieldString<>("trkkzkadr2kj1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> trkkzkadr3kj1 = new ExDBFieldString<>("trkkzkadr3kj1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> trkkzktelno1 = new ExDBFieldString<>("trkkzktelno1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> trkkzktelnomtrkhyouji1 = new ExDBFieldString<>("trkkzktelnomtrkhyouji1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Tdk> trkkzktdk1 = new ExDBFieldString<>("trkkzktdk1", this, UserType_C_Tdk.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_TrkKzkKbn> trkkzkkbn2 = new ExDBFieldString<>("trkkzkkbn2", this, UserType_C_TrkKzkKbn.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> trkkzknmkj2 = new ExDBFieldString<>("trkkzknmkj2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Seibetu> trkkzksei2 = new ExDBFieldString<>("trkkzksei2", this, UserType_C_Seibetu.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, BizDate> trkkzkseiymd2 = new ExDBFieldString<>("trkkzkseiymd2", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> trkkzkyno2 = new ExDBFieldString<>("trkkzkyno2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> trkkzkadr1kj2 = new ExDBFieldString<>("trkkzkadr1kj2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> trkkzkadr2kj2 = new ExDBFieldString<>("trkkzkadr2kj2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> trkkzkadr3kj2 = new ExDBFieldString<>("trkkzkadr3kj2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> trkkzktelno2 = new ExDBFieldString<>("trkkzktelno2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, C_Tdk> trkkzktdk2 = new ExDBFieldString<>("trkkzktdk2", this, UserType_C_Tdk.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykdairinmkj = new ExDBFieldString<>("kykdairinmkj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykomttutkbn = new ExDBFieldString<>("kykomttutkbn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kzkomttutkbn1 = new ExDBFieldString<>("kzkomttutkbn1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kzkomttutkbn2 = new ExDBFieldString<>("kzkomttutkbn2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhkomttutkbn = new ExDBFieldString<>("hhkomttutkbn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhkdromttutkbn = new ExDBFieldString<>("hhkdromttutkbn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykdairiomttutkbn = new ExDBFieldString<>("kykdairiomttutkbn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykurtutkbn = new ExDBFieldString<>("kykurtutkbn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kzkurtutkbn1 = new ExDBFieldString<>("kzkurtutkbn1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kzkurtutkbn2 = new ExDBFieldString<>("kzkurtutkbn2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhkdrurtutkbn = new ExDBFieldString<>("hhkdrurtutkbn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykdairiurtutkbn = new ExDBFieldString<>("kykdairiurtutkbn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykaistmsgkbn = new ExDBFieldString<>("kykaistmsgkbn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kzkaistmsgkbn1 = new ExDBFieldString<>("kzkaistmsgkbn1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kzkaistmsgkbn2 = new ExDBFieldString<>("kzkaistmsgkbn2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhkaistmsgkbn = new ExDBFieldString<>("hhkaistmsgkbn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhkdraistmsgkbn = new ExDBFieldString<>("hhkdraistmsgkbn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykdairiaistmsgkbn = new ExDBFieldString<>("kykdairiaistmsgkbn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> sakujyokzknmkj = new ExDBFieldString<>("sakujyokzknmkj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> ttdknaiyoukbn = new ExDBFieldString<>("ttdknaiyoukbn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kzktaisyoukykkbn = new ExDBFieldString<>("kzktaisyoukykkbn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhkdrtaisyoukykkbn = new ExDBFieldString<>("hhkdrtaisyoukykkbn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykdairitaisyoukykkbn = new ExDBFieldString<>("kykdairitaisyoukykkbn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> moshnkniymsgkbn1 = new ExDBFieldString<>("moshnkniymsgkbn1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykmoshnkniymsg2 = new ExDBFieldString<>("kykmoshnkniymsg2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kzkmoshnkniymsg21 = new ExDBFieldString<>("kzkmoshnkniymsg21", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kzkmoshnkniymsg22 = new ExDBFieldString<>("kzkmoshnkniymsg22", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhkdrmoshnkniymsg2 = new ExDBFieldString<>("hhkdrmoshnkniymsg2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykdairimoshnkniymsg2 = new ExDBFieldString<>("kykdairimoshnkniymsg2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykdrmsgkbn = new ExDBFieldString<>("kykdrmsgkbn", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykhhkdrmsg = new ExDBFieldString<>("kykhhkdrmsg", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kzkhhkdrmsg1 = new ExDBFieldString<>("kzkhhkdrmsg1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kzkhhkdrmsg2 = new ExDBFieldString<>("kzkhhkdrmsg2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhkdrnmkj = new ExDBFieldString<>("hhkdrnmkj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> duhubutumsg = new ExDBFieldString<>("duhubutumsg", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> duhubutumsg1 = new ExDBFieldString<>("duhubutumsg1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> duhubutumsg2 = new ExDBFieldString<>("duhubutumsg2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> duhubutumsg3 = new ExDBFieldString<>("duhubutumsg3", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> duhubutumsg4 = new ExDBFieldString<>("duhubutumsg4", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> duhubutumsg5 = new ExDBFieldString<>("duhubutumsg5", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> duhubutumsg6 = new ExDBFieldString<>("duhubutumsg6", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> duhubutumsg7 = new ExDBFieldString<>("duhubutumsg7", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykigaidhbtmsg1 = new ExDBFieldString<>("kykigaidhbtmsg1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykigaidhbtmsg2 = new ExDBFieldString<>("kykigaidhbtmsg2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykigaidhbtmsg3 = new ExDBFieldString<>("kykigaidhbtmsg3", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykigaidhbtmsg4 = new ExDBFieldString<>("kykigaidhbtmsg4", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kiyakuhunyuuhyouji = new ExDBFieldString<>("kiyakuhunyuuhyouji", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> yakkankiyakuhunyuuhyouji = new ExDBFieldString<>("yakkankiyakuhunyuuhyouji", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kyktrktrshuunyuuhyouji = new ExDBFieldString<>("kyktrktrshuunyuuhyouji", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kzktrktrshuunyuuhyouji1 = new ExDBFieldString<>("kzktrktrshuunyuuhyouji1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kzktrktrshuunyuuhyouji2 = new ExDBFieldString<>("kzktrktrshuunyuuhyouji2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykdrhuunyuuhyouji = new ExDBFieldString<>("kykdrhuunyuuhyouji", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhkdrhuunyuuhyouji = new ExDBFieldString<>("hhkdrhuunyuuhyouji", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykdairinmkj2 = new ExDBFieldString<>("kykdairinmkj2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, BizDate> kykdrseiymd = new ExDBFieldString<>("kykdrseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykdryno = new ExDBFieldString<>("kykdryno", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykdradr1kj = new ExDBFieldString<>("kykdradr1kj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykdradr2kj = new ExDBFieldString<>("kykdradr2kj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykdradr3kj = new ExDBFieldString<>("kykdradr3kj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> kykdrtelno = new ExDBFieldString<>("kykdrtelno", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhkdrnmkj2 = new ExDBFieldString<>("hhkdrnmkj2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, BizDate> hhkdrseiymd = new ExDBFieldString<>("hhkdrseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhkdryno = new ExDBFieldString<>("hhkdryno", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhkdradr1kj = new ExDBFieldString<>("hhkdradr1kj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhkdradr2kj = new ExDBFieldString<>("hhkdradr2kj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhkdradr3kj = new ExDBFieldString<>("hhkdradr3kj", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhkdrtelno = new ExDBFieldString<>("hhkdrtelno", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hhkdrtelnomtrkhyouji = new ExDBFieldString<>("hhkdrtelnomtrkhyouji", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khsyono2 = new ExDBFieldString<>("khsyono2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khsyono3 = new ExDBFieldString<>("khsyono3", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khsyono4 = new ExDBFieldString<>("khsyono4", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khsyono5 = new ExDBFieldString<>("khsyono5", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khsyono6 = new ExDBFieldString<>("khsyono6", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khsyono7 = new ExDBFieldString<>("khsyono7", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khsyono8 = new ExDBFieldString<>("khsyono8", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khsyono9 = new ExDBFieldString<>("khsyono9", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khsyono10 = new ExDBFieldString<>("khsyono10", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khmosno1 = new ExDBFieldString<>("khmosno1", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khmosno2 = new ExDBFieldString<>("khmosno2", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khmosno3 = new ExDBFieldString<>("khmosno3", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khmosno4 = new ExDBFieldString<>("khmosno4", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khmosno5 = new ExDBFieldString<>("khmosno5", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khmosno6 = new ExDBFieldString<>("khmosno6", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khmosno7 = new ExDBFieldString<>("khmosno7", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khmosno8 = new ExDBFieldString<>("khmosno8", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khmosno9 = new ExDBFieldString<>("khmosno9", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> khmosno10 = new ExDBFieldString<>("khmosno10", this);

    public final ExDBFieldString<IT_BAK_TtdkKan, String> hnsnhutouhuunyuuhyouji = new ExDBFieldString<>("hnsnhutouhuunyuuhyouji", this);
}

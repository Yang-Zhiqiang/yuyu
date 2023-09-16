package yuyu.def.db.mapping;

import com.google.common.base.Optional;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_TesuuryouSyouhn;
import yuyu.def.db.id.PKIT_TesuuryouSyouhn;
import yuyu.def.db.meta.GenQIT_TesuuryouSyouhn;
import yuyu.def.db.meta.QIT_TesuuryouSyouhn;
import yuyu.def.db.type.UserType_C_6daiLdKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_HrkkknsmnKbn;
import yuyu.def.db.type.UserType_C_KataKbn;
import yuyu.def.db.type.UserType_C_KhnkyhkgbairituKbn;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;
import yuyu.def.db.type.UserType_C_Kykjyoutai;
import yuyu.def.db.type.UserType_C_Nenkinsyu;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_SyukyhkinkataKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_TsrysyoriKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_YuukousyoumetuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 手数料情報商品テーブル テーブルのマッピング情報クラスで、 {@link IT_TesuuryouSyouhn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_TesuuryouSyouhn}</td><td colspan="3">手数料情報商品テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_TesuuryouSyouhn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_TesuuryouSyouhn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsrysyorikbn tsrysyorikbn}</td><td>手数料処理区分</td><td align="center">{@link PKIT_TesuuryouSyouhn ○}</td><td align="center">V</td><td>{@link C_TsrysyoriKbn}</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_TesuuryouSyouhn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">{@link PKIT_TesuuryouSyouhn ○}</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKIT_TesuuryouSyouhn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">{@link PKIT_TesuuryouSyouhn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno kyksyouhnrenno}</td><td>契約商品連番</td><td align="center">{@link PKIT_TesuuryouSyouhn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYuukousyoumetukbn yuukousyoumetukbn}</td><td>有効消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YuukousyoumetuKbn}</td></tr>
 *  <tr><td>{@link #getKykjyoutai kykjyoutai}</td><td>契約状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kykjyoutai}</td></tr>
 *  <tr><td>{@link #getSyoumetujiyuu syoumetujiyuu}</td><td>消滅事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syoumetujiyuu}</td></tr>
 *  <tr><td>{@link #getSyoumetuymd syoumetuymd}</td><td>消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKouryokuhasseiymd kouryokuhasseiymd}</td><td>効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSknnkaisiymd sknnkaisiymd}</td><td>責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGansknnkaisiymd gansknnkaisiymd}</td><td>がん責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn hknkknsmnkbn}</td><td>保険期間歳満期区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHknkkn hknkkn}</td><td>保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbn hrkkknsmnkbn}</td><td>払込期間歳満期区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHrkkkn hrkkkn}</td><td>払込期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyknen kyknen}</td><td>契約者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHaraimanymd haraimanymd}</td><td>払満日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHknkknmanryouymd hknkknmanryouymd}</td><td>保険期間満了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKatakbn katakbn}</td><td>型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>{@link #getKyhgndkatakbn kyhgndkatakbn}</td><td>給付限度型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr><td>{@link #getSyukyhkinkatakbn syukyhkinkatakbn}</td><td>手術給付金型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>{@link #getKhnkyhkgbairitukbn khnkyhkgbairitukbn}</td><td>基本給付金額倍率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KhnkyhkgbairituKbn}</td></tr>
 *  <tr><td>{@link #getRokudaildkbn rokudaildkbn}</td><td>６大生活習慣病追加給付型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_6daiLdKbn}</td></tr>
 *  <tr><td>{@link #getPmnjtkkbn pmnjtkkbn}</td><td>保険料免除特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PmnjtkKbn}</td></tr>
 *  <tr><td>{@link #getKihons kihons}</td><td>基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHokenryou hokenryou}</td><td>保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYoteiriritu yoteiriritu}</td><td>予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYoteirrthendohosyurrt yoteirrthendohosyurrt}</td><td>予定利率変動時保証利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYtirrthndmnskaisuu ytirrthndmnskaisuu}</td><td>予定利率変動見直回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksjkkktyouseiriritu kyksjkkktyouseiriritu}</td><td>契約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getNksyukbn nksyukbn}</td><td>年金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nenkinsyu}</td></tr>
 *  <tr><td>{@link #getNenkinkkn nenkinkkn}</td><td>年金期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNkgnshosyouritu nkgnshosyouritu}</td><td>年金原資最低保証率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNkgnshosyougk nkgnshosyougk}</td><td>年金原資最低保証額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_TesuuryouSyouhn
 * @see     PKIT_TesuuryouSyouhn
 * @see     QIT_TesuuryouSyouhn
 * @see     GenQIT_TesuuryouSyouhn
 */
@MappedSuperclass
@Table(name=GenIT_TesuuryouSyouhn.TABLE_NAME)
@IdClass(value=PKIT_TesuuryouSyouhn.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_6daiLdKbn", typeClass=UserType_C_6daiLdKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_HknkknsmnKbn", typeClass=UserType_C_HknkknsmnKbn.class),
    @TypeDef(name="UserType_C_HrkkknsmnKbn", typeClass=UserType_C_HrkkknsmnKbn.class),
    @TypeDef(name="UserType_C_KataKbn", typeClass=UserType_C_KataKbn.class),
    @TypeDef(name="UserType_C_KhnkyhkgbairituKbn", typeClass=UserType_C_KhnkyhkgbairituKbn.class),
    @TypeDef(name="UserType_C_KyhgndkataKbn", typeClass=UserType_C_KyhgndkataKbn.class),
    @TypeDef(name="UserType_C_Kykjyoutai", typeClass=UserType_C_Kykjyoutai.class),
    @TypeDef(name="UserType_C_Nenkinsyu", typeClass=UserType_C_Nenkinsyu.class),
    @TypeDef(name="UserType_C_PmnjtkKbn", typeClass=UserType_C_PmnjtkKbn.class),
    @TypeDef(name="UserType_C_Syoumetujiyuu", typeClass=UserType_C_Syoumetujiyuu.class),
    @TypeDef(name="UserType_C_SyukyhkinkataKbn", typeClass=UserType_C_SyukyhkinkataKbn.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class),
    @TypeDef(name="UserType_C_TsrysyoriKbn", typeClass=UserType_C_TsrysyoriKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_YuukousyoumetuKbn", typeClass=UserType_C_YuukousyoumetuKbn.class)
})
public abstract class GenIT_TesuuryouSyouhn extends AbstractExDBEntity<IT_TesuuryouSyouhn, PKIT_TesuuryouSyouhn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_TesuuryouSyouhn";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TSRYSYORIKBN             = "tsrysyorikbn";
    public static final String RENNO                    = "renno";
    public static final String SYUTKKBN                 = "syutkkbn";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KYKSYOUHNRENNO           = "kyksyouhnrenno";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String YUUKOUSYOUMETUKBN        = "yuukousyoumetukbn";
    public static final String KYKJYOUTAI               = "kykjyoutai";
    public static final String SYOUMETUJIYUU            = "syoumetujiyuu";
    public static final String SYOUMETUYMD              = "syoumetuymd";
    public static final String KOURYOKUHASSEIYMD        = "kouryokuhasseiymd";
    public static final String KYKYMD                   = "kykymd";
    public static final String SKNNKAISIYMD             = "sknnkaisiymd";
    public static final String GANSKNNKAISIYMD          = "gansknnkaisiymd";
    public static final String HKNKKNSMNKBN             = "hknkknsmnkbn";
    public static final String HKNKKN                   = "hknkkn";
    public static final String HRKKKNSMNKBN             = "hrkkknsmnkbn";
    public static final String HRKKKN                   = "hrkkkn";
    public static final String KYKNEN                   = "kyknen";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HARAIMANYMD              = "haraimanymd";
    public static final String HKNKKNMANRYOUYMD         = "hknkknmanryouymd";
    public static final String KATAKBN                  = "katakbn";
    public static final String KYHGNDKATAKBN            = "kyhgndkatakbn";
    public static final String SYUKYHKINKATAKBN         = "syukyhkinkatakbn";
    public static final String KHNKYHKGBAIRITUKBN       = "khnkyhkgbairitukbn";
    public static final String ROKUDAILDKBN             = "rokudaildkbn";
    public static final String PMNJTKKBN                = "pmnjtkkbn";
    public static final String KIHONS                   = "kihons";
    public static final String HOKENRYOU                = "hokenryou";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String RYOURITUSDNO             = "ryouritusdno";
    public static final String YOTEIRIRITU              = "yoteiriritu";
    public static final String YOTEIRRTHENDOHOSYURRT    = "yoteirrthendohosyurrt";
    public static final String YTIRRTHNDMNSKAISUU       = "ytirrthndmnskaisuu";
    public static final String KYKSJKKKTYOUSEIRIRITU    = "kyksjkkktyouseiriritu";
    public static final String NKSYUKBN                 = "nksyukbn";
    public static final String NENKINKKN                = "nenkinkkn";
    public static final String NKGNSHOSYOURITU          = "nkgnshosyouritu";
    public static final String NKGNSHOSYOUGK            = "nkgnshosyougk";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_TesuuryouSyouhn primaryKey;

    public GenIT_TesuuryouSyouhn() {
        primaryKey = new PKIT_TesuuryouSyouhn();
    }

    public GenIT_TesuuryouSyouhn(
        String pKbnkey,
        String pSyono,
        C_TsrysyoriKbn pTsrysyorikbn,
        Integer pRenno,
        C_SyutkKbn pSyutkkbn,
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno
    ) {
        primaryKey = new PKIT_TesuuryouSyouhn(
            pKbnkey,
            pSyono,
            pTsrysyorikbn,
            pRenno,
            pSyutkkbn,
            pSyouhncd,
            pSyouhnsdno,
            pKyksyouhnrenno
        );
    }

    @Transient
    @Override
    public PKIT_TesuuryouSyouhn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_TesuuryouSyouhn> getMetaClass() {
        return QIT_TesuuryouSyouhn.class;
    }

    @Id
    @Column(name=GenIT_TesuuryouSyouhn.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_TesuuryouSyouhn.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Type(type="UserType_C_TsrysyoriKbn")
    @Column(name=GenIT_TesuuryouSyouhn.TSRYSYORIKBN)
    public C_TsrysyoriKbn getTsrysyorikbn() {
        return getPrimaryKey().getTsrysyorikbn();
    }

    public void setTsrysyorikbn(C_TsrysyoriKbn pTsrysyorikbn) {
        getPrimaryKey().setTsrysyorikbn(pTsrysyorikbn);
    }

    @Id
    @Column(name=GenIT_TesuuryouSyouhn.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    @Id
    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenIT_TesuuryouSyouhn.SYUTKKBN)
    public C_SyutkKbn getSyutkkbn() {
        return getPrimaryKey().getSyutkkbn();
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        getPrimaryKey().setSyutkkbn(pSyutkkbn);
    }

    @Id
    @Column(name=GenIT_TesuuryouSyouhn.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Column(name=GenIT_TesuuryouSyouhn.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return getPrimaryKey().getSyouhnsdno();
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        getPrimaryKey().setSyouhnsdno(pSyouhnsdno);
    }

    @Id
    @Column(name=GenIT_TesuuryouSyouhn.KYKSYOUHNRENNO)
    public Integer getKyksyouhnrenno() {
        return getPrimaryKey().getKyksyouhnrenno();
    }

    public void setKyksyouhnrenno(Integer pKyksyouhnrenno) {
        getPrimaryKey().setKyksyouhnrenno(pKyksyouhnrenno);
    }

    private String henkousikibetukey;

    @Column(name=GenIT_TesuuryouSyouhn.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    @Type(type="UserType_C_YuukousyoumetuKbn")
    @Column(name=GenIT_TesuuryouSyouhn.YUUKOUSYOUMETUKBN)
    public C_YuukousyoumetuKbn getYuukousyoumetukbn() {
        return yuukousyoumetukbn;
    }

    public void setYuukousyoumetukbn(C_YuukousyoumetuKbn pYuukousyoumetukbn) {
        yuukousyoumetukbn = pYuukousyoumetukbn;
    }

    private C_Kykjyoutai kykjyoutai;

    @Type(type="UserType_C_Kykjyoutai")
    @Column(name=GenIT_TesuuryouSyouhn.KYKJYOUTAI)
    public C_Kykjyoutai getKykjyoutai() {
        return kykjyoutai;
    }

    public void setKykjyoutai(C_Kykjyoutai pKykjyoutai) {
        kykjyoutai = pKykjyoutai;
    }

    private C_Syoumetujiyuu syoumetujiyuu;

    @Type(type="UserType_C_Syoumetujiyuu")
    @Column(name=GenIT_TesuuryouSyouhn.SYOUMETUJIYUU)
    public C_Syoumetujiyuu getSyoumetujiyuu() {
        return syoumetujiyuu;
    }

    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu) {
        syoumetujiyuu = pSyoumetujiyuu;
    }

    private BizDate syoumetuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_TesuuryouSyouhn.SYOUMETUYMD)
    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    @Trim("both")
    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
    }

    private BizDate kouryokuhasseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_TesuuryouSyouhn.KOURYOKUHASSEIYMD)
    public BizDate getKouryokuhasseiymd() {
        return kouryokuhasseiymd;
    }

    public void setKouryokuhasseiymd(BizDate pKouryokuhasseiymd) {
        kouryokuhasseiymd = pKouryokuhasseiymd;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_TesuuryouSyouhn.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizDate sknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_TesuuryouSyouhn.SKNNKAISIYMD)
    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    @Trim("both")
    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    private BizDate gansknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_TesuuryouSyouhn.GANSKNNKAISIYMD)
    public BizDate getGansknnkaisiymd() {
        return gansknnkaisiymd;
    }

    public void setGansknnkaisiymd(BizDate pGansknnkaisiymd) {
        gansknnkaisiymd = pGansknnkaisiymd;
    }

    private C_HknkknsmnKbn hknkknsmnkbn;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenIT_TesuuryouSyouhn.HKNKKNSMNKBN)
    public C_HknkknsmnKbn getHknkknsmnkbn() {
        return hknkknsmnkbn;
    }

    public void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnkbn) {
        hknkknsmnkbn = pHknkknsmnkbn;
    }

    private Integer hknkkn;

    @Column(name=GenIT_TesuuryouSyouhn.HKNKKN)
    @Range(min="0", max="99")
    public Integer getHknkkn() {
        return hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknkkn(Integer pHknkkn) {
        hknkkn = pHknkkn;
    }

    private C_HrkkknsmnKbn hrkkknsmnkbn;

    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenIT_TesuuryouSyouhn.HRKKKNSMNKBN)
    public C_HrkkknsmnKbn getHrkkknsmnkbn() {
        return hrkkknsmnkbn;
    }

    public void setHrkkknsmnkbn(C_HrkkknsmnKbn pHrkkknsmnkbn) {
        hrkkknsmnkbn = pHrkkknsmnkbn;
    }

    private Integer hrkkkn;

    @Column(name=GenIT_TesuuryouSyouhn.HRKKKN)
    @Range(min="0", max="99")
    public Integer getHrkkkn() {
        return hrkkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrkkkn(Integer pHrkkkn) {
        hrkkkn = pHrkkkn;
    }

    private Integer kyknen;

    @Column(name=GenIT_TesuuryouSyouhn.KYKNEN)
    public Integer getKyknen() {
        return kyknen;
    }

    public void setKyknen(Integer pKyknen) {
        kyknen = pKyknen;
    }

    private Integer hhknnen;

    @Column(name=GenIT_TesuuryouSyouhn.HHKNNEN)
    @NaturalNumber
    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_TesuuryouSyouhn.HHKNSEIYMD)
    @ValidDate
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenIT_TesuuryouSyouhn.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private BizDate haraimanymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_TesuuryouSyouhn.HARAIMANYMD)
    public BizDate getHaraimanymd() {
        return haraimanymd;
    }

    public void setHaraimanymd(BizDate pHaraimanymd) {
        haraimanymd = pHaraimanymd;
    }

    private BizDate hknkknmanryouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_TesuuryouSyouhn.HKNKKNMANRYOUYMD)
    public BizDate getHknkknmanryouymd() {
        return hknkknmanryouymd;
    }

    public void setHknkknmanryouymd(BizDate pHknkknmanryouymd) {
        hknkknmanryouymd = pHknkknmanryouymd;
    }

    private C_KataKbn katakbn;

    @Type(type="UserType_C_KataKbn")
    @Column(name=GenIT_TesuuryouSyouhn.KATAKBN)
    public C_KataKbn getKatakbn() {
        return katakbn;
    }

    public void setKatakbn(C_KataKbn pKatakbn) {
        katakbn = pKatakbn;
    }

    private C_KyhgndkataKbn kyhgndkatakbn;

    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenIT_TesuuryouSyouhn.KYHGNDKATAKBN)
    public C_KyhgndkataKbn getKyhgndkatakbn() {
        return kyhgndkatakbn;
    }

    public void setKyhgndkatakbn(C_KyhgndkataKbn pKyhgndkatakbn) {
        kyhgndkatakbn = pKyhgndkatakbn;
    }

    private C_SyukyhkinkataKbn syukyhkinkatakbn;

    @Type(type="UserType_C_SyukyhkinkataKbn")
    @Column(name=GenIT_TesuuryouSyouhn.SYUKYHKINKATAKBN)
    public C_SyukyhkinkataKbn getSyukyhkinkatakbn() {
        return syukyhkinkatakbn;
    }

    public void setSyukyhkinkatakbn(C_SyukyhkinkataKbn pSyukyhkinkatakbn) {
        syukyhkinkatakbn = pSyukyhkinkatakbn;
    }

    private C_KhnkyhkgbairituKbn khnkyhkgbairitukbn;

    @Type(type="UserType_C_KhnkyhkgbairituKbn")
    @Column(name=GenIT_TesuuryouSyouhn.KHNKYHKGBAIRITUKBN)
    public C_KhnkyhkgbairituKbn getKhnkyhkgbairitukbn() {
        return khnkyhkgbairitukbn;
    }

    public void setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn) {
        khnkyhkgbairitukbn = pKhnkyhkgbairitukbn;
    }

    private C_6daiLdKbn rokudaildkbn;

    @Type(type="UserType_C_6daiLdKbn")
    @Column(name=GenIT_TesuuryouSyouhn.ROKUDAILDKBN)
    public C_6daiLdKbn getRokudaildkbn() {
        return rokudaildkbn;
    }

    public void setRokudaildkbn(C_6daiLdKbn pRokudaildkbn) {
        rokudaildkbn = pRokudaildkbn;
    }

    private C_PmnjtkKbn pmnjtkkbn;

    @Type(type="UserType_C_PmnjtkKbn")
    @Column(name=GenIT_TesuuryouSyouhn.PMNJTKKBN)
    public C_PmnjtkKbn getPmnjtkkbn() {
        return pmnjtkkbn;
    }

    public void setPmnjtkkbn(C_PmnjtkKbn pPmnjtkkbn) {
        pmnjtkkbn = pPmnjtkkbn;
    }

    private BizCurrency kihons;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    public BizCurrency getKihons() {
        return kihons;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons(BizCurrency pKihons) {
        kihons = pKihons;
        kihonsValue = null;
        kihonsType  = null;
    }

    transient private BigDecimal kihonsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS, nullable=true)
    protected BigDecimal getKihonsValue() {
        if (kihonsValue == null && kihons != null) {
            if (kihons.isOptional()) return null;
            return kihons.absolute();
        }
        return kihonsValue;
    }

    protected void setKihonsValue(BigDecimal value) {
        kihonsValue = value;
        kihons = Optional.fromNullable(toCurrencyType(kihonsType))
            .transform(bizCurrencyTransformer(getKihonsValue()))
            .orNull();
    }

    transient private String kihonsType = null;

    @Column(name=KIHONS + "$", nullable=true)
    protected String getKihonsType() {
        if (kihonsType == null && kihons != null) return kihons.getType().toString();
        if (kihonsType == null && getKihonsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons$' should not be NULL."));
        }
        return kihonsType;
    }

    protected void setKihonsType(String type) {
        kihonsType = type;
        kihons = Optional.fromNullable(toCurrencyType(kihonsType))
            .transform(bizCurrencyTransformer(getKihonsValue()))
            .orNull();
    }

    private BizCurrency hokenryou;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHokenryou() {
        return hokenryou;
    }

    public void setHokenryou(BizCurrency pHokenryou) {
        hokenryou = pHokenryou;
        hokenryouValue = null;
        hokenryouType  = null;
    }

    transient private BigDecimal hokenryouValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HOKENRYOU, nullable=true)
    protected BigDecimal getHokenryouValue() {
        if (hokenryouValue == null && hokenryou != null) {
            if (hokenryou.isOptional()) return null;
            return hokenryou.absolute();
        }
        return hokenryouValue;
    }

    protected void setHokenryouValue(BigDecimal value) {
        hokenryouValue = value;
        hokenryou = Optional.fromNullable(toCurrencyType(hokenryouType))
            .transform(bizCurrencyTransformer(getHokenryouValue()))
            .orNull();
    }

    transient private String hokenryouType = null;

    @Column(name=HOKENRYOU + "$", nullable=true)
    protected String getHokenryouType() {
        if (hokenryouType == null && hokenryou != null) return hokenryou.getType().toString();
        if (hokenryouType == null && getHokenryouValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hokenryou$' should not be NULL."));
        }
        return hokenryouType;
    }

    protected void setHokenryouType(String type) {
        hokenryouType = type;
        hokenryou = Optional.fromNullable(toCurrencyType(hokenryouType))
            .transform(bizCurrencyTransformer(getHokenryouValue()))
            .orNull();
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_TesuuryouSyouhn.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private String ryouritusdno;

    @Column(name=GenIT_TesuuryouSyouhn.RYOURITUSDNO)
    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        ryouritusdno = pRyouritusdno;
    }

    private BizNumber yoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_TesuuryouSyouhn.YOTEIRIRITU)
    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYoteiriritu(BizNumber pYoteiriritu) {
        yoteiriritu = pYoteiriritu;
    }

    private BizNumber yoteirrthendohosyurrt;

    @Type(type="BizNumberType")
    @Column(name=GenIT_TesuuryouSyouhn.YOTEIRRTHENDOHOSYURRT)
    public BizNumber getYoteirrthendohosyurrt() {
        return yoteirrthendohosyurrt;
    }

    public void setYoteirrthendohosyurrt(BizNumber pYoteirrthendohosyurrt) {
        yoteirrthendohosyurrt = pYoteirrthendohosyurrt;
    }

    private Integer ytirrthndmnskaisuu;

    @Column(name=GenIT_TesuuryouSyouhn.YTIRRTHNDMNSKAISUU)
    public Integer getYtirrthndmnskaisuu() {
        return ytirrthndmnskaisuu;
    }

    public void setYtirrthndmnskaisuu(Integer pYtirrthndmnskaisuu) {
        ytirrthndmnskaisuu = pYtirrthndmnskaisuu;
    }

    private BizNumber kyksjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_TesuuryouSyouhn.KYKSJKKKTYOUSEIRIRITU)
    public BizNumber getKyksjkkktyouseiriritu() {
        return kyksjkkktyouseiriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKyksjkkktyouseiriritu(BizNumber pKyksjkkktyouseiriritu) {
        kyksjkkktyouseiriritu = pKyksjkkktyouseiriritu;
    }

    private C_Nenkinsyu nksyukbn;

    @Type(type="UserType_C_Nenkinsyu")
    @Column(name=GenIT_TesuuryouSyouhn.NKSYUKBN)
    public C_Nenkinsyu getNksyukbn() {
        return nksyukbn;
    }

    public void setNksyukbn(C_Nenkinsyu pNksyukbn) {
        nksyukbn = pNksyukbn;
    }

    private Integer nenkinkkn;

    @Column(name=GenIT_TesuuryouSyouhn.NENKINKKN)
    public Integer getNenkinkkn() {
        return nenkinkkn;
    }

    public void setNenkinkkn(Integer pNenkinkkn) {
        nenkinkkn = pNenkinkkn;
    }

    private Integer nkgnshosyouritu;

    @Column(name=GenIT_TesuuryouSyouhn.NKGNSHOSYOURITU)
    public Integer getNkgnshosyouritu() {
        return nkgnshosyouritu;
    }

    public void setNkgnshosyouritu(Integer pNkgnshosyouritu) {
        nkgnshosyouritu = pNkgnshosyouritu;
    }

    private BizCurrency nkgnshosyougk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNkgnshosyougk() {
        return nkgnshosyougk;
    }

    public void setNkgnshosyougk(BizCurrency pNkgnshosyougk) {
        nkgnshosyougk = pNkgnshosyougk;
        nkgnshosyougkValue = null;
        nkgnshosyougkType  = null;
    }

    transient private BigDecimal nkgnshosyougkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NKGNSHOSYOUGK, nullable=true)
    protected BigDecimal getNkgnshosyougkValue() {
        if (nkgnshosyougkValue == null && nkgnshosyougk != null) {
            if (nkgnshosyougk.isOptional()) return null;
            return nkgnshosyougk.absolute();
        }
        return nkgnshosyougkValue;
    }

    protected void setNkgnshosyougkValue(BigDecimal value) {
        nkgnshosyougkValue = value;
        nkgnshosyougk = Optional.fromNullable(toCurrencyType(nkgnshosyougkType))
            .transform(bizCurrencyTransformer(getNkgnshosyougkValue()))
            .orNull();
    }

    transient private String nkgnshosyougkType = null;

    @Column(name=NKGNSHOSYOUGK + "$", nullable=true)
    protected String getNkgnshosyougkType() {
        if (nkgnshosyougkType == null && nkgnshosyougk != null) return nkgnshosyougk.getType().toString();
        if (nkgnshosyougkType == null && getNkgnshosyougkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'nkgnshosyougk$' should not be NULL."));
        }
        return nkgnshosyougkType;
    }

    protected void setNkgnshosyougkType(String type) {
        nkgnshosyougkType = type;
        nkgnshosyougk = Optional.fromNullable(toCurrencyType(nkgnshosyougkType))
            .transform(bizCurrencyTransformer(getNkgnshosyougkValue()))
            .orNull();
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_TesuuryouSyouhn.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_TesuuryouSyouhn.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_TesuuryouSyouhn.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
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
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
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
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.id.PKIT_KykSyouhnHnkmae;
import yuyu.def.db.meta.GenQIT_KykSyouhnHnkmae;
import yuyu.def.db.meta.QIT_KykSyouhnHnkmae;
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
import yuyu.def.db.type.UserType_C_Sisuukbn;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_SyukyhkinkataKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_TargetTkKbn;
import yuyu.def.db.type.UserType_C_TmttknhaibunjyoutaiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YuukousyoumetuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約商品変更前内容テーブル テーブルのマッピング情報クラスで、 {@link IT_KykSyouhnHnkmae} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KykSyouhnHnkmae}</td><td colspan="3">契約商品変更前内容テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KykSyouhnHnkmae ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KykSyouhnHnkmae ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">{@link PKIT_KykSyouhnHnkmae ○}</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKIT_KykSyouhnHnkmae ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">{@link PKIT_KykSyouhnHnkmae ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno kyksyouhnrenno}</td><td>契約商品連番</td><td align="center">{@link PKIT_KykSyouhnHnkmae ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_KykSyouhnHnkmae ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYuukousyoumetukbn yuukousyoumetukbn}</td><td>有効消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YuukousyoumetuKbn}</td></tr>
 *  <tr><td>{@link #getKykjyoutai kykjyoutai}</td><td>契約状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kykjyoutai}</td></tr>
 *  <tr><td>{@link #getSyoumetujiyuu syoumetujiyuu}</td><td>消滅事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syoumetujiyuu}</td></tr>
 *  <tr><td>{@link #getSyoumetuymd syoumetuymd}</td><td>消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKouryokuhasseiymd kouryokuhasseiymd}</td><td>効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymdsiteiumukbn kykymdsiteiumukbn}</td><td>契約日指定有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSknnkaisiymd sknnkaisiymd}</td><td>責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGansknnkaisiymd gansknnkaisiymd}</td><td>がん責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHksknnkaisiymd hksknnkaisiymd}</td><td>復活責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHkgansknnkaisiymd hkgansknnkaisiymd}</td><td>復活がん責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
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
 *  <tr><td>{@link #getGengakugoyenitijibrpstgk gengakugoyenitijibrpstgk}</td><td>減額後円換算一時払保険料相当額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYendthnkymd yendthnkymd}</td><td>円建変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSetteibairitu setteibairitu}</td><td>設定倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKykjisisuurendourate kykjisisuurendourate}</td><td>契約時指数連動部分割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTmttknzoukaritujygn tmttknzoukaritujygn}</td><td>積立金増加率上限</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTumitateriritu tumitateriritu}</td><td>積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTmttknhaibunjyoutai tmttknhaibunjyoutai}</td><td>積立金配分状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TmttknhaibunjyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getSisuukbn sisuukbn}</td><td>指数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sisuukbn}</td></tr>
 *  <tr><td>{@link #getGsbunrikzkakuninumu gsbunrikzkakuninumu}</td><td>源泉分離課税確認有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGsbunritaisyou gsbunritaisyou}</td><td>源泉分離課税対象</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTargettkhkumu targettkhkumu}</td><td>ターゲット特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTargettkykkykhenkoymd targettkykkykhenkoymd}</td><td>ターゲット特約契約変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTargettkkbn targettkkbn}</td><td>ターゲット特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TargetTkKbn}</td></tr>
 *  <tr><td>{@link #getTargettkmokuhyouti targettkmokuhyouti}</td><td>ターゲット特約目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getInitsbjiyensitihsytkhukaumu initsbjiyensitihsytkhukaumu}</td><td>初期死亡時円換算最低保証特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getInitsbjiyenkasaiteihsygk initsbjiyenkasaiteihsygk}</td><td>初期死亡時円換算最低保証額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTargettkykhkymd targettkykhkymd}</td><td>ターゲット特約付加日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTargettkykkijyungk targettkykkijyungk}</td><td>ターゲット特約基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1hknkkn dai1hknkkn}</td><td>第１保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaitounendo haitounendo}</td><td>配当年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>{@link #getPharaikomisougaku pharaikomisougaku}</td><td>保険料払込総額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTmttknitenymd tmttknitenymd}</td><td>積立金移転日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLoadinghnkgtumitateriritu loadinghnkgtumitateriritu}</td><td>ローディング変更後積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRendouritu rendouritu}</td><td>連動率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTeikishrritu teikishrritu}</td><td>定期支払率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getJyudkaigomeharaitkhukaumu jyudkaigomeharaitkhukaumu}</td><td>重度介護前払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getJyudkaigomeharaitkhukaymd jyudkaigomeharaitkhukaymd}</td><td>重度介護前払特約付加日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     IT_KykSyouhnHnkmae
 * @see     PKIT_KykSyouhnHnkmae
 * @see     QIT_KykSyouhnHnkmae
 * @see     GenQIT_KykSyouhnHnkmae
 */
@MappedSuperclass
@Table(name=GenIT_KykSyouhnHnkmae.TABLE_NAME)
@IdClass(value=PKIT_KykSyouhnHnkmae.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYType", typeClass=BizDateYType.class),
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
    @TypeDef(name="UserType_C_Sisuukbn", typeClass=UserType_C_Sisuukbn.class),
    @TypeDef(name="UserType_C_Syoumetujiyuu", typeClass=UserType_C_Syoumetujiyuu.class),
    @TypeDef(name="UserType_C_SyukyhkinkataKbn", typeClass=UserType_C_SyukyhkinkataKbn.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class),
    @TypeDef(name="UserType_C_TargetTkKbn", typeClass=UserType_C_TargetTkKbn.class),
    @TypeDef(name="UserType_C_TmttknhaibunjyoutaiKbn", typeClass=UserType_C_TmttknhaibunjyoutaiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YuukousyoumetuKbn", typeClass=UserType_C_YuukousyoumetuKbn.class)
})
public abstract class GenIT_KykSyouhnHnkmae extends AbstractExDBEntity<IT_KykSyouhnHnkmae, PKIT_KykSyouhnHnkmae> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KykSyouhnHnkmae";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String SYUTKKBN                 = "syutkkbn";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KYKSYOUHNRENNO           = "kyksyouhnrenno";
    public static final String RENNO                    = "renno";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String YUUKOUSYOUMETUKBN        = "yuukousyoumetukbn";
    public static final String KYKJYOUTAI               = "kykjyoutai";
    public static final String SYOUMETUJIYUU            = "syoumetujiyuu";
    public static final String SYOUMETUYMD              = "syoumetuymd";
    public static final String KOURYOKUHASSEIYMD        = "kouryokuhasseiymd";
    public static final String KYKYMD                   = "kykymd";
    public static final String KYKYMDSITEIUMUKBN        = "kykymdsiteiumukbn";
    public static final String SKNNKAISIYMD             = "sknnkaisiymd";
    public static final String GANSKNNKAISIYMD          = "gansknnkaisiymd";
    public static final String HKSKNNKAISIYMD           = "hksknnkaisiymd";
    public static final String HKGANSKNNKAISIYMD        = "hkgansknnkaisiymd";
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
    public static final String GENGAKUGOYENITIJIBRPSTGK = "gengakugoyenitijibrpstgk";
    public static final String YENDTHNKYMD              = "yendthnkymd";
    public static final String SETTEIBAIRITU            = "setteibairitu";
    public static final String KYKJISISUURENDOURATE     = "kykjisisuurendourate";
    public static final String TMTTKNZOUKARITUJYGN      = "tmttknzoukaritujygn";
    public static final String TUMITATERIRITU           = "tumitateriritu";
    public static final String TMTTKNHAIBUNJYOUTAI      = "tmttknhaibunjyoutai";
    public static final String SISUUKBN                 = "sisuukbn";
    public static final String GSBUNRIKZKAKUNINUMU      = "gsbunrikzkakuninumu";
    public static final String GSBUNRITAISYOU           = "gsbunritaisyou";
    public static final String TARGETTKHKUMU            = "targettkhkumu";
    public static final String TARGETTKYKKYKHENKOYMD    = "targettkykkykhenkoymd";
    public static final String TARGETTKKBN              = "targettkkbn";
    public static final String TARGETTKMOKUHYOUTI       = "targettkmokuhyouti";
    public static final String INITSBJIYENSITIHSYTKHUKAUMU = "initsbjiyensitihsytkhukaumu";
    public static final String INITSBJIYENKASAITEIHSYGK = "initsbjiyenkasaiteihsygk";
    public static final String TARGETTKYKHKYMD          = "targettkykhkymd";
    public static final String TARGETTKYKKIJYUNGK       = "targettkykkijyungk";
    public static final String DAI1HKNKKN               = "dai1hknkkn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String HAITOUNENDO              = "haitounendo";
    public static final String PHARAIKOMISOUGAKU        = "pharaikomisougaku";
    public static final String TMTTKNITENYMD            = "tmttknitenymd";
    public static final String LOADINGHNKGTUMITATERIRITU = "loadinghnkgtumitateriritu";
    public static final String RENDOURITU               = "rendouritu";
    public static final String TEIKISHRRITU             = "teikishrritu";
    public static final String JYUDKAIGOMEHARAITKHUKAUMU = "jyudkaigomeharaitkhukaumu";
    public static final String JYUDKAIGOMEHARAITKHUKAYMD = "jyudkaigomeharaitkhukaymd";

    private final PKIT_KykSyouhnHnkmae primaryKey;

    public GenIT_KykSyouhnHnkmae() {
        primaryKey = new PKIT_KykSyouhnHnkmae();
    }

    public GenIT_KykSyouhnHnkmae(
        String pKbnkey,
        String pSyono,
        C_SyutkKbn pSyutkkbn,
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno,
        Integer pRenno
    ) {
        primaryKey = new PKIT_KykSyouhnHnkmae(
            pKbnkey,
            pSyono,
            pSyutkkbn,
            pSyouhncd,
            pSyouhnsdno,
            pKyksyouhnrenno,
            pRenno
        );
    }

    @Transient
    @Override
    public PKIT_KykSyouhnHnkmae getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KykSyouhnHnkmae> getMetaClass() {
        return QIT_KykSyouhnHnkmae.class;
    }

    @Id
    @Column(name=GenIT_KykSyouhnHnkmae.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KykSyouhnHnkmae.SYONO)
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
    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.SYUTKKBN)
    public C_SyutkKbn getSyutkkbn() {
        return getPrimaryKey().getSyutkkbn();
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        getPrimaryKey().setSyutkkbn(pSyutkkbn);
    }

    @Id
    @Column(name=GenIT_KykSyouhnHnkmae.SYOUHNCD)
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
    @Column(name=GenIT_KykSyouhnHnkmae.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return getPrimaryKey().getSyouhnsdno();
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        getPrimaryKey().setSyouhnsdno(pSyouhnsdno);
    }

    @Id
    @Column(name=GenIT_KykSyouhnHnkmae.KYKSYOUHNRENNO)
    public Integer getKyksyouhnrenno() {
        return getPrimaryKey().getKyksyouhnrenno();
    }

    public void setKyksyouhnrenno(Integer pKyksyouhnrenno) {
        getPrimaryKey().setKyksyouhnrenno(pKyksyouhnrenno);
    }

    @Id
    @Column(name=GenIT_KykSyouhnHnkmae.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private String henkousikibetukey;

    @Column(name=GenIT_KykSyouhnHnkmae.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    @Type(type="UserType_C_YuukousyoumetuKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.YUUKOUSYOUMETUKBN)
    public C_YuukousyoumetuKbn getYuukousyoumetukbn() {
        return yuukousyoumetukbn;
    }

    public void setYuukousyoumetukbn(C_YuukousyoumetuKbn pYuukousyoumetukbn) {
        yuukousyoumetukbn = pYuukousyoumetukbn;
    }

    private C_Kykjyoutai kykjyoutai;

    @Type(type="UserType_C_Kykjyoutai")
    @Column(name=GenIT_KykSyouhnHnkmae.KYKJYOUTAI)
    public C_Kykjyoutai getKykjyoutai() {
        return kykjyoutai;
    }

    public void setKykjyoutai(C_Kykjyoutai pKykjyoutai) {
        kykjyoutai = pKykjyoutai;
    }

    private C_Syoumetujiyuu syoumetujiyuu;

    @Type(type="UserType_C_Syoumetujiyuu")
    @Column(name=GenIT_KykSyouhnHnkmae.SYOUMETUJIYUU)
    public C_Syoumetujiyuu getSyoumetujiyuu() {
        return syoumetujiyuu;
    }

    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu) {
        syoumetujiyuu = pSyoumetujiyuu;
    }

    private BizDate syoumetuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSyouhnHnkmae.SYOUMETUYMD)
    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    @Trim("both")
    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
    }

    private BizDate kouryokuhasseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSyouhnHnkmae.KOURYOKUHASSEIYMD)
    public BizDate getKouryokuhasseiymd() {
        return kouryokuhasseiymd;
    }

    public void setKouryokuhasseiymd(BizDate pKouryokuhasseiymd) {
        kouryokuhasseiymd = pKouryokuhasseiymd;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSyouhnHnkmae.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_UmuKbn kykymdsiteiumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.KYKYMDSITEIUMUKBN)
    public C_UmuKbn getKykymdsiteiumukbn() {
        return kykymdsiteiumukbn;
    }

    public void setKykymdsiteiumukbn(C_UmuKbn pKykymdsiteiumukbn) {
        kykymdsiteiumukbn = pKykymdsiteiumukbn;
    }

    private BizDate sknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSyouhnHnkmae.SKNNKAISIYMD)
    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    @Trim("both")
    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    private BizDate gansknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSyouhnHnkmae.GANSKNNKAISIYMD)
    public BizDate getGansknnkaisiymd() {
        return gansknnkaisiymd;
    }

    public void setGansknnkaisiymd(BizDate pGansknnkaisiymd) {
        gansknnkaisiymd = pGansknnkaisiymd;
    }

    private BizDate hksknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSyouhnHnkmae.HKSKNNKAISIYMD)
    public BizDate getHksknnkaisiymd() {
        return hksknnkaisiymd;
    }

    public void setHksknnkaisiymd(BizDate pHksknnkaisiymd) {
        hksknnkaisiymd = pHksknnkaisiymd;
    }

    private BizDate hkgansknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSyouhnHnkmae.HKGANSKNNKAISIYMD)
    @ValidDate
    public BizDate getHkgansknnkaisiymd() {
        return hkgansknnkaisiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHkgansknnkaisiymd(BizDate pHkgansknnkaisiymd) {
        hkgansknnkaisiymd = pHkgansknnkaisiymd;
    }

    private C_HknkknsmnKbn hknkknsmnkbn;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.HKNKKNSMNKBN)
    public C_HknkknsmnKbn getHknkknsmnkbn() {
        return hknkknsmnkbn;
    }

    public void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnkbn) {
        hknkknsmnkbn = pHknkknsmnkbn;
    }

    private Integer hknkkn;

    @Column(name=GenIT_KykSyouhnHnkmae.HKNKKN)
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
    @Column(name=GenIT_KykSyouhnHnkmae.HRKKKNSMNKBN)
    public C_HrkkknsmnKbn getHrkkknsmnkbn() {
        return hrkkknsmnkbn;
    }

    public void setHrkkknsmnkbn(C_HrkkknsmnKbn pHrkkknsmnkbn) {
        hrkkknsmnkbn = pHrkkknsmnkbn;
    }

    private Integer hrkkkn;

    @Column(name=GenIT_KykSyouhnHnkmae.HRKKKN)
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

    @Column(name=GenIT_KykSyouhnHnkmae.KYKNEN)
    public Integer getKyknen() {
        return kyknen;
    }

    public void setKyknen(Integer pKyknen) {
        kyknen = pKyknen;
    }

    private Integer hhknnen;

    @Column(name=GenIT_KykSyouhnHnkmae.HHKNNEN)
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
    @Column(name=GenIT_KykSyouhnHnkmae.HHKNSEIYMD)
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
    @Column(name=GenIT_KykSyouhnHnkmae.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private BizDate haraimanymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSyouhnHnkmae.HARAIMANYMD)
    public BizDate getHaraimanymd() {
        return haraimanymd;
    }

    public void setHaraimanymd(BizDate pHaraimanymd) {
        haraimanymd = pHaraimanymd;
    }

    private BizDate hknkknmanryouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSyouhnHnkmae.HKNKKNMANRYOUYMD)
    public BizDate getHknkknmanryouymd() {
        return hknkknmanryouymd;
    }

    public void setHknkknmanryouymd(BizDate pHknkknmanryouymd) {
        hknkknmanryouymd = pHknkknmanryouymd;
    }

    private C_KataKbn katakbn;

    @Type(type="UserType_C_KataKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.KATAKBN)
    public C_KataKbn getKatakbn() {
        return katakbn;
    }

    public void setKatakbn(C_KataKbn pKatakbn) {
        katakbn = pKatakbn;
    }

    private C_KyhgndkataKbn kyhgndkatakbn;

    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.KYHGNDKATAKBN)
    public C_KyhgndkataKbn getKyhgndkatakbn() {
        return kyhgndkatakbn;
    }

    public void setKyhgndkatakbn(C_KyhgndkataKbn pKyhgndkatakbn) {
        kyhgndkatakbn = pKyhgndkatakbn;
    }

    private C_SyukyhkinkataKbn syukyhkinkatakbn;

    @Type(type="UserType_C_SyukyhkinkataKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.SYUKYHKINKATAKBN)
    public C_SyukyhkinkataKbn getSyukyhkinkatakbn() {
        return syukyhkinkatakbn;
    }

    public void setSyukyhkinkatakbn(C_SyukyhkinkataKbn pSyukyhkinkatakbn) {
        syukyhkinkatakbn = pSyukyhkinkatakbn;
    }

    private C_KhnkyhkgbairituKbn khnkyhkgbairitukbn;

    @Type(type="UserType_C_KhnkyhkgbairituKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.KHNKYHKGBAIRITUKBN)
    public C_KhnkyhkgbairituKbn getKhnkyhkgbairitukbn() {
        return khnkyhkgbairitukbn;
    }

    public void setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn) {
        khnkyhkgbairitukbn = pKhnkyhkgbairitukbn;
    }

    private C_6daiLdKbn rokudaildkbn;

    @Type(type="UserType_C_6daiLdKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.ROKUDAILDKBN)
    public C_6daiLdKbn getRokudaildkbn() {
        return rokudaildkbn;
    }

    public void setRokudaildkbn(C_6daiLdKbn pRokudaildkbn) {
        rokudaildkbn = pRokudaildkbn;
    }

    private C_PmnjtkKbn pmnjtkkbn;

    @Type(type="UserType_C_PmnjtkKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.PMNJTKKBN)
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
    @Column(name=GenIT_KykSyouhnHnkmae.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private String ryouritusdno;

    @Column(name=GenIT_KykSyouhnHnkmae.RYOURITUSDNO)
    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        ryouritusdno = pRyouritusdno;
    }

    private BizNumber yoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KykSyouhnHnkmae.YOTEIRIRITU)
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
    @Column(name=GenIT_KykSyouhnHnkmae.YOTEIRRTHENDOHOSYURRT)
    public BizNumber getYoteirrthendohosyurrt() {
        return yoteirrthendohosyurrt;
    }

    public void setYoteirrthendohosyurrt(BizNumber pYoteirrthendohosyurrt) {
        yoteirrthendohosyurrt = pYoteirrthendohosyurrt;
    }

    private Integer ytirrthndmnskaisuu;

    @Column(name=GenIT_KykSyouhnHnkmae.YTIRRTHNDMNSKAISUU)
    public Integer getYtirrthndmnskaisuu() {
        return ytirrthndmnskaisuu;
    }

    public void setYtirrthndmnskaisuu(Integer pYtirrthndmnskaisuu) {
        ytirrthndmnskaisuu = pYtirrthndmnskaisuu;
    }

    private BizNumber kyksjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KykSyouhnHnkmae.KYKSJKKKTYOUSEIRIRITU)
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
    @Column(name=GenIT_KykSyouhnHnkmae.NKSYUKBN)
    public C_Nenkinsyu getNksyukbn() {
        return nksyukbn;
    }

    public void setNksyukbn(C_Nenkinsyu pNksyukbn) {
        nksyukbn = pNksyukbn;
    }

    private Integer nenkinkkn;

    @Column(name=GenIT_KykSyouhnHnkmae.NENKINKKN)
    public Integer getNenkinkkn() {
        return nenkinkkn;
    }

    public void setNenkinkkn(Integer pNenkinkkn) {
        nenkinkkn = pNenkinkkn;
    }

    private Integer nkgnshosyouritu;

    @Column(name=GenIT_KykSyouhnHnkmae.NKGNSHOSYOURITU)
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

    private BizCurrency gengakugoyenitijibrpstgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGengakugoyenitijibrpstgk() {
        return gengakugoyenitijibrpstgk;
    }

    public void setGengakugoyenitijibrpstgk(BizCurrency pGengakugoyenitijibrpstgk) {
        gengakugoyenitijibrpstgk = pGengakugoyenitijibrpstgk;
        gengakugoyenitijibrpstgkValue = null;
        gengakugoyenitijibrpstgkType  = null;
    }

    transient private BigDecimal gengakugoyenitijibrpstgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GENGAKUGOYENITIJIBRPSTGK, nullable=true)
    protected BigDecimal getGengakugoyenitijibrpstgkValue() {
        if (gengakugoyenitijibrpstgkValue == null && gengakugoyenitijibrpstgk != null) {
            if (gengakugoyenitijibrpstgk.isOptional()) return null;
            return gengakugoyenitijibrpstgk.absolute();
        }
        return gengakugoyenitijibrpstgkValue;
    }

    protected void setGengakugoyenitijibrpstgkValue(BigDecimal value) {
        gengakugoyenitijibrpstgkValue = value;
        gengakugoyenitijibrpstgk = Optional.fromNullable(toCurrencyType(gengakugoyenitijibrpstgkType))
            .transform(bizCurrencyTransformer(getGengakugoyenitijibrpstgkValue()))
            .orNull();
    }

    transient private String gengakugoyenitijibrpstgkType = null;

    @Column(name=GENGAKUGOYENITIJIBRPSTGK + "$", nullable=true)
    protected String getGengakugoyenitijibrpstgkType() {
        if (gengakugoyenitijibrpstgkType == null && gengakugoyenitijibrpstgk != null) return gengakugoyenitijibrpstgk.getType().toString();
        if (gengakugoyenitijibrpstgkType == null && getGengakugoyenitijibrpstgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gengakugoyenitijibrpstgk$' should not be NULL."));
        }
        return gengakugoyenitijibrpstgkType;
    }

    protected void setGengakugoyenitijibrpstgkType(String type) {
        gengakugoyenitijibrpstgkType = type;
        gengakugoyenitijibrpstgk = Optional.fromNullable(toCurrencyType(gengakugoyenitijibrpstgkType))
            .transform(bizCurrencyTransformer(getGengakugoyenitijibrpstgkValue()))
            .orNull();
    }

    private BizDate yendthnkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSyouhnHnkmae.YENDTHNKYMD)
    public BizDate getYendthnkymd() {
        return yendthnkymd;
    }

    public void setYendthnkymd(BizDate pYendthnkymd) {
        yendthnkymd = pYendthnkymd;
    }

    private BizNumber setteibairitu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KykSyouhnHnkmae.SETTEIBAIRITU)
    public BizNumber getSetteibairitu() {
        return setteibairitu;
    }

    public void setSetteibairitu(BizNumber pSetteibairitu) {
        setteibairitu = pSetteibairitu;
    }

    private BizNumber kykjisisuurendourate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KykSyouhnHnkmae.KYKJISISUURENDOURATE)
    public BizNumber getKykjisisuurendourate() {
        return kykjisisuurendourate;
    }

    public void setKykjisisuurendourate(BizNumber pKykjisisuurendourate) {
        kykjisisuurendourate = pKykjisisuurendourate;
    }

    private BizNumber tmttknzoukaritujygn;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KykSyouhnHnkmae.TMTTKNZOUKARITUJYGN)
    public BizNumber getTmttknzoukaritujygn() {
        return tmttknzoukaritujygn;
    }

    public void setTmttknzoukaritujygn(BizNumber pTmttknzoukaritujygn) {
        tmttknzoukaritujygn = pTmttknzoukaritujygn;
    }

    private BizNumber tumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KykSyouhnHnkmae.TUMITATERIRITU)
    public BizNumber getTumitateriritu() {
        return tumitateriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTumitateriritu(BizNumber pTumitateriritu) {
        tumitateriritu = pTumitateriritu;
    }

    private C_TmttknhaibunjyoutaiKbn tmttknhaibunjyoutai;

    @Type(type="UserType_C_TmttknhaibunjyoutaiKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.TMTTKNHAIBUNJYOUTAI)
    public C_TmttknhaibunjyoutaiKbn getTmttknhaibunjyoutai() {
        return tmttknhaibunjyoutai;
    }

    public void setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn pTmttknhaibunjyoutai) {
        tmttknhaibunjyoutai = pTmttknhaibunjyoutai;
    }

    private C_Sisuukbn sisuukbn;

    @Type(type="UserType_C_Sisuukbn")
    @Column(name=GenIT_KykSyouhnHnkmae.SISUUKBN)
    public C_Sisuukbn getSisuukbn() {
        return sisuukbn;
    }

    public void setSisuukbn(C_Sisuukbn pSisuukbn) {
        sisuukbn = pSisuukbn;
    }

    private C_UmuKbn gsbunrikzkakuninumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.GSBUNRIKZKAKUNINUMU)
    public C_UmuKbn getGsbunrikzkakuninumu() {
        return gsbunrikzkakuninumu;
    }

    public void setGsbunrikzkakuninumu(C_UmuKbn pGsbunrikzkakuninumu) {
        gsbunrikzkakuninumu = pGsbunrikzkakuninumu;
    }

    private C_UmuKbn gsbunritaisyou;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.GSBUNRITAISYOU)
    public C_UmuKbn getGsbunritaisyou() {
        return gsbunritaisyou;
    }

    public void setGsbunritaisyou(C_UmuKbn pGsbunritaisyou) {
        gsbunritaisyou = pGsbunritaisyou;
    }

    private C_UmuKbn targettkhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.TARGETTKHKUMU)
    public C_UmuKbn getTargettkhkumu() {
        return targettkhkumu;
    }

    public void setTargettkhkumu(C_UmuKbn pTargettkhkumu) {
        targettkhkumu = pTargettkhkumu;
    }

    private BizDate targettkykkykhenkoymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSyouhnHnkmae.TARGETTKYKKYKHENKOYMD)
    @ValidDate
    public BizDate getTargettkykkykhenkoymd() {
        return targettkykkykhenkoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTargettkykkykhenkoymd(BizDate pTargettkykkykhenkoymd) {
        targettkykkykhenkoymd = pTargettkykkykhenkoymd;
    }

    private C_TargetTkKbn targettkkbn;

    @Type(type="UserType_C_TargetTkKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.TARGETTKKBN)
    public C_TargetTkKbn getTargettkkbn() {
        return targettkkbn;
    }

    public void setTargettkkbn(C_TargetTkKbn pTargettkkbn) {
        targettkkbn = pTargettkkbn;
    }

    private Integer targettkmokuhyouti;

    @Column(name=GenIT_KykSyouhnHnkmae.TARGETTKMOKUHYOUTI)
    public Integer getTargettkmokuhyouti() {
        return targettkmokuhyouti;
    }

    public void setTargettkmokuhyouti(Integer pTargettkmokuhyouti) {
        targettkmokuhyouti = pTargettkmokuhyouti;
    }

    private C_UmuKbn initsbjiyensitihsytkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.INITSBJIYENSITIHSYTKHUKAUMU)
    public C_UmuKbn getInitsbjiyensitihsytkhukaumu() {
        return initsbjiyensitihsytkhukaumu;
    }

    public void setInitsbjiyensitihsytkhukaumu(C_UmuKbn pInitsbjiyensitihsytkhukaumu) {
        initsbjiyensitihsytkhukaumu = pInitsbjiyensitihsytkhukaumu;
    }

    private BizCurrency initsbjiyenkasaiteihsygk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getInitsbjiyenkasaiteihsygk() {
        return initsbjiyenkasaiteihsygk;
    }

    public void setInitsbjiyenkasaiteihsygk(BizCurrency pInitsbjiyenkasaiteihsygk) {
        initsbjiyenkasaiteihsygk = pInitsbjiyenkasaiteihsygk;
        initsbjiyenkasaiteihsygkValue = null;
        initsbjiyenkasaiteihsygkType  = null;
    }

    transient private BigDecimal initsbjiyenkasaiteihsygkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=INITSBJIYENKASAITEIHSYGK, nullable=true)
    protected BigDecimal getInitsbjiyenkasaiteihsygkValue() {
        if (initsbjiyenkasaiteihsygkValue == null && initsbjiyenkasaiteihsygk != null) {
            if (initsbjiyenkasaiteihsygk.isOptional()) return null;
            return initsbjiyenkasaiteihsygk.absolute();
        }
        return initsbjiyenkasaiteihsygkValue;
    }

    protected void setInitsbjiyenkasaiteihsygkValue(BigDecimal value) {
        initsbjiyenkasaiteihsygkValue = value;
        initsbjiyenkasaiteihsygk = Optional.fromNullable(toCurrencyType(initsbjiyenkasaiteihsygkType))
            .transform(bizCurrencyTransformer(getInitsbjiyenkasaiteihsygkValue()))
            .orNull();
    }

    transient private String initsbjiyenkasaiteihsygkType = null;

    @Column(name=INITSBJIYENKASAITEIHSYGK + "$", nullable=true)
    protected String getInitsbjiyenkasaiteihsygkType() {
        if (initsbjiyenkasaiteihsygkType == null && initsbjiyenkasaiteihsygk != null) return initsbjiyenkasaiteihsygk.getType().toString();
        if (initsbjiyenkasaiteihsygkType == null && getInitsbjiyenkasaiteihsygkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'initsbjiyenkasaiteihsygk$' should not be NULL."));
        }
        return initsbjiyenkasaiteihsygkType;
    }

    protected void setInitsbjiyenkasaiteihsygkType(String type) {
        initsbjiyenkasaiteihsygkType = type;
        initsbjiyenkasaiteihsygk = Optional.fromNullable(toCurrencyType(initsbjiyenkasaiteihsygkType))
            .transform(bizCurrencyTransformer(getInitsbjiyenkasaiteihsygkValue()))
            .orNull();
    }

    private BizDate targettkykhkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSyouhnHnkmae.TARGETTKYKHKYMD)
    @ValidDate
    public BizDate getTargettkykhkymd() {
        return targettkykhkymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTargettkykhkymd(BizDate pTargettkykhkymd) {
        targettkykhkymd = pTargettkykhkymd;
    }

    private BizCurrency targettkykkijyungk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTargettkykkijyungk() {
        return targettkykkijyungk;
    }

    public void setTargettkykkijyungk(BizCurrency pTargettkykkijyungk) {
        targettkykkijyungk = pTargettkykkijyungk;
        targettkykkijyungkValue = null;
        targettkykkijyungkType  = null;
    }

    transient private BigDecimal targettkykkijyungkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TARGETTKYKKIJYUNGK, nullable=true)
    protected BigDecimal getTargettkykkijyungkValue() {
        if (targettkykkijyungkValue == null && targettkykkijyungk != null) {
            if (targettkykkijyungk.isOptional()) return null;
            return targettkykkijyungk.absolute();
        }
        return targettkykkijyungkValue;
    }

    protected void setTargettkykkijyungkValue(BigDecimal value) {
        targettkykkijyungkValue = value;
        targettkykkijyungk = Optional.fromNullable(toCurrencyType(targettkykkijyungkType))
            .transform(bizCurrencyTransformer(getTargettkykkijyungkValue()))
            .orNull();
    }

    transient private String targettkykkijyungkType = null;

    @Column(name=TARGETTKYKKIJYUNGK + "$", nullable=true)
    protected String getTargettkykkijyungkType() {
        if (targettkykkijyungkType == null && targettkykkijyungk != null) return targettkykkijyungk.getType().toString();
        if (targettkykkijyungkType == null && getTargettkykkijyungkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'targettkykkijyungk$' should not be NULL."));
        }
        return targettkykkijyungkType;
    }

    protected void setTargettkykkijyungkType(String type) {
        targettkykkijyungkType = type;
        targettkykkijyungk = Optional.fromNullable(toCurrencyType(targettkykkijyungkType))
            .transform(bizCurrencyTransformer(getTargettkykkijyungkValue()))
            .orNull();
    }

    private Integer dai1hknkkn;

    @Column(name=GenIT_KykSyouhnHnkmae.DAI1HKNKKN)
    @Range(min="0", max="99")
    public Integer getDai1hknkkn() {
        return dai1hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai1hknkkn(Integer pDai1hknkkn) {
        dai1hknkkn = pDai1hknkkn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KykSyouhnHnkmae.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KykSyouhnHnkmae.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KykSyouhnHnkmae.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private BizDateY haitounendo;

    @Type(type="BizDateYType")
    @Column(name=GenIT_KykSyouhnHnkmae.HAITOUNENDO)
    public BizDateY getHaitounendo() {
        return haitounendo;
    }

    public void setHaitounendo(BizDateY pHaitounendo) {
        haitounendo = pHaitounendo;
    }

    private BizCurrency pharaikomisougaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getPharaikomisougaku() {
        return pharaikomisougaku;
    }

    public void setPharaikomisougaku(BizCurrency pPharaikomisougaku) {
        pharaikomisougaku = pPharaikomisougaku;
        pharaikomisougakuValue = null;
        pharaikomisougakuType  = null;
    }

    transient private BigDecimal pharaikomisougakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=PHARAIKOMISOUGAKU, nullable=true)
    protected BigDecimal getPharaikomisougakuValue() {
        if (pharaikomisougakuValue == null && pharaikomisougaku != null) {
            if (pharaikomisougaku.isOptional()) return null;
            return pharaikomisougaku.absolute();
        }
        return pharaikomisougakuValue;
    }

    protected void setPharaikomisougakuValue(BigDecimal value) {
        pharaikomisougakuValue = value;
        pharaikomisougaku = Optional.fromNullable(toCurrencyType(pharaikomisougakuType))
            .transform(bizCurrencyTransformer(getPharaikomisougakuValue()))
            .orNull();
    }

    transient private String pharaikomisougakuType = null;

    @Column(name=PHARAIKOMISOUGAKU + "$", nullable=true)
    protected String getPharaikomisougakuType() {
        if (pharaikomisougakuType == null && pharaikomisougaku != null) return pharaikomisougaku.getType().toString();
        if (pharaikomisougakuType == null && getPharaikomisougakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'pharaikomisougaku$' should not be NULL."));
        }
        return pharaikomisougakuType;
    }

    protected void setPharaikomisougakuType(String type) {
        pharaikomisougakuType = type;
        pharaikomisougaku = Optional.fromNullable(toCurrencyType(pharaikomisougakuType))
            .transform(bizCurrencyTransformer(getPharaikomisougakuValue()))
            .orNull();
    }

    private BizDate tmttknitenymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSyouhnHnkmae.TMTTKNITENYMD)
    public BizDate getTmttknitenymd() {
        return tmttknitenymd;
    }

    public void setTmttknitenymd(BizDate pTmttknitenymd) {
        tmttknitenymd = pTmttknitenymd;
    }

    private BizNumber loadinghnkgtumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KykSyouhnHnkmae.LOADINGHNKGTUMITATERIRITU)
    public BizNumber getLoadinghnkgtumitateriritu() {
        return loadinghnkgtumitateriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLoadinghnkgtumitateriritu(BizNumber pLoadinghnkgtumitateriritu) {
        loadinghnkgtumitateriritu = pLoadinghnkgtumitateriritu;
    }

    private BizNumber rendouritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KykSyouhnHnkmae.RENDOURITU)
    public BizNumber getRendouritu() {
        return rendouritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRendouritu(BizNumber pRendouritu) {
        rendouritu = pRendouritu;
    }

    private BizNumber teikishrritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KykSyouhnHnkmae.TEIKISHRRITU)
    public BizNumber getTeikishrritu() {
        return teikishrritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTeikishrritu(BizNumber pTeikishrritu) {
        teikishrritu = pTeikishrritu;
    }

    private C_UmuKbn jyudkaigomeharaitkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykSyouhnHnkmae.JYUDKAIGOMEHARAITKHUKAUMU)
    public C_UmuKbn getJyudkaigomeharaitkhukaumu() {
        return jyudkaigomeharaitkhukaumu;
    }

    public void setJyudkaigomeharaitkhukaumu(C_UmuKbn pJyudkaigomeharaitkhukaumu) {
        jyudkaigomeharaitkhukaumu = pJyudkaigomeharaitkhukaumu;
    }

    private BizDate jyudkaigomeharaitkhukaymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykSyouhnHnkmae.JYUDKAIGOMEHARAITKHUKAYMD)
    public BizDate getJyudkaigomeharaitkhukaymd() {
        return jyudkaigomeharaitkhukaymd;
    }

    public void setJyudkaigomeharaitkhukaymd(BizDate pJyudkaigomeharaitkhukaymd) {
        jyudkaigomeharaitkhukaymd = pJyudkaigomeharaitkhukaymd;
    }
}
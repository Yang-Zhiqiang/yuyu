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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.AlphaDigitOrExceptionCode;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_KoujyosyoumeimsgKbn;
import yuyu.def.classification.C_KoujyosyoumeisakuseisyoriKbn;
import yuyu.def.classification.C_KoujyosyoumeisentakuKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SaihkHyjKbn;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.id.PKIT_KoujyoSym;
import yuyu.def.db.meta.GenQIT_KoujyoSym;
import yuyu.def.db.meta.QIT_KoujyoSym;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_KoujyosyoumeimsgKbn;
import yuyu.def.db.type.UserType_C_KoujyosyoumeisakuseisyoriKbn;
import yuyu.def.db.type.UserType_C_KoujyosyoumeisentakuKbn;
import yuyu.def.db.type.UserType_C_Kykjyoutai;
import yuyu.def.db.type.UserType_C_SaihkHyjKbn;
import yuyu.def.db.type.UserType_C_TekiyouseidoKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YuukousyoumetuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 控除証明書テーブル テーブルのマッピング情報クラスで、 {@link IT_KoujyoSym} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KoujyoSym}</td><td colspan="3">控除証明書テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KoujyoSym ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KoujyoSym ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNendo nendo}</td><td>年度</td><td align="center">{@link PKIT_KoujyoSym ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKIT_KoujyoSym ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_KoujyoSym ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKjsmsakuseisyorikbn kjsmsakuseisyorikbn}</td><td>控除証明作成処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KoujyosyoumeisakuseisyoriKbn}</td></tr>
 *  <tr><td>{@link #getTekiyouseidokbn tekiyouseidokbn}</td><td>適用制度区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TekiyouseidoKbn}</td></tr>
 *  <tr><td>{@link #getSyoumeiymd syoumeiymd}</td><td>証明日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoumeistartym syoumeistartym}</td><td>証明開始年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSyoumeiendym syoumeiendym}</td><td>証明終了年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSyoumeikkntukisuu syoumeikkntukisuu}</td><td>証明期間月数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyoumeikknnensuu syoumeikknnensuu}</td><td>証明期間年数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktnmkjaddsama uktnmkjaddsama}</td><td>受取人名（漢字／様付加）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinuktseiymd nenkinuktseiymd}</td><td>年金受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHknsyuruinmrykkj hknsyuruinmrykkj}</td><td>保険種類略称（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbnsyu hknkknsmnkbnsyu}</td><td>保険期間歳満期区分（主契約）</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHknkknsyu hknkknsyu}</td><td>保険期間（主契約）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getNenkanhrkkaisuu nenkanhrkkaisuu}</td><td>年間払込回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getPhrkkkn phrkkkn}</td><td>保険料払込期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNkshrstartymd nkshrstartymd}</td><td>年金支払開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNknshry nknshry}</td><td>年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykjyoutai kykjyoutai}</td><td>契約状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kykjyoutai}</td></tr>
 *  <tr><td>{@link #getYuukousyoumetukbn yuukousyoumetukbn}</td><td>有効消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YuukousyoumetuKbn}</td></tr>
 *  <tr><td>{@link #getHaitoukinuketorihoukbn haitoukinuketorihoukbn}</td><td>配当金受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>{@link #getOldippanjissekip oldippanjissekip}</td><td>旧制度一般実績保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getOldippannenkanp oldippannenkanp}</td><td>旧制度一般年間保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getOldippanjissekihaitoukin oldippanjissekihaitoukin}</td><td>旧制度一般実績配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getOldippannenkanhaitoukin oldippannenkanhaitoukin}</td><td>旧制度一般年間配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getOldippanjissekisyoumeigk oldippanjissekisyoumeigk}</td><td>旧制度一般実績証明額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getOldippannenkansyoumeigk oldippannenkansyoumeigk}</td><td>旧制度一般年間証明額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewippanjissekip newippanjissekip}</td><td>新制度一般実績保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewippannenkanp newippannenkanp}</td><td>新制度一般年間保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewippanjissekihaitoukin newippanjissekihaitoukin}</td><td>新制度一般実績配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewippannenkanhaitoukin newippannenkanhaitoukin}</td><td>新制度一般年間配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewippanjissekisyoumeigk newippanjissekisyoumeigk}</td><td>新制度一般実績証明額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewippannenkansyoumeigk newippannenkansyoumeigk}</td><td>新制度一般年間証明額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewiryoujissekip newiryoujissekip}</td><td>新制度介護医療実績保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewiryounenkanp newiryounenkanp}</td><td>新制度介護医療年間保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewiryoujissekihaitoukin newiryoujissekihaitoukin}</td><td>新制度介護医療実績配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewiryounenkanhaitoukin newiryounenkanhaitoukin}</td><td>新制度介護医療年間配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewiryoujissekisyoumeigk newiryoujissekisyoumeigk}</td><td>新制度介護医療実績証明額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewiryounenkansyoumeigk newiryounenkansyoumeigk}</td><td>新制度介護医療年間証明額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewnkjissekip newnkjissekip}</td><td>新制度年金実績保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewnknenkanp newnknenkanp}</td><td>新制度年金年間保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewnkjissekihaitoukin newnkjissekihaitoukin}</td><td>新制度年金実績配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewnknenkanhaitoukin newnknenkanhaitoukin}</td><td>新制度年金年間配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewnkjissekisyoumeigk newnkjissekisyoumeigk}</td><td>新制度年金実績証明額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewnknenkansyoumeigk newnknenkansyoumeigk}</td><td>新制度年金年間証明額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKjnnkkoujyum kjnnkkoujyum}</td><td>個人年金控除有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj toiawasesosikinmkj}</td><td>問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseyno toiawaseyno}</td><td>問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr1kj toiawaseadr1kj}</td><td>問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr2kj toiawaseadr2kj}</td><td>問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr3kj toiawaseadr3kj}</td><td>問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno toiawasetelno}</td><td>問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseteluktkkanou1 toiawaseteluktkkanou1}</td><td>問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseteluktkkanou2 toiawaseteluktkkanou2}</td><td>問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj2 toiawasesosikinmkj2}</td><td>第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno2 toiawasetelno2}</td><td>第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtennmkj drtennmkj}</td><td>代理店名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHengakuumu hengakuumu}</td><td>変額保険有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNewsyoumeigkumukbn newsyoumeigkumukbn}</td><td>新制度証明額有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKoujyosyoumeisentakukbn koujyosyoumeisentakukbn}</td><td>控除証明選択区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KoujyosyoumeisentakuKbn}</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktnmkn uktnmkn}</td><td>受取人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaihkhyjkbn saihkhyjkbn}</td><td>再発行表示区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SaihkHyjKbn}</td></tr>
 *  <tr><td>{@link #getKoujyosyoumeimsgkbn koujyosyoumeimsgkbn}</td><td>控除証明メッセージ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KoujyosyoumeimsgKbn}</td></tr>
 * </table>
 * @see     IT_KoujyoSym
 * @see     PKIT_KoujyoSym
 * @see     QIT_KoujyoSym
 * @see     GenQIT_KoujyoSym
 */
@MappedSuperclass
@Table(name=GenIT_KoujyoSym.TABLE_NAME)
@IdClass(value=PKIT_KoujyoSym.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_HaitoukinuketorihouKbn", typeClass=UserType_C_HaitoukinuketorihouKbn.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_HknkknsmnKbn", typeClass=UserType_C_HknkknsmnKbn.class),
    @TypeDef(name="UserType_C_KoujyosyoumeimsgKbn", typeClass=UserType_C_KoujyosyoumeimsgKbn.class),
    @TypeDef(name="UserType_C_KoujyosyoumeisakuseisyoriKbn", typeClass=UserType_C_KoujyosyoumeisakuseisyoriKbn.class),
    @TypeDef(name="UserType_C_KoujyosyoumeisentakuKbn", typeClass=UserType_C_KoujyosyoumeisentakuKbn.class),
    @TypeDef(name="UserType_C_Kykjyoutai", typeClass=UserType_C_Kykjyoutai.class),
    @TypeDef(name="UserType_C_SaihkHyjKbn", typeClass=UserType_C_SaihkHyjKbn.class),
    @TypeDef(name="UserType_C_TekiyouseidoKbn", typeClass=UserType_C_TekiyouseidoKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YuukousyoumetuKbn", typeClass=UserType_C_YuukousyoumetuKbn.class)
})
public abstract class GenIT_KoujyoSym extends AbstractExDBEntity<IT_KoujyoSym, PKIT_KoujyoSym> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KoujyoSym";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String NENDO                    = "nendo";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String RENNO                    = "renno";
    public static final String KJSMSAKUSEISYORIKBN      = "kjsmsakuseisyorikbn";
    public static final String TEKIYOUSEIDOKBN          = "tekiyouseidokbn";
    public static final String SYOUMEIYMD               = "syoumeiymd";
    public static final String SYOUMEISTARTYM           = "syoumeistartym";
    public static final String SYOUMEIENDYM             = "syoumeiendym";
    public static final String SYOUMEIKKNTUKISUU        = "syoumeikkntukisuu";
    public static final String SYOUMEIKKNNENSUU         = "syoumeikknnensuu";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String UKTNMKJADDSAMA           = "uktnmkjaddsama";
    public static final String NENKINUKTSEIYMD          = "nenkinuktseiymd";
    public static final String HKNSYURUINMRYKKJ         = "hknsyuruinmrykkj";
    public static final String KYKYMD                   = "kykymd";
    public static final String HKNKKNSMNKBNSYU          = "hknkknsmnkbnsyu";
    public static final String HKNKKNSYU                = "hknkknsyu";
    public static final String NENKANHRKKAISUU          = "nenkanhrkkaisuu";
    public static final String PHRKKKN                  = "phrkkkn";
    public static final String NKSHRSTARTYMD            = "nkshrstartymd";
    public static final String NKNSHRY                  = "nknshry";
    public static final String KYKJYOUTAI               = "kykjyoutai";
    public static final String YUUKOUSYOUMETUKBN        = "yuukousyoumetukbn";
    public static final String HAITOUKINUKETORIHOUKBN   = "haitoukinuketorihoukbn";
    public static final String OLDIPPANJISSEKIP         = "oldippanjissekip";
    public static final String OLDIPPANNENKANP          = "oldippannenkanp";
    public static final String OLDIPPANJISSEKIHAITOUKIN = "oldippanjissekihaitoukin";
    public static final String OLDIPPANNENKANHAITOUKIN  = "oldippannenkanhaitoukin";
    public static final String OLDIPPANJISSEKISYOUMEIGK = "oldippanjissekisyoumeigk";
    public static final String OLDIPPANNENKANSYOUMEIGK  = "oldippannenkansyoumeigk";
    public static final String NEWIPPANJISSEKIP         = "newippanjissekip";
    public static final String NEWIPPANNENKANP          = "newippannenkanp";
    public static final String NEWIPPANJISSEKIHAITOUKIN = "newippanjissekihaitoukin";
    public static final String NEWIPPANNENKANHAITOUKIN  = "newippannenkanhaitoukin";
    public static final String NEWIPPANJISSEKISYOUMEIGK = "newippanjissekisyoumeigk";
    public static final String NEWIPPANNENKANSYOUMEIGK  = "newippannenkansyoumeigk";
    public static final String NEWIRYOUJISSEKIP         = "newiryoujissekip";
    public static final String NEWIRYOUNENKANP          = "newiryounenkanp";
    public static final String NEWIRYOUJISSEKIHAITOUKIN = "newiryoujissekihaitoukin";
    public static final String NEWIRYOUNENKANHAITOUKIN  = "newiryounenkanhaitoukin";
    public static final String NEWIRYOUJISSEKISYOUMEIGK = "newiryoujissekisyoumeigk";
    public static final String NEWIRYOUNENKANSYOUMEIGK  = "newiryounenkansyoumeigk";
    public static final String NEWNKJISSEKIP            = "newnkjissekip";
    public static final String NEWNKNENKANP             = "newnknenkanp";
    public static final String NEWNKJISSEKIHAITOUKIN    = "newnkjissekihaitoukin";
    public static final String NEWNKNENKANHAITOUKIN     = "newnknenkanhaitoukin";
    public static final String NEWNKJISSEKISYOUMEIGK    = "newnkjissekisyoumeigk";
    public static final String NEWNKNENKANSYOUMEIGK     = "newnknenkansyoumeigk";
    public static final String KJNNKKOUJYUM             = "kjnnkkoujyum";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TOIAWASESOSIKINMKJ       = "toiawasesosikinmkj";
    public static final String TOIAWASEYNO              = "toiawaseyno";
    public static final String TOIAWASEADR1KJ           = "toiawaseadr1kj";
    public static final String TOIAWASEADR2KJ           = "toiawaseadr2kj";
    public static final String TOIAWASEADR3KJ           = "toiawaseadr3kj";
    public static final String TOIAWASETELNO            = "toiawasetelno";
    public static final String TOIAWASETELUKTKKANOU1    = "toiawaseteluktkkanou1";
    public static final String TOIAWASETELUKTKKANOU2    = "toiawaseteluktkkanou2";
    public static final String TOIAWASESOSIKINMKJ2      = "toiawasesosikinmkj2";
    public static final String TOIAWASETELNO2           = "toiawasetelno2";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String DRTENCD                  = "drtencd";
    public static final String DRTENNMKJ                = "drtennmkj";
    public static final String HENGAKUUMU               = "hengakuumu";
    public static final String NEWSYOUMEIGKUMUKBN       = "newsyoumeigkumukbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String KOUJYOSYOUMEISENTAKUKBN  = "koujyosyoumeisentakukbn";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String UKTNMKN                  = "uktnmkn";
    public static final String SAIHKHYJKBN              = "saihkhyjkbn";
    public static final String KOUJYOSYOUMEIMSGKBN      = "koujyosyoumeimsgkbn";

    private final PKIT_KoujyoSym primaryKey;

    public GenIT_KoujyoSym() {
        primaryKey = new PKIT_KoujyoSym();
    }

    public GenIT_KoujyoSym(
        String pKbnkey,
        String pSyono,
        String pNendo,
        BizDate pTyouhyouymd,
        Integer pRenno
    ) {
        primaryKey = new PKIT_KoujyoSym(
            pKbnkey,
            pSyono,
            pNendo,
            pTyouhyouymd,
            pRenno
        );
    }

    @Transient
    @Override
    public PKIT_KoujyoSym getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KoujyoSym> getMetaClass() {
        return QIT_KoujyoSym.class;
    }

    @Id
    @Column(name=GenIT_KoujyoSym.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KoujyoSym.SYONO)
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
    @Column(name=GenIT_KoujyoSym.NENDO)
    public String getNendo() {
        return getPrimaryKey().getNendo();
    }

    public void setNendo(String pNendo) {
        getPrimaryKey().setNendo(pNendo);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_KoujyoSym.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return getPrimaryKey().getTyouhyouymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        getPrimaryKey().setTyouhyouymd(pTyouhyouymd);
    }

    @Id
    @Column(name=GenIT_KoujyoSym.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private C_KoujyosyoumeisakuseisyoriKbn kjsmsakuseisyorikbn;

    @Type(type="UserType_C_KoujyosyoumeisakuseisyoriKbn")
    @Column(name=GenIT_KoujyoSym.KJSMSAKUSEISYORIKBN)
    public C_KoujyosyoumeisakuseisyoriKbn getKjsmsakuseisyorikbn() {
        return kjsmsakuseisyorikbn;
    }

    public void setKjsmsakuseisyorikbn(C_KoujyosyoumeisakuseisyoriKbn pKjsmsakuseisyorikbn) {
        kjsmsakuseisyorikbn = pKjsmsakuseisyorikbn;
    }

    private C_TekiyouseidoKbn tekiyouseidokbn;

    @Type(type="UserType_C_TekiyouseidoKbn")
    @Column(name=GenIT_KoujyoSym.TEKIYOUSEIDOKBN)
    public C_TekiyouseidoKbn getTekiyouseidokbn() {
        return tekiyouseidokbn;
    }

    public void setTekiyouseidokbn(C_TekiyouseidoKbn pTekiyouseidokbn) {
        tekiyouseidokbn = pTekiyouseidokbn;
    }

    private String syoumeiymd;

    @Column(name=GenIT_KoujyoSym.SYOUMEIYMD)
    public String getSyoumeiymd() {
        return syoumeiymd;
    }

    public void setSyoumeiymd(String pSyoumeiymd) {
        syoumeiymd = pSyoumeiymd;
    }

    private BizDateYM syoumeistartym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KoujyoSym.SYOUMEISTARTYM)
    public BizDateYM getSyoumeistartym() {
        return syoumeistartym;
    }

    public void setSyoumeistartym(BizDateYM pSyoumeistartym) {
        syoumeistartym = pSyoumeistartym;
    }

    private BizDateYM syoumeiendym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KoujyoSym.SYOUMEIENDYM)
    public BizDateYM getSyoumeiendym() {
        return syoumeiendym;
    }

    public void setSyoumeiendym(BizDateYM pSyoumeiendym) {
        syoumeiendym = pSyoumeiendym;
    }

    private Integer syoumeikkntukisuu;

    @Column(name=GenIT_KoujyoSym.SYOUMEIKKNTUKISUU)
    public Integer getSyoumeikkntukisuu() {
        return syoumeikkntukisuu;
    }

    public void setSyoumeikkntukisuu(Integer pSyoumeikkntukisuu) {
        syoumeikkntukisuu = pSyoumeikkntukisuu;
    }

    private Integer syoumeikknnensuu;

    @Column(name=GenIT_KoujyoSym.SYOUMEIKKNNENSUU)
    public Integer getSyoumeikknnensuu() {
        return syoumeikknnensuu;
    }

    public void setSyoumeikknnensuu(Integer pSyoumeikknnensuu) {
        syoumeikknnensuu = pSyoumeikknnensuu;
    }

    private String kyknmkj;

    @Column(name=GenIT_KoujyoSym.KYKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    private String uktnmkjaddsama;

    @Column(name=GenIT_KoujyoSym.UKTNMKJADDSAMA)
    @MaxLength(max=17)
    @MultiByteStrings
    @InvalidCharacter
    public String getUktnmkjaddsama() {
        return uktnmkjaddsama;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktnmkjaddsama(String pUktnmkjaddsama) {
        uktnmkjaddsama = pUktnmkjaddsama;
    }

    private BizDate nenkinuktseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KoujyoSym.NENKINUKTSEIYMD)
    @ValidDate
    public BizDate getNenkinuktseiymd() {
        return nenkinuktseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNenkinuktseiymd(BizDate pNenkinuktseiymd) {
        nenkinuktseiymd = pNenkinuktseiymd;
    }

    private String hknsyuruinmrykkj;

    @Column(name=GenIT_KoujyoSym.HKNSYURUINMRYKKJ)
    public String getHknsyuruinmrykkj() {
        return hknsyuruinmrykkj;
    }

    public void setHknsyuruinmrykkj(String pHknsyuruinmrykkj) {
        hknsyuruinmrykkj = pHknsyuruinmrykkj;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KoujyoSym.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_HknkknsmnKbn hknkknsmnkbnsyu;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenIT_KoujyoSym.HKNKKNSMNKBNSYU)
    public C_HknkknsmnKbn getHknkknsmnkbnsyu() {
        return hknkknsmnkbnsyu;
    }

    public void setHknkknsmnkbnsyu(C_HknkknsmnKbn pHknkknsmnkbnsyu) {
        hknkknsmnkbnsyu = pHknkknsmnkbnsyu;
    }

    private BizNumber hknkknsyu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KoujyoSym.HKNKKNSYU)
    public BizNumber getHknkknsyu() {
        return hknkknsyu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknkknsyu(BizNumber pHknkknsyu) {
        hknkknsyu = pHknkknsyu;
    }

    private Integer nenkanhrkkaisuu;

    @Column(name=GenIT_KoujyoSym.NENKANHRKKAISUU)
    public Integer getNenkanhrkkaisuu() {
        return nenkanhrkkaisuu;
    }

    public void setNenkanhrkkaisuu(Integer pNenkanhrkkaisuu) {
        nenkanhrkkaisuu = pNenkanhrkkaisuu;
    }

    private Integer phrkkkn;

    @Column(name=GenIT_KoujyoSym.PHRKKKN)
    public Integer getPhrkkkn() {
        return phrkkkn;
    }

    public void setPhrkkkn(Integer pPhrkkkn) {
        phrkkkn = pPhrkkkn;
    }

    private BizDate nkshrstartymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KoujyoSym.NKSHRSTARTYMD)
    public BizDate getNkshrstartymd() {
        return nkshrstartymd;
    }

    @Trim("both")
    public void setNkshrstartymd(BizDate pNkshrstartymd) {
        nkshrstartymd = pNkshrstartymd;
    }

    private String nknshry;

    @Column(name=GenIT_KoujyoSym.NKNSHRY)
    public String getNknshry() {
        return nknshry;
    }

    public void setNknshry(String pNknshry) {
        nknshry = pNknshry;
    }

    private C_Kykjyoutai kykjyoutai;

    @Type(type="UserType_C_Kykjyoutai")
    @Column(name=GenIT_KoujyoSym.KYKJYOUTAI)
    public C_Kykjyoutai getKykjyoutai() {
        return kykjyoutai;
    }

    public void setKykjyoutai(C_Kykjyoutai pKykjyoutai) {
        kykjyoutai = pKykjyoutai;
    }

    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    @Type(type="UserType_C_YuukousyoumetuKbn")
    @Column(name=GenIT_KoujyoSym.YUUKOUSYOUMETUKBN)
    public C_YuukousyoumetuKbn getYuukousyoumetukbn() {
        return yuukousyoumetukbn;
    }

    public void setYuukousyoumetukbn(C_YuukousyoumetuKbn pYuukousyoumetukbn) {
        yuukousyoumetukbn = pYuukousyoumetukbn;
    }

    private C_HaitoukinuketorihouKbn haitoukinuketorihoukbn;

    @Type(type="UserType_C_HaitoukinuketorihouKbn")
    @Column(name=GenIT_KoujyoSym.HAITOUKINUKETORIHOUKBN)
    public C_HaitoukinuketorihouKbn getHaitoukinuketorihoukbn() {
        return haitoukinuketorihoukbn;
    }

    public void setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn) {
        haitoukinuketorihoukbn = pHaitoukinuketorihoukbn;
    }

    private BizCurrency oldippanjissekip;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getOldippanjissekip() {
        return oldippanjissekip;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOldippanjissekip(BizCurrency pOldippanjissekip) {
        oldippanjissekip = pOldippanjissekip;
        oldippanjissekipValue = null;
        oldippanjissekipType  = null;
    }

    transient private BigDecimal oldippanjissekipValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=OLDIPPANJISSEKIP, nullable=true)
    protected BigDecimal getOldippanjissekipValue() {
        if (oldippanjissekipValue == null && oldippanjissekip != null) {
            if (oldippanjissekip.isOptional()) return null;
            return oldippanjissekip.absolute();
        }
        return oldippanjissekipValue;
    }

    protected void setOldippanjissekipValue(BigDecimal value) {
        oldippanjissekipValue = value;
        oldippanjissekip = Optional.fromNullable(toCurrencyType(oldippanjissekipType))
            .transform(bizCurrencyTransformer(getOldippanjissekipValue()))
            .orNull();
    }

    transient private String oldippanjissekipType = null;

    @Column(name=OLDIPPANJISSEKIP + "$", nullable=true)
    protected String getOldippanjissekipType() {
        if (oldippanjissekipType == null && oldippanjissekip != null) return oldippanjissekip.getType().toString();
        if (oldippanjissekipType == null && getOldippanjissekipValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'oldippanjissekip$' should not be NULL."));
        }
        return oldippanjissekipType;
    }

    protected void setOldippanjissekipType(String type) {
        oldippanjissekipType = type;
        oldippanjissekip = Optional.fromNullable(toCurrencyType(oldippanjissekipType))
            .transform(bizCurrencyTransformer(getOldippanjissekipValue()))
            .orNull();
    }

    private BizCurrency oldippannenkanp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getOldippannenkanp() {
        return oldippannenkanp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOldippannenkanp(BizCurrency pOldippannenkanp) {
        oldippannenkanp = pOldippannenkanp;
        oldippannenkanpValue = null;
        oldippannenkanpType  = null;
    }

    transient private BigDecimal oldippannenkanpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=OLDIPPANNENKANP, nullable=true)
    protected BigDecimal getOldippannenkanpValue() {
        if (oldippannenkanpValue == null && oldippannenkanp != null) {
            if (oldippannenkanp.isOptional()) return null;
            return oldippannenkanp.absolute();
        }
        return oldippannenkanpValue;
    }

    protected void setOldippannenkanpValue(BigDecimal value) {
        oldippannenkanpValue = value;
        oldippannenkanp = Optional.fromNullable(toCurrencyType(oldippannenkanpType))
            .transform(bizCurrencyTransformer(getOldippannenkanpValue()))
            .orNull();
    }

    transient private String oldippannenkanpType = null;

    @Column(name=OLDIPPANNENKANP + "$", nullable=true)
    protected String getOldippannenkanpType() {
        if (oldippannenkanpType == null && oldippannenkanp != null) return oldippannenkanp.getType().toString();
        if (oldippannenkanpType == null && getOldippannenkanpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'oldippannenkanp$' should not be NULL."));
        }
        return oldippannenkanpType;
    }

    protected void setOldippannenkanpType(String type) {
        oldippannenkanpType = type;
        oldippannenkanp = Optional.fromNullable(toCurrencyType(oldippannenkanpType))
            .transform(bizCurrencyTransformer(getOldippannenkanpValue()))
            .orNull();
    }

    private BizCurrency oldippanjissekihaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getOldippanjissekihaitoukin() {
        return oldippanjissekihaitoukin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOldippanjissekihaitoukin(BizCurrency pOldippanjissekihaitoukin) {
        oldippanjissekihaitoukin = pOldippanjissekihaitoukin;
        oldippanjissekihaitoukinValue = null;
        oldippanjissekihaitoukinType  = null;
    }

    transient private BigDecimal oldippanjissekihaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=OLDIPPANJISSEKIHAITOUKIN, nullable=true)
    protected BigDecimal getOldippanjissekihaitoukinValue() {
        if (oldippanjissekihaitoukinValue == null && oldippanjissekihaitoukin != null) {
            if (oldippanjissekihaitoukin.isOptional()) return null;
            return oldippanjissekihaitoukin.absolute();
        }
        return oldippanjissekihaitoukinValue;
    }

    protected void setOldippanjissekihaitoukinValue(BigDecimal value) {
        oldippanjissekihaitoukinValue = value;
        oldippanjissekihaitoukin = Optional.fromNullable(toCurrencyType(oldippanjissekihaitoukinType))
            .transform(bizCurrencyTransformer(getOldippanjissekihaitoukinValue()))
            .orNull();
    }

    transient private String oldippanjissekihaitoukinType = null;

    @Column(name=OLDIPPANJISSEKIHAITOUKIN + "$", nullable=true)
    protected String getOldippanjissekihaitoukinType() {
        if (oldippanjissekihaitoukinType == null && oldippanjissekihaitoukin != null) return oldippanjissekihaitoukin.getType().toString();
        if (oldippanjissekihaitoukinType == null && getOldippanjissekihaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'oldippanjissekihaitoukin$' should not be NULL."));
        }
        return oldippanjissekihaitoukinType;
    }

    protected void setOldippanjissekihaitoukinType(String type) {
        oldippanjissekihaitoukinType = type;
        oldippanjissekihaitoukin = Optional.fromNullable(toCurrencyType(oldippanjissekihaitoukinType))
            .transform(bizCurrencyTransformer(getOldippanjissekihaitoukinValue()))
            .orNull();
    }

    private BizCurrency oldippannenkanhaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getOldippannenkanhaitoukin() {
        return oldippannenkanhaitoukin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOldippannenkanhaitoukin(BizCurrency pOldippannenkanhaitoukin) {
        oldippannenkanhaitoukin = pOldippannenkanhaitoukin;
        oldippannenkanhaitoukinValue = null;
        oldippannenkanhaitoukinType  = null;
    }

    transient private BigDecimal oldippannenkanhaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=OLDIPPANNENKANHAITOUKIN, nullable=true)
    protected BigDecimal getOldippannenkanhaitoukinValue() {
        if (oldippannenkanhaitoukinValue == null && oldippannenkanhaitoukin != null) {
            if (oldippannenkanhaitoukin.isOptional()) return null;
            return oldippannenkanhaitoukin.absolute();
        }
        return oldippannenkanhaitoukinValue;
    }

    protected void setOldippannenkanhaitoukinValue(BigDecimal value) {
        oldippannenkanhaitoukinValue = value;
        oldippannenkanhaitoukin = Optional.fromNullable(toCurrencyType(oldippannenkanhaitoukinType))
            .transform(bizCurrencyTransformer(getOldippannenkanhaitoukinValue()))
            .orNull();
    }

    transient private String oldippannenkanhaitoukinType = null;

    @Column(name=OLDIPPANNENKANHAITOUKIN + "$", nullable=true)
    protected String getOldippannenkanhaitoukinType() {
        if (oldippannenkanhaitoukinType == null && oldippannenkanhaitoukin != null) return oldippannenkanhaitoukin.getType().toString();
        if (oldippannenkanhaitoukinType == null && getOldippannenkanhaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'oldippannenkanhaitoukin$' should not be NULL."));
        }
        return oldippannenkanhaitoukinType;
    }

    protected void setOldippannenkanhaitoukinType(String type) {
        oldippannenkanhaitoukinType = type;
        oldippannenkanhaitoukin = Optional.fromNullable(toCurrencyType(oldippannenkanhaitoukinType))
            .transform(bizCurrencyTransformer(getOldippannenkanhaitoukinValue()))
            .orNull();
    }

    private BizCurrency oldippanjissekisyoumeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getOldippanjissekisyoumeigk() {
        return oldippanjissekisyoumeigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOldippanjissekisyoumeigk(BizCurrency pOldippanjissekisyoumeigk) {
        oldippanjissekisyoumeigk = pOldippanjissekisyoumeigk;
        oldippanjissekisyoumeigkValue = null;
        oldippanjissekisyoumeigkType  = null;
    }

    transient private BigDecimal oldippanjissekisyoumeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=OLDIPPANJISSEKISYOUMEIGK, nullable=true)
    protected BigDecimal getOldippanjissekisyoumeigkValue() {
        if (oldippanjissekisyoumeigkValue == null && oldippanjissekisyoumeigk != null) {
            if (oldippanjissekisyoumeigk.isOptional()) return null;
            return oldippanjissekisyoumeigk.absolute();
        }
        return oldippanjissekisyoumeigkValue;
    }

    protected void setOldippanjissekisyoumeigkValue(BigDecimal value) {
        oldippanjissekisyoumeigkValue = value;
        oldippanjissekisyoumeigk = Optional.fromNullable(toCurrencyType(oldippanjissekisyoumeigkType))
            .transform(bizCurrencyTransformer(getOldippanjissekisyoumeigkValue()))
            .orNull();
    }

    transient private String oldippanjissekisyoumeigkType = null;

    @Column(name=OLDIPPANJISSEKISYOUMEIGK + "$", nullable=true)
    protected String getOldippanjissekisyoumeigkType() {
        if (oldippanjissekisyoumeigkType == null && oldippanjissekisyoumeigk != null) return oldippanjissekisyoumeigk.getType().toString();
        if (oldippanjissekisyoumeigkType == null && getOldippanjissekisyoumeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'oldippanjissekisyoumeigk$' should not be NULL."));
        }
        return oldippanjissekisyoumeigkType;
    }

    protected void setOldippanjissekisyoumeigkType(String type) {
        oldippanjissekisyoumeigkType = type;
        oldippanjissekisyoumeigk = Optional.fromNullable(toCurrencyType(oldippanjissekisyoumeigkType))
            .transform(bizCurrencyTransformer(getOldippanjissekisyoumeigkValue()))
            .orNull();
    }

    private BizCurrency oldippannenkansyoumeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getOldippannenkansyoumeigk() {
        return oldippannenkansyoumeigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOldippannenkansyoumeigk(BizCurrency pOldippannenkansyoumeigk) {
        oldippannenkansyoumeigk = pOldippannenkansyoumeigk;
        oldippannenkansyoumeigkValue = null;
        oldippannenkansyoumeigkType  = null;
    }

    transient private BigDecimal oldippannenkansyoumeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=OLDIPPANNENKANSYOUMEIGK, nullable=true)
    protected BigDecimal getOldippannenkansyoumeigkValue() {
        if (oldippannenkansyoumeigkValue == null && oldippannenkansyoumeigk != null) {
            if (oldippannenkansyoumeigk.isOptional()) return null;
            return oldippannenkansyoumeigk.absolute();
        }
        return oldippannenkansyoumeigkValue;
    }

    protected void setOldippannenkansyoumeigkValue(BigDecimal value) {
        oldippannenkansyoumeigkValue = value;
        oldippannenkansyoumeigk = Optional.fromNullable(toCurrencyType(oldippannenkansyoumeigkType))
            .transform(bizCurrencyTransformer(getOldippannenkansyoumeigkValue()))
            .orNull();
    }

    transient private String oldippannenkansyoumeigkType = null;

    @Column(name=OLDIPPANNENKANSYOUMEIGK + "$", nullable=true)
    protected String getOldippannenkansyoumeigkType() {
        if (oldippannenkansyoumeigkType == null && oldippannenkansyoumeigk != null) return oldippannenkansyoumeigk.getType().toString();
        if (oldippannenkansyoumeigkType == null && getOldippannenkansyoumeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'oldippannenkansyoumeigk$' should not be NULL."));
        }
        return oldippannenkansyoumeigkType;
    }

    protected void setOldippannenkansyoumeigkType(String type) {
        oldippannenkansyoumeigkType = type;
        oldippannenkansyoumeigk = Optional.fromNullable(toCurrencyType(oldippannenkansyoumeigkType))
            .transform(bizCurrencyTransformer(getOldippannenkansyoumeigkValue()))
            .orNull();
    }

    private BizCurrency newippanjissekip;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewippanjissekip() {
        return newippanjissekip;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewippanjissekip(BizCurrency pNewippanjissekip) {
        newippanjissekip = pNewippanjissekip;
        newippanjissekipValue = null;
        newippanjissekipType  = null;
    }

    transient private BigDecimal newippanjissekipValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIPPANJISSEKIP, nullable=true)
    protected BigDecimal getNewippanjissekipValue() {
        if (newippanjissekipValue == null && newippanjissekip != null) {
            if (newippanjissekip.isOptional()) return null;
            return newippanjissekip.absolute();
        }
        return newippanjissekipValue;
    }

    protected void setNewippanjissekipValue(BigDecimal value) {
        newippanjissekipValue = value;
        newippanjissekip = Optional.fromNullable(toCurrencyType(newippanjissekipType))
            .transform(bizCurrencyTransformer(getNewippanjissekipValue()))
            .orNull();
    }

    transient private String newippanjissekipType = null;

    @Column(name=NEWIPPANJISSEKIP + "$", nullable=true)
    protected String getNewippanjissekipType() {
        if (newippanjissekipType == null && newippanjissekip != null) return newippanjissekip.getType().toString();
        if (newippanjissekipType == null && getNewippanjissekipValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newippanjissekip$' should not be NULL."));
        }
        return newippanjissekipType;
    }

    protected void setNewippanjissekipType(String type) {
        newippanjissekipType = type;
        newippanjissekip = Optional.fromNullable(toCurrencyType(newippanjissekipType))
            .transform(bizCurrencyTransformer(getNewippanjissekipValue()))
            .orNull();
    }

    private BizCurrency newippannenkanp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewippannenkanp() {
        return newippannenkanp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewippannenkanp(BizCurrency pNewippannenkanp) {
        newippannenkanp = pNewippannenkanp;
        newippannenkanpValue = null;
        newippannenkanpType  = null;
    }

    transient private BigDecimal newippannenkanpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIPPANNENKANP, nullable=true)
    protected BigDecimal getNewippannenkanpValue() {
        if (newippannenkanpValue == null && newippannenkanp != null) {
            if (newippannenkanp.isOptional()) return null;
            return newippannenkanp.absolute();
        }
        return newippannenkanpValue;
    }

    protected void setNewippannenkanpValue(BigDecimal value) {
        newippannenkanpValue = value;
        newippannenkanp = Optional.fromNullable(toCurrencyType(newippannenkanpType))
            .transform(bizCurrencyTransformer(getNewippannenkanpValue()))
            .orNull();
    }

    transient private String newippannenkanpType = null;

    @Column(name=NEWIPPANNENKANP + "$", nullable=true)
    protected String getNewippannenkanpType() {
        if (newippannenkanpType == null && newippannenkanp != null) return newippannenkanp.getType().toString();
        if (newippannenkanpType == null && getNewippannenkanpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newippannenkanp$' should not be NULL."));
        }
        return newippannenkanpType;
    }

    protected void setNewippannenkanpType(String type) {
        newippannenkanpType = type;
        newippannenkanp = Optional.fromNullable(toCurrencyType(newippannenkanpType))
            .transform(bizCurrencyTransformer(getNewippannenkanpValue()))
            .orNull();
    }

    private BizCurrency newippanjissekihaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewippanjissekihaitoukin() {
        return newippanjissekihaitoukin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewippanjissekihaitoukin(BizCurrency pNewippanjissekihaitoukin) {
        newippanjissekihaitoukin = pNewippanjissekihaitoukin;
        newippanjissekihaitoukinValue = null;
        newippanjissekihaitoukinType  = null;
    }

    transient private BigDecimal newippanjissekihaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIPPANJISSEKIHAITOUKIN, nullable=true)
    protected BigDecimal getNewippanjissekihaitoukinValue() {
        if (newippanjissekihaitoukinValue == null && newippanjissekihaitoukin != null) {
            if (newippanjissekihaitoukin.isOptional()) return null;
            return newippanjissekihaitoukin.absolute();
        }
        return newippanjissekihaitoukinValue;
    }

    protected void setNewippanjissekihaitoukinValue(BigDecimal value) {
        newippanjissekihaitoukinValue = value;
        newippanjissekihaitoukin = Optional.fromNullable(toCurrencyType(newippanjissekihaitoukinType))
            .transform(bizCurrencyTransformer(getNewippanjissekihaitoukinValue()))
            .orNull();
    }

    transient private String newippanjissekihaitoukinType = null;

    @Column(name=NEWIPPANJISSEKIHAITOUKIN + "$", nullable=true)
    protected String getNewippanjissekihaitoukinType() {
        if (newippanjissekihaitoukinType == null && newippanjissekihaitoukin != null) return newippanjissekihaitoukin.getType().toString();
        if (newippanjissekihaitoukinType == null && getNewippanjissekihaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newippanjissekihaitoukin$' should not be NULL."));
        }
        return newippanjissekihaitoukinType;
    }

    protected void setNewippanjissekihaitoukinType(String type) {
        newippanjissekihaitoukinType = type;
        newippanjissekihaitoukin = Optional.fromNullable(toCurrencyType(newippanjissekihaitoukinType))
            .transform(bizCurrencyTransformer(getNewippanjissekihaitoukinValue()))
            .orNull();
    }

    private BizCurrency newippannenkanhaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewippannenkanhaitoukin() {
        return newippannenkanhaitoukin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewippannenkanhaitoukin(BizCurrency pNewippannenkanhaitoukin) {
        newippannenkanhaitoukin = pNewippannenkanhaitoukin;
        newippannenkanhaitoukinValue = null;
        newippannenkanhaitoukinType  = null;
    }

    transient private BigDecimal newippannenkanhaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIPPANNENKANHAITOUKIN, nullable=true)
    protected BigDecimal getNewippannenkanhaitoukinValue() {
        if (newippannenkanhaitoukinValue == null && newippannenkanhaitoukin != null) {
            if (newippannenkanhaitoukin.isOptional()) return null;
            return newippannenkanhaitoukin.absolute();
        }
        return newippannenkanhaitoukinValue;
    }

    protected void setNewippannenkanhaitoukinValue(BigDecimal value) {
        newippannenkanhaitoukinValue = value;
        newippannenkanhaitoukin = Optional.fromNullable(toCurrencyType(newippannenkanhaitoukinType))
            .transform(bizCurrencyTransformer(getNewippannenkanhaitoukinValue()))
            .orNull();
    }

    transient private String newippannenkanhaitoukinType = null;

    @Column(name=NEWIPPANNENKANHAITOUKIN + "$", nullable=true)
    protected String getNewippannenkanhaitoukinType() {
        if (newippannenkanhaitoukinType == null && newippannenkanhaitoukin != null) return newippannenkanhaitoukin.getType().toString();
        if (newippannenkanhaitoukinType == null && getNewippannenkanhaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newippannenkanhaitoukin$' should not be NULL."));
        }
        return newippannenkanhaitoukinType;
    }

    protected void setNewippannenkanhaitoukinType(String type) {
        newippannenkanhaitoukinType = type;
        newippannenkanhaitoukin = Optional.fromNullable(toCurrencyType(newippannenkanhaitoukinType))
            .transform(bizCurrencyTransformer(getNewippannenkanhaitoukinValue()))
            .orNull();
    }

    private BizCurrency newippanjissekisyoumeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewippanjissekisyoumeigk() {
        return newippanjissekisyoumeigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewippanjissekisyoumeigk(BizCurrency pNewippanjissekisyoumeigk) {
        newippanjissekisyoumeigk = pNewippanjissekisyoumeigk;
        newippanjissekisyoumeigkValue = null;
        newippanjissekisyoumeigkType  = null;
    }

    transient private BigDecimal newippanjissekisyoumeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIPPANJISSEKISYOUMEIGK, nullable=true)
    protected BigDecimal getNewippanjissekisyoumeigkValue() {
        if (newippanjissekisyoumeigkValue == null && newippanjissekisyoumeigk != null) {
            if (newippanjissekisyoumeigk.isOptional()) return null;
            return newippanjissekisyoumeigk.absolute();
        }
        return newippanjissekisyoumeigkValue;
    }

    protected void setNewippanjissekisyoumeigkValue(BigDecimal value) {
        newippanjissekisyoumeigkValue = value;
        newippanjissekisyoumeigk = Optional.fromNullable(toCurrencyType(newippanjissekisyoumeigkType))
            .transform(bizCurrencyTransformer(getNewippanjissekisyoumeigkValue()))
            .orNull();
    }

    transient private String newippanjissekisyoumeigkType = null;

    @Column(name=NEWIPPANJISSEKISYOUMEIGK + "$", nullable=true)
    protected String getNewippanjissekisyoumeigkType() {
        if (newippanjissekisyoumeigkType == null && newippanjissekisyoumeigk != null) return newippanjissekisyoumeigk.getType().toString();
        if (newippanjissekisyoumeigkType == null && getNewippanjissekisyoumeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newippanjissekisyoumeigk$' should not be NULL."));
        }
        return newippanjissekisyoumeigkType;
    }

    protected void setNewippanjissekisyoumeigkType(String type) {
        newippanjissekisyoumeigkType = type;
        newippanjissekisyoumeigk = Optional.fromNullable(toCurrencyType(newippanjissekisyoumeigkType))
            .transform(bizCurrencyTransformer(getNewippanjissekisyoumeigkValue()))
            .orNull();
    }

    private BizCurrency newippannenkansyoumeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewippannenkansyoumeigk() {
        return newippannenkansyoumeigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewippannenkansyoumeigk(BizCurrency pNewippannenkansyoumeigk) {
        newippannenkansyoumeigk = pNewippannenkansyoumeigk;
        newippannenkansyoumeigkValue = null;
        newippannenkansyoumeigkType  = null;
    }

    transient private BigDecimal newippannenkansyoumeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIPPANNENKANSYOUMEIGK, nullable=true)
    protected BigDecimal getNewippannenkansyoumeigkValue() {
        if (newippannenkansyoumeigkValue == null && newippannenkansyoumeigk != null) {
            if (newippannenkansyoumeigk.isOptional()) return null;
            return newippannenkansyoumeigk.absolute();
        }
        return newippannenkansyoumeigkValue;
    }

    protected void setNewippannenkansyoumeigkValue(BigDecimal value) {
        newippannenkansyoumeigkValue = value;
        newippannenkansyoumeigk = Optional.fromNullable(toCurrencyType(newippannenkansyoumeigkType))
            .transform(bizCurrencyTransformer(getNewippannenkansyoumeigkValue()))
            .orNull();
    }

    transient private String newippannenkansyoumeigkType = null;

    @Column(name=NEWIPPANNENKANSYOUMEIGK + "$", nullable=true)
    protected String getNewippannenkansyoumeigkType() {
        if (newippannenkansyoumeigkType == null && newippannenkansyoumeigk != null) return newippannenkansyoumeigk.getType().toString();
        if (newippannenkansyoumeigkType == null && getNewippannenkansyoumeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newippannenkansyoumeigk$' should not be NULL."));
        }
        return newippannenkansyoumeigkType;
    }

    protected void setNewippannenkansyoumeigkType(String type) {
        newippannenkansyoumeigkType = type;
        newippannenkansyoumeigk = Optional.fromNullable(toCurrencyType(newippannenkansyoumeigkType))
            .transform(bizCurrencyTransformer(getNewippannenkansyoumeigkValue()))
            .orNull();
    }

    private BizCurrency newiryoujissekip;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewiryoujissekip() {
        return newiryoujissekip;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewiryoujissekip(BizCurrency pNewiryoujissekip) {
        newiryoujissekip = pNewiryoujissekip;
        newiryoujissekipValue = null;
        newiryoujissekipType  = null;
    }

    transient private BigDecimal newiryoujissekipValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIRYOUJISSEKIP, nullable=true)
    protected BigDecimal getNewiryoujissekipValue() {
        if (newiryoujissekipValue == null && newiryoujissekip != null) {
            if (newiryoujissekip.isOptional()) return null;
            return newiryoujissekip.absolute();
        }
        return newiryoujissekipValue;
    }

    protected void setNewiryoujissekipValue(BigDecimal value) {
        newiryoujissekipValue = value;
        newiryoujissekip = Optional.fromNullable(toCurrencyType(newiryoujissekipType))
            .transform(bizCurrencyTransformer(getNewiryoujissekipValue()))
            .orNull();
    }

    transient private String newiryoujissekipType = null;

    @Column(name=NEWIRYOUJISSEKIP + "$", nullable=true)
    protected String getNewiryoujissekipType() {
        if (newiryoujissekipType == null && newiryoujissekip != null) return newiryoujissekip.getType().toString();
        if (newiryoujissekipType == null && getNewiryoujissekipValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newiryoujissekip$' should not be NULL."));
        }
        return newiryoujissekipType;
    }

    protected void setNewiryoujissekipType(String type) {
        newiryoujissekipType = type;
        newiryoujissekip = Optional.fromNullable(toCurrencyType(newiryoujissekipType))
            .transform(bizCurrencyTransformer(getNewiryoujissekipValue()))
            .orNull();
    }

    private BizCurrency newiryounenkanp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewiryounenkanp() {
        return newiryounenkanp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewiryounenkanp(BizCurrency pNewiryounenkanp) {
        newiryounenkanp = pNewiryounenkanp;
        newiryounenkanpValue = null;
        newiryounenkanpType  = null;
    }

    transient private BigDecimal newiryounenkanpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIRYOUNENKANP, nullable=true)
    protected BigDecimal getNewiryounenkanpValue() {
        if (newiryounenkanpValue == null && newiryounenkanp != null) {
            if (newiryounenkanp.isOptional()) return null;
            return newiryounenkanp.absolute();
        }
        return newiryounenkanpValue;
    }

    protected void setNewiryounenkanpValue(BigDecimal value) {
        newiryounenkanpValue = value;
        newiryounenkanp = Optional.fromNullable(toCurrencyType(newiryounenkanpType))
            .transform(bizCurrencyTransformer(getNewiryounenkanpValue()))
            .orNull();
    }

    transient private String newiryounenkanpType = null;

    @Column(name=NEWIRYOUNENKANP + "$", nullable=true)
    protected String getNewiryounenkanpType() {
        if (newiryounenkanpType == null && newiryounenkanp != null) return newiryounenkanp.getType().toString();
        if (newiryounenkanpType == null && getNewiryounenkanpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newiryounenkanp$' should not be NULL."));
        }
        return newiryounenkanpType;
    }

    protected void setNewiryounenkanpType(String type) {
        newiryounenkanpType = type;
        newiryounenkanp = Optional.fromNullable(toCurrencyType(newiryounenkanpType))
            .transform(bizCurrencyTransformer(getNewiryounenkanpValue()))
            .orNull();
    }

    private BizCurrency newiryoujissekihaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewiryoujissekihaitoukin() {
        return newiryoujissekihaitoukin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewiryoujissekihaitoukin(BizCurrency pNewiryoujissekihaitoukin) {
        newiryoujissekihaitoukin = pNewiryoujissekihaitoukin;
        newiryoujissekihaitoukinValue = null;
        newiryoujissekihaitoukinType  = null;
    }

    transient private BigDecimal newiryoujissekihaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIRYOUJISSEKIHAITOUKIN, nullable=true)
    protected BigDecimal getNewiryoujissekihaitoukinValue() {
        if (newiryoujissekihaitoukinValue == null && newiryoujissekihaitoukin != null) {
            if (newiryoujissekihaitoukin.isOptional()) return null;
            return newiryoujissekihaitoukin.absolute();
        }
        return newiryoujissekihaitoukinValue;
    }

    protected void setNewiryoujissekihaitoukinValue(BigDecimal value) {
        newiryoujissekihaitoukinValue = value;
        newiryoujissekihaitoukin = Optional.fromNullable(toCurrencyType(newiryoujissekihaitoukinType))
            .transform(bizCurrencyTransformer(getNewiryoujissekihaitoukinValue()))
            .orNull();
    }

    transient private String newiryoujissekihaitoukinType = null;

    @Column(name=NEWIRYOUJISSEKIHAITOUKIN + "$", nullable=true)
    protected String getNewiryoujissekihaitoukinType() {
        if (newiryoujissekihaitoukinType == null && newiryoujissekihaitoukin != null) return newiryoujissekihaitoukin.getType().toString();
        if (newiryoujissekihaitoukinType == null && getNewiryoujissekihaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newiryoujissekihaitoukin$' should not be NULL."));
        }
        return newiryoujissekihaitoukinType;
    }

    protected void setNewiryoujissekihaitoukinType(String type) {
        newiryoujissekihaitoukinType = type;
        newiryoujissekihaitoukin = Optional.fromNullable(toCurrencyType(newiryoujissekihaitoukinType))
            .transform(bizCurrencyTransformer(getNewiryoujissekihaitoukinValue()))
            .orNull();
    }

    private BizCurrency newiryounenkanhaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewiryounenkanhaitoukin() {
        return newiryounenkanhaitoukin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewiryounenkanhaitoukin(BizCurrency pNewiryounenkanhaitoukin) {
        newiryounenkanhaitoukin = pNewiryounenkanhaitoukin;
        newiryounenkanhaitoukinValue = null;
        newiryounenkanhaitoukinType  = null;
    }

    transient private BigDecimal newiryounenkanhaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIRYOUNENKANHAITOUKIN, nullable=true)
    protected BigDecimal getNewiryounenkanhaitoukinValue() {
        if (newiryounenkanhaitoukinValue == null && newiryounenkanhaitoukin != null) {
            if (newiryounenkanhaitoukin.isOptional()) return null;
            return newiryounenkanhaitoukin.absolute();
        }
        return newiryounenkanhaitoukinValue;
    }

    protected void setNewiryounenkanhaitoukinValue(BigDecimal value) {
        newiryounenkanhaitoukinValue = value;
        newiryounenkanhaitoukin = Optional.fromNullable(toCurrencyType(newiryounenkanhaitoukinType))
            .transform(bizCurrencyTransformer(getNewiryounenkanhaitoukinValue()))
            .orNull();
    }

    transient private String newiryounenkanhaitoukinType = null;

    @Column(name=NEWIRYOUNENKANHAITOUKIN + "$", nullable=true)
    protected String getNewiryounenkanhaitoukinType() {
        if (newiryounenkanhaitoukinType == null && newiryounenkanhaitoukin != null) return newiryounenkanhaitoukin.getType().toString();
        if (newiryounenkanhaitoukinType == null && getNewiryounenkanhaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newiryounenkanhaitoukin$' should not be NULL."));
        }
        return newiryounenkanhaitoukinType;
    }

    protected void setNewiryounenkanhaitoukinType(String type) {
        newiryounenkanhaitoukinType = type;
        newiryounenkanhaitoukin = Optional.fromNullable(toCurrencyType(newiryounenkanhaitoukinType))
            .transform(bizCurrencyTransformer(getNewiryounenkanhaitoukinValue()))
            .orNull();
    }

    private BizCurrency newiryoujissekisyoumeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewiryoujissekisyoumeigk() {
        return newiryoujissekisyoumeigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewiryoujissekisyoumeigk(BizCurrency pNewiryoujissekisyoumeigk) {
        newiryoujissekisyoumeigk = pNewiryoujissekisyoumeigk;
        newiryoujissekisyoumeigkValue = null;
        newiryoujissekisyoumeigkType  = null;
    }

    transient private BigDecimal newiryoujissekisyoumeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIRYOUJISSEKISYOUMEIGK, nullable=true)
    protected BigDecimal getNewiryoujissekisyoumeigkValue() {
        if (newiryoujissekisyoumeigkValue == null && newiryoujissekisyoumeigk != null) {
            if (newiryoujissekisyoumeigk.isOptional()) return null;
            return newiryoujissekisyoumeigk.absolute();
        }
        return newiryoujissekisyoumeigkValue;
    }

    protected void setNewiryoujissekisyoumeigkValue(BigDecimal value) {
        newiryoujissekisyoumeigkValue = value;
        newiryoujissekisyoumeigk = Optional.fromNullable(toCurrencyType(newiryoujissekisyoumeigkType))
            .transform(bizCurrencyTransformer(getNewiryoujissekisyoumeigkValue()))
            .orNull();
    }

    transient private String newiryoujissekisyoumeigkType = null;

    @Column(name=NEWIRYOUJISSEKISYOUMEIGK + "$", nullable=true)
    protected String getNewiryoujissekisyoumeigkType() {
        if (newiryoujissekisyoumeigkType == null && newiryoujissekisyoumeigk != null) return newiryoujissekisyoumeigk.getType().toString();
        if (newiryoujissekisyoumeigkType == null && getNewiryoujissekisyoumeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newiryoujissekisyoumeigk$' should not be NULL."));
        }
        return newiryoujissekisyoumeigkType;
    }

    protected void setNewiryoujissekisyoumeigkType(String type) {
        newiryoujissekisyoumeigkType = type;
        newiryoujissekisyoumeigk = Optional.fromNullable(toCurrencyType(newiryoujissekisyoumeigkType))
            .transform(bizCurrencyTransformer(getNewiryoujissekisyoumeigkValue()))
            .orNull();
    }

    private BizCurrency newiryounenkansyoumeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewiryounenkansyoumeigk() {
        return newiryounenkansyoumeigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewiryounenkansyoumeigk(BizCurrency pNewiryounenkansyoumeigk) {
        newiryounenkansyoumeigk = pNewiryounenkansyoumeigk;
        newiryounenkansyoumeigkValue = null;
        newiryounenkansyoumeigkType  = null;
    }

    transient private BigDecimal newiryounenkansyoumeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIRYOUNENKANSYOUMEIGK, nullable=true)
    protected BigDecimal getNewiryounenkansyoumeigkValue() {
        if (newiryounenkansyoumeigkValue == null && newiryounenkansyoumeigk != null) {
            if (newiryounenkansyoumeigk.isOptional()) return null;
            return newiryounenkansyoumeigk.absolute();
        }
        return newiryounenkansyoumeigkValue;
    }

    protected void setNewiryounenkansyoumeigkValue(BigDecimal value) {
        newiryounenkansyoumeigkValue = value;
        newiryounenkansyoumeigk = Optional.fromNullable(toCurrencyType(newiryounenkansyoumeigkType))
            .transform(bizCurrencyTransformer(getNewiryounenkansyoumeigkValue()))
            .orNull();
    }

    transient private String newiryounenkansyoumeigkType = null;

    @Column(name=NEWIRYOUNENKANSYOUMEIGK + "$", nullable=true)
    protected String getNewiryounenkansyoumeigkType() {
        if (newiryounenkansyoumeigkType == null && newiryounenkansyoumeigk != null) return newiryounenkansyoumeigk.getType().toString();
        if (newiryounenkansyoumeigkType == null && getNewiryounenkansyoumeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newiryounenkansyoumeigk$' should not be NULL."));
        }
        return newiryounenkansyoumeigkType;
    }

    protected void setNewiryounenkansyoumeigkType(String type) {
        newiryounenkansyoumeigkType = type;
        newiryounenkansyoumeigk = Optional.fromNullable(toCurrencyType(newiryounenkansyoumeigkType))
            .transform(bizCurrencyTransformer(getNewiryounenkansyoumeigkValue()))
            .orNull();
    }

    private BizCurrency newnkjissekip;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewnkjissekip() {
        return newnkjissekip;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewnkjissekip(BizCurrency pNewnkjissekip) {
        newnkjissekip = pNewnkjissekip;
        newnkjissekipValue = null;
        newnkjissekipType  = null;
    }

    transient private BigDecimal newnkjissekipValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWNKJISSEKIP, nullable=true)
    protected BigDecimal getNewnkjissekipValue() {
        if (newnkjissekipValue == null && newnkjissekip != null) {
            if (newnkjissekip.isOptional()) return null;
            return newnkjissekip.absolute();
        }
        return newnkjissekipValue;
    }

    protected void setNewnkjissekipValue(BigDecimal value) {
        newnkjissekipValue = value;
        newnkjissekip = Optional.fromNullable(toCurrencyType(newnkjissekipType))
            .transform(bizCurrencyTransformer(getNewnkjissekipValue()))
            .orNull();
    }

    transient private String newnkjissekipType = null;

    @Column(name=NEWNKJISSEKIP + "$", nullable=true)
    protected String getNewnkjissekipType() {
        if (newnkjissekipType == null && newnkjissekip != null) return newnkjissekip.getType().toString();
        if (newnkjissekipType == null && getNewnkjissekipValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newnkjissekip$' should not be NULL."));
        }
        return newnkjissekipType;
    }

    protected void setNewnkjissekipType(String type) {
        newnkjissekipType = type;
        newnkjissekip = Optional.fromNullable(toCurrencyType(newnkjissekipType))
            .transform(bizCurrencyTransformer(getNewnkjissekipValue()))
            .orNull();
    }

    private BizCurrency newnknenkanp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewnknenkanp() {
        return newnknenkanp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewnknenkanp(BizCurrency pNewnknenkanp) {
        newnknenkanp = pNewnknenkanp;
        newnknenkanpValue = null;
        newnknenkanpType  = null;
    }

    transient private BigDecimal newnknenkanpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWNKNENKANP, nullable=true)
    protected BigDecimal getNewnknenkanpValue() {
        if (newnknenkanpValue == null && newnknenkanp != null) {
            if (newnknenkanp.isOptional()) return null;
            return newnknenkanp.absolute();
        }
        return newnknenkanpValue;
    }

    protected void setNewnknenkanpValue(BigDecimal value) {
        newnknenkanpValue = value;
        newnknenkanp = Optional.fromNullable(toCurrencyType(newnknenkanpType))
            .transform(bizCurrencyTransformer(getNewnknenkanpValue()))
            .orNull();
    }

    transient private String newnknenkanpType = null;

    @Column(name=NEWNKNENKANP + "$", nullable=true)
    protected String getNewnknenkanpType() {
        if (newnknenkanpType == null && newnknenkanp != null) return newnknenkanp.getType().toString();
        if (newnknenkanpType == null && getNewnknenkanpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newnknenkanp$' should not be NULL."));
        }
        return newnknenkanpType;
    }

    protected void setNewnknenkanpType(String type) {
        newnknenkanpType = type;
        newnknenkanp = Optional.fromNullable(toCurrencyType(newnknenkanpType))
            .transform(bizCurrencyTransformer(getNewnknenkanpValue()))
            .orNull();
    }

    private BizCurrency newnkjissekihaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewnkjissekihaitoukin() {
        return newnkjissekihaitoukin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewnkjissekihaitoukin(BizCurrency pNewnkjissekihaitoukin) {
        newnkjissekihaitoukin = pNewnkjissekihaitoukin;
        newnkjissekihaitoukinValue = null;
        newnkjissekihaitoukinType  = null;
    }

    transient private BigDecimal newnkjissekihaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWNKJISSEKIHAITOUKIN, nullable=true)
    protected BigDecimal getNewnkjissekihaitoukinValue() {
        if (newnkjissekihaitoukinValue == null && newnkjissekihaitoukin != null) {
            if (newnkjissekihaitoukin.isOptional()) return null;
            return newnkjissekihaitoukin.absolute();
        }
        return newnkjissekihaitoukinValue;
    }

    protected void setNewnkjissekihaitoukinValue(BigDecimal value) {
        newnkjissekihaitoukinValue = value;
        newnkjissekihaitoukin = Optional.fromNullable(toCurrencyType(newnkjissekihaitoukinType))
            .transform(bizCurrencyTransformer(getNewnkjissekihaitoukinValue()))
            .orNull();
    }

    transient private String newnkjissekihaitoukinType = null;

    @Column(name=NEWNKJISSEKIHAITOUKIN + "$", nullable=true)
    protected String getNewnkjissekihaitoukinType() {
        if (newnkjissekihaitoukinType == null && newnkjissekihaitoukin != null) return newnkjissekihaitoukin.getType().toString();
        if (newnkjissekihaitoukinType == null && getNewnkjissekihaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newnkjissekihaitoukin$' should not be NULL."));
        }
        return newnkjissekihaitoukinType;
    }

    protected void setNewnkjissekihaitoukinType(String type) {
        newnkjissekihaitoukinType = type;
        newnkjissekihaitoukin = Optional.fromNullable(toCurrencyType(newnkjissekihaitoukinType))
            .transform(bizCurrencyTransformer(getNewnkjissekihaitoukinValue()))
            .orNull();
    }

    private BizCurrency newnknenkanhaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewnknenkanhaitoukin() {
        return newnknenkanhaitoukin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewnknenkanhaitoukin(BizCurrency pNewnknenkanhaitoukin) {
        newnknenkanhaitoukin = pNewnknenkanhaitoukin;
        newnknenkanhaitoukinValue = null;
        newnknenkanhaitoukinType  = null;
    }

    transient private BigDecimal newnknenkanhaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWNKNENKANHAITOUKIN, nullable=true)
    protected BigDecimal getNewnknenkanhaitoukinValue() {
        if (newnknenkanhaitoukinValue == null && newnknenkanhaitoukin != null) {
            if (newnknenkanhaitoukin.isOptional()) return null;
            return newnknenkanhaitoukin.absolute();
        }
        return newnknenkanhaitoukinValue;
    }

    protected void setNewnknenkanhaitoukinValue(BigDecimal value) {
        newnknenkanhaitoukinValue = value;
        newnknenkanhaitoukin = Optional.fromNullable(toCurrencyType(newnknenkanhaitoukinType))
            .transform(bizCurrencyTransformer(getNewnknenkanhaitoukinValue()))
            .orNull();
    }

    transient private String newnknenkanhaitoukinType = null;

    @Column(name=NEWNKNENKANHAITOUKIN + "$", nullable=true)
    protected String getNewnknenkanhaitoukinType() {
        if (newnknenkanhaitoukinType == null && newnknenkanhaitoukin != null) return newnknenkanhaitoukin.getType().toString();
        if (newnknenkanhaitoukinType == null && getNewnknenkanhaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newnknenkanhaitoukin$' should not be NULL."));
        }
        return newnknenkanhaitoukinType;
    }

    protected void setNewnknenkanhaitoukinType(String type) {
        newnknenkanhaitoukinType = type;
        newnknenkanhaitoukin = Optional.fromNullable(toCurrencyType(newnknenkanhaitoukinType))
            .transform(bizCurrencyTransformer(getNewnknenkanhaitoukinValue()))
            .orNull();
    }

    private BizCurrency newnkjissekisyoumeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewnkjissekisyoumeigk() {
        return newnkjissekisyoumeigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewnkjissekisyoumeigk(BizCurrency pNewnkjissekisyoumeigk) {
        newnkjissekisyoumeigk = pNewnkjissekisyoumeigk;
        newnkjissekisyoumeigkValue = null;
        newnkjissekisyoumeigkType  = null;
    }

    transient private BigDecimal newnkjissekisyoumeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWNKJISSEKISYOUMEIGK, nullable=true)
    protected BigDecimal getNewnkjissekisyoumeigkValue() {
        if (newnkjissekisyoumeigkValue == null && newnkjissekisyoumeigk != null) {
            if (newnkjissekisyoumeigk.isOptional()) return null;
            return newnkjissekisyoumeigk.absolute();
        }
        return newnkjissekisyoumeigkValue;
    }

    protected void setNewnkjissekisyoumeigkValue(BigDecimal value) {
        newnkjissekisyoumeigkValue = value;
        newnkjissekisyoumeigk = Optional.fromNullable(toCurrencyType(newnkjissekisyoumeigkType))
            .transform(bizCurrencyTransformer(getNewnkjissekisyoumeigkValue()))
            .orNull();
    }

    transient private String newnkjissekisyoumeigkType = null;

    @Column(name=NEWNKJISSEKISYOUMEIGK + "$", nullable=true)
    protected String getNewnkjissekisyoumeigkType() {
        if (newnkjissekisyoumeigkType == null && newnkjissekisyoumeigk != null) return newnkjissekisyoumeigk.getType().toString();
        if (newnkjissekisyoumeigkType == null && getNewnkjissekisyoumeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newnkjissekisyoumeigk$' should not be NULL."));
        }
        return newnkjissekisyoumeigkType;
    }

    protected void setNewnkjissekisyoumeigkType(String type) {
        newnkjissekisyoumeigkType = type;
        newnkjissekisyoumeigk = Optional.fromNullable(toCurrencyType(newnkjissekisyoumeigkType))
            .transform(bizCurrencyTransformer(getNewnkjissekisyoumeigkValue()))
            .orNull();
    }

    private BizCurrency newnknenkansyoumeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewnknenkansyoumeigk() {
        return newnknenkansyoumeigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewnknenkansyoumeigk(BizCurrency pNewnknenkansyoumeigk) {
        newnknenkansyoumeigk = pNewnknenkansyoumeigk;
        newnknenkansyoumeigkValue = null;
        newnknenkansyoumeigkType  = null;
    }

    transient private BigDecimal newnknenkansyoumeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWNKNENKANSYOUMEIGK, nullable=true)
    protected BigDecimal getNewnknenkansyoumeigkValue() {
        if (newnknenkansyoumeigkValue == null && newnknenkansyoumeigk != null) {
            if (newnknenkansyoumeigk.isOptional()) return null;
            return newnknenkansyoumeigk.absolute();
        }
        return newnknenkansyoumeigkValue;
    }

    protected void setNewnknenkansyoumeigkValue(BigDecimal value) {
        newnknenkansyoumeigkValue = value;
        newnknenkansyoumeigk = Optional.fromNullable(toCurrencyType(newnknenkansyoumeigkType))
            .transform(bizCurrencyTransformer(getNewnknenkansyoumeigkValue()))
            .orNull();
    }

    transient private String newnknenkansyoumeigkType = null;

    @Column(name=NEWNKNENKANSYOUMEIGK + "$", nullable=true)
    protected String getNewnknenkansyoumeigkType() {
        if (newnknenkansyoumeigkType == null && newnknenkansyoumeigk != null) return newnknenkansyoumeigk.getType().toString();
        if (newnknenkansyoumeigkType == null && getNewnknenkansyoumeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newnknenkansyoumeigk$' should not be NULL."));
        }
        return newnknenkansyoumeigkType;
    }

    protected void setNewnknenkansyoumeigkType(String type) {
        newnknenkansyoumeigkType = type;
        newnknenkansyoumeigk = Optional.fromNullable(toCurrencyType(newnknenkansyoumeigkType))
            .transform(bizCurrencyTransformer(getNewnknenkansyoumeigkValue()))
            .orNull();
    }

    private C_UmuKbn kjnnkkoujyum;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KoujyoSym.KJNNKKOUJYUM)
    public C_UmuKbn getKjnnkkoujyum() {
        return kjnnkkoujyum;
    }

    public void setKjnnkkoujyum(C_UmuKbn pKjnnkkoujyum) {
        kjnnkkoujyum = pKjnnkkoujyum;
    }

    private String tsinyno;

    @Column(name=GenIT_KoujyoSym.TSINYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getTsinyno() {
        return tsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    private String tsinadr1kj;

    @Column(name=GenIT_KoujyoSym.TSINADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    private String tsinadr2kj;

    @Column(name=GenIT_KoujyoSym.TSINADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    private String tsinadr3kj;

    @Column(name=GenIT_KoujyoSym.TSINADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
    }

    private String toiawasesosikinmkj;

    @Column(name=GenIT_KoujyoSym.TOIAWASESOSIKINMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getToiawasesosikinmkj() {
        return toiawasesosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setToiawasesosikinmkj(String pToiawasesosikinmkj) {
        toiawasesosikinmkj = pToiawasesosikinmkj;
    }

    private String toiawaseyno;

    @Column(name=GenIT_KoujyoSym.TOIAWASEYNO)
    public String getToiawaseyno() {
        return toiawaseyno;
    }

    public void setToiawaseyno(String pToiawaseyno) {
        toiawaseyno = pToiawaseyno;
    }

    private String toiawaseadr1kj;

    @Column(name=GenIT_KoujyoSym.TOIAWASEADR1KJ)
    public String getToiawaseadr1kj() {
        return toiawaseadr1kj;
    }

    public void setToiawaseadr1kj(String pToiawaseadr1kj) {
        toiawaseadr1kj = pToiawaseadr1kj;
    }

    private String toiawaseadr2kj;

    @Column(name=GenIT_KoujyoSym.TOIAWASEADR2KJ)
    public String getToiawaseadr2kj() {
        return toiawaseadr2kj;
    }

    public void setToiawaseadr2kj(String pToiawaseadr2kj) {
        toiawaseadr2kj = pToiawaseadr2kj;
    }

    private String toiawaseadr3kj;

    @Column(name=GenIT_KoujyoSym.TOIAWASEADR3KJ)
    public String getToiawaseadr3kj() {
        return toiawaseadr3kj;
    }

    public void setToiawaseadr3kj(String pToiawaseadr3kj) {
        toiawaseadr3kj = pToiawaseadr3kj;
    }

    private String toiawasetelno;

    @Column(name=GenIT_KoujyoSym.TOIAWASETELNO)
    @AlphaDigitOrExceptionCode(except=("-()"))
    @MaxLength(max=14)
    public String getToiawasetelno() {
        return toiawasetelno;
    }

    @DataConvert("toSingleByte")
    public void setToiawasetelno(String pToiawasetelno) {
        toiawasetelno = pToiawasetelno;
    }

    private String toiawaseteluktkkanou1;

    @Column(name=GenIT_KoujyoSym.TOIAWASETELUKTKKANOU1)
    public String getToiawaseteluktkkanou1() {
        return toiawaseteluktkkanou1;
    }

    public void setToiawaseteluktkkanou1(String pToiawaseteluktkkanou1) {
        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;
    }

    private String toiawaseteluktkkanou2;

    @Column(name=GenIT_KoujyoSym.TOIAWASETELUKTKKANOU2)
    public String getToiawaseteluktkkanou2() {
        return toiawaseteluktkkanou2;
    }

    public void setToiawaseteluktkkanou2(String pToiawaseteluktkkanou2) {
        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;
    }

    private String toiawasesosikinmkj2;

    @Column(name=GenIT_KoujyoSym.TOIAWASESOSIKINMKJ2)
    public String getToiawasesosikinmkj2() {
        return toiawasesosikinmkj2;
    }

    public void setToiawasesosikinmkj2(String pToiawasesosikinmkj2) {
        toiawasesosikinmkj2 = pToiawasesosikinmkj2;
    }

    private String toiawasetelno2;

    @Column(name=GenIT_KoujyoSym.TOIAWASETELNO2)
    public String getToiawasetelno2() {
        return toiawasetelno2;
    }

    public void setToiawasetelno2(String pToiawasetelno2) {
        toiawasetelno2 = pToiawasetelno2;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIT_KoujyoSym.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private String drtencd;

    @Column(name=GenIT_KoujyoSym.DRTENCD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd() {
        return drtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }

    private String drtennmkj;

    @Column(name=GenIT_KoujyoSym.DRTENNMKJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getDrtennmkj() {
        return drtennmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setDrtennmkj(String pDrtennmkj) {
        drtennmkj = pDrtennmkj;
    }

    private C_UmuKbn hengakuumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KoujyoSym.HENGAKUUMU)
    public C_UmuKbn getHengakuumu() {
        return hengakuumu;
    }

    public void setHengakuumu(C_UmuKbn pHengakuumu) {
        hengakuumu = pHengakuumu;
    }

    private C_UmuKbn newsyoumeigkumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KoujyoSym.NEWSYOUMEIGKUMUKBN)
    public C_UmuKbn getNewsyoumeigkumukbn() {
        return newsyoumeigkumukbn;
    }

    public void setNewsyoumeigkumukbn(C_UmuKbn pNewsyoumeigkumukbn) {
        newsyoumeigkumukbn = pNewsyoumeigkumukbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KoujyoSym.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KoujyoSym.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KoujyoSym.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_KoujyosyoumeisentakuKbn koujyosyoumeisentakukbn;

    @Type(type="UserType_C_KoujyosyoumeisentakuKbn")
    @Column(name=GenIT_KoujyoSym.KOUJYOSYOUMEISENTAKUKBN)
    public C_KoujyosyoumeisentakuKbn getKoujyosyoumeisentakukbn() {
        return koujyosyoumeisentakukbn;
    }

    public void setKoujyosyoumeisentakukbn(C_KoujyosyoumeisentakuKbn pKoujyosyoumeisentakukbn) {
        koujyosyoumeisentakukbn = pKoujyosyoumeisentakukbn;
    }

    private String kyknmkn;

    @Column(name=GenIT_KoujyoSym.KYKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    private String uktnmkn;

    @Column(name=GenIT_KoujyoSym.UKTNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getUktnmkn() {
        return uktnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktnmkn(String pUktnmkn) {
        uktnmkn = pUktnmkn;
    }

    private C_SaihkHyjKbn saihkhyjkbn;

    @Type(type="UserType_C_SaihkHyjKbn")
    @Column(name=GenIT_KoujyoSym.SAIHKHYJKBN)
    public C_SaihkHyjKbn getSaihkhyjkbn() {
        return saihkhyjkbn;
    }

    public void setSaihkhyjkbn(C_SaihkHyjKbn pSaihkhyjkbn) {
        saihkhyjkbn = pSaihkhyjkbn;
    }

    private C_KoujyosyoumeimsgKbn koujyosyoumeimsgkbn;

    @Type(type="UserType_C_KoujyosyoumeimsgKbn")
    @Column(name=GenIT_KoujyoSym.KOUJYOSYOUMEIMSGKBN)
    public C_KoujyosyoumeimsgKbn getKoujyosyoumeimsgkbn() {
        return koujyosyoumeimsgkbn;
    }

    public void setKoujyosyoumeimsgkbn(C_KoujyosyoumeimsgKbn pKoujyosyoumeimsgkbn) {
        koujyosyoumeimsgkbn = pKoujyosyoumeimsgkbn;
    }
}
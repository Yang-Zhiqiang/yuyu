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
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_KyhkinTaniKbn;
import yuyu.def.classification.C_NitigakuHokenKngkKbn;
import yuyu.def.classification.C_SbjiShrKbn;
import yuyu.def.classification.C_SeisankinKanritukaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.id.PKJM_SiSyouhnZokusei;
import yuyu.def.db.meta.GenQJM_SiSyouhnZokusei;
import yuyu.def.db.meta.QJM_SiSyouhnZokusei;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;
import yuyu.def.db.type.UserType_C_KyhkinTaniKbn;
import yuyu.def.db.type.UserType_C_NitigakuHokenKngkKbn;
import yuyu.def.db.type.UserType_C_SbjiShrKbn;
import yuyu.def.db.type.UserType_C_SeisankinKanritukaKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 支払商品属性マスタ テーブルのマッピング情報クラスで、 {@link JM_SiSyouhnZokusei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_SiSyouhnZokusei}</td><td colspan="3">支払商品属性マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKJM_SiSyouhnZokusei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyhgndkatakbn kyhgndkatakbn}</td><td>給付限度型区分</td><td align="center">{@link PKJM_SiSyouhnZokusei ○}</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">{@link PKJM_SiSyouhnZokusei ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyuuhucd kyuuhucd}</td><td>給付コード</td><td align="center">{@link PKJM_SiSyouhnZokusei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyouhnnm syouhnnm}</td><td>商品名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnmgm syouhnnmgm}</td><td>商品名（画面用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnmtyhy syouhnnmtyhy}</td><td>商品名（帳票用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujijyun hyoujijyun}</td><td>表示順</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTaisyoukkngaishrkahikbn taisyoukkngaishrkahikbn}</td><td>対象期間外支払可否区分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getByoumeisetteikbn byoumeisetteikbn}</td><td>病名設定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getShrjiyuu shrjiyuu}</td><td>支払事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoumetuumukbn syoumetuumukbn}</td><td>消滅有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTaisyoukknmae taisyoukknmae}</td><td>対象期間（前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTaisyoukknato taisyoukknato}</td><td>対象期間（後）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getShrtaisyounissuu shrtaisyounissuu}</td><td>支払対象日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getShrtaisyounyuuinnissuu shrtaisyounyuuinnissuu}</td><td>支払対象入院日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHutanponissuu hutanponissuu}</td><td>不担保日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getItinyuuingendonissuu itinyuuingendonissuu}</td><td>１入院限度日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyhgendonissuu kyhgendonissuu}</td><td>給付限度日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTuusangendonissuu tuusangendonissuu}</td><td>通算限度日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTuusangendokaisuu tuusangendokaisuu}</td><td>通算限度回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTuusangendogaku tuusangendogaku}</td><td>通算限度額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getBetusippeihanteinissuu betusippeihanteinissuu}</td><td>別疾病判定日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNitigakurate nitigakurate}</td><td>日額率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getNitigakuhokenkngkkbn nitigakuhokenkngkkbn}</td><td>日額・保険金額区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NitigakuHokenKngkKbn}</td></tr>
 *  <tr><td>{@link #getKyhkintanikbn kyhkintanikbn}</td><td>給付金単位区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyhkinTaniKbn}</td></tr>
 *  <tr><td>{@link #getShrbairitu shrbairitu}</td><td>支払倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getJisatumensekinensuu jisatumensekinensuu}</td><td>自殺免責年数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getManryoumaetukisuu manryoumaetukisuu}</td><td>満了前月数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTyouhyouhyoujikbn tyouhyouhyoujikbn}</td><td>帳票表示区分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNyuuinitijikinumukbn nyuuinitijikinumukbn}</td><td>入院一時金有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSensinitijikinumukbn sensinitijikinumukbn}</td><td>先進医療一時金有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getItijikngk itijikngk}</td><td>一時金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKyhkintaisyouumukbn kyhkintaisyouumukbn}</td><td>給付金対象有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKdhokenkintaisyouumukbn kdhokenkintaisyouumukbn}</td><td>高度障害保険金対象有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getPmtaisyouumukbn pmtaisyouumukbn}</td><td>Ｐ免対象有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSbjishrkbn sbjishrkbn}</td><td>死亡時支払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SbjiShrKbn}</td></tr>
 *  <tr><td>{@link #getSbmensekitaisyouumukbn sbmensekitaisyouumukbn}</td><td>死亡免責対象有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKyhntgkkatacalcumukbn kyhntgkkatacalcumukbn}</td><td>給付日額型計算有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getShrsakugenkknumukbn shrsakugenkknumukbn}</td><td>支払削減期間有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getMisyuumikeikadoujiumukbn misyuumikeikadoujiumukbn}</td><td>未収未経過同時発生有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHokenkngknitigakumsg1 hokenkngknitigakumsg1}</td><td>保険金額日額文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokenkngknitigakumsg2 hokenkngknitigakumsg2}</td><td>保険金額日額文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLnmaxkngk lnmaxkngk}</td><td>ＬＮ上限金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLnminkngk lnminkngk}</td><td>ＬＮ下限金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLnseikyuutanisenyen lnseikyuutanisenyen}</td><td>ＬＮ請求単位（千円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getCalckijyunmiraibicheck calckijyunmiraibicheck}</td><td>計算基準未来日チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getPsoutougkhyoujiumu psoutougkhyoujiumu}</td><td>保険料相当額表示有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTmttkngkhyoujiumu tmttkngkhyoujiumu}</td><td>積立金額表示有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKaiyakuhrhyoujiumu kaiyakuhrhyoujiumu}</td><td>解約返戻金表示有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKihonshyoujiumu kihonshyoujiumu}</td><td>基本保険金額表示有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSaigaishyoujiumu saigaishyoujiumu}</td><td>災害保険金額表示有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getMsyupknrtuukakbn msyupknrtuukakbn}</td><td>未収Ｐ管理通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeisankinKanritukaKbn}</td></tr>
 *  <tr><td>{@link #getMikeikapknrtuukakbn mikeikapknrtuukakbn}</td><td>未経過Ｐ管理通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeisankinKanritukaKbn}</td></tr>
 *  <tr><td>{@link #getZnnusisnkinknrtuukakbn znnusisnkinknrtuukakbn}</td><td>前納精算金管理通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeisankinKanritukaKbn}</td></tr>
 *  <tr><td>{@link #getKrkinknrtuukakbn krkinknrtuukakbn}</td><td>仮受金管理通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeisankinKanritukaKbn}</td></tr>
 * </table>
 * @see     JM_SiSyouhnZokusei
 * @see     PKJM_SiSyouhnZokusei
 * @see     QJM_SiSyouhnZokusei
 * @see     GenQJM_SiSyouhnZokusei
 */
@MappedSuperclass
@Table(name=GenJM_SiSyouhnZokusei.TABLE_NAME)
@IdClass(value=PKJM_SiSyouhnZokusei.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_KyhgndkataKbn", typeClass=UserType_C_KyhgndkataKbn.class),
    @TypeDef(name="UserType_C_KyhkinTaniKbn", typeClass=UserType_C_KyhkinTaniKbn.class),
    @TypeDef(name="UserType_C_NitigakuHokenKngkKbn", typeClass=UserType_C_NitigakuHokenKngkKbn.class),
    @TypeDef(name="UserType_C_SbjiShrKbn", typeClass=UserType_C_SbjiShrKbn.class),
    @TypeDef(name="UserType_C_SeisankinKanritukaKbn", typeClass=UserType_C_SeisankinKanritukaKbn.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJM_SiSyouhnZokusei extends AbstractExDBEntity<JM_SiSyouhnZokusei, PKJM_SiSyouhnZokusei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JM_SiSyouhnZokusei";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String KYHGNDKATAKBN            = "kyhgndkatakbn";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KYUUHUCD                 = "kyuuhucd";
    public static final String SYUTKKBN                 = "syutkkbn";
    public static final String SYOUHNNM                 = "syouhnnm";
    public static final String SYOUHNNMGM               = "syouhnnmgm";
    public static final String SYOUHNNMTYHY             = "syouhnnmtyhy";
    public static final String HYOUJIJYUN               = "hyoujijyun";
    public static final String TAISYOUKKNGAISHRKAHIKBN  = "taisyoukkngaishrkahikbn";
    public static final String BYOUMEISETTEIKBN         = "byoumeisetteikbn";
    public static final String SHRJIYUU                 = "shrjiyuu";
    public static final String SYOUMETUUMUKBN           = "syoumetuumukbn";
    public static final String TAISYOUKKNMAE            = "taisyoukknmae";
    public static final String TAISYOUKKNATO            = "taisyoukknato";
    public static final String SHRTAISYOUNISSUU         = "shrtaisyounissuu";
    public static final String SHRTAISYOUNYUUINNISSUU   = "shrtaisyounyuuinnissuu";
    public static final String HUTANPONISSUU            = "hutanponissuu";
    public static final String ITINYUUINGENDONISSUU     = "itinyuuingendonissuu";
    public static final String KYHGENDONISSUU           = "kyhgendonissuu";
    public static final String TUUSANGENDONISSUU        = "tuusangendonissuu";
    public static final String TUUSANGENDOKAISUU        = "tuusangendokaisuu";
    public static final String TUUSANGENDOGAKU          = "tuusangendogaku";
    public static final String BETUSIPPEIHANTEINISSUU   = "betusippeihanteinissuu";
    public static final String NITIGAKURATE             = "nitigakurate";
    public static final String NITIGAKUHOKENKNGKKBN     = "nitigakuhokenkngkkbn";
    public static final String KYHKINTANIKBN            = "kyhkintanikbn";
    public static final String SHRBAIRITU               = "shrbairitu";
    public static final String JISATUMENSEKINENSUU      = "jisatumensekinensuu";
    public static final String MANRYOUMAETUKISUU        = "manryoumaetukisuu";
    public static final String TYOUHYOUHYOUJIKBN        = "tyouhyouhyoujikbn";
    public static final String NYUUINITIJIKINUMUKBN     = "nyuuinitijikinumukbn";
    public static final String SENSINITIJIKINUMUKBN     = "sensinitijikinumukbn";
    public static final String ITIJIKNGK                = "itijikngk";
    public static final String KYHKINTAISYOUUMUKBN      = "kyhkintaisyouumukbn";
    public static final String KDHOKENKINTAISYOUUMUKBN  = "kdhokenkintaisyouumukbn";
    public static final String PMTAISYOUUMUKBN          = "pmtaisyouumukbn";
    public static final String SBJISHRKBN               = "sbjishrkbn";
    public static final String SBMENSEKITAISYOUUMUKBN   = "sbmensekitaisyouumukbn";
    public static final String KYHNTGKKATACALCUMUKBN    = "kyhntgkkatacalcumukbn";
    public static final String SHRSAKUGENKKNUMUKBN      = "shrsakugenkknumukbn";
    public static final String MISYUUMIKEIKADOUJIUMUKBN = "misyuumikeikadoujiumukbn";
    public static final String HOKENKNGKNITIGAKUMSG1    = "hokenkngknitigakumsg1";
    public static final String HOKENKNGKNITIGAKUMSG2    = "hokenkngknitigakumsg2";
    public static final String LNMAXKNGK                = "lnmaxkngk";
    public static final String LNMINKNGK                = "lnminkngk";
    public static final String LNSEIKYUUTANISENYEN      = "lnseikyuutanisenyen";
    public static final String CALCKIJYUNMIRAIBICHECK   = "calckijyunmiraibicheck";
    public static final String PSOUTOUGKHYOUJIUMU       = "psoutougkhyoujiumu";
    public static final String TMTTKNGKHYOUJIUMU        = "tmttkngkhyoujiumu";
    public static final String KAIYAKUHRHYOUJIUMU       = "kaiyakuhrhyoujiumu";
    public static final String KIHONSHYOUJIUMU          = "kihonshyoujiumu";
    public static final String SAIGAISHYOUJIUMU         = "saigaishyoujiumu";
    public static final String MSYUPKNRTUUKAKBN         = "msyupknrtuukakbn";
    public static final String MIKEIKAPKNRTUUKAKBN      = "mikeikapknrtuukakbn";
    public static final String ZNNUSISNKINKNRTUUKAKBN   = "znnusisnkinknrtuukakbn";
    public static final String KRKINKNRTUUKAKBN         = "krkinknrtuukakbn";

    private final PKJM_SiSyouhnZokusei primaryKey;

    public GenJM_SiSyouhnZokusei() {
        primaryKey = new PKJM_SiSyouhnZokusei();
    }

    public GenJM_SiSyouhnZokusei(
        String pSyouhncd,
        C_KyhgndkataKbn pKyhgndkatakbn,
        Integer pSyouhnsdno,
        String pKyuuhucd
    ) {
        primaryKey = new PKJM_SiSyouhnZokusei(
            pSyouhncd,
            pKyhgndkatakbn,
            pSyouhnsdno,
            pKyuuhucd
        );
    }

    @Transient
    @Override
    public PKJM_SiSyouhnZokusei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJM_SiSyouhnZokusei> getMetaClass() {
        return QJM_SiSyouhnZokusei.class;
    }

    @Id
    @Column(name=GenJM_SiSyouhnZokusei.SYOUHNCD)
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
    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenJM_SiSyouhnZokusei.KYHGNDKATAKBN)
    public C_KyhgndkataKbn getKyhgndkatakbn() {
        return getPrimaryKey().getKyhgndkatakbn();
    }

    public void setKyhgndkatakbn(C_KyhgndkataKbn pKyhgndkatakbn) {
        getPrimaryKey().setKyhgndkatakbn(pKyhgndkatakbn);
    }

    @Id
    @Column(name=GenJM_SiSyouhnZokusei.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return getPrimaryKey().getSyouhnsdno();
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        getPrimaryKey().setSyouhnsdno(pSyouhnsdno);
    }

    @Id
    @Column(name=GenJM_SiSyouhnZokusei.KYUUHUCD)
    public String getKyuuhucd() {
        return getPrimaryKey().getKyuuhucd();
    }

    public void setKyuuhucd(String pKyuuhucd) {
        getPrimaryKey().setKyuuhucd(pKyuuhucd);
    }

    private C_SyutkKbn syutkkbn;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenJM_SiSyouhnZokusei.SYUTKKBN)
    public C_SyutkKbn getSyutkkbn() {
        return syutkkbn;
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        syutkkbn = pSyutkkbn;
    }

    private String syouhnnm;

    @Column(name=GenJM_SiSyouhnZokusei.SYOUHNNM)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyouhnnm() {
        return syouhnnm;
    }

    @Trim("right")
    public void setSyouhnnm(String pSyouhnnm) {
        syouhnnm = pSyouhnnm;
    }

    private String syouhnnmgm;

    @Column(name=GenJM_SiSyouhnZokusei.SYOUHNNMGM)
    public String getSyouhnnmgm() {
        return syouhnnmgm;
    }

    public void setSyouhnnmgm(String pSyouhnnmgm) {
        syouhnnmgm = pSyouhnnmgm;
    }

    private String syouhnnmtyhy;

    @Column(name=GenJM_SiSyouhnZokusei.SYOUHNNMTYHY)
    public String getSyouhnnmtyhy() {
        return syouhnnmtyhy;
    }

    public void setSyouhnnmtyhy(String pSyouhnnmtyhy) {
        syouhnnmtyhy = pSyouhnnmtyhy;
    }

    private Integer hyoujijyun;

    @Column(name=GenJM_SiSyouhnZokusei.HYOUJIJYUN)
    public Integer getHyoujijyun() {
        return hyoujijyun;
    }

    public void setHyoujijyun(Integer pHyoujijyun) {
        hyoujijyun = pHyoujijyun;
    }

    private Integer taisyoukkngaishrkahikbn;

    @Column(name=GenJM_SiSyouhnZokusei.TAISYOUKKNGAISHRKAHIKBN)
    public Integer getTaisyoukkngaishrkahikbn() {
        return taisyoukkngaishrkahikbn;
    }

    public void setTaisyoukkngaishrkahikbn(Integer pTaisyoukkngaishrkahikbn) {
        taisyoukkngaishrkahikbn = pTaisyoukkngaishrkahikbn;
    }

    private C_UmuKbn byoumeisetteikbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.BYOUMEISETTEIKBN)
    public C_UmuKbn getByoumeisetteikbn() {
        return byoumeisetteikbn;
    }

    public void setByoumeisetteikbn(C_UmuKbn pByoumeisetteikbn) {
        byoumeisetteikbn = pByoumeisetteikbn;
    }

    private String shrjiyuu;

    @Column(name=GenJM_SiSyouhnZokusei.SHRJIYUU)
    public String getShrjiyuu() {
        return shrjiyuu;
    }

    public void setShrjiyuu(String pShrjiyuu) {
        shrjiyuu = pShrjiyuu;
    }

    private C_UmuKbn syoumetuumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.SYOUMETUUMUKBN)
    public C_UmuKbn getSyoumetuumukbn() {
        return syoumetuumukbn;
    }

    public void setSyoumetuumukbn(C_UmuKbn pSyoumetuumukbn) {
        syoumetuumukbn = pSyoumetuumukbn;
    }

    private Integer taisyoukknmae;

    @Column(name=GenJM_SiSyouhnZokusei.TAISYOUKKNMAE)
    public Integer getTaisyoukknmae() {
        return taisyoukknmae;
    }

    public void setTaisyoukknmae(Integer pTaisyoukknmae) {
        taisyoukknmae = pTaisyoukknmae;
    }

    private Integer taisyoukknato;

    @Column(name=GenJM_SiSyouhnZokusei.TAISYOUKKNATO)
    public Integer getTaisyoukknato() {
        return taisyoukknato;
    }

    public void setTaisyoukknato(Integer pTaisyoukknato) {
        taisyoukknato = pTaisyoukknato;
    }

    private Integer shrtaisyounissuu;

    @Column(name=GenJM_SiSyouhnZokusei.SHRTAISYOUNISSUU)
    public Integer getShrtaisyounissuu() {
        return shrtaisyounissuu;
    }

    public void setShrtaisyounissuu(Integer pShrtaisyounissuu) {
        shrtaisyounissuu = pShrtaisyounissuu;
    }

    private Integer shrtaisyounyuuinnissuu;

    @Column(name=GenJM_SiSyouhnZokusei.SHRTAISYOUNYUUINNISSUU)
    public Integer getShrtaisyounyuuinnissuu() {
        return shrtaisyounyuuinnissuu;
    }

    public void setShrtaisyounyuuinnissuu(Integer pShrtaisyounyuuinnissuu) {
        shrtaisyounyuuinnissuu = pShrtaisyounyuuinnissuu;
    }

    private Integer hutanponissuu;

    @Column(name=GenJM_SiSyouhnZokusei.HUTANPONISSUU)
    public Integer getHutanponissuu() {
        return hutanponissuu;
    }

    public void setHutanponissuu(Integer pHutanponissuu) {
        hutanponissuu = pHutanponissuu;
    }

    private Integer itinyuuingendonissuu;

    @Column(name=GenJM_SiSyouhnZokusei.ITINYUUINGENDONISSUU)
    public Integer getItinyuuingendonissuu() {
        return itinyuuingendonissuu;
    }

    public void setItinyuuingendonissuu(Integer pItinyuuingendonissuu) {
        itinyuuingendonissuu = pItinyuuingendonissuu;
    }

    private Integer kyhgendonissuu;

    @Column(name=GenJM_SiSyouhnZokusei.KYHGENDONISSUU)
    public Integer getKyhgendonissuu() {
        return kyhgendonissuu;
    }

    public void setKyhgendonissuu(Integer pKyhgendonissuu) {
        kyhgendonissuu = pKyhgendonissuu;
    }

    private Integer tuusangendonissuu;

    @Column(name=GenJM_SiSyouhnZokusei.TUUSANGENDONISSUU)
    public Integer getTuusangendonissuu() {
        return tuusangendonissuu;
    }

    public void setTuusangendonissuu(Integer pTuusangendonissuu) {
        tuusangendonissuu = pTuusangendonissuu;
    }

    private Integer tuusangendokaisuu;

    @Column(name=GenJM_SiSyouhnZokusei.TUUSANGENDOKAISUU)
    public Integer getTuusangendokaisuu() {
        return tuusangendokaisuu;
    }

    public void setTuusangendokaisuu(Integer pTuusangendokaisuu) {
        tuusangendokaisuu = pTuusangendokaisuu;
    }

    private BizCurrency tuusangendogaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTuusangendogaku() {
        return tuusangendogaku;
    }

    public void setTuusangendogaku(BizCurrency pTuusangendogaku) {
        tuusangendogaku = pTuusangendogaku;
        tuusangendogakuValue = null;
        tuusangendogakuType  = null;
    }

    transient private BigDecimal tuusangendogakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TUUSANGENDOGAKU, nullable=true)
    protected BigDecimal getTuusangendogakuValue() {
        if (tuusangendogakuValue == null && tuusangendogaku != null) {
            if (tuusangendogaku.isOptional()) return null;
            return tuusangendogaku.absolute();
        }
        return tuusangendogakuValue;
    }

    protected void setTuusangendogakuValue(BigDecimal value) {
        tuusangendogakuValue = value;
        tuusangendogaku = Optional.fromNullable(toCurrencyType(tuusangendogakuType))
            .transform(bizCurrencyTransformer(getTuusangendogakuValue()))
            .orNull();
    }

    transient private String tuusangendogakuType = null;

    @Column(name=TUUSANGENDOGAKU + "$", nullable=true)
    protected String getTuusangendogakuType() {
        if (tuusangendogakuType == null && tuusangendogaku != null) return tuusangendogaku.getType().toString();
        if (tuusangendogakuType == null && getTuusangendogakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tuusangendogaku$' should not be NULL."));
        }
        return tuusangendogakuType;
    }

    protected void setTuusangendogakuType(String type) {
        tuusangendogakuType = type;
        tuusangendogaku = Optional.fromNullable(toCurrencyType(tuusangendogakuType))
            .transform(bizCurrencyTransformer(getTuusangendogakuValue()))
            .orNull();
    }

    private Integer betusippeihanteinissuu;

    @Column(name=GenJM_SiSyouhnZokusei.BETUSIPPEIHANTEINISSUU)
    public Integer getBetusippeihanteinissuu() {
        return betusippeihanteinissuu;
    }

    public void setBetusippeihanteinissuu(Integer pBetusippeihanteinissuu) {
        betusippeihanteinissuu = pBetusippeihanteinissuu;
    }

    private BizNumber nitigakurate;

    @Type(type="BizNumberType")
    @Column(name=GenJM_SiSyouhnZokusei.NITIGAKURATE)
    public BizNumber getNitigakurate() {
        return nitigakurate;
    }

    public void setNitigakurate(BizNumber pNitigakurate) {
        nitigakurate = pNitigakurate;
    }

    private C_NitigakuHokenKngkKbn nitigakuhokenkngkkbn;

    @Type(type="UserType_C_NitigakuHokenKngkKbn")
    @Column(name=GenJM_SiSyouhnZokusei.NITIGAKUHOKENKNGKKBN)
    public C_NitigakuHokenKngkKbn getNitigakuhokenkngkkbn() {
        return nitigakuhokenkngkkbn;
    }

    public void setNitigakuhokenkngkkbn(C_NitigakuHokenKngkKbn pNitigakuhokenkngkkbn) {
        nitigakuhokenkngkkbn = pNitigakuhokenkngkkbn;
    }

    private C_KyhkinTaniKbn kyhkintanikbn;

    @Type(type="UserType_C_KyhkinTaniKbn")
    @Column(name=GenJM_SiSyouhnZokusei.KYHKINTANIKBN)
    public C_KyhkinTaniKbn getKyhkintanikbn() {
        return kyhkintanikbn;
    }

    public void setKyhkintanikbn(C_KyhkinTaniKbn pKyhkintanikbn) {
        kyhkintanikbn = pKyhkintanikbn;
    }

    private BizNumber shrbairitu;

    @Type(type="BizNumberType")
    @Column(name=GenJM_SiSyouhnZokusei.SHRBAIRITU)
    public BizNumber getShrbairitu() {
        return shrbairitu;
    }

    public void setShrbairitu(BizNumber pShrbairitu) {
        shrbairitu = pShrbairitu;
    }

    private Integer jisatumensekinensuu;

    @Column(name=GenJM_SiSyouhnZokusei.JISATUMENSEKINENSUU)
    public Integer getJisatumensekinensuu() {
        return jisatumensekinensuu;
    }

    public void setJisatumensekinensuu(Integer pJisatumensekinensuu) {
        jisatumensekinensuu = pJisatumensekinensuu;
    }

    private Integer manryoumaetukisuu;

    @Column(name=GenJM_SiSyouhnZokusei.MANRYOUMAETUKISUU)
    public Integer getManryoumaetukisuu() {
        return manryoumaetukisuu;
    }

    public void setManryoumaetukisuu(Integer pManryoumaetukisuu) {
        manryoumaetukisuu = pManryoumaetukisuu;
    }

    private Integer tyouhyouhyoujikbn;

    @Column(name=GenJM_SiSyouhnZokusei.TYOUHYOUHYOUJIKBN)
    public Integer getTyouhyouhyoujikbn() {
        return tyouhyouhyoujikbn;
    }

    public void setTyouhyouhyoujikbn(Integer pTyouhyouhyoujikbn) {
        tyouhyouhyoujikbn = pTyouhyouhyoujikbn;
    }

    private C_UmuKbn nyuuinitijikinumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.NYUUINITIJIKINUMUKBN)
    public C_UmuKbn getNyuuinitijikinumukbn() {
        return nyuuinitijikinumukbn;
    }

    public void setNyuuinitijikinumukbn(C_UmuKbn pNyuuinitijikinumukbn) {
        nyuuinitijikinumukbn = pNyuuinitijikinumukbn;
    }

    private C_UmuKbn sensinitijikinumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.SENSINITIJIKINUMUKBN)
    public C_UmuKbn getSensinitijikinumukbn() {
        return sensinitijikinumukbn;
    }

    public void setSensinitijikinumukbn(C_UmuKbn pSensinitijikinumukbn) {
        sensinitijikinumukbn = pSensinitijikinumukbn;
    }

    private BizCurrency itijikngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getItijikngk() {
        return itijikngk;
    }

    public void setItijikngk(BizCurrency pItijikngk) {
        itijikngk = pItijikngk;
        itijikngkValue = null;
        itijikngkType  = null;
    }

    transient private BigDecimal itijikngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ITIJIKNGK, nullable=true)
    protected BigDecimal getItijikngkValue() {
        if (itijikngkValue == null && itijikngk != null) {
            if (itijikngk.isOptional()) return null;
            return itijikngk.absolute();
        }
        return itijikngkValue;
    }

    protected void setItijikngkValue(BigDecimal value) {
        itijikngkValue = value;
        itijikngk = Optional.fromNullable(toCurrencyType(itijikngkType))
            .transform(bizCurrencyTransformer(getItijikngkValue()))
            .orNull();
    }

    transient private String itijikngkType = null;

    @Column(name=ITIJIKNGK + "$", nullable=true)
    protected String getItijikngkType() {
        if (itijikngkType == null && itijikngk != null) return itijikngk.getType().toString();
        if (itijikngkType == null && getItijikngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'itijikngk$' should not be NULL."));
        }
        return itijikngkType;
    }

    protected void setItijikngkType(String type) {
        itijikngkType = type;
        itijikngk = Optional.fromNullable(toCurrencyType(itijikngkType))
            .transform(bizCurrencyTransformer(getItijikngkValue()))
            .orNull();
    }

    private C_UmuKbn kyhkintaisyouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.KYHKINTAISYOUUMUKBN)
    public C_UmuKbn getKyhkintaisyouumukbn() {
        return kyhkintaisyouumukbn;
    }

    public void setKyhkintaisyouumukbn(C_UmuKbn pKyhkintaisyouumukbn) {
        kyhkintaisyouumukbn = pKyhkintaisyouumukbn;
    }

    private C_UmuKbn kdhokenkintaisyouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.KDHOKENKINTAISYOUUMUKBN)
    public C_UmuKbn getKdhokenkintaisyouumukbn() {
        return kdhokenkintaisyouumukbn;
    }

    public void setKdhokenkintaisyouumukbn(C_UmuKbn pKdhokenkintaisyouumukbn) {
        kdhokenkintaisyouumukbn = pKdhokenkintaisyouumukbn;
    }

    private C_UmuKbn pmtaisyouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.PMTAISYOUUMUKBN)
    public C_UmuKbn getPmtaisyouumukbn() {
        return pmtaisyouumukbn;
    }

    public void setPmtaisyouumukbn(C_UmuKbn pPmtaisyouumukbn) {
        pmtaisyouumukbn = pPmtaisyouumukbn;
    }

    private C_SbjiShrKbn sbjishrkbn;

    @Type(type="UserType_C_SbjiShrKbn")
    @Column(name=GenJM_SiSyouhnZokusei.SBJISHRKBN)
    public C_SbjiShrKbn getSbjishrkbn() {
        return sbjishrkbn;
    }

    public void setSbjishrkbn(C_SbjiShrKbn pSbjishrkbn) {
        sbjishrkbn = pSbjishrkbn;
    }

    private C_UmuKbn sbmensekitaisyouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.SBMENSEKITAISYOUUMUKBN)
    public C_UmuKbn getSbmensekitaisyouumukbn() {
        return sbmensekitaisyouumukbn;
    }

    public void setSbmensekitaisyouumukbn(C_UmuKbn pSbmensekitaisyouumukbn) {
        sbmensekitaisyouumukbn = pSbmensekitaisyouumukbn;
    }

    private C_UmuKbn kyhntgkkatacalcumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.KYHNTGKKATACALCUMUKBN)
    public C_UmuKbn getKyhntgkkatacalcumukbn() {
        return kyhntgkkatacalcumukbn;
    }

    public void setKyhntgkkatacalcumukbn(C_UmuKbn pKyhntgkkatacalcumukbn) {
        kyhntgkkatacalcumukbn = pKyhntgkkatacalcumukbn;
    }

    private C_UmuKbn shrsakugenkknumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.SHRSAKUGENKKNUMUKBN)
    public C_UmuKbn getShrsakugenkknumukbn() {
        return shrsakugenkknumukbn;
    }

    public void setShrsakugenkknumukbn(C_UmuKbn pShrsakugenkknumukbn) {
        shrsakugenkknumukbn = pShrsakugenkknumukbn;
    }

    private C_UmuKbn misyuumikeikadoujiumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.MISYUUMIKEIKADOUJIUMUKBN)
    public C_UmuKbn getMisyuumikeikadoujiumukbn() {
        return misyuumikeikadoujiumukbn;
    }

    public void setMisyuumikeikadoujiumukbn(C_UmuKbn pMisyuumikeikadoujiumukbn) {
        misyuumikeikadoujiumukbn = pMisyuumikeikadoujiumukbn;
    }

    private String hokenkngknitigakumsg1;

    @Column(name=GenJM_SiSyouhnZokusei.HOKENKNGKNITIGAKUMSG1)
    public String getHokenkngknitigakumsg1() {
        return hokenkngknitigakumsg1;
    }

    public void setHokenkngknitigakumsg1(String pHokenkngknitigakumsg1) {
        hokenkngknitigakumsg1 = pHokenkngknitigakumsg1;
    }

    private String hokenkngknitigakumsg2;

    @Column(name=GenJM_SiSyouhnZokusei.HOKENKNGKNITIGAKUMSG2)
    public String getHokenkngknitigakumsg2() {
        return hokenkngknitigakumsg2;
    }

    public void setHokenkngknitigakumsg2(String pHokenkngknitigakumsg2) {
        hokenkngknitigakumsg2 = pHokenkngknitigakumsg2;
    }

    private BizCurrency lnmaxkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getLnmaxkngk() {
        return lnmaxkngk;
    }

    public void setLnmaxkngk(BizCurrency pLnmaxkngk) {
        lnmaxkngk = pLnmaxkngk;
        lnmaxkngkValue = null;
        lnmaxkngkType  = null;
    }

    transient private BigDecimal lnmaxkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=LNMAXKNGK, nullable=true)
    protected BigDecimal getLnmaxkngkValue() {
        if (lnmaxkngkValue == null && lnmaxkngk != null) {
            if (lnmaxkngk.isOptional()) return null;
            return lnmaxkngk.absolute();
        }
        return lnmaxkngkValue;
    }

    protected void setLnmaxkngkValue(BigDecimal value) {
        lnmaxkngkValue = value;
        lnmaxkngk = Optional.fromNullable(toCurrencyType(lnmaxkngkType))
            .transform(bizCurrencyTransformer(getLnmaxkngkValue()))
            .orNull();
    }

    transient private String lnmaxkngkType = null;

    @Column(name=LNMAXKNGK + "$", nullable=true)
    protected String getLnmaxkngkType() {
        if (lnmaxkngkType == null && lnmaxkngk != null) return lnmaxkngk.getType().toString();
        if (lnmaxkngkType == null && getLnmaxkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'lnmaxkngk$' should not be NULL."));
        }
        return lnmaxkngkType;
    }

    protected void setLnmaxkngkType(String type) {
        lnmaxkngkType = type;
        lnmaxkngk = Optional.fromNullable(toCurrencyType(lnmaxkngkType))
            .transform(bizCurrencyTransformer(getLnmaxkngkValue()))
            .orNull();
    }

    private BizCurrency lnminkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getLnminkngk() {
        return lnminkngk;
    }

    public void setLnminkngk(BizCurrency pLnminkngk) {
        lnminkngk = pLnminkngk;
        lnminkngkValue = null;
        lnminkngkType  = null;
    }

    transient private BigDecimal lnminkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=LNMINKNGK, nullable=true)
    protected BigDecimal getLnminkngkValue() {
        if (lnminkngkValue == null && lnminkngk != null) {
            if (lnminkngk.isOptional()) return null;
            return lnminkngk.absolute();
        }
        return lnminkngkValue;
    }

    protected void setLnminkngkValue(BigDecimal value) {
        lnminkngkValue = value;
        lnminkngk = Optional.fromNullable(toCurrencyType(lnminkngkType))
            .transform(bizCurrencyTransformer(getLnminkngkValue()))
            .orNull();
    }

    transient private String lnminkngkType = null;

    @Column(name=LNMINKNGK + "$", nullable=true)
    protected String getLnminkngkType() {
        if (lnminkngkType == null && lnminkngk != null) return lnminkngk.getType().toString();
        if (lnminkngkType == null && getLnminkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'lnminkngk$' should not be NULL."));
        }
        return lnminkngkType;
    }

    protected void setLnminkngkType(String type) {
        lnminkngkType = type;
        lnminkngk = Optional.fromNullable(toCurrencyType(lnminkngkType))
            .transform(bizCurrencyTransformer(getLnminkngkValue()))
            .orNull();
    }

    private BizCurrency lnseikyuutanisenyen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getLnseikyuutanisenyen() {
        return lnseikyuutanisenyen;
    }

    public void setLnseikyuutanisenyen(BizCurrency pLnseikyuutanisenyen) {
        lnseikyuutanisenyen = pLnseikyuutanisenyen;
        lnseikyuutanisenyenValue = null;
        lnseikyuutanisenyenType  = null;
    }

    transient private BigDecimal lnseikyuutanisenyenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=LNSEIKYUUTANISENYEN, nullable=true)
    protected BigDecimal getLnseikyuutanisenyenValue() {
        if (lnseikyuutanisenyenValue == null && lnseikyuutanisenyen != null) {
            if (lnseikyuutanisenyen.isOptional()) return null;
            return lnseikyuutanisenyen.absolute();
        }
        return lnseikyuutanisenyenValue;
    }

    protected void setLnseikyuutanisenyenValue(BigDecimal value) {
        lnseikyuutanisenyenValue = value;
        lnseikyuutanisenyen = Optional.fromNullable(toCurrencyType(lnseikyuutanisenyenType))
            .transform(bizCurrencyTransformer(getLnseikyuutanisenyenValue()))
            .orNull();
    }

    transient private String lnseikyuutanisenyenType = null;

    @Column(name=LNSEIKYUUTANISENYEN + "$", nullable=true)
    protected String getLnseikyuutanisenyenType() {
        if (lnseikyuutanisenyenType == null && lnseikyuutanisenyen != null) return lnseikyuutanisenyen.getType().toString();
        if (lnseikyuutanisenyenType == null && getLnseikyuutanisenyenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'lnseikyuutanisenyen$' should not be NULL."));
        }
        return lnseikyuutanisenyenType;
    }

    protected void setLnseikyuutanisenyenType(String type) {
        lnseikyuutanisenyenType = type;
        lnseikyuutanisenyen = Optional.fromNullable(toCurrencyType(lnseikyuutanisenyenType))
            .transform(bizCurrencyTransformer(getLnseikyuutanisenyenValue()))
            .orNull();
    }

    private C_UmuKbn calckijyunmiraibicheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.CALCKIJYUNMIRAIBICHECK)
    public C_UmuKbn getCalckijyunmiraibicheck() {
        return calckijyunmiraibicheck;
    }

    public void setCalckijyunmiraibicheck(C_UmuKbn pCalckijyunmiraibicheck) {
        calckijyunmiraibicheck = pCalckijyunmiraibicheck;
    }

    private C_UmuKbn psoutougkhyoujiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.PSOUTOUGKHYOUJIUMU)
    public C_UmuKbn getPsoutougkhyoujiumu() {
        return psoutougkhyoujiumu;
    }

    public void setPsoutougkhyoujiumu(C_UmuKbn pPsoutougkhyoujiumu) {
        psoutougkhyoujiumu = pPsoutougkhyoujiumu;
    }

    private C_UmuKbn tmttkngkhyoujiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.TMTTKNGKHYOUJIUMU)
    public C_UmuKbn getTmttkngkhyoujiumu() {
        return tmttkngkhyoujiumu;
    }

    public void setTmttkngkhyoujiumu(C_UmuKbn pTmttkngkhyoujiumu) {
        tmttkngkhyoujiumu = pTmttkngkhyoujiumu;
    }

    private C_UmuKbn kaiyakuhrhyoujiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.KAIYAKUHRHYOUJIUMU)
    public C_UmuKbn getKaiyakuhrhyoujiumu() {
        return kaiyakuhrhyoujiumu;
    }

    public void setKaiyakuhrhyoujiumu(C_UmuKbn pKaiyakuhrhyoujiumu) {
        kaiyakuhrhyoujiumu = pKaiyakuhrhyoujiumu;
    }

    private C_UmuKbn kihonshyoujiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.KIHONSHYOUJIUMU)
    public C_UmuKbn getKihonshyoujiumu() {
        return kihonshyoujiumu;
    }

    public void setKihonshyoujiumu(C_UmuKbn pKihonshyoujiumu) {
        kihonshyoujiumu = pKihonshyoujiumu;
    }

    private C_UmuKbn saigaishyoujiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SiSyouhnZokusei.SAIGAISHYOUJIUMU)
    public C_UmuKbn getSaigaishyoujiumu() {
        return saigaishyoujiumu;
    }

    public void setSaigaishyoujiumu(C_UmuKbn pSaigaishyoujiumu) {
        saigaishyoujiumu = pSaigaishyoujiumu;
    }

    private C_SeisankinKanritukaKbn msyupknrtuukakbn;

    @Type(type="UserType_C_SeisankinKanritukaKbn")
    @Column(name=GenJM_SiSyouhnZokusei.MSYUPKNRTUUKAKBN)
    public C_SeisankinKanritukaKbn getMsyupknrtuukakbn() {
        return msyupknrtuukakbn;
    }

    public void setMsyupknrtuukakbn(C_SeisankinKanritukaKbn pMsyupknrtuukakbn) {
        msyupknrtuukakbn = pMsyupknrtuukakbn;
    }

    private C_SeisankinKanritukaKbn mikeikapknrtuukakbn;

    @Type(type="UserType_C_SeisankinKanritukaKbn")
    @Column(name=GenJM_SiSyouhnZokusei.MIKEIKAPKNRTUUKAKBN)
    public C_SeisankinKanritukaKbn getMikeikapknrtuukakbn() {
        return mikeikapknrtuukakbn;
    }

    public void setMikeikapknrtuukakbn(C_SeisankinKanritukaKbn pMikeikapknrtuukakbn) {
        mikeikapknrtuukakbn = pMikeikapknrtuukakbn;
    }

    private C_SeisankinKanritukaKbn znnusisnkinknrtuukakbn;

    @Type(type="UserType_C_SeisankinKanritukaKbn")
    @Column(name=GenJM_SiSyouhnZokusei.ZNNUSISNKINKNRTUUKAKBN)
    public C_SeisankinKanritukaKbn getZnnusisnkinknrtuukakbn() {
        return znnusisnkinknrtuukakbn;
    }

    public void setZnnusisnkinknrtuukakbn(C_SeisankinKanritukaKbn pZnnusisnkinknrtuukakbn) {
        znnusisnkinknrtuukakbn = pZnnusisnkinknrtuukakbn;
    }

    private C_SeisankinKanritukaKbn krkinknrtuukakbn;

    @Type(type="UserType_C_SeisankinKanritukaKbn")
    @Column(name=GenJM_SiSyouhnZokusei.KRKINKNRTUUKAKBN)
    public C_SeisankinKanritukaKbn getKrkinknrtuukakbn() {
        return krkinknrtuukakbn;
    }

    public void setKrkinknrtuukakbn(C_SeisankinKanritukaKbn pKrkinknrtuukakbn) {
        krkinknrtuukakbn = pKrkinknrtuukakbn;
    }
}
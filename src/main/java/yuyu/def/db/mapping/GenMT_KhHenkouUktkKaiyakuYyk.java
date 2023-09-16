package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.MT_KhHenkouUktkKaiyakuYyk;
import yuyu.def.db.id.PKMT_KhHenkouUktkKaiyakuYyk;
import yuyu.def.db.meta.GenQMT_KhHenkouUktkKaiyakuYyk;
import yuyu.def.db.meta.QMT_KhHenkouUktkKaiyakuYyk;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全変更受付内容（解約）予約テーブル テーブルのマッピング情報クラスで、 {@link MT_KhHenkouUktkKaiyakuYyk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_KhHenkouUktkKaiyakuYyk}</td><td colspan="3">契約保全変更受付内容（解約）予約テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKMT_KhHenkouUktkKaiyakuYyk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKMT_KhHenkouUktkKaiyakuYyk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHozenhenkouuktkrenno hozenhenkouuktkrenno}</td><td>保全変更受付連番</td><td align="center">{@link PKMT_KhHenkouUktkKaiyakuYyk ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getInputshrhousiteikbn inputshrhousiteikbn}</td><td>入力用支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_InputShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getYenshrtkhkumu yenshrtkhkumu}</td><td>円支払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzdoukbn kzdoukbn}</td><td>口座名義人同一区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kzdou}</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_KhHenkouUktkKaiyakuYyk
 * @see     PKMT_KhHenkouUktkKaiyakuYyk
 * @see     QMT_KhHenkouUktkKaiyakuYyk
 * @see     GenQMT_KhHenkouUktkKaiyakuYyk
 */
@MappedSuperclass
@Table(name=GenMT_KhHenkouUktkKaiyakuYyk.TABLE_NAME)
@IdClass(value=PKMT_KhHenkouUktkKaiyakuYyk.class)
@TypeDefs({
    @TypeDef(name="UserType_C_InputShrhousiteiKbn", typeClass=UserType_C_InputShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_Kzdou", typeClass=UserType_C_Kzdou.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenMT_KhHenkouUktkKaiyakuYyk extends AbstractExDBEntity<MT_KhHenkouUktkKaiyakuYyk, PKMT_KhHenkouUktkKaiyakuYyk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_KhHenkouUktkKaiyakuYyk";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HOZENHENKOUUKTKRENNO     = "hozenhenkouuktkrenno";
    public static final String INPUTSHRHOUSITEIKBN      = "inputshrhousiteikbn";
    public static final String YENSHRTKHKUMU            = "yenshrtkhkumu";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZDOUKBN                 = "kzdoukbn";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_KhHenkouUktkKaiyakuYyk primaryKey;

    public GenMT_KhHenkouUktkKaiyakuYyk() {
        primaryKey = new PKMT_KhHenkouUktkKaiyakuYyk();
    }

    public GenMT_KhHenkouUktkKaiyakuYyk(
        String pKbnkey,
        String pSyono,
        Integer pHozenhenkouuktkrenno
    ) {
        primaryKey = new PKMT_KhHenkouUktkKaiyakuYyk(
            pKbnkey,
            pSyono,
            pHozenhenkouuktkrenno
        );
    }

    @Transient
    @Override
    public PKMT_KhHenkouUktkKaiyakuYyk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_KhHenkouUktkKaiyakuYyk> getMetaClass() {
        return QMT_KhHenkouUktkKaiyakuYyk.class;
    }

    @Id
    @Column(name=GenMT_KhHenkouUktkKaiyakuYyk.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenMT_KhHenkouUktkKaiyakuYyk.SYONO)
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
    @Column(name=GenMT_KhHenkouUktkKaiyakuYyk.HOZENHENKOUUKTKRENNO)
    public Integer getHozenhenkouuktkrenno() {
        return getPrimaryKey().getHozenhenkouuktkrenno();
    }

    public void setHozenhenkouuktkrenno(Integer pHozenhenkouuktkrenno) {
        getPrimaryKey().setHozenhenkouuktkrenno(pHozenhenkouuktkrenno);
    }

    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    @Type(type="UserType_C_InputShrhousiteiKbn")
    @Column(name=GenMT_KhHenkouUktkKaiyakuYyk.INPUTSHRHOUSITEIKBN)
    public C_InputShrhousiteiKbn getInputshrhousiteikbn() {
        return inputshrhousiteikbn;
    }

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn) {
        inputshrhousiteikbn = pInputshrhousiteikbn;
    }

    private C_UmuKbn yenshrtkhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenMT_KhHenkouUktkKaiyakuYyk.YENSHRTKHKUMU)
    public C_UmuKbn getYenshrtkhkumu() {
        return yenshrtkhkumu;
    }

    public void setYenshrtkhkumu(C_UmuKbn pYenshrtkhkumu) {
        yenshrtkhkumu = pYenshrtkhkumu;
    }

    private String bankcd;

    @Column(name=GenMT_KhHenkouUktkKaiyakuYyk.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private String sitencd;

    @Column(name=GenMT_KhHenkouUktkKaiyakuYyk.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenMT_KhHenkouUktkKaiyakuYyk.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenMT_KhHenkouUktkKaiyakuYyk.KOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private C_Kzdou kzdoukbn;

    @Type(type="UserType_C_Kzdou")
    @Column(name=GenMT_KhHenkouUktkKaiyakuYyk.KZDOUKBN)
    public C_Kzdou getKzdoukbn() {
        return kzdoukbn;
    }

    public void setKzdoukbn(C_Kzdou pKzdoukbn) {
        kzdoukbn = pKzdoukbn;
    }

    private String kzmeiginmkn;

    @Column(name=GenMT_KhHenkouUktkKaiyakuYyk.KZMEIGINMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_KhHenkouUktkKaiyakuYyk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_KhHenkouUktkKaiyakuYyk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_KhHenkouUktkKaiyakuYyk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
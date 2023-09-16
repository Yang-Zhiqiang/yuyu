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
import yuyu.def.classification.C_DsTrhkserviceKanyukeiroKbn;
import yuyu.def.classification.C_DsTtdksyubetuKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_TrksriyuuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.MT_DsTourokuUkKouzaAnsyono;
import yuyu.def.db.id.PKMT_DsTourokuUkKouzaAnsyono;
import yuyu.def.db.meta.GenQMT_DsTourokuUkKouzaAnsyono;
import yuyu.def.db.meta.QMT_DsTourokuUkKouzaAnsyono;
import yuyu.def.db.type.UserType_C_DsTrhkserviceKanyukeiroKbn;
import yuyu.def.db.type.UserType_C_DsTtdksyubetuKbn;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_TrksriyuuKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳ登録受付（口座暗証番号）テーブル テーブルのマッピング情報クラスで、 {@link MT_DsTourokuUkKouzaAnsyono} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsTourokuUkKouzaAnsyono}</td><td colspan="3">ＤＳ登録受付（口座暗証番号）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKMT_DsTourokuUkKouzaAnsyono ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsttdksyubetukbn dsttdksyubetukbn}</td><td>ＤＳ手続種別区分</td><td align="center">{@link PKMT_DsTourokuUkKouzaAnsyono ○}</td><td align="center">V</td><td>{@link C_DsTtdksyubetuKbn}</td></tr>
 *  <tr><td>{@link #getDatarenno datarenno}</td><td>データ連番</td><td align="center">{@link PKMT_DsTourokuUkKouzaAnsyono ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKzsyuruikbn kzsyuruikbn}</td><td>口座種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KouzasyuruiKbn}</td></tr>
 *  <tr><td>{@link #getSoukinkzyennrkumu soukinkzyennrkumu}</td><td>送金用口座（円貨）入力有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTokuteitrhkansyononrkumu tokuteitrhkansyononrkumu}</td><td>特定取引用暗証番号入力有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getDstrhkserviceknykeironrumu dstrhkserviceknykeironrumu}</td><td>ＤＳ取引サービス加入経路入力有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzdoukbn kzdoukbn}</td><td>口座名義人同一区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kzdou}</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTokuteitrhkansyono tokuteitrhkansyono}</td><td>特定取引用暗証番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrksriyuukbn trksriyuukbn}</td><td>取消理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TrksriyuuKbn}</td></tr>
 *  <tr><td>{@link #getDstrhkservicekanyukeirokbn dstrhkservicekanyukeirokbn}</td><td>ＤＳ取引サービス加入経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsTrhkserviceKanyukeiroKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsTourokuUkKouzaAnsyono
 * @see     PKMT_DsTourokuUkKouzaAnsyono
 * @see     QMT_DsTourokuUkKouzaAnsyono
 * @see     GenQMT_DsTourokuUkKouzaAnsyono
 */
@MappedSuperclass
@Table(name=GenMT_DsTourokuUkKouzaAnsyono.TABLE_NAME)
@IdClass(value=PKMT_DsTourokuUkKouzaAnsyono.class)
@TypeDefs({
    @TypeDef(name="UserType_C_DsTrhkserviceKanyukeiroKbn", typeClass=UserType_C_DsTrhkserviceKanyukeiroKbn.class),
    @TypeDef(name="UserType_C_DsTtdksyubetuKbn", typeClass=UserType_C_DsTtdksyubetuKbn.class),
    @TypeDef(name="UserType_C_KouzasyuruiKbn", typeClass=UserType_C_KouzasyuruiKbn.class),
    @TypeDef(name="UserType_C_Kzdou", typeClass=UserType_C_Kzdou.class),
    @TypeDef(name="UserType_C_TrksriyuuKbn", typeClass=UserType_C_TrksriyuuKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenMT_DsTourokuUkKouzaAnsyono extends AbstractExDBEntity<MT_DsTourokuUkKouzaAnsyono, PKMT_DsTourokuUkKouzaAnsyono> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsTourokuUkKouzaAnsyono";
    public static final String SYONO                    = "syono";
    public static final String DSTTDKSYUBETUKBN         = "dsttdksyubetukbn";
    public static final String DATARENNO                = "datarenno";
    public static final String KZSYURUIKBN              = "kzsyuruikbn";
    public static final String SOUKINKZYENNRKUMU        = "soukinkzyennrkumu";
    public static final String TOKUTEITRHKANSYONONRKUMU = "tokuteitrhkansyononrkumu";
    public static final String DSTRHKSERVICEKNYKEIRONRUMU = "dstrhkserviceknykeironrumu";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZDOUKBN                 = "kzdoukbn";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String TOKUTEITRHKANSYONO       = "tokuteitrhkansyono";
    public static final String TRKSRIYUUKBN             = "trksriyuukbn";
    public static final String DSTRHKSERVICEKANYUKEIROKBN = "dstrhkservicekanyukeirokbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_DsTourokuUkKouzaAnsyono primaryKey;

    public GenMT_DsTourokuUkKouzaAnsyono() {
        primaryKey = new PKMT_DsTourokuUkKouzaAnsyono();
    }

    public GenMT_DsTourokuUkKouzaAnsyono(
        String pSyono,
        C_DsTtdksyubetuKbn pDsttdksyubetukbn,
        Integer pDatarenno
    ) {
        primaryKey = new PKMT_DsTourokuUkKouzaAnsyono(
            pSyono,
            pDsttdksyubetukbn,
            pDatarenno
        );
    }

    @Transient
    @Override
    public PKMT_DsTourokuUkKouzaAnsyono getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsTourokuUkKouzaAnsyono> getMetaClass() {
        return QMT_DsTourokuUkKouzaAnsyono.class;
    }

    @Id
    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.SYONO)
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
    @Type(type="UserType_C_DsTtdksyubetuKbn")
    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.DSTTDKSYUBETUKBN)
    public C_DsTtdksyubetuKbn getDsttdksyubetukbn() {
        return getPrimaryKey().getDsttdksyubetukbn();
    }

    public void setDsttdksyubetukbn(C_DsTtdksyubetuKbn pDsttdksyubetukbn) {
        getPrimaryKey().setDsttdksyubetukbn(pDsttdksyubetukbn);
    }

    @Id
    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.DATARENNO)
    public Integer getDatarenno() {
        return getPrimaryKey().getDatarenno();
    }

    public void setDatarenno(Integer pDatarenno) {
        getPrimaryKey().setDatarenno(pDatarenno);
    }

    private C_KouzasyuruiKbn kzsyuruikbn;

    @Type(type="UserType_C_KouzasyuruiKbn")
    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.KZSYURUIKBN)
    public C_KouzasyuruiKbn getKzsyuruikbn() {
        return kzsyuruikbn;
    }

    public void setKzsyuruikbn(C_KouzasyuruiKbn pKzsyuruikbn) {
        kzsyuruikbn = pKzsyuruikbn;
    }

    private C_UmuKbn soukinkzyennrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.SOUKINKZYENNRKUMU)
    public C_UmuKbn getSoukinkzyennrkumu() {
        return soukinkzyennrkumu;
    }

    public void setSoukinkzyennrkumu(C_UmuKbn pSoukinkzyennrkumu) {
        soukinkzyennrkumu = pSoukinkzyennrkumu;
    }

    private C_UmuKbn tokuteitrhkansyononrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.TOKUTEITRHKANSYONONRKUMU)
    public C_UmuKbn getTokuteitrhkansyononrkumu() {
        return tokuteitrhkansyononrkumu;
    }

    public void setTokuteitrhkansyononrkumu(C_UmuKbn pTokuteitrhkansyononrkumu) {
        tokuteitrhkansyononrkumu = pTokuteitrhkansyononrkumu;
    }

    private C_UmuKbn dstrhkserviceknykeironrumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.DSTRHKSERVICEKNYKEIRONRUMU)
    public C_UmuKbn getDstrhkserviceknykeironrumu() {
        return dstrhkserviceknykeironrumu;
    }

    public void setDstrhkserviceknykeironrumu(C_UmuKbn pDstrhkserviceknykeironrumu) {
        dstrhkserviceknykeironrumu = pDstrhkserviceknykeironrumu;
    }

    private String bankcd;

    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.BANKCD)
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

    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.SITENCD)
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
    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.KOUZANO)
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
    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.KZDOUKBN)
    public C_Kzdou getKzdoukbn() {
        return kzdoukbn;
    }

    public void setKzdoukbn(C_Kzdou pKzdoukbn) {
        kzdoukbn = pKzdoukbn;
    }

    private String kzmeiginmkn;

    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.KZMEIGINMKN)
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

    private String tokuteitrhkansyono;

    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.TOKUTEITRHKANSYONO)
    public String getTokuteitrhkansyono() {
        return tokuteitrhkansyono;
    }

    public void setTokuteitrhkansyono(String pTokuteitrhkansyono) {
        tokuteitrhkansyono = pTokuteitrhkansyono;
    }

    private C_TrksriyuuKbn trksriyuukbn;

    @Type(type="UserType_C_TrksriyuuKbn")
    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.TRKSRIYUUKBN)
    public C_TrksriyuuKbn getTrksriyuukbn() {
        return trksriyuukbn;
    }

    public void setTrksriyuukbn(C_TrksriyuuKbn pTrksriyuukbn) {
        trksriyuukbn = pTrksriyuukbn;
    }

    private C_DsTrhkserviceKanyukeiroKbn dstrhkservicekanyukeirokbn;

    @Type(type="UserType_C_DsTrhkserviceKanyukeiroKbn")
    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.DSTRHKSERVICEKANYUKEIROKBN)
    public C_DsTrhkserviceKanyukeiroKbn getDstrhkservicekanyukeirokbn() {
        return dstrhkservicekanyukeirokbn;
    }

    public void setDstrhkservicekanyukeirokbn(C_DsTrhkserviceKanyukeiroKbn pDstrhkservicekanyukeirokbn) {
        dstrhkservicekanyukeirokbn = pDstrhkservicekanyukeirokbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsTourokuUkKouzaAnsyono.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
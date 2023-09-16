package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_NayoseJyoutaiKbn;
import yuyu.def.classification.C_SirajiKykKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.HT_NayoseKekka;
import yuyu.def.db.id.PKHT_NayoseKekka;
import yuyu.def.db.meta.GenQHT_NayoseKekka;
import yuyu.def.db.meta.QHT_NayoseKekka;
import yuyu.def.db.type.UserType_C_BlnktkumuKbn;
import yuyu.def.db.type.UserType_C_MQSyoukaiErrorKbn;
import yuyu.def.db.type.UserType_C_NayoseJissiKekkaKbn;
import yuyu.def.db.type.UserType_C_NayoseJyoutaiKbn;
import yuyu.def.db.type.UserType_C_SirajiKykKbn;
import yuyu.def.db.type.UserType_C_SntkInfoTaisyousyaKbn;
import yuyu.def.db.type.UserType_C_YouhiblnkKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 名寄せ結果テーブル テーブルのマッピング情報クラスで、 {@link HT_NayoseKekka} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_NayoseKekka}</td><td colspan="3">名寄せ結果テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_NayoseKekka ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSntkinfotaisyousyakbn sntkinfotaisyousyakbn}</td><td>選択情報対象者区分</td><td align="center">{@link PKHT_NayoseKekka ○}</td><td align="center">V</td><td>{@link C_SntkInfoTaisyousyaKbn}</td></tr>
 *  <tr><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">{@link PKHT_NayoseKekka ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSakuinnmno sakuinnmno}</td><td>索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNysjissikekkakbn nysjissikekkakbn}</td><td>名寄せ実施結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NayoseJissiKekkaKbn}</td></tr>
 *  <tr><td>{@link #getNysjyoutaikbn nysjyoutaikbn}</td><td>名寄せ状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NayoseJyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getSakuininfosyoukaierrkbn sakuininfosyoukaierrkbn}</td><td>索引情報照会エラー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MQSyoukaiErrorKbn}</td></tr>
 *  <tr><td>{@link #getMrsyoukaierrkbn mrsyoukaierrkbn}</td><td>ＭＲ照会エラー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MQSyoukaiErrorKbn}</td></tr>
 *  <tr><td>{@link #getSignalsyoukaierrkbn signalsyoukaierrkbn}</td><td>シグナル照会エラー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MQSyoukaiErrorKbn}</td></tr>
 *  <tr><td>{@link #getSinsntkhnsysyoukaierrkbn sinsntkhnsysyoukaierrkbn}</td><td>新選択情報反社照会エラー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MQSyoukaiErrorKbn}</td></tr>
 *  <tr><td>{@link #getTsngksyoukaierrkbn tsngksyoukaierrkbn}</td><td>通算金額照会エラー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MQSyoukaiErrorKbn}</td></tr>
 *  <tr><td>{@link #getKykdrtentsnssyoukaierrkbn kykdrtentsnssyoukaierrkbn}</td><td>契約者同一代理店通算Ｓ照会エラー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MQSyoukaiErrorKbn}</td></tr>
 *  <tr><td>{@link #getMossakuseikahisyoukaierrkbn mossakuseikahisyoukaierrkbn}</td><td>申込書作成可否照会エラー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MQSyoukaiErrorKbn}</td></tr>
 *  <tr><td>{@link #getHndketyhsyoukaierrkbn hndketyhsyoukaierrkbn}</td><td>ハンド決定要否照会エラー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MQSyoukaiErrorKbn}</td></tr>
 *  <tr><td>{@link #getSntkinfomrumukbn sntkinfomrumukbn}</td><td>選択情報ＭＲ有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getSntkinfohnsyumukbn sntkinfohnsyumukbn}</td><td>選択情報反社有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getSignalsetteiumukbn signalsetteiumukbn}</td><td>シグナル設定有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getSignalinfohnsyumukbn signalinfohnsyumukbn}</td><td>シグナル情報反社有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getGaikokupepsumukbn gaikokupepsumukbn}</td><td>外国ＰＥＰｓ有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getSinsntkhnsyumukbn sinsntkhnsyumukbn}</td><td>新選択情報反社有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getItekisntkhndktyhkbn itekisntkhndktyhkbn}</td><td>医的選択情報ハンド決定要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiblnkKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuiknkhndktyhkbn ttdktyuuiknkhndktyhkbn}</td><td>手続注意環境ハンド決定要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiblnkKbn}</td></tr>
 *  <tr><td>{@link #getKyhkinuktkariitkhndktyhkbn kyhkinuktkariitkhndktyhkbn}</td><td>給付金受付有医的ハンド決定要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiblnkKbn}</td></tr>
 *  <tr><td>{@link #getDoujimositekihndktyhkbn doujimositekihndktyhkbn}</td><td>同時申込医的ハンド決定要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiblnkKbn}</td></tr>
 *  <tr><td>{@link #getDoujimosknkhndktyhkbn doujimosknkhndktyhkbn}</td><td>同時申込環境ハンド決定要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiblnkKbn}</td></tr>
 *  <tr><td>{@link #getSirajikykkbn sirajikykkbn}</td><td>白地契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SirajiKykKbn}</td></tr>
 *  <tr><td>{@link #getKikykinfoseiymd kikykinfoseiymd}</td><td>既契約情報生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_NayoseKekka
 * @see     PKHT_NayoseKekka
 * @see     QHT_NayoseKekka
 * @see     GenQHT_NayoseKekka
 */
@MappedSuperclass
@Table(name=GenHT_NayoseKekka.TABLE_NAME)
@IdClass(value=PKHT_NayoseKekka.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_BlnktkumuKbn", typeClass=UserType_C_BlnktkumuKbn.class),
    @TypeDef(name="UserType_C_MQSyoukaiErrorKbn", typeClass=UserType_C_MQSyoukaiErrorKbn.class),
    @TypeDef(name="UserType_C_NayoseJissiKekkaKbn", typeClass=UserType_C_NayoseJissiKekkaKbn.class),
    @TypeDef(name="UserType_C_NayoseJyoutaiKbn", typeClass=UserType_C_NayoseJyoutaiKbn.class),
    @TypeDef(name="UserType_C_SirajiKykKbn", typeClass=UserType_C_SirajiKykKbn.class),
    @TypeDef(name="UserType_C_SntkInfoTaisyousyaKbn", typeClass=UserType_C_SntkInfoTaisyousyaKbn.class),
    @TypeDef(name="UserType_C_YouhiblnkKbn", typeClass=UserType_C_YouhiblnkKbn.class)
})
public abstract class GenHT_NayoseKekka extends AbstractExDBEntity<HT_NayoseKekka, PKHT_NayoseKekka> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_NayoseKekka";
    public static final String MOSNO                    = "mosno";
    public static final String SNTKINFOTAISYOUSYAKBN    = "sntkinfotaisyousyakbn";
    public static final String EDANO                    = "edano";
    public static final String SAKUINNMNO               = "sakuinnmno";
    public static final String NYSJISSIKEKKAKBN         = "nysjissikekkakbn";
    public static final String NYSJYOUTAIKBN            = "nysjyoutaikbn";
    public static final String SAKUININFOSYOUKAIERRKBN  = "sakuininfosyoukaierrkbn";
    public static final String MRSYOUKAIERRKBN          = "mrsyoukaierrkbn";
    public static final String SIGNALSYOUKAIERRKBN      = "signalsyoukaierrkbn";
    public static final String SINSNTKHNSYSYOUKAIERRKBN = "sinsntkhnsysyoukaierrkbn";
    public static final String TSNGKSYOUKAIERRKBN       = "tsngksyoukaierrkbn";
    public static final String KYKDRTENTSNSSYOUKAIERRKBN = "kykdrtentsnssyoukaierrkbn";
    public static final String MOSSAKUSEIKAHISYOUKAIERRKBN = "mossakuseikahisyoukaierrkbn";
    public static final String HNDKETYHSYOUKAIERRKBN    = "hndketyhsyoukaierrkbn";
    public static final String SNTKINFOMRUMUKBN         = "sntkinfomrumukbn";
    public static final String SNTKINFOHNSYUMUKBN       = "sntkinfohnsyumukbn";
    public static final String SIGNALSETTEIUMUKBN       = "signalsetteiumukbn";
    public static final String SIGNALINFOHNSYUMUKBN     = "signalinfohnsyumukbn";
    public static final String GAIKOKUPEPSUMUKBN        = "gaikokupepsumukbn";
    public static final String SINSNTKHNSYUMUKBN        = "sinsntkhnsyumukbn";
    public static final String ITEKISNTKHNDKTYHKBN      = "itekisntkhndktyhkbn";
    public static final String TTDKTYUUIKNKHNDKTYHKBN   = "ttdktyuuiknkhndktyhkbn";
    public static final String KYHKINUKTKARIITKHNDKTYHKBN = "kyhkinuktkariitkhndktyhkbn";
    public static final String DOUJIMOSITEKIHNDKTYHKBN  = "doujimositekihndktyhkbn";
    public static final String DOUJIMOSKNKHNDKTYHKBN    = "doujimosknkhndktyhkbn";
    public static final String SIRAJIKYKKBN             = "sirajikykkbn";
    public static final String KIKYKINFOSEIYMD          = "kikykinfoseiymd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_NayoseKekka primaryKey;

    public GenHT_NayoseKekka() {
        primaryKey = new PKHT_NayoseKekka();
    }

    public GenHT_NayoseKekka(
        String pMosno,
        C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn,
        Integer pEdano
    ) {
        primaryKey = new PKHT_NayoseKekka(
            pMosno,
            pSntkinfotaisyousyakbn,
            pEdano
        );
    }

    @Transient
    @Override
    public PKHT_NayoseKekka getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_NayoseKekka> getMetaClass() {
        return QHT_NayoseKekka.class;
    }

    @Id
    @Column(name=GenHT_NayoseKekka.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    @Id
    @Type(type="UserType_C_SntkInfoTaisyousyaKbn")
    @Column(name=GenHT_NayoseKekka.SNTKINFOTAISYOUSYAKBN)
    public C_SntkInfoTaisyousyaKbn getSntkinfotaisyousyakbn() {
        return getPrimaryKey().getSntkinfotaisyousyakbn();
    }

    public void setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn) {
        getPrimaryKey().setSntkinfotaisyousyakbn(pSntkinfotaisyousyakbn);
    }

    @Id
    @Column(name=GenHT_NayoseKekka.EDANO)
    public Integer getEdano() {
        return getPrimaryKey().getEdano();
    }

    public void setEdano(Integer pEdano) {
        getPrimaryKey().setEdano(pEdano);
    }

    private String sakuinnmno;

    @Column(name=GenHT_NayoseKekka.SAKUINNMNO)
    public String getSakuinnmno() {
        return sakuinnmno;
    }

    public void setSakuinnmno(String pSakuinnmno) {
        sakuinnmno = pSakuinnmno;
    }

    private C_NayoseJissiKekkaKbn nysjissikekkakbn;

    @Type(type="UserType_C_NayoseJissiKekkaKbn")
    @Column(name=GenHT_NayoseKekka.NYSJISSIKEKKAKBN)
    public C_NayoseJissiKekkaKbn getNysjissikekkakbn() {
        return nysjissikekkakbn;
    }

    public void setNysjissikekkakbn(C_NayoseJissiKekkaKbn pNysjissikekkakbn) {
        nysjissikekkakbn = pNysjissikekkakbn;
    }

    private C_NayoseJyoutaiKbn nysjyoutaikbn;

    @Type(type="UserType_C_NayoseJyoutaiKbn")
    @Column(name=GenHT_NayoseKekka.NYSJYOUTAIKBN)
    public C_NayoseJyoutaiKbn getNysjyoutaikbn() {
        return nysjyoutaikbn;
    }

    public void setNysjyoutaikbn(C_NayoseJyoutaiKbn pNysjyoutaikbn) {
        nysjyoutaikbn = pNysjyoutaikbn;
    }

    private C_MQSyoukaiErrorKbn sakuininfosyoukaierrkbn;

    @Type(type="UserType_C_MQSyoukaiErrorKbn")
    @Column(name=GenHT_NayoseKekka.SAKUININFOSYOUKAIERRKBN)
    public C_MQSyoukaiErrorKbn getSakuininfosyoukaierrkbn() {
        return sakuininfosyoukaierrkbn;
    }

    public void setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn pSakuininfosyoukaierrkbn) {
        sakuininfosyoukaierrkbn = pSakuininfosyoukaierrkbn;
    }

    private C_MQSyoukaiErrorKbn mrsyoukaierrkbn;

    @Type(type="UserType_C_MQSyoukaiErrorKbn")
    @Column(name=GenHT_NayoseKekka.MRSYOUKAIERRKBN)
    public C_MQSyoukaiErrorKbn getMrsyoukaierrkbn() {
        return mrsyoukaierrkbn;
    }

    public void setMrsyoukaierrkbn(C_MQSyoukaiErrorKbn pMrsyoukaierrkbn) {
        mrsyoukaierrkbn = pMrsyoukaierrkbn;
    }

    private C_MQSyoukaiErrorKbn signalsyoukaierrkbn;

    @Type(type="UserType_C_MQSyoukaiErrorKbn")
    @Column(name=GenHT_NayoseKekka.SIGNALSYOUKAIERRKBN)
    public C_MQSyoukaiErrorKbn getSignalsyoukaierrkbn() {
        return signalsyoukaierrkbn;
    }

    public void setSignalsyoukaierrkbn(C_MQSyoukaiErrorKbn pSignalsyoukaierrkbn) {
        signalsyoukaierrkbn = pSignalsyoukaierrkbn;
    }

    private C_MQSyoukaiErrorKbn sinsntkhnsysyoukaierrkbn;

    @Type(type="UserType_C_MQSyoukaiErrorKbn")
    @Column(name=GenHT_NayoseKekka.SINSNTKHNSYSYOUKAIERRKBN)
    public C_MQSyoukaiErrorKbn getSinsntkhnsysyoukaierrkbn() {
        return sinsntkhnsysyoukaierrkbn;
    }

    public void setSinsntkhnsysyoukaierrkbn(C_MQSyoukaiErrorKbn pSinsntkhnsysyoukaierrkbn) {
        sinsntkhnsysyoukaierrkbn = pSinsntkhnsysyoukaierrkbn;
    }

    private C_MQSyoukaiErrorKbn tsngksyoukaierrkbn;

    @Type(type="UserType_C_MQSyoukaiErrorKbn")
    @Column(name=GenHT_NayoseKekka.TSNGKSYOUKAIERRKBN)
    public C_MQSyoukaiErrorKbn getTsngksyoukaierrkbn() {
        return tsngksyoukaierrkbn;
    }

    public void setTsngksyoukaierrkbn(C_MQSyoukaiErrorKbn pTsngksyoukaierrkbn) {
        tsngksyoukaierrkbn = pTsngksyoukaierrkbn;
    }

    private C_MQSyoukaiErrorKbn kykdrtentsnssyoukaierrkbn;

    @Type(type="UserType_C_MQSyoukaiErrorKbn")
    @Column(name=GenHT_NayoseKekka.KYKDRTENTSNSSYOUKAIERRKBN)
    public C_MQSyoukaiErrorKbn getKykdrtentsnssyoukaierrkbn() {
        return kykdrtentsnssyoukaierrkbn;
    }

    public void setKykdrtentsnssyoukaierrkbn(C_MQSyoukaiErrorKbn pKykdrtentsnssyoukaierrkbn) {
        kykdrtentsnssyoukaierrkbn = pKykdrtentsnssyoukaierrkbn;
    }

    private C_MQSyoukaiErrorKbn mossakuseikahisyoukaierrkbn;

    @Type(type="UserType_C_MQSyoukaiErrorKbn")
    @Column(name=GenHT_NayoseKekka.MOSSAKUSEIKAHISYOUKAIERRKBN)
    public C_MQSyoukaiErrorKbn getMossakuseikahisyoukaierrkbn() {
        return mossakuseikahisyoukaierrkbn;
    }

    public void setMossakuseikahisyoukaierrkbn(C_MQSyoukaiErrorKbn pMossakuseikahisyoukaierrkbn) {
        mossakuseikahisyoukaierrkbn = pMossakuseikahisyoukaierrkbn;
    }

    private C_MQSyoukaiErrorKbn hndketyhsyoukaierrkbn;

    @Type(type="UserType_C_MQSyoukaiErrorKbn")
    @Column(name=GenHT_NayoseKekka.HNDKETYHSYOUKAIERRKBN)
    public C_MQSyoukaiErrorKbn getHndketyhsyoukaierrkbn() {
        return hndketyhsyoukaierrkbn;
    }

    public void setHndketyhsyoukaierrkbn(C_MQSyoukaiErrorKbn pHndketyhsyoukaierrkbn) {
        hndketyhsyoukaierrkbn = pHndketyhsyoukaierrkbn;
    }

    private C_BlnktkumuKbn sntkinfomrumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_NayoseKekka.SNTKINFOMRUMUKBN)
    public C_BlnktkumuKbn getSntkinfomrumukbn() {
        return sntkinfomrumukbn;
    }

    public void setSntkinfomrumukbn(C_BlnktkumuKbn pSntkinfomrumukbn) {
        sntkinfomrumukbn = pSntkinfomrumukbn;
    }

    private C_BlnktkumuKbn sntkinfohnsyumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_NayoseKekka.SNTKINFOHNSYUMUKBN)
    public C_BlnktkumuKbn getSntkinfohnsyumukbn() {
        return sntkinfohnsyumukbn;
    }

    public void setSntkinfohnsyumukbn(C_BlnktkumuKbn pSntkinfohnsyumukbn) {
        sntkinfohnsyumukbn = pSntkinfohnsyumukbn;
    }

    private C_BlnktkumuKbn signalsetteiumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_NayoseKekka.SIGNALSETTEIUMUKBN)
    public C_BlnktkumuKbn getSignalsetteiumukbn() {
        return signalsetteiumukbn;
    }

    public void setSignalsetteiumukbn(C_BlnktkumuKbn pSignalsetteiumukbn) {
        signalsetteiumukbn = pSignalsetteiumukbn;
    }

    private C_BlnktkumuKbn signalinfohnsyumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_NayoseKekka.SIGNALINFOHNSYUMUKBN)
    public C_BlnktkumuKbn getSignalinfohnsyumukbn() {
        return signalinfohnsyumukbn;
    }

    public void setSignalinfohnsyumukbn(C_BlnktkumuKbn pSignalinfohnsyumukbn) {
        signalinfohnsyumukbn = pSignalinfohnsyumukbn;
    }

    private C_BlnktkumuKbn gaikokupepsumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_NayoseKekka.GAIKOKUPEPSUMUKBN)
    public C_BlnktkumuKbn getGaikokupepsumukbn() {
        return gaikokupepsumukbn;
    }

    public void setGaikokupepsumukbn(C_BlnktkumuKbn pGaikokupepsumukbn) {
        gaikokupepsumukbn = pGaikokupepsumukbn;
    }

    private C_BlnktkumuKbn sinsntkhnsyumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_NayoseKekka.SINSNTKHNSYUMUKBN)
    public C_BlnktkumuKbn getSinsntkhnsyumukbn() {
        return sinsntkhnsyumukbn;
    }

    public void setSinsntkhnsyumukbn(C_BlnktkumuKbn pSinsntkhnsyumukbn) {
        sinsntkhnsyumukbn = pSinsntkhnsyumukbn;
    }

    private C_YouhiblnkKbn itekisntkhndktyhkbn;

    @Type(type="UserType_C_YouhiblnkKbn")
    @Column(name=GenHT_NayoseKekka.ITEKISNTKHNDKTYHKBN)
    public C_YouhiblnkKbn getItekisntkhndktyhkbn() {
        return itekisntkhndktyhkbn;
    }

    public void setItekisntkhndktyhkbn(C_YouhiblnkKbn pItekisntkhndktyhkbn) {
        itekisntkhndktyhkbn = pItekisntkhndktyhkbn;
    }

    private C_YouhiblnkKbn ttdktyuuiknkhndktyhkbn;

    @Type(type="UserType_C_YouhiblnkKbn")
    @Column(name=GenHT_NayoseKekka.TTDKTYUUIKNKHNDKTYHKBN)
    public C_YouhiblnkKbn getTtdktyuuiknkhndktyhkbn() {
        return ttdktyuuiknkhndktyhkbn;
    }

    public void setTtdktyuuiknkhndktyhkbn(C_YouhiblnkKbn pTtdktyuuiknkhndktyhkbn) {
        ttdktyuuiknkhndktyhkbn = pTtdktyuuiknkhndktyhkbn;
    }

    private C_YouhiblnkKbn kyhkinuktkariitkhndktyhkbn;

    @Type(type="UserType_C_YouhiblnkKbn")
    @Column(name=GenHT_NayoseKekka.KYHKINUKTKARIITKHNDKTYHKBN)
    public C_YouhiblnkKbn getKyhkinuktkariitkhndktyhkbn() {
        return kyhkinuktkariitkhndktyhkbn;
    }

    public void setKyhkinuktkariitkhndktyhkbn(C_YouhiblnkKbn pKyhkinuktkariitkhndktyhkbn) {
        kyhkinuktkariitkhndktyhkbn = pKyhkinuktkariitkhndktyhkbn;
    }

    private C_YouhiblnkKbn doujimositekihndktyhkbn;

    @Type(type="UserType_C_YouhiblnkKbn")
    @Column(name=GenHT_NayoseKekka.DOUJIMOSITEKIHNDKTYHKBN)
    public C_YouhiblnkKbn getDoujimositekihndktyhkbn() {
        return doujimositekihndktyhkbn;
    }

    public void setDoujimositekihndktyhkbn(C_YouhiblnkKbn pDoujimositekihndktyhkbn) {
        doujimositekihndktyhkbn = pDoujimositekihndktyhkbn;
    }

    private C_YouhiblnkKbn doujimosknkhndktyhkbn;

    @Type(type="UserType_C_YouhiblnkKbn")
    @Column(name=GenHT_NayoseKekka.DOUJIMOSKNKHNDKTYHKBN)
    public C_YouhiblnkKbn getDoujimosknkhndktyhkbn() {
        return doujimosknkhndktyhkbn;
    }

    public void setDoujimosknkhndktyhkbn(C_YouhiblnkKbn pDoujimosknkhndktyhkbn) {
        doujimosknkhndktyhkbn = pDoujimosknkhndktyhkbn;
    }

    private C_SirajiKykKbn sirajikykkbn;

    @Type(type="UserType_C_SirajiKykKbn")
    @Column(name=GenHT_NayoseKekka.SIRAJIKYKKBN)
    public C_SirajiKykKbn getSirajikykkbn() {
        return sirajikykkbn;
    }

    public void setSirajikykkbn(C_SirajiKykKbn pSirajikykkbn) {
        sirajikykkbn = pSirajikykkbn;
    }

    private BizDate kikykinfoseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_NayoseKekka.KIKYKINFOSEIYMD)
    public BizDate getKikykinfoseiymd() {
        return kikykinfoseiymd;
    }

    public void setKikykinfoseiymd(BizDate pKikykinfoseiymd) {
        kikykinfoseiymd = pKikykinfoseiymd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_NayoseKekka.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_NayoseKekka.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
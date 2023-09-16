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
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_SntkinfoKbn;
import yuyu.def.classification.C_SysCdKbn;
import yuyu.def.db.entity.HT_SentakuJyouhou;
import yuyu.def.db.id.PKHT_SentakuJyouhou;
import yuyu.def.db.meta.GenQHT_SentakuJyouhou;
import yuyu.def.db.meta.QHT_SentakuJyouhou;
import yuyu.def.db.type.UserType_C_BlnktkumuKbn;
import yuyu.def.db.type.UserType_C_KankeisyaKbn;
import yuyu.def.db.type.UserType_C_SntkInfoTaisyousyaKbn;
import yuyu.def.db.type.UserType_C_SntkinfoKbn;
import yuyu.def.db.type.UserType_C_SysCdKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 選択情報テーブル テーブルのマッピング情報クラスで、 {@link HT_SentakuJyouhou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SentakuJyouhou}</td><td colspan="3">選択情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_SentakuJyouhou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSntkinfotaisyousyakbn sntkinfotaisyousyakbn}</td><td>選択情報対象者区分</td><td align="center">{@link PKHT_SentakuJyouhou ○}</td><td align="center">V</td><td>{@link C_SntkInfoTaisyousyaKbn}</td></tr>
 *  <tr><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">{@link PKHT_SentakuJyouhou ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSntkinfono sntkinfono}</td><td>選択情報番号</td><td align="center">{@link PKHT_SentakuJyouhou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyscdkbn syscdkbn}</td><td>システムコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SysCdKbn}</td></tr>
 *  <tr><td>{@link #getSntkinfokankeisyakbn sntkinfokankeisyakbn}</td><td>選択情報関係者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KankeisyaKbn}</td></tr>
 *  <tr><td>{@link #getSntkinfofkojinkbn sntkinfofkojinkbn}</td><td>選択情報Ｆ個人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSntkinfokbn sntkinfokbn}</td><td>選択情報区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SntkinfoKbn}</td></tr>
 *  <tr><td>{@link #getSntkinfosakuseiymd sntkinfosakuseiymd}</td><td>選択情報作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMrumukbn mrumukbn}</td><td>ＭＲ有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getDecumukbn decumukbn}</td><td>ＤＥＣ有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getInfokoukanumukbn infokoukanumukbn}</td><td>情報交換有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getNyuuinkyhkshrumukbn nyuuinkyhkshrumukbn}</td><td>入院給付金支払有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getSyujyutukyhkshrumukbn syujyutukyhkshrumukbn}</td><td>手術給付金支払有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getSyougaikyhkshrumukbn syougaikyhkshrumukbn}</td><td>障害給付金支払有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getKoudosyougaiumukbn koudosyougaiumukbn}</td><td>高度障害有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getPmenumukbn pmenumukbn}</td><td>Ｐ免有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getTorikaijoumukbn torikaijoumukbn}</td><td>取消解除有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getSoukikeakyhkshrumukbn soukikeakyhkshrumukbn}</td><td>早期ケア給付金支払有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getSonotakyhkshrumukbn sonotakyhkshrumukbn}</td><td>その他給付金支払有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getKghsjjtkyhkshrumukbn kghsjjtkyhkshrumukbn}</td><td>介護保障充実給付金支払有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getHuho2mrumukbn huho2mrumukbn}</td><td>普保ⅡＭＲ有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getHuho2decumukbn huho2decumukbn}</td><td>普保ⅡＤＥＣ有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getHuho2kdumukbn huho2kdumukbn}</td><td>普保Ⅱ高度障害有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getHuho2torikaijoumukbn huho2torikaijoumukbn}</td><td>普保Ⅱ取消解除有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SentakuJyouhou
 * @see     PKHT_SentakuJyouhou
 * @see     QHT_SentakuJyouhou
 * @see     GenQHT_SentakuJyouhou
 */
@MappedSuperclass
@Table(name=GenHT_SentakuJyouhou.TABLE_NAME)
@IdClass(value=PKHT_SentakuJyouhou.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_BlnktkumuKbn", typeClass=UserType_C_BlnktkumuKbn.class),
    @TypeDef(name="UserType_C_KankeisyaKbn", typeClass=UserType_C_KankeisyaKbn.class),
    @TypeDef(name="UserType_C_SntkInfoTaisyousyaKbn", typeClass=UserType_C_SntkInfoTaisyousyaKbn.class),
    @TypeDef(name="UserType_C_SntkinfoKbn", typeClass=UserType_C_SntkinfoKbn.class),
    @TypeDef(name="UserType_C_SysCdKbn", typeClass=UserType_C_SysCdKbn.class)
})
public abstract class GenHT_SentakuJyouhou extends AbstractExDBEntity<HT_SentakuJyouhou, PKHT_SentakuJyouhou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SentakuJyouhou";
    public static final String MOSNO                    = "mosno";
    public static final String SNTKINFOTAISYOUSYAKBN    = "sntkinfotaisyousyakbn";
    public static final String EDANO                    = "edano";
    public static final String SNTKINFONO               = "sntkinfono";
    public static final String SYSCDKBN                 = "syscdkbn";
    public static final String SNTKINFOKANKEISYAKBN     = "sntkinfokankeisyakbn";
    public static final String SNTKINFOFKOJINKBN        = "sntkinfofkojinkbn";
    public static final String SNTKINFOKBN              = "sntkinfokbn";
    public static final String SNTKINFOSAKUSEIYMD       = "sntkinfosakuseiymd";
    public static final String MRUMUKBN                 = "mrumukbn";
    public static final String DECUMUKBN                = "decumukbn";
    public static final String INFOKOUKANUMUKBN         = "infokoukanumukbn";
    public static final String NYUUINKYHKSHRUMUKBN      = "nyuuinkyhkshrumukbn";
    public static final String SYUJYUTUKYHKSHRUMUKBN    = "syujyutukyhkshrumukbn";
    public static final String SYOUGAIKYHKSHRUMUKBN     = "syougaikyhkshrumukbn";
    public static final String KOUDOSYOUGAIUMUKBN       = "koudosyougaiumukbn";
    public static final String PMENUMUKBN               = "pmenumukbn";
    public static final String TORIKAIJOUMUKBN          = "torikaijoumukbn";
    public static final String SOUKIKEAKYHKSHRUMUKBN    = "soukikeakyhkshrumukbn";
    public static final String SONOTAKYHKSHRUMUKBN      = "sonotakyhkshrumukbn";
    public static final String KGHSJJTKYHKSHRUMUKBN     = "kghsjjtkyhkshrumukbn";
    public static final String HUHO2MRUMUKBN            = "huho2mrumukbn";
    public static final String HUHO2DECUMUKBN           = "huho2decumukbn";
    public static final String HUHO2KDUMUKBN            = "huho2kdumukbn";
    public static final String HUHO2TORIKAIJOUMUKBN     = "huho2torikaijoumukbn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SentakuJyouhou primaryKey;

    public GenHT_SentakuJyouhou() {
        primaryKey = new PKHT_SentakuJyouhou();
    }

    public GenHT_SentakuJyouhou(
        String pMosno,
        C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn,
        Integer pEdano,
        String pSntkinfono
    ) {
        primaryKey = new PKHT_SentakuJyouhou(
            pMosno,
            pSntkinfotaisyousyakbn,
            pEdano,
            pSntkinfono
        );
    }

    @Transient
    @Override
    public PKHT_SentakuJyouhou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SentakuJyouhou> getMetaClass() {
        return QHT_SentakuJyouhou.class;
    }

    @Id
    @Column(name=GenHT_SentakuJyouhou.MOSNO)
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
    @Column(name=GenHT_SentakuJyouhou.SNTKINFOTAISYOUSYAKBN)
    public C_SntkInfoTaisyousyaKbn getSntkinfotaisyousyakbn() {
        return getPrimaryKey().getSntkinfotaisyousyakbn();
    }

    public void setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn) {
        getPrimaryKey().setSntkinfotaisyousyakbn(pSntkinfotaisyousyakbn);
    }

    @Id
    @Column(name=GenHT_SentakuJyouhou.EDANO)
    public Integer getEdano() {
        return getPrimaryKey().getEdano();
    }

    public void setEdano(Integer pEdano) {
        getPrimaryKey().setEdano(pEdano);
    }

    @Id
    @Column(name=GenHT_SentakuJyouhou.SNTKINFONO)
    public String getSntkinfono() {
        return getPrimaryKey().getSntkinfono();
    }

    public void setSntkinfono(String pSntkinfono) {
        getPrimaryKey().setSntkinfono(pSntkinfono);
    }

    private C_SysCdKbn syscdkbn;

    @Type(type="UserType_C_SysCdKbn")
    @Column(name=GenHT_SentakuJyouhou.SYSCDKBN)
    public C_SysCdKbn getSyscdkbn() {
        return syscdkbn;
    }

    public void setSyscdkbn(C_SysCdKbn pSyscdkbn) {
        syscdkbn = pSyscdkbn;
    }

    private C_KankeisyaKbn sntkinfokankeisyakbn;

    @Type(type="UserType_C_KankeisyaKbn")
    @Column(name=GenHT_SentakuJyouhou.SNTKINFOKANKEISYAKBN)
    public C_KankeisyaKbn getSntkinfokankeisyakbn() {
        return sntkinfokankeisyakbn;
    }

    public void setSntkinfokankeisyakbn(C_KankeisyaKbn pSntkinfokankeisyakbn) {
        sntkinfokankeisyakbn = pSntkinfokankeisyakbn;
    }

    private String sntkinfofkojinkbn;

    @Column(name=GenHT_SentakuJyouhou.SNTKINFOFKOJINKBN)
    public String getSntkinfofkojinkbn() {
        return sntkinfofkojinkbn;
    }

    public void setSntkinfofkojinkbn(String pSntkinfofkojinkbn) {
        sntkinfofkojinkbn = pSntkinfofkojinkbn;
    }

    private C_SntkinfoKbn sntkinfokbn;

    @Type(type="UserType_C_SntkinfoKbn")
    @Column(name=GenHT_SentakuJyouhou.SNTKINFOKBN)
    public C_SntkinfoKbn getSntkinfokbn() {
        return sntkinfokbn;
    }

    public void setSntkinfokbn(C_SntkinfoKbn pSntkinfokbn) {
        sntkinfokbn = pSntkinfokbn;
    }

    private BizDate sntkinfosakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SentakuJyouhou.SNTKINFOSAKUSEIYMD)
    public BizDate getSntkinfosakuseiymd() {
        return sntkinfosakuseiymd;
    }

    public void setSntkinfosakuseiymd(BizDate pSntkinfosakuseiymd) {
        sntkinfosakuseiymd = pSntkinfosakuseiymd;
    }

    private C_BlnktkumuKbn mrumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_SentakuJyouhou.MRUMUKBN)
    public C_BlnktkumuKbn getMrumukbn() {
        return mrumukbn;
    }

    public void setMrumukbn(C_BlnktkumuKbn pMrumukbn) {
        mrumukbn = pMrumukbn;
    }

    private C_BlnktkumuKbn decumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_SentakuJyouhou.DECUMUKBN)
    public C_BlnktkumuKbn getDecumukbn() {
        return decumukbn;
    }

    public void setDecumukbn(C_BlnktkumuKbn pDecumukbn) {
        decumukbn = pDecumukbn;
    }

    private C_BlnktkumuKbn infokoukanumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_SentakuJyouhou.INFOKOUKANUMUKBN)
    public C_BlnktkumuKbn getInfokoukanumukbn() {
        return infokoukanumukbn;
    }

    public void setInfokoukanumukbn(C_BlnktkumuKbn pInfokoukanumukbn) {
        infokoukanumukbn = pInfokoukanumukbn;
    }

    private C_BlnktkumuKbn nyuuinkyhkshrumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_SentakuJyouhou.NYUUINKYHKSHRUMUKBN)
    public C_BlnktkumuKbn getNyuuinkyhkshrumukbn() {
        return nyuuinkyhkshrumukbn;
    }

    public void setNyuuinkyhkshrumukbn(C_BlnktkumuKbn pNyuuinkyhkshrumukbn) {
        nyuuinkyhkshrumukbn = pNyuuinkyhkshrumukbn;
    }

    private C_BlnktkumuKbn syujyutukyhkshrumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_SentakuJyouhou.SYUJYUTUKYHKSHRUMUKBN)
    public C_BlnktkumuKbn getSyujyutukyhkshrumukbn() {
        return syujyutukyhkshrumukbn;
    }

    public void setSyujyutukyhkshrumukbn(C_BlnktkumuKbn pSyujyutukyhkshrumukbn) {
        syujyutukyhkshrumukbn = pSyujyutukyhkshrumukbn;
    }

    private C_BlnktkumuKbn syougaikyhkshrumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_SentakuJyouhou.SYOUGAIKYHKSHRUMUKBN)
    public C_BlnktkumuKbn getSyougaikyhkshrumukbn() {
        return syougaikyhkshrumukbn;
    }

    public void setSyougaikyhkshrumukbn(C_BlnktkumuKbn pSyougaikyhkshrumukbn) {
        syougaikyhkshrumukbn = pSyougaikyhkshrumukbn;
    }

    private C_BlnktkumuKbn koudosyougaiumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_SentakuJyouhou.KOUDOSYOUGAIUMUKBN)
    public C_BlnktkumuKbn getKoudosyougaiumukbn() {
        return koudosyougaiumukbn;
    }

    public void setKoudosyougaiumukbn(C_BlnktkumuKbn pKoudosyougaiumukbn) {
        koudosyougaiumukbn = pKoudosyougaiumukbn;
    }

    private C_BlnktkumuKbn pmenumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_SentakuJyouhou.PMENUMUKBN)
    public C_BlnktkumuKbn getPmenumukbn() {
        return pmenumukbn;
    }

    public void setPmenumukbn(C_BlnktkumuKbn pPmenumukbn) {
        pmenumukbn = pPmenumukbn;
    }

    private C_BlnktkumuKbn torikaijoumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_SentakuJyouhou.TORIKAIJOUMUKBN)
    public C_BlnktkumuKbn getTorikaijoumukbn() {
        return torikaijoumukbn;
    }

    public void setTorikaijoumukbn(C_BlnktkumuKbn pTorikaijoumukbn) {
        torikaijoumukbn = pTorikaijoumukbn;
    }

    private C_BlnktkumuKbn soukikeakyhkshrumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_SentakuJyouhou.SOUKIKEAKYHKSHRUMUKBN)
    public C_BlnktkumuKbn getSoukikeakyhkshrumukbn() {
        return soukikeakyhkshrumukbn;
    }

    public void setSoukikeakyhkshrumukbn(C_BlnktkumuKbn pSoukikeakyhkshrumukbn) {
        soukikeakyhkshrumukbn = pSoukikeakyhkshrumukbn;
    }

    private C_BlnktkumuKbn sonotakyhkshrumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_SentakuJyouhou.SONOTAKYHKSHRUMUKBN)
    public C_BlnktkumuKbn getSonotakyhkshrumukbn() {
        return sonotakyhkshrumukbn;
    }

    public void setSonotakyhkshrumukbn(C_BlnktkumuKbn pSonotakyhkshrumukbn) {
        sonotakyhkshrumukbn = pSonotakyhkshrumukbn;
    }

    private C_BlnktkumuKbn kghsjjtkyhkshrumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_SentakuJyouhou.KGHSJJTKYHKSHRUMUKBN)
    public C_BlnktkumuKbn getKghsjjtkyhkshrumukbn() {
        return kghsjjtkyhkshrumukbn;
    }

    public void setKghsjjtkyhkshrumukbn(C_BlnktkumuKbn pKghsjjtkyhkshrumukbn) {
        kghsjjtkyhkshrumukbn = pKghsjjtkyhkshrumukbn;
    }

    private C_BlnktkumuKbn huho2mrumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_SentakuJyouhou.HUHO2MRUMUKBN)
    public C_BlnktkumuKbn getHuho2mrumukbn() {
        return huho2mrumukbn;
    }

    public void setHuho2mrumukbn(C_BlnktkumuKbn pHuho2mrumukbn) {
        huho2mrumukbn = pHuho2mrumukbn;
    }

    private C_BlnktkumuKbn huho2decumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_SentakuJyouhou.HUHO2DECUMUKBN)
    public C_BlnktkumuKbn getHuho2decumukbn() {
        return huho2decumukbn;
    }

    public void setHuho2decumukbn(C_BlnktkumuKbn pHuho2decumukbn) {
        huho2decumukbn = pHuho2decumukbn;
    }

    private C_BlnktkumuKbn huho2kdumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_SentakuJyouhou.HUHO2KDUMUKBN)
    public C_BlnktkumuKbn getHuho2kdumukbn() {
        return huho2kdumukbn;
    }

    public void setHuho2kdumukbn(C_BlnktkumuKbn pHuho2kdumukbn) {
        huho2kdumukbn = pHuho2kdumukbn;
    }

    private C_BlnktkumuKbn huho2torikaijoumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_SentakuJyouhou.HUHO2TORIKAIJOUMUKBN)
    public C_BlnktkumuKbn getHuho2torikaijoumukbn() {
        return huho2torikaijoumukbn;
    }

    public void setHuho2torikaijoumukbn(C_BlnktkumuKbn pHuho2torikaijoumukbn) {
        huho2torikaijoumukbn = pHuho2torikaijoumukbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SentakuJyouhou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SentakuJyouhou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
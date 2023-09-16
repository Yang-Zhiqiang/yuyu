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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.ST_SynypTukiYkgtIkouHozon;
import yuyu.def.db.id.PKST_SynypTukiYkgtIkouHozon;
import yuyu.def.db.meta.GenQST_SynypTukiYkgtIkouHozon;
import yuyu.def.db.meta.QST_SynypTukiYkgtIkouHozon;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 収入Ｐ統計翌月以降保存テーブル テーブルのマッピング情報クラスで、 {@link ST_SynypTukiYkgtIkouHozon} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_SynypTukiYkgtIkouHozon}</td><td colspan="3">収入Ｐ統計翌月以降保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSrkijyunym srkijyunym}</td><td>数理用基準年月</td><td align="center">{@link PKST_SynypTukiYkgtIkouHozon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSequenceno sequenceno}</td><td>シーケンス番号</td><td align="center">{@link PKST_SynypTukiYkgtIkouHozon ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKST_SynypTukiYkgtIkouHozon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJyutoustartym jyutoustartym}</td><td>充当開始年月</td><td align="center">{@link PKST_SynypTukiYkgtIkouHozon ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getJyutouendym jyutouendym}</td><td>充当終了年月</td><td align="center">{@link PKST_SynypTukiYkgtIkouHozon ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getTaisyakukbn taisyakukbn}</td><td>貸借区分</td><td align="center">{@link PKST_SynypTukiYkgtIkouHozon ○}</td><td align="center">V</td><td>{@link C_TaisyakuKbn}</td></tr>
 *  <tr><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeg1cd seg1cd}</td><td>セグメント１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getZennoujiikkatubaraijytgk zennoujiikkatubaraijytgk}</td><td>前納時一括払充当額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ST_SynypTukiYkgtIkouHozon
 * @see     PKST_SynypTukiYkgtIkouHozon
 * @see     QST_SynypTukiYkgtIkouHozon
 * @see     GenQST_SynypTukiYkgtIkouHozon
 */
@MappedSuperclass
@Table(name=GenST_SynypTukiYkgtIkouHozon.TABLE_NAME)
@IdClass(value=PKST_SynypTukiYkgtIkouHozon.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_TaisyakuKbn", typeClass=UserType_C_TaisyakuKbn.class)
})
public abstract class GenST_SynypTukiYkgtIkouHozon extends AbstractExDBEntity<ST_SynypTukiYkgtIkouHozon, PKST_SynypTukiYkgtIkouHozon> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ST_SynypTukiYkgtIkouHozon";
    public static final String SRKIJYUNYM               = "srkijyunym";
    public static final String SEQUENCENO               = "sequenceno";
    public static final String SYONO                    = "syono";
    public static final String JYUTOUSTARTYM            = "jyutoustartym";
    public static final String JYUTOUENDYM              = "jyutouendym";
    public static final String TAISYAKUKBN              = "taisyakukbn";
    public static final String DENYMD                   = "denymd";
    public static final String SYORICD                  = "syoricd";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SEG1CD                   = "seg1cd";
    public static final String ZENNOUJIIKKATUBARAIJYTGK = "zennoujiikkatubaraijytgk";
    public static final String DENRENNO                 = "denrenno";

    private final PKST_SynypTukiYkgtIkouHozon primaryKey;

    public GenST_SynypTukiYkgtIkouHozon() {
        primaryKey = new PKST_SynypTukiYkgtIkouHozon();
    }

    public GenST_SynypTukiYkgtIkouHozon(
        String pSrkijyunym,
        Integer pSequenceno,
        String pSyono,
        BizDateYM pJyutoustartym,
        BizDateYM pJyutouendym,
        C_TaisyakuKbn pTaisyakukbn
    ) {
        primaryKey = new PKST_SynypTukiYkgtIkouHozon(
            pSrkijyunym,
            pSequenceno,
            pSyono,
            pJyutoustartym,
            pJyutouendym,
            pTaisyakukbn
        );
    }

    @Transient
    @Override
    public PKST_SynypTukiYkgtIkouHozon getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QST_SynypTukiYkgtIkouHozon> getMetaClass() {
        return QST_SynypTukiYkgtIkouHozon.class;
    }

    @Id
    @Column(name=GenST_SynypTukiYkgtIkouHozon.SRKIJYUNYM)
    public String getSrkijyunym() {
        return getPrimaryKey().getSrkijyunym();
    }

    public void setSrkijyunym(String pSrkijyunym) {
        getPrimaryKey().setSrkijyunym(pSrkijyunym);
    }

    @Id
    @Column(name=GenST_SynypTukiYkgtIkouHozon.SEQUENCENO)
    public Integer getSequenceno() {
        return getPrimaryKey().getSequenceno();
    }

    public void setSequenceno(Integer pSequenceno) {
        getPrimaryKey().setSequenceno(pSequenceno);
    }

    @Id
    @Column(name=GenST_SynypTukiYkgtIkouHozon.SYONO)
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
    @Type(type="BizDateYMType")
    @Column(name=GenST_SynypTukiYkgtIkouHozon.JYUTOUSTARTYM)
    public BizDateYM getJyutoustartym() {
        return getPrimaryKey().getJyutoustartym();
    }

    public void setJyutoustartym(BizDateYM pJyutoustartym) {
        getPrimaryKey().setJyutoustartym(pJyutoustartym);
    }

    @Id
    @Type(type="BizDateYMType")
    @Column(name=GenST_SynypTukiYkgtIkouHozon.JYUTOUENDYM)
    public BizDateYM getJyutouendym() {
        return getPrimaryKey().getJyutouendym();
    }

    public void setJyutouendym(BizDateYM pJyutouendym) {
        getPrimaryKey().setJyutouendym(pJyutouendym);
    }

    @Id
    @Type(type="UserType_C_TaisyakuKbn")
    @Column(name=GenST_SynypTukiYkgtIkouHozon.TAISYAKUKBN)
    public C_TaisyakuKbn getTaisyakukbn() {
        return getPrimaryKey().getTaisyakukbn();
    }

    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn) {
        getPrimaryKey().setTaisyakukbn(pTaisyakukbn);
    }

    private BizDate denymd;

    @Type(type="BizDateType")
    @Column(name=GenST_SynypTukiYkgtIkouHozon.DENYMD)
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

    private String syoricd;

    @Column(name=GenST_SynypTukiYkgtIkouHozon.SYORICD)
    public String getSyoricd() {
        return syoricd;
    }

    public void setSyoricd(String pSyoricd) {
        syoricd = pSyoricd;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenST_SynypTukiYkgtIkouHozon.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private C_Segcd seg1cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenST_SynypTukiYkgtIkouHozon.SEG1CD)
    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }

    private Long zennoujiikkatubaraijytgk;

    @Column(name=GenST_SynypTukiYkgtIkouHozon.ZENNOUJIIKKATUBARAIJYTGK)
    public Long getZennoujiikkatubaraijytgk() {
        return zennoujiikkatubaraijytgk;
    }

    public void setZennoujiikkatubaraijytgk(Long pZennoujiikkatubaraijytgk) {
        zennoujiikkatubaraijytgk = pZennoujiikkatubaraijytgk;
    }

    private String denrenno;

    @Column(name=GenST_SynypTukiYkgtIkouHozon.DENRENNO)
    public String getDenrenno() {
        return denrenno;
    }

    public void setDenrenno(String pDenrenno) {
        denrenno = pDenrenno;
    }
}
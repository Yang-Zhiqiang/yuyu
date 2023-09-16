package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.id.PKST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.meta.GenQST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.meta.QST_SynypTukiTugtTykiyuHozon;

/**
 * 収入Ｐ統計当月処理中継用保存テーブル テーブルのマッピング情報クラスで、 {@link ST_SynypTukiTugtTykiyuHozon} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_SynypTukiTugtTykiyuHozon}</td><td colspan="3">収入Ｐ統計当月処理中継用保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysrkijyunym ztysrkijyunym}</td><td>（中継用）数理用基準年月</td><td align="center">{@link PKST_SynypTukiTugtTykiyuHozon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrkakutyoujobcd ztysrkakutyoujobcd}</td><td>（中継用）数理用拡張ジョブコード</td><td align="center">{@link PKST_SynypTukiTugtTykiyuHozon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKST_SynypTukiTugtTykiyuHozon ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuutouym ztyjyuutouym}</td><td>（中継用）充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuutoukaisuu ztyjyuutoukaisuu}</td><td>（中継用）充当回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrecordkbn ztyrecordkbn}</td><td>（中継用）レコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydenymd ztydenymd}</td><td>（中継用）伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhenkousyoriymd ztyhenkousyoriymd}</td><td>（中継用）変更処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentcd ztykbnkeiriyousegmentcd}</td><td>（中継用）区分経理用セグメントコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoujiikkatubaraijytgk ztyzennoujiikkatubaraijytgk}</td><td>（中継用）前納時一括払充当額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysrdenrenno ztysrdenrenno}</td><td>（中継用）数理用伝票データ連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ST_SynypTukiTugtTykiyuHozon
 * @see     PKST_SynypTukiTugtTykiyuHozon
 * @see     QST_SynypTukiTugtTykiyuHozon
 * @see     GenQST_SynypTukiTugtTykiyuHozon
 */
@MappedSuperclass
@Table(name=GenST_SynypTukiTugtTykiyuHozon.TABLE_NAME)
@IdClass(value=PKST_SynypTukiTugtTykiyuHozon.class)
public abstract class GenST_SynypTukiTugtTykiyuHozon extends AbstractExDBEntity<ST_SynypTukiTugtTykiyuHozon, PKST_SynypTukiTugtTykiyuHozon> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ST_SynypTukiTugtTykiyuHozon";
    public static final String ZTYSRKIJYUNYM            = "ztysrkijyunym";
    public static final String ZTYSRKAKUTYOUJOBCD       = "ztysrkakutyoujobcd";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYJYUUTOUYM             = "ztyjyuutouym";
    public static final String ZTYJYUUTOUKAISUU         = "ztyjyuutoukaisuu";
    public static final String ZTYRECORDKBN             = "ztyrecordkbn";
    public static final String ZTYDENYMD                = "ztydenymd";
    public static final String ZTYSYORICD               = "ztysyoricd";
    public static final String ZTYHENKOUSYORIYMD        = "ztyhenkousyoriymd";
    public static final String ZTYKBNKEIRIYOUSEGMENTCD  = "ztykbnkeiriyousegmentcd";
    public static final String ZTYZENNOUJIIKKATUBARAIJYTGK = "ztyzennoujiikkatubaraijytgk";
    public static final String ZTYSRDENRENNO            = "ztysrdenrenno";

    private final PKST_SynypTukiTugtTykiyuHozon primaryKey;

    public GenST_SynypTukiTugtTykiyuHozon() {
        primaryKey = new PKST_SynypTukiTugtTykiyuHozon();
    }

    public GenST_SynypTukiTugtTykiyuHozon(
        String pZtysrkijyunym,
        String pZtysrkakutyoujobcd,
        Integer pZtysequenceno
    ) {
        primaryKey = new PKST_SynypTukiTugtTykiyuHozon(
            pZtysrkijyunym,
            pZtysrkakutyoujobcd,
            pZtysequenceno
        );
    }

    @Transient
    @Override
    public PKST_SynypTukiTugtTykiyuHozon getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QST_SynypTukiTugtTykiyuHozon> getMetaClass() {
        return QST_SynypTukiTugtTykiyuHozon.class;
    }

    @Id
    @Column(name=GenST_SynypTukiTugtTykiyuHozon.ZTYSRKIJYUNYM)
    public String getZtysrkijyunym() {
        return getPrimaryKey().getZtysrkijyunym();
    }

    public void setZtysrkijyunym(String pZtysrkijyunym) {
        getPrimaryKey().setZtysrkijyunym(pZtysrkijyunym);
    }

    @Id
    @Column(name=GenST_SynypTukiTugtTykiyuHozon.ZTYSRKAKUTYOUJOBCD)
    public String getZtysrkakutyoujobcd() {
        return getPrimaryKey().getZtysrkakutyoujobcd();
    }

    public void setZtysrkakutyoujobcd(String pZtysrkakutyoujobcd) {
        getPrimaryKey().setZtysrkakutyoujobcd(pZtysrkakutyoujobcd);
    }

    @Id
    @Column(name=GenST_SynypTukiTugtTykiyuHozon.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private String ztydatakanrino;

    @Column(name=GenST_SynypTukiTugtTykiyuHozon.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return ztydatakanrino;
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }

    private String ztyjyuutouym;

    @Column(name=GenST_SynypTukiTugtTykiyuHozon.ZTYJYUUTOUYM)
    public String getZtyjyuutouym() {
        return ztyjyuutouym;
    }

    public void setZtyjyuutouym(String pZtyjyuutouym) {
        ztyjyuutouym = pZtyjyuutouym;
    }

    private String ztyjyuutoukaisuu;

    @Column(name=GenST_SynypTukiTugtTykiyuHozon.ZTYJYUUTOUKAISUU)
    public String getZtyjyuutoukaisuu() {
        return ztyjyuutoukaisuu;
    }

    public void setZtyjyuutoukaisuu(String pZtyjyuutoukaisuu) {
        ztyjyuutoukaisuu = pZtyjyuutoukaisuu;
    }

    private String ztyrecordkbn;

    @Column(name=GenST_SynypTukiTugtTykiyuHozon.ZTYRECORDKBN)
    public String getZtyrecordkbn() {
        return ztyrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyrecordkbn(String pZtyrecordkbn) {
        ztyrecordkbn = pZtyrecordkbn;
    }

    private String ztydenymd;

    @Column(name=GenST_SynypTukiTugtTykiyuHozon.ZTYDENYMD)
    public String getZtydenymd() {
        return ztydenymd;
    }

    public void setZtydenymd(String pZtydenymd) {
        ztydenymd = pZtydenymd;
    }

    private String ztysyoricd;

    @Column(name=GenST_SynypTukiTugtTykiyuHozon.ZTYSYORICD)
    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }

    private String ztyhenkousyoriymd;

    @Column(name=GenST_SynypTukiTugtTykiyuHozon.ZTYHENKOUSYORIYMD)
    public String getZtyhenkousyoriymd() {
        return ztyhenkousyoriymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhenkousyoriymd(String pZtyhenkousyoriymd) {
        ztyhenkousyoriymd = pZtyhenkousyoriymd;
    }

    private String ztykbnkeiriyousegmentcd;

    @Column(name=GenST_SynypTukiTugtTykiyuHozon.ZTYKBNKEIRIYOUSEGMENTCD)
    public String getZtykbnkeiriyousegmentcd() {
        return ztykbnkeiriyousegmentcd;
    }

    public void setZtykbnkeiriyousegmentcd(String pZtykbnkeiriyousegmentcd) {
        ztykbnkeiriyousegmentcd = pZtykbnkeiriyousegmentcd;
    }

    private Long ztyzennoujiikkatubaraijytgk;

    @Column(name=GenST_SynypTukiTugtTykiyuHozon.ZTYZENNOUJIIKKATUBARAIJYTGK)
    public Long getZtyzennoujiikkatubaraijytgk() {
        return ztyzennoujiikkatubaraijytgk;
    }

    public void setZtyzennoujiikkatubaraijytgk(Long pZtyzennoujiikkatubaraijytgk) {
        ztyzennoujiikkatubaraijytgk = pZtyzennoujiikkatubaraijytgk;
    }

    private String ztysrdenrenno;

    @Column(name=GenST_SynypTukiTugtTykiyuHozon.ZTYSRDENRENNO)
    public String getZtysrdenrenno() {
        return ztysrdenrenno;
    }

    public void setZtysrdenrenno(String pZtysrdenrenno) {
        ztysrdenrenno = pZtysrdenrenno;
    }
}
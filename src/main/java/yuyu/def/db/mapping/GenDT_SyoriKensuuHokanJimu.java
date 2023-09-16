package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.DT_SyoriKensuuHokanJimu;
import yuyu.def.db.id.PKDT_SyoriKensuuHokanJimu;
import yuyu.def.db.meta.GenQDT_SyoriKensuuHokanJimu;
import yuyu.def.db.meta.QDT_SyoriKensuuHokanJimu;

/**
 * 処理件数保管（事務手続別）テーブル テーブルのマッピング情報クラスで、 {@link DT_SyoriKensuuHokanJimu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link DT_SyoriKensuuHokanJimu}</td><td colspan="3">処理件数保管（事務手続別）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKensuuHokanYmd kensuuHokanYmd}</td><td>件数保管日</td><td align="center">{@link PKDT_SyoriKensuuHokanJimu ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">{@link PKDT_SyoriKensuuHokanJimu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAccountId accountId}</td><td>アカウントＩＤ</td><td align="center">{@link PKDT_SyoriKensuuHokanJimu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZenjituzanKensuu zenjituzanKensuu}</td><td>前日残件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZanKensuu zanKensuu}</td><td>残件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKanryoKensuu kanryoKensuu}</td><td>完了件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTaskKanryouKensuuarihyouji taskKanryouKensuuarihyouji}</td><td>タスク完了件数有表示</td><td align="center">&nbsp;</td><td align="center">N</td><td>String</td></tr>
 * </table>
 * @see     DT_SyoriKensuuHokanJimu
 * @see     PKDT_SyoriKensuuHokanJimu
 * @see     QDT_SyoriKensuuHokanJimu
 * @see     GenQDT_SyoriKensuuHokanJimu
 */
@MappedSuperclass
@Table(name=GenDT_SyoriKensuuHokanJimu.TABLE_NAME)
@IdClass(value=PKDT_SyoriKensuuHokanJimu.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenDT_SyoriKensuuHokanJimu extends AbstractExDBEntity<DT_SyoriKensuuHokanJimu, PKDT_SyoriKensuuHokanJimu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "DT_SyoriKensuuHokanJimu";
    public static final String KENSUUHOKANYMD           = "kensuuHokanYmd";
    public static final String JIMUTETUZUKICD           = "jimutetuzukicd";
    public static final String ACCOUNTID                = "accountId";
    public static final String ZENJITUZANKENSUU         = "zenjituzanKensuu";
    public static final String ZANKENSUU                = "zanKensuu";
    public static final String KANRYOKENSUU             = "kanryoKensuu";
    public static final String TASKKANRYOUKENSUUARIHYOUJI = "taskKanryouKensuuarihyouji";

    private final PKDT_SyoriKensuuHokanJimu primaryKey;

    public GenDT_SyoriKensuuHokanJimu() {
        primaryKey = new PKDT_SyoriKensuuHokanJimu();
    }

    public GenDT_SyoriKensuuHokanJimu(
        BizDate pKensuuHokanYmd,
        String pJimutetuzukicd,
        String pAccountId
    ) {
        primaryKey = new PKDT_SyoriKensuuHokanJimu(
            pKensuuHokanYmd,
            pJimutetuzukicd,
            pAccountId
        );
    }

    @Transient
    @Override
    public PKDT_SyoriKensuuHokanJimu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QDT_SyoriKensuuHokanJimu> getMetaClass() {
        return QDT_SyoriKensuuHokanJimu.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenDT_SyoriKensuuHokanJimu.KENSUUHOKANYMD)
    public BizDate getKensuuHokanYmd() {
        return getPrimaryKey().getKensuuHokanYmd();
    }

    public void setKensuuHokanYmd(BizDate pKensuuHokanYmd) {
        getPrimaryKey().setKensuuHokanYmd(pKensuuHokanYmd);
    }

    @Id
    @Column(name=GenDT_SyoriKensuuHokanJimu.JIMUTETUZUKICD)
    public String getJimutetuzukicd() {
        return getPrimaryKey().getJimutetuzukicd();
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        getPrimaryKey().setJimutetuzukicd(pJimutetuzukicd);
    }

    @Id
    @Column(name=GenDT_SyoriKensuuHokanJimu.ACCOUNTID)
    public String getAccountId() {
        return getPrimaryKey().getAccountId();
    }

    public void setAccountId(String pAccountId) {
        getPrimaryKey().setAccountId(pAccountId);
    }

    private BizNumber zenjituzanKensuu;

    @Type(type="BizNumberType")
    @Column(name=GenDT_SyoriKensuuHokanJimu.ZENJITUZANKENSUU)
    public BizNumber getZenjituzanKensuu() {
        return zenjituzanKensuu;
    }

    public void setZenjituzanKensuu(BizNumber pZenjituzanKensuu) {
        zenjituzanKensuu = pZenjituzanKensuu;
    }

    private BizNumber zanKensuu;

    @Type(type="BizNumberType")
    @Column(name=GenDT_SyoriKensuuHokanJimu.ZANKENSUU)
    public BizNumber getZanKensuu() {
        return zanKensuu;
    }

    public void setZanKensuu(BizNumber pZanKensuu) {
        zanKensuu = pZanKensuu;
    }

    private BizNumber kanryoKensuu;

    @Type(type="BizNumberType")
    @Column(name=GenDT_SyoriKensuuHokanJimu.KANRYOKENSUU)
    public BizNumber getKanryoKensuu() {
        return kanryoKensuu;
    }

    public void setKanryoKensuu(BizNumber pKanryoKensuu) {
        kanryoKensuu = pKanryoKensuu;
    }

    private String taskKanryouKensuuarihyouji;

    @Column(name=GenDT_SyoriKensuuHokanJimu.TASKKANRYOUKENSUUARIHYOUJI)
    public String getTaskKanryouKensuuarihyouji() {
        return taskKanryouKensuuarihyouji;
    }

    public void setTaskKanryouKensuuarihyouji(String pTaskKanryouKensuuarihyouji) {
        taskKanryouKensuuarihyouji = pTaskKanryouKensuuarihyouji;
    }
}
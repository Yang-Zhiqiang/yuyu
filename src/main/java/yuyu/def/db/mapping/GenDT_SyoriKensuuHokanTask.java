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
import yuyu.def.db.entity.DT_SyoriKensuuHokanTask;
import yuyu.def.db.id.PKDT_SyoriKensuuHokanTask;
import yuyu.def.db.meta.GenQDT_SyoriKensuuHokanTask;
import yuyu.def.db.meta.QDT_SyoriKensuuHokanTask;

/**
 * 処理件数保管（タスク別）テーブル テーブルのマッピング情報クラスで、 {@link DT_SyoriKensuuHokanTask} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link DT_SyoriKensuuHokanTask}</td><td colspan="3">処理件数保管（タスク別）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKensuuHokanYmd kensuuHokanYmd}</td><td>件数保管日</td><td align="center">{@link PKDT_SyoriKensuuHokanTask ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">{@link PKDT_SyoriKensuuHokanTask ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTskid tskid}</td><td>タスクＩＤ</td><td align="center">{@link PKDT_SyoriKensuuHokanTask ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAccountId accountId}</td><td>アカウントＩＤ</td><td align="center">{@link PKDT_SyoriKensuuHokanTask ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZenjituzanKensuu zenjituzanKensuu}</td><td>前日残件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZanKensuu zanKensuu}</td><td>残件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKanryoKensuu kanryoKensuu}</td><td>完了件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     DT_SyoriKensuuHokanTask
 * @see     PKDT_SyoriKensuuHokanTask
 * @see     QDT_SyoriKensuuHokanTask
 * @see     GenQDT_SyoriKensuuHokanTask
 */
@MappedSuperclass
@Table(name=GenDT_SyoriKensuuHokanTask.TABLE_NAME)
@IdClass(value=PKDT_SyoriKensuuHokanTask.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenDT_SyoriKensuuHokanTask extends AbstractExDBEntity<DT_SyoriKensuuHokanTask, PKDT_SyoriKensuuHokanTask> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "DT_SyoriKensuuHokanTask";
    public static final String KENSUUHOKANYMD           = "kensuuHokanYmd";
    public static final String JIMUTETUZUKICD           = "jimutetuzukicd";
    public static final String TSKID                    = "tskid";
    public static final String ACCOUNTID                = "accountId";
    public static final String ZENJITUZANKENSUU         = "zenjituzanKensuu";
    public static final String ZANKENSUU                = "zanKensuu";
    public static final String KANRYOKENSUU             = "kanryoKensuu";

    private final PKDT_SyoriKensuuHokanTask primaryKey;

    public GenDT_SyoriKensuuHokanTask() {
        primaryKey = new PKDT_SyoriKensuuHokanTask();
    }

    public GenDT_SyoriKensuuHokanTask(
        BizDate pKensuuHokanYmd,
        String pJimutetuzukicd,
        String pTskid,
        String pAccountId
    ) {
        primaryKey = new PKDT_SyoriKensuuHokanTask(
            pKensuuHokanYmd,
            pJimutetuzukicd,
            pTskid,
            pAccountId
        );
    }

    @Transient
    @Override
    public PKDT_SyoriKensuuHokanTask getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QDT_SyoriKensuuHokanTask> getMetaClass() {
        return QDT_SyoriKensuuHokanTask.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenDT_SyoriKensuuHokanTask.KENSUUHOKANYMD)
    public BizDate getKensuuHokanYmd() {
        return getPrimaryKey().getKensuuHokanYmd();
    }

    public void setKensuuHokanYmd(BizDate pKensuuHokanYmd) {
        getPrimaryKey().setKensuuHokanYmd(pKensuuHokanYmd);
    }

    @Id
    @Column(name=GenDT_SyoriKensuuHokanTask.JIMUTETUZUKICD)
    public String getJimutetuzukicd() {
        return getPrimaryKey().getJimutetuzukicd();
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        getPrimaryKey().setJimutetuzukicd(pJimutetuzukicd);
    }

    @Id
    @Column(name=GenDT_SyoriKensuuHokanTask.TSKID)
    public String getTskid() {
        return getPrimaryKey().getTskid();
    }

    public void setTskid(String pTskid) {
        getPrimaryKey().setTskid(pTskid);
    }

    @Id
    @Column(name=GenDT_SyoriKensuuHokanTask.ACCOUNTID)
    public String getAccountId() {
        return getPrimaryKey().getAccountId();
    }

    public void setAccountId(String pAccountId) {
        getPrimaryKey().setAccountId(pAccountId);
    }

    private BizNumber zenjituzanKensuu;

    @Type(type="BizNumberType")
    @Column(name=GenDT_SyoriKensuuHokanTask.ZENJITUZANKENSUU)
    public BizNumber getZenjituzanKensuu() {
        return zenjituzanKensuu;
    }

    public void setZenjituzanKensuu(BizNumber pZenjituzanKensuu) {
        zenjituzanKensuu = pZenjituzanKensuu;
    }

    private BizNumber zanKensuu;

    @Type(type="BizNumberType")
    @Column(name=GenDT_SyoriKensuuHokanTask.ZANKENSUU)
    public BizNumber getZanKensuu() {
        return zanKensuu;
    }

    public void setZanKensuu(BizNumber pZanKensuu) {
        zanKensuu = pZanKensuu;
    }

    private BizNumber kanryoKensuu;

    @Type(type="BizNumberType")
    @Column(name=GenDT_SyoriKensuuHokanTask.KANRYOKENSUU)
    public BizNumber getKanryoKensuu() {
        return kanryoKensuu;
    }

    public void setKanryoKensuu(BizNumber pKanryoKensuu) {
        kanryoKensuu = pKanryoKensuu;
    }
}
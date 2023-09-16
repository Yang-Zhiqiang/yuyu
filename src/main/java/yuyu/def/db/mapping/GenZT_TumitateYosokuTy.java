package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_TumitateYosokuTy;
import yuyu.def.db.id.PKZT_TumitateYosokuTy;
import yuyu.def.db.meta.GenQZT_TumitateYosokuTy;
import yuyu.def.db.meta.QZT_TumitateYosokuTy;

/**
 * 積立金額予測ファイルテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_TumitateYosokuTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TumitateYosokuTy}</td><td colspan="3">積立金額予測ファイルテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">{@link PKZT_TumitateYosokuTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuymd ztykeiyakuymd}</td><td>（中継用）契約日</td><td align="center">{@link PKZT_TumitateYosokuTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytysytymd ztytysytymd}</td><td>（中継用）抽出日</td><td align="center">{@link PKZT_TumitateYosokuTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyktuukasyu ztykyktuukasyu}</td><td>（中継用）契約通貨種類</td><td align="center">{@link PKZT_TumitateYosokuTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">{@link PKZT_TumitateYosokuTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknsyuruikbn ztytmttknsyuruikbn}</td><td>（中継用）積立金種類区分</td><td align="center">{@link PKZT_TumitateYosokuTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuukbn ztysisuukbn}</td><td>（中継用）指数区分</td><td align="center">{@link PKZT_TumitateYosokuTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknysktaisyoukensuu ztytmttknysktaisyoukensuu}</td><td>（中継用）積立金予測対象件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykyktuukakyktmttkngk ztykyktuukakyktmttkngk}</td><td>（中継用）契約通貨建契約時積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykyktuukakisitmttkngk ztykyktuukakisitmttkngk}</td><td>（中継用）契約通貨建期始積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykyktuukaysktmttkngk ztykyktuukaysktmttkngk}</td><td>（中継用）契約通貨建予測積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     ZT_TumitateYosokuTy
 * @see     PKZT_TumitateYosokuTy
 * @see     QZT_TumitateYosokuTy
 * @see     GenQZT_TumitateYosokuTy
 */
@MappedSuperclass
@Table(name=GenZT_TumitateYosokuTy.TABLE_NAME)
@IdClass(value=PKZT_TumitateYosokuTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_TumitateYosokuTy extends AbstractExDBEntity<ZT_TumitateYosokuTy, PKZT_TumitateYosokuTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TumitateYosokuTy";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYKEIYAKUYMD            = "ztykeiyakuymd";
    public static final String ZTYTYSYTYMD              = "ztytysytymd";
    public static final String ZTYKYKTUUKASYU           = "ztykyktuukasyu";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYTMTTKNSYURUIKBN       = "ztytmttknsyuruikbn";
    public static final String ZTYSISUUKBN              = "ztysisuukbn";
    public static final String ZTYTMTTKNYSKTAISYOUKENSUU = "ztytmttknysktaisyoukensuu";
    public static final String ZTYKYKTUUKAKYKTMTTKNGK   = "ztykyktuukakyktmttkngk";
    public static final String ZTYKYKTUUKAKISITMTTKNGK  = "ztykyktuukakisitmttkngk";
    public static final String ZTYKYKTUUKAYSKTMTTKNGK   = "ztykyktuukaysktmttkngk";

    private final PKZT_TumitateYosokuTy primaryKey;

    public GenZT_TumitateYosokuTy() {
        primaryKey = new PKZT_TumitateYosokuTy();
    }

    public GenZT_TumitateYosokuTy(
        String pZtyhknsyukigou,
        String pZtykeiyakuymd,
        String pZtytysytymd,
        String pZtykyktuukasyu,
        String pZtyhknkkn,
        String pZtytmttknsyuruikbn,
        String pZtysisuukbn
    ) {
        primaryKey = new PKZT_TumitateYosokuTy(
            pZtyhknsyukigou,
            pZtykeiyakuymd,
            pZtytysytymd,
            pZtykyktuukasyu,
            pZtyhknkkn,
            pZtytmttknsyuruikbn,
            pZtysisuukbn
        );
    }

    @Transient
    @Override
    public PKZT_TumitateYosokuTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TumitateYosokuTy> getMetaClass() {
        return QZT_TumitateYosokuTy.class;
    }

    @Id
    @Column(name=GenZT_TumitateYosokuTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return getPrimaryKey().getZtyhknsyukigou();
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        getPrimaryKey().setZtyhknsyukigou(pZtyhknsyukigou);
    }

    @Id
    @Column(name=GenZT_TumitateYosokuTy.ZTYKEIYAKUYMD)
    public String getZtykeiyakuymd() {
        return getPrimaryKey().getZtykeiyakuymd();
    }

    public void setZtykeiyakuymd(String pZtykeiyakuymd) {
        getPrimaryKey().setZtykeiyakuymd(pZtykeiyakuymd);
    }

    @Id
    @Column(name=GenZT_TumitateYosokuTy.ZTYTYSYTYMD)
    public String getZtytysytymd() {
        return getPrimaryKey().getZtytysytymd();
    }

    public void setZtytysytymd(String pZtytysytymd) {
        getPrimaryKey().setZtytysytymd(pZtytysytymd);
    }

    @Id
    @Column(name=GenZT_TumitateYosokuTy.ZTYKYKTUUKASYU)
    public String getZtykyktuukasyu() {
        return getPrimaryKey().getZtykyktuukasyu();
    }

    public void setZtykyktuukasyu(String pZtykyktuukasyu) {
        getPrimaryKey().setZtykyktuukasyu(pZtykyktuukasyu);
    }

    @Id
    @Column(name=GenZT_TumitateYosokuTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return getPrimaryKey().getZtyhknkkn();
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        getPrimaryKey().setZtyhknkkn(pZtyhknkkn);
    }

    @Id
    @Column(name=GenZT_TumitateYosokuTy.ZTYTMTTKNSYURUIKBN)
    public String getZtytmttknsyuruikbn() {
        return getPrimaryKey().getZtytmttknsyuruikbn();
    }

    public void setZtytmttknsyuruikbn(String pZtytmttknsyuruikbn) {
        getPrimaryKey().setZtytmttknsyuruikbn(pZtytmttknsyuruikbn);
    }

    @Id
    @Column(name=GenZT_TumitateYosokuTy.ZTYSISUUKBN)
    public String getZtysisuukbn() {
        return getPrimaryKey().getZtysisuukbn();
    }

    public void setZtysisuukbn(String pZtysisuukbn) {
        getPrimaryKey().setZtysisuukbn(pZtysisuukbn);
    }

    private Integer ztytmttknysktaisyoukensuu;

    @Column(name=GenZT_TumitateYosokuTy.ZTYTMTTKNYSKTAISYOUKENSUU)
    public Integer getZtytmttknysktaisyoukensuu() {
        return ztytmttknysktaisyoukensuu;
    }

    public void setZtytmttknysktaisyoukensuu(Integer pZtytmttknysktaisyoukensuu) {
        ztytmttknysktaisyoukensuu = pZtytmttknysktaisyoukensuu;
    }

    private BizNumber ztykyktuukakyktmttkngk;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TumitateYosokuTy.ZTYKYKTUUKAKYKTMTTKNGK)
    public BizNumber getZtykyktuukakyktmttkngk() {
        return ztykyktuukakyktmttkngk;
    }

    public void setZtykyktuukakyktmttkngk(BizNumber pZtykyktuukakyktmttkngk) {
        ztykyktuukakyktmttkngk = pZtykyktuukakyktmttkngk;
    }

    private BizNumber ztykyktuukakisitmttkngk;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TumitateYosokuTy.ZTYKYKTUUKAKISITMTTKNGK)
    public BizNumber getZtykyktuukakisitmttkngk() {
        return ztykyktuukakisitmttkngk;
    }

    public void setZtykyktuukakisitmttkngk(BizNumber pZtykyktuukakisitmttkngk) {
        ztykyktuukakisitmttkngk = pZtykyktuukakisitmttkngk;
    }

    private BizNumber ztykyktuukaysktmttkngk;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TumitateYosokuTy.ZTYKYKTUUKAYSKTMTTKNGK)
    public BizNumber getZtykyktuukaysktmttkngk() {
        return ztykyktuukaysktmttkngk;
    }

    public void setZtykyktuukaysktmttkngk(BizNumber pZtykyktuukaysktmttkngk) {
        ztykyktuukaysktmttkngk = pZtykyktuukaysktmttkngk;
    }
}
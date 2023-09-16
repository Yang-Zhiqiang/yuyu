package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_SntkInfoTourokuTy;
import yuyu.def.db.id.PKZT_SntkInfoTourokuTy;
import yuyu.def.db.meta.GenQZT_SntkInfoTourokuTy;
import yuyu.def.db.meta.QZT_SntkInfoTourokuTy;

/**
 * 選択情報登録テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SntkInfoTourokuTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SntkInfoTourokuTy}</td><td colspan="3">選択情報登録テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysntkinfono ztysntkinfono}</td><td>（中継用）選択情報番号</td><td align="center">{@link PKZT_SntkInfoTourokuTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrenno ztyrenno}</td><td>（中継用）連番</td><td align="center">{@link PKZT_SntkInfoTourokuTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysntkinfotourokusyskbn ztysntkinfotourokusyskbn}</td><td>（中継用）選択情報登録システム区分</td><td align="center">{@link PKZT_SntkInfoTourokuTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoriymd ztysyoriymd}</td><td>（中継用）処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhuho2kyknokbn ztyhuho2kyknokbn}</td><td>（中継用）普保Ⅱ契約番号区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhuho2kykno ztyhuho2kykno}</td><td>（中継用）普保Ⅱ契約番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyouhncd ztysyouhncd}</td><td>（中継用）商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysntkinfofsegkbn ztysntkinfofsegkbn}</td><td>（中継用）選択情報ＦＳＥＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysntkinfofkojinkbn ztysntkinfofkojinkbn}</td><td>（中継用）選択情報Ｆ個人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytaisyounm ztytaisyounm}</td><td>（中継用）対象者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjtaisyounm ztykjtaisyounm}</td><td>（中継用）漢字対象者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytaisyouseiymd ztytaisyouseiymd}</td><td>（中継用）対象者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytaisyouseibetu ztytaisyouseibetu}</td><td>（中継用）対象者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketnaiyouarihyj ztydakuhiketnaiyouarihyj}</td><td>（中継用）諾否決定内容有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykktnaiyouarihyj ztykktnaiyouarihyj}</td><td>（中継用）告知内容有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykijinaiyouarihyj ztykijinaiyouarihyj}</td><td>（中継用）記事内容有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrarihyj ztymrarihyj}</td><td>（中継用）ＭＲ有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykoudosyougaiarihyj ztykoudosyougaiarihyj}</td><td>（中継用）高度障害有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytorikaijoarihyj ztytorikaijoarihyj}</td><td>（中継用）取消解除有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskhuseirituhyouji ztyskhuseirituhyouji}</td><td>（中継用）新契約不成立表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysntkinfotourokuyobi01 ztysntkinfotourokuyobi01}</td><td>（中継用）選択情報登録予備０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydeckbn ztydeckbn}</td><td>（中継用）ＤＥＣ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketymd ztyketymd}</td><td>（中継用）決定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketkekkacd ztyketkekkacd}</td><td>（中継用）決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketriyuucd1 ztyketriyuucd1}</td><td>（中継用）決定理由コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketriyuucd2 ztyketriyuucd2}</td><td>（中継用）決定理由コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketriyuucd3 ztyketriyuucd3}</td><td>（中継用）決定理由コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketriyuucd4 ztyketriyuucd4}</td><td>（中継用）決定理由コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketsyacd ztyketsyacd}</td><td>（中継用）決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysntkinfotourokuyobi02 ztysntkinfotourokuyobi02}</td><td>（中継用）選択情報登録予備０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysntkinfosintyou ztysntkinfosintyou}</td><td>（中継用）選択情報身長</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysntkinfotaijyuu ztysntkinfotaijyuu}</td><td>（中継用）選択情報体重</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykokutiymd ztykokutiymd}</td><td>（中継用）告知年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysntkinfotourokuyobi03 ztysntkinfotourokuyobi03}</td><td>（中継用）選択情報登録予備０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoubyoucd1 ztysyoubyoucd1}</td><td>（中継用）傷病コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykantiym1 ztykantiym1}</td><td>（中継用）完治年月１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoubyoucd2 ztysyoubyoucd2}</td><td>（中継用）傷病コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykantiym2 ztykantiym2}</td><td>（中継用）完治年月２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysntkinfotourokuyobi04 ztysntkinfotourokuyobi04}</td><td>（中継用）選択情報登録予備０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrriyuucdkbn ztymrriyuucdkbn}</td><td>（中継用）ＭＲ理由コード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysntkinfotourokuyobi05 ztysntkinfotourokuyobi05}</td><td>（中継用）選択情報登録予備０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysntkinfokyktorikesikbn ztysntkinfokyktorikesikbn}</td><td>（中継用）選択情報用契約取消処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysntkinfotourokuyobi06 ztysntkinfotourokuyobi06}</td><td>（中継用）選択情報登録予備０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykdsssiharaijyoutaikbn ztykdsssiharaijyoutaikbn}</td><td>（中継用）高度障害Ｓ支払状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykdsssiharaiymd ztykdsssiharaiymd}</td><td>（中継用）高度障害Ｓ支払年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykdsymd ztykdsymd}</td><td>（中継用）高度障害年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykdssiharaisosikicd ztykdssiharaisosikicd}</td><td>（中継用）高度障害支払組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysntkinfotourokuyobi07 ztysntkinfotourokuyobi07}</td><td>（中継用）選択情報登録予備０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SntkInfoTourokuTy
 * @see     PKZT_SntkInfoTourokuTy
 * @see     QZT_SntkInfoTourokuTy
 * @see     GenQZT_SntkInfoTourokuTy
 */
@MappedSuperclass
@Table(name=GenZT_SntkInfoTourokuTy.TABLE_NAME)
@IdClass(value=PKZT_SntkInfoTourokuTy.class)
public abstract class GenZT_SntkInfoTourokuTy extends AbstractExDBEntity<ZT_SntkInfoTourokuTy, PKZT_SntkInfoTourokuTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SntkInfoTourokuTy";
    public static final String ZTYSNTKINFONO            = "ztysntkinfono";
    public static final String ZTYRENNO                 = "ztyrenno";
    public static final String ZTYSNTKINFOTOUROKUSYSKBN = "ztysntkinfotourokusyskbn";
    public static final String ZTYSYORIYMD              = "ztysyoriymd";
    public static final String ZTYHUHO2KYKNOKBN         = "ztyhuho2kyknokbn";
    public static final String ZTYHUHO2KYKNO            = "ztyhuho2kykno";
    public static final String ZTYSYOUHNCD              = "ztysyouhncd";
    public static final String ZTYSNTKINFOFSEGKBN       = "ztysntkinfofsegkbn";
    public static final String ZTYSNTKINFOFKOJINKBN     = "ztysntkinfofkojinkbn";
    public static final String ZTYTAISYOUNM             = "ztytaisyounm";
    public static final String ZTYKJTAISYOUNM           = "ztykjtaisyounm";
    public static final String ZTYTAISYOUSEIYMD         = "ztytaisyouseiymd";
    public static final String ZTYTAISYOUSEIBETU        = "ztytaisyouseibetu";
    public static final String ZTYDAKUHIKETNAIYOUARIHYJ = "ztydakuhiketnaiyouarihyj";
    public static final String ZTYKKTNAIYOUARIHYJ       = "ztykktnaiyouarihyj";
    public static final String ZTYKIJINAIYOUARIHYJ      = "ztykijinaiyouarihyj";
    public static final String ZTYMRARIHYJ              = "ztymrarihyj";
    public static final String ZTYKOUDOSYOUGAIARIHYJ    = "ztykoudosyougaiarihyj";
    public static final String ZTYTORIKAIJOARIHYJ       = "ztytorikaijoarihyj";
    public static final String ZTYSKHUSEIRITUHYOUJI     = "ztyskhuseirituhyouji";
    public static final String ZTYSNTKINFOTOUROKUYOBI01 = "ztysntkinfotourokuyobi01";
    public static final String ZTYDECKBN                = "ztydeckbn";
    public static final String ZTYKETYMD                = "ztyketymd";
    public static final String ZTYKETKEKKACD            = "ztyketkekkacd";
    public static final String ZTYKETRIYUUCD1           = "ztyketriyuucd1";
    public static final String ZTYKETRIYUUCD2           = "ztyketriyuucd2";
    public static final String ZTYKETRIYUUCD3           = "ztyketriyuucd3";
    public static final String ZTYKETRIYUUCD4           = "ztyketriyuucd4";
    public static final String ZTYKETSYACD              = "ztyketsyacd";
    public static final String ZTYSNTKINFOTOUROKUYOBI02 = "ztysntkinfotourokuyobi02";
    public static final String ZTYSNTKINFOSINTYOU       = "ztysntkinfosintyou";
    public static final String ZTYSNTKINFOTAIJYUU       = "ztysntkinfotaijyuu";
    public static final String ZTYKOKUTIYMD             = "ztykokutiymd";
    public static final String ZTYSNTKINFOTOUROKUYOBI03 = "ztysntkinfotourokuyobi03";
    public static final String ZTYSYOUBYOUCD1           = "ztysyoubyoucd1";
    public static final String ZTYKANTIYM1              = "ztykantiym1";
    public static final String ZTYSYOUBYOUCD2           = "ztysyoubyoucd2";
    public static final String ZTYKANTIYM2              = "ztykantiym2";
    public static final String ZTYSNTKINFOTOUROKUYOBI04 = "ztysntkinfotourokuyobi04";
    public static final String ZTYMRRIYUUCDKBN          = "ztymrriyuucdkbn";
    public static final String ZTYSNTKINFOTOUROKUYOBI05 = "ztysntkinfotourokuyobi05";
    public static final String ZTYSNTKINFOKYKTORIKESIKBN = "ztysntkinfokyktorikesikbn";
    public static final String ZTYSNTKINFOTOUROKUYOBI06 = "ztysntkinfotourokuyobi06";
    public static final String ZTYKDSSSIHARAIJYOUTAIKBN = "ztykdsssiharaijyoutaikbn";
    public static final String ZTYKDSSSIHARAIYMD        = "ztykdsssiharaiymd";
    public static final String ZTYKDSYMD                = "ztykdsymd";
    public static final String ZTYKDSSIHARAISOSIKICD    = "ztykdssiharaisosikicd";
    public static final String ZTYSNTKINFOTOUROKUYOBI07 = "ztysntkinfotourokuyobi07";

    private final PKZT_SntkInfoTourokuTy primaryKey;

    public GenZT_SntkInfoTourokuTy() {
        primaryKey = new PKZT_SntkInfoTourokuTy();
    }

    public GenZT_SntkInfoTourokuTy(
        String pZtysntkinfono,
        String pZtyrenno,
        String pZtysntkinfotourokusyskbn
    ) {
        primaryKey = new PKZT_SntkInfoTourokuTy(
            pZtysntkinfono,
            pZtyrenno,
            pZtysntkinfotourokusyskbn
        );
    }

    @Transient
    @Override
    public PKZT_SntkInfoTourokuTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SntkInfoTourokuTy> getMetaClass() {
        return QZT_SntkInfoTourokuTy.class;
    }

    @Id
    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSNTKINFONO)
    public String getZtysntkinfono() {
        return getPrimaryKey().getZtysntkinfono();
    }

    public void setZtysntkinfono(String pZtysntkinfono) {
        getPrimaryKey().setZtysntkinfono(pZtysntkinfono);
    }

    @Id
    @Column(name=GenZT_SntkInfoTourokuTy.ZTYRENNO)
    public String getZtyrenno() {
        return getPrimaryKey().getZtyrenno();
    }

    public void setZtyrenno(String pZtyrenno) {
        getPrimaryKey().setZtyrenno(pZtyrenno);
    }

    @Id
    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSNTKINFOTOUROKUSYSKBN)
    public String getZtysntkinfotourokusyskbn() {
        return getPrimaryKey().getZtysntkinfotourokusyskbn();
    }

    public void setZtysntkinfotourokusyskbn(String pZtysntkinfotourokusyskbn) {
        getPrimaryKey().setZtysntkinfotourokusyskbn(pZtysntkinfotourokusyskbn);
    }

    private String ztysyoriymd;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSYORIYMD)
    public String getZtysyoriymd() {
        return ztysyoriymd;
    }

    public void setZtysyoriymd(String pZtysyoriymd) {
        ztysyoriymd = pZtysyoriymd;
    }

    private String ztyhuho2kyknokbn;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYHUHO2KYKNOKBN)
    public String getZtyhuho2kyknokbn() {
        return ztyhuho2kyknokbn;
    }

    public void setZtyhuho2kyknokbn(String pZtyhuho2kyknokbn) {
        ztyhuho2kyknokbn = pZtyhuho2kyknokbn;
    }

    private String ztyhuho2kykno;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYHUHO2KYKNO)
    public String getZtyhuho2kykno() {
        return ztyhuho2kykno;
    }

    public void setZtyhuho2kykno(String pZtyhuho2kykno) {
        ztyhuho2kykno = pZtyhuho2kykno;
    }

    private String ztysyouhncd;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSYOUHNCD)
    public String getZtysyouhncd() {
        return ztysyouhncd;
    }

    public void setZtysyouhncd(String pZtysyouhncd) {
        ztysyouhncd = pZtysyouhncd;
    }

    private String ztysntkinfofsegkbn;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSNTKINFOFSEGKBN)
    public String getZtysntkinfofsegkbn() {
        return ztysntkinfofsegkbn;
    }

    public void setZtysntkinfofsegkbn(String pZtysntkinfofsegkbn) {
        ztysntkinfofsegkbn = pZtysntkinfofsegkbn;
    }

    private String ztysntkinfofkojinkbn;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSNTKINFOFKOJINKBN)
    public String getZtysntkinfofkojinkbn() {
        return ztysntkinfofkojinkbn;
    }

    public void setZtysntkinfofkojinkbn(String pZtysntkinfofkojinkbn) {
        ztysntkinfofkojinkbn = pZtysntkinfofkojinkbn;
    }

    private String ztytaisyounm;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYTAISYOUNM)
    public String getZtytaisyounm() {
        return ztytaisyounm;
    }

    public void setZtytaisyounm(String pZtytaisyounm) {
        ztytaisyounm = pZtytaisyounm;
    }

    private String ztykjtaisyounm;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKJTAISYOUNM)
    public String getZtykjtaisyounm() {
        return ztykjtaisyounm;
    }

    public void setZtykjtaisyounm(String pZtykjtaisyounm) {
        ztykjtaisyounm = pZtykjtaisyounm;
    }

    private String ztytaisyouseiymd;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYTAISYOUSEIYMD)
    public String getZtytaisyouseiymd() {
        return ztytaisyouseiymd;
    }

    public void setZtytaisyouseiymd(String pZtytaisyouseiymd) {
        ztytaisyouseiymd = pZtytaisyouseiymd;
    }

    private String ztytaisyouseibetu;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYTAISYOUSEIBETU)
    public String getZtytaisyouseibetu() {
        return ztytaisyouseibetu;
    }

    public void setZtytaisyouseibetu(String pZtytaisyouseibetu) {
        ztytaisyouseibetu = pZtytaisyouseibetu;
    }

    private String ztydakuhiketnaiyouarihyj;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYDAKUHIKETNAIYOUARIHYJ)
    public String getZtydakuhiketnaiyouarihyj() {
        return ztydakuhiketnaiyouarihyj;
    }

    public void setZtydakuhiketnaiyouarihyj(String pZtydakuhiketnaiyouarihyj) {
        ztydakuhiketnaiyouarihyj = pZtydakuhiketnaiyouarihyj;
    }

    private String ztykktnaiyouarihyj;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKKTNAIYOUARIHYJ)
    public String getZtykktnaiyouarihyj() {
        return ztykktnaiyouarihyj;
    }

    public void setZtykktnaiyouarihyj(String pZtykktnaiyouarihyj) {
        ztykktnaiyouarihyj = pZtykktnaiyouarihyj;
    }

    private String ztykijinaiyouarihyj;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKIJINAIYOUARIHYJ)
    public String getZtykijinaiyouarihyj() {
        return ztykijinaiyouarihyj;
    }

    public void setZtykijinaiyouarihyj(String pZtykijinaiyouarihyj) {
        ztykijinaiyouarihyj = pZtykijinaiyouarihyj;
    }

    private String ztymrarihyj;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYMRARIHYJ)
    public String getZtymrarihyj() {
        return ztymrarihyj;
    }

    public void setZtymrarihyj(String pZtymrarihyj) {
        ztymrarihyj = pZtymrarihyj;
    }

    private String ztykoudosyougaiarihyj;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKOUDOSYOUGAIARIHYJ)
    public String getZtykoudosyougaiarihyj() {
        return ztykoudosyougaiarihyj;
    }

    public void setZtykoudosyougaiarihyj(String pZtykoudosyougaiarihyj) {
        ztykoudosyougaiarihyj = pZtykoudosyougaiarihyj;
    }

    private String ztytorikaijoarihyj;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYTORIKAIJOARIHYJ)
    public String getZtytorikaijoarihyj() {
        return ztytorikaijoarihyj;
    }

    public void setZtytorikaijoarihyj(String pZtytorikaijoarihyj) {
        ztytorikaijoarihyj = pZtytorikaijoarihyj;
    }

    private String ztyskhuseirituhyouji;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSKHUSEIRITUHYOUJI)
    public String getZtyskhuseirituhyouji() {
        return ztyskhuseirituhyouji;
    }

    public void setZtyskhuseirituhyouji(String pZtyskhuseirituhyouji) {
        ztyskhuseirituhyouji = pZtyskhuseirituhyouji;
    }

    private String ztysntkinfotourokuyobi01;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSNTKINFOTOUROKUYOBI01)
    public String getZtysntkinfotourokuyobi01() {
        return ztysntkinfotourokuyobi01;
    }

    public void setZtysntkinfotourokuyobi01(String pZtysntkinfotourokuyobi01) {
        ztysntkinfotourokuyobi01 = pZtysntkinfotourokuyobi01;
    }

    private String ztydeckbn;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYDECKBN)
    public String getZtydeckbn() {
        return ztydeckbn;
    }

    public void setZtydeckbn(String pZtydeckbn) {
        ztydeckbn = pZtydeckbn;
    }

    private String ztyketymd;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKETYMD)
    public String getZtyketymd() {
        return ztyketymd;
    }

    public void setZtyketymd(String pZtyketymd) {
        ztyketymd = pZtyketymd;
    }

    private String ztyketkekkacd;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKETKEKKACD)
    public String getZtyketkekkacd() {
        return ztyketkekkacd;
    }

    public void setZtyketkekkacd(String pZtyketkekkacd) {
        ztyketkekkacd = pZtyketkekkacd;
    }

    private String ztyketriyuucd1;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKETRIYUUCD1)
    public String getZtyketriyuucd1() {
        return ztyketriyuucd1;
    }

    public void setZtyketriyuucd1(String pZtyketriyuucd1) {
        ztyketriyuucd1 = pZtyketriyuucd1;
    }

    private String ztyketriyuucd2;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKETRIYUUCD2)
    public String getZtyketriyuucd2() {
        return ztyketriyuucd2;
    }

    public void setZtyketriyuucd2(String pZtyketriyuucd2) {
        ztyketriyuucd2 = pZtyketriyuucd2;
    }

    private String ztyketriyuucd3;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKETRIYUUCD3)
    public String getZtyketriyuucd3() {
        return ztyketriyuucd3;
    }

    public void setZtyketriyuucd3(String pZtyketriyuucd3) {
        ztyketriyuucd3 = pZtyketriyuucd3;
    }

    private String ztyketriyuucd4;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKETRIYUUCD4)
    public String getZtyketriyuucd4() {
        return ztyketriyuucd4;
    }

    public void setZtyketriyuucd4(String pZtyketriyuucd4) {
        ztyketriyuucd4 = pZtyketriyuucd4;
    }

    private String ztyketsyacd;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKETSYACD)
    public String getZtyketsyacd() {
        return ztyketsyacd;
    }

    public void setZtyketsyacd(String pZtyketsyacd) {
        ztyketsyacd = pZtyketsyacd;
    }

    private String ztysntkinfotourokuyobi02;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSNTKINFOTOUROKUYOBI02)
    public String getZtysntkinfotourokuyobi02() {
        return ztysntkinfotourokuyobi02;
    }

    public void setZtysntkinfotourokuyobi02(String pZtysntkinfotourokuyobi02) {
        ztysntkinfotourokuyobi02 = pZtysntkinfotourokuyobi02;
    }

    private String ztysntkinfosintyou;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSNTKINFOSINTYOU)
    public String getZtysntkinfosintyou() {
        return ztysntkinfosintyou;
    }

    public void setZtysntkinfosintyou(String pZtysntkinfosintyou) {
        ztysntkinfosintyou = pZtysntkinfosintyou;
    }

    private String ztysntkinfotaijyuu;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSNTKINFOTAIJYUU)
    public String getZtysntkinfotaijyuu() {
        return ztysntkinfotaijyuu;
    }

    public void setZtysntkinfotaijyuu(String pZtysntkinfotaijyuu) {
        ztysntkinfotaijyuu = pZtysntkinfotaijyuu;
    }

    private String ztykokutiymd;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKOKUTIYMD)
    public String getZtykokutiymd() {
        return ztykokutiymd;
    }

    public void setZtykokutiymd(String pZtykokutiymd) {
        ztykokutiymd = pZtykokutiymd;
    }

    private String ztysntkinfotourokuyobi03;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSNTKINFOTOUROKUYOBI03)
    public String getZtysntkinfotourokuyobi03() {
        return ztysntkinfotourokuyobi03;
    }

    public void setZtysntkinfotourokuyobi03(String pZtysntkinfotourokuyobi03) {
        ztysntkinfotourokuyobi03 = pZtysntkinfotourokuyobi03;
    }

    private String ztysyoubyoucd1;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSYOUBYOUCD1)
    public String getZtysyoubyoucd1() {
        return ztysyoubyoucd1;
    }

    public void setZtysyoubyoucd1(String pZtysyoubyoucd1) {
        ztysyoubyoucd1 = pZtysyoubyoucd1;
    }

    private String ztykantiym1;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKANTIYM1)
    public String getZtykantiym1() {
        return ztykantiym1;
    }

    public void setZtykantiym1(String pZtykantiym1) {
        ztykantiym1 = pZtykantiym1;
    }

    private String ztysyoubyoucd2;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSYOUBYOUCD2)
    public String getZtysyoubyoucd2() {
        return ztysyoubyoucd2;
    }

    public void setZtysyoubyoucd2(String pZtysyoubyoucd2) {
        ztysyoubyoucd2 = pZtysyoubyoucd2;
    }

    private String ztykantiym2;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKANTIYM2)
    public String getZtykantiym2() {
        return ztykantiym2;
    }

    public void setZtykantiym2(String pZtykantiym2) {
        ztykantiym2 = pZtykantiym2;
    }

    private String ztysntkinfotourokuyobi04;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSNTKINFOTOUROKUYOBI04)
    public String getZtysntkinfotourokuyobi04() {
        return ztysntkinfotourokuyobi04;
    }

    public void setZtysntkinfotourokuyobi04(String pZtysntkinfotourokuyobi04) {
        ztysntkinfotourokuyobi04 = pZtysntkinfotourokuyobi04;
    }

    private String ztymrriyuucdkbn;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYMRRIYUUCDKBN)
    public String getZtymrriyuucdkbn() {
        return ztymrriyuucdkbn;
    }

    public void setZtymrriyuucdkbn(String pZtymrriyuucdkbn) {
        ztymrriyuucdkbn = pZtymrriyuucdkbn;
    }

    private String ztysntkinfotourokuyobi05;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSNTKINFOTOUROKUYOBI05)
    public String getZtysntkinfotourokuyobi05() {
        return ztysntkinfotourokuyobi05;
    }

    public void setZtysntkinfotourokuyobi05(String pZtysntkinfotourokuyobi05) {
        ztysntkinfotourokuyobi05 = pZtysntkinfotourokuyobi05;
    }

    private String ztysntkinfokyktorikesikbn;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSNTKINFOKYKTORIKESIKBN)
    public String getZtysntkinfokyktorikesikbn() {
        return ztysntkinfokyktorikesikbn;
    }

    public void setZtysntkinfokyktorikesikbn(String pZtysntkinfokyktorikesikbn) {
        ztysntkinfokyktorikesikbn = pZtysntkinfokyktorikesikbn;
    }

    private String ztysntkinfotourokuyobi06;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSNTKINFOTOUROKUYOBI06)
    public String getZtysntkinfotourokuyobi06() {
        return ztysntkinfotourokuyobi06;
    }

    public void setZtysntkinfotourokuyobi06(String pZtysntkinfotourokuyobi06) {
        ztysntkinfotourokuyobi06 = pZtysntkinfotourokuyobi06;
    }

    private String ztykdsssiharaijyoutaikbn;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKDSSSIHARAIJYOUTAIKBN)
    public String getZtykdsssiharaijyoutaikbn() {
        return ztykdsssiharaijyoutaikbn;
    }

    public void setZtykdsssiharaijyoutaikbn(String pZtykdsssiharaijyoutaikbn) {
        ztykdsssiharaijyoutaikbn = pZtykdsssiharaijyoutaikbn;
    }

    private String ztykdsssiharaiymd;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKDSSSIHARAIYMD)
    public String getZtykdsssiharaiymd() {
        return ztykdsssiharaiymd;
    }

    public void setZtykdsssiharaiymd(String pZtykdsssiharaiymd) {
        ztykdsssiharaiymd = pZtykdsssiharaiymd;
    }

    private String ztykdsymd;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKDSYMD)
    public String getZtykdsymd() {
        return ztykdsymd;
    }

    public void setZtykdsymd(String pZtykdsymd) {
        ztykdsymd = pZtykdsymd;
    }

    private String ztykdssiharaisosikicd;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYKDSSIHARAISOSIKICD)
    public String getZtykdssiharaisosikicd() {
        return ztykdssiharaisosikicd;
    }

    public void setZtykdssiharaisosikicd(String pZtykdssiharaisosikicd) {
        ztykdssiharaisosikicd = pZtykdssiharaisosikicd;
    }

    private String ztysntkinfotourokuyobi07;

    @Column(name=GenZT_SntkInfoTourokuTy.ZTYSNTKINFOTOUROKUYOBI07)
    public String getZtysntkinfotourokuyobi07() {
        return ztysntkinfotourokuyobi07;
    }

    public void setZtysntkinfotourokuyobi07(String pZtysntkinfotourokuyobi07) {
        ztysntkinfotourokuyobi07 = pZtysntkinfotourokuyobi07;
    }
}

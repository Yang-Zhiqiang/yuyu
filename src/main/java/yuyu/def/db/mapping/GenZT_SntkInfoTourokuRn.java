package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_SntkInfoTourokuRn;
import yuyu.def.db.id.PKZT_SntkInfoTourokuRn;
import yuyu.def.db.meta.GenQZT_SntkInfoTourokuRn;
import yuyu.def.db.meta.QZT_SntkInfoTourokuRn;

/**
 * 選択情報登録テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SntkInfoTourokuRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SntkInfoTourokuRn}</td><td colspan="3">選択情報登録テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsntkinfono zrnsntkinfono}</td><td>（連携用）選択情報番号</td><td align="center">{@link PKZT_SntkInfoTourokuRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrenno zrnrenno}</td><td>（連携用）連番</td><td align="center">{@link PKZT_SntkInfoTourokuRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinfotourokusyskbn zrnsntkinfotourokusyskbn}</td><td>（連携用）選択情報登録システム区分</td><td align="center">{@link PKZT_SntkInfoTourokuRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoriymd zrnsyoriymd}</td><td>（連携用）処理年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhuho2kyknokbn zrnhuho2kyknokbn}</td><td>（連携用）普保Ⅱ契約番号区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhuho2kykno zrnhuho2kykno}</td><td>（連携用）普保Ⅱ契約番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyouhncd zrnsyouhncd}</td><td>（連携用）商品コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinfofsegkbn zrnsntkinfofsegkbn}</td><td>（連携用）選択情報ＦＳＥＧ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinfofkojinkbn zrnsntkinfofkojinkbn}</td><td>（連携用）選択情報Ｆ個人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntaisyounm zrntaisyounm}</td><td>（連携用）対象者姓名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjtaisyounm zrnkjtaisyounm}</td><td>（連携用）対象者漢字姓名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntaisyouseiymd zrntaisyouseiymd}</td><td>（連携用）対象者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntaisyouseibetu zrntaisyouseibetu}</td><td>（連携用）対象者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketnaiyouarihyj zrndakuhiketnaiyouarihyj}</td><td>（連携用）諾否決定内容有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkktnaiyouarihyj zrnkktnaiyouarihyj}</td><td>（連携用）告知内容有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkijinaiyouarihyj zrnkijinaiyouarihyj}</td><td>（連携用）記事内容有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrarihyj zrnmrarihyj}</td><td>（連携用）ＭＲ有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkoudosyougaiarihyj zrnkoudosyougaiarihyj}</td><td>（連携用）高度障害有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntorikaijoarihyj zrntorikaijoarihyj}</td><td>（連携用）取消解除有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskhuseirituhyouji zrnskhuseirituhyouji}</td><td>（連携用）新契約不成立表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinfotourokuyobi01 zrnsntkinfotourokuyobi01}</td><td>（連携用）選択情報登録予備０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndeckbn zrndeckbn}</td><td>（連携用）ＤＥＣ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketymd zrnketymd}</td><td>（連携用）決定年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketkekkacd zrnketkekkacd}</td><td>（連携用）決定結果コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketriyuucd1 zrnketriyuucd1}</td><td>（連携用）決定理由コード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketriyuucd2 zrnketriyuucd2}</td><td>（連携用）決定理由コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketriyuucd3 zrnketriyuucd3}</td><td>（連携用）決定理由コード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketriyuucd4 zrnketriyuucd4}</td><td>（連携用）決定理由コード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketsyacd zrnketsyacd}</td><td>（連携用）決定者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinfotourokuyobi02 zrnsntkinfotourokuyobi02}</td><td>（連携用）選択情報登録予備０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinfosintyou zrnsntkinfosintyou}</td><td>（連携用）選択情報身長</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinfotaijyuu zrnsntkinfotaijyuu}</td><td>（連携用）選択情報体重</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkokutiymd zrnkokutiymd}</td><td>（連携用）告知年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinfotourokuyobi03 zrnsntkinfotourokuyobi03}</td><td>（連携用）選択情報登録予備０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoubyoucd1 zrnsyoubyoucd1}</td><td>（連携用）傷病コード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkantiym1 zrnkantiym1}</td><td>（連携用）完治年月１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoubyoucd2 zrnsyoubyoucd2}</td><td>（連携用）傷病コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkantiym2 zrnkantiym2}</td><td>（連携用）完治年月２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinfotourokuyobi04 zrnsntkinfotourokuyobi04}</td><td>（連携用）選択情報登録予備０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrriyuucdkbn zrnmrriyuucdkbn}</td><td>（連携用）ＭＲ理由コード区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinfotourokuyobi05 zrnsntkinfotourokuyobi05}</td><td>（連携用）選択情報登録予備０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinfokyktorikesikbn zrnsntkinfokyktorikesikbn}</td><td>（連携用）選択情報用契約取消処理区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinfotourokuyobi06 zrnsntkinfotourokuyobi06}</td><td>（連携用）選択情報登録予備０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkdsssiharaijyoutaikbn zrnkdsssiharaijyoutaikbn}</td><td>（連携用）高度障害Ｓ支払状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkdsssiharaiymd zrnkdsssiharaiymd}</td><td>（連携用）高度障害Ｓ支払年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkdsymd zrnkdsymd}</td><td>（連携用）高度障害年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkdssiharaisosikicd zrnkdssiharaisosikicd}</td><td>（連携用）高度障害支払組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinfotourokuyobi07 zrnsntkinfotourokuyobi07}</td><td>（連携用）選択情報登録予備０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SntkInfoTourokuRn
 * @see     PKZT_SntkInfoTourokuRn
 * @see     QZT_SntkInfoTourokuRn
 * @see     GenQZT_SntkInfoTourokuRn
 */
@MappedSuperclass
@Table(name=GenZT_SntkInfoTourokuRn.TABLE_NAME)
@IdClass(value=PKZT_SntkInfoTourokuRn.class)
public abstract class GenZT_SntkInfoTourokuRn extends AbstractExDBEntityForZDB<ZT_SntkInfoTourokuRn, PKZT_SntkInfoTourokuRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SntkInfoTourokuRn";
    public static final String ZRNSNTKINFONO            = "zrnsntkinfono";
    public static final String ZRNRENNO                 = "zrnrenno";
    public static final String ZRNSNTKINFOTOUROKUSYSKBN = "zrnsntkinfotourokusyskbn";
    public static final String ZRNSYORIYMD              = "zrnsyoriymd";
    public static final String ZRNHUHO2KYKNOKBN         = "zrnhuho2kyknokbn";
    public static final String ZRNHUHO2KYKNO            = "zrnhuho2kykno";
    public static final String ZRNSYOUHNCD              = "zrnsyouhncd";
    public static final String ZRNSNTKINFOFSEGKBN       = "zrnsntkinfofsegkbn";
    public static final String ZRNSNTKINFOFKOJINKBN     = "zrnsntkinfofkojinkbn";
    public static final String ZRNTAISYOUNM             = "zrntaisyounm";
    public static final String ZRNKJTAISYOUNM           = "zrnkjtaisyounm";
    public static final String ZRNTAISYOUSEIYMD         = "zrntaisyouseiymd";
    public static final String ZRNTAISYOUSEIBETU        = "zrntaisyouseibetu";
    public static final String ZRNDAKUHIKETNAIYOUARIHYJ = "zrndakuhiketnaiyouarihyj";
    public static final String ZRNKKTNAIYOUARIHYJ       = "zrnkktnaiyouarihyj";
    public static final String ZRNKIJINAIYOUARIHYJ      = "zrnkijinaiyouarihyj";
    public static final String ZRNMRARIHYJ              = "zrnmrarihyj";
    public static final String ZRNKOUDOSYOUGAIARIHYJ    = "zrnkoudosyougaiarihyj";
    public static final String ZRNTORIKAIJOARIHYJ       = "zrntorikaijoarihyj";
    public static final String ZRNSKHUSEIRITUHYOUJI     = "zrnskhuseirituhyouji";
    public static final String ZRNSNTKINFOTOUROKUYOBI01 = "zrnsntkinfotourokuyobi01";
    public static final String ZRNDECKBN                = "zrndeckbn";
    public static final String ZRNKETYMD                = "zrnketymd";
    public static final String ZRNKETKEKKACD            = "zrnketkekkacd";
    public static final String ZRNKETRIYUUCD1           = "zrnketriyuucd1";
    public static final String ZRNKETRIYUUCD2           = "zrnketriyuucd2";
    public static final String ZRNKETRIYUUCD3           = "zrnketriyuucd3";
    public static final String ZRNKETRIYUUCD4           = "zrnketriyuucd4";
    public static final String ZRNKETSYACD              = "zrnketsyacd";
    public static final String ZRNSNTKINFOTOUROKUYOBI02 = "zrnsntkinfotourokuyobi02";
    public static final String ZRNSNTKINFOSINTYOU       = "zrnsntkinfosintyou";
    public static final String ZRNSNTKINFOTAIJYUU       = "zrnsntkinfotaijyuu";
    public static final String ZRNKOKUTIYMD             = "zrnkokutiymd";
    public static final String ZRNSNTKINFOTOUROKUYOBI03 = "zrnsntkinfotourokuyobi03";
    public static final String ZRNSYOUBYOUCD1           = "zrnsyoubyoucd1";
    public static final String ZRNKANTIYM1              = "zrnkantiym1";
    public static final String ZRNSYOUBYOUCD2           = "zrnsyoubyoucd2";
    public static final String ZRNKANTIYM2              = "zrnkantiym2";
    public static final String ZRNSNTKINFOTOUROKUYOBI04 = "zrnsntkinfotourokuyobi04";
    public static final String ZRNMRRIYUUCDKBN          = "zrnmrriyuucdkbn";
    public static final String ZRNSNTKINFOTOUROKUYOBI05 = "zrnsntkinfotourokuyobi05";
    public static final String ZRNSNTKINFOKYKTORIKESIKBN = "zrnsntkinfokyktorikesikbn";
    public static final String ZRNSNTKINFOTOUROKUYOBI06 = "zrnsntkinfotourokuyobi06";
    public static final String ZRNKDSSSIHARAIJYOUTAIKBN = "zrnkdsssiharaijyoutaikbn";
    public static final String ZRNKDSSSIHARAIYMD        = "zrnkdsssiharaiymd";
    public static final String ZRNKDSYMD                = "zrnkdsymd";
    public static final String ZRNKDSSIHARAISOSIKICD    = "zrnkdssiharaisosikicd";
    public static final String ZRNSNTKINFOTOUROKUYOBI07 = "zrnsntkinfotourokuyobi07";

    private final PKZT_SntkInfoTourokuRn primaryKey;

    public GenZT_SntkInfoTourokuRn() {
        primaryKey = new PKZT_SntkInfoTourokuRn();
    }

    public GenZT_SntkInfoTourokuRn(
        String pZrnsntkinfono,
        String pZrnrenno,
        String pZrnsntkinfotourokusyskbn
    ) {
        primaryKey = new PKZT_SntkInfoTourokuRn(
            pZrnsntkinfono,
            pZrnrenno,
            pZrnsntkinfotourokusyskbn
        );
    }

    @Transient
    @Override
    public PKZT_SntkInfoTourokuRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SntkInfoTourokuRn> getMetaClass() {
        return QZT_SntkInfoTourokuRn.class;
    }

    @Id
    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSNTKINFONO)
    public String getZrnsntkinfono() {
        return getPrimaryKey().getZrnsntkinfono();
    }

    public void setZrnsntkinfono(String pZrnsntkinfono) {
        getPrimaryKey().setZrnsntkinfono(pZrnsntkinfono);
    }

    @Id
    @Column(name=GenZT_SntkInfoTourokuRn.ZRNRENNO)
    public String getZrnrenno() {
        return getPrimaryKey().getZrnrenno();
    }

    public void setZrnrenno(String pZrnrenno) {
        getPrimaryKey().setZrnrenno(pZrnrenno);
    }

    @Id
    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSNTKINFOTOUROKUSYSKBN)
    public String getZrnsntkinfotourokusyskbn() {
        return getPrimaryKey().getZrnsntkinfotourokusyskbn();
    }

    public void setZrnsntkinfotourokusyskbn(String pZrnsntkinfotourokusyskbn) {
        getPrimaryKey().setZrnsntkinfotourokusyskbn(pZrnsntkinfotourokusyskbn);
    }

    private String zrnsyoriymd;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSYORIYMD)
    public String getZrnsyoriymd() {
        return zrnsyoriymd;
    }

    public void setZrnsyoriymd(String pZrnsyoriymd) {
        zrnsyoriymd = pZrnsyoriymd;
    }

    private String zrnhuho2kyknokbn;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNHUHO2KYKNOKBN)
    public String getZrnhuho2kyknokbn() {
        return zrnhuho2kyknokbn;
    }

    public void setZrnhuho2kyknokbn(String pZrnhuho2kyknokbn) {
        zrnhuho2kyknokbn = pZrnhuho2kyknokbn;
    }

    private String zrnhuho2kykno;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNHUHO2KYKNO)
    public String getZrnhuho2kykno() {
        return zrnhuho2kykno;
    }

    public void setZrnhuho2kykno(String pZrnhuho2kykno) {
        zrnhuho2kykno = pZrnhuho2kykno;
    }

    private String zrnsyouhncd;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSYOUHNCD)
    public String getZrnsyouhncd() {
        return zrnsyouhncd;
    }

    public void setZrnsyouhncd(String pZrnsyouhncd) {
        zrnsyouhncd = pZrnsyouhncd;
    }

    private String zrnsntkinfofsegkbn;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSNTKINFOFSEGKBN)
    public String getZrnsntkinfofsegkbn() {
        return zrnsntkinfofsegkbn;
    }

    public void setZrnsntkinfofsegkbn(String pZrnsntkinfofsegkbn) {
        zrnsntkinfofsegkbn = pZrnsntkinfofsegkbn;
    }

    private String zrnsntkinfofkojinkbn;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSNTKINFOFKOJINKBN)
    public String getZrnsntkinfofkojinkbn() {
        return zrnsntkinfofkojinkbn;
    }

    public void setZrnsntkinfofkojinkbn(String pZrnsntkinfofkojinkbn) {
        zrnsntkinfofkojinkbn = pZrnsntkinfofkojinkbn;
    }

    private String zrntaisyounm;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNTAISYOUNM)
    public String getZrntaisyounm() {
        return zrntaisyounm;
    }

    public void setZrntaisyounm(String pZrntaisyounm) {
        zrntaisyounm = pZrntaisyounm;
    }

    private String zrnkjtaisyounm;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKJTAISYOUNM)
    public String getZrnkjtaisyounm() {
        return zrnkjtaisyounm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjtaisyounm(String pZrnkjtaisyounm) {
        zrnkjtaisyounm = pZrnkjtaisyounm;
    }

    private String zrntaisyouseiymd;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNTAISYOUSEIYMD)
    public String getZrntaisyouseiymd() {
        return zrntaisyouseiymd;
    }

    public void setZrntaisyouseiymd(String pZrntaisyouseiymd) {
        zrntaisyouseiymd = pZrntaisyouseiymd;
    }

    private String zrntaisyouseibetu;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNTAISYOUSEIBETU)
    public String getZrntaisyouseibetu() {
        return zrntaisyouseibetu;
    }

    public void setZrntaisyouseibetu(String pZrntaisyouseibetu) {
        zrntaisyouseibetu = pZrntaisyouseibetu;
    }

    private String zrndakuhiketnaiyouarihyj;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNDAKUHIKETNAIYOUARIHYJ)
    public String getZrndakuhiketnaiyouarihyj() {
        return zrndakuhiketnaiyouarihyj;
    }

    public void setZrndakuhiketnaiyouarihyj(String pZrndakuhiketnaiyouarihyj) {
        zrndakuhiketnaiyouarihyj = pZrndakuhiketnaiyouarihyj;
    }

    private String zrnkktnaiyouarihyj;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKKTNAIYOUARIHYJ)
    public String getZrnkktnaiyouarihyj() {
        return zrnkktnaiyouarihyj;
    }

    public void setZrnkktnaiyouarihyj(String pZrnkktnaiyouarihyj) {
        zrnkktnaiyouarihyj = pZrnkktnaiyouarihyj;
    }

    private String zrnkijinaiyouarihyj;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKIJINAIYOUARIHYJ)
    public String getZrnkijinaiyouarihyj() {
        return zrnkijinaiyouarihyj;
    }

    public void setZrnkijinaiyouarihyj(String pZrnkijinaiyouarihyj) {
        zrnkijinaiyouarihyj = pZrnkijinaiyouarihyj;
    }

    private String zrnmrarihyj;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNMRARIHYJ)
    public String getZrnmrarihyj() {
        return zrnmrarihyj;
    }

    public void setZrnmrarihyj(String pZrnmrarihyj) {
        zrnmrarihyj = pZrnmrarihyj;
    }

    private String zrnkoudosyougaiarihyj;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKOUDOSYOUGAIARIHYJ)
    public String getZrnkoudosyougaiarihyj() {
        return zrnkoudosyougaiarihyj;
    }

    public void setZrnkoudosyougaiarihyj(String pZrnkoudosyougaiarihyj) {
        zrnkoudosyougaiarihyj = pZrnkoudosyougaiarihyj;
    }

    private String zrntorikaijoarihyj;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNTORIKAIJOARIHYJ)
    public String getZrntorikaijoarihyj() {
        return zrntorikaijoarihyj;
    }

    public void setZrntorikaijoarihyj(String pZrntorikaijoarihyj) {
        zrntorikaijoarihyj = pZrntorikaijoarihyj;
    }

    private String zrnskhuseirituhyouji;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSKHUSEIRITUHYOUJI)
    public String getZrnskhuseirituhyouji() {
        return zrnskhuseirituhyouji;
    }

    public void setZrnskhuseirituhyouji(String pZrnskhuseirituhyouji) {
        zrnskhuseirituhyouji = pZrnskhuseirituhyouji;
    }

    private String zrnsntkinfotourokuyobi01;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSNTKINFOTOUROKUYOBI01)
    public String getZrnsntkinfotourokuyobi01() {
        return zrnsntkinfotourokuyobi01;
    }

    public void setZrnsntkinfotourokuyobi01(String pZrnsntkinfotourokuyobi01) {
        zrnsntkinfotourokuyobi01 = pZrnsntkinfotourokuyobi01;
    }

    private String zrndeckbn;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNDECKBN)
    public String getZrndeckbn() {
        return zrndeckbn;
    }

    public void setZrndeckbn(String pZrndeckbn) {
        zrndeckbn = pZrndeckbn;
    }

    private String zrnketymd;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKETYMD)
    public String getZrnketymd() {
        return zrnketymd;
    }

    public void setZrnketymd(String pZrnketymd) {
        zrnketymd = pZrnketymd;
    }

    private String zrnketkekkacd;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKETKEKKACD)
    public String getZrnketkekkacd() {
        return zrnketkekkacd;
    }

    public void setZrnketkekkacd(String pZrnketkekkacd) {
        zrnketkekkacd = pZrnketkekkacd;
    }

    private String zrnketriyuucd1;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKETRIYUUCD1)
    public String getZrnketriyuucd1() {
        return zrnketriyuucd1;
    }

    public void setZrnketriyuucd1(String pZrnketriyuucd1) {
        zrnketriyuucd1 = pZrnketriyuucd1;
    }

    private String zrnketriyuucd2;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKETRIYUUCD2)
    public String getZrnketriyuucd2() {
        return zrnketriyuucd2;
    }

    public void setZrnketriyuucd2(String pZrnketriyuucd2) {
        zrnketriyuucd2 = pZrnketriyuucd2;
    }

    private String zrnketriyuucd3;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKETRIYUUCD3)
    public String getZrnketriyuucd3() {
        return zrnketriyuucd3;
    }

    public void setZrnketriyuucd3(String pZrnketriyuucd3) {
        zrnketriyuucd3 = pZrnketriyuucd3;
    }

    private String zrnketriyuucd4;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKETRIYUUCD4)
    public String getZrnketriyuucd4() {
        return zrnketriyuucd4;
    }

    public void setZrnketriyuucd4(String pZrnketriyuucd4) {
        zrnketriyuucd4 = pZrnketriyuucd4;
    }

    private String zrnketsyacd;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKETSYACD)
    public String getZrnketsyacd() {
        return zrnketsyacd;
    }

    public void setZrnketsyacd(String pZrnketsyacd) {
        zrnketsyacd = pZrnketsyacd;
    }

    private String zrnsntkinfotourokuyobi02;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSNTKINFOTOUROKUYOBI02)
    public String getZrnsntkinfotourokuyobi02() {
        return zrnsntkinfotourokuyobi02;
    }

    public void setZrnsntkinfotourokuyobi02(String pZrnsntkinfotourokuyobi02) {
        zrnsntkinfotourokuyobi02 = pZrnsntkinfotourokuyobi02;
    }

    private String zrnsntkinfosintyou;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSNTKINFOSINTYOU)
    public String getZrnsntkinfosintyou() {
        return zrnsntkinfosintyou;
    }

    public void setZrnsntkinfosintyou(String pZrnsntkinfosintyou) {
        zrnsntkinfosintyou = pZrnsntkinfosintyou;
    }

    private String zrnsntkinfotaijyuu;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSNTKINFOTAIJYUU)
    public String getZrnsntkinfotaijyuu() {
        return zrnsntkinfotaijyuu;
    }

    public void setZrnsntkinfotaijyuu(String pZrnsntkinfotaijyuu) {
        zrnsntkinfotaijyuu = pZrnsntkinfotaijyuu;
    }

    private String zrnkokutiymd;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKOKUTIYMD)
    public String getZrnkokutiymd() {
        return zrnkokutiymd;
    }

    public void setZrnkokutiymd(String pZrnkokutiymd) {
        zrnkokutiymd = pZrnkokutiymd;
    }

    private String zrnsntkinfotourokuyobi03;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSNTKINFOTOUROKUYOBI03)
    public String getZrnsntkinfotourokuyobi03() {
        return zrnsntkinfotourokuyobi03;
    }

    public void setZrnsntkinfotourokuyobi03(String pZrnsntkinfotourokuyobi03) {
        zrnsntkinfotourokuyobi03 = pZrnsntkinfotourokuyobi03;
    }

    private String zrnsyoubyoucd1;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSYOUBYOUCD1)
    public String getZrnsyoubyoucd1() {
        return zrnsyoubyoucd1;
    }

    public void setZrnsyoubyoucd1(String pZrnsyoubyoucd1) {
        zrnsyoubyoucd1 = pZrnsyoubyoucd1;
    }

    private String zrnkantiym1;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKANTIYM1)
    public String getZrnkantiym1() {
        return zrnkantiym1;
    }

    public void setZrnkantiym1(String pZrnkantiym1) {
        zrnkantiym1 = pZrnkantiym1;
    }

    private String zrnsyoubyoucd2;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSYOUBYOUCD2)
    public String getZrnsyoubyoucd2() {
        return zrnsyoubyoucd2;
    }

    public void setZrnsyoubyoucd2(String pZrnsyoubyoucd2) {
        zrnsyoubyoucd2 = pZrnsyoubyoucd2;
    }

    private String zrnkantiym2;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKANTIYM2)
    public String getZrnkantiym2() {
        return zrnkantiym2;
    }

    public void setZrnkantiym2(String pZrnkantiym2) {
        zrnkantiym2 = pZrnkantiym2;
    }

    private String zrnsntkinfotourokuyobi04;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSNTKINFOTOUROKUYOBI04)
    public String getZrnsntkinfotourokuyobi04() {
        return zrnsntkinfotourokuyobi04;
    }

    public void setZrnsntkinfotourokuyobi04(String pZrnsntkinfotourokuyobi04) {
        zrnsntkinfotourokuyobi04 = pZrnsntkinfotourokuyobi04;
    }

    private String zrnmrriyuucdkbn;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNMRRIYUUCDKBN)
    public String getZrnmrriyuucdkbn() {
        return zrnmrriyuucdkbn;
    }

    public void setZrnmrriyuucdkbn(String pZrnmrriyuucdkbn) {
        zrnmrriyuucdkbn = pZrnmrriyuucdkbn;
    }

    private String zrnsntkinfotourokuyobi05;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSNTKINFOTOUROKUYOBI05)
    public String getZrnsntkinfotourokuyobi05() {
        return zrnsntkinfotourokuyobi05;
    }

    public void setZrnsntkinfotourokuyobi05(String pZrnsntkinfotourokuyobi05) {
        zrnsntkinfotourokuyobi05 = pZrnsntkinfotourokuyobi05;
    }

    private String zrnsntkinfokyktorikesikbn;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSNTKINFOKYKTORIKESIKBN)
    public String getZrnsntkinfokyktorikesikbn() {
        return zrnsntkinfokyktorikesikbn;
    }

    public void setZrnsntkinfokyktorikesikbn(String pZrnsntkinfokyktorikesikbn) {
        zrnsntkinfokyktorikesikbn = pZrnsntkinfokyktorikesikbn;
    }

    private String zrnsntkinfotourokuyobi06;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSNTKINFOTOUROKUYOBI06)
    public String getZrnsntkinfotourokuyobi06() {
        return zrnsntkinfotourokuyobi06;
    }

    public void setZrnsntkinfotourokuyobi06(String pZrnsntkinfotourokuyobi06) {
        zrnsntkinfotourokuyobi06 = pZrnsntkinfotourokuyobi06;
    }

    private String zrnkdsssiharaijyoutaikbn;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKDSSSIHARAIJYOUTAIKBN)
    public String getZrnkdsssiharaijyoutaikbn() {
        return zrnkdsssiharaijyoutaikbn;
    }

    public void setZrnkdsssiharaijyoutaikbn(String pZrnkdsssiharaijyoutaikbn) {
        zrnkdsssiharaijyoutaikbn = pZrnkdsssiharaijyoutaikbn;
    }

    private String zrnkdsssiharaiymd;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKDSSSIHARAIYMD)
    public String getZrnkdsssiharaiymd() {
        return zrnkdsssiharaiymd;
    }

    public void setZrnkdsssiharaiymd(String pZrnkdsssiharaiymd) {
        zrnkdsssiharaiymd = pZrnkdsssiharaiymd;
    }

    private String zrnkdsymd;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKDSYMD)
    public String getZrnkdsymd() {
        return zrnkdsymd;
    }

    public void setZrnkdsymd(String pZrnkdsymd) {
        zrnkdsymd = pZrnkdsymd;
    }

    private String zrnkdssiharaisosikicd;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNKDSSIHARAISOSIKICD)
    public String getZrnkdssiharaisosikicd() {
        return zrnkdssiharaisosikicd;
    }

    public void setZrnkdssiharaisosikicd(String pZrnkdssiharaisosikicd) {
        zrnkdssiharaisosikicd = pZrnkdssiharaisosikicd;
    }

    private String zrnsntkinfotourokuyobi07;

    @Column(name=GenZT_SntkInfoTourokuRn.ZRNSNTKINFOTOUROKUYOBI07)
    public String getZrnsntkinfotourokuyobi07() {
        return zrnsntkinfotourokuyobi07;
    }

    public void setZrnsntkinfotourokuyobi07(String pZrnsntkinfotourokuyobi07) {
        zrnsntkinfotourokuyobi07 = pZrnsntkinfotourokuyobi07;
    }
}
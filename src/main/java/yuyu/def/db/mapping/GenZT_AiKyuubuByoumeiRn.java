package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_AiKyuubuByoumeiRn;
import yuyu.def.db.id.PKZT_AiKyuubuByoumeiRn;
import yuyu.def.db.meta.GenQZT_AiKyuubuByoumeiRn;
import yuyu.def.db.meta.QZT_AiKyuubuByoumeiRn;

/**
 * あいキューブ病名マスタ送信データテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_AiKyuubuByoumeiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_AiKyuubuByoumeiRn}</td><td colspan="3">あいキューブ病名マスタ送信データテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnbyoumeitourokuno zrnbyoumeitourokuno}</td><td>（連携用）病名登録番号</td><td align="center">{@link PKZT_AiKyuubuByoumeiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbyoumei zrnbyoumei}</td><td>（連携用）病名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbyoumeizenkaku zrnbyoumeizenkaku}</td><td>（連携用）病名全角</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbyoumeihurigana zrnbyoumeihurigana}</td><td>（連携用）病名フリガナ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbyoumeihuriganakensaku zrnbyoumeihuriganakensaku}</td><td>（連携用）病名フリガナ検索用</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbyoumeicd zrnbyoumeicd}</td><td>（連携用）病名コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbyoumeibuicd zrnbyoumeibuicd}</td><td>（連携用）病名部位コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaitoukbn1 zrngaitoukbn1}</td><td>（連携用）該当区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaitoukbn2 zrngaitoukbn2}</td><td>（連携用）該当区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaitoukbn3 zrngaitoukbn3}</td><td>（連携用）該当区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaitoukbn4 zrngaitoukbn4}</td><td>（連携用）該当区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaitoukbn5 zrngaitoukbn5}</td><td>（連携用）該当区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuuimongon zrntyuuimongon}</td><td>（連携用）注意文言</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 * </table>
 * @see     ZT_AiKyuubuByoumeiRn
 * @see     PKZT_AiKyuubuByoumeiRn
 * @see     QZT_AiKyuubuByoumeiRn
 * @see     GenQZT_AiKyuubuByoumeiRn
 */
@MappedSuperclass
@Table(name=GenZT_AiKyuubuByoumeiRn.TABLE_NAME)
@IdClass(value=PKZT_AiKyuubuByoumeiRn.class)
public abstract class GenZT_AiKyuubuByoumeiRn extends AbstractExDBEntityForZDB<ZT_AiKyuubuByoumeiRn, PKZT_AiKyuubuByoumeiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_AiKyuubuByoumeiRn";
    public static final String ZRNBYOUMEITOUROKUNO      = "zrnbyoumeitourokuno";
    public static final String ZRNBYOUMEI               = "zrnbyoumei";
    public static final String ZRNBYOUMEIZENKAKU        = "zrnbyoumeizenkaku";
    public static final String ZRNBYOUMEIHURIGANA       = "zrnbyoumeihurigana";
    public static final String ZRNBYOUMEIHURIGANAKENSAKU = "zrnbyoumeihuriganakensaku";
    public static final String ZRNBYOUMEICD             = "zrnbyoumeicd";
    public static final String ZRNBYOUMEIBUICD          = "zrnbyoumeibuicd";
    public static final String ZRNGAITOUKBN1            = "zrngaitoukbn1";
    public static final String ZRNGAITOUKBN2            = "zrngaitoukbn2";
    public static final String ZRNGAITOUKBN3            = "zrngaitoukbn3";
    public static final String ZRNGAITOUKBN4            = "zrngaitoukbn4";
    public static final String ZRNGAITOUKBN5            = "zrngaitoukbn5";
    public static final String ZRNTYUUIMONGON           = "zrntyuuimongon";

    private final PKZT_AiKyuubuByoumeiRn primaryKey;

    public GenZT_AiKyuubuByoumeiRn() {
        primaryKey = new PKZT_AiKyuubuByoumeiRn();
    }

    public GenZT_AiKyuubuByoumeiRn(String pZrnbyoumeitourokuno) {
        primaryKey = new PKZT_AiKyuubuByoumeiRn(pZrnbyoumeitourokuno);
    }

    @Transient
    @Override
    public PKZT_AiKyuubuByoumeiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_AiKyuubuByoumeiRn> getMetaClass() {
        return QZT_AiKyuubuByoumeiRn.class;
    }

    @Id
    @Column(name=GenZT_AiKyuubuByoumeiRn.ZRNBYOUMEITOUROKUNO)
    public String getZrnbyoumeitourokuno() {
        return getPrimaryKey().getZrnbyoumeitourokuno();
    }

    public void setZrnbyoumeitourokuno(String pZrnbyoumeitourokuno) {
        getPrimaryKey().setZrnbyoumeitourokuno(pZrnbyoumeitourokuno);
    }

    private String zrnbyoumei;

    @Column(name=GenZT_AiKyuubuByoumeiRn.ZRNBYOUMEI)
    public String getZrnbyoumei() {
        return zrnbyoumei;
    }

    @DataConvert("toMultiByte")
    public void setZrnbyoumei(String pZrnbyoumei) {
        zrnbyoumei = pZrnbyoumei;
    }

    private String zrnbyoumeizenkaku;

    @Column(name=GenZT_AiKyuubuByoumeiRn.ZRNBYOUMEIZENKAKU)
    public String getZrnbyoumeizenkaku() {
        return zrnbyoumeizenkaku;
    }

    @DataConvert("toMultiByte")
    public void setZrnbyoumeizenkaku(String pZrnbyoumeizenkaku) {
        zrnbyoumeizenkaku = pZrnbyoumeizenkaku;
    }

    private String zrnbyoumeihurigana;

    @Column(name=GenZT_AiKyuubuByoumeiRn.ZRNBYOUMEIHURIGANA)
    public String getZrnbyoumeihurigana() {
        return zrnbyoumeihurigana;
    }

    public void setZrnbyoumeihurigana(String pZrnbyoumeihurigana) {
        zrnbyoumeihurigana = pZrnbyoumeihurigana;
    }

    private String zrnbyoumeihuriganakensaku;

    @Column(name=GenZT_AiKyuubuByoumeiRn.ZRNBYOUMEIHURIGANAKENSAKU)
    public String getZrnbyoumeihuriganakensaku() {
        return zrnbyoumeihuriganakensaku;
    }

    public void setZrnbyoumeihuriganakensaku(String pZrnbyoumeihuriganakensaku) {
        zrnbyoumeihuriganakensaku = pZrnbyoumeihuriganakensaku;
    }

    private String zrnbyoumeicd;

    @Column(name=GenZT_AiKyuubuByoumeiRn.ZRNBYOUMEICD)
    public String getZrnbyoumeicd() {
        return zrnbyoumeicd;
    }

    public void setZrnbyoumeicd(String pZrnbyoumeicd) {
        zrnbyoumeicd = pZrnbyoumeicd;
    }

    private String zrnbyoumeibuicd;

    @Column(name=GenZT_AiKyuubuByoumeiRn.ZRNBYOUMEIBUICD)
    public String getZrnbyoumeibuicd() {
        return zrnbyoumeibuicd;
    }

    public void setZrnbyoumeibuicd(String pZrnbyoumeibuicd) {
        zrnbyoumeibuicd = pZrnbyoumeibuicd;
    }

    private String zrngaitoukbn1;

    @Column(name=GenZT_AiKyuubuByoumeiRn.ZRNGAITOUKBN1)
    public String getZrngaitoukbn1() {
        return zrngaitoukbn1;
    }

    public void setZrngaitoukbn1(String pZrngaitoukbn1) {
        zrngaitoukbn1 = pZrngaitoukbn1;
    }

    private String zrngaitoukbn2;

    @Column(name=GenZT_AiKyuubuByoumeiRn.ZRNGAITOUKBN2)
    public String getZrngaitoukbn2() {
        return zrngaitoukbn2;
    }

    public void setZrngaitoukbn2(String pZrngaitoukbn2) {
        zrngaitoukbn2 = pZrngaitoukbn2;
    }

    private String zrngaitoukbn3;

    @Column(name=GenZT_AiKyuubuByoumeiRn.ZRNGAITOUKBN3)
    public String getZrngaitoukbn3() {
        return zrngaitoukbn3;
    }

    public void setZrngaitoukbn3(String pZrngaitoukbn3) {
        zrngaitoukbn3 = pZrngaitoukbn3;
    }

    private String zrngaitoukbn4;

    @Column(name=GenZT_AiKyuubuByoumeiRn.ZRNGAITOUKBN4)
    public String getZrngaitoukbn4() {
        return zrngaitoukbn4;
    }

    public void setZrngaitoukbn4(String pZrngaitoukbn4) {
        zrngaitoukbn4 = pZrngaitoukbn4;
    }

    private String zrngaitoukbn5;

    @Column(name=GenZT_AiKyuubuByoumeiRn.ZRNGAITOUKBN5)
    public String getZrngaitoukbn5() {
        return zrngaitoukbn5;
    }

    public void setZrngaitoukbn5(String pZrngaitoukbn5) {
        zrngaitoukbn5 = pZrngaitoukbn5;
    }

    private String zrntyuuimongon;

    @Column(name=GenZT_AiKyuubuByoumeiRn.ZRNTYUUIMONGON)
    public String getZrntyuuimongon() {
        return zrntyuuimongon;
    }

    @DataConvert("toMultiByte")
    public void setZrntyuuimongon(String pZrntyuuimongon) {
        zrntyuuimongon = pZrntyuuimongon;
    }
}
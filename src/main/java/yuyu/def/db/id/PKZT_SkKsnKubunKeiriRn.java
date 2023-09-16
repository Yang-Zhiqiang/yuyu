package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SkKsnKubunKeiriRn;
import yuyu.def.db.mapping.GenZT_SkKsnKubunKeiriRn;
import yuyu.def.db.meta.GenQZT_SkKsnKubunKeiriRn;
import yuyu.def.db.meta.QZT_SkKsnKubunKeiriRn;

/**
 * 新契約決算用区分経理Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkKsnKubunKeiriRn}</td><td colspan="3">新契約決算用区分経理Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnkaikeitani</td><td>（連携用）会計単位</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsystemkbnnum</td><td>（連携用）システム区分（数値）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoricd</td><td>（連携用）処理コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntorihikiymd zrntorihikiymd}</td><td>（連携用）取引年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntorihikinon7 zrntorihikinon7}</td><td>（連携用）取引番号Ｎ７</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuuryokubasyo</td><td>（連携用）入力場所</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuuryokusyacd</td><td>（連携用）入力者コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoriymdn</td><td>（連携用）処理年月日（数値）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkessankbn</td><td>（連携用）決算区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnonlinesyorikbn</td><td>（連携用）オンライン処理区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv28</td><td>（連携用）予備項目Ｖ２８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjyoukbnn</td><td>（連携用）勘定区分（数値）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntaisyakukbnn zrntaisyakukbnn}</td><td>（連携用）貸借区分（数値）</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkanjyoukamokucdn zrnkanjyoukamokucdn}</td><td>（連携用）勘定科目コード（数値）</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv4</td><td>（連携用）予備項目Ｖ４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsuitoubumoncd zrnsuitoubumoncd}</td><td>（連携用）出納部門コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkingaku</td><td>（連携用）金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkizokusegment zrnkizokusegment}</td><td>（連携用）帰属セグメント</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnaitesegment zrnaitesegment}</td><td>（連携用）相手セグメント</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv23</td><td>（連携用）予備項目Ｖ２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkKsnKubunKeiriRn
 * @see     GenZT_SkKsnKubunKeiriRn
 * @see     QZT_SkKsnKubunKeiriRn
 * @see     GenQZT_SkKsnKubunKeiriRn
 */
public class PKZT_SkKsnKubunKeiriRn extends AbstractExDBPrimaryKey<ZT_SkKsnKubunKeiriRn, PKZT_SkKsnKubunKeiriRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SkKsnKubunKeiriRn() {
    }

    public PKZT_SkKsnKubunKeiriRn(
        String pZrntorihikiymd,
        String pZrntorihikinon7,
        String pZrntaisyakukbnn,
        String pZrnkanjyoukamokucdn,
        String pZrnsuitoubumoncd,
        String pZrnkizokusegment,
        String pZrnaitesegment
    ) {
        zrntorihikiymd = pZrntorihikiymd;
        zrntorihikinon7 = pZrntorihikinon7;
        zrntaisyakukbnn = pZrntaisyakukbnn;
        zrnkanjyoukamokucdn = pZrnkanjyoukamokucdn;
        zrnsuitoubumoncd = pZrnsuitoubumoncd;
        zrnkizokusegment = pZrnkizokusegment;
        zrnaitesegment = pZrnaitesegment;
    }

    @Transient
    @Override
    public Class<ZT_SkKsnKubunKeiriRn> getEntityClass() {
        return ZT_SkKsnKubunKeiriRn.class;
    }

    private String zrntorihikiymd;

    public String getZrntorihikiymd() {
        return zrntorihikiymd;
    }

    public void setZrntorihikiymd(String pZrntorihikiymd) {
        zrntorihikiymd = pZrntorihikiymd;
    }
    private String zrntorihikinon7;

    public String getZrntorihikinon7() {
        return zrntorihikinon7;
    }

    public void setZrntorihikinon7(String pZrntorihikinon7) {
        zrntorihikinon7 = pZrntorihikinon7;
    }
    private String zrntaisyakukbnn;

    public String getZrntaisyakukbnn() {
        return zrntaisyakukbnn;
    }

    public void setZrntaisyakukbnn(String pZrntaisyakukbnn) {
        zrntaisyakukbnn = pZrntaisyakukbnn;
    }
    private String zrnkanjyoukamokucdn;

    public String getZrnkanjyoukamokucdn() {
        return zrnkanjyoukamokucdn;
    }

    public void setZrnkanjyoukamokucdn(String pZrnkanjyoukamokucdn) {
        zrnkanjyoukamokucdn = pZrnkanjyoukamokucdn;
    }
    private String zrnsuitoubumoncd;

    public String getZrnsuitoubumoncd() {
        return zrnsuitoubumoncd;
    }

    public void setZrnsuitoubumoncd(String pZrnsuitoubumoncd) {
        zrnsuitoubumoncd = pZrnsuitoubumoncd;
    }
    private String zrnkizokusegment;

    public String getZrnkizokusegment() {
        return zrnkizokusegment;
    }

    public void setZrnkizokusegment(String pZrnkizokusegment) {
        zrnkizokusegment = pZrnkizokusegment;
    }
    private String zrnaitesegment;

    public String getZrnaitesegment() {
        return zrnaitesegment;
    }

    public void setZrnaitesegment(String pZrnaitesegment) {
        zrnaitesegment = pZrnaitesegment;
    }

}
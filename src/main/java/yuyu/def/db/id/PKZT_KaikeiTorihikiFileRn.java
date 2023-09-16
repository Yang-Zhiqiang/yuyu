package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KaikeiTorihikiFileRn;
import yuyu.def.db.mapping.GenZT_KaikeiTorihikiFileRn;
import yuyu.def.db.meta.GenQZT_KaikeiTorihikiFileRn;
import yuyu.def.db.meta.QZT_KaikeiTorihikiFileRn;

/**
 * 会計取引ファイルテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KaikeiTorihikiFileRn}</td><td colspan="3">会計取引ファイルテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnlen</td><td>（連携用）ＬＥＮ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaikeitani</td><td>（連携用）会計単位</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsystemkbnnum</td><td>（連携用）システム区分（数値）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoricd</td><td>（連携用）処理コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntorihikiymd zrntorihikiymd}</td><td>（連携用）取引年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntorihikinon7 zrntorihikinon7}</td><td>（連携用）取引番号Ｎ７</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuuryokubasyo</td><td>（連携用）入力場所</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuuryokusyacd</td><td>（連携用）入力者コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoriymdn</td><td>（連携用）処理年月日（数値）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimekirikbn</td><td>（連携用）締切区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkessankbn</td><td>（連携用）決算区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv20</td><td>（連携用）予備項目Ｖ２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaisyakantorihikikbn</td><td>（連携用）会社間取引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntukekaekbn</td><td>（連携用）付替区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntablekosuu</td><td>（連携用）テーブル個数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjyoukbnn</td><td>（連携用）勘定区分（数値）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntaisyakukbnn zrntaisyakukbnn}</td><td>（連携用）貸借区分（数値）</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkanjyoukamokucdn zrnkanjyoukamokucdn}</td><td>（連携用）勘定科目コード（数値）</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv4</td><td>（連携用）予備項目Ｖ４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsuitoubumon zrnsuitoubumon}</td><td>（連携用）出納部門</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkingaku</td><td>（連携用）金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntekiyoucd zrntekiyoucd}</td><td>（連携用）摘要コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10</td><td>（連携用）予備項目Ｖ１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmeisaikanryoukbn</td><td>（連携用）明細完了区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KaikeiTorihikiFileRn
 * @see     GenZT_KaikeiTorihikiFileRn
 * @see     QZT_KaikeiTorihikiFileRn
 * @see     GenQZT_KaikeiTorihikiFileRn
 */
public class PKZT_KaikeiTorihikiFileRn extends AbstractExDBPrimaryKey<ZT_KaikeiTorihikiFileRn, PKZT_KaikeiTorihikiFileRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KaikeiTorihikiFileRn() {
    }

    public PKZT_KaikeiTorihikiFileRn(
        String pZrntorihikiymd,
        String pZrntorihikinon7,
        String pZrntaisyakukbnn,
        String pZrnkanjyoukamokucdn,
        String pZrnsuitoubumon,
        String pZrntekiyoucd
    ) {
        zrntorihikiymd = pZrntorihikiymd;
        zrntorihikinon7 = pZrntorihikinon7;
        zrntaisyakukbnn = pZrntaisyakukbnn;
        zrnkanjyoukamokucdn = pZrnkanjyoukamokucdn;
        zrnsuitoubumon = pZrnsuitoubumon;
        zrntekiyoucd = pZrntekiyoucd;
    }

    @Transient
    @Override
    public Class<ZT_KaikeiTorihikiFileRn> getEntityClass() {
        return ZT_KaikeiTorihikiFileRn.class;
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
    private String zrnsuitoubumon;

    public String getZrnsuitoubumon() {
        return zrnsuitoubumon;
    }

    public void setZrnsuitoubumon(String pZrnsuitoubumon) {
        zrnsuitoubumon = pZrnsuitoubumon;
    }
    private String zrntekiyoucd;

    public String getZrntekiyoucd() {
        return zrntekiyoucd;
    }

    public void setZrntekiyoucd(String pZrntekiyoucd) {
        zrntekiyoucd = pZrntekiyoucd;
    }

}
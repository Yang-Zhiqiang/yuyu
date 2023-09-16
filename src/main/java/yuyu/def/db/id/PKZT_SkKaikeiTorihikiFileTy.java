package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SkKaikeiTorihikiFileTy;
import yuyu.def.db.mapping.GenZT_SkKaikeiTorihikiFileTy;
import yuyu.def.db.meta.GenQZT_SkKaikeiTorihikiFileTy;
import yuyu.def.db.meta.QZT_SkKaikeiTorihikiFileTy;

/**
 * 新契約会計取引ファイルテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkKaikeiTorihikiFileTy}</td><td colspan="3">新契約会計取引ファイルテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztylen</td><td>（中継用）ＬＥＮ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaikeitani</td><td>（中継用）会計単位</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysystemkbnnum</td><td>（中継用）システム区分（数値）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoricd</td><td>（中継用）処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytorihikiymd ztytorihikiymd}</td><td>（中継用）取引年月日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytorihikinon7 ztytorihikinon7}</td><td>（中継用）取引番号Ｎ７</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyuuryokubasyo</td><td>（中継用）入力場所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyuuryokusyacd</td><td>（中継用）入力者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoriymdn</td><td>（中継用）処理年月日（数値）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimekirikbn</td><td>（中継用）締切区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykessankbn</td><td>（中継用）決算区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv20</td><td>（中継用）予備項目Ｖ２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaisyakantorihikikbn</td><td>（中継用）会社間取引区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytukekaekbn</td><td>（中継用）付替区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytablekosuu</td><td>（中継用）テーブル個数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanjyoukbnn</td><td>（中継用）勘定区分（数値）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytaisyakukbnn ztytaisyakukbnn}</td><td>（中継用）貸借区分（数値）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykanjyoukamokucdn ztykanjyoukamokucdn}</td><td>（中継用）勘定科目コード（数値）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv4</td><td>（中継用）予備項目Ｖ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysuitoubumon ztysuitoubumon}</td><td>（中継用）出納部門</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykingaku</td><td>（中継用）金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytekiyoucd ztytekiyoucd}</td><td>（中継用）摘要コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10</td><td>（中継用）予備項目Ｖ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymeisaikanryoukbn</td><td>（中継用）明細完了区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkKaikeiTorihikiFileTy
 * @see     GenZT_SkKaikeiTorihikiFileTy
 * @see     QZT_SkKaikeiTorihikiFileTy
 * @see     GenQZT_SkKaikeiTorihikiFileTy
 */
public class PKZT_SkKaikeiTorihikiFileTy extends AbstractExDBPrimaryKey<ZT_SkKaikeiTorihikiFileTy, PKZT_SkKaikeiTorihikiFileTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SkKaikeiTorihikiFileTy() {
    }

    public PKZT_SkKaikeiTorihikiFileTy(
        String pZtytorihikiymd,
        String pZtytorihikinon7,
        String pZtytaisyakukbnn,
        String pZtykanjyoukamokucdn,
        String pZtysuitoubumon,
        String pZtytekiyoucd
    ) {
        ztytorihikiymd = pZtytorihikiymd;
        ztytorihikinon7 = pZtytorihikinon7;
        ztytaisyakukbnn = pZtytaisyakukbnn;
        ztykanjyoukamokucdn = pZtykanjyoukamokucdn;
        ztysuitoubumon = pZtysuitoubumon;
        ztytekiyoucd = pZtytekiyoucd;
    }

    @Transient
    @Override
    public Class<ZT_SkKaikeiTorihikiFileTy> getEntityClass() {
        return ZT_SkKaikeiTorihikiFileTy.class;
    }

    private String ztytorihikiymd;

    public String getZtytorihikiymd() {
        return ztytorihikiymd;
    }

    public void setZtytorihikiymd(String pZtytorihikiymd) {
        ztytorihikiymd = pZtytorihikiymd;
    }
    private String ztytorihikinon7;

    public String getZtytorihikinon7() {
        return ztytorihikinon7;
    }

    public void setZtytorihikinon7(String pZtytorihikinon7) {
        ztytorihikinon7 = pZtytorihikinon7;
    }
    private String ztytaisyakukbnn;

    public String getZtytaisyakukbnn() {
        return ztytaisyakukbnn;
    }

    public void setZtytaisyakukbnn(String pZtytaisyakukbnn) {
        ztytaisyakukbnn = pZtytaisyakukbnn;
    }
    private String ztykanjyoukamokucdn;

    public String getZtykanjyoukamokucdn() {
        return ztykanjyoukamokucdn;
    }

    public void setZtykanjyoukamokucdn(String pZtykanjyoukamokucdn) {
        ztykanjyoukamokucdn = pZtykanjyoukamokucdn;
    }
    private String ztysuitoubumon;

    public String getZtysuitoubumon() {
        return ztysuitoubumon;
    }

    public void setZtysuitoubumon(String pZtysuitoubumon) {
        ztysuitoubumon = pZtysuitoubumon;
    }
    private String ztytekiyoucd;

    public String getZtytekiyoucd() {
        return ztytekiyoucd;
    }

    public void setZtytekiyoucd(String pZtytekiyoucd) {
        ztytekiyoucd = pZtytekiyoucd;
    }

}
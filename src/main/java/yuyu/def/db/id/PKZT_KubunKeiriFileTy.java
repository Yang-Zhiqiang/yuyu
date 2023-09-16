package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KubunKeiriFileTy;
import yuyu.def.db.mapping.GenZT_KubunKeiriFileTy;
import yuyu.def.db.meta.GenQZT_KubunKeiriFileTy;
import yuyu.def.db.meta.QZT_KubunKeiriFileTy;

/**
 * 区分経理ファイルテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KubunKeiriFileTy}</td><td colspan="3">区分経理ファイルテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztykaikeitani</td><td>（中継用）会計単位</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysystemkbnnum</td><td>（中継用）システム区分（数値）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoricd</td><td>（中継用）処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytorihikiymd ztytorihikiymd}</td><td>（中継用）取引年月日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytorihikinon7 ztytorihikinon7}</td><td>（中継用）取引番号Ｎ７</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyuuryokubasyo</td><td>（中継用）入力場所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyuuryokusyacd</td><td>（中継用）入力者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoriymdn</td><td>（中継用）処理年月日（数値）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykessankbn</td><td>（中継用）決算区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyonlinesyorikbn</td><td>（中継用）オンライン処理区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv28</td><td>（中継用）予備項目Ｖ２８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanjyoukbnn</td><td>（中継用）勘定区分（数値）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytaisyakukbnn ztytaisyakukbnn}</td><td>（中継用）貸借区分（数値）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykanjyoukamokucdn ztykanjyoukamokucdn}</td><td>（中継用）勘定科目コード（数値）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv4</td><td>（中継用）予備項目Ｖ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysuitoubumoncd ztysuitoubumoncd}</td><td>（中継用）出納部門コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykingaku</td><td>（中継用）金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykizokusegment ztykizokusegment}</td><td>（中継用）帰属セグメント</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyaitesegment ztyaitesegment}</td><td>（中継用）相手セグメント</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv23</td><td>（中継用）予備項目Ｖ２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KubunKeiriFileTy
 * @see     GenZT_KubunKeiriFileTy
 * @see     QZT_KubunKeiriFileTy
 * @see     GenQZT_KubunKeiriFileTy
 */
public class PKZT_KubunKeiriFileTy extends AbstractExDBPrimaryKey<ZT_KubunKeiriFileTy, PKZT_KubunKeiriFileTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_KubunKeiriFileTy() {
    }

    public PKZT_KubunKeiriFileTy(
        String pZtytorihikiymd,
        String pZtytorihikinon7,
        String pZtytaisyakukbnn,
        String pZtykanjyoukamokucdn,
        String pZtysuitoubumoncd,
        String pZtykizokusegment,
        String pZtyaitesegment
    ) {
        ztytorihikiymd = pZtytorihikiymd;
        ztytorihikinon7 = pZtytorihikinon7;
        ztytaisyakukbnn = pZtytaisyakukbnn;
        ztykanjyoukamokucdn = pZtykanjyoukamokucdn;
        ztysuitoubumoncd = pZtysuitoubumoncd;
        ztykizokusegment = pZtykizokusegment;
        ztyaitesegment = pZtyaitesegment;
    }

    @Transient
    @Override
    public Class<ZT_KubunKeiriFileTy> getEntityClass() {
        return ZT_KubunKeiriFileTy.class;
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
    private String ztysuitoubumoncd;

    public String getZtysuitoubumoncd() {
        return ztysuitoubumoncd;
    }

    public void setZtysuitoubumoncd(String pZtysuitoubumoncd) {
        ztysuitoubumoncd = pZtysuitoubumoncd;
    }
    private String ztykizokusegment;

    public String getZtykizokusegment() {
        return ztykizokusegment;
    }

    public void setZtykizokusegment(String pZtykizokusegment) {
        ztykizokusegment = pZtykizokusegment;
    }
    private String ztyaitesegment;

    public String getZtyaitesegment() {
        return ztyaitesegment;
    }

    public void setZtyaitesegment(String pZtyaitesegment) {
        ztyaitesegment = pZtyaitesegment;
    }

}
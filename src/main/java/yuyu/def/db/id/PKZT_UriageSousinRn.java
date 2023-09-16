package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_UriageSousinRn;
import yuyu.def.db.mapping.GenZT_UriageSousinRn;
import yuyu.def.db.meta.GenQZT_UriageSousinRn;
import yuyu.def.db.meta.QZT_UriageSousinRn;

/**
 * 売上送信Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_UriageSousinRn}</td><td colspan="3">売上送信Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrncreditkessaiyouno zrncreditkessaiyouno}</td><td>（連携用）クレジットカード決済用番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnauthorikbn</td><td>（連携用）オーソリ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnuriageseikyuuymd zrnuriageseikyuuymd}</td><td>（連携用）売上請求年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnrsgaku zrnrsgaku}</td><td>（連携用）領収金額</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnfukusuukameitennokey</td><td>（連携用）複数加盟店番号設定キー情報</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnrecordno zrnrecordno}</td><td>（連携用）レコード番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuriagetaisyouym</td><td>（連携用）売上対象年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv33</td><td>（連携用）予備項目Ｖ３３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_UriageSousinRn
 * @see     GenZT_UriageSousinRn
 * @see     QZT_UriageSousinRn
 * @see     GenQZT_UriageSousinRn
 */
public class PKZT_UriageSousinRn extends AbstractExDBPrimaryKey<ZT_UriageSousinRn, PKZT_UriageSousinRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_UriageSousinRn() {
    }

    public PKZT_UriageSousinRn(
        String pZrncreditkessaiyouno,
        String pZrnsyono,
        String pZrnuriageseikyuuymd,
        Long pZrnrsgaku,
        String pZrnrecordno
    ) {
        zrncreditkessaiyouno = pZrncreditkessaiyouno;
        zrnsyono = pZrnsyono;
        zrnuriageseikyuuymd = pZrnuriageseikyuuymd;
        zrnrsgaku = pZrnrsgaku;
        zrnrecordno = pZrnrecordno;
    }

    @Transient
    @Override
    public Class<ZT_UriageSousinRn> getEntityClass() {
        return ZT_UriageSousinRn.class;
    }

    private String zrncreditkessaiyouno;

    public String getZrncreditkessaiyouno() {
        return zrncreditkessaiyouno;
    }

    public void setZrncreditkessaiyouno(String pZrncreditkessaiyouno) {
        zrncreditkessaiyouno = pZrncreditkessaiyouno;
    }
    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }
    private String zrnuriageseikyuuymd;

    public String getZrnuriageseikyuuymd() {
        return zrnuriageseikyuuymd;
    }

    public void setZrnuriageseikyuuymd(String pZrnuriageseikyuuymd) {
        zrnuriageseikyuuymd = pZrnuriageseikyuuymd;
    }
    private Long zrnrsgaku;

    public Long getZrnrsgaku() {
        return zrnrsgaku;
    }

    public void setZrnrsgaku(Long pZrnrsgaku) {
        zrnrsgaku = pZrnrsgaku;
    }
    private String zrnrecordno;

    public String getZrnrecordno() {
        return zrnrecordno;
    }

    public void setZrnrecordno(String pZrnrecordno) {
        zrnrecordno = pZrnrecordno;
    }

}
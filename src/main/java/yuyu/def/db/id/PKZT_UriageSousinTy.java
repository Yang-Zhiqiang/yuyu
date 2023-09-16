package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_UriageSousinTy;
import yuyu.def.db.mapping.GenZT_UriageSousinTy;
import yuyu.def.db.meta.GenQZT_UriageSousinTy;
import yuyu.def.db.meta.QZT_UriageSousinTy;

/**
 * 売上送信Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_UriageSousinTy}</td><td colspan="3">売上送信Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtycreditkessaiyouno ztycreditkessaiyouno}</td><td>（中継用）クレジットカード決済用番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyauthorikbn</td><td>（中継用）オーソリ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyuriageseikyuuymd ztyuriageseikyuuymd}</td><td>（中継用）売上請求年月日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyrsgaku ztyrsgaku}</td><td>（中継用）領収金額</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyfukusuukameitennokey</td><td>（中継用）複数加盟店番号設定キー情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyrecordno ztyrecordno}</td><td>（中継用）レコード番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuriagetaisyouym</td><td>（中継用）売上対象年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv33</td><td>（中継用）予備項目Ｖ３３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_UriageSousinTy
 * @see     GenZT_UriageSousinTy
 * @see     QZT_UriageSousinTy
 * @see     GenQZT_UriageSousinTy
 */
public class PKZT_UriageSousinTy extends AbstractExDBPrimaryKey<ZT_UriageSousinTy, PKZT_UriageSousinTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_UriageSousinTy() {
    }

    public PKZT_UriageSousinTy(
        String pZtycreditkessaiyouno,
        String pZtysyono,
        String pZtyuriageseikyuuymd,
        Long pZtyrsgaku,
        String pZtyrecordno
    ) {
        ztycreditkessaiyouno = pZtycreditkessaiyouno;
        ztysyono = pZtysyono;
        ztyuriageseikyuuymd = pZtyuriageseikyuuymd;
        ztyrsgaku = pZtyrsgaku;
        ztyrecordno = pZtyrecordno;
    }

    @Transient
    @Override
    public Class<ZT_UriageSousinTy> getEntityClass() {
        return ZT_UriageSousinTy.class;
    }

    private String ztycreditkessaiyouno;

    public String getZtycreditkessaiyouno() {
        return ztycreditkessaiyouno;
    }

    public void setZtycreditkessaiyouno(String pZtycreditkessaiyouno) {
        ztycreditkessaiyouno = pZtycreditkessaiyouno;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztyuriageseikyuuymd;

    public String getZtyuriageseikyuuymd() {
        return ztyuriageseikyuuymd;
    }

    public void setZtyuriageseikyuuymd(String pZtyuriageseikyuuymd) {
        ztyuriageseikyuuymd = pZtyuriageseikyuuymd;
    }
    private Long ztyrsgaku;

    public Long getZtyrsgaku() {
        return ztyrsgaku;
    }

    public void setZtyrsgaku(Long pZtyrsgaku) {
        ztyrsgaku = pZtyrsgaku;
    }
    private String ztyrecordno;

    public String getZtyrecordno() {
        return ztyrecordno;
    }

    public void setZtyrecordno(String pZtyrecordno) {
        ztyrecordno = pZtyrecordno;
    }

}
package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TtdkKanAdHenkouTy;
import yuyu.def.db.mapping.GenZT_TtdkKanAdHenkouTy;
import yuyu.def.db.meta.GenQZT_TtdkKanAdHenkouTy;
import yuyu.def.db.meta.QZT_TtdkKanAdHenkouTy;

/**
 * 手続完了（住所変更）Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TtdkKanAdHenkouTy}</td><td colspan="3">手続完了（住所変更）Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztysyoruicd</td><td>（中継用）書類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassoukbn</td><td>（中継用）発送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyodouhuukbn</td><td>（中継用）証券同封区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv24</td><td>（中継用）予備項目Ｖ２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoruicd2</td><td>（中継用）書類コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyouhyouymd2</td><td>（中継用）帳票作成日２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyono2</td><td>（中継用）証券番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassoukbn2</td><td>（中継用）発送区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyodouhuukbn2</td><td>（中継用）証券同封区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysikibetuno ztysikibetuno}</td><td>（中継用）識別番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv44</td><td>（中継用）予備項目Ｖ４４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskyno</td><td>（中継用）送付先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr1kj</td><td>（中継用）送付先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr2kj</td><td>（中継用）送付先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr3kj</td><td>（中継用）送付先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshsnmkjttdk</td><td>（中継用）送付先名（漢字）（手続完了）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv43</td><td>（中継用）予備項目Ｖ４３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawsosikikj</td><td>（中継用）問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawyno</td><td>（中継用）問合せ先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr1kj</td><td>（中継用）問合せ先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr2kj</td><td>（中継用）問合せ先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr3kj</td><td>（中継用）問合せ先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawtelno</td><td>（中継用）問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawteluktkkanou1</td><td>（中継用）問合せ先電話受付可能時間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawteluktkkanou2</td><td>（中継用）問合せ先電話受付可能時間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2tawsosikinmkj</td><td>（中継用）第２問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2tawtelno</td><td>（中継用）第２問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysclatosyono</td><td>（中継用）スクランブル後証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakunm</td><td>（中継用）作成番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv66</td><td>（中継用）予備項目Ｖ６６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyono3</td><td>（中継用）証券番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytetudukisyunm</td><td>（中継用）手続種類名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkj</td><td>（中継用）契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmkj</td><td>（中継用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv59</td><td>（中継用）予備項目Ｖ５９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_TtdkKanAdHenkouTy
 * @see     GenZT_TtdkKanAdHenkouTy
 * @see     QZT_TtdkKanAdHenkouTy
 * @see     GenQZT_TtdkKanAdHenkouTy
 */
public class PKZT_TtdkKanAdHenkouTy extends AbstractExDBPrimaryKey<ZT_TtdkKanAdHenkouTy, PKZT_TtdkKanAdHenkouTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_TtdkKanAdHenkouTy() {
    }

    public PKZT_TtdkKanAdHenkouTy(
        String pZtytyouhyouymd,
        String pZtysyono,
        String pZtysikibetuno
    ) {
        ztytyouhyouymd = pZtytyouhyouymd;
        ztysyono = pZtysyono;
        ztysikibetuno = pZtysikibetuno;
    }

    @Transient
    @Override
    public Class<ZT_TtdkKanAdHenkouTy> getEntityClass() {
        return ZT_TtdkKanAdHenkouTy.class;
    }

    private String ztytyouhyouymd;

    public String getZtytyouhyouymd() {
        return ztytyouhyouymd;
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        ztytyouhyouymd = pZtytyouhyouymd;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztysikibetuno;

    public String getZtysikibetuno() {
        return ztysikibetuno;
    }

    public void setZtysikibetuno(String pZtysikibetuno) {
        ztysikibetuno = pZtysikibetuno;
    }

}
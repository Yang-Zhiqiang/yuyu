package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SeisanDHaneiTuutiTy;
import yuyu.def.db.mapping.GenZT_SeisanDHaneiTuutiTy;
import yuyu.def.db.meta.GenQZT_SeisanDHaneiTuutiTy;
import yuyu.def.db.meta.QZT_SeisanDHaneiTuutiTy;

/**
 * 精算Ｄ反映通知テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SeisanDHaneiTuutiTy}</td><td colspan="3">精算Ｄ反映通知テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztysyoruicd</td><td>（中継用）書類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykeysyono ztykeysyono}</td><td>（中継用）キー証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhaitounendo</td><td>（中継用）配当年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassoukbn</td><td>（中継用）発送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakiyno</td><td>（中継用）宛先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrigikbn</td><td>（中継用）例外区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeiro</td><td>（中継用）払込経路</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysclatosyono</td><td>（中継用）スクランブル後証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakiadr1</td><td>（中継用）宛先住所１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakiadr2</td><td>（中継用）宛先住所２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakiadr3</td><td>（中継用）宛先住所３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatena1</td><td>（中継用）宛名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1syoukaisakifreearea1</td><td>（中継用）第１照会先フリーエリア１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1syoukaisakifreearea2</td><td>（中継用）第１照会先フリーエリア２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1syoukaisakifreearea3</td><td>（中継用）第１照会先フリーエリア３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1syoukaisakifreearea4</td><td>（中継用）第１照会先フリーエリア４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1syoukaisakifreearea5</td><td>（中継用）第１照会先フリーエリア５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakunm</td><td>（中継用）作成番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakuseiymdseireki</td><td>（中継用）作成年月日（西暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyono</td><td>（中継用）証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymdseireki</td><td>（中継用）契約年月日（西暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseisikihknnm</td><td>（中継用）正式保険名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmkj17</td><td>（中継用）被保険者名（漢字）（１７桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta11</td><td>（中継用）フリーエリア（３７桁）１＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta12</td><td>（中継用）フリーエリア（３７桁）１＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta13</td><td>（中継用）フリーエリア（３７桁）１＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta14</td><td>（中継用）フリーエリア（３７桁）１＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta15</td><td>（中継用）フリーエリア（３７桁）１＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta16</td><td>（中継用）フリーエリア（３７桁）１＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta17</td><td>（中継用）フリーエリア（３７桁）１＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta18</td><td>（中継用）フリーエリア（３７桁）１＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta19</td><td>（中継用）フリーエリア（３７桁）１＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta110</td><td>（中継用）フリーエリア（３７桁）１＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta111</td><td>（中継用）フリーエリア（３７桁）１＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta112</td><td>（中継用）フリーエリア（３７桁）１＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta113</td><td>（中継用）フリーエリア（３７桁）１＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta114</td><td>（中継用）フリーエリア（３７桁）１＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta115</td><td>（中継用）フリーエリア（３７桁）１＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta116</td><td>（中継用）フリーエリア（３７桁）１＿１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta117</td><td>（中継用）フリーエリア（３７桁）１＿１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta118</td><td>（中継用）フリーエリア（３７桁）１＿１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta119</td><td>（中継用）フリーエリア（３７桁）１＿１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta120</td><td>（中継用）フリーエリア（３７桁）１＿２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta121</td><td>（中継用）フリーエリア（３７桁）１＿２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta122</td><td>（中継用）フリーエリア（３７桁）１＿２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta123</td><td>（中継用）フリーエリア（３７桁）１＿２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta124</td><td>（中継用）フリーエリア（３７桁）１＿２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea37keta125</td><td>（中継用）フリーエリア（３７桁）１＿２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymidasi11</td><td>（中継用）見出し１＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytouduketorihouhou</td><td>（中継用）当Ｄ受取方法</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymidasi21</td><td>（中継用）見出し２＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykakuteidkgk</td><td>（中継用）確定Ｄ金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymidasi31</td><td>（中継用）見出し３＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaiteidkgk</td><td>（中継用）内定Ｄ金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymidasi41</td><td>（中継用）見出し４＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseisandkgk</td><td>（中継用）精算Ｄ金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea21</td><td>（中継用）フリーエリア２＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea22</td><td>（中継用）フリーエリア２＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea23</td><td>（中継用）フリーエリア２＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea24</td><td>（中継用）フリーエリア２＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea25</td><td>（中継用）フリーエリア２＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv141</td><td>（中継用）予備項目Ｖ１４１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SeisanDHaneiTuutiTy
 * @see     GenZT_SeisanDHaneiTuutiTy
 * @see     QZT_SeisanDHaneiTuutiTy
 * @see     GenQZT_SeisanDHaneiTuutiTy
 */
public class PKZT_SeisanDHaneiTuutiTy extends AbstractExDBPrimaryKey<ZT_SeisanDHaneiTuutiTy, PKZT_SeisanDHaneiTuutiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SeisanDHaneiTuutiTy() {
    }

    public PKZT_SeisanDHaneiTuutiTy(String pZtytyouhyouymd, String pZtykeysyono) {
        ztytyouhyouymd = pZtytyouhyouymd;
        ztykeysyono = pZtykeysyono;
    }

    @Transient
    @Override
    public Class<ZT_SeisanDHaneiTuutiTy> getEntityClass() {
        return ZT_SeisanDHaneiTuutiTy.class;
    }

    private String ztytyouhyouymd;

    public String getZtytyouhyouymd() {
        return ztytyouhyouymd;
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        ztytyouhyouymd = pZtytyouhyouymd;
    }
    private String ztykeysyono;

    public String getZtykeysyono() {
        return ztykeysyono;
    }

    public void setZtykeysyono(String pZtykeysyono) {
        ztykeysyono = pZtykeysyono;
    }

}
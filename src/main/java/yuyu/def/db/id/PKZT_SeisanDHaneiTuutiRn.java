package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SeisanDHaneiTuutiRn;
import yuyu.def.db.mapping.GenZT_SeisanDHaneiTuutiRn;
import yuyu.def.db.meta.GenQZT_SeisanDHaneiTuutiRn;
import yuyu.def.db.meta.QZT_SeisanDHaneiTuutiRn;

/**
 * 精算Ｄ反映通知テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SeisanDHaneiTuutiRn}</td><td colspan="3">精算Ｄ反映通知テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnsyoruicd</td><td>（連携用）書類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkeysyono zrnkeysyono}</td><td>（連携用）キー証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhaitounendo</td><td>（連携用）配当年度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhassoukbn</td><td>（連携用）発送区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatesakiyno</td><td>（連携用）宛先郵便番号</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnrigikbn</td><td>（連携用）例外区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeiro</td><td>（連携用）払込経路</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsclatosyono</td><td>（連携用）スクランブル後証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatesakiadr1</td><td>（連携用）宛先住所１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatesakiadr2</td><td>（連携用）宛先住所２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatesakiadr3</td><td>（連携用）宛先住所３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatena1</td><td>（連携用）宛名１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai1syoukaisakifreearea1</td><td>（連携用）第１照会先フリーエリア１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai1syoukaisakifreearea2</td><td>（連携用）第１照会先フリーエリア２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai1syoukaisakifreearea3</td><td>（連携用）第１照会先フリーエリア３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai1syoukaisakifreearea4</td><td>（連携用）第１照会先フリーエリア４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai1syoukaisakifreearea5</td><td>（連携用）第１照会先フリーエリア５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsakunm</td><td>（連携用）作成番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsakuseiymdseireki</td><td>（連携用）作成年月日（西暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsyono</td><td>（連携用）証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymdseireki</td><td>（連携用）契約年月日（西暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseisikihknnm</td><td>（連携用）正式保険名称</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmkj17</td><td>（連携用）被保険者名（漢字）（１７桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta11</td><td>（連携用）フリーエリア（３７桁）１＿１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta12</td><td>（連携用）フリーエリア（３７桁）１＿２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta13</td><td>（連携用）フリーエリア（３７桁）１＿３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta14</td><td>（連携用）フリーエリア（３７桁）１＿４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta15</td><td>（連携用）フリーエリア（３７桁）１＿５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta16</td><td>（連携用）フリーエリア（３７桁）１＿６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta17</td><td>（連携用）フリーエリア（３７桁）１＿７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta18</td><td>（連携用）フリーエリア（３７桁）１＿８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta19</td><td>（連携用）フリーエリア（３７桁）１＿９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta110</td><td>（連携用）フリーエリア（３７桁）１＿１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta111</td><td>（連携用）フリーエリア（３７桁）１＿１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta112</td><td>（連携用）フリーエリア（３７桁）１＿１２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta113</td><td>（連携用）フリーエリア（３７桁）１＿１３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta114</td><td>（連携用）フリーエリア（３７桁）１＿１４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta115</td><td>（連携用）フリーエリア（３７桁）１＿１５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta116</td><td>（連携用）フリーエリア（３７桁）１＿１６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta117</td><td>（連携用）フリーエリア（３７桁）１＿１７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta118</td><td>（連携用）フリーエリア（３７桁）１＿１８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta119</td><td>（連携用）フリーエリア（３７桁）１＿１９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta120</td><td>（連携用）フリーエリア（３７桁）１＿２０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta121</td><td>（連携用）フリーエリア（３７桁）１＿２１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta122</td><td>（連携用）フリーエリア（３７桁）１＿２２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta123</td><td>（連携用）フリーエリア（３７桁）１＿２３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta124</td><td>（連携用）フリーエリア（３７桁）１＿２４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea37keta125</td><td>（連携用）フリーエリア（３７桁）１＿２５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnmidasi11</td><td>（連携用）見出し１＿１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntouduketorihouhou</td><td>（連携用）当Ｄ受取方法</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnmidasi21</td><td>（連携用）見出し２＿１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkakuteidkgk</td><td>（連携用）確定Ｄ金額</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnmidasi31</td><td>（連携用）見出し３＿１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnnaiteidkgk</td><td>（連携用）内定Ｄ金額</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnmidasi41</td><td>（連携用）見出し４＿１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseisandkgk</td><td>（連携用）精算Ｄ金額</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea21</td><td>（連携用）フリーエリア２＿１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea22</td><td>（連携用）フリーエリア２＿２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea23</td><td>（連携用）フリーエリア２＿３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea24</td><td>（連携用）フリーエリア２＿４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea25</td><td>（連携用）フリーエリア２＿５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv141</td><td>（連携用）予備項目Ｖ１４１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SeisanDHaneiTuutiRn
 * @see     GenZT_SeisanDHaneiTuutiRn
 * @see     QZT_SeisanDHaneiTuutiRn
 * @see     GenQZT_SeisanDHaneiTuutiRn
 */
public class PKZT_SeisanDHaneiTuutiRn extends AbstractExDBPrimaryKey<ZT_SeisanDHaneiTuutiRn, PKZT_SeisanDHaneiTuutiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SeisanDHaneiTuutiRn() {
    }

    public PKZT_SeisanDHaneiTuutiRn(String pZrntyouhyouymd, String pZrnkeysyono) {
        zrntyouhyouymd = pZrntyouhyouymd;
        zrnkeysyono = pZrnkeysyono;
    }

    @Transient
    @Override
    public Class<ZT_SeisanDHaneiTuutiRn> getEntityClass() {
        return ZT_SeisanDHaneiTuutiRn.class;
    }

    private String zrntyouhyouymd;

    public String getZrntyouhyouymd() {
        return zrntyouhyouymd;
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        zrntyouhyouymd = pZrntyouhyouymd;
    }
    private String zrnkeysyono;

    public String getZrnkeysyono() {
        return zrnkeysyono;
    }

    public void setZrnkeysyono(String pZrnkeysyono) {
        zrnkeysyono = pZrnkeysyono;
    }

}
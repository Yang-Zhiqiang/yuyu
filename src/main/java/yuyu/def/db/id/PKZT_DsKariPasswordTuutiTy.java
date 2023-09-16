package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiTy;
import yuyu.def.db.mapping.GenZT_DsKariPasswordTuutiTy;
import yuyu.def.db.meta.GenQZT_DsKariPasswordTuutiTy;
import yuyu.def.db.meta.QZT_DsKariPasswordTuutiTy;

/**
 * 仮パスワード通知テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DsKariPasswordTuutiTy}</td><td colspan="3">仮パスワード通知テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykrpasswordtuutikey ztykrpasswordtuutikey}</td><td>（中継用）仮パスワード通知キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydskokno</td><td>（中継用）ＤＳ顧客番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakiyno</td><td>（中継用）宛先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakiynobarcode</td><td>（中継用）宛先郵便番号バーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakuseimd</td><td>（中継用）作成月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysclakadskokno</td><td>（中継用）スクランブル化ＤＳ顧客番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyreigaisyorihyj</td><td>（中継用）例外処理表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyuubinbutukanpusakiyno</td><td>（中継用）郵便物還付先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyuubinbutukanpusakiadr</td><td>（中継用）郵便物還付先住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakiadr1</td><td>（中継用）宛先住所１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakiadr2</td><td>（中継用）宛先住所２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakiadr3</td><td>（中継用）宛先住所３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatena1</td><td>（中継用）宛名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatena2</td><td>（中継用）宛名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1syoukaisakifreearea1</td><td>（中継用）第１照会先フリーエリア１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1syoukaisakifreearea2</td><td>（中継用）第１照会先フリーエリア２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1syoukaisakifreearea3</td><td>（中継用）第１照会先フリーエリア３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1syoukaisakifreearea4</td><td>（中継用）第１照会先フリーエリア４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1syoukaisakifreearea5</td><td>（中継用）第１照会先フリーエリア５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakuseino</td><td>（中継用）作成No</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyokyakusamanm</td><td>（中継用）お客様氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhkymd</td><td>（中継用）発行日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydskrhnnkakcdyoken</td><td>（中継用）ＤＳ仮本人確認コード与件</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykrpasswordyuukouymd</td><td>（中継用）仮パスワード有効年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea1</td><td>（中継用）フリーエリア１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea2</td><td>（中継用）フリーエリア２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea3</td><td>（中継用）フリーエリア３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea4</td><td>（中継用）フリーエリア４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea5</td><td>（中継用）フリーエリア５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyuuijikou1</td><td>（中継用）注意事項欄１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyuuijikou2</td><td>（中継用）注意事項欄２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyuuijikou3</td><td>（中継用）注意事項欄３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyuuijikou4</td><td>（中継用）注意事項欄４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyuuijikou5</td><td>（中継用）注意事項欄５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyuuijikou6</td><td>（中継用）注意事項欄６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyuuijikou7</td><td>（中継用）注意事項欄７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DsKariPasswordTuutiTy
 * @see     GenZT_DsKariPasswordTuutiTy
 * @see     QZT_DsKariPasswordTuutiTy
 * @see     GenQZT_DsKariPasswordTuutiTy
 */
public class PKZT_DsKariPasswordTuutiTy extends AbstractExDBPrimaryKey<ZT_DsKariPasswordTuutiTy, PKZT_DsKariPasswordTuutiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_DsKariPasswordTuutiTy() {
    }

    public PKZT_DsKariPasswordTuutiTy(String pZtykrpasswordtuutikey) {
        ztykrpasswordtuutikey = pZtykrpasswordtuutikey;
    }

    @Transient
    @Override
    public Class<ZT_DsKariPasswordTuutiTy> getEntityClass() {
        return ZT_DsKariPasswordTuutiTy.class;
    }

    private String ztykrpasswordtuutikey;

    public String getZtykrpasswordtuutikey() {
        return ztykrpasswordtuutikey;
    }

    public void setZtykrpasswordtuutikey(String pZtykrpasswordtuutikey) {
        ztykrpasswordtuutikey = pZtykrpasswordtuutikey;
    }

}